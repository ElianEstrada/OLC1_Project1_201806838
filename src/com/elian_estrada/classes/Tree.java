/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elian_estrada.classes;

import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * @author elian_estrada
 */
public class Tree {

    private NodeTree root;
    private String name;
    private int count;
    private int countStates = 1;
    private ArrayList<String> terminals;
    private ArrayList<State> states;
    private Stack<ArrayList<NodeTree>> valuateState;
    private Hashtable<ArrayList<NodeTree>, String> listStates;
    private Hashtable<Integer, ArrayList<NodeTree>> leaves;
    private Hashtable<String, SymbolTable> symbolTable;

    public Tree() {
        this.setRoot(null);
    }

    public Tree(NodeTree root, String name, ArrayList<String> terminals) {
        this.setRoot(root);
        this.setName(name);
        this.terminals = terminals;
        this.valuateState = new Stack<ArrayList<NodeTree>>();
        this.listStates = new Hashtable<ArrayList<NodeTree>, String>();
        count = 0;
    }

    public String followTable(Hashtable<Integer, ArrayList<NodeTree>> leaves) {

        String symbols = searchNode(1);
        String leaf = 1 + "";
        String follows = (leaves.get(1) + "").replace("[", "").replace("]", "");

        for (int i = 2; i <= leaves.size(); i++) {
            symbols += "|" + searchNode(i);
            leaf += "|" + i;
            follows += "|" + (leaves.get(i).isEmpty() ? "-" : (leaves.get(i) + "").replace("[", "").replace("]", ""));
        }

        String follow = "digraph G{\nbgcolor = \"#1a1a1a\"\nrankdir=TB\nedge[fontcolor = white, color=white]\n"
                + "node [shape = \"record\" style=filled fillcolor = \"#313638\" fontcolor = white color = \"#007acc\"];\n"
                + this.getName() + " [label = \"{ Symbols|" + symbols + "} | { Leaf|" + leaf + "} | {Follow|" + follows + "}\"]\n}";

        System.out.println(follow);
        return follow;
    }

    public String transitionsTable(Hashtable<Integer, ArrayList<NodeTree>> leaves, Hashtable<String, SymbolTable> symbolTable) {

        this.leaves = leaves;
        this.symbolTable = symbolTable;
        this.states = new ArrayList<State>();
        
        AdjacencyList adjacencyList = new AdjacencyList();
        this.listStates.put(this.getRoot().getFirst(), "S0");
        this.valuateState.add(this.getRoot().getFirst());
        
        Vertex aux = new Vertex("S0");
        State state = new State("S0");
        ArrayList<NodeTree> copy = new ArrayList<NodeTree>();
        ArrayList<NodeTree> result = new ArrayList<NodeTree>();
        SymbolTable symbol;
        int index = 0;
        while(!this.valuateState.empty()){
            for (int i = 0; i < this.terminals.size(); i++){
                for(int j = 0; j < this.valuateState.get(0).size(); j++){
                    if(this.valuateState.get(0).get(j).getName().equals(this.terminals.get(i))){
                        if(result.isEmpty()){
                            result = this.leaves.get(this.valuateState.get(0).get(j).getId());
                            state.setTransitionName(this.terminals.get(i));
                        }else{
                            copy = this.leaves.get(this.valuateState.get(0).get(j).getId());
                            for(int k = 0; k < copy.size(); k++){
                                if(!result.contains(copy.get(k).getId())){
                                    result.add(copy.get(k));
                                }
                            }
                        }
                    }
                }
                if(this.listStates.get(result) == null && result.size() != 0){
                    this.listStates.put(result, "S" + this.countStates);
                    state.setDestinationState("S" + this.countStates);
                    symbol = this.symbolTable.get(state.getTransitionName());
                    if(symbol == null){
                        state.setTransitionValue(Pattern.compile(state.getTransitionName()));
                    }else{
                        state.setTransitionValue(symbol.getValues());
                    }
                    if(result.contains(this.getRoot().getRight())){
                        state.setAcceptance(true);
                    }else{
                        state.setAcceptance(false);
                    }
                    this.states.add(state);
                    //state = new State(this.listStates.get(this.valuateState.get(0)));
                    this.valuateState.addElement(result);
                    this.countStates++;
                }else if(result.size() != 0){
                    state.setDestinationState(this.listStates.get(result));
                    symbol = this.symbolTable.get(state.getTransitionName());
                    if(symbol == null){
                        state.setTransitionValue(Pattern.compile(state.getTransitionName()));
                    }else{
                        state.setTransitionValue(symbol.getValues());
                    }
                    if(result.contains(this.getRoot().getRight())){
                        state.setAcceptance(true);
                    }else{
                        state.setAcceptance(false);
                    }
                    this.states.add(state);
                    //state = new State(this.listStates.get(this.valuateState.get(0)));
                }
                state = new State(this.listStates.get(this.valuateState.get(0)));
                result = new ArrayList<NodeTree>();
                copy = new ArrayList<NodeTree>();
            }
            this.valuateState.remove(0);
            if(!this.valuateState.isEmpty()){
                state = new State(this.listStates.get(this.valuateState.get(0)));
            }
        }

        for(State afd: this.states){
            adjacencyList.addVertex(afd);
        }
        adjacencyList.print();
        System.out.println(this.states);
        
        return "";
    }

    public String searchNode(int id) {
        return search(root, id);
    }

    public String search(NodeTree node, int id) {
        if (node == null) {
            return "";
        } else {
            if (isLeaf(node) && node.getId() == id) {
                return node.getName();
            }

            String name;

            name = search(node.getLeft(), id);

            if (name.equals("")) {
                name = search(node.getRight(), id);
            }

            return name;
        }
    }

    public String chart() {

        String graph = "digraph G {\nbgcolor = \"#1a1a1a\"\nrankdir=TB\nedge[fontcolor = white, color=white]\n"
                + "node [shape = \"record\" style=filled fillcolor = \"#313638\" fontcolor = white color = \"#007acc\"];\n"
                + "root [label = \"" + root.toStringFist() + " | { "
                + (root.isVoidable() ? "A" : "N") + " | " + root.getName() + " | id: " + root.getId() + " } | " + root.toStringLast() + " \"]\n";;

        graph += "root->" + preOrder(this.getRoot().getLeft());
        graph += "root->" + preOrder(this.getRoot().getRight()) + "\n}";

        return graph;
    }

    public String preOrder(NodeTree node) {

        String nodeTree = "";
        int idNode = 0;

        if (isLeaf(node)) {
            nodeTree = "\"" + node.getId() + "\"\n\"" + node.getId() + "\" [label = \"" + node.toStringFist() + " | { "
                    + (node.isVoidable() ? "A" : "N") + " | " + ((node.getName().equals("|") || node.getName().equals("\\n")) ? "\\"
                    + node.getName() : node.getName()) + " | id: " + node.getId() + " } | " + node.toStringLast() + " \"]\n";
        } else if (node.getRight() == null) {

            count++;
            idNode = count;
            nodeTree = "\"" + count + node.getId() + node.getName() + "\"\n\""
                    + count + node.getId() + node.getName() + "\" [label = \"" + node.toStringFist() + " | { "
                    + (node.isVoidable() ? "A" : "N") + " | " + ((node.getName().equals("|") || node.getName().equals("\\n")) ? "\\"
                    + node.getName() : node.getName()) + " | id: " + node.getId() + " } | " + node.toStringLast() + " \"]\n";

            nodeTree += "\"" + idNode + node.getId() + node.getName() + "\"->" + preOrder(node.getLeft()) + "\n";

        } else {

            count++;
            idNode = count;
            nodeTree = "\"" + idNode + node.getId() + node.getName() + "\"\n\""
                    + count + node.getId() + node.getName() + "\" [label = \"" + node.toStringFist() + " | { "
                    + (node.isVoidable() ? "A" : "N") + " | " + ((node.getName().equals("|") || node.getName().equals("\\n")) ? "\\"
                    + node.getName() : node.getName()) + " | id: " + node.getId() + " } | " + node.toStringLast() + " \"]\n";

            nodeTree += "\"" + idNode + node.getId() + node.getName() + "\"->" + preOrder(node.getLeft());
            nodeTree += "\"" + idNode + node.getId() + node.getName() + "\"->" + preOrder(node.getRight());
        }

        return nodeTree;
    }

    public boolean isLeaf(NodeTree node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    public NodeTree getRoot() {
        return root;
    }

    public void setRoot(NodeTree root) {
        this.root = root;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

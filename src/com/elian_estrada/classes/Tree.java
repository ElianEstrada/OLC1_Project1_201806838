/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elian_estrada.classes;

import java.util.*;

/**
 *
 * @author elian_estrada
 */
public class Tree {

    private NodeTree root;
    private String name;
    private int count;
    private int countStates = 1;
    private ArrayList<State> state;
    private Hashtable<String, ArrayList<NodeTree>> listStates;
    private Hashtable<Integer, ArrayList<NodeTree>> leaves;
    private Hashtable<String, SymbolTable> symbolTable;

    public Tree() {
        this.setRoot(null);
    }

    public Tree(NodeTree root, String name) {
        this.setRoot(root);
        this.setName(name);
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
        this.state = new ArrayList<State>();

        AdjacencyList adjacencyList = new AdjacencyList();

        this.listStates.put("S0", this.getRoot().getFirst());

        return "";
    }

    public ArrayList<NodeTree> isRepeated(ArrayList<NodeTree> state) {

        ArrayList<NodeTree> result = new ArrayList<NodeTree>();
        ArrayList<NodeTree> copy = new ArrayList<NodeTree>();

        if (state.size() > 1) {
            for (int i = 0; i < state.size() - 1; i++) {
                for (int j = 1; j < state.size(); j++) {
                    if (state.get(i).getName().equals(state.get(j).getName())) {
                        copy = this.leaves.get(state.get(i).getId());
                        copy.removeAll(this.leaves.get(state.get(j).getId()));
                        result.addAll(leaves.get(state.get(j).getId()));
                        result.addAll(copy);
                    }
                }
            }
        }

        return state;
    }

    public boolean existState(ArrayList<NodeTree> state) {
        return true;
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

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

        String follow = "digraph G{\nrankdir=TB\nnode [shape = \"record\"];\n"
                + this.getName() + " [label = \"{ Symbols|" + symbols + "} | { Leaf|" + leaf + "} | {Follow|" + follows + "}\"]\n}";

        System.out.println(follow);
        return follow;
    }

    public String transitionsTable() {

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

        String graph = "digraph G {\nrankdir=TB\nnode [shape = \"record\"];\n"
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

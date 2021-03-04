/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elian_estrada.classes;

/**
 *
 * @author elian_estrada
 */
public class Tree {
    
    private NodeTree root;
    private int count;
    
    public Tree(){
        this.setRoot(null);
    }
    
    public Tree(NodeTree root){
        this.setRoot(root);
        count = 0;
    }
    
    
    
    public String chart(){
        
        
        String graph = "digraph G {\nrankdir=TB\nnode [shape = \"record\"];\n"
                + "root [label = \"" + root.toStringFist() +" | { "
                    + (root.isVoidable()? "A": "N") + " | "+ root.getName() + " | id: " + root.getId() + " } | " + root.toStringLast() + " \"]\n";;
        
        graph += "root->" + preOrder(this.getRoot().getLeft());
        graph += "root->" + preOrder(this.getRoot().getRight());
        
        return graph + "\n}";
    }
    
    public String preOrder(NodeTree node){
        
        String nodeTree = "";
        int idNode = 0;
        
        if (isLeaf(node)){
            nodeTree = "\"" + node.getId() + "\"\n\"" + node.getId() + "\" [label = \"" + node.toStringFist() +" | { "
                    + (node.isVoidable()? "A": "N") + " | "+ ((node.getName().equals("|") || node.getName().equals("\\n"))? "\\" 
                    + node.getName(): node.getName()) + " | id: " + node.getId() + " } | " + node.toStringLast() + " \"]\n";
        }else if (node.getRight() == null){
            
            count++;
            idNode = count;
            nodeTree = "\"" + count + node.getId() + node.getName() + "\"\n\"" 
                    + count + node.getId() + node.getName() + "\" [label = \"" + node.toStringFist() +" | { "
                    + (node.isVoidable()? "A": "N") + " | "+ ((node.getName().equals("|") || node.getName().equals("\\n"))? "\\" 
                    + node.getName(): node.getName()) + " | id: " + node.getId() + " } | " + node.toStringLast() + " \"]\n";
            
            nodeTree += "\"" + idNode + node.getId() + node.getName() + "\"->" + preOrder(node.getLeft()) + "\n";
            
        }else{
            
            count++;
            idNode = count;
            nodeTree = "\"" + idNode + node.getId() + node.getName() + "\"\n\""
                    + count + node.getId() + node.getName() + "\" [label = \"" + node.toStringFist() +" | { "
                    + (node.isVoidable()? "A": "N") + " | "+ ((node.getName().equals("|") || node.getName().equals("\\n"))? "\\" 
                    + node.getName(): node.getName()) + " | id: " + node.getId() + " } | " + node.toStringLast() + " \"]\n";
            
            nodeTree += "\"" + idNode + node.getId() + node.getName() + "\"->" + preOrder(node.getLeft());
            nodeTree += "\"" + idNode + node.getId() + node.getName() + "\"->" + preOrder(node.getRight());
        }
        
        return nodeTree;
    }
    
    public boolean isLeaf(NodeTree node){
        return node.getLeft() == null && node.getRight() == null;
    }

    public NodeTree getRoot() {
        return root;
    }

    public void setRoot(NodeTree root) {
        this.root = root;
    }
    
}

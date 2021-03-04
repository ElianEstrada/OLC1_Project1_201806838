/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elian_estrada.classes;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author elian_estrada
 */
public class NodeTree {
    
    private NodeTree left;
    private NodeTree right;
    private String name;
    private int id;
    private ArrayList<NodeTree> first;
    private ArrayList<NodeTree> last;
    private ArrayList<NodeTree> follows;
    private boolean voidable;
    
    
    public NodeTree(String name, NodeTree left, NodeTree right){
        this.setName(name);
        this.setLeft(left);
        this.setRight(right);
        this.setId(0);
        this.setFirst(new ArrayList<NodeTree>());
        this.setLast(new ArrayList<NodeTree>());
        this.calculations(name);
    }

    public NodeTree(String name, int id, Hashtable<Integer, ArrayList<NodeTree>> leaves){
        this.setName(name);
        this.setId(id);
        this.setVoidable(false);
        this.setLeft(null);
        this.setRight(null);
        this.setFirst(new ArrayList<NodeTree>());
        this.getFirst().add(this);
        this.setLast(new ArrayList<NodeTree>());
        this.getLast().add(this);
        this.setFollows(new ArrayList<NodeTree>());
        leaves.put(id, new ArrayList<NodeTree>());
    }
    
    
    private void calculations(String name){
        switch(name){
            case "*":
                this.setVoidable(true);
                this.setFirst(this.left.getFirst());
                this.setLast(this.left.getLast());
                break;
            case "+":
                if(left.isVoidable()){
                    this.setVoidable(true);
                }else{
                    this.setVoidable(false);
                }
                this.setFirst(this.left.getFirst());
                this.setLast(this.left.getLast());
                break;
            case "?":
                this.setVoidable(true);
                this.setFirst(this.left.getFirst());
                this.setLast(this.left.getLast());
                break;
            case ".":
                if (left.isVoidable() && right.isVoidable()) {
                    this.setVoidable(true);
                    this.getFirst().addAll(this.left.getFirst());
                    this.getFirst().addAll(this.right.getFirst());
                    this.getLast().addAll(this.left.getLast());
                    this.getLast().addAll(this.right.getLast());
                }else{
                    this.setVoidable(false);
                    this.setFirst(left.getFirst());
                    this.setLast(this.right.getLast());
                }
                break;
            case "|":
                if(left.isVoidable() || right.isVoidable()){
                    this.setVoidable(true);
                }else{
                    this.setVoidable(false);
                }
                this.getFirst().addAll(this.left.getFirst());
                this.getFirst().addAll(this.right.getFirst());
                this.getLast().addAll(this.left.getLast());
                this.getLast().addAll(this.right.getLast());
                break;
        }
    }
    
    
    public NodeTree getLeft() {
        return left;
    }

    public void setLeft(NodeTree left) {
        this.left = left;
    }

    public NodeTree getRight() {
        return right;
    }

    public void setRight(NodeTree right) {
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<NodeTree> getFirst() {
        return first;
    }
    
    public String toStringFist(){
        String firstString = first.get(0).getId()+"";
        if (first.size() > 0){
            for (NodeTree fir: first.subList(1, first.size())){
                firstString += "," + fir.getId();
            }
        }
        
        return firstString;
    }

    public void setFirst(ArrayList<NodeTree> first) {
        this.first = first;
    }

    public ArrayList<NodeTree> getLast() {
        return last;
    }

    public String toStringLast(){
        String lastString = last.get(0).getId()+"";
        if (last.size() > 0){
            for (NodeTree las: last.subList(1, last.size())){
                lastString += "," + las.getId();
            }
        }
        
        return lastString;
    }
    
    public void setLast(ArrayList<NodeTree> last) {
        this.last = last;
    }

    public ArrayList<NodeTree> getFollows() {
        return follows;
    }

    public void setFollows(ArrayList<NodeTree> follows) {
        this.follows = follows;
    }

    public boolean isVoidable() {
        return voidable;
    }

    public void setVoidable(boolean voidable) {
        this.voidable = voidable;
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elian_estrada.classes;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author elian_estrada
 */
public class Vertex {
    
    private String name;
    private Pattern values;
    private String edge;
    private ArrayList<Vertex> neighbors;
    private boolean acceptance;
    
    public Vertex(String name){
        
        this.setName(name);
        this.setValues(null);
        this.setEdge("");
        this.setNeighbors(new ArrayList<Vertex>());
        this.setAcceptance(false);
        
    }

    public String getEdge() {
        return edge;
    }

    public void setEdge(String edge) {
        this.edge = edge;
    }
    
    public Vertex(String name, String edge, Pattern values, boolean acceptance){
        this.setName(name);
        this.setEdge(edge);
        this.setValues(values);
        this.setAcceptance(acceptance);
    }
    
    public boolean addNeighbors(String name, String edge, Pattern values, boolean acceptance){
        
        Vertex vertex = new Vertex(name);
        vertex.setValues(values);
        vertex.setEdge(edge);
        vertex.setAcceptance(acceptance);
        this.getNeighbors().add(vertex);
        
        return true;
    }

    public void print(StringBuilder dot){
        Vertex aux = this.neighbors.get(0);
        int count = 1;
        while(aux != null){
            dot.append("edge[label = \"" + aux.getEdge() + " fontseize = 5]\n" + this.getName());
            dot.append("->" + aux.getName() + ";\n");
            
            aux = this.neighbors.get(count);
            count++;
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pattern getValues() {
        return values;
    }

    public void setValues(Pattern values) {
        this.values = values;
    }

    public ArrayList<Vertex> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Vertex> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isAcceptance() {
        return acceptance;
    }

    public void setAcceptance(boolean acceptance) {
        this.acceptance = acceptance;
    }
    
    
    
}

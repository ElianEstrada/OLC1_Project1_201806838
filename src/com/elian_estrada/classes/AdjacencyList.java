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
public class AdjacencyList {
    
    private ArrayList<Vertex> listVertex;
    
    
    public AdjacencyList(){
        this.setListVertex(new ArrayList<Vertex>());
    }
    
    public boolean addVertex(State state){
        Vertex newVertex = new Vertex(state.getCurrentState());
        
        Vertex exist = searchVertex(newVertex.getName());
        
        if(exist != null){
            exist.addNeighbors(state.getDestinationState(), state.getTransitionName(), state.getTransitionValue(), false);
        }else{
            newVertex.addNeighbors(state.getDestinationState(), state.getTransitionName(), state.getTransitionValue(), false);
            listVertex.add(newVertex);
        }
        
        return true;
    }
    
    public Vertex searchVertex(String name){
        Vertex aux = listVertex.get(0);
        int count = 1;
        
        while(aux != null){
            if(aux.getName().equals(name)){
                return aux;
            }
            aux = listVertex.get(count);
            count++;
        }
        
        return null;
    }

    public ArrayList<Vertex> getListVertex() {
        return listVertex;
    }

    public void setListVertex(ArrayList<Vertex> listVertex) {
        this.listVertex = listVertex;
    }
    
    
}

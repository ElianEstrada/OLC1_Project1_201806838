/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elian_estrada.classes;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author elian_estrada
 */
public class AdjacencyList {

    private ArrayList<Vertex> listVertex;

    public AdjacencyList() {
        this.setListVertex(new ArrayList<Vertex>());
    }

    public boolean addVertex(State state) {
        Vertex newVertex = new Vertex(state.getCurrentState());

        Vertex exist = searchVertex(newVertex.getName());

        if (exist != null) {
            exist.addNeighbors(state.getDestinationState(), state.getTransitionName(), state.getTransitionValue(), state.isAcceptance());
        } else {
            newVertex.addNeighbors(state.getDestinationState(), state.getTransitionName(), state.getTransitionValue(), state.isAcceptance());
            listVertex.add(newVertex);
        }

        return true;
    }

    public Vertex searchVertex(String name) {
        if (!this.listVertex.isEmpty()) {
            Vertex aux;
            int count = 0;

            while (count < listVertex.size()) {
                aux = listVertex.get(count);
                if (aux.getName().equals(name)) {
                    return aux;
                }
                count++;
            }
        }

        return null;
    }

    public String print(String name){
        StringBuilder dot = new StringBuilder();
        String path = "";
        dot.append("digraph G {\nbgcolor = \"#1a1a1a\"\nrankdir=LR\nedge[fontcolor = white, color=white]\n"
                + "node [shape = \"circle\" style=filled fillcolor = \"#313638\" fontcolor = white color = \"#007acc\"];\n");
        if(!this.listVertex.isEmpty()){
            Vertex aux;
            int count = 0;
            
            while(count < this.listVertex.size()){
                aux = listVertex.get(count);
                aux.print(dot);
                count++;
            }
        }
        
        dot.append("}");    
        System.out.println(dot);
        
        try{
            File dir = new File(new File(".").getCanonicalPath() + "/AFD_201806838");
            dir.mkdir();
            File file = new File(dir.getAbsolutePath() + "/" + name + ".dot");
            file.createNewFile();
            
            FileWriter write = new FileWriter(file);
            write.write(dot.toString());
            write.close();
            
            path = "AFD_201806838/" + name;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Don't create File.");
        }
        
        return path;
        
    }
    
    public ArrayList<Vertex> getListVertex() {
        return listVertex;
    }

    public void setListVertex(ArrayList<Vertex> listVertex) {
        this.listVertex = listVertex;
    }

}

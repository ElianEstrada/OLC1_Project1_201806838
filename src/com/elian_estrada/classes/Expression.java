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
public class Expression {
    
    private String pathTree;
    private String pathTransitions;
    private String pathFollow;
    private String pathAFD;
    private String pathAFN;
    
    public Expression(String pathTree, String pathTransitions, String pathFollow, String pathAFD, String pathAFN){
        
        this.setPathTree(pathTree);
        this.setPathTransitions(pathTransitions);
        this.setPathFollow(pathFollow);
        this.setPathAFD(pathAFD);
        this.setPathAFN(pathAFN);
        
    }

    public String getPathTree() {
        return pathTree;
    }

    public void setPathTree(String pathTree) {
        this.pathTree = pathTree;
    }

    public String getPathTransitions() {
        return pathTransitions;
    }

    public void setPathTransitions(String pathTransitions) {
        this.pathTransitions = pathTransitions;
    }

    public String getPathFollow() {
        return pathFollow;
    }

    public void setPathFollow(String pathFollow) {
        this.pathFollow = pathFollow;
    }

    public String getPathAFD() {
        return pathAFD;
    }

    public void setPathAFD(String pathAFD) {
        this.pathAFD = pathAFD;
    }

    public String getPathAFN() {
        return pathAFN;
    }

    public void setPathAFN(String pathAFN) {
        this.pathAFN = pathAFN;
    }
    
    
}

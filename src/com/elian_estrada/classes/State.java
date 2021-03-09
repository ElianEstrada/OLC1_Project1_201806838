/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elian_estrada.classes;

import java.util.regex.Pattern;

/**
 *
 * @author elian_estrada
 */
public class State {
    
    private String currentState;
    private String destinationState;
    private String transitionName;
    private Pattern transitionValue;
    
    public State(String currentState, String destinationSatate, String transitionName, Pattern transitionValue){
        this.setCurrentState(currentState);
        this.setDestinationState(destinationState);
        this.setTransitionName(transitionName);
        this.setTransitionValue(transitionValue);
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getDestinationState() {
        return destinationState;
    }

    public void setDestinationState(String destinationState) {
        this.destinationState = destinationState;
    }

    public String getTransitionName() {
        return transitionName;
    }

    public void setTransitionName(String transitionName) {
        this.transitionName = transitionName;
    }

    public Pattern getTransitionValue() {
        return transitionValue;
    }

    public void setTransitionValue(Pattern transitionValue) {
        this.transitionValue = transitionValue;
    }
    
    
    
}

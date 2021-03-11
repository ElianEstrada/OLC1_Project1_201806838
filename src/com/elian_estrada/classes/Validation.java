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
public class Validation {
    
    private String value;
    private String regular;
    private boolean result;
    
    
    public Validation(String value, String regular, boolean result){
        this.setValue(value);
        this.setRegular(regular);
        this.setResult(result);
    }

    public Validation(String value, String regular){
        this.setValue(value);
        this.setRegular(regular);
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        if(this.result){
            return "La expresion \"" + this.value + "\" es valida con la expresion regular: " + this.regular;
        }else{
            return "La expresion \"" + this.value + "\" no es valida con la expresion regular: " + this.regular;
        }
    }
    
    
}

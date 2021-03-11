/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elian_estrada.classes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author elian_estrada
 */
public class SymbolTable {
    
    private String name;
    private Pattern values;
    private String[] charactters;
    private Expression expresion;
    
    public SymbolTable(String name, String values){
        String options = "";
        setName(name);
        if (values.contains("~")){
            String[] range = values.split("~");
            setValues(Pattern.compile("[" + range[0] + "-" + range[1] + "]"));
        }else{
            this.setCharactters(values.split(","));
            for(int i = 0; i < this.getCharactters().length; i++){
                options += this.getCharactters()[i].replace(" ", "");
            }
            
            setValues(Pattern.compile("["+ options + "]"));
        }
    }

    public SymbolTable(String name, Expression expression){
        this.setName(name);
        this.expresion = expression;
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

    public String[] getCharactters() {
        return charactters;
    }

    public void setCharactters(String[] charactters) {
        this.charactters = charactters;
    }

    @Override
    public String toString() {
        return "SymbolTable{" + "name=" + name + ", values=" + values + ", charactters=" + charactters + '}';
    }

    public Expression getExpresion() {
        return expresion;
    }
    
    
}

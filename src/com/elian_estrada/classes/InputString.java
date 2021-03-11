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
public class InputString {

    private String name;
    private String input;
    private Validation validations;
    private Hashtable<String, SymbolTable> symbolTable;

    public InputString(String name, String input, Hashtable<String, SymbolTable> symbolTable) {
        this.setName(name);
        this.setInput(input);
        this.setSymbolTable(symbolTable);
        this.setValidations(new Validation(input, name));
    }

    public Validation validation() {
        SymbolTable symbol = this.symbolTable.get(this.name);
        Expression expression;
        if (symbol != null) {
            expression = symbol.getExpresion();

            if (expression != null) {
                AdjacencyList afd = expression.getAfd();
                
                this.validations.setResult(afd.validation(this.input));
            }
        }

        return this.validations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hashtable<String, SymbolTable> getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(Hashtable<String, SymbolTable> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Validation getValidations() {
        return validations;
    }

    public void setValidations(Validation validations) {
        this.validations = validations;
    }
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elian_estrada.classes;

import java.util.ArrayList;

/**
 *
 * @author elian_estrada
 */
public class SintacticError {
    
    protected int id;
    protected String description;
    protected int line;
    protected int column;
    
    public SintacticError(int id, String description, int line, int column){
        this.setId(id);
        this.setDescription(description);
        this.setLine(line);
        this.setColumn(column);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "SintacticError{" + "id=" + id + ", description=" + description + ", line=" + line + ", column=" + column + '}';
    }
    
}

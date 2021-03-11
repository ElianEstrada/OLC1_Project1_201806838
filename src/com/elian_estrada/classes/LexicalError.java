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
public class LexicalError extends SintacticError{
    
    
    public LexicalError(int id, String description, int line, int column){
        super(id, description, line, column);
    }

    @Override
    public String toString() {
        return "LexicalError{" + "id=" + id + ", description=" + description + ", line=" + line + ", column=" + column + '}';
    }
    
}

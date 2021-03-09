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
    
    
    /*public String drawing (ArrayList<> errorlist){
        
        String tables = "<div class=\"collapsible-body\">\n<table class =\"striped\">\n"
                + "<thead>\n<tr>\n<th> No. </th>\n<th> Description </th>\n<th> Line </th>\n<th> Column </th>\n</thead>\n<tbody>\n";
        for (int i = 0; i < errorlist.size(); i++){
            tables += "<tr>\n<td> " + errorlist.get(i).getId() + " </td>\n"
                    + "<td> " + errorlist.get(i).getDescription() + "</td>\n"
                    + "<td> " + errorlist.get(i).getLine() + "</td>\n"
                    + "<td> " + errorlist.get(i).getColumn() + "</td>\n</tr>\n";
        }
        
        tables += "</tbody>\n</table>\n</div>\n";
        
        return tables;
    }*/
    
}

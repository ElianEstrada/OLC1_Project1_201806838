package com.elian_estrada.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author elian_estrada
 */
public class Menu {

    private boolean flagEdit;
    private String filePath;
    private String absolutePath = "/media/elian_estrada/Documents/Elian/2021/Usac/Primer_Semestre/Compi1/Lab";

    public Menu() {
        this.flagEdit = false;
        this.filePath = "";
    }

    public void newFile() {
        if (flagEdit) {

        } else {
            File file = new File(filePath);

        }
    }

    public String saveFile(String text) {
        if (flagEdit && filePath != "") {
            this.writeFile(text);
        } else if (flagEdit) {
            return this.saveAsFile(text);
        }
        
        return "";
    }

    public String saveAsFile(String text) {

        JFileChooser saveFile = new JFileChooser();
        saveFile.setAcceptAllFileFilterUsed(false);
        saveFile.setFileFilter(new FileNameExtensionFilter("*." + "olc", "olc"));
        saveFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        saveFile.setCurrentDirectory(new File(this.absolutePath));

        int result = saveFile.showSaveDialog(null);

        if (result != JFileChooser.CANCEL_OPTION) {
            File file = saveFile.getSelectedFile();
            if (file.getName().contains(".")) {
                if (new File(file.getAbsoluteFile().toString()).exists()){
                    if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(saveFile, "Thi file is al ready exist, should rempalce?",
                            "Remplace", JOptionPane.YES_NO_OPTION)) {
                        this.filePath = file.getAbsoluteFile().toString();
                    } else {
                        return "";
                    }
                }else{
                    this.filePath = file.getAbsoluteFile().toString();
                }
            } else {
                if (new File(file.getAbsoluteFile() + ".olc").exists()) {
                    if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(saveFile, "Thi file is al ready exist, should rempalce?",
                            "Remplace", JOptionPane.YES_NO_OPTION)) {
                        this.filePath = file.getAbsolutePath() + ".olc";
                    } else {
                        return "";
                    }
                }else{
                    this.filePath = file.getAbsolutePath() + ".olc";
                }
            }

            if (this.writeFile(text)){
                return file.getName();
            }
        }
        
        return "";

    }

    private boolean writeFile(String text) {
        FileWriter file = null;
        PrintWriter write = null;

        try {
            file = new FileWriter(this.filePath);
            file.write(text);
            file.close();
            
            return true;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Escribir en el archivo");
            if (file != null) {
                try {
                    file.close();
                } catch (IOException eIO) {
                    //
                }
            }
        }
        return false;
    }

    public boolean getFlagEdit() {
        return flagEdit;
    }

    public void setFlagEdit(boolean flagEdit) {
        this.flagEdit = flagEdit;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}

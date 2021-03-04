/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import com.elian_estrada.gui.Home;
import com.elian_estrada.classes.SymbolTable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author elian_estrada
 */
public class Project1 {

    private static Home home = new Home();
    private static SymbolTable table = new SymbolTable("letras", "a~c");
    private static SymbolTable table2 = new SymbolTable("digit", "0, 1, 2, 3, 4");
    
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Project1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Project1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Project1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Project1.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setVisible(true);
        home.setLocationRelativeTo(null);
        
        /*
        if(table.getValues().matcher("a").find()){
            System.out.println("Match");
        }else{
            System.out.println("no Match");
        }
        
        if(table2.getValues().matcher("5").find()){
            System.out.println("Match");
        }else{
            System.out.println("No Match");
        }
        */
    }
    
}

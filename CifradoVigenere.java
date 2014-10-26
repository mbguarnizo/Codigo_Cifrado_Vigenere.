/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradovigenere;



/**
 *
 * @author Marlon
 */
import javax.swing.*;
public class CifradoVigenere {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String palabra = JOptionPane.showInputDialog("Ingrese la plabra a decifrar");
        String clave = JOptionPane.showInputDialog("Ingrese la clave");
        CifrarCodigo x;
        x = new CifrarCodigo(palabra,clave); 
        
    }
    
}

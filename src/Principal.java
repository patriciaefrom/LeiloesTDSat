/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Patrícia
 */
public class Principal {
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
           public void run(){
               new cadastroVIEW().setVisible(true);
           } 
        });
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.problematablero.tree;

/**
 *
 * @author Camilo
 */
public class Nodo {
    private Nodo arriba;
    private Nodo abajo;
    private Nodo derecha;
    private Nodo izquierda;
    int[][] tablero = new int[3][3];
    
    public Nodo( int[][] data){
        arriba = null;
        abajo = null;
        derecha = null;
        izquierda = null;
        tablero = data;
    }
   
    
}

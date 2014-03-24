/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.problematablero.tree;

/**
 *
 * @author Camilo
 */
public class Node {
    private Node arriba;
    private Node abajo;
    private Node derecha;
    private Node izquierda;
    int[][] tablero = new int[3][3];
    
    public Node( int[][] data){
        arriba = null;
        abajo = null;
        derecha = null;
        izquierda = null;
        tablero = data;
    }
   
    
}

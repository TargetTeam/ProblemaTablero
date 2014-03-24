/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.problematablero.tree;

import java.util.Arrays;

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
    
    public Node setDerecha(){
        int i = 0,j = 0;
        while(tablero[i][j] != 0){
            i++;
            if(i==3){
                i=0;
                j++;
            }
        }
        if(i==2) return null;
        int[][] ret= Arrays.copyOf(tablero, tablero.length);
        ret[i][j] = ret[i+1][j];
        ret[i+1][j] = 0;
        derecha = new Node(ret);
        return derecha;
    }
    
      public Node setIzquierda(){
        int i = 0,j = 0;
        while(tablero[i][j] != 0){
            i++;
            if(i==3){
                i=0;
                j++;
            }
        }
        if(i==0) return null;
        int[][] ret= Arrays.copyOf(tablero, tablero.length);
        ret[i][j] = ret[i-1][j];
        ret[i-1][j] = 0;
        izquierda = new Node(ret);
        return izquierda;
    }
    
    public Node setArriba(){
        int i = 0,j = 0;
        while(tablero[i][j] != 0){
            i++;
            if(i==3){
                i=0;
                j++;
            }
        }
        if(j==0) return null;
        int[][] ret= Arrays.copyOf(tablero, tablero.length);
        ret[i][j] = ret[i][j-1];
        ret[i][j-1] = 0;
        arriba = new Node(ret);
        return arriba;
    }
    
    public Node setAbajo(){
        int i = 0,j = 0;
        while(tablero[i][j] != 0){
            i++;
            if(i==3){
                i=0;
                j++;
            }
        }
        if(j==2) return null;
        int[][] ret= Arrays.copyOf(tablero, tablero.length);
        ret[i][j] = ret[i][j+1];
        ret[i][j+1] = 0;
        abajo = new Node(ret);
        return abajo;
    }
    
}

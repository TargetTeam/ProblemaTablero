/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.problematablero.tree;

import java.util.Arrays;
import java.util.HashMap;

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
    
    public Node setDerecha(HashMap<Integer, Integer> hash){
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
        Integer code = hash.get(getHashCode(ret));
        if(code != null){
            return null;
        }
        hash.put(code, code);
        derecha = new Node(ret);
        derecha.setIzquierda(this);
        return derecha;
    }
    
      public Node setIzquierda(HashMap<Integer, Integer> hash){
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
        Integer code = hash.get(getHashCode(ret));
        if(code != null){
            return null;
        }
        hash.put(code, code);
        izquierda = new Node(ret);
        izquierda.setDerecha(this);
        return izquierda;
    }
    
    public Node setArriba(HashMap<Integer, Integer> hash){
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
        Integer code = hash.get(getHashCode(ret));
        if(code != null){
            return null;
        }
        hash.put(code, code);
        arriba = new Node(ret);
        arriba.setAbajo(this);
        return arriba;
    }
    
    public Node setAbajo(HashMap<Integer, Integer> hash){
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
        Integer code = hash.get(getHashCode(ret));
        if(code != null){
            return null;
        }
        hash.put(code, code);
        abajo = new Node(ret);
        abajo.setArriba(this);
        return abajo;
    }
    
    public int getHashCode(int[][] data){
        return Integer.parseInt(""+data[0][0] +
                data[0][1]  +
                data[0][2]  +
                data[1][0]  +
                data[1][1]  +
                data[1][2]  +
                data[2][0]  +
                data[2][1]  +
                data[2][2] );
    }

    public Node getArriba() {
        return arriba;
    }

    public Node getAbajo() {
        return abajo;
    }

    public Node getDerecha() {
        return derecha;
    }

    public Node getIzquierda() {
        return izquierda;
    }

    public void setArriba(Node arriba) {
        this.arriba = arriba;
    }

    public void setAbajo(Node abajo) {
        this.abajo = abajo;
    }

    public void setDerecha(Node derecha) {
        this.derecha = derecha;
    }

    public void setIzquierda(Node izquierda) {
        this.izquierda = izquierda;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.problematablero.tree;

import edu.problematablero.helper.Helper;
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
    static  Helper helper = new Helper();
    
    public Node( int[][] data){
        arriba = null;
        abajo = null;
        derecha = null;
        izquierda = null;
        tablero = data;
    }
    
    public Node(Node n){
        this.tablero = n.tablero;
    }
    
    public Node setDerecha(HashMap<Integer, Integer> hash){
        int i = 0,j = 0;
        while(tablero[i][j] != 0){
            j++;
            if(j==3){
                j=0;
                i++;
            }
        }
        if(j==2) return null;
        int[][] ret = new int[3][3];
        for(int k=0;k<3;k++){
            for(int m=0;m<3;m++){
                ret[k][m] = tablero[k][m];
            }
        }
        ret[i][j] = ret[i][j+1];
        ret[i][j+1] = 0;
        Integer code = helper.getHashCode(ret);
        if(hash.get(code) != null){
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
            j++;
            if(j==3){
                j=0;
                i++;
            }
        }
        if(j==0) return null;
        int[][] ret = new int[3][3];
        for(int k=0;k<3;k++){
            for(int m=0;m<3;m++){
                ret[k][m] = tablero[k][m];
            }
        }
        ret[i][j] = ret[i][j-1];
        ret[i][j-1] = 0;
        Integer code = helper.getHashCode(ret);
        if(hash.get(code) != null){
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
            j++;
            if(j==3){
                j=0;
                i++;
            }
        }
        if(i==0) return null;
        int[][] ret = new int[3][3];
        for(int k=0;k<3;k++){
            for(int m=0;m<3;m++){
                ret[k][m] = tablero[k][m];
            }
        }
        ret[i][j] = ret[i-1][j];
        ret[i-1][j] = 0;
        Integer code = helper.getHashCode(ret);
        if(hash.get(code) != null){
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
            j++;
            if(j==3){
                j=0;
                i++;
            }
        }
        if(i==2) return null;
        int[][] ret = new int[3][3];
        for(int k=0;k<3;k++){
            for(int m=0;m<3;m++){
                ret[k][m] = tablero[k][m];
            }
        }
        ret[i][j] = ret[i+1][j];
        ret[i+1][j] = 0;
        Integer code = helper.getHashCode(ret);
        if(hash.get(code) != null){
            return null;
        }
        hash.put(code, code);
        abajo = new Node(ret);
        abajo.setArriba(this);
        return abajo;
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

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
    
    public void print(){
        System.out.println(""+tablero[0][0] +
                tablero[0][1]  +
                tablero[0][2]  +
                tablero[1][0]  +
                tablero[1][1]  +
                tablero[1][2]  +
                tablero[2][0]  +
                tablero[2][1]  +
                tablero[2][2] );
    }
}

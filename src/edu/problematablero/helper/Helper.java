/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.problematablero.helper;

import edu.problematablero.tree.Node;
import java.util.HashMap;

/**
 *
 * @author Camilo
 */
public class Helper {
    
    public static final int TARGET = 123456780;
    
    public void busquedaPorfundidad(Node actual, HashMap<Integer,Integer> hash){
        actual.print();
        if(getHashCode(actual.getTablero())==TARGET){
            System.out.println("Solucionado");
            return;
        }
        Node aux;
        aux = actual.setArriba(hash);
        if(aux != null){
            if(getHashCode(aux.getTablero())==TARGET){
                aux.print();
                System.out.println("Solucionado");
                return;
            }
            busquedaPorfundidad(aux, hash);
        }
        aux = actual.setAbajo(hash);
        if(aux != null){
            if(getHashCode(aux.getTablero())==TARGET){
                aux.print();
                System.out.println("Solucionado");
                return;
            }
            busquedaPorfundidad(aux, hash);
        }
        aux = actual.setDerecha(hash);
        if(aux != null){
            if(getHashCode(aux.getTablero())==TARGET){
                aux.print();
                System.out.println("Solucionado");
                return;
            }
            busquedaPorfundidad(aux, hash);
        }
        aux = actual.setIzquierda(hash);
        if(aux != null){
            if(getHashCode(aux.getTablero())==TARGET){
                aux.print();
                System.out.println("Solucionado");
                return;
            }
            busquedaPorfundidad(aux, hash);
        }
        return;
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
}

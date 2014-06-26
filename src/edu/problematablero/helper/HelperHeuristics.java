/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.problematablero.helper;

import static edu.problematablero.helper.Helper.TARGET;
import edu.problematablero.tree.Node;
import edu.problematablero.tree.Tree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Camilo
 */
public class HelperHeuristics {
    
    public static final int TARGET = 123456780;
    
    public int getHeuristicMisplaced(Node node){
        if(node==null)return 100;
        int cont = 0;
        String tablero  = String.valueOf(getHashCode(node.getTablero()));
        String objetivo = String.valueOf(TARGET);
        for(int i=0; i<tablero.length();i++){
            if(tablero.charAt(i)!=objetivo.charAt(i))
                cont++;
        }
        return cont;
    }
    public int getHeuristicManhatan(Node node){
        int cont = 0,valor = 0,di,dj;
        int [][] aux = node.getTablero();
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                valor = aux[i][j];
                if(valor != 0){
                    di = i - (int)((valor-1)/3)%3; 
                    dj = j - (int)((valor-1)%3);
                    cont += Math.abs(di) + Math.abs(di);
                }
            }
        }
        return cont;
    }
    
    //Busquedas con heuristica Misplace
    public boolean busquedaProfundidadIterativoMisplace(Node actual, HashMap<Integer,Integer> hash){
        boolean ret;
        actual.print();
        if(getHashCode(actual.getTablero())==TARGET){
            System.out.println("Solucionado");
            return true;
        }
        Node auxArriba;
        int hArriba;
        auxArriba = actual.setArriba(hash);
        hArriba = getHeuristicMisplaced(auxArriba);
        
        Node auxAbajo;
        int hAbajo;
        auxAbajo = actual.setAbajo(hash);
        hAbajo = getHeuristicMisplaced(auxAbajo);
        
        Node auxDerecha;
        int hDerecha;
        auxDerecha = actual.setDerecha(hash);
        hDerecha = getHeuristicMisplaced(auxDerecha);
        
        Node auxIzq;
        int hIzq;
        auxIzq = actual.setIzquierda(hash);
        hIzq = getHeuristicMisplaced(auxIzq);
        
        while(hAbajo<100 || hArriba<100 || hDerecha<100 || hIzq<100){
            if(auxArriba != null && hArriba<=hAbajo && hArriba<=hDerecha && hArriba<=hIzq){
                if(getHashCode(auxArriba.getTablero())==TARGET){
                    auxArriba.print();
                    System.out.println("Solucionado");
                    return true;
                }
                hArriba=100;
                ret = busquedaProfundidadIterativoMisplace(auxArriba, hash);
                if(ret)
                    return ret;

            }
            if(auxAbajo != null && hAbajo<=hArriba && hAbajo<=hDerecha && hAbajo<=hIzq){
                if(getHashCode(auxAbajo.getTablero())==TARGET){
                    auxAbajo.print();
                    System.out.println("Solucionado");
                    return true;
                }
                hAbajo = 100;
                ret = busquedaProfundidadIterativoMisplace(auxAbajo, hash);
                if(ret)
                    return ret;
            }
            if(auxDerecha != null && hDerecha<=hArriba && hDerecha<=hAbajo && hDerecha<=hIzq){
                if(getHashCode(auxDerecha.getTablero())==TARGET){
                    auxDerecha.print();
                    System.out.println("Solucionado");
                    return true;
                }
                hDerecha = 100;
                ret = busquedaProfundidadIterativoMisplace(auxDerecha, hash);
                if(ret)
                    return ret;
            }
            if(auxIzq != null && hIzq<=hArriba && hIzq<=hAbajo && hIzq<=hDerecha){
                if(getHashCode(auxIzq.getTablero())==TARGET){
                    auxIzq.print();
                    System.out.println("Solucionado");
                    return true;
                }
                ret = busquedaProfundidadIterativoMisplace(auxIzq, hash);
                if(ret)
                    return ret;
            }
        }
        
        return false;
    }
    
    public void busquedaAnchuraMisplaced(Tree arbol, HashMap<Integer,Integer> hash){
        
        Queue<Node> q = new LinkedList<>();
        q.add(arbol.getNode());
        
        while(!q.isEmpty()){
            Node actual = (Node)q.remove();
                actual.print();
            if(getHashCode(actual.getTablero())==TARGET){
                System.out.println("Solucionado");
                q.clear();
            }else{
                actual.setAbajo(hash);
                actual.setArriba(hash);
                actual.setDerecha(hash);
                actual.setIzquierda(hash);
                int ab = getHeuristicMisplaced(actual.getAbajo());
                int ar = getHeuristicMisplaced(actual.getArriba());
                int de = getHeuristicMisplaced(actual.getDerecha());
                int iz = getHeuristicMisplaced(actual.getIzquierda());
                while(ab<100 || ar<100 || de<100 || iz<100){
                    if(actual.getAbajo() != null && ab<=ar && ab<=de && ab<=iz){
                        q.add(actual.getAbajo());
                        ab=100;
                    }
                    if(actual.getArriba() != null && ar<=ab && ar<=de && ar<=iz){
                        q.add(actual.getArriba());
                        ar=100;
                    }
                    if(actual.getDerecha() != null && de<=ab && de<=ab && de<=iz){
                        q.add(actual.getDerecha());
                        de=100;
                    }
                    if(actual.getIzquierda() != null && iz<=ab && iz<=ab && iz<=de){
                        q.add(actual.getIzquierda());
                        iz=100;
                    }
                }
            }
        }
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

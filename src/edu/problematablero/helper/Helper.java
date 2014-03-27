/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.problematablero.helper;

import edu.problematablero.tree.Node;
import edu.problematablero.tree.Tree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Camilo
 */
public class Helper {
    
    public static final int TARGET = 123456780;
    
    public boolean busquedaProfundidad(Node actual, HashMap<Integer,Integer> hash){
        boolean ret;
        actual.print();
        if(getHashCode(actual.getTablero())==TARGET){
            System.out.println("Solucionado");
            return true;
        }
        Node aux;
        aux = actual.setArriba(hash);
        if(aux != null){
            if(getHashCode(aux.getTablero())==TARGET){
                aux.print();
                System.out.println("Solucionado");
                return true;
            }
            ret = busquedaProfundidad(aux, hash);
            if(ret)
                return ret;
                
        }
        aux = actual.setAbajo(hash);
        if(aux != null){
            if(getHashCode(aux.getTablero())==TARGET){
                aux.print();
                System.out.println("Solucionado");
                return true;
            }
            ret = busquedaProfundidad(aux, hash);
            if(ret)
                return ret;
        }
        aux = actual.setDerecha(hash);
        if(aux != null){
            if(getHashCode(aux.getTablero())==TARGET){
                aux.print();
                System.out.println("Solucionado");
                return true;
            }
            ret = busquedaProfundidad(aux, hash);
            if(ret)
                return ret;
        }
        aux = actual.setIzquierda(hash);
        if(aux != null){
            if(getHashCode(aux.getTablero())==TARGET){
                aux.print();
                System.out.println("Solucionado");
                return true;
            }
            ret = busquedaProfundidad(aux, hash);
            if(ret)
                return ret;
        }
        return false;
    }
    
    public boolean busquedaProfundidadIterativa(Node actual, HashMap<Integer,Integer> hash){
        boolean ret;
        actual.print();
        if(getHashCode(actual.getTablero())==TARGET){
            System.out.println("Solucionado");
            return true;
        }
        Node auxArriba;
        auxArriba = actual.setArriba(hash);
        if(auxArriba != null && getHashCode(auxArriba.getTablero())==TARGET){
            auxArriba.print();
            System.out.println("Solucionado");
            return true;
        }
        Node auxAbajo;
        auxAbajo = actual.setAbajo(hash);
        if(auxAbajo != null && getHashCode(auxAbajo.getTablero())==TARGET){
            auxAbajo.print();
            System.out.println("Solucionado");
            return true;
        }
        Node auxDerecha;
        auxDerecha = actual.setDerecha(hash);
        if(auxDerecha != null && getHashCode(auxDerecha.getTablero())==TARGET){
            auxDerecha.print();
            System.out.println("Solucionado");
            return true;
        }
        Node auxIzquierda;
        auxIzquierda = actual.setIzquierda(hash);
        if(auxIzquierda != null && getHashCode(auxIzquierda.getTablero())==TARGET){
            auxIzquierda.print();
            System.out.println("Solucionado");
            return true;
        }
        if(auxArriba != null){
            ret = busquedaProfundidadIterativa(auxArriba, hash);
            if(ret)
                return ret;
        }
        if(auxAbajo != null){
            ret = busquedaProfundidadIterativa(auxAbajo, hash);
            if(ret)
                return ret;   
        }
        if(auxDerecha != null){
            ret = busquedaProfundidadIterativa(auxDerecha, hash);
            if(ret)
                return ret;
        }
        if(auxIzquierda != null){
            ret = busquedaProfundidadIterativa(auxIzquierda, hash);
            if(ret)
                return ret;
        }
        return false;
    }
    
    public void busquedaAnchura(Tree arbol, HashMap<Integer,Integer> hash){
        
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
                if(actual.getAbajo() != null) q.add(actual.getAbajo());
                actual.setArriba(hash);
                if(actual.getArriba() != null) q.add(actual.getArriba());
                actual.setDerecha(hash);
                if(actual.getDerecha() != null) q.add(actual.getDerecha());
                actual.setIzquierda(hash);
                if(actual.getIzquierda() != null)  q.add(actual.getIzquierda());
            }
        }
    }
    
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
        int cont = 0;
        String tablero  = String.valueOf(getHashCode(node.getTablero()));
        String objetivo = String.valueOf(TARGET);
        for(int i=0; i<tablero.length();i++){
            if(tablero.charAt(i)!=objetivo.charAt(i))
                cont++;
        }
        return cont;
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
}

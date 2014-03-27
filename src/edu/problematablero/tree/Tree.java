/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.problematablero.tree;

import edu.problematablero.helper.Helper;
import java.util.HashMap;

/**
 *
 * @author Camilo
 */
public class Tree {
    private static Helper helper = new Helper();
    private Node node;
    private HashMap<Integer, Integer> hash = new HashMap<>();;
    
    public Tree(){
        node=null;
    }
    
    public void crecerProfundidad(){
        boolean r = helper.busquedaProfundidad(node, hash);
    }
    
    public void crecerProfundidadIterativa(){
        boolean r = helper.busquedaProfundidadIterativa(node, hash);
        System.out.println(r);
    }
    
    public void crecerProfundidadIterativaMisplace(){
        boolean r = helper.busquedaProfundidadIterativoMisplace(node, hash);
        System.out.println(r);
    }
    
    public void crecerAnchura(){
        helper.busquedaAnchura(this, hash);
    }
    
    public boolean empty (){
        return node == null;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
    
}

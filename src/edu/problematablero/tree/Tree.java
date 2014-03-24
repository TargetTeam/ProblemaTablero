/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.problematablero.tree;

import java.util.HashMap;

/**
 *
 * @author Camilo
 */
public class Tree {
    
    private Node node;
    private HashMap<Integer, Integer> hash;
    
    public Tree(){
        node=null;
    }
    
    public void busquedaPorfundidad(){
        
    }
    
    public void busquedaAmplitud(){
        
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

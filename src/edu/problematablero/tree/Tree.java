/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.problematablero.tree;

/**
 *
 * @author Camilo
 */
public class Tree {
    
    private Node node;
    
    public Tree(){
        node=null;
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

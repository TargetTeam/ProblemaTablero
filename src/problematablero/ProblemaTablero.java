/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problematablero;

import edu.problematablero.tree.Node;
import edu.problematablero.tree.Tree;

/**
 *
 * @author Camilo
 */
public class ProblemaTablero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [][] data1 = {{2,4,3}, {7,0,6}, {5,1,8}};
        Node n1 = new Node(data1);
        Tree tree1 = new Tree ();
        tree1.setNode(n1);
        tree1.crecerAnchura();
        /*
        int [][] data2 = {{1,2,3}, {4,5,6}, {7,0,8}};
        Node n2 = new Node(data2);
        Tree tree2 = new Tree();
        tree2.setNode(n2);
        tree2.crecerProfundidadIterativa();*/
    }
}

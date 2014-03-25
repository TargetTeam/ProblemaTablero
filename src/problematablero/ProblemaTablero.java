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
        int [][] data = {{1,2,3}, {4,5,6}, {7,0,8}};
        Node n = new Node(data);
        Tree tree = new Tree ();
        tree.setNode(n);
        tree.crecerProfundidad();
    }
}

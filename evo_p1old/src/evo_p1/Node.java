/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evo_p1;

/**
 *
 * @author fan0114
 */
public class Node {

    public double x;
    public double y;
    public double rank;

    public Node(double x, double y) {
        this.x = x;
        this.y = y;
        this.rank = Math.random();
    }
}

package evo_p1;

/**
 *
 * @author fan0114
 */
public class Node {

    public double x;
    public double y;
    public int no;

    public Node(double x, double y, int no) {
        this.x = x;
        this.y = y;
        this.no = no;
    }

    public Node(Node n) {
        this.x = n.x;
        this.y = n.y;
        this.no = n.no;
    }
}

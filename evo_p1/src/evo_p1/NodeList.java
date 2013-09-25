package evo_p1;

import java.util.ArrayList;

/**
 *
 * @author fan0114
 */
public class NodeList {

    ArrayList<Node> list;
    double totalcost;

    public NodeList(ArrayList<Node> list) {
        this.list = list;
        totalcost = Evo_p1.totalcost(list);
    }

    public Node get(int i) {
        return list.get(i);
    }

    public int size() {
        return list.size();
    }

    public Node get(Node n) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).no == n.no) {
                return list.get(i);
            }
        }
        return null;
    }

    Node getNext(Node n) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).no == n.no) {
                if (i + 1 == list.size()) {
                    return list.get(0);
                } else {
                    return list.get(i + 1);
                }
            }
        }
        return null;
    }
}

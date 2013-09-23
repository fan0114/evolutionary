/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evo_p1;

import java.util.ArrayList;

/**
 *
 * @author fan0114
 */
public class NodeList {
    ArrayList<Node> list;
    double totalcost;
    public NodeList(ArrayList<Node> list){
        this.list=list;
        totalcost=Evo_p1old.totalcost(list);
    }
    public Node get(int i){
        return list.get(i);
    }
    
    public int size(){
        return list.size();
    }
}

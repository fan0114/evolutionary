/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evo_p1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author fan0114
 */
public class Evo_p1hc {

    static int evals;
    static String filename = "TSP3.txt";

    static Comparator<NodeList> cList = new Comparator<NodeList>() {

        @Override
        public int compare(NodeList l1, NodeList l2) {
            double tmp = l1.totalcost - l2.totalcost;
            if (tmp < 0) {
                return -1;
            } else if (tmp == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    };
    ArrayList<NodeList> currentlists;

    public Evo_p1hc() {
        evals = 0;
    }

    static double cost(Node n1, Node n2) {
        return Math.pow((Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2)), 0.5);
    }

    static double totalcost(ArrayList<Node> list) {
        evals++;
        //ascending order
        ArrayList<Node> listcopy = (ArrayList<Node>) list.clone();
        //Collections.sort(listcopy, cNode);
        Node lastnode = null;
        Node firstnode = null;
        double total = 0;
        for (Node node : listcopy) {
            if (firstnode == null) {
                firstnode = node;
            }
            if (lastnode != null) {
                total += cost(node, lastnode);
            }
            lastnode = node;
        }
        total += cost(lastnode, firstnode);
        return total;
    }

    static NodeList offspring(NodeList l1) {
        //crossover
        ArrayList<Node> child = new ArrayList<Node>();

        Random generator = new Random();

        for (int i = 0; i < l1.size(); i++) {
            Node tmp = new Node(l1.get(i));
            child.add(tmp);
        }


        //mutation: swap

        for (int i = 0; i < generator.nextInt(2); i++) {

            int n1 = generator.nextInt(child.size());
            int n2 = generator.nextInt(child.size());
            Node tmp1 = new Node(child.get(n1));
            Node tmp2 = new Node(child.get(n2));
            child.set(n1, tmp2);
            child.set(n2, tmp1);
        }

//        //random change
//        for (int i = 0; i < child.size()/20; i++) {
//            int n1 = generator.nextInt(child.size());
//            child.get(n1).rank+=(Math.random()-0.5)/5;
//        }
//        
        NodeList ret = new NodeList(child);
        return ret;
    }

    static NodeList newlist(ArrayList<Node> list) {
        ArrayList<Node> listcopy = new ArrayList<Node>();
        ArrayList<Node> templist = (ArrayList<Node>) list.clone();
        Random generator = new Random();
        Node node = new Node(templist.get(0));
        listcopy.add(node);
        templist.remove(0);
        int i;
        while (!templist.isEmpty()) {
            i = generator.nextInt(templist.size());
            node = new Node(templist.get(i));
            listcopy.add(node);
            templist.remove(i);
        }
        NodeList ret = new NodeList(listcopy);
        return ret;
    }

    /**
     * @param args the command line arguments
     */
    public void init() throws FileNotFoundException, IOException {
        // TODO code application logic here
        ArrayList<Node> list = new ArrayList<Node>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            String[] nums = line.split(" ");
            Node node = new Node(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]), count);
            //System.out.println("count: " + count);
            list.add(node);
            count++;
        }
        //System.out.println(totalcost(list));
        currentlists = new ArrayList<NodeList>();
        for (int i = 0; i < 1; i++) {
            currentlists.add(newlist(list));
        }
        Collections.sort(currentlists, cList);

    }

    public double[][] run() {
        double[][] result = new double[currentlists.get(0).size()][2];
        double cost;
        cost = currentlists.get(0).totalcost;
        double newcost = cost;
        ArrayList<NodeList> newlists = (ArrayList<NodeList>) currentlists.clone();
        while (newcost >= cost) {
            newlists.set(0, offspring(currentlists.get(0));
            Collections.sort(newlists, cList);
            currentlists = newlists;
            newcost = currentlists.get(0).totalcost;
        }
        System.out.print(newcost);
        ArrayList<Node> sortedlist = (ArrayList<Node>) currentlists.get(0).list.clone();
        //Collections.sort(sortedlist, cNode);
        for (int i = 0; i < sortedlist.size(); i++) {
            result[i][0] = sortedlist.get(i).x;
            result[i][1] = sortedlist.get(i).y;
        }
        System.out.println("|" + evals);
        return result;
    }

    public void run2(PrintWriter out) {
        int oldevals = evals;
        while (evals - oldevals < 1000) {
            run();
        }
        out.print(currentlists.get(0).totalcost);
        out.println("|" + evals);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        for (int i = 0; i < 3; i++) {
            Evo_p1hc instance = new Evo_p1hc();
            instance.init();
            File file = new File("SHC" + "i" + i + ".txt");
            PrintWriter out = new PrintWriter(new FileWriter(file));
            while (evals < 1000000) {
                instance.run2(out);
            }
            out.close();
        }
    }
}

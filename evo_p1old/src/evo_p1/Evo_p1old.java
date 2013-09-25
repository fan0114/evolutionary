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
public class Evo_p1old {

    static int evals;
    static int population = 1000;
    static String filename = "TSP1.txt";
    static Comparator<Node> cNode = new Comparator<Node>() {

        @Override
        public int compare(Node t1, Node t2) {
            double tmp = t1.rank - t2.rank;
            if (tmp < 0) {
                return -1;
            } else if (tmp == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    };
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

    public Evo_p1old() {
        evals = 0;
    }

    static double cost(Node n1, Node n2) {
        return Math.pow((Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2)), 0.5);
    }

    static double totalcost(ArrayList<Node> list) {
        evals++;
        //ascending order
        ArrayList<Node> listcopy = (ArrayList<Node>) list.clone();
        Collections.sort(listcopy, cNode);
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
            Node node = new Node(l1.get(i).x, l1.get(i).y);
            node.rank = l1.get(i).rank;
            child.add(node);
        }

        //mutation: swap

        for (int i = 0; i < generator.nextInt(2); i++) {

            int n1 = generator.nextInt(child.size());
            int n2 = generator.nextInt(child.size());
            double tmp = child.get(n1).rank;
            child.get(n1).rank = child.get(n2).rank;
            child.get(n2).rank = tmp;
        }


        NodeList ret = new NodeList(child);
        return ret;
    }

    static NodeList newlist(ArrayList<Node> list) {
        ArrayList<Node> listcopy = new ArrayList<Node>();
        for (int i = 0; i < list.size(); i++) {
            Node node = new Node(list.get(i).x, list.get(i).y);
            listcopy.add(node);
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
        while ((line = reader.readLine()) != null) {
            String[] nums = line.split(" ");
            Node node = new Node(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
            list.add(node);
        }
        //System.out.println(totalcost(list));
        currentlists = new ArrayList<NodeList>();
        for (int i = 0; i < population; i++) {
            currentlists.add(newlist(list));
        }
        Collections.sort(currentlists, cList);

    }

    public double[][] run() {
        double[][] result = new double[currentlists.get(0).size()][2];
        double cost;
        cost = currentlists.get(0).totalcost;
        double newcost = cost;
        while (newcost >= cost) {
            //random pick
            double grandtotalcost = 0;
            for (int i = 0; i < currentlists.size() / 2; i++) {
                grandtotalcost += 1 / currentlists.get(i).totalcost;
            }
            for (int i = (int) (currentlists.size() / 2); i < currentlists.size(); i++) {
                NodeList p1 = currentlists.get(0);
                double p = Math.random();
                double cumulativeProbability = 0.0;
                for (NodeList item : currentlists) {
                    cumulativeProbability += 1 / item.totalcost / grandtotalcost;
                    if (p <= cumulativeProbability) {
                        p1 = item;
                        break;
                    }
                }
                currentlists.set(i, offspring(p1));
            }
            Collections.sort(currentlists, cList);
            newcost = currentlists.get(0).totalcost;
        }
        System.out.print(newcost);
        ArrayList<Node> sortedlist = (ArrayList<Node>) currentlists.get(0).list.clone();
        Collections.sort(sortedlist, cNode);
        for (int i = 0; i < sortedlist.size(); i++) {
            result[i][0] = sortedlist.get(i).x;
            result[i][1] = sortedlist.get(i).y;
        }
        System.out.println("|" + evals);
        return result;
    }

    public double[][] run2(PrintWriter out) {
        double[][] result = new double[currentlists.get(0).size()][2];
        double cost;
        cost = currentlists.get(0).totalcost;
        double newcost = cost;
        int oldevals = evals;
        while (evals - oldevals < 1000) {
            double grandtotalcost = 0;
            for (int i = 0; i < currentlists.size() / 2; i++) {
                grandtotalcost += 1 / currentlists.get(i).totalcost;
            }
            for (int i = (int) (currentlists.size() / 2); i < currentlists.size(); i++) {
                NodeList p1 = currentlists.get(0);
                double p = Math.random();
                double cumulativeProbability = 0.0;
                for (NodeList item : currentlists) {
                    cumulativeProbability += 1 / item.totalcost / grandtotalcost;
                    if (p <= cumulativeProbability) {
                        p1 = item;
                        break;
                    }
                }
                currentlists.set(i, offspring(p1));
            }
            Collections.sort(currentlists, cList);
            newcost = currentlists.get(0).totalcost;
        }
        out.print(newcost);
        ArrayList<Node> sortedlist = (ArrayList<Node>) currentlists.get(0).list.clone();
        Collections.sort(sortedlist, cNode);
        for (int i = 0; i < sortedlist.size(); i++) {
            result[i][0] = sortedlist.get(i).x;
            result[i][1] = sortedlist.get(i).y;
        }
        out.println("|" + evals);
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        for (int i = 0; i < 10; i++) {
            Evo_p1old instance = new Evo_p1old();
            instance.init();
            File file = new File("BS" + population + "i" + i + ".txt");
            PrintWriter out = new PrintWriter(new FileWriter(file));
            while (evals < 1000000) {
                instance.run2(out);
            }
            out.close();
        }
    }
}

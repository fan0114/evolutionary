/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evo_p1;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author fan0114
 */
public class Test2 {

    public static void main(String args[]) throws FileNotFoundException, IOException, InterruptedException {
        Evo_p1hc instance = new Evo_p1hc();
        instance.init();
        DrawPanel panel=new DrawPanel(instance.run());

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(800, 800);
        application.setVisible(true);
        //while (true) {
//            application.remove(panel);
//            panel = new DrawPanel(instance.run());
            application.add(panel);
            application.repaint();
            System.out.println("here");
            Thread.sleep(1000);
        //}
    }
}

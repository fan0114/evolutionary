/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evo_p1;

/**
 *
 * @author fan0114
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class Surface extends JPanel {

    public double[][] linenums;

    public Surface(double[][] linenums) {
        this.linenums = linenums;
    }

    private void doDrawing(Graphics g) throws FileNotFoundException, IOException {
        int scale = 500;


        Graphics2D g2d = (Graphics2D) g;

        for (int i = 1; i < linenums.length; i++) {
            g2d.drawLine((int) (linenums[i - 1][0] * scale), (int) (linenums[i - 1][1] * scale), (int) (linenums[i][0] * scale), (int) (linenums[i][1] * scale));
        }


        //removeAll();
        //updateUI();
    }

    @Override
    public void paintComponent(Graphics g) {
        try {
            doDrawing(g);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Surface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Surface.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}

public class Lines2 extends JFrame {

    static double[][] linenums;
    static Evo_p1hc instance;
    static JPanel panel;

    public void updateLines() throws FileNotFoundException, IOException {
        linenums = instance.run();
    }

    public Lines2() throws FileNotFoundException, IOException, InterruptedException {

        final JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout(10, 10));


        JButton myButton = new JButton("Add Component ");
        myButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    parentPanel.remove(panel);
                    updateLines();
                    panel = new Surface(linenums);
                    panel.setPreferredSize(new Dimension(800, 600));
                    parentPanel.add(panel, BorderLayout.CENTER);
                    parentPanel.revalidate();
                    parentPanel.repaint();
                    pack();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Lines2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Lines2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        updateLines();
        panel = new Surface(linenums);
        panel.setPreferredSize(new Dimension(800, 600));

        setTitle("Lines");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        setSize(800, 800);
        setLocationRelativeTo(null);
        parentPanel.add(panel, BorderLayout.CENTER);
        parentPanel.add(myButton, BorderLayout.SOUTH);
        add(parentPanel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        instance = new Evo_p1hc();
        instance.init();

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    Lines2 lines;

                    lines = new Lines2();
                    lines.setVisible(true);


//                    int count = 0;
////                    while (count < 0) {
//                    lines.removeAll();
//                    count++;
//                    lines.updateLines();
//                    panel = new Surface(linenums);
//                    lines.add(panel);
//                    lines.invalidate();
//                    lines.validate();
//                    lines.repaint();
////                        Thread.sleep(1000);
////                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Lines2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Lines2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Lines2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}

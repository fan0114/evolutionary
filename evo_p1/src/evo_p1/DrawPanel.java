/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evo_p1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author fan0114
 */
class DrawPanel  extends JPanel {

    public double[][] linenums;

    public DrawPanel(double[][] linenums) {
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
        super.paintComponent(g);
        try {
            doDrawing(g);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Surface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Surface.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}

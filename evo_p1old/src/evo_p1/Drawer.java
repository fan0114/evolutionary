/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evo_p1;

/**
 *
 * @author fan0114
 */
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** @see http://stackoverflow.com/questions/3742731 */
public class Drawer extends JPanel implements MouseMotionListener {

    private static final int SIZE = 16;
    private static final int S2 = SIZE / 2;
    private static final int SCALE = 48;
    private BufferedImage img;
    private Robot robot;

    public Drawer() {
        super(true);
        this.setPreferredSize(new Dimension(SIZE * SCALE, SIZE * SCALE));
        img = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        int x = p.x * SIZE / getWidth();
        int y = p.y * SIZE / getHeight();
        int c = img.getRGB(x, y);
        this.setToolTipText(x + "," + y + ": "
            + String.format("%08X", c));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        Rectangle rect = new Rectangle(x - S2, y - S2, SIZE, SIZE);
        img = robot.createScreenCapture(rect);
        repaint();
    }

    private static void create() {
        JFrame f = new JFrame("Click & drag to zoom.");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Drawer zoom = new Drawer();
        f.add(zoom);
        f.pack();
        f.setVisible(true);
        zoom.addMouseMotionListener(zoom);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                create();
            }
        });
    }
}

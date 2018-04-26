package output;

import input.Keyboard;
import input.Mouse;
import main.GameLoop;
import main.Main;
import world.World;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * @author Klausmp
 */
public class GameFrame extends JFrame {
    public static final int WINDOWSIZEX = 341;
    public static final int WINDOWSIZEY = 256;

    public static BufferedImage black;


    public static JFrame jFrame = new JFrame();

    public static Screen screen;

    public GameFrame() {
        jFrame.setSize(WINDOWSIZEX, WINDOWSIZEY);
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle(Main.gameTitle);
        jFrame.setResizable(false);
        jFrame.setLayout(null);

        screen = new Screen();
        screen.setBounds(0, 0, WINDOWSIZEX, WINDOWSIZEY);
        jFrame.addMouseListener(new Mouse());
        jFrame.addKeyListener(new Keyboard());
        jFrame.add(screen);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    class Screen extends JLabel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            GameFrame.background(g);
            GameFrame.layerSix(g);
            GameFrame.layerFive(g);
            GameFrame.layerFour(g);
            GameFrame.layerThree(g);
            GameFrame.layerTwo(g);
            GameFrame.layerOne(g);
            GameFrame.guiLayer(g);
        }
    }

    public static void guiLayer(Graphics g) {
        g.setPaintMode();
    }

    public static void layerOne(Graphics g) {
        for (World world : World.getWorldList()) {
            world.render(g);
        }
    }

    public static void layerTwo(Graphics g) {

    }

    public static void layerThree(Graphics g) {

    }

    public static void layerFour(Graphics g) {

    }

    public static void layerFive(Graphics g) {

    }

    public static void layerSix(Graphics g) {

    }

    public static void background(Graphics g) {

    }

    public static void repaintScreen() {
        screen.repaint(0, 0, WINDOWSIZEX, WINDOWSIZEY);
    }

}

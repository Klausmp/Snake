package output;

import input.Keyboard;
import input.Mouse;
import main.Main;
import world.World;
import javax.swing.*;
import java.awt.*;

/**
 * @author Klausmp
 */
public class GameFrame extends JFrame {
    public static int windowSizeX = 341;
    public static int windowSizeY = 256;

    public static JFrame gameFrame = new JFrame();

    public static Screen screen;

    public GameFrame() {
        getGameFrame().setSize(windowSizeX, windowSizeY);
        getGameFrame().setLocationRelativeTo(null);
        getGameFrame().setTitle(Main.getGameTitle());
        getGameFrame().setResizable(false);
        getGameFrame().setLayout(null);

        getGameFrame().addMouseListener(new Mouse());
        getGameFrame().addKeyListener(new Keyboard());
        screen = new Screen();
        getScreen().setBounds(0, 0, 1920, 1080);
        getGameFrame().add(screen);

        getGameFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getGameFrame().setVisible(true);

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
        screen.repaint(0, 0, windowSizeX, windowSizeY);
    }

    public static void resizeWindow(int wight, int height){
        wight = (wight + 2) * 16 - 10;
        height = (height + 2) * 16 + 12;
        getScreen().setBounds(0, 0, wight, height);
        getGameFrame().setSize(wight, height);
        setWindowSizeX(wight);
        setWindowSizeY(height);
    }

    public static int getWindowSizeX() {
        return windowSizeX;
    }

    public static void setWindowSizeX(int windowSizeX) {
        GameFrame.windowSizeX = windowSizeX;
    }

    public static int getWindowSizeY() {
        return windowSizeY;
    }

    public static void setWindowSizeY(int windowSizeY) {
        GameFrame.windowSizeY = windowSizeY;
    }

    public static JFrame getGameFrame() {
        return gameFrame;
    }

    public static void setGameFrame(JFrame gameFrame) {
        GameFrame.gameFrame = gameFrame;
    }

    public static Screen getScreen() {
        return screen;
    }

    public static void setScreen(Screen screen) {
        GameFrame.screen = screen;
    }
}

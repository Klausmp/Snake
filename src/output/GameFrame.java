package output;

import input.Keyboard;
import input.Mouse;
import main.Main;
import util.Util;
import world.World;
import world.WorldOne;

import javax.swing.*;
import java.awt.*;

/**
 * @author Klausmp
 */
public class GameFrame extends JFrame {
    public static int windowSizeX = 341;
    public static int windowSizeY = 256;

    public static JFrame gameFrame = new JFrame();

    public static JPanel gamePannel = new JPanel(new BorderLayout());
    public static JPanel mainMenuePanel = new JPanel(new BorderLayout());

    public static JButton newGameButton = new JButton("New Game");

    public static JLabel gameTitel = new JLabel("Snake Main Menü");

    public static Screen screen;


    public GameFrame() {
        screen = new Screen();
        resizeWindow(20,14);
        getGameFrame().setLocationRelativeTo(null);
        getGameFrame().setTitle(Main.getGameTitle());
        getGameFrame().setResizable(false);
        getGameFrame().setLayout(new BorderLayout());

        getGameFrame().addMouseListener(new Mouse());
        getScreen().addKeyListener(new Keyboard());
        getScreen().setBounds(0, 0, 1920, 1080);
        getGamePannel().add(getScreen(), BorderLayout.CENTER);
        getScreen().setVisible(true);

        getGameFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getGameFrame().setVisible(true);
        getGameFrame().add(mainMenuePanel, BorderLayout.CENTER);

        getMainMenuePanel().add(newGameButton, BorderLayout.WEST);
        getGameFrame().add(gameTitel, BorderLayout.NORTH);

        newGameButton.addActionListener(actionEvent -> {
            getGameFrame().add(getScreen(), BorderLayout.CENTER);
            getScreen().setVisible(true);
            getGameTitel().setVisible(false);
            screen.requestFocus();
            getMainMenuePanel().setVisible(false);
            World.worldList.add(new WorldOne(16, 16, 5));
        });

    }

    class Screen extends JLabel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            GameFrame.background(g);
            GameFrame.layerOne(g);
            GameFrame.guiLayer(g);
        }
    }

    private static void background(Graphics g) {
    }

    public static void guiLayer(Graphics g) {
        g.setPaintMode();
    }

    public static void layerOne(Graphics g) {
        for (World world : World.getWorldList()) {
            world.render(g);
        }
    }

    public static void repaintScreen() {
        screen.repaint(0, 0, windowSizeX, windowSizeY);
    }

    public static void resizeWindow(int wight, int height) {
        if (Util.getScreenSize().getWidth() == 1360 && Util.getScreenSize().getHeight() == 768) {
            wight = (wight + 2) * 16 - 10;
            height = (height + 2) * 16 + 12;
        }
        if (Util.getScreenSize().getWidth() == 1920 && Util.getScreenSize().getHeight() == 1080) {
            wight = (wight + 2) * 16;
            height = (height + 2) * 16 + 23;
        }
        if (Util.getScreenSize().getWidth() == 1280 && Util.getScreenSize().getHeight() == 720) {
            wight = (wight + 2) * 16;
            height = (height + 2) * 16 + 23;
        }
        getScreen().setBounds(0, 0, wight, height);
        getGameFrame().setSize(wight, height);
        setWindowSizeX(wight);
        setWindowSizeY(height);
    }

    public static void openMainMenue(){
        resizeWindow(20, 14);
        getScreen().setVisible(false);
        getGameTitel().setVisible(true);
        getMainMenuePanel().setVisible(true);
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

    public static JPanel getGamePannel() {
        return gamePannel;
    }

    public static void setGamePannel(JPanel gamePannel) {
        GameFrame.gamePannel = gamePannel;
    }

    public static JPanel getMainMenuePanel() {
        return mainMenuePanel;
    }

    public static void setMainMenuePanel(JPanel mainMenuePanel) {
        GameFrame.mainMenuePanel = mainMenuePanel;
    }

    public static JButton getNewGameButton() {
        return newGameButton;
    }

    public static void setNewGameButton(JButton newGameButton) {
        GameFrame.newGameButton = newGameButton;
    }

    public static JLabel getGameTitel() {
        return gameTitel;
    }

    public static void setGameTitel(JLabel gameTitel) {
        GameFrame.gameTitel = gameTitel;
    }
}
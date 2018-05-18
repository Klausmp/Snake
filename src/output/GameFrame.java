package output;

import input.Keyboard;
import input.Mouse;
import main.Main;
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
    public static JPanel newGamePanel = new JPanel(new BorderLayout());

    public static JButton newGame = new JButton("New Game");
    public static JButton createNewGame = new JButton("Create New Game");

    public static JLabel gameTitel = new JLabel("Snake Main Menue");

    public static Screen screen;

    public GameFrame() {
        screen = new Screen();
        getGameFrame().setSize(windowSizeX, windowSizeY);
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

        getMainMenuePanel().add(newGame, BorderLayout.WEST);
        getGameFrame().add(gameTitel, BorderLayout.NORTH);

        getNewGamePanel().add(createNewGame, BorderLayout.CENTER);

        newGame.addActionListener(actionEvent -> {
            getGameFrame().add(newGamePanel, BorderLayout.SOUTH);
            getNewGamePanel().setVisible(true);
            getMainMenuePanel().setVisible(false);
        });

        getCreateNewGame().addActionListener(actionEvent ->{
            getGameFrame().add(screen, BorderLayout.CENTER);
            getScreen().setVisible(true);
            getNewGamePanel().setVisible(false);
            getGameFrame().remove(gameTitel);
            getGameTitel().setVisible(false);
            screen.requestFocus();
            World.worldList.add(new WorldOne(8, 8, 1));
        });

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

    public static void resizeWindow(int wight, int height) {
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

    public static JButton getCreateNewGame() {
        return createNewGame;
    }

    public static void setCreateNewGame(JButton createNewGame) {
        GameFrame.createNewGame = createNewGame;
    }

    public static void setNewGamePanel(JPanel newGamePanel) {
        GameFrame.newGamePanel = newGamePanel;
    }

    public static JButton getNewGame() {
        return newGame;
    }

    public static void setNewGame(JButton newGame) {
        GameFrame.newGame = newGame;
    }

    public static JPanel getNewGamePanel() {
        return newGamePanel;
    }

    public static JLabel getGameTitel() {
        return gameTitel;
    }

    public static void setGameTitel(JLabel gameTitel) {
        GameFrame.gameTitel = gameTitel;
    }


}
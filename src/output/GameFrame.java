package output;

import input.Keyboard;
import input.Mouse;
import main.Main;
import util.Util;
import world.World;
import world.WorldOne;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

/**
 * @author Klausmp
 */

public class GameFrame extends JFrame {
    public static int windowSizeX;
    public static int windowSizeY;

    public static JFrame gameFrame = new JFrame();

    public static JPanel gamePannel = new JPanel(new BorderLayout());
    public static JPanel mainMenuePanel = new JPanel(new BorderLayout());
    public static JPanel topBar = new JPanel(new BorderLayout());
    public static JPanel optionPanel = new JPanel(new GridLayout(3, 2));

    public static JButton newGameButton = new JButton("New Game");

    public static JLabel menuTitle = new JLabel("Snake Main Menü");
    public static JLabel highScore = new JLabel("Highscore: 0");
    public static JLabel xSpinnerLabel = new JLabel("Field Width");
    public static JLabel ySpinnerLabel = new JLabel("Field Height");
    public static JLabel speedLabel = new JLabel("Running Speed");

    public static SpinnerModel spinnerModelX = new SpinnerNumberModel(16, 10, 48, 1);
    public static SpinnerModel spinnerModelY = new SpinnerNumberModel(16, 10, 48, 1);
    public static JSpinner xSpinner = new JSpinner(getSpinnerModelX());
    public static JSpinner ySpinner = new JSpinner(getSpinnerModelY());

    public static JSlider speedSlider = new JSlider(1, 3, 2);

    public static Hashtable speedSliderDecription = new Hashtable();

    public static Screen screen;

    public GameFrame() {
        screen = new Screen();
        resizeWindow(20, 14);
        getGameFrame().setLocationRelativeTo(null);
        getGameFrame().setTitle(Main.getGameTitle());
        getGameFrame().setResizable(false);
        getGameFrame().setLayout(new BorderLayout());

        getGameFrame().addMouseListener(new Mouse());
        getScreen().addKeyListener(new Keyboard());
        getScreen().setBounds(0, 0, 1920, 1080);
        getGamePannel().add(getScreen(), BorderLayout.CENTER);
        getScreen().setVisible(true);
        getHighScore().setVisible(true);
        getTopBar().add(getHighScore(), BorderLayout.EAST);

        getGameFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getGameFrame().setVisible(true);
        getGameFrame().add(mainMenuePanel, BorderLayout.CENTER);

        getTopBar().add(getMenuTitle(), BorderLayout.CENTER);
        getMainMenuePanel().add(newGameButton, BorderLayout.WEST);
        getGameFrame().add(getTopBar(), BorderLayout.NORTH);
        getMainMenuePanel().add(optionPanel, BorderLayout.CENTER);
        getSpeedSliderDecription().put(1, new JLabel("Slow"));
        getSpeedSliderDecription().put(2, new JLabel("Mid"));
        getSpeedSliderDecription().put(3, new JLabel("Fast"));
        getSpeedSlider().setLabelTable(getSpeedSliderDecription());
        getSpeedSlider().setPaintLabels(true);
        getOptionPanel().add(getxSpinnerLabel());
        getOptionPanel().add(getxSpinner());
        getOptionPanel().add(getySpinnerLabel());
        getOptionPanel().add(getySpinner());
        getOptionPanel().add(getSpeedLabel());
        getOptionPanel().add(getSpeedSlider());

        newGameButton.addActionListener(actionEvent -> {
            getGameFrame().add(getScreen(), BorderLayout.CENTER);
            getScreen().setVisible(true);
            getTopBar().setVisible(false);
            screen.requestFocus();
            getMainMenuePanel().setVisible(false);
            switch (getSpeedSlider().getValue()) {
                case 1:
                    World.worldList.add(new WorldOne((int) getxSpinner().getValue(), (int) getySpinner().getValue(), 2));
                    break;
                case 2:
                    World.worldList.add(new WorldOne((int) getxSpinner().getValue(), (int) getySpinner().getValue(), 5));
                    break;
                case 3:
                    World.worldList.add(new WorldOne((int) getxSpinner().getValue(), (int) getySpinner().getValue(), 10));
                    break;
                default:
                    World.worldList.add(new WorldOne((int) getxSpinner().getValue(), (int) getySpinner().getValue(), 5));
                    break;
            }

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

    public static void openMainMenue() {
        resizeWindow(20, 14);
        getScreen().setVisible(false);
        getMenuTitle().setVisible(true);
        getMainMenuePanel().setVisible(true);
        getTopBar().setVisible(true);
        getHighScore().setText("Highscore: " + Main.getHighScore());
    }

    public static JLabel getHighScore() {
        return highScore;
    }

    public static void setHighScore(JLabel highScore) {
        GameFrame.highScore = highScore;
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

    public static JLabel getMenuTitle() {
        return menuTitle;
    }

    public static void setMenuTitle(JLabel menuTitle) {
        GameFrame.menuTitle = menuTitle;
    }

    public static JPanel getTopBar() {
        return topBar;
    }

    public static void setTopBar(JPanel topBar) {
        GameFrame.topBar = topBar;
    }

    public static JSpinner getxSpinner() {
        return xSpinner;
    }

    public static void setxSpinner(JSpinner xSpinner) {
        GameFrame.xSpinner = xSpinner;
    }

    public static SpinnerModel getSpinnerModelX() {
        return spinnerModelX;
    }

    public static void setSpinnerModelX(SpinnerModel spinnerModelX) {
        GameFrame.spinnerModelX = spinnerModelX;
    }

    public static JPanel getOptionPanel() {
        return optionPanel;
    }

    public static void setOptionPanel(JPanel optionPanel) {
        GameFrame.optionPanel = optionPanel;
    }

    public static JSpinner getySpinner() {
        return ySpinner;
    }

    public static void setySpinner(JSpinner ySpinner) {
        GameFrame.ySpinner = ySpinner;
    }

    public static SpinnerModel getSpinnerModelY() {
        return spinnerModelY;
    }

    public static void setSpinnerModelY(SpinnerModel spinnerModelY) {
        GameFrame.spinnerModelY = spinnerModelY;
    }

    public static JLabel getxSpinnerLabel() {
        return xSpinnerLabel;
    }

    public static void setxSpinnerLabel(JLabel xSpinnerLabel) {
        GameFrame.xSpinnerLabel = xSpinnerLabel;
    }

    public static JLabel getySpinnerLabel() {
        return ySpinnerLabel;
    }

    public static void setySpinnerLabel(JLabel ySpinnerLabel) {
        GameFrame.ySpinnerLabel = ySpinnerLabel;
    }

    public static JLabel getSpeedLabel() {
        return speedLabel;
    }

    public static void setSpeedLabel(JLabel speedLabel) {
        GameFrame.speedLabel = speedLabel;
    }

    public static JSlider getSpeedSlider() {
        return speedSlider;
    }

    public static void setSpeedSlider(JSlider speedSlider) {
        GameFrame.speedSlider = speedSlider;
    }

    public static Hashtable getSpeedSliderDecription() {
        return speedSliderDecription;
    }

    public static void setSpeedSliderDecription(Hashtable speedSliderDecription) {
        GameFrame.speedSliderDecription = speedSliderDecription;
    }
}
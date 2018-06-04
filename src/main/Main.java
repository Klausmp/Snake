package main;

public class Main {
    public static final String gameTitle = "Snake";
    public static int highScore = 0;
    public static void main(String[] args) {
        new GameLoop().init();
        new GameLoop().run();
    }

    public static String getGameTitle() {
        return gameTitle;
    }

    public static int getHighScore() {
        return highScore;
    }

    public static void setHighScore(int highScore) {
        Main.highScore = highScore;
    }
}

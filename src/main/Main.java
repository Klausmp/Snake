package main;

public class Main {
    public static final String gameTitle = "Snake";
    public static void main(String[] args) {
        new GameLoop().init();
        new GameLoop().run();
    }


    public static String getGameTitle() {
        return gameTitle;
    }
}

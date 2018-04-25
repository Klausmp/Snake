package main;

import world.World;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String gameTitle = "Snake";
    public static List<World> worldList = new ArrayList<World>();
    public static void main(String[] args) {
        new GameLoop().init();
        new GameLoop().run();
    }

    public static String getGameTitle() {
        return gameTitle;
    }

    public static List<World> getWorldList() {
        return worldList;
    }

    public static void setWorldList(List<World> worldList) {
        Main.worldList = worldList;
    }
}

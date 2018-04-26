package world;

import entity.Food;
import entity.Snake;
import entity.Wall;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class World {
    public static List<World> worldList = new ArrayList<World>();
    public static List<Snake> snakeList = new ArrayList<Snake>();
    public static List<Food> foodList = new ArrayList<Food>();
    public static List<Wall> wallList = new ArrayList<Wall>();

    public final int WORLDSPEED;

    public World(int WORLDSPEED) {
        this.WORLDSPEED = WORLDSPEED;
    }

    public void update() {
        for (Snake snake : getSnakeList()) {
            snake.update();
        }
    }

    public void render(Graphics g) {
        for (Snake snake : getSnakeList()) {
            snake.render(g);
        }
    }

    public int getWORLDSPEED() {
        return WORLDSPEED;
    }

    public static List<World> getWorldList() {
        return worldList;
    }

    public static void setWorldList(List<World> worldList) {
        World.worldList = worldList;
    }

    public List<Snake> getSnakeList() {
        return snakeList;
    }

    public void setSnakeList(List<Snake> snakeList) {
        World.snakeList = snakeList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        World.foodList = foodList;
    }

    public List<Wall> getWallList() {
        return wallList;
    }

    public void setWallList(List<Wall> wallList) {
        World.wallList = wallList;
    }
}

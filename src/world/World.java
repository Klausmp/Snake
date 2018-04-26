package world;

import entity.Food;
import entity.Snake;
import entity.Wall;
import util.Util;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class World {
    public static List<World> worldList = new ArrayList<World>();
    public static List<Snake> snakeList = new ArrayList<Snake>();
    public static List<Food> foodList = new ArrayList<Food>();
    public static List<Wall> wallList = new ArrayList<Wall>();

    public static List<World> deadWorldList = new ArrayList<World>();
    public static List<Snake> deadSnakeList = new ArrayList<Snake>();
    public static List<Food> deadFoodList = new ArrayList<Food>();
    public static List<Wall> deadWwallList = new ArrayList<Wall>();

    public final int WORLDSPEED;
    public static int snakeTilesToAdd = 0;

    public World(int WORLDSPEED) {
        this.WORLDSPEED = WORLDSPEED;
    }

    public void update() {
        for (Snake snake : getSnakeList()) {
            snake.update();
        }
        addSnakeTiles();
        clearLists();
    }

    public void render(Graphics g) {
        for (Food food : getFoodList()) {
            food.render(g);
        }
        for (Snake snake : getSnakeList()) {
            snake.render(g);
        }
    }

    public void clearLists(){
        if (!getDeadFoodList().isEmpty()) {
            getFoodList().removeAll(getDeadFoodList());
            getDeadFoodList().clear();
        }
        if (!getDeadSnakeList().isEmpty()) {
            getSnakeList().removeAll(getDeadSnakeList());
            getDeadSnakeList().clear();
        }
    }

    public void addSnakeTiles() {
        if (snakeTilesToAdd > 0) {
            for (World world : getWorldList()) {
                for (int i = 0; i < snakeTilesToAdd; i++) {
                    world.getSnakeList().add(new Snake(-32, -32, Util.getSnakeLenght() + 1));
                }
                setSnakeTilesToAdd(0);
            }
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

    public static List<Snake> getSnakeList() {
        return snakeList;
    }

    public void setSnakeList(List<Snake> snakeList) {
        World.snakeList = snakeList;
    }

    public static List<Food> getFoodList() {
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

    public int getSnakeTilesToAdd() {
        return snakeTilesToAdd;
    }

    public void setSnakeTilesToAdd(int snakeTilesToAdd) {
        World.snakeTilesToAdd = snakeTilesToAdd;
    }

    public static List<World> getDeadWorldList() {
        return deadWorldList;
    }

    public static void setDeadWorldList(List<World> deadWorldList) {
        World.deadWorldList = deadWorldList;
    }

    public static List<Snake> getDeadSnakeList() {
        return deadSnakeList;
    }

    public static void setDeadSnakeList(List<Snake> deadSnakeList) {
        World.deadSnakeList = deadSnakeList;
    }

    public static List<Food> getDeadFoodList() {
        return deadFoodList;
    }

    public static void setDeadFoodList(List<Food> deadFoodList) {
        World.deadFoodList = deadFoodList;
    }

    public static List<Wall> getDeadWwallList() {
        return deadWwallList;
    }

    public static void setDeadWwallList(List<Wall> deadWwallList) {
        World.deadWwallList = deadWwallList;
    }
}

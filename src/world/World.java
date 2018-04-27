package world;

import entity.Food;
import entity.Snake;
import entity.Wall;
import output.GameFrame;
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

    public int worldSizeX;
    public int worldSizeY;

    public final int WORLDSPEED;
    public static int snakeTilesToAdd = 0;

    public World(int worldSizeX, int worldSizeY, int WORLDSPEED) {
        this.WORLDSPEED = WORLDSPEED;
        this.worldSizeX = worldSizeX;
        this.worldSizeY = worldSizeY;
        GameFrame.resizeWindow(this.getWorldSizeX() * 16, this.getWorldSizeY() * 16);
    }

    public void update() {
        for (Snake snake : getSnakeList()) {
            snake.update();
        }
        addSnakeTiles();
        clearLists();
        addNewFood();
    }

    public void render(Graphics g) {
        for (Food food : getFoodList()) {
            food.render(g);
            System.out.println(food.getPosX() +" : " +food.getPosY());
        }
        for (Snake snake : getSnakeList()) {
            snake.render(g);
        }
    }

    public void clearLists() {
        for (World world : getWorldList()) {
            for (Snake snake : world.getSnakeList()) {
                if (!snake.isAlive) {
                    world.getDeadSnakeList().add(snake);
                }
            }
            for (Food food : world.getFoodList()) {
                if (!food.isAlive()) {
                    world.getDeadFoodList().add(food);
                }
            }
        }
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

    public void addNewFood(){
        if (getFoodList().isEmpty()){
            getFoodList().add(new Food((int)(Math.random() * getWorldSizeX()) - 2, (int)(Math.random() * getWorldSizeY()) - 2));
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

    public int getWorldSizeX() {
        return worldSizeX;
    }

    public void setWorldSizeX(int worldSizeX) {
        this.worldSizeX = worldSizeX;
    }

    public int getWorldSizeY() {
        return worldSizeY;
    }

    public void setWorldSizeY(int worldSizeY) {
        this.worldSizeY = worldSizeY;
    }
}

package util;

import entity.Food;
import entity.Snake;
import world.World;

import java.awt.*;

/**
 * @author Klausmp
 */

public class Util {
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static int getSnakeLenght(){
        int lenght = -1;
        for (World world: World.worldList) {
            for (Snake snake: World.getSnakeList()) {
                if (lenght < snake.getPOSITIONINQUEUE()){
                    lenght = snake.getPOSITIONINQUEUE();
                }
            }
        }
        return lenght;
    }

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(Dimension screenSize) {
        Util.screenSize = screenSize;
    }

    public static void clearLists() {
        for (World world : World.getWorldList()) {
            for (Snake snake : World.getSnakeList()) {
                if (!snake.isAlive) {
                    World.getDeadSnakeList().add(snake);
                }
            }
            for (Food food : World.getFoodList()) {
                if (!food.isAlive()) {
                    World.getDeadFoodList().add(food);
                }
            }
        }
        if (!World.getDeadWallList().isEmpty()){
            World.getWallList().removeAll(World.getDeadWallList());
            World.getDeadWallList().clear();
        }
        if (!World.getDeadFoodList().isEmpty()) {
            World.getFoodList().removeAll(World.getDeadFoodList());
            World.getDeadFoodList().clear();
        }
        if (!World.getDeadSnakeList().isEmpty()) {
            World.getSnakeList().removeAll(World.getDeadSnakeList());
            World.getDeadSnakeList().clear();
        }
        if (!World.getDeadWorldList().isEmpty()) {
            World.getWorldList().removeAll(World.getWorldList());
            World.getDeadWorldList().clear();
        }
    }
}

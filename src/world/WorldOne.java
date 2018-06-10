package world;

import entity.Food;
import entity.Player;
import entity.Snake;

/**
 * @author Klausmp
 */

public class WorldOne extends World {

    public WorldOne(int worldSizeX, int worldSizeY, int WORLDSPEED) {
        super(worldSizeX, worldSizeY, WORLDSPEED);
        int rotation;
        if (worldSizeX > worldSizeY) {
            rotation = 2;
        } else {
            rotation = 1;
        }
        snakeList.add(new Player(worldSizeX / 2, worldSizeY / 2, rotation));
        snakeList.add(new Snake(-320, -320, 1));
        snakeList.add(new Snake(-320, -320, 2));
        snakeList.add(new Snake(-320, -320, 3));
        foodList.add(new Food(3, 3));
    }
}

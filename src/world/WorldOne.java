package world;

import entity.Food;
import entity.Player;
import entity.Snake;
import entity.Wall;

public class WorldOne extends World {
    public WorldOne(int worldSizeX, int worldSizeY, int WORLDSPEED) {
        super(worldSizeX, worldSizeY, WORLDSPEED);
        snakeList.add(new Player(5, 5, 3));
        snakeList.add(new Snake(-320, -320, 1));
        snakeList.add(new Snake(-320, -320, 2));
        snakeList.add(new Snake(-320, -320, 3));
        snakeList.add(new Snake(-320, -320, 4));
        snakeList.add(new Snake(-320, -320, 5));
        snakeList.add(new Snake(-320, -320, 6));
        snakeList.add(new Snake(-320, -320, 7));
        snakeList.add(new Snake(-320, -320, 8));
        foodList.add(new Food(1,1));
    }
}

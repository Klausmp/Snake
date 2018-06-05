package world;

import entity.Food;
import entity.Player;
import entity.Snake;

public class WorldOne extends World {
    public WorldOne(int worldSizeX, int worldSizeY, int WORLDSPEED) {
        super(worldSizeX, worldSizeY, WORLDSPEED);
        snakeList.add(new Player(5, 5, 3));
        //foodList.add(new Food(3,3));
    }
}

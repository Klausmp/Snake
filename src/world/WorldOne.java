package world;

import entity.Food;
import entity.Player;
import entity.Snake;

public class WorldOne extends World {
    public WorldOne(int WORLDSPEED) {
        super(WORLDSPEED);
        snakeList.add(new Player(5, 5, 0));
        foodList.add(new Food(1,1));
    }
}

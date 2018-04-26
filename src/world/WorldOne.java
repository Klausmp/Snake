package world;

import entity.Food;
import entity.Player;
import entity.Snake;

public class WorldOne extends World {
    public WorldOne(int WORLDSPEED) {
        super(WORLDSPEED);
        snakeList.add(new Player(5, 5, 0));
        snakeList.add(new Snake(-32, -32, 1));
        snakeList.add(new Snake(-32, -32, 2));
        snakeList.add(new Snake(-32, -32, 3));
        snakeList.add(new Snake(-32, -32, 4));
        snakeList.add(new Snake(-32, -32, 5));
        snakeList.add(new Snake(-32, -32, 6));
        snakeList.add(new Snake(-32, -32, 7));
        snakeList.add(new Snake(-32, -32, 8));
        foodList.add(new Food(1,1));
    }
}

package world;

import entity.Player;
import entity.Snake;

public class WorldOne extends World {
    public WorldOne(int WORLDSPEED) {
        super(WORLDSPEED);
        snakeList.add(new Player(5, 5, 0));
        snakeList.add(new Snake(-20, -20, 1));
        snakeList.add(new Snake(-20, -20, 2));
        snakeList.add(new Snake(-20, -20, 3));
    }
}

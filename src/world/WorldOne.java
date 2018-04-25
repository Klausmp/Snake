package world;

import entity.Player;

public class WorldOne extends World {
    public WorldOne() {
        snakeList.add(new Player(5, 5, 0));
    }
}

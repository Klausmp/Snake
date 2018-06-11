package world;

import entity.Player;

/**
 * @author Klausmp
 */

public class WorldOne extends World {

    public WorldOne(int worldSizeX, int worldSizeY, int WORLDSPEED) {
        super(worldSizeX, worldSizeY, WORLDSPEED);
        snakeList.add(new Player(worldSizeX / 2, worldSizeY / 2, 0));
    }
}

package util;

import entity.Snake;
import world.World;

public class Util {

    public static int getSnakeLenght(){
        int lenght = -1;
        for (World world: World.worldList) {
            for (Snake snake: world.getSnakeList()) {
                if (lenght < snake.getPOSITIONINQUEUE()){
                    lenght = snake.getPOSITIONINQUEUE();
                }
            }
        }
        return lenght;
    }
}

package util;

import entity.Snake;
import world.World;

import java.awt.*;


public class Util {
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
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

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(Dimension screenSize) {
        Util.screenSize = screenSize;
    }
}

package output;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Klausmp
 */

public class Renderer {

    public static BufferedImage food;
    public static BufferedImage snake;
    public static BufferedImage wall;


    public Renderer() {
        try {
            //Entity Texture
            food = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/food.png"));
            snake = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/snake.png"));
            wall = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/wall.png"));
            //Block Texture

            //Item Texture

            //Background and other

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int makeToRenderPos(int pos){
        return pos * 16;
    }
}

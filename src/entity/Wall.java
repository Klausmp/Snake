package entity;

import output.Renderer;

/**
 * @author Klausmp
 */

public class Wall extends Entity {
    public Wall(int posX, int posY) {
        super(posX, posY);
        setLook(Renderer.wall);
        creatBounds();
        setBounds();
    }

    @Override
    public void update() {

    }
}

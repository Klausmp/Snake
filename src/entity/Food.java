package entity;

import output.Renderer;

public class Food extends Entity {

    public Food(int posX, int posY) {
        super(posX, posY);
        look = Renderer.food;
        creatBounds();
    }

    @Override
    public void update() {
    }
}

package entity;

import main.GameLoop;
import output.Renderer;

public class Snake extends Entity {
    public int lastPosX;
    public int lastPosY;
    public final int POSITIONINQUEUE;

    public Snake(int posX, int posY, int POSITIONINQUEUE) {
        this.posX = posX;
        this.posY = posY;
        look = Renderer.snake;
        this.POSITIONINQUEUE = POSITIONINQUEUE;
        creatBounds();
    }

    public boolean canMove(double speed) {
        double a = GameLoop.getTPS() / speed;
        for (int i = 0; i <= speed; i++) {
            if (GameLoop.getCurrentTick() == i*a) return true;
        }
        return false;
}

    public void movement() {
        setLastPosX(posX);
        setLastPosY(posY);

    }

    @Override
    public void update() {
        movement();

    }

    public int getLastPosX() {
        return lastPosX;
    }

    public void setLastPosX(int lastPosX) {
        this.lastPosX = lastPosX;
    }

    public int getLastPosY() {
        return lastPosY;
    }

    public void setLastPosY(int lastPosY) {
        this.lastPosY = lastPosY;
    }

    public int getPOSITIONINQUEUE() {
        return POSITIONINQUEUE;
    }
}

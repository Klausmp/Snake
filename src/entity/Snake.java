package entity;

import main.GameLoop;
import output.Renderer;
import world.World;

public class Snake extends Entity {
    public int lastPosX;
    public int lastPosY;
    public final int POSITIONINQUEUE;

    public Snake(int posX, int posY, int POSITIONINQUEUE) {
        super(posX, posY);
        look = Renderer.snake;
        this.POSITIONINQUEUE = POSITIONINQUEUE;
        creatBounds();
    }

    public boolean canMove(double speed) {
        double a = GameLoop.getTPS() / speed;
        for (int i = 0; i <= speed; i++) {
            if (GameLoop.getCurrentTick() == i * a) return true;
        }
        return false;
    }

    public void movement() {
        setLastPosX(posX);
        setLastPosY(posY);
        for (World world : World.getWorldList()) {
            if (canMove(world.WORLDSPEED)) {
                for (Snake snake : World.getSnakeList()) {
                    if (snake.getPOSITIONINQUEUE() == POSITIONINQUEUE - 1) {
                        setPosX(snake.getLastPosX());
                        setPosY(snake.getLastPosY());
                    }
                }
            }
        }
    }

    @Override
    public void update() {
        movement();
        setBounds();
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

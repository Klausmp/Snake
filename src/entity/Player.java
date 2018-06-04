package entity;

import input.Keyboard;
import world.World;

import java.awt.event.KeyEvent;

public class Player extends Snake {
    public int rotation;

    public Player(int posX, int posY, int rotation) {
        super(posX, posY, 0);
        this.rotation = rotation;
    }

    public void keyboardInput() {
        if (Keyboard.isKeyDown(KeyEvent.VK_W)) {
            rotation = 1;
        }
        if (Keyboard.isKeyDown(KeyEvent.VK_A)) {
            rotation = 2;
        }
        if (Keyboard.isKeyDown(KeyEvent.VK_S)) {
            rotation = 3;
        }
        if (Keyboard.isKeyDown(KeyEvent.VK_D)) {
            rotation = 4;
        }
    }


    public void movement() {
        keyboardInput();
        for (World world : World.getWorldList()) {
            if (canMove(world.getWORLDSPEED())) {
                setLastPosX(posX);
                setLastPosY(posY);
                switch (rotation) {
                    case 1:
                        posY--;
                        break;
                    case 2:
                        posX--;
                        break;
                    case 3:
                        posY++;
                        break;
                    case 4:
                        posX++;
                        break;
                }
            }
        }
    }

    public void eat() {
        for (World world : World.getWorldList()) {
            if (canMove(world.getWORLDSPEED()))
                for (Food food : world.getFoodList()) {
                    if (getBounding().intersects(food.bounding) && food.isAlive()) {
                        food.setAlive(false);
                        world.setSnakeTilesToAdd(world.getSnakeTilesToAdd() + 1);
                    }
                }
        }
    }

    public void tailHit() {
        for (World world : World.getWorldList()) {
            for (Snake snake : world.getSnakeList()) {
                if (snake.getBounding().intersects(getBounding()) && snake.getPOSITIONINQUEUE() != 0 && canMove(world.WORLDSPEED)) {
                    setAlive(false);
                    World.delit();
                }
            }
        }
    }

    public void hitWall() {
        for (World world : World.worldList) {
            for (Wall wall : world.getWallList()) {
                if (wall.getBounding().intersects(getBounding()) && canMove(world.WORLDSPEED)) {
                    setAlive(false);
                    World.delit();
                }
            }
        }
    }

    @Override
    public void update() {
        movement();
        setBounds();
        eat();
        tailHit();
        hitWall();
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
}

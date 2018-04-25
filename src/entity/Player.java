package entity;

import input.Keyboard;
import main.GameLoop;

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
        if (canMove(12)) {
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

    @Override
    public void update() {
        movement();
        setBounds();
    }
}

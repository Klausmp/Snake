package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Marc on 27.02.2016.
 */
public class Keyboard implements KeyListener {
    private static boolean[] keys = new boolean[512];


    public static boolean isKeyDown(int keyCode) {
        return keyCode >= 0 && keyCode < keys.length && keys[keyCode];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode < keys.length) keys[keyCode] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode < keys.length) keys[keyCode] = false;
    }

    public static boolean[] getKeys() {
        return keys;
    }

    public static void setKeys(boolean[] keys) {
        Keyboard.keys = keys;
    }
}
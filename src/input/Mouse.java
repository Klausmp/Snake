package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Klausmp
 */

public class Mouse implements MouseListener {
    public static int[] mousePos = new int[]{0, 0};


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePos[0] = e.getX();
        mousePos[1] = e.getY();
        //System.out.println(GameFrame.mousePos[0] + " " + GameFrame.mousePos[1]);

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void resetMousPos() {
        mousePos = null;
    }

    public static int[] getMousePos() {
        return mousePos;
    }

    public static void setMousePos(int[] mousePos) {
        mousePos = mousePos;
    }


}


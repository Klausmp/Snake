package entity;

import output.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    public int posX;
    public int posY;
    public int wight;
    public int height;
    public BufferedImage look;
    public Rectangle bounding;

    public abstract void update();

    public void render(Graphics g){
        g.drawImage(getLook(), Renderer.makeToRenderPos(getPosX()), Renderer.makeToRenderPos(getPosY()), getWight(), getHeight(), null);
    }

    public void setBounds(){
        bounding.setBounds(getPosX(), getPosY(), getWight(), getHeight());
    }

    public void creatBounds(){
        setWight(look.getWidth());
        setHeight(look.getHeight());
        bounding = new Rectangle(getPosX(), getPosY(), getWight(), getHeight());
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getLook() {
        return look;
    }

    public void setLook(BufferedImage look) {
        this.look = look;
    }

    public Rectangle getBounding() {
        return bounding;
    }

    public void setBounding(Rectangle bounding) {
        this.bounding = bounding;
    }
}

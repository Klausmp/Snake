package world;

import entity.Entity;
import entity.Snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class World {

    public List<Snake> snakeList= new ArrayList<Snake>();


    public World() {
    }

    public static void update(){

    }

    public static void render(Graphics g){

    }
}

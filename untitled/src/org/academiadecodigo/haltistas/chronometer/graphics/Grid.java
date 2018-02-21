package org.academiadecodigo.haltistas.chronometer.graphics;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Grid {


    public final static int PADDLE = 9;
    public final static int WIDTH = 1381;
    public final static int HEIGHT = 741;
    public final static int WIDTH_CENTER = WIDTH / 2;
    public final static int HEIGHT_CENTER = HEIGHT / 2;


    private Rectangle grid;


    public Grid() {

        grid = new Rectangle(PADDLE, PADDLE, WIDTH, HEIGHT);

    }

    public void drawGrid() {
        grid.draw();
    }

    public void deleteGird(){
        grid.delete();
    }

}

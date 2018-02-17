package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Background {

    public final static int PADDLE = 9;
    public final static int WIDTH = 1381;
    public final static int HEIGHT = 741;
    public final static int WIDTH_CENTER = WIDTH/2;
    public final static int HEIGHT_CENTER = HEIGHT/2;

    private Picture background;
    private Picture chronometerDraw;
    private Rectangle rectangle;
    private Text chronometerText;
    private Ellipse circle;


    public Background() throws InterruptedException {

        //Thread.sleep(1000);
        rectangle = new Rectangle(PADDLE, PADDLE, WIDTH, HEIGHT);
        rectangle.draw();

        background = new Picture(-100, -70, "assets/saloon.jpg");
        background.grow(-110, -80);



    }

    public void deleteChronometer(){

        chronometerDraw.delete();

    }

    public void drawChronometer(String source){

        chronometerDraw = new Picture(WIDTH_CENTER-110, HEIGHT_CENTER, source);
        chronometerDraw.draw();


    }

    public void drawBackground(){

        background.draw();

    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getPaddle() {
        return PADDLE;
    }


}

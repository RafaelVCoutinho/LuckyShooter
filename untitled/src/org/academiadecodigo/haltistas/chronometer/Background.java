package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Background {

    private Picture background;
    private Rectangle rectangle;


    public Background() throws InterruptedException {

        Thread.sleep(1000);
        rectangle = new Rectangle(9, 9, 1381, 741);
        rectangle.draw();

        background = new Picture(-100, -70, "assets/saloon.jpg");
        background.grow(-110, -80);


    }

    public void draw(){

        background.draw();


    }



}

package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Background {

    private Picture background;
    private Rectangle rectangle;
    private Picture playerOne;
    private Picture playerTwo;
    private Picture counter;


    public Background() throws InterruptedException {

        Thread.sleep(1000);
        rectangle = new Rectangle(9, 9, 1381, 741);
        rectangle.draw();

        background = new Picture(-100, -70, "assets/saloon.jpg");
        background.grow(-110, -80);
        Thread.sleep(1000);

        drawPlayer1();
        drawPlayer2();
    }

    public void draw(){

        background.draw();
        //playerOne.draw();
        //playerTwo.draw();




    }

    public void drawPlayer1(){
        playerOne = new Picture(350, 550,"assets/player1Alive.png");
        playerOne.draw();

    }
public void drawPlayer2(){
    playerTwo = new Picture(1000, 550, "assets/player2Alive.png");
    playerTwo.draw();
}
public void drawcounterPlayer1(){
    counter = new Picture(150, 150, "assets/picture3.png");
    counter.draw();
}
    public void drawcounterPlayer2(){
        counter = new Picture(900, 150, "assets/picture3.png");
        counter.draw();
    }

}

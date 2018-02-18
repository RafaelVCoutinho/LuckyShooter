package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Background {


    //this is th 1

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

    public void draw() {

        background.draw();

    }

    public void drawPlayer1() {
        playerOne = new Picture(350, 550, "assets/player1Alive.png");
        playerOne.draw();

    }

    public void drawPlayer2() {
        playerTwo = new Picture(1000, 550, "assets/player2Alive.png");
        playerTwo.draw();
    }

    public void drawCounterPlayer1(int stars) {
        Picture counter = new Picture(350, 150, "assets/picture3.png");

        Picture counter2 = new Picture(380, 150, "assets/picture3.png");

        Picture counter3 = new Picture(410, 150, "assets/picture3.png");

        Picture counter4 = new Picture(440, 150, "assets/picture3.png");

        Picture counter5 = new Picture(470, 150, "assets/picture3.png");

        switch (stars) {
            case 1:
                counter.draw();
                break;
            case 2:
                counter.draw();
                counter2.draw();
                break;
            case 3:
                counter.draw();
                counter2.draw();
                counter3.draw();
                break;
            case 4:
                counter.draw();
                counter2.draw();
                counter3.draw();
                counter4.draw();
                break;
            case 5:
                counter.draw();
                counter2.draw();
                counter3.draw();
                counter4.draw();
                counter5.draw();
        }
    }

    public void drawCounterPlayer2(int stars) {
        Picture counter = new Picture(1000, 150, "assets/picture3.png");

        Picture counter2 = new Picture(1030, 150, "assets/picture3.png");

        Picture counter3 = new Picture(1060, 150, "assets/picture3.png");

        Picture counter4 = new Picture(1090, 150, "assets/picture3.png");

        Picture counter5 = new Picture(1120, 150, "assets/picture3.png");

        switch (stars) {
            case 1:
                counter.draw();
                break;
            case 2:
                counter.draw();
                counter2.draw();
                break;
            case 3:
                counter.draw();
                counter2.draw();
                counter3.draw();
                break;
            case 4:
                counter.draw();
                counter2.draw();
                counter3.draw();
                counter4.draw();
                break;
            case 5:
                counter.draw();
                counter2.draw();
                counter3.draw();
                counter4.draw();
                counter5.draw();
        }
    }
}



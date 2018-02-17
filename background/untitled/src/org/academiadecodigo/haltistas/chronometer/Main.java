package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Game g = new Game();

        //g.start();
        //g.chronometer();

        Background background = new Background();

        background.draw();
        background.drawPlayer1();
        background.drawPlayer2();

    }
}



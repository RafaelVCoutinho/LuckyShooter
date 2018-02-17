package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Game g = new Game();

        //g.start();
        //g.chronometer();

        Background background = new Background();

        while(true) {

            background.drawBackground();

            Thread.sleep(3000);
            background.drawChronometer("assets/ready.png");
            Thread.sleep(1000);
            background.deleteChronometer();

            Thread.sleep(3000);
            background.drawChronometer("assets/set.png");
            Thread.sleep(1000);
            background.deleteChronometer();

            Thread.sleep(3000);
            background.drawChronometer("assets/bang.png");
            Thread.sleep(1000);
            background.deleteChronometer();


        }

    }
}



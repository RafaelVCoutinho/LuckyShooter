package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Background extends Grid {


    private Picture background;
    private Picture playerWins;


    public Background() throws InterruptedException {

        background = new Picture(-100, -70, "assets/saloon.jpg");
        background.grow(-110, -80);

    }



    public void drawPlayerWins(int adjustX, int adjustY, String source){

        playerWins = new Picture(WIDTH_CENTER-adjustX, HEIGHT_CENTER-adjustY, source);
        playerWins.draw();

    }

    public void deletePlayerWins(){
        playerWins.delete();
    }


    public void drawBackground() {

        background.draw();

    }


}
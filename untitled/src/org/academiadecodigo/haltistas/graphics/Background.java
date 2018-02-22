package org.academiadecodigo.haltistas.graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Background extends Grid {


    private Picture background;


    public Background() throws InterruptedException {

        background = new Picture(-100, -70, "assets/saloon.jpg");
        background.grow(-110, -80);

    }


    public void drawBackground() {

        background.draw();

    }

}
package org.academiadecodigo.haltistas.graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Background extends Grid {


    private Picture background;


    public Background() throws InterruptedException {

        background = new Picture(PADDLE+0.5, PADDLE+0.5, "assets/saloon.jpg");
        background.grow(-0.5, -0.5);

    }


    public void drawBackground() {

        background.draw();

    }

    public void deleteBackground(){
        background.delete();
    }

}
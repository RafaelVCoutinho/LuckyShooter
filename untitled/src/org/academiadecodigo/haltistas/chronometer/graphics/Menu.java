package org.academiadecodigo.haltistas.chronometer.graphics;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu extends Grid {


    private Rectangle menu;
    private Picture background;
    private Picture playerVsPlayer;
    private Picture playerVsComputer;
    private Picture menuPointer;


    public Menu(){

        menu = new Rectangle(10, 10, 1381, 741);
        background = new Picture(PADDLE+0.5, PADDLE+0.5, "assets/menubackground.jpg");
        background.grow(-0.5, -0.5);
    }



    public void drawPlayerVsPlayer(){

        playerVsPlayer = new Picture(WIDTH_CENTER-205, HEIGHT_CENTER-90, "assets/playervsplayer.png");
        playerVsPlayer.draw();

    }


    public void drawPlayerVsComputer(){

        playerVsComputer = new Picture(WIDTH_CENTER-245, HEIGHT_CENTER + 80, "assets/playervscomputer.png");
        playerVsComputer.draw();



    }


    public void drawMenuPointer(){

        menuPointer = new Picture(WIDTH_CENTER-550, HEIGHT_CENTER-60, "assets/menupointer.png");
        menuPointer.draw();

    }

    public void moveMenuPointerDown(){

        menuPointer.delete();
        menuPointer = new Picture(WIDTH_CENTER-590, HEIGHT_CENTER + 115, "assets/menupointer.png");
        menuPointer.draw();

    }

    public void moveMenuPointerUp(){
        menuPointer.delete();
        drawMenuPointer();
    }

    public void deleteMenu(){

        menu.delete();
        background.delete();
        playerVsPlayer.delete();
        playerVsComputer.delete();
        menuPointer.delete();
    }

    public void drawMenu() {
        menu.draw();
        background.draw();
        drawPlayerVsPlayer();
        drawPlayerVsComputer();
        drawMenuPointer();

    }
}

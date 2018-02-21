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
    }

    public void drawMenu() throws InterruptedException {

        menu.draw();

    }

    public void drawPlayerVsPlayer(){

        playerVsPlayer = new Picture(WIDTH_CENTER-205, HEIGHT_CENTER-90, "assets/playervsplayer.png");
        playerVsPlayer.draw();

    }


    public void darwPlayerVsComputer(){

        playerVsComputer = new Picture(WIDTH_CENTER-245, HEIGHT_CENTER + 80, "assets/playervscomputer.png");
        playerVsComputer.draw();



    }


    public void drawMenuPointer(){

        menuPointer = new Picture(WIDTH_CENTER-550, HEIGHT_CENTER-60, "assets/menupointer.png");
        menuPointer.draw();

    }

    public void moveMenuPointerDown(){

        if(menuPointer.getY() == 110 && menuPointer.getX() == 470){
            return;
        }

        menuPointer.delete();
        menuPointer = new Picture(WIDTH_CENTER-590, HEIGHT_CENTER + 115, "assets/menupointer.png");
        menuPointer.draw();

    }

    public void moveMenuPointerUp(){
        menuPointer.delete();
        drawMenuPointer();
    }


}

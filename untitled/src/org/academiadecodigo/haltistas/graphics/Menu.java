package org.academiadecodigo.haltistas.graphics;

import org.academiadecodigo.haltistas.game_enteties.BotGame;
import org.academiadecodigo.haltistas.game_enteties.HumanGame;
import org.academiadecodigo.haltistas.graphics.Grid;
import org.academiadecodigo.haltistas.keyboard.KeyboardMenu;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu extends Grid {


    private Rectangle menu;
    private Picture background;
    private Picture playerVsPlayer;
    private Picture playerVsComputer;
    private Picture menuPointer;

    private KeyboardMenu keyboardMenu;


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

    public void desenbucha(KeyboardMenu keyboardMenu) throws InterruptedException {

        System.out.println("ola fodeu");
        this.keyboardMenu = keyboardMenu;

        while(!keyboardMenu.getMenuChoice()){
            Thread.sleep(60);
        }

        System.out.println("asd");

        Background background = new Background();

        if(keyboardMenu.getPlayerVsPlayer()) {
            deleteMenu();
            background.drawBackground();
            HumanGame humanGame = new HumanGame();
            humanGame.start();
        }

        if(!keyboardMenu.getPlayerVsPlayer()) {
            deleteMenu();
            background.drawBackground();
            BotGame botGame = new BotGame();
            botGame.start();

        }
    }
}

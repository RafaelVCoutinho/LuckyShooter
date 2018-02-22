package org.academiadecodigo.haltistas.chronometer.graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CharacterSelectionMenu extends Grid {


    private String[] charSpritesAlive;
    private String[] charSpritesDead;
    private Picture charPointer;
    private Picture player;
    private Picture noob;
    private Picture rickSanches;
    private Picture lucky;


    public CharacterSelectionMenu(){

        charSpritesAlive = new String[]{"assets/player1Alive.png","assets/noobalive.png", "assets/rick_sanchez_alive.png", "assets/luckylukealive.png" };
        charSpritesDead = new String[]{"assets/player1Dead.png","assets/noobdead.png", "assets/rick_sanchez_dead.png", "assets/luckyluke.png"};
        charPointer = new Picture(200, 400, "assets/charpointer.png");

    }

    public void drawCharMenu(){
        drawGrid();
    }

    public void drawCharacter(){
        player = new Picture(200,280,"assets/player1Alive.png");
        player.draw();
        noob = new Picture(500, 200,"assets/noobalive.png");
        noob.draw();
        rickSanches = new Picture(700, 130,"assets/rick_sanchez_alive.png");
        rickSanches.draw();
        lucky = new Picture(1000, 150,"assets/luckylukealive.png");
        lucky.draw();
    }


    public String characterAliveChoice(int choice){

        return charSpritesAlive[choice];

    }

    public String characterDead(int choice){

        return charSpritesDead[choice];

    }

    public void showPointer(){

        charPointer.draw();

    }

    public void hidePointer(){

        charPointer.delete();

    }


    public void right(){
        hidePointer();
        charPointer.translate(300, 0);
        showPointer();

    }

    public void left(){

        hidePointer();;
        charPointer.translate(-300, 0);
        showPointer();

    }






}

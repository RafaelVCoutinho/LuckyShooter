package org.academiadecodigo.haltistas.chronometer.graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CharacterSelectionMenu extends Grid {


    private String[] playerOneSpritesAlive;
    private String[] playerOneSpritesDead;

    private String[] playerTwoSpritesAlive;
    private String[] playersTwoSpritesDead;


    private Picture playerOnePointer;
    private Picture playerTwoPointer;


    private Picture cowboyOne;
    private Picture noobOne;
    private Picture rickSanchesOne;
    private Picture luckyOne;

    private Picture cowboyTwo;
    private Picture noobTwo;
    private Picture rickSanchesTwo;
    private Picture luckyTwo;


    public CharacterSelectionMenu(){

        playerOneSpritesAlive = new String[]{"assets/player1Alive.png","assets/noobalive.png", "assets/rick_sanchez_alive.png", "assets/luckylukealive.png" };
        playerOneSpritesDead = new String[]{"assets/player1Dead.png","assets/noobdead.png", "assets/rick_sanchez_dead.png", "assets/luckylukedead.png"};

        playerTwoSpritesAlive = new String[]{"assets/player2Alive.png","assets/noobalive.png", "assets/rick_sanchez_alive.png", "assets/luckylukealive.png" };
        playersTwoSpritesDead = new String[]{"assets/player2Dead.png","assets/noobdead.png", "assets/rick_sanchez_dead.png", "assets/luckylukedead.png"};

        playerOnePointer = new Picture(50, 100, "assets/menupointer.png");

        playerTwoPointer = new Picture(1200, 100, "assets/menupointer.png");

    }

    public void drawCharMenu(){
        drawGrid();
    }

    public void drawPlayerOneCharacter(){
        cowboyOne = new Picture(400,100,"assets/player1Alive.png");
        cowboyOne.draw();
        noobOne = new Picture(400, 250,"assets/noobalive.png");
        noobOne.draw();
        rickSanchesOne = new Picture(400, 400,"assets/rick_sanchez_alive.png");
        rickSanchesOne.draw();
        luckyOne = new Picture(400, 550,"assets/luckylukealive.png");
        luckyOne.draw();
    }


    public void drawPlayerTwoCharacter(){
        cowboyTwo = new Picture(1000,100,"assets/player2Alive.png");
        cowboyTwo.draw();
        noobTwo = new Picture(1000, 250,"assets/noobalive.png");
        noobTwo.draw();
        rickSanchesTwo = new Picture(1000, 400,"assets/rick_sanchez_alive.png");
        rickSanchesTwo.draw();
        luckyTwo = new Picture(1000, 550,"assets/luckylukealive.png");
        luckyTwo.draw();


    }


    public String playerOneCharacterAliveChoice(int choice){

        return playerOneSpritesAlive[choice];

    }

    public String playerOneharacterDead(int choice){

        return playerOneSpritesDead[choice];

    }

    public String playerTwoCharacterAliveChoice(int choice){

        return playerTwoSpritesAlive[choice];

    }

    public String playerTwoCharcaterDead(int choice){

        return playersTwoSpritesDead[choice];

    }






    public void showPlayerOnePointer(){

        playerOnePointer.draw();

    }

    public void hidePlayerOnePointer(){

        playerOnePointer.delete();

    }

    public void showPlayerTwoPointer(){

        playerTwoPointer.draw();

    }

    public void hidePlayerTwoPointer(){

        playerTwoPointer.delete();

    }

    public void playerOneUp(){

        hidePlayerOnePointer();;
        playerOnePointer.translate(0, -200);
        showPlayerOnePointer();

    }

    public void playerOneDown(){
        hidePlayerOnePointer();
        playerOnePointer.translate(0, 200);
        showPlayerOnePointer();

    }

    public void playerTwoUp(){

        hidePlayerTwoPointer();
        playerTwoPointer.translate(0, -200);
        showPlayerTwoPointer();

    }


    public void playerTwoDown(){
        hidePlayerTwoPointer();
        playerTwoPointer.translate(0, 200);
        showPlayerTwoPointer();

    }




    public void deleteCharSelecMenu(){
        cowboyOne.delete();
        noobOne.delete();
        rickSanchesOne.delete();
        luckyOne.delete();
        playerOnePointer.delete();

        cowboyTwo.delete();
        noobTwo.delete();
        rickSanchesTwo.delete();
        luckyTwo.delete();
        playerTwoPointer.delete();
    }






}

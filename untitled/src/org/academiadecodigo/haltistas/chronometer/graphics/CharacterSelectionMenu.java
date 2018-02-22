package org.academiadecodigo.haltistas.chronometer.graphics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class CharacterSelectionMenu extends Grid {


    private String[] playerOneSpritesAlive;
    private String[] playerOneSpritesDead;

    private String[] playerTwoSpritesAlive;
    private String[] playersTwoSpritesDead;

    private Integer[] playerOneCharacterPosition;
    private Integer[] playerTwoCharacterPosition;

    private Picture playerOnePointer;
    private Picture playerTwoPointer;


    private Picture cowboyOne;
    private Picture noobOne;
    private Picture luckyOne;

    private Picture cowboyTwo;
    private Picture noobTwo;
    private Picture luckyTwo;

    private Rectangle grid;

    public CharacterSelectionMenu(){

        playerOneSpritesAlive = new String[]{"assets/player1Alive.png","assets/noobnoobalive1.png", "assets/luckyalive1.png" };
        playerOneSpritesDead = new String[]{"assets/player1Dead.png","assets/noobnoobdead1.png", "assets/luckydead1.png"};

        playerOneCharacterPosition = new Integer[]{20, 40 , 40};
        playerTwoCharacterPosition = new Integer[]{20, 40, 40};

        playerTwoSpritesAlive = new String[]{"assets/player2Alive.png","assets/noobnoobalive2.png",  "assets/luckyalive2.png" };
        playersTwoSpritesDead = new String[]{"assets/player2Dead.png","assets/noobnoobdead2.png", "assets/luckydead2.png"};

        playerOnePointer = new Picture(50, 110, "assets/pointer1.png");

        playerTwoPointer = new Picture(1100, 110, "assets/pointer2.png");

    }


    public Integer getPlayerTwoCharacterPosition( int pos){

        return playerTwoCharacterPosition[pos];
    }


    public Integer getPlayerOneCharacterPosition(int pos){

        return playerOneCharacterPosition[pos];

    }


    public void drawCharSelectMenu(){

        drawGridCharMenu();
        drawPlayerOneCharacter();
        drawPlayerTwoCharacter();

    }

    public void drawGridCharMenu(){
        grid = new Rectangle(10, 10, 1381, HEIGHT);
        grid.setColor(Color.PINK);
        grid.fill();
    }

    public void drawPlayerOneCharacter(){
        cowboyOne = new Picture(400,55,"assets/player1Alive.png");
        cowboyOne.draw();
        noobOne = new Picture(380, 200,"assets/noobnoobalive1.png");
        noobOne.draw();
        luckyOne = new Picture(320, 450,"assets/luckyalive1.png");
        luckyOne.draw();
    }


    public void drawPlayerTwoCharacter(){
        cowboyTwo = new Picture(1000,55,"assets/player2Alive.png");
        cowboyTwo.draw();
        noobTwo = new Picture(995, 200,"assets/noobnoobalive2.png");
        noobTwo.draw();
        luckyTwo = new Picture(920, 450,"assets/luckyalive2.png");
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
        playerOnePointer.translate(0, -210);
        showPlayerOnePointer();

    }

    public void playerOneDown(){
        hidePlayerOnePointer();
        playerOnePointer.translate(0, 210);
        showPlayerOnePointer();

    }

    public void playerTwoUp(){

        hidePlayerTwoPointer();
        playerTwoPointer.translate(0, -210);
        showPlayerTwoPointer();

    }


    public void playerTwoDown(){
        hidePlayerTwoPointer();
        playerTwoPointer.translate(0, 210);
        showPlayerTwoPointer();

    }




    public void deleteCharSelecMenu(){
        cowboyOne.delete();
        noobOne.delete();
        luckyOne.delete();
        playerOnePointer.delete();

        cowboyTwo.delete();
        noobTwo.delete();
        luckyTwo.delete();
        playerTwoPointer.delete();

        grid.delete();

    }






}

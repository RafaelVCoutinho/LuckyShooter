package org.academiadecodigo.haltistas.graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DrawCharacter {

    public final static int PLAYER_ONE_POS = 350;
    public final static int PLAYER_TWO_POS = 1000;
    public final static int PLAYER_GROUND = 550;

    private Picture playerOne;
    private Picture playerTwo;


    public void drawPlayerOneAlive(int adjustY, String source) {
        playerOne = new Picture(PLAYER_ONE_POS, PLAYER_GROUND - adjustY, source);
        playerOne.draw();
    }

    public void drawPLayerTwoAlive(String source) {
        drawPLayerTwoAlive(0, source);
    }
    public void drawPLayerTwoAlive(int adjustY, String source) {
        playerTwo = new Picture(PLAYER_TWO_POS, PLAYER_GROUND - adjustY, source);
        playerTwo.draw();
    }


    public void deletePlayer(Picture player) {
        player.delete();
    }

    public void drawPlayerOneDead(int adjustY, String source) {
        playerOne = new Picture(PLAYER_ONE_POS, PLAYER_GROUND + 40 - adjustY, source);
        playerOne.draw();
    }

    public void drawPlayerTwoDead(int adjustY, String source) {
        playerTwo = new Picture(PLAYER_TWO_POS, PLAYER_GROUND + 40 - adjustY, source);
        playerTwo.draw();
    }

    public Picture getPlayerOne() {
        return playerOne;
    }

    public Picture getPlayerTwo() {
        return playerTwo;
    }

    public void deleteCharacters(){

        playerOne.delete();
        playerTwo.delete();

    }

}

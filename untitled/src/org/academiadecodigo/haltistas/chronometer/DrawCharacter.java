package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DrawCharacter extends Grid {

    private Picture playerOne;
    private Picture playerTwo;


    public void drawPlayerOneAlive(String source) {
        playerOne = new Picture(PLAYER_ONE_POS, PLAYER_GROUND, source);
        playerOne.draw();
    }

    public void drawPLayerTwoAlive(String source) {
        playerTwo = new Picture(PLAYER_TWO_POS, PLAYER_GROUND, source);
        playerTwo.draw();
    }


    public void deletePlayer(Picture player) {
        player.delete();
    }

    public void drawPlayerOneDead(String source) {
        playerOne = new Picture(PLAYER_ONE_POS, PLAYER_GROUND + 40, source);
        playerOne.draw();
    }

    public void drawPlayerTwoDead(String source) {
        playerTwo = new Picture(PLAYER_TWO_POS, PLAYER_GROUND + 40, source);
        playerTwo.draw();
    }

    public Picture getPlayerOne() {
        return playerOne;
    }

    public Picture getPlayerTwo() {
        return playerTwo;
    }
}

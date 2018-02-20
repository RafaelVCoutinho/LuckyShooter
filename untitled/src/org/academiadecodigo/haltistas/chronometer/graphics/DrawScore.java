package org.academiadecodigo.haltistas.chronometer.graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DrawScore extends Grid {


    private int newStar;

    private Picture star;
    private Picture playerWins;


    public DrawScore() {

        newStar = 30;

    }

    public void drawPlayerOneScore(int nextStar) {
        int pos = 100;
        int end = 0;


        switch (nextStar) {
            case 1:
                end = 30;
                break;
            case 2:
                end = 60;
                break;
            case 3:
                end = 90;
                break;
            case 4:
                end = 120;
                break;
            case 5:
                end = 150;
                break;

        }

        for (int i = 0; i < end; i += 30) {

            //this.newStar += nextStar;
            star = new Picture(pos + i, 30, "assets/starCounter.png");
            star.draw();
        }


    }

    public void drawPlayerTwoScore(int newStar) {

        int pos = 1050;
        int end = 0;


        switch (newStar) {
            case 1:
                end = 30;
                break;
            case 2:
                end = 60;
                break;
            case 3:
                end = 90;
                break;
            case 4:
                end = 120;
                break;
            case 5:
                end = 150;
                break;

        }

        for (int i = 0; i < end; i += 30) {

            //this.newStar += nextStar;
            star = new Picture(pos + i, 30, "assets/starCounter.png");
            star.draw();
        }
    }

    //player one: x = 350, y = 250
    // player two: x = 350, y =250
    // draw: x = 300, y = 250

    public void drawPlayerWins(int adjustX, int adjustY, String source) {

        playerWins = new Picture(WIDTH_CENTER - adjustX, HEIGHT_CENTER - adjustY, source);
        playerWins.draw();

    }

    public void deletePlayerWins() throws InterruptedException {
        Thread.sleep(800);
        playerWins.delete();
    }
}

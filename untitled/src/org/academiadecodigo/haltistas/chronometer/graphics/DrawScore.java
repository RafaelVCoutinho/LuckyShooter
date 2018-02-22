package org.academiadecodigo.haltistas.chronometer.graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DrawScore extends Grid {


    private int newStar;

    private Picture playerOneStar;
    private Picture playerTwoStar;
    private Picture playerWins;
    private Picture round;


    public DrawScore() {

        newStar = 30;

    }

    public void drawPlayerOneScore(int score) {

        int x = 200;
        int y = 100;

        switch (score) {
            case 1:
                playerOneStar = new Picture(x, y, "assets/star1.png");
                playerOneStar.draw();
                break;
            case 2:
                playerOneStar.delete();
                playerOneStar = new Picture(x, y, "assets/star2.png");
                playerOneStar.draw();
                break;
            case 3:
                playerOneStar.delete();
                playerOneStar = new Picture(x, y, "assets/star3.png");
                playerOneStar.draw();
                break;
            case 4:
                playerOneStar.delete();
                playerOneStar = new Picture(x, y, "assets/star4.png");
                playerOneStar.draw();
                break;
            case 5:
                playerOneStar.delete();
                playerOneStar = new Picture(x, y, "assets/star5.png");
                playerOneStar.draw();
                break;

        }


    }

    public void drawPlayerTwoScore(int score) {

        int x = 1050;
        int y = 100;

        switch (score) {

            case 1:
                playerTwoStar = new Picture(x, y, "assets/star1.png");
                playerTwoStar.draw();
                break;
            case 2:
                playerTwoStar.delete();
                playerTwoStar = new Picture(x, y, "assets/star2.png");
                playerTwoStar.draw();
                break;
            case 3:
                playerTwoStar.delete();
                playerTwoStar = new Picture(x, y, "assets/star3.png");
                playerTwoStar.draw();
                break;
            case 4:
                playerTwoStar.delete();
                playerTwoStar = new Picture(x, y, "assets/star4.png");
                playerTwoStar.draw();
                break;
            case 5:
                playerTwoStar.delete();
                playerTwoStar = new Picture(x, y, "assets/star5.png");
                playerTwoStar.draw();
                break;

        }

    }

    //player one: x = 350, y = 250
    // player two: x = 350, y =250
    // draw: x = 300, y = 250

    public void drawPlayerWins(int adjustX, int adjustY, String source) {

        playerWins = new Picture(WIDTH_CENTER - adjustX, HEIGHT_CENTER - adjustY, source);
        playerWins.draw();

    }

    public void drawRound(int number) {
        switch (number) {
            case 1:
                round = new Picture(400, 100, "assets/round1.png");
                round.draw();
                deleteRound();
                break;

            case 2:
                round = new Picture(400, 100, "assets/round2.png");
                round.draw();
                deleteRound();
                break;
            case 3:
                round = new Picture(400, 100, "assets/round3.png");
                round.draw();
                deleteRound();
                break;

            case 4:
                round = new Picture(400, 100, "assets/round4.png");
                round.draw();
                deleteRound();
                break;
            case 5:
                round = new Picture(400, 100, "assets/round5.png");
                round.draw();
                deleteRound();
                break;

            default:
                System.out.println("error");
                break;
        }
    }

    public void deleteRound() {
        try {
            Thread.sleep(2000);
            round.delete();
        } catch (InterruptedException s) {
            System.out.println("Ups");
        }
    }

    public void deletePlayerWins() throws InterruptedException {
        Thread.sleep(800);
        playerWins.delete();
    }

    public void deleteScore() {
        playerOneStar.delete();
        playerTwoStar.delete();
        playerWins.delete();
    }

}

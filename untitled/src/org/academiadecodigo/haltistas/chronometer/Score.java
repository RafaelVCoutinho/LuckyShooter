package org.academiadecodigo.haltistas.chronometer;


public class Score {

    private int scorePlayer1;
    private int scorePlayer2;

    public Score() {
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
    }

    public void addScorePlayer1() {

        scorePlayer1 += 1;

    }

    public void addScorePlayer2() {

        scorePlayer2 += 1;
    }

    public void reset() {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }
}

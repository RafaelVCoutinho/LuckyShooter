package org.academiadecodigo.haltistas.chronometer.oldgame;

public class Game {

    private Player[] players;
    private Chronometer chronometer;
    private KeyboardTest k;
    private KeyboardTest2 k2;
    private Canvas canvas;

    public Game() {

        canvas = new Canvas();
        players = new Player[]{new Player("Lucky"), new Player("Luke")};
        chronometer = new Chronometer();

        k2 = new KeyboardTest2();
        k = new KeyboardTest();

    }



    public void start() throws InterruptedException {

        k2.test2(chronometer, players[0], players[1], canvas, k);
        k.test(chronometer, players[0], players[1], canvas, k2);
        chronometer.chronometero();
    }
}

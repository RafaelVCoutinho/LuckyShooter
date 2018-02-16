package org.academiadecodigo.haltistas.chronometer;

public class Game {

    private Player[] players;
    private Chronometer chronometer;
    private  KeyboardTest k;

    public Game() {

        players = new Player[]{new Player("Lucky"), new Player("Luke")};
        chronometer = new Chronometer();
        k = new KeyboardTest();
    }

    public void start() throws InterruptedException {

        k.test(chronometer);
        k.test2(chronometer);
        chronometer.chronometero();
    }
}

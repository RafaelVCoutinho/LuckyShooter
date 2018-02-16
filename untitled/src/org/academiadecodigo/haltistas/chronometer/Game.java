package org.academiadecodigo.haltistas.chronometer;

public class Game {

    private Player[] players;
    private Chronometer chronometer;
    private KeyboardTest k;
    private Canvas canvas;

    public Game() {

        canvas = new Canvas();
        players = new Player[]{new Player("Lucky"), new Player("Luke")};
        chronometer = new Chronometer();
        k = new KeyboardTest();
    }

    public void chronometer() {

        chronometer.chronometero();

    }

    public void start() throws InterruptedException {

        while (true) {
            k.test(chronometer, players[0], players[1]);
            //k.test2(chronometer, players[1]);


            if (players[0].isDead()) {

                canvas.deadPlayerOne(canvas.getPlayerOne());

            }

            if (players[1].isDead()) {

                canvas.deadPlayerOne(canvas.getPlayerTwo());

            }

        }
    }
}

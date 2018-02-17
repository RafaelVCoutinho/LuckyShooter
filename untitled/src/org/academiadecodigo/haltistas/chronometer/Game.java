package org.academiadecodigo.haltistas.chronometer;

public class Game {

    private Player[] players;
    private Chronometer chronometer;


    private Canvas canvas;

    public Game() {

        canvas = new Canvas();
        players = new Player[]{new HumanPlayer(), new HumanPlayer()};
        chronometer = new Chronometer();
        

    }

    public void chronometer() {

        chronometer.chronometero();

    }

    public void start() throws InterruptedException {

        k.test(chronometer, players[0], players[1], canvas, k2);
        k2.test2(chronometer, players[0], players[1], canvas, k);
        //k.test2(chronometer, players[1]);


    }


    public void kill(Player player) {

        if (player.isDead()) {

            System.out.println("I am dead");
            return;
        }

        System.out.println("Bang!");
        player.killed();
    }
}

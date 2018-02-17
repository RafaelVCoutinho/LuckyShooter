package org.academiadecodigo.haltistas.chronometer;

public class Game {

    private Player[] players;
    private Chronometer chronometer;
    private Canvas canvas;
    private HumanPlayer humanPlayer;

    public Game() {

        canvas = new Canvas();
        players = new Player[]{new HumanPlayer(), new HumanPlayer()};
        chronometer = new Chronometer();

    }

    public void chronometer() {

        chronometer.startTimer();

    }

    public void start() throws InterruptedException {

    }

    public boolean shootBeforeTime() {
        return humanPlayer.isShoot();
    }

    public void canShoot() {
        if (shootBeforeTime()) {

        }
    }
    public void winner(Player player) {

        if (player.isDead()) {
            System.out.println("I am dead");
            return;
        }
        System.out.println("Bang!");
        player.killed();
    }
}

package org.academiadecodigo.haltistas.chronometer;

public class Game {

    private Player[] players;
    private Chronometer chronometer;
    private Canvas canvas;
    private HumanPlayer humanPlayer;

    public Game() {
        canvas = new Canvas();
        players = new Player[]{new HumanPlayer("Woody"), new HumanPlayer("Uganda Warrior")};
        chronometer = new Chronometer();
    }

    public void chronometer() {

        chronometer.startTimer();

    }

    public void start() throws InterruptedException {

    }

    public boolean checkShooter(Player player) {
        return
    }

    public void checkKiller() {
        if (checkShooter()) {
            players[0].killed();
        }
        players[1].killed();
    }

}

package org.academiadecodigo.haltistas.chronometer;

public class Game {

    private HumanPlayer[] humanPlayers;
    private Chronometer chronometer;
    private Canvas canvas;
    private InputHandlerPlayer1 inputHandlerPlayer1;
    private InputHandlerPlayer2 inputHandlerPlayer2;
    private boolean flagPlayer1;
    private boolean flagPlayer2;

    public Game() {
        canvas = new Canvas();
        humanPlayers = new HumanPlayer[]{new HumanPlayer("Woody"), new HumanPlayer("Uganda Warrior")};
        chronometer = new Chronometer(this);
        inputHandlerPlayer1 = new InputHandlerPlayer1(humanPlayers[0]);
        inputHandlerPlayer2 = new InputHandlerPlayer2(humanPlayers[1]);
        inputHandlerPlayer1.key1();
        inputHandlerPlayer2.key2();
        flagPlayer1 = false;
        flagPlayer2 = false;
    }

    public void start() {
        chronometer();

        while (!flagPlayer1 || !flagPlayer2) {
            dead();
            System.out.println();
        }
        System.out.println("1 " + humanPlayers[0].isDead());
        System.out.println("2 " + humanPlayers[1].isDead());
    }

    public void chronometer() {
        chronometer.startTimer();
    }

    public void shotDuringTimer() {

        if (humanPlayers[0].isShoot()) {
            flagPlayer1 = true;
            System.out.println("shot 2 early player 1");

        }
        if (humanPlayers[1].isShoot()) {
            flagPlayer2 = true;
            System.out.println("shot 2 early player 2");
        }
    }

    public void dead() {
        if (humanPlayers[0].isShoot() && !flagPlayer1) {
            humanPlayers[1].killed();
            flagPlayer1 = true;
            flagPlayer2 = true;
            System.out.println("Player1 wins " + humanPlayers[1].isDead());

        }
        if (humanPlayers[1].isShoot() && !flagPlayer2) {
            humanPlayers[0].killed();
            flagPlayer2 = true;
            flagPlayer1 = true;
            System.out.println("Player2 wins " + humanPlayers[0].isDead());
        }
    }


}

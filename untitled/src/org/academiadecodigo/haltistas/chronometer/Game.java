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
        chronometer = new Chronometer();
        inputHandlerPlayer1 = new InputHandlerPlayer1(humanPlayers[0]);
        inputHandlerPlayer2 = new InputHandlerPlayer2(humanPlayers[1]);
        inputHandlerPlayer1.key1();
        inputHandlerPlayer2.key2();
        flagPlayer1 = false;
        flagPlayer2 = false;
    }

    public void start() {

        chronometer();

        while (chronometer.getRunning()) {
            deadDuringTimer();
            return;
        }

        while(!chronometer.getRunning()) {
            dead();
        }
    }

    public void chronometer() {
        chronometer.startTimer();
    }

    public void deadDuringTimer() {

        if (humanPlayers[0].isShoot()) {
            humanPlayers[0].killed();
            flagPlayer1 = true;
            System.out.println("you killed your self player 1");
            return;
        }
        if (humanPlayers[1].isShoot()) {
            humanPlayers[1].killed();
            flagPlayer2 = true;
            System.out.println("you killed your self player 2");
        }
    }

    public void dead() {
        if (humanPlayers[0].isShoot() && !flagPlayer1) {
            humanPlayers[1].killed();
            System.out.println("Player1 wins");
            return;
        }
        if (humanPlayers[1].isShoot() && !flagPlayer2) {
            humanPlayers[0].killed();
            System.out.println("Player2 wins");
        }
    }


}

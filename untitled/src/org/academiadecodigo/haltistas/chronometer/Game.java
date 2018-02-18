package org.academiadecodigo.haltistas.chronometer;

public class Game {

    private HumanPlayer[] humanPlayers;
    private Chronometer chronometer;
    private Canvas canvas;
    private InputHandlerPlayer1 inputHandlerPlayer1;
    private InputHandlerPlayer2 inputHandlerPlayer2;

    public Game() {
        canvas = new Canvas();
        humanPlayers = new HumanPlayer[]{new HumanPlayer("Woody"), new HumanPlayer("Uganda Warrior")};
        chronometer = new Chronometer();
        inputHandlerPlayer1 = new InputHandlerPlayer1(humanPlayers[0]);
        inputHandlerPlayer2 = new InputHandlerPlayer2(humanPlayers[1]);
        inputHandlerPlayer1.key1();
        inputHandlerPlayer2.key2();
    }

    public void start() throws InterruptedException {
            chronometer();
            checkKiller();
    }

    public void chronometer() {
        chronometer.startTimer();
    }

    public boolean checkShooter(HumanPlayer humanPlayer) {
        return humanPlayer.isShoot();
    }

    public void checkKiller() {
       if (checkShooter(humanPlayers[0]) && !checkShooter(humanPlayers[1])){
           humanPlayers[1].killed();
           System.out.println(humanPlayers[0] + " wins!!");
       }
        if (checkShooter(humanPlayers[1]) && !checkShooter(humanPlayers[1])) {
            humanPlayers[0].killed();
            System.out.println(humanPlayers[1] + " wins!!");
        }
    }
}

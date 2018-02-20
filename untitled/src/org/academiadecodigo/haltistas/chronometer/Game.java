package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.haltistas.chronometer.Keyboard.InputHandlerPlayer1;
import org.academiadecodigo.haltistas.chronometer.Keyboard.InputHandlerPlayer2;
import org.academiadecodigo.haltistas.chronometer.PlayerEnteties.HumanPlayer;
import org.academiadecodigo.haltistas.chronometer.graphics.DrawCharacter;
import org.academiadecodigo.haltistas.chronometer.graphics.DrawScore;
import org.academiadecodigo.haltistas.chronometer.graphics.Timer;

import java.util.Arrays;

public class Game {

    private final int MAX_NUMBER_OF_ROUNDS = 5;
    private int round;

    private InputHandlerPlayer1 inputHandlerPlayer1;
    private InputHandlerPlayer2 inputHandlerPlayer2;

    private HumanPlayer[] humanPlayers;

    private Boolean[] flags;
    private boolean flagPlayer1;
    private boolean flagPlayer2;

    private Timer timer;
    private Score score;

    private DrawScore drawScore;

    private DrawCharacter drawCharacter;


    public Game() {

        humanPlayers = new HumanPlayer[]{new HumanPlayer("Woody"), new HumanPlayer("Uganda Warrior")};
        inputHandlerPlayer1 = new InputHandlerPlayer1(humanPlayers[0]);
        inputHandlerPlayer2 = new InputHandlerPlayer2(humanPlayers[1]);

        drawCharacter = new DrawCharacter();

        inputHandlerPlayer1.key1();
        inputHandlerPlayer2.key2();

        drawScore = new DrawScore();

        timer = new Timer(this);


        flags = new Boolean[]{flagPlayer1 = false, flagPlayer2 = false};
        score = new Score();

        round = 1;
    }


    public void start() throws InterruptedException {


        drawCharacter.drawPlayerOneAlive(0, "assets/player1Alive.png");
        drawCharacter.drawPLayerTwoAlive("assets/player2Alive.png");


        timer.startCountdown();

        while (!flags[0] || !flags[1]) {

            dead();
            //Thread.sleep(1);
            System.out.println("i don't know how to solve visibility issues");
        }

        System.out.println("Player Lucky " + score.getScorePlayer1());
        System.out.println("Player Uganda Warrior " + score.getScorePlayer2());

        round++;

        if (round <= MAX_NUMBER_OF_ROUNDS) {
            Thread.sleep(1000);

            drawCharacter.deletePlayer(drawCharacter.getPlayerOne());
            drawCharacter.deletePlayer(drawCharacter.getPlayerTwo());
            reset();
            start();
        }
    }


    public void shotDuringTimer() {

        if (humanPlayers[0].isShoot()) {

            flags[0] = true;
            System.out.println("shot 2 early player 1");

        }
        if (humanPlayers[1].isShoot()) {

            flags[1] = true;
            System.out.println("shot 2 early player 2");
        }
    }


    public void dead() {


        if (humanPlayers[0].isShoot() && !flags[0]) {

            humanPlayers[1].killed();
            drawCharacter.deletePlayer(drawCharacter.getPlayerTwo());
            drawCharacter.drawPlayerTwoDead("assets/player2Dead.png");
            Arrays.fill(flags, true);

            score.addScorePlayer1();
            drawScore.drawPlayerOneScore(score.getScorePlayer1());
        }

        if (humanPlayers[1].isShoot() && !flags[1]) {

            humanPlayers[0].killed();
            drawCharacter.deletePlayer(drawCharacter.getPlayerOne());
            drawCharacter.drawPlayerOneDead("assets/player1Dead.png");
            Arrays.fill(flags, true);

            score.addScorePlayer2();
            drawScore.drawPlayerTwoScore(score.getScorePlayer2());
        }
    }


    public void reset() {
        Arrays.fill(flags, false);


        humanPlayers[0].revive();
        humanPlayers[1].revive();

        humanPlayers[0].notShot();
        humanPlayers[1].notShot();
    }
}

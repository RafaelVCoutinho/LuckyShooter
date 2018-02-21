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

    private InputHandlerPlayer1 inputHandlerPlayer1;
    private InputHandlerPlayer2 inputHandlerPlayer2;

    private HumanPlayer[] humanPlayers;

    private boolean flagPlayer1;
    private boolean flagPlayer2;

    private Timer timer;
    private Score score;

    private DrawScore drawScore;

    private DrawCharacter drawCharacter;


    public Game() {

        humanPlayers = new HumanPlayer[]{new HumanPlayer("Woody Toy"), new HumanPlayer("Lucky Luke")};

        inputHandlerPlayer1 = new InputHandlerPlayer1(humanPlayers[0]);
        inputHandlerPlayer2 = new InputHandlerPlayer2(humanPlayers[1]);

        drawCharacter = new DrawCharacter();

        inputHandlerPlayer1.key1();
        inputHandlerPlayer2.key2();

        flagPlayer1 = false;
        flagPlayer2 = false;

        drawScore = new DrawScore();

        timer = new Timer(this);

        score = new Score();
    }


    public void start() throws InterruptedException {

        drawCharacter.drawPlayerOneAlive(0, "assets/player1Alive.png");
        drawCharacter.drawPLayerTwoAlive("assets/player2Alive.png");

        timer.startCountdown();

        while (!flagPlayer1 || !flagPlayer2) {

            Thread.sleep(100);

            checkKiller();
        }
        System.out.println("After while");
        //System.out.println("Player Um " + inputHandlerPlayer1.getPressedKeyTime());
        //System.out.println("Player Dois " + inputHandlerPlayer2.getPressedKeyTime());
        winner();

        if (score.getScorePlayer1() < MAX_NUMBER_OF_ROUNDS && score.getScorePlayer2() < MAX_NUMBER_OF_ROUNDS) {
            Thread.sleep(1000);

            drawCharacter.deletePlayer(drawCharacter.getPlayerOne());
            drawCharacter.deletePlayer(drawCharacter.getPlayerTwo());
            reset();
            start();
        }
    }

    public void shotBeforeTimer() {

        if (humanPlayers[0].isShoot()) {
            flagPlayer1 = true;
            inputHandlerPlayer1.resetPressedKeyTime();
        }

        if (humanPlayers[1].isShoot()) {
            flagPlayer2 = true;
            inputHandlerPlayer2.resetPressedKeyTime();
        }
    }


    public void winner() {

        if (score.getScorePlayer1() == 5) {
            drawScore.drawPlayerWins(350, 250, "assets/playerOneWins.png");
        }

        if (score.getScorePlayer2() == 5) {
            drawScore.drawPlayerWins(350, 250, "assets/playerTwoWins.png");
        }
    }


    public void checkKiller() {

        if (playerOneShotTime() > playerTwoShotTime() && !flagPlayer1) {
            System.out.println("Plaeyr1");
            humanPlayers[1].killed();

            flagPlayer1 = true;
            flagPlayer2 = true;

            drawCharacter.deletePlayer(drawCharacter.getPlayerTwo());
            drawCharacter.drawPlayerTwoDead("assets/player2Dead.png");

            score.addScorePlayer1();
            drawScore.drawPlayerOneScore(score.getScorePlayer1());
        }

        if (playerTwoShotTime() > playerOneShotTime() && !flagPlayer2) {

            System.out.println("Player2");
            humanPlayers[0].killed();

            flagPlayer1 = true;
            flagPlayer2 = true;

            drawCharacter.deletePlayer(drawCharacter.getPlayerOne());
            drawCharacter.drawPlayerOneDead("assets/player1Dead.png");

            score.addScorePlayer2();
            drawScore.drawPlayerTwoScore(score.getScorePlayer2());

        }

    }


    public long playerOneShotTime() {
        return inputHandlerPlayer1.getPressedKeyTime() - timer.getBangTime();
    }


    public long playerTwoShotTime() {
        return inputHandlerPlayer2.getPressedKeyTime() - timer.getBangTime();
    }


    public void reset() {

        inputHandlerPlayer1.resetPressedKeyTime();
        inputHandlerPlayer2.resetPressedKeyTime();
        timer.resetBangTime();

        inputHandlerPlayer1.resetPressedKey();
        inputHandlerPlayer2.resetPressedKey();

        humanPlayers[0].revive();
        humanPlayers[1].revive();

        humanPlayers[0].notShot();
        humanPlayers[1].notShot();

        flagPlayer1 = false;
        flagPlayer2 = false;
    }


}

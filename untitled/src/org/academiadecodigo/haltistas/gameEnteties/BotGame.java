package org.academiadecodigo.haltistas.gameEnteties;

import org.academiadecodigo.haltistas.PlayerEnteties.BotPlayer;
import org.academiadecodigo.haltistas.PlayerEnteties.HumanPlayer;
import org.academiadecodigo.haltistas.Score;
import org.academiadecodigo.haltistas.graphics.DrawCharacter;
import org.academiadecodigo.haltistas.graphics.DrawScore;
import org.academiadecodigo.haltistas.graphics.Timer;
import org.academiadecodigo.haltistas.Keyboard.InputHandlerPlayer1;

public class BotGame {

    private final int MAX_NUMBER_OF_ROUNDS = 5;

    private InputHandlerPlayer1 inputHandlerPlayer1;

    private BotPlayer botPlayer;
    private HumanPlayer humanPlayer;

    private boolean flagPlayer;
    private boolean flagBot;

    private Timer timer;
    private Score score;

    private DrawScore drawScore;
    private DrawCharacter drawCharacter;


    public BotGame() {

        botPlayer = new BotPlayer("n00b n00b");
        humanPlayer = new HumanPlayer("FODETE");

        inputHandlerPlayer1 = new InputHandlerPlayer1(humanPlayer);

        drawCharacter = new DrawCharacter();

        inputHandlerPlayer1.key1();

        flagPlayer = false;
        flagBot = false;

        drawScore = new DrawScore();

        timer = new Timer(this);

        score = new Score();
    }


    public void start() throws InterruptedException {

        drawCharacter.drawPlayerOneAlive(0, "assets/player1Alive.png");
        drawCharacter.drawPLayerTwoAlive("assets/player2Alive.png");

        timer.startCountdown();
        botPlayer.shoot();

        while (!flagPlayer || !flagBot) {
            Thread.sleep(100);

            checkKiller();
        }

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

        if (humanPlayer.isShoot()) {
            flagPlayer = true;
            inputHandlerPlayer1.resetPressedKeyTime();
        }

        if (botPlayer.isShoot()) {
            flagBot = true;
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

        if (humanPlayer.isShoot() && !flagPlayer) {
            System.out.println("Plaeyr1");
            botPlayer.killed();

            flagPlayer = true;
            flagBot = true;

            drawCharacter.deletePlayer(drawCharacter.getPlayerTwo());
            drawCharacter.drawPlayerTwoDead("assets/player2Dead.png");

            score.addScorePlayer1();
            drawScore.drawPlayerOneScore(score.getScorePlayer1());
        }

        if (botPlayer.isShoot() && !flagBot) {

            System.out.println("Player2");
            humanPlayer.killed();

            flagPlayer = true;
            flagBot = true;

            drawCharacter.deletePlayer(drawCharacter.getPlayerOne());
            drawCharacter.drawPlayerOneDead("assets/player1Dead.png");

            score.addScorePlayer2();
            drawScore.drawPlayerTwoScore(score.getScorePlayer2());
        }
    }


    public void reset() {

        inputHandlerPlayer1.resetPressedKeyTime();

        humanPlayer.revive();
        botPlayer.revive();

        humanPlayer.notShot();
        botPlayer.notShot();

        flagPlayer = false;
        flagBot = false;
    }
}

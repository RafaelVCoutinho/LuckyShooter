package org.academiadecodigo.haltistas.game_enteties;

import org.academiadecodigo.haltistas.player_enteties.BotPlayer;
import org.academiadecodigo.haltistas.player_enteties.HumanPlayer;
import org.academiadecodigo.haltistas.keyboard.InputHandlerPlayer1;

public class BotGame extends SuperGame {

    private InputHandlerPlayer1 inputHandlerPlayer1;

    private BotPlayer botPlayer;
    private HumanPlayer humanPlayer;

    private boolean flagPlayer;
    private boolean flagBot;


    public BotGame() {

        botPlayer = new BotPlayer("n00b n00b");
        humanPlayer = new HumanPlayer("FODETE");

        inputHandlerPlayer1 = new InputHandlerPlayer1(humanPlayer);
        inputHandlerPlayer1.key1();

        flagPlayer = false;
        flagBot = false;
    }

    @Override
    public void start() throws InterruptedException {
        drawCharacter.drawPlayerOneAlive(0, "assets/player1Alive.png");
        drawCharacter.drawPLayerTwoAlive("assets/player2Alive.png");

        super.startCountdown();
        botPlayer.shoot();

        while (!flagPlayer || !flagBot) {
            Thread.sleep(100);

            checkKiller();
        }

        winner();

        super.start();
    }

    @Override
    public void shotBeforeTimer() {

        if (humanPlayer.isShoot()) {
            flagPlayer = true;
            inputHandlerPlayer1.resetPressedKeyTime();
        }

        if (botPlayer.isShoot()) {
            flagBot = true;
        }
    }


    @Override
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

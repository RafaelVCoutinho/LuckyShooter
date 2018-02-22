package org.academiadecodigo.haltistas.game_enteties;

import org.academiadecodigo.haltistas.keyboard.InputHandlerPlayer1;
import org.academiadecodigo.haltistas.player_enteties.BotPlayer;
import org.academiadecodigo.haltistas.player_enteties.HumanPlayer;

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

        if (timer.isBotFlag()) {
            botPlayer.shoot();
        }

        checkKiller();

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

        System.out.println("Player time " + inputHandlerPlayer1.getPressedKeyTime());
        System.out.println("Bot time " + botPlayer.getShotTimer());

        if (inputHandlerPlayer1.getPressedKeyTime() < botPlayer.getShotTimer() && !flagPlayer) {
            System.out.println("Plaeyr1");
            botPlayer.killed();

            flagPlayer = true;
            flagBot = true;

            drawCharacter.deletePlayer(drawCharacter.getPlayerTwo());
            drawCharacter.drawPlayerTwoDead(0,"assets/player2Dead.png");

            score.addScorePlayer1();
            drawScore.drawPlayerOneScore(score.getScorePlayer1());

            return;
        }


        System.out.println("Player2");
        humanPlayer.killed();

        flagPlayer = true;
        flagBot = true;

        drawCharacter.deletePlayer(drawCharacter.getPlayerOne());
        drawCharacter.drawPlayerOneDead(0,"assets/player1Dead.png");

        score.addScorePlayer2();
        drawScore.drawPlayerTwoScore(score.getScorePlayer2());
    }


    public void reset() {

        inputHandlerPlayer1.resetPressedKeyTime();

        humanPlayer.revive();
        botPlayer.revive();

        humanPlayer.notShot();
        botPlayer.notShot();

        flagPlayer = false;
        flagBot = false;

        timer.resetBotflag();
    }
}

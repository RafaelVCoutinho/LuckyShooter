package org.academiadecodigo.haltistas.game_enteties;

import org.academiadecodigo.haltistas.keyboard.InputHandlerPlayer1;
import org.academiadecodigo.haltistas.keyboard.InputHandlerPlayer2;
import org.academiadecodigo.haltistas.player_enteties.HumanPlayer;

import java.util.Arrays;

public class HumanGame extends SuperGame {

    private InputHandlerPlayer1 inputHandlerPlayer1;
    private InputHandlerPlayer2 inputHandlerPlayer2;

    private HumanPlayer[] humanPlayers;

    private Boolean[] flags;
    private boolean flagPlayer1;
    private boolean flagPlayer2;


    public HumanGame() {

        super();

        humanPlayers = new HumanPlayer[]{new HumanPlayer("Woody Toy"), new HumanPlayer("Lucky Luke")};

        inputHandlerPlayer1 = new InputHandlerPlayer1(humanPlayers[0]);
        inputHandlerPlayer2 = new InputHandlerPlayer2(humanPlayers[1]);

        inputHandlerPlayer1.key1();
        inputHandlerPlayer2.key2();

        flags = new Boolean[]{flagPlayer1 = false, flagPlayer2 = false};
    }


    @Override
    public void start() throws InterruptedException {
        super.drawCharacter();

        super.startCountdown();

        while (!flags[0] || !flags[1]) {

            Thread.sleep(100);
            checkKiller();
        }

        winner();
        super.start();
    }

    @Override
    public void shotBeforeTimer() {

        if (humanPlayers[0].isShoot()) {

            flags[0] = true;
            inputHandlerPlayer1.resetPressedKeyTime();
            System.out.println("shot 2 early player 1");

        }
        if (humanPlayers[1].isShoot()) {

            flags[1] = true;
            inputHandlerPlayer2.resetPressedKeyTime();
            System.out.println("shot 2 early player 2");
        }
    }

    @Override
    public void checkKiller() {


        if (inputHandlerPlayer1.getPressedKeyTime() < inputHandlerPlayer2.getPressedKeyTime() && !flags[0]) {

            humanPlayers[1].killed();
            drawCharacter.deletePlayer(drawCharacter.getPlayerTwo());
            drawCharacter.drawPlayerTwoDead(0,"assets/player2Dead.png");
            Arrays.fill(flags, true);
            score.addScorePlayer1();
            drawScore.drawPlayerOneScore(score.getScorePlayer1());
        }

        if (inputHandlerPlayer2.getPressedKeyTime() < inputHandlerPlayer1.getPressedKeyTime() && !flags[1]) {

            humanPlayers[0].killed();
            drawCharacter.deletePlayer(drawCharacter.getPlayerOne());
            drawCharacter.drawPlayerOneDead(0,"assets/player1Dead.png");
            Arrays.fill(flags, true);

            score.addScorePlayer2();
            drawScore.drawPlayerTwoScore(score.getScorePlayer2());
        }
    }


    public void reset() throws InterruptedException {
        Arrays.fill(flags, false);

        inputHandlerPlayer1.resetPressedKeyTime();
        inputHandlerPlayer2.resetPressedKeyTime();

        humanPlayers[0].revive();
        humanPlayers[1].revive();

        humanPlayers[0].notShot();
        humanPlayers[1].notShot();

    }
}

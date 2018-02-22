package org.academiadecodigo.haltistas.game_enteties;

import org.academiadecodigo.haltistas.Score;
import org.academiadecodigo.haltistas.graphics.DrawCharacter;
import org.academiadecodigo.haltistas.graphics.DrawScore;
import org.academiadecodigo.haltistas.graphics.Menu;
import org.academiadecodigo.haltistas.graphics.Timer;
import org.academiadecodigo.haltistas.keyboard.KeyboardMenu;

public abstract class SuperGame {

    private final int MAX_NUMBER_OF_ROUNDS = 2;

    protected DrawScore drawScore;
    protected DrawCharacter drawCharacter;

    private Boolean[] flags;
    private boolean flagPlayer1;
    private boolean flagPlayer2;

    protected Timer timer;
    protected Score score;

    private Menu menu;
    private KeyboardMenu keyboardMenu;


    public SuperGame() {
        menu = new Menu();
        keyboardMenu = new KeyboardMenu(menu);

        this.flagPlayer1 = false;
        this.flagPlayer2 = false;
        this.timer = new Timer(this);
        this.score = new Score();
        this.drawScore = new DrawScore();
        this.drawCharacter = new DrawCharacter();

    }

    public void startCountdown() throws InterruptedException {
        timer.startCountdown();
    }

    public void start() throws InterruptedException {

        if (score.getScorePlayer1() < MAX_NUMBER_OF_ROUNDS && score.getScorePlayer2() < MAX_NUMBER_OF_ROUNDS) {
            Thread.sleep(1000);

            drawCharacter.deletePlayer(drawCharacter.getPlayerOne());
            drawCharacter.deletePlayer(drawCharacter.getPlayerTwo());
            reset();
            start();
        }
    }

    public void endGame() throws InterruptedException {
        drawCharacter.deletePlayer(drawCharacter.getPlayerOne());
        drawCharacter.deletePlayer(drawCharacter.getPlayerTwo());
        drawScore.deletePlayerWins();
    }


    public void winner() throws InterruptedException {
        if (score.getScorePlayer1() == MAX_NUMBER_OF_ROUNDS) {
            drawScore.drawPlayerWins(350, 250, "assets/playerOneWins.png");
            Thread.sleep(2000);
            endGame();
        }

        if (score.getScorePlayer2() == MAX_NUMBER_OF_ROUNDS) {
            drawScore.drawPlayerWins(350, 250, "assets/playerTwoWins.png");
            Thread.sleep(2000);
            endGame();
        }


    }

    public void drawCharacter() {
        drawCharacter.drawPlayerOneAlive(0, "assets/player1Alive.png");
        drawCharacter.drawPLayerTwoAlive(0, "assets/player2Alive.png");
    }


    public abstract void shotBeforeTimer();


    public abstract void checkKiller();


    public abstract void reset() throws InterruptedException;

}


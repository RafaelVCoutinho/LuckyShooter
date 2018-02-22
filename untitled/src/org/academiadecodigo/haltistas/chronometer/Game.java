package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.haltistas.chronometer.Keyboard.CharacterSelectionKeyboard;
import org.academiadecodigo.haltistas.chronometer.Keyboard.InputHandlerPlayer1;
import org.academiadecodigo.haltistas.chronometer.Keyboard.InputHandlerPlayer2;
import org.academiadecodigo.haltistas.chronometer.Keyboard.KeyboardMenu;
import org.academiadecodigo.haltistas.chronometer.PlayerEnteties.HumanPlayer;
import org.academiadecodigo.haltistas.chronometer.graphics.*;

import java.util.Arrays;

public class Game {

    private final int MAX_NUMBER_OF_ROUNDS = 5;

    private InputHandlerPlayer1 inputHandlerPlayer1;
    private InputHandlerPlayer2 inputHandlerPlayer2;
    private KeyboardMenu keyboardMenu;
    private Menu menu;

    private int alreadyPlayed;
    private HumanPlayer[] humanPlayers;

    private Boolean[] flags;
    private boolean flagPlayer1;
    private boolean flagPlayer2;

    private Timer timer;
    private Score score;

    private Grid grid;
    private Background background;

    private DrawScore drawScore;

    private DrawCharacter drawCharacter;

    private CharacterSelectionMenu characterSelectionMenu;

    private CharacterSelectionKeyboard characterSelectionKeyboard;


    public Game() {

        characterSelectionMenu = new CharacterSelectionMenu();
        characterSelectionKeyboard = new CharacterSelectionKeyboard(characterSelectionMenu);

        humanPlayers = new HumanPlayer[]{new HumanPlayer("Woody Toy"), new HumanPlayer("Lucky Luke")};
        menu = new Menu();
        inputHandlerPlayer1 = new InputHandlerPlayer1(humanPlayers[0]);
        inputHandlerPlayer2 = new InputHandlerPlayer2(humanPlayers[1]);

        keyboardMenu = new KeyboardMenu(menu);

        drawCharacter = new DrawCharacter();

        inputHandlerPlayer1.key1();
        inputHandlerPlayer2.key2();

        drawScore = new DrawScore();

        timer = new Timer(this);


        flags = new Boolean[]{flagPlayer1 = false, flagPlayer2 = false};
        score = new Score();
        alreadyPlayed = 0;

    }


    public void start() throws InterruptedException {

            keyboardMenu.menuKeys();


        characterSelectionKeyboard.playerOneSelectionKeys();
        characterSelectionKeyboard.playerTwoSelectionKeys();

        if (score.getScorePlayer1() == 0 && score.getScorePlayer2() == 0 && alreadyPlayed == 0) {
            menu.drawMenu();
        }

        while (!keyboardMenu.getMenuChoice()) {
            Thread.sleep(60);
        }

        menu.deleteMenu();

        characterSelectionMenu.drawCharMenu();
        characterSelectionMenu.drawPlayerOneCharacter();
        characterSelectionMenu.drawPlayerTwoCharacter();

        while (!characterSelectionKeyboard.getPlayerOneChoice() || !characterSelectionKeyboard.getPlayerTwoChoice()) {
            Thread.sleep(60);
        }

        characterSelectionMenu.deleteCharSelecMenu();


        if (keyboardMenu.getMenuDeleted() && keyboardMenu.getPlayerVsPlayer()) {
            menu.deleteMenu();

            keyboardMenu.menuDeletedFalse();

            System.out.println("entrou no player vs player");


            grid = new Grid();
            grid.drawGrid();
            background = new Background();
            background.drawBackground();


            drawCharacter.drawPlayerOneAlive(20, characterSelectionMenu.playerOneCharacterAliveChoice(characterSelectionKeyboard.getPlayerOneCharPosition()));
            drawCharacter.drawPLayerTwoAlive(20, characterSelectionMenu.playerTwoCharacterAliveChoice(characterSelectionKeyboard.getPlayerTwoCharPosition()));
            timer.startCountdown();
        }


        if (keyboardMenu.getMenuDeleted() && !keyboardMenu.getPlayerVsPlayer()) {


            keyboardMenu.menuDeletedFalse();
            System.out.println("entrou no bot");


            grid = new Grid();
            grid.drawGrid();
            background = new Background();
            background.drawBackground();
            drawCharacter.drawPlayerOneAlive(20, "assets/player1Alive.png");
            drawCharacter.drawPLayerTwoAlive(20, "assets/player2Alive.png");

            timer.startCountdown();


        }

        if (score.getScorePlayer1() != 0 || score.getScorePlayer2() != 0) {

            drawCharacter.drawPlayerOneAlive(20, characterSelectionMenu.playerOneCharacterAliveChoice(characterSelectionKeyboard.getPlayerOneCharPosition()));
            drawCharacter.drawPLayerTwoAlive(20, characterSelectionMenu.playerTwoCharacterAliveChoice(characterSelectionKeyboard.getPlayerTwoCharPosition()));
            timer.startCountdown();
        }


        while (!flags[0] || !flags[1]) {

            Thread.sleep(100);
            dead();
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


    public void winner() throws InterruptedException {


        if (score.getScorePlayer1() == 5) {
            Thread.sleep(2000);
            drawScore.drawPlayerWins(350, 250, "assets/playerOneWins.png");
            grid.deleteGird();
            background.deleteBackground();
            drawCharacter.deleteCharacters();
            drawScore.deleteScore();
            menu.drawMenu();
            keyboardMenu.menuChoiceFalse();
            keyboardMenu.menuDeletedTrue();
            score.reset();
            alreadyPlayed = 1;

        }

        if (score.getScorePlayer2() == 5) {
            Thread.sleep(2000);
            drawScore.drawPlayerWins(350, 250, "assets/playerTwoWins.png");
            grid.deleteGird();
            background.deleteBackground();
            drawCharacter.deleteCharacters();
            drawScore.deleteScore();
            menu.drawMenu();
            keyboardMenu.menuChoiceFalse();
            keyboardMenu.menuDeletedTrue();
            score.reset();
            alreadyPlayed = 1;

        }
    }


    public void shotDuringTimer() {

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


    public void dead() {


        if (inputHandlerPlayer1.getPressedKeyTime() < inputHandlerPlayer2.getPressedKeyTime() && !flags[0]) {

            humanPlayers[1].killed();
            drawCharacter.deletePlayer(drawCharacter.getPlayerTwo());
            drawCharacter.drawPlayerTwoDead(characterSelectionMenu.playerTwoCharcaterDead(characterSelectionKeyboard.getPlayerTwoCharPosition()));
            Arrays.fill(flags, true);

            score.addScorePlayer1();
            drawScore.drawPlayerOneScore(score.getScorePlayer1());
        }

        if (inputHandlerPlayer2.getPressedKeyTime() < inputHandlerPlayer1.getPressedKeyTime() && !flags[1]) {

            humanPlayers[0].killed();
            drawCharacter.deletePlayer(drawCharacter.getPlayerOne());
            drawCharacter.drawPlayerOneDead(characterSelectionMenu.playerOneharacterDead(characterSelectionKeyboard.getPlayerOneCharPosition()));
            Arrays.fill(flags, true);

            score.addScorePlayer2();
            drawScore.drawPlayerTwoScore(score.getScorePlayer2());
        }
    }


    public void reset() {
        Arrays.fill(flags, false);

        inputHandlerPlayer1.resetPressedKeyTime();
        inputHandlerPlayer2.resetPressedKeyTime();

        humanPlayers[0].revive();
        humanPlayers[1].revive();

        humanPlayers[0].notShot();
        humanPlayers[1].notShot();
    }
}

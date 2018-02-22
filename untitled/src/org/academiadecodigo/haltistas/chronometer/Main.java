package org.academiadecodigo.haltistas.chronometer;


import org.academiadecodigo.haltistas.chronometer.gameEnteties.BotGame;
import org.academiadecodigo.haltistas.chronometer.gameEnteties.HumanGame;
import org.academiadecodigo.haltistas.chronometer.graphics.Background;
import org.academiadecodigo.haltistas.chronometer.graphics.Grid;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Grid grid = new Grid();
        Background background = new Background();
        //HumanGame humanGame = new HumanGame();
        BotGame botGame = new BotGame();

        grid.drawGrid();
        background.drawBackground();
        //humanGame.start();
        botGame.start();


    }
}



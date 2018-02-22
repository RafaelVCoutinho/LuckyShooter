package org.academiadecodigo.haltistas;


import org.academiadecodigo.haltistas.game_enteties.BotGame;
import org.academiadecodigo.haltistas.game_enteties.HumanGame;
import org.academiadecodigo.haltistas.graphics.Background;
import org.academiadecodigo.haltistas.graphics.Grid;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Grid grid = new Grid();
        Background background = new Background();
        HumanGame humanGame = new HumanGame();
        //BotGame botGame = new BotGame();

        grid.drawGrid();
        background.drawBackground();
        humanGame.start();
        //botGame.start();


    }
}



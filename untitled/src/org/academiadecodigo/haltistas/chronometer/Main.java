package org.academiadecodigo.haltistas.chronometer;


import org.academiadecodigo.haltistas.chronometer.graphics.Background;
import org.academiadecodigo.haltistas.chronometer.graphics.Grid;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Grid grid = new Grid();
        Background background = new Background();
        Game game = new Game();

        grid.drawGrid();
        background.drawBackground();
        game.start();


    }
}



package org.academiadecodigo.haltistas.chronometer;


import org.academiadecodigo.haltistas.chronometer.Keyboard.KeyboardMenu;
import org.academiadecodigo.haltistas.chronometer.graphics.Background;
import org.academiadecodigo.haltistas.chronometer.graphics.Grid;
import org.academiadecodigo.haltistas.chronometer.graphics.Menu;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        /*Grid grid = new Grid();
        Background background = new Background();
        Game game = new Game();

        grid.drawGrid();
        background.drawBackground();
        game.start();*/

        Menu menu = new Menu();
        KeyboardMenu keyboardMenu = new KeyboardMenu(menu);
        keyboardMenu.menuDown();
        keyboardMenu.menuUp();
        menu.drawMenu();
        menu.drawPlayerVsPlayer();
        menu.darwPlayerVsComputer();
        menu.drawMenuPointer();

    }
}



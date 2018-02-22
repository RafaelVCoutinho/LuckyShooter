package org.academiadecodigo.haltistas;


import org.academiadecodigo.haltistas.game_enteties.BotGame;
import org.academiadecodigo.haltistas.game_enteties.HumanGame;
import org.academiadecodigo.haltistas.graphics.Background;
import org.academiadecodigo.haltistas.graphics.Grid;
import org.academiadecodigo.haltistas.graphics.Menu;
import org.academiadecodigo.haltistas.keyboard.KeyboardMenu;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            Grid grid = new Grid();
            Menu menu = new Menu();

            KeyboardMenu keyboardMenu = new KeyboardMenu(menu);

            menu.drawMenu();
            keyboardMenu.menuKeys();

            grid.drawGrid();

            menu.desenbucha(keyboardMenu);

        }
    }
}



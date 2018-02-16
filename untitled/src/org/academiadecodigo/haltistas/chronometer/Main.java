package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game g = new Game();
        KeyboardTest k = new KeyboardTest();
        Canvas canvas = new Canvas();
        Text text = new Text(canvas.getCol(), canvas.getRow(), "Teste");

        g.start();


    }
}



package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        KeyboardTest k = new KeyboardTest();
        Canvas canvas = new Canvas();
        Text text = new Text(canvas.getCol(), canvas.getRow(), "Teste");
        Chronometer c = new Chronometer();

        k.test();
        k.test2();
        c.chronometero();


    }
}



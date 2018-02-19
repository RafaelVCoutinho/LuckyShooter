package org.academiadecodigo.haltistas.chronometer;


public class Main {

    public static void main(String[] args) {

        try {
            Game g = new Game();
            g.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



package org.academiadecodigo.haltistas.chronometer;


public class Main {

    public static void main(String[] args) {

        Game g = new Game();


        try {
            g.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Chronometer {

    private Thread thread;
    private Text text;
    private boolean running;
    private Game game;

    public Chronometer(Game game) {

        this.text = new Text(700 / 2, 500 / 2, "Test");
        this.thread = new Thread();

        this.running = true;
        this.game = game;
    }

    public void startTimer() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException s) {
            System.out.println("Nice");
        }
        for (int i = 3; i >= 0; i--) {

            if (i == 3) {

                text.setText("3");
                text.draw();
                //game.shotDuringTimer();
                continue;
            }


            if (i == 2) {
                delayCount();
                text.setText("2");
                text.draw();
                //game.shotDuringTimer();
                continue;
            }

            if (i == 1) {
                delayCount();
                text.setText("1");
                text.draw();
                //game.shotDuringTimer();
                continue;
            }

            if (i == 0) {
                delayCount();
                text.setText("0");
                text.draw();
                //game.shotDuringTimer(); shot = true
                // stoppedRunning();
                return;
            }

        }
    }

    public void delayCount() {

        int randomDelay = (int) (Math.random() * 3500);

        try {
            Thread.sleep(randomDelay);
        } catch (InterruptedException s) {
            System.out.println("nice");
        }
    }

    public void stoppedRunning() {
        this.running = false;
    }

    public boolean getRunning() {
        return running;
    }
}

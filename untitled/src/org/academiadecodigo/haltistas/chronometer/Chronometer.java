package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Chronometer {

    private Thread thread;
    private int timer;
    private Text text;
    private boolean flag;



    public Chronometer() {

        this.text = new Text(700 / 2, 500 / 2, "Test");
        this.timer = 3;
        this.thread = new Thread();
    }

    public void chronometero() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException s) {
            System.out.println("Nice");
        }
        for (int i = 3; i >= 0; i--) {

            if (i == 3) {

                text.setText("3");
                text.draw();
                continue;
            }


            if (i == 2) {
                delayCount();
                text.setText("2");
                text.draw();
                continue;
            }

            if (i == 1) {
                delayCount();
                text.setText("1");
                text.draw();
                continue;
            }

            if (i == 0) {
                delayCount();
                text.setText("0");
                text.draw();
            }

        }
    }

    public void delayCount() {

        int randomDelay = (int) (Math.random() * 3500);

        try {
            thread.sleep(randomDelay);
        } catch (InterruptedException s) {
            System.out.println("nice");
        }

    }


    public void timer() {

        if (timer <= 0) {

            return;

        }

        int random = (int) (Math.random() * 10);


        if (random < 3) {

            timer = timer--;

            System.out.println(timer);
        }

        System.out.println("nope");

    }

    public void setFlag() {
        this.flag = true;
    }

    public boolean isFlag() {
        return flag;
    }
}

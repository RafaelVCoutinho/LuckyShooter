package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Timer extends Grid {

    private Thread thread;
    private Picture timerDraw;

    public Timer(){

        thread = new Thread();

    }


    public void startCountdown() throws InterruptedException{

        thread.sleep(4000);
        drawTimer(110,0,"assets/ready.png");
        deleteTimer();
        delayTimer();
        drawTimer(60,-4,"assets/set.png");
        deleteTimer();
        delayTimer();
        drawTimer(110,0,"assets/bang.png");
        deleteTimer();

    }



    public void drawTimer(int adjustX, int adjustY, String source){
        timerDraw = new Picture(WIDTH_CENTER - adjustX, HEIGHT_CENTER - adjustY, source);
        timerDraw.draw();
    }


    public void deleteTimer() throws InterruptedException {
        thread.sleep(700);
        timerDraw.delete();
    }



    public void delayTimer() throws InterruptedException {

        int random = (int) (Math.random() * 5000);
        thread.sleep(random);

    }


}

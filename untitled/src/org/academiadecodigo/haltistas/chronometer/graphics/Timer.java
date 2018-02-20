package org.academiadecodigo.haltistas.chronometer.graphics;

import org.academiadecodigo.haltistas.chronometer.Game;
import org.academiadecodigo.haltistas.chronometer.graphics.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Timer extends Grid {

    private Picture timerDraw;
    private Game game;

    public Timer(Game game) {
        this.game = game;
    }

    public void startCountdown() throws InterruptedException {

        Thread.sleep(4000);
        drawTimer(110, 0, "assets/ready.png");
        deleteTimer();
        delayTimer();
        drawTimer(60, -4, "assets/set.png");
        deleteTimer();
        delayTimer();
        drawTimer(110, 0, "assets/bang.png");
        game.shotDuringTimer();
        deleteTimer();

    }


    public void drawTimer(int adjustX, int adjustY, String source) {
        timerDraw = new Picture(WIDTH_CENTER - adjustX, HEIGHT_CENTER - adjustY, source);
        timerDraw.draw();
    }


    public void deleteTimer() throws InterruptedException {
        Thread.sleep(550);
        timerDraw.delete();
    }


    public void delayTimer() throws InterruptedException {

        int random = (int) (Math.random() * 3000);
        Thread.sleep(random);

    }


}

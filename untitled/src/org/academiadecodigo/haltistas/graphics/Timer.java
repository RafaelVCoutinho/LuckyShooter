package org.academiadecodigo.haltistas.graphics;

import org.academiadecodigo.haltistas.gameEnteties.BotGame;
import org.academiadecodigo.haltistas.gameEnteties.HumanGame;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Timer extends Grid {

    private Picture timerDraw;
    private HumanGame humanGame;
    private BotGame botGame;
    private long bangTime;

    public Timer(HumanGame humanGame) {
        this.humanGame = humanGame;
    }

    public Timer(BotGame botGame) {
        this.botGame = botGame;
    }

    public void startCountdown() throws InterruptedException {

        Thread.sleep(4000);
        drawTimer(110, 0, "assets/ready.png");
        deleteTimer();
        delayTimer();
        drawTimer(60, -4, "assets/set.png");
        deleteTimer();
        delayTimer();
        botGame.shotBeforeTimer();
        drawTimer(110, 0, "assets/bang.png");
        Thread.sleep(10);
        //humanGame.shotDuringTimer();
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

    public long getBangTime() {
        return bangTime;
    }

    public void resetBangTime() {
        bangTime = 0;
    }
}

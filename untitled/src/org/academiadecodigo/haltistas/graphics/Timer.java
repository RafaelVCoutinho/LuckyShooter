package org.academiadecodigo.haltistas.graphics;

import com.sun.tools.javac.comp.Todo;
import com.sun.xml.internal.bind.v2.TODO;
import org.academiadecodigo.haltistas.game_enteties.BotGame;
import org.academiadecodigo.haltistas.game_enteties.HumanGame;
import org.academiadecodigo.haltistas.game_enteties.SuperGame;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Timer extends Grid {

    private Picture timerDraw;
    private SuperGame game;
    private long bangTime;

    public Timer(SuperGame game) {
        this.game = game;
    }

    //TODO improve bot reaction time
    public void startCountdown() throws InterruptedException {

        Thread.sleep(4000);
        drawTimer(110, 0, "assets/ready.png");
        deleteTimer();
        delayTimer();
        drawTimer(60, -4, "assets/set.png");
        deleteTimer();
        delayTimer();
        //game.shotBeforeTimer();                                               //BOT timer methoo
        drawTimer(110, 0, "assets/bang.png");
        Thread.sleep(10);
        game.shotBeforeTimer();
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

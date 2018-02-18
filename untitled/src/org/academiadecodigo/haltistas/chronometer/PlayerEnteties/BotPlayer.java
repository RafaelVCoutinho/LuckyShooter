package org.academiadecodigo.haltistas.chronometer.PlayerEnteties;

public class BotPlayer extends Player {

    public BotPlayer() {
        super("BOT");
    }

    @Override
    public void shoot() throws InterruptedException {
        int shootTime = (int) (Math.random()*2000)+ 1000;

        Thread.sleep(shootTime);

        super.shoot();
    }

}

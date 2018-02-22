package org.academiadecodigo.haltistas.chronometer.playerEnteties;

public class BotPlayer extends Player {

    public BotPlayer(String name) {
        super(name);
    }

    @Override
    public void shoot() throws InterruptedException {
        int shootTime = (int) (Math.random() * 0.00000000000000000000000005);

        Thread.sleep(shootTime);

        super.shoot();
    }

}

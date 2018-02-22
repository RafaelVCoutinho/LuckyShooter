package org.academiadecodigo.haltistas.player_enteties;

public class BotPlayer extends Player {

    private long shotTimer;

    public BotPlayer(String name) {
        super(name);
    }

    @Override
    public void shoot() {
        int shootTime = (int) (Math.random() * 4);
        System.out.println("time " + shootTime);

        try {
            Thread.sleep(150 + shootTime * 50);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        shotTimer = System.currentTimeMillis() % 100000;
        super.shoot();
    }

    public long getShotTimer() {
        return shotTimer;
    }
}

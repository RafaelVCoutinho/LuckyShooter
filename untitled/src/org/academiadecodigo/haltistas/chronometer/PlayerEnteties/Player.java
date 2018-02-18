package org.academiadecodigo.haltistas.chronometer.PlayerEnteties;


public abstract class Player {

    private boolean dead;
    private String name;
    private boolean shoot;

    public Player(String name) {
        this.name = name;
        this.dead = false;
        this.shoot = false;
    }

    public void shoot() throws InterruptedException {
        shoot = true;
    }

    public void notShot() {
        shoot = false;
    }

    public boolean isShoot() {
        return shoot;
    }

    public void killed() {
        System.out.println("matou");
        this.dead = true;
    }

    public void revive() {
        this.dead = false;
    }

    public boolean isDead() {
        return this.dead;
    }
}

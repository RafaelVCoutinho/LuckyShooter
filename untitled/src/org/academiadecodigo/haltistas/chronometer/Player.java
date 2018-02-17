package org.academiadecodigo.haltistas.chronometer;


public abstract class Player {

    private boolean dead;

    public Player() {
        this.dead = false;
    }

    public abstract void input();

    public void killed() {
        this.dead = true;
    }

    public boolean isDead() {
        return this.dead;
    }

}

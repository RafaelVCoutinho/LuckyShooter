package org.academiadecodigo.haltistas.chronometer;


public abstract class Player {

    private boolean dead;
    private String name;

    public Player(String name) {
        this.name = name;
        this.dead = false;
    }

    public void killed() {
        System.out.println("matou");
        this.dead = true;
    }

    public boolean isDead() {
        return this.dead;
    }

}

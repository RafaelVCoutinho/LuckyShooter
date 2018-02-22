package org.academiadecodigo.haltistas.player_enteties;


import org.academiadecodigo.haltistas.graphics.DrawCharacter;

public abstract class Player {

    private boolean dead;
    private String name;
    private boolean shoot;

    DrawCharacter drawCharacter;


    public Player(String name) {

        drawCharacter = new DrawCharacter();
        this.name = name;
        this.dead = false;
        this.shoot = false;

    }

    public DrawCharacter getDrawCharacter() {
        return drawCharacter;
    }

    public void shoot() {
        shoot = true;
    }


    public void notShot() {
        shoot = false;
    }


    public boolean isShoot() {
        return shoot;
    }


    public void killed() {
        this.dead = true;
    }


    public void revive() {
        this.dead = false;
    }


    public boolean isDead() {
        return this.dead;
    }
}

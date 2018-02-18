package org.academiadecodigo.haltistas.chronometer;

public class HumanPlayer extends Player {


    private boolean shoot;

    public HumanPlayer(String name) {
        super(name);
        this.shoot = false;
    }

    public void shoot() {
        System.out.println("disparei");
        this.shoot = true;
    }

    public boolean isShoot() {
        return shoot;
    }
}
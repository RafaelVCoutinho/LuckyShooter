package org.academiadecodigo.haltistas.chronometer;

public class HumanPlayer extends Player {


    private boolean shoot;

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void input() {
        if (!isShoot()) {
            shoot();
        }
    }

    public void shoot() {
        this.shoot = true;
    }

    public boolean isShoot() {
        return shoot;
    }
}
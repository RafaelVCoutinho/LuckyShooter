package org.academiadecodigo.haltistas.chronometer;

public class HumanPlayer extends Player {

    private InputHandler inputHandler;
    private boolean shoot;

    public HumanPlayer() {
        this.inputHandler = new InputHandler();
    }

    @Override
    public void input() {
        shoot();
    }

    public void shoot() {
        this.shoot = true;
    }

    public boolean isShoot() {
        return shoot;
    }
}
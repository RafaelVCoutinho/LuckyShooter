package org.academiadecodigo.haltistas.chronometer;

public class HumanPlayer extends Player {

    private InputHandler inputHandler;
    private boolean shoot;

    public HumanPlayer(String name) {
        super(name);
        this.inputHandler = new InputHandler();
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
package org.academiadecodigo.haltistas.chronometer;

public class Player {

    private String name;
    private boolean dead;
    private KeyboardTest keyboardTest;

    public Player(String name) {
        this.name = name;
        this.dead = dead;
    }

    public void shoot(Player player) {

        if (keyboardTest.isFlag()) {
            return;
        }

        if (dead) {
            return;
        }
        player.kill();

    }

    public void kill() {
        dead = true;
    }

}

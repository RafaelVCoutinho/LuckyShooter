package org.academiadecodigo.haltistas.chronometer.oldgame;

public class Player {

    private String name;
    private boolean dead;



    public Player(String name) {
        this.name = name;
        this.dead = false;
    }

    public void shoot(Player player) {


        if (this.dead) {

            System.out.println("I am dead");
            return;
        }
        System.out.println("Bang!");
        player.setDead(kill());

    }

    public Boolean kill() {
        System.out.println("dead = true");
        return dead = true;

    }

    public void setDead(boolean dead){

        this.dead = dead;
    }

    public boolean isDead(){

        return dead;

    }




}

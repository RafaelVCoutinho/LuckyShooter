package org.academiadecodigo.haltistas.chronometer;

public class Player {

    private boolean dead;
    private KeyboardTest keyboardTest;

    public void shoot(Player player){

        if(keyboardTest.isFlag()){

            return;

        }

        if(dead){
            return;
        }

        player.kill();


    }


    public void kill(){

        dead = true;

    }

}

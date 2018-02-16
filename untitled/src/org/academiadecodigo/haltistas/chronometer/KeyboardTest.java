package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardTest implements KeyboardHandler {


    private boolean flag;
    private Chronometer chronometer;
    private Player playerOne;
    private  Player playerTwo;

    public KeyboardTest() {
        flag = false;
    }

    public void test(Chronometer chronometer, Player player, Player playerTwo) throws InterruptedException {
        playerOne = player;
        this.playerTwo = playerTwo;
        this.chronometer = chronometer;
        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_X);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }

    /*public void test2(Chronometer chronometer, Player player) throws InterruptedException {
        playerTwo = player;
        this.chronometer = chronometer;
        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_K);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }*/

    public boolean isFlag() {

        return flag;

    }

    public void setFlagTrue() {

        flag = true;

    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        if (chronometer.getRunning()) {
            System.out.println("Flag is true");
            setFlagTrue();
            return;
        }

        if (!flag) {
            playerOne.shoot(playerTwo);

        }

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

}

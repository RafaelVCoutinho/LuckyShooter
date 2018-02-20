package org.academiadecodigo.haltistas.chronometer.Keyboard;

import org.academiadecodigo.haltistas.chronometer.PlayerEnteties.HumanPlayer;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.sql.Timestamp;


public class InputHandlerPlayer1 implements KeyboardHandler {


    private HumanPlayer humanPlayer;
    private long pressedKeyTime;


    public InputHandlerPlayer1(HumanPlayer humanPlayer) {
        this.humanPlayer = humanPlayer;
        this.pressedKeyTime = 200;
    }


    public void key1() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_A);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }

    public void resetPressedKeyTime(){
        this.pressedKeyTime = 200;
    }

    public long getPressedKeyTime(){
        return pressedKeyTime;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (humanPlayer.isShoot()) {
            return;
        }
        System.out.println("A");

        try {

            pressedKeyTime = System.currentTimeMillis() % 100;
            System.out.println("Player One " + pressedKeyTime);
            humanPlayer.shoot();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
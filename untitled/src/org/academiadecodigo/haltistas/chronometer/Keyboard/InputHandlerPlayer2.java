package org.academiadecodigo.haltistas.chronometer.Keyboard;

import org.academiadecodigo.haltistas.chronometer.PlayerEnteties.HumanPlayer;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class InputHandlerPlayer2 implements KeyboardHandler {

    private HumanPlayer humanPlayer;
    private long pressedKeyTime;


    public InputHandlerPlayer2(HumanPlayer humanPlayer) {
        this.humanPlayer = humanPlayer;
        pressedKeyTime = 0;
    }


    public void key2() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_L);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }

    public void resetPressedKeyTime() {
        this.pressedKeyTime = 200;
    }

    public long getPressedKeyTime() {
        return pressedKeyTime;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (humanPlayer.isShoot()) {
            return;
        }
        System.out.println("L");

        try {
            pressedKeyTime = System.currentTimeMillis() % 100;
            System.out.println("PLayer Two " + pressedKeyTime);
            humanPlayer.shoot();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}


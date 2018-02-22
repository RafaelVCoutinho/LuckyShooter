package org.academiadecodigo.haltistas.chronometer.keyboard;

import org.academiadecodigo.haltistas.chronometer.playerEnteties.HumanPlayer;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class InputHandlerPlayer2 implements KeyboardHandler {

    private HumanPlayer humanPlayer;
    private long pressedKeyTime;
    private boolean pressedKey;


    public InputHandlerPlayer2(HumanPlayer humanPlayer) {
        this.humanPlayer = humanPlayer;
        pressedKeyTime = 0;
        pressedKey = false;
    }


    public void key2() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_L);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }

    public void resetPressedKeyTime() {
        this.pressedKeyTime = 0;
    }

    public long getPressedKeyTime() {
        return pressedKeyTime;
    }

    public void resetPressedKey() {
        this.pressedKey = false;
    }

    public boolean isPressedKey() {
        return pressedKey;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (humanPlayer.isShoot()) {
            return;
        }
        System.out.println("L");

        try {

            pressedKeyTime = System.currentTimeMillis();
            System.out.println("PLayer Two " + pressedKeyTime);
            humanPlayer.shoot();
            pressedKey = true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}


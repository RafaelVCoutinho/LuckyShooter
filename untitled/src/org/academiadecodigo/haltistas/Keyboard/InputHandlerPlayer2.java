package org.academiadecodigo.haltistas.keyboard;

import org.academiadecodigo.haltistas.player_enteties.HumanPlayer;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class InputHandlerPlayer2 implements KeyboardHandler {


    private HumanPlayer humanPlayer;
    private long pressedKeyTime;


    public InputHandlerPlayer2(HumanPlayer humanPlayer) {
        this.humanPlayer = humanPlayer;
        this.pressedKeyTime = 200000;
    }


    public void key2() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_L);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }

    public void resetPressedKeyTime() {
        this.pressedKeyTime = 200000;
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


        pressedKeyTime = System.currentTimeMillis() % 100000;
        System.out.println("Player Two " + pressedKeyTime);
        humanPlayer.shoot();

    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}


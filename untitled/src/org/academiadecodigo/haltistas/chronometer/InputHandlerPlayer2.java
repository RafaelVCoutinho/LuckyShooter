package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class InputHandlerPlayer2 implements KeyboardHandler {

    private HumanPlayer humanPlayer;

    public InputHandlerPlayer2(HumanPlayer humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    public void key2() {

        Keyboard k = new Keyboard(this);


        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_L);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (humanPlayer.isShoot()){
            return;
        }
        System.out.println("L");
        humanPlayer.shoot();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}


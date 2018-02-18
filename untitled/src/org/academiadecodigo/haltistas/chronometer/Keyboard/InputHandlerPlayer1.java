package org.academiadecodigo.haltistas.chronometer.Keyboard;

import org.academiadecodigo.haltistas.chronometer.PlayerEnteties.HumanPlayer;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class InputHandlerPlayer1 implements KeyboardHandler {

    private HumanPlayer humanPlayer;

    public InputHandlerPlayer1(HumanPlayer humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    public void key1() {

        Keyboard k = new Keyboard(this);

        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_A);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (humanPlayer.isShoot()) {
            return;
        }
        System.out.println("A");
        try {
            humanPlayer.shoot();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}

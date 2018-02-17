package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class InputHandler implements KeyboardHandler {

    private HumanPlayer humanplayer;
    private HumanPlayer humanPlayer2;

    public void key() throws InterruptedException {

        Keyboard k = new Keyboard(this);

        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_A);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_L);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_UP);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_DOWN);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_R);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_A:
                this.humanplayer.input();
                break;
            case KeyboardEvent.KEY_L:
                this.humanPlayer2.input();
                break;
            default:
                System.out.println("FODETE JOGADOR DA MERDA FIZESTE PIÇA!!!!");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}

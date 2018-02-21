package org.academiadecodigo.haltistas.chronometer.Keyboard;

import org.academiadecodigo.haltistas.chronometer.graphics.Menu;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardMenu implements KeyboardHandler {


    private Keyboard k;
    private KeyboardEvent event;
    private Menu menu;
    private boolean menuChoice;

    public KeyboardMenu( Menu menu) {

        menuChoice = false;
        this.menu = menu;

    }


    public void menuUp() {
        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_UP);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

    }

    public void menuDown() {
        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_DOWN);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }

    public void menuEnter() {

        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {


            case KeyboardEvent.KEY_UP:
                menu.moveMenuPointerUp();
                break;
            case KeyboardEvent.KEY_DOWN:
                menu.moveMenuPointerDown();
                break;
            case KeyboardEvent.KEY_SPACE:
                menuChoice = true;
                break;
            default:
                System.out.println("Ups!");
                break;


        }


    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}


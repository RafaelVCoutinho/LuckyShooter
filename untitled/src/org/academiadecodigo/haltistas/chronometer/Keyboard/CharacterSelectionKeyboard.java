package org.academiadecodigo.haltistas.chronometer.Keyboard;

import org.academiadecodigo.haltistas.chronometer.graphics.CharacterSelectionMenu;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class CharacterSelectionKeyboard implements KeyboardHandler {

    private int charPosition;
    private CharacterSelectionMenu characterSelectionMenu;
    private boolean choice;


    public CharacterSelectionKeyboard(CharacterSelectionMenu characterSelectionMenu) {

        charPosition = 0;
        this.characterSelectionMenu = characterSelectionMenu;
        choice = false;

    }


    public void selectRight() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_RIGHT);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

    }

    public void selectLeft() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_LEFT);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

    }


    public void select() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_X);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }

    public void slectionKeys() {

        selectRight();
        selectLeft();
        select();
    }

    public int getCharPosition() {

        return charPosition;

    }

    public boolean getChoice(){
        return  choice;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                if (charPosition > 3) {
                    break;
                }
                characterSelectionMenu.right();
                charPosition += 1;
                System.out.println(charPosition);
                break;

            case KeyboardEvent.KEY_LEFT:
                if (charPosition < 0) {
                    break;
                }
                characterSelectionMenu.left();
                charPosition -= 1;
                System.out.println(charPosition);
                break;

            case KeyboardEvent.KEY_X:
                choice = true;
                break;

            default:
                System.out.println("Ups");
                break;


        }

    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

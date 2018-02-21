package org.academiadecodigo.haltistas.chronometer.Keyboard;

import org.academiadecodigo.haltistas.chronometer.graphics.Menu;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardMenu implements KeyboardHandler {


    private Menu menu;
    private boolean menuChoice;
    private boolean menuDeleted;
    private boolean playerVsPlayer;

    public KeyboardMenu( Menu menu) {

        playerVsPlayer = true;
        this.menuDeleted = false;
        this.menuChoice = false;

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

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

    }

    public void menuKeys(){
        menuUp();
        menuDown();
        menuEnter();
    }

    public boolean getMenuChoice(){
        return menuChoice;
    }

    public boolean getMenuDeleted(){

        return menuDeleted;

    }

    public void menuChoiceFalse(){
        menuChoice = false;
    }

    public void menuDeletedTrue(){
        menuDeleted = true;
    }

    public void menuDeletedFalse(){

        menuDeleted = false;

    }

    public boolean getPlayerVsPlayer(){
        return playerVsPlayer;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {


            case KeyboardEvent.KEY_UP:
                menu.moveMenuPointerUp();
                playerVsPlayer = true;
                System.out.println("estou true");
                break;
            case KeyboardEvent.KEY_DOWN:
                menu.moveMenuPointerDown();
                playerVsPlayer = false;
                System.out.println("estou false");
                break;
            case KeyboardEvent.KEY_SPACE:
                menuChoice = true;
                menuDeleted = true;
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


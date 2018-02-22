package org.academiadecodigo.haltistas.keyboard;

import org.academiadecodigo.haltistas.graphics.CharacterSelectionMenu;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class CharacterSelectionKeyboard implements KeyboardHandler {

    private int playerOneCharPosition;
    private int playerTwoCharPosition;

    private CharacterSelectionMenu characterSelectionMenu;

    private boolean playerOneChoice;
    private boolean playerTwoChoice;


    public CharacterSelectionKeyboard(CharacterSelectionMenu characterSelectionMenu) {

        playerOneCharPosition = 0;
        this.characterSelectionMenu = characterSelectionMenu;

        playerOneChoice = false;
        playerTwoChoice = false;

    }


    public void playerTwoSelectRight() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_8);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

    }

    public void playerTwoSelectLeft() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_9);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

    }


    public void playerTwoSelect() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_0);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }

    public void playerOneSelectRight() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_1);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

    }

    public void playerOneSelectLeft() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_2);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

    }


    public void playerOneSelect() {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_3);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }


    public void playerOneSelectionKeys() {

        playerOneSelectRight();
        playerOneSelectLeft();
        playerOneSelect();
    }

    public void playerTwoSelectionKeys(){

        playerTwoSelectRight();
        playerTwoSelectLeft();
        playerTwoSelect();

    }

    public int getPlayerOneCharPosition() {

        return playerOneCharPosition;

    }

    public int getPlayerTwoCharPosition(){

        return playerTwoCharPosition;

    }

    public boolean getPlayerOneChoice() {
        return playerOneChoice;
    }

    public boolean getPlayerTwoChoice(){
        return playerTwoChoice;
    }

    public void playerOneChoiceFalse(){
        playerOneChoice = false;
    }

    public void playerTwoChoiceFalse(){
        playerTwoChoice = false;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(playerOneChoice && playerTwoChoice){
            return;
        }

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_1:
                if (playerOneCharPosition > 1) {
                    break;
                }
                characterSelectionMenu.playerOneDown();
                playerOneCharPosition += 1;
                System.out.println(playerOneCharPosition);
                break;

            case KeyboardEvent.KEY_2:
                if (playerOneCharPosition < 1) {
                    break;
                }
                characterSelectionMenu.playerOneUp();
                playerOneCharPosition -= 1;
                System.out.println(playerOneCharPosition);
                break;

            case KeyboardEvent.KEY_3:
                playerOneChoice = true;
                break;

            case KeyboardEvent.KEY_8:
                if(playerTwoCharPosition > 1){
                    break;
                }
                playerTwoCharPosition += 1;
                characterSelectionMenu.playerTwoDown();
                break;

            case KeyboardEvent.KEY_9:
                if(playerTwoCharPosition < 1){
                    break;
                }
                playerTwoCharPosition -= 1;
                characterSelectionMenu.playerTwoUp();
                break;

            case KeyboardEvent.KEY_0:
                playerTwoChoice = true;
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

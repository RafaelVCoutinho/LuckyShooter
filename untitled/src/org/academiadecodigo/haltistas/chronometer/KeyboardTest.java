package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardTest implements KeyboardHandler {

    private boolean flag;

    public KeyboardTest(){
        flag = false;
    }

    public void test() throws InterruptedException {
        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_X);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }

    public void test2() throws InterruptedException {
        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_K);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
    }

    public boolean isFlag(){

        return flag;

    }

    public void setFlagTrue(){

        flag = true;

    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

}

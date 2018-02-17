package org.academiadecodigo.haltistas.chronometer;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardTest2 implements KeyboardHandler{

    private boolean flag;
    private Chronometer chronometer;
    private Canvas rectangle;
    private KeyboardTest keyboardTest;

    public KeyboardTest2(){

        flag = false;

    }

    public void test2(Chronometer chronometer, Player player, Player playerTwo, Canvas canvas, KeyboardTest keyboardTest){
        this.keyboardTest = keyboardTest;
        this.chronometer = chronometer;
        rectangle = canvas;
        Keyboard k2 = new Keyboard(this);
        KeyboardEvent event2 = new KeyboardEvent();
        event2.setKey(KeyboardEvent.KEY_M);
        event2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k2.addEventListener(event2);

    }

    public void setFlagTrue(){


        flag = true;

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(chronometer.getRunning()){

            System.out.println("Flag2 is true");
            setFlagTrue();
            return;
        }

        if(!flag){

            System.out.println("Tau2");
            rectangle.removePlayerRectangle(rectangle.getPlayerOne());
            rectangle.deadPlayerRectangleOne(rectangle.getPlayerOne());
            keyboardTest.setFlagTrue();

        }



    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

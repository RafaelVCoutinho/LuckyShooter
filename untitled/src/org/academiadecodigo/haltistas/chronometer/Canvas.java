package org.academiadecodigo.haltistas.chronometer;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;




public class Canvas {

    private int col;
    private int row;



    private Rectangle rectangle;
    private Rectangle playerOne;
    private Rectangle playerTwo;

    public Canvas() {

        this.col = 700;
        this.row = 500;

        //canvas
        this.rectangle = new Rectangle(10, 10, 700, 500);
        this.rectangle.draw();

        //players
        this.playerOne = new Rectangle(50, 300, 50, 100 );
        this.playerTwo = new Rectangle(620, 300, 50, 100);
        this.playerOne.setColor(Color.BLUE);
        this.playerTwo.setColor(Color.GREEN);
        this.playerOne.fill();
        this.playerTwo.fill();

    }

   public void init(){

        this.rectangle = new Rectangle(10, 10, 700, 500);
        this.rectangle.draw();

   }

    public double getCol(){
        return this.col / 2;

    }

    public double getRow(){

        return this.row / 2;

    }

    public void removePlayerRectangle(Rectangle rectangle){

        rectangle.delete();
        init();

    }

    public void deadPlayerRectangleOne(Rectangle rectangle){

        rectangle.delete();
        rectangle = new Rectangle(30, 350, 100, 50);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();

    }

    public  void deadPlayerRectangleTwo(Rectangle rectangle){

        rectangle.delete();
        rectangle = new Rectangle(550, 350, 100, 50);
        rectangle.setColor(Color.GREEN);
        rectangle.fill();

    }

    public Rectangle getPlayerOne() {
        return playerOne;
    }

    public Rectangle getPlayerTwo() {
        return playerTwo;
    }
}

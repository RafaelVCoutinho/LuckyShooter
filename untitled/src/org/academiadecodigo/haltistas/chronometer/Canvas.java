package org.academiadecodigo.haltistas.chronometer;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;




public class Canvas {

    private int col;
    private int row;

    public static Canvas canvas = new Canvas();
    private Rectangle rectangle;

    public Canvas() {

        this.col = 700;
        this.row = 500;

        this.rectangle = new Rectangle(10, 10, 700, 500);

        this.rectangle.draw();

    }

    public static Canvas getCanvas(){

        return canvas;

    }

    public double getCol(){
        return this.col / 2;

    }

    public double getRow(){

        return this.row / 2;

    }





}

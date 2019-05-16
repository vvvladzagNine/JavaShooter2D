package com.vladislavZag.shooter;

import java.awt.*;

/**
 * Created by vladislavZag on 08.12.2017.
 */
public abstract class Figure {
    protected int x;
    protected int y;
    protected Color color;


    public Figure(int x,int y,Color color){
        this.color=color;
        this.x=x;
        this.y=y;
    }
    public abstract void draw(Graphics2D g);

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Color getColor() {
        return color;
    }
}
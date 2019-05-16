package com.vladislavZag.shooter;
import java.awt.*;
/**
 * Created by vladislavZag on 03.07.17.
 */
public abstract class Drop  {
    //Fields
    protected double x;
    protected double y;
    protected double dx;
    protected double dy;
    protected int a;
    protected Color color;
    //Constructor
    public Drop(double x,double y,double dx, double dy){
        this.dx=dx*0.6;
        this.dy=dy*0.6;
        this.x=x;
        this.y=y;
        a = 8;

    }
    //Functions
    public double getX(){

        return x;
    }
    public double getY(){

        return y;
    }
    public int getA(){

        return a;
    }
    public abstract void addSth();
    public void update(){
        x+=dx;
        y+=dy;


    }
    public void draw(Graphics2D g){
        g.setColor(Color.white);
        g.fillRect((int)x-a/2,(int)y-a/2,a,a);
        g.setStroke(new BasicStroke(2));
        g.setColor(color);
        g.drawRect((int)x-a/2,(int)y-a/2,a,a);
        g.setStroke(new BasicStroke(1));
    }
}

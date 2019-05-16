package com.vladislavZag.shooter;

import java.awt.*;
import java.util.Random;

/**
 * Created by vladislavZag on 17.07.17.
 */
public class Meat {
    //Fields
    private final int VISDIST = 70;
    private double x;
    private double y;
    double X;
    double Y;
    private double dx;
    private double dy;
    private int r;
    private Color color;
    private int speed;
    //Constructor

    public Meat(double x,double y,Color color,double dx,double dy){
        this.x=x;
        this.X=x;
        this.y=y;
        this.Y=y;
        this.color=new Color(color.getRed(),color.getGreen(),color.getBlue(),150);
        speed = new Random().nextInt(7)+3;
        double angle = Math.toRadians(Math.random()*360);
        this.dy = (Math.sin(angle)*speed)+dy;
        this.dx = (Math.cos(angle)*speed)+dx;
        r=2;
    }

    //Functions
    public void update(){
        x+=dx;
        y-=dy;
        double dist = Math.sqrt((x-X)*(x-X)+(y-Y)*(y-Y));
        int alpha = (int)(255 - 255*dist/(VISDIST+r));
        if(alpha<0)alpha=0;
        color = new Color(color.getRed(),color.getGreen(),color.getBlue(),alpha);
    }
    public double getX(){

        return x;
    }
    public double getY(){

        return y;
    }
    public boolean remove(){
        if(y<0 || y > GamePanel.HEIGHT || x<0 || x>GamePanel.WIDTH){
            return true;
        }
        return false;
    }



    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int)(x-r),(int)(y-r),r*2,2*r);
        g.setStroke(new BasicStroke(3));
        g.setColor(color.darker().darker());
        g.drawOval((int)x-r,(int)y-r,2*r,2*r);
        g.setStroke(new BasicStroke(1));

    }
}

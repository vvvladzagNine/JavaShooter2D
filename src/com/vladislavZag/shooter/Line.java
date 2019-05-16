package com.vladislavZag.shooter;

import java.awt.*;

/**
 * Created by vladislavZag on 08.12.2017.
 */
public class Line extends Figure {
    double angle;
    int l;
    public Line(int x, int y, Color color, int l, double angle) {
        super(x, y, color);
        this.l=l;
        this.angle=angle;
    }

    @Override
    public void draw(Graphics2D g) {
        int lx= (int)(l * Math.cos(angle));
        int ly= (int)(l * Math.sin(angle));
        int x1= x + lx;
        int y1= y + ly;
        g.setStroke(new BasicStroke(3));
        g.setColor(color);
        g.drawLine(x,y,x1,y1);
    }



    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }
}

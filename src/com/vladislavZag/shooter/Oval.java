package com.vladislavZag.shooter;

import java.awt.*;

/**
 * Created by vladislavZag on 08.12.2017.
 */
public class Oval extends Figure {
    private int a2;
    private int b2;
    private boolean fd;

    public Oval(int x, int y, Color color, int a2, int b2, boolean fd) {
        super(x, y, color);
        this.a2=a2;
        this.b2=b2;
        this.fd = fd;

    }

    public int getA2() {
        return a2;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }

    public int getB2() {
        return b2;
    }

    public void setB2(int b2) {
        this.b2 = b2;
    }

    public boolean isFd() {
        return fd;
    }

    public void setFd(boolean fd) {
        this.fd = fd;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        if(fd)
            g.fillOval(x-a2/2,y-a2/2,a2,b2);
        else{
            g.setColor(color.darker());
            g.setStroke(new BasicStroke(3));
            g.drawOval(x-a2/2,y-a2/2,a2,b2);}
    }
}

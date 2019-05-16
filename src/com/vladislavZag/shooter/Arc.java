package com.vladislavZag.shooter;

import java.awt.*;

/**
 * Created by vladislavZag on 08.12.2017.
 */
public class Arc extends Figure {
    private int r;
    private int startA;
    private int arcA;
    private boolean fd;
    public Arc(int x, int y, Color color, int r, int startA, int arcA, boolean fd)  {
        super(x, y, color);
        this.r=r;
        this.startA=startA;
        this.arcA=arcA;
        this.fd = fd;
    }

    @Override
    public void draw(Graphics2D g) {

        g.setColor(color);
        if(fd)
            g.fillArc(x-r,y-r,2*r,2*r,startA,arcA);
        else {
            g.setColor(color.darker());
            g.setStroke(new BasicStroke(3));
            g.drawArc(x - r, y - r, 2 * r, 2 * r, startA, arcA);
        }

    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getStartA() {
        return startA;
    }

    public void setStartA(int startA) {
        this.startA = startA;
    }

    public int getArcA() {
        return arcA;
    }

    public void setArcA(int arcA) {
        this.arcA = arcA;
    }

    public boolean isFd() {
        return fd;
    }

    public void setFd(boolean fd) {
        this.fd = fd;
    }
}


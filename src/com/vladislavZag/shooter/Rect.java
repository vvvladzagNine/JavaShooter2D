package com.vladislavZag.shooter;

import java.awt.*;

/**
 * Created by vladislavZag on 08.12.2017.
 */
public class Rect extends Figure {
    private int width;
    private int height;
    private boolean fd;
    public Rect(int x, int y, Color color, int width, int height, boolean fd) {
        super(x, y, color);
        this.width=width;
        this.height=height;
        this.fd=fd;

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        if(fd){
            g.fillRect(x-width/2,y-height/2,width,height);}
        else{
            g.setColor(color.darker());
            g.setStroke(new BasicStroke(3));
            g.drawRect(x-width/2,y-height/2,width,height);}
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

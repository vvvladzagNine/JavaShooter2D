package com.vladislavZag.shooter;

import java.awt.*;

/**
 * Created by vladislavZag on 01.12.2017.
 */
public class Treasure {
    public boolean isEmpty;
    protected int x;
    protected int y;

    public Treasure(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void draw(Graphics2D g){
        g.setColor(new Color(255, 229, 71));
        g.drawRect(x,y,50,50);

    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }

}

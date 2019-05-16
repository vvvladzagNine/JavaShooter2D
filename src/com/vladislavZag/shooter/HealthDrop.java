package com.vladislavZag.shooter;

import java.awt.*;

/**
 * Created by vladislavZag on 11.07.17.
 */
public class HealthDrop extends Drop {
    public HealthDrop(double x, double y,double dx,double dy){
        super(x,y,dx,dy);
        super.color= Color.WHITE;
    }
    public void draw(Graphics2D g){
        g.setColor(GamePanel.player.getColor1());
        g.fillRect((int)x-a/2,(int)y-a/2,a,a);
        g.setStroke(new BasicStroke(2));
        g.setColor(color);
        g.drawRect((int)x-a/2,(int)y-a/2,a,a);
        g.setStroke(new BasicStroke(1));
    }
    public void addSth(){
        Player.addHealth(4);
    }
}

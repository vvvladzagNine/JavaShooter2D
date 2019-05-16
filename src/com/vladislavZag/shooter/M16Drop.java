package com.vladislavZag.shooter;

import java.awt.*;

public class M16Drop extends Drop {

    //Constructor
    public M16Drop(double x, double y, double dx,double dy){
        super(x,y,dx,dy);
        super.color = new Color(160, 156,225,255);

    }
    //Functions
    public void addSth(){
        Player.m16Ammo+=50;
    }
}

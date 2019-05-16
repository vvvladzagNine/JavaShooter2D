package com.vladislavZag.shooter;

import java.awt.*;

public class RpkDrop extends Drop {

    //Constructor
    public RpkDrop(double x, double y,double dx,double dy){
        super(x,y,dx,dy);
        super.color = color = new Color(200, 110, 166,255);

    }
    //Functions
    public void addSth(){
        Player.rifleAmmo+=50;
    }
}


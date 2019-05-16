package com.vladislavZag.shooter;

import java.awt.*;

public class SmgDrop extends Drop {

    //Constructor
    public SmgDrop(double x, double y,double dx, double dy){
        super(x,y,dx,dy);
        super.color = new Color(200, 3, 154,255);

    }
    //Functions
    public void addSth(){
        Player.smgAmmo+=60;
    }
}

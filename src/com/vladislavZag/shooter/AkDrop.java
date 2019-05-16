package com.vladislavZag.shooter;

import java.awt.*;

public class AkDrop extends Drop {

    //Constructor
    public AkDrop(double x, double y,double dx,double dy){
        super(x,y,dx,dy);
        super.color = new Color(184, 86, 10,255);

    }
    //Functions
    public void addSth(){
        Player.akAmmo+=60;
    }
}
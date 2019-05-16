package com.vladislavZag.shooter;

import java.awt.*;

/**
 * Created by vladislavZag on 11.07.17.
 */
public class LazerDrop extends Drop {
    //Constructor
    public LazerDrop(double x, double y,double dx,double dy){
        super(x,y,dx,dy);
        super.color = new Color(255,0,0,255);

    }
    //Functions
    public void addSth(){
        Player.lazerAmmo+=250;
    }
}

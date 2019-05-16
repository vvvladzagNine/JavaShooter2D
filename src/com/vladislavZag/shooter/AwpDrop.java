package com.vladislavZag.shooter;

import java.awt.*;

/**
 * Created by vladislavZag on 15.07.17.
 */
public class AwpDrop extends Drop {
    //Constructor
    public AwpDrop(double x, double y,double dx,double dy){
        super(x,y,dx,dy);
        super.color = new Color(105,68,56,255);

    }
    //Functions
    public void addSth(){
        Player.awpAmmo+=25;
    }
}

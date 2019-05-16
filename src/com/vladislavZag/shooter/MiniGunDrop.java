package com.vladislavZag.shooter;

import java.awt.*;

/**
 * Created by vladislavZag on 11.07.17.
 */
//color = new Color(136, 225, 157,255);
public class MiniGunDrop extends Drop {


    //Constructor
    public MiniGunDrop(double x, double y,double dx,double dy){
        super(x,y,dx,dy);
        super.color = color = new Color(147, 225, 123,255);

    }
    //Functions
    public void addSth(){
        Player.minigunAmmo+=200;
    }
}

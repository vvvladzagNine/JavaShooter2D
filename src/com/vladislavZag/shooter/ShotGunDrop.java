package com.vladislavZag.shooter;
import java.awt.*;

public class ShotGunDrop extends Drop {

    //Constructor
    public ShotGunDrop(double x, double y,double dx,double dy){
        super(x,y,dx,dy);
        super.color = new Color(0, 93, 9,255);

    }
    //Functions
    public void addSth(){
        Player.shotGunAmmo+=20;
    }
}

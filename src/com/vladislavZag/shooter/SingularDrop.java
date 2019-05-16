package com.vladislavZag.shooter;

import java.awt.*;
import java.util.Random;

/**
 * Created by vladislavZag on 11.07.17.
 */
public class SingularDrop extends Drop {
    //Constructor
    public SingularDrop(double x, double y,double dx,double dy){
        super(x,y,dx,dy);
        super.color = new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);

    }
    //Functions
    public void addSth(){
        Player.singularAmmo+=new Random().nextInt(250)+5;
    }
    public void update(){
        super.update();
        color = new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);
    }
}

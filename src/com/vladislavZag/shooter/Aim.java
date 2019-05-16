package com.vladislavZag.shooter;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by vladislavZag on 08.12.2017.
 */
public class Aim {
    private ArrayList<Figure> figures;
    int x;
    int y;
    public Aim(){
        figures=new ArrayList<>();
        x=GamePanel.mouseX;
        y=GamePanel.mouseY;
        Figure f1 = new Oval(x+14,y+13,new Color(34,95,170),20,22,false);
        Figure f2 = new Line(x+14,y+0,new Color(34,95,170),32,1.5533430342749535);
        Figure f3 = new Line(x+26,y+14,new Color(34,95,170),26,3.159045946109736);
        figures.add(f1);
        figures.add(f2);
        figures.add(f3);
    }

    public void draw(Graphics2D g){
        for(Figure f:figures){
            f.draw(g);
        }
    }
    public void update(){
        x=GamePanel.mouseX;
        y=GamePanel.mouseY;
        figures.get(0).setX(x+14);figures.get(1).setY(y+13);
        figures.get(1).setX(x+14);figures.get(0).setY(y+0);
        figures.get(2).setX(x+26);figures.get(2).setY(y+14);
    }
}

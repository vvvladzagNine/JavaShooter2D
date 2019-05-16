package com.vladislavZag.shooter;
import java.awt.*;
/**
 * Created by vladislavZag on 29.06.17.
 */
public class Block {


    //Fields

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;
    private Rectangle upBorder;
    private Rectangle downBorder;
    private Rectangle leftBorder;
    private Rectangle rightBorder;


    //Constructor

    public Block(int x, int y,int width,int height, Color c){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        color = c;
        upBorder = new Rectangle(x+3,y,width-3,2);
        downBorder = new Rectangle(x+3,y+height,width-3,2);
        leftBorder = new Rectangle(x,y+3,2,height-3);
        rightBorder = new Rectangle(x+width,y+3,2,height-3);

    }

    //Functions

    public void update(){

    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(x,y,(int)width,(int)height);
        g.setStroke(new BasicStroke(3));
        g.setColor(color.darker());
        g.drawRect(x,y,(int)width,(int)height);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public Rectangle getUpBorder(){
        return upBorder;
    }
    public Rectangle getDownBorder(){
        return downBorder;
    }
    public Rectangle getLeftBorder(){
        return leftBorder;
    }
    public Rectangle getRightBorder(){
        return rightBorder;
    }



}

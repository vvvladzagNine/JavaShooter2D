package com.vladislavZag.shooter;

import java.awt.*;

/**
 * Created by vladislavZag on 27.11.2017.
 */
public class Darkness {
    private static int backTime;
    private static int theBackTime;

    public static int red;
    public static int green;
    public static int blue;

    private Color color;
    private Color color2;
    private  int vision;
    public  int lowLight;
    public  int llIter;
    public boolean ld;



    public Darkness(){
        ld=false;
        color=new Color(10, 10, 10, 255);
        color2=new Color(10, 10, 10, 150);
        //new Color(233, 232, 235,255);
        backTime=0;
        theBackTime=10;
        vision=180;
        lowLight=44;
        llIter=6;
    }


    public void update(){

    }

    public void draw(Graphics2D g){
        g.setColor(color);
        //g.fillRect(0,0,GamePanel.WIDTH,GamePanel.HEIGHT);
        Player p = GamePanel.player;
        int x12=0,y12=0;

        int w1 = (int)p.getX()-vision;
        int h1 = GamePanel.HEIGHT;

        int w2 = (int)GamePanel.WIDTH;
        int h2 = (int)p.getY()-vision;

        int x3=0;
        int y3=(int)p.getY()+vision;
        int w3 = GamePanel.WIDTH;
        int h3 = GamePanel.WIDTH-(int)p.getY()-vision;

        int x4 =(int)p.getX()+vision;
        int y4=0;
        int h4=GamePanel.HEIGHT;
        int w4=GamePanel.WIDTH-(int)p.getX()-vision;

        g.fillRect(x12,y12,w1,h1);
        g.fillRect(x12,y12,w2,h2);
        g.fillRect(x3,y3,w3,h3);
        g.fillRect(x4,y4,w4,h4);


        int XO = (int)( p.getX() -1.2*vision);
        int YO = (int)( p.getY() -1.2*vision);
        g.setStroke(new BasicStroke(70));
        g.drawOval(XO,YO,(int)(vision*2.4),(int)(vision*2.4));
        g.setColor(color2);
        if((Player.isFiring | Player.isFiring2) & Player.reload>=Bullet.gunSpeed-1
                & Player.reload<=Bullet.gunSpeed+3 & Player.currentAmmo>0){
            lowLight=30;
        }
        else {
            lowLight=44;
        }


       /*for(int i =1;i<6;i++){

            int lowL=lowLight*i;
            int X0 = (int) p.getX() - vision;
            int Y0 = (int) p.getY() - vision;

            int w12 = vision * 2;
            int h12 = lowL;

            int h22 = vision * 2 - lowL;
            int w22 = lowL;

            g.fillRect(X0, Y0, w12, h12);
            g.fillRect(X0, Y0 + (vision * 2) - lowL, w12, h12);
            g.fillRect(X0, Y0 + lowL, w22, h22 - lowL);
            g.fillRect(X0 + (vision * 2) - lowL, Y0 + lowL, w22, h22 - lowL);

        }*/
        for(int i =1;i<llIter;i++){


            int X = (int)( p.getX() -1.2*vision);
            int Y = (int)( p.getY() -1.2*vision);
            g.setStroke(new BasicStroke(100+i*lowLight));
            g.drawOval(X,Y,(int)(vision*2.4),(int)(vision*2.4));



        }



    }
    public void increaceLowLight(){
        lowLight+=2;
    }
    public void decreaceLowLight(){
        lowLight-=2;
    }
    public void increaceLlIter(){
        llIter+=2;
    }
    public void decreaceLlIter(){
        llIter-=2;
    }
    public void setColor(Color color){
        this.color=color;
    }
}

package com.vladislavZag.shooter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
/**
 * Created by vladislavZag on 13.06.17.
 */
public class Player {
    //Fields
    private double x;
    private double y;
    private int r;
    public static final int MAXHP= 25;

    public static int reload;



    private static int health;

    public static final int PISTOL = 1;
    public static final int SHOTGUN = 2;
    public static final int SMG = 3;
    public static final int AK = 4;
    public static final int M16 = 5;
    public static final int RIFLE = 6;
    public static final int MINIGUN = 7;
    public static final int AWP = 8;
    public static final int LAZER = 9;
    public static final int SINGULARGUN = 0;

    public static int myGun;




    private double dx; // Move Coef
    private double dy;
    private double ddy;
    private double ddx;
    private int speed;

    private Color color1;
    private Color color2;
    private Color colorLight;
    private Color light = new Color(251, 255, 2, 26);

    public static  boolean up;
    public static  boolean down;
    public static boolean left;
    public static  boolean right;

    public static boolean isFiring;
    public static boolean isFiring2;

    public final static boolean isMove = true;
    public static int shotGunAmmo;
    public static int smgAmmo;
    public static int akAmmo;
    public static int m16Ammo;
    public static int rifleAmmo;
    public static int minigunAmmo;
    public static int awpAmmo;
    public static int lazerAmmo;
    public static int singularAmmo;
    public static int currentAmmo;


    //Constructor

    public Player(){
        x = GamePanel.WIDTH / 2;
        y = GamePanel.HEIGHT / 2;
        //x = 30;
        //y = 30;

        r=5;

        speed = 5;

        dx =0;
        dy=0;

        color2 = new Color(0, 2, 169,255);
        color1 = new Color(40, 89, 200,255);
        colorLight = new Color(251, 255, 2,255);

        up = false;
        down = false;
        left = false;
        right = false;



        myGun=PISTOL;

        shotGunAmmo=0;
        smgAmmo=0;
        akAmmo=0;
        m16Ammo=0;
        rifleAmmo=0;
        minigunAmmo=300;
        awpAmmo=0;
        lazerAmmo=0;
        singularAmmo=0;

        isFiring=false;
        health = 20;

        reload=0;
    }

    public Player(int health,int x,int y,int shotGun,
                  int smg,int ak,int m16,int rifle, int minigun, int awp, int lazer, int singular ){
        this.x = x;
        this.y = y;

        r=5;

        speed = 5;

        dx =0;
        dy=0;

        color2 = new Color(0, 2, 169,255);
        color1 = new Color(40, 89, 200,255);
        colorLight = new Color(251, 255, 2,255);

        up = false;
        down = false;
        left = false;
        right = false;



        myGun=PISTOL;

        shotGunAmmo=shotGun;
        smgAmmo=smg;
        akAmmo=ak;
        m16Ammo=m16;
        rifleAmmo=rifle;
        minigunAmmo=minigun;
        awpAmmo=awp;
        lazerAmmo=lazer;
        singularAmmo=singular;

        isFiring=false;
        this.health =health;

        reload=0;
    }

    //Functions
    public Color getColor1(){return color1;}

    public double getX(){
        return x;
    }

    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }

    public double getY(){
        return y;
    }

    public int getR(){
        return  r;
    }

    public int getHealth(){

        return health;
    }
    public static void addHealth(int a){
        health+=a;
    }




    public static void upSpeed(){
        Bullet.gunSpeed-=2;
    }
    public static void downSpeed(){
        Bullet.gunSpeed+=2;
    }


    public void hit(){
        health--;
    }

    public boolean remove(){
        if(health<=0){
            return true;
        }
        return false;
    }
    public void HealthColor(){
        if(health>MAXHP)health=MAXHP;
        if(health<10 && health>5) {
            color1 = new Color(56, 140, 200,255);
        }
        else if(health<=5){
            color1 = new Color(109, 188, 200,255);
        }
        else color1 = new Color(40, 89, 200,255);
    }




    public void update(){


       if(health<1){
           JOptionPane.showMessageDialog(null, "You have lost :(");
           GamePanel.wave.setWaveNumber(1);
           for(int i =0;i<GamePanel.enemies.size();i++){
               GamePanel.enemies.remove(i);
               i--;
               health=20;
               shotGunAmmo=10;
               smgAmmo=0;
               akAmmo=0;
               m16Ammo=0;
               rifleAmmo=0;
               minigunAmmo=100;
               awpAmmo=0;
               lazerAmmo=0;
               singularAmmo=0;
           }
       }
       if(GamePanel.wave.getWaveNumber()==9){
           JOptionPane.showMessageDialog(null,"You have won!");
           System.exit(0);
       }
        double dist=0;

       if(isMove){
        double drx =GamePanel.mouseX- GamePanel.player.getX();
        double dry = GamePanel.mouseY- GamePanel.player.getY();
        dist = Math.sqrt(drx*drx + dry * dry);
        double sin = drx/dist;
        double cos = dry/dist;
        dx=this.speed * sin;
        dy=this.speed * cos;
        if(x<0 && dx<0) dx = 0;
        if(x>(GamePanel.WIDTH - 2*r) && dx>0) dx = 0;
        if(y<0 && dy<0) dy = 0;
        if(y>(GamePanel.HEIGHT - 2 * r) && dy>0) dy = 0;
       for(int i = 0;i<GamePanel.blocks.size();i++){
           Block b = GamePanel.blocks.get(i);

           if(x+r>b.getX() && x-r<(b.getX()+b.getWidth()) && y+r>b.getY()&&y-r<(b.getY()+b.getHeight())) {

               if (x + r > b.getX() && dx > 0 && (y + r) > b.getY()
                       && (y - r) < ((b.getY()) + b.getHeight()) && Math.abs(x+r-b.getX())
                       <Math.abs(x - r - (b.getX() + b.getWidth()))) dx = 0;
               else {
                   if (x - r < (b.getX() + b.getWidth()) && dx < 0 && (y + r) > b.getY() &&
                           (y - r) < (b.getY() + b.getHeight())&& Math.abs(x+r-b.getX())
                           >Math.abs(x - r - (b.getX() + b.getWidth())))
                       dx = 0.2;
               }

               if (y + r > b.getY() && dy > 0 && (x + r) > b.getX() &&
                       (x - r) < ((b.getX()) + b.getWidth())&& Math.abs(y+r-b.getY())
                       <Math.abs(y - r - (b.getY() + b.getHeight()))) dy = 0;
               else {
                   if (y - r < (b.getY() + b.getHeight()) && dy < 0 && (x + r) > b.getX() &&
                           (x - r) < ((b.getX()) + b.getWidth())&& Math.abs(y+r-b.getY())
                           >Math.abs(y - r - (b.getY() + b.getHeight())))
                       dy = 0;
               }
           }
       }
       }
        else{
           dx=0;
           dy=0;
       }
       if(dist>15) {
           y += dy;
           x += dx;
       }


        //Reload
        if(reload>Bullet.gunSpeed) reload=Bullet.gunSpeed;

        //Front shooting
        if (isFiring && reload==Bullet.gunSpeed && !isFiring2){
            switch (myGun){
                case 1:
                    GamePanel.bullets.add(new Bullet(myGun));
                    break;
                case 2:
                    if(shotGunAmmo>0){
                        for(int i=0;i<8;i++)
                            GamePanel.bullets.add(new Bullet(myGun));
                    shotGunAmmo--;}
                    break;
                case 3:
                    if(smgAmmo>0){
                    GamePanel.bullets.add(new Bullet(myGun));
                    smgAmmo--;}
                    break;
                case 4:
                    if(akAmmo>0){
                        GamePanel.bullets.add(new Bullet(myGun));
                    akAmmo--;}
                    break;
                case 5:
                    if(m16Ammo>0){
                        GamePanel.bullets.add(new Bullet(myGun));
                    m16Ammo--;}
                    break;
                case 6:
                    if(rifleAmmo>0){
                        GamePanel.bullets.add(new Bullet(myGun));
                    rifleAmmo--;}
                    break;
                case 7:
                    if(minigunAmmo>0){
                        GamePanel.bullets.add(new Bullet(myGun));
                    minigunAmmo--;}
                    break;
                case 8:
                    if(awpAmmo>0){
                        GamePanel.bullets.add(new Bullet(myGun));
                    awpAmmo--;}
                    break;
                case 9:
                    if(lazerAmmo>0){
                        GamePanel.bullets.add(new Bullet(myGun));
                    lazerAmmo--;}
                    break;
                case 0:
                    if(singularAmmo>0){
                        for(int i=0;i<new Random().nextInt(5)+1;i++) {
                            GamePanel.bullets.add(new Bullet(myGun));}
                    singularAmmo--;}
                    break;
            }
            reload=0;
        }
        if (isFiring2 && reload==Bullet.gunSpeed && !isFiring){
            switch (myGun){
                case 1:
                    GamePanel.bullets.add(new Bullet(myGun,1));
                    break;
                case 2:
                    if(shotGunAmmo>0){
                        for(int i=0;i<8;i++)
                            GamePanel.bullets.add(new Bullet(myGun,1));
                        shotGunAmmo--;}
                    break;
                case 3:
                    if(smgAmmo>0){
                        GamePanel.bullets.add(new Bullet(myGun,1));
                        smgAmmo--;}
                    break;
                case 4:
                    if(akAmmo>0){
                        GamePanel.bullets.add(new Bullet(myGun,1));
                    akAmmo--;}
                    break;
                case 5:
                    if(m16Ammo>0){
                        GamePanel.bullets.add(new Bullet(myGun,1));
                    m16Ammo--;}
                    break;
                case 6:
                    if(rifleAmmo>0){
                        GamePanel.bullets.add(new Bullet(myGun,1));
                    rifleAmmo--;}
                    break;
                case 7:
                    if(minigunAmmo>0){
                        GamePanel.bullets.add(new Bullet(myGun,1));
                    minigunAmmo--;}
                    break;
                case 8:
                    if(awpAmmo>0){
                        GamePanel.bullets.add(new Bullet(myGun,1));
                    awpAmmo--;}
                    break;
                case 9:
                    if(lazerAmmo>0){
                        GamePanel.bullets.add(new Bullet(myGun,1));
                    lazerAmmo--;}
                    break;
                case 0:
                    if(singularAmmo>0){
                    for(int i=0;i<new Random().nextInt(5)+1;i++)
                        GamePanel.bullets.add(new Bullet(myGun,1));
                    singularAmmo--;}
                    break;
            }
            reload=0;
        }
        //behind shooting

       /* if (isFiring && reload==Bullet.gunSpeed && ammo>0 && !isFiring2 && myGun!=PISTOL){

            if(myGun==2){
                for(int i =0;i<8;i++) {
                    GamePanel.bullets.add(new Bullet(myGun));
                }
            }
            if(myGun==0){
                for(int i =0;i<new Random().nextInt(5);i++) {
                    GamePanel.bullets.add(new Bullet(myGun));
                }
            }
            GamePanel.bullets.add(new Bullet(myGun));
            reload=0;
            ammo--;
        }
        if(reload>Bullet.gunSpeed) reload=Bullet.gunSpeed;
        if (isFiring2 && reload==Bullet.gunSpeed && ammo>0 && !isFiring){
            GamePanel.bullets.add(new Bullet(myGun,1));
            reload=0;
            ammo--;
        }*/
        reload++;

        //Health
        this.HealthColor();

    }
    public void draw(Graphics2D g ){
        g.setColor(color1);
        g.fillOval((int)(x-r),(int)(y-r),2*r,2*r);
        g.setStroke(new BasicStroke(3));
        g.setColor(color2);
        g.drawOval((int)(x-r),(int)(y-r),2*r,2*r);
        if((isFiring | isFiring2) & reload>=Bullet.gunSpeed-1
                & reload<=Bullet.gunSpeed+3 & Player.currentAmmo>0) {
            g.setColor(light);
            g.fillOval((int)(x-4*r),(int)(y-4*r),8*r,8*r);
        }



    }

}

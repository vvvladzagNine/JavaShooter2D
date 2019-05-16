package com.vladislavZag.shooter;
import java.awt.*;
import java.util.Random;
/**
 * Created by vladislavZag on 13.06.17.
 */
public class Bullet {
    //Fields
    private double x;
    private double y;
    public int r;

    private int speed;
    private double dx;
    private double dy;

    public double razbros;
    public static int gunSpeed;
    public double damage;

    private Color color;
    private Color color2;
    private Color forDark= new Color(250, 254, 240);
    public Bullet(int gun){


        switch (Player.myGun){
            case (1):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=2;
                if(!GamePanel.darkness.ld){
                    color = Color.blue;}
                else {
                    color = forDark ;
                }//new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);
                speed = 8;
                razbros = 0.1;
                damage = 1.5;
                double drx = GamePanel.player.getX() - GamePanel.mouseX;
                double dry = GamePanel.player.getY() - GamePanel.mouseY;
                double dist = Math.sqrt(drx*drx + dry * dry);
                double cos = drx/dist + (Math.random()-0.5)*razbros;
                double sin = dry/dist + (Math.random()-0.5)*razbros;
                dx=-(speed * cos);
                dy=(speed * sin);
                gunSpeed=10;
                break;
            case (2):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=1;
                if(!GamePanel.darkness.ld){
                    color = new Color(0, 93, 9,255);}
                else {
                    color = forDark ;
                }//new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);
                speed = 10;
                razbros = 0.5;
                damage = 0.8;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=-(speed * sin);
                dy=speed * cos;
                gunSpeed=24;
                break;
            case (3):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=1;
                if(!GamePanel.darkness.ld){
                    color = new Color(200, 3, 154,255);}
                else {
                    color = forDark ;
                }//new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);
                speed = 10;
                razbros = 0.7;
                damage=1;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=-(speed * sin);
                dy=speed * cos;
                gunSpeed=3;
                break;
            case (4):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=2;
                if(!GamePanel.darkness.ld){
                    color = new Color(184, 86, 10,255);}
                else {
                    color = forDark ;
                }//new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);
                speed = 12;
                razbros = 0.35;
                damage=2.7;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=-(speed * sin);
                dy=speed * cos;
                gunSpeed=4;
                break;
            case (5):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=2;
                if(!GamePanel.darkness.ld){
                    color = new Color(160, 156,225,255);}
                else {
                    color = forDark ;
                }//new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);
                speed = 10;
                razbros = 0.05;
                damage=2;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=-(speed * sin);
                dy=speed * cos;
                gunSpeed=5;
                break;
            case (6):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=2;
                if(!GamePanel.darkness.ld){
                    color = new Color(200, 110, 166,255);}
                else {
                    color = forDark ;
                }//new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);
                speed = 10;
                razbros = 0.8;
                damage=4;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=-(speed * sin);
                dy=speed * cos;
                gunSpeed=3;
                break;
            case (7):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=2;
                color = new Color(136, 225, 157,255);//new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);
                speed = 10;
                razbros = 0.2;
                damage=2;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=-(speed * sin);
                dy=speed * cos;
                gunSpeed=1;
                break;

            case (8):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=3;
                if(!GamePanel.darkness.ld){
                    color = new Color(105,68,56,255);}
                else {
                    color = forDark ;
                }//new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);
                speed = 20;
                razbros = 0.02;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=-(speed * sin);
                dy=speed * cos;
                gunSpeed=30;
                damage=80;
                break;
            case (9):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=2;
                color = new Color(255,0,0,255);//new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);
                speed = 4;
                razbros = 0;
                damage=1;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist;
                cos = dry/dist;
                dx=-(speed * sin);
                dy=speed * cos;
                gunSpeed=1;
                break;
            case (0):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=new Random().nextInt(6)+2;
                color = new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);
                speed = new Random().nextInt(7)+9;
                razbros = 0.2 + new Random().nextInt(15)*0.1;
                damage=r*1.1;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=-(speed * sin);
                dy=speed * cos;
                gunSpeed=new Random().nextInt(7)+3;
                break;
        }

    }
    public Bullet(int gun, int a) {
        switch (Player.myGun){
            case (1):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=2;
                if(!GamePanel.darkness.ld){
                color = Color.blue;}
                else {
                    color = forDark ;
                }
                speed = 8;
                razbros = 0.1;
                damage = 1.5;
                double drx = GamePanel.player.getX() - GamePanel.mouseX;
                double dry = GamePanel.player.getY() - GamePanel.mouseY;
                double dist = Math.sqrt(drx*drx + dry * dry);
                double cos = drx/dist + (Math.random()-0.5)*razbros;
                double sin = dry/dist + (Math.random()-0.5)*razbros;
                dx=(speed * cos);
                dy=-(speed * sin);
                gunSpeed=10;
                break;
            case (2):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=1;
                if(!GamePanel.darkness.ld){
                color = new Color(0, 93, 9,255);}
                else {
                    color = forDark ;
                }
                speed = 10;
                razbros = 0.5;
                damage = 0.8;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=(speed * sin);
                dy=-speed * cos;
                gunSpeed=24;
                break;
            case (3):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=1;
                ;
                if(!GamePanel.darkness.ld){
                    color = new Color(200, 3, 154,255);}
                else {
                    color = forDark ;
                }
                speed = 10;
                razbros = 0.7;
                damage=1;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=(speed * sin);
                dy=-speed * cos;
                gunSpeed=3;
                break;
            case (4):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=2;

                if(!GamePanel.darkness.ld){
                    color = new Color(184, 86, 10,255);}
                else {
                    color = forDark ;
                }
                speed = 12;
                razbros = 0.35;
                damage=2.7;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=(speed * sin);
                dy=-speed * cos;
                gunSpeed=4;
                break;
            case (5):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=2;

                if(!GamePanel.darkness.ld){
                    color = new Color(160, 156,225,255);}
                else {
                    color = forDark ;
                }
                speed = 10;
                razbros = 0.05;
                damage=2;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=(speed * sin);
                dy=-speed * cos;
                gunSpeed=5;
                break;
            case (6):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=2;

                if(!GamePanel.darkness.ld){
                    color = new Color(200, 110, 166,255);}
                else {
                    color = forDark ;
                }
                speed = 10;
                razbros = 0.8;
                damage=4;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=(speed * sin);
                dy=-speed * cos;
                gunSpeed=3;
                break;
            case (7):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=2;

                if(!GamePanel.darkness.ld){
                    color = new Color(136, 225, 157,255);}
                else {
                    color = forDark ;
                }
                speed = 10;
                razbros = 0.2;
                damage=2;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=(speed * sin);
                dy=-speed * cos;
                gunSpeed=1;
                break;

            case (8):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=3;

                if(!GamePanel.darkness.ld){
                    color = new Color(105,68,56,255);}
                else {
                    color = forDark ;
                }
                speed = 20;
                razbros = 0.02;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=(speed * sin);
                dy=-speed * cos;
                gunSpeed=30;
                damage=80;
                break;
            case (9):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=2;
                color = new Color(255,0,0,255);
                speed = 4;
                razbros = 0;
                damage=1;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist;
                cos = dry/dist;
                dx=(speed * sin);
                dy=-speed * cos;
                gunSpeed=1;
                break;
            case (0):
                x=GamePanel.player.getX();
                y=GamePanel.player.getY();
                r=new Random().nextInt(6)+2;
                color = new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(50),255);
                speed = new Random().nextInt(7)+9;
                razbros = 0.2 + new Random().nextInt(15)*0.1;
                damage=r*1.1;
                drx = GamePanel.player.getX() - GamePanel.mouseX;
                dry = GamePanel.player.getY() - GamePanel.mouseY;
                dist = Math.sqrt(drx*drx + dry * dry);
                sin = drx/dist + (Math.random()-0.5)*razbros;
                cos = dry/dist + (Math.random()-0.5)*razbros;
                dx=(speed * sin);
                dy=-speed * cos;
                gunSpeed=new Random().nextInt(7)+3;
                break;
        }
    }


    //Functions
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public int getR(){
        return r;
    }
    public double getDamage(){
        return damage;
    }

    public boolean remove(){
        if(y<0 || y > GamePanel.HEIGHT || x<0 || x>GamePanel.WIDTH){
            return true;
        }
        return false;
    }
    public double getDx(){

        return dx;
    }
    public double getDy(){

        return dy;
    }

    public void update(){

        x+=dx;
        y-=dy;
        for(int i = 0;i<GamePanel.blocks.size();i++){
            Block b = GamePanel.blocks.get(i);

            /*if(x+r>b.getX() && x-r<(b.getX()+b.getWidth()) && y+r>b.getY()&&y-r<(b.getY()+b.getHeight())) {

                if (x + r > b.getX() && dx > 0 && (y + r) > b.getY()
                        && (y - r) < ((b.getY()) + b.getHeight()) && Math.abs(x+r-b.getX())<Math.abs(x - r - (b.getX() + b.getWidth()))) dx = -dx;
                else {
                    if (x - r < (b.getX() + b.getWidth()) && dx < 0 && (y + r) > b.getY() &&
                            (y - r) < (b.getY() + b.getHeight())&& Math.abs(x+r-b.getX())>Math.abs(x - r - (b.getX() + b.getWidth())))
                        dx = -dx;
                    if (y + r > b.getY() && dy > 0 && (x + r) > b.getX() &&
                            (x - r) < ((b.getX()) + b.getWidth())&& Math.abs(y+r-b.getY())<Math.abs(y - r - (b.getY() + b.getHeight()))) dy = -dy;
                    else {
                        if (y - r < (b.getY() + b.getHeight()) && dy < 0 && (x + r) > b.getX() &&
                                (x - r) < ((b.getX()) + b.getWidth())&& Math.abs(y+r-b.getY())>Math.abs(y - r - (b.getY() + b.getHeight())))
                            dy = -dy;
                    }
                }


            }*/
            if(this.getRect().intersects(b.getUpBorder()) || this.getRect().intersects(b.getDownBorder())){
                dy=-dy;
            }
            else {
                if(this.getRect().intersects(b.getRightBorder()) || this.getRect().intersects(b.getLeftBorder())){
                    dx=-dx;
                }
            }
        }
    }
    public Rectangle getRect(){
        return new Rectangle((int)x-2*r,(int)y-2*r,4*r,4*r);
    }



    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int)x-r,(int)y-r,r*2,2*r);
        if(Player.myGun==Player.SINGULARGUN){
            g.setStroke(new BasicStroke(3));
            g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255),255));
            g.drawOval((int)x-r,(int)y-r,2*r,2*r);
            g.setStroke(new BasicStroke(1));
        }
    }

}




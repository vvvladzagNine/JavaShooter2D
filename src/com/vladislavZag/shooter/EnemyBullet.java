package com.vladislavZag.shooter;
import java.awt.*;

/**
 * Created by vladislavZag on 21.06.17.
 */
public class EnemyBullet {

    //Fields

    private double x;
    private double y;
    private int r;

    private double speed;
    private double dx;
    private double dy;

    private double razbros;


    private Color color;

    //Constructor
    public EnemyBullet(double x, double y) {
        this.x = x;
        this.y = y;
        r = 2;
        speed = 5;
        color = Color.BLACK;
        razbros=0.1;
        double drx = x - GamePanel.player.getX();
        double dry = y - GamePanel.player.getY();
        double dist = Math.sqrt(drx*drx + dry * dry);
        double sin = drx/dist + (Math.random()-0.5)*razbros;
        double cos = dry/dist + (Math.random()-0.5)*razbros;
        dx=-(speed * sin);
        dy=speed * cos;
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

    public void update() {
        x+=dx;
        y-=dy;

    }
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int)x,(int)y,r*2,2*r);

    }
    public boolean remove(){
        if(y<0 || y > GamePanel.HEIGHT || x<0 || x>GamePanel.WIDTH){
            return true;
        }
        return false;
    }
}

package com.vladislavZag.shooter;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import java.awt.*;
/**
 * Created by vladislavZag on 18.06.17.
 */
public class Enemy {
    //Fields
    private double x;
    private double y;
    private int r;
    int R;

    private int type;
    private int rank;

    private int reload;
    private int gunSpeed;

    private double speed;
    private double dx;
    private double dy;

    private int instrum;
    private int note;

    private double health;
    double HEALTH;

    private boolean randMove;
    private boolean isFiring;

    private static int startTick = 2;
    private static int endTick=4;



    private Color color;
    public Enemy(){

        instrum=10;
        note=70;
        x=300;
        y=300;
        r=3;



        speed=4;
        health = 10;
        R=r;
        HEALTH=health;

        double angle = Math.toRadians(Math.random()*360);
        dx = Math.sin(angle)*speed;
        dy = Math.cos(angle)*speed;
        randMove=true;
        isFiring=false;
        color=new Color(72, 227, 223);
    }

    //Constructor
    public Enemy(int type,int rank, int gunSpeed){
        this.type = type;
        this.rank = rank;
        instrum=10;
        note=70;


        switch (type){
            case (1):
                color = new Color(48,107,55,255);
                randMove=true;
                isFiring=false;

                switch (rank){
                case(1):
                    x=Math.random() * GamePanel.WIDTH;
                    y=0;
                    r=7;



                    speed=2;
                    health = 2;
                    R=r;
                    HEALTH=health;

                    double angle = Math.toRadians(Math.random()*360);
                    dx = Math.sin(angle)*speed;
                    dy = Math.cos(angle)*speed;
                    break;

                    case(2):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=9;



                        speed=2;
                        health = 3;
                        R=r;
                        HEALTH=health;
                        angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;
                    case(3):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=12;



                        speed=2;
                        health = 4;
                        R=r;
                        HEALTH=health;

                        angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;

            }
            break;
            case (2):
                color = Color.YELLOW;
                randMove=true;
                isFiring=true;
                this.gunSpeed= gunSpeed;
                reload=0;
                switch (rank){
                    case(1):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=8;



                        speed=3;
                        health = 2;
                        R=r;
                        HEALTH=health;

                        double angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;

                    case(2):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=11;



                        speed=3;
                        health = 4;
                        R=r;
                        HEALTH=health;

                        angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;
                    case(3):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=16;



                        speed=2;
                        health = 6;
                        R=r;
                        HEALTH=health;

                        angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;
                    case(4):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=30;



                        speed=0.5;
                        health = 400;
                        R=r;
                        HEALTH=health;

                        angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;

                }
                break;
            case (3):
                color = Color.RED;
                randMove=false;
                isFiring=false;
                switch (rank){
                    case(1):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=6;



                        speed =4;
                        health =1;
                        R=r;
                        HEALTH=health;

                        double angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;

                    case(2):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=13;



                        speed=4;
                        health = 4;
                        R=r;
                        HEALTH=health;

                        angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;
                    case(3):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=18;



                        speed=4;
                        health = 8;
                        R=r;
                        HEALTH=health;

                        angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;
                    case(4):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=20;

                        speed=4;
                        health = 600;
                        R=r;
                        HEALTH=health;

                        angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;

                }
                break;
            case (4):
                color = Color.MAGENTA;
                randMove=true;
                isFiring=false;
                switch (rank){
                    case(1):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=7;



                        speed=4;
                        health = 1;
                        R=r;
                        HEALTH=health;

                        double angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;

                    case(2):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=13;



                        speed=2;
                        health = 4;
                        R=r;
                        HEALTH=health;

                        angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;
                    case(3):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=20;



                        speed=1;
                        health = 10;
                        R=r;
                        HEALTH=health;

                        angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;

                    case(4):
                        x=Math.random() * GamePanel.WIDTH;
                        y=0;
                        r=30;



                        speed=1;
                        health = 10000;
                        R=r;
                        HEALTH=health;

                        angle = Math.toRadians(Math.random()*360);
                        dx = Math.sin(angle)*speed;
                        dy = Math.cos(angle)*speed;
                        break;

                }
                break;

        }

    }

    //Functions



    public double getX(){

        return x;
    }

    public int getInstrum()
    {
        return instrum;
    }
    public int getNote(){
        return note;
    }
    public double getY(){

        return y;
    }
    public int getR(){

        return r;
    }
    public double getDx(){

        return dx;
    }
    public double getDy(){

        return dy;
    }
    public Color getColor(){
        return color;
    }
    public int getRank(){
        return rank;
    }
    public double getHealth(){
        return health;
    }
    public void setR(int r){
        this.r=r;
    }

    public void changeMove(){
        if(randMove)randMove=false;
        else {
            randMove=true;
            for(int i=0;i<GamePanel.enemies.size();i++) {
                double angle = Math.toRadians(Math.random() * 360);
                GamePanel.enemies.get(i).dx = Math.sin(angle) * GamePanel.enemies.get(i).speed;
                GamePanel.enemies.get(i).dy = Math.cos(angle) * GamePanel.enemies.get(i).speed;
            }

        }
    }

    public boolean remove(){
        if(health<=0){
            return true;
        }
        return false;
    }

    public void hit(double damage){
        health-=damage;
    }
    public void update(){
        if(randMove){
            this.moveRandom();
        }
        else{
            this.moveToPlayer();
        }
        if (isFiring && reload==gunSpeed ){
            GamePanel.enemyBullets.add(new EnemyBullet(this.getX(),this.getY()));
            reload=0;
        }
        reload++;




    }
    public void moveRandom(){
        x+=dx;
        y+=dy;

        if(x<0 && dx<0) dx = -dx;
        if(x>(GamePanel.WIDTH - 2*r) && dx>0) dx = -dx;
        if(y<0 && dy<0) dy = -dy;
        if(y>(GamePanel.HEIGHT - 2 * r) && dy>0) dy = -dy;

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

    //MoveToPlayer
    public void moveToPlayer(){
        x+=dx;
        y+=dy;
        double drx = GamePanel.player.getX() - this.getX();
        double dry = GamePanel.player.getY() - this.getY();
        double dist = Math.sqrt(drx*drx + dry * dry);
        double sin = drx/dist;
        double cos = dry/dist;
        dx=this.speed * sin;
        dy=this.speed * cos;

        for(int i = 0;i<GamePanel.blocks.size();i++){
            Block b = GamePanel.blocks.get(i);
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
    public void dropSth(){
        double rand = Math.random();
        if(rand>0.5 && rand<0.58) GamePanel.Drops.add(new HealthDrop(x,y,0,1));
        switch (type){
            case 1:
                if(rand>0.85) GamePanel.Drops.add(new ShotGunDrop(x,y,dx,dy));
                if(rand<0.15) GamePanel.Drops.add(new SmgDrop(x,y,dx,dy));
                break;

            case 2:
                if(rand>0.78) GamePanel.Drops.add(new AkDrop(x,y,dx,dy));
                if(rand<0.20) GamePanel.Drops.add(new M16Drop(x,y,dx,dy));
                break;

            case 3:
                if(rand>0.83) GamePanel.Drops.add(new AwpDrop(x,y,dx,dy));
                if(rand<0.15) GamePanel.Drops.add(new MiniGunDrop(x,y,dx,dy));
                if(rand>0.25 && rand<0.60) GamePanel.Drops.add(new SingularDrop(x,y,dx,dy));
                break;

            case 4:
                if(rand>0.1) for(int i = 0;i<10;i++)GamePanel.Drops.add(new ShotGunDrop(x,y,dx,dy));
                if(rand<0.2) GamePanel.Drops.add(new SmgDrop(x,y,dx,dy));
                break;

        }
    }
    public void playSound(int instrument,int n){
        try {


            ShortMessage setInst = new ShortMessage();
            setInst.setMessage(192,1,instrument,0);
            MidiEvent si = new MidiEvent(setInst,--startTick);
            GamePanel.track.add(si);

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,n,100);
            MidiEvent begin = new MidiEvent(a,startTick);
            GamePanel.track.add(begin);

            ShortMessage b = new ShortMessage();
            b.setMessage(128,2,n,100);
            MidiEvent end = new MidiEvent(b,endTick);
            GamePanel.track.add(end);

            GamePanel.sint.setSequence(GamePanel.seq);
            GamePanel.sint.start();

            startTick+=2;
            endTick+=2;
        }
        catch (Exception e){

        }

    }
    public Rectangle getRect(){
        return new Rectangle((int)x-r,(int)y-r,2*r,2*r);
    }
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int)x-r,(int)y-r,2*r,2*r);
        g.setStroke(new BasicStroke(3));
        g.setColor(color.darker());
        g.drawOval((int)x-r,(int)y-r,2*r,2*r);
        g.setStroke(new BasicStroke(1));

    }
}

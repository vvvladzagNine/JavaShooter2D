package com.vladislavZag.shooter;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by vladislavZag on 13.06.17.
 */
public class GamePanel extends JPanel implements Runnable {

    //Field
    public static int WIDTH = 700;
    public static int HEIGHT = 450;

    public static int mouseX;
    public static int mouseY;
    public static boolean leftMouse;


    private Thread thread;
    private BufferedImage image;
    private Graphics2D g;

    private int FPS;
    private double millisToFPS;
    private long timerFPS;
    private int sleepTime;

    static Sequencer sint;
    static Sequence seq;
    static Track track;



    public static enum STATES{
        MENUE,
        PLAY,
        EDITOR
    }

    public static STATES state = STATES.MENUE;

    public static GameBack backGround;
    public static Aim aim;
    public static Darkness darkness;
    public static Player player;
    public static Treasure treasure;
    public static ArrayList<Bullet> bullets;
    public static ArrayList<EnemyBullet> enemyBullets;
    public static ArrayList<Enemy> enemies;
    public static ArrayList<Block> blocks;
    public static ArrayList<Block> blocksE;
    public static ArrayList<Drop> Drops;
    public static ArrayList<Meat> Meats;
    public static Wave wave;
    public static Menue menue;
    public static PhantomBlock pBlock;
    public static ArrayList<String> lvlCode;


    //contructor

    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(new Listeners());
        addMouseMotionListener(new Listeners());
        addMouseListener(new Listeners());
        addMouseWheelListener(new Listeners());

    }
    //Funcions

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        FPS=35;
        millisToFPS = 1000/FPS;
        sleepTime = 0;
        pBlock = new PhantomBlock(50,50,Color.RED);

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        leftMouse=false;
        backGround = new GameBack();
        player = new Player();
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        enemyBullets = new ArrayList<>();
        blocks = new ArrayList<>();
        Drops = new ArrayList<>();
        Meats = new ArrayList<>();
        blocksE=new ArrayList<>();
        wave = new Wave();
        menue = new Menue();
        darkness=new Darkness();
        lvlCode = new ArrayList<>();
        treasure=new Treasure(50,50);
        aim=new Aim();

        createBlocks();


       /* blocks.add(new Block(200,200,20,200,Color.orange));
        blocks.add(new Block(400,200,20,200,Color.orange));
        blocks.add(new Block(200,180,220,20,Color.orange));
        blocks.add(new Block(200,380,200,20,Color.orange));
        for(int i=0;i<300;i++)
        enemies.add(new Enemy());*/
        createSequencer();






        while (true) {
            timerFPS = System.nanoTime();
            if(state.equals(STATES.MENUE)){
                backGround.update();
                backGround.draw(g);
                menue.draw(g);
                menue.update();
                gameDraw();

            }
            if(state.equals(STATES.EDITOR)){
                gameRender2();
                gameDraw();
                update2();
            }
            if(state.equals(STATES.PLAY)){
                gameRender();
                gameDraw();
                gameUpdate();
            }


            timerFPS = (System.nanoTime() - timerFPS)/1000000;
            if(millisToFPS > timerFPS){
                sleepTime =(int)(millisToFPS - timerFPS);
            }
            else sleepTime = 0;

            try {
                thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timerFPS=0;
            sleepTime=1;
        }
    }

        public void gameUpdate () {
            //BackGround update
            backGround.update();
            //Player update
            player.update();
            //Aim update
            //aim.update();
            //Bullets update
            for (int i = 0; i < bullets.size(); i++) {
                bullets.get(i).update();
                boolean remove = bullets.get(i).remove();
                if (remove) {
                    bullets.remove(i);
                    i--;
                }
            }
            //Drop update
            for(int i =0;i<Drops.size();i++){
                Drops.get(i).update();
            }
            //EnemyBullets update
            for (int i = 0; i < enemyBullets.size(); i++) {
                enemyBullets.get(i).update();
                boolean remove = enemyBullets.get(i).remove();
                if (remove) {
                    enemyBullets.remove(i);
                    i--;
                }
            }
            //Enemies update
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).update();
            }
            //Blocks update
            for(int i=0;i<blocks.size();i++){
                blocks.get(i).update();
            }
            //Meat update
            for(int i =0;i<Meats.size();i++){
                Meats.get(i).update();
                boolean remove = Meats.get(i).remove();
                if (remove) {
                    Meats.remove(i);
                    i--;
                }

            }
            //Bullets-enemies collide
            for (int i = 0; i < enemies.size(); i++) {
                Enemy e = enemies.get(i);
                double ex = e.getX();
                double ey = e.getY();
                for (int j = 0; j < bullets.size(); j++) {
                    Bullet b = bullets.get(j);
                    double bx = b.getX();
                    double by = b.getY();
                    double dx = ex - bx;
                    double dy = ey - by;
                    double dist = Math.sqrt(dx * dx + dy * dy);
                    if ((int) dist <=e.getR() + b.getR()) {
                        e.hit(bullets.get(j).getDamage());
                        bullets.remove(j);
                        j--;
                        boolean remove = e.remove();


                        double newR=e.R*e.getHealth()/e.HEALTH;
                        if(newR>6){
                        enemies.get(i).setR((int)(newR));}
                        else {
                            enemies.get(i).setR(6);
                        }
                        if(!remove){
                        for(int l =0;l<b.getDamage();l++){
                            Meats.add(new Meat(e.getX(),e.getY(),e.getColor(),e.getDx(),e.getDy()));}
                        }

                        else {
                            for(int k=0;k<4;k++){
                            Meats.add(new Meat(e.getX(),e.getY(),e.getColor(),0,0));
                        }
                            e.dropSth();
                            //e.playSound(e.getInstrum(),e.getNote());
                            enemies.remove(i);
                            i--;

                        break;
                    }



                }

                }

            }//Bullets-Blocks collide
            for (int i = 0; i < blocks.size(); i++) {
                Block e = blocks.get(i);
                int ex = e.getX();
                int ey = e.getY();
                int we=e.getWidth();
                int he=e.getHeight();
                for (int j = 0; j < bullets.size(); j++) {
                    Bullet b = bullets.get(j);
                    double bx = b.getX();
                    double by = b.getY();
                    if (bx<(ex+we) && bx>ex && by<(ey+he) && by>ey) {
                        bullets.remove(j);
                        j--;
                        break;
                    }

                }

            }
            //EnemyBullets-Blocks collide
            for (int i = 0; i < blocks.size(); i++) {
                Block e = blocks.get(i);
                int ex = e.getX();
                int ey = e.getY();
                int we=e.getWidth();
                int he=e.getHeight();
                for (int j = 0; j < enemyBullets.size(); j++) {
                    EnemyBullet b = enemyBullets.get(j);
                    double bx = b.getX();
                    double by = b.getY();
                    if (bx<(ex+we) && bx>ex && by<(ey+he) && by>ey) {
                        enemyBullets.remove(j);
                        j--;
                        break;
                    }

                }

            }
            //Player-enemies collide
            double px = player.getX();
            double py = player.getY();
            for(int i=0;i<enemies.size();i++){
                Enemy e = enemies.get(i);
                double ex = e.getX();
                double ey = e.getY();

                double dx = px-ex;
                double dy = py-ey;
                double dist = Math.sqrt(dx*dx + dy*dy);
                if((int)dist<= player.getR()+e.getR()){
                    e.hit(1);

                    player.hit();
                    boolean remove = e.remove();
                    if (remove) {
                        enemies.remove(i);
                        i--;
                        break;
                    }

                }

            }




            //Player-Drop taking
             px = player.getX();
             py = player.getY();
            for(int i=0;i<Drops.size();i++){
                Drop s = Drops.get(i);
                double ex = s.getX();
                double ey = s.getY();

                double dx = px-ex;
                double dy = py-ey;
                double dist = Math.sqrt(dx*dx + dy*dy);
                if((int)dist<= player.getR()+s.getA()){
                    Drops.get(i).addSth();
                    Drops.remove(i);
                    i--;
                        break;


                }

            }

            //Player-bullets collide

            for(int i=0;i<enemyBullets.size();i++){
                EnemyBullet b = enemyBullets.get(i);
                double bx = b.getX();
                double by = b.getY();

                double dx = px-bx;
                double dy = py-by;
                double dist = Math.sqrt(dx*dx + dy*dy);
                if((int)dist<= player.getR()+b.getR()){
                    player.hit();
                    //player.getSound().play();
                    enemyBullets.remove(i);
                    i--;
                    break;


                }

            }
            //Wave update
            wave.update();

        }

        public void gameRender(){
            //BackGround draw
            backGround.draw(g);

            //Player draw
            player.draw(g);
            //Drop draw
            for(int i =0;i<Drops.size();i++){
                Drops.get(i).draw(g);
            }
            for(int i =0;i<Meats.size();i++){
                Meats.get(i).draw(g);
            }

            //Bullets draw
            for (int i = 0; i < bullets.size(); i++) {
                bullets.get(i).draw(g);
            }
            //EnemyBullets draw
            for (int i = 0; i < enemyBullets.size(); i++) {
                enemyBullets.get(i).draw(g);
            }
            //Enemies draw
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).draw(g);
            }
            if(wave.showWave()){
                wave.draw(g);
            }

            //Blocks draw
            for(int i=0;i<blocks.size();i++){
                blocks.get(i).draw(g);
            }
            //treasure.draw(g);

            //Darkness draw
            if(darkness.ld) {
                darkness.draw(g);
            }
            for (int i = 0; i < bullets.size(); i++) {
                if((bullets.get(i).razbros==0) | (bullets.get(i).damage == bullets.get(i).r * 1.1))
                    bullets.get(i).draw(g);
            }

            //aim.draw(g);

            //HUD draw
            int lineHealthLenght = 180;
            int lenght = lineHealthLenght * player.getHealth()/Player.MAXHP;
            int hbY = lineHealthLenght - lineHealthLenght * player.getHealth()/Player.MAXHP;
            g.setColor(new Color(109, 18, 149));
            Font font = new Font("Arial",Font.ITALIC,20);
            g.setFont(font);
            g.setStroke(new BasicStroke(4));
            //g.drawString("Health: " + player.getHealth(),10,30);
            g.drawRect(1,115,11,lineHealthLenght+1);
            g.setStroke(new BasicStroke(1));
            g.setColor(new Color(183, 255, 240));
            g.fillRect(2,116+hbY,10,lenght);

            if(!darkness.ld)
            g.setColor(new Color(8, 14, 227));
            else {
                g.setColor(Color.WHITE);
            }

            int wy1=40;
            int wy2=60;
            int wy3=80;
            int wx=14;



            switch (Player.myGun){
                case 1:
                    g.drawString("Ammo: infinity",wx,wy1);
                    g.drawString("Pistol",wx,wy2);
                    Player.currentAmmo=320000;
                    break;
                case 2:
                    g.drawString("Ammo: "+Player.shotGunAmmo,wx,wy1);
                    g.drawString("Shotgun",wx,wy2);
                    Player.currentAmmo=Player.shotGunAmmo;
                    break;
                case 3:
                    g.drawString("Ammo: "+Player.smgAmmo,wx,wy1);
                    g.drawString("UZI",wx,wy2);
                    Player.currentAmmo=Player.smgAmmo;
                    break;
                case 4:
                    g.drawString("Ammo: "+Player.akAmmo,wx,wy1);
                    g.drawString("Ak-47",wx,wy2);
                    Player.currentAmmo=Player.akAmmo;
                    break;
                case 5:
                    g.drawString("Ammo: "+Player.m16Ammo,wx,wy1);
                    g.drawString("M16",wx,wy2);
                    Player.currentAmmo=Player.m16Ammo;
                    break;
                case 6:
                    g.drawString("Ammo: "+Player.rifleAmmo,wx,wy1);
                    g.drawString("RPK",wx,wy2);
                    Player.currentAmmo=Player.rifleAmmo;
                    break;
                case 7:
                    g.drawString("Ammo: "+Player.minigunAmmo,wx,wy1);
                    g.drawString("Minigun",wx,wy2);
                    Player.currentAmmo=Player.minigunAmmo;
                    break;
                case 8:
                    g.drawString("Ammo: "+Player.awpAmmo,wx,wy1);
                    g.drawString("Sniper rifle",wx,wy2);
                    Player.currentAmmo=Player.awpAmmo;
                    break;
                case 9:
                    g.drawString("Ammo: "+Player.lazerAmmo,wx,wy1);
                    g.drawString("Laser",wx,wy2);
                    Player.currentAmmo=Player.lazerAmmo;
                    break;
                case 0:
                    g.drawString("Ammo: "+Player.singularAmmo,wx,wy1);
                    g.drawString("Alien gun",wx,wy2);
                    Player.currentAmmo=Player.singularAmmo;
                    break;
            }

            g.drawString("Wave: " + (GamePanel.wave.getWaveNumber()-1),wx,wy3);
            //g.drawString("llInc:"+ darkness.llIter,10,130);
            //g.drawString("LowLight:"+ darkness.lowLight,10,150);


            //Show Wave
            if(wave.showWave()){
                wave.draw(g);
            }
        }

        public void gameRender2(){
            backGround.draw(g);
          for(int i=0;i<blocksE.size();i++){
               blocksE.get(i).draw(g);
            }
            pBlock.draw(g);



        }
        public void update2(){
            pBlock.update();
        }

        void createSequencer(){
            try {
                sint = MidiSystem.getSequencer();
                sint.open();
                seq = new Sequence(Sequence.PPQ,4);
                track = seq.createTrack();
            }
            catch (Exception e){
            }
        }

        private void gameDraw(){
            Graphics g2 = this.getGraphics();
            g2.drawImage(image, 0, 0, null);
            g2.dispose();
        }
    void createBlocks(){



    }

}
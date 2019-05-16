package com.vladislavZag.shooter;

import java.awt.*;
import java.util.Random;

/**
 * Created by vladislavZag on 19.06.17.
 */
public class Wave {

    //Fields
    private int waveNumber;
    private long waveTimer;
    private long waveDelay;
    private long waveTimerDiff;

    private int waveMultiplier;

    private String waveText;

    //Constructor
    public Wave(){
        waveNumber=1;
        waveMultiplier = 35;

        waveTimer = 0;
        waveDelay = 5000;
        waveTimerDiff=0;

        waveText = "В О Л Н А  - ";
    }

    //Functions

    public int getWaveNumber(){
        return waveNumber;
    }
    public void setWaveNumber(int a){
        waveNumber = a;

    }

    public void createEnemies(){
        double enemyCount = waveNumber * waveMultiplier;
        int gunSpeed;
        switch (waveNumber){
            case(1):
            while (enemyCount > 0){
                int type =1;
                int rank = 1;
                GamePanel.enemies.add(new Enemy(type,rank,0));
                enemyCount-= type*rank;
            }
            break;
            case(2):
                while (enemyCount > 0){
                    int type = 1;
                    int rank = new Random().nextInt(3)+1;
                    GamePanel.enemies.add(new Enemy(type,rank,0));
                    enemyCount-= type*rank*1.2;
                }
                break;

            case(3):
                while (enemyCount >waveNumber * waveMultiplier / 6 ){
                    int type = 1;
                    int rank = new Random().nextInt(3)+1;
                    GamePanel.enemies.add(new Enemy(type,rank,0));
                    enemyCount-= type*rank;
                }
                while (enemyCount > 0){
                    int type = 2;
                    int rank = 1;
                    GamePanel.enemies.add(new Enemy(type,rank,50 + new Random().nextInt(100)));
                    enemyCount-= type*rank;
                }
                break;
            case(4):
                while (enemyCount > waveNumber * waveMultiplier * 4/5){
                    int type =1;
                    int rank = new Random().nextInt(3)+1;
                    GamePanel.enemies.add(new Enemy(type,rank,0));
                    enemyCount-= type*rank;
                }
                while (enemyCount > 0){
                    int type = 2;
                    int rank = new Random().nextInt(3)+1;
                    GamePanel.enemies.add(new Enemy(type,rank,50 + new Random().nextInt(100)));
                    enemyCount-= type*rank*1.5;
                }
                break;
            case(5):
                while (enemyCount >waveNumber * waveMultiplier * 3/4){
                    int type = 1;
                    int rank = new Random().nextInt(3)+1;
                    GamePanel.enemies.add(new Enemy(type,rank,0));
                    enemyCount-= type*rank;
                }
                while (enemyCount > waveNumber * waveMultiplier /8 ){
                    int type = 2;
                    int rank =  new Random().nextInt(3)+1;
                    GamePanel.enemies.add(new Enemy(type,rank,50 + new Random().nextInt(100)));
                    enemyCount-= type*rank;
                }
                while (enemyCount >0 ){
                    int type = 3;
                    int rank = 1;
                    GamePanel.enemies.add(new Enemy(type,rank,0));
                    enemyCount-= type*rank;
                }
                break;
            case(6):
                while (enemyCount >waveNumber * waveMultiplier * 4/5 ){
                    int type = 1;
                    int rank = new Random().nextInt(3)+1;
                    GamePanel.enemies.add(new Enemy(type,rank,0));
                    enemyCount-= type*rank;
                }
                while (enemyCount > waveNumber * waveMultiplier /5 ){
                    int type = 2;
                    int rank =  new Random().nextInt(3)+1;
                    GamePanel.enemies.add(new Enemy(type,rank,50 + new Random().nextInt(100)));
                    enemyCount-= type*rank;
                }
                while (enemyCount >0 ){
                    int type = 3;
                    int rank = new Random().nextInt(3)+1;
                    GamePanel.enemies.add(new Enemy(type,rank,0));
                    enemyCount-= type*rank;
                }
                break;
            case(7):

                GamePanel.enemies.add(new Enemy(2,4,2));
                GamePanel.enemies.add(new Enemy(3,4,0));
                break;
            case(8):

                //GamePanel.enemies.add(new Enemy(4,4,1));

                break;


        }
        if((waveNumber%2)==0){
            GamePanel.darkness.ld=true;

            GamePanel.backGround.setColor(new Color(74, 68, 99));
        }
        else {
            GamePanel.darkness.ld=false;
            GamePanel.backGround.setColor(new Color(227, 227, 227));

        }
        waveNumber++;

    }

    public void update(){
        if(waveNumber==1){
            waveDelay=9000;
        }
        else waveDelay =5000;

        if(GamePanel.enemies.size()==0 && waveTimer == 0){
            waveTimer = System.nanoTime();
        }
        if(waveTimer > 0){
            waveTimerDiff += (System.nanoTime() - waveTimer)/1000000;
            waveTimer = System.nanoTime();
        }
        if(waveTimerDiff > waveDelay){
            createEnemies();
            waveTimer =0;
            waveTimerDiff =0;

        }

    }
    public boolean showWave(){
        if(waveTimer!=0){
            return true;
        }
        else return false;
    }
    public void draw(Graphics2D g){
        String begin1 = "Колеск - выбор оружия";
        String begin2 = "SPACE - двигаться по направлению курсора";
        String begin3 = "ЛКМ - стрелять вперед";
        String begin4 = "ПКМ - стрелять назад";
        String begin5 = "Четные раунды - день, нечетные - ночь";
        String wave3 = "";
        String wave5 = "";
        String wave7 = "BIG BOSS";
        //String hp = "<= Твои жизни";
        //String am = "<= боеприпасы";
        //String wa = "<= номер текущей волны";
        double divider = waveDelay / 180;
        double alpha = waveTimerDiff/divider;
        alpha = 255 * Math.sin(Math.toRadians(alpha));
        if(alpha < 0) alpha =0;
        if(alpha>255)alpha = 255;
        if(!GamePanel.darkness.ld){
        g.setColor(new Color(2,2,255,(int)alpha));}
        else {
            g.setColor(new Color(100, 248, 255));
        }
        if(waveNumber!=8){
        String s =" - "+ waveNumber + "ая " + waveText;
        long lenght =(int) g.getFontMetrics().getStringBounds(s,g).getWidth();
        g.drawString(s,GamePanel.WIDTH/2 - lenght/2,GamePanel.HEIGHT/2);}
        else{
            String s ="Победа!";
            long lenght =(int) g.getFontMetrics().getStringBounds(s,g).getWidth();
            g.drawString(s,GamePanel.WIDTH/2 - lenght/2,GamePanel.HEIGHT/2);

        }
        if(waveNumber == 3){
            long lenghtWave3 =(int) g.getFontMetrics().getStringBounds(wave3,g).getWidth();
            g.drawString(wave3,GamePanel.WIDTH/2 - lenghtWave3/2,GamePanel.HEIGHT/2 - 60);
        }
        if(waveNumber == 5){
            long lenghtWave5 =(int) g.getFontMetrics().getStringBounds(wave5,g).getWidth();
            g.drawString(wave5,GamePanel.WIDTH/2 - lenghtWave5/2,GamePanel.HEIGHT/2 - 60);
        }
        if(waveNumber == 7){
            long lenghtWave7 =(int) g.getFontMetrics().getStringBounds(wave7,g).getWidth();
            g.drawString(wave7,GamePanel.WIDTH/2 - lenghtWave7/2,GamePanel.HEIGHT/2 - 60);
        }
        if(waveNumber ==1){
        long lenght1 =(int) g.getFontMetrics().getStringBounds(begin1,g).getWidth();
        long lenght2 =(int) g.getFontMetrics().getStringBounds(begin2,g).getWidth();
        long lenght3 =(int) g.getFontMetrics().getStringBounds(begin3,g).getWidth();
        long lenght4 =(int) g.getFontMetrics().getStringBounds(begin4,g).getWidth();
        long lenght5 =(int) g.getFontMetrics().getStringBounds(begin5,g).getWidth();
        g.setColor(new Color(189, 14, 153));
        g.drawString(begin2,GamePanel.WIDTH/2 - lenght2/2,GamePanel.HEIGHT/2 - 60);
        g.drawString(begin3,GamePanel.WIDTH/2 - lenght3/2,GamePanel.HEIGHT/2 - 78);
        g.drawString(begin4,GamePanel.WIDTH/2 - lenght4/2,GamePanel.HEIGHT/2 - 96);
        g.drawString(begin1,GamePanel.WIDTH/2 - lenght1/2,GamePanel.HEIGHT/2 - 114);
        g.drawString(begin5,GamePanel.WIDTH/2 - lenght5/2,GamePanel.HEIGHT/2 - 132);
        //g.drawString(hp,150,30);
        //g.drawString(am,150,50);
        //g.drawString(wa,150,70);
            }
    }
}

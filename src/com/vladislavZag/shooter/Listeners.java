package com.vladislavZag.shooter;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by vladislavZag on 13.06.17.
 */
public class Listeners implements KeyListener, MouseListener,MouseMotionListener, MouseWheelListener{


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_DOWN){
            if(GamePanel.state.equals(GamePanel.STATES.EDITOR)){
            PhantomBlock p = GamePanel.pBlock;
            p.height+=5;}

        }
        if(key == KeyEvent.VK_UP){
            if(GamePanel.state.equals(GamePanel.STATES.EDITOR)){
            PhantomBlock p = GamePanel.pBlock;
            if(p.height>=10){
                p.height-=5;
            }}
        }
        if(key == KeyEvent.VK_LEFT){
            if(GamePanel.state.equals(GamePanel.STATES.EDITOR)){
            PhantomBlock p = GamePanel.pBlock;
            if(p.width>=10){
                p.width-=5;
            }}
        }
        if(key == KeyEvent.VK_RIGHT){
            if(GamePanel.state.equals(GamePanel.STATES.EDITOR)){
            PhantomBlock p = GamePanel.pBlock;
            p.width+=5;}
        }
        if(key == KeyEvent.VK_1){
            Player.myGun=Player.PISTOL;
        }
        if(key == KeyEvent.VK_2){
            Player.myGun=Player.SHOTGUN;
        }
        if(key == KeyEvent.VK_3){
            Player.myGun=Player.SMG;
        }
        if(key == KeyEvent.VK_4){
            Player.myGun=Player.AK;
        }
        if(key == KeyEvent.VK_5){
            Player.myGun=Player.M16;
        }
        if(key == KeyEvent.VK_6){
            Player.myGun=Player.RIFLE;
        }
        if(key == KeyEvent.VK_7){
            Player.myGun=Player.MINIGUN;
        }
        if(key == KeyEvent.VK_8){
            Player.myGun=Player.AWP;
        }
        if(key == KeyEvent.VK_9){
            Player.myGun=Player.LAZER;
        }
        if(key == KeyEvent.VK_0){
            Player.myGun=Player.SINGULARGUN;
        }
        /*if(key == KeyEvent.VK_SPACE){
            Player.isMove=true;
        }*/
        if(key == KeyEvent.VK_I){
            if(GamePanel.darkness.ld){
                GamePanel.darkness.ld=false;
                GamePanel.backGround.setColor(new Color(227, 227, 227));
            }
            else
            {
                GamePanel.darkness.ld=true;
                GamePanel.backGround.setColor(new Color(74, 68, 99));
            }
        }
        if(key == KeyEvent.VK_ENTER){
            GamePanel.enemies.add(new Enemy(4,4,0));
        }
        if(key == KeyEvent.VK_ESCAPE){
            if(GamePanel.state==GamePanel.STATES.PLAY){
                GamePanel.state=GamePanel.STATES.MENUE;
            }
            else{
                GamePanel.state=GamePanel.STATES.PLAY;
            }
        }
        if(key == KeyEvent.VK_K){
            GamePanel.player.setX(GamePanel.mouseX);
            GamePanel.player.setY(GamePanel.mouseY);
        }
        /*if(key == KeyEvent.VK_6){
            Enemy.changeMove();
        }*/
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_UP){
           // GamePanel.darkness.increaceLowLight();
        }
        if(key == KeyEvent.VK_DOWN){
            //GamePanel.darkness.decreaceLowLight();
        }
        if(key == KeyEvent.VK_LEFT){
           // GamePanel.darkness.decreaceLlIter();
        }
        if(key == KeyEvent.VK_RIGHT){
            //GamePanel.darkness.increaceLlIter();
        }

        /*if(key == KeyEvent.VK_SPACE){
            Player.isMove=false;
        }*/

    }


    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            Player.isFiring = true;
            GamePanel.leftMouse = true;
            if(GamePanel.state.equals(GamePanel.STATES.EDITOR)){
                int x =GamePanel.pBlock.getX();
                int y =GamePanel.pBlock.getY();
                int w =GamePanel.pBlock.getWidth();
                int h =GamePanel.pBlock.getHeight();
                Color cc = Color.RED;
                int r = cc.getRed();
                int g = cc.getGreen();
                int b= cc.getBlue();

            GamePanel.blocksE.add(new Block(x,y,w,h,new Color(r,g,b)));
            String s ="blocks.add(new Block("+x+","+y+
                    ","+w+","+h+",new Color("+r+","+g+","+b+")));";



            }

        }


            if(e.getButton() == MouseEvent.BUTTON3){
                Player.isFiring2 = true;

            }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            Player.isFiring = false;
            GamePanel.leftMouse = false;
        }
        if(e.getButton() == MouseEvent.BUTTON3){
            Player.isFiring2 = false;

        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        GamePanel.mouseX=e.getX();
        GamePanel.mouseY=e.getY();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        GamePanel.mouseX = e.getX();
        GamePanel.mouseY = e.getY();


    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int v =e.getWheelRotation();
        Player.myGun = (Player.myGun + 10 + v )%10;

    }
}

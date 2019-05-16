package com.vladislavZag.shooter;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Created by vladislavZag on 20.06.17.
 */
public class Menue {

    //Fields
    private int buttonWidth;
    private int buttonHeight;

    private Color color1;
    private Color color2;
    private Color color3;
    private String s;
    private String s1;
    private String s2;
    private int transp = 0;
    private int transp1 = 0;
    private int transp2 = 0;

    //Constructor

    public Menue(){
        buttonWidth = 120;
        buttonHeight = 60;
        color1 = Color.BLUE;
        color2 = Color.RED;
        color3 = Color.GREEN.darker();
        s = "GO";
        s1="Save";
        s2="Load";

    }

    //Functions

    public void update(){
        if(GamePanel.mouseX > GamePanel.WIDTH/2-buttonWidth/2 &&
                GamePanel.mouseX < GamePanel.WIDTH/2 + buttonWidth/2 &&
                GamePanel.mouseY > GamePanel.HEIGHT/2 - buttonHeight/2 &&
                GamePanel.mouseY < GamePanel.HEIGHT/2 + buttonHeight/2){
            transp = 60;
            if(GamePanel.leftMouse){
                GamePanel.state = GamePanel.STATES.PLAY;
            }
        }else {
            transp = 0;
        }
        if(GamePanel.mouseX > GamePanel.WIDTH/2-buttonWidth/2 &&
                GamePanel.mouseX < GamePanel.WIDTH/2 + buttonWidth/2 &&
                GamePanel.mouseY > GamePanel.HEIGHT/2 - buttonHeight/2 - 100 &&
                GamePanel.mouseY < GamePanel.HEIGHT/2 + buttonHeight/2 - 100){
            transp1 = 60;
            if(GamePanel.leftMouse){
                JFileChooser fileSave = new JFileChooser();
                fileSave.showSaveDialog(GameStart.starFrame);
                saveFile(fileSave.getSelectedFile());


            }
        }else {
            transp1 = 0;
        }
        if(GamePanel.mouseX > GamePanel.WIDTH/2-buttonWidth/2 &&
                GamePanel.mouseX < GamePanel.WIDTH/2 + buttonWidth/2 &&
                GamePanel.mouseY > GamePanel.HEIGHT/2 - buttonHeight/2 + 100 &&
                GamePanel.mouseY < GamePanel.HEIGHT/2 + buttonHeight/2 + 100){
            transp2 = 60;
            if(GamePanel.leftMouse){
                JFileChooser fileLoad = new JFileChooser();
                fileLoad.showOpenDialog(null);
                loadFile(fileLoad.getSelectedFile());
            }
        }else {
            transp2 = 0;
        }
    }
    public void saveFile(File file){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(GamePanel.player.getHealth() + "/" + GamePanel.player.getX()
                    + "/" + GamePanel.player.getY()
            +"/"+ Player.shotGunAmmo + "/" + Player.smgAmmo +
                    "/" + Player.akAmmo + "/" + Player.m16Ammo + "/" + Player.rifleAmmo + "/"+
            Player.minigunAmmo + "/" + Player.awpAmmo + "/" +
                    Player.lazerAmmo + "/" + Player.singularAmmo + "/" + (GamePanel.wave.getWaveNumber()-1));

            writer.close();

        }
        catch (Exception e){
            System.out.println("NO :(");
            e.printStackTrace();
        }
    }
    private void loadFile(File file){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            line = reader.readLine();

            String[] saves = line.split("/");
            double [] asaves = new double[saves.length];
            for(int i=0;i<saves.length;i++){
                asaves[i]= Double.parseDouble(saves[i]);
            }
            GamePanel.player = new Player((int)asaves[0],(int)asaves[1],(int)asaves[2],(int)asaves[3],(int)asaves[4],
                    (int)asaves[5],(int)asaves[6],(int)asaves[7],(int)asaves[8],(int)asaves[9],(int)asaves[10],(int)asaves[11]);

            GamePanel.wave.setWaveNumber((int)asaves[12]);
            reader.close();
            GamePanel.state = GamePanel.STATES.PLAY;

        }
        catch (Exception e){
            System.out.println("Nope :(");
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g){
        g.setColor(color1);
        g.setStroke(new BasicStroke(3));
        g.drawRect(GamePanel.WIDTH/2 - buttonWidth/2,GamePanel.HEIGHT/2 -
                buttonHeight/2,buttonWidth,buttonHeight);
        g.setColor(new Color(0,0,255,transp));
        g.fillRect(GamePanel.WIDTH/2 - buttonWidth/2,GamePanel.HEIGHT/2 -
                buttonHeight/2,buttonWidth,buttonHeight);

        g.setColor(color2);
        g.setStroke(new BasicStroke(3));
        g.drawRect(GamePanel.WIDTH/2 - buttonWidth/2,GamePanel.HEIGHT/2 -
                buttonHeight/2 - 100,buttonWidth,buttonHeight);
        g.setColor(new Color(255,0,255,transp1));
        g.fillRect(GamePanel.WIDTH/2 - buttonWidth/2,GamePanel.HEIGHT/2 -
                buttonHeight/2 - 100,buttonWidth,buttonHeight);


        g.setColor(color3);
        g.setStroke(new BasicStroke(3));
        g.drawRect(GamePanel.WIDTH/2 - buttonWidth/2,GamePanel.HEIGHT/2 -
                buttonHeight/2 + 100,buttonWidth,buttonHeight);
        g.setColor(new Color(0,220,00,transp2));
        g.fillRect(GamePanel.WIDTH/2 - buttonWidth/2,GamePanel.HEIGHT/2 -
                buttonHeight/2 + 100,buttonWidth,buttonHeight);

        g.setStroke(new BasicStroke(1));
        g.setColor(color1);
        g.setFont(new Font("Consolas",Font.BOLD,40));

        long lenght = (int)(g.getFontMetrics().getStringBounds(s,g).getWidth());
        g.drawString(s,(int)(GamePanel.WIDTH/2 - lenght/2),(int)(GamePanel.HEIGHT/2 + buttonHeight/4));

        g.setColor(color2);
        long lenght1 = (int)(g.getFontMetrics().getStringBounds(s1,g).getWidth());
        g.drawString(s1,(int)(GamePanel.WIDTH/2 - lenght1/2 ),(int)(GamePanel.HEIGHT/2 + buttonHeight/4)-100);

        g.setColor(color3);
        long lenght2 = (int)(g.getFontMetrics().getStringBounds(s2,g).getWidth());
        g.drawString(s2,(int)(GamePanel.WIDTH/2 - lenght2/2),(int)(GamePanel.HEIGHT/2 + buttonHeight/4)+100);

    }
}

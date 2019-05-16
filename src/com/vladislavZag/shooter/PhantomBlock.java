package com.vladislavZag.shooter;

import java.awt.*;

/**
 * Created by vladislavZag on 30.11.2017.
 */
public class PhantomBlock extends Block {

    public PhantomBlock(int width, int height, Color c) {
        super(GamePanel.mouseX, GamePanel.mouseY, width, height, c);
        super.color=new Color(c.getRed(),c.getGreen(),c.getBlue(),100);
    }
    public void update(){
        super.x=GamePanel.mouseX;
        super.y=GamePanel.mouseY;
    }
}

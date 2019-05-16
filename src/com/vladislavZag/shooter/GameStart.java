package com.vladislavZag.shooter;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vladislavZag on 13.06.17.
 */
public class GameStart {
    static JFrame starFrame;
    public static void main(String[] args) {
        GamePanel panel = new GamePanel();
        panel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        starFrame = new JFrame("Game");
        starFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        starFrame.getContentPane().add(panel);
        starFrame.pack();
        starFrame.setResizable(false);
        starFrame.setLocationRelativeTo(null);
        panel.start();
        starFrame.setVisible(true);

    }

}

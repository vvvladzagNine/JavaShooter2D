package com.vladislavZag.shooter;

/**
 * Created by vladislavZag on 31.08.17.
 */
public class DropText {
    String s;
    private long timer;
    private long timeDelay;
    private long timeDiff;
    public DropText(String s){
        this.s = s;
        timeDelay=5000;
    }

    public void update(){
        long t =System.nanoTime()/1000000;
    }
}

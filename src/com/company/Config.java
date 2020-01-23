package com.company;

import java.awt.*;

public class Config {
    public static final int SIZE = 10;
    public static final int WIDTH = 100;
    public static final int SLEEP = 100;
    public static final int HEIGHT = 75;
    
    
    public static Color getColor(Status status){
        switch (status){

            default:
            case NONE: return Color.BLACK;
            case BORN: return Color.GRAY;
            case LIVE: return Color.GRAY;
            case DIED: return Color.GRAY;

        }
        
    }
}

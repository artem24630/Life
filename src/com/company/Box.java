package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Box extends JPanel {
    Cell cell;

    public Box(int x,int y){
        super();
        setBounds(x* Config.SIZE,y*Config.SIZE,Config.SIZE,Config.SIZE);
        setBackground(Config.getColor(Status.NONE));
        cell = new Cell();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cell.turn();
            }
        });

    }


   void step1(){
        cell.step1();
        setBackground(Config.getColor(cell.status));
   }
   void step2(){
        cell.step2();
       setBackground(Config.getColor(cell.status));
   }
    public void setColor(){
        setBackground(Config.getColor(cell.status));
    }
}

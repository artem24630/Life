package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable {
    JFrame frame;
    Box[][] boxes;


    @Override
    public void run() {
        initFrame();
        initBoxes();
        initTime();
    }

    private void initTime() {
        TimerListener tl = new TimerListener();
        Timer timer = new Timer(Config.SLEEP,tl);
        timer.start();
    }
    private class TimerListener implements ActionListener {
        boolean flop=false;

        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;
            for (int x = 0; x < Config.WIDTH; x++) {
                for (int i = 0; i < Config.HEIGHT; i++) {
                    if(flop)
                    boxes[x][i].step1();
                    else
                    boxes[x][i].step2();
                }
            }
        }
    }
    private void initBoxes() {
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        for(int x = 0;x < Config.WIDTH;x++){
            for (int i = 0; i < Config.HEIGHT; i++) {

                boxes[x][i] = new Box(x,i);
                frame.add(boxes[x][i]);
            }
        }

        for(int x = 0;x < Config.WIDTH;x++) {
            for (int i = 0; i < Config.HEIGHT; i++) {
                for(int sx = -1;sx<=+1;sx++){
                    for(int sy = -1;sy<=+1;sy++){
                        if(!(sx==0 && sy == 0))
                            boxes[x][i].cell.addNear(boxes[(x+sx+Config.WIDTH)% Config.WIDTH][(i+sy+Config.HEIGHT)%Config.HEIGHT].cell);
                    }

                }
            }

        }


    }

    private void initFrame() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(Config.SIZE* Config.WIDTH,Config.SIZE* Config.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Life Game");
    }
}

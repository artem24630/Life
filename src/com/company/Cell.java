package com.company;

import java.util.ArrayList;

public class Cell {
    ArrayList<Cell> near;

    Status status;

    void addNear(Cell cell){
        near.add(cell);

    }


    public Cell() {
        this.status = Status.NONE;
        near = new ArrayList<>();
    }

     void step1(){

        int around = countNearCells();
        status = status.step1(around);

    }

    private int countNearCells() {
        int count = 0;
        for (Cell c: near
             ) {
            if(c.status.isAlive())
                count++;

        }
        return count;
    }

     void step2(){
        status = status.step2();
    }


    public void turn() {
        for (Cell cell: near
             ) {
            cell.status = cell.status.isAlive() ? Status.NONE: Status.LIVE;
        }

    }
}

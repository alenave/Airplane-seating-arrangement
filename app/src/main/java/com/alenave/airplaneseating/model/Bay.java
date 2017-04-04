package com.alenave.airplaneseating.model;

/**
 * Created by alenave on 03/04/17.
 */

public class Bay implements Comparable<Bay>{
    int row;
    int column;

    public Bay(){

    }

    public Bay(int row, int column) {
        this.row = row;
        this.column = column;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public int compareTo(Bay bay) {
        if(bay.getRow() < row) {
            return 1;
        }
        return -1;
    }
}

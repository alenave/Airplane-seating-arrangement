package com.alenave.airplaneseating.model;

/**
 * Created by alenave on 03/04/17.
 */

public class Middle {
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

    int row;
    int column;

    public int getBay() {
        return bay;
    }

    public void setBay(int bay) {
        this.bay = bay;
    }

    int bay;
}
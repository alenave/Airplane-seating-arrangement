package com.alenave.airplaneseating.model;

/**
 * Created by alenave on 03/04/17.
 */

public class Window {
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

    public int getBay() {
        return bay;
    }

    public void setBay(int bay) {
        this.bay = bay;
    }

    int row;
    int column;
    int bay;

}

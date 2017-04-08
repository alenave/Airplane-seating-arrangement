package com.alenave.airplaneseating.model;

/**
 * Created by alenave on 06/04/17.
 */

public class Seat implements Comparable<Seat> {
    private int row;
    private int column;
    private String type;
    private int number;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Seat seat) {

        int result = Integer.compare(row, seat.getRow());
        if (result == 0) {
            result = Integer.compare(column, seat.getColumn());
        }
        return result;
    }
}
package com.alenave.airplaneseating.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alenave on 03/04/17.
 */

public class Bay implements Comparable<Bay> {
    private int row;
    private int column;
    private List<Seat> seatList;

    public Bay(){}

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(Seat seat) {
        this.seatList = getInstance();
        this.seatList.add(seat);
    }

    private List<Seat> getInstance() {
        if(seatList == null) {
            return new ArrayList<>();
        }
        return seatList;
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

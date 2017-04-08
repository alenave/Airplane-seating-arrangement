package com.alenave.airplaneseating.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.alenave.airplaneseating.util.MagicNumbers.AISLE;
import static com.alenave.airplaneseating.util.MagicNumbers.MIDDLE;
import static com.alenave.airplaneseating.util.MagicNumbers.WINDOW;

/**
 * Created by alenave on 03/04/17.
 */

public class SeatArrangement {
    List<Bay> bays;
    Seat seat;

    public SeatArrangement() {
    }

    public SeatArrangement(List<Bay> bays) {
        if (this.bays != null) {
            this.bays.clear();
        }
        this.bays = new ArrayList<>(bays);
    }

    public List<Bay> getBays() {
        return bays;
    }

    public void setArrangement() {
        if (bays.size() == 0) {
            return;
        }
        int seatNumber = 0;
        for (int rowIndex = 0; rowIndex < Collections.max(bays).getRow(); rowIndex++) {

            for (int bayIndex = 0; bayIndex < bays.size(); bayIndex++) {
                if (!(bays.get(bayIndex).getColumn() <= 1)) {
                    if (bayIndex == 0 && rowIndex < bays.get(bayIndex).getRow()) {
                        seat = new Seat();
                        seat.setRow(rowIndex);
                        seat.setColumn(bays.get(bayIndex).getColumn() - 1);
                        seat.setType(AISLE);
                        seatNumber++;
                        seat.setNumber(seatNumber);
                        bays.get(bayIndex).setSeatList(seat);
                    } else if (bayIndex == bays.size() - 1) {
                        seat = new Seat();
                        seat.setRow(rowIndex);
                        seat.setColumn(0);
                        seat.setType(AISLE);
                        seatNumber++;
                        seat.setNumber(seatNumber);
                        bays.get(bayIndex).setSeatList(seat);

                    } else if (rowIndex < bays.get(bayIndex).getRow()) {
                        seat = new Seat();
                        seat.setRow(rowIndex);
                        seat.setColumn(0);
                        seat.setType(AISLE);
                        seatNumber++;
                        seat.setNumber(seatNumber);
                        bays.get(bayIndex).setSeatList(seat);

                        seat = new Seat();
                        seat.setRow(rowIndex);
                        seat.setColumn(bays.get(bayIndex).getColumn() - 1);
                        seat.setType(AISLE);
                        seatNumber++;
                        seat.setNumber(seatNumber);
                        bays.get(bayIndex).setSeatList(seat);
                    }
                } else {
                    break;
                }
            }
        }

        //                set Window

        for (int rowIndex = 0; rowIndex < Collections.max(bays).getRow(); rowIndex++) {

            for (int bayIndex = 0; bayIndex < bays.size(); bayIndex++) {
                if (bayIndex == 0 && rowIndex < bays.get(bayIndex).getRow()) {
                    seat = new Seat();
                    seat.setRow(rowIndex);
                    seat.setColumn(0);
                    seat.setType(WINDOW);
                    seatNumber++;
                    seat.setNumber(seatNumber);
                    bays.get(bayIndex).setSeatList(seat);
                } else if (bayIndex == bays.size() - 1) {
                    seat = new Seat();
                    seat.setRow(rowIndex);
                    seat.setColumn(bays.get(bayIndex).getColumn() - 1);
                    seat.setType(WINDOW);
                    seatNumber++;
                    seat.setNumber(seatNumber);
                    bays.get(bayIndex).setSeatList(seat);
                }
            }
        }
        //                set middle

        for (int rowIndex = 0; rowIndex < Collections.max(bays).getRow(); rowIndex++) {

            for (int bayIndex = 0; bayIndex < bays.size(); bayIndex++) {
                if (!(bays.get(bayIndex).getColumn() <= 2) && bays.get(bayIndex).getColumn() > 2) {
                    int numberOfMiddle = bays.get(bayIndex).getColumn() - 2;

                    for (int columnIndex = 1; columnIndex <= numberOfMiddle && rowIndex < bays.get(bayIndex).getRow(); columnIndex++) {
                        seat = new Seat();
                        seat.setRow(rowIndex);
                        seat.setColumn(columnIndex);
                        seat.setType(MIDDLE);
                        seatNumber++;
                        seat.setNumber(seatNumber);
                        bays.get(bayIndex).setSeatList(seat);
                    }
                }
            }
        }

// arranging seats in bay in aisle -> window -> middle
        for (int bayIndex = 0; bayIndex < bays.size(); bayIndex++) {
            Collections.sort(bays.get(bayIndex).getSeatList());
        }
    }

    public List<Seat> getArrangement(int bayNumber) {
        return bays.get(bayNumber).getSeatList();
    }
}
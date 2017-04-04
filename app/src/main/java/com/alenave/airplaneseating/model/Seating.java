package com.alenave.airplaneseating.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.alenave.airplaneseating.MainActivity.bays;

/**
 * Created by alenave on 03/04/17.
 */

public class Seating {
    List<Bay> bays;
    List<Aisle> aisles;
    List<Middle> middles;
    List<Window> windows;

    public Seating() {
    }


    public Seating(List<Bay> bays) {
        this.bays = new ArrayList<>(bays);
    }

    public List<Bay> getBays() {
        return bays;
    }

    public void setAisle() {
        aisles = new ArrayList<>();
        Aisle aisle;
        if (bays.size() == 0) {
            return;
        }
        for (int rowIndex = 0; rowIndex < Collections.max(bays).getRow(); rowIndex++) {

            for (int bayIndex = 0; bayIndex < bays.size(); bayIndex++) {

                aisle = new Aisle();

                if (bayIndex == 0 && rowIndex < bays.get(bayIndex).getRow()) {
                    aisle.setRow(rowIndex);
                    aisle.setColumn(bays.get(bayIndex).getColumn() - 1);
                    aisle.setBay(bayIndex);
                    aisles.add(aisle);
                } else if (bayIndex == bays.size() - 1) {
                    aisle.setRow(rowIndex);
                    aisle.setColumn(0);
                    aisle.setBay(bayIndex);
                    aisles.add(aisle);
                } else if (rowIndex < bays.get(bayIndex).getRow()) {
                    aisle.setRow(rowIndex);
                    aisle.setColumn(0);
                    aisle.setBay(bayIndex);
                    aisles.add(aisle);
                    aisle = new Aisle();
                    aisle.setRow(rowIndex);
                    aisle.setColumn(bays.get(bayIndex).getColumn() - 1);
                    aisle.setBay(bayIndex);
                    aisles.add(aisle);
                }
            }
        }
    }

    public void setMiddle() {
        middles = new ArrayList<>();
        Middle middle;

        for (int rowIndex = 0; rowIndex < Collections.max(bays).getRow(); rowIndex++) {

            for (int bayIndex = 0; bayIndex < bays.size(); bayIndex++) {

                if (bays.get(bayIndex).getColumn() <= 2) {
                    continue;
                } else if (bays.get(bayIndex).getColumn() > 2) {
                    int numberOfMiddle = bays.get(bayIndex).getColumn() - 2;

                    for (int columnIndex = 1; columnIndex <= numberOfMiddle && rowIndex < bays.get(bayIndex).getRow(); columnIndex++) {
                        middle = new Middle();
                        middle.setRow(rowIndex);
                        middle.setColumn(columnIndex);
                        middle.setBay(bayIndex);
                        middles.add(middle);
                    }
                }
            }
        }
    }

    public void setWindow() {
        windows = new ArrayList<>();
        Window window;

        for (int rowIndex = 0; rowIndex < Collections.max(bays).getRow(); rowIndex++) {

            for (int bayIndex = 0; bayIndex < bays.size(); bayIndex++) {
                window = new Window();
                if (bayIndex == 0 && rowIndex < bays.get(bayIndex).getRow()) {
                    window.setRow(rowIndex);
                    window.setColumn(0);
                    window.setBay(bayIndex);
                    windows.add(window);
                } else if (bayIndex == bays.size() - 1) {
                    window.setRow(rowIndex);
                    window.setColumn(bays.get(bayIndex).getColumn() - 1);
                    window.setBay(bayIndex);
                    windows.add(window);
                }
            }
        }
    }

    public List<Aisle> getAisles() {
        return aisles;
    }

    public List<Middle> getMiddles() {
        return middles;
    }

    public List<Window> getWindows() {
        return windows;
    }

}
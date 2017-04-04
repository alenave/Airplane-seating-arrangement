package com.alenave.airplaneseating.model;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alenave on 03/04/17.
 */
public class SeatingTest extends TestCase {
    Bay bay_one, bay_two, bay_three, bay_four;
    List<Bay> bays;
    Seating seating;

    @Before
    public void setUp() throws Exception {
        bay_one = new Bay(2, 3);
        bay_two = new Bay(3, 4);
        bay_three = new Bay(3, 2);
        bay_four = new Bay(4, 3);
        bays = new ArrayList<>();
        bays.add(bay_one);
        bays.add(bay_two);
        bays.add(bay_three);
        bays.add(bay_four);
        seating = new Seating(bays);
        seating.setAisle();
        seating.setWindow();
        seating.setMiddle();
    }

    public void test_number_of_bay() throws Exception {
        assertEquals(4, seating.getBays().size());
    }

    public void test_check_aisle() throws Exception {
        assertEquals(0, seating.getAisles().get(0).getRow());
        assertEquals(2, seating.getAisles().get(0).getColumn());
        assertEquals(0, seating.getAisles().get(1).getRow());
        assertEquals(0, seating.getAisles().get(1).getColumn());
        assertEquals(3, seating.getAisles().get(2).getColumn());
    }


    public void test_check_window() throws Exception {
        assertEquals(0, seating.getWindows().get(0).getRow());
        assertEquals(0, seating.getWindows().get(0).getColumn());
        assertEquals(0, seating.getWindows().get(1).getRow());
        assertEquals(2, seating.getWindows().get(1).getColumn());
        assertEquals(0, seating.getWindows().get(2).getColumn());
    }

    public void test_check_middle() throws Exception {
        assertEquals(0, seating.getMiddles().get(0).getRow());
        assertEquals(1, seating.getMiddles().get(0).getColumn());
        assertEquals(0, seating.getMiddles().get(1).getRow());
        assertEquals(1, seating.getMiddles().get(1).getColumn());
        assertEquals(2, seating.getMiddles().get(2).getColumn());
    }
}
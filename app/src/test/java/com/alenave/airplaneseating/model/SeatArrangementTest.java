package com.alenave.airplaneseating.model;

import junit.framework.TestCase;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alenave on 03/04/17.
 */
public class SeatArrangementTest extends TestCase {
    Bay bayOne, bayTwo, bayThree, bayFour;
    List<Bay> baysOne, baysTwo;
    SeatArrangement seatArrangementOne, seatArrangementTwo;

    @Before
    public void setUp() throws Exception {
        bayOne = new Bay(2, 3);
        bayTwo = new Bay(3, 4);
        bayThree = new Bay(3, 2);
        bayFour = new Bay(4, 3);
        baysOne = new ArrayList<>();
        baysOne.add(bayOne);
        baysOne.add(bayTwo);
        baysOne.add(bayThree);
        baysOne.add(bayFour);
        seatArrangementOne = new SeatArrangement(baysOne);
        seatArrangementOne.setArrangement();
        baysOne.clear();
        bayOne = new Bay(1, 1);
        bayTwo = new Bay(1, 1);
        baysTwo = new ArrayList<>();
        baysTwo.add(bayOne);
        baysTwo.add(bayTwo);
        seatArrangementTwo = new SeatArrangement(baysTwo);
        seatArrangementTwo.setArrangement();
    }

    public void test_number_of_bay() throws Exception {
        assertEquals(4, seatArrangementOne.getBays().size());
    }

    public void test_check_aisle() throws Exception {
        assertEquals(0, seatArrangementOne.getArrangement(0).get(2).getRow());
        assertEquals(2, seatArrangementOne.getArrangement(0).get(2).getColumn());
        assertEquals(1, seatArrangementOne.getArrangement(0).get(2).getNumber());
        assertEquals("aisle", seatArrangementOne.getArrangement(0).get(2).getType());
        assertEquals(false, "middle".equals(seatArrangementOne.getArrangement(0).get(2).getType()));

        assertEquals(1, seatArrangementOne.getArrangement(0).get(5).getRow());
        assertEquals(2, seatArrangementOne.getArrangement(0).get(5).getColumn());
        assertEquals(7, seatArrangementOne.getArrangement(0).get(5).getNumber());
        assertEquals("aisle", seatArrangementOne.getArrangement(0).get(5).getType());
        assertEquals(false, "window".equals(seatArrangementOne.getArrangement(0).get(5).getType()));

        assertEquals(1, seatArrangementOne.getArrangement(2).get(3).getRow());
        assertEquals(1, seatArrangementOne.getArrangement(2).get(3).getColumn());
        assertEquals(11, seatArrangementOne.getArrangement(2).get(3).getNumber());
        assertEquals("aisle", seatArrangementOne.getArrangement(2).get(3).getType());
        assertEquals(false, "middle".equals(seatArrangementOne.getArrangement(2).get(3).getType()));
    }


    public void test_check_window() throws Exception {
        assertEquals(1, seatArrangementTwo.getArrangement(0).get(0).getNumber());
        assertEquals(2, seatArrangementTwo.getArrangement(1).get(0).getNumber());

        assertEquals("window", seatArrangementTwo.getArrangement(0).get(0).getType());
        assertEquals("window", seatArrangementTwo.getArrangement(1).get(0).getType());

        assertEquals(0, seatArrangementOne.getArrangement(0).get(0).getRow());
        assertEquals(0, seatArrangementOne.getArrangement(0).get(0).getColumn());
        assertEquals(19, seatArrangementOne.getArrangement(0).get(0).getNumber());
        assertEquals("window", seatArrangementOne.getArrangement(0).get(0).getType());
        assertEquals(false, "aisle".equals(seatArrangementOne.getArrangement(0).get(0).getType()));

        assertEquals(1, seatArrangementOne.getArrangement(0).get(3).getRow());
        assertEquals(0, seatArrangementOne.getArrangement(0).get(3).getColumn());
        assertEquals(21, seatArrangementOne.getArrangement(0).get(3).getNumber());
        assertEquals("window", seatArrangementOne.getArrangement(0).get(3).getType());
        assertEquals(false, "aisle".equals(seatArrangementOne.getArrangement(0).get(3).getType()));

        assertEquals(0, seatArrangementOne.getArrangement(3).get(2).getRow());
        assertEquals(2, seatArrangementOne.getArrangement(3).get(2).getColumn());
        assertEquals(20, seatArrangementOne.getArrangement(3).get(2).getNumber());
        assertEquals("window", seatArrangementOne.getArrangement(3).get(2).getType());
        assertEquals(false, "aisle".equals(seatArrangementOne.getArrangement(3).get(2).getType()));

        assertEquals(3, seatArrangementOne.getArrangement(3).get(11).getRow());
        assertEquals(2, seatArrangementOne.getArrangement(3).get(11).getColumn());
        assertEquals(24, seatArrangementOne.getArrangement(3).get(11).getNumber());
        assertEquals("window", seatArrangementOne.getArrangement(3).get(11).getType());
        assertEquals(false, "aisle".equals(seatArrangementOne.getArrangement(3).get(11).getType()));
    }

    public void test_check_middle() throws Exception {
        assertEquals(0, seatArrangementOne.getArrangement(3).get(1).getRow());
        assertEquals(1, seatArrangementOne.getArrangement(3).get(1).getColumn());
        assertEquals(28, seatArrangementOne.getArrangement(3).get(1).getNumber());
        assertEquals("middle", seatArrangementOne.getArrangement(3).get(1).getType());
        assertEquals(false, "aisle".equals(seatArrangementOne.getArrangement(3).get(1).getType()));

        assertEquals(25, seatArrangementOne.getArrangement(0).get(1).getNumber());
        assertEquals(26, seatArrangementOne.getArrangement(1).get(1).getNumber());
        assertEquals(27, seatArrangementOne.getArrangement(1).get(2).getNumber());

    }
}
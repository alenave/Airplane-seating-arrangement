package com.alenave.airplaneseating.model;

import junit.framework.TestCase;

import org.junit.Before;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by alenave on 04/04/17.
 */
public class BayTest extends TestCase{
    Bay bay_one, bay_two, bay_three, bay_four;
    List<Bay> bays;
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
    }


    public void test_size_of_bay() throws Exception {
        assertEquals(4, bays.size());
    }

    public void test_number_of_row_and_column() throws Exception {
        assertEquals(2, bay_one.getRow());
        assertEquals(3, bay_one.getColumn());
        assertEquals(3, bay_two.getRow());
        assertEquals(4, bay_two.getColumn());
        assertEquals(3, bay_three.getRow());
        assertEquals(2, bay_three.getColumn());
        assertEquals(4, bay_four.getRow());
        assertEquals(3, bay_four.getColumn());
    }

    public void test_first_greater_than_second() throws Exception {
        assertNotEquals(2, Collections.max(bays).getRow());
        assertEquals(4, Collections.max(bays).getRow());
    }

}
package com.alenave.airplaneseating.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.alenave.airplaneseating.R;
import com.alenave.airplaneseating.model.Aisle;
import com.alenave.airplaneseating.model.Middle;
import com.alenave.airplaneseating.model.Seating;
import com.alenave.airplaneseating.model.Window;

import static com.alenave.airplaneseating.MainActivity.bays;

public class SeatDisplay extends AppCompatActivity {
    private TextView arrangement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_display);
        initViewAndSetListeners();
        displaySeats();
    }

    private void initViewAndSetListeners() {
        arrangement = (TextView) findViewById(R.id.arrangment);
    }

    private void displaySeats() {
        Seating seating = new Seating(bays);
        String sequence = "";
        seating.setAisle();
        for(Aisle aisle : seating.getAisles()) {
            sequence += aisle.getBay() + " " + aisle.getRow() + "," + aisle.getColumn() + " Aisle" + "\n";
        }
        seating.setWindow();
        for(Window window : seating.getWindows()) {
            sequence += window.getBay() + " " +  window.getRow() + "," + window.getColumn() + " Win" + "\n";
        }
        seating.setMiddle();
        for(Middle middle : seating.getMiddles()) {
            sequence += middle.getBay() + " " + middle.getRow() + "," + middle.getColumn() + " Mid" + "\n";
        }
        arrangement.setText(sequence);
    }
}

package com.alenave.airplaneseating.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alenave.airplaneseating.R;
import com.alenave.airplaneseating.adapter.SeatAdapter;
import com.alenave.airplaneseating.model.SeatArrangement;

import static com.alenave.airplaneseating.MainActivity.bays;

public class SeatDisplay extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SeatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_display);
        initViewAndSetListeners();
        displaySeats();
    }

    private void initViewAndSetListeners() {
        recyclerView = (RecyclerView) findViewById(R.id.primary_recycler_view);
    }

    private void displaySeats() {
        SeatArrangement seatArrangement = new SeatArrangement(bays);
        seatArrangement.setArrangement();
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), bays.size());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SeatAdapter(this, bays);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

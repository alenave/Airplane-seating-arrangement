package com.alenave.airplaneseating.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alenave.airplaneseating.R;
import com.alenave.airplaneseating.model.Bay;
import com.alenave.airplaneseating.model.Seat;

import java.util.ArrayList;
import java.util.List;

import static com.alenave.airplaneseating.util.MagicNumbers.AISLE;
import static com.alenave.airplaneseating.util.MagicNumbers.WINDOW;

/**
 * Created by alenave on 06/04/17.
 */

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.PrimaryViewHolder> {
    private Context context;
    private List<Bay> bayList = new ArrayList<>();
    private final int VIEW_TYPE_CELL = 1;
    private final int VIEW_TYPE_FOOTER = 2;

    public SeatAdapter() {

    }

    public SeatAdapter(Context context, List<Bay> bayList) {
        this.context = context;
        this.bayList = bayList;
    }

    @Override
    public SeatAdapter.PrimaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.secondry_grid, null);
        PrimaryViewHolder viewHolder = new PrimaryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SeatAdapter.PrimaryViewHolder holder, int position) {
        Bay bay = bayList.get(position);
        holder.bindViews(bay);
    }

    @Override
    public int getItemCount() {
        return (null != bayList ? bayList.size() : 0);
    }

    @Override
    public int getItemViewType(int position) {
        return ((position + 1) == bayList.size()) ? VIEW_TYPE_FOOTER : VIEW_TYPE_CELL;
    }

    public class PrimaryViewHolder extends RecyclerView.ViewHolder {
        private SecondaryAdapter secondaryAdapter;
        protected RecyclerView mSecondaryRecyclerView;

        public PrimaryViewHolder(View view) {
            super(view);
            mSecondaryRecyclerView = (RecyclerView) itemView.findViewById(R.id.secondary_recycler_view);
        }

        public void bindViews(Bay bay) {
            LinearLayoutManager linearLayoutManager = new GridLayoutManager(context, bay.getColumn());
            mSecondaryRecyclerView.setLayoutManager(linearLayoutManager);
            secondaryAdapter = new SecondaryAdapter(bay.getSeatList());
            mSecondaryRecyclerView.setAdapter(secondaryAdapter);
            secondaryAdapter.notifyDataSetChanged();
        }


    }


    private class SecondaryViewHolder extends RecyclerView.ViewHolder {

        private View seatView;
        private TextView seatNumber;

        public SecondaryViewHolder(View view) {
            super(view);
            seatView = (View) itemView.findViewById(R.id.seat_view);
            seatNumber = (TextView) itemView.findViewById(R.id.seat_number);

        }

        public void bindView(Seat seat) {
            seatNumber.setText(String.valueOf(seat.getNumber()));
            if (seat.getType().equals(AISLE)) {
                seatView.setBackgroundColor(Color.BLUE);
            } else if (seat.getType().equals(WINDOW)) {
                seatView.setBackgroundColor(Color.GREEN);
            } else {
                seatView.setBackgroundColor(Color.RED);
            }
        }
    }

    private class SecondaryAdapter extends RecyclerView.Adapter<SeatAdapter.SecondaryViewHolder> {
        private List<Seat> seatList;

        public SecondaryAdapter(List<Seat> seatList) {
            this.seatList = seatList;
        }

        @Override
        public SecondaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seat, null);
            SecondaryViewHolder viewHolder = new SecondaryViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(SecondaryViewHolder holder, int position) {
            Seat seat = seatList.get(position);
            holder.bindView(seat);
        }

        @Override
        public int getItemCount() {
            return (null != seatList ? seatList.size() : 0);
        }
    }

}


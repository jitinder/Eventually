package com.example.android.uclapi;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sidak on 08-10-2017.
 */

public class EventAdapter extends BaseAdapter {
    ArrayList<Event> eventArrayList;
    Context c;

    public EventAdapter(Context c, ArrayList<Event> list) {
        eventArrayList = list;
        this.c = c;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return eventArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return eventArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View row = null;
        LayoutInflater inflater = (LayoutInflater) c
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            row = inflater.inflate(R.layout.event_placeholder, parent,
                    false);
        } else {
            row = convertView;
        }

        Event event = eventArrayList.get(position);
        TextView eventNameTV = (TextView) row.findViewById(R.id.event_place_name);
        eventNameTV.setText(event.eventName);
        TextView desc = (TextView) row.findViewById(R.id.event_place_desc);
        desc.setText(event.eventDesc);
        TextView location = (TextView) row.findViewById(R.id.event_place_loc);
        location.setText(event.eventLoc);
        TextView price= (TextView) row.findViewById(R.id.event_place_price);
        price.setText("Price: " +event.eventPrice);
        TextView avail = (TextView) row.findViewById(R.id.event_place_availability);
        avail.setText(event.availableEventSlots +"\navailable");
        TextView time = (TextView) row.findViewById(R.id.event_place_start_time);
        time.setText("Unix: " +event.startUnix);

        LinearLayout eventBack = (LinearLayout) row.findViewById(R.id.event_place_background);
        int cat = event.sumCategory;
        boolean categArray[] = {false, false, false, false, false, false, false, false};
        for(int i=0;i<8;i++){
            categArray[i] = (((cat & (1 << i)) > 0));
        }
        ImageView priceImg = (ImageView) row.findViewById(R.id.event_price_indicator);
        int color;
        if (event.eventPrice > 0){
            color = R.color.notfree;
        } else {
            color = R.color.free;
            price.setText("Free");
        }
        priceImg.setColorFilter(color);
        return row;
    }
}

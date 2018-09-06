package com.example.android.uclapi;

/**
 * Created by Sidak on 08-10-2017.
 */

public class Event {

    public String eventName, eventDesc, eventLoc, creatorUser, creatorFullName;
    public int startUnix, totalEventSlots, availableEventSlots, sumCategory, endUnix;
    public double eventPrice;
    public boolean free;

    public Event(String name, String description, String location, int startTimeStamp, int totalSlots, int availableSlots,
                 String creatorUsername, String creatorName, int sumCat, int endTimeStamp, double price){
        this.eventName = name;
        this.eventDesc = description;
        this.eventLoc = location;
        this.startUnix = startTimeStamp;
        this.totalEventSlots = totalSlots;
        this.availableEventSlots = availableSlots;
        this.creatorUser = creatorUsername;
        this.creatorFullName = creatorName;
        this.sumCategory = sumCat;
        this.endUnix = endTimeStamp;
        this.eventPrice = price;
        if(price > 0){
            this.free = true;
        } else {
            this.free = false;
        }
    }

}

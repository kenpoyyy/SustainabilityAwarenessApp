package com.example.sustainabilityapp;

public class EventItem {
    //private int imageResource; // Resource ID for image
    String eventNumber;
    String eventType;
    String eventDescription;
    String activityClassName;

    // Constructor and getters (and setters if necessary)
    public EventItem( String eventNumber, String eventType, String eventDescription,String activityClassName) {
        // this.imageResource = imageResource;
        this.eventNumber = eventNumber;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.activityClassName = activityClassName;
    }

    public EventItem(){

    }

    // Getters
    //public int getImageResource() { return imageResource; }
    public String getEventNumber() { return eventNumber; }
    public String getEventType() { return eventType; }
    public String getEventDescription() { return eventDescription; }
    public String getActivityClassName() {
        return activityClassName;
    }
}



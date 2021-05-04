package com.example.boxticketingwebapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventId;

    private String date;

    private String name;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public EventModel(){

    }

    public EventModel(int eventId, String date, String name) {
        this.eventId = eventId;
        this.date = date;
        this.name = name;
    }
}

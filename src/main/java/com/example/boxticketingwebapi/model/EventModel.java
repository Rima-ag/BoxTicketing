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

    private String venue;

    private String description;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventModel(){

    }

    public EventModel(int eventId, String date, String name) {
        this.eventId = eventId;
        this.date = date;
        this.name = name;
    }
}

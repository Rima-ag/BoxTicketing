package com.example.boxticketingwebapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "EVENT")
public class EventModel extends RepresentationModel<EventModel> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventid;

    private String date;

    private String name;

    private String venue;

    private String description;

    public int getEventId() {
        return eventid;
    }

    public void setEventId(int eventid) {
        this.eventid = eventid;
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

    @JsonCreator
    public EventModel(String date, String name,
                      String venue,String description) {
        this.date = date;
        this.name = name;
        this.venue = venue;
        this.description = description;
    }
}

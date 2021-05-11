package com.example.boxticketingwebapi.service;


import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.repo.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.*;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private IEventRepo eventRepo;

    public List<EventModel> getAllEvents(){
        ArrayList<EventModel> events = new ArrayList<EventModel>();
        this.eventRepo.findAll().forEach(events::add);
        return events;
    }

    public EventModel getEventDetails(Integer id){
        return this.eventRepo.findById(id).orElse(null);
    }

    public EventModel saveEvent(EventModel event){
        return eventRepo.save(event);
    }

    public String deleteEvent(Integer id){
        eventRepo.deleteById(id);
        return "Event Deleted !";
    }

}

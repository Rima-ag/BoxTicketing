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

    public List<EventModel> getAllEvents() throws Exception {
        //ArrayList<EventModel> events = new ArrayList<EventModel>();
        List<EventModel> events = (List<EventModel>) this.eventRepo.findAll();
        if(events.size()>0){
            throw new Exception("List is Empty");
        }
        return events;
    }

    public EventModel getEventDetails(Integer id) {
        EventModel event = this.eventRepo.findById(id).get();
        return event;

    }

    public EventModel saveEvent(EventModel event){
        return eventRepo.save(event);
    }

    public String deleteEvent(Integer id){
        eventRepo.deleteById(id);
        return "Event Deleted !";
    }

}

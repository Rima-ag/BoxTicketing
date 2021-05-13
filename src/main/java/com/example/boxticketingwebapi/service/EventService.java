package com.example.boxticketingwebapi.service;


import com.example.boxticketingwebapi.controller.exceptions.DataNotFoundException;
import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.repo.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private IEventRepo eventRepo;

    public List<EventModel> getAllEvents() throws DataNotFoundException {
        List<EventModel> events = this.eventRepo.findAll();
        if(events.size()==0){
            throw new DataNotFoundException("List is Empty");
        }
        return events;
    }

    public EventModel getEventDetails(Long id) throws DataNotFoundException {
        EventModel event = this.eventRepo.findById(id).orElse(null);
        if(event == null){
            throw new DataNotFoundException("Event doesn't exist Found");
        }
        return event;
    }

    public EventModel saveEvent(EventModel event){
        return eventRepo.save(event);
    }

    public String deleteEvent(Long id){
        EventModel event = this.eventRepo.findById(id).orElse(null);
        if(event == null){
            throw new DataNotFoundException("Event with id:" + id + " doesn't exists!");
        }
        eventRepo.deleteById(id);
        return "Event Deleted !";
    }

}

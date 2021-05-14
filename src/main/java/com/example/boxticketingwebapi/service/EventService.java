package com.example.boxticketingwebapi.service;


import com.example.boxticketingwebapi.controller.exceptions.DataNotFoundException;
import com.example.boxticketingwebapi.controller.exceptions.ServerException;
import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.repo.IEventRepo;
import com.example.boxticketingwebapi.security.jwt.AuthEntryPointJwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private IEventRepo eventRepo;

    public List<EventModel> getAllEvents() throws DataNotFoundException {
        List<EventModel> events = this.eventRepo.findAll();
        if(events.size()==0){
            throw new DataNotFoundException("List is empty.");
        }
        return events;
    }

    public EventModel getEventDetails(Long id) throws DataNotFoundException {
        EventModel event = this.eventRepo.findById(id).orElse(null);
        if(event == null){
            throw new DataNotFoundException("Event with id:" + id + " not found.");
        }
        return event;
    }

    public EventModel saveEvent(EventModel event){
        return eventRepo.save(event);
    }

    public void deleteEvent(Long id){
        EventModel event = this.eventRepo.findById(id).orElse(null);
        if(event == null){
            throw new DataNotFoundException("Event with id:" + id + " not found.");
        }
        try{
            eventRepo.deleteById(id);
        } catch (Exception ex){
            throw new ServerException("Unable to delete this event.");
        }

    }

}

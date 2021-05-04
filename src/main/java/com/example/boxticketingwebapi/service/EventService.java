package com.example.boxticketingwebapi.service;


import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.repo.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EventService {

    @Autowired
    private IEventRepo eventRepo;

    public List<EventModel> getAllEvents(){
        ArrayList<EventModel> events = new ArrayList<EventModel>();
        this.eventRepo.findAll().forEach(e -> events.add(e));
        return events;
    }
}

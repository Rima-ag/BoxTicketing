package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EventModel> getEvents() {
        return this.eventService.getAllEvents();
    }

}

package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody /*Inserts returned value in reponse body*/ List<EventModel> getEvents() {
        return this.eventService.getAllEvents();
    }

}

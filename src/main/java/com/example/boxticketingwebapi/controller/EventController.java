package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.dto.MessageResponseDTO;
import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ticket-api/v1/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public @ResponseBody /*Inserts returned value in response body*/ List<EventModel> getEvents() {
        List<EventModel> events = this.eventService.getAllEvents();
        return events;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public @ResponseBody /*Inserts returned value in response body*/ EventModel getEvent(@PathVariable(value = "id") Long eventId) {
        EventModel event = this.eventService.getEventDetails(eventId);
        event.add(linkTo(methodOn(this.getClass()).getEvents()).withRel("getEvents"));
        return event;
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponseDTO addEvent(@RequestBody EventModel event) {
        this.eventService.saveEvent(event);
        MessageResponseDTO message =  new MessageResponseDTO("Event successfully added.");
        message.add(linkTo(methodOn(this.getClass()).deleteEvent(event.getEventId())).withRel("deleteEvent"));
        message.add(linkTo(methodOn(this.getClass()).updateEvent(new EventModel())).withRel("updateEvent"));
        message.add(linkTo(methodOn(this.getClass()).getEvents()).withRel("getEvents"));
        message.add(linkTo(methodOn(this.getClass()).getEvent(event.getEventId())).withRel("getEvent"));
        return message;
    }

    @PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponseDTO updateEvent(@RequestBody EventModel event) {
        this.eventService.saveEvent(event);
        MessageResponseDTO message =  new MessageResponseDTO("Event successfully updated.");
        message.add(linkTo(methodOn(this.getClass()).addEvent(new EventModel())).withRel("addEvent"));
        message.add(linkTo(methodOn(this.getClass()).deleteEvent(event.getEventId())).withRel("deleteEvent"));
        message.add(linkTo(methodOn(this.getClass()).getEvents()).withRel("getEvents"));
        message.add(linkTo(methodOn(this.getClass()).getEvent(event.getEventId())).withRel("getEvent"));
        return message;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponseDTO deleteEvent(@PathVariable(value = "id") Long eventId) {
        this.eventService.deleteEvent(eventId);
        MessageResponseDTO message =  new MessageResponseDTO("Event successfully deleted.");
        message.add(linkTo(methodOn(this.getClass()).addEvent(new EventModel())).withRel("addEvent"));
        message.add(linkTo(methodOn(this.getClass()).getEvents()).withRel("getEvents"));
        return message;
    }

}

package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.model.TicketTypeModel;
import com.example.boxticketingwebapi.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticketTypes")
public class TicketTypeController {

    @Autowired
    private TicketTypeService ticketTypeService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTicketType(@RequestBody TicketTypeModel ticketType){
        ticketTypeService.addTicketType(ticketType);
    }
}

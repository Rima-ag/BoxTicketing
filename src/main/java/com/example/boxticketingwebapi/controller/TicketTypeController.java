package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.model.TicketTypeModel;
import com.example.boxticketingwebapi.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ticket-api/v1/ticketTypes")
public class TicketTypeController {
    @Autowired
    private TicketTypeService ticketTypeService;

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTicketType(@RequestBody TicketTypeModel ticketType){
        ticketTypeService.addTicketType(ticketType);
    }

    @GetMapping( produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public @ResponseBody List<TicketTypeModel>  getTicketTypes(@RequestBody TicketTypeModel ticketType){
        List<TicketTypeModel> resp = ticketTypeService.getAllTicketTypes();
        return resp;
    }
}

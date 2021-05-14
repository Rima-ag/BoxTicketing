package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.dto.MessageResponseDTO;
import com.example.boxticketingwebapi.model.TicketTypeModel;
import com.example.boxticketingwebapi.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ticket-api/v1/ticketTypes")
public class TicketTypeController {
    @Autowired
    private TicketTypeService ticketTypeService;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO addTicketType(@RequestBody TicketTypeModel ticketType){
        ticketTypeService.addTicketType(ticketType);
        MessageResponseDTO message =  new MessageResponseDTO("Ticket type successfully added.");
        message.add(linkTo(methodOn(this.getClass()).getTicketTypes()).withRel("getTicketTypes"));
        return message;
    }


    @GetMapping( produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public @ResponseBody List<TicketTypeModel>  getTicketTypes(){
        List<TicketTypeModel> resp = ticketTypeService.getAllTicketTypes();
        return resp;
    }
}

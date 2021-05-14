package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.dto.MessageResponseDTO;
import com.example.boxticketingwebapi.dto.TransactionRequestDTO;
import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.model.TicketModel;
import com.example.boxticketingwebapi.service.TicketService;
import com.example.boxticketingwebapi.service.TransactionService;
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
@RequestMapping("/ticket-api/v1/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('USER')")
    public @ResponseBody List<TicketModel> getTicketsByUserId() {
        return this.ticketService.getTicketsByUserId();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public @ResponseBody /*Inserts returned value in response body*/ TicketModel getTicket(@PathVariable(value = "id") Long ticketId) {
        TicketModel ticket = this.ticketService.getTicketDetails(ticketId);
        ticket.add(linkTo(methodOn(this.getClass()).getTicketsByUserId()).withRel("getTickets"));
        return ticket;
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO buyTicket(@RequestBody TransactionRequestDTO transactionRequestDTO){
        TicketModel ticket = transactionService.buyTicket(transactionRequestDTO);
        MessageResponseDTO message =  new MessageResponseDTO("Ticket successfully bought.");
        message.add(linkTo(methodOn(this.getClass()).getTicketsByUserId()).withRel("getTickets"));
        message.add(linkTo(methodOn(this.getClass()).getTicket(ticket.getTicketId())).withRel("getTicket"));
        return message;
    }

}

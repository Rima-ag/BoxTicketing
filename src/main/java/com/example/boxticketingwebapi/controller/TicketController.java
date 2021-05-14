package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.dto.request.TransactionRequestDTO;
import com.example.boxticketingwebapi.model.TicketModel;
import com.example.boxticketingwebapi.service.TicketService;
import com.example.boxticketingwebapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public @ResponseBody List<TicketModel> getTickets() {
        return this.ticketService.getAllTickets();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public @ResponseBody /*Inserts returned value in response body*/ TicketModel getTicket(@PathVariable(value = "id") Long ticketId) {
        return this.ticketService.getTicketDetails(ticketId);
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void buyTicket(@RequestBody TransactionRequestDTO transactionRequestDTO){
        transactionService.buyTicket(transactionRequestDTO);
    }

}

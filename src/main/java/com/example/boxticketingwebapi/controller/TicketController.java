package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.dto.Transaction;
import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.model.TicketModel;
import com.example.boxticketingwebapi.service.EventService;
import com.example.boxticketingwebapi.service.TicketService;
import com.example.boxticketingwebapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<TicketModel> getTickets() {
        return this.ticketService.getAllTickets();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody /*Inserts returned value in reponse body*/ TicketModel getTicket(@PathVariable(value = "id") Integer ticketId) {
        return this.ticketService.getTicketDetails(ticketId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void buyTicket(@RequestBody Transaction transaction){
        transactionService.buyTicket(transaction);
    }

}

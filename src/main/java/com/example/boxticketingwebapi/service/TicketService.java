package com.example.boxticketingwebapi.service;


import com.example.boxticketingwebapi.controller.exceptions.DataNotFoundException;
import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.model.TicketModel;
import com.example.boxticketingwebapi.model.TicketTypeModel;
import com.example.boxticketingwebapi.repo.ITicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ITicketRepo ticketRepo;

    public List<TicketModel> getAllTickets() {
        ArrayList<TicketModel> tickets = new ArrayList<>();
        this.ticketRepo.findAll().forEach(tickets::add);
        if(tickets.size()==0){
            throw new DataNotFoundException("Tickets list is empty.");
        }
        return tickets;
    }

    public TicketModel getTicketDetails(Long id) throws DataNotFoundException{
        TicketModel ticket = this.ticketRepo.findById(id).orElse(null);
        if(ticket == null){
            throw new DataNotFoundException("Ticket with id: " + id + " not found.");
        }
        return ticket;
    }

    public TicketModel saveTicket(EventModel event, TicketTypeModel ticketType){
        TicketModel ticket = new TicketModel();
        ticket.setEvent(event);
        ticket.setTicketType(ticketType);
        return ticketRepo.save(ticket);
    }
}

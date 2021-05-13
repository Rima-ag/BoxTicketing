package com.example.boxticketingwebapi.service;


import com.example.boxticketingwebapi.DataNotFoundException;
import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.model.TicketModel;
import com.example.boxticketingwebapi.repo.IEventRepo;
import com.example.boxticketingwebapi.repo.ITicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.*;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ITicketRepo ticketRepo;

    public List<TicketModel> getAllTickets() {
        ArrayList<TicketModel> tickets = new ArrayList<TicketModel>();
        this.ticketRepo.findAll().forEach(e -> tickets.add(e));
        if(tickets.size()==0){
            throw new DataNotFoundException("Tickets List is Empty");
        }
        return tickets;
    }

    public TicketModel getTicketDetails(Integer id){
        TicketModel ticket = this.ticketRepo.findById(id).orElse(null);
        if(ticket == null){
            throw new DataNotFoundException("Ticket Not Found");
        }
        return ticket;
    }
}

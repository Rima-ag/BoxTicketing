package com.example.boxticketingwebapi.service;


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
        return tickets;
    }

    public TicketModel getTicketDetails(Integer id){
        return this.ticketRepo.findById(id).orElse(null);
    }
}

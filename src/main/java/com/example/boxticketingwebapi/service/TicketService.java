package com.example.boxticketingwebapi.service;


import com.example.boxticketingwebapi.controller.exceptions.DataNotFoundException;
import com.example.boxticketingwebapi.controller.exceptions.ServerException;
import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.model.TicketModel;
import com.example.boxticketingwebapi.model.TicketTypeModel;
import com.example.boxticketingwebapi.model.UserModel;
import com.example.boxticketingwebapi.repo.ITicketRepo;
import com.example.boxticketingwebapi.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ITicketRepo ticketRepo;

    @Autowired
    private UserService userService;

    public List<TicketModel> getTicketsByUserId() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserModel user = userService.getUserById(userDetails.getId());
        List<TicketModel> tickets = user.getTickets();
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
        try{
            TicketModel ticket = new TicketModel();
            ticket.setEvent(event);
            ticket.setTicketType(ticketType);
            return ticketRepo.save(ticket);
        } catch (Exception ex){
            throw new ServerException("Unable to save this ticket.");
        }
    }
}

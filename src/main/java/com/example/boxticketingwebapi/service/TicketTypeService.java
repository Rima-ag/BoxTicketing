package com.example.boxticketingwebapi.service;

import com.example.boxticketingwebapi.controller.exceptions.DataNotFoundException;
import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.model.TicketTypeModel;
import com.example.boxticketingwebapi.repo.ITicketTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketTypeService {


    @Autowired
    private ITicketTypeRepo ticketTypeRepo;

    public TicketTypeModel getTicketTypeById(Integer ticketTypeId){
        TicketTypeModel ticketType = ticketTypeRepo.findById(ticketTypeId).orElse(null);
        if(ticketType == null){
            throw new DataNotFoundException("Ticket Type Not Found");
        }
        return ticketType;
    }

    public void addTicketType(TicketTypeModel ticketType){
        ticketTypeRepo.save(ticketType);
    }

}

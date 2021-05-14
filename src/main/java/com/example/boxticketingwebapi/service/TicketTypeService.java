package com.example.boxticketingwebapi.service;

import com.example.boxticketingwebapi.controller.exceptions.DataNotFoundException;
import com.example.boxticketingwebapi.controller.exceptions.ServerException;
import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.model.TicketModel;
import com.example.boxticketingwebapi.model.TicketTypeModel;
import com.example.boxticketingwebapi.repo.ITicketTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketTypeService {


    @Autowired
    private ITicketTypeRepo ticketTypeRepo;

    public TicketTypeModel getTicketTypeById(Long ticketTypeId){
        TicketTypeModel ticketType = ticketTypeRepo.findById(ticketTypeId).orElse(null);
        if(ticketType == null){
            throw new DataNotFoundException("Ticket type with id: " + ticketTypeId + " not found.");
        }
        return ticketType;
    }

    public List<TicketTypeModel> getAllTicketTypes() throws DataNotFoundException {
        List<TicketTypeModel> types = this.ticketTypeRepo.findAll();
        if(types.size()==0){
            throw new DataNotFoundException("List is empty.");
        }
        return types;
    }

    public TicketTypeModel addTicketType(TicketTypeModel ticketType){
        try{
            return ticketTypeRepo.save(ticketType);
        }catch(Exception e){
            throw new ServerException("Error adding ticket type.");
        }
    }

}

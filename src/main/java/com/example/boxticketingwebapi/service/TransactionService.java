package com.example.boxticketingwebapi.service;

import com.example.boxticketingwebapi.controller.exceptions.BadRequestException;
import com.example.boxticketingwebapi.controller.exceptions.DataNotFoundException;
import com.example.boxticketingwebapi.dto.TransactionRequestDTO;
import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.model.TicketModel;
import com.example.boxticketingwebapi.model.TicketTypeModel;
import com.example.boxticketingwebapi.model.UserModel;
import com.example.boxticketingwebapi.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketTypeService ticketTypeService;

    @Autowired
    private TicketService ticketService;

    public TicketModel buyTicket(TransactionRequestDTO transactionRequestDTO) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserModel account = userService.getUserById(userDetails.getId());
        TicketTypeModel ticketType = ticketTypeService.getTicketTypeById(transactionRequestDTO.getTicketTypeId());
        EventModel event = eventService.getEventDetails(transactionRequestDTO.getEventId());
        if (account.getAmountInWallet() >= ticketType.getPrice()) {
            TicketModel ticket = ticketService.saveTicket(event, ticketType);
            account.setAmountInWallet(account.getAmountInWallet() - ticketType.getPrice());
            account.addTicket(ticket);
            userService.saveUser(account);
            return ticket;
        } else {
            throw new BadRequestException("Amount in wallet is not enough to buy this ticket.");
        }
    }

}

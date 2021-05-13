package com.example.boxticketingwebapi.service;

import com.example.boxticketingwebapi.controller.exceptions.TransactionNotAllowed;
import com.example.boxticketingwebapi.dto.Transaction;
import com.example.boxticketingwebapi.model.AccountModel;
import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.model.TicketModel;
import com.example.boxticketingwebapi.model.TicketTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketTypeService ticketTypeService;

    @Autowired
    private TicketService ticketService;

    public void buyTicket(Transaction transaction){
        AccountModel account = accountService.getAccountById(transaction.getAccountId());
        TicketTypeModel ticketType = ticketTypeService.getTicketTypeById(transaction.getTicketTypeId());
        EventModel event = eventService.getEventDetails(transaction.getEventId());
        if(account != null && ticketType != null && event != null && account.getAmountInWallet() >= ticketType.getPrice()){
            TicketModel ticket = ticketService.addTicket(event, ticketType);
            account.setAmountInWallet(account.getAmountInWallet() - ticketType.getPrice());
            account.addTicket(ticket);
            accountService.saveAccount(account);
        }else{
            throw new TransactionNotAllowed("An error occurred");
        }
    }
}

package com.example.boxticketingwebapi.dto;

public class Transaction {

    private Integer accountId;

    private Integer eventId;

    private Integer ticketTypeId;

    public Transaction(Integer accountId, Integer eventId, Integer ticketTypeId) {
        this.accountId = accountId;
        this.eventId = eventId;
        this.ticketTypeId = ticketTypeId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Integer ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }
}

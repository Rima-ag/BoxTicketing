package com.example.boxticketingwebapi.dto;

public class TransactionRequestDTO {

    private Long eventId;

    private Long ticketTypeId;

    public TransactionRequestDTO(Long eventId, Long ticketTypeId) {
        this.eventId = eventId;
        this.ticketTypeId = ticketTypeId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }
}

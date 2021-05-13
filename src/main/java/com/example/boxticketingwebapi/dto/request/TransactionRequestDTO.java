package com.example.boxticketingwebapi.dto.request;

public class TransactionRequestDTO {

    private Long userId;

    private Long eventId;

    private Long ticketTypeId;

    public TransactionRequestDTO(Long userId, Long eventId, Long ticketTypeId) {
        this.userId = userId;
        this.eventId = eventId;
        this.ticketTypeId = ticketTypeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setAccountId(Long accountId) {
        this.userId = accountId;
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

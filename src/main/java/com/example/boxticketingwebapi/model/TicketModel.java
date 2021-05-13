package com.example.boxticketingwebapi.model;

import javax.persistence.*;

@Entity(name = "TICKET")
public class TicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @ManyToOne
    private EventModel event;

    @ManyToOne(fetch = FetchType.EAGER)
    private TicketTypeModel ticketType;

    public TicketModel(Integer ticketId, EventModel event, TicketTypeModel ticketType) {
        this.ticketId = ticketId;
        this.event = event;
        this.ticketType = ticketType;
    }

    public TicketModel() {
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public EventModel getEvent() {
        return event;
    }

    public void setEvent(EventModel event) {
        this.event = event;
    }

    public TicketTypeModel getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketTypeModel ticketType) {
        this.ticketType = ticketType;
    }
}
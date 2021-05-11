package com.example.boxticketingwebapi.model;

import javax.persistence.*;

@Entity
public class TicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketId;

    @ManyToOne
    private EventModel event;

    @ManyToOne(fetch = FetchType.EAGER)
    private TicketTypeModel ticketType;

    public TicketModel(int ticketId, EventModel event, TicketTypeModel ticketType) {
        this.ticketId = ticketId;
        this.event = event;
        this.ticketType = ticketType;
    }

    public TicketModel() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
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
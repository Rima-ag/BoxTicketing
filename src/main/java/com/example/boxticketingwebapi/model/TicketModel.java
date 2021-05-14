package com.example.boxticketingwebapi.model;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity(name = "TICKET")
public class TicketModel extends RepresentationModel<EventModel> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @ManyToOne
    private EventModel event;

    @ManyToOne(fetch = FetchType.EAGER)
    private TicketTypeModel ticketType;

    public TicketModel(Long ticketId, EventModel event, TicketTypeModel ticketType) {
        this.ticketId = ticketId;
        this.event = event;
        this.ticketType = ticketType;
    }

    public TicketModel() {
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
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
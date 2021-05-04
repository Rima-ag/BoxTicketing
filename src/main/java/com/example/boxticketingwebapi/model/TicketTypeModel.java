package com.example.boxticketingwebapi.model;

import javax.persistence.*;

@Entity
public class TicketTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketTypeId;
    private String typeName;

    @ManyToOne
    private EventModel event;

    private double price;

    public TicketTypeModel() {
    }

    public int getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(int ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTicketTypeId(Integer ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public EventModel getEvent() {
        return event;
    }

    public void setEvent(EventModel event) {
        this.event = event;
    }

    public TicketTypeModel(int ticketTypeId, String typeName, EventModel event, double price) {
        this.ticketTypeId = ticketTypeId;
        this.typeName = typeName;
        this.price = price;
    }

}

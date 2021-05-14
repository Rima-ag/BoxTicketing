package com.example.boxticketingwebapi.model;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity(name = "TICKET_TYPE")
public class TicketTypeModel extends RepresentationModel<EventModel> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketTypeId;
    private String typeName;

    private double price;

    public TicketTypeModel() {
    }

    public Long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Long ticketTypeId) {
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

    public TicketTypeModel(Long ticketTypeId, String typeName, EventModel event, double price) {
        this.ticketTypeId = ticketTypeId;
        this.typeName = typeName;
        this.price = price;
    }
}
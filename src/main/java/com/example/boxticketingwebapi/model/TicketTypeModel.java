package com.example.boxticketingwebapi.model;

import javax.persistence.*;

@Entity(name = "TICKET_TYPE")
public class TicketTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketTypeId;
    private String typeName;

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

    public TicketTypeModel(int ticketTypeId, String typeName, EventModel event, double price) {
        this.ticketTypeId = ticketTypeId;
        this.typeName = typeName;
        this.price = price;
    }
}
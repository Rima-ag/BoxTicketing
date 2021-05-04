package com.example.boxticketingwebapi.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

    public TicketTypeModel(int ticketTypeId, String typeName, double price) {
        this.ticketTypeId = ticketTypeId;
        this.typeName = typeName;
        this.price = price;
    }

}

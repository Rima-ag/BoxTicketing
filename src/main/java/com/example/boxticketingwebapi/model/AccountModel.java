package com.example.boxticketingwebapi.model;
import java.util.Collection;
import javax.persistence.*;

@Entity(name = "ACCOUNT")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String password;
    private String username;
    private double amountInWallet;
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<TicketModel> tickets;

    public AccountModel() {
    }

    public AccountModel(Integer accountId, String password, String username, double amountInWallet) {
        this.accountId = accountId;
        this.password = password;
        this.username = username;
        this.amountInWallet = amountInWallet;
    }

    public void addTicket(TicketModel ticket){
        tickets.add(ticket);
    }

    public void removeTicket(TicketModel ticket){
        tickets.remove(ticket);
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getAmountInWallet() {
        return amountInWallet;
    }

    public void setAmountInWallet(double amountInWallet) {
        this.amountInWallet = amountInWallet;
    }

    public Collection<TicketModel> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<TicketModel> tickets) {
        this.tickets = tickets;
    }
}

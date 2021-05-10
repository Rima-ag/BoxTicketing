package com.example.boxticketingwebapi.model;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;
    private String password;
    private String username;
    private String amountInWallet;
    private Collection<TicketModel> tickets;

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

    public String getAmountInWallet() {
        return amountInWallet;
    }

    public void setAmountInWallet(String amountInWallet) {
        this.amountInWallet = amountInWallet;
    }

    @OneToMany(fetch = FetchType.EAGER)
    public Collection<TicketModel> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<TicketModel> tickets) {
        this.tickets = tickets;
    }
}

package com.example.boxticketingwebapi.model;
import org.springframework.hateoas.RepresentationModel;

import java.util.Collection;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "USER")
@Table(uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        })
public class UserModel  extends RepresentationModel<EventModel> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    @Size(max = 20)
    private String username;

    private double amountInWallet;
    @OneToMany(fetch = FetchType.LAZY)
    private List<TicketModel> tickets;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleModel> roles = new HashSet<>();

    public UserModel() {
    }
    public UserModel(String username, String password, double amountInWallet) {
        this.amountInWallet = amountInWallet;
        this.password = password;
        this.username = username;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }

    public void addTicket(TicketModel ticket){
        tickets.add(ticket);
    }

    public void removeTicket(TicketModel ticket){
        tickets.remove(ticket);
    }

    public Long getId() {
        return userId;
    }

    public void setId(Long userId) {
        this.userId = userId;
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

    public List<TicketModel> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketModel> tickets) {
        this.tickets = tickets;
    }
}

package com.example.boxticketingwebapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequestDTO {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    private double amountInWallet;

    public double getAmountInWallet() {
        return amountInWallet;
    }

    public void setAmountInWallet(double amountInWallet) {
        this.amountInWallet = amountInWallet;
    }

    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}

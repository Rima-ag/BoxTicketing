package com.example.boxticketingwebapi.controller;

import com.example.boxticketingwebapi.model.AccountModel;
import com.example.boxticketingwebapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/addAccount")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountModel addAccount(@RequestBody AccountModel account) {
        return this.accountService.saveAccount(account);
    }

    @DeleteMapping(value = "/deleteAccount/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String addAccount(@PathVariable(value = "id") Integer accountId) {
        return this.accountService.deleteAccount(accountId);
    }
}

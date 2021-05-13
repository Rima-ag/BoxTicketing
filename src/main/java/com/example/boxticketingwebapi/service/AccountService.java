package com.example.boxticketingwebapi.service;


import com.example.boxticketingwebapi.controller.exceptions.DataNotFoundException;
import com.example.boxticketingwebapi.model.AccountModel;
import com.example.boxticketingwebapi.repo.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    @Autowired
    private IAccountRepo accountRepo;

    public AccountModel saveAccount(AccountModel account){
        return accountRepo.save(account);
    }

    public String deleteAccount(Integer id){
        AccountModel account = this.accountRepo.findById(id).orElse(null);
        if(account == null) {
            throw new DataNotFoundException("Account with id:" + id + " doesn't exists!");
        }
        accountRepo.deleteById(id);
        return "Account Deleted !";
    }

    public AccountModel getAccountById(Integer accountId){
        AccountModel account = this.accountRepo.findById(accountId).orElse(null);
        if(account == null) {
            throw new DataNotFoundException("Account with id:" + accountId + " doesn't exists!");
        }
        return account;
    }

}

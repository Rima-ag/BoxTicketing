package com.example.boxticketingwebapi.service;


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
        accountRepo.deleteById(id);
        return "Account Deleted !";
    }
}

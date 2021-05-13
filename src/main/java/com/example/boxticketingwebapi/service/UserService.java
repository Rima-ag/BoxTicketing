package com.example.boxticketingwebapi.service;


import com.example.boxticketingwebapi.DataNotFoundException;
import com.example.boxticketingwebapi.model.UserModel;
import com.example.boxticketingwebapi.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private IUserRepo accountRepo;

    public UserModel saveAccount(UserModel account){
        return accountRepo.save(account);
    }

    public String deleteAccount(Integer id){
        UserModel account = this.accountRepo.findById(id).orElse(null);
        if(account == null) {
            throw new DataNotFoundException("Account with id:" + id + " doesn't exists!");
        }
        accountRepo.deleteById(id);
        return "Account Deleted !";
    }
}

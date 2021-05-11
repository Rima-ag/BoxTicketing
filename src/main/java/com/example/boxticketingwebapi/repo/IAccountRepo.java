package com.example.boxticketingwebapi.repo;


import com.example.boxticketingwebapi.model.AccountModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAccountRepo extends CrudRepository<AccountModel, Integer> {
}

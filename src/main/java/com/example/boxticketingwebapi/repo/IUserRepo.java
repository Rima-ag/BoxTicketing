package com.example.boxticketingwebapi.repo;


import com.example.boxticketingwebapi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUserRepo extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByUsername(String username);
    Boolean existsByUsername(String username);
}

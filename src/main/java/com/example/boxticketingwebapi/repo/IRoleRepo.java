package com.example.boxticketingwebapi.repo;

import com.example.boxticketingwebapi.model.ERole;
import com.example.boxticketingwebapi.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepo extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findByName(ERole name);
}
package com.example.boxticketingwebapi.repo;

import com.example.boxticketingwebapi.model.TicketTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketTypeRepo extends JpaRepository<TicketTypeModel, Long> {
}

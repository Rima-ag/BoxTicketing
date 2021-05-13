package com.example.boxticketingwebapi.repo;
import com.example.boxticketingwebapi.model.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITicketRepo extends JpaRepository<TicketModel, Integer> {
}

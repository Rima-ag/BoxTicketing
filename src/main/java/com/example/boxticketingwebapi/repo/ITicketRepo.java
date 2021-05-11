package com.example.boxticketingwebapi.repo;


import com.example.boxticketingwebapi.model.EventModel;
import com.example.boxticketingwebapi.model.TicketModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITicketRepo extends CrudRepository<TicketModel, Integer> {
}

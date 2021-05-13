package com.example.boxticketingwebapi.repo;


import com.example.boxticketingwebapi.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEventRepo extends JpaRepository<EventModel, Long> {
}

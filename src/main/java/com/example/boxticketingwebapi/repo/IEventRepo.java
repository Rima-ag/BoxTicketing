package com.example.boxticketingwebapi.repo;


import com.example.boxticketingwebapi.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventRepo extends CrudRepository<EventModel, Integer> {


}

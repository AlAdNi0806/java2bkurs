package com.example.demo.repo;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {

    // Custom method to update an event
    @Modifying
    @Transactional
    @Query("update Event e set e.title = ?1, e.description = ?2, e.location = ?3, e.maxPeople = ?4, e.status = ?5 where e.id = ?6")
    int updateEvent(String title, String description, String location, int maxPeople, String status, Long id);

    // Method to retrieve all events
    List<Event> findAll();

    List<Event> findByOwnerId(Long ownerId);

    @Modifying
    @Transactional
    @Query("update Event e set e.status = ?1 where e.id = ?2")
    int updateEventStatus(String status, Long id);
}
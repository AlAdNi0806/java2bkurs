package com.example.demo;

import com.example.demo.model.Event;
import com.example.demo.model.Users;
import com.example.demo.repo.EventRepo;
import com.example.demo.repo.UsersRepo;
import com.example.demo.types.CreateEvent;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventRepo eventRepo; // so that you don't have to do the contructon (UserRepo userRepo = new UserRepo())

    @Autowired
    private UsersRepo usersRepo; // so that you don't have to do the contructon (UserRepo userRepo = new UserRepo())


    @Transactional
    @PostMapping("/create-event")
    public Event createEventAndLinkToUser(@RequestBody CreateEvent createEvent) {
        // Create a new event
        Event event = new Event();
        event.setTitle(createEvent.getTitle());
        event.setDescription(createEvent.getDescription());
        event.setLocation(createEvent.getLocation());
        event.setMaxPeople(createEvent.getMaxPeople());
        event.setStatus("pending");
        event.setDate(createEvent.getDate());
        event.setOwnerId(createEvent.getId());

        System.out.println(createEvent.getDate());

        event = eventRepo.save(event);



        return event;
    }

    public List<Event> getEventsByOwnerId(Long ownerId) {
        return eventRepo.findByOwnerId(ownerId);
    }

    @PostMapping("/events")
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @PostMapping("/update-event-status")
    public int updateEventStatus(@RequestBody Event event) {
        return eventRepo.updateEventStatus(event.getStatus(), event.getId());
    }

    @PostMapping("/delete-event")
    public void deleteEvent(@RequestBody Event event) {
        eventRepo.deleteById(event.getId());
    }
}

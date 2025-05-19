package com.example.importantdays.controller;

import com.example.importantdays.dto.Eventdto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.importantdays.service.EventService;

@RequestMapping("/events")
@RestController
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public List<Eventdto> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping("/add")
    public List<Eventdto> addEvent(@RequestBody Eventdto event) {
        eventService.addEvent(event);
        return eventService.getAllEvents();
    }

    @DeleteMapping("/delete")
    public List deleteEvent(@RequestParam("id") long id) {
        eventService.deleteEvent(id);
        return eventService.getAllEvents();

    }
    @GetMapping("/closest")
    public Eventdto getClosestEvent() {
        return eventService.getClosestEvent();
    }

}








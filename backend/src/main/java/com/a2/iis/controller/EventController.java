package com.a2.iis.controller;

import com.a2.iis.model.Event;
import com.a2.iis.service.CalendarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
public class EventController {
    private final CalendarService service;
    public EventController(CalendarService service) {
        this.service = service;
    }
    @GetMapping("/events")
    public List<Event> getEvents() {
        return service.getEvents();
    }
    @PostMapping("/events")
    public Event addEvent(
        @RequestBody Event event
    ) {
        return service.addEvent(event);
    }
    @PutMapping("/events/{id}")
    public Event updateEvent(
        @PathVariable String id,
        @RequestBody Event updatedEvent
    ) {
        return service.updateEvent(id, updatedEvent);
    }
    @DeleteMapping("/events/{id}")
    public void deleteEvent(
        @PathVariable String id
    ) {
        service.deleteEvent(id);
    }
}

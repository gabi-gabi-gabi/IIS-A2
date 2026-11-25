package com.a2.iis.service;

import com.a2.iis.model.Event;
import com.a2.iis.repository.JsonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {
    private final JsonRepository repository;
    private final UndoService undoService;
    public CalendarService(JsonRepository repository, UndoService undoService) {
        this.repository = repository;
        this.undoService = undoService;
    }
    public List<Event> getEvents() {
        return repository.findAll();
    }
    public Event addEvent(Event event) {
        List<Event> events = repository.findAll();
        undoService.backup(events);
        events.add(event);
        repository.saveAll(events);
        return event;
    }
    public Event updateEvent(
        String id,
        Event updatedEvent
    ) {
        List<Event> events = repository.findAll();
        undoService.backup(events);
        for (Event event : events) {
            if (event.getId().equals(id)) {
                event.setTitle(updatedEvent.getTitle());
                event.setDay(updatedEvent.getDay());
                event.setTime(updatedEvent.getTime());
                repository.saveAll(events);
                return event;
            }
        }
        throw new RuntimeException("Event not found");
    }
    public void deleteEvent(String id) {
        List<Event> events = repository.findAll();
        undoService.backup(events);
        events.removeIf(event -> event.getId().equals(id));
        repository.saveAll(events);
    }
    public void moveEvent(String eventTitle, String newTime) {
        List<Event> events = repository.findAll();
        undoService.backup(events);
        for(Event event : events) {
            if(event.getTitle().equals(eventTitle)) {
                event.setTime(newTime);
            }
        }
        repository.saveAll(events);
    }
    public void undo() {
        List<Event> previousState = undoService.restore();
        repository.saveAll(previousState);
    }
}

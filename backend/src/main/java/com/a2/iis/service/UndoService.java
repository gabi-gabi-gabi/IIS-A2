package com.a2.iis.service;

import com.a2.iis.model.CalendarData;
import com.a2.iis.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.List;

@Service
public class UndoService {
    private final ObjectMapper mapper = new ObjectMapper();
    public void backup(List<Event> events) {
        try {
            CalendarData data = new CalendarData();
            data.setEvents(events);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/backup.json"), data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Event> restore() {
        try {
            CalendarData data = mapper.readValue(new File("src/main/resources/backup.json"), CalendarData.class);
            return data.getEvents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
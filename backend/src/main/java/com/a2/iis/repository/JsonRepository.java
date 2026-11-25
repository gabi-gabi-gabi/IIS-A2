package com.a2.iis.repository;

import com.a2.iis.model.CalendarData;
import com.a2.iis.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

//import java.io.InputStream;
import java.util.List;
import java.io.File;

@Repository
public class JsonRepository {
    public List<Event> findAll() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/calendar.json");
            CalendarData data =
                mapper.readValue(
                    file,
                    CalendarData.class
                );
            return data.getEvents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void saveAll(List<Event> events) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            CalendarData data = new CalendarData();
            data.setEvents(events);
            File file = new File("src/main/resources/calendar.json");
            mapper.writerWithDefaultPrettyPrinter()
                .writeValue(file, data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

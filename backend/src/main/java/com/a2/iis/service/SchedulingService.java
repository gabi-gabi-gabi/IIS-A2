package com.a2.iis.service;

import com.a2.iis.model.ConflictResponse;
import com.a2.iis.model.Event;
import com.a2.iis.model.RecommendationResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SchedulingService {
    public ConflictResponse detectConflict(List<Event> events) {
        for(int i = 0; i < events.size(); i++) {
            for(int j = i + 1; j < events.size(); j++) {
                Event first = events.get(i);
                Event second = events.get(j);
                if(first.getDay().equals(second.getDay()) && first.getTime().equals(second.getTime())) {
                    return new ConflictResponse(
                            true,
                            first.getTitle(),
                            second.getTitle(),
                            "Scheduling conflict detected"
                    );
                }
            }
        }
        return new ConflictResponse(
                false,
                null,
                null,
                "No conflicts detected"
        );
    }
    public RecommendationResponse generateRecommendation(List<Event> events) {
        for(int i = 0; i < events.size(); i++) {
            for(int j = i + 1; j < events.size(); j++) {
                Event first = events.get(i);
                Event second = events.get(j);
                if(first.getDay().equals(second.getDay()) && first.getTime().equals(second.getTime())) {
                    return new RecommendationResponse(
                            true,
                            second.getTitle(),
                            "16:00",
                            "Conflict detected between events.",
                            "LOW"
                    );
                }
            }
        }
        return new RecommendationResponse(
                false,
                null,
                null,
                "No recommendation needed.",
                "NONE"
        );
    }
}
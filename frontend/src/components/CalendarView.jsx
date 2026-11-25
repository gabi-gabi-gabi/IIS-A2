import { useEffect, useState } from "react";
import { getEvents } from "../services/api";

function CalendarView() {
    const [events, setEvents] = useState([]);
    useEffect(() => {
        loadEvents();
        const interval = setInterval(loadEvents, 2000);
        return () => clearInterval(interval);
    }, []);
    const loadEvents = async () => {
        try {
            const response = await getEvents();
            setEvents(response.data);
        } catch (error) {
            console.error(error);
        }
    };
    return (
        <div>
            <h2>Calendar</h2>
            {events.map((event) => (
                <div
                    key={event.id}
                    style={{
                        border: "1px solid black",
                        padding: "10px",
                        marginBottom: "10px"
                    }}
                >
                    <h3>{event.title}</h3>
                    <p>{event.day}</p>
                    <p>{event.time}</p>
                </div>
            ))}
        </div>
    );
}

export default CalendarView;
package LLDQues.EventManagementSystem;

import java.time.LocalDate;

public class EventController {
    EventManager eventManager;

    public EventController(EventManager manager){
        this.eventManager=manager;

    }
    public Event createEvent(String name, LocalDate date, int capacity, Location location) {
        return eventManager.createEvent(name, date, capacity, location);
    }

    public void deleteEvent(int eventId) {
        eventManager.deleteEvent(eventId);
    }

    public void showAllEvents() {
        for (Event e : eventManager.getAllEvents()) {
            System.out.println("Event: " + e.getTitle() + " ID: " + e.getEventId());
        }
    }

    public void addParticipant(int eventId, Participant participant, Payment payment) {
        try {
            Registration reg = eventManager.registrationParticipant(eventId, participant, payment);
            System.out.println("Participant " + participant.getFirstName() + " registered successfully!");
        } catch (Exception ex) {
            System.out.println("Registration failed: " + ex.getMessage());
        }
    }

    public void removeParticipant(int eventId, int participantId) {
        Registration removed = eventManager.removeParticipant(eventId, participantId);
        if (removed != null) {
            System.out.println("Removed: " + removed.getParticipantId());
        } else {
            System.out.println("Participant not found!");
        }
    }
}


package LLDQues.EventManagementSystem;

import java.time.LocalDate;
import java.util.*;

public class EventManager {
    private Map<Integer, Event> eventMap = new HashMap<>();
    int registrationCounter = 1;


    public Event createEvent(String name, LocalDate date, int capacity, Location location) {
        Event event = new Event(name, date, capacity);
        eventMap.put(event.getEventId(), event);
        return event;
    }

    public void deleteEvent(int eventId) {
        if (!eventMap.containsKey(eventId)) {
            throw new IllegalArgumentException("Event not found with ID: " + eventId);
        }
        eventMap.remove(eventId);
    }

    public List<Event> getAllEvents() {
        return new ArrayList<>(eventMap.values());
    }

    public void updateEvent(Event updatedEvent) {
        if (eventMap.containsKey(updatedEvent.getEventId())) {
            eventMap.put(updatedEvent.getEventId(), updatedEvent);
        }
    }

    public Registration registrationParticipant(int eventId, Participant participant, Payment payment){
        Event event = eventMap.get(eventId);

        if(event == null){
            throw new IllegalArgumentException("event not found");
        }

        if(payment.getPaymentStatus() != PaymentStatus.COMPLETED){
            throw new IllegalArgumentException("payment is not completed .. cannot register");
        }

        //int registrationId, List<Event> events, List<Participant> participants, Payment payment)
        Registration registration = new Registration(registrationCounter++, event, participant,payment);
        event.addRegistration(registration);
        return registration;
    }

    public Registration removeParticipant(int eventId, int participantId) {
        Event event = eventMap.get(eventId);
        if (event == null) {
            return null;
        }

        List<Registration> regs = event.getRegistrations();
        for (int i = 0; i < regs.size(); i++) {
            Registration reg = regs.get(i);
            if (reg.getParticipantId() == participantId) {
                regs.remove(i);   // remove by index
                return reg;       // return the removed registration
            }
        }

        return null; // not found
    }
}

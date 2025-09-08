package LLDQues.EventManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    private int registrationId;
    private Event event;           // one event
    private Participant participant; // one participant
    private Payment payment;


    public Registration(int registrationId, Event event, Participant participant, Payment payment) {
        this.registrationId = registrationId;
        this.event = event;
        this.participant = participant;
        this.payment = payment;
    }

    public int getParticipantId() {
        return participant.getParticipantId();
    }
}
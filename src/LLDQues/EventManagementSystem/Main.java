package LLDQues.EventManagementSystem;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        EventController controller = new EventController(eventManager);
        Location location = new Location("Bangalore", "Karnataka", 560001, "MG Road");

        Event event = controller.createEvent("Tech Conference", LocalDate.parse("2025-09-08"),200,location);
        Participant participant1= new Participant(1,"Shuchi","F", "957363694857","sh@gmail.com");
        Participant participant2= new Participant(1,"PQR","F", "9439785365332","pqr@gmail.com");

        //re
        Payment payment = new Payment(101, 500.0);

        //after payment gateway confirmation
        payment.setPaymentStatus(PaymentStatus.COMPLETED);

        Payment payment2 = new Payment(102, 500.0);
        controller.addParticipant(event.getEventId(), participant2, payment2);

        // Suppose payment failed
        payment2.setPaymentStatus(PaymentStatus.FAILED);

        // Remove Participant (Alice)
        controller.removeParticipant(event.getEventId(), 1);

        // Show Events again (to verify updates)
        controller.showAllEvents();

    }

}

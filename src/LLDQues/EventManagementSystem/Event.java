package LLDQues.EventManagementSystem;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event {
    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCapacity() {
        return capacity;
    }

    public Location getLocation() {
        return location;
    }

    int eventId;
    String title;
    int duration;
    LocalDate date;
    int capacity;
    Location location;
    List<Registration> registrations = new ArrayList<>(); //avoid null pointer

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }



    public Event(String title, LocalDate date, int capacity){
        this.title = title;
        this.date = date;
        this.capacity = capacity;
    }


    public int getEventId(){
        return eventId;
    }


    public List<Registration> getRegistrations() {
        return registrations;
    }
    public void addRegistration(Registration r) {
        registrations.add(r);
    }
    public void removeRegistration(Registration r) {
        registrations.remove(r);
    }



}


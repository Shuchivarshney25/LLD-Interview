package LLDQues.RestaurantManagementSystem.service;

import LLDQues.RestaurantManagementSystem.model.Customer;
import LLDQues.RestaurantManagementSystem.model.Reservation;
import LLDQues.RestaurantManagementSystem.model.ReservationStatus;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationService {
    private Map<Integer, Reservation> reservations;
    private AtomicInteger reservationIdGenerator;
    private Set<Integer> availableTables;



    public ReservationService(int totalTables) {
        this.reservations = new ConcurrentHashMap<>();
        this.reservationIdGenerator = new AtomicInteger(1);
        this.availableTables = new HashSet<>();

        for (int i = 1; i <= totalTables; i++) {
            availableTables.add(i);
        }
    }


    public Reservation makeReservation(Customer customer, Date date) {

            for (Integer tableNumber : availableTables) {
                int reservationId = reservationIdGenerator.getAndIncrement();
                Reservation reservation = new Reservation(reservationId, customer, date, tableNumber);
                reservations.put(reservationId, reservation);
                availableTables.remove(tableNumber);
                return reservation;
            }
            return null;
    }

   public boolean cancelReservation(int reservationId){
       Reservation reservation = reservations.get(reservationId);
       if(reservation != null){
           reservation.setStatus(ReservationStatus.CANCELLED);
           availableTables.add(reservation.getTableNumber());
           return true;
       }
       return false;
   }

   public List<Integer> getAvailableTables(){
        return new ArrayList<>(availableTables);
   }
}


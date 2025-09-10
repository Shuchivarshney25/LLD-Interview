package LLDQues.RestaurantManagementSystem.model;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private Customer customer;
    private Date reservationDate;

    public Reservation(int reservationId, Customer customer, Date reservationDate, int tableNumber) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.reservationDate = reservationDate;
        this.tableNumber = tableNumber;
        this.status = ReservationStatus.PENDING;
    }

    private int tableNumber;
    private ReservationStatus status;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }


}

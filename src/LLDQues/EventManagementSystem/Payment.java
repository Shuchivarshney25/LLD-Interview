package LLDQues.EventManagementSystem;


public class Payment {
    int paymentId;
    double amount;
    PaymentStatus paymentStatus;

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Payment(int paymentId, double amount){
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.PENDING;
    }




}

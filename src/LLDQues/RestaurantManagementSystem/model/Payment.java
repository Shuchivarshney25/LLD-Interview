package LLDQues.RestaurantManagementSystem.model;

public class Payment {
    private int paymentId;
    private double amount;
    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;
    private Order order;


    public Payment(int paymentId, double amount, PaymentMethod paymentMethod, Order order) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.PENDING;
        this.paymentMethod = paymentMethod;
        this.order = order;
    }


    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrderId(Order order) {
        this.order = order;
    }


}



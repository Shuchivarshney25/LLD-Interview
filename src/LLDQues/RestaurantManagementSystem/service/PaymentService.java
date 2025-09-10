package LLDQues.RestaurantManagementSystem.service;

import LLDQues.RestaurantManagementSystem.model.Order;
import LLDQues.RestaurantManagementSystem.model.Payment;
import LLDQues.RestaurantManagementSystem.model.PaymentMethod;
import LLDQues.RestaurantManagementSystem.model.PaymentStatus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PaymentService {
    private Map<Integer, Payment> payments;
    private AtomicInteger paymentIdGenerator;

    public PaymentService() {
        this.payments = new ConcurrentHashMap<Integer, Payment>();
        this.paymentIdGenerator = new AtomicInteger(1);

    }

    public Payment processPayment(Order order, PaymentMethod method) {
        int paymentId = paymentIdGenerator.getAndIncrement();
        Payment payment = new Payment(paymentId,  order.getTotalAmount(), method,order);

        boolean paymentSuccess = simulatePaymentProcessing(method, payment.getAmount());

        if (paymentSuccess) {
            payment.setPaymentStatus(PaymentStatus.COMPLETED);
        } else {
            payment.setPaymentStatus(PaymentStatus.FAILED);
        }

        payments.put(paymentId, payment);
        return payment;
    }

    private boolean simulatePaymentProcessing(PaymentMethod method, double amount) {
        // Simulate payment processing logic
        // For demonstration, assume 95% success rate
        return Math.random() < 0.95;
    }
}

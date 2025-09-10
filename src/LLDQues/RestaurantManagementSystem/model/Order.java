package LLDQues.RestaurantManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderId;
    private List<OrderItem> orderItems;
    private OrderStatus orderStatus;
    private double totalAmount;

    public Order(int orderId) {
        this.orderId = orderId;
        this.orderItems = new ArrayList<OrderItem>();
        this.orderStatus = OrderStatus.PENDING;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void addItems(OrderItem item){
        orderItems.add(item);
        calculateTotal();
    }

    private void calculateTotal() {
        totalAmount = 0.0;
        for (OrderItem item : orderItems) {
            totalAmount += item.getSubtotal();
        }
    }

}



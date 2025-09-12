package LLDQues.RestaurantManagementSystem;

import LLDQues.RestaurantManagementSystem.model.*;

import java.util.Date;

public class Driver {
    public static void main(String[] args) {
        RestaurantManagementSystem restaurant = new RestaurantManagementSystem(20);
        // Add some menu items
        MenuItem pizza = new MenuItem(1, "Margherita Pizza", "Classic pizza with tomato and mozzarella", 12.99, "Main Course");
        MenuItem pasta = new MenuItem(2, "Spaghetti Carbonara", "Creamy pasta with bacon", 14.99, "Main Course");
        MenuItem salad = new MenuItem(3, "Caesar Salad", "Fresh lettuce with caesar dressing", 8.99, "Appetizer");

        restaurant.addMenu(pizza);
        restaurant.addMenu(pasta);
        restaurant.addMenu(salad);

        // Add ingredients
        Ingredient tomatoes = new Ingredient(1, "Tomatoes", 50, "kg", 10);
        Ingredient cheese = new Ingredient(2, "Mozzarella Cheese", 30, "kg", 5);
        restaurant.addIngredient(tomatoes);
        restaurant.addIngredient(cheese);

        // Register customer
        Customer customer = restaurant.registerCustomer("Shuchi", "845376582368", "sh@gmail,com");

        // Make reservation
        //System.out.println("Available tables: " + restaurant.getAvailableTables());
        Reservation reservation = restaurant.makeReservation(customer.getCustomerId(), new Date());
        System.out.println("Reservation made for table: " + reservation.getTableNumber());
        //System.out.println("Available tables after reservation: " + restaurant.getAvailableTables());

        // Place order
        Order order = restaurant.createOrder(customer.getCustomerId());
        restaurant.addItemToOrder(order.getOrderId(), 1, 2); // 2 pizzas
        restaurant.addItemToOrder(order.getOrderId(), 3, 1); // 1 salad

        System.out.println("Order total: INR " + order.getTotalAmount());

        // Process payment
        Payment payment = restaurant.processPayment(order.getOrderId(), PaymentMethod.CREDIT_CARD);
        System.out.println("Payment status: " + payment.getPaymentStatus());

        // Update order status
        restaurant.updateOrderStatus(order.getOrderId(), OrderStatus.PREPARING);
        restaurant.updateOrderStatus(order.getOrderId(), OrderStatus.READY);
        restaurant.updateOrderStatus(order.getOrderId(), OrderStatus.SERVED);

        System.out.println("Restaurant Management System Demo Completed!");

    }
}

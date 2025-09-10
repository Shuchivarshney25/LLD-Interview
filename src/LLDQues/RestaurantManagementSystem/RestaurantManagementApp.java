package LLDQues.RestaurantManagementSystem;

import LLDQues.RestaurantManagementSystem.model.*;
import LLDQues.RestaurantManagementSystem.service.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestaurantManagementApp {
    private CustomerService customerService;
    private MenuService menuService;
    private InventoryService inventoryService;
    private OrderService orderService;
    private PaymentService paymentService;
    private ReservationService reservationService;

    public RestaurantManagementApp(int totalTables) {
        this.customerService = new CustomerService();
        this.menuService = new MenuService();
        this.inventoryService = new InventoryService();
        this.orderService = new OrderService();
        this.paymentService = new PaymentService();
        this.reservationService = new ReservationService(totalTables);
    }


    //customer management
    public Customer registerCustomer(String name, String phoneNumber, String email){
        return customerService.registerCustomer(name,phoneNumber,email);
    }

    public Customer getCustomer(int customerId){
        return customerService.getCustomer(customerId);
    }

    //menu operation

    public void addMenu(MenuItem menuItem){
        menuService.addMenuItem(menuItem);
    }

    public List<MenuItem> viewMenu(){
       return menuService.getAvailableItems();
    }

    public List<MenuItem> viewMenuByCategory(String category){
        return menuService.getItemByCategory(category);
    }


    //order operation

    public Order createOrder(int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if(customer != null){
            return orderService.createOrder(customer);
        }
        return null;
    }


    public void addItemToOrder(int orderId, int menuItemId, int quantity) {
        MenuItem menuItem = menuService.getMenuItem(menuItemId);
        if (menuItem != null && menuItem.isAvailable()) {
            OrderItem orderItem = new OrderItem(menuItem, quantity);
            orderService.addItemsToOrder(orderId, orderItem);
        }
    }

    public boolean updateOrderStatus(int orderId, OrderStatus status) {
        return orderService.updateOrderByStatus(orderId, status);
    }



    // Reservation Operations
    public Reservation makeReservation(int customerId, Date date){
        Customer customer = customerService.getCustomer(customerId);
        if (customer != null) {
            return reservationService.makeReservation(customer, date);
        }
        return null;
    }

    public boolean cancelReservation(int reservationId) {
        return reservationService.cancelReservation(reservationId);
    }

    // Payment Operations
    public Payment processPayment(int orderId, PaymentMethod method) {
        Order order = orderService.getOrder(orderId);
        if (order != null) {
            return paymentService.processPayment(order, method);
        }
        return null;
    }

    // Inventory Operations
    public void addIngredient(Ingredient ingredient) {
        inventoryService.addIngredient(ingredient);
    }

    public boolean updateInventory(int ingredientId, int quantity) {
        return inventoryService.updateIngredientQuantity(ingredientId, quantity);
    }
}

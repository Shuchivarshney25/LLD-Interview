package LLDQues.RestaurantManagementSystem.service;

import LLDQues.RestaurantManagementSystem.model.Customer;
import LLDQues.RestaurantManagementSystem.model.Order;
import LLDQues.RestaurantManagementSystem.model.OrderItem;
import LLDQues.RestaurantManagementSystem.model.OrderStatus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderService {
   private Map<Integer, Order> orders;
   private AtomicInteger orderIdGenerator;

    public OrderService() {
        this.orders = new ConcurrentHashMap<Integer, Order>();
        this.orderIdGenerator = new AtomicInteger(1);
    }

    public Order createOrder(Customer customer){
       int orderId = orderIdGenerator.getAndIncrement();
       Order order = new Order(orderId);
       orders.put(orderId,order);
       return order;
   }

   public void addItemsToOrder(int orderId, OrderItem item){
       Order order = orders.get(orderId);
       if(order != null){
           order.addItems(item);
       }
   }

   public boolean updateOrderByStatus(int orderId, OrderStatus orderstatus){
       Order order = orders.get(orderId);
       if(order != null){
           order.setOrderStatus(orderstatus);
           return  true;
       }else {
           return false;
       }
   }

   public Order getOrder(int orderId){
       return orders.get(orderId);
   }
}

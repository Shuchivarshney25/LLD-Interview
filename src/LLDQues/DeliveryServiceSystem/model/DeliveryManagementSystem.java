package LLDQues.DeliveryServiceSystem.model;


import java.util.*;

public class DeliveryManagementSystem {
       private List<Order> orders;
       private List<DeliveryAgent> agents;
       private Map<String, Queue<Order>> orderQueue;
       private Map<String, List<DeliveryAgent>> agentsByPinCode;

       public DeliveryManagementSystem(){
           this.orders = new ArrayList<>();
           this.agents = new ArrayList<>();
           this.orderQueue = new HashMap<>();
           this.agentsByPinCode = new HashMap<>();
       }

       public void createOrder(String orderName, String pinCode){
           Order order = new Order(orderName,pinCode);
           orders.add(order);

           //Ensure we have a queue for this pincode
           if(!orderQueue.containsKey(pinCode)){
               orderQueue.put(pinCode, new LinkedList<Order>());
           }

           //add the order to the queue specific pincode
           orderQueue.get(pinCode).offer(order);
       }

       public void createAgent(String agentName, String pinCode){
           DeliveryAgent agent = new DeliveryAgent(agentName,pinCode);
           agents.add(agent);

           if (!agentsByPinCode.containsKey(pinCode)) {
               agentsByPinCode.put(pinCode, new ArrayList<DeliveryAgent>());
           }
           agentsByPinCode.get(pinCode).add(agent);
       }



       public void assignOrderToAgent(){
           for (Map.Entry<String,Queue<Order>> entry: orderQueue.entrySet()) {
               String pinCode = entry.getKey();
               Queue<Order> orders = entry.getValue();

               if(!orders.isEmpty()){
                   Order order = orders.peek();
                   if(order.getOrderStatus() == OrderStatus.CREATED){
                       DeliveryAgent availableAgent = findAvailableAgent(pinCode);
                       if(availableAgent != null){
                            orders.poll();
                           deliverOrder(availableAgent,order);
                       }
                   }
               }

           }
       }


    public DeliveryAgent findAvailableAgent(String pinCode) {
        List<DeliveryAgent> deliveryAgents = agentsByPinCode.get(pinCode);
        if(deliveryAgents != null){
            for (DeliveryAgent agent: deliveryAgents) {
                  if(agent.isAvailable()){
                      return agent;
                  }
            }
        }
        return null;

    }

    public void deliverOrder(DeliveryAgent availableAgent, Order order) {
           availableAgent.setAvailable(false);
           order.setOrderStatus(OrderStatus.PICKED_UP);
           System.out.println(availableAgent.getAgentName() + " has picked up " + order.getOrderName());
        // TODO: taking delivery time to deliver the order
           order.setOrderStatus(OrderStatus.DELIVERED);
           availableAgent.setAvailable(true);
        System.out.println(availableAgent.getAgentName() + " has delivered " + order.getOrderName() + " to " + order.getPinCode());



    }



}

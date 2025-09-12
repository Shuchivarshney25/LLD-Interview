package LLDQues.DeliveryServiceSystem;

public class Driver {
    public DeliveryManagementSystem system;

    public Driver() {
        this.system = new DeliveryManagementSystem();
    }

    public void runDeliveryProcess() {
        System.out.println("Creating orders and agents...\n");

        system.createOrder("Order A", "560087");
        system.createOrder("Order B", "560088");
        system.createOrder("Order C", "560089");
        system.createOrder("Order D", "560087");

        system.createAgent("Agent A", "560087");
        system.createAgent("Agent B", "560088");
        system.createAgent("Agent C", "560089");

        system.assignOrderToAgent();
        system.assignOrderToAgent();
        system.assignOrderToAgent();
        system.assignOrderToAgent();


        system.createOrder("Order E", "560090");
        system.createOrder("Order F", "560091");

        system.assignOrderToAgent();

    }

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.runDeliveryProcess();
    }



}

package LLDQues.DeliveryServiceSystem.model;


public class Order {
    private String orderId;
    private String orderName;
    private String pinCode;
    private OrderStatus orderStatus;

    public Order( String orderName, String pinCode) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.pinCode = pinCode;
        this.orderStatus = OrderStatus.CREATED;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }


}

package LLDQues.ShoppingCartSystem.model;

import LLDQues.ShoppingCartSystem.exception.CartException;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String, CartItem> items;
    private Cart cart;
    private ProductCatalog productCatalog;
    private String cartId;
    private static final int MAX_ITEM_QUANTITY = 10;
    private static final int MAX_CART_SIZE = 20;

    public Cart(String cartId, ProductCatalog productCatalog) {
        this.cartId = cartId;
        this.productCatalog = productCatalog;
        this.items = new HashMap<>();
    }

    public void addItem(String productId, int quantity) throws CartException {
        //adding existing item
        Product product = productCatalog.getProduct(productId);
        if(items.containsKey(productId)){
            CartItem existingCartItem = items.get(productId);
             int newQuantity = existingCartItem.getQuantity() + quantity;

             if(newQuantity > MAX_CART_SIZE){
                 throw new CartException("Cannot add " + quantity + " items. Maximum " +
                         MAX_ITEM_QUANTITY + " items allowed per product.");
             }

             if(!productCatalog.isProductAvailable(productId,quantity)){
                 throw new CartException("out of stock");
             }
             existingCartItem.setQuantity(newQuantity);
        }else {
            //add new item
            if(items.size() >= MAX_CART_SIZE){
                throw  new CartException("cart is full");
            }
            CartItem newCartItem = new CartItem(product, quantity);
            items.put(productId,newCartItem);
        }
    }

    public void viewCart(){
        if(items.isEmpty()){
            System.out.println("cart is empty");
            return;
        }
    }

    public void removeItem(String productId) throws Exception {
        if(productId == null){
            throw new Exception("product id cannot be null");
        }
        items.remove(productId);
    }

    public void clearCart(){
        items.clear();
    }

    public void checkOut() throws CartException {
        int totalAmount = 0;
        if(items.isEmpty()){
            throw new CartException("cannot checkout without empty cart");
        }

        for (CartItem cartItem: items.values()) {
            int productId = cartItem.getProduct().getProductId();
            int quantity = cartItem.getQuantity();

            productCatalog.updateStock(productId, quantity);
            totalAmount += cartItem.getTotalPrice();
        }
        System.out.println("checkout successfull");
        System.out.println("total order amount in Rs." +totalAmount);
        System.out.println("item purchased " +items.size());

        items.clear();
        System.out.println("cart clear after successful checkout");
    }
}

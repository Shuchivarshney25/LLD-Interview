package LLDQues.ShoppingCart;

import LLDQues.ShoppingCart.exception.CartException;
import LLDQues.ShoppingCart.model.Cart;
import LLDQues.ShoppingCart.model.Product;
import LLDQues.ShoppingCart.model.ProductCatalog;

public class Driver {
    public static void main(String[] args) {
        // Initialize system
        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(new Product(1, "Laptop", 60000.0, 5));
        catalog.addProduct(new Product(2, "Mouse", 200, 3));
        catalog.addProduct(new Product(3, "Keyboard", 500.0, 4));
        Cart cart = new Cart("CART_001", catalog);

        try {

            // Test adding items
            cart.addItem("P101", 2);  // Add 2 laptops
            cart.addItem("P002", 1);  // Add 1 mouse
            cart.addItem("P003", 1);  // Add 1 keyboard

             //View cart
            cart.viewCart();

            // Test edge cases
            System.out.println("\n=== Testing Edge Cases ===");

            // Try to add out of stock item
            try {
                cart.addItem("P004", 10); // Only 5 monitors available
            } catch (CartException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Try to add invalid quantity
            try {
                cart.addItem("P002", 0);
            } catch (CartException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Remove an item
            cart.removeItem("P003");
            cart.viewCart();

            // Checkout
            System.out.println("\n=== Checkout ===");
            cart.checkOut();

            // Try to checkout empty cart
            try {
                cart.checkOut();
            } catch (CartException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (CartException e) {
            System.out.println("Cart Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

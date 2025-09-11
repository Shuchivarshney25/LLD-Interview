package LLDQues.ShoppingCartSystem.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCatalog {
    private Map<Integer,Product> products;

    public ProductCatalog(){
        this.products = new HashMap<>();
    }

    public void addProduct(Product product){
        products.put(product.getProductId(),product);
    }

    public void removeProduct(int productId){
            products.remove(productId);

    }

    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        for (Product product: products.values()) {
            list.add(product);
        }
        return list;
    }

    public boolean isProductAvailable(String productId, int quantity){
        Product product = products.get(productId);
        if(product != null && product.isInStock(quantity)){
            return true;
        }
        return false;
    }

    public Product getProduct(String productId){
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("WARNING: Product not found for ID: " + productId);
        }
        return product;
    }

    public void updateStock(int productId, int quantity){
        Product product = products.get(productId);
        if(product != null){
            product.setStockQuantity(product.getStockQuantity() - quantity);
        }


    }

}

package LLDQues.RestaurantManagementSystem.service;

import LLDQues.RestaurantManagementSystem.model.Ingredient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {
    private Map<Integer, Ingredient> ingredients;

    public InventoryService() {
        this.ingredients = new ConcurrentHashMap<>();

    }

    public void addIngredient(Ingredient ingredient){
        ingredients.put(ingredient.getIngredientId(),ingredient);
    }

    public boolean updateIngredientQuantity(int ingredientId, int newQuantity){
        Ingredient ingredient = ingredients.get(ingredientId);
        if(ingredient == null){
            ingredient.setQuantity(newQuantity);
            return true;
        }else {
            return false;
        }
    }

    public boolean consumeIngredient(int ingredientId, int quantity){
        Ingredient ingredient = ingredients.get(ingredientId);
        if(ingredient != null && ingredient.getQuantity() >= quantity){
            ingredient.setQuantity(ingredient.getQuantity() - quantity);
            return true;
        }else {
            return false;
        }
    }


    public Ingredient getIngredient(int ingredientId){
        return ingredients.get(ingredientId);
    }
}

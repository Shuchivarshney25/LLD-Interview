package LLDQues.RestaurantManagementSystem.model;

public class Ingredient{
    private int ingredientId;
    private String name;
    private int quantity;
    private String unit; //kg, litre etc etc
    private int minThreshold;


    public Ingredient(int ingredientId, String name, int quantity, String unit, int minThreshold) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.minThreshold = minThreshold;
    }


    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(int minThreshold) {
        this.minThreshold = minThreshold;
    }




}

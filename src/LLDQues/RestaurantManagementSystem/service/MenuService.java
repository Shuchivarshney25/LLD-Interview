package LLDQues.RestaurantManagementSystem.service;

import LLDQues.RestaurantManagementSystem.model.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MenuService {
    private Map<Integer, MenuItem> menuItems;

    public MenuService() {
        this.menuItems = new ConcurrentHashMap<>();
    }


    public void addMenuItem(MenuItem item){
        menuItems.put(item.getItemId(), item);
    }

    public MenuItem getMenuItem(int itemId){
        return menuItems.get(itemId);
    }

    public List<MenuItem> getItemByCategory(String category){
        List<MenuItem> result = new ArrayList<>();
        for (MenuItem item: menuItems.values()) {
             if(item.getCategory().equals(category) && item.isAvailable()){
                 result.add(item);
             }
        }
        return result;
    }

    public List<MenuItem> getAvailableItems(){
        List<MenuItem> availableItemList = new ArrayList<>();
        for (MenuItem item: menuItems.values()){
            if(item.isAvailable()){
                availableItemList.add(item);
            }
        }
        return availableItemList;
    }
}


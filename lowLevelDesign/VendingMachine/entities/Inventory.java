package lowLevelDesign.VendingMachine.entities;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Integer> stocks = new HashMap<>();
    private final Map<String, Item> items = new HashMap<>();

    public void addItem(Item item, String code, int quantity) {
        System.out.println("Adding item: " + item.getName() + " with code: " + code);
        items.put(code, item);
        stocks.put(code, stocks.getOrDefault(code, 0) + quantity);
    }

    public void removeItem(String code) {
        if (stocks.containsKey(code) && stocks.get(code) > 0) {
            stocks.put(code, stocks.get(code) - 1);
            System.out.println("Removed item with code: " + code);
        } else {
            System.out.println("Item with code: " + code + " is out of stock!");
        }
    }

    public Item getItem(String code) {
        return items.get(code);
    }

    public boolean isAvailable(String itemName) {
        return stocks.getOrDefault(itemName, 0) > 0;
    }


}

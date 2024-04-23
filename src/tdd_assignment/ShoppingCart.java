package tdd_assignment;
import java.util.HashMap;
import java.util.Map;
public class ShoppingCart {
    private Map<String, Double> items;
    public ShoppingCart() {
        this.items = new HashMap<>();
    }
    public void addItem(String itemName, double price) {
        items.put(itemName, price);
    }
    public void removeItem(String itemName) {
        items.remove(itemName);
    }
    public int getItemCount() {
        return items.size();
    }
    public double calculateTotal() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        return total;
    }
}

package exercicedeux.domain;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Integer> stock = new HashMap<>();

    public void addStock(String medication, int quantity) {
        stock.put(medication, stock.getOrDefault(medication, 0) + quantity);
    }

    public boolean hasStockFor(String medication) {
        return stock.getOrDefault(medication, 0) > 0;
    }

    public int getStockLevel(String medication) {
        return stock.getOrDefault(medication, 0);
    }
}


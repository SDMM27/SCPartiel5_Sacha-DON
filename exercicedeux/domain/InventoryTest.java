package exercicedeux.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    @Test
    void shouldStartWithEmptyStock() {
        Inventory inventory = new Inventory();

        assertFalse(inventory.hasStockFor("X"));
        assertEquals(0, inventory.getStockLevel("X"));
    }

    @Test
    void shouldAddStockCorrectly() {
        Inventory inventory = new Inventory();
        inventory.addStock("X", 10);

        assertTrue(inventory.hasStockFor("X"));
        assertEquals(10, inventory.getStockLevel("X"));
    }

    @Test
    void shouldIncreaseStockWhenAddingMore() {
        Inventory inventory = new Inventory();
        inventory.addStock("X", 5);
        inventory.addStock("X", 10);

        assertEquals(15, inventory.getStockLevel("X"));
    }

    @Test
    void shouldReturnZeroForUnknownMedication() {
        Inventory inventory = new Inventory();

        assertEquals(0, inventory.getStockLevel("Z"));
    }
}


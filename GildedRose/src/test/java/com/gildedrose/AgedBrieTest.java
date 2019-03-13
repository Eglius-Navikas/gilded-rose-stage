package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.services.InventoryService;
import com.gildedrose.services.ItemUpdateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {

    private ItemUpdateService itemUpdateService = new ItemUpdateService();

    @Test
    public void agedBrieGainsQualityDaily() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 10)};
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(11, inventoryService.getItems().get(0).quality);
    }

    @Test
    public void agedBrieGainsQualityTwiceAsFastAfterExpiration() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 10)};
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(12, inventoryService.getItems().get(0).quality);
    }

    @Test
    public void agedBrieCannotGainQualityAbove50() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 50),
                new Item("Aged Brie", 0, 50),
                new Item("Aged Brie", 0, 49),
                new Item("Aged Brie", 0, 49)
        };
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(50, inventoryService.getItems().get(0).quality);
        assertEquals(50, inventoryService.getItems().get(1).quality);
        assertEquals(50, inventoryService.getItems().get(2).quality);
        assertEquals(50, inventoryService.getItems().get(3).quality);
    }
}

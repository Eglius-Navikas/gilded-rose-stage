package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.services.InventoryService;
import com.gildedrose.services.ItemUpdateService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasTest {

    private ItemUpdateService itemUpdateService = new ItemUpdateService();

    @Test
    public void sulfurasQualityNeverAlters() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(80, inventoryService.getItems().get(0).quality);
        assertEquals(80, inventoryService.getItems().get(1).quality);
    }

}

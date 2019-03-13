package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.services.InventoryService;
import com.gildedrose.services.ItemUpdateService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private ItemUpdateService itemUpdateService = new ItemUpdateService();

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals("foo", inventoryService.getItems().get(0).name);
    }

}

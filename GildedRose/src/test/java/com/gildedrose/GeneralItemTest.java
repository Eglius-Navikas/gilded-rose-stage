package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.services.InventoryService;
import com.gildedrose.services.ItemUpdateService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneralItemTest {

    private ItemUpdateService itemUpdateService = new ItemUpdateService();

    @Test
    public void generalItemLosesQualityDaily() {
        Item[] items = new Item[]{new Item("foo", 10, 10)};
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(9, inventoryService.getItems().get(0).quality);
    }

    @Test
    public void generalItemPastExpirationLosesQualityTwiceAsFast() {
        Item[] items = new Item[]{new Item("foo", 0, 10)};
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(8, inventoryService.getItems().get(0).quality);
    }

    @Test
    public void qualityOfAnItemDoesNotDegradeIntoNegative() {
        Item[] items = new Item[]{new Item("foo", 10, 0)};
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(0, inventoryService.getItems().get(0).quality);
    }
}

package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.services.InventoryService;
import com.gildedrose.services.ItemUpdateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

public class ConjuredItemTest {

    private ItemUpdateService itemUpdateService = new ItemUpdateService();

    @Test
    public void conjuredItemLosesQualityTwiceAsFastAsNormalDaily() {
        Item[] items = new Item[]{new Item("foo", 10, 10),
                new Item("Conjured Sweetroll", 10, 10)
        };
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(9, inventoryService.getItems().get(0).quality);
        assertEquals(8, inventoryService.getItems().get(1).quality);
    }

    @Test
    public void conjuredItemPastExpirationLosesQualityTwiceAsFast() {
        Item[] items = new Item[]{new Item("Conjured Bananapie", 0, 10)};
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(6, inventoryService.getItems().get(0).quality);
    }

    @Test
    public void qualityOfAConjuredItemDoesNotDegradeIntoNegative() {
        Item[] items = new Item[]{
                new Item("Conjured Replica of Thunderfury, Blessed Blade of the Windseeker", 10, 0)
        };
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(0, inventoryService.getItems().get(0).quality);
    }
}

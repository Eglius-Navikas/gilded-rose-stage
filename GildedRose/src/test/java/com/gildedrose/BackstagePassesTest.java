package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.services.InventoryService;
import com.gildedrose.services.ItemUpdateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

public class BackstagePassesTest {

    private ItemUpdateService itemUpdateService = new ItemUpdateService();

    @Test
    public void backstagePassesQualityIncreasesDaily() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10)};
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(11, inventoryService.getItems().get(0).quality);
    }

    @Test
    public void backstagePassesQualityIncreasesTwiceAsFastWhen6To10DaysRemain() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10)};
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(12, inventoryService.getItems().get(0).quality);
    }

    @Test
    public void backstagePassesQualityIncreasesThriceAsFastWhen1To5DaysRemain() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10)};
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(13, inventoryService.getItems().get(0).quality);
    }

    @Test
    public void backstagePassesLoseAllQualityAfterExpiration() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        InventoryService inventoryService = new InventoryService(itemUpdateService, items);
        inventoryService.updateQuality();
        assertEquals(0, inventoryService.getItems().get(0).quality);
    }
}

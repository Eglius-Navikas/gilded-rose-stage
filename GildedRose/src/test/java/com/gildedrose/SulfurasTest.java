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
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        Item item2 = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        itemUpdateService.updateItem(item);
        itemUpdateService.updateItem(item2);
        assertEquals(80, item.quality);
        assertEquals(80, item2.quality);
    }

}

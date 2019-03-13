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
        Item item = new Item("Foo", 10, 10);
        itemUpdateService.updateItem(item);
        assertEquals("Foo", item.name);
    }

}

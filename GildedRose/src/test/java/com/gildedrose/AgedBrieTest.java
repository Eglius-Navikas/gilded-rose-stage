package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.services.ItemUpdateService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {

    private ItemUpdateService itemUpdateService = new ItemUpdateService();

    @Test
    public void agedBrieGainsQualityDaily() {
        Item item = new Item("Aged Brie", 10, 10);
        itemUpdateService.updateItem(item);
        assertEquals(11, item.quality);
    }

    @Test
    public void agedBrieGainsQualityTwiceAsFastAfterExpiration() {
        Item item = new Item("Aged Brie", 0, 10);
        itemUpdateService.updateItem(item);
        assertEquals(12, item.quality);
    }

    @Test
    public void agedBrieCannotGainQualityAbove50() {
        Item item = new Item("Aged Brie", 10, 50);
        Item item2 = new Item("Aged Brie", 0, 50);
        Item item3 = new Item("Aged Brie", 0, 49);
        Item item4 = new Item("Aged Brie", 0, 48);
        itemUpdateService.updateItem(item);
        itemUpdateService.updateItem(item2);
        itemUpdateService.updateItem(item3);
        itemUpdateService.updateItem(item4);
        assertEquals(50, item.quality);
        assertEquals(50, item2.quality);
        assertEquals(50, item3.quality);
        assertEquals(50, item4.quality);

    }
}

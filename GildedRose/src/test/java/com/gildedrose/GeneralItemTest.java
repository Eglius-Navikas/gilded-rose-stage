package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.services.ItemUpdateService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneralItemTest {

    private ItemUpdateService itemUpdateService = new ItemUpdateService();

    @Test
    public void generalItemLosesQualityDaily() {
        Item item = new Item("foo", 10, 10);
        itemUpdateService.updateItem(item);
        assertEquals(9, item.quality);
    }

    @Test
    public void generalItemPastExpirationLosesQualityTwiceAsFast() {
        Item item = new Item("foo", 0, 10);
        itemUpdateService.updateItem(item);
        assertEquals(8, item.quality);
    }

    @Test
    public void qualityOfAnItemDoesNotDegradeIntoNegative() {
        Item item = new Item("foo", 10, 0);
        itemUpdateService.updateItem(item);
        assertEquals(0, item.quality);
    }
}

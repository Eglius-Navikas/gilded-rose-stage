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
        Item item = new Item("foo", 10, 10);
        itemUpdateService.updateItem(item);
        Item item2 = new Item("Conjured Sweetroll", 10, 10);
        itemUpdateService.updateItem(item2);
        assertEquals(9, item.quality);
        assertEquals(8, item2.quality);
    }

    @Test
    public void conjuredItemPastExpirationLosesQualityTwiceAsFast() {
        Item item = new Item("Conjured Bananapie", 0, 10);
        itemUpdateService.updateItem(item);
        assertEquals(6, item.quality);
    }

    @Test
    public void qualityOfAConjuredItemDoesNotDegradeIntoNegative() {
        Item item = new Item("Conjured Replica of Thunderfury, Blessed Blade of the Windseeker", 10, 0);
        itemUpdateService.updateItem(item);
        assertEquals(0, item.quality);
    }
}

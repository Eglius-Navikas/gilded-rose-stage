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
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10);
        itemUpdateService.updateItem(item);
        assertEquals(11, item.quality);
    }

    @Test
    public void backstagePassesQualityIncreasesTwiceAsFastWhen6To10DaysRemain() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        itemUpdateService.updateItem(item);
        assertEquals(12, item.quality);

    }

    @Test
    public void backstagePassesQualityIncreasesThriceAsFastWhen1To5DaysRemain() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10);
        itemUpdateService.updateItem(item);
        assertEquals(13, item.quality);
    }

    @Test
    public void backstagePassesLoseAllQualityAfterExpiration() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        itemUpdateService.updateItem(item);
        assertEquals(0, item.quality);
    }
}

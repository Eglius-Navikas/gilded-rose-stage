package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstagePassesTest {

    @Test
    public void backstagePassesQualityIncreasesDaily() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void backstagePassesQualityIncreasesTwiceAsFastWhen6To10DaysRemain() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void backstagePassesQualityIncreasesThriceAsFastWhen1To5DaysRemain() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void backstagePassesLoseAllQualityAfterExpiration() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}

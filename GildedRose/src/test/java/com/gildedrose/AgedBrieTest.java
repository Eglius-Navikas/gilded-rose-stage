package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {

    @Test
    public void agedBrieGainsQualityDaily() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void agedBrieGainsQualityTwiceAsFastAfterExpiration() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void agedBrieCannotGainQualityAbove50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50),
                new Item("Aged Brie", 0, 50),
                new Item("Aged Brie", 0, 49),
                new Item("Aged Brie", 0, 49)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(50, app.items[2].quality);
        assertEquals(50, app.items[3].quality);
    }
}

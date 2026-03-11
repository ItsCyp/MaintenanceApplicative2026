package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void standardItem_decreasesQualityAndSellIn() {
        Item[] items = new Item[] { new Item("Item", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void standardItem_decreasesQualityTwiceAsFast_afterSellIn() {
        Item[] items = new Item[] { new Item("Item", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void quality_isNeverNegative() {
        Item[] items = new Item[] { new Item("Item", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void agedBrie_increasesInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void agedBrie_increasesInQualityTwiceAsFast_afterSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void quality_isNeverMoreThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void sulfuras_neverChanges() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sulfuras_neverChanges_evenAfterSellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstagePasses_increasesInQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void backstagePasses_increasesByTwo_when10DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void backstagePasses_increasesByThree_when5DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void backstagePasses_dropsToZero_afterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void item_toString() {
        Item item = new Item("foo", 10, 20);
        assertEquals("foo, 10, 20", item.toString());
    }
}

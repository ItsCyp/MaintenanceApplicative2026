package com.gildedrose;

class GildedRose {
    Item[] items;

    static final String AGED_BRIE = "Aged Brie";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        switch (item.name) {
            case AGED_BRIE -> updateAgedBrie(item);
            case BACKSTAGE_PASSES -> updateBackstagePasses(item);
            case SULFURAS -> updateSulfuras(item);
            default -> updateStandardItem(item);
        }
    }

    private void updateAgedBrie(Item item) {
        increaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void updateBackstagePasses(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 10) {
            increaseQuality(item);
        }
        if (item.sellIn <= 5) {
            increaseQuality(item);
        }
        
        item.sellIn--;
        
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateSulfuras(Item item) {
        // Sulfuras ne change pas
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void updateStandardItem(Item item) {
        decreaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }
}

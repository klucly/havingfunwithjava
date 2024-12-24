package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItemQuality(Item item) {
        if (item.name.equals(Item.Names.AGED_BRIE)) {
            item.incrementQualityUpToThreshold();

        } else if (item.name.equals(Item.Names.BACKSTAGE_PASSES)) {
            item.incrementQualityUpToThreshold();
            if (item.sellIn < 11) {
                item.incrementQualityUpToThreshold();
            }
            
            if (item.sellIn < 6) {
                item.incrementQualityUpToThreshold();
            }

        } else if (!item.name.equals(Item.Names.SULFURAS)) {
            item.decrementQualityDownToThreshold();
        }

        if (!item.name.equals(Item.Names.SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn >= 0) return;

        if (item.name.equals(Item.Names.AGED_BRIE)) {
            item.incrementQualityUpToThreshold();
        } else if (item.name.equals(Item.Names.BACKSTAGE_PASSES)) {
            item.quality = 0;
        } else if (!item.name.equals(Item.Names.SULFURAS)) {
            item.decrementQualityDownToThreshold();
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }
}

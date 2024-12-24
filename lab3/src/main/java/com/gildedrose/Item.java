package com.gildedrose;

public class Item {

    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
    public String toString() {
        return String.format("%s, %s, %s", this.name, this.sellIn, this.quality);
    }
    public void decrementQualityDownToThreshold() {
        this.quality -= 1;
    }
    public void incrementQualityUpToThreshold() {
        if (this.quality < 50) {
            this.quality += 1;
        }
    }
}

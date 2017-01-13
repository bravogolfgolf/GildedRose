package com.gildedrose;

class BackstageItem extends Item {
    BackstageItem(String name, int sellin, int quality) {
        super(name, sellin, quality);
    }

    @Override
    void UpdateQuality() {
        sellIn -= 1;

        quality += 1;

        if (sellIn < 10)
            quality += 1;

        if (sellIn < 5)
            quality += 1;

        if (sellIn < 0)
            quality = 0;

        if (quality > 50)
            quality = 50;
    }

}


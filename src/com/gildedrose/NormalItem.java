package com.gildedrose;

class NormalItem extends Item {
    NormalItem(String name, int sellin, int quality) {
        super(name, sellin, quality);
    }

    @Override
    void UpdateQuality() {
        sellIn -= 1;

        quality -= 1;

        if (sellIn < 0)
            quality -= 1;

        if (quality < 0)
            quality = 0;
    }
}

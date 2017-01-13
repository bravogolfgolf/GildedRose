package com.gildedrose;

class OtherItem extends Item {
    OtherItem(String name, int sellin, int quality) {
        super(name, sellin, quality);
    }

    @Override
    void UpdateQuality() {
        if (!name.equals(AGED_BRIE)
                && !name.equals(Item.BACKSTAGE_PASS)) {
            if (quality > 0) {
                if (!name.equals(Item.SULFURAS)) {
                    quality = quality - 1;
                }
            }
        } else if (quality < 50) {
            quality = quality + 1;

            if (name.equals(Item.BACKSTAGE_PASS)) {
                if (sellIn < 11) {
                    if (quality < 50) {
                        quality = quality + 1;
                    }
                }

                if (sellIn < 6) {
                    if (quality < 50) {
                        quality = quality + 1;
                    }
                }
            }
        }

        if (!name.equals(Item.SULFURAS)) {
            sellIn = sellIn - 1;
        }

        if (sellIn < 0) {
            if (!name.equals(Item.AGED_BRIE)) {
                if (!name.equals(Item.BACKSTAGE_PASS)) {
                    if (quality > 0) {
                        if (!name.equals(Item.SULFURAS)) {
                            quality = quality - 1;
                        }
                    }
                } else {
                    quality = 0;
                }
            } else {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
    }
}

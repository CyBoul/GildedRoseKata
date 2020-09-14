package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if ( item.name.equals("Backstage passes to a TAFKAL80ETC concert") ) {
                if ( item.quality < 50 ) {
                    if ( item.sellIn > 10 ) {
                        item.quality = item.quality + 1;
                    } else if ( item.sellIn > 5 ) {
                        item.quality = item.quality + 2;
                    } else if ( item.sellIn > 0 ) {
                        item.quality = item.quality + 3;
                    } else {
                        item.quality = 0;
                    }
                }
            } else if ( item.name.equals("Aged Brie") ) {
                if ( item.quality < 50 ) {
                    item.quality = ( item.sellIn < 0 ) ? item.quality + 2 : item.quality + 1;
                }       
            } else if ( item.name.equals("Conjured Mana Cake") ) {
                if ( item.quality > 0 ) {
                    item.quality = ( item.sellIn < 0 ) ? item.quality - 4 :  item.quality - 2;
                }       
            } else if ( !item.name.equals("Sulfuras, Hand of Ragnaros") ) {
                if ( item.quality > 0 ) {
                    item.quality = ( item.sellIn < 0 ) ? item.quality - 2 : item.quality - 1;
                } 
            } 
            
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }
        }
    }
}
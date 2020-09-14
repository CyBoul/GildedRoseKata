package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;

class GildedRoseTest {
    
    public Item getCustomUpdatedItem(String name, int sellIn, int quality) {
        Item[] items    = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app  = new GildedRose(items);
        app.updateQuality();
        return app.items[0];
    }
    
    @Test
    @DisplayName("Decrements sellIn each update")
    public void testSellInDecrement() {
        
        int sellIn  = 0;
        Item item   = this.getCustomUpdatedItem("foo", sellIn, 0);
        
        assertTrue(item.sellIn == sellIn-1);
    }
    
    @Test
    @DisplayName("Decrements quality when > 0 each update")
    public void testQualityDecrement() {
        
        int quality = 1;
        Item item   = this.getCustomUpdatedItem("PositiveQuality", 0, quality);

        assertTrue(item.quality == quality-1);
    }
    
    @Test
    @DisplayName("Quality is never negative")
    public void testQualityNoDecrement() {
        
        int quality = 0;
        Item item   = this.getCustomUpdatedItem("ZeroQuality", 0, quality);
        
        assertTrue(item.quality > -1);
    }
    
    @Test
    @DisplayName("Quality degrades twice when expired")
    public void testQualityDecrementTwice() {
        
        int expired = -1;
        int quality = 2;
        Item item   = this.getCustomUpdatedItem("ExpiredItem", expired, quality);

        assertTrue(item.quality == quality-2);
    }
    
    @Test
    @DisplayName("Aged Brie Quality improve over time")
    public void testQualityAgedBrieIncrement() {
        
        int quality = 0;
        String name = "Aged Brie";
        Item item   = this.getCustomUpdatedItem(name, 0, quality);
        
        assertTrue(item.quality > quality);
    }
    
    @Test
    @DisplayName("Immutable Sulfuras")
    public void testSulfuras() {
        
        int quality = 80;
        int sellIn 	= 0;
        String name = "Sulfuras, Hand of Ragnaros";
        Item item   = this.getCustomUpdatedItem(name, sellIn, quality);

        assertTrue(item.quality == quality);
        assertTrue(item.sellIn  == sellIn);
    }
    
    @ParameterizedTest(name = "Backstage passes quality increased by 1 when sellIn = {0} (test{index})")
    @ValueSource(ints = {11, 12, 13, 14, Integer.MAX_VALUE})
    public void testBackstageQ1(int sellIn) {
        
        int quality = 0;
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item item   = this.getCustomUpdatedItem(name, sellIn, quality);
        
        assertTrue(item.quality == quality+1);
    }
    
    @ParameterizedTest(name = "Backstage passes quality increased by 2 when sellIn = {0} (test{index})")
    @ValueSource(ints = {6, 7, 8, 9, 10})
    public void testBackstageQ2(int sellIn) {
        
        int quality = 0;
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item item   = this.getCustomUpdatedItem(name, sellIn, quality);
        
        assertTrue(item.quality == quality+2);
    }
    
    @ParameterizedTest(name = "Backstage passes quality increased by 3 when sellIn = {0} (test{index})")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testBackstageQ3(int sellIn) {
        
        int quality = 0;
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item item   = this.getCustomUpdatedItem(name, sellIn, quality);
        
        assertTrue(item.quality == quality+3);
    }
    
    @ParameterizedTest(name = "Backstage passes quality drop to 0 after the concert (sellIn = {0}) (test{index})")
    @ValueSource(ints = {-50, -25, -5, -1, 0})
    public void testBackstageAfterConcert(int sellIn) {
        
        int quality = 0;
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item item   = this.getCustomUpdatedItem(name, sellIn, quality);
        
        assertTrue(item.quality == 0);
    }  
    
    
    @Test
    @Disabled
    @DisplayName("Conjured items quality degrades 2 times faster than others")
    public void testConjured() {
        
        int quality = 2;
        String name = "Conjured Mana Cake";
        Item item   = this.getCustomUpdatedItem(name, 5, quality);

        assertTrue(item.quality == quality-2);
    }

}

package com.android.i18n.phonenumbers;

// Droidsafe Imports
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RegexCache {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.387 -0400", hash_original_field = "0FEA6A13C52B4D4725368F24B045CA84", hash_generated_field = "16D47F72D075CA4D463362B842829988")

    private LRUCache<String, Pattern> cache;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.388 -0400", hash_original_method = "21C87B9404006AB8BDC70A7D87D605C9", hash_generated_method = "BA72428A9A53B792FB4D16D0540B1699")
    public  RegexCache(int size) {
        cache = new LRUCache<String, Pattern>(size);
        // ---------- Original Method ----------
        //cache = new LRUCache<String, Pattern>(size);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.388 -0400", hash_original_method = "625FF0438C87362FF750355AAC8DD91B", hash_generated_method = "81F39FBCD31CCEB40FAD3A865A9D6BD6")
    public Pattern getPatternForRegex(String regex) {
        addTaint(regex.getTaint());
        Pattern pattern = cache.get(regex);
        if(pattern == null)        
        {
            pattern = Pattern.compile(regex);
            cache.put(regex, pattern);
        } //End block
Pattern var407D32260E541B695CF3FD3F7EFB76AB_484713998 =         pattern;
        var407D32260E541B695CF3FD3F7EFB76AB_484713998.addTaint(taint);
        return var407D32260E541B695CF3FD3F7EFB76AB_484713998;
        // ---------- Original Method ----------
        //Pattern pattern = cache.get(regex);
        //if (pattern == null) {
      //pattern = Pattern.compile(regex);
      //cache.put(regex, pattern);
    //}
        //return pattern;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.389 -0400", hash_original_method = "9456A95A80F85B5D1573A006C0CCB596", hash_generated_method = "4AE80820004F3C87D1C2A0580AB872F6")
     boolean containsRegex(String regex) {
        addTaint(regex.getTaint());
        boolean var270B0AAC269CF9448F1E6159F9C60FE7_2017189632 = (cache.containsKey(regex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_998658910 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_998658910;
        // ---------- Original Method ----------
        //return cache.containsKey(regex);
    }

    
    private static class LRUCache<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.389 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

        private LinkedHashMap<K, V> map;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.389 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

        private int size;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.390 -0400", hash_original_method = "2359AFA0A580D93087724107F1345FB2", hash_generated_method = "95D598BDFEA945861964D97AABD227ED")
        @SuppressWarnings("serial")
        public  LRUCache(int size) {
            this.size = size;
            map = new LinkedHashMap<K, V>(size * 4 / 3 + 1, 0.75f, true) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.390 -0400", hash_original_method = "EDE0FFFEE229BA4DD0CD2DD6457A597A", hash_generated_method = "C8E4155A5B34E7C09588BDEBBAFD1D38")
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                addTaint(eldest.getTaint());
                boolean var4536DB7FE41CFF7E06CD6ABACDCD12AC_236688362 = (size() > LRUCache.this.size);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_158584236 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_158584236;
                // ---------- Original Method ----------
                //return size() > LRUCache.this.size;
            }
};
            // ---------- Original Method ----------
            //this.size = size;
            //map = new LinkedHashMap<K, V>(size * 4 / 3 + 1, 0.75f, true) {
        //@Override
        //protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
          //return size() > LRUCache.this.size;
        //}
      //};
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.390 -0400", hash_original_method = "EEC311F1C8E6E4405BF9A97AEC3D11BF", hash_generated_method = "048A646390AA7D6CDC685125451988F0")
        public synchronized V get(K key) {
            addTaint(key.getTaint());
V var97156AACD411ADC83FECC30C065B5B0C_1976966703 =             map.get(key);
            var97156AACD411ADC83FECC30C065B5B0C_1976966703.addTaint(taint);
            return var97156AACD411ADC83FECC30C065B5B0C_1976966703;
            // ---------- Original Method ----------
            //return map.get(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.391 -0400", hash_original_method = "C4C725598B9694AF1F3D731C0033484D", hash_generated_method = "698C581D6ABEE6803D172CCEA428E1C5")
        public synchronized void put(K key, V value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
            map.put(key, value);
            // ---------- Original Method ----------
            //map.put(key, value);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.391 -0400", hash_original_method = "145C938C17F7FBD329FF51DDD81E595D", hash_generated_method = "0C791021CF636556D0859775DE066E8B")
        public synchronized boolean containsKey(K key) {
            addTaint(key.getTaint());
            boolean var1F5C7C829096E4FDB1A63A2E9D4DD6A2_2096256204 = (map.containsKey(key));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756826650 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_756826650;
            // ---------- Original Method ----------
            //return map.containsKey(key);
        }

        
    }


    
}


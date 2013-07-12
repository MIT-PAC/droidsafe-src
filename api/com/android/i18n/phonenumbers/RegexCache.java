package com.android.i18n.phonenumbers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegexCache {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.266 -0400", hash_original_field = "0FEA6A13C52B4D4725368F24B045CA84", hash_generated_field = "16D47F72D075CA4D463362B842829988")

    private LRUCache<String, Pattern> cache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.266 -0400", hash_original_method = "21C87B9404006AB8BDC70A7D87D605C9", hash_generated_method = "BA72428A9A53B792FB4D16D0540B1699")
    public  RegexCache(int size) {
        cache = new LRUCache<String, Pattern>(size);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.267 -0400", hash_original_method = "625FF0438C87362FF750355AAC8DD91B", hash_generated_method = "7802E79BA710B5FBB590985F42BB31A1")
    public Pattern getPatternForRegex(String regex) {
        addTaint(regex.getTaint());
        Pattern pattern = cache.get(regex);
    if(pattern == null)        
        {
            pattern = Pattern.compile(regex);
            cache.put(regex, pattern);
        } 
Pattern var407D32260E541B695CF3FD3F7EFB76AB_986472401 =         pattern;
        var407D32260E541B695CF3FD3F7EFB76AB_986472401.addTaint(taint);
        return var407D32260E541B695CF3FD3F7EFB76AB_986472401;
        
        
        
      
      
    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.267 -0400", hash_original_method = "9456A95A80F85B5D1573A006C0CCB596", hash_generated_method = "2D0BE40CD6821F85B7550726AE028D8E")
     boolean containsRegex(String regex) {
        addTaint(regex.getTaint());
        boolean var270B0AAC269CF9448F1E6159F9C60FE7_1190176006 = (cache.containsKey(regex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1007945219 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1007945219;
        
        
    }

    
    private static class LRUCache<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.267 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

        private LinkedHashMap<K, V> map;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.267 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

        private int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.268 -0400", hash_original_method = "2359AFA0A580D93087724107F1345FB2", hash_generated_method = "B4E5F1DEDAC08075FB9CDC0705AAA980")
        @SuppressWarnings("serial")
        public  LRUCache(int size) {
            this.size = size;
            map = new LinkedHashMap<K, V>(size * 4 / 3 + 1, 0.75f, true) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.268 -0400", hash_original_method = "EDE0FFFEE229BA4DD0CD2DD6457A597A", hash_generated_method = "74DAADBE3FF6EC3843DC8932BA7AE61B")
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                addTaint(eldest.getTaint());
                boolean var4536DB7FE41CFF7E06CD6ABACDCD12AC_1520044045 = (size() > LRUCache.this.size);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_80473660 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_80473660;
                
                
            }
};
            
            
            
        
        
          
        
      
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.269 -0400", hash_original_method = "EEC311F1C8E6E4405BF9A97AEC3D11BF", hash_generated_method = "520953992AC5A249510B32B3ED87792C")
        public synchronized V get(K key) {
            addTaint(key.getTaint());
V var97156AACD411ADC83FECC30C065B5B0C_1130226788 =             map.get(key);
            var97156AACD411ADC83FECC30C065B5B0C_1130226788.addTaint(taint);
            return var97156AACD411ADC83FECC30C065B5B0C_1130226788;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.269 -0400", hash_original_method = "C4C725598B9694AF1F3D731C0033484D", hash_generated_method = "698C581D6ABEE6803D172CCEA428E1C5")
        public synchronized void put(K key, V value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
            map.put(key, value);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.269 -0400", hash_original_method = "145C938C17F7FBD329FF51DDD81E595D", hash_generated_method = "57FAFE10CF84625445BB91462E040F46")
        public synchronized boolean containsKey(K key) {
            addTaint(key.getTaint());
            boolean var1F5C7C829096E4FDB1A63A2E9D4DD6A2_830982600 = (map.containsKey(key));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807041712 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_807041712;
            
            
        }

        
    }


    
}


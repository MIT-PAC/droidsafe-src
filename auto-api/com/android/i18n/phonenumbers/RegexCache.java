package com.android.i18n.phonenumbers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegexCache {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.589 -0400", hash_original_field = "0FEA6A13C52B4D4725368F24B045CA84", hash_generated_field = "16D47F72D075CA4D463362B842829988")

    private LRUCache<String, Pattern> cache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.589 -0400", hash_original_method = "21C87B9404006AB8BDC70A7D87D605C9", hash_generated_method = "BA72428A9A53B792FB4D16D0540B1699")
    public  RegexCache(int size) {
        cache = new LRUCache<String, Pattern>(size);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.590 -0400", hash_original_method = "625FF0438C87362FF750355AAC8DD91B", hash_generated_method = "F0C23FE92A8036255D9F3832666F4967")
    public Pattern getPatternForRegex(String regex) {
        Pattern varB4EAC82CA7396A68D541C85D26508E83_2021709327 = null; 
        Pattern pattern = cache.get(regex);
        {
            pattern = Pattern.compile(regex);
            cache.put(regex, pattern);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2021709327 = pattern;
        addTaint(regex.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2021709327.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2021709327;
        
        
        
      
      
    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.590 -0400", hash_original_method = "9456A95A80F85B5D1573A006C0CCB596", hash_generated_method = "12BB19B0BB1EB8BB947A54EB1F522993")
     boolean containsRegex(String regex) {
        boolean var4E1CD2CC7CA4363A5DB68216C19887CE_567348792 = (cache.containsKey(regex));
        addTaint(regex.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_384036882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_384036882;
        
        
    }

    
    private static class LRUCache<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.590 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

        private LinkedHashMap<K, V> map;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.590 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

        private int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.591 -0400", hash_original_method = "2359AFA0A580D93087724107F1345FB2", hash_generated_method = "9207C791B0CC7EF2B1AB5DFA82DEE6AC")
        @SuppressWarnings("serial")
        public  LRUCache(int size) {
            this.size = size;
            map = new LinkedHashMap<K, V>(size * 4 / 3 + 1, 0.75f, true) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.591 -0400", hash_original_method = "EDE0FFFEE229BA4DD0CD2DD6457A597A", hash_generated_method = "8624A1DEF0E76823FC5A03EA1FA48F18")
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    boolean var129042BDB7AF4F618BCA11D51C28FB8E_1842732780 = (size() > LRUCache.this.size);
                    addTaint(eldest.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662558881 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_662558881;
                    
                    
                }
};
            
            
            
        
        
          
        
      
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.594 -0400", hash_original_method = "EEC311F1C8E6E4405BF9A97AEC3D11BF", hash_generated_method = "2D78954A16CFAF5798BE325791984C83")
        public synchronized V get(K key) {
            V varB4EAC82CA7396A68D541C85D26508E83_1672311579 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1672311579 = map.get(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1672311579.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1672311579;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.594 -0400", hash_original_method = "C4C725598B9694AF1F3D731C0033484D", hash_generated_method = "6A121F230509D6B7823307835D9E4CA1")
        public synchronized void put(K key, V value) {
            map.put(key, value);
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.595 -0400", hash_original_method = "145C938C17F7FBD329FF51DDD81E595D", hash_generated_method = "BCFFC13A5FDA52C0FA116E4EE759EC5B")
        public synchronized boolean containsKey(K key) {
            boolean varC4E367E3FE7F5E2BFFF66DFA372B2F07_582899179 = (map.containsKey(key));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_64036841 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_64036841;
            
            
        }

        
    }


    
}


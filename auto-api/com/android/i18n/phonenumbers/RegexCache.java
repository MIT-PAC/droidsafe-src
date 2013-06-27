package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegexCache {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.059 -0400", hash_original_field = "0FEA6A13C52B4D4725368F24B045CA84", hash_generated_field = "16D47F72D075CA4D463362B842829988")

    private LRUCache<String, Pattern> cache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.060 -0400", hash_original_method = "21C87B9404006AB8BDC70A7D87D605C9", hash_generated_method = "BA72428A9A53B792FB4D16D0540B1699")
    public  RegexCache(int size) {
        cache = new LRUCache<String, Pattern>(size);
        // ---------- Original Method ----------
        //cache = new LRUCache<String, Pattern>(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.061 -0400", hash_original_method = "625FF0438C87362FF750355AAC8DD91B", hash_generated_method = "D5B0B922526FD9FCD0D1A3C567B32B20")
    public Pattern getPatternForRegex(String regex) {
        Pattern varB4EAC82CA7396A68D541C85D26508E83_2101006032 = null; //Variable for return #1
        Pattern pattern;
        pattern = cache.get(regex);
        {
            pattern = Pattern.compile(regex);
            cache.put(regex, pattern);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2101006032 = pattern;
        addTaint(regex.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2101006032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2101006032;
        // ---------- Original Method ----------
        //Pattern pattern = cache.get(regex);
        //if (pattern == null) {
      //pattern = Pattern.compile(regex);
      //cache.put(regex, pattern);
    //}
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.061 -0400", hash_original_method = "9456A95A80F85B5D1573A006C0CCB596", hash_generated_method = "C4350C4A7F0EAA7A3A9432C01FCB5FF7")
     boolean containsRegex(String regex) {
        boolean var4E1CD2CC7CA4363A5DB68216C19887CE_889295756 = (cache.containsKey(regex));
        addTaint(regex.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412648350 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412648350;
        // ---------- Original Method ----------
        //return cache.containsKey(regex);
    }

    
    private static class LRUCache<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.061 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

        private LinkedHashMap<K, V> map;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.061 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

        private int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.072 -0400", hash_original_method = "2359AFA0A580D93087724107F1345FB2", hash_generated_method = "CEBC70BA15DF415DF62B408D5D45532F")
        @SuppressWarnings("serial")
        public  LRUCache(int size) {
            this.size = size;
            map = new LinkedHashMap<K, V>(size * 4 / 3 + 1, 0.75f, true) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.072 -0400", hash_original_method = "EDE0FFFEE229BA4DD0CD2DD6457A597A", hash_generated_method = "9DBCC296569F9B8BB83D8F8F795E79F3")
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    boolean var129042BDB7AF4F618BCA11D51C28FB8E_733886581 = (size() > LRUCache.this.size);
                    addTaint(eldest.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951557418 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951557418;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.079 -0400", hash_original_method = "EEC311F1C8E6E4405BF9A97AEC3D11BF", hash_generated_method = "E2B4E03E629824BBE809F000830779E9")
        public synchronized V get(K key) {
            V varB4EAC82CA7396A68D541C85D26508E83_316943733 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_316943733 = map.get(key);
            addTaint(key.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_316943733.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_316943733;
            // ---------- Original Method ----------
            //return map.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.079 -0400", hash_original_method = "C4C725598B9694AF1F3D731C0033484D", hash_generated_method = "6A121F230509D6B7823307835D9E4CA1")
        public synchronized void put(K key, V value) {
            map.put(key, value);
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            // ---------- Original Method ----------
            //map.put(key, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.084 -0400", hash_original_method = "145C938C17F7FBD329FF51DDD81E595D", hash_generated_method = "94A9206371F7BE747560115BAFF15BA5")
        public synchronized boolean containsKey(K key) {
            boolean varC4E367E3FE7F5E2BFFF66DFA372B2F07_1652471166 = (map.containsKey(key));
            addTaint(key.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1339931406 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1339931406;
            // ---------- Original Method ----------
            //return map.containsKey(key);
        }

        
    }


    
}


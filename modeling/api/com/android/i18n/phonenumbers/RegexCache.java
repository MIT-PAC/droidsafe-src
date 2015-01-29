package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegexCache {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.405 -0500", hash_original_field = "197D42C39B9E9B55486DBF25B05CC429", hash_generated_field = "16D47F72D075CA4D463362B842829988")

  private LRUCache<String, Pattern> cache;

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.408 -0500", hash_original_method = "21C87B9404006AB8BDC70A7D87D605C9", hash_generated_method = "ADA9F5825FF2D2EDE589632A581E9992")
    
public RegexCache(int size) {
    cache = new LRUCache<String, Pattern>(size);
  }

  @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.410 -0500", hash_original_method = "625FF0438C87362FF750355AAC8DD91B", hash_generated_method = "28FD5363EB582F4464A14A70E6688480")
    
public Pattern getPatternForRegex(String regex) {
    Pattern pattern = cache.get(regex);
    if (pattern == null) {
      pattern = Pattern.compile(regex);
      cache.put(regex, pattern);
    }
    return pattern;
  }

  // This method is used for testing.
  @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.412 -0500", hash_original_method = "9456A95A80F85B5D1573A006C0CCB596", hash_generated_method = "9456A95A80F85B5D1573A006C0CCB596")
    
boolean containsRegex(String regex) {
    return cache.containsKey(regex);
  }
    
    private static class LRUCache<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.416 -0500", hash_original_field = "C1EA1E037942401E0AF0EDC51327A696", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private LinkedHashMap<K, V> map;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.418 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.425 -0500", hash_original_method = "2359AFA0A580D93087724107F1345FB2", hash_generated_method = "4CEC9D5ACC0919F8B5A8E3983B4546B4")
        
@SuppressWarnings("serial")
    public LRUCache(int size) {
      this.size = size;
      map = new LinkedHashMap<K, V>(size * 4 / 3 + 1, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
          return size() > LRUCache.this.size;
        }
      };
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.428 -0500", hash_original_method = "EEC311F1C8E6E4405BF9A97AEC3D11BF", hash_generated_method = "13505DC3C354D45318E31EF8B60DDE7F")
        
public synchronized V get(K key) {
      return map.get(key);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.430 -0500", hash_original_method = "C4C725598B9694AF1F3D731C0033484D", hash_generated_method = "4F3992ACC31257B93764691542D535C9")
        
public synchronized void put(K key, V value) {
      map.put(key, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:00.432 -0500", hash_original_method = "145C938C17F7FBD329FF51DDD81E595D", hash_generated_method = "B03CD2F925D027F5337012AE8664B238")
        
public synchronized boolean containsKey(K key) {
      return map.containsKey(key);
    }
        
    }
    
}


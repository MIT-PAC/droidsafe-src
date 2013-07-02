package android.support.v4.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.463 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private LinkedHashMap<K, V> map;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.463 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.463 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private int maxSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.463 -0400", hash_original_field = "B5E773FF0DAA7AF2D35B09A2ACE97C38", hash_generated_field = "19F4FFEE16EDFF5AE45C5FE9A1BFB8DE")

    private int putCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.463 -0400", hash_original_field = "1EFE30A68A1999763186AA8A0FF431E2", hash_generated_field = "E17BC39B90B7FC1868ABCF5E868DC1F0")

    private int createCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.463 -0400", hash_original_field = "3E1471C5E3C695ABC459C18E113BDF6F", hash_generated_field = "5818FEEB77D22B7930FC3E6082C766A2")

    private int evictionCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.463 -0400", hash_original_field = "5BBBCEBEEA805F9664B2979FBACE5699", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.463 -0400", hash_original_field = "698B6BDB01E0C702797DD865E1B3FBBB", hash_generated_field = "F9F39FB5A1CA690A1C15055CB8F2E309")

    private int missCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.464 -0400", hash_original_method = "4EF140C80EBAC1C26C5562E76AB6C34D", hash_generated_method = "342ED4F1A18B9C1FFF71B4D29E269529")
    public  LruCache(int maxSize) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("maxSize <= 0");
        } 
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.465 -0400", hash_original_method = "E5DC52D3C4EAEBC9C86A603CE5606C4A", hash_generated_method = "3A5E5638869F5B7E1ADB8D1D7F2D0D2B")
    public final V get(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1753611264 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_818574397 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_287584027 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_311641258 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key == null");
        } 
        V mapValue;
        {
            mapValue = map.get(key);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1753611264 = mapValue;
            } 
        } 
        V createdValue = create(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_818574397 = null;
        } 
        {
            mapValue = map.put(key, createdValue);
            {
                map.put(key, mapValue);
            } 
            {
                size += safeSizeOf(key, createdValue);
            } 
        } 
        {
            entryRemoved(false, key, createdValue, mapValue);
            varB4EAC82CA7396A68D541C85D26508E83_287584027 = mapValue;
        } 
        {
            trimToSize(maxSize);
            varB4EAC82CA7396A68D541C85D26508E83_311641258 = createdValue;
        } 
        V varA7E53CE21691AB073D9660D615818899_1809416467; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1809416467 = varB4EAC82CA7396A68D541C85D26508E83_1753611264;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1809416467 = varB4EAC82CA7396A68D541C85D26508E83_818574397;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1809416467 = varB4EAC82CA7396A68D541C85D26508E83_287584027;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1809416467 = varB4EAC82CA7396A68D541C85D26508E83_311641258;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1809416467.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1809416467;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.467 -0400", hash_original_method = "79B383546C2B260561E7B3FD1850F381", hash_generated_method = "5FD0712DDA055DF091A5295E37A47A50")
    public final V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_892249663 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key == null || value == null");
        } 
        V previous;
        {
            size += safeSizeOf(key, value);
            previous = map.put(key, value);
            {
                size -= safeSizeOf(key, previous);
            } 
        } 
        {
            entryRemoved(false, key, previous, value);
        } 
        trimToSize(maxSize);
        varB4EAC82CA7396A68D541C85D26508E83_892249663 = previous;
        varB4EAC82CA7396A68D541C85D26508E83_892249663.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_892249663;
        
        
            
        
        
        
            
            
            
            
                
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.468 -0400", hash_original_method = "82D005458BB4BC837252CC0C6863637E", hash_generated_method = "72496199EE76D986630BB22337072B69")
    public void trimToSize(int maxSize) {
        {
            K key;
            V value;
            {
                {
                    boolean var78F01EF42D3F5C8B47D2FC6491891300_1221709408 = (size < 0 || (map.isEmpty() && size != 0));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(getClass().getName()
                            + ".sizeOf() is reporting inconsistent results!");
                    } 
                } 
                {
                    boolean varBAACAD442F890937440A52CBAEB6BBA9_1835438258 = (size <= maxSize || map.isEmpty());
                } 
                Map.Entry<K, V> toEvict = map.entrySet().iterator().next();
                key = toEvict.getKey();
                value = toEvict.getValue();
                map.remove(key);
                size -= safeSizeOf(key, value);
            } 
            entryRemoved(true, key, value, null);
        } 
        addTaint(maxSize);
        
        
            
            
            
                
                    
                            
                
                
                    
                
                
                
                
                
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.469 -0400", hash_original_method = "5ECD46803ACE6D1B641401078C3B9D9C", hash_generated_method = "4D76BFCCDDD9F2E89E9AFCFE448ACF8E")
    public final V remove(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_602944649 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key == null");
        } 
        V previous;
        {
            previous = map.remove(key);
            {
                size -= safeSizeOf(key, previous);
            } 
        } 
        {
            entryRemoved(false, key, previous, null);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_602944649 = previous;
        varB4EAC82CA7396A68D541C85D26508E83_602944649.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_602944649;
        
        
            
        
        
        
            
            
                
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.470 -0400", hash_original_method = "9AD1617B914C1EE986412183164D996B", hash_generated_method = "B3A7091C6ADAD1391374D154CCDCC5BA")
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        addTaint(evicted);
        addTaint(key.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(newValue.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.470 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "E053F4109FEA20A519E958F7F44A3ADD")
    protected V create(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1883241633 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1883241633 = null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1883241633.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1883241633;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.471 -0400", hash_original_method = "971860883D94FE365FE71BDE260829D3", hash_generated_method = "8DEC69CC234F6FDAFBE71041240694F8")
    private int safeSizeOf(K key, V value) {
        int result = sizeOf(key, value);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Negative size: " + key + "=" + value);
        } 
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585204730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585204730;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.471 -0400", hash_original_method = "6F73EAFB28729CDC0BB32AECE7CD1246", hash_generated_method = "D9040983D501189F2457E16E1EDDB489")
    protected int sizeOf(K key, V value) {
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768811253 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768811253;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.471 -0400", hash_original_method = "D3EB145ED9D558FDF887F10175D8EBDF", hash_generated_method = "6852E1E415BA1B80059D4CFD58DC38F6")
    public final void evictAll() {
        trimToSize(-1);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.472 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "9BB6815BBE4F02FBC6F14DADAFD47479")
    public synchronized final int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31611;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.472 -0400", hash_original_method = "3468DBA84D0C4B093D85888533351ACC", hash_generated_method = "F8D0C7477284F650FB94E49A9C200330")
    public synchronized final int maxSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408791333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408791333;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.472 -0400", hash_original_method = "58C54B9E60920B23E133E0E61BF2A4F4", hash_generated_method = "604C37F77CC8AF640DB68497ED7FF772")
    public synchronized final int hitCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288745898 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288745898;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.473 -0400", hash_original_method = "CD33CA8BAAD7A20717BABBDF22DCC17E", hash_generated_method = "41681A0CE04C2F5FFAB3FABE0683CDFA")
    public synchronized final int missCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1443810771 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1443810771;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.473 -0400", hash_original_method = "03691337F25E7C4DFAAA3B9F69FCDA1E", hash_generated_method = "0D63C9FA0BAFF4C7124AC175F9D67E26")
    public synchronized final int createCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756947785 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756947785;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.473 -0400", hash_original_method = "291437E08BF34B71B9E36D69031C2701", hash_generated_method = "7FF4ECDFFD3BFC3C3CF930B3D686833C")
    public synchronized final int putCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_804875931 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_804875931;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.473 -0400", hash_original_method = "21AA3C6AE5648A36F9E47AF2806112A8", hash_generated_method = "3EAAFAE41C31960C881CA5984483A514")
    public synchronized final int evictionCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_176749113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_176749113;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.474 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "FF2AC02D332A773180EDEE580B82EE18")
    public synchronized final Map<K, V> snapshot() {
        Map<K, V> varB4EAC82CA7396A68D541C85D26508E83_1873383034 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1873383034 = new LinkedHashMap<K, V>(map);
        varB4EAC82CA7396A68D541C85D26508E83_1873383034.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1873383034;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.475 -0400", hash_original_method = "D511C7B644032E2A9485769132851C89", hash_generated_method = "CA8CD4980FF15FB54768FA587665E63F")
    @Override
    public synchronized final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2106083789 = null; 
        int accesses = hitCount + missCount;
        int hitPercent;
        hitPercent = (100 * hitCount / accesses);
        hitPercent = 0;
        varB4EAC82CA7396A68D541C85D26508E83_2106083789 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent);
        varB4EAC82CA7396A68D541C85D26508E83_2106083789.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2106083789;
        
        
        
        
                
    }

    
}


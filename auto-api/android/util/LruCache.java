package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.412 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private LinkedHashMap<K, V> map;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.412 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.412 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private int maxSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.412 -0400", hash_original_field = "B5E773FF0DAA7AF2D35B09A2ACE97C38", hash_generated_field = "19F4FFEE16EDFF5AE45C5FE9A1BFB8DE")

    private int putCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.412 -0400", hash_original_field = "1EFE30A68A1999763186AA8A0FF431E2", hash_generated_field = "E17BC39B90B7FC1868ABCF5E868DC1F0")

    private int createCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.412 -0400", hash_original_field = "3E1471C5E3C695ABC459C18E113BDF6F", hash_generated_field = "5818FEEB77D22B7930FC3E6082C766A2")

    private int evictionCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.412 -0400", hash_original_field = "5BBBCEBEEA805F9664B2979FBACE5699", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.412 -0400", hash_original_field = "698B6BDB01E0C702797DD865E1B3FBBB", hash_generated_field = "F9F39FB5A1CA690A1C15055CB8F2E309")

    private int missCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.412 -0400", hash_original_method = "4EF140C80EBAC1C26C5562E76AB6C34D", hash_generated_method = "342ED4F1A18B9C1FFF71B4D29E269529")
    public  LruCache(int maxSize) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("maxSize <= 0");
        } 
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.414 -0400", hash_original_method = "E5DC52D3C4EAEBC9C86A603CE5606C4A", hash_generated_method = "A9F12EB5CC77510DD0C690BD9D8ECAA7")
    public final V get(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_151281798 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_1789590719 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_84310554 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_1032342214 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key == null");
        } 
        V mapValue;
        {
            mapValue = map.get(key);
            {
                varB4EAC82CA7396A68D541C85D26508E83_151281798 = mapValue;
            } 
        } 
        V createdValue = create(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1789590719 = null;
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
            varB4EAC82CA7396A68D541C85D26508E83_84310554 = mapValue;
        } 
        {
            trimToSize(maxSize);
            varB4EAC82CA7396A68D541C85D26508E83_1032342214 = createdValue;
        } 
        V varA7E53CE21691AB073D9660D615818899_1069970679; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1069970679 = varB4EAC82CA7396A68D541C85D26508E83_151281798;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1069970679 = varB4EAC82CA7396A68D541C85D26508E83_1789590719;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1069970679 = varB4EAC82CA7396A68D541C85D26508E83_84310554;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1069970679 = varB4EAC82CA7396A68D541C85D26508E83_1032342214;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1069970679.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1069970679;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.416 -0400", hash_original_method = "79B383546C2B260561E7B3FD1850F381", hash_generated_method = "EF0CE7C15D90E9BAA1E488A032262DE6")
    public final V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_50110971 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_50110971 = previous;
        varB4EAC82CA7396A68D541C85D26508E83_50110971.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_50110971;
        
        
            
        
        
        
            
            
            
            
                
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.417 -0400", hash_original_method = "5A85F1994DB09F90DA92A4710FB4C22D", hash_generated_method = "972C39874A0ECB46A3E20C6439B43900")
    private void trimToSize(int maxSize) {
        {
            K key;
            V value;
            {
                {
                    boolean var78F01EF42D3F5C8B47D2FC6491891300_356146329 = (size < 0 || (map.isEmpty() && size != 0));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(getClass().getName()
                            + ".sizeOf() is reporting inconsistent results!");
                    } 
                } 
                Map.Entry<K, V> toEvict = map.eldest();
                key = toEvict.getKey();
                value = toEvict.getValue();
                map.remove(key);
                size -= safeSizeOf(key, value);
            } 
            entryRemoved(true, key, value, null);
        } 
        addTaint(maxSize);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.418 -0400", hash_original_method = "5ECD46803ACE6D1B641401078C3B9D9C", hash_generated_method = "ED40E2A4204DE391A454E6F85C1E9AD3")
    public final V remove(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_643623699 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_643623699 = previous;
        varB4EAC82CA7396A68D541C85D26508E83_643623699.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_643623699;
        
        
            
        
        
        
            
            
                
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.418 -0400", hash_original_method = "9AD1617B914C1EE986412183164D996B", hash_generated_method = "B3A7091C6ADAD1391374D154CCDCC5BA")
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        addTaint(evicted);
        addTaint(key.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(newValue.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.420 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "24E606D48BBC80247AAFD260BA35DE5C")
    protected V create(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_762464435 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_762464435 = null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_762464435.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_762464435;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.420 -0400", hash_original_method = "971860883D94FE365FE71BDE260829D3", hash_generated_method = "A43EE0462B727EAA50E949E5C7DDC731")
    private int safeSizeOf(K key, V value) {
        int result = sizeOf(key, value);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Negative size: " + key + "=" + value);
        } 
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654852341 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654852341;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.421 -0400", hash_original_method = "6F73EAFB28729CDC0BB32AECE7CD1246", hash_generated_method = "26C4F71061634A1BE1C556DD83974DB2")
    protected int sizeOf(K key, V value) {
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2417667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2417667;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.421 -0400", hash_original_method = "D3EB145ED9D558FDF887F10175D8EBDF", hash_generated_method = "6852E1E415BA1B80059D4CFD58DC38F6")
    public final void evictAll() {
        trimToSize(-1);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.422 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "FB0707A21598300017A4E4938B768772")
    public synchronized final int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233929075 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233929075;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.422 -0400", hash_original_method = "3468DBA84D0C4B093D85888533351ACC", hash_generated_method = "A54DB83A8D993B3869C2A2AB3EA692E7")
    public synchronized final int maxSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_393755263 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_393755263;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.422 -0400", hash_original_method = "58C54B9E60920B23E133E0E61BF2A4F4", hash_generated_method = "FC62B76A13C5451D12569375CB7CCE0A")
    public synchronized final int hitCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923767327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923767327;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.423 -0400", hash_original_method = "CD33CA8BAAD7A20717BABBDF22DCC17E", hash_generated_method = "154DC852BB9F0D6ECB126F97A49F86A8")
    public synchronized final int missCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2114383999 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2114383999;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.423 -0400", hash_original_method = "03691337F25E7C4DFAAA3B9F69FCDA1E", hash_generated_method = "66F78602B0E2CA4EC52F6124716AAB5F")
    public synchronized final int createCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819704120 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819704120;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.424 -0400", hash_original_method = "291437E08BF34B71B9E36D69031C2701", hash_generated_method = "9BF4639969F1A87920D41DD901FC4181")
    public synchronized final int putCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966006154 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966006154;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.424 -0400", hash_original_method = "21AA3C6AE5648A36F9E47AF2806112A8", hash_generated_method = "081E986AB8ABDA3C8BA12A04F0E1F13D")
    public synchronized final int evictionCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267853067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267853067;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.426 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "B9E1573AB54AB2A4AC8A3B2546F572F7")
    public synchronized final Map<K, V> snapshot() {
        Map<K, V> varB4EAC82CA7396A68D541C85D26508E83_2096436125 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2096436125 = new LinkedHashMap<K, V>(map);
        varB4EAC82CA7396A68D541C85D26508E83_2096436125.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2096436125;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.428 -0400", hash_original_method = "D511C7B644032E2A9485769132851C89", hash_generated_method = "D1AAF7BB36D9791D294BE574A07F2515")
    @Override
    public synchronized final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_523543746 = null; 
        int accesses = hitCount + missCount;
        int hitPercent;
        hitPercent = (100 * hitCount / accesses);
        hitPercent = 0;
        varB4EAC82CA7396A68D541C85D26508E83_523543746 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent);
        varB4EAC82CA7396A68D541C85D26508E83_523543746.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_523543746;
        
        
        
        
                
    }

    
}


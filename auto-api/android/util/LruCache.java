package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.004 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private LinkedHashMap<K, V> map;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.004 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.004 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private int maxSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.004 -0400", hash_original_field = "B5E773FF0DAA7AF2D35B09A2ACE97C38", hash_generated_field = "19F4FFEE16EDFF5AE45C5FE9A1BFB8DE")

    private int putCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.004 -0400", hash_original_field = "1EFE30A68A1999763186AA8A0FF431E2", hash_generated_field = "E17BC39B90B7FC1868ABCF5E868DC1F0")

    private int createCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.004 -0400", hash_original_field = "3E1471C5E3C695ABC459C18E113BDF6F", hash_generated_field = "5818FEEB77D22B7930FC3E6082C766A2")

    private int evictionCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.004 -0400", hash_original_field = "5BBBCEBEEA805F9664B2979FBACE5699", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.004 -0400", hash_original_field = "698B6BDB01E0C702797DD865E1B3FBBB", hash_generated_field = "F9F39FB5A1CA690A1C15055CB8F2E309")

    private int missCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.017 -0400", hash_original_method = "4EF140C80EBAC1C26C5562E76AB6C34D", hash_generated_method = "342ED4F1A18B9C1FFF71B4D29E269529")
    public  LruCache(int maxSize) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("maxSize <= 0");
        } //End block
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
        // ---------- Original Method ----------
        //if (maxSize <= 0) {
            //throw new IllegalArgumentException("maxSize <= 0");
        //}
        //this.maxSize = maxSize;
        //this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.022 -0400", hash_original_method = "E5DC52D3C4EAEBC9C86A603CE5606C4A", hash_generated_method = "524170A54595EC689AD722B62B568210")
    public final V get(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1000265731 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1685720723 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_1124499070 = null; //Variable for return #3
        V varB4EAC82CA7396A68D541C85D26508E83_1342087429 = null; //Variable for return #4
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key == null");
        } //End block
        V mapValue;
        {
            mapValue = map.get(key);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1000265731 = mapValue;
            } //End block
        } //End block
        V createdValue;
        createdValue = create(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1685720723 = null;
        } //End block
        {
            mapValue = map.put(key, createdValue);
            {
                map.put(key, mapValue);
            } //End block
            {
                size += safeSizeOf(key, createdValue);
            } //End block
        } //End block
        {
            entryRemoved(false, key, createdValue, mapValue);
            varB4EAC82CA7396A68D541C85D26508E83_1124499070 = mapValue;
        } //End block
        {
            trimToSize(maxSize);
            varB4EAC82CA7396A68D541C85D26508E83_1342087429 = createdValue;
        } //End block
        V varA7E53CE21691AB073D9660D615818899_2137828055; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2137828055 = varB4EAC82CA7396A68D541C85D26508E83_1000265731;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2137828055 = varB4EAC82CA7396A68D541C85D26508E83_1685720723;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2137828055 = varB4EAC82CA7396A68D541C85D26508E83_1124499070;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2137828055 = varB4EAC82CA7396A68D541C85D26508E83_1342087429;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2137828055.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2137828055;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.026 -0400", hash_original_method = "79B383546C2B260561E7B3FD1850F381", hash_generated_method = "89168BD1F45CE9A395CD4A59D26366F4")
    public final V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_2005670193 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key == null || value == null");
        } //End block
        V previous;
        {
            size += safeSizeOf(key, value);
            previous = map.put(key, value);
            {
                size -= safeSizeOf(key, previous);
            } //End block
        } //End block
        {
            entryRemoved(false, key, previous, value);
        } //End block
        trimToSize(maxSize);
        varB4EAC82CA7396A68D541C85D26508E83_2005670193 = previous;
        varB4EAC82CA7396A68D541C85D26508E83_2005670193.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2005670193;
        // ---------- Original Method ----------
        //if (key == null || value == null) {
            //throw new NullPointerException("key == null || value == null");
        //}
        //V previous;
        //synchronized (this) {
            //putCount++;
            //size += safeSizeOf(key, value);
            //previous = map.put(key, value);
            //if (previous != null) {
                //size -= safeSizeOf(key, previous);
            //}
        //}
        //if (previous != null) {
            //entryRemoved(false, key, previous, value);
        //}
        //trimToSize(maxSize);
        //return previous;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.036 -0400", hash_original_method = "5A85F1994DB09F90DA92A4710FB4C22D", hash_generated_method = "E3B729265E9F150A283AB600A6B2C822")
    private void trimToSize(int maxSize) {
        {
            K key;
            V value;
            {
                {
                    boolean var78F01EF42D3F5C8B47D2FC6491891300_158553400 = (size < 0 || (map.isEmpty() && size != 0));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(getClass().getName()
                            + ".sizeOf() is reporting inconsistent results!");
                    } //End block
                } //End collapsed parenthetic
                Map.Entry<K, V> toEvict;
                toEvict = map.eldest();
                key = toEvict.getKey();
                value = toEvict.getValue();
                map.remove(key);
                size -= safeSizeOf(key, value);
            } //End block
            entryRemoved(true, key, value, null);
        } //End block
        addTaint(maxSize);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.051 -0400", hash_original_method = "5ECD46803ACE6D1B641401078C3B9D9C", hash_generated_method = "3CFC28D2DFFED4F30412B16EB2874F8F")
    public final V remove(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1247778699 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key == null");
        } //End block
        V previous;
        {
            previous = map.remove(key);
            {
                size -= safeSizeOf(key, previous);
            } //End block
        } //End block
        {
            entryRemoved(false, key, previous, null);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1247778699 = previous;
        varB4EAC82CA7396A68D541C85D26508E83_1247778699.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1247778699;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException("key == null");
        //}
        //V previous;
        //synchronized (this) {
            //previous = map.remove(key);
            //if (previous != null) {
                //size -= safeSizeOf(key, previous);
            //}
        //}
        //if (previous != null) {
            //entryRemoved(false, key, previous, null);
        //}
        //return previous;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.057 -0400", hash_original_method = "9AD1617B914C1EE986412183164D996B", hash_generated_method = "B3A7091C6ADAD1391374D154CCDCC5BA")
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        addTaint(evicted);
        addTaint(key.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.060 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "ABC1BF9B121AD4664EF05AC309918382")
    protected V create(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1865197148 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1865197148 = null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1865197148.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1865197148;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.064 -0400", hash_original_method = "971860883D94FE365FE71BDE260829D3", hash_generated_method = "A7EFA8B022F3E56FB217F9B2FCE918E2")
    private int safeSizeOf(K key, V value) {
        int result;
        result = sizeOf(key, value);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Negative size: " + key + "=" + value);
        } //End block
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720014309 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720014309;
        // ---------- Original Method ----------
        //int result = sizeOf(key, value);
        //if (result < 0) {
            //throw new IllegalStateException("Negative size: " + key + "=" + value);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.064 -0400", hash_original_method = "6F73EAFB28729CDC0BB32AECE7CD1246", hash_generated_method = "8DB38B08B679687E0715F301C80A4301")
    protected int sizeOf(K key, V value) {
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618448817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618448817;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.080 -0400", hash_original_method = "D3EB145ED9D558FDF887F10175D8EBDF", hash_generated_method = "6852E1E415BA1B80059D4CFD58DC38F6")
    public final void evictAll() {
        trimToSize(-1);
        // ---------- Original Method ----------
        //trimToSize(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.081 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "A6B36A51858936EE9708CF4DDEEF4A9D")
    public synchronized final int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1768193402 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1768193402;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.082 -0400", hash_original_method = "3468DBA84D0C4B093D85888533351ACC", hash_generated_method = "B17EEA6D25C7B1485E78774800FAFEB6")
    public synchronized final int maxSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1136117708 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1136117708;
        // ---------- Original Method ----------
        //return maxSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.082 -0400", hash_original_method = "58C54B9E60920B23E133E0E61BF2A4F4", hash_generated_method = "FD651881D635524A627E73DA4344EC34")
    public synchronized final int hitCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049358556 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049358556;
        // ---------- Original Method ----------
        //return hitCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.087 -0400", hash_original_method = "CD33CA8BAAD7A20717BABBDF22DCC17E", hash_generated_method = "AEAED4700D8557B2FC8D261E736A481D")
    public synchronized final int missCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565772075 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565772075;
        // ---------- Original Method ----------
        //return missCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.090 -0400", hash_original_method = "03691337F25E7C4DFAAA3B9F69FCDA1E", hash_generated_method = "EDD40F98A08FBC40EC6DDBB5CDA6735D")
    public synchronized final int createCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261645196 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261645196;
        // ---------- Original Method ----------
        //return createCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.103 -0400", hash_original_method = "291437E08BF34B71B9E36D69031C2701", hash_generated_method = "ACA35F6F61694BF206DA52A64413877E")
    public synchronized final int putCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979243733 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979243733;
        // ---------- Original Method ----------
        //return putCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.112 -0400", hash_original_method = "21AA3C6AE5648A36F9E47AF2806112A8", hash_generated_method = "24B0D3FFD57616E39376F937DCCE337D")
    public synchronized final int evictionCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1296257186 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1296257186;
        // ---------- Original Method ----------
        //return evictionCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.113 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "83D786DC7C0DFF395C6A824ADD68E358")
    public synchronized final Map<K, V> snapshot() {
        Map<K, V> varB4EAC82CA7396A68D541C85D26508E83_1068571998 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1068571998 = new LinkedHashMap<K, V>(map);
        varB4EAC82CA7396A68D541C85D26508E83_1068571998.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1068571998;
        // ---------- Original Method ----------
        //return new LinkedHashMap<K, V>(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.113 -0400", hash_original_method = "D511C7B644032E2A9485769132851C89", hash_generated_method = "FF84D68A944278B3A99EB92534556E20")
    @Override
    public synchronized final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_832262286 = null; //Variable for return #1
        int accesses;
        accesses = hitCount + missCount;
        int hitPercent;
        hitPercent = (100 * hitCount / accesses);
        hitPercent = 0;
        varB4EAC82CA7396A68D541C85D26508E83_832262286 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent);
        varB4EAC82CA7396A68D541C85D26508E83_832262286.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_832262286;
        // ---------- Original Method ----------
        //int accesses = hitCount + missCount;
        //int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
        //return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                //maxSize, hitCount, missCount, hitPercent);
    }

    
}


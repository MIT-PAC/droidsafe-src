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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.802 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private LinkedHashMap<K, V> map;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.803 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.803 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private int maxSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.803 -0400", hash_original_field = "B5E773FF0DAA7AF2D35B09A2ACE97C38", hash_generated_field = "19F4FFEE16EDFF5AE45C5FE9A1BFB8DE")

    private int putCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.803 -0400", hash_original_field = "1EFE30A68A1999763186AA8A0FF431E2", hash_generated_field = "E17BC39B90B7FC1868ABCF5E868DC1F0")

    private int createCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.803 -0400", hash_original_field = "3E1471C5E3C695ABC459C18E113BDF6F", hash_generated_field = "5818FEEB77D22B7930FC3E6082C766A2")

    private int evictionCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.803 -0400", hash_original_field = "5BBBCEBEEA805F9664B2979FBACE5699", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.803 -0400", hash_original_field = "698B6BDB01E0C702797DD865E1B3FBBB", hash_generated_field = "F9F39FB5A1CA690A1C15055CB8F2E309")

    private int missCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.804 -0400", hash_original_method = "4EF140C80EBAC1C26C5562E76AB6C34D", hash_generated_method = "342ED4F1A18B9C1FFF71B4D29E269529")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.808 -0400", hash_original_method = "E5DC52D3C4EAEBC9C86A603CE5606C4A", hash_generated_method = "3AFBBB886E3263D1B877E3FA927E80C7")
    public final V get(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_212741945 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_633191718 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_1068565734 = null; //Variable for return #3
        V varB4EAC82CA7396A68D541C85D26508E83_1912008922 = null; //Variable for return #4
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key == null");
        } //End block
        V mapValue;
        {
            mapValue = map.get(key);
            {
                varB4EAC82CA7396A68D541C85D26508E83_212741945 = mapValue;
            } //End block
        } //End block
        V createdValue;
        createdValue = create(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_633191718 = null;
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
            varB4EAC82CA7396A68D541C85D26508E83_1068565734 = mapValue;
        } //End block
        {
            trimToSize(maxSize);
            varB4EAC82CA7396A68D541C85D26508E83_1912008922 = createdValue;
        } //End block
        V varA7E53CE21691AB073D9660D615818899_805611176; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_805611176 = varB4EAC82CA7396A68D541C85D26508E83_212741945;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_805611176 = varB4EAC82CA7396A68D541C85D26508E83_633191718;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_805611176 = varB4EAC82CA7396A68D541C85D26508E83_1068565734;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_805611176 = varB4EAC82CA7396A68D541C85D26508E83_1912008922;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_805611176.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_805611176;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.810 -0400", hash_original_method = "79B383546C2B260561E7B3FD1850F381", hash_generated_method = "FD2E1E8083D2C67DFBAE43F0A2F60475")
    public final V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_649092101 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_649092101 = previous;
        varB4EAC82CA7396A68D541C85D26508E83_649092101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_649092101;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.830 -0400", hash_original_method = "5A85F1994DB09F90DA92A4710FB4C22D", hash_generated_method = "C9642E2703FE1E6DE756D3FDFBBA5B60")
    private void trimToSize(int maxSize) {
        {
            K key;
            V value;
            {
                {
                    boolean var78F01EF42D3F5C8B47D2FC6491891300_228421951 = (size < 0 || (map.isEmpty() && size != 0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.832 -0400", hash_original_method = "5ECD46803ACE6D1B641401078C3B9D9C", hash_generated_method = "0D36C9BF7F690C0327A07D941CA3403D")
    public final V remove(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1217515650 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1217515650 = previous;
        varB4EAC82CA7396A68D541C85D26508E83_1217515650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1217515650;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.832 -0400", hash_original_method = "9AD1617B914C1EE986412183164D996B", hash_generated_method = "B3A7091C6ADAD1391374D154CCDCC5BA")
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        addTaint(evicted);
        addTaint(key.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.833 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "57BCF15B404BC781F3EA474CC6F35D8E")
    protected V create(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_685135014 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_685135014 = null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_685135014.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_685135014;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.847 -0400", hash_original_method = "971860883D94FE365FE71BDE260829D3", hash_generated_method = "F2904161CEFC07C119C926F0D43A0638")
    private int safeSizeOf(K key, V value) {
        int result;
        result = sizeOf(key, value);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Negative size: " + key + "=" + value);
        } //End block
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399546522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399546522;
        // ---------- Original Method ----------
        //int result = sizeOf(key, value);
        //if (result < 0) {
            //throw new IllegalStateException("Negative size: " + key + "=" + value);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.848 -0400", hash_original_method = "6F73EAFB28729CDC0BB32AECE7CD1246", hash_generated_method = "BCAA98887B12F9635A5E9BC119FDCAFD")
    protected int sizeOf(K key, V value) {
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280239682 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280239682;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.848 -0400", hash_original_method = "D3EB145ED9D558FDF887F10175D8EBDF", hash_generated_method = "6852E1E415BA1B80059D4CFD58DC38F6")
    public final void evictAll() {
        trimToSize(-1);
        // ---------- Original Method ----------
        //trimToSize(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.849 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "9E4C83559209137B4B5CC9A98C550676")
    public synchronized final int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170062264 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170062264;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.849 -0400", hash_original_method = "3468DBA84D0C4B093D85888533351ACC", hash_generated_method = "32786937118272AA9C76958F752B18B4")
    public synchronized final int maxSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939680016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939680016;
        // ---------- Original Method ----------
        //return maxSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.849 -0400", hash_original_method = "58C54B9E60920B23E133E0E61BF2A4F4", hash_generated_method = "528FB2774F383CEB016EA93942B50C21")
    public synchronized final int hitCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686663656 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686663656;
        // ---------- Original Method ----------
        //return hitCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.859 -0400", hash_original_method = "CD33CA8BAAD7A20717BABBDF22DCC17E", hash_generated_method = "AD84621A989A85EC293919FAC9C4EFA3")
    public synchronized final int missCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390662083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390662083;
        // ---------- Original Method ----------
        //return missCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.860 -0400", hash_original_method = "03691337F25E7C4DFAAA3B9F69FCDA1E", hash_generated_method = "A65824EE93C36BCC1C424741D3841A7B")
    public synchronized final int createCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_61355475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_61355475;
        // ---------- Original Method ----------
        //return createCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.860 -0400", hash_original_method = "291437E08BF34B71B9E36D69031C2701", hash_generated_method = "9A4454323470B6C8B9610EBC68298696")
    public synchronized final int putCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763898467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763898467;
        // ---------- Original Method ----------
        //return putCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.861 -0400", hash_original_method = "21AA3C6AE5648A36F9E47AF2806112A8", hash_generated_method = "8077317C58978EA3BC71FEBE69564076")
    public synchronized final int evictionCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_236812268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_236812268;
        // ---------- Original Method ----------
        //return evictionCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.861 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "11FE621A15A995266CCCB960196AD3FB")
    public synchronized final Map<K, V> snapshot() {
        Map<K, V> varB4EAC82CA7396A68D541C85D26508E83_1840432334 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1840432334 = new LinkedHashMap<K, V>(map);
        varB4EAC82CA7396A68D541C85D26508E83_1840432334.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1840432334;
        // ---------- Original Method ----------
        //return new LinkedHashMap<K, V>(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.870 -0400", hash_original_method = "D511C7B644032E2A9485769132851C89", hash_generated_method = "3792156049D20C89E2DEC8A73DF22EB8")
    @Override
    public synchronized final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_134922484 = null; //Variable for return #1
        int accesses;
        accesses = hitCount + missCount;
        int hitPercent;
        hitPercent = (100 * hitCount / accesses);
        hitPercent = 0;
        varB4EAC82CA7396A68D541C85D26508E83_134922484 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent);
        varB4EAC82CA7396A68D541C85D26508E83_134922484.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_134922484;
        // ---------- Original Method ----------
        //int accesses = hitCount + missCount;
        //int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
        //return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                //maxSize, hitCount, missCount, hitPercent);
    }

    
}


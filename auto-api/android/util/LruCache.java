package android.util;

// Droidsafe Imports
import java.util.LinkedHashMap;
import java.util.Map;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class LruCache<K, V> {
    private final LinkedHashMap<K, V> map;
    private int size;
    private int maxSize;
    private int putCount;
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private int missCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.630 -0400", hash_original_method = "4EF140C80EBAC1C26C5562E76AB6C34D", hash_generated_method = "6CE5527D8A5A2ED1B6104557EB9C23FA")
    @DSModeled(DSC.SAFE)
    public LruCache(int maxSize) {
        dsTaint.addTaint(maxSize);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("maxSize <= 0");
        } //End block
        this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
        // ---------- Original Method ----------
        //if (maxSize <= 0) {
            //throw new IllegalArgumentException("maxSize <= 0");
        //}
        //this.maxSize = maxSize;
        //this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.631 -0400", hash_original_method = "E5DC52D3C4EAEBC9C86A603CE5606C4A", hash_generated_method = "7C0D0D490E0C7D919FA7F54DE4B38EF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final V get(K key) {
        dsTaint.addTaint(key.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key == null");
        } //End block
        V mapValue;
        {
            mapValue = map.get(key);
            {
                hitCount++;
            } //End block
            missCount++;
        } //End block
        V createdValue;
        createdValue = create(key);
        {
            createCount++;
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
        } //End block
        {
            trimToSize(maxSize);
        } //End block
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.631 -0400", hash_original_method = "79B383546C2B260561E7B3FD1850F381", hash_generated_method = "E9FFB53F1BB118CE58703DC0322F3D91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key == null || value == null");
        } //End block
        V previous;
        {
            putCount++;
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
        return (V)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.631 -0400", hash_original_method = "5A85F1994DB09F90DA92A4710FB4C22D", hash_generated_method = "C637608F3A69A9B20172714BF16CB713")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void trimToSize(int maxSize) {
        dsTaint.addTaint(maxSize);
        {
            K key;
            V value;
            {
                {
                    boolean var78F01EF42D3F5C8B47D2FC6491891300_1608405922 = (size < 0 || (map.isEmpty() && size != 0));
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
                evictionCount++;
            } //End block
            entryRemoved(true, key, value, null);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.631 -0400", hash_original_method = "5ECD46803ACE6D1B641401078C3B9D9C", hash_generated_method = "0C1D9AC1CEA466129FE13B6BFC213D43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final V remove(K key) {
        dsTaint.addTaint(key.dsTaint);
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
        return (V)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.631 -0400", hash_original_method = "9AD1617B914C1EE986412183164D996B", hash_generated_method = "4C7A41EA7AD4F973DA002AE56251F126")
    @DSModeled(DSC.SAFE)
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(oldValue.dsTaint);
        dsTaint.addTaint(evicted);
        dsTaint.addTaint(key.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.631 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "0751A6F70F8811814554A78EC2932D23")
    @DSModeled(DSC.SAFE)
    protected V create(K key) {
        dsTaint.addTaint(key.dsTaint);
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.631 -0400", hash_original_method = "971860883D94FE365FE71BDE260829D3", hash_generated_method = "082E7449B2AFF77059DF66F1D7B95C3A")
    @DSModeled(DSC.SAFE)
    private int safeSizeOf(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        int result;
        result = sizeOf(key, value);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Negative size: " + key + "=" + value);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = sizeOf(key, value);
        //if (result < 0) {
            //throw new IllegalStateException("Negative size: " + key + "=" + value);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.631 -0400", hash_original_method = "6F73EAFB28729CDC0BB32AECE7CD1246", hash_generated_method = "7AD2FBB5D8D76A604318C1F495681EB2")
    @DSModeled(DSC.SAFE)
    protected int sizeOf(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.632 -0400", hash_original_method = "D3EB145ED9D558FDF887F10175D8EBDF", hash_generated_method = "BC0E3EA3C3970FFFC8DBBB7BE2F0DA56")
    @DSModeled(DSC.SAFE)
    public final void evictAll() {
        trimToSize(-1);
        // ---------- Original Method ----------
        //trimToSize(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.632 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "65D53F05657ACEE9F8F0BDB0321E3E28")
    @DSModeled(DSC.SAFE)
    public synchronized final int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.632 -0400", hash_original_method = "3468DBA84D0C4B093D85888533351ACC", hash_generated_method = "7A7938E36D10F55863E696AE19AEF5FE")
    @DSModeled(DSC.SAFE)
    public synchronized final int maxSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maxSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.632 -0400", hash_original_method = "58C54B9E60920B23E133E0E61BF2A4F4", hash_generated_method = "AA1402951CFDFF3F7889C982E426F250")
    @DSModeled(DSC.SAFE)
    public synchronized final int hitCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return hitCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.632 -0400", hash_original_method = "CD33CA8BAAD7A20717BABBDF22DCC17E", hash_generated_method = "42D23BB8CE40B237DAAE872D3BADC517")
    @DSModeled(DSC.SAFE)
    public synchronized final int missCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return missCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.632 -0400", hash_original_method = "03691337F25E7C4DFAAA3B9F69FCDA1E", hash_generated_method = "3733863C9291E1CDA4FD4CAE66300B0B")
    @DSModeled(DSC.SAFE)
    public synchronized final int createCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return createCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.632 -0400", hash_original_method = "291437E08BF34B71B9E36D69031C2701", hash_generated_method = "40CC1A2CD73C77764D7C8342166519BF")
    @DSModeled(DSC.SAFE)
    public synchronized final int putCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return putCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.632 -0400", hash_original_method = "21AA3C6AE5648A36F9E47AF2806112A8", hash_generated_method = "3A2417BFB27B7036F9081AC50D80E178")
    @DSModeled(DSC.SAFE)
    public synchronized final int evictionCount() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return evictionCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.632 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "E290134E2E0BDBD74AE953A3B5DD0B1F")
    @DSModeled(DSC.SAFE)
    public synchronized final Map<K, V> snapshot() {
        return (Map<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LinkedHashMap<K, V>(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.632 -0400", hash_original_method = "D511C7B644032E2A9485769132851C89", hash_generated_method = "D43EBAD3C19543AAF78A993CF6A42A19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized final String toString() {
        int accesses;
        accesses = hitCount + missCount;
        int hitPercent;
        hitPercent = (100 * hitCount / accesses);
        hitPercent = 0;
        String varA3592988E9EAF650585F334CC9D09A36_436037032 = (String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int accesses = hitCount + missCount;
        //int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
        //return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                //maxSize, hitCount, missCount, hitPercent);
    }

    
}



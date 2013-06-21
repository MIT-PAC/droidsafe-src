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
    private LinkedHashMap<K, V> map;
    private int size;
    private int maxSize;
    private int putCount;
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private int missCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.260 -0400", hash_original_method = "4EF140C80EBAC1C26C5562E76AB6C34D", hash_generated_method = "9C22B7B8666FB55D28A3B55167C33F6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.260 -0400", hash_original_method = "E5DC52D3C4EAEBC9C86A603CE5606C4A", hash_generated_method = "0D054635CD1A2BB3996F3007D5B25718")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final V get(K key) {
        dsTaint.addTaint(key.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("key == null");
        } //End block
        V mapValue;
        {
            mapValue = map.get(key);
        } //End block
        V createdValue;
        createdValue = create(key);
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
        } //End block
        {
            trimToSize(maxSize);
        } //End block
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.266 -0400", hash_original_method = "79B383546C2B260561E7B3FD1850F381", hash_generated_method = "42671330B742B37ECBC5150DD802C45B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.267 -0400", hash_original_method = "5A85F1994DB09F90DA92A4710FB4C22D", hash_generated_method = "6E6A0F20AE42A198B74588C421408A1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void trimToSize(int maxSize) {
        dsTaint.addTaint(maxSize);
        {
            K key;
            V value;
            {
                {
                    boolean var78F01EF42D3F5C8B47D2FC6491891300_1962460857 = (size < 0 || (map.isEmpty() && size != 0));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.267 -0400", hash_original_method = "5ECD46803ACE6D1B641401078C3B9D9C", hash_generated_method = "5C9212E644DE8452490F6C71536A659C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.268 -0400", hash_original_method = "9AD1617B914C1EE986412183164D996B", hash_generated_method = "B6600F252ED42C433E5ADDB7F86AB119")
    @DSModeled(DSC.SAFE)
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(oldValue.dsTaint);
        dsTaint.addTaint(evicted);
        dsTaint.addTaint(key.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.268 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "0DBF6286EC7C2581ED043CE1DEB31846")
    @DSModeled(DSC.SAFE)
    protected V create(K key) {
        dsTaint.addTaint(key.dsTaint);
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.268 -0400", hash_original_method = "971860883D94FE365FE71BDE260829D3", hash_generated_method = "F30310AC4B01E39958920EDF9590E4F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.269 -0400", hash_original_method = "6F73EAFB28729CDC0BB32AECE7CD1246", hash_generated_method = "692071C5C82045C216D1EFE363390749")
    @DSModeled(DSC.SAFE)
    protected int sizeOf(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.269 -0400", hash_original_method = "D3EB145ED9D558FDF887F10175D8EBDF", hash_generated_method = "6852E1E415BA1B80059D4CFD58DC38F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void evictAll() {
        trimToSize(-1);
        // ---------- Original Method ----------
        //trimToSize(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.269 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "F986A8BBF5B2F1BBC764FB020C8482D7")
    @DSModeled(DSC.SAFE)
    public synchronized final int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.269 -0400", hash_original_method = "3468DBA84D0C4B093D85888533351ACC", hash_generated_method = "3C9F35EDEDE5FD0B2D4AF70FFFE44674")
    @DSModeled(DSC.SAFE)
    public synchronized final int maxSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maxSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.269 -0400", hash_original_method = "58C54B9E60920B23E133E0E61BF2A4F4", hash_generated_method = "63AF21343B88C15FFCF2A7E05BB3A1B1")
    @DSModeled(DSC.SAFE)
    public synchronized final int hitCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return hitCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.270 -0400", hash_original_method = "CD33CA8BAAD7A20717BABBDF22DCC17E", hash_generated_method = "C819B127751895C93819B17FA4070B81")
    @DSModeled(DSC.SAFE)
    public synchronized final int missCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return missCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.270 -0400", hash_original_method = "03691337F25E7C4DFAAA3B9F69FCDA1E", hash_generated_method = "05630DE01D2EDEBD1C9627E265D2E4D5")
    @DSModeled(DSC.SAFE)
    public synchronized final int createCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return createCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.270 -0400", hash_original_method = "291437E08BF34B71B9E36D69031C2701", hash_generated_method = "F4FD0BFA6F03BCC5B3CCE42E684E15E3")
    @DSModeled(DSC.SAFE)
    public synchronized final int putCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return putCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.271 -0400", hash_original_method = "21AA3C6AE5648A36F9E47AF2806112A8", hash_generated_method = "4A0AFAC666DEA757B7E44195DFFB9827")
    @DSModeled(DSC.SAFE)
    public synchronized final int evictionCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return evictionCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.271 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "9DA13E6FAB1DB486CFA1597C1F42BFE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final Map<K, V> snapshot() {
        Map<K, V> var386147AFF0F309627A763D905FB336F9_776670784 = (new LinkedHashMap<K, V>(map));
        return (Map<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LinkedHashMap<K, V>(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.271 -0400", hash_original_method = "D511C7B644032E2A9485769132851C89", hash_generated_method = "CF54AFF1CDA1931AAF27CFD20F95B1A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized final String toString() {
        int accesses;
        accesses = hitCount + missCount;
        int hitPercent;
        hitPercent = (100 * hitCount / accesses);
        hitPercent = 0;
        String varA3592988E9EAF650585F334CC9D09A36_1361372125 = (String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int accesses = hitCount + missCount;
        //int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
        //return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                //maxSize, hitCount, missCount, hitPercent);
    }

    
}


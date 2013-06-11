package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.LinkedHashMap;
import java.util.Map;

public class BasicLruCache<K, V> {
    private final LinkedHashMap<K, V> map;
    private final int maxSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.538 -0400", hash_original_method = "CC3CF8B3D98F4B51DBF91665642387E1", hash_generated_method = "A524E4F45727162BA916ED578B15FABA")
    @DSModeled(DSC.SAFE)
    public BasicLruCache(int maxSize) {
        dsTaint.addTaint(maxSize);
        {
            throw new IllegalArgumentException("maxSize <= 0");
        } //End block
        this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
        // ---------- Original Method ----------
        //if (maxSize <= 0) {
            //throw new IllegalArgumentException("maxSize <= 0");
        //}
        //this.maxSize = maxSize;
        //this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.538 -0400", hash_original_method = "FDCF7F376F479E894B67671F9DF4B51A", hash_generated_method = "76C1B86201548F1D461D335927F2BA86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final V get(K key) {
        dsTaint.addTaint(key.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        V result;
        result = map.get(key);
        result = create(key);
        {
            map.put(key, result);
            trimToSize(maxSize);
        } //End block
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //V result = map.get(key);
        //if (result != null) {
            //return result;
        //}
        //result = create(key);
        //if (result != null) {
            //map.put(key, result);
            //trimToSize(maxSize);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.538 -0400", hash_original_method = "B215038407F38B18B2F223450263C0DA", hash_generated_method = "E02FF8DFFE7A7AF1D4C477C6D258D793")
    @DSModeled(DSC.SAFE)
    public synchronized final V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        V previous;
        previous = map.put(key, value);
        trimToSize(maxSize);
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (key == null || value == null) {
            //throw new NullPointerException();
        //}
        //V previous = map.put(key, value);
        //trimToSize(maxSize);
        //return previous;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.538 -0400", hash_original_method = "C2014D558C9CB4AC36D82EB01EFD84A6", hash_generated_method = "CE8C844EAFC798A7B09C63905FA06408")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void trimToSize(int maxSize) {
        dsTaint.addTaint(maxSize);
        {
            boolean var3BFE4AB1CCFC4CFAE6E3CC8404C94C02_900770513 = (map.size() > maxSize);
            {
                Map.Entry<K, V> toEvict;
                toEvict = map.eldest();
                K key;
                key = toEvict.getKey();
                V value;
                value = toEvict.getValue();
                map.remove(key);
                entryEvicted(key, value);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (map.size() > maxSize) {
            //Map.Entry<K, V> toEvict = map.eldest();
            //K key = toEvict.getKey();
            //V value = toEvict.getValue();
            //map.remove(key);
            //entryEvicted(key, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.538 -0400", hash_original_method = "4BE44702079F6982C8F2A1526F7D2A98", hash_generated_method = "8FCF5C44E3BDEAD8CBAD678111FAF6C0")
    @DSModeled(DSC.SAFE)
    protected void entryEvicted(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.538 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "0751A6F70F8811814554A78EC2932D23")
    @DSModeled(DSC.SAFE)
    protected V create(K key) {
        dsTaint.addTaint(key.dsTaint);
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.538 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "E290134E2E0BDBD74AE953A3B5DD0B1F")
    @DSModeled(DSC.SAFE)
    public synchronized final Map<K, V> snapshot() {
        return (Map<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LinkedHashMap<K, V>(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.538 -0400", hash_original_method = "4FACC3280D713DC7A18D1388CFCADEC7", hash_generated_method = "FB7295E82E6ABA0B9037285705FCC914")
    @DSModeled(DSC.SAFE)
    public synchronized final void evictAll() {
        trimToSize(0);
        // ---------- Original Method ----------
        //trimToSize(0);
    }

    
}



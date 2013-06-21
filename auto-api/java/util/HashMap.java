package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import libcore.util.Objects;

public class HashMap<K, V> extends AbstractMap<K, V> implements Cloneable, Serializable {
    transient HashMapEntry<K, V>[] table;
    transient HashMapEntry<K, V> entryForNullKey;
    transient int size;
    transient int modCount;
    private transient int threshold;
    private transient Set<K> keySet;
    private transient Set<Entry<K, V>> entrySet;
    private transient Collection<V> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.357 -0400", hash_original_method = "67F8ADB6599C3AA95FA8DFFD843377DD", hash_generated_method = "7409D258B8D042741B25C0440FA51BF9")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public HashMap() {
        table = (HashMapEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1;
        // ---------- Original Method ----------
        //table = (HashMapEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.357 -0400", hash_original_method = "DBEA46BF5DB352E6536C06B54FDF6C1E", hash_generated_method = "96C0AD82905E390DF40A4372809944E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HashMap(int capacity) {
        dsTaint.addTaint(capacity);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Capacity: " + capacity);
        } //End block
        {
            @SuppressWarnings("unchecked") HashMapEntry<K, V>[] tab;
            tab = (HashMapEntry<K, V>[]) EMPTY_TABLE;
            table = tab;
            threshold = -1;
        } //End block
        {
            capacity = MINIMUM_CAPACITY;
        } //End block
        {
            capacity = MAXIMUM_CAPACITY;
        } //End block
        {
            capacity = roundUpToPowerOfTwo(capacity);
        } //End block
        makeTable(capacity);
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new IllegalArgumentException("Capacity: " + capacity);
        //}
        //if (capacity == 0) {
            //@SuppressWarnings("unchecked")
            //HashMapEntry<K, V>[] tab = (HashMapEntry<K, V>[]) EMPTY_TABLE;
            //table = tab;
            //threshold = -1; 
            //return;
        //}
        //if (capacity < MINIMUM_CAPACITY) {
            //capacity = MINIMUM_CAPACITY;
        //} else if (capacity > MAXIMUM_CAPACITY) {
            //capacity = MAXIMUM_CAPACITY;
        //} else {
            //capacity = roundUpToPowerOfTwo(capacity);
        //}
        //makeTable(capacity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.357 -0400", hash_original_method = "ED265422F07438826BD7CEB727CA13DA", hash_generated_method = "2E5D2232C688602304A7E52F4EDB5056")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HashMap(int capacity, float loadFactor) {
        this(capacity);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
        {
            boolean var7E96777C74EA86B66256F7B00F5AE961_1710682432 = (loadFactor <= 0 || Float.isNaN(loadFactor));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Load factor: " + loadFactor);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            //throw new IllegalArgumentException("Load factor: " + loadFactor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.357 -0400", hash_original_method = "D988B3BE94D6CE1D83E9BB54AA86E55F", hash_generated_method = "5436C107CDF32E0D3978FAAE007A87D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HashMap(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        dsTaint.addTaint(map.dsTaint);
        constructorPutAll(map);
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.359 -0400", hash_original_method = "6631235722E4D3190E3529D2039DDD7A", hash_generated_method = "211EC2A4A4C7B3132EE9ABC25AF7E495")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void constructorPutAll(Map<? extends K, ? extends V> map) {
        dsTaint.addTaint(map.dsTaint);
        {
            map.entrySet().iterator().hasNext();
            Entry<? extends K, ? extends V> e = map.entrySet().iterator().next();
            {
                constructorPut(e.getKey(), e.getValue());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Entry<? extends K, ? extends V> e : map.entrySet()) {
            //constructorPut(e.getKey(), e.getValue());
        //}
    }

    
        static int capacityForInitSize(int size) {
        int result = (size >> 1) + size;
        return (result & ~(MAXIMUM_CAPACITY-1))==0 ? result : MAXIMUM_CAPACITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.360 -0400", hash_original_method = "C555E25CE67FE12926CA5480B863847E", hash_generated_method = "62E16FE256C96524D09C7FDD1DD0B290")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        HashMap<K, V> result;
        try 
        {
            result = (HashMap<K, V>) super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        result.makeTable(table.length);
        result.entryForNullKey = null;
        result.size = 0;
        result.keySet = null;
        result.entrySet = null;
        result.values = null;
        result.init();
        result.constructorPutAll(this);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //HashMap<K, V> result;
        //try {
            //result = (HashMap<K, V>) super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
        //result.makeTable(table.length);
        //result.entryForNullKey = null;
        //result.size = 0;
        //result.keySet = null;
        //result.entrySet = null;
        //result.values = null;
        //result.init();
        //result.constructorPutAll(this);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.360 -0400", hash_original_method = "417EF77086319CE91314CCF850ADA61E", hash_generated_method = "2067003B6622767497B839D408201FF1")
    @DSModeled(DSC.SAFE)
     void init() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.360 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "4BEC7A3919A556BE19BE40EE7160C52B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.360 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "2127DA49D089D6CBC77B455A0DBDC124")
    @DSModeled(DSC.SAFE)
    @Override
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.361 -0400", hash_original_method = "D55BBCD9F0C6BD0BD798F81C2A3EFECD", hash_generated_method = "BB626AD6240246F4E68342244E19CFDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        {
            HashMapEntry<K, V> e;
            e = entryForNullKey;
        } //End block
        int hash;
        hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashMapEntry<K, V>[] tab;
        tab = table;
        {
            HashMapEntry<K, V> e;
            e = tab[hash & (tab.length - 1)];
            e = e.next;
            {
                K eKey;
                eKey = e.key;
                {
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_1459770781 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (key == null) {
            //HashMapEntry<K, V> e = entryForNullKey;
            //return e == null ? null : e.value;
        //}
        //int hash = key.hashCode();
        //hash ^= (hash >>> 20) ^ (hash >>> 12);
        //hash ^= (hash >>> 7) ^ (hash >>> 4);
        //HashMapEntry<K, V>[] tab = table;
        //for (HashMapEntry<K, V> e = tab[hash & (tab.length - 1)];
                //e != null; e = e.next) {
            //K eKey = e.key;
            //if (eKey == key || (e.hash == hash && key.equals(eKey))) {
                //return e.value;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.361 -0400", hash_original_method = "664DBEAFB6D0F34975160DBB887BD5CA", hash_generated_method = "A0A70BF724ADDD3E286B6DBB40FAF483")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        int hash;
        hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashMapEntry<K, V>[] tab;
        tab = table;
        {
            HashMapEntry<K, V> e;
            e = tab[hash & (tab.length - 1)];
            e = e.next;
            {
                K eKey;
                eKey = e.key;
                {
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_1528738812 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (key == null) {
            //return entryForNullKey != null;
        //}
        //int hash = key.hashCode();
        //hash ^= (hash >>> 20) ^ (hash >>> 12);
        //hash ^= (hash >>> 7) ^ (hash >>> 4);
        //HashMapEntry<K, V>[] tab = table;
        //for (HashMapEntry<K, V> e = tab[hash & (tab.length - 1)];
                //e != null; e = e.next) {
            //K eKey = e.key;
            //if (eKey == key || (e.hash == hash && key.equals(eKey))) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.361 -0400", hash_original_method = "8A9DFD8A0E528EE1DFDA14FDA5F2B177", hash_generated_method = "B619152A4AF274FDAC33C61714AF8B3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        HashMapEntry[] tab;
        tab = table;
        int len;
        len = tab.length;
        {
            {
                int i;
                i = 0;
                {
                    {
                        HashMapEntry e;
                        e = tab[i];
                        e = e.next;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int i;
            i = 0;
            {
                {
                    HashMapEntry e;
                    e = tab[i];
                    e = e.next;
                    {
                        {
                            boolean varB228932AA07990623CC3C29EF03F40DA_1098199945 = (value.equals(e.value));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean varEA7E3E060F89A85EADC32277C95F3D47_773291360 = (entryForNullKey != null && value.equals(entryForNullKey.value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //HashMapEntry[] tab = table;
        //int len = tab.length;
        //if (value == null) {
            //for (int i = 0; i < len; i++) {
                //for (HashMapEntry e = tab[i]; e != null; e = e.next) {
                    //if (e.value == null) {
                        //return true;
                    //}
                //}
            //}
            //return entryForNullKey != null && entryForNullKey.value == null;
        //}
        //for (int i = 0; i < len; i++) {
            //for (HashMapEntry e = tab[i]; e != null; e = e.next) {
                //if (value.equals(e.value)) {
                    //return true;
                //}
            //}
        //}
        //return entryForNullKey != null && value.equals(entryForNullKey.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.362 -0400", hash_original_method = "5BBA395276A0B9AAD236878C1432D189", hash_generated_method = "83D49E2C5F0026C29B1C1AA31AD59C9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            V var2491118F67ABE91E390B281865D3A065_1084162391 = (putValueForNullKey(value));
        } //End block
        int hash;
        hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab;
        tab = table;
        int index;
        index = hash & (tab.length - 1);
        {
            HashMapEntry<K, V> e;
            e = tab[index];
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_2133126233 = (e.hash == hash && key.equals(e.key));
                    {
                        preModify(e);
                        V oldValue;
                        oldValue = e.value;
                        e.value = value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            tab = doubleCapacity();
            index = hash & (tab.length - 1);
        } //End block
        addNewEntry(key, value, hash, index);
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (key == null) {
            //return putValueForNullKey(value);
        //}
        //int hash = secondaryHash(key.hashCode());
        //HashMapEntry<K, V>[] tab = table;
        //int index = hash & (tab.length - 1);
        //for (HashMapEntry<K, V> e = tab[index]; e != null; e = e.next) {
            //if (e.hash == hash && key.equals(e.key)) {
                //preModify(e);
                //V oldValue = e.value;
                //e.value = value;
                //return oldValue;
            //}
        //}
        //modCount++;
        //if (size++ > threshold) {
            //tab = doubleCapacity();
            //index = hash & (tab.length - 1);
        //}
        //addNewEntry(key, value, hash, index);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.362 -0400", hash_original_method = "23837E71B15780DD12C36C21FB15F598", hash_generated_method = "852503314AD45B0260EB6E90FC264F8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private V putValueForNullKey(V value) {
        dsTaint.addTaint(value.dsTaint);
        HashMapEntry<K, V> entry;
        entry = entryForNullKey;
        {
            addNewEntryForNullKey(value);
        } //End block
        {
            preModify(entry);
            V oldValue;
            oldValue = entry.value;
            entry.value = value;
        } //End block
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //HashMapEntry<K, V> entry = entryForNullKey;
        //if (entry == null) {
            //addNewEntryForNullKey(value);
            //size++;
            //modCount++;
            //return null;
        //} else {
            //preModify(entry);
            //V oldValue = entry.value;
            //entry.value = value;
            //return oldValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.362 -0400", hash_original_method = "DFE0557B59605BA6C5CD9DE7502DD68F", hash_generated_method = "BBAFB733369A4279148D97ACA65BC138")
    @DSModeled(DSC.SAFE)
     void preModify(HashMapEntry<K, V> e) {
        dsTaint.addTaint(e.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.363 -0400", hash_original_method = "627029122DE3FFF8BEA7942964D9C227", hash_generated_method = "7A773E36D2E94D22399FC13F4A887B1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void constructorPut(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            HashMapEntry<K, V> entry;
            entry = entryForNullKey;
            {
                entryForNullKey = constructorNewEntry(null, value, 0, null);
            } //End block
            {
                entry.value = value;
            } //End block
        } //End block
        int hash;
        hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab;
        tab = table;
        int index;
        index = hash & (tab.length - 1);
        HashMapEntry<K, V> first;
        first = tab[index];
        {
            HashMapEntry<K, V> e;
            e = first;
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_758095733 = (e.hash == hash && key.equals(e.key));
                    {
                        e.value = value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        tab[index] = constructorNewEntry(key, value, hash, first);
        // ---------- Original Method ----------
        //if (key == null) {
            //HashMapEntry<K, V> entry = entryForNullKey;
            //if (entry == null) {
                //entryForNullKey = constructorNewEntry(null, value, 0, null);
                //size++;
            //} else {
                //entry.value = value;
            //}
            //return;
        //}
        //int hash = secondaryHash(key.hashCode());
        //HashMapEntry<K, V>[] tab = table;
        //int index = hash & (tab.length - 1);
        //HashMapEntry<K, V> first = tab[index];
        //for (HashMapEntry<K, V> e = first; e != null; e = e.next) {
            //if (e.hash == hash && key.equals(e.key)) {
                //e.value = value;
                //return;
            //}
        //}
        //tab[index] = constructorNewEntry(key, value, hash, first);
        //size++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.363 -0400", hash_original_method = "6DFE8ABD0EB0EC55F81B8127E2FB540C", hash_generated_method = "F0890512F229DAA67E126842BF0857FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void addNewEntry(K key, V value, int hash, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(hash);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        table[index] = new HashMapEntry<K, V>(key, value, hash, table[index]);
        // ---------- Original Method ----------
        //table[index] = new HashMapEntry<K, V>(key, value, hash, table[index]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.363 -0400", hash_original_method = "1A0C0EFFA3B59B8426ED7AB00D5D7C14", hash_generated_method = "032E7293C907BEB8ACFFC10561A223BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void addNewEntryForNullKey(V value) {
        dsTaint.addTaint(value.dsTaint);
        entryForNullKey = new HashMapEntry<K, V>(null, value, 0, null);
        // ---------- Original Method ----------
        //entryForNullKey = new HashMapEntry<K, V>(null, value, 0, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.363 -0400", hash_original_method = "08952C170F8B11733B904F0E99F6B0F5", hash_generated_method = "9B5853DE31844EA7F97862CB7BF45D89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HashMapEntry<K, V> constructorNewEntry(
            K key, V value, int hash, HashMapEntry<K, V> first) {
        dsTaint.addTaint(hash);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(first.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        HashMapEntry<K, V> var52C2FF30355EA4C7753916B6F0506728_1190949340 = (new HashMapEntry<K, V>(key, value, hash, first));
        return (HashMapEntry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new HashMapEntry<K, V>(key, value, hash, first);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.364 -0400", hash_original_method = "A51614C8AB5E8271029690D5F9184632", hash_generated_method = "763676C73B7F75B359F321CD85FFE6D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        dsTaint.addTaint(map.dsTaint);
        ensureCapacity(map.size());
        super.putAll(map);
        // ---------- Original Method ----------
        //ensureCapacity(map.size());
        //super.putAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.364 -0400", hash_original_method = "4BE6F38D6656B87B29773B0AAEA75993", hash_generated_method = "4E0D2C1222E15EF90DCF59C0B82F2B7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureCapacity(int numMappings) {
        dsTaint.addTaint(numMappings);
        int newCapacity;
        newCapacity = roundUpToPowerOfTwo(capacityForInitSize(numMappings));
        HashMapEntry<K, V>[] oldTable;
        oldTable = table;
        int oldCapacity;
        oldCapacity = oldTable.length;
        {
            doubleCapacity();
        } //End block
        HashMapEntry<K, V>[] newTable;
        newTable = makeTable(newCapacity);
        {
            int newMask;
            newMask = newCapacity - 1;
            {
                int i;
                i = 0;
                {
                    {
                        HashMapEntry<K, V> e;
                        e = oldTable[i];
                        {
                            HashMapEntry<K, V> oldNext;
                            oldNext = e.next;
                            int newIndex;
                            newIndex = e.hash & newMask;
                            HashMapEntry<K, V> newNext;
                            newNext = newTable[newIndex];
                            newTable[newIndex] = e;
                            e.next = newNext;
                            e = oldNext;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.364 -0400", hash_original_method = "EE2E1A4893DAC33AFE32D39C3AA93587", hash_generated_method = "93F36EED8DFCDE1AEF5E051CA97F39E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private HashMapEntry<K, V>[] makeTable(int newCapacity) {
        dsTaint.addTaint(newCapacity);
        @SuppressWarnings("unchecked") HashMapEntry<K, V>[] newTable;
        newTable = (HashMapEntry<K, V>[]) new HashMapEntry[newCapacity];
        table = newTable;
        threshold = (newCapacity >> 1) + (newCapacity >> 2);
        return (HashMapEntry<K, V>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked") HashMapEntry<K, V>[] newTable
                //= (HashMapEntry<K, V>[]) new HashMapEntry[newCapacity];
        //table = newTable;
        //threshold = (newCapacity >> 1) + (newCapacity >> 2);
        //return newTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.364 -0400", hash_original_method = "0D1C32EF365F651EE12DB3FC6B4877B2", hash_generated_method = "ED12D0DA99D82A4E406FA2DD31F23866")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private HashMapEntry<K, V>[] doubleCapacity() {
        HashMapEntry<K, V>[] oldTable;
        oldTable = table;
        int oldCapacity;
        oldCapacity = oldTable.length;
        int newCapacity;
        newCapacity = oldCapacity * 2;
        HashMapEntry<K, V>[] newTable;
        newTable = makeTable(newCapacity);
        {
            int j;
            j = 0;
            {
                HashMapEntry<K, V> e;
                e = oldTable[j];
                int highBit;
                highBit = e.hash & oldCapacity;
                HashMapEntry<K, V> broken;
                broken = null;
                newTable[j | highBit] = e;
                {
                    HashMapEntry<K, V> n;
                    n = e.next;
                    e = n;
                    n = n.next;
                    {
                        int nextHighBit;
                        nextHighBit = n.hash & oldCapacity;
                        {
                            newTable[j | nextHighBit] = n;
                            broken.next = n;
                            broken = e;
                            highBit = nextHighBit;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                broken.next = null;
            } //End block
        } //End collapsed parenthetic
        return (HashMapEntry<K, V>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.365 -0400", hash_original_method = "D4E7D7B0427A5C260627922F822E871C", hash_generated_method = "DC90A616C361FA047206A26A8F50DF3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        {
            V var33078FE3A29A290A1DA0BB31A5D77172_1634910408 = (removeNullKey());
        } //End block
        int hash;
        hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab;
        tab = table;
        int index;
        index = hash & (tab.length - 1);
        {
            HashMapEntry<K, V> e, prev;
            e = tab[index];
            prev = null;
            prev = e;
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1377675218 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            tab[index] = e.next;
                        } //End block
                        {
                            prev.next = e.next;
                        } //End block
                        postRemove(e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (key == null) {
            //return removeNullKey();
        //}
        //int hash = secondaryHash(key.hashCode());
        //HashMapEntry<K, V>[] tab = table;
        //int index = hash & (tab.length - 1);
        //for (HashMapEntry<K, V> e = tab[index], prev = null;
                //e != null; prev = e, e = e.next) {
            //if (e.hash == hash && key.equals(e.key)) {
                //if (prev == null) {
                    //tab[index] = e.next;
                //} else {
                    //prev.next = e.next;
                //}
                //modCount++;
                //size--;
                //postRemove(e);
                //return e.value;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.365 -0400", hash_original_method = "C27EF61BE4179F161C4389258A9892DE", hash_generated_method = "F1FFA5DFFE070961A87AA5757B8ACB4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private V removeNullKey() {
        HashMapEntry<K, V> e;
        e = entryForNullKey;
        entryForNullKey = null;
        postRemove(e);
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //HashMapEntry<K, V> e = entryForNullKey;
        //if (e == null) {
            //return null;
        //}
        //entryForNullKey = null;
        //modCount++;
        //size--;
        //postRemove(e);
        //return e.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.365 -0400", hash_original_method = "FA0A77625972B3EBD78B9E2926769234", hash_generated_method = "5626926A4FD290AE1A37EC1533902190")
    @DSModeled(DSC.SAFE)
     void postRemove(HashMapEntry<K, V> e) {
        dsTaint.addTaint(e.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.365 -0400", hash_original_method = "19183B81B15552124143C4B9B1D176AB", hash_generated_method = "36983ECD3B8546C41194A59C9AEA9DE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clear() {
        {
            Arrays.fill(table, null);
            entryForNullKey = null;
            size = 0;
        } //End block
        // ---------- Original Method ----------
        //if (size != 0) {
            //Arrays.fill(table, null);
            //entryForNullKey = null;
            //modCount++;
            //size = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.366 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "1EF1E23210ADB3048073F126BA9E6462")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Set<K> keySet() {
        Set<K> ks;
        ks = keySet;
        {
            Object varB5B77DAF0CA06DFD739ACDEAEEA4B87A_665221767 = ((keySet = new KeySet()));
        } //End flattened ternary
        return (Set<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.366 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "AADC5AB7DB563A69A21DDBAD1EB12EC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Collection<V> values() {
        Collection<V> vs;
        vs = values;
        {
            Object varA810554C04DFEDF1EF7ED76F9552EC23_515566997 = ((values = new Values()));
        } //End flattened ternary
        return (Collection<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.366 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "953E31B3D5A8892B76342EF33BE03BF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> es;
        es = entrySet;
        {
            Object var8EEA31F996A0AE22A7B2AC281EA5A60C_860852667 = ((entrySet = new EntrySet()));
        } //End flattened ternary
        return (Set<Entry<K, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.367 -0400", hash_original_method = "DB078B96D3A026778ABE08AF9188B4AF", hash_generated_method = "B0D66042A7D32120CFD7227EA6EFA41F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean containsMapping(Object key, Object value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            HashMapEntry<K, V> e;
            e = entryForNullKey;
            boolean var40279722BF7E3C571A7656157FAC1347_373772711 = (e != null && Objects.equal(value, e.value));
        } //End block
        int hash;
        hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab;
        tab = table;
        int index;
        index = hash & (tab.length - 1);
        {
            HashMapEntry<K, V> e;
            e = tab[index];
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_76020590 = (e.hash == hash && key.equals(e.key));
                    {
                        boolean var0A2AB9D17E208A44FDDADD38B7C746A6_149062243 = (Objects.equal(value, e.value));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (key == null) {
            //HashMapEntry<K, V> e = entryForNullKey;
            //return e != null && Objects.equal(value, e.value);
        //}
        //int hash = secondaryHash(key.hashCode());
        //HashMapEntry<K, V>[] tab = table;
        //int index = hash & (tab.length - 1);
        //for (HashMapEntry<K, V> e = tab[index]; e != null; e = e.next) {
            //if (e.hash == hash && key.equals(e.key)) {
                //return Objects.equal(value, e.value);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.367 -0400", hash_original_method = "6968B8C772086C45A00DBEEB8B4680E5", hash_generated_method = "26608B1EB989278DE0AF270D5D7A091D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean removeMapping(Object key, Object value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            HashMapEntry<K, V> e;
            e = entryForNullKey;
            {
                boolean varD3D296D0132E960C37912D3ADB0BA70A_2053722015 = (e == null || !Objects.equal(value, e.value));
            } //End collapsed parenthetic
            entryForNullKey = null;
            postRemove(e);
        } //End block
        int hash;
        hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab;
        tab = table;
        int index;
        index = hash & (tab.length - 1);
        {
            HashMapEntry<K, V> e, prev;
            e = tab[index];
            prev = null;
            prev = e;
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1273925927 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            boolean varA66595D18F1E35DC37004284678D0E23_635948326 = (!Objects.equal(value, e.value));
                        } //End collapsed parenthetic
                        {
                            tab[index] = e.next;
                        } //End block
                        {
                            prev.next = e.next;
                        } //End block
                        postRemove(e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.367 -0400", hash_original_method = "E5C2B853B7FE0DFF8A1198070D9AED67", hash_generated_method = "C2D402E13EF71EB648BCED579988A1BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Iterator<K> newKeyIterator() {
        Iterator<K> var23DBCBF4E184D62482444F7AF7A8A6FB_1650183231 = (new KeyIterator());
        return (Iterator<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.367 -0400", hash_original_method = "58BEE1C21CE9010029EB8FF9FDCDF9B3", hash_generated_method = "AB022C6A9B2446B6588B7778908A2AA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Iterator<V> newValueIterator() {
        Iterator<V> varD97090F3A13A0D960A637BC236C561C5_378466937 = (new ValueIterator());
        return (Iterator<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.368 -0400", hash_original_method = "41242F67E24C22ACB46F6D238FB07528", hash_generated_method = "22D9BA88EF4DB3999230CDAB7138E6B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Iterator<Entry<K, V>> newEntryIterator() {
        Iterator<Entry<K, V>> var1ECA2617FE2310C4DFA319908865704D_797069647 = (new EntryIterator());
        return (Iterator<Entry<K, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new EntryIterator();
    }

    
        private static int secondaryHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    
        private static int roundUpToPowerOfTwo(int i) {
        i--;
        i |= i >>>  1;
        i |= i >>>  2;
        i |= i >>>  4;
        i |= i >>>  8;
        i |= i >>> 16;
        return i + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.372 -0400", hash_original_method = "04BAFB4D83496263E755E7BD0F7C13FF", hash_generated_method = "044C5518F07C57D6E8BE1D25AC3558BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("loadFactor", DEFAULT_LOAD_FACTOR);
        stream.writeFields();
        stream.writeInt(table.length);
        stream.writeInt(size);
        {
            Iterator<Entry<K, V>> varD93A6471022189C0BA28AFBB8C8557A0_1362755958 = (entrySet()).iterator();
            varD93A6471022189C0BA28AFBB8C8557A0_1362755958.hasNext();
            Entry<K, V> e = varD93A6471022189C0BA28AFBB8C8557A0_1362755958.next();
            {
                stream.writeObject(e.getKey());
                stream.writeObject(e.getValue());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //ObjectOutputStream.PutField fields = stream.putFields();
        //fields.put("loadFactor", DEFAULT_LOAD_FACTOR);
        //stream.writeFields();
        //stream.writeInt(table.length);
        //stream.writeInt(size);
        //for (Entry<K, V> e : entrySet()) {
            //stream.writeObject(e.getKey());
            //stream.writeObject(e.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.373 -0400", hash_original_method = "332DDC73CD162DC81E3D2D410CF74F29", hash_generated_method = "1C2D4CCB37BC58DAEAFA9E20103301AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultReadObject();
        int capacity;
        capacity = stream.readInt();
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Capacity: " + capacity);
        } //End block
        {
            capacity = MINIMUM_CAPACITY;
        } //End block
        {
            capacity = MAXIMUM_CAPACITY;
        } //End block
        {
            capacity = roundUpToPowerOfTwo(capacity);
        } //End block
        makeTable(capacity);
        int size;
        size = stream.readInt();
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Size: " + size);
        } //End block
        init();
        {
            int i;
            i = 0;
            {
                @SuppressWarnings("unchecked") K key;
                key = (K) stream.readObject();
                @SuppressWarnings("unchecked") V val;
                val = (V) stream.readObject();
                constructorPut(key, val);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static class HashMapEntry<K, V> implements Entry<K, V> {
        K key;
        V value;
        int hash;
        HashMapEntry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.374 -0400", hash_original_method = "59EAB065FDED45CEE8A2A37A4323841C", hash_generated_method = "C0AA8088FFD56ED4061FBCA24CBC97FB")
        @DSModeled(DSC.SAFE)
         HashMapEntry(K key, V value, int hash, HashMapEntry<K, V> next) {
            dsTaint.addTaint(hash);
            dsTaint.addTaint(next.dsTaint);
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            // ---------- Original Method ----------
            //this.key = key;
            //this.value = value;
            //this.hash = hash;
            //this.next = next;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.374 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "EE071B019D3BFDDDB20AAD5C11BA2C9D")
        @DSModeled(DSC.SAFE)
        public final K getKey() {
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.374 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "8B012D6735DD9AA7386E0263130FD3D0")
        @DSModeled(DSC.SAFE)
        public final V getValue() {
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.374 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "0D85184F3F77605E4AFCA5446FCE9921")
        @DSModeled(DSC.SAFE)
        public final V setValue(V value) {
            dsTaint.addTaint(value.dsTaint);
            V oldValue;
            oldValue = this.value;
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.374 -0400", hash_original_method = "A2F2028BE339F747959E241A5FA9FFD4", hash_generated_method = "2224D274E78DDD7797E9D42AF065E91D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public final boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varA6FC4CEB84BC9265AEA86B844A98520F_1044258590 = (Objects.equal(e.getKey(), key)
                    && Objects.equal(e.getValue(), value));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return Objects.equal(e.getKey(), key)
                    //&& Objects.equal(e.getValue(), value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.375 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "7BBEFD15FB72D5A11251C63F9A624A96")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public final int hashCode() {
            int var3D869AD0C50894398C24E31912CFB90B_448733329 = ((key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode()) ^
                    //(value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.375 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "546FBDB0F2F6D1AD8A60D457DDC0FBEA")
        @DSModeled(DSC.SAFE)
        @Override
        public final String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
    }


    
    private abstract class HashIterator {
        int nextIndex;
        HashMapEntry<K, V> nextEntry = entryForNullKey;
        HashMapEntry<K, V> lastEntryReturned;
        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.375 -0400", hash_original_method = "1EAE57F880E5B81388FFC9611EFAA8EA", hash_generated_method = "51B338D2FBA648AB206D69E1243CB95C")
        @DSModeled(DSC.SAFE)
         HashIterator() {
            {
                HashMapEntry<K, V>[] tab;
                tab = table;
                HashMapEntry<K, V> next;
                next = null;
                {
                    next = tab[nextIndex++];
                } //End block
                nextEntry = next;
            } //End block
            // ---------- Original Method ----------
            //if (nextEntry == null) {
                //HashMapEntry<K, V>[] tab = table;
                //HashMapEntry<K, V> next = null;
                //while (next == null && nextIndex < tab.length) {
                    //next = tab[nextIndex++];
                //}
                //nextEntry = next;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.375 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "CC4831130E120DAE2C5139D0C4D85FB9")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.376 -0400", hash_original_method = "5956AFD098F3B365104EB4761E150134", hash_generated_method = "E87B84C4A90C374E441B7D4E18AA46EF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         HashMapEntry<K, V> nextEntry() {
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            HashMapEntry<K, V> entryToReturn;
            entryToReturn = nextEntry;
            HashMapEntry<K, V>[] tab;
            tab = table;
            HashMapEntry<K, V> next;
            next = entryToReturn.next;
            {
                next = tab[nextIndex++];
            } //End block
            nextEntry = next;
            HashMapEntry<K, V> varE716D0B9837917675A560095A2F6354C_1136536183 = (lastEntryReturned = entryToReturn);
            return (HashMapEntry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (modCount != expectedModCount)
                //throw new ConcurrentModificationException();
            //if (nextEntry == null)
                //throw new NoSuchElementException();
            //HashMapEntry<K, V> entryToReturn = nextEntry;
            //HashMapEntry<K, V>[] tab = table;
            //HashMapEntry<K, V> next = entryToReturn.next;
            //while (next == null && nextIndex < tab.length) {
                //next = tab[nextIndex++];
            //}
            //nextEntry = next;
            //return lastEntryReturned = entryToReturn;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.376 -0400", hash_original_method = "FE8482BFEC11D819DE4FA740E823F031", hash_generated_method = "F04FA077471E00E01DE713F18A0BE8B7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            HashMap.this.remove(lastEntryReturned.key);
            lastEntryReturned = null;
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //if (lastEntryReturned == null)
                //throw new IllegalStateException();
            //if (modCount != expectedModCount)
                //throw new ConcurrentModificationException();
            //HashMap.this.remove(lastEntryReturned.key);
            //lastEntryReturned = null;
            //expectedModCount = modCount;
        }

        
    }


    
    private final class KeyIterator extends HashIterator implements Iterator<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.376 -0400", hash_original_method = "5D388AF9F4BC08670D6FC8B0690B4586", hash_generated_method = "5D388AF9F4BC08670D6FC8B0690B4586")
                public KeyIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.376 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "C9D292A3E33C0B3C32309BEA9CF7CECF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K next() {
            K var0826C92B2F2C6B3475D8BF572E4E70AE_363014356 = (nextEntry().key);
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends HashIterator implements Iterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.376 -0400", hash_original_method = "0633288CFFDB0D47FC844EDFD5BB157F", hash_generated_method = "0633288CFFDB0D47FC844EDFD5BB157F")
                public ValueIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.376 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "92BDBBCCE71BDF361B12D4AE428BF34F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public V next() {
            V var551184D8EC6DFD9474BC6F4F9A2CB7F7_528068059 = (nextEntry().value);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.376 -0400", hash_original_method = "FCA6D1B18319AC57F041ABBA6E1FAA59", hash_generated_method = "FCA6D1B18319AC57F041ABBA6E1FAA59")
                public EntryIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.377 -0400", hash_original_method = "C7E2B840B075445DC1033B130AB2E6A6", hash_generated_method = "A87BEB516352E67E47714D721BC149D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> next() {
            Entry<K, V> varFDACBEE1E52798928B8D0EBEA13DBC12_2054730544 = (nextEntry());
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.377 -0400", hash_original_method = "AD2AA12DF2DCFDBEC9B4D1AB308E571A", hash_generated_method = "AD2AA12DF2DCFDBEC9B4D1AB308E571A")
                public KeySet ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.377 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "EDB6EA7308D32010FAE9CEDFF879F54A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<K> iterator() {
            Iterator<K> varA9B4179358078A77109B51144A3FD35B_863079962 = (newKeyIterator());
            return (Iterator<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return newKeyIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.377 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "5952D8F6ECECE9C90DA6440092EF19A0")
        @DSModeled(DSC.SAFE)
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.377 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "B02D7658F0824D0869C92F4AD19DB19E")
        @DSModeled(DSC.SAFE)
        public boolean isEmpty() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.377 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "02CBBB6C167DC8FAB23531849A59C58D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean var997BAB39B2F072D5CD66A271F3B6E196_716612969 = (containsKey(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.377 -0400", hash_original_method = "AFD23FBC02983B6BF4B878FD36F94DEB", hash_generated_method = "893E26AAC643691B24F9435131C1E23A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean remove(Object o) {
            dsTaint.addTaint(o.dsTaint);
            int oldSize;
            oldSize = size;
            HashMap.this.remove(o);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //int oldSize = size;
            //HashMap.this.remove(o);
            //return size != oldSize;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.378 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    private final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.378 -0400", hash_original_method = "D4CD3011C6EAF83FB83B7739F97A2374", hash_generated_method = "D4CD3011C6EAF83FB83B7739F97A2374")
                public Values ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.378 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "E558CCD176C126D4385DADCDEC43CC74")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<V> iterator() {
            Iterator<V> var3F269B9710619427718DF7C0BF51E397_1201329130 = (newValueIterator());
            return (Iterator<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return newValueIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.378 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "5952D8F6ECECE9C90DA6440092EF19A0")
        @DSModeled(DSC.SAFE)
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.378 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "B02D7658F0824D0869C92F4AD19DB19E")
        @DSModeled(DSC.SAFE)
        public boolean isEmpty() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.379 -0400", hash_original_method = "C13053467D6FDF772DF450C87D40A3D5", hash_generated_method = "AA1670A7CD49113A50270CF041AF8F41")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean varD1EEFCBD27E28C71EA594EC596966CFD_1566983443 = (containsValue(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return containsValue(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.379 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    private final class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.379 -0400", hash_original_method = "2F953926D7C5D976A09AA3C5A1A35BD1", hash_generated_method = "2F953926D7C5D976A09AA3C5A1A35BD1")
                public EntrySet ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.379 -0400", hash_original_method = "D7164BC97FFDCB587AB273006C953E50", hash_generated_method = "7332845EE8406D19BEA32A08C9EF709E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> var153372D521AAB89DE882AC552CFDD732_1218888218 = (newEntryIterator());
            return (Iterator<Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return newEntryIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.379 -0400", hash_original_method = "6E695F138E29D844DC896198513B6135", hash_generated_method = "4D9699B908909212A9B035FD1D5A4D1D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varEC3A3E183CD0A7D33A5B45EDAE091B2E_544613961 = (containsMapping(e.getKey(), e.getValue()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return containsMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.379 -0400", hash_original_method = "F484CBC8566C601718EDE0034034C7B3", hash_generated_method = "C194FAD2FBA5269F882911D34C44DEFE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean remove(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Entry<?, ?> e;
            e = (Entry<?, ?>)o;
            boolean var598A216136B4C4D06069F46B6EC81DD9_1604633027 = (removeMapping(e.getKey(), e.getValue()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>)o;
            //return removeMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.379 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "5952D8F6ECECE9C90DA6440092EF19A0")
        @DSModeled(DSC.SAFE)
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.380 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "B02D7658F0824D0869C92F4AD19DB19E")
        @DSModeled(DSC.SAFE)
        public boolean isEmpty() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.380 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    private static final int MINIMUM_CAPACITY = 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final Entry[] EMPTY_TABLE
            = new HashMapEntry[MINIMUM_CAPACITY >>> 1];
    static final float DEFAULT_LOAD_FACTOR = .75F;
    private static final long serialVersionUID = 362498820763181265L;
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("loadFactor", float.class)
    };
}


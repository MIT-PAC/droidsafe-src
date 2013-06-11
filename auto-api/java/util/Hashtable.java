package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

public class Hashtable<K, V> extends Dictionary<K, V> implements Map<K, V>, Cloneable, Serializable {
    private static final int MINIMUM_CAPACITY = 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final Entry[] EMPTY_TABLE
            = new HashtableEntry[MINIMUM_CAPACITY >>> 1];
    private static final float DEFAULT_LOAD_FACTOR = .75F;
    private transient HashtableEntry<K, V>[] table;
    private transient int size;
    private transient int modCount;
    private transient int threshold;
    private transient Set<K> keySet;
    private transient Set<Entry<K, V>> entrySet;
    private transient Collection<V> values;
    private static final int CHARS_PER_ENTRY = 15;
    private static final long serialVersionUID = 1421746759512286392L;
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("threshold", int.class),
        new ObjectStreamField("loadFactor", float.class),
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.437 -0400", hash_original_method = "9A93999031A29C4DD8DE295A6372F847", hash_generated_method = "AE3027308D92464F1AF368BC37E776A6")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public Hashtable() {
        table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1;
        // ---------- Original Method ----------
        //table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.437 -0400", hash_original_method = "6003D4D798348C1583CB15DE42C187C6", hash_generated_method = "81D631A568F2F62C265A61ADBDFD41F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Hashtable(int capacity) {
        dsTaint.addTaint(capacity);
        {
            throw new IllegalArgumentException("Capacity: " + capacity);
        } //End block
        {
            @SuppressWarnings("unchecked") HashtableEntry<K, V>[] tab;
            tab = (HashtableEntry<K, V>[]) EMPTY_TABLE;
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
            //HashtableEntry<K, V>[] tab = (HashtableEntry<K, V>[]) EMPTY_TABLE;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.438 -0400", hash_original_method = "5B6B569F078844A0FAD42909C56D1E6D", hash_generated_method = "1C9BAA879D622A947157F0654C64A428")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Hashtable(int capacity, float loadFactor) {
        this(capacity);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
        {
            boolean var7E96777C74EA86B66256F7B00F5AE961_300576477 = (loadFactor <= 0 || Float.isNaN(loadFactor));
            {
                throw new IllegalArgumentException("Load factor: " + loadFactor);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            //throw new IllegalArgumentException("Load factor: " + loadFactor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.438 -0400", hash_original_method = "6950B91F5E6C68C49CB594AFD1673B84", hash_generated_method = "6D6EE99F8AA36750A7EFD68FCCB041A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Hashtable(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        dsTaint.addTaint(map.dsTaint);
        constructorPutAll(map);
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.438 -0400", hash_original_method = "6631235722E4D3190E3529D2039DDD7A", hash_generated_method = "8E2ACCB1C0DEB8CDB93C555112234A1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void constructorPutAll(Map<? extends K, ? extends V> map) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.438 -0400", hash_original_method = "D3652F5150C5AE281EEFD951292F69EA", hash_generated_method = "B61374A142BDE93B582D58738DEFC2D1")
    private static int capacityForInitSize(int size) {
        int result = (size >> 1) + size;
        return (result & ~(MAXIMUM_CAPACITY-1))==0 ? result : MAXIMUM_CAPACITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.438 -0400", hash_original_method = "F0D9AD485DB15C1D3427CA487C88BFBD", hash_generated_method = "A3E88882BF59CCA0424DFE9E1F2A84C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public synchronized Object clone() {
        Hashtable<K, V> result;
        try 
        {
            result = (Hashtable<K, V>) super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError(e);
        } //End block
        result.makeTable(table.length);
        result.size = 0;
        result.keySet = null;
        result.entrySet = null;
        result.values = null;
        result.constructorPutAll(this);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Hashtable<K, V> result;
        //try {
            //result = (Hashtable<K, V>) super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
        //result.makeTable(table.length);
        //result.size = 0;
        //result.keySet = null;
        //result.entrySet = null;
        //result.values = null;
        //result.constructorPutAll(this);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.438 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "66007FC4E39D50DACF31306163F4D9BF")
    @DSModeled(DSC.SAFE)
    public synchronized boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.438 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "1583699642C1723080C132104BF7CD5F")
    @DSModeled(DSC.SAFE)
    public synchronized int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.438 -0400", hash_original_method = "0D498A226869DEB0F3920DC31F67162F", hash_generated_method = "0D6CC52DBAFB2805E3614B2A4A25EC33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized V get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        int hash;
        hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashtableEntry<K, V>[] tab;
        tab = table;
        {
            HashtableEntry<K, V> e;
            e = tab[hash & (tab.length - 1)];
            e = e.next;
            {
                K eKey;
                eKey = e.key;
                {
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_873950038 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int hash = key.hashCode();
        //hash ^= (hash >>> 20) ^ (hash >>> 12);
        //hash ^= (hash >>> 7) ^ (hash >>> 4);
        //HashtableEntry<K, V>[] tab = table;
        //for (HashtableEntry<K, V> e = tab[hash & (tab.length - 1)];
                //e != null; e = e.next) {
            //K eKey = e.key;
            //if (eKey == key || (e.hash == hash && key.equals(eKey))) {
                //return e.value;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.438 -0400", hash_original_method = "EDC536266386E3A88DC2FA7B05BC7882", hash_generated_method = "2E93928076275EC3A44F5921371B5D69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        int hash;
        hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashtableEntry<K, V>[] tab;
        tab = table;
        {
            HashtableEntry<K, V> e;
            e = tab[hash & (tab.length - 1)];
            e = e.next;
            {
                K eKey;
                eKey = e.key;
                {
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_1748465261 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int hash = key.hashCode();
        //hash ^= (hash >>> 20) ^ (hash >>> 12);
        //hash ^= (hash >>> 7) ^ (hash >>> 4);
        //HashtableEntry<K, V>[] tab = table;
        //for (HashtableEntry<K, V> e = tab[hash & (tab.length - 1)];
                //e != null; e = e.next) {
            //K eKey = e.key;
            //if (eKey == key || (e.hash == hash && key.equals(eKey))) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.438 -0400", hash_original_method = "22B2A1F3D878FCC53A2BA6539B84615E", hash_generated_method = "7ADBE335DC3525C757F260487B0F3289")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        HashtableEntry[] tab;
        tab = table;
        int len;
        len = tab.length;
        {
            int i;
            i = 0;
            {
                {
                    HashtableEntry e;
                    e = tab[i];
                    e = e.next;
                    {
                        {
                            boolean varB228932AA07990623CC3C29EF03F40DA_384020077 = (value.equals(e.value));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //HashtableEntry[] tab = table;
        //int len = tab.length;
        //for (int i = 0; i < len; i++) {
            //for (HashtableEntry e = tab[i]; e != null; e = e.next) {
                //if (value.equals(e.value)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.439 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "05C361F9DB81B7595A2413E78C70BA62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object value) {
        dsTaint.addTaint(value.dsTaint);
        boolean var9D0C71166B134CB9FEA4F5814A8E4863_556306566 = (containsValue(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.439 -0400", hash_original_method = "70A37B9812099DB6AA6597919714B995", hash_generated_method = "0D0B58708F57DA5367B2CA3B533C284B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        int hash;
        hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab;
        tab = table;
        int index;
        index = hash & (tab.length - 1);
        HashtableEntry<K, V> first;
        first = tab[index];
        {
            HashtableEntry<K, V> e;
            e = first;
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_160110778 = (e.hash == hash && key.equals(e.key));
                    {
                        V oldValue;
                        oldValue = e.value;
                        e.value = value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        modCount++;
        {
            rehash();
            tab = doubleCapacity();
            index = hash & (tab.length - 1);
            first = tab[index];
        } //End block
        tab[index] = new HashtableEntry<K, V>(key, value, hash, first);
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //int hash = secondaryHash(key.hashCode());
        //HashtableEntry<K, V>[] tab = table;
        //int index = hash & (tab.length - 1);
        //HashtableEntry<K, V> first = tab[index];
        //for (HashtableEntry<K, V> e = first; e != null; e = e.next) {
            //if (e.hash == hash && key.equals(e.key)) {
                //V oldValue = e.value;
                //e.value = value;
                //return oldValue;
            //}
        //}
        //modCount++;
        //if (size++ > threshold) {
            //rehash();  
            //tab = doubleCapacity();
            //index = hash & (tab.length - 1);
            //first = tab[index];
        //}
        //tab[index] = new HashtableEntry<K, V>(key, value, hash, first);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.439 -0400", hash_original_method = "DD29A5E73441E57ACE3C1AF694856AF1", hash_generated_method = "EBF2E32E34425BB3E3CC9606774A2302")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void constructorPut(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        int hash;
        hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab;
        tab = table;
        int index;
        index = hash & (tab.length - 1);
        HashtableEntry<K, V> first;
        first = tab[index];
        {
            HashtableEntry<K, V> e;
            e = first;
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_2087801637 = (e.hash == hash && key.equals(e.key));
                    {
                        e.value = value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        tab[index] = new HashtableEntry<K, V>(key, value, hash, first);
        size++;
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //int hash = secondaryHash(key.hashCode());
        //HashtableEntry<K, V>[] tab = table;
        //int index = hash & (tab.length - 1);
        //HashtableEntry<K, V> first = tab[index];
        //for (HashtableEntry<K, V> e = first; e != null; e = e.next) {
            //if (e.hash == hash && key.equals(e.key)) {
                //e.value = value;
                //return;
            //}
        //}
        //tab[index] = new HashtableEntry<K, V>(key, value, hash, first);
        //size++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.439 -0400", hash_original_method = "46C920EF16234ECC2EBDE62DDADD6435", hash_generated_method = "C2A9B93222B52C8965A388E2FEB00266")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void putAll(Map<? extends K, ? extends V> map) {
        dsTaint.addTaint(map.dsTaint);
        ensureCapacity(map.size());
        {
             map.entrySet().iterator().hasNext();
            Entry<? extends K, ? extends V> e = map.entrySet().iterator().next();
            {
                put(e.getKey(), e.getValue());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //ensureCapacity(map.size());
        //for (Entry<? extends K, ? extends V> e : map.entrySet()) {
            //put(e.getKey(), e.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.439 -0400", hash_original_method = "5BCC94324BA2D5ECBED6314BEA7D0FA8", hash_generated_method = "DB4CA5527F03A6D0C4CA114D7F9D2746")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureCapacity(int numMappings) {
        dsTaint.addTaint(numMappings);
        int newCapacity;
        newCapacity = roundUpToPowerOfTwo(capacityForInitSize(numMappings));
        HashtableEntry<K, V>[] oldTable;
        oldTable = table;
        int oldCapacity;
        oldCapacity = oldTable.length;
        rehash();
        {
            doubleCapacity();
        } //End block
        HashtableEntry<K, V>[] newTable;
        newTable = makeTable(newCapacity);
        {
            int newMask;
            newMask = newCapacity - 1;
            {
                int i;
                i = 0;
                {
                    {
                        HashtableEntry<K, V> e;
                        e = oldTable[i];
                        {
                            HashtableEntry<K, V> oldNext;
                            oldNext = e.next;
                            int newIndex;
                            newIndex = e.hash & newMask;
                            HashtableEntry<K, V> newNext;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.439 -0400", hash_original_method = "CC28673E29B73787492CFDC805600F5D", hash_generated_method = "C3A9DC41EA396B1D713FB22D93DE937A")
    @DSModeled(DSC.SAFE)
    protected void rehash() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.439 -0400", hash_original_method = "8FDFD015009EFB98FD90E5E66F0193AF", hash_generated_method = "28467CDF76DE50FD6846DC82FC188B5F")
    @DSModeled(DSC.SAFE)
    private HashtableEntry<K, V>[] makeTable(int newCapacity) {
        dsTaint.addTaint(newCapacity);
        @SuppressWarnings("unchecked") HashtableEntry<K, V>[] newTable;
        newTable = (HashtableEntry<K, V>[]) new HashtableEntry[newCapacity];
        table = newTable;
        threshold = (newCapacity >> 1) + (newCapacity >> 2);
        return (HashtableEntry<K, V>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked") HashtableEntry<K, V>[] newTable
                //= (HashtableEntry<K, V>[]) new HashtableEntry[newCapacity];
        //table = newTable;
        //threshold = (newCapacity >> 1) + (newCapacity >> 2);
        //return newTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.440 -0400", hash_original_method = "291B56F25D1E56D0A03492C2073BE506", hash_generated_method = "C75A8C6A7CE95732FE78A93AF8953EA6")
    @DSModeled(DSC.SAFE)
    private HashtableEntry<K, V>[] doubleCapacity() {
        HashtableEntry<K, V>[] oldTable;
        oldTable = table;
        int oldCapacity;
        oldCapacity = oldTable.length;
        int newCapacity;
        newCapacity = oldCapacity * 2;
        HashtableEntry<K, V>[] newTable;
        newTable = makeTable(newCapacity);
        {
            int j;
            j = 0;
            {
                HashtableEntry<K, V> e;
                e = oldTable[j];
                int highBit;
                highBit = e.hash & oldCapacity;
                HashtableEntry<K, V> broken;
                broken = null;
                newTable[j | highBit] = e;
                {
                    HashtableEntry<K,V> n;
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
        return (HashtableEntry<K, V>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.440 -0400", hash_original_method = "B19FA41811C96CC39A17F943778772D8", hash_generated_method = "958C1B1B34489D55CE5178889CC7BAA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized V remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        int hash;
        hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab;
        tab = table;
        int index;
        index = hash & (tab.length - 1);
        {
            HashtableEntry<K, V> e, prev;
            e = tab[index];
            prev = null;
            prev = e;
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_612367813 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            tab[index] = e.next;
                        } //End block
                        {
                            prev.next = e.next;
                        } //End block
                        modCount++;
                        size--;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int hash = secondaryHash(key.hashCode());
        //HashtableEntry<K, V>[] tab = table;
        //int index = hash & (tab.length - 1);
        //for (HashtableEntry<K, V> e = tab[index], prev = null;
                //e != null; prev = e, e = e.next) {
            //if (e.hash == hash && key.equals(e.key)) {
                //if (prev == null) {
                    //tab[index] = e.next;
                //} else {
                    //prev.next = e.next;
                //}
                //modCount++;
                //size--;
                //return e.value;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.440 -0400", hash_original_method = "1C0D329A7E5E91219CE97B2AC82E739C", hash_generated_method = "26E261D588E147EF3ED47C35DEC7A85F")
    @DSModeled(DSC.SAFE)
    public synchronized void clear() {
        {
            Arrays.fill(table, null);
            modCount++;
            size = 0;
        } //End block
        // ---------- Original Method ----------
        //if (size != 0) {
            //Arrays.fill(table, null);
            //modCount++;
            //size = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.440 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "585E192EAF3B08D74F70CBA5857169EB")
    @DSModeled(DSC.SAFE)
    public synchronized Set<K> keySet() {
        Set<K> ks;
        ks = keySet;
        return (Set<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.440 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "FE788EF05B81CFFC5626BDC749185C38")
    @DSModeled(DSC.SAFE)
    public synchronized Collection<V> values() {
        Collection<V> vs;
        vs = values;
        return (Collection<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.440 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "59568352AB71923D1365472122831303")
    @DSModeled(DSC.SAFE)
    public synchronized Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> es;
        es = entrySet;
        return (Set<Entry<K, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.440 -0400", hash_original_method = "BD8590C2A6B44E1AD87F42CA1DDBEEC0", hash_generated_method = "72D1CDB6E1018CB04471B2D6E32A0B47")
    @DSModeled(DSC.SAFE)
    public synchronized Enumeration<K> keys() {
        return (Enumeration<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new KeyEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.440 -0400", hash_original_method = "D92B3AB4F78D152BCFDB4F438052384E", hash_generated_method = "56AA30161E5D30E4CD36369906FB4658")
    @DSModeled(DSC.SAFE)
    public synchronized Enumeration<V> elements() {
        return (Enumeration<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ValueEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.440 -0400", hash_original_method = "CF57466F07C2DB8AF5EFB522D22E3680", hash_generated_method = "602088420D8DC9C7FA95E574AF92F3B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean containsMapping(Object key, Object value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        int hash;
        hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab;
        tab = table;
        int index;
        index = hash & (tab.length - 1);
        {
            HashtableEntry<K, V> e;
            e = tab[index];
            e = e.next;
            {
                {
                    boolean varBF092BC27A863E23FE4C44D225ED1FDA_1973344394 = (e.hash == hash && e.key.equals(key));
                    {
                        boolean var6C13353AEE37EBEED16BB037A146133C_1192132995 = (e.value.equals(value));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int hash = secondaryHash(key.hashCode());
        //HashtableEntry<K, V>[] tab = table;
        //int index = hash & (tab.length - 1);
        //for (HashtableEntry<K, V> e = tab[index]; e != null; e = e.next) {
            //if (e.hash == hash && e.key.equals(key)) {
                //return e.value.equals(value);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.441 -0400", hash_original_method = "A191738781408606E816E9A37080097D", hash_generated_method = "E19B7BCF6D6E33996898BF63C248EF9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized boolean removeMapping(Object key, Object value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        int hash;
        hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab;
        tab = table;
        int index;
        index = hash & (tab.length - 1);
        {
            HashtableEntry<K, V> e, prev;
            e = tab[index];
            prev = null;
            prev = e;
            e = e.next;
            {
                {
                    boolean varBF092BC27A863E23FE4C44D225ED1FDA_192656513 = (e.hash == hash && e.key.equals(key));
                    {
                        {
                            boolean var876C169E101ABBE81C5DB09387C8C08C_284933564 = (!e.value.equals(value));
                        } //End collapsed parenthetic
                        {
                            tab[index] = e.next;
                        } //End block
                        {
                            prev.next = e.next;
                        } //End block
                        modCount++;
                        size--;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int hash = secondaryHash(key.hashCode());
        //HashtableEntry<K, V>[] tab = table;
        //int index = hash & (tab.length - 1);
        //for (HashtableEntry<K, V> e = tab[index], prev = null;
                //e != null; prev = e, e = e.next) {
            //if (e.hash == hash && e.key.equals(key)) {
                //if (!e.value.equals(value)) {
                    //return false;  
                //}
                //if (prev == null) {
                    //tab[index] = e.next;
                //} else {
                    //prev.next = e.next;
                //}
                //modCount++;
                //size--;
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.441 -0400", hash_original_method = "9BC17AC5DA957A9C0A07708C3D3A3E68", hash_generated_method = "D5FA76043DB7EADB5C458208760A70F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varF1443A15804B24DDE99B981E7E34D8C9_1432217908 = ((object instanceof Map) &&
                entrySet().equals(((Map<?, ?>)object).entrySet()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object instanceof Map) &&
                //entrySet().equals(((Map<?, ?>)object).entrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.441 -0400", hash_original_method = "0904BEF2CA25AF4229493E32A4F8928E", hash_generated_method = "B156357C1CE360C31F2A911C5EF4764D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int hashCode() {
        int result;
        result = 0;
        {
            Iterator<Entry<K, V>> seatecAstronomy42 = entrySet().iterator();
            seatecAstronomy42.hasNext();
            Entry<K, V> e = seatecAstronomy42.next();
            {
                K key;
                key = e.getKey();
                V value;
                value = e.getValue();
                result += (key != null ? key.hashCode() : 0)
                    ^ (value != null ? value.hashCode() : 0);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = 0;
        //for (Entry<K, V> e : entrySet()) {
            //K key = e.getKey();
            //V value = e.getValue();
            //if (key == this || value == this) {
                //continue;
            //}
            //result += (key != null ? key.hashCode() : 0)
                    //^ (value != null ? value.hashCode() : 0);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.441 -0400", hash_original_method = "A78197C1027A9ECA0DF472B01066EEE7", hash_generated_method = "28F396FCFD4AF64F1BF832870D47F500")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized String toString() {
        StringBuilder result;
        result = new StringBuilder(CHARS_PER_ENTRY * size);
        result.append('{');
        Iterator<Entry<K, V>> i;
        i = entrySet().iterator();
        boolean hasMore;
        hasMore = i.hasNext();
        {
            Entry<K, V> entry;
            entry = i.next();
            K key;
            key = entry.getKey();
            result.append(key == this ? "(this Map)" : key.toString());
            result.append('=');
            V value;
            value = entry.getValue();
            result.append(value == this ? "(this Map)" : value.toString());
            {
                boolean var41667EFB1D4E18743BE89148FA51235C_863344496 = (hasMore = i.hasNext());
                {
                    result.append(", ");
                } //End block
            } //End collapsed parenthetic
        } //End block
        result.append('}');
        String varEA70154FDA28CC59402440C6317B57EF_123191238 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(CHARS_PER_ENTRY * size);
        //result.append('{');
        //Iterator<Entry<K, V>> i = entrySet().iterator();
        //boolean hasMore = i.hasNext();
        //while (hasMore) {
            //Entry<K, V> entry = i.next();
            //K key = entry.getKey();
            //result.append(key == this ? "(this Map)" : key.toString());
            //result.append('=');
            //V value = entry.getValue();
            //result.append(value == this ? "(this Map)" : value.toString());
            //if (hasMore = i.hasNext()) {
                //result.append(", ");
            //}
        //}
        //result.append('}');
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.441 -0400", hash_original_method = "EB10FD63A8403F00F4E59BED9E510DF9", hash_generated_method = "A7B2F3BD014C30B08BADDE8833C4A221")
    private static int secondaryHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.441 -0400", hash_original_method = "2E3FAB2711A493998A5CD02CF97D3862", hash_generated_method = "20636B0D75DF5604A849BEC9C39C4E70")
    private static int roundUpToPowerOfTwo(int i) {
        i--;
        i |= i >>>  1;
        i |= i >>>  2;
        i |= i >>>  4;
        i |= i >>>  8;
        i |= i >>> 16;
        return i + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.441 -0400", hash_original_method = "19818AA4E6F1DBA67EBB75B368743917", hash_generated_method = "BE51A41CD3B0809B8671F51E54648715")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("threshold",  (int) (DEFAULT_LOAD_FACTOR * table.length));
        fields.put("loadFactor", DEFAULT_LOAD_FACTOR);
        stream.writeFields();
        stream.writeInt(table.length);
        stream.writeInt(size);
        {
            Iterator<Entry<K, V>> seatecAstronomy42 = entrySet().iterator();
            seatecAstronomy42.hasNext();
            Entry<K, V> e = seatecAstronomy42.next();
            {
                stream.writeObject(e.getKey());
                stream.writeObject(e.getValue());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //ObjectOutputStream.PutField fields = stream.putFields();
        //fields.put("threshold",  (int) (DEFAULT_LOAD_FACTOR * table.length));
        //fields.put("loadFactor", DEFAULT_LOAD_FACTOR);
        //stream.writeFields();
        //stream.writeInt(table.length);
        //stream.writeInt(size);
        //for (Entry<K, V> e : entrySet()) {
            //stream.writeObject(e.getKey());
            //stream.writeObject(e.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.441 -0400", hash_original_method = "2EADB0DA3622DE13512805CD17FDFE7A", hash_generated_method = "83F403F13BBAFEF402E129A5EAD16417")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultReadObject();
        int capacity;
        capacity = stream.readInt();
        {
            throw new InvalidObjectException("Capacity: " + capacity);
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
            throw new InvalidObjectException("Size: " + size);
        } //End block
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

    
    private static class HashtableEntry<K, V> implements Entry<K, V> {
        final K key;
        V value;
        final int hash;
        HashtableEntry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.442 -0400", hash_original_method = "FCC59894C2665A76D7100104D46402EE", hash_generated_method = "16D1062D1432A9122B3FDEF21EAF61E8")
        @DSModeled(DSC.SAFE)
         HashtableEntry(K key, V value, int hash, HashtableEntry<K, V> next) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.442 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "62DC5773B0857090D60E1A39AA6F6DAD")
        @DSModeled(DSC.SAFE)
        public final K getKey() {
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.442 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "E67AD041E8C2943FCEE279A3164AFEC2")
        @DSModeled(DSC.SAFE)
        public final V getValue() {
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.442 -0400", hash_original_method = "09EE506DF55191FF6B72960EEA25D181", hash_generated_method = "3FFB8D2BA61059D0B71DF72846073114")
        @DSModeled(DSC.SAFE)
        public final V setValue(V value) {
            dsTaint.addTaint(value.dsTaint);
            {
                throw new NullPointerException();
            } //End block
            V oldValue;
            oldValue = this.value;
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (value == null) {
                //throw new NullPointerException();
            //}
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.442 -0400", hash_original_method = "509D67FA76563438156B3275F90914F5", hash_generated_method = "FAE435C4794886BCB7C03E4089A01058")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public final boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varE09B45BE378FDDE1749CF5314C9B65A1_1636211668 = (key.equals(e.getKey()) && value.equals(e.getValue()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return key.equals(e.getKey()) && value.equals(e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.442 -0400", hash_original_method = "28D407F854479314A0A7C3BE1F12A9AB", hash_generated_method = "B1686284DB94AC656183FEB539B9791A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public final int hashCode() {
            int varCC7293A69A74489DFEF0094B17563C76_1915288594 = (key.hashCode() ^ value.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return key.hashCode() ^ value.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.442 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "CE0DC8014C1CF39AB481A576F2E1AA38")
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
        HashtableEntry<K, V> nextEntry;
        HashtableEntry<K, V> lastEntryReturned;
        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.442 -0400", hash_original_method = "1BB35CB0E7E6DF7A5633A61B0F63C5AA", hash_generated_method = "CB19291E51F84CC975834E1EBF571764")
        @DSModeled(DSC.SAFE)
         HashIterator() {
            HashtableEntry<K, V>[] tab;
            tab = table;
            HashtableEntry<K, V> next;
            next = null;
            {
                next = tab[nextIndex++];
            } //End block
            nextEntry = next;
            // ---------- Original Method ----------
            //HashtableEntry<K, V>[] tab = table;
            //HashtableEntry<K, V> next = null;
            //while (next == null && nextIndex < tab.length) {
                //next = tab[nextIndex++];
            //}
            //nextEntry = next;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.442 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "DF473530490CCCE1C8649D2C81D780C3")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.442 -0400", hash_original_method = "5FA6641462F5564CAC982C4AF6FCFB6C", hash_generated_method = "CF14FA4E2EA7CC741223A59B97BFF53A")
        @DSModeled(DSC.SAFE)
         HashtableEntry<K, V> nextEntry() {
            throw new ConcurrentModificationException();
            throw new NoSuchElementException();
            HashtableEntry<K, V> entryToReturn;
            entryToReturn = nextEntry;
            HashtableEntry<K, V>[] tab;
            tab = table;
            HashtableEntry<K, V> next;
            next = entryToReturn.next;
            {
                next = tab[nextIndex++];
            } //End block
            nextEntry = next;
            HashtableEntry<K, V> varE716D0B9837917675A560095A2F6354C_1853918454 = (lastEntryReturned = entryToReturn);
            return (HashtableEntry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (modCount != expectedModCount)
                //throw new ConcurrentModificationException();
            //if (nextEntry == null)
                //throw new NoSuchElementException();
            //HashtableEntry<K, V> entryToReturn = nextEntry;
            //HashtableEntry<K, V>[] tab = table;
            //HashtableEntry<K, V> next = entryToReturn.next;
            //while (next == null && nextIndex < tab.length) {
                //next = tab[nextIndex++];
            //}
            //nextEntry = next;
            //return lastEntryReturned = entryToReturn;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.442 -0400", hash_original_method = "1C3D72122BB58702CE822C81122C0D27", hash_generated_method = "66495A466B656DB98EBD25ED97F4331A")
        @DSModeled(DSC.SAFE)
         HashtableEntry<K, V> nextEntryNotFailFast() {
            throw new NoSuchElementException();
            HashtableEntry<K, V> entryToReturn;
            entryToReturn = nextEntry;
            HashtableEntry<K, V>[] tab;
            tab = table;
            HashtableEntry<K, V> next;
            next = entryToReturn.next;
            {
                next = tab[nextIndex++];
            } //End block
            nextEntry = next;
            HashtableEntry<K, V> varE716D0B9837917675A560095A2F6354C_1645606050 = (lastEntryReturned = entryToReturn);
            return (HashtableEntry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (nextEntry == null)
                //throw new NoSuchElementException();
            //HashtableEntry<K, V> entryToReturn = nextEntry;
            //HashtableEntry<K, V>[] tab = table;
            //HashtableEntry<K, V> next = entryToReturn.next;
            //while (next == null && nextIndex < tab.length) {
                //next = tab[nextIndex++];
            //}
            //nextEntry = next;
            //return lastEntryReturned = entryToReturn;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.442 -0400", hash_original_method = "342FDC52CA82B385D96AADB83EE8F936", hash_generated_method = "5240F1890F1D528C967E8B10ECC9EF81")
        @DSModeled(DSC.SAFE)
        public void remove() {
            throw new IllegalStateException();
            throw new ConcurrentModificationException();
            Hashtable.this.remove(lastEntryReturned.key);
            lastEntryReturned = null;
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //if (lastEntryReturned == null)
                //throw new IllegalStateException();
            //if (modCount != expectedModCount)
                //throw new ConcurrentModificationException();
            //Hashtable.this.remove(lastEntryReturned.key);
            //lastEntryReturned = null;
            //expectedModCount = modCount;
        }

        
    }


    
    private final class KeyIterator extends HashIterator implements Iterator<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "990236266A0CC922F5F5C7F35DEE2E4D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K next() {
            K var0826C92B2F2C6B3475D8BF572E4E70AE_2053416071 = (nextEntry().key);
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends HashIterator implements Iterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "553656D57446A64135875343081E0CBF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public V next() {
            V var551184D8EC6DFD9474BC6F4F9A2CB7F7_130684618 = (nextEntry().value);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "C7E2B840B075445DC1033B130AB2E6A6", hash_generated_method = "3AC110D72D327B06ED893D65312F0B55")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> next() {
            Entry<K, V> varFDACBEE1E52798928B8D0EBEA13DBC12_2105257542 = (nextEntry());
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private final class KeyEnumeration extends HashIterator implements Enumeration<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "1EA8AD3FC464F9DDDDA908BB6B552F97")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_196631911 = (hasNext());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "BED82438F0CBBB90FF7803670DD55802", hash_generated_method = "8B891F826E73BC63892968650085DEE4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K nextElement() {
            K varED0D07A4A50EC193BECB36F8B21B708D_440682807 = (nextEntryNotFailFast().key);
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().key;
        }

        
    }


    
    private final class ValueEnumeration extends HashIterator implements Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "225B76CFE41FB1D0A6F86AD128BC009D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_1743746946 = (hasNext());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "433328C2A0882CA6574B6B21E730CA05", hash_generated_method = "2002B768E58FE077FD228812CA769AC9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public V nextElement() {
            V var3323A15378AB29A460328ED110B9E5BD_980975139 = (nextEntryNotFailFast().value);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().value;
        }

        
    }


    
    private final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "AFDD38ADCC30897A9F883887A548098E")
        @DSModeled(DSC.SAFE)
        public Iterator<K> iterator() {
            return (Iterator<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new KeyIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "18350B0472B74C006FA05F034C1DAF85")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_1168451002 = (Hashtable.this.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "7A43207ECCB4C707157F6179A2E84B00")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean var997BAB39B2F072D5CD66A271F3B6E196_137453283 = (containsKey(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "FF159DEBFD9D37DD2EC80383AA98B734", hash_generated_method = "D4D35893EA429019CDEBEBB18E76FDA1")
        @DSModeled(DSC.SAFE)
        public boolean remove(Object o) {
            dsTaint.addTaint(o.dsTaint);
            {
                int oldSize;
                oldSize = size;
                Hashtable.this.remove(o);
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //int oldSize = size;
                //Hashtable.this.remove(o);
                //return size != oldSize;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "A5EA77A83DE5A1B85559523CBD8F0C8C")
        @DSModeled(DSC.SAFE)
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "1C32F01A0F66C9AE9AB9E3B87F3A25E5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var58AE03DF73A4D12F601C955635C96F4B_173815122 = (super.removeAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "E6489F04D9DEACF3795CBDD225EB4994")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var3255E4A0EFB9EAA451138C6BB0926616_1399043289 = (super.retainAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "B547791C4C8500992F783059EF2E8E90")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var79EF5D55440F889A4F23742E0DEB4B9E_1025848513 = (super.containsAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "E75752F31CC44EE4E07186CE32194E18")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var5F3224CFE728C1743180B4BAE5039FE5_1495666610 = (super.equals(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.443 -0400", hash_original_method = "2EB37718E343BC9663B783B0FC3BE747", hash_generated_method = "87729526EC9975EA704409D28E1A5136")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int hashCode() {
            {
                int var672EFE3D50C5368A35AD3BD6AA18947C_594594473 = (super.hashCode());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "1C61739354996899AAD417BFADE2335A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            {
                String varF45A451555C5FF491E4319B524E3196B_677480220 = (super.toString());
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "26D957958E253755F1FB97A339065B8B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object[] toArray() {
            {
                Object[] varDD446D0A183C5CF0D3A3E96A06EA864C_1753330391 = (super.toArray());
            } //End block
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "32F96439660144EADD2941F66F07D15F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T[] toArray(T[] a) {
            dsTaint.addTaint(a.dsTaint);
            {
                T[] var74CFC86FF606F1E8E5731D501890BE99_1421014284 = (super.toArray(a));
            } //End block
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "37EBB56C40C2F1778FC125B53C28357F")
        @DSModeled(DSC.SAFE)
        public Iterator<V> iterator() {
            return (Iterator<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ValueIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "424306BB22CDE51E914005704E4B3FB1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_1423684103 = (Hashtable.this.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "C13053467D6FDF772DF450C87D40A3D5", hash_generated_method = "1109469012A775A42C39E831C90389AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean varD1EEFCBD27E28C71EA594EC596966CFD_517259445 = (containsValue(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return containsValue(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "A5EA77A83DE5A1B85559523CBD8F0C8C")
        @DSModeled(DSC.SAFE)
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "DBA319F8558990F5935E36C182CFB4D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var79EF5D55440F889A4F23742E0DEB4B9E_1559743210 = (super.containsAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "B3368E498308F3B1AB26C79A29DF68DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            {
                String varF45A451555C5FF491E4319B524E3196B_1877150554 = (super.toString());
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "A7EEF475BBA1D92AD4D04585CCB50718")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object[] toArray() {
            {
                Object[] varDD446D0A183C5CF0D3A3E96A06EA864C_1910601175 = (super.toArray());
            } //End block
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "7F45CA1806EDCB066AE42EBB7710908D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T[] toArray(T[] a) {
            dsTaint.addTaint(a.dsTaint);
            {
                T[] var74CFC86FF606F1E8E5731D501890BE99_124300587 = (super.toArray(a));
            } //End block
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "D7164BC97FFDCB587AB273006C953E50", hash_generated_method = "26A9659C32000EFDF82D5A5C1982204D")
        @DSModeled(DSC.SAFE)
        public Iterator<Entry<K, V>> iterator() {
            return (Iterator<Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new EntryIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "6E695F138E29D844DC896198513B6135", hash_generated_method = "35B2D2564663794070EF462A4FCB2AB7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varEC3A3E183CD0A7D33A5B45EDAE091B2E_1206306955 = (containsMapping(e.getKey(), e.getValue()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return containsMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "F484CBC8566C601718EDE0034034C7B3", hash_generated_method = "13E27AED03AA94D723F1487940C817C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean remove(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Entry<?, ?> e;
            e = (Entry<?, ?>)o;
            boolean var598A216136B4C4D06069F46B6EC81DD9_1689766961 = (removeMapping(e.getKey(), e.getValue()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>)o;
            //return removeMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "6A651F2D299810FB5F6B87A9A934EC84")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_1748484333 = (Hashtable.this.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "A5EA77A83DE5A1B85559523CBD8F0C8C")
        @DSModeled(DSC.SAFE)
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "FD9B586EFCA8F92F4BC1AD58B8A0B751")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var58AE03DF73A4D12F601C955635C96F4B_917160518 = (super.removeAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.444 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "99F5AA163686D1B989C366047D28FE9C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var3255E4A0EFB9EAA451138C6BB0926616_491225503 = (super.retainAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.445 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "F1247CA78DAC9A29219BC3E258E0B272")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean var79EF5D55440F889A4F23742E0DEB4B9E_1961989112 = (super.containsAll(collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.445 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "595FF120D6F59C3B9A081B7DD75B65ED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var5F3224CFE728C1743180B4BAE5039FE5_1364330081 = (super.equals(object));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.445 -0400", hash_original_method = "3000FE237E7845AEAFDA2B41B0704346", hash_generated_method = "9827A3458FE275BC258E196470DEA25B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int hashCode() {
            int var888832939E9A16C553FA6EB5FC57B96E_1613883314 = (Hashtable.this.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Hashtable.this.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.445 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "9804FF5997B181B4312C5299FBE66415")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            {
                String varF45A451555C5FF491E4319B524E3196B_1546727368 = (super.toString());
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.445 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "837E3B1138E22D11827C71ED430ACECE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object[] toArray() {
            {
                Object[] varDD446D0A183C5CF0D3A3E96A06EA864C_2016578342 = (super.toArray());
            } //End block
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.445 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "930D1892CE920FF9F436E7A43BB7C1E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T[] toArray(T[] a) {
            dsTaint.addTaint(a.dsTaint);
            {
                T[] var74CFC86FF606F1E8E5731D501890BE99_1827380498 = (super.toArray(a));
            } //End block
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
}



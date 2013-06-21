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

public class Hashtable<K, V> extends Dictionary<K, V> implements Map<K, V>, Cloneable, Serializable {
    private transient HashtableEntry<K, V>[] table;
    private transient int size;
    private transient int modCount;
    private transient int threshold;
    private transient Set<K> keySet;
    private transient Set<Entry<K, V>> entrySet;
    private transient Collection<V> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.447 -0400", hash_original_method = "9A93999031A29C4DD8DE295A6372F847", hash_generated_method = "6A7170C4C6FFAE127214BE36F7841D7F")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public Hashtable() {
        table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1;
        // ---------- Original Method ----------
        //table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.448 -0400", hash_original_method = "6003D4D798348C1583CB15DE42C187C6", hash_generated_method = "181C53F43FA094223DA8897563D28447")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Hashtable(int capacity) {
        dsTaint.addTaint(capacity);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Capacity: " + capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.448 -0400", hash_original_method = "5B6B569F078844A0FAD42909C56D1E6D", hash_generated_method = "9AFDD372A4DCDE56455E77CB8ACED100")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Hashtable(int capacity, float loadFactor) {
        this(capacity);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
        {
            boolean var7E96777C74EA86B66256F7B00F5AE961_1505762576 = (loadFactor <= 0 || Float.isNaN(loadFactor));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Load factor: " + loadFactor);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            //throw new IllegalArgumentException("Load factor: " + loadFactor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.448 -0400", hash_original_method = "6950B91F5E6C68C49CB594AFD1673B84", hash_generated_method = "06AF3255ED0EE7D4E1D3D919D46B0A8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Hashtable(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        dsTaint.addTaint(map.dsTaint);
        constructorPutAll(map);
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.450 -0400", hash_original_method = "6631235722E4D3190E3529D2039DDD7A", hash_generated_method = "DEE69A01076C45040BD402A80CC5A758")
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

    
        private static int capacityForInitSize(int size) {
        int result = (size >> 1) + size;
        return (result & ~(MAXIMUM_CAPACITY-1))==0 ? result : MAXIMUM_CAPACITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.451 -0400", hash_original_method = "F0D9AD485DB15C1D3427CA487C88BFBD", hash_generated_method = "084D6138B80AF05E44B98D73812C658E")
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
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.451 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "4C75E4108F4EF0DD45284FD161B821E1")
    @DSModeled(DSC.SAFE)
    public synchronized boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.452 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "0E2F088D0B20998022630C90B24A418D")
    @DSModeled(DSC.SAFE)
    public synchronized int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.452 -0400", hash_original_method = "0D498A226869DEB0F3920DC31F67162F", hash_generated_method = "F3D3265D499359B51E6E9FB40BE61B81")
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
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_1713700955 = (eKey == key || (e.hash == hash && key.equals(eKey)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.452 -0400", hash_original_method = "EDC536266386E3A88DC2FA7B05BC7882", hash_generated_method = "A0804561A652849F85384396B3024B87")
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
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_37775505 = (eKey == key || (e.hash == hash && key.equals(eKey)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.453 -0400", hash_original_method = "22B2A1F3D878FCC53A2BA6539B84615E", hash_generated_method = "5AA52466F07716CA068E7CD920A583F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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
                            boolean varB228932AA07990623CC3C29EF03F40DA_296061287 = (value.equals(e.value));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.453 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "E2C7B76A09FE537630168EBE45E94807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object value) {
        dsTaint.addTaint(value.dsTaint);
        boolean var9D0C71166B134CB9FEA4F5814A8E4863_803792746 = (containsValue(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.453 -0400", hash_original_method = "70A37B9812099DB6AA6597919714B995", hash_generated_method = "8C286C822E0943F1D9DDB3D7286741BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_550039959 = (e.hash == hash && key.equals(e.key));
                    {
                        V oldValue;
                        oldValue = e.value;
                        e.value = value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.454 -0400", hash_original_method = "DD29A5E73441E57ACE3C1AF694856AF1", hash_generated_method = "731B75E8655CC76679A6176A86C1BFFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void constructorPut(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1200747860 = (e.hash == hash && key.equals(e.key));
                    {
                        e.value = value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        tab[index] = new HashtableEntry<K, V>(key, value, hash, first);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.456 -0400", hash_original_method = "46C920EF16234ECC2EBDE62DDADD6435", hash_generated_method = "B84F82FBD0BBBFA3BF4AD31EF4ACECF1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.457 -0400", hash_original_method = "5BCC94324BA2D5ECBED6314BEA7D0FA8", hash_generated_method = "40AB0ECF87951D910ED5593C3302E6B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.457 -0400", hash_original_method = "CC28673E29B73787492CFDC805600F5D", hash_generated_method = "E3452D490AF44DF99FFD2B9DFC516DAB")
    @DSModeled(DSC.SAFE)
    protected void rehash() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.457 -0400", hash_original_method = "8FDFD015009EFB98FD90E5E66F0193AF", hash_generated_method = "2760B06A98794C634AD65C3245F8617B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.457 -0400", hash_original_method = "291B56F25D1E56D0A03492C2073BE506", hash_generated_method = "AA18CBDC309A8D7FF8038B5B52819F16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.458 -0400", hash_original_method = "B19FA41811C96CC39A17F943778772D8", hash_generated_method = "508D3E78FDC590AA42C97016A65B3836")
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1061407076 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            tab[index] = e.next;
                        } //End block
                        {
                            prev.next = e.next;
                        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.458 -0400", hash_original_method = "1C0D329A7E5E91219CE97B2AC82E739C", hash_generated_method = "D68A0CADC876BC1431B9C8C9FB2DDE0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void clear() {
        {
            Arrays.fill(table, null);
            size = 0;
        } //End block
        // ---------- Original Method ----------
        //if (size != 0) {
            //Arrays.fill(table, null);
            //modCount++;
            //size = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.458 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "1B614E81D61B185816DB59CD9F2D190C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Set<K> keySet() {
        Set<K> ks;
        ks = keySet;
        {
            Object varB5B77DAF0CA06DFD739ACDEAEEA4B87A_1634563623 = ((keySet = new KeySet()));
        } //End flattened ternary
        return (Set<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.459 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "3AAAB3ABCDA50E0A1B35ACB187836A54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Collection<V> values() {
        Collection<V> vs;
        vs = values;
        {
            Object varA810554C04DFEDF1EF7ED76F9552EC23_861050731 = ((values = new Values()));
        } //End flattened ternary
        return (Collection<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.459 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "E2807434391A588719DA4E0B84EEB699")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> es;
        es = entrySet;
        {
            Object var8EEA31F996A0AE22A7B2AC281EA5A60C_1227120674 = ((entrySet = new EntrySet()));
        } //End flattened ternary
        return (Set<Entry<K, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.459 -0400", hash_original_method = "BD8590C2A6B44E1AD87F42CA1DDBEEC0", hash_generated_method = "63CF4E2296AB10DAB3BF22A78D5035A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Enumeration<K> keys() {
        Enumeration<K> var1774950CE5B50AB22A92B45369CB2EA9_646059779 = (new KeyEnumeration());
        return (Enumeration<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new KeyEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.459 -0400", hash_original_method = "D92B3AB4F78D152BCFDB4F438052384E", hash_generated_method = "30E3F97E62C256BCA6C6A90761BB3172")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Enumeration<V> elements() {
        Enumeration<V> varC6BE002220C06DF2272D9925EB181F6D_459960129 = (new ValueEnumeration());
        return (Enumeration<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ValueEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.460 -0400", hash_original_method = "CF57466F07C2DB8AF5EFB522D22E3680", hash_generated_method = "0A67537F6BC6DBCD8D7D8759024D092B")
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
                    boolean varBF092BC27A863E23FE4C44D225ED1FDA_272185365 = (e.hash == hash && e.key.equals(key));
                    {
                        boolean var6C13353AEE37EBEED16BB037A146133C_1590971816 = (e.value.equals(value));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.460 -0400", hash_original_method = "A191738781408606E816E9A37080097D", hash_generated_method = "063A77E6FAD9B709C41919F6A40F4B52")
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
                    boolean varBF092BC27A863E23FE4C44D225ED1FDA_876100525 = (e.hash == hash && e.key.equals(key));
                    {
                        {
                            boolean var876C169E101ABBE81C5DB09387C8C08C_1012992902 = (!e.value.equals(value));
                        } //End collapsed parenthetic
                        {
                            tab[index] = e.next;
                        } //End block
                        {
                            prev.next = e.next;
                        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.460 -0400", hash_original_method = "9BC17AC5DA957A9C0A07708C3D3A3E68", hash_generated_method = "245A9BC15187E1E9F123DDEFE9C5A604")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varF1443A15804B24DDE99B981E7E34D8C9_1307396577 = ((object instanceof Map) &&
                entrySet().equals(((Map<?, ?>)object).entrySet()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object instanceof Map) &&
                //entrySet().equals(((Map<?, ?>)object).entrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.465 -0400", hash_original_method = "0904BEF2CA25AF4229493E32A4F8928E", hash_generated_method = "643AF82F9555D3FC327E258E4BF9D7F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int hashCode() {
        int result;
        result = 0;
        {
            Iterator<Entry<K, V>> varD93A6471022189C0BA28AFBB8C8557A0_127145674 = (entrySet()).iterator();
            varD93A6471022189C0BA28AFBB8C8557A0_127145674.hasNext();
            Entry<K, V> e = varD93A6471022189C0BA28AFBB8C8557A0_127145674.next();
            {
                K key;
                key = e.getKey();
                V value;
                value = e.getValue();
                {
                    boolean varA5737C8BC3A00C9E9A68B0C1A8552473_1371898676 = (key == this || value == this);
                } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.466 -0400", hash_original_method = "A78197C1027A9ECA0DF472B01066EEE7", hash_generated_method = "522BAFF7152F738ABFF372D3F1F28EE4")
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
                boolean var41667EFB1D4E18743BE89148FA51235C_538663067 = (hasMore = i.hasNext());
                {
                    result.append(", ");
                } //End block
            } //End collapsed parenthetic
        } //End block
        result.append('}');
        String varEA70154FDA28CC59402440C6317B57EF_2089207209 = (result.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.472 -0400", hash_original_method = "19818AA4E6F1DBA67EBB75B368743917", hash_generated_method = "E9321B11134EDDEB2F05D57DBB7FDC33")
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
            Iterator<Entry<K, V>> varD93A6471022189C0BA28AFBB8C8557A0_1129239900 = (entrySet()).iterator();
            varD93A6471022189C0BA28AFBB8C8557A0_1129239900.hasNext();
            Entry<K, V> e = varD93A6471022189C0BA28AFBB8C8557A0_1129239900.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.472 -0400", hash_original_method = "2EADB0DA3622DE13512805CD17FDFE7A", hash_generated_method = "E8AC8B5338BA70813FB4D9E2BEBC8EEB")
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
        K key;
        V value;
        int hash;
        HashtableEntry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.472 -0400", hash_original_method = "FCC59894C2665A76D7100104D46402EE", hash_generated_method = "6B2991C5D4F249325382B3C48139A29E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.473 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "EE071B019D3BFDDDB20AAD5C11BA2C9D")
        @DSModeled(DSC.SAFE)
        public final K getKey() {
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.473 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "8B012D6735DD9AA7386E0263130FD3D0")
        @DSModeled(DSC.SAFE)
        public final V getValue() {
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.473 -0400", hash_original_method = "09EE506DF55191FF6B72960EEA25D181", hash_generated_method = "E6A6DF76851892A2DA825EEDBA5DB0A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final V setValue(V value) {
            dsTaint.addTaint(value.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.473 -0400", hash_original_method = "509D67FA76563438156B3275F90914F5", hash_generated_method = "BD8C0C6A4B6BFCA7D61390ADC1720C80")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public final boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varE09B45BE378FDDE1749CF5314C9B65A1_1116987533 = (key.equals(e.getKey()) && value.equals(e.getValue()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return key.equals(e.getKey()) && value.equals(e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.473 -0400", hash_original_method = "28D407F854479314A0A7C3BE1F12A9AB", hash_generated_method = "11B42C45A92D128FC2791288FED2E2FB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public final int hashCode() {
            int varCC7293A69A74489DFEF0094B17563C76_983470731 = (key.hashCode() ^ value.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return key.hashCode() ^ value.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.474 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "546FBDB0F2F6D1AD8A60D457DDC0FBEA")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.474 -0400", hash_original_method = "1BB35CB0E7E6DF7A5633A61B0F63C5AA", hash_generated_method = "3ABDD7645076F8F6E69EEFCA7860E17F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.474 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "CC4831130E120DAE2C5139D0C4D85FB9")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.474 -0400", hash_original_method = "5FA6641462F5564CAC982C4AF6FCFB6C", hash_generated_method = "5208007273BFBC8F3A8A1CE5DF1998AB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         HashtableEntry<K, V> nextEntry() {
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
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
            HashtableEntry<K, V> varE716D0B9837917675A560095A2F6354C_1343970619 = (lastEntryReturned = entryToReturn);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.474 -0400", hash_original_method = "1C3D72122BB58702CE822C81122C0D27", hash_generated_method = "083B0C8FEE1EE215F4BFFD2601A50792")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         HashtableEntry<K, V> nextEntryNotFailFast() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
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
            HashtableEntry<K, V> varE716D0B9837917675A560095A2F6354C_698984461 = (lastEntryReturned = entryToReturn);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.475 -0400", hash_original_method = "342FDC52CA82B385D96AADB83EE8F936", hash_generated_method = "55CA60158E545DDD18DDAB246D1BF2A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.475 -0400", hash_original_method = "5D388AF9F4BC08670D6FC8B0690B4586", hash_generated_method = "5D388AF9F4BC08670D6FC8B0690B4586")
                public KeyIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.475 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "AC228D1E563F5EFD542BAA28D6A48226")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K next() {
            K var0826C92B2F2C6B3475D8BF572E4E70AE_386463005 = (nextEntry().key);
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends HashIterator implements Iterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.475 -0400", hash_original_method = "0633288CFFDB0D47FC844EDFD5BB157F", hash_generated_method = "0633288CFFDB0D47FC844EDFD5BB157F")
                public ValueIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.475 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "3FBA45DAFDB78AA4F8CFEE2958F41FB1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public V next() {
            V var551184D8EC6DFD9474BC6F4F9A2CB7F7_1935628192 = (nextEntry().value);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.475 -0400", hash_original_method = "FCA6D1B18319AC57F041ABBA6E1FAA59", hash_generated_method = "FCA6D1B18319AC57F041ABBA6E1FAA59")
                public EntryIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.475 -0400", hash_original_method = "C7E2B840B075445DC1033B130AB2E6A6", hash_generated_method = "CE698522035D2E7340308281878A88A7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry<K, V> next() {
            Entry<K, V> varFDACBEE1E52798928B8D0EBEA13DBC12_1732379871 = (nextEntry());
            return (Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private final class KeyEnumeration extends HashIterator implements Enumeration<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.475 -0400", hash_original_method = "BCE2F0B93B764006016F370CAB3D3310", hash_generated_method = "BCE2F0B93B764006016F370CAB3D3310")
                public KeyEnumeration ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.476 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "475748796AD733826FBE00C88A509053")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_1951915063 = (hasNext());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.476 -0400", hash_original_method = "BED82438F0CBBB90FF7803670DD55802", hash_generated_method = "7F052118FF2299AED5A306C667211A7D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K nextElement() {
            K varED0D07A4A50EC193BECB36F8B21B708D_500532885 = (nextEntryNotFailFast().key);
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().key;
        }

        
    }


    
    private final class ValueEnumeration extends HashIterator implements Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.476 -0400", hash_original_method = "56FD7BBB1786C4E26652F4397889F410", hash_generated_method = "56FD7BBB1786C4E26652F4397889F410")
                public ValueEnumeration ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.476 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "705DB85B81553C2AB11F6A6214F400F1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_275289976 = (hasNext());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.476 -0400", hash_original_method = "433328C2A0882CA6574B6B21E730CA05", hash_generated_method = "EF0225B16600654B2E82A6E94D4F6A4A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public V nextElement() {
            V var3323A15378AB29A460328ED110B9E5BD_1062756570 = (nextEntryNotFailFast().value);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().value;
        }

        
    }


    
    private final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.476 -0400", hash_original_method = "AD2AA12DF2DCFDBEC9B4D1AB308E571A", hash_generated_method = "AD2AA12DF2DCFDBEC9B4D1AB308E571A")
                public KeySet ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.476 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "5B10B7D13B9F8779342BEACDFC1690B3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<K> iterator() {
            Iterator<K> var727A467D8B784AF4C95A4BCEAD645213_1357528044 = (new KeyIterator());
            return (Iterator<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new KeyIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.477 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "C9DFFE9FECFE6A776DB30BEBF14A286A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_1970385657 = (Hashtable.this.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.477 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "353BD63DFEC0F35A06AB95A4BAE15C76")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean var997BAB39B2F072D5CD66A271F3B6E196_713275284 = (containsKey(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.477 -0400", hash_original_method = "FF159DEBFD9D37DD2EC80383AA98B734", hash_generated_method = "A60369CDE70E3AD39F50F1B2566FA0B9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean remove(Object o) {
            dsTaint.addTaint(o.dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_50344156 = (Hashtable.this);
                {
                    int oldSize;
                    oldSize = size;
                    Hashtable.this.remove(o);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //int oldSize = size;
                //Hashtable.this.remove(o);
                //return size != oldSize;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.477 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.477 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "745F0CABFF30FA63AF99933AF1A8A4BC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_2058142588 = (Hashtable.this);
                {
                    boolean varF33472708DFFFDAF6959DE4125160D76_280723270 = (super.removeAll(collection));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.478 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "E39078A0EDD0B7E5DE66C811B05CFF36")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_907427247 = (Hashtable.this);
                {
                    boolean var802E13F1B176A50DBD94ED7EACD6E76C_221139123 = (super.retainAll(collection));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.478 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "D9B2FDEF0C7DEE6EB60D95174FA9378E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1272597260 = (Hashtable.this);
                {
                    boolean var7FF1A279AF3532345951D9FAAC0AC82D_747518656 = (super.containsAll(collection));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.478 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "9B7B2B8C6152269F34D7D07E6B450707")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_110829374 = (Hashtable.this);
                {
                    boolean var5BE46525B597E36F672CA971A0B1396F_85553373 = (super.equals(object));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.478 -0400", hash_original_method = "2EB37718E343BC9663B783B0FC3BE747", hash_generated_method = "2A759CF3BD0D40AD51E5A879348B4805")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int hashCode() {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_30205918 = (Hashtable.this);
                {
                    int varC1EBD1993309EE605028A8712B798C0E_769284409 = (super.hashCode());
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.478 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "FA68087DAD6DD731E42DA055C2449C91")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1755038804 = (Hashtable.this);
                {
                    String var57BB1F027776FC912051DE79A61E1E50_1472763233 = (super.toString());
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.478 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "1CFEB0D6E70EBAA16EBC6BA2223C05F4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object[] toArray() {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_875116121 = (Hashtable.this);
                {
                    Object[] varCAA258B7C6EA4646EA3B003B04387CD0_805431652 = (super.toArray());
                } //End block
            } //End collapsed parenthetic
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.479 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "93E87BA2C1F21EAE2B3C65C12918AA6C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T[] toArray(T[] a) {
            dsTaint.addTaint(a[0].dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_2043363192 = (Hashtable.this);
                {
                    T[] var1CA9704E295DAE60B271D8D53F0D9273_266354631 = (super.toArray(a));
                } //End block
            } //End collapsed parenthetic
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.479 -0400", hash_original_method = "D4CD3011C6EAF83FB83B7739F97A2374", hash_generated_method = "D4CD3011C6EAF83FB83B7739F97A2374")
                public Values ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.479 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "E4D1CA04E45D3B118A2033E0C278ACE5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<V> iterator() {
            Iterator<V> var574E07CFE3EC53CCAFC369382828B6D5_1112998324 = (new ValueIterator());
            return (Iterator<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ValueIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.479 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "E6CCD9FC640F990E70F86767C9BDEFD2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_259883294 = (Hashtable.this.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.479 -0400", hash_original_method = "C13053467D6FDF772DF450C87D40A3D5", hash_generated_method = "D55E677F5862D8D98DD60C70D110A927")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean varD1EEFCBD27E28C71EA594EC596966CFD_2053089090 = (containsValue(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return containsValue(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.479 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.479 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "7E385C6EA8FD8813755C38C1DE5F8E19")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_101967083 = (Hashtable.this);
                {
                    boolean var7FF1A279AF3532345951D9FAAC0AC82D_1481112168 = (super.containsAll(collection));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.480 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "BE55607CD280CF2F73440EFB324BDFB6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_273961109 = (Hashtable.this);
                {
                    String var57BB1F027776FC912051DE79A61E1E50_955126344 = (super.toString());
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.480 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "0E9F93E718118DD60BE59262271E8DAD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object[] toArray() {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_680391025 = (Hashtable.this);
                {
                    Object[] varCAA258B7C6EA4646EA3B003B04387CD0_6827743 = (super.toArray());
                } //End block
            } //End collapsed parenthetic
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.480 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "0CC9C927CF26FEEA85EE608E057DB2F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T[] toArray(T[] a) {
            dsTaint.addTaint(a[0].dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_2108879726 = (Hashtable.this);
                {
                    T[] var1CA9704E295DAE60B271D8D53F0D9273_735465834 = (super.toArray(a));
                } //End block
            } //End collapsed parenthetic
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.480 -0400", hash_original_method = "2F953926D7C5D976A09AA3C5A1A35BD1", hash_generated_method = "2F953926D7C5D976A09AA3C5A1A35BD1")
                public EntrySet ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.480 -0400", hash_original_method = "D7164BC97FFDCB587AB273006C953E50", hash_generated_method = "AFDAA47726519B07288BBE04EA7A8F47")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> var8A4CFE84C6EAED9EA430E32D824AF517_17270572 = (new EntryIterator());
            return (Iterator<Entry<K, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new EntryIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.480 -0400", hash_original_method = "6E695F138E29D844DC896198513B6135", hash_generated_method = "49957C2236E9066D817F5999FDAEA8DC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varEC3A3E183CD0A7D33A5B45EDAE091B2E_828597734 = (containsMapping(e.getKey(), e.getValue()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return containsMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.481 -0400", hash_original_method = "F484CBC8566C601718EDE0034034C7B3", hash_generated_method = "166A792725EC0A34D47988BE3580A756")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean remove(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Entry<?, ?> e;
            e = (Entry<?, ?>)o;
            boolean var598A216136B4C4D06069F46B6EC81DD9_494792512 = (removeMapping(e.getKey(), e.getValue()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>)o;
            //return removeMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.481 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "D8CEDC905BFFCF67975628B4E20FF1AD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_1222984783 = (Hashtable.this.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.481 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.481 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "AAB2B1AC87E7E84083E631A1610D7C9A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_192496063 = (Hashtable.this);
                {
                    boolean varF33472708DFFFDAF6959DE4125160D76_239699989 = (super.removeAll(collection));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.481 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "0606B747779D4B4B9A757732FC40F470")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1425084368 = (Hashtable.this);
                {
                    boolean var802E13F1B176A50DBD94ED7EACD6E76C_2016517027 = (super.retainAll(collection));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.481 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "5E079D8862880EE9F2E18BDF081186ED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_294534245 = (Hashtable.this);
                {
                    boolean var7FF1A279AF3532345951D9FAAC0AC82D_42090 = (super.containsAll(collection));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.482 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "342837CB449D8D23CF23842EFD317128")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_106187807 = (Hashtable.this);
                {
                    boolean var5BE46525B597E36F672CA971A0B1396F_1429413397 = (super.equals(object));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.482 -0400", hash_original_method = "3000FE237E7845AEAFDA2B41B0704346", hash_generated_method = "16F454EE4BC1CBF875CCE6FF43D12626")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int hashCode() {
            int var888832939E9A16C553FA6EB5FC57B96E_1724442985 = (Hashtable.this.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Hashtable.this.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.482 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "1EE9C1F17FD31ECA0FC31F72A1CD063F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_82134655 = (Hashtable.this);
                {
                    String var57BB1F027776FC912051DE79A61E1E50_600302710 = (super.toString());
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.482 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "109B19A35865DDE661969C3ADAB774CA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object[] toArray() {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_13733944 = (Hashtable.this);
                {
                    Object[] varCAA258B7C6EA4646EA3B003B04387CD0_1098011183 = (super.toArray());
                } //End block
            } //End collapsed parenthetic
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.482 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "7580AA2D7D8A8DB33FA95B93DCF5EDB6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T[] toArray(T[] a) {
            dsTaint.addTaint(a[0].dsTaint);
            {
                Object var85D7E5D24FB948184A7704DF274F5600_834830409 = (Hashtable.this);
                {
                    T[] var1CA9704E295DAE60B271D8D53F0D9273_1441066677 = (super.toArray(a));
                } //End block
            } //End collapsed parenthetic
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private static final int MINIMUM_CAPACITY = 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final Entry[] EMPTY_TABLE
            = new HashtableEntry[MINIMUM_CAPACITY >>> 1];
    private static final float DEFAULT_LOAD_FACTOR = .75F;
    private static final int CHARS_PER_ENTRY = 15;
    private static final long serialVersionUID = 1421746759512286392L;
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("threshold", int.class),
        new ObjectStreamField("loadFactor", float.class),
    };
}


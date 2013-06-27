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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.560 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "19DEB795009FCB78D63A1C2C298CE954")

    private transient HashtableEntry<K, V>[] table;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.560 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "55DCA83C6162ACD637EB02860F7422EE")

    private transient int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.560 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "EDCBB672EA8C27007EA64BE3078BC69C")

    private transient int modCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.560 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "AC9BEC59E41404676A448C0DD2BB745B")

    private transient int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.560 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "EB6C570550CCFE8E5FEBB44BA37D02C0")

    private transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.560 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "BFDE585634496DDD7FBD15EDD2D3C5DD")

    private transient Set<Entry<K, V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.560 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "5A2A505CEEC79706812E901D735E2A7C")

    private transient Collection<V> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.570 -0400", hash_original_method = "9A93999031A29C4DD8DE295A6372F847", hash_generated_method = "6A7170C4C6FFAE127214BE36F7841D7F")
    @SuppressWarnings("unchecked")
    public  Hashtable() {
        table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1;
        // ---------- Original Method ----------
        //table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.570 -0400", hash_original_method = "6003D4D798348C1583CB15DE42C187C6", hash_generated_method = "8C486488FEBC94DCBEBBA43CC60196AD")
    public  Hashtable(int capacity) {
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
        addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.571 -0400", hash_original_method = "5B6B569F078844A0FAD42909C56D1E6D", hash_generated_method = "E3A3C4352339EE76223D479C954414C7")
    public  Hashtable(int capacity, float loadFactor) {
        this(capacity);
        {
            boolean var7E96777C74EA86B66256F7B00F5AE961_2044648168 = (loadFactor <= 0 || Float.isNaN(loadFactor));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Load factor: " + loadFactor);
            } //End block
        } //End collapsed parenthetic
        addTaint(capacity);
        addTaint(loadFactor);
        // ---------- Original Method ----------
        //if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            //throw new IllegalArgumentException("Load factor: " + loadFactor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.571 -0400", hash_original_method = "6950B91F5E6C68C49CB594AFD1673B84", hash_generated_method = "9942D9644FF2A2AB7459A99EAC4A7ACB")
    public  Hashtable(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        constructorPutAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.577 -0400", hash_original_method = "6631235722E4D3190E3529D2039DDD7A", hash_generated_method = "B58DB30B084A51EFD3D5B70EAB9427C5")
    private void constructorPutAll(Map<? extends K, ? extends V> map) {
        {
            map.entrySet().iterator().hasNext();
            Entry<? extends K, ? extends V> e = map.entrySet().iterator().next();
            {
                constructorPut(e.getKey(), e.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //for (Entry<? extends K, ? extends V> e : map.entrySet()) {
            //constructorPut(e.getKey(), e.getValue());
        //}
    }

    
        private static int capacityForInitSize(int size) {
        int result = (size >> 1) + size;
        return (result & ~(MAXIMUM_CAPACITY-1))==0 ? result : MAXIMUM_CAPACITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.587 -0400", hash_original_method = "F0D9AD485DB15C1D3427CA487C88BFBD", hash_generated_method = "7428F4C5B7375A9AFE95507B85AE36CE")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_802877781 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_802877781 = result;
        varB4EAC82CA7396A68D541C85D26508E83_802877781.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_802877781;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.588 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "DADC1AF785DF2DC5DB308BD8B14AD2D2")
    public synchronized boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1841299799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1841299799;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.588 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "B0AADEFCCDB639DC42DAF03D289CD80B")
    public synchronized int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_774324304 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_774324304;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.593 -0400", hash_original_method = "0D498A226869DEB0F3920DC31F67162F", hash_generated_method = "2EDDA3654CCBB7987C55E74CF9C2C2E6")
    public synchronized V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1985410871 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_626275448 = null; //Variable for return #2
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
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_1095314327 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1985410871 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_626275448 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1409169426; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1409169426 = varB4EAC82CA7396A68D541C85D26508E83_1985410871;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1409169426 = varB4EAC82CA7396A68D541C85D26508E83_626275448;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1409169426.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1409169426;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.599 -0400", hash_original_method = "EDC536266386E3A88DC2FA7B05BC7882", hash_generated_method = "AB2DAB740AFBC19B9E13EBC6910C0881")
    public synchronized boolean containsKey(Object key) {
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
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_1430549892 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260681627 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260681627;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.600 -0400", hash_original_method = "22B2A1F3D878FCC53A2BA6539B84615E", hash_generated_method = "EC3BCA62C1AEB18C7F4CC698554B2006")
    public synchronized boolean containsValue(Object value) {
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
                            boolean varB228932AA07990623CC3C29EF03F40DA_1729461960 = (value.equals(e.value));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_323653435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_323653435;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.600 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "393512804A1DBC39FDC70C0CB79359FD")
    public boolean contains(Object value) {
        boolean var9D0C71166B134CB9FEA4F5814A8E4863_877570510 = (containsValue(value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659510577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659510577;
        // ---------- Original Method ----------
        //return containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.601 -0400", hash_original_method = "70A37B9812099DB6AA6597919714B995", hash_generated_method = "4BD8B57F3304C1F3CC365D5E2F86F726")
    public synchronized V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1917930699 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1730360197 = null; //Variable for return #2
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1598455699 = (e.hash == hash && key.equals(e.key));
                    {
                        V oldValue;
                        oldValue = e.value;
                        e.value = value;
                        varB4EAC82CA7396A68D541C85D26508E83_1917930699 = oldValue;
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
        varB4EAC82CA7396A68D541C85D26508E83_1730360197 = null;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        V varA7E53CE21691AB073D9660D615818899_526043343; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_526043343 = varB4EAC82CA7396A68D541C85D26508E83_1917930699;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_526043343 = varB4EAC82CA7396A68D541C85D26508E83_1730360197;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_526043343.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_526043343;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.610 -0400", hash_original_method = "DD29A5E73441E57ACE3C1AF694856AF1", hash_generated_method = "CF3B1FFF48753652475B5CFFDCAD1103")
    private void constructorPut(K key, V value) {
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1528801563 = (e.hash == hash && key.equals(e.key));
                    {
                        e.value = value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        tab[index] = new HashtableEntry<K, V>(key, value, hash, first);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.618 -0400", hash_original_method = "46C920EF16234ECC2EBDE62DDADD6435", hash_generated_method = "0544AE9AED41A82DB1322BE6F491C3AB")
    public synchronized void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size());
        {
            map.entrySet().iterator().hasNext();
            Entry<? extends K, ? extends V> e = map.entrySet().iterator().next();
            {
                put(e.getKey(), e.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //ensureCapacity(map.size());
        //for (Entry<? extends K, ? extends V> e : map.entrySet()) {
            //put(e.getKey(), e.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.630 -0400", hash_original_method = "5BCC94324BA2D5ECBED6314BEA7D0FA8", hash_generated_method = "410BDC902D93FE57D25A2339D187F568")
    private void ensureCapacity(int numMappings) {
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
        addTaint(numMappings);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.631 -0400", hash_original_method = "CC28673E29B73787492CFDC805600F5D", hash_generated_method = "E3452D490AF44DF99FFD2B9DFC516DAB")
    protected void rehash() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.636 -0400", hash_original_method = "8FDFD015009EFB98FD90E5E66F0193AF", hash_generated_method = "A549590254172EA028C5D54ECFA2F28C")
    private HashtableEntry<K, V>[] makeTable(int newCapacity) {
        HashtableEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1738606772 = null; //Variable for return #1
        @SuppressWarnings("unchecked") HashtableEntry<K, V>[] newTable;
        newTable = (HashtableEntry<K, V>[]) new HashtableEntry[newCapacity];
        table = newTable;
        threshold = (newCapacity >> 1) + (newCapacity >> 2);
        varB4EAC82CA7396A68D541C85D26508E83_1738606772 = newTable;
        varB4EAC82CA7396A68D541C85D26508E83_1738606772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1738606772;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked") HashtableEntry<K, V>[] newTable
                //= (HashtableEntry<K, V>[]) new HashtableEntry[newCapacity];
        //table = newTable;
        //threshold = (newCapacity >> 1) + (newCapacity >> 2);
        //return newTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.643 -0400", hash_original_method = "291B56F25D1E56D0A03492C2073BE506", hash_generated_method = "83AADF8BB0D6B5CEFBD189B52921CFD6")
    private HashtableEntry<K, V>[] doubleCapacity() {
        HashtableEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_2106468438 = null; //Variable for return #1
        HashtableEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1434049077 = null; //Variable for return #2
        HashtableEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1781530003 = null; //Variable for return #3
        HashtableEntry<K, V>[] oldTable;
        oldTable = table;
        int oldCapacity;
        oldCapacity = oldTable.length;
        {
            varB4EAC82CA7396A68D541C85D26508E83_2106468438 = oldTable;
        } //End block
        int newCapacity;
        newCapacity = oldCapacity * 2;
        HashtableEntry<K, V>[] newTable;
        newTable = makeTable(newCapacity);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1434049077 = newTable;
        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_1781530003 = newTable;
        HashtableEntry<K, V>[] varA7E53CE21691AB073D9660D615818899_1385781477; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1385781477 = varB4EAC82CA7396A68D541C85D26508E83_2106468438;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1385781477 = varB4EAC82CA7396A68D541C85D26508E83_1434049077;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1385781477 = varB4EAC82CA7396A68D541C85D26508E83_1781530003;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1385781477.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1385781477;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.649 -0400", hash_original_method = "B19FA41811C96CC39A17F943778772D8", hash_generated_method = "2868861AA75A05DFC104CBB504FC7264")
    public synchronized V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_450584014 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1623997819 = null; //Variable for return #2
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_706930075 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            tab[index] = e.next;
                        } //End block
                        {
                            prev.next = e.next;
                        } //End block
                        varB4EAC82CA7396A68D541C85D26508E83_450584014 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1623997819 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1634245079; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1634245079 = varB4EAC82CA7396A68D541C85D26508E83_450584014;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1634245079 = varB4EAC82CA7396A68D541C85D26508E83_1623997819;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1634245079.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1634245079;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.655 -0400", hash_original_method = "1C0D329A7E5E91219CE97B2AC82E739C", hash_generated_method = "D68A0CADC876BC1431B9C8C9FB2DDE0F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.655 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "B6AEABD5111872C2017DA6B2CA2D9B79")
    public synchronized Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_945183315 = null; //Variable for return #1
        Set<K> ks;
        ks = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_945183315 = (ks != null) ? ks : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_945183315.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_945183315;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.656 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "CEE177CD51E2FD1AEAFAAA72CDE8427A")
    public synchronized Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1358178419 = null; //Variable for return #1
        Collection<V> vs;
        vs = values;
        varB4EAC82CA7396A68D541C85D26508E83_1358178419 = (vs != null) ? vs : (values = new Values());
        varB4EAC82CA7396A68D541C85D26508E83_1358178419.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1358178419;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.661 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "044CAB59768D5707B33A8665C9517381")
    public synchronized Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_176409585 = null; //Variable for return #1
        Set<Entry<K, V>> es;
        es = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_176409585 = (es != null) ? es : (entrySet = new EntrySet());
        varB4EAC82CA7396A68D541C85D26508E83_176409585.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_176409585;
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.662 -0400", hash_original_method = "BD8590C2A6B44E1AD87F42CA1DDBEEC0", hash_generated_method = "D65916F2789D89103454E89A9439259C")
    public synchronized Enumeration<K> keys() {
        Enumeration<K> varB4EAC82CA7396A68D541C85D26508E83_1885739380 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1885739380 = new KeyEnumeration();
        varB4EAC82CA7396A68D541C85D26508E83_1885739380.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1885739380;
        // ---------- Original Method ----------
        //return new KeyEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.662 -0400", hash_original_method = "D92B3AB4F78D152BCFDB4F438052384E", hash_generated_method = "9F51F050619B7D1E5FFDA699081DFFC4")
    public synchronized Enumeration<V> elements() {
        Enumeration<V> varB4EAC82CA7396A68D541C85D26508E83_145377054 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_145377054 = new ValueEnumeration();
        varB4EAC82CA7396A68D541C85D26508E83_145377054.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_145377054;
        // ---------- Original Method ----------
        //return new ValueEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.667 -0400", hash_original_method = "CF57466F07C2DB8AF5EFB522D22E3680", hash_generated_method = "D00F80D9BF50B7C7F6C2C9BCC3157661")
    private synchronized boolean containsMapping(Object key, Object value) {
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
                    boolean varBF092BC27A863E23FE4C44D225ED1FDA_1432075930 = (e.hash == hash && e.key.equals(key));
                    {
                        boolean var6C13353AEE37EBEED16BB037A146133C_1748456612 = (e.value.equals(value));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97547471 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_97547471;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.669 -0400", hash_original_method = "A191738781408606E816E9A37080097D", hash_generated_method = "296CDE8615DB78A1128F1DDF9C86F861")
    private synchronized boolean removeMapping(Object key, Object value) {
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
                    boolean varBF092BC27A863E23FE4C44D225ED1FDA_2043433692 = (e.hash == hash && e.key.equals(key));
                    {
                        {
                            boolean var876C169E101ABBE81C5DB09387C8C08C_564964550 = (!e.value.equals(value));
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
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_171437520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_171437520;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.670 -0400", hash_original_method = "9BC17AC5DA957A9C0A07708C3D3A3E68", hash_generated_method = "13A440D152CEF6D1C45180459757E0F5")
    @Override
    public synchronized boolean equals(Object object) {
        boolean varF1443A15804B24DDE99B981E7E34D8C9_1437472171 = ((object instanceof Map) &&
                entrySet().equals(((Map<?, ?>)object).entrySet()));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1978332698 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1978332698;
        // ---------- Original Method ----------
        //return (object instanceof Map) &&
                //entrySet().equals(((Map<?, ?>)object).entrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.719 -0400", hash_original_method = "0904BEF2CA25AF4229493E32A4F8928E", hash_generated_method = "2273E4660BA4CE73F3BFA838BEA763BB")
    @Override
    public synchronized int hashCode() {
        int result;
        result = 0;
        {
            Iterator<Entry<K, V>> varD93A6471022189C0BA28AFBB8C8557A0_947047724 = (entrySet()).iterator();
            varD93A6471022189C0BA28AFBB8C8557A0_947047724.hasNext();
            Entry<K, V> e = varD93A6471022189C0BA28AFBB8C8557A0_947047724.next();
            {
                K key;
                key = e.getKey();
                V value;
                value = e.getValue();
                {
                    boolean varA5737C8BC3A00C9E9A68B0C1A8552473_1501321249 = (key == this || value == this);
                } //End collapsed parenthetic
                result += (key != null ? key.hashCode() : 0)
                    ^ (value != null ? value.hashCode() : 0);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718103386 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718103386;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.720 -0400", hash_original_method = "A78197C1027A9ECA0DF472B01066EEE7", hash_generated_method = "88DE97B5E5A11D37B5D3F3EE13AED18E")
    @Override
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1909596232 = null; //Variable for return #1
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
                boolean var41667EFB1D4E18743BE89148FA51235C_922267140 = (hasMore = i.hasNext());
                {
                    result.append(", ");
                } //End block
            } //End collapsed parenthetic
        } //End block
        result.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_1909596232 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1909596232.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1909596232;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.747 -0400", hash_original_method = "19818AA4E6F1DBA67EBB75B368743917", hash_generated_method = "0827F8C00497877650DCF6F3AD5FC9C4")
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("threshold",  (int) (DEFAULT_LOAD_FACTOR * table.length));
        fields.put("loadFactor", DEFAULT_LOAD_FACTOR);
        stream.writeFields();
        stream.writeInt(table.length);
        stream.writeInt(size);
        {
            Iterator<Entry<K, V>> varD93A6471022189C0BA28AFBB8C8557A0_203216456 = (entrySet()).iterator();
            varD93A6471022189C0BA28AFBB8C8557A0_203216456.hasNext();
            Entry<K, V> e = varD93A6471022189C0BA28AFBB8C8557A0_203216456.next();
            {
                stream.writeObject(e.getKey());
                stream.writeObject(e.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.749 -0400", hash_original_method = "2EADB0DA3622DE13512805CD17FDFE7A", hash_generated_method = "88C240AC8C67A0713F488D22FF3720B8")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
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
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class HashtableEntry<K, V> implements Entry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.749 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.749 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.749 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.749 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A5AC9F76C2A7B9F6F79010A5F4A3B4B7")

        HashtableEntry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.749 -0400", hash_original_method = "FCC59894C2665A76D7100104D46402EE", hash_generated_method = "7F8F2DB59D28E587038E679033461007")
          HashtableEntry(K key, V value, int hash, HashtableEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
            // ---------- Original Method ----------
            //this.key = key;
            //this.value = value;
            //this.hash = hash;
            //this.next = next;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.783 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "5F61BF5F2086871B70FFA6360EB9CA2C")
        public final K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_465247363 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_465247363 = key;
            varB4EAC82CA7396A68D541C85D26508E83_465247363.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_465247363;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.784 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "22BCFBFBE062C578BBBB00826126695A")
        public final V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_757459045 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_757459045 = value;
            varB4EAC82CA7396A68D541C85D26508E83_757459045.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_757459045;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.785 -0400", hash_original_method = "09EE506DF55191FF6B72960EEA25D181", hash_generated_method = "6986B156006CF43C44EA4941C89B5E8D")
        public final V setValue(V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_616377808 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            V oldValue;
            oldValue = this.value;
            this.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_616377808 = oldValue;
            varB4EAC82CA7396A68D541C85D26508E83_616377808.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_616377808;
            // ---------- Original Method ----------
            //if (value == null) {
                //throw new NullPointerException();
            //}
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.785 -0400", hash_original_method = "509D67FA76563438156B3275F90914F5", hash_generated_method = "F85F4207924FD0825D89ABA026418540")
        @Override
        public final boolean equals(Object o) {
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varE09B45BE378FDDE1749CF5314C9B65A1_1324881863 = (key.equals(e.getKey()) && value.equals(e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_54505609 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_54505609;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return key.equals(e.getKey()) && value.equals(e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.785 -0400", hash_original_method = "28D407F854479314A0A7C3BE1F12A9AB", hash_generated_method = "E466EA64AF76CC2A2D6813B6A92850C1")
        @Override
        public final int hashCode() {
            int varCC7293A69A74489DFEF0094B17563C76_497759328 = (key.hashCode() ^ value.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593549784 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593549784;
            // ---------- Original Method ----------
            //return key.hashCode() ^ value.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.786 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "2F17FE67358850A6F000CFAE0D533F35")
        @Override
        public final String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_782958477 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_782958477 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_782958477.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_782958477;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
    }


    
    private abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.786 -0400", hash_original_field = "B6F75212F617C3E247C9474AFDA3B784", hash_generated_field = "04911A8A6B33F6D23811475122C95D0E")

        int nextIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.786 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "7A671A08D7EC5144843A6963DC69FDC7")

        HashtableEntry<K, V> nextEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.786 -0400", hash_original_field = "8A3A9937F6D0DA3448C9C061B347CECF", hash_generated_field = "7DA4F26BBE36FAFDC112AEE30391E8D1")

        HashtableEntry<K, V> lastEntryReturned;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.786 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "17128C49BCF19B4186F02F384F2DEA86")

        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.786 -0400", hash_original_method = "1BB35CB0E7E6DF7A5633A61B0F63C5AA", hash_generated_method = "3ABDD7645076F8F6E69EEFCA7860E17F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.787 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "F56E83F9F0A64F6BE4336DA168ECFDE4")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1639944510 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1639944510;
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.787 -0400", hash_original_method = "5FA6641462F5564CAC982C4AF6FCFB6C", hash_generated_method = "A4D937513A00A1A647C10E96D25B4FE2")
         HashtableEntry<K, V> nextEntry() {
            HashtableEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_572947575 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_572947575 = lastEntryReturned = entryToReturn;
            varB4EAC82CA7396A68D541C85D26508E83_572947575.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_572947575;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.801 -0400", hash_original_method = "1C3D72122BB58702CE822C81122C0D27", hash_generated_method = "6E3EC76791CB532241EB784ADF85E721")
         HashtableEntry<K, V> nextEntryNotFailFast() {
            HashtableEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1189986591 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1189986591 = lastEntryReturned = entryToReturn;
            varB4EAC82CA7396A68D541C85D26508E83_1189986591.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1189986591;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.801 -0400", hash_original_method = "342FDC52CA82B385D96AADB83EE8F936", hash_generated_method = "55CA60158E545DDD18DDAB246D1BF2A1")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.802 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.802 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "2078859E8520A47202B36BF307650983")
        public K next() {
            K varB4EAC82CA7396A68D541C85D26508E83_1137306407 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1137306407 = nextEntry().key;
            varB4EAC82CA7396A68D541C85D26508E83_1137306407.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1137306407;
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends HashIterator implements Iterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.802 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.809 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "648347608CC7F4911985E23EDD4ABF7A")
        public V next() {
            V varB4EAC82CA7396A68D541C85D26508E83_23578919 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_23578919 = nextEntry().value;
            varB4EAC82CA7396A68D541C85D26508E83_23578919.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_23578919;
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.810 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.817 -0400", hash_original_method = "C7E2B840B075445DC1033B130AB2E6A6", hash_generated_method = "1E1295856063BF2ADDD368018208B6EE")
        public Entry<K, V> next() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_723107457 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_723107457 = nextEntry();
            varB4EAC82CA7396A68D541C85D26508E83_723107457.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_723107457;
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private final class KeyEnumeration extends HashIterator implements Enumeration<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.818 -0400", hash_original_method = "2E46AFA79C505478BD5C8702CDCDD1D4", hash_generated_method = "2E46AFA79C505478BD5C8702CDCDD1D4")
        public KeyEnumeration ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.818 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "264D3B6049501EAF595163B222357F4E")
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_1405033908 = (hasNext());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1029979841 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1029979841;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.819 -0400", hash_original_method = "BED82438F0CBBB90FF7803670DD55802", hash_generated_method = "1DC8AA36191F19E222D6EC1A5E8F63B3")
        public K nextElement() {
            K varB4EAC82CA7396A68D541C85D26508E83_1173166409 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1173166409 = nextEntryNotFailFast().key;
            varB4EAC82CA7396A68D541C85D26508E83_1173166409.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1173166409;
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().key;
        }

        
    }


    
    private final class ValueEnumeration extends HashIterator implements Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.819 -0400", hash_original_method = "0C70885115EB664BF7ADABD8AB769AB3", hash_generated_method = "0C70885115EB664BF7ADABD8AB769AB3")
        public ValueEnumeration ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.819 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "0B7744D4CB75B57B1450ED2B0F673A32")
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_446444364 = (hasNext());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1599706957 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1599706957;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.831 -0400", hash_original_method = "433328C2A0882CA6574B6B21E730CA05", hash_generated_method = "E8E092D2BF83C1787AC886B6C470DF1C")
        public V nextElement() {
            V varB4EAC82CA7396A68D541C85D26508E83_14373778 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_14373778 = nextEntryNotFailFast().value;
            varB4EAC82CA7396A68D541C85D26508E83_14373778.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_14373778;
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().value;
        }

        
    }


    
    private final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.832 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.833 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "2F0701DD481646C99BDC95C4CC99F262")
        public Iterator<K> iterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_889886253 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_889886253 = new KeyIterator();
            varB4EAC82CA7396A68D541C85D26508E83_889886253.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_889886253;
            // ---------- Original Method ----------
            //return new KeyIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.833 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "325E5F4A8AC1E64E224A117EF093B61F")
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_152932314 = (Hashtable.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1250013529 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1250013529;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.834 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "6A625D5DA1AB40637B27F5A125AB76F0")
        public boolean contains(Object o) {
            boolean var997BAB39B2F072D5CD66A271F3B6E196_1307073170 = (containsKey(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837734200 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837734200;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.835 -0400", hash_original_method = "FF159DEBFD9D37DD2EC80383AA98B734", hash_generated_method = "B625F062073EEC6BA32F99BF5DFAEBD4")
        public boolean remove(Object o) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1235856227 = (Hashtable.this);
                {
                    int oldSize;
                    oldSize = size;
                    Hashtable.this.remove(o);
                } //End block
            } //End collapsed parenthetic
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394116667 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_394116667;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //int oldSize = size;
                //Hashtable.this.remove(o);
                //return size != oldSize;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.835 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.835 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "CF208B560F781C4CDF92AFE880032BEB")
        public boolean removeAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1899869809 = (Hashtable.this);
                {
                    boolean varF33472708DFFFDAF6959DE4125160D76_769911018 = (super.removeAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1290576345 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1290576345;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.850 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "CE4E4D3867B2354A3EF72EE800B82174")
        public boolean retainAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1318062457 = (Hashtable.this);
                {
                    boolean var802E13F1B176A50DBD94ED7EACD6E76C_37255839 = (super.retainAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1009494524 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1009494524;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.850 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "27526EE07B08CEDEB765BA8B47BE0579")
        public boolean containsAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_155479057 = (Hashtable.this);
                {
                    boolean var7FF1A279AF3532345951D9FAAC0AC82D_2136041241 = (super.containsAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1947535456 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1947535456;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.850 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "A53CD6FD58E8CA7217D52EA0FABD35E8")
        public boolean equals(Object object) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_807718622 = (Hashtable.this);
                {
                    boolean var5BE46525B597E36F672CA971A0B1396F_818209764 = (super.equals(object));
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1429660732 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1429660732;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.851 -0400", hash_original_method = "2EB37718E343BC9663B783B0FC3BE747", hash_generated_method = "1F3A6361E2A19E1D6EBAB8B79C995F05")
        public int hashCode() {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_251722619 = (Hashtable.this);
                {
                    int varC1EBD1993309EE605028A8712B798C0E_1963918172 = (super.hashCode());
                } //End block
            } //End collapsed parenthetic
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1207319500 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1207319500;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.863 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "F17444DD49999E1E7FB6BA79948BD6A2")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1570571102 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1612645011 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1570571102 = super.toString();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1570571102.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1570571102;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.879 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "B66C7D0F800C0F8B6B7981F0E5536E2B")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_936547652 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_230327411 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_936547652 = super.toArray();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_936547652.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_936547652;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.880 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "902468699A038FCBC4B6D6869BE4409E")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1179622671 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_745748056 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1179622671 = super.toArray(a);
                } //End block
            } //End collapsed parenthetic
            addTaint(a[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1179622671.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1179622671;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.880 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.881 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "3E496C01384C7A1197D9AE9FB7AC0DA5")
        public Iterator<V> iterator() {
            Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_1022083309 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1022083309 = new ValueIterator();
            varB4EAC82CA7396A68D541C85D26508E83_1022083309.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1022083309;
            // ---------- Original Method ----------
            //return new ValueIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.882 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "9B58FF59910244153E34F82F87C648D9")
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_994941078 = (Hashtable.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690454674 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690454674;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.883 -0400", hash_original_method = "C13053467D6FDF772DF450C87D40A3D5", hash_generated_method = "7D4F140FFD38347D9966A3C7E7991541")
        public boolean contains(Object o) {
            boolean varD1EEFCBD27E28C71EA594EC596966CFD_1123818092 = (containsValue(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1750987266 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1750987266;
            // ---------- Original Method ----------
            //return containsValue(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.883 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.884 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "B15443D70BB02858585D08B56351DCA2")
        public boolean containsAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_226889841 = (Hashtable.this);
                {
                    boolean var7FF1A279AF3532345951D9FAAC0AC82D_344572573 = (super.containsAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1186858888 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1186858888;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.897 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "E2A19289B499C56D3C65079CA9618A8D")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_794357541 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_744607360 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_794357541 = super.toString();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_794357541.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_794357541;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.898 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "76AD6BBAE9D4016C1768EA4FCA978977")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_226694790 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1013595690 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_226694790 = super.toArray();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_226694790.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_226694790;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.898 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "155F2B3A9FCFAFF2713AD70E27A5A7A2")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1707137482 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1552833981 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1707137482 = super.toArray(a);
                } //End block
            } //End collapsed parenthetic
            addTaint(a[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1707137482.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1707137482;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.898 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.902 -0400", hash_original_method = "D7164BC97FFDCB587AB273006C953E50", hash_generated_method = "68368DF321FB3368D2DB9D219D797E4A")
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_639608031 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_639608031 = new EntryIterator();
            varB4EAC82CA7396A68D541C85D26508E83_639608031.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_639608031;
            // ---------- Original Method ----------
            //return new EntryIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.903 -0400", hash_original_method = "6E695F138E29D844DC896198513B6135", hash_generated_method = "68BAB2E6D2F44BF046FB7813AA8EC9DE")
        public boolean contains(Object o) {
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varEC3A3E183CD0A7D33A5B45EDAE091B2E_983114026 = (containsMapping(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147515364 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147515364;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return containsMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.904 -0400", hash_original_method = "F484CBC8566C601718EDE0034034C7B3", hash_generated_method = "213C833C1809B378918E341B4B5EADC6")
        public boolean remove(Object o) {
            Entry<?, ?> e;
            e = (Entry<?, ?>)o;
            boolean var598A216136B4C4D06069F46B6EC81DD9_289932385 = (removeMapping(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_385440280 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_385440280;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>)o;
            //return removeMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.904 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "E5BD69556A19625FAEE5FD1A3A33A3AA")
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_297838133 = (Hashtable.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1476677544 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1476677544;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.904 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.979 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "6B2291BC5F981D5C62D70057CAB73DC5")
        public boolean removeAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1374421668 = (Hashtable.this);
                {
                    boolean varF33472708DFFFDAF6959DE4125160D76_1379682292 = (super.removeAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2123776615 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2123776615;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.980 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "915766966906C45A9008F2082F8B545F")
        public boolean retainAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_60067347 = (Hashtable.this);
                {
                    boolean var802E13F1B176A50DBD94ED7EACD6E76C_94103216 = (super.retainAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_793877643 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_793877643;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.981 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "C83F1FF9C8479B16D3C51096A11490A8")
        public boolean containsAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1118035247 = (Hashtable.this);
                {
                    boolean var7FF1A279AF3532345951D9FAAC0AC82D_519043823 = (super.containsAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1542465397 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1542465397;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.981 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "2A64AA3568C23E2D0CF6EC118F243404")
        public boolean equals(Object object) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_66370352 = (Hashtable.this);
                {
                    boolean var5BE46525B597E36F672CA971A0B1396F_623328181 = (super.equals(object));
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_719428575 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_719428575;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.982 -0400", hash_original_method = "3000FE237E7845AEAFDA2B41B0704346", hash_generated_method = "C903FDC2A8CA6DB89BBE3323376E8D1E")
        public int hashCode() {
            int var888832939E9A16C553FA6EB5FC57B96E_691551270 = (Hashtable.this.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_54912975 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_54912975;
            // ---------- Original Method ----------
            //return Hashtable.this.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.983 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "CF323C247EDB4039533DF55BEC8C8671")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1969913176 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1793374220 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1969913176 = super.toString();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1969913176.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1969913176;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.983 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "58231B8636EE1D7770F26897725B2323")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1748426212 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1313745345 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1748426212 = super.toArray();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1748426212.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1748426212;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.984 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "2B3FF651116CC1925F1C27E875EE8A2B")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_794318257 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1388148461 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_794318257 = super.toArray(a);
                } //End block
            } //End collapsed parenthetic
            addTaint(a[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_794318257.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_794318257;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.984 -0400", hash_original_field = "74773297EBE9767DD8F1E8A0F109042B", hash_generated_field = "4FA46765B2A3EF08CC97297AFC75A0ED")

    private static int MINIMUM_CAPACITY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.984 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "864BDCB1A430DAF5D56F9061E7B2A26F")

    private static int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.984 -0400", hash_original_field = "215B48891AB1D8DA059087E167B4E6A3", hash_generated_field = "C93F61FB7CC10C41ECD4CA75E47F0E5C")

    private static Entry[] EMPTY_TABLE = new HashtableEntry[MINIMUM_CAPACITY >>> 1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.984 -0400", hash_original_field = "2457D6689D4C035FB0208C51E3216836", hash_generated_field = "BDD44B42DE376759E8EB7DC76E05062E")

    private static float DEFAULT_LOAD_FACTOR = .75F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.984 -0400", hash_original_field = "C12E356D9C08DF40A0A68843ED778698", hash_generated_field = "AE6BC140A8BB8804DA193F9527E22796")

    private static int CHARS_PER_ENTRY = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.984 -0400", hash_original_field = "5908451E267AA95A476F28CC7A33B199", hash_generated_field = "587CD269B9F1F82A53C5D381FEFA45BD")

    private static long serialVersionUID = 1421746759512286392L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.984 -0400", hash_original_field = "109308E5D4D5B0ADE2743F48081B723A", hash_generated_field = "DF3B779AC65293AACA2C768A9CD43464")

    private static ObjectStreamField[] serialPersistentFields = ;
}


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.155 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "19DEB795009FCB78D63A1C2C298CE954")

    private transient HashtableEntry<K, V>[] table;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.155 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "55DCA83C6162ACD637EB02860F7422EE")

    private transient int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.155 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "EDCBB672EA8C27007EA64BE3078BC69C")

    private transient int modCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.155 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "AC9BEC59E41404676A448C0DD2BB745B")

    private transient int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.155 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "EB6C570550CCFE8E5FEBB44BA37D02C0")

    private transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.155 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "BFDE585634496DDD7FBD15EDD2D3C5DD")

    private transient Set<Entry<K, V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.155 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "5A2A505CEEC79706812E901D735E2A7C")

    private transient Collection<V> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.155 -0400", hash_original_method = "9A93999031A29C4DD8DE295A6372F847", hash_generated_method = "6A7170C4C6FFAE127214BE36F7841D7F")
    @SuppressWarnings("unchecked")
    public  Hashtable() {
        table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1;
        // ---------- Original Method ----------
        //table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.156 -0400", hash_original_method = "6003D4D798348C1583CB15DE42C187C6", hash_generated_method = "6EAB6AF8B3A5141A9377339E4666364F")
    public  Hashtable(int capacity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Capacity: " + capacity);
        } //End block
        {
            @SuppressWarnings("unchecked") HashtableEntry<K, V>[] tab = (HashtableEntry<K, V>[]) EMPTY_TABLE;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.156 -0400", hash_original_method = "5B6B569F078844A0FAD42909C56D1E6D", hash_generated_method = "343E2D2DD4444DD049BB485112109618")
    public  Hashtable(int capacity, float loadFactor) {
        this(capacity);
        {
            boolean var7E96777C74EA86B66256F7B00F5AE961_1548891081 = (loadFactor <= 0 || Float.isNaN(loadFactor));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.156 -0400", hash_original_method = "6950B91F5E6C68C49CB594AFD1673B84", hash_generated_method = "9942D9644FF2A2AB7459A99EAC4A7ACB")
    public  Hashtable(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        constructorPutAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.159 -0400", hash_original_method = "6631235722E4D3190E3529D2039DDD7A", hash_generated_method = "B58DB30B084A51EFD3D5B70EAB9427C5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.160 -0400", hash_original_method = "F0D9AD485DB15C1D3427CA487C88BFBD", hash_generated_method = "A91E17FA9E63556ABD0BBBAC97F7E8BF")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1239472287 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1239472287 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1239472287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1239472287;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.160 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "E66331C216B0F694D75A518035E7A6C0")
    public synchronized boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_658792751 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_658792751;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.160 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "11308D5F0787F96896B90A459B3B57B7")
    public synchronized int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819754425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819754425;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.161 -0400", hash_original_method = "0D498A226869DEB0F3920DC31F67162F", hash_generated_method = "FBC2DBA2C43677139D8173214492BFF1")
    public synchronized V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1301495947 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_419327634 = null; //Variable for return #2
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashtableEntry<K, V>[] tab = table;
        {
            HashtableEntry<K, V> e = tab[hash & (tab.length - 1)];
            e = e.next;
            {
                K eKey = e.key;
                {
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_1424471803 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1301495947 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_419327634 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_261871219; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_261871219 = varB4EAC82CA7396A68D541C85D26508E83_1301495947;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_261871219 = varB4EAC82CA7396A68D541C85D26508E83_419327634;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_261871219.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_261871219;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.162 -0400", hash_original_method = "EDC536266386E3A88DC2FA7B05BC7882", hash_generated_method = "01118F5016133FD40E47018F29B8124C")
    public synchronized boolean containsKey(Object key) {
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashtableEntry<K, V>[] tab = table;
        {
            HashtableEntry<K, V> e = tab[hash & (tab.length - 1)];
            e = e.next;
            {
                K eKey = e.key;
                {
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_240681002 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1954283980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1954283980;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.163 -0400", hash_original_method = "22B2A1F3D878FCC53A2BA6539B84615E", hash_generated_method = "33D8CEBF199B74023BBF531A089B81BA")
    public synchronized boolean containsValue(Object value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        HashtableEntry[] tab = table;
        int len = tab.length;
        {
            int i = 0;
            {
                {
                    HashtableEntry e = tab[i];
                    e = e.next;
                    {
                        {
                            boolean varB228932AA07990623CC3C29EF03F40DA_1732889604 = (value.equals(e.value));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_272959850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_272959850;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.164 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "CC89CD8209E0FA6DEE3311932BCF2938")
    public boolean contains(Object value) {
        boolean var9D0C71166B134CB9FEA4F5814A8E4863_145257129 = (containsValue(value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1344190710 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1344190710;
        // ---------- Original Method ----------
        //return containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.165 -0400", hash_original_method = "70A37B9812099DB6AA6597919714B995", hash_generated_method = "017EE2BB178CFF8D32B17981B93648FA")
    public synchronized V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_537254614 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_600411525 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        HashtableEntry<K, V> first = tab[index];
        {
            HashtableEntry<K, V> e = first;
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1163913607 = (e.hash == hash && key.equals(e.key));
                    {
                        V oldValue = e.value;
                        e.value = value;
                        varB4EAC82CA7396A68D541C85D26508E83_537254614 = oldValue;
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
        varB4EAC82CA7396A68D541C85D26508E83_600411525 = null;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1164684187; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1164684187 = varB4EAC82CA7396A68D541C85D26508E83_537254614;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1164684187 = varB4EAC82CA7396A68D541C85D26508E83_600411525;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1164684187.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1164684187;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.166 -0400", hash_original_method = "DD29A5E73441E57ACE3C1AF694856AF1", hash_generated_method = "1D74224909779868C67B4A04EBB6A6F7")
    private void constructorPut(K key, V value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        HashtableEntry<K, V> first = tab[index];
        {
            HashtableEntry<K, V> e = first;
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_495849710 = (e.hash == hash && key.equals(e.key));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.173 -0400", hash_original_method = "46C920EF16234ECC2EBDE62DDADD6435", hash_generated_method = "0544AE9AED41A82DB1322BE6F491C3AB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.174 -0400", hash_original_method = "5BCC94324BA2D5ECBED6314BEA7D0FA8", hash_generated_method = "9BD7D3268B924110DB6123380DF38318")
    private void ensureCapacity(int numMappings) {
        int newCapacity = roundUpToPowerOfTwo(capacityForInitSize(numMappings));
        HashtableEntry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;
        rehash();
        {
            doubleCapacity();
        } //End block
        HashtableEntry<K, V>[] newTable = makeTable(newCapacity);
        {
            int newMask = newCapacity - 1;
            {
                int i = 0;
                {
                    {
                        HashtableEntry<K, V> e = oldTable[i];
                        {
                            HashtableEntry<K, V> oldNext = e.next;
                            int newIndex = e.hash & newMask;
                            HashtableEntry<K, V> newNext = newTable[newIndex];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.175 -0400", hash_original_method = "CC28673E29B73787492CFDC805600F5D", hash_generated_method = "E3452D490AF44DF99FFD2B9DFC516DAB")
    protected void rehash() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.176 -0400", hash_original_method = "8FDFD015009EFB98FD90E5E66F0193AF", hash_generated_method = "E7476A72566D553E81F6D4ACA2ECEDF6")
    private HashtableEntry<K, V>[] makeTable(int newCapacity) {
        HashtableEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1826126259 = null; //Variable for return #1
        @SuppressWarnings("unchecked") HashtableEntry<K, V>[] newTable = (HashtableEntry<K, V>[]) new HashtableEntry[newCapacity];
        table = newTable;
        threshold = (newCapacity >> 1) + (newCapacity >> 2);
        varB4EAC82CA7396A68D541C85D26508E83_1826126259 = newTable;
        varB4EAC82CA7396A68D541C85D26508E83_1826126259.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1826126259;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked") HashtableEntry<K, V>[] newTable
                //= (HashtableEntry<K, V>[]) new HashtableEntry[newCapacity];
        //table = newTable;
        //threshold = (newCapacity >> 1) + (newCapacity >> 2);
        //return newTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.177 -0400", hash_original_method = "291B56F25D1E56D0A03492C2073BE506", hash_generated_method = "C635ADA2E8D52CC164E2CF71C970DA23")
    private HashtableEntry<K, V>[] doubleCapacity() {
        HashtableEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1954360466 = null; //Variable for return #1
        HashtableEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1504976486 = null; //Variable for return #2
        HashtableEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1785951523 = null; //Variable for return #3
        HashtableEntry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1954360466 = oldTable;
        } //End block
        int newCapacity = oldCapacity * 2;
        HashtableEntry<K, V>[] newTable = makeTable(newCapacity);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1504976486 = newTable;
        } //End block
        {
            int j = 0;
            {
                HashtableEntry<K, V> e = oldTable[j];
                int highBit = e.hash & oldCapacity;
                HashtableEntry<K, V> broken = null;
                newTable[j | highBit] = e;
                {
                    HashtableEntry<K,V> n = e.next;
                    e = n;
                    n = n.next;
                    {
                        int nextHighBit = n.hash & oldCapacity;
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
        varB4EAC82CA7396A68D541C85D26508E83_1785951523 = newTable;
        HashtableEntry<K, V>[] varA7E53CE21691AB073D9660D615818899_1182554135; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1182554135 = varB4EAC82CA7396A68D541C85D26508E83_1954360466;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1182554135 = varB4EAC82CA7396A68D541C85D26508E83_1504976486;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1182554135 = varB4EAC82CA7396A68D541C85D26508E83_1785951523;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1182554135.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1182554135;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.179 -0400", hash_original_method = "B19FA41811C96CC39A17F943778772D8", hash_generated_method = "D10D8D98754023FC1F4732126DEFEC58")
    public synchronized V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1062299784 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_668630550 = null; //Variable for return #2
        int hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        {
            HashtableEntry<K, V> e = tab[index];
            HashtableEntry<K, V> prev = null;
            prev = e;
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1635627126 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            tab[index] = e.next;
                        } //End block
                        {
                            prev.next = e.next;
                        } //End block
                        varB4EAC82CA7396A68D541C85D26508E83_1062299784 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_668630550 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_2113741514; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2113741514 = varB4EAC82CA7396A68D541C85D26508E83_1062299784;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2113741514 = varB4EAC82CA7396A68D541C85D26508E83_668630550;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2113741514.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2113741514;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.180 -0400", hash_original_method = "1C0D329A7E5E91219CE97B2AC82E739C", hash_generated_method = "D68A0CADC876BC1431B9C8C9FB2DDE0F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.181 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "84AACD14FD49D9AABCF24BA8FD553AB8")
    public synchronized Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_1443357696 = null; //Variable for return #1
        Set<K> ks = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_1443357696 = (ks != null) ? ks : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_1443357696.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1443357696;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.183 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "A80360C112D7F38E80A51340640B0CD9")
    public synchronized Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1683593318 = null; //Variable for return #1
        Collection<V> vs = values;
        varB4EAC82CA7396A68D541C85D26508E83_1683593318 = (vs != null) ? vs : (values = new Values());
        varB4EAC82CA7396A68D541C85D26508E83_1683593318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1683593318;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.183 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "54BD04FFAE24B32C63CC73572F174EAD")
    public synchronized Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1281002365 = null; //Variable for return #1
        Set<Entry<K, V>> es = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_1281002365 = (es != null) ? es : (entrySet = new EntrySet());
        varB4EAC82CA7396A68D541C85D26508E83_1281002365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1281002365;
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.184 -0400", hash_original_method = "BD8590C2A6B44E1AD87F42CA1DDBEEC0", hash_generated_method = "7214D6FA50CA0A936A31C35EA68D9AB0")
    public synchronized Enumeration<K> keys() {
        Enumeration<K> varB4EAC82CA7396A68D541C85D26508E83_1109961763 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1109961763 = new KeyEnumeration();
        varB4EAC82CA7396A68D541C85D26508E83_1109961763.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1109961763;
        // ---------- Original Method ----------
        //return new KeyEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.184 -0400", hash_original_method = "D92B3AB4F78D152BCFDB4F438052384E", hash_generated_method = "6A4D4F032DCFF3C164F1108BC95F3A0A")
    public synchronized Enumeration<V> elements() {
        Enumeration<V> varB4EAC82CA7396A68D541C85D26508E83_1787748726 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1787748726 = new ValueEnumeration();
        varB4EAC82CA7396A68D541C85D26508E83_1787748726.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1787748726;
        // ---------- Original Method ----------
        //return new ValueEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.185 -0400", hash_original_method = "CF57466F07C2DB8AF5EFB522D22E3680", hash_generated_method = "4A43E656B38951C497F1612344632091")
    private synchronized boolean containsMapping(Object key, Object value) {
        int hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        {
            HashtableEntry<K, V> e = tab[index];
            e = e.next;
            {
                {
                    boolean varBF092BC27A863E23FE4C44D225ED1FDA_1202835502 = (e.hash == hash && e.key.equals(key));
                    {
                        boolean var6C13353AEE37EBEED16BB037A146133C_83014206 = (e.value.equals(value));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2126575317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2126575317;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.186 -0400", hash_original_method = "A191738781408606E816E9A37080097D", hash_generated_method = "A56F5B2271466690EC3FB31E9A224A9D")
    private synchronized boolean removeMapping(Object key, Object value) {
        int hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        {
            HashtableEntry<K, V> e = tab[index];
            HashtableEntry<K, V> prev = null;
            prev = e;
            e = e.next;
            {
                {
                    boolean varBF092BC27A863E23FE4C44D225ED1FDA_4079125 = (e.hash == hash && e.key.equals(key));
                    {
                        {
                            boolean var876C169E101ABBE81C5DB09387C8C08C_800768001 = (!e.value.equals(value));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639902329 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639902329;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.186 -0400", hash_original_method = "9BC17AC5DA957A9C0A07708C3D3A3E68", hash_generated_method = "3AF86BDA93BE0EDD3D88B14E75FC8C7E")
    @Override
    public synchronized boolean equals(Object object) {
        boolean varF1443A15804B24DDE99B981E7E34D8C9_1565248919 = ((object instanceof Map) &&
                entrySet().equals(((Map<?, ?>)object).entrySet()));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1564774767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1564774767;
        // ---------- Original Method ----------
        //return (object instanceof Map) &&
                //entrySet().equals(((Map<?, ?>)object).entrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.194 -0400", hash_original_method = "0904BEF2CA25AF4229493E32A4F8928E", hash_generated_method = "B8266596A962C98ECA8BE4D33354ED0D")
    @Override
    public synchronized int hashCode() {
        int result = 0;
        {
            Iterator<Entry<K, V>> varD93A6471022189C0BA28AFBB8C8557A0_1163448282 = (entrySet()).iterator();
            varD93A6471022189C0BA28AFBB8C8557A0_1163448282.hasNext();
            Entry<K, V> e = varD93A6471022189C0BA28AFBB8C8557A0_1163448282.next();
            {
                K key = e.getKey();
                V value = e.getValue();
                {
                    boolean varA5737C8BC3A00C9E9A68B0C1A8552473_495859636 = (key == this || value == this);
                } //End collapsed parenthetic
                result += (key != null ? key.hashCode() : 0)
                    ^ (value != null ? value.hashCode() : 0);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786896019 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786896019;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.197 -0400", hash_original_method = "A78197C1027A9ECA0DF472B01066EEE7", hash_generated_method = "BF38FAE916B71D1D616EF4D087021FBA")
    @Override
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2015488043 = null; //Variable for return #1
        StringBuilder result = new StringBuilder(CHARS_PER_ENTRY * size);
        result.append('{');
        Iterator<Entry<K, V>> i = entrySet().iterator();
        boolean hasMore = i.hasNext();
        {
            Entry<K, V> entry = i.next();
            K key = entry.getKey();
            result.append(key == this ? "(this Map)" : key.toString());
            result.append('=');
            V value = entry.getValue();
            result.append(value == this ? "(this Map)" : value.toString());
            {
                boolean var41667EFB1D4E18743BE89148FA51235C_1418131222 = (hasMore = i.hasNext());
                {
                    result.append(", ");
                } //End block
            } //End collapsed parenthetic
        } //End block
        result.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_2015488043 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2015488043.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2015488043;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.206 -0400", hash_original_method = "19818AA4E6F1DBA67EBB75B368743917", hash_generated_method = "93455CF15D0DD92FA163C8C0F59DDC60")
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("threshold",  (int) (DEFAULT_LOAD_FACTOR * table.length));
        fields.put("loadFactor", DEFAULT_LOAD_FACTOR);
        stream.writeFields();
        stream.writeInt(table.length);
        stream.writeInt(size);
        {
            Iterator<Entry<K, V>> varD93A6471022189C0BA28AFBB8C8557A0_680058942 = (entrySet()).iterator();
            varD93A6471022189C0BA28AFBB8C8557A0_680058942.hasNext();
            Entry<K, V> e = varD93A6471022189C0BA28AFBB8C8557A0_680058942.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.206 -0400", hash_original_method = "2EADB0DA3622DE13512805CD17FDFE7A", hash_generated_method = "27D4524AADC0DFC7A1F031E01B5A25CD")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        int capacity = stream.readInt();
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
        int size = stream.readInt();
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Size: " + size);
        } //End block
        {
            int i = 0;
            {
                @SuppressWarnings("unchecked") K key = (K) stream.readObject();
                @SuppressWarnings("unchecked") V val = (V) stream.readObject();
                constructorPut(key, val);
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class HashtableEntry<K, V> implements Entry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.207 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.207 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.207 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.207 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A5AC9F76C2A7B9F6F79010A5F4A3B4B7")

        HashtableEntry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.207 -0400", hash_original_method = "FCC59894C2665A76D7100104D46402EE", hash_generated_method = "7F8F2DB59D28E587038E679033461007")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.208 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "3C05479CB8A0311398AD0103DB2EC295")
        public final K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1872500954 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1872500954 = key;
            varB4EAC82CA7396A68D541C85D26508E83_1872500954.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1872500954;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.208 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "03829FFF535081C33A726BAC0FC80E54")
        public final V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_2073686591 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2073686591 = value;
            varB4EAC82CA7396A68D541C85D26508E83_2073686591.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2073686591;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.209 -0400", hash_original_method = "09EE506DF55191FF6B72960EEA25D181", hash_generated_method = "14E2E1CAF6603C87F56826DDD7A0598C")
        public final V setValue(V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_815686376 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            V oldValue = this.value;
            this.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_815686376 = oldValue;
            varB4EAC82CA7396A68D541C85D26508E83_815686376.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_815686376;
            // ---------- Original Method ----------
            //if (value == null) {
                //throw new NullPointerException();
            //}
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.209 -0400", hash_original_method = "509D67FA76563438156B3275F90914F5", hash_generated_method = "883212E8A991E38DB8B8B92EC522BDD7")
        @Override
        public final boolean equals(Object o) {
            Entry<?, ?> e = (Entry<?, ?>) o;
            boolean varE09B45BE378FDDE1749CF5314C9B65A1_132537241 = (key.equals(e.getKey()) && value.equals(e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016259042 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016259042;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return key.equals(e.getKey()) && value.equals(e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.209 -0400", hash_original_method = "28D407F854479314A0A7C3BE1F12A9AB", hash_generated_method = "B79CFF8E6A7A368B391E1E8398D2B7FE")
        @Override
        public final int hashCode() {
            int varCC7293A69A74489DFEF0094B17563C76_119479975 = (key.hashCode() ^ value.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531197685 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531197685;
            // ---------- Original Method ----------
            //return key.hashCode() ^ value.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.210 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "B5102B3C31DF80EDE1D23CEABCF1EC65")
        @Override
        public final String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1954827189 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1954827189 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_1954827189.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1954827189;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
    }


    
    private abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.210 -0400", hash_original_field = "B6F75212F617C3E247C9474AFDA3B784", hash_generated_field = "04911A8A6B33F6D23811475122C95D0E")

        int nextIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.210 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "7A671A08D7EC5144843A6963DC69FDC7")

        HashtableEntry<K, V> nextEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.210 -0400", hash_original_field = "8A3A9937F6D0DA3448C9C061B347CECF", hash_generated_field = "7DA4F26BBE36FAFDC112AEE30391E8D1")

        HashtableEntry<K, V> lastEntryReturned;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.210 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "17128C49BCF19B4186F02F384F2DEA86")

        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.210 -0400", hash_original_method = "1BB35CB0E7E6DF7A5633A61B0F63C5AA", hash_generated_method = "A9AD649000D442301C43851C4A22B454")
          HashIterator() {
            HashtableEntry<K, V>[] tab = table;
            HashtableEntry<K, V> next = null;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.211 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "7DDB0489D3955D9447D2A6418FAC7A01")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_620077703 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_620077703;
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.212 -0400", hash_original_method = "5FA6641462F5564CAC982C4AF6FCFB6C", hash_generated_method = "3D3112BDA762F77E57F103236FE13298")
         HashtableEntry<K, V> nextEntry() {
            HashtableEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_910336998 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            HashtableEntry<K, V> entryToReturn = nextEntry;
            HashtableEntry<K, V>[] tab = table;
            HashtableEntry<K, V> next = entryToReturn.next;
            {
                next = tab[nextIndex++];
            } //End block
            nextEntry = next;
            varB4EAC82CA7396A68D541C85D26508E83_910336998 = lastEntryReturned = entryToReturn;
            varB4EAC82CA7396A68D541C85D26508E83_910336998.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_910336998;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.214 -0400", hash_original_method = "1C3D72122BB58702CE822C81122C0D27", hash_generated_method = "D0CB4BB7C4D994ADDAA686AB0ECA6DF4")
         HashtableEntry<K, V> nextEntryNotFailFast() {
            HashtableEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_882643752 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            HashtableEntry<K, V> entryToReturn = nextEntry;
            HashtableEntry<K, V>[] tab = table;
            HashtableEntry<K, V> next = entryToReturn.next;
            {
                next = tab[nextIndex++];
            } //End block
            nextEntry = next;
            varB4EAC82CA7396A68D541C85D26508E83_882643752 = lastEntryReturned = entryToReturn;
            varB4EAC82CA7396A68D541C85D26508E83_882643752.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_882643752;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.215 -0400", hash_original_method = "342FDC52CA82B385D96AADB83EE8F936", hash_generated_method = "55CA60158E545DDD18DDAB246D1BF2A1")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.215 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.215 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "BE9CA147DB41889E3336DD6D593D462A")
        public K next() {
            K varB4EAC82CA7396A68D541C85D26508E83_114810037 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_114810037 = nextEntry().key;
            varB4EAC82CA7396A68D541C85D26508E83_114810037.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_114810037;
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends HashIterator implements Iterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.215 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.216 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "082A6C2D2077BCA990271F34540B9D75")
        public V next() {
            V varB4EAC82CA7396A68D541C85D26508E83_1319744898 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1319744898 = nextEntry().value;
            varB4EAC82CA7396A68D541C85D26508E83_1319744898.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1319744898;
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.216 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.217 -0400", hash_original_method = "C7E2B840B075445DC1033B130AB2E6A6", hash_generated_method = "BDC3B28FACA5221D09915CD3636EAABA")
        public Entry<K, V> next() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_802093272 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_802093272 = nextEntry();
            varB4EAC82CA7396A68D541C85D26508E83_802093272.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_802093272;
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private final class KeyEnumeration extends HashIterator implements Enumeration<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.217 -0400", hash_original_method = "2E46AFA79C505478BD5C8702CDCDD1D4", hash_generated_method = "2E46AFA79C505478BD5C8702CDCDD1D4")
        public KeyEnumeration ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.218 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "3DB3E683C98210B54ED02284A6CD76CF")
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_1684907323 = (hasNext());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_454430351 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_454430351;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.219 -0400", hash_original_method = "BED82438F0CBBB90FF7803670DD55802", hash_generated_method = "C81D865AE0141FC46D70F81E2950D564")
        public K nextElement() {
            K varB4EAC82CA7396A68D541C85D26508E83_1593422259 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1593422259 = nextEntryNotFailFast().key;
            varB4EAC82CA7396A68D541C85D26508E83_1593422259.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1593422259;
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().key;
        }

        
    }


    
    private final class ValueEnumeration extends HashIterator implements Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.219 -0400", hash_original_method = "0C70885115EB664BF7ADABD8AB769AB3", hash_generated_method = "0C70885115EB664BF7ADABD8AB769AB3")
        public ValueEnumeration ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.219 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "D48F6787068ED83B9EAEBEEDC6B752DE")
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_799341549 = (hasNext());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1684621122 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1684621122;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.222 -0400", hash_original_method = "433328C2A0882CA6574B6B21E730CA05", hash_generated_method = "38FBA5580CF2DE628A16DA05855D7FD0")
        public V nextElement() {
            V varB4EAC82CA7396A68D541C85D26508E83_1968089166 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1968089166 = nextEntryNotFailFast().value;
            varB4EAC82CA7396A68D541C85D26508E83_1968089166.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1968089166;
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().value;
        }

        
    }


    
    private final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.222 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.224 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "DB185CAA1B2F96A8E299ECEF0E33694D")
        public Iterator<K> iterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_514825137 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_514825137 = new KeyIterator();
            varB4EAC82CA7396A68D541C85D26508E83_514825137.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_514825137;
            // ---------- Original Method ----------
            //return new KeyIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.225 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "590B7F115417FF410FA10CF967A5C1FB")
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_124125673 = (Hashtable.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662123195 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662123195;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.227 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "82761CCA72967ECDF7C461AB57F2E40B")
        public boolean contains(Object o) {
            boolean var997BAB39B2F072D5CD66A271F3B6E196_653199114 = (containsKey(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340788259 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_340788259;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.228 -0400", hash_original_method = "FF159DEBFD9D37DD2EC80383AA98B734", hash_generated_method = "AD427DB4F066B8FA0C30DAF558ECE8F6")
        public boolean remove(Object o) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_397329513 = (Hashtable.this);
                {
                    int oldSize = size;
                    Hashtable.this.remove(o);
                } //End block
            } //End collapsed parenthetic
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_405958818 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_405958818;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //int oldSize = size;
                //Hashtable.this.remove(o);
                //return size != oldSize;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.228 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.229 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "EE3C24241DAE633AF73690D98F6FE678")
        public boolean removeAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1891092015 = (Hashtable.this);
                {
                    boolean varF33472708DFFFDAF6959DE4125160D76_1672184806 = (super.removeAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216511994 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216511994;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.229 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "5B43FF15B559815F3622FD5DD20B4821")
        public boolean retainAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1876814011 = (Hashtable.this);
                {
                    boolean var802E13F1B176A50DBD94ED7EACD6E76C_1144380607 = (super.retainAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_665817648 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_665817648;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.230 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "2372F4AA9552F6B5DA5D39FA652C473D")
        public boolean containsAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1646452751 = (Hashtable.this);
                {
                    boolean var7FF1A279AF3532345951D9FAAC0AC82D_1681988834 = (super.containsAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1907028422 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1907028422;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.230 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "768106FF997D35DD891D5C875A55D927")
        public boolean equals(Object object) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_556730330 = (Hashtable.this);
                {
                    boolean var5BE46525B597E36F672CA971A0B1396F_566796920 = (super.equals(object));
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1283192364 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1283192364;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.230 -0400", hash_original_method = "2EB37718E343BC9663B783B0FC3BE747", hash_generated_method = "89B9D1464096F9369B127FBBB3B65B07")
        public int hashCode() {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_735247951 = (Hashtable.this);
                {
                    int varC1EBD1993309EE605028A8712B798C0E_1563237274 = (super.hashCode());
                } //End block
            } //End collapsed parenthetic
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400406982 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400406982;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.231 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "D355C8A5C700AC89E37471025AF17C23")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_106289748 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1796093595 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_106289748 = super.toString();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_106289748.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_106289748;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.232 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "920DA18C007934ADC28B39DB6AEE1405")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1650787410 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_205208466 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1650787410 = super.toArray();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1650787410.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1650787410;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.233 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "2D12CD4C2AD0ABD5F7D50216091F9074")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_769781133 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1322514282 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_769781133 = super.toArray(a);
                } //End block
            } //End collapsed parenthetic
            addTaint(a[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_769781133.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_769781133;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.233 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.234 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "8C95B7BE352B405F58186A6F04B0E4C9")
        public Iterator<V> iterator() {
            Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_645755456 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_645755456 = new ValueIterator();
            varB4EAC82CA7396A68D541C85D26508E83_645755456.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_645755456;
            // ---------- Original Method ----------
            //return new ValueIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.234 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "1D4611C5992C95D1F46B27E7794A9068")
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_629902488 = (Hashtable.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449194166 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449194166;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.235 -0400", hash_original_method = "C13053467D6FDF772DF450C87D40A3D5", hash_generated_method = "CE01C43D220AE22D7E8D18FEE7FE6A01")
        public boolean contains(Object o) {
            boolean varD1EEFCBD27E28C71EA594EC596966CFD_597147049 = (containsValue(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_194731101 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_194731101;
            // ---------- Original Method ----------
            //return containsValue(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.235 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.235 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "3959EF1BC9EB86FC8B0FC2DF34D51886")
        public boolean containsAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1769371674 = (Hashtable.this);
                {
                    boolean var7FF1A279AF3532345951D9FAAC0AC82D_1675833816 = (super.containsAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1052755081 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1052755081;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.236 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "EB65BB29BE19FE1D2C2E771867296AE0")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_611145206 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1120048710 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_611145206 = super.toString();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_611145206.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_611145206;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.237 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "54E575725F6F3BDF2065132BFCAF9474")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1518018676 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_2084371503 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1518018676 = super.toArray();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1518018676.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1518018676;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.238 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "5FA31E39905CC133AD4D31396DDF5697")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1860107476 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1086983075 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1860107476 = super.toArray(a);
                } //End block
            } //End collapsed parenthetic
            addTaint(a[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1860107476.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1860107476;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.238 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.238 -0400", hash_original_method = "D7164BC97FFDCB587AB273006C953E50", hash_generated_method = "7A1AE6AE50C2BA675B30BB0124A5C622")
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_749247636 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_749247636 = new EntryIterator();
            varB4EAC82CA7396A68D541C85D26508E83_749247636.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_749247636;
            // ---------- Original Method ----------
            //return new EntryIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.238 -0400", hash_original_method = "6E695F138E29D844DC896198513B6135", hash_generated_method = "A8B581B305DF067EF1487DD29FCD2C6F")
        public boolean contains(Object o) {
            Entry<?, ?> e = (Entry<?, ?>) o;
            boolean varEC3A3E183CD0A7D33A5B45EDAE091B2E_7816169 = (containsMapping(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1139601097 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1139601097;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return containsMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.239 -0400", hash_original_method = "F484CBC8566C601718EDE0034034C7B3", hash_generated_method = "74AA97C663C23DA0F81A5770379F1232")
        public boolean remove(Object o) {
            Entry<?, ?> e = (Entry<?, ?>)o;
            boolean var598A216136B4C4D06069F46B6EC81DD9_2000896376 = (removeMapping(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1289824911 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1289824911;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>)o;
            //return removeMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.239 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "8CB048027C54A26D76B4791E6E064BCC")
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_2106438175 = (Hashtable.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416099623 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416099623;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.239 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.240 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "3DB9B75995C17FB9EF3C29D82CE909BB")
        public boolean removeAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1960223119 = (Hashtable.this);
                {
                    boolean varF33472708DFFFDAF6959DE4125160D76_1427418379 = (super.removeAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1713665067 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1713665067;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.240 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "DEDE71F112E48E3B355805B731FC3ED8")
        public boolean retainAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1682366602 = (Hashtable.this);
                {
                    boolean var802E13F1B176A50DBD94ED7EACD6E76C_517650037 = (super.retainAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_132414678 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_132414678;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.240 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "B9EBB6B901D94E7F2288967390CE13EF")
        public boolean containsAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1750998815 = (Hashtable.this);
                {
                    boolean var7FF1A279AF3532345951D9FAAC0AC82D_871786656 = (super.containsAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1268177226 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1268177226;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.241 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "6AE6CC8FC03125B1AFEAC9D1254A0329")
        public boolean equals(Object object) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1966547597 = (Hashtable.this);
                {
                    boolean var5BE46525B597E36F672CA971A0B1396F_629231659 = (super.equals(object));
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779652624 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779652624;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.241 -0400", hash_original_method = "3000FE237E7845AEAFDA2B41B0704346", hash_generated_method = "D21ED05B96F20FC8ECB7862E1137E84D")
        public int hashCode() {
            int var888832939E9A16C553FA6EB5FC57B96E_1423525886 = (Hashtable.this.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_943060354 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_943060354;
            // ---------- Original Method ----------
            //return Hashtable.this.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.242 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "C39C927F4E3C6BE10574A3CDB4CD7971")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1426075798 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1960388091 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1426075798 = super.toString();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1426075798.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1426075798;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.242 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "D40336D0A297196240AF358777F3CCA3")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1512175706 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_369519505 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1512175706 = super.toArray();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1512175706.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1512175706;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.243 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "5F7284A99E09C9252DE21EE841980FB7")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1592433286 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_324855842 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1592433286 = super.toArray(a);
                } //End block
            } //End collapsed parenthetic
            addTaint(a[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1592433286.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1592433286;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.243 -0400", hash_original_field = "74773297EBE9767DD8F1E8A0F109042B", hash_generated_field = "2D66E915A2C4A5FBF28A99892F20B1AF")

    private static final int MINIMUM_CAPACITY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.243 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "C94813E6F46C48A83BBFCFA3C9862983")

    private static final int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.243 -0400", hash_original_field = "215B48891AB1D8DA059087E167B4E6A3", hash_generated_field = "BC3AFA3625EEAFE404B4E2EE0E75EE0F")

    private static final Entry[] EMPTY_TABLE = new HashtableEntry[MINIMUM_CAPACITY >>> 1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.243 -0400", hash_original_field = "2457D6689D4C035FB0208C51E3216836", hash_generated_field = "41B5CEA68D112450CD83A4199938FEF0")

    private static final float DEFAULT_LOAD_FACTOR = .75F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.243 -0400", hash_original_field = "C12E356D9C08DF40A0A68843ED778698", hash_generated_field = "46C6C9B52666C02F378F5368FD774F43")

    private static final int CHARS_PER_ENTRY = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.243 -0400", hash_original_field = "5908451E267AA95A476F28CC7A33B199", hash_generated_field = "C70DCA64D7F48D81CC1FCEA91128ADE1")

    private static final long serialVersionUID = 1421746759512286392L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.243 -0400", hash_original_field = "109308E5D4D5B0ADE2743F48081B723A", hash_generated_field = "BED226748EC460106938E3D870C7138F")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("threshold", int.class),
        new ObjectStreamField("loadFactor", float.class),
    };
}


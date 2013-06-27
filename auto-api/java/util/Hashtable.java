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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.543 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "19DEB795009FCB78D63A1C2C298CE954")

    private transient HashtableEntry<K, V>[] table;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.543 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "55DCA83C6162ACD637EB02860F7422EE")

    private transient int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.543 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "EDCBB672EA8C27007EA64BE3078BC69C")

    private transient int modCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.543 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "AC9BEC59E41404676A448C0DD2BB745B")

    private transient int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.543 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "EB6C570550CCFE8E5FEBB44BA37D02C0")

    private transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.543 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "BFDE585634496DDD7FBD15EDD2D3C5DD")

    private transient Set<Entry<K, V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.543 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "5A2A505CEEC79706812E901D735E2A7C")

    private transient Collection<V> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.544 -0400", hash_original_method = "9A93999031A29C4DD8DE295A6372F847", hash_generated_method = "6A7170C4C6FFAE127214BE36F7841D7F")
    @SuppressWarnings("unchecked")
    public  Hashtable() {
        table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1;
        // ---------- Original Method ----------
        //table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.544 -0400", hash_original_method = "6003D4D798348C1583CB15DE42C187C6", hash_generated_method = "8C486488FEBC94DCBEBBA43CC60196AD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.545 -0400", hash_original_method = "5B6B569F078844A0FAD42909C56D1E6D", hash_generated_method = "0E6FCC888666E9801CD1C67573E75977")
    public  Hashtable(int capacity, float loadFactor) {
        this(capacity);
        {
            boolean var7E96777C74EA86B66256F7B00F5AE961_234273137 = (loadFactor <= 0 || Float.isNaN(loadFactor));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.545 -0400", hash_original_method = "6950B91F5E6C68C49CB594AFD1673B84", hash_generated_method = "9942D9644FF2A2AB7459A99EAC4A7ACB")
    public  Hashtable(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        constructorPutAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.573 -0400", hash_original_method = "6631235722E4D3190E3529D2039DDD7A", hash_generated_method = "B58DB30B084A51EFD3D5B70EAB9427C5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.574 -0400", hash_original_method = "F0D9AD485DB15C1D3427CA487C88BFBD", hash_generated_method = "96FFD07200C460EAFEF13691DA4C4071")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_433948553 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_433948553 = result;
        varB4EAC82CA7396A68D541C85D26508E83_433948553.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_433948553;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.575 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "676808E44B8FA2AF85C6B53A8E49BDB6")
    public synchronized boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_194998689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_194998689;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.575 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "46CC790A409EE680F2FA86BA5AD94366")
    public synchronized int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909507068 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909507068;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.579 -0400", hash_original_method = "0D498A226869DEB0F3920DC31F67162F", hash_generated_method = "B1064FAAAFD5A058F181EC8C170D5FB6")
    public synchronized V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1007351836 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_96178428 = null; //Variable for return #2
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
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_2147105803 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1007351836 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_96178428 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_548846801; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_548846801 = varB4EAC82CA7396A68D541C85D26508E83_1007351836;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_548846801 = varB4EAC82CA7396A68D541C85D26508E83_96178428;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_548846801.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_548846801;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.606 -0400", hash_original_method = "EDC536266386E3A88DC2FA7B05BC7882", hash_generated_method = "F511198C411F151E570718937E7B4773")
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
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_1293581036 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_120396276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_120396276;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.606 -0400", hash_original_method = "22B2A1F3D878FCC53A2BA6539B84615E", hash_generated_method = "E2C45CB0D98EDD34D7004A7686809003")
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
                            boolean varB228932AA07990623CC3C29EF03F40DA_1030507786 = (value.equals(e.value));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1283484235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1283484235;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.607 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "8C5A39EE03D53E53A4CE6958E8386FEB")
    public boolean contains(Object value) {
        boolean var9D0C71166B134CB9FEA4F5814A8E4863_1620399281 = (containsValue(value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222033887 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_222033887;
        // ---------- Original Method ----------
        //return containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.625 -0400", hash_original_method = "70A37B9812099DB6AA6597919714B995", hash_generated_method = "B96841CEA0194C0229412DBA2868904C")
    public synchronized V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1739622256 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1555628355 = null; //Variable for return #2
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_883195118 = (e.hash == hash && key.equals(e.key));
                    {
                        V oldValue;
                        oldValue = e.value;
                        e.value = value;
                        varB4EAC82CA7396A68D541C85D26508E83_1739622256 = oldValue;
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
        varB4EAC82CA7396A68D541C85D26508E83_1555628355 = null;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1437584220; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1437584220 = varB4EAC82CA7396A68D541C85D26508E83_1739622256;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1437584220 = varB4EAC82CA7396A68D541C85D26508E83_1555628355;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1437584220.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1437584220;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.626 -0400", hash_original_method = "DD29A5E73441E57ACE3C1AF694856AF1", hash_generated_method = "9CD0A1C9E65F54D79DCDAD2E7C68D4CB")
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_253897906 = (e.hash == hash && key.equals(e.key));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.662 -0400", hash_original_method = "46C920EF16234ECC2EBDE62DDADD6435", hash_generated_method = "0544AE9AED41A82DB1322BE6F491C3AB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.663 -0400", hash_original_method = "5BCC94324BA2D5ECBED6314BEA7D0FA8", hash_generated_method = "410BDC902D93FE57D25A2339D187F568")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.663 -0400", hash_original_method = "CC28673E29B73787492CFDC805600F5D", hash_generated_method = "E3452D490AF44DF99FFD2B9DFC516DAB")
    protected void rehash() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.664 -0400", hash_original_method = "8FDFD015009EFB98FD90E5E66F0193AF", hash_generated_method = "B059B0C6A7D79449EF9939124678ED42")
    private HashtableEntry<K, V>[] makeTable(int newCapacity) {
        HashtableEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_439748933 = null; //Variable for return #1
        @SuppressWarnings("unchecked") HashtableEntry<K, V>[] newTable;
        newTable = (HashtableEntry<K, V>[]) new HashtableEntry[newCapacity];
        table = newTable;
        threshold = (newCapacity >> 1) + (newCapacity >> 2);
        varB4EAC82CA7396A68D541C85D26508E83_439748933 = newTable;
        varB4EAC82CA7396A68D541C85D26508E83_439748933.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_439748933;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked") HashtableEntry<K, V>[] newTable
                //= (HashtableEntry<K, V>[]) new HashtableEntry[newCapacity];
        //table = newTable;
        //threshold = (newCapacity >> 1) + (newCapacity >> 2);
        //return newTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.665 -0400", hash_original_method = "291B56F25D1E56D0A03492C2073BE506", hash_generated_method = "51A0B671C3954E6AC09936DF1637D348")
    private HashtableEntry<K, V>[] doubleCapacity() {
        HashtableEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1241763884 = null; //Variable for return #1
        HashtableEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1375922420 = null; //Variable for return #2
        HashtableEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_3872862 = null; //Variable for return #3
        HashtableEntry<K, V>[] oldTable;
        oldTable = table;
        int oldCapacity;
        oldCapacity = oldTable.length;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1241763884 = oldTable;
        } //End block
        int newCapacity;
        newCapacity = oldCapacity * 2;
        HashtableEntry<K, V>[] newTable;
        newTable = makeTable(newCapacity);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1375922420 = newTable;
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
        varB4EAC82CA7396A68D541C85D26508E83_3872862 = newTable;
        HashtableEntry<K, V>[] varA7E53CE21691AB073D9660D615818899_1338936319; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1338936319 = varB4EAC82CA7396A68D541C85D26508E83_1241763884;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1338936319 = varB4EAC82CA7396A68D541C85D26508E83_1375922420;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1338936319 = varB4EAC82CA7396A68D541C85D26508E83_3872862;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1338936319.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1338936319;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.678 -0400", hash_original_method = "B19FA41811C96CC39A17F943778772D8", hash_generated_method = "F8531D8DF494CE6FEB64C9FBC3C47FDC")
    public synchronized V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1874307590 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1468434117 = null; //Variable for return #2
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1567400206 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            tab[index] = e.next;
                        } //End block
                        {
                            prev.next = e.next;
                        } //End block
                        varB4EAC82CA7396A68D541C85D26508E83_1874307590 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1468434117 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_271981565; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_271981565 = varB4EAC82CA7396A68D541C85D26508E83_1874307590;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_271981565 = varB4EAC82CA7396A68D541C85D26508E83_1468434117;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_271981565.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_271981565;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.678 -0400", hash_original_method = "1C0D329A7E5E91219CE97B2AC82E739C", hash_generated_method = "D68A0CADC876BC1431B9C8C9FB2DDE0F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.679 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "52E2EAB1BA585EA8B204D98F5A406860")
    public synchronized Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_1121199218 = null; //Variable for return #1
        Set<K> ks;
        ks = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_1121199218 = (ks != null) ? ks : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_1121199218.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1121199218;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.679 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "4E71FAD0D48747FB758192AC6D5BD6B1")
    public synchronized Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_874501452 = null; //Variable for return #1
        Collection<V> vs;
        vs = values;
        varB4EAC82CA7396A68D541C85D26508E83_874501452 = (vs != null) ? vs : (values = new Values());
        varB4EAC82CA7396A68D541C85D26508E83_874501452.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_874501452;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.703 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "A21FB1E085C0D41D0663962F067127E7")
    public synchronized Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_98072451 = null; //Variable for return #1
        Set<Entry<K, V>> es;
        es = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_98072451 = (es != null) ? es : (entrySet = new EntrySet());
        varB4EAC82CA7396A68D541C85D26508E83_98072451.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_98072451;
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.704 -0400", hash_original_method = "BD8590C2A6B44E1AD87F42CA1DDBEEC0", hash_generated_method = "6CDF7703C9E83B0363143F852C904695")
    public synchronized Enumeration<K> keys() {
        Enumeration<K> varB4EAC82CA7396A68D541C85D26508E83_750329155 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_750329155 = new KeyEnumeration();
        varB4EAC82CA7396A68D541C85D26508E83_750329155.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_750329155;
        // ---------- Original Method ----------
        //return new KeyEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.704 -0400", hash_original_method = "D92B3AB4F78D152BCFDB4F438052384E", hash_generated_method = "15C0EC1769929ED2DBEEFAF2F44132D2")
    public synchronized Enumeration<V> elements() {
        Enumeration<V> varB4EAC82CA7396A68D541C85D26508E83_225429720 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_225429720 = new ValueEnumeration();
        varB4EAC82CA7396A68D541C85D26508E83_225429720.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_225429720;
        // ---------- Original Method ----------
        //return new ValueEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.708 -0400", hash_original_method = "CF57466F07C2DB8AF5EFB522D22E3680", hash_generated_method = "7822A35C4CB1CBE96553450B6A652544")
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
                    boolean varBF092BC27A863E23FE4C44D225ED1FDA_828341053 = (e.hash == hash && e.key.equals(key));
                    {
                        boolean var6C13353AEE37EBEED16BB037A146133C_1845275017 = (e.value.equals(value));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1688645618 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1688645618;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.721 -0400", hash_original_method = "A191738781408606E816E9A37080097D", hash_generated_method = "324E4D29C33F7BB9FA87A093D815C52A")
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
                    boolean varBF092BC27A863E23FE4C44D225ED1FDA_485998469 = (e.hash == hash && e.key.equals(key));
                    {
                        {
                            boolean var876C169E101ABBE81C5DB09387C8C08C_1999513551 = (!e.value.equals(value));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1257620582 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1257620582;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.721 -0400", hash_original_method = "9BC17AC5DA957A9C0A07708C3D3A3E68", hash_generated_method = "0ECC1BF1D4672E3AD56D83061CD66FE5")
    @Override
    public synchronized boolean equals(Object object) {
        boolean varF1443A15804B24DDE99B981E7E34D8C9_588427407 = ((object instanceof Map) &&
                entrySet().equals(((Map<?, ?>)object).entrySet()));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1012994075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1012994075;
        // ---------- Original Method ----------
        //return (object instanceof Map) &&
                //entrySet().equals(((Map<?, ?>)object).entrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.791 -0400", hash_original_method = "0904BEF2CA25AF4229493E32A4F8928E", hash_generated_method = "A2045CB7F6735E47824BDB216B9F1795")
    @Override
    public synchronized int hashCode() {
        int result;
        result = 0;
        {
            Iterator<Entry<K, V>> varD93A6471022189C0BA28AFBB8C8557A0_617921520 = (entrySet()).iterator();
            varD93A6471022189C0BA28AFBB8C8557A0_617921520.hasNext();
            Entry<K, V> e = varD93A6471022189C0BA28AFBB8C8557A0_617921520.next();
            {
                K key;
                key = e.getKey();
                V value;
                value = e.getValue();
                {
                    boolean varA5737C8BC3A00C9E9A68B0C1A8552473_887034136 = (key == this || value == this);
                } //End collapsed parenthetic
                result += (key != null ? key.hashCode() : 0)
                    ^ (value != null ? value.hashCode() : 0);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784718883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784718883;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.792 -0400", hash_original_method = "A78197C1027A9ECA0DF472B01066EEE7", hash_generated_method = "C9E8FE2F235D0107965200A599667057")
    @Override
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_160355858 = null; //Variable for return #1
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
                boolean var41667EFB1D4E18743BE89148FA51235C_1526701762 = (hasMore = i.hasNext());
                {
                    result.append(", ");
                } //End block
            } //End collapsed parenthetic
        } //End block
        result.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_160355858 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_160355858.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_160355858;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.868 -0400", hash_original_method = "19818AA4E6F1DBA67EBB75B368743917", hash_generated_method = "DF612AC99E242E590E9E3BC35F499AB7")
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("threshold",  (int) (DEFAULT_LOAD_FACTOR * table.length));
        fields.put("loadFactor", DEFAULT_LOAD_FACTOR);
        stream.writeFields();
        stream.writeInt(table.length);
        stream.writeInt(size);
        {
            Iterator<Entry<K, V>> varD93A6471022189C0BA28AFBB8C8557A0_1954327403 = (entrySet()).iterator();
            varD93A6471022189C0BA28AFBB8C8557A0_1954327403.hasNext();
            Entry<K, V> e = varD93A6471022189C0BA28AFBB8C8557A0_1954327403.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.880 -0400", hash_original_method = "2EADB0DA3622DE13512805CD17FDFE7A", hash_generated_method = "88C240AC8C67A0713F488D22FF3720B8")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.880 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.880 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.880 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.880 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A5AC9F76C2A7B9F6F79010A5F4A3B4B7")

        HashtableEntry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.881 -0400", hash_original_method = "FCC59894C2665A76D7100104D46402EE", hash_generated_method = "7F8F2DB59D28E587038E679033461007")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.890 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "E3839E03DDB16753FA5931B51B4D28E9")
        public final K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_2087864643 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2087864643 = key;
            varB4EAC82CA7396A68D541C85D26508E83_2087864643.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2087864643;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.891 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "DB6700B6236CF2F06CD21E02153D67C8")
        public final V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_1687168424 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1687168424 = value;
            varB4EAC82CA7396A68D541C85D26508E83_1687168424.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1687168424;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.916 -0400", hash_original_method = "09EE506DF55191FF6B72960EEA25D181", hash_generated_method = "3DEA10E6F3BF25202752907F67F26497")
        public final V setValue(V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_1145636983 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            V oldValue;
            oldValue = this.value;
            this.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_1145636983 = oldValue;
            varB4EAC82CA7396A68D541C85D26508E83_1145636983.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1145636983;
            // ---------- Original Method ----------
            //if (value == null) {
                //throw new NullPointerException();
            //}
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.917 -0400", hash_original_method = "509D67FA76563438156B3275F90914F5", hash_generated_method = "FF418B68064F6A523AC0E5E038C06AF5")
        @Override
        public final boolean equals(Object o) {
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varE09B45BE378FDDE1749CF5314C9B65A1_233487584 = (key.equals(e.getKey()) && value.equals(e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_31130281 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_31130281;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return key.equals(e.getKey()) && value.equals(e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.918 -0400", hash_original_method = "28D407F854479314A0A7C3BE1F12A9AB", hash_generated_method = "04C362733CB1C839DD52007C9A6DA9A3")
        @Override
        public final int hashCode() {
            int varCC7293A69A74489DFEF0094B17563C76_963287417 = (key.hashCode() ^ value.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585116952 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585116952;
            // ---------- Original Method ----------
            //return key.hashCode() ^ value.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.918 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "8B30EB8ED498F7C56305D0F43C538294")
        @Override
        public final String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_955981728 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_955981728 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_955981728.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_955981728;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
    }


    
    private abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.918 -0400", hash_original_field = "B6F75212F617C3E247C9474AFDA3B784", hash_generated_field = "04911A8A6B33F6D23811475122C95D0E")

        int nextIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.918 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "7A671A08D7EC5144843A6963DC69FDC7")

        HashtableEntry<K, V> nextEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.918 -0400", hash_original_field = "8A3A9937F6D0DA3448C9C061B347CECF", hash_generated_field = "7DA4F26BBE36FAFDC112AEE30391E8D1")

        HashtableEntry<K, V> lastEntryReturned;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.918 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "17128C49BCF19B4186F02F384F2DEA86")

        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.919 -0400", hash_original_method = "1BB35CB0E7E6DF7A5633A61B0F63C5AA", hash_generated_method = "3ABDD7645076F8F6E69EEFCA7860E17F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.919 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "1E7FA7F50ACEC3AE492CC6ACD90B3C15")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382619907 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_382619907;
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.937 -0400", hash_original_method = "5FA6641462F5564CAC982C4AF6FCFB6C", hash_generated_method = "44E27C14485BAE2CC9DE60F0521398EA")
         HashtableEntry<K, V> nextEntry() {
            HashtableEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1160228339 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1160228339 = lastEntryReturned = entryToReturn;
            varB4EAC82CA7396A68D541C85D26508E83_1160228339.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1160228339;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.939 -0400", hash_original_method = "1C3D72122BB58702CE822C81122C0D27", hash_generated_method = "86A1174C99A7B67055190F94E868FAB9")
         HashtableEntry<K, V> nextEntryNotFailFast() {
            HashtableEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_448882520 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_448882520 = lastEntryReturned = entryToReturn;
            varB4EAC82CA7396A68D541C85D26508E83_448882520.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_448882520;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.939 -0400", hash_original_method = "342FDC52CA82B385D96AADB83EE8F936", hash_generated_method = "55CA60158E545DDD18DDAB246D1BF2A1")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.939 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.939 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "4E313C956A4410B14910A06D24539817")
        public K next() {
            K varB4EAC82CA7396A68D541C85D26508E83_7773494 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_7773494 = nextEntry().key;
            varB4EAC82CA7396A68D541C85D26508E83_7773494.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_7773494;
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends HashIterator implements Iterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.939 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.940 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "AB55E17E834213F2E670D4603296BDF3")
        public V next() {
            V varB4EAC82CA7396A68D541C85D26508E83_1609658659 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1609658659 = nextEntry().value;
            varB4EAC82CA7396A68D541C85D26508E83_1609658659.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1609658659;
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.940 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.943 -0400", hash_original_method = "C7E2B840B075445DC1033B130AB2E6A6", hash_generated_method = "4EB3B93D844B9598FBAE8721C51791C4")
        public Entry<K, V> next() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_447883216 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_447883216 = nextEntry();
            varB4EAC82CA7396A68D541C85D26508E83_447883216.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_447883216;
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private final class KeyEnumeration extends HashIterator implements Enumeration<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.946 -0400", hash_original_method = "2E46AFA79C505478BD5C8702CDCDD1D4", hash_generated_method = "2E46AFA79C505478BD5C8702CDCDD1D4")
        public KeyEnumeration ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.946 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "507CF447AA1F470DA4BFF8D25CAD8F98")
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_1651468705 = (hasNext());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691783704 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691783704;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.947 -0400", hash_original_method = "BED82438F0CBBB90FF7803670DD55802", hash_generated_method = "B4453B724FA553810868EFCC62B86B10")
        public K nextElement() {
            K varB4EAC82CA7396A68D541C85D26508E83_1192189518 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1192189518 = nextEntryNotFailFast().key;
            varB4EAC82CA7396A68D541C85D26508E83_1192189518.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1192189518;
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().key;
        }

        
    }


    
    private final class ValueEnumeration extends HashIterator implements Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.969 -0400", hash_original_method = "0C70885115EB664BF7ADABD8AB769AB3", hash_generated_method = "0C70885115EB664BF7ADABD8AB769AB3")
        public ValueEnumeration ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.970 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "2E4FAE924908B7723E731277112B811A")
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_1770594116 = (hasNext());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1963350703 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1963350703;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.971 -0400", hash_original_method = "433328C2A0882CA6574B6B21E730CA05", hash_generated_method = "49ADB9018CA59BC90CAD390AE73A870F")
        public V nextElement() {
            V varB4EAC82CA7396A68D541C85D26508E83_1734078972 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1734078972 = nextEntryNotFailFast().value;
            varB4EAC82CA7396A68D541C85D26508E83_1734078972.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1734078972;
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().value;
        }

        
    }


    
    private final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.972 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.972 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "B02EAE1F1D726B7EDF638364D0D78EC7")
        public Iterator<K> iterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_971672172 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_971672172 = new KeyIterator();
            varB4EAC82CA7396A68D541C85D26508E83_971672172.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_971672172;
            // ---------- Original Method ----------
            //return new KeyIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.973 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "B05919C23F47838557E13A9019802CCB")
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_518520241 = (Hashtable.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715359282 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715359282;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.973 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "A2C608FC564BAC68FCC98957D0C2DFCA")
        public boolean contains(Object o) {
            boolean var997BAB39B2F072D5CD66A271F3B6E196_524084312 = (containsKey(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_966237926 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_966237926;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.973 -0400", hash_original_method = "FF159DEBFD9D37DD2EC80383AA98B734", hash_generated_method = "B444E88382AB3C48968C377A2E1DB7E7")
        public boolean remove(Object o) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_799319404 = (Hashtable.this);
                {
                    int oldSize;
                    oldSize = size;
                    Hashtable.this.remove(o);
                } //End block
            } //End collapsed parenthetic
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_683438193 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_683438193;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //int oldSize = size;
                //Hashtable.this.remove(o);
                //return size != oldSize;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.989 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.989 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "0EF79222F9B99A59C2B37FC8FB7A02AC")
        public boolean removeAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1468949668 = (Hashtable.this);
                {
                    boolean varF33472708DFFFDAF6959DE4125160D76_1294045717 = (super.removeAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842297948 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_842297948;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.990 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "ABBF21B99990A79413FD37F90850F284")
        public boolean retainAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1333559831 = (Hashtable.this);
                {
                    boolean var802E13F1B176A50DBD94ED7EACD6E76C_1616834237 = (super.retainAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_424230481 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_424230481;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.990 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "DFE92117BA39AB04314E2FF53BF47DCF")
        public boolean containsAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1498110649 = (Hashtable.this);
                {
                    boolean var7FF1A279AF3532345951D9FAAC0AC82D_1033975686 = (super.containsAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1908512 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1908512;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.991 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "977EA246047080B1DD6E2E2CA8B57F4F")
        public boolean equals(Object object) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_473588608 = (Hashtable.this);
                {
                    boolean var5BE46525B597E36F672CA971A0B1396F_481961961 = (super.equals(object));
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734933123 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734933123;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.991 -0400", hash_original_method = "2EB37718E343BC9663B783B0FC3BE747", hash_generated_method = "F1C8F0A251B70E72C7BC361980F98ECE")
        public int hashCode() {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1788011654 = (Hashtable.this);
                {
                    int varC1EBD1993309EE605028A8712B798C0E_2108986351 = (super.hashCode());
                } //End block
            } //End collapsed parenthetic
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235624798 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235624798;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.995 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "6FDE925AB918781715D2C338F1CD697E")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_72456170 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1081130966 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_72456170 = super.toString();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_72456170.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_72456170;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.996 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "2966254229D396122617547A7F220C25")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_156732572 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1366599509 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_156732572 = super.toArray();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_156732572.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_156732572;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.000 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "38D0B651C5274155EA741786F629FC82")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1878789064 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1195469779 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1878789064 = super.toArray(a);
                } //End block
            } //End collapsed parenthetic
            addTaint(a[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1878789064.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1878789064;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.000 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.001 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "617C82C76F5C1C2225D77ADD91A56372")
        public Iterator<V> iterator() {
            Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_1679071373 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1679071373 = new ValueIterator();
            varB4EAC82CA7396A68D541C85D26508E83_1679071373.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1679071373;
            // ---------- Original Method ----------
            //return new ValueIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.001 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "CE16C403CBFCCDF8B67B45E830C7C8E7")
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_685435805 = (Hashtable.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1125116620 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1125116620;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.001 -0400", hash_original_method = "C13053467D6FDF772DF450C87D40A3D5", hash_generated_method = "9F6B46A66F9E8767B3DA5EADB3A090D0")
        public boolean contains(Object o) {
            boolean varD1EEFCBD27E28C71EA594EC596966CFD_1512834555 = (containsValue(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1465090576 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1465090576;
            // ---------- Original Method ----------
            //return containsValue(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.021 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.022 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "9D85AD2B95814D4043147B9BB50D8399")
        public boolean containsAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1640046107 = (Hashtable.this);
                {
                    boolean var7FF1A279AF3532345951D9FAAC0AC82D_153772017 = (super.containsAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1721543835 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1721543835;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.022 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "D1FFAD396FDFC37984C90C912D08D829")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1013504155 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_2115605639 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1013504155 = super.toString();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1013504155.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1013504155;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.023 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "28CCB6663AC24E2672E0C67B8931815C")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_1731894528 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1377580078 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1731894528 = super.toArray();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1731894528.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1731894528;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.039 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "DA5BBE0B255FA0960812982FA444D0A4")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_550113320 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1735623130 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_550113320 = super.toArray(a);
                } //End block
            } //End collapsed parenthetic
            addTaint(a[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_550113320.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_550113320;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.039 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.039 -0400", hash_original_method = "D7164BC97FFDCB587AB273006C953E50", hash_generated_method = "07A13C8EAF17AD70043FF12B4C7325BF")
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_708431365 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_708431365 = new EntryIterator();
            varB4EAC82CA7396A68D541C85D26508E83_708431365.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_708431365;
            // ---------- Original Method ----------
            //return new EntryIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.040 -0400", hash_original_method = "6E695F138E29D844DC896198513B6135", hash_generated_method = "D5184E3E84E3BE78FAEFC3E0C66A6A63")
        public boolean contains(Object o) {
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varEC3A3E183CD0A7D33A5B45EDAE091B2E_2100944166 = (containsMapping(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_427988116 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_427988116;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return containsMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.045 -0400", hash_original_method = "F484CBC8566C601718EDE0034034C7B3", hash_generated_method = "FA26F966CCEF2DDD6C724EF08CE12CB6")
        public boolean remove(Object o) {
            Entry<?, ?> e;
            e = (Entry<?, ?>)o;
            boolean var598A216136B4C4D06069F46B6EC81DD9_397203249 = (removeMapping(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303249167 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303249167;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>)o;
            //return removeMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.046 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "265DDEF66DC3B7FB1A36124271F05BE2")
        public int size() {
            int varC7873C16804AFC59CFA1E639D76690F1_446462870 = (Hashtable.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2099324908 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2099324908;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.046 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.046 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "66326C5F3012BBD3A5D52A16CC591665")
        public boolean removeAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_678356181 = (Hashtable.this);
                {
                    boolean varF33472708DFFFDAF6959DE4125160D76_1619710667 = (super.removeAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1900131558 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1900131558;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.046 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "9B59C5E8F5B8CA0689B099D38B353018")
        public boolean retainAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_644639369 = (Hashtable.this);
                {
                    boolean var802E13F1B176A50DBD94ED7EACD6E76C_561277522 = (super.retainAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045294870 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045294870;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.047 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "FEA765466FA1F6015E2F4C44C4DA5EAB")
        public boolean containsAll(Collection<?> collection) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_441477870 = (Hashtable.this);
                {
                    boolean var7FF1A279AF3532345951D9FAAC0AC82D_1786006721 = (super.containsAll(collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1448155114 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1448155114;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.048 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "E3C4F3A2BD14A0CD6828035CEF5FC32D")
        public boolean equals(Object object) {
            {
                Object var85D7E5D24FB948184A7704DF274F5600_621735091 = (Hashtable.this);
                {
                    boolean var5BE46525B597E36F672CA971A0B1396F_1797850184 = (super.equals(object));
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_54198492 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_54198492;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.048 -0400", hash_original_method = "3000FE237E7845AEAFDA2B41B0704346", hash_generated_method = "ADABD8E60F54D33CFD086B64E54B5366")
        public int hashCode() {
            int var888832939E9A16C553FA6EB5FC57B96E_1654825394 = (Hashtable.this.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505109532 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505109532;
            // ---------- Original Method ----------
            //return Hashtable.this.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.048 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "10854121B1A6EC684ED08AA1121F79C3")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1084896426 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1526516948 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1084896426 = super.toString();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1084896426.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1084896426;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.049 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "77BB59CE163422AA36B5A1A74E083DD2")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_782369962 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_1780231805 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_782369962 = super.toArray();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_782369962.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_782369962;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.049 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "CDFED834C8FE3D4CAF69E6CABE9019A4")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_573961788 = null; //Variable for return #1
            {
                Object var85D7E5D24FB948184A7704DF274F5600_457046411 = (Hashtable.this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_573961788 = super.toArray(a);
                } //End block
            } //End collapsed parenthetic
            addTaint(a[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_573961788.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_573961788;
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.066 -0400", hash_original_field = "74773297EBE9767DD8F1E8A0F109042B", hash_generated_field = "4FA46765B2A3EF08CC97297AFC75A0ED")

    private static int MINIMUM_CAPACITY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.066 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "864BDCB1A430DAF5D56F9061E7B2A26F")

    private static int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.066 -0400", hash_original_field = "215B48891AB1D8DA059087E167B4E6A3", hash_generated_field = "C93F61FB7CC10C41ECD4CA75E47F0E5C")

    private static Entry[] EMPTY_TABLE = new HashtableEntry[MINIMUM_CAPACITY >>> 1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.066 -0400", hash_original_field = "2457D6689D4C035FB0208C51E3216836", hash_generated_field = "BDD44B42DE376759E8EB7DC76E05062E")

    private static float DEFAULT_LOAD_FACTOR = .75F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.066 -0400", hash_original_field = "C12E356D9C08DF40A0A68843ED778698", hash_generated_field = "AE6BC140A8BB8804DA193F9527E22796")

    private static int CHARS_PER_ENTRY = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.067 -0400", hash_original_field = "5908451E267AA95A476F28CC7A33B199", hash_generated_field = "587CD269B9F1F82A53C5D381FEFA45BD")

    private static long serialVersionUID = 1421746759512286392L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.067 -0400", hash_original_field = "109308E5D4D5B0ADE2743F48081B723A", hash_generated_field = "DB1580F41A649CDFCF2A87E36EC907B3")

    private static ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("threshold", int.class),
        new ObjectStreamField("loadFactor", float.class),
    };
}


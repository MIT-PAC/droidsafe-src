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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.267 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "5BCDF9B3CCDE8C26B422211A63786F6F")

    transient HashMapEntry<K, V>[] table;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.267 -0400", hash_original_field = "789DFF82296D9E921000DB270879418B", hash_generated_field = "001B08BF95F5AEB6F938F9E6275C3105")

    transient HashMapEntry<K, V> entryForNullKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.267 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "7BEABDDA8AE5EA70226B47F806396840")

    transient int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.267 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "66B0BB3B51ED8DFDAEFDC2833CA7C4AB")

    transient int modCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.267 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "AC9BEC59E41404676A448C0DD2BB745B")

    private transient int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.267 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "EB6C570550CCFE8E5FEBB44BA37D02C0")

    private transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.267 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "BFDE585634496DDD7FBD15EDD2D3C5DD")

    private transient Set<Entry<K, V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.268 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "5A2A505CEEC79706812E901D735E2A7C")

    private transient Collection<V> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.268 -0400", hash_original_method = "67F8ADB6599C3AA95FA8DFFD843377DD", hash_generated_method = "7409D258B8D042741B25C0440FA51BF9")
    @SuppressWarnings("unchecked")
    public  HashMap() {
        table = (HashMapEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1;
        // ---------- Original Method ----------
        //table = (HashMapEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.268 -0400", hash_original_method = "DBEA46BF5DB352E6536C06B54FDF6C1E", hash_generated_method = "B1A277D14172C22C0F374CC94D9F536F")
    public  HashMap(int capacity) {
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
        addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.270 -0400", hash_original_method = "ED265422F07438826BD7CEB727CA13DA", hash_generated_method = "CF5433A41DCA21B4B39FFE11FF84A96E")
    public  HashMap(int capacity, float loadFactor) {
        this(capacity);
        {
            boolean var7E96777C74EA86B66256F7B00F5AE961_831133363 = (loadFactor <= 0 || Float.isNaN(loadFactor));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.274 -0400", hash_original_method = "D988B3BE94D6CE1D83E9BB54AA86E55F", hash_generated_method = "3E2B06BFA5313BED39B7740BA34828C4")
    public  HashMap(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        constructorPutAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.309 -0400", hash_original_method = "6631235722E4D3190E3529D2039DDD7A", hash_generated_method = "A6081E0DE071576701528C2E5F3CBEC9")
    final void constructorPutAll(Map<? extends K, ? extends V> map) {
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

    
        static int capacityForInitSize(int size) {
        int result = (size >> 1) + size;
        return (result & ~(MAXIMUM_CAPACITY-1))==0 ? result : MAXIMUM_CAPACITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.310 -0400", hash_original_method = "C555E25CE67FE12926CA5480B863847E", hash_generated_method = "63918674A4666CEEA5A376E17BFBFA4C")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1829225210 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1829225210 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1829225210.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1829225210;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.311 -0400", hash_original_method = "417EF77086319CE91314CCF850ADA61E", hash_generated_method = "2067003B6622767497B839D408201FF1")
     void init() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.319 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "6C21811190629DF7D4C20D4F97B0C00D")
    @Override
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1365532164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1365532164;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.322 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "026C391AC27EF8282D3CEC76E604AACC")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808920248 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808920248;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.326 -0400", hash_original_method = "D55BBCD9F0C6BD0BD798F81C2A3EFECD", hash_generated_method = "32C7AA474EE4163F7F342ECC123E476A")
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1488467839 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1408601909 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_1408641880 = null; //Variable for return #3
        {
            HashMapEntry<K, V> e;
            e = entryForNullKey;
            varB4EAC82CA7396A68D541C85D26508E83_1488467839 = e == null ? null : e.value;
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
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_921920729 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1408601909 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1408641880 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1361821941; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1361821941 = varB4EAC82CA7396A68D541C85D26508E83_1488467839;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1361821941 = varB4EAC82CA7396A68D541C85D26508E83_1408601909;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1361821941 = varB4EAC82CA7396A68D541C85D26508E83_1408641880;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1361821941.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1361821941;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.342 -0400", hash_original_method = "664DBEAFB6D0F34975160DBB887BD5CA", hash_generated_method = "670E1294D07C03328384E331910A7580")
    @Override
    public boolean containsKey(Object key) {
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
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_658533752 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217500863 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_217500863;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.343 -0400", hash_original_method = "8A9DFD8A0E528EE1DFDA14FDA5F2B177", hash_generated_method = "A42FD55BA0926CEB7EAA8CE9036D5A07")
    @Override
    public boolean containsValue(Object value) {
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
                            boolean varB228932AA07990623CC3C29EF03F40DA_1008664933 = (value.equals(e.value));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean varEA7E3E060F89A85EADC32277C95F3D47_1104972627 = (entryForNullKey != null && value.equals(entryForNullKey.value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2087563564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2087563564;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.344 -0400", hash_original_method = "5BBA395276A0B9AAD236878C1432D189", hash_generated_method = "BE58CCA5BC936DD904C51A77D0FC5C1C")
    @Override
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_164209021 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_829982071 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_1188273094 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_164209021 = putValueForNullKey(value);
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_961175832 = (e.hash == hash && key.equals(e.key));
                    {
                        preModify(e);
                        V oldValue;
                        oldValue = e.value;
                        e.value = value;
                        varB4EAC82CA7396A68D541C85D26508E83_829982071 = oldValue;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            tab = doubleCapacity();
            index = hash & (tab.length - 1);
        } //End block
        addNewEntry(key, value, hash, index);
        varB4EAC82CA7396A68D541C85D26508E83_1188273094 = null;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        V varA7E53CE21691AB073D9660D615818899_802936838; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_802936838 = varB4EAC82CA7396A68D541C85D26508E83_164209021;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_802936838 = varB4EAC82CA7396A68D541C85D26508E83_829982071;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_802936838 = varB4EAC82CA7396A68D541C85D26508E83_1188273094;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_802936838.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_802936838;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.356 -0400", hash_original_method = "23837E71B15780DD12C36C21FB15F598", hash_generated_method = "39556B953AD71E154D1FC09E57F3E622")
    private V putValueForNullKey(V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1498700787 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_290459143 = null; //Variable for return #2
        HashMapEntry<K, V> entry;
        entry = entryForNullKey;
        {
            addNewEntryForNullKey(value);
            varB4EAC82CA7396A68D541C85D26508E83_1498700787 = null;
        } //End block
        {
            preModify(entry);
            V oldValue;
            oldValue = entry.value;
            entry.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_290459143 = oldValue;
        } //End block
        addTaint(value.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1945045498; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1945045498 = varB4EAC82CA7396A68D541C85D26508E83_1498700787;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1945045498 = varB4EAC82CA7396A68D541C85D26508E83_290459143;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1945045498.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1945045498;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.357 -0400", hash_original_method = "DFE0557B59605BA6C5CD9DE7502DD68F", hash_generated_method = "8E8423E144F06F950B93A82209065B3F")
     void preModify(HashMapEntry<K, V> e) {
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.409 -0400", hash_original_method = "627029122DE3FFF8BEA7942964D9C227", hash_generated_method = "1178EEFFCA274C1EE725FFDC8826A2F0")
    private void constructorPut(K key, V value) {
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1996655104 = (e.hash == hash && key.equals(e.key));
                    {
                        e.value = value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        tab[index] = constructorNewEntry(key, value, hash, first);
        addTaint(key.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.410 -0400", hash_original_method = "6DFE8ABD0EB0EC55F81B8127E2FB540C", hash_generated_method = "453D2264FFA6453AAFEB1CBBCCBC261D")
     void addNewEntry(K key, V value, int hash, int index) {
        table[index] = new HashMapEntry<K, V>(key, value, hash, table[index]);
        // ---------- Original Method ----------
        //table[index] = new HashMapEntry<K, V>(key, value, hash, table[index]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.410 -0400", hash_original_method = "1A0C0EFFA3B59B8426ED7AB00D5D7C14", hash_generated_method = "0ED80084966D32973E9213641BE7C311")
     void addNewEntryForNullKey(V value) {
        entryForNullKey = new HashMapEntry<K, V>(null, value, 0, null);
        // ---------- Original Method ----------
        //entryForNullKey = new HashMapEntry<K, V>(null, value, 0, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.410 -0400", hash_original_method = "08952C170F8B11733B904F0E99F6B0F5", hash_generated_method = "EE7B2FE23D086DE24CE61C36CE1E4AB1")
     HashMapEntry<K, V> constructorNewEntry(
            K key, V value, int hash, HashMapEntry<K, V> first) {
        HashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1959717790 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1959717790 = new HashMapEntry<K, V>(key, value, hash, first);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        addTaint(hash);
        addTaint(first.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1959717790.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1959717790;
        // ---------- Original Method ----------
        //return new HashMapEntry<K, V>(key, value, hash, first);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.411 -0400", hash_original_method = "A51614C8AB5E8271029690D5F9184632", hash_generated_method = "D35741D79B2FD354561E200C494D3864")
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size());
        super.putAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //ensureCapacity(map.size());
        //super.putAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.411 -0400", hash_original_method = "4BE6F38D6656B87B29773B0AAEA75993", hash_generated_method = "1F4D9C543F4DE3C273E5161A25A9DC76")
    private void ensureCapacity(int numMappings) {
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
        addTaint(numMappings);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.412 -0400", hash_original_method = "EE2E1A4893DAC33AFE32D39C3AA93587", hash_generated_method = "9EBF75946EFBCA8AB2C04D7C5C841B2D")
    private HashMapEntry<K, V>[] makeTable(int newCapacity) {
        HashMapEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_335588843 = null; //Variable for return #1
        @SuppressWarnings("unchecked") HashMapEntry<K, V>[] newTable;
        newTable = (HashMapEntry<K, V>[]) new HashMapEntry[newCapacity];
        table = newTable;
        threshold = (newCapacity >> 1) + (newCapacity >> 2);
        varB4EAC82CA7396A68D541C85D26508E83_335588843 = newTable;
        varB4EAC82CA7396A68D541C85D26508E83_335588843.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_335588843;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked") HashMapEntry<K, V>[] newTable
                //= (HashMapEntry<K, V>[]) new HashMapEntry[newCapacity];
        //table = newTable;
        //threshold = (newCapacity >> 1) + (newCapacity >> 2);
        //return newTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.414 -0400", hash_original_method = "0D1C32EF365F651EE12DB3FC6B4877B2", hash_generated_method = "355D33A680808F2F7B74889D864EE5B1")
    private HashMapEntry<K, V>[] doubleCapacity() {
        HashMapEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_899216482 = null; //Variable for return #1
        HashMapEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_282727771 = null; //Variable for return #2
        HashMapEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1028640879 = null; //Variable for return #3
        HashMapEntry<K, V>[] oldTable;
        oldTable = table;
        int oldCapacity;
        oldCapacity = oldTable.length;
        {
            varB4EAC82CA7396A68D541C85D26508E83_899216482 = oldTable;
        } //End block
        int newCapacity;
        newCapacity = oldCapacity * 2;
        HashMapEntry<K, V>[] newTable;
        newTable = makeTable(newCapacity);
        {
            varB4EAC82CA7396A68D541C85D26508E83_282727771 = newTable;
        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_1028640879 = newTable;
        HashMapEntry<K, V>[] varA7E53CE21691AB073D9660D615818899_542063297; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_542063297 = varB4EAC82CA7396A68D541C85D26508E83_899216482;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_542063297 = varB4EAC82CA7396A68D541C85D26508E83_282727771;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_542063297 = varB4EAC82CA7396A68D541C85D26508E83_1028640879;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_542063297.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_542063297;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.426 -0400", hash_original_method = "D4E7D7B0427A5C260627922F822E871C", hash_generated_method = "BBC2B36E90B6D7026916BFA7B19F04C0")
    @Override
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1224561249 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_2024897158 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_1596352024 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1224561249 = removeNullKey();
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1240233721 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            tab[index] = e.next;
                        } //End block
                        {
                            prev.next = e.next;
                        } //End block
                        postRemove(e);
                        varB4EAC82CA7396A68D541C85D26508E83_2024897158 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1596352024 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_781155125; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_781155125 = varB4EAC82CA7396A68D541C85D26508E83_1224561249;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_781155125 = varB4EAC82CA7396A68D541C85D26508E83_2024897158;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_781155125 = varB4EAC82CA7396A68D541C85D26508E83_1596352024;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_781155125.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_781155125;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.427 -0400", hash_original_method = "C27EF61BE4179F161C4389258A9892DE", hash_generated_method = "0DF7604B7F36AFE3547753D59B8AC79D")
    private V removeNullKey() {
        V varB4EAC82CA7396A68D541C85D26508E83_1795441485 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_674304117 = null; //Variable for return #2
        HashMapEntry<K, V> e;
        e = entryForNullKey;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1795441485 = null;
        } //End block
        entryForNullKey = null;
        postRemove(e);
        varB4EAC82CA7396A68D541C85D26508E83_674304117 = e.value;
        V varA7E53CE21691AB073D9660D615818899_1751413640; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1751413640 = varB4EAC82CA7396A68D541C85D26508E83_1795441485;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1751413640 = varB4EAC82CA7396A68D541C85D26508E83_674304117;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1751413640.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1751413640;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.427 -0400", hash_original_method = "FA0A77625972B3EBD78B9E2926769234", hash_generated_method = "BDB96E09DB8E60586F70F118100AD4CC")
     void postRemove(HashMapEntry<K, V> e) {
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.427 -0400", hash_original_method = "19183B81B15552124143C4B9B1D176AB", hash_generated_method = "36983ECD3B8546C41194A59C9AEA9DE3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.428 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "2481D0AB4F283185374E4FCE90D1F302")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_913144482 = null; //Variable for return #1
        Set<K> ks;
        ks = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_913144482 = (ks != null) ? ks : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_913144482.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_913144482;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.428 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "BC201A02DB5614B5AEFAB9C7154FE663")
    @Override
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_240430357 = null; //Variable for return #1
        Collection<V> vs;
        vs = values;
        varB4EAC82CA7396A68D541C85D26508E83_240430357 = (vs != null) ? vs : (values = new Values());
        varB4EAC82CA7396A68D541C85D26508E83_240430357.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_240430357;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.430 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "630DC912D1898A34593771B42C39DF92")
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1865849294 = null; //Variable for return #1
        Set<Entry<K, V>> es;
        es = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_1865849294 = (es != null) ? es : (entrySet = new EntrySet());
        varB4EAC82CA7396A68D541C85D26508E83_1865849294.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1865849294;
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.430 -0400", hash_original_method = "DB078B96D3A026778ABE08AF9188B4AF", hash_generated_method = "A8C1CCA5DFF6733F6B294421604C9D00")
    private boolean containsMapping(Object key, Object value) {
        {
            HashMapEntry<K, V> e;
            e = entryForNullKey;
            boolean var40279722BF7E3C571A7656157FAC1347_192301602 = (e != null && Objects.equal(value, e.value));
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1433644915 = (e.hash == hash && key.equals(e.key));
                    {
                        boolean var0A2AB9D17E208A44FDDADD38B7C746A6_1753686280 = (Objects.equal(value, e.value));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510723896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_510723896;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.431 -0400", hash_original_method = "6968B8C772086C45A00DBEEB8B4680E5", hash_generated_method = "28E5FC8D336B81F7BB0C088C405FA239")
    private boolean removeMapping(Object key, Object value) {
        {
            HashMapEntry<K, V> e;
            e = entryForNullKey;
            {
                boolean varD3D296D0132E960C37912D3ADB0BA70A_1819051297 = (e == null || !Objects.equal(value, e.value));
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1702402783 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            boolean varA66595D18F1E35DC37004284678D0E23_1579354044 = (!Objects.equal(value, e.value));
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
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_389624006 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_389624006;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.432 -0400", hash_original_method = "E5C2B853B7FE0DFF8A1198070D9AED67", hash_generated_method = "DC35BE6078244180A6EDA41A5EC5C633")
     Iterator<K> newKeyIterator() {
        Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1394966361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1394966361 = new KeyIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1394966361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1394966361;
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.432 -0400", hash_original_method = "58BEE1C21CE9010029EB8FF9FDCDF9B3", hash_generated_method = "F64C6D0150FA06E05BAF35B027C3D959")
     Iterator<V> newValueIterator() {
        Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_1277366388 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1277366388 = new ValueIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1277366388.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1277366388;
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.451 -0400", hash_original_method = "41242F67E24C22ACB46F6D238FB07528", hash_generated_method = "442D4954399403734DE51AB780579B3C")
     Iterator<Entry<K, V>> newEntryIterator() {
        Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_409921923 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_409921923 = new EntryIterator();
        varB4EAC82CA7396A68D541C85D26508E83_409921923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_409921923;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.497 -0400", hash_original_method = "04BAFB4D83496263E755E7BD0F7C13FF", hash_generated_method = "5A923B2888263C4DE1830A1CA0859B8D")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("loadFactor", DEFAULT_LOAD_FACTOR);
        stream.writeFields();
        stream.writeInt(table.length);
        stream.writeInt(size);
        {
            Iterator<Entry<K, V>> varD93A6471022189C0BA28AFBB8C8557A0_2104006350 = (entrySet()).iterator();
            varD93A6471022189C0BA28AFBB8C8557A0_2104006350.hasNext();
            Entry<K, V> e = varD93A6471022189C0BA28AFBB8C8557A0_2104006350.next();
            {
                stream.writeObject(e.getKey());
                stream.writeObject(e.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.498 -0400", hash_original_method = "332DDC73CD162DC81E3D2D410CF74F29", hash_generated_method = "832F40F0219241EB8D850459FA57D846")
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
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static class HashMapEntry<K, V> implements Entry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.498 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.498 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.498 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.498 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "EFF097737D8D1DD9FA2B138EC8EE329B")

        HashMapEntry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.500 -0400", hash_original_method = "59EAB065FDED45CEE8A2A37A4323841C", hash_generated_method = "A273A4961FF63025E25EB678F2528A39")
          HashMapEntry(K key, V value, int hash, HashMapEntry<K, V> next) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.501 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "6245B5B6188DCA3B10996D34FD836017")
        public final K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_2122481766 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2122481766 = key;
            varB4EAC82CA7396A68D541C85D26508E83_2122481766.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2122481766;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.501 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "D5C8716E4D2D9D33264F629C2B8A1410")
        public final V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_1828113659 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1828113659 = value;
            varB4EAC82CA7396A68D541C85D26508E83_1828113659.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1828113659;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.515 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "9DE3381F9DCC45EB9C7B2FEB79CAA0E6")
        public final V setValue(V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_1332255224 = null; //Variable for return #1
            V oldValue;
            oldValue = this.value;
            this.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_1332255224 = oldValue;
            varB4EAC82CA7396A68D541C85D26508E83_1332255224.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1332255224;
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.515 -0400", hash_original_method = "A2F2028BE339F747959E241A5FA9FFD4", hash_generated_method = "B5B511F046F5E62BD5BC9CFC21C27CCD")
        @Override
        public final boolean equals(Object o) {
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varA6FC4CEB84BC9265AEA86B844A98520F_772255474 = (Objects.equal(e.getKey(), key)
                    && Objects.equal(e.getValue(), value));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1608334533 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1608334533;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return Objects.equal(e.getKey(), key)
                    //&& Objects.equal(e.getValue(), value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.516 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "287828A0FC2AFB8242CDDDBE2AB8530A")
        @Override
        public final int hashCode() {
            int var3D869AD0C50894398C24E31912CFB90B_123922927 = ((key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876726140 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876726140;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode()) ^
                    //(value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.516 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "D773E32FFE0FEEA678B40B2D3A900367")
        @Override
        public final String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_860524208 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_860524208 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_860524208.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_860524208;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
    }


    
    private abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.516 -0400", hash_original_field = "B6F75212F617C3E247C9474AFDA3B784", hash_generated_field = "04911A8A6B33F6D23811475122C95D0E")

        int nextIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.516 -0400", hash_original_field = "1BF1C18789BF9A611993EC2DE07C682C", hash_generated_field = "714CC477FAEEEEC0B90131EEA4F76ACE")

        HashMapEntry<K, V> nextEntry = entryForNullKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.516 -0400", hash_original_field = "8A3A9937F6D0DA3448C9C061B347CECF", hash_generated_field = "0C026A4A91581F8AA81723168CEE7A19")

        HashMapEntry<K, V> lastEntryReturned;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.516 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "17128C49BCF19B4186F02F384F2DEA86")

        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.517 -0400", hash_original_method = "1EAE57F880E5B81388FFC9611EFAA8EA", hash_generated_method = "51B338D2FBA648AB206D69E1243CB95C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.517 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "0BB44013B6302B10CFF515A9AA1E467B")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135221914 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135221914;
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.529 -0400", hash_original_method = "5956AFD098F3B365104EB4761E150134", hash_generated_method = "A45B97E9BA38A719BE1EC2CFA089AC25")
         HashMapEntry<K, V> nextEntry() {
            HashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1803389432 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1803389432 = lastEntryReturned = entryToReturn;
            varB4EAC82CA7396A68D541C85D26508E83_1803389432.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1803389432;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.532 -0400", hash_original_method = "FE8482BFEC11D819DE4FA740E823F031", hash_generated_method = "F04FA077471E00E01DE713F18A0BE8B7")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.532 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.532 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "D3CACE0B873C292FF599717F901F3090")
        public K next() {
            K varB4EAC82CA7396A68D541C85D26508E83_879309833 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_879309833 = nextEntry().key;
            varB4EAC82CA7396A68D541C85D26508E83_879309833.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_879309833;
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends HashIterator implements Iterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.532 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.535 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "0FEB4EE1F955313CD7520F8CF4C81CE1")
        public V next() {
            V varB4EAC82CA7396A68D541C85D26508E83_1620341270 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1620341270 = nextEntry().value;
            varB4EAC82CA7396A68D541C85D26508E83_1620341270.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1620341270;
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.535 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.535 -0400", hash_original_method = "C7E2B840B075445DC1033B130AB2E6A6", hash_generated_method = "8B718E1EAB98F22A10065AA7A6E0BB20")
        public Entry<K, V> next() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_34701658 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_34701658 = nextEntry();
            varB4EAC82CA7396A68D541C85D26508E83_34701658.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_34701658;
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.535 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.550 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "5010E93EE70B29B3936440BB2073FAD9")
        public Iterator<K> iterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_110425699 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_110425699 = newKeyIterator();
            varB4EAC82CA7396A68D541C85D26508E83_110425699.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_110425699;
            // ---------- Original Method ----------
            //return newKeyIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.550 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "BA5236EBEA666CAC449BF58FF9EF233E")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1892571984 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1892571984;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.551 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "576BFC5A61DF76D95C66630F539AEDCE")
        public boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_984766600 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_984766600;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.551 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "9B284CF478B81E9E26861B91D5DEB4EF")
        public boolean contains(Object o) {
            boolean var997BAB39B2F072D5CD66A271F3B6E196_199366352 = (containsKey(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_126848995 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_126848995;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.552 -0400", hash_original_method = "AFD23FBC02983B6BF4B878FD36F94DEB", hash_generated_method = "2EDD1CA558ED00654D1894D1D057043D")
        public boolean remove(Object o) {
            int oldSize;
            oldSize = size;
            HashMap.this.remove(o);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_964177987 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_964177987;
            // ---------- Original Method ----------
            //int oldSize = size;
            //HashMap.this.remove(o);
            //return size != oldSize;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.552 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    private final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.553 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.558 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "45E18D84AE18EE40991B04E5A68AA2D8")
        public Iterator<V> iterator() {
            Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_1923557511 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1923557511 = newValueIterator();
            varB4EAC82CA7396A68D541C85D26508E83_1923557511.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1923557511;
            // ---------- Original Method ----------
            //return newValueIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.558 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "3071619315C73A6CCD5B6AF107977EA1")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374598427 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374598427;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.558 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "D745BD91866307CCCBDF8F61889FD336")
        public boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_218048297 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_218048297;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.559 -0400", hash_original_method = "C13053467D6FDF772DF450C87D40A3D5", hash_generated_method = "8B4CAF316926F9E0767925D222A5B5D4")
        public boolean contains(Object o) {
            boolean varD1EEFCBD27E28C71EA594EC596966CFD_573301623 = (containsValue(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_989865355 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_989865355;
            // ---------- Original Method ----------
            //return containsValue(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.559 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    private final class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.559 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.559 -0400", hash_original_method = "D7164BC97FFDCB587AB273006C953E50", hash_generated_method = "9BD09EC31CB02321DFBF8C9FB6FF59BC")
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_758440876 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_758440876 = newEntryIterator();
            varB4EAC82CA7396A68D541C85D26508E83_758440876.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_758440876;
            // ---------- Original Method ----------
            //return newEntryIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.574 -0400", hash_original_method = "6E695F138E29D844DC896198513B6135", hash_generated_method = "F5D727D7385C2A0515EE70940576F9AE")
        public boolean contains(Object o) {
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varEC3A3E183CD0A7D33A5B45EDAE091B2E_712448452 = (containsMapping(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1516550280 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1516550280;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return containsMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.574 -0400", hash_original_method = "F484CBC8566C601718EDE0034034C7B3", hash_generated_method = "8D1F73BB777A808E9F85B50D0CBDDA65")
        public boolean remove(Object o) {
            Entry<?, ?> e;
            e = (Entry<?, ?>)o;
            boolean var598A216136B4C4D06069F46B6EC81DD9_2027279540 = (removeMapping(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_626714839 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_626714839;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>)o;
            //return removeMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.575 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "C3530DBBED8A0B300EE8F6D47B9DCD23")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116352922 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116352922;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.575 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "1DB9C734F00351A28873DDA32A311628")
        public boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1750434813 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1750434813;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.575 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.575 -0400", hash_original_field = "74773297EBE9767DD8F1E8A0F109042B", hash_generated_field = "4FA46765B2A3EF08CC97297AFC75A0ED")

    private static int MINIMUM_CAPACITY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.575 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "864BDCB1A430DAF5D56F9061E7B2A26F")

    private static int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.575 -0400", hash_original_field = "A1E5317AEBE2AA7B440C685A8E07ADDF", hash_generated_field = "947F578B0E9421AD06047343845DB1DB")

    private static Entry[] EMPTY_TABLE = new HashMapEntry[MINIMUM_CAPACITY >>> 1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.575 -0400", hash_original_field = "2457D6689D4C035FB0208C51E3216836", hash_generated_field = "412B498E8D39470CA979972558ED44E9")

    static float DEFAULT_LOAD_FACTOR = .75F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.575 -0400", hash_original_field = "B9B0D4CAFA519E3022BDB211EDB6108F", hash_generated_field = "41BDCB2D4BCA21EC570050DA29ACC543")

    private static long serialVersionUID = 362498820763181265L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.575 -0400", hash_original_field = "6B5047BD80649C86F20ACE5466546B8B", hash_generated_field = "DF3B779AC65293AACA2C768A9CD43464")

    private static ObjectStreamField[] serialPersistentFields = ;
}


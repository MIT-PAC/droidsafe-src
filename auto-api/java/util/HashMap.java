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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.283 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "5BCDF9B3CCDE8C26B422211A63786F6F")

    transient HashMapEntry<K, V>[] table;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.283 -0400", hash_original_field = "789DFF82296D9E921000DB270879418B", hash_generated_field = "001B08BF95F5AEB6F938F9E6275C3105")

    transient HashMapEntry<K, V> entryForNullKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.283 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "7BEABDDA8AE5EA70226B47F806396840")

    transient int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.283 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "66B0BB3B51ED8DFDAEFDC2833CA7C4AB")

    transient int modCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.283 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "AC9BEC59E41404676A448C0DD2BB745B")

    private transient int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.283 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "EB6C570550CCFE8E5FEBB44BA37D02C0")

    private transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.283 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "BFDE585634496DDD7FBD15EDD2D3C5DD")

    private transient Set<Entry<K, V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.283 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "5A2A505CEEC79706812E901D735E2A7C")

    private transient Collection<V> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.284 -0400", hash_original_method = "67F8ADB6599C3AA95FA8DFFD843377DD", hash_generated_method = "7409D258B8D042741B25C0440FA51BF9")
    @SuppressWarnings("unchecked")
    public  HashMap() {
        table = (HashMapEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1;
        // ---------- Original Method ----------
        //table = (HashMapEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.284 -0400", hash_original_method = "DBEA46BF5DB352E6536C06B54FDF6C1E", hash_generated_method = "B1A277D14172C22C0F374CC94D9F536F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.284 -0400", hash_original_method = "ED265422F07438826BD7CEB727CA13DA", hash_generated_method = "785916A6E84A29CD888DA3A1454D3818")
    public  HashMap(int capacity, float loadFactor) {
        this(capacity);
        {
            boolean var7E96777C74EA86B66256F7B00F5AE961_1235901884 = (loadFactor <= 0 || Float.isNaN(loadFactor));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.288 -0400", hash_original_method = "D988B3BE94D6CE1D83E9BB54AA86E55F", hash_generated_method = "3E2B06BFA5313BED39B7740BA34828C4")
    public  HashMap(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        constructorPutAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.299 -0400", hash_original_method = "6631235722E4D3190E3529D2039DDD7A", hash_generated_method = "A6081E0DE071576701528C2E5F3CBEC9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.301 -0400", hash_original_method = "C555E25CE67FE12926CA5480B863847E", hash_generated_method = "FA1218BFC2A89294C3D15D3A21044893")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1074112358 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1074112358 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1074112358.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1074112358;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.309 -0400", hash_original_method = "417EF77086319CE91314CCF850ADA61E", hash_generated_method = "2067003B6622767497B839D408201FF1")
     void init() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.309 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "E41BA5D332E625428F8D53853457ED79")
    @Override
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_11663681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_11663681;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.309 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "5A3286AA36DDD224ABD58E92C5368410")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1446092675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1446092675;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.315 -0400", hash_original_method = "D55BBCD9F0C6BD0BD798F81C2A3EFECD", hash_generated_method = "0E1BA964D44868B4A53230DF88EB71AD")
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1127366126 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1792438665 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_1642312177 = null; //Variable for return #3
        {
            HashMapEntry<K, V> e;
            e = entryForNullKey;
            varB4EAC82CA7396A68D541C85D26508E83_1127366126 = e == null ? null : e.value;
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
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_1513445368 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1792438665 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1642312177 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1953979380; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1953979380 = varB4EAC82CA7396A68D541C85D26508E83_1127366126;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1953979380 = varB4EAC82CA7396A68D541C85D26508E83_1792438665;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1953979380 = varB4EAC82CA7396A68D541C85D26508E83_1642312177;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1953979380.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1953979380;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.317 -0400", hash_original_method = "664DBEAFB6D0F34975160DBB887BD5CA", hash_generated_method = "0178E2020AC4406705F769EA4A40479C")
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
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_1676118007 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1604858390 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1604858390;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.322 -0400", hash_original_method = "8A9DFD8A0E528EE1DFDA14FDA5F2B177", hash_generated_method = "441775A61FB43A5F62627D802092F089")
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
                            boolean varB228932AA07990623CC3C29EF03F40DA_1277739108 = (value.equals(e.value));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean varEA7E3E060F89A85EADC32277C95F3D47_1096548923 = (entryForNullKey != null && value.equals(entryForNullKey.value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1998352997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1998352997;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.323 -0400", hash_original_method = "5BBA395276A0B9AAD236878C1432D189", hash_generated_method = "1B0840C4658A074F7F7B203B0B4FE25D")
    @Override
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_685915953 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1649530097 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_2079413746 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_685915953 = putValueForNullKey(value);
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1176658047 = (e.hash == hash && key.equals(e.key));
                    {
                        preModify(e);
                        V oldValue;
                        oldValue = e.value;
                        e.value = value;
                        varB4EAC82CA7396A68D541C85D26508E83_1649530097 = oldValue;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            tab = doubleCapacity();
            index = hash & (tab.length - 1);
        } //End block
        addNewEntry(key, value, hash, index);
        varB4EAC82CA7396A68D541C85D26508E83_2079413746 = null;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        V varA7E53CE21691AB073D9660D615818899_299489015; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_299489015 = varB4EAC82CA7396A68D541C85D26508E83_685915953;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_299489015 = varB4EAC82CA7396A68D541C85D26508E83_1649530097;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_299489015 = varB4EAC82CA7396A68D541C85D26508E83_2079413746;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_299489015.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_299489015;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.323 -0400", hash_original_method = "23837E71B15780DD12C36C21FB15F598", hash_generated_method = "C59DBC08647AAD602787CD2C210FF6D7")
    private V putValueForNullKey(V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_977379264 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1989814751 = null; //Variable for return #2
        HashMapEntry<K, V> entry;
        entry = entryForNullKey;
        {
            addNewEntryForNullKey(value);
            varB4EAC82CA7396A68D541C85D26508E83_977379264 = null;
        } //End block
        {
            preModify(entry);
            V oldValue;
            oldValue = entry.value;
            entry.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_1989814751 = oldValue;
        } //End block
        addTaint(value.getTaint());
        V varA7E53CE21691AB073D9660D615818899_261975725; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_261975725 = varB4EAC82CA7396A68D541C85D26508E83_977379264;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_261975725 = varB4EAC82CA7396A68D541C85D26508E83_1989814751;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_261975725.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_261975725;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.334 -0400", hash_original_method = "DFE0557B59605BA6C5CD9DE7502DD68F", hash_generated_method = "8E8423E144F06F950B93A82209065B3F")
     void preModify(HashMapEntry<K, V> e) {
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.336 -0400", hash_original_method = "627029122DE3FFF8BEA7942964D9C227", hash_generated_method = "C88F0387ACC182668C61978259809143")
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1450970314 = (e.hash == hash && key.equals(e.key));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.337 -0400", hash_original_method = "6DFE8ABD0EB0EC55F81B8127E2FB540C", hash_generated_method = "453D2264FFA6453AAFEB1CBBCCBC261D")
     void addNewEntry(K key, V value, int hash, int index) {
        table[index] = new HashMapEntry<K, V>(key, value, hash, table[index]);
        // ---------- Original Method ----------
        //table[index] = new HashMapEntry<K, V>(key, value, hash, table[index]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.337 -0400", hash_original_method = "1A0C0EFFA3B59B8426ED7AB00D5D7C14", hash_generated_method = "0ED80084966D32973E9213641BE7C311")
     void addNewEntryForNullKey(V value) {
        entryForNullKey = new HashMapEntry<K, V>(null, value, 0, null);
        // ---------- Original Method ----------
        //entryForNullKey = new HashMapEntry<K, V>(null, value, 0, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.337 -0400", hash_original_method = "08952C170F8B11733B904F0E99F6B0F5", hash_generated_method = "A8BF1E51DA40D4D62C6132EFDBFE7611")
     HashMapEntry<K, V> constructorNewEntry(
            K key, V value, int hash, HashMapEntry<K, V> first) {
        HashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_476226421 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_476226421 = new HashMapEntry<K, V>(key, value, hash, first);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        addTaint(hash);
        addTaint(first.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_476226421.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_476226421;
        // ---------- Original Method ----------
        //return new HashMapEntry<K, V>(key, value, hash, first);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.341 -0400", hash_original_method = "A51614C8AB5E8271029690D5F9184632", hash_generated_method = "D35741D79B2FD354561E200C494D3864")
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size());
        super.putAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //ensureCapacity(map.size());
        //super.putAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.350 -0400", hash_original_method = "4BE6F38D6656B87B29773B0AAEA75993", hash_generated_method = "1F4D9C543F4DE3C273E5161A25A9DC76")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.355 -0400", hash_original_method = "EE2E1A4893DAC33AFE32D39C3AA93587", hash_generated_method = "1D2E64B1A1C5F34062A8E69B5E56133C")
    private HashMapEntry<K, V>[] makeTable(int newCapacity) {
        HashMapEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1490225924 = null; //Variable for return #1
        @SuppressWarnings("unchecked") HashMapEntry<K, V>[] newTable;
        newTable = (HashMapEntry<K, V>[]) new HashMapEntry[newCapacity];
        table = newTable;
        threshold = (newCapacity >> 1) + (newCapacity >> 2);
        varB4EAC82CA7396A68D541C85D26508E83_1490225924 = newTable;
        varB4EAC82CA7396A68D541C85D26508E83_1490225924.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1490225924;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked") HashMapEntry<K, V>[] newTable
                //= (HashMapEntry<K, V>[]) new HashMapEntry[newCapacity];
        //table = newTable;
        //threshold = (newCapacity >> 1) + (newCapacity >> 2);
        //return newTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.364 -0400", hash_original_method = "0D1C32EF365F651EE12DB3FC6B4877B2", hash_generated_method = "FAC53AE14CD694B14CB09003FB53C3EE")
    private HashMapEntry<K, V>[] doubleCapacity() {
        HashMapEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_212691729 = null; //Variable for return #1
        HashMapEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_867052832 = null; //Variable for return #2
        HashMapEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1656397897 = null; //Variable for return #3
        HashMapEntry<K, V>[] oldTable;
        oldTable = table;
        int oldCapacity;
        oldCapacity = oldTable.length;
        {
            varB4EAC82CA7396A68D541C85D26508E83_212691729 = oldTable;
        } //End block
        int newCapacity;
        newCapacity = oldCapacity * 2;
        HashMapEntry<K, V>[] newTable;
        newTable = makeTable(newCapacity);
        {
            varB4EAC82CA7396A68D541C85D26508E83_867052832 = newTable;
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
        varB4EAC82CA7396A68D541C85D26508E83_1656397897 = newTable;
        HashMapEntry<K, V>[] varA7E53CE21691AB073D9660D615818899_1072029880; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1072029880 = varB4EAC82CA7396A68D541C85D26508E83_212691729;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1072029880 = varB4EAC82CA7396A68D541C85D26508E83_867052832;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1072029880 = varB4EAC82CA7396A68D541C85D26508E83_1656397897;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1072029880.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1072029880;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.365 -0400", hash_original_method = "D4E7D7B0427A5C260627922F822E871C", hash_generated_method = "C3E48910FD95AEAA4AF79F7F9B46F658")
    @Override
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1702561393 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_2066558369 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_111611413 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1702561393 = removeNullKey();
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_177126086 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            tab[index] = e.next;
                        } //End block
                        {
                            prev.next = e.next;
                        } //End block
                        postRemove(e);
                        varB4EAC82CA7396A68D541C85D26508E83_2066558369 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_111611413 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_903356598; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_903356598 = varB4EAC82CA7396A68D541C85D26508E83_1702561393;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_903356598 = varB4EAC82CA7396A68D541C85D26508E83_2066558369;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_903356598 = varB4EAC82CA7396A68D541C85D26508E83_111611413;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_903356598.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_903356598;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.366 -0400", hash_original_method = "C27EF61BE4179F161C4389258A9892DE", hash_generated_method = "69EBD8AE86AA14797AD76BFEAF3D0735")
    private V removeNullKey() {
        V varB4EAC82CA7396A68D541C85D26508E83_1898683930 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_560662280 = null; //Variable for return #2
        HashMapEntry<K, V> e;
        e = entryForNullKey;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1898683930 = null;
        } //End block
        entryForNullKey = null;
        postRemove(e);
        varB4EAC82CA7396A68D541C85D26508E83_560662280 = e.value;
        V varA7E53CE21691AB073D9660D615818899_1869987984; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1869987984 = varB4EAC82CA7396A68D541C85D26508E83_1898683930;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1869987984 = varB4EAC82CA7396A68D541C85D26508E83_560662280;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1869987984.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1869987984;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.379 -0400", hash_original_method = "FA0A77625972B3EBD78B9E2926769234", hash_generated_method = "BDB96E09DB8E60586F70F118100AD4CC")
     void postRemove(HashMapEntry<K, V> e) {
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.379 -0400", hash_original_method = "19183B81B15552124143C4B9B1D176AB", hash_generated_method = "36983ECD3B8546C41194A59C9AEA9DE3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.380 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "0233152B9188CDA47CF7C0AC187244E2")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_1491815390 = null; //Variable for return #1
        Set<K> ks;
        ks = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_1491815390 = (ks != null) ? ks : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_1491815390.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1491815390;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.380 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "31EAFDC584589C40DD16768DEEBAD80A")
    @Override
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1140857939 = null; //Variable for return #1
        Collection<V> vs;
        vs = values;
        varB4EAC82CA7396A68D541C85D26508E83_1140857939 = (vs != null) ? vs : (values = new Values());
        varB4EAC82CA7396A68D541C85D26508E83_1140857939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1140857939;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.381 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "33327A8198819264DAB250E7FC30CA80")
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_266403914 = null; //Variable for return #1
        Set<Entry<K, V>> es;
        es = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_266403914 = (es != null) ? es : (entrySet = new EntrySet());
        varB4EAC82CA7396A68D541C85D26508E83_266403914.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_266403914;
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.381 -0400", hash_original_method = "DB078B96D3A026778ABE08AF9188B4AF", hash_generated_method = "46C1ED63081A3A90AFDCEDFAA44002FA")
    private boolean containsMapping(Object key, Object value) {
        {
            HashMapEntry<K, V> e;
            e = entryForNullKey;
            boolean var40279722BF7E3C571A7656157FAC1347_378124574 = (e != null && Objects.equal(value, e.value));
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_594292428 = (e.hash == hash && key.equals(e.key));
                    {
                        boolean var0A2AB9D17E208A44FDDADD38B7C746A6_1431891653 = (Objects.equal(value, e.value));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_790015357 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_790015357;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.389 -0400", hash_original_method = "6968B8C772086C45A00DBEEB8B4680E5", hash_generated_method = "DB816D1D89DB0750D1971E49DD7D33FD")
    private boolean removeMapping(Object key, Object value) {
        {
            HashMapEntry<K, V> e;
            e = entryForNullKey;
            {
                boolean varD3D296D0132E960C37912D3ADB0BA70A_1050657161 = (e == null || !Objects.equal(value, e.value));
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
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_835833746 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            boolean varA66595D18F1E35DC37004284678D0E23_1009520604 = (!Objects.equal(value, e.value));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_830854738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_830854738;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.390 -0400", hash_original_method = "E5C2B853B7FE0DFF8A1198070D9AED67", hash_generated_method = "7B2A7D92F082787915641C4724BE8AD3")
     Iterator<K> newKeyIterator() {
        Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1024985615 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1024985615 = new KeyIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1024985615.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1024985615;
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.390 -0400", hash_original_method = "58BEE1C21CE9010029EB8FF9FDCDF9B3", hash_generated_method = "DC63BC068002480F86971F752D690EC8")
     Iterator<V> newValueIterator() {
        Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_1955128383 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1955128383 = new ValueIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1955128383.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1955128383;
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.391 -0400", hash_original_method = "41242F67E24C22ACB46F6D238FB07528", hash_generated_method = "A4C067C258BEFB6365AE056503F007A8")
     Iterator<Entry<K, V>> newEntryIterator() {
        Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_534569980 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_534569980 = new EntryIterator();
        varB4EAC82CA7396A68D541C85D26508E83_534569980.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_534569980;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.561 -0400", hash_original_method = "04BAFB4D83496263E755E7BD0F7C13FF", hash_generated_method = "3F46AD907BD9A4233CA58D8F179066CB")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("loadFactor", DEFAULT_LOAD_FACTOR);
        stream.writeFields();
        stream.writeInt(table.length);
        stream.writeInt(size);
        {
            Iterator<Entry<K, V>> varD93A6471022189C0BA28AFBB8C8557A0_1392156489 = (entrySet()).iterator();
            varD93A6471022189C0BA28AFBB8C8557A0_1392156489.hasNext();
            Entry<K, V> e = varD93A6471022189C0BA28AFBB8C8557A0_1392156489.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.562 -0400", hash_original_method = "332DDC73CD162DC81E3D2D410CF74F29", hash_generated_method = "832F40F0219241EB8D850459FA57D846")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.562 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.562 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.562 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.562 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "EFF097737D8D1DD9FA2B138EC8EE329B")

        HashMapEntry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.570 -0400", hash_original_method = "59EAB065FDED45CEE8A2A37A4323841C", hash_generated_method = "A273A4961FF63025E25EB678F2528A39")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.571 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "09713998CA00537CC8A28344B062F870")
        public final K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_33667312 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_33667312 = key;
            varB4EAC82CA7396A68D541C85D26508E83_33667312.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_33667312;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.571 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "EACFD5BAE4B00C4480883F4F4F41FF90")
        public final V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_835087279 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_835087279 = value;
            varB4EAC82CA7396A68D541C85D26508E83_835087279.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_835087279;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.599 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "FD0F11EF6C2A1417558CD6D640852B65")
        public final V setValue(V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_1480942861 = null; //Variable for return #1
            V oldValue;
            oldValue = this.value;
            this.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_1480942861 = oldValue;
            varB4EAC82CA7396A68D541C85D26508E83_1480942861.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1480942861;
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.600 -0400", hash_original_method = "A2F2028BE339F747959E241A5FA9FFD4", hash_generated_method = "C560408DBF7FB5BDA8AD074F0A7E155C")
        @Override
        public final boolean equals(Object o) {
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varA6FC4CEB84BC9265AEA86B844A98520F_331543634 = (Objects.equal(e.getKey(), key)
                    && Objects.equal(e.getValue(), value));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1801429669 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1801429669;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return Objects.equal(e.getKey(), key)
                    //&& Objects.equal(e.getValue(), value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.601 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "FF9D7D49C99CE6DD21237426821CEBB5")
        @Override
        public final int hashCode() {
            int var3D869AD0C50894398C24E31912CFB90B_1156507731 = ((key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078004473 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078004473;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode()) ^
                    //(value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.601 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "CD8D91BE64E502ED479799388A4616F5")
        @Override
        public final String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1371773531 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1371773531 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_1371773531.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1371773531;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
    }


    
    private abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.601 -0400", hash_original_field = "B6F75212F617C3E247C9474AFDA3B784", hash_generated_field = "04911A8A6B33F6D23811475122C95D0E")

        int nextIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.601 -0400", hash_original_field = "1BF1C18789BF9A611993EC2DE07C682C", hash_generated_field = "714CC477FAEEEEC0B90131EEA4F76ACE")

        HashMapEntry<K, V> nextEntry = entryForNullKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.601 -0400", hash_original_field = "8A3A9937F6D0DA3448C9C061B347CECF", hash_generated_field = "0C026A4A91581F8AA81723168CEE7A19")

        HashMapEntry<K, V> lastEntryReturned;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.601 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "17128C49BCF19B4186F02F384F2DEA86")

        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.602 -0400", hash_original_method = "1EAE57F880E5B81388FFC9611EFAA8EA", hash_generated_method = "51B338D2FBA648AB206D69E1243CB95C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.602 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "6E2457A2C1DC2DA7518F2BB6C3547EAF")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1784721594 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1784721594;
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.608 -0400", hash_original_method = "5956AFD098F3B365104EB4761E150134", hash_generated_method = "A3A052FD92CFF61520DB4935CB236044")
         HashMapEntry<K, V> nextEntry() {
            HashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1008895479 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1008895479 = lastEntryReturned = entryToReturn;
            varB4EAC82CA7396A68D541C85D26508E83_1008895479.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1008895479;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.608 -0400", hash_original_method = "FE8482BFEC11D819DE4FA740E823F031", hash_generated_method = "F04FA077471E00E01DE713F18A0BE8B7")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.608 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.618 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "14EE43C5510BB3FE65DCF1CB908DEABD")
        public K next() {
            K varB4EAC82CA7396A68D541C85D26508E83_1381962236 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1381962236 = nextEntry().key;
            varB4EAC82CA7396A68D541C85D26508E83_1381962236.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1381962236;
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends HashIterator implements Iterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.618 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.618 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "FA201BF186D5B1129290EB67458D012F")
        public V next() {
            V varB4EAC82CA7396A68D541C85D26508E83_1723435512 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1723435512 = nextEntry().value;
            varB4EAC82CA7396A68D541C85D26508E83_1723435512.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1723435512;
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.618 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.619 -0400", hash_original_method = "C7E2B840B075445DC1033B130AB2E6A6", hash_generated_method = "D62DF41EE3482DD3B7E61121979F2CEC")
        public Entry<K, V> next() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_853438140 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_853438140 = nextEntry();
            varB4EAC82CA7396A68D541C85D26508E83_853438140.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_853438140;
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.619 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.619 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "BA1A087FF7780F6E8743A4B9AC0AB4C4")
        public Iterator<K> iterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_548253062 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_548253062 = newKeyIterator();
            varB4EAC82CA7396A68D541C85D26508E83_548253062.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_548253062;
            // ---------- Original Method ----------
            //return newKeyIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.619 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "DD3F93848C45B7BBCF54F1167923BC1D")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364910998 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364910998;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.657 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "BB5DFD1EF3BA3A6B118BA822B974B361")
        public boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1670545458 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1670545458;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.657 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "02DE17F98AC3F25E0DD155057EF558BC")
        public boolean contains(Object o) {
            boolean var997BAB39B2F072D5CD66A271F3B6E196_482209396 = (containsKey(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312802503 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312802503;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.658 -0400", hash_original_method = "AFD23FBC02983B6BF4B878FD36F94DEB", hash_generated_method = "ED9A1E9B965C6FC96E8066A72B90A5F6")
        public boolean remove(Object o) {
            int oldSize;
            oldSize = size;
            HashMap.this.remove(o);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910041967 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910041967;
            // ---------- Original Method ----------
            //int oldSize = size;
            //HashMap.this.remove(o);
            //return size != oldSize;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.658 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    private final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.658 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.658 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "23A6A3DA2D12E06F829E97938D5C5A41")
        public Iterator<V> iterator() {
            Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_128545755 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_128545755 = newValueIterator();
            varB4EAC82CA7396A68D541C85D26508E83_128545755.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_128545755;
            // ---------- Original Method ----------
            //return newValueIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.659 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "18B849343B25CD3EC24CEC37B9EAD848")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132292616 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132292616;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.659 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "D3D296B23104268DE5DFC8DC80EE334B")
        public boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1049009330 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1049009330;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.659 -0400", hash_original_method = "C13053467D6FDF772DF450C87D40A3D5", hash_generated_method = "6A461519383B26732D749D65A2A080C3")
        public boolean contains(Object o) {
            boolean varD1EEFCBD27E28C71EA594EC596966CFD_1086306090 = (containsValue(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226935201 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226935201;
            // ---------- Original Method ----------
            //return containsValue(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.660 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    private final class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.660 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.661 -0400", hash_original_method = "D7164BC97FFDCB587AB273006C953E50", hash_generated_method = "3797A3159FE4B633E8D0FD9CE736C7F7")
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_525681178 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_525681178 = newEntryIterator();
            varB4EAC82CA7396A68D541C85D26508E83_525681178.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_525681178;
            // ---------- Original Method ----------
            //return newEntryIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.661 -0400", hash_original_method = "6E695F138E29D844DC896198513B6135", hash_generated_method = "486FB938F42D267F4E5E86FC73C8C43F")
        public boolean contains(Object o) {
            Entry<?, ?> e;
            e = (Entry<?, ?>) o;
            boolean varEC3A3E183CD0A7D33A5B45EDAE091B2E_688819282 = (containsMapping(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676718855 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676718855;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return containsMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.680 -0400", hash_original_method = "F484CBC8566C601718EDE0034034C7B3", hash_generated_method = "A75588B458FD81199AD2EE6C8AAB08B5")
        public boolean remove(Object o) {
            Entry<?, ?> e;
            e = (Entry<?, ?>)o;
            boolean var598A216136B4C4D06069F46B6EC81DD9_1041744388 = (removeMapping(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_853768808 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_853768808;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>)o;
            //return removeMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.680 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "C1A0A8AF06FCDBB27102F5D9C9E2DC71")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60981467 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60981467;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.680 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "8D01DEBE598BFFB7C037093A34ED0545")
        public boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1228124686 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1228124686;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.680 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.680 -0400", hash_original_field = "74773297EBE9767DD8F1E8A0F109042B", hash_generated_field = "4FA46765B2A3EF08CC97297AFC75A0ED")

    private static int MINIMUM_CAPACITY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.681 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "864BDCB1A430DAF5D56F9061E7B2A26F")

    private static int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.681 -0400", hash_original_field = "A1E5317AEBE2AA7B440C685A8E07ADDF", hash_generated_field = "947F578B0E9421AD06047343845DB1DB")

    private static Entry[] EMPTY_TABLE = new HashMapEntry[MINIMUM_CAPACITY >>> 1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.681 -0400", hash_original_field = "2457D6689D4C035FB0208C51E3216836", hash_generated_field = "412B498E8D39470CA979972558ED44E9")

    static float DEFAULT_LOAD_FACTOR = .75F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.681 -0400", hash_original_field = "B9B0D4CAFA519E3022BDB211EDB6108F", hash_generated_field = "41BDCB2D4BCA21EC570050DA29ACC543")

    private static long serialVersionUID = 362498820763181265L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.681 -0400", hash_original_field = "6B5047BD80649C86F20ACE5466546B8B", hash_generated_field = "F5A553668FBA04FFB18FC841AA098729")

    private static ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("loadFactor", float.class)
    };
}


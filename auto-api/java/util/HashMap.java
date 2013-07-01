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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.958 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "5BCDF9B3CCDE8C26B422211A63786F6F")

    transient HashMapEntry<K, V>[] table;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.958 -0400", hash_original_field = "789DFF82296D9E921000DB270879418B", hash_generated_field = "001B08BF95F5AEB6F938F9E6275C3105")

    transient HashMapEntry<K, V> entryForNullKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.958 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "7BEABDDA8AE5EA70226B47F806396840")

    transient int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.958 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "66B0BB3B51ED8DFDAEFDC2833CA7C4AB")

    transient int modCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.958 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "AC9BEC59E41404676A448C0DD2BB745B")

    private transient int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.958 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "EB6C570550CCFE8E5FEBB44BA37D02C0")

    private transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.958 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "BFDE585634496DDD7FBD15EDD2D3C5DD")

    private transient Set<Entry<K, V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.958 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "5A2A505CEEC79706812E901D735E2A7C")

    private transient Collection<V> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.958 -0400", hash_original_method = "67F8ADB6599C3AA95FA8DFFD843377DD", hash_generated_method = "7409D258B8D042741B25C0440FA51BF9")
    @SuppressWarnings("unchecked")
    public  HashMap() {
        table = (HashMapEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1;
        // ---------- Original Method ----------
        //table = (HashMapEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.958 -0400", hash_original_method = "DBEA46BF5DB352E6536C06B54FDF6C1E", hash_generated_method = "612772902DB46ACB4AADC1244B030310")
    public  HashMap(int capacity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Capacity: " + capacity);
        } //End block
        {
            @SuppressWarnings("unchecked") HashMapEntry<K, V>[] tab = (HashMapEntry<K, V>[]) EMPTY_TABLE;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.959 -0400", hash_original_method = "ED265422F07438826BD7CEB727CA13DA", hash_generated_method = "93E670163B428FD5AFF45A4D427534B1")
    public  HashMap(int capacity, float loadFactor) {
        this(capacity);
        {
            boolean var7E96777C74EA86B66256F7B00F5AE961_331988622 = (loadFactor <= 0 || Float.isNaN(loadFactor));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.959 -0400", hash_original_method = "D988B3BE94D6CE1D83E9BB54AA86E55F", hash_generated_method = "3E2B06BFA5313BED39B7740BA34828C4")
    public  HashMap(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        constructorPutAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.962 -0400", hash_original_method = "6631235722E4D3190E3529D2039DDD7A", hash_generated_method = "A6081E0DE071576701528C2E5F3CBEC9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.963 -0400", hash_original_method = "C555E25CE67FE12926CA5480B863847E", hash_generated_method = "1C12E13428387AE0E1510F5761D523AD")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1075344535 = null; //Variable for return #1
        HashMap<K, V> result;
        try 
        {
            result = (HashMap<K, V>) super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
        	throw new AssertionError(e);
        } //End block
        result.makeTable(table.length);
        result.entryForNullKey = null;
        result.size = 0;
        result.keySet = null;
        result.entrySet = null;
        result.values = null;
        result.init();
        result.constructorPutAll(this);
        varB4EAC82CA7396A68D541C85D26508E83_1075344535 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1075344535.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1075344535;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.963 -0400", hash_original_method = "417EF77086319CE91314CCF850ADA61E", hash_generated_method = "2067003B6622767497B839D408201FF1")
     void init() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.963 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "8D695823F6F1D90B768FC1C9033E16D8")
    @Override
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646668981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_646668981;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.963 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "BAD1DC5A4EACD17E86B591589B0E031B")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858589 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858589;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.964 -0400", hash_original_method = "D55BBCD9F0C6BD0BD798F81C2A3EFECD", hash_generated_method = "B7FB49BDDABCE103C7B0BBD1E644C7A5")
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_745537855 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_356416656 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_438761615 = null; //Variable for return #3
        {
            HashMapEntry<K, V> e = entryForNullKey;
            varB4EAC82CA7396A68D541C85D26508E83_745537855 = e == null ? null : e.value;
        } //End block
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashMapEntry<K, V>[] tab = table;
        {
            HashMapEntry<K, V> e = tab[hash & (tab.length - 1)];
            e = e.next;
            {
                K eKey = e.key;
                {
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_599955692 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_356416656 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_438761615 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_578167588; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_578167588 = varB4EAC82CA7396A68D541C85D26508E83_745537855;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_578167588 = varB4EAC82CA7396A68D541C85D26508E83_356416656;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_578167588 = varB4EAC82CA7396A68D541C85D26508E83_438761615;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_578167588.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_578167588;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.965 -0400", hash_original_method = "664DBEAFB6D0F34975160DBB887BD5CA", hash_generated_method = "13CCC5B46ACF1DBBAC3598C8DD31E046")
    @Override
    public boolean containsKey(Object key) {
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashMapEntry<K, V>[] tab = table;
        {
            HashMapEntry<K, V> e = tab[hash & (tab.length - 1)];
            e = e.next;
            {
                K eKey = e.key;
                {
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_1678082059 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663610192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663610192;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.966 -0400", hash_original_method = "8A9DFD8A0E528EE1DFDA14FDA5F2B177", hash_generated_method = "E2E80BBAD6201E00B75A3ECCFEE52243")
    @Override
    public boolean containsValue(Object value) {
        HashMapEntry[] tab = table;
        int len = tab.length;
        {
            {
                int i = 0;
                {
                    {
                        HashMapEntry e = tab[i];
                        e = e.next;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int i = 0;
            {
                {
                    HashMapEntry e = tab[i];
                    e = e.next;
                    {
                        {
                            boolean varB228932AA07990623CC3C29EF03F40DA_1414782479 = (value.equals(e.value));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean varEA7E3E060F89A85EADC32277C95F3D47_849817229 = (entryForNullKey != null && value.equals(entryForNullKey.value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2114976942 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2114976942;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.966 -0400", hash_original_method = "5BBA395276A0B9AAD236878C1432D189", hash_generated_method = "E4472B32AD458790E861C6E4293F3BFB")
    @Override
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_2075503543 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_823487519 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_2083819024 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_2075503543 = putValueForNullKey(value);
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        {
            HashMapEntry<K, V> e = tab[index];
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_811289729 = (e.hash == hash && key.equals(e.key));
                    {
                        preModify(e);
                        V oldValue = e.value;
                        e.value = value;
                        varB4EAC82CA7396A68D541C85D26508E83_823487519 = oldValue;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            tab = doubleCapacity();
            index = hash & (tab.length - 1);
        } //End block
        addNewEntry(key, value, hash, index);
        varB4EAC82CA7396A68D541C85D26508E83_2083819024 = null;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        V varA7E53CE21691AB073D9660D615818899_483400962; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_483400962 = varB4EAC82CA7396A68D541C85D26508E83_2075503543;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_483400962 = varB4EAC82CA7396A68D541C85D26508E83_823487519;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_483400962 = varB4EAC82CA7396A68D541C85D26508E83_2083819024;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_483400962.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_483400962;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.967 -0400", hash_original_method = "23837E71B15780DD12C36C21FB15F598", hash_generated_method = "74CEE3AA1BC3D3E3403DA30AF94312EC")
    private V putValueForNullKey(V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_430589176 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_645006483 = null; //Variable for return #2
        HashMapEntry<K, V> entry = entryForNullKey;
        {
            addNewEntryForNullKey(value);
            varB4EAC82CA7396A68D541C85D26508E83_430589176 = null;
        } //End block
        {
            preModify(entry);
            V oldValue = entry.value;
            entry.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_645006483 = oldValue;
        } //End block
        addTaint(value.getTaint());
        V varA7E53CE21691AB073D9660D615818899_725997330; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_725997330 = varB4EAC82CA7396A68D541C85D26508E83_430589176;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_725997330 = varB4EAC82CA7396A68D541C85D26508E83_645006483;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_725997330.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_725997330;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.967 -0400", hash_original_method = "DFE0557B59605BA6C5CD9DE7502DD68F", hash_generated_method = "8E8423E144F06F950B93A82209065B3F")
     void preModify(HashMapEntry<K, V> e) {
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.968 -0400", hash_original_method = "627029122DE3FFF8BEA7942964D9C227", hash_generated_method = "BFEC81CF9F795F62B2263A7EEF50CD06")
    private void constructorPut(K key, V value) {
        {
            HashMapEntry<K, V> entry = entryForNullKey;
            {
                entryForNullKey = constructorNewEntry(null, value, 0, null);
            } //End block
            {
                entry.value = value;
            } //End block
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        HashMapEntry<K, V> first = tab[index];
        {
            HashMapEntry<K, V> e = first;
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_678134418 = (e.hash == hash && key.equals(e.key));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.968 -0400", hash_original_method = "6DFE8ABD0EB0EC55F81B8127E2FB540C", hash_generated_method = "453D2264FFA6453AAFEB1CBBCCBC261D")
     void addNewEntry(K key, V value, int hash, int index) {
        table[index] = new HashMapEntry<K, V>(key, value, hash, table[index]);
        // ---------- Original Method ----------
        //table[index] = new HashMapEntry<K, V>(key, value, hash, table[index]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.969 -0400", hash_original_method = "1A0C0EFFA3B59B8426ED7AB00D5D7C14", hash_generated_method = "0ED80084966D32973E9213641BE7C311")
     void addNewEntryForNullKey(V value) {
        entryForNullKey = new HashMapEntry<K, V>(null, value, 0, null);
        // ---------- Original Method ----------
        //entryForNullKey = new HashMapEntry<K, V>(null, value, 0, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.969 -0400", hash_original_method = "08952C170F8B11733B904F0E99F6B0F5", hash_generated_method = "C56E56255B7E661E9639615699C0A71E")
     HashMapEntry<K, V> constructorNewEntry(
            K key, V value, int hash, HashMapEntry<K, V> first) {
        HashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1589843037 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1589843037 = new HashMapEntry<K, V>(key, value, hash, first);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        addTaint(hash);
        addTaint(first.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1589843037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1589843037;
        // ---------- Original Method ----------
        //return new HashMapEntry<K, V>(key, value, hash, first);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.970 -0400", hash_original_method = "A51614C8AB5E8271029690D5F9184632", hash_generated_method = "D35741D79B2FD354561E200C494D3864")
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size());
        super.putAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //ensureCapacity(map.size());
        //super.putAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.970 -0400", hash_original_method = "4BE6F38D6656B87B29773B0AAEA75993", hash_generated_method = "4C77F4E2D3A1FB24BBA9C2007793AF4A")
    private void ensureCapacity(int numMappings) {
        int newCapacity = roundUpToPowerOfTwo(capacityForInitSize(numMappings));
        HashMapEntry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;
        {
            doubleCapacity();
        } //End block
        HashMapEntry<K, V>[] newTable = makeTable(newCapacity);
        {
            int newMask = newCapacity - 1;
            {
                int i = 0;
                {
                    {
                        HashMapEntry<K, V> e = oldTable[i];
                        {
                            HashMapEntry<K, V> oldNext = e.next;
                            int newIndex = e.hash & newMask;
                            HashMapEntry<K, V> newNext = newTable[newIndex];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.971 -0400", hash_original_method = "EE2E1A4893DAC33AFE32D39C3AA93587", hash_generated_method = "2B6FD00DD1854C8DFA41889F7E647AB5")
    private HashMapEntry<K, V>[] makeTable(int newCapacity) {
        HashMapEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1830868341 = null; //Variable for return #1
        @SuppressWarnings("unchecked") HashMapEntry<K, V>[] newTable = (HashMapEntry<K, V>[]) new HashMapEntry[newCapacity];
        table = newTable;
        threshold = (newCapacity >> 1) + (newCapacity >> 2);
        varB4EAC82CA7396A68D541C85D26508E83_1830868341 = newTable;
        varB4EAC82CA7396A68D541C85D26508E83_1830868341.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1830868341;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked") HashMapEntry<K, V>[] newTable
                //= (HashMapEntry<K, V>[]) new HashMapEntry[newCapacity];
        //table = newTable;
        //threshold = (newCapacity >> 1) + (newCapacity >> 2);
        //return newTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.973 -0400", hash_original_method = "0D1C32EF365F651EE12DB3FC6B4877B2", hash_generated_method = "B189530D3C1AED90CBA7925978946072")
    private HashMapEntry<K, V>[] doubleCapacity() {
        HashMapEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_120659179 = null; //Variable for return #1
        HashMapEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_1457195041 = null; //Variable for return #2
        HashMapEntry<K, V>[] varB4EAC82CA7396A68D541C85D26508E83_176752567 = null; //Variable for return #3
        HashMapEntry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;
        {
            varB4EAC82CA7396A68D541C85D26508E83_120659179 = oldTable;
        } //End block
        int newCapacity = oldCapacity * 2;
        HashMapEntry<K, V>[] newTable = makeTable(newCapacity);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1457195041 = newTable;
        } //End block
        {
            int j = 0;
            {
                HashMapEntry<K, V> e = oldTable[j];
                int highBit = e.hash & oldCapacity;
                HashMapEntry<K, V> broken = null;
                newTable[j | highBit] = e;
                {
                    HashMapEntry<K, V> n = e.next;
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
        varB4EAC82CA7396A68D541C85D26508E83_176752567 = newTable;
        HashMapEntry<K, V>[] varA7E53CE21691AB073D9660D615818899_1682105978; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1682105978 = varB4EAC82CA7396A68D541C85D26508E83_120659179;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1682105978 = varB4EAC82CA7396A68D541C85D26508E83_1457195041;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1682105978 = varB4EAC82CA7396A68D541C85D26508E83_176752567;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1682105978.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1682105978;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.975 -0400", hash_original_method = "D4E7D7B0427A5C260627922F822E871C", hash_generated_method = "47E3B384F9FDDB3A130EE17DB469B2B6")
    @Override
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_146286328 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_640913569 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_211324445 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_146286328 = removeNullKey();
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        {
            HashMapEntry<K, V> e = tab[index];
            HashMapEntry<K, V> prev = null;
            prev = e;
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_561774383 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            tab[index] = e.next;
                        } //End block
                        {
                            prev.next = e.next;
                        } //End block
                        postRemove(e);
                        varB4EAC82CA7396A68D541C85D26508E83_640913569 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_211324445 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_45104183; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_45104183 = varB4EAC82CA7396A68D541C85D26508E83_146286328;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_45104183 = varB4EAC82CA7396A68D541C85D26508E83_640913569;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_45104183 = varB4EAC82CA7396A68D541C85D26508E83_211324445;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_45104183.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_45104183;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.976 -0400", hash_original_method = "C27EF61BE4179F161C4389258A9892DE", hash_generated_method = "22FAD83EC94B5E8A6259D6F21EC172FD")
    private V removeNullKey() {
        V varB4EAC82CA7396A68D541C85D26508E83_1408417633 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1075509535 = null; //Variable for return #2
        HashMapEntry<K, V> e = entryForNullKey;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1408417633 = null;
        } //End block
        entryForNullKey = null;
        postRemove(e);
        varB4EAC82CA7396A68D541C85D26508E83_1075509535 = e.value;
        V varA7E53CE21691AB073D9660D615818899_477849352; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_477849352 = varB4EAC82CA7396A68D541C85D26508E83_1408417633;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_477849352 = varB4EAC82CA7396A68D541C85D26508E83_1075509535;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_477849352.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_477849352;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.977 -0400", hash_original_method = "FA0A77625972B3EBD78B9E2926769234", hash_generated_method = "BDB96E09DB8E60586F70F118100AD4CC")
     void postRemove(HashMapEntry<K, V> e) {
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.977 -0400", hash_original_method = "19183B81B15552124143C4B9B1D176AB", hash_generated_method = "36983ECD3B8546C41194A59C9AEA9DE3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.978 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "C1DD17BD35348492458746D589045D18")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_1303485791 = null; //Variable for return #1
        Set<K> ks = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_1303485791 = (ks != null) ? ks : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_1303485791.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1303485791;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.978 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "6807DD1CE16B38D11186695390E5E8FB")
    @Override
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_1473797439 = null; //Variable for return #1
        Collection<V> vs = values;
        varB4EAC82CA7396A68D541C85D26508E83_1473797439 = (vs != null) ? vs : (values = new Values());
        varB4EAC82CA7396A68D541C85D26508E83_1473797439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1473797439;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.979 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "8AC548CD0B3CA85F98823C33D749EFA9")
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1314758451 = null; //Variable for return #1
        Set<Entry<K, V>> es = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_1314758451 = (es != null) ? es : (entrySet = new EntrySet());
        varB4EAC82CA7396A68D541C85D26508E83_1314758451.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1314758451;
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.979 -0400", hash_original_method = "DB078B96D3A026778ABE08AF9188B4AF", hash_generated_method = "B952DF4D4218F00A32091CDD922B39B4")
    private boolean containsMapping(Object key, Object value) {
        {
            HashMapEntry<K, V> e = entryForNullKey;
            boolean var40279722BF7E3C571A7656157FAC1347_1553335321 = (e != null && Objects.equal(value, e.value));
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        {
            HashMapEntry<K, V> e = tab[index];
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_1789108639 = (e.hash == hash && key.equals(e.key));
                    {
                        boolean var0A2AB9D17E208A44FDDADD38B7C746A6_1983606162 = (Objects.equal(value, e.value));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719790528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719790528;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.980 -0400", hash_original_method = "6968B8C772086C45A00DBEEB8B4680E5", hash_generated_method = "0A4CB9CB3AB16824B3DB3D9E55C7E051")
    private boolean removeMapping(Object key, Object value) {
        {
            HashMapEntry<K, V> e = entryForNullKey;
            {
                boolean varD3D296D0132E960C37912D3ADB0BA70A_773715497 = (e == null || !Objects.equal(value, e.value));
            } //End collapsed parenthetic
            entryForNullKey = null;
            postRemove(e);
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        {
            HashMapEntry<K, V> e = tab[index];
            HashMapEntry<K, V> prev = null;
            prev = e;
            e = e.next;
            {
                {
                    boolean varCF3CB06D8B3423834BD16D9452B8E29B_934062946 = (e.hash == hash && key.equals(e.key));
                    {
                        {
                            boolean varA66595D18F1E35DC37004284678D0E23_391799587 = (!Objects.equal(value, e.value));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_508747965 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_508747965;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.981 -0400", hash_original_method = "E5C2B853B7FE0DFF8A1198070D9AED67", hash_generated_method = "DA68464ED9DBC71FE0B453C2882E6348")
     Iterator<K> newKeyIterator() {
        Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1947505655 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1947505655 = new KeyIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1947505655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1947505655;
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.982 -0400", hash_original_method = "58BEE1C21CE9010029EB8FF9FDCDF9B3", hash_generated_method = "8D8E21FBEF34A3B9AA4B5E6E9875882F")
     Iterator<V> newValueIterator() {
        Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_307450329 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_307450329 = new ValueIterator();
        varB4EAC82CA7396A68D541C85D26508E83_307450329.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_307450329;
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.983 -0400", hash_original_method = "41242F67E24C22ACB46F6D238FB07528", hash_generated_method = "2191D081D3A92A5B4D71C37AEB267E38")
     Iterator<Entry<K, V>> newEntryIterator() {
        Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1248208082 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1248208082 = new EntryIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1248208082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1248208082;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.989 -0400", hash_original_method = "04BAFB4D83496263E755E7BD0F7C13FF", hash_generated_method = "0EA735FC882A5A31141542EAC6BB89DF")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("loadFactor", DEFAULT_LOAD_FACTOR);
        stream.writeFields();
        stream.writeInt(table.length);
        stream.writeInt(size);
        {
            Iterator<Entry<K, V>> varD93A6471022189C0BA28AFBB8C8557A0_2144677597 = (entrySet()).iterator();
            varD93A6471022189C0BA28AFBB8C8557A0_2144677597.hasNext();
            Entry<K, V> e = varD93A6471022189C0BA28AFBB8C8557A0_2144677597.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.990 -0400", hash_original_method = "332DDC73CD162DC81E3D2D410CF74F29", hash_generated_method = "97402D3589D55AD66128E64F571A9699")
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
        init();
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

    
    static class HashMapEntry<K, V> implements Entry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.990 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.990 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.990 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.990 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "EFF097737D8D1DD9FA2B138EC8EE329B")

        HashMapEntry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.991 -0400", hash_original_method = "59EAB065FDED45CEE8A2A37A4323841C", hash_generated_method = "A273A4961FF63025E25EB678F2528A39")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.992 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "3FDF1FF513FF645236C316F924A1EB11")
        public final K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1638009385 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1638009385 = key;
            varB4EAC82CA7396A68D541C85D26508E83_1638009385.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1638009385;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.993 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "58FBFE78733E3F79EABB49D0E11DCA3B")
        public final V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_2105406221 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2105406221 = value;
            varB4EAC82CA7396A68D541C85D26508E83_2105406221.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2105406221;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.996 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "98E08C42BC845300962C11503E982964")
        public final V setValue(V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_634997629 = null; //Variable for return #1
            V oldValue = this.value;
            this.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_634997629 = oldValue;
            varB4EAC82CA7396A68D541C85D26508E83_634997629.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_634997629;
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.998 -0400", hash_original_method = "A2F2028BE339F747959E241A5FA9FFD4", hash_generated_method = "B8D735A20698B1BE7A50B7C8A8541172")
        @Override
        public final boolean equals(Object o) {
            Entry<?, ?> e = (Entry<?, ?>) o;
            boolean varA6FC4CEB84BC9265AEA86B844A98520F_156141990 = (Objects.equal(e.getKey(), key)
                    && Objects.equal(e.getValue(), value));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498436805 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498436805;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return Objects.equal(e.getKey(), key)
                    //&& Objects.equal(e.getValue(), value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.999 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "1343A4BDB5527E6B7EBFEEFB1AFD2B43")
        @Override
        public final int hashCode() {
            int var3D869AD0C50894398C24E31912CFB90B_1505617375 = ((key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532574860 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532574860;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode()) ^
                    //(value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.000 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "1429AADE11F5E8722573B5E30E892D64")
        @Override
        public final String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1627287655 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1627287655 = key + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_1627287655.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1627287655;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
    }


    
    private abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.000 -0400", hash_original_field = "B6F75212F617C3E247C9474AFDA3B784", hash_generated_field = "04911A8A6B33F6D23811475122C95D0E")

        int nextIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.000 -0400", hash_original_field = "1BF1C18789BF9A611993EC2DE07C682C", hash_generated_field = "714CC477FAEEEEC0B90131EEA4F76ACE")

        HashMapEntry<K, V> nextEntry = entryForNullKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.000 -0400", hash_original_field = "8A3A9937F6D0DA3448C9C061B347CECF", hash_generated_field = "0C026A4A91581F8AA81723168CEE7A19")

        HashMapEntry<K, V> lastEntryReturned;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.000 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "17128C49BCF19B4186F02F384F2DEA86")

        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.001 -0400", hash_original_method = "1EAE57F880E5B81388FFC9611EFAA8EA", hash_generated_method = "4B9A3A0A9A7FDED3AB33C19933E769E1")
          HashIterator() {
            {
                HashMapEntry<K, V>[] tab = table;
                HashMapEntry<K, V> next = null;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.001 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "AF2EBDA5E94CBF0E7483048966006065")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1725693423 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1725693423;
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.002 -0400", hash_original_method = "5956AFD098F3B365104EB4761E150134", hash_generated_method = "6FDB8A797E5978A6F50E05648A411ED1")
         HashMapEntry<K, V> nextEntry() {
            HashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1861589913 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            HashMapEntry<K, V> entryToReturn = nextEntry;
            HashMapEntry<K, V>[] tab = table;
            HashMapEntry<K, V> next = entryToReturn.next;
            {
                next = tab[nextIndex++];
            } //End block
            nextEntry = next;
            varB4EAC82CA7396A68D541C85D26508E83_1861589913 = lastEntryReturned = entryToReturn;
            varB4EAC82CA7396A68D541C85D26508E83_1861589913.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1861589913;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.002 -0400", hash_original_method = "FE8482BFEC11D819DE4FA740E823F031", hash_generated_method = "F04FA077471E00E01DE713F18A0BE8B7")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.002 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.003 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "B4BC3417ADBC9DB4BDF53380F8F9603C")
        public K next() {
            K varB4EAC82CA7396A68D541C85D26508E83_427231341 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_427231341 = nextEntry().key;
            varB4EAC82CA7396A68D541C85D26508E83_427231341.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_427231341;
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends HashIterator implements Iterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.003 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.004 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "040F0E4F355592FCF38BF15D12D82B40")
        public V next() {
            V varB4EAC82CA7396A68D541C85D26508E83_1308353326 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1308353326 = nextEntry().value;
            varB4EAC82CA7396A68D541C85D26508E83_1308353326.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1308353326;
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.004 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.005 -0400", hash_original_method = "C7E2B840B075445DC1033B130AB2E6A6", hash_generated_method = "270BF1420453F5697504155B6BFE72FC")
        public Entry<K, V> next() {
            Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_603431830 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_603431830 = nextEntry();
            varB4EAC82CA7396A68D541C85D26508E83_603431830.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_603431830;
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.005 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.006 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "80994ECEBDA04F6AF0A4BE641B3FAF66")
        public Iterator<K> iterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_393276758 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_393276758 = newKeyIterator();
            varB4EAC82CA7396A68D541C85D26508E83_393276758.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_393276758;
            // ---------- Original Method ----------
            //return newKeyIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.006 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "DC747E0C47749EA1D9F719193FDCE15B")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_594156011 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_594156011;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.006 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "A6AC67BDC2E82648929795022BEAF915")
        public boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_788959144 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_788959144;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.007 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "68E06C1BEBC3A06A57A40C45A2733E68")
        public boolean contains(Object o) {
            boolean var997BAB39B2F072D5CD66A271F3B6E196_658833114 = (containsKey(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1751489276 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1751489276;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.008 -0400", hash_original_method = "AFD23FBC02983B6BF4B878FD36F94DEB", hash_generated_method = "3BA3594C306EE422D6FC6C3C3E578D62")
        public boolean remove(Object o) {
            int oldSize = size;
            HashMap.this.remove(o);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241419278 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241419278;
            // ---------- Original Method ----------
            //int oldSize = size;
            //HashMap.this.remove(o);
            //return size != oldSize;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.008 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    private final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.008 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.009 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "1A0D101C2E28C43DCE9FE2360B52ECF9")
        public Iterator<V> iterator() {
            Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_632831829 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_632831829 = newValueIterator();
            varB4EAC82CA7396A68D541C85D26508E83_632831829.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_632831829;
            // ---------- Original Method ----------
            //return newValueIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.010 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "86012ADF3E2CE4A6BC997279A44EA73F")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548415433 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548415433;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.010 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "486F53B6B0688D52F1CD19676E1D5F24")
        public boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_587761453 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_587761453;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.010 -0400", hash_original_method = "C13053467D6FDF772DF450C87D40A3D5", hash_generated_method = "A772747F4B3E76C6F497BB42319FB8BE")
        public boolean contains(Object o) {
            boolean varD1EEFCBD27E28C71EA594EC596966CFD_1286228690 = (containsValue(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1905254161 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1905254161;
            // ---------- Original Method ----------
            //return containsValue(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.011 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    private final class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.011 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.012 -0400", hash_original_method = "D7164BC97FFDCB587AB273006C953E50", hash_generated_method = "71EC23A7FAA85BE32C6CE13B765393C9")
        public Iterator<Entry<K, V>> iterator() {
            Iterator<Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_429999511 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_429999511 = newEntryIterator();
            varB4EAC82CA7396A68D541C85D26508E83_429999511.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_429999511;
            // ---------- Original Method ----------
            //return newEntryIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.013 -0400", hash_original_method = "6E695F138E29D844DC896198513B6135", hash_generated_method = "410F25519DB1F04AB7069DA93FADE95E")
        public boolean contains(Object o) {
            Entry<?, ?> e = (Entry<?, ?>) o;
            boolean varEC3A3E183CD0A7D33A5B45EDAE091B2E_1920567933 = (containsMapping(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577980913 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577980913;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return containsMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.013 -0400", hash_original_method = "F484CBC8566C601718EDE0034034C7B3", hash_generated_method = "2A1253C2DC1FD4ED860F3B182AC675CC")
        public boolean remove(Object o) {
            Entry<?, ?> e = (Entry<?, ?>)o;
            boolean var598A216136B4C4D06069F46B6EC81DD9_1838884605 = (removeMapping(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_623085871 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_623085871;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>)o;
            //return removeMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.013 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "A6FD493759F5BDC67A0501F4EF248B01")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078896349 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078896349;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.013 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "F0B6DC3A041EB06BE93EA04906D0F1FB")
        public boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349432921 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349432921;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.014 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.014 -0400", hash_original_field = "74773297EBE9767DD8F1E8A0F109042B", hash_generated_field = "2D66E915A2C4A5FBF28A99892F20B1AF")

    private static final int MINIMUM_CAPACITY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.014 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "C94813E6F46C48A83BBFCFA3C9862983")

    private static final int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.014 -0400", hash_original_field = "A1E5317AEBE2AA7B440C685A8E07ADDF", hash_generated_field = "EAEFC19DF41584BBCC74BC909378688B")

    private static final Entry[] EMPTY_TABLE = new HashMapEntry[MINIMUM_CAPACITY >>> 1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.014 -0400", hash_original_field = "2457D6689D4C035FB0208C51E3216836", hash_generated_field = "8B66B6321C50459F7579C610CEA9040E")

    static final float DEFAULT_LOAD_FACTOR = .75F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.014 -0400", hash_original_field = "B9B0D4CAFA519E3022BDB211EDB6108F", hash_generated_field = "895D2EFED015878DCDE59CE17F2ED051")

    private static final long serialVersionUID = 362498820763181265L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.014 -0400", hash_original_field = "6B5047BD80649C86F20ACE5466546B8B", hash_generated_field = "07BD8E29CA88435F65E9AD35F51067E8")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("loadFactor", float.class)
    };
}


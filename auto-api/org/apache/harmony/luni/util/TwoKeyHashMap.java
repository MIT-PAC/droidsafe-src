package org.apache.harmony.luni.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class TwoKeyHashMap<E, K, V> extends AbstractMap<String, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.246 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "922E9E523E3B4B4E0BBECCC2419D9A8A")

    private Set<Map.Entry<String, V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.247 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "0CA88E23C485E63FB3BB9610D40E8264")

    private Collection<V> values;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.247 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.247 -0400", hash_original_field = "DFEF811547BBC141513674AE42682230", hash_generated_field = "316FD2AB259DA26036E31C0D78278AE7")

    private int arrSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.247 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "444771311A9B09F69D7C8D75C59C2BBB")

    private int modCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.247 -0400", hash_original_field = "47C80780AB608CC046F2A6E6F071FEB6", hash_generated_field = "8E4CC84ABB20D75F51E93933E0A59066")

    private Entry<E, K, V>[] arr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.247 -0400", hash_original_field = "97C293EF8ABD832D29E88C21D8E562F5", hash_generated_field = "4BC2677DD136E3CB5AE0C48B0EDF5A53")

    private float loadFactor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.247 -0400", hash_original_field = "70D6CECF8D97F10969A69F5BF3BDD295", hash_generated_field = "F9A5F8AF6E8A641C6C49EB5204F6EF63")

    int threshold = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.247 -0400", hash_original_method = "294B6DEE36941009B0B201B0BEC2DD67", hash_generated_method = "E45D157C82C9A0D27E45C7E8FDC413D5")
    public  TwoKeyHashMap() {
        this(DEFAULT_INITIAL_SIZE, DEFAULT_LOAD_FACTOR);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.259 -0400", hash_original_method = "E595C77056089A502D8DE33B445FC550", hash_generated_method = "8A450F5AB8941E4B262790914C952160")
    public  TwoKeyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
        addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.264 -0400", hash_original_method = "679241DAB133FCD723055BFD98A1C12B", hash_generated_method = "4112C1F81ABACAED775A32CE7FB494FF")
    @SuppressWarnings("unchecked")
    public  TwoKeyHashMap(int initialCapacity, float initialLoadFactor) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("initialCapacity should be >= 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "initialLoadFactor should be > 0");
        } //End block
        loadFactor = initialLoadFactor;
        arrSize = initialCapacity > 0 ? initialCapacity : 1;
        threshold = (int) (arrSize * loadFactor);
        arr = new Entry[arrSize + 1];
        // ---------- Original Method ----------
        //if (initialCapacity < 0) {
            //throw new IllegalArgumentException("initialCapacity should be >= 0");
        //}
        //if (initialLoadFactor <= 0) {
            //throw new IllegalArgumentException(
                    //"initialLoadFactor should be > 0");
        //}
        //loadFactor = initialLoadFactor;
        //if (initialCapacity == Integer.MAX_VALUE) {
            //initialCapacity--;
        //}
        //arrSize = initialCapacity > 0 ? initialCapacity : 1;
        //threshold = (int) (arrSize * loadFactor);
        //arr = new Entry[arrSize + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.265 -0400", hash_original_method = "66B88A01F8296942609EF87ACA0E012C", hash_generated_method = "7F4739F51E429B00FDD71A2566F1808C")
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_585580967 = null; //Variable for return #1
        {
            values = new ValuesCollectionImpl();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_585580967 = values;
        varB4EAC82CA7396A68D541C85D26508E83_585580967.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_585580967;
        // ---------- Original Method ----------
        //if (values == null) {
            //values = new ValuesCollectionImpl();
        //}
        //return values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.265 -0400", hash_original_method = "56D76EA36DEC4CA5689518DF65F0FB11", hash_generated_method = "EF20F2973AD854F5468EFB664C3AAC1F")
    public Set<Map.Entry<String, V>> entrySet() {
        Set<Map.Entry<String, V>> varB4EAC82CA7396A68D541C85D26508E83_2100288649 = null; //Variable for return #1
        {
            entrySet = new EntrySetImpl();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2100288649 = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_2100288649.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2100288649;
        // ---------- Original Method ----------
        //if (entrySet == null) {
            //entrySet = new EntrySetImpl();
        //}
        //return entrySet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.266 -0400", hash_original_method = "818EB47C54D790B2A626C59717AA13C9", hash_generated_method = "24DDA753AE3FC4B7DC0DE284B1597AB7")
    public void clear() {
        size = 0;
        Arrays.fill(arr, 0, arr.length, null);
        // ---------- Original Method ----------
        //modCount++;
        //size = 0;
        //Arrays.fill(arr, 0, arr.length, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.266 -0400", hash_original_method = "FFF3CF52B9B0B5141C3665D271E08CFC", hash_generated_method = "41A12E5346F0A564EE5DD8A50E188F97")
    public V remove(Object key1, Object key2) {
        V varB4EAC82CA7396A68D541C85D26508E83_1156253870 = null; //Variable for return #1
        Entry<E, K, V> e;
        e = removeEntry(key1, key2);
        varB4EAC82CA7396A68D541C85D26508E83_1156253870 = (e != null) ? e.value : null;
        addTaint(key1.getTaint());
        addTaint(key2.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1156253870.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1156253870;
        // ---------- Original Method ----------
        //Entry<E, K, V> e = removeEntry(key1, key2);
        //return (e != null) ? e.value : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.301 -0400", hash_original_method = "8D27DE23631F09453D73093F15998EF0", hash_generated_method = "53B64BF095C071C29EE1394E14FB1DBE")
    public V put(E key1, K key2, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_658617640 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_91390787 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_2005027733 = null; //Variable for return #3
        V varB4EAC82CA7396A68D541C85D26508E83_934620741 = null; //Variable for return #4
        {
            int index;
            index = arrSize;
            {
                arr[index] = createEntry(0, null, null, value, null);
                varB4EAC82CA7396A68D541C85D26508E83_658617640 = null;
            } //End block
            {
                V oldValue;
                oldValue = arr[index].value;
                arr[index].value = value;
                varB4EAC82CA7396A68D541C85D26508E83_91390787 = oldValue;
            } //End block
        } //End block
        int hash;
        hash = key1.hashCode() + key2.hashCode();
        int index;
        index = (hash & 0x7fffffff) % arrSize;
        Entry<E, K, V> e;
        e = arr[index];
        {
            {
                boolean var3CC53A54E9E56C8592159E167D247BC8_363645072 = (hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2()));
                {
                    V oldValue;
                    oldValue = e.value;
                    e.value = value;
                    varB4EAC82CA7396A68D541C85D26508E83_2005027733 = oldValue;
                } //End block
            } //End collapsed parenthetic
            e = e.next;
        } //End block
        arr[index] = createEntry(hash, key1, key2, value, arr[index]);
        {
            rehash();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_934620741 = null;
        V varA7E53CE21691AB073D9660D615818899_1983352471; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1983352471 = varB4EAC82CA7396A68D541C85D26508E83_658617640;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1983352471 = varB4EAC82CA7396A68D541C85D26508E83_91390787;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1983352471 = varB4EAC82CA7396A68D541C85D26508E83_2005027733;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1983352471 = varB4EAC82CA7396A68D541C85D26508E83_934620741;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1983352471.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1983352471;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.302 -0400", hash_original_method = "4E92EE4014ABA801EB273C60A5958799", hash_generated_method = "1C64948B01E521F7245D93B45FE4435D")
    @SuppressWarnings("unchecked")
     void rehash() {
        int newArrSize;
        newArrSize = (arrSize + 1) * 2 + 1;
        {
            newArrSize = Integer.MAX_VALUE - 1;
        } //End block
        Entry<E, K, V>[] newArr;
        newArr = new Entry[newArrSize + 1];
        {
            int i;
            i = 0;
            {
                Entry<E, K, V> entry;
                entry = arr[i];
                {
                    Entry<E, K, V> next;
                    next = entry.next;
                    int newIndex;
                    newIndex = (entry.hash & 0x7fffffff) % newArrSize;
                    entry.next = newArr[newIndex];
                    newArr[newIndex] = entry;
                    entry = next;
                } //End block
            } //End block
        } //End collapsed parenthetic
        newArr[newArrSize] = arr[arrSize];
        arrSize = newArrSize;
        {
            loadFactor *= 10;
        } //End block
        threshold = (int) (arrSize * loadFactor);
        arr = newArr;
        // ---------- Original Method ----------
        //int newArrSize = (arrSize + 1) * 2 + 1;
        //if (newArrSize < 0) {
            //newArrSize = Integer.MAX_VALUE - 1;
        //}
        //Entry<E, K, V>[] newArr = new Entry[newArrSize + 1];
        //for (int i = 0; i < arr.length - 1; i++) {
            //Entry<E, K, V> entry = arr[i];
            //while (entry != null) {
                //Entry<E, K, V> next = entry.next;
                //int newIndex = (entry.hash & 0x7fffffff) % newArrSize;
                //entry.next = newArr[newIndex];
                //newArr[newIndex] = entry;
                //entry = next;
            //}
        //}
        //newArr[newArrSize] = arr[arrSize];
        //arrSize = newArrSize;
        //if (arrSize == Integer.MAX_VALUE) {
            //loadFactor *= 10;
        //}
        //threshold = (int) (arrSize * loadFactor);
        //arr = newArr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.303 -0400", hash_original_method = "31FF250303275620FA0192DC25A0041E", hash_generated_method = "B06DC8885279D0608FB8BB79C181B738")
    public boolean containsKey(Object key1, Object key2) {
        boolean varE6D9CD9BC0FD3434DD2196F79DFDAC11_147658895 = (findEntry(key1, key2) != null);
        addTaint(key1.getTaint());
        addTaint(key2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2066131220 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2066131220;
        // ---------- Original Method ----------
        //return findEntry(key1, key2) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.316 -0400", hash_original_method = "E13BBD09CFB92FF506FEC56FABF87B9F", hash_generated_method = "F7755B45E76350075521EFB6FEA78666")
    public V get(Object key1, Object key2) {
        V varB4EAC82CA7396A68D541C85D26508E83_447883446 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_2045879422 = null; //Variable for return #2
        Entry<E, K, V> e;
        e = findEntry(key1, key2);
        {
            varB4EAC82CA7396A68D541C85D26508E83_447883446 = e.value;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2045879422 = null;
        addTaint(key1.getTaint());
        addTaint(key2.getTaint());
        V varA7E53CE21691AB073D9660D615818899_366324457; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_366324457 = varB4EAC82CA7396A68D541C85D26508E83_447883446;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_366324457 = varB4EAC82CA7396A68D541C85D26508E83_2045879422;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_366324457.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_366324457;
        // ---------- Original Method ----------
        //Entry<E, K, V> e = findEntry(key1, key2);
        //if (e != null) {
            //return e.value;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.316 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "6F509DBE6743C1EF7272BEC549357EBB")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1191207525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1191207525;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.326 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "8047E2A54D336D24CC3891BFAB50E6FB")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436045393 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436045393;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.326 -0400", hash_original_method = "B126004260D8EBAD1640E464F002A4A4", hash_generated_method = "3DF21834DABBEC09CF21298F8248AF1C")
     Entry<E, K, V> createEntry(int hashCode, E key1, K key2, V value,
            Entry<E, K, V> next) {
        Entry<E, K, V> varB4EAC82CA7396A68D541C85D26508E83_1271266165 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1271266165 = new Entry<E, K, V>(hashCode, key1, key2, value, next);
        addTaint(hashCode);
        addTaint(key1.getTaint());
        addTaint(key2.getTaint());
        addTaint(value.getTaint());
        addTaint(next.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1271266165.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1271266165;
        // ---------- Original Method ----------
        //return new Entry<E, K, V>(hashCode, key1, key2, value, next);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.327 -0400", hash_original_method = "F4E18AFB5A6BD2866D211174F2C65244", hash_generated_method = "9A23AD355D191053C7BB77D7A1DC8FD4")
     Iterator<Map.Entry<String, V>> createEntrySetIterator() {
        Iterator<Map.Entry<String, V>> varB4EAC82CA7396A68D541C85D26508E83_1871919307 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1871919307 = new EntryIteratorImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1871919307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1871919307;
        // ---------- Original Method ----------
        //return new EntryIteratorImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.328 -0400", hash_original_method = "6209E5C519243BC33CB9A47AFA9E017F", hash_generated_method = "D95062A4B7DEE1CCDC9CD5206AF4647F")
     Iterator<V> createValueCollectionIterator() {
        Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_413951138 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_413951138 = new ValueIteratorImpl();
        varB4EAC82CA7396A68D541C85D26508E83_413951138.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_413951138;
        // ---------- Original Method ----------
        //return new ValueIteratorImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.334 -0400", hash_original_method = "C152D61E326241B091FB8EBCBC5C9180", hash_generated_method = "7410C47365D5C38CB17985A24F6070DD")
    private final Entry<E, K, V> findEntry(Object key1, Object key2) {
        Entry<E, K, V> varB4EAC82CA7396A68D541C85D26508E83_1052736861 = null; //Variable for return #1
        Entry<E, K, V> varB4EAC82CA7396A68D541C85D26508E83_466020695 = null; //Variable for return #2
        Entry<E, K, V> varB4EAC82CA7396A68D541C85D26508E83_121383524 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1052736861 = arr[arrSize];
        } //End block
        int hash;
        hash = key1.hashCode() + key2.hashCode();
        int index;
        index = (hash & 0x7fffffff) % arrSize;
        Entry<E, K, V> e;
        e = arr[index];
        {
            {
                boolean var3CC53A54E9E56C8592159E167D247BC8_1271163021 = (hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2()));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_466020695 = e;
                } //End block
            } //End collapsed parenthetic
            e = e.next;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_121383524 = null;
        addTaint(key1.getTaint());
        addTaint(key2.getTaint());
        Entry<E, K, V> varA7E53CE21691AB073D9660D615818899_1114321284; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1114321284 = varB4EAC82CA7396A68D541C85D26508E83_1052736861;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1114321284 = varB4EAC82CA7396A68D541C85D26508E83_466020695;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1114321284 = varB4EAC82CA7396A68D541C85D26508E83_121383524;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1114321284.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1114321284;
        // ---------- Original Method ----------
        //if (key1 == null && key2 == null) {
            //return arr[arrSize];
        //}
        //int hash = key1.hashCode() + key2.hashCode();
        //int index = (hash & 0x7fffffff) % arrSize;
        //Entry<E, K, V> e = arr[index];
        //while (e != null) {
            //if (hash == e.hash && key1.equals(e.getKey1())
                    //&& key2.equals(e.getKey2())) {
                //return e;
            //}
            //e = e.next;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.349 -0400", hash_original_method = "C98DB123D4E5CC84B2492FBCF56B145D", hash_generated_method = "5090338947508F043A114FD2755128AE")
    private final Entry<E, K, V> removeEntry(Object key1, Object key2) {
        Entry<E, K, V> varB4EAC82CA7396A68D541C85D26508E83_1831392749 = null; //Variable for return #1
        Entry<E, K, V> varB4EAC82CA7396A68D541C85D26508E83_1277470666 = null; //Variable for return #2
        Entry<E, K, V> varB4EAC82CA7396A68D541C85D26508E83_227216859 = null; //Variable for return #3
        Entry<E, K, V> varB4EAC82CA7396A68D541C85D26508E83_1232235711 = null; //Variable for return #4
        {
            int index;
            index = arrSize;
            {
                Entry<E, K, V> ret;
                ret = arr[index];
                arr[index] = null;
                varB4EAC82CA7396A68D541C85D26508E83_1831392749 = ret;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1277470666 = null;
        } //End block
        int hash;
        hash = key1.hashCode() + key2.hashCode();
        int index;
        index = (hash & 0x7fffffff) % arrSize;
        Entry<E, K, V> e;
        e = arr[index];
        Entry<E, K, V> prev;
        prev = e;
        {
            {
                boolean var3CC53A54E9E56C8592159E167D247BC8_1142367395 = (hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2()));
                {
                    {
                        arr[index] = e.next;
                    } //End block
                    {
                        prev.next = e.next;
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_227216859 = e;
                } //End block
            } //End collapsed parenthetic
            prev = e;
            e = e.next;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1232235711 = null;
        addTaint(key1.getTaint());
        addTaint(key2.getTaint());
        Entry<E, K, V> varA7E53CE21691AB073D9660D615818899_271269768; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_271269768 = varB4EAC82CA7396A68D541C85D26508E83_1831392749;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_271269768 = varB4EAC82CA7396A68D541C85D26508E83_1277470666;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_271269768 = varB4EAC82CA7396A68D541C85D26508E83_227216859;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_271269768 = varB4EAC82CA7396A68D541C85D26508E83_1232235711;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_271269768.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_271269768;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class Entry<E, K, V> implements Map.Entry<String, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.349 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.349 -0400", hash_original_field = "C2ADD694BF942DC77B376592D9C862CD", hash_generated_field = "FF2F76F560606089FC32D051F70C3BCF")

        E key1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.350 -0400", hash_original_field = "78F825AAA0103319AAA1A30BF4FE3ADA", hash_generated_field = "DE7247D222A6A88790AAD9007484F2CE")

        K key2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.350 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.350 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "041FC26789DCA96E16327DF3859848D1")

        Entry<E, K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.350 -0400", hash_original_method = "3E3A99A3B7891AEE573C3F0F98EEE3AE", hash_generated_method = "6DEBEC5295235A0ED788B9F66F6D400D")
        public  Entry(int hash, E key1, K key2, V value, Entry<E, K, V> next) {
            this.hash = hash;
            this.key1 = key1;
            this.key2 = key2;
            this.value = value;
            this.next = next;
            // ---------- Original Method ----------
            //this.hash = hash;
            //this.key1 = key1;
            //this.key2 = key2;
            //this.value = value;
            //this.next = next;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.351 -0400", hash_original_method = "43A91F8C54B90BC0F4C951BCB1425B25", hash_generated_method = "51C7BC7C4A1FDB319F51503C88A254F6")
        public String getKey() {
            String varB4EAC82CA7396A68D541C85D26508E83_673050418 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_673050418 = key1.toString() + key2.toString();
            varB4EAC82CA7396A68D541C85D26508E83_673050418.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_673050418;
            // ---------- Original Method ----------
            //return key1.toString() + key2.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.351 -0400", hash_original_method = "8E21854AE9ADC89A1868BC4522219FB2", hash_generated_method = "EDE6C921AF008C9EF089AE7D642245FF")
        public E getKey1() {
            E varB4EAC82CA7396A68D541C85D26508E83_1022406297 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1022406297 = key1;
            varB4EAC82CA7396A68D541C85D26508E83_1022406297.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1022406297;
            // ---------- Original Method ----------
            //return key1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.352 -0400", hash_original_method = "7F02D1AD568FC6C2F60475D661F743CB", hash_generated_method = "03BCCC4BB3504810A775B3153C1B6433")
        public K getKey2() {
            K varB4EAC82CA7396A68D541C85D26508E83_1774870235 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1774870235 = key2;
            varB4EAC82CA7396A68D541C85D26508E83_1774870235.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1774870235;
            // ---------- Original Method ----------
            //return key2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.352 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "FE895400B0D7990B444248E5002966A6")
        public V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_490172537 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_490172537 = value;
            varB4EAC82CA7396A68D541C85D26508E83_490172537.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_490172537;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.363 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "72536DA65BFA639ED600038D52C1B781")
        public V setValue(V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_1729320113 = null; //Variable for return #1
            V oldValue;
            oldValue = this.value;
            this.value = value;
            varB4EAC82CA7396A68D541C85D26508E83_1729320113 = oldValue;
            varB4EAC82CA7396A68D541C85D26508E83_1729320113.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1729320113;
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.363 -0400", hash_original_method = "2C745FE5DF9CE9CA09289DC08E07F848", hash_generated_method = "BEDCB1110167A31EF2884ED735AD7ED7")
        public boolean equals(Object obj) {
            Entry<?, ?, ?> e;
            e = (Entry<?, ?, ?>) obj;
            Object getKey1;
            getKey1 = e.getKey1();
            Object getKey2;
            getKey2 = e.getKey2();
            Object getValue;
            getValue = e.getValue();
            {
                boolean var5AA186129D40D0D053E9DEE36E4B4EF5_1696241436 = ((key1 == null && getKey1 != null)
                    || (key2 == null && getKey2 != null)
                    || (value == null && getValue != null)
                    || !key1.equals(e.getKey1()) || !key2.equals(e.getKey2())
                    || !value.equals(getValue));
            } //End collapsed parenthetic
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1142827772 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1142827772;
            // ---------- Original Method ----------
            //if (!(obj instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?, ?> e = (Entry<?, ?, ?>) obj;
            //Object getKey1 = e.getKey1();
            //Object getKey2 = e.getKey2();
            //Object getValue = e.getValue();
            //if ((key1 == null && getKey1 != null)
                    //|| (key2 == null && getKey2 != null)
                    //|| (value == null && getValue != null)
                    //|| !key1.equals(e.getKey1()) || !key2.equals(e.getKey2())
                    //|| !value.equals(getValue)) {
                //return false;
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.389 -0400", hash_original_method = "57C89921FB9688640B9C568340F7B69C", hash_generated_method = "B266BEAB5AB72CEAA1280E8D78864E51")
        public int hashCode() {
            int hash1;
            hash1 = (key1 == null ? 0 : key1.hashCode());//DSFIXME:  CODE0008: Nested ternary operator in expression
            int hash2;
            hash2 = (key2 == null ? 0 : key2.hashCode());//DSFIXME:  CODE0008: Nested ternary operator in expression
            int varA174CA9A4343C7CD5810592D3B17DB9F_376155127 = ((hash1 + hash2) ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318842920 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318842920;
            // ---------- Original Method ----------
            //int hash1 = (key1 == null ? 0 : key1.hashCode());
            //int hash2 = (key2 == null ? 0 : key2.hashCode());
            //return (hash1 + hash2) ^ (value == null ? 0 : value.hashCode());
        }

        
    }


    
    class EntrySetImpl extends AbstractSet<Map.Entry<String, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.389 -0400", hash_original_method = "403B9BE439CBD0FBC0501C0EDC2D9426", hash_generated_method = "403B9BE439CBD0FBC0501C0EDC2D9426")
        public EntrySetImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.390 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "2E1617BC342DC7840AED06EFBF3BC39F")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436968665 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436968665;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.390 -0400", hash_original_method = "AE463F3857FBE52FC47F5CD4A94D1EE6", hash_generated_method = "CB1BBFA30FC78A80159E3DCADA51A3C9")
        public void clear() {
            TwoKeyHashMap.this.clear();
            // ---------- Original Method ----------
            //TwoKeyHashMap.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.390 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "45F47C84970EF6FA0198A5BC9AC2C4D7")
        public boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1899065887 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1899065887;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.391 -0400", hash_original_method = "0351D580B43E9823D3890B3F7A27BB60", hash_generated_method = "51CE221E113FA8FB23DDE60864161A54")
        public boolean contains(Object obj) {
            Entry<?, ?, ?> entry;
            entry = (Entry<?, ?, ?>) obj;
            Entry<E, K, V> entry2;
            entry2 = findEntry(entry.getKey1(), entry.getKey2());
            Object value;
            value = entry.getValue();
            Object value2;
            value2 = entry2.getValue();
            {
                Object var8FE214ACB260EF10FD8536B4BD04FDDC_887784256 = (value.equals(value2));
            } //End flattened ternary
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_600938085 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_600938085;
            // ---------- Original Method ----------
            //if (!(obj instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?, ?> entry = (Entry<?, ?, ?>) obj;
            //Entry<E, K, V> entry2 = findEntry(entry.getKey1(), entry.getKey2());
            //if (entry2 == null) {
                //return false;
            //}
            //Object value = entry.getValue();
            //Object value2 = entry2.getValue();
            //return value == null ? value2 == null : value.equals(value2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.392 -0400", hash_original_method = "30A2FA02E1530F63F4EB8959C457654B", hash_generated_method = "D21F89F87E75C3C1F52D1ADE42F7F14E")
        public boolean remove(Object obj) {
            boolean var51FCFB63B23B042D188F5889FADEE83D_1623852963 = (removeEntry(((Entry) obj).getKey1(), ((Entry) obj).getKey2()) != null);
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_322764439 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_322764439;
            // ---------- Original Method ----------
            //if (!(obj instanceof Entry)) {
                //return false;
            //}
            //return removeEntry(((Entry) obj).getKey1(), ((Entry) obj).getKey2()) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.392 -0400", hash_original_method = "820C2D57E851A82BD3B2742370FA728A", hash_generated_method = "576438100638275F6CCD0F25DC691C87")
        public Iterator<Map.Entry<String, V>> iterator() {
            Iterator<Map.Entry<String, V>> varB4EAC82CA7396A68D541C85D26508E83_1462645862 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1462645862 = createEntrySetIterator();
            varB4EAC82CA7396A68D541C85D26508E83_1462645862.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1462645862;
            // ---------- Original Method ----------
            //return createEntrySetIterator();
        }

        
    }


    
    class EntryIteratorImpl implements Iterator<Map.Entry<String, V>> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.392 -0400", hash_original_field = "80E557AEBBB542A89F16261A24CEC107", hash_generated_field = "B4C5A8998384DD2BFFBA01B52B5A43F1")

        private int startModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.393 -0400", hash_original_field = "6CFE61694EE1BB13AE719D47C2F80B7A", hash_generated_field = "A24795FFAF6F71C43D54678ACBE48727")

        private boolean found;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.393 -0400", hash_original_field = "D8BFB05268C3F10F56D2E317116E092F", hash_generated_field = "5246D1500CC51F8F9763D7817E7866E1")

        private int curr = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.393 -0400", hash_original_field = "8C1AFCF80C11DFC9B00A5AA1A18FF85B", hash_generated_field = "9B36237E7FADCCC12E7D5892AF7FF998")

        private int returned_index = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.393 -0400", hash_original_field = "4D68C10F64A8B575EA358BB9796F7290", hash_generated_field = "EAAB6E203DE27FDA0DA70E7B83C4808C")

        private Entry<E, K, V> curr_entry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.393 -0400", hash_original_field = "65384B1BED378C7A7453F2DA54B739A6", hash_generated_field = "FCA5E17EE5CF26E634230F4C2907BA4F")

        private Entry<E, K, V> returned_entry;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.393 -0400", hash_original_method = "E708A38A6B1072C269DF2FC2A57F4EEE", hash_generated_method = "795363C7EF8F0A7D3A2E876BD06BA763")
          EntryIteratorImpl() {
            startModCount = modCount;
            // ---------- Original Method ----------
            //startModCount = modCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.394 -0400", hash_original_method = "2E6F84DE8CBAE5EA419B2332CF98801C", hash_generated_method = "2C49D0AF25DD9C62406485871AC73B3C")
        public boolean hasNext() {
            {
                curr_entry = curr_entry.next;
            } //End block
            {
                {
                    curr_entry = arr[curr];
                } //End block
            } //End block
            boolean varADD6E08E9486A747E6272FE6A1AEAF8B_1372451201 = (found = (curr_entry != null));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2022340567 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2022340567;
            // ---------- Original Method ----------
            //if (found) {
                //return true;
            //}
            //if (curr_entry != null) {
                //curr_entry = curr_entry.next;
            //}
            //if (curr_entry == null) {
                //for (curr++; curr < arr.length && arr[curr] == null; curr++) {
                //}
                //if (curr < arr.length) {
                    //curr_entry = arr[curr];
                //}
            //}
            //return found = (curr_entry != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.395 -0400", hash_original_method = "4A9B66986403EF804F6712808B1107B5", hash_generated_method = "57E3C05288FC65928807D08F5807930B")
        public Map.Entry<String, V> next() {
            Map.Entry<String, V> varB4EAC82CA7396A68D541C85D26508E83_514330919 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_401937822 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            found = false;
            returned_index = curr;
            returned_entry = curr_entry;
            varB4EAC82CA7396A68D541C85D26508E83_514330919 = (Map.Entry<String, V>) curr_entry;
            varB4EAC82CA7396A68D541C85D26508E83_514330919.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_514330919;
            // ---------- Original Method ----------
            //if (modCount != startModCount) {
                //throw new ConcurrentModificationException();
            //}
            //if (!hasNext()) {
                //throw new NoSuchElementException();
            //}
            //found = false;
            //returned_index = curr;
            //returned_entry = curr_entry;
            //return (Map.Entry<String, V>) curr_entry;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.408 -0400", hash_original_method = "5DECA7771A914CFF4F808726B9F33811", hash_generated_method = "B41075074EB51DC53301EB7000FC0F00")
        public void remove() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            Entry<E, K, V> p;
            p = null;
            Entry<E, K, V> e;
            e = arr[returned_index];
            {
                p = e;
                e = e.next;
            } //End block
            {
                p.next = returned_entry.next;
            } //End block
            {
                arr[returned_index] = returned_entry.next;
            } //End block
            returned_index = -1;
            // ---------- Original Method ----------
            //if (returned_index == -1) {
                //throw new IllegalStateException();
            //}
            //if (modCount != startModCount) {
                //throw new ConcurrentModificationException();
            //}
            //Entry<E, K, V> p = null;
            //Entry<E, K, V> e = arr[returned_index];
            //while (e != returned_entry) {
                //p = e;
                //e = e.next;
            //}
            //if (p != null) {
                //p.next = returned_entry.next;
            //} else {
                //arr[returned_index] = returned_entry.next;
            //}
            //size--;
            //modCount++;
            //startModCount++;
            //returned_index = -1;
        }

        
    }


    
    class ValuesCollectionImpl extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.409 -0400", hash_original_method = "3C90742D57762549FF961ACAAF6110EC", hash_generated_method = "3C90742D57762549FF961ACAAF6110EC")
        public ValuesCollectionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.418 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "01482EA3E7ABB9983EAA28F6D645EE96")
        public int size() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022242563 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022242563;
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.418 -0400", hash_original_method = "AE463F3857FBE52FC47F5CD4A94D1EE6", hash_generated_method = "CB1BBFA30FC78A80159E3DCADA51A3C9")
        public void clear() {
            TwoKeyHashMap.this.clear();
            // ---------- Original Method ----------
            //TwoKeyHashMap.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.418 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "852341682C504660F83072EAB65E22C2")
        public boolean isEmpty() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1878955313 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1878955313;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.419 -0400", hash_original_method = "680FD22D8DB10527F3174FA8865D96E7", hash_generated_method = "F3BD9B437ACEDEFC3966DCD8B706EEEF")
        public Iterator<V> iterator() {
            Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_1099964073 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1099964073 = createValueCollectionIterator();
            varB4EAC82CA7396A68D541C85D26508E83_1099964073.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1099964073;
            // ---------- Original Method ----------
            //return createValueCollectionIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.423 -0400", hash_original_method = "74702C44933E62600B2ED3E7307D82B0", hash_generated_method = "417CB09B702300DA562AA9D3458005B2")
        public boolean contains(Object obj) {
            boolean varE4B410CADF0B35A0E3C54617BD85817F_653641742 = (containsValue(obj));
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1762790524 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1762790524;
            // ---------- Original Method ----------
            //return containsValue(obj);
        }

        
    }


    
    class ValueIteratorImpl implements Iterator<V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.423 -0400", hash_original_field = "62FCE98555002A61A6DA4D29476B0A9F", hash_generated_field = "48025B493C25248658D4DBBDCE3A3E0F")

        private EntryIteratorImpl itr;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.424 -0400", hash_original_method = "5B2B0240442A661D6F35A8FA67A7469B", hash_generated_method = "FAA2EFD99674487E058F0C99576A9B8D")
          ValueIteratorImpl() {
            this.itr = new EntryIteratorImpl();
            // ---------- Original Method ----------
            //this.itr = new EntryIteratorImpl();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.433 -0400", hash_original_method = "351E0C8E290AF7E9E6FFA36B6DF7C9FA", hash_generated_method = "E8FCC9A1C07D4B212392D505201FB4D3")
        public V next() {
            V varB4EAC82CA7396A68D541C85D26508E83_2140639349 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2140639349 = itr.next().getValue();
            varB4EAC82CA7396A68D541C85D26508E83_2140639349.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2140639349;
            // ---------- Original Method ----------
            //return itr.next().getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.433 -0400", hash_original_method = "C9ED4E1E548B82ACF6AA423D5E0C3E8C", hash_generated_method = "F1B26A301CD95E7A3CF3E96C8421A61D")
        public void remove() {
            itr.remove();
            // ---------- Original Method ----------
            //itr.remove();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.444 -0400", hash_original_method = "0093C9D638C4ECB39AFF8230D36DFCB0", hash_generated_method = "57D4B4E0ABBE14D180A4F975CE33C81E")
        public boolean hasNext() {
            boolean varF664500D47A97D2A15781D0CF424E05F_60441405 = (itr.hasNext());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1404344439 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1404344439;
            // ---------- Original Method ----------
            //return itr.hasNext();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.444 -0400", hash_original_field = "DF48F8D92FC36ACC8968654109C53FC4", hash_generated_field = "5E50DAC6309EF9A0289BCDB49DC3C430")

    static float DEFAULT_LOAD_FACTOR = 0.75f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.444 -0400", hash_original_field = "DA4109A0CC3182799ED4F6C2DDA24CF9", hash_generated_field = "14F0F2A8138A3BF0F93E2BE360204B7A")

    static int DEFAULT_INITIAL_SIZE = 16;
}


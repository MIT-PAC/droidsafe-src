package org.apache.harmony.luni.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.775 -0500", hash_original_field = "C1C76A87F655C174D217EA23B00CC6D8", hash_generated_field = "A8CC9CBDCFEE884AAACD2650D6276B04")

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.777 -0500", hash_original_field = "638C82ACF5EA5C74337F2A945B4E5C3F", hash_generated_field = "EA69D1A7FA6057000A0CB80BAF0F0ADB")

    static final int DEFAULT_INITIAL_SIZE = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.779 -0500", hash_original_field = "14557A47C47F1A76966820D4FF4DD06C", hash_generated_field = "922E9E523E3B4B4E0BBECCC2419D9A8A")

    private Set<Map.Entry<String, V>> entrySet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.782 -0500", hash_original_field = "66FC55BC3FE3DFC76C7BE5EAF459710C", hash_generated_field = "0CA88E23C485E63FB3BB9610D40E8264")

    private Collection<V> values;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.784 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.787 -0500", hash_original_field = "642C54AB72C376C6A8B90F3FFBFB9691", hash_generated_field = "316FD2AB259DA26036E31C0D78278AE7")

    private int arrSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.789 -0500", hash_original_field = "52F3DED7388D6DA42BC9C902075440B5", hash_generated_field = "444771311A9B09F69D7C8D75C59C2BBB")

    private int modCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.791 -0500", hash_original_field = "A005EC563646E47434E5E2706D942C82", hash_generated_field = "8E4CC84ABB20D75F51E93933E0A59066")

    private Entry<E, K, V>[] arr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.793 -0500", hash_original_field = "9AE85CE37BA4DE356F76E49D73EDA32D", hash_generated_field = "4BC2677DD136E3CB5AE0C48B0EDF5A53")

    private float loadFactor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.795 -0500", hash_original_field = "F9A5F8AF6E8A641C6C49EB5204F6EF63", hash_generated_field = "F9A5F8AF6E8A641C6C49EB5204F6EF63")

    int threshold = 0;

    /**
     * Constructs an empty HashMap
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.798 -0500", hash_original_method = "294B6DEE36941009B0B201B0BEC2DD67", hash_generated_method = "7C91D3CE551988D4DFA74FC99CD84DC2")
    
public TwoKeyHashMap() {
        this(DEFAULT_INITIAL_SIZE, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructs an empty HashMap
     *
     * @param initialCapacity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.800 -0500", hash_original_method = "E595C77056089A502D8DE33B445FC550", hash_generated_method = "529A9908C01F268B9A9646FFCB7DFD78")
    
public TwoKeyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructs an empty HashMap
     *
     * @param initialCapacity
     * @param initialLoadFactor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.803 -0500", hash_original_method = "679241DAB133FCD723055BFD98A1C12B", hash_generated_method = "62F002EF6010FDC01460CF50CCA393FF")
    
@SuppressWarnings("unchecked")
    public TwoKeyHashMap(int initialCapacity, float initialLoadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initialCapacity should be >= 0");
        }
        if (initialLoadFactor <= 0) {
            throw new IllegalArgumentException(
                    "initialLoadFactor should be > 0");
        }
        loadFactor = initialLoadFactor;
        if (initialCapacity == Integer.MAX_VALUE) {
            initialCapacity--;
        }
        arrSize = initialCapacity > 0 ? initialCapacity : 1;
        threshold = (int) (arrSize * loadFactor);
        arr = new Entry[arrSize + 1];
    }

    /**
     * Returns a collection view of the values
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.806 -0500", hash_original_method = "66B88A01F8296942609EF87ACA0E012C", hash_generated_method = "EF54B80F0E76445F1731B727231203AB")
    
public Collection<V> values() {
        if (values == null) {
            values = new ValuesCollectionImpl();
        }
        return values;
    }

    /**
     * Returns a collection view of the mappings
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.808 -0500", hash_original_method = "56D76EA36DEC4CA5689518DF65F0FB11", hash_generated_method = "E04A3B0C734A09D8E9927923EE922597")
    
public Set<Map.Entry<String, V>> entrySet() {
        if (entrySet == null) {
            entrySet = new EntrySetImpl();
        }
        return entrySet;
    }

    /**
     * Clears the map
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.811 -0500", hash_original_method = "818EB47C54D790B2A626C59717AA13C9", hash_generated_method = "AE2861DAA9D26D16EC73F49007A3C695")
    
public void clear() {
        modCount++;
        size = 0;
        Arrays.fill(arr, 0, arr.length, null);
    }

    /**
     * Removes the mapping for the keys
     *
     * @param key1
     * @param key2
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.813 -0500", hash_original_method = "FFF3CF52B9B0B5141C3665D271E08CFC", hash_generated_method = "8B1A2D0030F1493711F7EA1AC0C82AC8")
    
public V remove(Object key1, Object key2) {
        Entry<E, K, V> e = removeEntry(key1, key2);
        return (e != null) ? e.value : null;
    }

    /**
     * Associates the specified value with the specified keys in this map
     *
     * @param key1
     * @param key2
     * @param value
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.816 -0500", hash_original_method = "8D27DE23631F09453D73093F15998EF0", hash_generated_method = "AB0EDA48FE6E3353CB887BAB0BB48AEE")
    
public V put(E key1, K key2, V value) {
        if (key1 == null && key2 == null) {
            int index = arrSize;
            if (arr[index] == null) {
                arr[index] = createEntry(0, null, null, value, null);
                size++;
                modCount++;
                return null;
            } else {
                V oldValue = arr[index].value;
                arr[index].value = value;
                return oldValue;
            }
        }

        int hash = key1.hashCode() + key2.hashCode();
        int index = (hash & 0x7fffffff) % arrSize;
        Entry<E, K, V> e = arr[index];

        while (e != null) {
            if (hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2())) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
            e = e.next;
        }

        arr[index] = createEntry(hash, key1, key2, value, arr[index]);
        size++;
        modCount++;

        if (size > threshold) {
            rehash();
        }
        return null;
    }

    /**
     * Rehash the map
     *
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.818 -0500", hash_original_method = "4E92EE4014ABA801EB273C60A5958799", hash_generated_method = "CC78676D47114D00E5B39F22B9B4DA60")
    
@SuppressWarnings("unchecked")
    void rehash() {
        int newArrSize = (arrSize + 1) * 2 + 1;
        if (newArrSize < 0) {
            newArrSize = Integer.MAX_VALUE - 1;
        }
        Entry<E, K, V>[] newArr = new Entry[newArrSize + 1];

        for (int i = 0; i < arr.length - 1; i++) {
            Entry<E, K, V> entry = arr[i];
            while (entry != null) {
                Entry<E, K, V> next = entry.next;

                int newIndex = (entry.hash & 0x7fffffff) % newArrSize;
                entry.next = newArr[newIndex];
                newArr[newIndex] = entry;

                entry = next;
            }
        }
        newArr[newArrSize] = arr[arrSize]; // move null entry
        arrSize = newArrSize;

        // The maximum array size is reached, increased loadFactor
        // will keep array from further growing
        if (arrSize == Integer.MAX_VALUE) {
            loadFactor *= 10;
        }
        threshold = (int) (arrSize * loadFactor);
        arr = newArr;
    }

    /**
     * Returns true if this map contains a mapping for {@code key1} and {@code key2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.820 -0500", hash_original_method = "31FF250303275620FA0192DC25A0041E", hash_generated_method = "4755B1B7E892E99CD20C509FB882A644")
    
public boolean containsKey(Object key1, Object key2) {
        return findEntry(key1, key2) != null;
    }

    /**
     * Return the value by keys
     *
     * @param key1
     * @param key2
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.822 -0500", hash_original_method = "E13BBD09CFB92FF506FEC56FABF87B9F", hash_generated_method = "D3A70E7842E180A5EA1778FB42464AE6")
    
public V get(Object key1, Object key2) {
        Entry<E, K, V> e = findEntry(key1, key2);
        if (e != null) {
            return e.value;
        }
        return null;
    }

    /**
     * Returns true if this map contains no key-value mappings
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.825 -0500", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "BCEA08F5849F536168BFB81023CBA1DB")
    
public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of mappings
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.827 -0500", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "409DC5F4E827A6799350876AEA63C2E8")
    
public int size() {
        return size;
    }

    /**
     * Creates new entry
     *
     * @param hashCode
     * @param key1
     * @param key2
     * @param value
     * @param next
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.830 -0500", hash_original_method = "B126004260D8EBAD1640E464F002A4A4", hash_generated_method = "B126004260D8EBAD1640E464F002A4A4")
    
Entry<E, K, V> createEntry(int hashCode, E key1, K key2, V value,
            Entry<E, K, V> next) {
        return new Entry<E, K, V>(hashCode, key1, key2, value, next);
    }

    /**
     * Creates entries iterator
     *
     * @return
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.832 -0500", hash_original_method = "F4E18AFB5A6BD2866D211174F2C65244", hash_generated_method = "F4E18AFB5A6BD2866D211174F2C65244")
    
Iterator<Map.Entry<String, V>> createEntrySetIterator() {
        return new EntryIteratorImpl();
    }

    /**
     * Creates values iterator
     *
     * @return
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.834 -0500", hash_original_method = "6209E5C519243BC33CB9A47AFA9E017F", hash_generated_method = "6209E5C519243BC33CB9A47AFA9E017F")
    
Iterator<V> createValueCollectionIterator() {
        return new ValueIteratorImpl();
    }
    
    public static class Entry<E, K, V> implements Map.Entry<String, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.837 -0500", hash_original_field = "5ED776CD81502BA181156D7F28EBC9C8", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.840 -0500", hash_original_field = "FF2F76F560606089FC32D051F70C3BCF", hash_generated_field = "FF2F76F560606089FC32D051F70C3BCF")

        E key1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.842 -0500", hash_original_field = "DE7247D222A6A88790AAD9007484F2CE", hash_generated_field = "DE7247D222A6A88790AAD9007484F2CE")

        K key2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.844 -0500", hash_original_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.846 -0500", hash_original_field = "041FC26789DCA96E16327DF3859848D1", hash_generated_field = "041FC26789DCA96E16327DF3859848D1")

        Entry<E, K, V> next;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.849 -0500", hash_original_method = "3E3A99A3B7891AEE573C3F0F98EEE3AE", hash_generated_method = "769D5633592B3CFE8C9460AB4DA1CF70")
        
public Entry(int hash, E key1, K key2, V value, Entry<E, K, V> next) {
            this.hash = hash;
            this.key1 = key1;
            this.key2 = key2;
            this.value = value;
            this.next = next;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.851 -0500", hash_original_method = "43A91F8C54B90BC0F4C951BCB1425B25", hash_generated_method = "B93C43ACFFA4DC54889B9B46FBCDB4DD")
        
public String getKey() {
            return key1.toString() + key2.toString();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.853 -0500", hash_original_method = "8E21854AE9ADC89A1868BC4522219FB2", hash_generated_method = "7DA8A8226D383F1FD654F9FEC2B21858")
        
public E getKey1() {
            return key1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.856 -0500", hash_original_method = "7F02D1AD568FC6C2F60475D661F743CB", hash_generated_method = "1AE12F9FD3DF7F998A2AA46C9DF48E2A")
        
public K getKey2() {
            return key2;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.858 -0500", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "95D4F56CA118DD7517C6CA2E4A00FE92")
        
public V getValue() {
            return value;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.860 -0500", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "A52BCF12098803F796B5BC5764802A61")
        
public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.863 -0500", hash_original_method = "2C745FE5DF9CE9CA09289DC08E07F848", hash_generated_method = "44285056DFACE7BE368C5347EFC51F0A")
        
public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }

            Entry<?, ?, ?> e = (Entry<?, ?, ?>) obj;
            Object getKey1 = e.getKey1();
            Object getKey2 = e.getKey2();
            Object getValue = e.getValue();
            if ((key1 == null && getKey1 != null)
                    || (key2 == null && getKey2 != null)
                    || (value == null && getValue != null)
                    || !key1.equals(e.getKey1()) || !key2.equals(e.getKey2())
                    || !value.equals(getValue)) {
                return false;
            }
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.865 -0500", hash_original_method = "57C89921FB9688640B9C568340F7B69C", hash_generated_method = "61711EBEE1B41DE04769CE60B21FE27A")
        
public int hashCode() {
            int hash1 = (key1 == null ? 0 : key1.hashCode());
            int hash2 = (key2 == null ? 0 : key2.hashCode());
            return (hash1 + hash2) ^ (value == null ? 0 : value.hashCode());
        }
        
    }
    
    class EntrySetImpl extends AbstractSet<Map.Entry<String, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.139 -0400", hash_original_method = "403B9BE439CBD0FBC0501C0EDC2D9426", hash_generated_method = "403B9BE439CBD0FBC0501C0EDC2D9426")
        public EntrySetImpl ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.870 -0500", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "409DC5F4E827A6799350876AEA63C2E8")
        
public int size() {
            return size;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.872 -0500", hash_original_method = "AE463F3857FBE52FC47F5CD4A94D1EE6", hash_generated_method = "7938B6218D2887AF4969D66394C015AC")
        
public void clear() {
            TwoKeyHashMap.this.clear();
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.875 -0500", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "BCEA08F5849F536168BFB81023CBA1DB")
        
public boolean isEmpty() {
            return size == 0;
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.877 -0500", hash_original_method = "0351D580B43E9823D3890B3F7A27BB60", hash_generated_method = "6E489F7E0B9E9E4EE7262AFDD77851DE")
        
public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }

            Entry<?, ?, ?> entry = (Entry<?, ?, ?>) obj;
            Entry<E, K, V> entry2 = findEntry(entry.getKey1(), entry.getKey2());
            if (entry2 == null) {
                return false;
            }
            Object value = entry.getValue();
            Object value2 = entry2.getValue();
            return value == null ? value2 == null : value.equals(value2);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.880 -0500", hash_original_method = "30A2FA02E1530F63F4EB8959C457654B", hash_generated_method = "96F2FA26C7AAADEA7DC1964EB77A601B")
        
public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            return removeEntry(((Entry) obj).getKey1(), ((Entry) obj).getKey2()) != null;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.882 -0500", hash_original_method = "820C2D57E851A82BD3B2742370FA728A", hash_generated_method = "2464D232BF1D0BEF33BB3789FF431EC4")
        
public Iterator<Map.Entry<String, V>> iterator() {
            return createEntrySetIterator();
        }
        
    }
    
    class EntryIteratorImpl implements Iterator<Map.Entry<String, V>> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.887 -0500", hash_original_field = "CA1D34833BA909ED4BD5B0D0AE54A828", hash_generated_field = "B4C5A8998384DD2BFFBA01B52B5A43F1")

        private int startModCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.890 -0500", hash_original_field = "73617B2373B8F291004A21278DB567AD", hash_generated_field = "A24795FFAF6F71C43D54678ACBE48727")

        private boolean found;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.892 -0500", hash_original_field = "4C8DB7577B82E0B53589C9D6775C5C47", hash_generated_field = "5246D1500CC51F8F9763D7817E7866E1")

        private int curr = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.895 -0500", hash_original_field = "7CF262102986AA98F52FE89A50F40945", hash_generated_field = "9B36237E7FADCCC12E7D5892AF7FF998")

        private int returned_index = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.897 -0500", hash_original_field = "47D0396C9B15C0CA48B2941766DC534C", hash_generated_field = "EAAB6E203DE27FDA0DA70E7B83C4808C")

        private Entry<E, K, V> curr_entry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.899 -0500", hash_original_field = "4D5F5E6C63E7F9843B4177D176F38747", hash_generated_field = "FCA5E17EE5CF26E634230F4C2907BA4F")

        private Entry<E, K, V> returned_entry;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.902 -0500", hash_original_method = "E708A38A6B1072C269DF2FC2A57F4EEE", hash_generated_method = "E708A38A6B1072C269DF2FC2A57F4EEE")
        
EntryIteratorImpl() {
            startModCount = modCount;
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.904 -0500", hash_original_method = "2E6F84DE8CBAE5EA419B2332CF98801C", hash_generated_method = "0CC1FCF13D008F781C9BF5D95A422158")
        
public boolean hasNext() {
            if (found) {
                return true;
            }
            if (curr_entry != null) {
                curr_entry = curr_entry.next;
            }
            if (curr_entry == null) {
                for (curr++; curr < arr.length && arr[curr] == null; curr++) {
                }

                if (curr < arr.length) {
                    curr_entry = arr[curr];
                }
            }
            return found = (curr_entry != null);
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.907 -0500", hash_original_method = "4A9B66986403EF804F6712808B1107B5", hash_generated_method = "0E58A69C4E1E701113B79DB7D5E66606")
        
public Map.Entry<String, V> next() {
            if (modCount != startModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            found = false;
            returned_index = curr;
            returned_entry = curr_entry;
            return (Map.Entry<String, V>) curr_entry;
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.909 -0500", hash_original_method = "5DECA7771A914CFF4F808726B9F33811", hash_generated_method = "4443562E5F06807B335CB0227363E97C")
        
public void remove() {
            if (returned_index == -1) {
                throw new IllegalStateException();
            }

            if (modCount != startModCount) {
                throw new ConcurrentModificationException();
            }

            Entry<E, K, V> p = null;
            Entry<E, K, V> e = arr[returned_index];
            while (e != returned_entry) {
                p = e;
                e = e.next;
            }
            if (p != null) {
                p.next = returned_entry.next;
            } else {
                arr[returned_index] = returned_entry.next;
            }
            size--;
            modCount++;
            startModCount++;
            returned_index = -1;
        }
        
    }
    
    class ValuesCollectionImpl extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.147 -0400", hash_original_method = "3C90742D57762549FF961ACAAF6110EC", hash_generated_method = "3C90742D57762549FF961ACAAF6110EC")
        public ValuesCollectionImpl ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.920 -0500", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "409DC5F4E827A6799350876AEA63C2E8")
        
public int size() {
            return size;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.922 -0500", hash_original_method = "AE463F3857FBE52FC47F5CD4A94D1EE6", hash_generated_method = "7938B6218D2887AF4969D66394C015AC")
        
public void clear() {
            TwoKeyHashMap.this.clear();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.924 -0500", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "BCEA08F5849F536168BFB81023CBA1DB")
        
public boolean isEmpty() {
            return size == 0;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.927 -0500", hash_original_method = "680FD22D8DB10527F3174FA8865D96E7", hash_generated_method = "B3D50EFFD3CB50CFB2AFADC43DA5F2B9")
        
public Iterator<V> iterator() {
            return createValueCollectionIterator();
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.929 -0500", hash_original_method = "74702C44933E62600B2ED3E7307D82B0", hash_generated_method = "908CCF7A7D5D563E0A6C995531B0C71B")
        
public boolean contains(Object obj) {
            return containsValue(obj);
        }
        
    }
    
    class ValueIteratorImpl implements Iterator<V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.934 -0500", hash_original_field = "2F6782BE81FB2B45679F3A4703FDCDEC", hash_generated_field = "48025B493C25248658D4DBBDCE3A3E0F")

        private EntryIteratorImpl itr;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.936 -0500", hash_original_method = "5B2B0240442A661D6F35A8FA67A7469B", hash_generated_method = "5B2B0240442A661D6F35A8FA67A7469B")
        
ValueIteratorImpl() {
            this.itr = new EntryIteratorImpl();
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.939 -0500", hash_original_method = "351E0C8E290AF7E9E6FFA36B6DF7C9FA", hash_generated_method = "986A334A8E5DD87120168D58A2A8FAE5")
        
public V next() {
            return itr.next().getValue();
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.941 -0500", hash_original_method = "C9ED4E1E548B82ACF6AA423D5E0C3E8C", hash_generated_method = "B84673A0D6E6D51AA11E560A12644D33")
        
public void remove() {
            itr.remove();
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.943 -0500", hash_original_method = "0093C9D638C4ECB39AFF8230D36DFCB0", hash_generated_method = "027499FEB3568215F20E455AF5F768BE")
        
public boolean hasNext() {
            return itr.hasNext();
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.913 -0500", hash_original_method = "C152D61E326241B091FB8EBCBC5C9180", hash_generated_method = "A8CD26CDA6043345B7A1BBE3A58F222F")
    
private final Entry<E, K, V> findEntry(Object key1, Object key2) {
        if (key1 == null && key2 == null) {
            return arr[arrSize];
        }

        int hash = key1.hashCode() + key2.hashCode();
        int index = (hash & 0x7fffffff) % arrSize;
        Entry<E, K, V> e = arr[index];

        while (e != null) {
            if (hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2())) {
                return e;
            }
            e = e.next;
        }
        return null;
    }

    // Removes entry
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.917 -0500", hash_original_method = "C98DB123D4E5CC84B2492FBCF56B145D", hash_generated_method = "AD8FEC590AD2D2E97C42F34FB34DB36B")
    
private final Entry<E, K, V> removeEntry(Object key1, Object key2) {
        if (key1 == null && key2 == null) {
            int index = arrSize;
            if (arr[index] != null) {
                Entry<E, K, V> ret = arr[index];
                arr[index] = null;
                size--;
                modCount++;
                return ret;
            }
            return null;
        }

        int hash = key1.hashCode() + key2.hashCode();
        int index = (hash & 0x7fffffff) % arrSize;

        Entry<E, K, V> e = arr[index];
        Entry<E, K, V> prev = e;
        while (e != null) {
            if (hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2())) {
                if (prev == e) {
                    arr[index] = e.next;
                } else {
                    prev.next = e.next;
                }
                size--;
                modCount++;
                return e;
            }

            prev = e;
            e = e.next;
        }
        return null;
    }
}


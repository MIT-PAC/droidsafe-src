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
    private Set<Map.Entry<String, V>> entrySet;
    private Collection<V> values;
    private int size;
    private int arrSize;
    private int modCount;
    private Entry<E, K, V>[] arr;
    private float loadFactor;
    int threshold = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.892 -0400", hash_original_method = "294B6DEE36941009B0B201B0BEC2DD67", hash_generated_method = "E45D157C82C9A0D27E45C7E8FDC413D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TwoKeyHashMap() {
        this(DEFAULT_INITIAL_SIZE, DEFAULT_LOAD_FACTOR);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.892 -0400", hash_original_method = "E595C77056089A502D8DE33B445FC550", hash_generated_method = "56B2E961DDA39E3F674D0F60C1C8BD4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TwoKeyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
        dsTaint.addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.892 -0400", hash_original_method = "679241DAB133FCD723055BFD98A1C12B", hash_generated_method = "CF6D9F86EC422B03A8FA73B171240F95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public TwoKeyHashMap(int initialCapacity, float initialLoadFactor) {
        dsTaint.addTaint(initialCapacity);
        dsTaint.addTaint(initialLoadFactor);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("initialCapacity should be >= 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "initialLoadFactor should be > 0");
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.893 -0400", hash_original_method = "66B88A01F8296942609EF87ACA0E012C", hash_generated_method = "F5FD6A29EF76DC86C8382E6F59A0D4E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<V> values() {
        {
            values = new ValuesCollectionImpl();
        } //End block
        return (Collection<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (values == null) {
            //values = new ValuesCollectionImpl();
        //}
        //return values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.893 -0400", hash_original_method = "56D76EA36DEC4CA5689518DF65F0FB11", hash_generated_method = "F480DD13DD70A2646D2019FD17F581C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Map.Entry<String, V>> entrySet() {
        {
            entrySet = new EntrySetImpl();
        } //End block
        return (Set<Map.Entry<String, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (entrySet == null) {
            //entrySet = new EntrySetImpl();
        //}
        //return entrySet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.894 -0400", hash_original_method = "818EB47C54D790B2A626C59717AA13C9", hash_generated_method = "24DDA753AE3FC4B7DC0DE284B1597AB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        size = 0;
        Arrays.fill(arr, 0, arr.length, null);
        // ---------- Original Method ----------
        //modCount++;
        //size = 0;
        //Arrays.fill(arr, 0, arr.length, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.895 -0400", hash_original_method = "FFF3CF52B9B0B5141C3665D271E08CFC", hash_generated_method = "26EF56C058C2777453E02CAD4C9EB908")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V remove(Object key1, Object key2) {
        dsTaint.addTaint(key2.dsTaint);
        dsTaint.addTaint(key1.dsTaint);
        Entry<E, K, V> e;
        e = removeEntry(key1, key2);
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Entry<E, K, V> e = removeEntry(key1, key2);
        //return (e != null) ? e.value : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.895 -0400", hash_original_method = "8D27DE23631F09453D73093F15998EF0", hash_generated_method = "05247FE33529393C656F97A794D5BE91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V put(E key1, K key2, V value) {
        dsTaint.addTaint(key2.dsTaint);
        dsTaint.addTaint(key1.dsTaint);
        dsTaint.addTaint(value.dsTaint);
        {
            int index;
            index = arrSize;
            {
                arr[index] = createEntry(0, null, null, value, null);
            } //End block
            {
                V oldValue;
                oldValue = arr[index].value;
                arr[index].value = value;
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
                boolean var3CC53A54E9E56C8592159E167D247BC8_2109202807 = (hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2()));
                {
                    V oldValue;
                    oldValue = e.value;
                    e.value = value;
                } //End block
            } //End collapsed parenthetic
            e = e.next;
        } //End block
        arr[index] = createEntry(hash, key1, key2, value, arr[index]);
        {
            rehash();
        } //End block
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.896 -0400", hash_original_method = "4E92EE4014ABA801EB273C60A5958799", hash_generated_method = "1C64948B01E521F7245D93B45FE4435D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.896 -0400", hash_original_method = "31FF250303275620FA0192DC25A0041E", hash_generated_method = "D76C3B890EF9B4A3D134553A41607664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(Object key1, Object key2) {
        dsTaint.addTaint(key2.dsTaint);
        dsTaint.addTaint(key1.dsTaint);
        boolean varE6D9CD9BC0FD3434DD2196F79DFDAC11_1919878885 = (findEntry(key1, key2) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return findEntry(key1, key2) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.896 -0400", hash_original_method = "E13BBD09CFB92FF506FEC56FABF87B9F", hash_generated_method = "FBC857D828CCBECD1503F4A82AB667DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V get(Object key1, Object key2) {
        dsTaint.addTaint(key2.dsTaint);
        dsTaint.addTaint(key1.dsTaint);
        Entry<E, K, V> e;
        e = findEntry(key1, key2);
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Entry<E, K, V> e = findEntry(key1, key2);
        //if (e != null) {
            //return e.value;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.896 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "B02D7658F0824D0869C92F4AD19DB19E")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.897 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "5952D8F6ECECE9C90DA6440092EF19A0")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.897 -0400", hash_original_method = "B126004260D8EBAD1640E464F002A4A4", hash_generated_method = "61E828EEB9DBC6E8BE40F3652967F8BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Entry<E, K, V> createEntry(int hashCode, E key1, K key2, V value,
            Entry<E, K, V> next) {
        dsTaint.addTaint(key2.dsTaint);
        dsTaint.addTaint(next.dsTaint);
        dsTaint.addTaint(key1.dsTaint);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(hashCode);
        Entry<E, K, V> var8E93C3C85192236BDE07196AB40CD9F2_873853745 = (new Entry<E, K, V>(hashCode, key1, key2, value, next));
        return (Entry<E, K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Entry<E, K, V>(hashCode, key1, key2, value, next);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.897 -0400", hash_original_method = "F4E18AFB5A6BD2866D211174F2C65244", hash_generated_method = "07CC0779E72C3FABB07CE4BCBFE8AF85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Iterator<Map.Entry<String, V>> createEntrySetIterator() {
        Iterator<Map.Entry<String, V>> var54D36B8493EA7FFABB7AA624F333E0AF_2041661036 = (new EntryIteratorImpl());
        return (Iterator<Map.Entry<String, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new EntryIteratorImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.897 -0400", hash_original_method = "6209E5C519243BC33CB9A47AFA9E017F", hash_generated_method = "28A81748A905490EDC98295A26E48452")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Iterator<V> createValueCollectionIterator() {
        Iterator<V> var8919824AFBA062C0E0F350915FD78DA0_1098435060 = (new ValueIteratorImpl());
        return (Iterator<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ValueIteratorImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.897 -0400", hash_original_method = "C152D61E326241B091FB8EBCBC5C9180", hash_generated_method = "898668F4D24C1972EB999632AA9BBF35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final Entry<E, K, V> findEntry(Object key1, Object key2) {
        dsTaint.addTaint(key2.dsTaint);
        dsTaint.addTaint(key1.dsTaint);
        int hash;
        hash = key1.hashCode() + key2.hashCode();
        int index;
        index = (hash & 0x7fffffff) % arrSize;
        Entry<E, K, V> e;
        e = arr[index];
        {
            {
                boolean var3CC53A54E9E56C8592159E167D247BC8_668574631 = (hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2()));
            } //End collapsed parenthetic
            e = e.next;
        } //End block
        return (Entry<E, K, V>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.898 -0400", hash_original_method = "C98DB123D4E5CC84B2492FBCF56B145D", hash_generated_method = "20C346B937EBA2B85B655ED02768BCFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final Entry<E, K, V> removeEntry(Object key1, Object key2) {
        dsTaint.addTaint(key2.dsTaint);
        dsTaint.addTaint(key1.dsTaint);
        {
            int index;
            index = arrSize;
            {
                Entry<E, K, V> ret;
                ret = arr[index];
                arr[index] = null;
            } //End block
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
                boolean var3CC53A54E9E56C8592159E167D247BC8_1573741762 = (hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2()));
                {
                    {
                        arr[index] = e.next;
                    } //End block
                    {
                        prev.next = e.next;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            prev = e;
            e = e.next;
        } //End block
        return (Entry<E, K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class Entry<E, K, V> implements Map.Entry<String, V> {
        int hash;
        E key1;
        K key2;
        V value;
        Entry<E, K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.898 -0400", hash_original_method = "3E3A99A3B7891AEE573C3F0F98EEE3AE", hash_generated_method = "742A6FE7995619DAEB156235CC39674A")
        @DSModeled(DSC.SAFE)
        public Entry(int hash, E key1, K key2, V value, Entry<E, K, V> next) {
            dsTaint.addTaint(hash);
            dsTaint.addTaint(key2.dsTaint);
            dsTaint.addTaint(next.dsTaint);
            dsTaint.addTaint(key1.dsTaint);
            dsTaint.addTaint(value.dsTaint);
            // ---------- Original Method ----------
            //this.hash = hash;
            //this.key1 = key1;
            //this.key2 = key2;
            //this.value = value;
            //this.next = next;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.898 -0400", hash_original_method = "43A91F8C54B90BC0F4C951BCB1425B25", hash_generated_method = "CF55A814FEA5E5E0C881A4AAC64CDA69")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getKey() {
            String var5ED34EB54975ADC483C09039AF439E54_377090036 = (key1.toString() + key2.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return key1.toString() + key2.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.898 -0400", hash_original_method = "8E21854AE9ADC89A1868BC4522219FB2", hash_generated_method = "4AB7DBF2DA2E66854762476A543BC9C7")
        @DSModeled(DSC.SAFE)
        public E getKey1() {
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return key1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.899 -0400", hash_original_method = "7F02D1AD568FC6C2F60475D661F743CB", hash_generated_method = "38E3F985A08FCC813C2928958E2B2920")
        @DSModeled(DSC.SAFE)
        public K getKey2() {
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return key2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.899 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "1716B03F3EEDEC9A8CDFDC8FCC55E236")
        @DSModeled(DSC.SAFE)
        public V getValue() {
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.899 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "4333C41A04860BA6AEEB70B0D6A9817D")
        @DSModeled(DSC.SAFE)
        public V setValue(V value) {
            dsTaint.addTaint(value.dsTaint);
            V oldValue;
            oldValue = this.value;
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.899 -0400", hash_original_method = "2C745FE5DF9CE9CA09289DC08E07F848", hash_generated_method = "1019A6AF81268989141273489A8EBC03")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            Entry<?, ?, ?> e;
            e = (Entry<?, ?, ?>) obj;
            Object getKey1;
            getKey1 = e.getKey1();
            Object getKey2;
            getKey2 = e.getKey2();
            Object getValue;
            getValue = e.getValue();
            {
                boolean var5AA186129D40D0D053E9DEE36E4B4EF5_873330546 = ((key1 == null && getKey1 != null)
                    || (key2 == null && getKey2 != null)
                    || (value == null && getValue != null)
                    || !key1.equals(e.getKey1()) || !key2.equals(e.getKey2())
                    || !value.equals(getValue));
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.900 -0400", hash_original_method = "57C89921FB9688640B9C568340F7B69C", hash_generated_method = "361BCB0854F551B97338261F5FD39310")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int hashCode() {
            int hash1;
            hash1 = (key1 == null ? 0 : key1.hashCode());//DSFIXME:  CODE0008: Nested ternary operator in expression
            int hash2;
            hash2 = (key2 == null ? 0 : key2.hashCode());//DSFIXME:  CODE0008: Nested ternary operator in expression
            int varA174CA9A4343C7CD5810592D3B17DB9F_2088675720 = ((hash1 + hash2) ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int hash1 = (key1 == null ? 0 : key1.hashCode());
            //int hash2 = (key2 == null ? 0 : key2.hashCode());
            //return (hash1 + hash2) ^ (value == null ? 0 : value.hashCode());
        }

        
    }


    
    class EntrySetImpl extends AbstractSet<Map.Entry<String, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.900 -0400", hash_original_method = "2BCF4F287850C09B90ABA7132F996DC4", hash_generated_method = "2BCF4F287850C09B90ABA7132F996DC4")
                public EntrySetImpl ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.900 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "5952D8F6ECECE9C90DA6440092EF19A0")
        @DSModeled(DSC.SAFE)
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.900 -0400", hash_original_method = "AE463F3857FBE52FC47F5CD4A94D1EE6", hash_generated_method = "CB1BBFA30FC78A80159E3DCADA51A3C9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            TwoKeyHashMap.this.clear();
            // ---------- Original Method ----------
            //TwoKeyHashMap.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.900 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "B02D7658F0824D0869C92F4AD19DB19E")
        @DSModeled(DSC.SAFE)
        public boolean isEmpty() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.900 -0400", hash_original_method = "0351D580B43E9823D3890B3F7A27BB60", hash_generated_method = "0FCDFA50C36FD9701E237D0BDC869022")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            Entry<?, ?, ?> entry;
            entry = (Entry<?, ?, ?>) obj;
            Entry<E, K, V> entry2;
            entry2 = findEntry(entry.getKey1(), entry.getKey2());
            Object value;
            value = entry.getValue();
            Object value2;
            value2 = entry2.getValue();
            {
                Object var8FE214ACB260EF10FD8536B4BD04FDDC_766179218 = (value.equals(value2));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.901 -0400", hash_original_method = "30A2FA02E1530F63F4EB8959C457654B", hash_generated_method = "94D4D81E2591AF91B9C9FF538AC1C34F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean remove(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean var51FCFB63B23B042D188F5889FADEE83D_1243754650 = (removeEntry(((Entry) obj).getKey1(), ((Entry) obj).getKey2()) != null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(obj instanceof Entry)) {
                //return false;
            //}
            //return removeEntry(((Entry) obj).getKey1(), ((Entry) obj).getKey2()) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.901 -0400", hash_original_method = "820C2D57E851A82BD3B2742370FA728A", hash_generated_method = "0EC78E84C8DE0A3549C172B62E950092")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<Map.Entry<String, V>> iterator() {
            Iterator<Map.Entry<String, V>> var78C064C20B576D743C699EACE8389B8A_887466853 = (createEntrySetIterator());
            return (Iterator<Map.Entry<String, V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return createEntrySetIterator();
        }

        
    }


    
    class EntryIteratorImpl implements Iterator<Map.Entry<String, V>> {
        private int startModCount;
        private boolean found;
        private int curr = -1;
        private int returned_index = -1;
        private Entry<E, K, V> curr_entry;
        private Entry<E, K, V> returned_entry;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.901 -0400", hash_original_method = "E708A38A6B1072C269DF2FC2A57F4EEE", hash_generated_method = "795363C7EF8F0A7D3A2E876BD06BA763")
        @DSModeled(DSC.SAFE)
         EntryIteratorImpl() {
            startModCount = modCount;
            // ---------- Original Method ----------
            //startModCount = modCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.901 -0400", hash_original_method = "2E6F84DE8CBAE5EA419B2332CF98801C", hash_generated_method = "CAD7249BEA274AA6485717B207C194AF")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            {
                curr_entry = curr_entry.next;
            } //End block
            {
                {
                    curr_entry = arr[curr];
                } //End block
            } //End block
            boolean varADD6E08E9486A747E6272FE6A1AEAF8B_384752774 = (found = (curr_entry != null));
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.902 -0400", hash_original_method = "4A9B66986403EF804F6712808B1107B5", hash_generated_method = "6718461DB42174BB5BF7805AE1CBDB97")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Map.Entry<String, V> next() {
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_581910730 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            found = false;
            returned_index = curr;
            returned_entry = curr_entry;
            return (Map.Entry<String, V>)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.902 -0400", hash_original_method = "5DECA7771A914CFF4F808726B9F33811", hash_generated_method = "B41075074EB51DC53301EB7000FC0F00")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.902 -0400", hash_original_method = "F8D82136CD0857DF0A94EC7033BE2B48", hash_generated_method = "F8D82136CD0857DF0A94EC7033BE2B48")
                public ValuesCollectionImpl ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.902 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "5952D8F6ECECE9C90DA6440092EF19A0")
        @DSModeled(DSC.SAFE)
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.902 -0400", hash_original_method = "AE463F3857FBE52FC47F5CD4A94D1EE6", hash_generated_method = "CB1BBFA30FC78A80159E3DCADA51A3C9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            TwoKeyHashMap.this.clear();
            // ---------- Original Method ----------
            //TwoKeyHashMap.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.903 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "B02D7658F0824D0869C92F4AD19DB19E")
        @DSModeled(DSC.SAFE)
        public boolean isEmpty() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.903 -0400", hash_original_method = "680FD22D8DB10527F3174FA8865D96E7", hash_generated_method = "BFAF4C7A52CEF8C3A9A338C21C5FB110")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<V> iterator() {
            Iterator<V> varCCB77251279D4C1252EF10F6F8D7569D_193270518 = (createValueCollectionIterator());
            return (Iterator<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return createValueCollectionIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.903 -0400", hash_original_method = "74702C44933E62600B2ED3E7307D82B0", hash_generated_method = "350AAE9652234D2A43942D4E530CDB99")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            boolean varE4B410CADF0B35A0E3C54617BD85817F_441208236 = (containsValue(obj));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return containsValue(obj);
        }

        
    }


    
    class ValueIteratorImpl implements Iterator<V> {
        private EntryIteratorImpl itr;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.903 -0400", hash_original_method = "5B2B0240442A661D6F35A8FA67A7469B", hash_generated_method = "FAA2EFD99674487E058F0C99576A9B8D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ValueIteratorImpl() {
            this.itr = new EntryIteratorImpl();
            // ---------- Original Method ----------
            //this.itr = new EntryIteratorImpl();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.903 -0400", hash_original_method = "351E0C8E290AF7E9E6FFA36B6DF7C9FA", hash_generated_method = "411F1961678868ADB1087BA75C7675C4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public V next() {
            V varFA24B5A3A7B00E8B43A198E7FF29536D_1784524980 = (itr.next().getValue());
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return itr.next().getValue();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.903 -0400", hash_original_method = "C9ED4E1E548B82ACF6AA423D5E0C3E8C", hash_generated_method = "F1B26A301CD95E7A3CF3E96C8421A61D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            itr.remove();
            // ---------- Original Method ----------
            //itr.remove();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.904 -0400", hash_original_method = "0093C9D638C4ECB39AFF8230D36DFCB0", hash_generated_method = "B3A0F7CB9618DCCBFBECCD80307A2939")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasNext() {
            boolean varF664500D47A97D2A15781D0CF424E05F_405461805 = (itr.hasNext());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return itr.hasNext();
        }

        
    }


    
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int DEFAULT_INITIAL_SIZE = 16;
}


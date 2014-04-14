package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {
    
    @SuppressWarnings("unchecked")
    private static <K, V> Entry<K, V>[] newEntryArray(int size) {
        return new Entry[size];
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.504 -0500", hash_original_field = "5F72F58EEBF24F573F6939A12F43F1DD", hash_generated_field = "7DB5CF06E1B6356201026C14CAD31DE8")

    private static final int DEFAULT_SIZE = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.507 -0500", hash_original_field = "DD92337EC0A949FCB6367CB914D87989", hash_generated_field = "DA4F581341DFFC093DAB2ED377CF1682")

    private  ReferenceQueue<K> referenceQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.509 -0500", hash_original_field = "BF84735BCD9327FC2D1CC927ED35945D", hash_generated_field = "BF84735BCD9327FC2D1CC927ED35945D")

    int elementCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.512 -0500", hash_original_field = "36C14C81A5F4E64B5630EF2ADDAD7469", hash_generated_field = "36C14C81A5F4E64B5630EF2ADDAD7469")

    Entry<K, V>[] elementData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.515 -0500", hash_original_field = "09A32BD26ECAFE02311923153FC6AF4D", hash_generated_field = "9875194AD635CA8D9949128549486276")

    private  int loadFactor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.517 -0500", hash_original_field = "B212DD967AF5750AEF1DDA2E6D14352F", hash_generated_field = "831F8FC1A32CF07BE696149BB6AEA9AA")

    private int threshold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.520 -0500", hash_original_field = "52F3DED7388D6DA42BC9C902075440B5", hash_generated_field = "7980638400FDA73EFCEF2F9901C03D43")

    volatile int modCount;

    /**
     * Constructs a new empty {@code WeakHashMap} instance.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.617 -0500", hash_original_method = "B976885DE3CF2C49EC1331AC2786A4B5", hash_generated_method = "16A7169736FF430365004AC4125002EC")
    
public WeakHashMap() {
        this(DEFAULT_SIZE);
    }

    /**
     * Constructs a new {@code WeakHashMap} instance with the specified
     * capacity.
     *
     * @param capacity
     *            the initial capacity of this map.
     * @throws IllegalArgumentException
     *                if the capacity is less than zero.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.623 -0500", hash_original_method = "76AE00E803F5BFDB4BDF43DC151D88D7", hash_generated_method = "E98B88877DFC7D328CA78DE2C40A64A3")
    
public WeakHashMap(int capacity) {
        if (capacity >= 0) {
            elementCount = 0;
            elementData = newEntryArray(capacity == 0 ? 1 : capacity);
            loadFactor = 7500; // Default load factor of 0.75
            computeMaxSize();
            referenceQueue = new ReferenceQueue<K>();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Constructs a new {@code WeakHashMap} instance with the specified capacity
     * and load factor.
     *
     * @param capacity
     *            the initial capacity of this map.
     * @param loadFactor
     *            the initial load factor.
     * @throws IllegalArgumentException
     *             if the capacity is less than zero or the load factor is less
     *             or equal to zero.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.628 -0500", hash_original_method = "342F9B7CF63C1134C14E3979782FA4FA", hash_generated_method = "8A8F0D1C4AB228C0688F808ED15B8670")
    
public WeakHashMap(int capacity, float loadFactor) {
        if (capacity >= 0 && loadFactor > 0) {
            elementCount = 0;
            elementData = newEntryArray(capacity == 0 ? 1 : capacity);
            this.loadFactor = (int) (loadFactor * 10000);
            computeMaxSize();
            referenceQueue = new ReferenceQueue<K>();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Constructs a new {@code WeakHashMap} instance containing the mappings
     * from the specified map.
     *
     * @param map
     *            the mappings to add.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.633 -0500", hash_original_method = "4D7BC16BC60EE786903D624E86CA0AFB", hash_generated_method = "234CA68C4FDBFBFAC8497D2548488981")
    
public WeakHashMap(Map<? extends K, ? extends V> map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        putAllImpl(map);
    }

    /**
     * Removes all mappings from this map, leaving it empty.
     *
     * @see #isEmpty()
     * @see #size()
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.638 -0500", hash_original_method = "C690E441FDF499DD7829AA3D638ADE28", hash_generated_method = "87106446D54E5996CA5D5947A9A32982")
    
@Override
    public void clear() {
        if (elementCount > 0) {
            elementCount = 0;
            Arrays.fill(elementData, null);
            modCount++;
            while (referenceQueue.poll() != null) {
                // do nothing
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.642 -0500", hash_original_method = "85D93BA99AF40F5CDC3F42570A89C9FC", hash_generated_method = "3DE3412ACE1BE890F1F96C0B01D802D7")
    
private void computeMaxSize() {
        threshold = (int) ((long) elementData.length * loadFactor / 10000);
    }

    /**
     * Returns whether this map contains the specified key.
     *
     * @param key
     *            the key to search for.
     * @return {@code true} if this map contains the specified key,
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.657 -0500", hash_original_method = "7C0BA359573790AC71E46CA35F3B3C5D", hash_generated_method = "3A533A1E3B5EF2AF662A06C62B53947C")
    
@Override
    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.246 -0400", hash_original_method = "115108C1B40A91216FE420487FA7990C", hash_generated_method = "54486BB87EC100E6525877EA5676ED14")
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        poll();
Set<Map.Entry<K, V>> var952772A53018FA152689B94755082E8D_915180893 =         new AbstractSet<Map.Entry<K, V>>() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.752 -0500", hash_original_method = "997773928D6A4FA2A905BEE282A68997", hash_generated_method = "176D1A4C8F486CE93A2F004880186E5F")
                
@Override
                public int size() {
                    return WeakHashMap.this.size();
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.757 -0500", hash_original_method = "0820DD19F55EBD9E05BEDEF72AA76B85", hash_generated_method = "BADC0F927F8612CA7ECB009ADC632E8E")
                
@Override
                public void clear() {
                    WeakHashMap.this.clear();
                }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.673 -0500", hash_original_method = "1E7F94AC13E80E407E04FDAF276E4CCB", hash_generated_method = "9BBDC7F5B49772432F3B85C33468DAD2")
            
@Override
            public boolean remove(Object object) {
                if (contains(object)) {
                    WeakHashMap.this
                            .remove(((Map.Entry<?, ?>) object).getKey());
                    return true;
                }
                return false;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.679 -0500", hash_original_method = "A69D5126071923809AD406525E677E9C", hash_generated_method = "64CC9C389B6F3AD4B9D7E545E6F42AB1")
            
@Override
            public boolean contains(Object object) {
                if (object instanceof Map.Entry) {
                    Entry<?, ?> entry = getEntry(((Map.Entry<?, ?>) object)
                            .getKey());
                    if (entry != null) {
                        Object key = entry.get();
                        if (key != null || entry.isNull) {
                            return object.equals(entry);
                        }
                    }
                }
                return false;
            }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.246 -0400", hash_original_method = "6126AC883C019C19A724D0EDFC9A192D", hash_generated_method = "C5540A31518834C464989BAA9FF0BE80")
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
Iterator<Map.Entry<K, V>> varFD445BCDDF9C631EA7BE770450B83225_839819223 =             new HashIterator<Map.Entry<K, V>>(
                        new Entry.Type<Map.Entry<K, V>, K, V>() {
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.686 -0500", hash_original_method = "90738D101B25945A174A5A8A030091D2", hash_generated_method = "F0C59BE87F669D2723D76C7BAB9FB3DD")
                    
public Map.Entry<K, V> get(Map.Entry<K, V> entry) {
                                return entry;
                            }
});
            varFD445BCDDF9C631EA7BE770450B83225_839819223.addTaint(getTaint());
            return varFD445BCDDF9C631EA7BE770450B83225_839819223;
            // ---------- Original Method ----------
            //return new HashIterator<Map.Entry<K, V>>(
                        //new Entry.Type<Map.Entry<K, V>, K, V>() {
                            //public Map.Entry<K, V> get(Map.Entry<K, V> entry) {
                                //return entry;
                            //}
                        //});
        }
};
        var952772A53018FA152689B94755082E8D_915180893.addTaint(getTaint());
        return var952772A53018FA152689B94755082E8D_915180893;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.787 -0500", hash_original_method = "545F7F0FB84E7EA33FCF99594092AF0D", hash_generated_method = "545F7F0FB84E7EA33FCF99594092AF0D")
    
Entry<K, V> getEntry(Object key) {
        poll();
        if (key != null) {
            int index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            Entry<K, V> entry = elementData[index];
            while (entry != null) {
                if (key.equals(entry.get())) {
                    return entry;
                }
                entry = entry.next;
            }
            return null;
        }
        Entry<K, V> entry = elementData[0];
        while (entry != null) {
            if (entry.isNull) {
                return entry;
            }
            entry = entry.next;
        }
        return null;
    }

    /**
     * Returns whether this map contains the specified value.
     *
     * @param value
     *            the value to search for.
     * @return {@code true} if this map contains the specified value,
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.792 -0500", hash_original_method = "EBDA4BA5DE93153797BA511A1B84894F", hash_generated_method = "09DD43FF130EF5BE29CC5B0B3623FD1F")
    
@Override
    public boolean containsValue(Object value) {
        poll();
        if (value != null) {
            for (int i = elementData.length; --i >= 0;) {
                Entry<K, V> entry = elementData[i];
                while (entry != null) {
                    K key = entry.get();
                    if ((key != null || entry.isNull)
                            && value.equals(entry.value)) {
                        return true;
                    }
                    entry = entry.next;
                }
            }
        } else {
            for (int i = elementData.length; --i >= 0;) {
                Entry<K, V> entry = elementData[i];
                while (entry != null) {
                    K key = entry.get();
                    if ((key != null || entry.isNull) && entry.value == null) {
                        return true;
                    }
                    entry = entry.next;
                }
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in this map.
     *
     * @return the number of elements in this map.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.796 -0500", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "DBCA9EC6E74705391235527F696D1557")
    
@Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.800 -0500", hash_original_method = "0A4BB2570FECEAC055174AF0C493CF3C", hash_generated_method = "7AB1FAF3EC17D4FD9BF031A89091E9CC")
    
@SuppressWarnings("unchecked")
    void poll() {
        Entry<K, V> toRemove;
        while ((toRemove = (Entry<K, V>) referenceQueue.poll()) != null) {
            removeEntry(toRemove);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.804 -0500", hash_original_method = "950CA8B0FD25845E584DCFB2BE4D9F32", hash_generated_method = "E5803BAC86669FD0B5B57C66157EF76F")
    
void removeEntry(Entry<K, V> toRemove) {
        Entry<K, V> entry, last = null;
        int index = (toRemove.hash & 0x7FFFFFFF) % elementData.length;
        entry = elementData[index];
        // Ignore queued entries which cannot be found, the user could
        // have removed them before they were queued, i.e. using clear()
        while (entry != null) {
            if (toRemove == entry) {
                modCount++;
                if (last == null) {
                    elementData[index] = entry.next;
                } else {
                    last.next = entry.next;
                }
                elementCount--;
                break;
            }
            last = entry;
            entry = entry.next;
        }
    }

    /**
     * Maps the specified key to the specified value.
     *
     * @param key
     *            the key.
     * @param value
     *            the value.
     * @return the value of any previous mapping with the specified key or
     *         {@code null} if there was no mapping.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.808 -0500", hash_original_method = "E298E65486168CC370356B38BEF7AC1C", hash_generated_method = "F72FA88B2EDEA35C5229B35E73BA76C0")
    
@Override
    public V put(K key, V value) {
        poll();
        int index = 0;
        Entry<K, V> entry;
        if (key != null) {
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            entry = elementData[index];
            while (entry != null && !key.equals(entry.get())) {
                entry = entry.next;
            }
        } else {
            entry = elementData[0];
            while (entry != null && !entry.isNull) {
                entry = entry.next;
            }
        }
        if (entry == null) {
            modCount++;
            if (++elementCount > threshold) {
                rehash();
                index = key == null ? 0 : (key.hashCode() & 0x7FFFFFFF)
                        % elementData.length;
            }
            entry = new Entry<K, V>(key, value, referenceQueue);
            entry.next = elementData[index];
            elementData[index] = entry;
            return null;
        }
        V result = entry.value;
        entry.value = value;
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.814 -0500", hash_original_method = "2B64F6E6AE3910B09507F9013DEACFFD", hash_generated_method = "0F02A7F0DE7C24AAC0BD4A926000772E")
    
private void rehash() {
        int length = elementData.length * 2;
        if (length == 0) {
            length = 1;
        }
        Entry<K, V>[] newData = newEntryArray(length);
        for (int i = 0; i < elementData.length; i++) {
            Entry<K, V> entry = elementData[i];
            while (entry != null) {
                int index = entry.isNull ? 0 : (entry.hash & 0x7FFFFFFF)
                        % length;
                Entry<K, V> next = entry.next;
                entry.next = newData[index];
                newData[index] = entry;
                entry = next;
            }
        }
        elementData = newData;
        computeMaxSize();
    }

    /**
     * Copies all the mappings in the given map to this map. These mappings will
     * replace all mappings that this map had for any of the keys currently in
     * the given map.
     *
     * @param map
     *            the map to copy mappings from.
     * @throws NullPointerException
     *             if {@code map} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.818 -0500", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "180A9BE19E826613D60BF9D91B5A0A45")
    
@Override
    public void putAll(Map<? extends K, ? extends V> map) {
        putAllImpl(map);
    }

    /**
     * Removes the mapping with the specified key from this map.
     *
     * @param key
     *            the key of the mapping to remove.
     * @return the value of the removed mapping or {@code null} if no mapping
     *         for the specified key was found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.822 -0500", hash_original_method = "FE1A1739C961B2012661CB8735C428AE", hash_generated_method = "96E059F7F14F6D116320374B370EFB07")
    
@Override
    public V remove(Object key) {
        poll();
        int index = 0;
        Entry<K, V> entry, last = null;
        if (key != null) {
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            entry = elementData[index];
            while (entry != null && !key.equals(entry.get())) {
                last = entry;
                entry = entry.next;
            }
        } else {
            entry = elementData[0];
            while (entry != null && !entry.isNull) {
                last = entry;
                entry = entry.next;
            }
        }
        if (entry != null) {
            modCount++;
            if (last == null) {
                elementData[index] = entry.next;
            } else {
                last.next = entry.next;
            }
            elementCount--;
            return entry.value;
        }
        return null;
    }

    /**
     * Returns the number of elements in this map.
     *
     * @return the number of elements in this map.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.826 -0500", hash_original_method = "B65BB7405B9BD112F0A817BA32556A99", hash_generated_method = "746B615BBFBDD47A19CCC643A3AE0A95")
    
@Override
    public int size() {
        poll();
        return elementCount;
    }
    
    private static final class Entry<K, V> extends WeakReference<K> implements Map.Entry<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.525 -0500", hash_original_field = "5ED776CD81502BA181156D7F28EBC9C8", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.527 -0500", hash_original_field = "608BD3C529DBD92C1EC1FA5648B44B23", hash_generated_field = "608BD3C529DBD92C1EC1FA5648B44B23")

        boolean isNull;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.530 -0500", hash_original_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.533 -0500", hash_original_field = "5EEEE64CD04E8528349A03DB7ACC9002", hash_generated_field = "5EEEE64CD04E8528349A03DB7ACC9002")

        Entry<K, V> next;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.539 -0500", hash_original_method = "87D1D30974ED96CB990C400F03BCFAE4", hash_generated_method = "87D1D30974ED96CB990C400F03BCFAE4")
        
Entry(K key, V object, ReferenceQueue<K> queue) {
            super(key, queue);
            isNull = key == null;
            hash = isNull ? 0 : key.hashCode();
            value = object;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.541 -0500", hash_original_method = "1761F5110CA075C2A7975CB6F7D505A7", hash_generated_method = "85DF8CFEA3AA2CD64EE21E6586D0C720")
        
public K getKey() {
            return super.get();
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.544 -0500", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "95D4F56CA118DD7517C6CA2E4A00FE92")
        
public V getValue() {
            return value;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.546 -0500", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "F9467D3B60D7F9589C17103B5B4486CB")
        
public V setValue(V object) {
            V result = value;
            value = object;
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.549 -0500", hash_original_method = "3B6A8BF252F73FDC95A7717672A6DE75", hash_generated_method = "D5B9FFF76B2DD708B51243E4D7086BFA")
        
@Override
        public boolean equals(Object other) {
            if (!(other instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) other;
            Object key = super.get();
            return (key == null ? key == entry.getKey() : key.equals(entry
                    .getKey()))
                    && (value == null ? value == entry.getValue() : value
                            .equals(entry.getValue()));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.552 -0500", hash_original_method = "D08C41096A06FEDF3165E76D8A8BDE22", hash_generated_method = "6D2A9EA430B7D6F412536172B7348C30")
        
@Override
        public int hashCode() {
            return hash + (value == null ? 0 : value.hashCode());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.555 -0500", hash_original_method = "1EE8DCD6F434B8EBFF147EFC16429262", hash_generated_method = "EB23E3252038C24E74060C0CC22CCEAE")
        
@Override
        public String toString() {
            return super.get() + "=" + value;
        }
        
        interface Type<R, K, V> {
            R get(Map.Entry<K, V> entry);
        }
        
    }
    
    class HashIterator<R> implements Iterator<R> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.122 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "6E2A691F6D792F742C26DA32023216AB")

        private int position = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.122 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "9C353E755EC3A4E9B0CFE1EA9EEC47A8")

        private int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.123 -0400", hash_original_field = "99BA38A3E6B2466208E2D2433FB7C05C", hash_generated_field = "55DBD0360631F6C09DC3C9CAFB79E913")

        private Entry<K, V> currentEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.123 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "147D6C1E63E472440226370714C1D130")

        private Entry<K, V> nextEntry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.565 -0500", hash_original_field = "986FD776AF6F39F011FE4F157CCA073D", hash_generated_field = "989887495A4D0A589ACCCD9CE9664248")

        private K nextKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.567 -0500", hash_original_field = "01CE55F7E5B83A126B2D2C311EAC0383", hash_generated_field = "01CE55F7E5B83A126B2D2C311EAC0383")

         Entry.Type<R, K, V> type;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.570 -0500", hash_original_method = "257D5034B04AA7E9B1AFE5220E974305", hash_generated_method = "257D5034B04AA7E9B1AFE5220E974305")
        
HashIterator(Entry.Type<R, K, V> type) {
            this.type = type;
            expectedModCount = modCount;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.573 -0500", hash_original_method = "E96FCD52B0E07477D827A4DEB82A49B2", hash_generated_method = "270631B00E29F85530E17B5949D858AB")
        
public boolean hasNext() {
            if (nextEntry != null && (nextKey != null || nextEntry.isNull)) {
                return true;
            }
            while (true) {
                if (nextEntry == null) {
                    while (position < elementData.length) {
                        if ((nextEntry = elementData[position++]) != null) {
                            break;
                        }
                    }
                    if (nextEntry == null) {
                        return false;
                    }
                }
                // ensure key of next entry is not gc'ed
                nextKey = nextEntry.get();
                if (nextKey != null || nextEntry.isNull) {
                    return true;
                }
                nextEntry = nextEntry.next;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.576 -0500", hash_original_method = "F6AE8405A941E9948A6F966D8D2D9924", hash_generated_method = "FE9B8EA14816052DAC5FF5E80806B11C")
        
public R next() {
            if (expectedModCount == modCount) {
                if (hasNext()) {
                    currentEntry = nextEntry;
                    nextEntry = currentEntry.next;
                    R result = type.get(currentEntry);
                    // free the key
                    nextKey = null;
                    return result;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.580 -0500", hash_original_method = "9519576E1338F396C5D4D192735A75A5", hash_generated_method = "87E03B7F421A15B6D8B56D333DD18131")
        
public void remove() {
            if (expectedModCount == modCount) {
                if (currentEntry != null) {
                    removeEntry(currentEntry);
                    currentEntry = null;
                    expectedModCount++;
                    // cannot poll() as that would change the expectedModCount
                } else {
                    throw new IllegalStateException();
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:54.830 -0500", hash_original_method = "F23833AECC848C129604A1D671C10BB2", hash_generated_method = "5CB6A83A562A7C5A0E5B6F087B960F67")
    
private void putAllImpl(Map<? extends K, ? extends V> map) {
        if (map.entrySet() != null) {
            super.putAll(map);
        }
    }
}


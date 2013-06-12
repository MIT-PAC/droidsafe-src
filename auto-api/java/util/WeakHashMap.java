package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_SIZE = 16;
    private final ReferenceQueue<K> referenceQueue;
    int elementCount;
    Entry<K, V>[] elementData;
    private final int loadFactor;
    private int threshold;
    volatile int modCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.415 -0400", hash_original_method = "B976885DE3CF2C49EC1331AC2786A4B5", hash_generated_method = "5EE53B4B76909EC0F94BF6DCB04DA6BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WeakHashMap() {
        this(DEFAULT_SIZE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.416 -0400", hash_original_method = "76AE00E803F5BFDB4BDF43DC151D88D7", hash_generated_method = "934509F13EE1310E7A17D2D81FCA3903")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WeakHashMap(int capacity) {
        dsTaint.addTaint(capacity);
        {
            elementCount = 0;
            elementData = newEntryArray(capacity == 0 ? 1 : capacity);
            loadFactor = 7500;
            computeMaxSize();
            referenceQueue = new ReferenceQueue<K>();
        } //End block
        {
            throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (capacity >= 0) {
            //elementCount = 0;
            //elementData = newEntryArray(capacity == 0 ? 1 : capacity);
            //loadFactor = 7500; 
            //computeMaxSize();
            //referenceQueue = new ReferenceQueue<K>();
        //} else {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.416 -0400", hash_original_method = "342F9B7CF63C1134C14E3979782FA4FA", hash_generated_method = "31BF6FD3AAD107AB518B9E9C4C299B1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WeakHashMap(int capacity, float loadFactor) {
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
        {
            elementCount = 0;
            elementData = newEntryArray(capacity == 0 ? 1 : capacity);
            this.loadFactor = (int) (loadFactor * 10000);
            computeMaxSize();
            referenceQueue = new ReferenceQueue<K>();
        } //End block
        {
            throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (capacity >= 0 && loadFactor > 0) {
            //elementCount = 0;
            //elementData = newEntryArray(capacity == 0 ? 1 : capacity);
            //this.loadFactor = (int) (loadFactor * 10000);
            //computeMaxSize();
            //referenceQueue = new ReferenceQueue<K>();
        //} else {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.416 -0400", hash_original_method = "4D7BC16BC60EE786903D624E86CA0AFB", hash_generated_method = "7F57831A6164F3A294C1174B0FD7E6D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WeakHashMap(Map<? extends K, ? extends V> map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        dsTaint.addTaint(map.dsTaint);
        putAllImpl(map);
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.416 -0400", hash_original_method = "2247F12AA145F6C8DA6DC6EE8034FB60", hash_generated_method = "3B907ED700B825E6DCC78D1DD8808FB6")
    @SuppressWarnings("unchecked")
    private static <K, V> Entry<K, V>[] newEntryArray(int size) {
        return new Entry[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.416 -0400", hash_original_method = "C690E441FDF499DD7829AA3D638ADE28", hash_generated_method = "D2BD8D65AC8CBBDF285DA7DF0591D84B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clear() {
        {
            elementCount = 0;
            Arrays.fill(elementData, null);
            modCount++;
            {
                boolean varFA1D4F81EDB4C923F843813B6540E0FE_1357809873 = (referenceQueue.poll() != null);
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (elementCount > 0) {
            //elementCount = 0;
            //Arrays.fill(elementData, null);
            //modCount++;
            //while (referenceQueue.poll() != null) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.416 -0400", hash_original_method = "85D93BA99AF40F5CDC3F42570A89C9FC", hash_generated_method = "126BD2BF8F56499262304E9B731E5631")
    @DSModeled(DSC.SAFE)
    private void computeMaxSize() {
        threshold = (int) ((long) elementData.length * loadFactor / 10000);
        // ---------- Original Method ----------
        //threshold = (int) ((long) elementData.length * loadFactor / 10000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.416 -0400", hash_original_method = "7C0BA359573790AC71E46CA35F3B3C5D", hash_generated_method = "5618FE6D51A74E1EBF11EA8DD3426480")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        boolean var80C6FDED6A61C62705DB13137566169D_1498667862 = (getEntry(key) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getEntry(key) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.416 -0400", hash_original_method = "115108C1B40A91216FE420487FA7990C", hash_generated_method = "D33C36652ED41C1D848C5D90D51672D4")
    @DSModeled(DSC.SAFE)
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        poll();
        return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.416 -0400", hash_original_method = "058A25F673776D4338089073DA213D4E", hash_generated_method = "0BFDFBC421BFE3E4DA46B63E015E3EB8")
    @DSModeled(DSC.SAFE)
    @Override
    public Set<K> keySet() {
        poll();
        {
            keySet = new AbstractSet<K>() {
                @Override
                public boolean contains(Object object) {
                    return containsKey(object);
                }
                @Override
                public int size() {
                    return WeakHashMap.this.size();
                }
                @Override
                public void clear() {
                    WeakHashMap.this.clear();
                }
                @Override
                public boolean remove(Object key) {
                    if (containsKey(key)) {
                        WeakHashMap.this.remove(key);
                        return true;
                    }
                    return false;
                }
                @Override
                public Iterator<K> iterator() {
                    return new HashIterator<K>(new Entry.Type<K, K, V>() {
                        public K get(Map.Entry<K, V> entry) {
                            return entry.getKey();
                        }
                    });
                }
                @Override
                public Object[] toArray() {
                    Collection<K> coll = new ArrayList<K>(size());
                    for (Iterator<K> iter = iterator(); iter.hasNext();) {
                        coll.add(iter.next());
                    }
                    return coll.toArray();
                }
                @Override
                public <T> T[] toArray(T[] contents) {
                    Collection<K> coll = new ArrayList<K>(size());
                    for (Iterator<K> iter = iterator(); iter.hasNext();) {
                        coll.add(iter.next());
                    }
                    return coll.toArray(contents);
                }
            };
        } //End block
        return (Set<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.417 -0400", hash_original_method = "1BF87F9B8C3D58711D484B01D41C9F2F", hash_generated_method = "E02B3AB871EF144E3DF58B44802A6760")
    @DSModeled(DSC.SAFE)
    @Override
    public Collection<V> values() {
        poll();
        {
            valuesCollection = new AbstractCollection<V>() {
                @Override
                public int size() {
                    return WeakHashMap.this.size();
                }
                @Override
                public void clear() {
                    WeakHashMap.this.clear();
                }
                @Override
                public boolean contains(Object object) {
                    return containsValue(object);
                }
                @Override
                public Iterator<V> iterator() {
                    return new HashIterator<V>(new Entry.Type<V, K, V>() {
                        public V get(Map.Entry<K, V> entry) {
                            return entry.getValue();
                        }
                    });
                }
            };
        } //End block
        return (Collection<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.417 -0400", hash_original_method = "7498B4140ED8DA87371F31164D271C1D", hash_generated_method = "C0E0BBD55FC1B111D9AD583DE2801CC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        poll();
        {
            int index;
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            Entry<K, V> entry;
            entry = elementData[index];
            {
                {
                    boolean var34A40B722D871D6DB92AB2E02C0D49BB_199036679 = (key.equals(entry.get()));
                } //End collapsed parenthetic
                entry = entry.next;
            } //End block
        } //End block
        Entry<K, V> entry;
        entry = elementData[0];
        {
            entry = entry.next;
        } //End block
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //poll();
        //if (key != null) {
            //int index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            //Entry<K, V> entry = elementData[index];
            //while (entry != null) {
                //if (key.equals(entry.get())) {
                    //return entry.value;
                //}
                //entry = entry.next;
            //}
            //return null;
        //}
        //Entry<K, V> entry = elementData[0];
        //while (entry != null) {
            //if (entry.isNull) {
                //return entry.value;
            //}
            //entry = entry.next;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.417 -0400", hash_original_method = "545F7F0FB84E7EA33FCF99594092AF0D", hash_generated_method = "B2BBFBC8BD6A1EAC876C627E79E4F428")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Entry<K, V> getEntry(Object key) {
        dsTaint.addTaint(key.dsTaint);
        poll();
        {
            int index;
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            Entry<K, V> entry;
            entry = elementData[index];
            {
                {
                    boolean var34A40B722D871D6DB92AB2E02C0D49BB_1277615474 = (key.equals(entry.get()));
                } //End collapsed parenthetic
                entry = entry.next;
            } //End block
        } //End block
        Entry<K, V> entry;
        entry = elementData[0];
        {
            entry = entry.next;
        } //End block
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //poll();
        //if (key != null) {
            //int index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            //Entry<K, V> entry = elementData[index];
            //while (entry != null) {
                //if (key.equals(entry.get())) {
                    //return entry;
                //}
                //entry = entry.next;
            //}
            //return null;
        //}
        //Entry<K, V> entry = elementData[0];
        //while (entry != null) {
            //if (entry.isNull) {
                //return entry;
            //}
            //entry = entry.next;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.417 -0400", hash_original_method = "EBDA4BA5DE93153797BA511A1B84894F", hash_generated_method = "DA46F632C5C5B81E5ECA5F2FC931577D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        poll();
        {
            {
                int i;
                i = elementData.length;
                {
                    Entry<K, V> entry;
                    entry = elementData[i];
                    {
                        K key;
                        key = entry.get();
                        {
                            boolean var18A512D740DE406E77259979D1000436_65910015 = ((key != null || entry.isNull)
                            && value.equals(entry.value));
                        } //End collapsed parenthetic
                        entry = entry.next;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = elementData.length;
                {
                    Entry<K, V> entry;
                    entry = elementData[i];
                    {
                        K key;
                        key = entry.get();
                        entry = entry.next;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.417 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "F28CD474752FE4879B7660A7F2B72A30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_929913470 = (size() == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.417 -0400", hash_original_method = "0A4BB2570FECEAC055174AF0C493CF3C", hash_generated_method = "992D1A55949014704B55E83689E1D48A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
     void poll() {
        Entry<K, V> toRemove;
        {
            boolean varAF179C89B87910BBBA6E45758D4FD0E7_1410018815 = ((toRemove = (Entry<K, V>) referenceQueue.poll()) != null);
            {
                removeEntry(toRemove);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Entry<K, V> toRemove;
        //while ((toRemove = (Entry<K, V>) referenceQueue.poll()) != null) {
            //removeEntry(toRemove);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.418 -0400", hash_original_method = "950CA8B0FD25845E584DCFB2BE4D9F32", hash_generated_method = "1CC117455E1EA61C90698A6E13D1C7D0")
    @DSModeled(DSC.SAFE)
     void removeEntry(Entry<K, V> toRemove) {
        dsTaint.addTaint(toRemove.dsTaint);
        Entry<K, V> entry, last;
        last = null;
        int index;
        index = (toRemove.hash & 0x7FFFFFFF) % elementData.length;
        entry = elementData[index];
        {
            {
                modCount++;
                {
                    elementData[index] = entry.next;
                } //End block
                {
                    last.next = entry.next;
                } //End block
                elementCount--;
            } //End block
            last = entry;
            entry = entry.next;
        } //End block
        // ---------- Original Method ----------
        //Entry<K, V> entry, last = null;
        //int index = (toRemove.hash & 0x7FFFFFFF) % elementData.length;
        //entry = elementData[index];
        //while (entry != null) {
            //if (toRemove == entry) {
                //modCount++;
                //if (last == null) {
                    //elementData[index] = entry.next;
                //} else {
                    //last.next = entry.next;
                //}
                //elementCount--;
                //break;
            //}
            //last = entry;
            //entry = entry.next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.418 -0400", hash_original_method = "E298E65486168CC370356B38BEF7AC1C", hash_generated_method = "821563A916CCDE12CD7DD58A948CCACB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        poll();
        int index;
        index = 0;
        Entry<K, V> entry;
        {
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            entry = elementData[index];
            {
                boolean var11C456750D82E660592E03F3DAA89A38_12133661 = (entry != null && !key.equals(entry.get()));
                {
                    entry = entry.next;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            entry = elementData[0];
            {
                entry = entry.next;
            } //End block
        } //End block
        {
            modCount++;
            {
                rehash();
                index = key == null ? 0 : (key.hashCode() & 0x7FFFFFFF)
                        % elementData.length;
            } //End block
            entry = new Entry<K, V>(key, value, referenceQueue);
            entry.next = elementData[index];
            elementData[index] = entry;
        } //End block
        V result;
        result = entry.value;
        entry.value = value;
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.418 -0400", hash_original_method = "2B64F6E6AE3910B09507F9013DEACFFD", hash_generated_method = "76E1B4F9A31B90BE0AF3F07E1421D22C")
    @DSModeled(DSC.SAFE)
    private void rehash() {
        int length;
        length = elementData.length * 2;
        {
            length = 1;
        } //End block
        Entry<K, V>[] newData;
        newData = newEntryArray(length);
        {
            int i;
            i = 0;
            {
                Entry<K, V> entry;
                entry = elementData[i];
                {
                    int index;
                    index = 0;
                    index = (entry.hash & 0x7FFFFFFF)
                        % length;
                    Entry<K, V> next;
                    next = entry.next;
                    entry.next = newData[index];
                    newData[index] = entry;
                    entry = next;
                } //End block
            } //End block
        } //End collapsed parenthetic
        elementData = newData;
        computeMaxSize();
        // ---------- Original Method ----------
        //int length = elementData.length * 2;
        //if (length == 0) {
            //length = 1;
        //}
        //Entry<K, V>[] newData = newEntryArray(length);
        //for (int i = 0; i < elementData.length; i++) {
            //Entry<K, V> entry = elementData[i];
            //while (entry != null) {
                //int index = entry.isNull ? 0 : (entry.hash & 0x7FFFFFFF)
                        //% length;
                //Entry<K, V> next = entry.next;
                //entry.next = newData[index];
                //newData[index] = entry;
                //entry = next;
            //}
        //}
        //elementData = newData;
        //computeMaxSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.418 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "CCA3EC9AF8C86411AE741798A2A6970E")
    @DSModeled(DSC.SAFE)
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        dsTaint.addTaint(map.dsTaint);
        putAllImpl(map);
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.418 -0400", hash_original_method = "FE1A1739C961B2012661CB8735C428AE", hash_generated_method = "3876C23551929EFAA3C5374B3C565D6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        poll();
        int index;
        index = 0;
        Entry<K, V> entry, last;
        last = null;
        {
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            entry = elementData[index];
            {
                boolean var11C456750D82E660592E03F3DAA89A38_329469853 = (entry != null && !key.equals(entry.get()));
                {
                    last = entry;
                    entry = entry.next;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            entry = elementData[0];
            {
                last = entry;
                entry = entry.next;
            } //End block
        } //End block
        {
            modCount++;
            {
                elementData[index] = entry.next;
            } //End block
            {
                last.next = entry.next;
            } //End block
            elementCount--;
        } //End block
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.418 -0400", hash_original_method = "B65BB7405B9BD112F0A817BA32556A99", hash_generated_method = "64E44F0FFEFA6C2C79B82FF62339A698")
    @DSModeled(DSC.SAFE)
    @Override
    public int size() {
        poll();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //poll();
        //return elementCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.418 -0400", hash_original_method = "F23833AECC848C129604A1D671C10BB2", hash_generated_method = "1DBF0A08A0BBACEA55CD1E52170C84E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void putAllImpl(Map<? extends K, ? extends V> map) {
        dsTaint.addTaint(map.dsTaint);
        {
            boolean var6889E31DD8EB0136BAB9D60DD7EEE838_1131284936 = (map.entrySet() != null);
            {
                super.putAll(map);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (map.entrySet() != null) {
            //super.putAll(map);
        //}
    }

    
    private static final class Entry<K, V> extends WeakReference<K> implements Map.Entry<K, V> {
        int hash;
        boolean isNull;
        V value;
        Entry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.419 -0400", hash_original_method = "87D1D30974ED96CB990C400F03BCFAE4", hash_generated_method = "4B958CD9C29BA572D8F947713A8EB892")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Entry(K key, V object, ReferenceQueue<K> queue) {
            super(key, queue);
            dsTaint.addTaint(queue.dsTaint);
            dsTaint.addTaint(object.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            isNull = key == null;
            hash = isNull ? 0 : key.hashCode();
            // ---------- Original Method ----------
            //isNull = key == null;
            //hash = isNull ? 0 : key.hashCode();
            //value = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.419 -0400", hash_original_method = "1761F5110CA075C2A7975CB6F7D505A7", hash_generated_method = "57A735616F8B144A091DB6181F5234FB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K getKey() {
            K varB65187F425649C82FC5DED1D0938E1AD_1262077885 = (super.get());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return super.get();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.419 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "296B8D2ED309B616704C60943FB1CB71")
        @DSModeled(DSC.SAFE)
        public V getValue() {
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.419 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "D7D161FD7F5A353B9D0AF473B6320B0F")
        @DSModeled(DSC.SAFE)
        public V setValue(V object) {
            dsTaint.addTaint(object.dsTaint);
            V result;
            result = value;
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //V result = value;
            //value = object;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.419 -0400", hash_original_method = "3B6A8BF252F73FDC95A7717672A6DE75", hash_generated_method = "B2865B896D86D888A5DF442BC5EF6D13")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object other) {
            dsTaint.addTaint(other.dsTaint);
            Map.Entry<?, ?> entry;
            entry = (Map.Entry<?, ?>) other;
            Object key;
            key = super.get();
            boolean var715794E66FEAD2DA8E249FD5488C80A4_738925947 = ((key == null ? key == entry.getKey() : key.equals(entry
                    .getKey()))
                    && (value == null ? value == entry.getValue() : value
                            .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(other instanceof Map.Entry)) {
                //return false;
            //}
            //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) other;
            //Object key = super.get();
            //return (key == null ? key == entry.getKey() : key.equals(entry
                    //.getKey()))
                    //&& (value == null ? value == entry.getValue() : value
                            //.equals(entry.getValue()));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.419 -0400", hash_original_method = "D08C41096A06FEDF3165E76D8A8BDE22", hash_generated_method = "C69B265316F1DAC935C7E84F933BCA18")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int varBFAA27FDBD65002EF874070ACA9FDE01_2116509724 = (hash + (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return hash + (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.419 -0400", hash_original_method = "1EE8DCD6F434B8EBFF147EFC16429262", hash_generated_method = "6D914DDFC4333E4AA349A4CF015CCFDF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var6C7F813D34BDE56169D1ED827A0A0228_1669555670 = (super.get() + "=" + value);
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return super.get() + "=" + value;
        }

        
        interface Type<R, K, V> {
            R get(Map.Entry<K, V> entry);
        }
        
    }


    
    class HashIterator<R> implements Iterator<R> {
        private int position = 0, expectedModCount;
        private Entry<K, V> currentEntry, nextEntry;
        private K nextKey;
        final Entry.Type<R, K, V> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.419 -0400", hash_original_method = "257D5034B04AA7E9B1AFE5220E974305", hash_generated_method = "0CC2C30CEA19BCCAF3D01F3A318F30BE")
        @DSModeled(DSC.SAFE)
         HashIterator(Entry.Type<R, K, V> type) {
            dsTaint.addTaint(type.dsTaint);
            expectedModCount = modCount;
            // ---------- Original Method ----------
            this.type = type;
            expectedModCount = modCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.419 -0400", hash_original_method = "E96FCD52B0E07477D827A4DEB82A49B2", hash_generated_method = "FAEED1DCD3E181340A185CC1CD41802C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasNext() {
            {
                {
                    {
                        {
                            boolean var153DD30E336FC14C6728E2427043F36D_2081308956 = ((nextEntry = elementData[position++]) != null);
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                nextKey = nextEntry.get();
                nextEntry = nextEntry.next;
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (nextEntry != null && (nextKey != null || nextEntry.isNull)) {
                //return true;
            //}
            //while (true) {
                //if (nextEntry == null) {
                    //while (position < elementData.length) {
                        //if ((nextEntry = elementData[position++]) != null) {
                            //break;
                        //}
                    //}
                    //if (nextEntry == null) {
                        //return false;
                    //}
                //}
                //nextKey = nextEntry.get();
                //if (nextKey != null || nextEntry.isNull) {
                    //return true;
                //}
                //nextEntry = nextEntry.next;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.419 -0400", hash_original_method = "F6AE8405A941E9948A6F966D8D2D9924", hash_generated_method = "216347515836D134F8A1FB59B5674359")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public R next() {
            {
                {
                    boolean var384B0C75E2EB52B4939B27A6F15C2DC1_1518511509 = (hasNext());
                    {
                        currentEntry = nextEntry;
                        nextEntry = currentEntry.next;
                        R result;
                        result = type.get(currentEntry);
                        nextKey = null;
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) {
                	throw new NoSuchElementException();
                }
            } //End block
            if (DroidSafeAndroidRuntime.control) {
            	throw new ConcurrentModificationException();
            }
            
            return (R)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (expectedModCount == modCount) {
                //if (hasNext()) {
                    //currentEntry = nextEntry;
                    //nextEntry = currentEntry.next;
                    //R result = type.get(currentEntry);
                    //nextKey = null;
                    //return result;
                //}
                //throw new NoSuchElementException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.419 -0400", hash_original_method = "9519576E1338F396C5D4D192735A75A5", hash_generated_method = "12ED904B010B0284D74E46CAC0056F00")
        @DSModeled(DSC.SAFE)
        public void remove() {
            {
                {
                    removeEntry(currentEntry);
                    currentEntry = null;
                    expectedModCount++;
                } //End block
                if (DroidSafeAndroidRuntime.control) {
                    throw new IllegalStateException();
                } //End block
            } //End block
            if (DroidSafeAndroidRuntime.control) {
                throw new ConcurrentModificationException();
            } //End block
            // ---------- Original Method ----------
            //if (expectedModCount == modCount) {
                //if (currentEntry != null) {
                    //removeEntry(currentEntry);
                    //currentEntry = null;
                    //expectedModCount++;
                //} else {
                    //throw new IllegalStateException();
                //}
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
    }


    
}



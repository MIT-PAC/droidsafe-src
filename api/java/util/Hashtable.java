package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

public class Hashtable<K, V> extends Dictionary<K, V> implements Map<K, V>, Cloneable, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.272 -0500", hash_original_field = "9C9C52C3044A64A1683A2865C14D4656", hash_generated_field = "2D66E915A2C4A5FBF28A99892F20B1AF")

    private static final int MINIMUM_CAPACITY = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.275 -0500", hash_original_field = "8450B9285BE1BB97BF823A8DA56CC45D", hash_generated_field = "C94813E6F46C48A83BBFCFA3C9862983")

    private static final int MAXIMUM_CAPACITY = 1 << 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.277 -0500", hash_original_field = "BC5DB75EFD28A0C0128F36A7288DD7BF", hash_generated_field = "BC3AFA3625EEAFE404B4E2EE0E75EE0F")

    private static final Entry[] EMPTY_TABLE
            = new HashtableEntry[MINIMUM_CAPACITY >>> 1];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.280 -0500", hash_original_field = "69E9667A37D40729A72B55AC0A75E1FE", hash_generated_field = "41B5CEA68D112450CD83A4199938FEF0")

    private static final float DEFAULT_LOAD_FACTOR = .75F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.467 -0500", hash_original_field = "50E6753055F9DE382EADDC4CC1672596", hash_generated_field = "46C6C9B52666C02F378F5368FD774F43")

    private static final int CHARS_PER_ENTRY = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.571 -0500", hash_original_field = "5869819C603EB25B9D81226C26F9CB6F", hash_generated_field = "C70DCA64D7F48D81CC1FCEA91128ADE1")

    private static final long serialVersionUID = 1421746759512286392L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.573 -0500", hash_original_field = "CF235C5C020AE737E73C6D9BA948DD23", hash_generated_field = "BED226748EC460106938E3D870C7138F")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("threshold", int.class),
        new ObjectStreamField("loadFactor", float.class),
    };

    private HashMap<K,V> backingMap = new HashMap<K,V>();
        
@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.342 -0400", hash_original_method = "9A93999031A29C4DD8DE295A6372F847", hash_generated_method = "6A7170C4C6FFAE127214BE36F7841D7F")
    @SuppressWarnings("unchecked")
    public  Hashtable() {
        // ---------- Original Method ----------
        //table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }
        
@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.344 -0400", hash_original_method = "6003D4D798348C1583CB15DE42C187C6", hash_generated_method = "C0EB67B815B968B704ED802BE6142354")
    public  Hashtable(int capacity) {
        addTaint(capacity);
        backingMap.requestCapacity(capacity);
        
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
        
@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.346 -0400", hash_original_method = "5B6B569F078844A0FAD42909C56D1E6D", hash_generated_method = "91BC277383C1006AE68C521E66A2CAB0")
    public  Hashtable(int capacity, float loadFactor) {
        this(capacity);
        addTaint(loadFactor);
        addTaint(capacity);
        if (DroidSafeAndroidRuntime.control)
        {
            IllegalArgumentException var5B3332F9036D49CF8BF1BBF51FC6B72E_1155103858 = new IllegalArgumentException("Load factor: " + loadFactor);
            var5B3332F9036D49CF8BF1BBF51FC6B72E_1155103858.addTaint(taint);
            throw var5B3332F9036D49CF8BF1BBF51FC6B72E_1155103858;
        } //End block
        // ---------- Original Method ----------
        //if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            //throw new IllegalArgumentException("Load factor: " + loadFactor);
        //}
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.346 -0400", hash_original_method = "6950B91F5E6C68C49CB594AFD1673B84", hash_generated_method = "B59FAFD8CEADB25F80DD1853537DF4FA")
    public  Hashtable(Map<? extends K, ? extends V> map) {
        this(map.size());
        addTaint(map.getTaint());
        backingMap.putAll(map);
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.350 -0400", hash_original_method = "F0D9AD485DB15C1D3427CA487C88BFBD", hash_generated_method = "2719F1581F628268F46DEDB5FC36FA11")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized Object clone() {
        Hashtable<K, V> result = new Hashtable<K,V>();
        result.putAll(backingMap);
        result.addTaint(getTaint());
        if (DroidSafeAndroidRuntime.control)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_358918830 = 
                    new AssertionError(new CloneNotSupportedException());
            varA5A331D65C8C3F32D42E49D64BCF4109_358918830.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_358918830;
        } //End block
        
        return result;
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
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.351 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "E4FDC859CC599DE6CCB373537967445A")
    public synchronized boolean isEmpty() {
        return getTaintBoolean(); 
        // ---------- Original Method ----------
        //return size == 0;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.351 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "392CC05EF4F1B8CD4F26897A2D6FB092")
    public synchronized int size() {
        return getTaintInt(); 
        // ---------- Original Method ----------
        //return size;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.352 -0400", hash_original_method = "0D498A226869DEB0F3920DC31F67162F", hash_generated_method = "D037CE715676A07C60713D1D613B4CA4")
    public synchronized V get(Object key) {
        V value = backingMap.get(key);
        value.addTaint(getTaint());
        return value;
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
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.353 -0400", hash_original_method = "EDC536266386E3A88DC2FA7B05BC7882", hash_generated_method = "542F9EE3BA8B4E0B991426A62F884E03")
    public synchronized boolean containsKey(Object key) {
        return getTaintBoolean();
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
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.354 -0400", hash_original_method = "22B2A1F3D878FCC53A2BA6539B84615E", hash_generated_method = "4FDBB57EA40EF4A684F188E4E2C54B96")
    public synchronized boolean containsValue(Object value) {
        return backingMap.containsValue(value);
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
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.354 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "3A49322AA9ED5E55D08AD0F443327DB0")
    public boolean contains(Object value) {
        return getTaintBoolean();
        // ---------- Original Method ----------
        //return containsValue(value);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.356 -0400", hash_original_method = "70A37B9812099DB6AA6597919714B995", hash_generated_method = "758D3CDC605A984AF4341EA96D3A0293")
    
    public synchronized V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        if (DroidSafeAndroidRuntime.control)
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_609880649 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_609880649.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_609880649;
        } //End block
        return backingMap.put(key,  value);
        
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
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.358 -0400", hash_original_method = "46C920EF16234ECC2EBDE62DDADD6435", hash_generated_method = "54874BF81DEC6C650960B5D6E3D4D392")
    public synchronized void putAll(Map<? extends K, ? extends V> map) {
        addTaint(map.getTaint());
        backingMap.putAll(map);
        // ---------- Original Method ----------
        //ensureCapacity(map.size());
        //for (Entry<? extends K, ? extends V> e : map.entrySet()) {
            //put(e.getKey(), e.getValue());
        //}
    }

    /**
     * Increases the capacity of this {@code Hashtable}. This method is called
     * when the size of this {@code Hashtable} exceeds the load factor.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.346 -0500", hash_original_method = "CC28673E29B73787492CFDC805600F5D", hash_generated_method = "14708CA3A1941121C6C0D608E6FFAA7C")
    
protected void rehash() {
        /*
         * This method has no testable semantics, other than that it gets
         * called from time to time.
         */
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.366 -0400", hash_original_method = "B19FA41811C96CC39A17F943778772D8", hash_generated_method = "80B04D515B1317EE61E1AAF9F5382248")
    public synchronized V remove(Object key) {
        addTaint(key.getTaint());
        V value = backingMap.remove(key);
        value.addTaint(getTaint());
        return value;
        
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
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.367 -0400", hash_original_method = "1C0D329A7E5E91219CE97B2AC82E739C", hash_generated_method = "45AD9C95CF6097B621C7C9B171BF463C")
    public synchronized void clear() {
        backingMap.clear();
        // ---------- Original Method ----------
        //if (size != 0) {
            //Arrays.fill(table, null);
            //modCount++;
            //size = 0;
        //}
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.367 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "0BF30D06B517FD8D8DA79FFC3A6A2F5C")
    public synchronized Set<K> keySet() {
        Set<K> ks = backingMap.keySet();
        ks.addTaint(getTaint());
        return ks;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.367 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "E59F3976A2B93651AD7EFEBF2CC2964C")
    public synchronized Collection<V> values() {
        Collection<V> values = backingMap.values();
        values.addTaint(getTaint());
        return values;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.368 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "CF6379F765767D007D563C4052D00846")
    public synchronized Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> es = backingMap.getEntrySet();
        es.addTaint(getTaint());
        return es;
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.368 -0400", hash_original_method = "BD8590C2A6B44E1AD87F42CA1DDBEEC0", hash_generated_method = "8693180988660B3F37CDC637A13CD5A8")
    public synchronized Enumeration<K> keys() {
        Enumeration<K> var72EDC079A47B19D9B47B38BBA00AF901_1738885427 = new KeyEnumeration<K>();
        var72EDC079A47B19D9B47B38BBA00AF901_1738885427.addTaint(getTaint());
        return var72EDC079A47B19D9B47B38BBA00AF901_1738885427;
        // ---------- Original Method ----------
        //return new KeyEnumeration();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.368 -0400", hash_original_method = "D92B3AB4F78D152BCFDB4F438052384E", hash_generated_method = "3698A0D9DC498C7A503FBCDCEFC73B91")
    public synchronized Enumeration<V> elements() {
Enumeration<V> var3998A6162E9CBDC16A5D7E7745A926CC_955772035 =         new ValueEnumeration<V>();
        var3998A6162E9CBDC16A5D7E7745A926CC_955772035.addTaint(taint);
        return var3998A6162E9CBDC16A5D7E7745A926CC_955772035;
        // ---------- Original Method ----------
        //return new ValueEnumeration();
    }
    
    private static class HashtableEntry<K, V> implements Entry<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.372 -0500", hash_original_field = "F780C5984CF24E477CB9559E91475987", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

         K key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.375 -0500", hash_original_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.377 -0500", hash_original_field = "5ED776CD81502BA181156D7F28EBC9C8", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

         int hash;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.379 -0500", hash_original_field = "A5AC9F76C2A7B9F6F79010A5F4A3B4B7", hash_generated_field = "A5AC9F76C2A7B9F6F79010A5F4A3B4B7")

        HashtableEntry<K, V> next;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.382 -0500", hash_original_method = "FCC59894C2665A76D7100104D46402EE", hash_generated_method = "FCC59894C2665A76D7100104D46402EE")
        
HashtableEntry(K key, V value, int hash, HashtableEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.384 -0500", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "9EABD2522EB9D2E4218C9F5D70610D46")
        
public final K getKey() {
            return key;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.387 -0500", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "F012337EC034D28D12FEB60EC691650B")
        
public final V getValue() {
            return value;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.390 -0500", hash_original_method = "09EE506DF55191FF6B72960EEA25D181", hash_generated_method = "CE8BA28B53D9C36EF199302D5DBCDDC7")
        
public final V setValue(V value) {
            if (value == null) {
                throw new NullPointerException();
            }
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.392 -0500", hash_original_method = "509D67FA76563438156B3275F90914F5", hash_generated_method = "B7AB8038537E8D2F748C3F9D5E76A1F7")
        
@Override public final boolean equals(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry<?, ?> e = (Entry<?, ?>) o;
            return key.equals(e.getKey()) && value.equals(e.getValue());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.395 -0500", hash_original_method = "28D407F854479314A0A7C3BE1F12A9AB", hash_generated_method = "9F324F0EFF4E854AF4EF08A4B5EB550F")
        
@Override public final int hashCode() {
            return key.hashCode() ^ value.hashCode();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.398 -0500", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "1C713F1AABEB092283314E1A4F2FE9EE")
        
@Override public final String toString() {
            return key + "=" + value;
        }
        
    }
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.369 -0400", hash_original_method = "CF57466F07C2DB8AF5EFB522D22E3680", hash_generated_method = "871E41CFD4777EF0B724B8C5351615A3")
    private synchronized boolean containsMapping(Object key, Object value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1815748013 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1815748013;
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
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.371 -0400", hash_original_method = "A191738781408606E816E9A37080097D", hash_generated_method = "D8F6E8E7E7FD3058625E314BE1505141")
    private synchronized boolean removeMapping(Object key, Object value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        backingMap.remove(key);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_467110774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_467110774;
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

    /**
     * Compares this {@code Hashtable} with the specified object and indicates
     * if they are equal. In order to be equal, {@code object} must be an
     * instance of Map and contain the same key/value pairs.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if the specified object is equal to this Map,
     *         {@code false} otherwise.
     * @see #hashCode
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.462 -0500", hash_original_method = "9BC17AC5DA957A9C0A07708C3D3A3E68", hash_generated_method = "BB68B78A0F70D5B11399D7C204F4FCAF")
    
@Override public synchronized boolean equals(Object object) {
        return (object instanceof Map) &&
                entrySet().equals(((Map<?, ?>)object).entrySet());
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:25.465 -0500", hash_original_method = "0904BEF2CA25AF4229493E32A4F8928E", hash_generated_method = "395D69B6EB953B7D8BA4EDDE2AD97E1F")
    
@Override public synchronized int hashCode() {
        int result = 0;
        for (Entry<K, V> e : entrySet()) {
            K key = e.getKey();
            V value = e.getValue();
            if (key == this || value == this) {
                continue;
            }
            result += (key != null ? key.hashCode() : 0)
                    ^ (value != null ? value.hashCode() : 0);
        }
        return result;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.374 -0400", hash_original_method = "A78197C1027A9ECA0DF472B01066EEE7", hash_generated_method = "B4802C5F5E1EC42704522B104481436F")
    @Override
    public synchronized String toString() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
        
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
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.376 -0400", hash_original_method = "19818AA4E6F1DBA67EBB75B368743917", hash_generated_method = "3F395FD92DFBACFB0EEEE0858BA58751")
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        ObjectOutputStream.PutField fields = stream.putFields();
        stream.writeFields();
        for(Entry<K, V> e : entrySet())
        {
            stream.writeObject(e.getKey());
            stream.writeObject(e.getValue());
        } //End block
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
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.377 -0400", hash_original_method = "2EADB0DA3622DE13512805CD17FDFE7A", hash_generated_method = "399A5670241C83FF7B5FD9415EAD81BB")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        int capacity = stream.readInt();
        if(capacity < 0)        
        {
            InvalidObjectException var4B6A7F779A4667EA55847180B6A27960_1436446989 = new InvalidObjectException("Capacity: " + capacity);
            var4B6A7F779A4667EA55847180B6A27960_1436446989.addTaint(taint);
            throw var4B6A7F779A4667EA55847180B6A27960_1436446989;
        } //End block
        
        int size = stream.readInt();
        if(size < 0)        
        {
            InvalidObjectException varE685AABC7A986A19539C13F2F8920021_1526559440 = new InvalidObjectException("Size: " + size);
            varE685AABC7A986A19539C13F2F8920021_1526559440.addTaint(taint);
            throw varE685AABC7A986A19539C13F2F8920021_1526559440;
        } //End block
for(int i = 0;i < size;i++)
        {
            @SuppressWarnings("unchecked") K key = (K) stream.readObject();
            @SuppressWarnings("unchecked") V val = (V) stream.readObject();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    private class KeyEnumeration<K> implements Enumeration<K> {

        Iterator<K> iter;
        
        public KeyEnumeration() {
            iter = (Iterator<K>) backingMap.keySet.getIterator();
        }
        
        @Override
        
        public boolean hasMoreElements() {
            // TODO Auto-generated method stub
            return Hashtable.this.getTaintBoolean();
        }

        @Override
        
        public K nextElement() {
            // TODO Auto-generated method stub
            K item = iter.next();
            item.addTaint(Hashtable.this.getTaint());
            return item;
        }
    }
    
    private class ValueEnumeration<V> implements Enumeration<V> {

        Iterator<V> iter;
        
        public ValueEnumeration() {
            iter = (Iterator<V>) backingMap.valuesCollection.getIterator();
        }
        
        @Override
        
        public boolean hasMoreElements() {
            // TODO Auto-generated method stub
            return Hashtable.this.getTaintBoolean();
        }

        @Override
        
        public V nextElement() {
            // TODO Auto-generated method stub
            V item = iter.next();
            item.addTaint(Hashtable.this.getTaint());
            return item;
        }
    }
}


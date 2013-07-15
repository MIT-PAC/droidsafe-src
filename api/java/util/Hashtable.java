package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

public class Hashtable<K, V> extends Dictionary<K, V> implements Map<K, V>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.568 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "19DEB795009FCB78D63A1C2C298CE954")

    private transient HashtableEntry<K, V>[] table;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.568 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "55DCA83C6162ACD637EB02860F7422EE")

    private transient int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.568 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "EDCBB672EA8C27007EA64BE3078BC69C")

    private transient int modCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.568 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "AC9BEC59E41404676A448C0DD2BB745B")

    private transient int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.568 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "EB6C570550CCFE8E5FEBB44BA37D02C0")

    private transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.568 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "BFDE585634496DDD7FBD15EDD2D3C5DD")

    private transient Set<Entry<K, V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.568 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "5A2A505CEEC79706812E901D735E2A7C")

    private transient Collection<V> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.569 -0400", hash_original_method = "9A93999031A29C4DD8DE295A6372F847", hash_generated_method = "6A7170C4C6FFAE127214BE36F7841D7F")
    @SuppressWarnings("unchecked")
    public  Hashtable() {
        table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1;
        // ---------- Original Method ----------
        //table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.570 -0400", hash_original_method = "6003D4D798348C1583CB15DE42C187C6", hash_generated_method = "1A4CFD1EE43EB0AD683218A6C1B6BA0A")
    public  Hashtable(int capacity) {
        addTaint(capacity);
    if(capacity < 0)        
        {
            IllegalArgumentException varE68AB0C8AF29B541CCF795D60D7AEAE6_23000741 = new IllegalArgumentException("Capacity: " + capacity);
            varE68AB0C8AF29B541CCF795D60D7AEAE6_23000741.addTaint(taint);
            throw varE68AB0C8AF29B541CCF795D60D7AEAE6_23000741;
        } //End block
    if(capacity == 0)        
        {
            @SuppressWarnings("unchecked") HashtableEntry<K, V>[] tab = (HashtableEntry<K, V>[]) EMPTY_TABLE;
            table = tab;
            threshold = -1;
            return;
        } //End block
    if(capacity < MINIMUM_CAPACITY)        
        {
            capacity = MINIMUM_CAPACITY;
        } //End block
        else
    if(capacity > MAXIMUM_CAPACITY)        
        {
            capacity = MAXIMUM_CAPACITY;
        } //End block
        else
        {
            capacity = roundUpToPowerOfTwo(capacity);
        } //End block
        makeTable(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.570 -0400", hash_original_method = "5B6B569F078844A0FAD42909C56D1E6D", hash_generated_method = "16CB7D14B0B8C4DE945AB3B58AB366AE")
    public  Hashtable(int capacity, float loadFactor) {
        this(capacity);
        addTaint(loadFactor);
        addTaint(capacity);
    if(loadFactor <= 0 || Float.isNaN(loadFactor))        
        {
            IllegalArgumentException var5B3332F9036D49CF8BF1BBF51FC6B72E_165669601 = new IllegalArgumentException("Load factor: " + loadFactor);
            var5B3332F9036D49CF8BF1BBF51FC6B72E_165669601.addTaint(taint);
            throw var5B3332F9036D49CF8BF1BBF51FC6B72E_165669601;
        } //End block
        // ---------- Original Method ----------
        //if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            //throw new IllegalArgumentException("Load factor: " + loadFactor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.571 -0400", hash_original_method = "6950B91F5E6C68C49CB594AFD1673B84", hash_generated_method = "B59FAFD8CEADB25F80DD1853537DF4FA")
    public  Hashtable(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        addTaint(map.getTaint());
        constructorPutAll(map);
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.571 -0400", hash_original_method = "6631235722E4D3190E3529D2039DDD7A", hash_generated_method = "FE36B163F86E1A97E198B18AF38E1841")
    private void constructorPutAll(Map<? extends K, ? extends V> map) {
        addTaint(map.getTaint());
for(Entry<? extends K, ? extends V> e : map.entrySet())
        {
            constructorPut(e.getKey(), e.getValue());
        } //End block
        // ---------- Original Method ----------
        //for (Entry<? extends K, ? extends V> e : map.entrySet()) {
            //constructorPut(e.getKey(), e.getValue());
        //}
    }

    
        private static int capacityForInitSize(int size) {
        int result = (size >> 1) + size;
        return (result & ~(MAXIMUM_CAPACITY-1))==0 ? result : MAXIMUM_CAPACITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.572 -0400", hash_original_method = "F0D9AD485DB15C1D3427CA487C88BFBD", hash_generated_method = "BE159381D46D5DC395EEF381D8D30C15")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized Object clone() {
        Hashtable<K, V> result;
        try 
        {
            result = (Hashtable<K, V>) super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1356508547 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1356508547.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1356508547;
        } //End block
        result.makeTable(table.length);
        result.size = 0;
        result.keySet = null;
        result.entrySet = null;
        result.values = null;
        result.constructorPutAll(this);
Object varDC838461EE2FA0CA4C9BBB70A15456B0_315047863 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_315047863.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_315047863;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.573 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "2C9B1C1E2779FA98FB2710648DA4D746")
    public synchronized boolean isEmpty() {
        boolean var9FB8BC7F775DDD98EEAB5582D340229E_2019826 = (size == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1103247544 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1103247544;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.573 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "19DF007FACCDB99E7B79B2C719435F3C")
    public synchronized int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1654569465 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961983140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961983140;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.574 -0400", hash_original_method = "0D498A226869DEB0F3920DC31F67162F", hash_generated_method = "F4F38018A1CF46D7D9AC8301DB1ADAB7")
    public synchronized V get(Object key) {
        addTaint(key.getTaint());
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashtableEntry<K, V>[] tab = table;
for(HashtableEntry<K, V> e = tab[hash & (tab.length - 1)];e != null;e = e.next)
        {
            K eKey = e.key;
    if(eKey == key || (e.hash == hash && key.equals(eKey)))            
            {
V var65D32B0ADAFF3F55986024909BAFC34B_1792876163 =                 e.value;
                var65D32B0ADAFF3F55986024909BAFC34B_1792876163.addTaint(taint);
                return var65D32B0ADAFF3F55986024909BAFC34B_1792876163;
            } //End block
        } //End block
V var540C13E9E156B687226421B24F2DF178_1573432019 =         null;
        var540C13E9E156B687226421B24F2DF178_1573432019.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1573432019;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.575 -0400", hash_original_method = "EDC536266386E3A88DC2FA7B05BC7882", hash_generated_method = "2BC56865284749B72FC5F560491475B7")
    public synchronized boolean containsKey(Object key) {
        addTaint(key.getTaint());
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashtableEntry<K, V>[] tab = table;
for(HashtableEntry<K, V> e = tab[hash & (tab.length - 1)];e != null;e = e.next)
        {
            K eKey = e.key;
    if(eKey == key || (e.hash == hash && key.equals(eKey)))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1410072453 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578679490 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578679490;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1012790255 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485332638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_485332638;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.575 -0400", hash_original_method = "22B2A1F3D878FCC53A2BA6539B84615E", hash_generated_method = "32921907B6FE84F2CD25D39CBAC12365")
    public synchronized boolean containsValue(Object value) {
        addTaint(value.getTaint());
    if(value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1011405431 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1011405431.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1011405431;
        } //End block
        HashtableEntry[] tab = table;
        int len = tab.length;
for(int i = 0;i < len;i++)
        {
for(HashtableEntry e = tab[i];e != null;e = e.next)
            {
    if(value.equals(e.value))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1136639891 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008129776 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008129776;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2107120622 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_770224565 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_770224565;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.576 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "6B56F32E80BD43F9678E8A9354A85537")
    public boolean contains(Object value) {
        addTaint(value.getTaint());
        boolean varF98DD5D16840FDEEA577F8F359CCE837_949459386 = (containsValue(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2005052041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2005052041;
        // ---------- Original Method ----------
        //return containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.577 -0400", hash_original_method = "70A37B9812099DB6AA6597919714B995", hash_generated_method = "1B301F553E17558998D77DFAC2B90E43")
    public synchronized V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
    if(value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1973626283 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1973626283.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1973626283;
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        HashtableEntry<K, V> first = tab[index];
for(HashtableEntry<K, V> e = first;e != null;e = e.next)
        {
    if(e.hash == hash && key.equals(e.key))            
            {
                V oldValue = e.value;
                e.value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_1057187025 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_1057187025.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_1057187025;
            } //End block
        } //End block
        modCount++;
    if(size++ > threshold)        
        {
            rehash();
            tab = doubleCapacity();
            index = hash & (tab.length - 1);
            first = tab[index];
        } //End block
        tab[index] = new HashtableEntry<K, V>(key, value, hash, first);
V var540C13E9E156B687226421B24F2DF178_1211325222 =         null;
        var540C13E9E156B687226421B24F2DF178_1211325222.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1211325222;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.578 -0400", hash_original_method = "DD29A5E73441E57ACE3C1AF694856AF1", hash_generated_method = "3EAC9E30124026059716B8A19C31A5CC")
    private void constructorPut(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
    if(value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_675466165 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_675466165.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_675466165;
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        HashtableEntry<K, V> first = tab[index];
for(HashtableEntry<K, V> e = first;e != null;e = e.next)
        {
    if(e.hash == hash && key.equals(e.key))            
            {
                e.value = value;
                return;
            } //End block
        } //End block
        tab[index] = new HashtableEntry<K, V>(key, value, hash, first);
        size++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.579 -0400", hash_original_method = "46C920EF16234ECC2EBDE62DDADD6435", hash_generated_method = "54874BF81DEC6C650960B5D6E3D4D392")
    public synchronized void putAll(Map<? extends K, ? extends V> map) {
        addTaint(map.getTaint());
        ensureCapacity(map.size());
for(Entry<? extends K, ? extends V> e : map.entrySet())
        {
            put(e.getKey(), e.getValue());
        } //End block
        // ---------- Original Method ----------
        //ensureCapacity(map.size());
        //for (Entry<? extends K, ? extends V> e : map.entrySet()) {
            //put(e.getKey(), e.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.579 -0400", hash_original_method = "5BCC94324BA2D5ECBED6314BEA7D0FA8", hash_generated_method = "B5A6383892470F6E1DB0E8EDE51B1B1C")
    private void ensureCapacity(int numMappings) {
        addTaint(numMappings);
        int newCapacity = roundUpToPowerOfTwo(capacityForInitSize(numMappings));
        HashtableEntry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;
    if(newCapacity <= oldCapacity)        
        {
            return;
        } //End block
        rehash();
    if(newCapacity == oldCapacity * 2)        
        {
            doubleCapacity();
            return;
        } //End block
        HashtableEntry<K, V>[] newTable = makeTable(newCapacity);
    if(size != 0)        
        {
            int newMask = newCapacity - 1;
for(int i = 0;i < oldCapacity;i++)
            {
for(HashtableEntry<K, V> e = oldTable[i];e != null;)
                {
                    HashtableEntry<K, V> oldNext = e.next;
                    int newIndex = e.hash & newMask;
                    HashtableEntry<K, V> newNext = newTable[newIndex];
                    newTable[newIndex] = e;
                    e.next = newNext;
                    e = oldNext;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.580 -0400", hash_original_method = "CC28673E29B73787492CFDC805600F5D", hash_generated_method = "E3452D490AF44DF99FFD2B9DFC516DAB")
    protected void rehash() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.581 -0400", hash_original_method = "8FDFD015009EFB98FD90E5E66F0193AF", hash_generated_method = "26D429101DD2B38EF0D1C1D9D965215E")
    private HashtableEntry<K, V>[] makeTable(int newCapacity) {
        @SuppressWarnings("unchecked") HashtableEntry<K, V>[] newTable = (HashtableEntry<K, V>[]) new HashtableEntry[newCapacity];
        table = newTable;
        threshold = (newCapacity >> 1) + (newCapacity >> 2);
HashtableEntry<K, V>[] varBBDF9FA229AA843E98D9C8441545D1D6_1400625224 =         newTable;
        varBBDF9FA229AA843E98D9C8441545D1D6_1400625224.addTaint(taint);
        return varBBDF9FA229AA843E98D9C8441545D1D6_1400625224;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked") HashtableEntry<K, V>[] newTable
                //= (HashtableEntry<K, V>[]) new HashtableEntry[newCapacity];
        //table = newTable;
        //threshold = (newCapacity >> 1) + (newCapacity >> 2);
        //return newTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.582 -0400", hash_original_method = "291B56F25D1E56D0A03492C2073BE506", hash_generated_method = "A47E0A63083F7ECE160E5CF019A05B0A")
    private HashtableEntry<K, V>[] doubleCapacity() {
        HashtableEntry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;
    if(oldCapacity == MAXIMUM_CAPACITY)        
        {
HashtableEntry<K, V>[] var644E69580A9DE331964CDB2EEA8BEBA2_874692536 =             oldTable;
            var644E69580A9DE331964CDB2EEA8BEBA2_874692536.addTaint(taint);
            return var644E69580A9DE331964CDB2EEA8BEBA2_874692536;
        } //End block
        int newCapacity = oldCapacity * 2;
        HashtableEntry<K, V>[] newTable = makeTable(newCapacity);
    if(size == 0)        
        {
HashtableEntry<K, V>[] varBBDF9FA229AA843E98D9C8441545D1D6_2121384876 =             newTable;
            varBBDF9FA229AA843E98D9C8441545D1D6_2121384876.addTaint(taint);
            return varBBDF9FA229AA843E98D9C8441545D1D6_2121384876;
        } //End block
for(int j = 0;j < oldCapacity;j++)
        {
            HashtableEntry<K, V> e = oldTable[j];
    if(e == null)            
            {
                continue;
            } //End block
            int highBit = e.hash & oldCapacity;
            HashtableEntry<K, V> broken = null;
            newTable[j | highBit] = e;
for(HashtableEntry<K,V> n = e.next;n != null;e = n,n = n.next)
            {
                int nextHighBit = n.hash & oldCapacity;
    if(nextHighBit != highBit)                
                {
    if(broken == null)                    
                    newTable[j | nextHighBit] = n;
                    else
                    broken.next = n;
                    broken = e;
                    highBit = nextHighBit;
                } //End block
            } //End block
    if(broken != null)            
            broken.next = null;
        } //End block
HashtableEntry<K, V>[] varBBDF9FA229AA843E98D9C8441545D1D6_1988099233 =         newTable;
        varBBDF9FA229AA843E98D9C8441545D1D6_1988099233.addTaint(taint);
        return varBBDF9FA229AA843E98D9C8441545D1D6_1988099233;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.583 -0400", hash_original_method = "B19FA41811C96CC39A17F943778772D8", hash_generated_method = "03E190B901C384E87B24035008D3C8BC")
    public synchronized V remove(Object key) {
        addTaint(key.getTaint());
        int hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
for(HashtableEntry<K, V> e = tab[index], prev = null;e != null;prev = e,e = e.next)
        {
    if(e.hash == hash && key.equals(e.key))            
            {
    if(prev == null)                
                {
                    tab[index] = e.next;
                } //End block
                else
                {
                    prev.next = e.next;
                } //End block
                modCount++;
                size--;
V var65D32B0ADAFF3F55986024909BAFC34B_581213215 =                 e.value;
                var65D32B0ADAFF3F55986024909BAFC34B_581213215.addTaint(taint);
                return var65D32B0ADAFF3F55986024909BAFC34B_581213215;
            } //End block
        } //End block
V var540C13E9E156B687226421B24F2DF178_201794393 =         null;
        var540C13E9E156B687226421B24F2DF178_201794393.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_201794393;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.584 -0400", hash_original_method = "1C0D329A7E5E91219CE97B2AC82E739C", hash_generated_method = "45AD9C95CF6097B621C7C9B171BF463C")
    public synchronized void clear() {
    if(size != 0)        
        {
            Arrays.fill(table, null);
            modCount++;
            size = 0;
        } //End block
        // ---------- Original Method ----------
        //if (size != 0) {
            //Arrays.fill(table, null);
            //modCount++;
            //size = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.584 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "3BDAB5A9E6CD8E32E385044827125B37")
    public synchronized Set<K> keySet() {
        Set<K> ks = keySet;
Set<K> varB6853687BE649BA8B10F9701AD179BB7_1181925963 =         (ks != null) ? ks : (keySet = new KeySet());
        varB6853687BE649BA8B10F9701AD179BB7_1181925963.addTaint(taint);
        return varB6853687BE649BA8B10F9701AD179BB7_1181925963;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.585 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "F1687EF23FA86A71BAA3293B67130403")
    public synchronized Collection<V> values() {
        Collection<V> vs = values;
Collection<V> var5CABA883D65798B391E2C02013734397_1182938890 =         (vs != null) ? vs : (values = new Values());
        var5CABA883D65798B391E2C02013734397_1182938890.addTaint(taint);
        return var5CABA883D65798B391E2C02013734397_1182938890;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.585 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "329B51CF92B0FF1F62CFAC1948029BA3")
    public synchronized Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> es = entrySet;
Set<Entry<K, V>> var25D080FAAE722B04AA5C8EBDE33DD606_818280756 =         (es != null) ? es : (entrySet = new EntrySet());
        var25D080FAAE722B04AA5C8EBDE33DD606_818280756.addTaint(taint);
        return var25D080FAAE722B04AA5C8EBDE33DD606_818280756;
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.585 -0400", hash_original_method = "BD8590C2A6B44E1AD87F42CA1DDBEEC0", hash_generated_method = "1CA11A867A5E6B49BCE23702BBF160DC")
    public synchronized Enumeration<K> keys() {
Enumeration<K> var72EDC079A47B19D9B47B38BBA00AF901_340473673 =         new KeyEnumeration();
        var72EDC079A47B19D9B47B38BBA00AF901_340473673.addTaint(taint);
        return var72EDC079A47B19D9B47B38BBA00AF901_340473673;
        // ---------- Original Method ----------
        //return new KeyEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.586 -0400", hash_original_method = "D92B3AB4F78D152BCFDB4F438052384E", hash_generated_method = "DBE981E31362AB8B593C0EB145DAE339")
    public synchronized Enumeration<V> elements() {
Enumeration<V> var3998A6162E9CBDC16A5D7E7745A926CC_1508406829 =         new ValueEnumeration();
        var3998A6162E9CBDC16A5D7E7745A926CC_1508406829.addTaint(taint);
        return var3998A6162E9CBDC16A5D7E7745A926CC_1508406829;
        // ---------- Original Method ----------
        //return new ValueEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.586 -0400", hash_original_method = "CF57466F07C2DB8AF5EFB522D22E3680", hash_generated_method = "E90AE9085379EFC9D9A68283E22F36AE")
    private synchronized boolean containsMapping(Object key, Object value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        int hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
for(HashtableEntry<K, V> e = tab[index];e != null;e = e.next)
        {
    if(e.hash == hash && e.key.equals(key))            
            {
                boolean var9D13214451B619F7B04A75FF2E5FF359_178991989 = (e.value.equals(value));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628315790 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628315790;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1858213465 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1989915636 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1989915636;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.588 -0400", hash_original_method = "A191738781408606E816E9A37080097D", hash_generated_method = "7439F9A06E18DEEE2F8E002B7D92A3BA")
    private synchronized boolean removeMapping(Object key, Object value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        int hash = secondaryHash(key.hashCode());
        HashtableEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
for(HashtableEntry<K, V> e = tab[index], prev = null;e != null;prev = e,e = e.next)
        {
    if(e.hash == hash && e.key.equals(key))            
            {
    if(!e.value.equals(value))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1305252851 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1899393194 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1899393194;
                } //End block
    if(prev == null)                
                {
                    tab[index] = e.next;
                } //End block
                else
                {
                    prev.next = e.next;
                } //End block
                modCount++;
                size--;
                boolean varB326B5062B2F0E69046810717534CB09_1382450209 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1410353976 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1410353976;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1173265929 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1163464458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1163464458;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.588 -0400", hash_original_method = "9BC17AC5DA957A9C0A07708C3D3A3E68", hash_generated_method = "F0C8DD5BCDB9561CAC748BD9789FF367")
    @Override
    public synchronized boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean var33DF79B9894C00BA5911C8933571E1E7_2082172081 = ((object instanceof Map) &&
                entrySet().equals(((Map<?, ?>)object).entrySet()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120257043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120257043;
        // ---------- Original Method ----------
        //return (object instanceof Map) &&
                //entrySet().equals(((Map<?, ?>)object).entrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.589 -0400", hash_original_method = "0904BEF2CA25AF4229493E32A4F8928E", hash_generated_method = "51B9BF6B7FD50FF0A8A3499ACF01BEF3")
    @Override
    public synchronized int hashCode() {
        int result = 0;
for(Entry<K, V> e : entrySet())
        {
            K key = e.getKey();
            V value = e.getValue();
    if(key == this || value == this)            
            {
                continue;
            } //End block
            result += (key != null ? key.hashCode() : 0)
                    ^ (value != null ? value.hashCode() : 0);
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1263942119 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683945063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683945063;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.590 -0400", hash_original_method = "A78197C1027A9ECA0DF472B01066EEE7", hash_generated_method = "1DFCC3FE3FD1F69316BA66BA3615040C")
    @Override
    public synchronized String toString() {
        StringBuilder result = new StringBuilder(CHARS_PER_ENTRY * size);
        result.append('{');
        Iterator<Entry<K, V>> i = entrySet().iterator();
        boolean hasMore = i.hasNext();
        while
(hasMore)        
        {
            Entry<K, V> entry = i.next();
            K key = entry.getKey();
            result.append(key == this ? "(this Map)" : key.toString());
            result.append('=');
            V value = entry.getValue();
            result.append(value == this ? "(this Map)" : value.toString());
    if(hasMore = i.hasNext())            
            {
                result.append(", ");
            } //End block
        } //End block
        result.append('}');
String varE65B3A02759122992CB82C0E651AD408_44821279 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_44821279.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_44821279;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.591 -0400", hash_original_method = "19818AA4E6F1DBA67EBB75B368743917", hash_generated_method = "3F395FD92DFBACFB0EEEE0858BA58751")
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("threshold",  (int) (DEFAULT_LOAD_FACTOR * table.length));
        fields.put("loadFactor", DEFAULT_LOAD_FACTOR);
        stream.writeFields();
        stream.writeInt(table.length);
        stream.writeInt(size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.591 -0400", hash_original_method = "2EADB0DA3622DE13512805CD17FDFE7A", hash_generated_method = "2B6C9A068AE31C8DE53FE6575566AD17")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        int capacity = stream.readInt();
    if(capacity < 0)        
        {
            InvalidObjectException var4B6A7F779A4667EA55847180B6A27960_1624308400 = new InvalidObjectException("Capacity: " + capacity);
            var4B6A7F779A4667EA55847180B6A27960_1624308400.addTaint(taint);
            throw var4B6A7F779A4667EA55847180B6A27960_1624308400;
        } //End block
    if(capacity < MINIMUM_CAPACITY)        
        {
            capacity = MINIMUM_CAPACITY;
        } //End block
        else
    if(capacity > MAXIMUM_CAPACITY)        
        {
            capacity = MAXIMUM_CAPACITY;
        } //End block
        else
        {
            capacity = roundUpToPowerOfTwo(capacity);
        } //End block
        makeTable(capacity);
        int size = stream.readInt();
    if(size < 0)        
        {
            InvalidObjectException varE685AABC7A986A19539C13F2F8920021_1026939957 = new InvalidObjectException("Size: " + size);
            varE685AABC7A986A19539C13F2F8920021_1026939957.addTaint(taint);
            throw varE685AABC7A986A19539C13F2F8920021_1026939957;
        } //End block
for(int i = 0;i < size;i++)
        {
            @SuppressWarnings("unchecked") K key = (K) stream.readObject();
            @SuppressWarnings("unchecked") V val = (V) stream.readObject();
            constructorPut(key, val);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class HashtableEntry<K, V> implements Entry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.592 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.592 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.592 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.592 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A5AC9F76C2A7B9F6F79010A5F4A3B4B7")

        HashtableEntry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.593 -0400", hash_original_method = "FCC59894C2665A76D7100104D46402EE", hash_generated_method = "7F8F2DB59D28E587038E679033461007")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.593 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "72B3D66A6A50FE042829E4A77A2DE104")
        public final K getKey() {
K var6A95247616A3A8B93CFF7783DABD08D4_1586329679 =             key;
            var6A95247616A3A8B93CFF7783DABD08D4_1586329679.addTaint(taint);
            return var6A95247616A3A8B93CFF7783DABD08D4_1586329679;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.594 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "FB12DE94A05866D53029D50FE1C8AD20")
        public final V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_465606503 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_465606503.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_465606503;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.594 -0400", hash_original_method = "09EE506DF55191FF6B72960EEA25D181", hash_generated_method = "077C03A577BF814E1617D29E688CE9D7")
        public final V setValue(V value) {
    if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2099167606 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_2099167606.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_2099167606;
            } //End block
            V oldValue = this.value;
            this.value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_941817771 =             oldValue;
            var8CDBD2181CBEF5C2129AFFA68C014D4A_941817771.addTaint(taint);
            return var8CDBD2181CBEF5C2129AFFA68C014D4A_941817771;
            // ---------- Original Method ----------
            //if (value == null) {
                //throw new NullPointerException();
            //}
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.595 -0400", hash_original_method = "509D67FA76563438156B3275F90914F5", hash_generated_method = "1C9DE02166A9E6197D96CE3F200DE4B8")
        @Override
        public final boolean equals(Object o) {
            addTaint(o.getTaint());
    if(!(o instanceof Entry))            
            {
                boolean var68934A3E9455FA72420237EB05902327_502206569 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_195303309 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_195303309;
            } //End block
            Entry<?, ?> e = (Entry<?, ?>) o;
            boolean varBDE3EC6CCF05189A86D923F3FEC0BC60_172602276 = (key.equals(e.getKey()) && value.equals(e.getValue()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1227613073 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1227613073;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return key.equals(e.getKey()) && value.equals(e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.595 -0400", hash_original_method = "28D407F854479314A0A7C3BE1F12A9AB", hash_generated_method = "5B47C0C1B55D5DC7B6FE9C3D6A72FC96")
        @Override
        public final int hashCode() {
            int varD8C9F3525E899BE1FE8346EA0B439C65_311962859 = (key.hashCode() ^ value.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970618192 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970618192;
            // ---------- Original Method ----------
            //return key.hashCode() ^ value.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.595 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "9298D8E61921C2FCFD5B87CBE6602C61")
        @Override
        public final String toString() {
String varFE698C13EFD83B87FAF2DC2AB0874271_452754191 =             key + "=" + value;
            varFE698C13EFD83B87FAF2DC2AB0874271_452754191.addTaint(taint);
            return varFE698C13EFD83B87FAF2DC2AB0874271_452754191;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
    }


    
    private abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.596 -0400", hash_original_field = "B6F75212F617C3E247C9474AFDA3B784", hash_generated_field = "04911A8A6B33F6D23811475122C95D0E")

        int nextIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.596 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "7A671A08D7EC5144843A6963DC69FDC7")

        HashtableEntry<K, V> nextEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.596 -0400", hash_original_field = "8A3A9937F6D0DA3448C9C061B347CECF", hash_generated_field = "7DA4F26BBE36FAFDC112AEE30391E8D1")

        HashtableEntry<K, V> lastEntryReturned;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.596 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "17128C49BCF19B4186F02F384F2DEA86")

        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.596 -0400", hash_original_method = "1BB35CB0E7E6DF7A5633A61B0F63C5AA", hash_generated_method = "1DEA380805BCD885E22B88C930E74A1E")
          HashIterator() {
            HashtableEntry<K, V>[] tab = table;
            HashtableEntry<K, V> next = null;
            while
(next == null && nextIndex < tab.length)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.597 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "2798F399956624CA3E67767EF76DC892")
        public boolean hasNext() {
            boolean var89CBB2F442CE6BC294273342C489EBAF_2057750223 = (nextEntry != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2062423119 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2062423119;
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.598 -0400", hash_original_method = "5FA6641462F5564CAC982C4AF6FCFB6C", hash_generated_method = "F80B6A79E2F0B31D87DAB8900631F316")
         HashtableEntry<K, V> nextEntry() {
    if(modCount != expectedModCount)            
            {
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1245904692 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1245904692.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1245904692;
            }
    if(nextEntry == null)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1090055382 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1090055382.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1090055382;
            }
            HashtableEntry<K, V> entryToReturn = nextEntry;
            HashtableEntry<K, V>[] tab = table;
            HashtableEntry<K, V> next = entryToReturn.next;
            while
(next == null && nextIndex < tab.length)            
            {
                next = tab[nextIndex++];
            } //End block
            nextEntry = next;
HashtableEntry<K, V> var4D0F707C8B7B92ABA91FE6E8CAA540A2_628690424 =             lastEntryReturned = entryToReturn;
            var4D0F707C8B7B92ABA91FE6E8CAA540A2_628690424.addTaint(taint);
            return var4D0F707C8B7B92ABA91FE6E8CAA540A2_628690424;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.598 -0400", hash_original_method = "1C3D72122BB58702CE822C81122C0D27", hash_generated_method = "86A4848C509D0B3571438D2969C34D61")
         HashtableEntry<K, V> nextEntryNotFailFast() {
    if(nextEntry == null)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_206871612 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_206871612.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_206871612;
            }
            HashtableEntry<K, V> entryToReturn = nextEntry;
            HashtableEntry<K, V>[] tab = table;
            HashtableEntry<K, V> next = entryToReturn.next;
            while
(next == null && nextIndex < tab.length)            
            {
                next = tab[nextIndex++];
            } //End block
            nextEntry = next;
HashtableEntry<K, V> var4D0F707C8B7B92ABA91FE6E8CAA540A2_1136871736 =             lastEntryReturned = entryToReturn;
            var4D0F707C8B7B92ABA91FE6E8CAA540A2_1136871736.addTaint(taint);
            return var4D0F707C8B7B92ABA91FE6E8CAA540A2_1136871736;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.599 -0400", hash_original_method = "342FDC52CA82B385D96AADB83EE8F936", hash_generated_method = "46842471DF5E38BEE5E3EA450F4DB34A")
        public void remove() {
    if(lastEntryReturned == null)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_337991958 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_337991958.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_337991958;
            }
    if(modCount != expectedModCount)            
            {
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_829264139 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_829264139.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_829264139;
            }
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.599 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.599 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "36E6BC5BE4E9E5EB7B894982FCA24520")
        public K next() {
K varDFFFB017DDA62C15E8D1D49BA5F94802_2099772689 =             nextEntry().key;
            varDFFFB017DDA62C15E8D1D49BA5F94802_2099772689.addTaint(taint);
            return varDFFFB017DDA62C15E8D1D49BA5F94802_2099772689;
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends HashIterator implements Iterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.600 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.600 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "F6CD8DFA98BAFEE25FB177FCB07FD6A0")
        public V next() {
V var57B066C0B962D4E7D7CC8F9272046644_897567276 =             nextEntry().value;
            var57B066C0B962D4E7D7CC8F9272046644_897567276.addTaint(taint);
            return var57B066C0B962D4E7D7CC8F9272046644_897567276;
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.600 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.600 -0400", hash_original_method = "C7E2B840B075445DC1033B130AB2E6A6", hash_generated_method = "8F7A043E5B0EA89ABE8DDD2F3E39E47F")
        public Entry<K, V> next() {
Entry<K, V> varDC8D7EA83135934E991F02D91E02BF6E_640364973 =             nextEntry();
            varDC8D7EA83135934E991F02D91E02BF6E_640364973.addTaint(taint);
            return varDC8D7EA83135934E991F02D91E02BF6E_640364973;
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private final class KeyEnumeration extends HashIterator implements Enumeration<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.601 -0400", hash_original_method = "2E46AFA79C505478BD5C8702CDCDD1D4", hash_generated_method = "2E46AFA79C505478BD5C8702CDCDD1D4")
        public KeyEnumeration ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.601 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "DF0D9536916DED8C9F81A1B8B8812274")
        public boolean hasMoreElements() {
            boolean varABBE3B24714136305D7430F5669CF141_1422682961 = (hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1503506577 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1503506577;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.601 -0400", hash_original_method = "BED82438F0CBBB90FF7803670DD55802", hash_generated_method = "559D7C269561BE91A02953579DB43621")
        public K nextElement() {
K var543B7F1D4AED8B3FA8DE77E5172AD0E2_8753133 =             nextEntryNotFailFast().key;
            var543B7F1D4AED8B3FA8DE77E5172AD0E2_8753133.addTaint(taint);
            return var543B7F1D4AED8B3FA8DE77E5172AD0E2_8753133;
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().key;
        }

        
    }


    
    private final class ValueEnumeration extends HashIterator implements Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.601 -0400", hash_original_method = "0C70885115EB664BF7ADABD8AB769AB3", hash_generated_method = "0C70885115EB664BF7ADABD8AB769AB3")
        public ValueEnumeration ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.602 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "041B34064E90F4E3DF25EB0840D380D7")
        public boolean hasMoreElements() {
            boolean varABBE3B24714136305D7430F5669CF141_1484757808 = (hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2109423644 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2109423644;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.602 -0400", hash_original_method = "433328C2A0882CA6574B6B21E730CA05", hash_generated_method = "2849E7EF84FCF09D3B7AC36B4CA9B578")
        public V nextElement() {
V var14E6AFDEC282DCCE83E189119A2AA690_742508979 =             nextEntryNotFailFast().value;
            var14E6AFDEC282DCCE83E189119A2AA690_742508979.addTaint(taint);
            return var14E6AFDEC282DCCE83E189119A2AA690_742508979;
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().value;
        }

        
    }


    
    private final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.602 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.602 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "70AD96009D4788B44E5D7D7737158835")
        public Iterator<K> iterator() {
Iterator<K> var3934136BB713579A43A8E8C1C3034CA0_1079390382 =             new KeyIterator();
            var3934136BB713579A43A8E8C1C3034CA0_1079390382.addTaint(taint);
            return var3934136BB713579A43A8E8C1C3034CA0_1079390382;
            // ---------- Original Method ----------
            //return new KeyIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.603 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "AAB917D4DB13CE595317E34CB4EBA11B")
        public int size() {
            int varB057BBA362E5B50E22D7AFEEF31086FA_380606755 = (Hashtable.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_264466451 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_264466451;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.603 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "B3910CC58E7B24CE4E38255C4A981CEC")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var6CE6D88A4041ABB2C763C00DFE3D40ED_1119963740 = (containsKey(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625019261 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_625019261;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.603 -0400", hash_original_method = "FF159DEBFD9D37DD2EC80383AA98B734", hash_generated_method = "AB498961830AB1AA2E173AE11B21EE5D")
        public boolean remove(Object o) {
            addTaint(o.getTaint());
            synchronized
(Hashtable.this)            {
                int oldSize = size;
                Hashtable.this.remove(o);
                boolean varF5DDED0F84B0A41C9923865D0C223F3C_1053182307 = (size != oldSize);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_100355069 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_100355069;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //int oldSize = size;
                //Hashtable.this.remove(o);
                //return size != oldSize;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.604 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.604 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "8C5EE6D2FF4FC671DEFA5E475A56F669")
        public boolean removeAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean varC59E950B034B0097B868C2C96544231D_1533954012 = (super.removeAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1830189564 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1830189564;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.604 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "9F2523179F673FF3F3C1E8E2EB0D48AE")
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var503FF497CC541185965B7F24CCB51DB8_1542003994 = (super.retainAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1594745513 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1594745513;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.605 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "105CB27784EA9A2498743933B8DCA111")
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var7D226F5CF447636EBAEB56D51C084B69_1259494906 = (super.containsAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_109382159 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_109382159;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.605 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "91277BD5630A924F1A43C1C0F6DC9B01")
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var75EAEC12DA10D524D5BB1C4333283B8A_656108455 = (super.equals(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_51587277 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_51587277;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.606 -0400", hash_original_method = "2EB37718E343BC9663B783B0FC3BE747", hash_generated_method = "3D7C44C445FDC17B4825BAB939B80484")
        public int hashCode() {
            synchronized
(Hashtable.this)            {
                int var805ED14872F1C08E5C4314680FD405F0_2076756346 = (super.hashCode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1824576629 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1824576629;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.hashCode();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.606 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "C1B64AA00A4440817880DB24024A3108")
        public String toString() {
            synchronized
(Hashtable.this)            {
String varD8287C6801A4C167675BF9EBA9EC2C1B_1565238821 =                 super.toString();
                varD8287C6801A4C167675BF9EBA9EC2C1B_1565238821.addTaint(taint);
                return varD8287C6801A4C167675BF9EBA9EC2C1B_1565238821;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.606 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "C24A5484062BBC89551598A04A4C128F")
        public Object[] toArray() {
            synchronized
(Hashtable.this)            {
Object[] var49FE09309552BE881763EA685A7D0CAF_188583588 =                 super.toArray();
                var49FE09309552BE881763EA685A7D0CAF_188583588.addTaint(taint);
                return var49FE09309552BE881763EA685A7D0CAF_188583588;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.607 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "01896FEBCCDFA16CBB1604F1C166DFE3")
        public <T> T[] toArray(T[] a) {
            addTaint(a[0].getTaint());
            synchronized
(Hashtable.this)            {
T[] var8B3B9EE2A35763F71C420B8875277B7C_1958037699 =                 super.toArray(a);
                var8B3B9EE2A35763F71C420B8875277B7C_1958037699.addTaint(taint);
                return var8B3B9EE2A35763F71C420B8875277B7C_1958037699;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.607 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.607 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "5F506FB260032B00DA17655A4C98C9BF")
        public Iterator<V> iterator() {
Iterator<V> varA5D0B7DD47403A81B3461DEE499DEE74_2112701170 =             new ValueIterator();
            varA5D0B7DD47403A81B3461DEE499DEE74_2112701170.addTaint(taint);
            return varA5D0B7DD47403A81B3461DEE499DEE74_2112701170;
            // ---------- Original Method ----------
            //return new ValueIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.608 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "CC095431FFB760361D04933874B38D6C")
        public int size() {
            int varB057BBA362E5B50E22D7AFEEF31086FA_723817576 = (Hashtable.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585467838 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585467838;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.608 -0400", hash_original_method = "C13053467D6FDF772DF450C87D40A3D5", hash_generated_method = "E2B6AF6947D6A742BBC9EFBD8BE5A07A")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var1B8C9A98435D2C268A243B67E80B7085_138130811 = (containsValue(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858817740 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858817740;
            // ---------- Original Method ----------
            //return containsValue(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.608 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.609 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "9E9B5F3E851AC38166FD31F343FFEB73")
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var7D226F5CF447636EBAEB56D51C084B69_1058503017 = (super.containsAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1365153788 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1365153788;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.609 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "0A3898F2B41BF4866F51FBDAD43DF2D6")
        public String toString() {
            synchronized
(Hashtable.this)            {
String varD8287C6801A4C167675BF9EBA9EC2C1B_301848934 =                 super.toString();
                varD8287C6801A4C167675BF9EBA9EC2C1B_301848934.addTaint(taint);
                return varD8287C6801A4C167675BF9EBA9EC2C1B_301848934;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.609 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "C8D57BF8DCAA23F66C4A45DEB1D8177C")
        public Object[] toArray() {
            synchronized
(Hashtable.this)            {
Object[] var49FE09309552BE881763EA685A7D0CAF_619446918 =                 super.toArray();
                var49FE09309552BE881763EA685A7D0CAF_619446918.addTaint(taint);
                return var49FE09309552BE881763EA685A7D0CAF_619446918;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.610 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "36ACC22F1C9025185C7131D7AC0F8DC4")
        public <T> T[] toArray(T[] a) {
            addTaint(a[0].getTaint());
            synchronized
(Hashtable.this)            {
T[] var8B3B9EE2A35763F71C420B8875277B7C_272513799 =                 super.toArray(a);
                var8B3B9EE2A35763F71C420B8875277B7C_272513799.addTaint(taint);
                return var8B3B9EE2A35763F71C420B8875277B7C_272513799;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.610 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.610 -0400", hash_original_method = "D7164BC97FFDCB587AB273006C953E50", hash_generated_method = "327BC9FC54F359E28150313A08106D5A")
        public Iterator<Entry<K, V>> iterator() {
Iterator<Entry<K, V>> varA27729B8E339A6F174B2D9A9BA7B896F_1042866050 =             new EntryIterator();
            varA27729B8E339A6F174B2D9A9BA7B896F_1042866050.addTaint(taint);
            return varA27729B8E339A6F174B2D9A9BA7B896F_1042866050;
            // ---------- Original Method ----------
            //return new EntryIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.611 -0400", hash_original_method = "6E695F138E29D844DC896198513B6135", hash_generated_method = "0A98804B884627858BF0D8351414D41F")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
    if(!(o instanceof Entry))            
            {
            boolean var68934A3E9455FA72420237EB05902327_1557592101 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_495535920 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_495535920;
            }
            Entry<?, ?> e = (Entry<?, ?>) o;
            boolean varBCB5439A3C90DA1EEC1D1019805D2AEB_1189105180 = (containsMapping(e.getKey(), e.getValue()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1771801429 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1771801429;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return containsMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.611 -0400", hash_original_method = "F484CBC8566C601718EDE0034034C7B3", hash_generated_method = "BF4E87C6F94271D8D2078BAA65CB657F")
        public boolean remove(Object o) {
            addTaint(o.getTaint());
    if(!(o instanceof Entry))            
            {
            boolean var68934A3E9455FA72420237EB05902327_1768816410 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_348917358 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_348917358;
            }
            Entry<?, ?> e = (Entry<?, ?>)o;
            boolean varC8B62CA77D8440BA8EB39DF9C30B611A_103815591 = (removeMapping(e.getKey(), e.getValue()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2132709175 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2132709175;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>)o;
            //return removeMapping(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.612 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "AD73550C57CE17B7DB0A4D4A340ACBA7")
        public int size() {
            int varB057BBA362E5B50E22D7AFEEF31086FA_1274506703 = (Hashtable.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283156788 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283156788;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.612 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.613 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "42FEB595DB4026FFF8AF21EA30CF25DD")
        public boolean removeAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean varC59E950B034B0097B868C2C96544231D_858666819 = (super.removeAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1395977222 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1395977222;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.614 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "68E4FF2EAC17DB9BA712F430D17E409D")
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var503FF497CC541185965B7F24CCB51DB8_401780520 = (super.retainAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1680782925 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1680782925;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.614 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "B6555DD3D39944F91BEF92AF1FC73A83")
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var7D226F5CF447636EBAEB56D51C084B69_1359685414 = (super.containsAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_210528957 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_210528957;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.615 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "04EAACC6EEDFAB87B6445E9CFB1C864B")
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var75EAEC12DA10D524D5BB1C4333283B8A_903734287 = (super.equals(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894280378 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_894280378;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.615 -0400", hash_original_method = "3000FE237E7845AEAFDA2B41B0704346", hash_generated_method = "273B8046870E34EC4B393D2307070B8F")
        public int hashCode() {
            int var40E5B040409EAFD396E30657035E9D74_1795905692 = (Hashtable.this.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_104438208 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_104438208;
            // ---------- Original Method ----------
            //return Hashtable.this.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.616 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "8A22485593BD1D5E9D424BDCA8564C69")
        public String toString() {
            synchronized
(Hashtable.this)            {
String varD8287C6801A4C167675BF9EBA9EC2C1B_1286760946 =                 super.toString();
                varD8287C6801A4C167675BF9EBA9EC2C1B_1286760946.addTaint(taint);
                return varD8287C6801A4C167675BF9EBA9EC2C1B_1286760946;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.616 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "2A7327EEF8FDC7EFCB8F201CB361D80B")
        public Object[] toArray() {
            synchronized
(Hashtable.this)            {
Object[] var49FE09309552BE881763EA685A7D0CAF_933561631 =                 super.toArray();
                var49FE09309552BE881763EA685A7D0CAF_933561631.addTaint(taint);
                return var49FE09309552BE881763EA685A7D0CAF_933561631;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.616 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "D5710FF3BA2DAD5D5F9429DE1E735431")
        public <T> T[] toArray(T[] a) {
            addTaint(a[0].getTaint());
            synchronized
(Hashtable.this)            {
T[] var8B3B9EE2A35763F71C420B8875277B7C_157326677 =                 super.toArray(a);
                var8B3B9EE2A35763F71C420B8875277B7C_157326677.addTaint(taint);
                return var8B3B9EE2A35763F71C420B8875277B7C_157326677;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.616 -0400", hash_original_field = "74773297EBE9767DD8F1E8A0F109042B", hash_generated_field = "2D66E915A2C4A5FBF28A99892F20B1AF")

    private static final int MINIMUM_CAPACITY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.617 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "C94813E6F46C48A83BBFCFA3C9862983")

    private static final int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.617 -0400", hash_original_field = "215B48891AB1D8DA059087E167B4E6A3", hash_generated_field = "BC3AFA3625EEAFE404B4E2EE0E75EE0F")

    private static final Entry[] EMPTY_TABLE = new HashtableEntry[MINIMUM_CAPACITY >>> 1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.617 -0400", hash_original_field = "2457D6689D4C035FB0208C51E3216836", hash_generated_field = "41B5CEA68D112450CD83A4199938FEF0")

    private static final float DEFAULT_LOAD_FACTOR = .75F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.617 -0400", hash_original_field = "C12E356D9C08DF40A0A68843ED778698", hash_generated_field = "46C6C9B52666C02F378F5368FD774F43")

    private static final int CHARS_PER_ENTRY = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.617 -0400", hash_original_field = "5908451E267AA95A476F28CC7A33B199", hash_generated_field = "C70DCA64D7F48D81CC1FCEA91128ADE1")

    private static final long serialVersionUID = 1421746759512286392L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.617 -0400", hash_original_field = "109308E5D4D5B0ADE2743F48081B723A", hash_generated_field = "BED226748EC460106938E3D870C7138F")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("threshold", int.class),
        new ObjectStreamField("loadFactor", float.class),
    };
}


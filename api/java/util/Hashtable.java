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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.341 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "19DEB795009FCB78D63A1C2C298CE954")

    private transient HashtableEntry<K, V>[] table;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.341 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "55DCA83C6162ACD637EB02860F7422EE")

    private transient int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.341 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "EDCBB672EA8C27007EA64BE3078BC69C")

    private transient int modCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.341 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "AC9BEC59E41404676A448C0DD2BB745B")

    private transient int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.341 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "EB6C570550CCFE8E5FEBB44BA37D02C0")

    private transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.341 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "BFDE585634496DDD7FBD15EDD2D3C5DD")

    private transient Set<Entry<K, V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.342 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "5A2A505CEEC79706812E901D735E2A7C")

    private transient Collection<V> values;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.342 -0400", hash_original_method = "9A93999031A29C4DD8DE295A6372F847", hash_generated_method = "6A7170C4C6FFAE127214BE36F7841D7F")
    @SuppressWarnings("unchecked")
    public  Hashtable() {
        table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1;
        // ---------- Original Method ----------
        //table = (HashtableEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.344 -0400", hash_original_method = "6003D4D798348C1583CB15DE42C187C6", hash_generated_method = "C0EB67B815B968B704ED802BE6142354")
    public  Hashtable(int capacity) {
        addTaint(capacity);
        if(capacity < 0)        
        {
            IllegalArgumentException varE68AB0C8AF29B541CCF795D60D7AEAE6_15963249 = new IllegalArgumentException("Capacity: " + capacity);
            varE68AB0C8AF29B541CCF795D60D7AEAE6_15963249.addTaint(taint);
            throw varE68AB0C8AF29B541CCF795D60D7AEAE6_15963249;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.346 -0400", hash_original_method = "5B6B569F078844A0FAD42909C56D1E6D", hash_generated_method = "91BC277383C1006AE68C521E66A2CAB0")
    public  Hashtable(int capacity, float loadFactor) {
        this(capacity);
        addTaint(loadFactor);
        addTaint(capacity);
        if(loadFactor <= 0 || Float.isNaN(loadFactor))        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.346 -0400", hash_original_method = "6950B91F5E6C68C49CB594AFD1673B84", hash_generated_method = "B59FAFD8CEADB25F80DD1853537DF4FA")
    public  Hashtable(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        addTaint(map.getTaint());
        constructorPutAll(map);
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.347 -0400", hash_original_method = "6631235722E4D3190E3529D2039DDD7A", hash_generated_method = "FE36B163F86E1A97E198B18AF38E1841")
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

    
    @DSModeled(DSC.SAFE)
    private static int capacityForInitSize(int size) {
        int result = (size >> 1) + size;
        return (result & ~(MAXIMUM_CAPACITY-1))==0 ? result : MAXIMUM_CAPACITY;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.350 -0400", hash_original_method = "F0D9AD485DB15C1D3427CA487C88BFBD", hash_generated_method = "2719F1581F628268F46DEDB5FC36FA11")
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
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_358918830 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_358918830.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_358918830;
        } //End block
        result.makeTable(table.length);
        result.size = 0;
        result.keySet = null;
        result.entrySet = null;
        result.values = null;
        result.constructorPutAll(this);
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1689619835 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1689619835.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1689619835;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.351 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "E4FDC859CC599DE6CCB373537967445A")
    public synchronized boolean isEmpty() {
        boolean var9FB8BC7F775DDD98EEAB5582D340229E_374193261 = (size == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_55795361 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_55795361;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.351 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "392CC05EF4F1B8CD4F26897A2D6FB092")
    public synchronized int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1150411265 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51627755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51627755;
        // ---------- Original Method ----------
        //return size;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.352 -0400", hash_original_method = "0D498A226869DEB0F3920DC31F67162F", hash_generated_method = "D037CE715676A07C60713D1D613B4CA4")
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
V var65D32B0ADAFF3F55986024909BAFC34B_2065572102 =                 e.value;
                var65D32B0ADAFF3F55986024909BAFC34B_2065572102.addTaint(taint);
                return var65D32B0ADAFF3F55986024909BAFC34B_2065572102;
            } //End block
        } //End block
V var540C13E9E156B687226421B24F2DF178_1858881389 =         null;
        var540C13E9E156B687226421B24F2DF178_1858881389.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1858881389;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.353 -0400", hash_original_method = "EDC536266386E3A88DC2FA7B05BC7882", hash_generated_method = "542F9EE3BA8B4E0B991426A62F884E03")
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
                boolean varB326B5062B2F0E69046810717534CB09_1409765900 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_864548667 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_864548667;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1453136652 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_828338057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_828338057;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.354 -0400", hash_original_method = "22B2A1F3D878FCC53A2BA6539B84615E", hash_generated_method = "4FDBB57EA40EF4A684F188E4E2C54B96")
    public synchronized boolean containsValue(Object value) {
        addTaint(value.getTaint());
        if(value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_512248220 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_512248220.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_512248220;
        } //End block
        HashtableEntry[] tab = table;
        int len = tab.length;
for(int i = 0;i < len;i++)
        {
for(HashtableEntry e = tab[i];e != null;e = e.next)
            {
                if(value.equals(e.value))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1744719399 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467711710 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467711710;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1433566931 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2050000783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2050000783;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.354 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "3A49322AA9ED5E55D08AD0F443327DB0")
    public boolean contains(Object value) {
        addTaint(value.getTaint());
        boolean varF98DD5D16840FDEEA577F8F359CCE837_991619915 = (containsValue(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535794413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535794413;
        // ---------- Original Method ----------
        //return containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.356 -0400", hash_original_method = "70A37B9812099DB6AA6597919714B995", hash_generated_method = "758D3CDC605A984AF4341EA96D3A0293")
    public synchronized V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        if(value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_609880649 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_609880649.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_609880649;
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
V var8CDBD2181CBEF5C2129AFFA68C014D4A_1031594385 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_1031594385.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_1031594385;
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
V var540C13E9E156B687226421B24F2DF178_315329797 =         null;
        var540C13E9E156B687226421B24F2DF178_315329797.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_315329797;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.357 -0400", hash_original_method = "DD29A5E73441E57ACE3C1AF694856AF1", hash_generated_method = "9BAFBDBE7A34744E3E336C425B295D08")
    private void constructorPut(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        if(value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_257453306 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_257453306.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_257453306;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.358 -0400", hash_original_method = "46C920EF16234ECC2EBDE62DDADD6435", hash_generated_method = "54874BF81DEC6C650960B5D6E3D4D392")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.359 -0400", hash_original_method = "5BCC94324BA2D5ECBED6314BEA7D0FA8", hash_generated_method = "B5A6383892470F6E1DB0E8EDE51B1B1C")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.360 -0400", hash_original_method = "CC28673E29B73787492CFDC805600F5D", hash_generated_method = "E3452D490AF44DF99FFD2B9DFC516DAB")
    protected void rehash() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.361 -0400", hash_original_method = "8FDFD015009EFB98FD90E5E66F0193AF", hash_generated_method = "F72AF6FB3A161451E105F898B8983180")
    private HashtableEntry<K, V>[] makeTable(int newCapacity) {
        @SuppressWarnings("unchecked") HashtableEntry<K, V>[] newTable = (HashtableEntry<K, V>[]) new HashtableEntry[newCapacity];
        table = newTable;
        threshold = (newCapacity >> 1) + (newCapacity >> 2);
HashtableEntry<K, V>[] varBBDF9FA229AA843E98D9C8441545D1D6_197798341 =         newTable;
        varBBDF9FA229AA843E98D9C8441545D1D6_197798341.addTaint(taint);
        return varBBDF9FA229AA843E98D9C8441545D1D6_197798341;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked") HashtableEntry<K, V>[] newTable
                //= (HashtableEntry<K, V>[]) new HashtableEntry[newCapacity];
        //table = newTable;
        //threshold = (newCapacity >> 1) + (newCapacity >> 2);
        //return newTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.364 -0400", hash_original_method = "291B56F25D1E56D0A03492C2073BE506", hash_generated_method = "98F5D500EA6AF953722E545D23C9DC83")
    private HashtableEntry<K, V>[] doubleCapacity() {
        HashtableEntry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;
        if(oldCapacity == MAXIMUM_CAPACITY)        
        {
HashtableEntry<K, V>[] var644E69580A9DE331964CDB2EEA8BEBA2_849895130 =             oldTable;
            var644E69580A9DE331964CDB2EEA8BEBA2_849895130.addTaint(taint);
            return var644E69580A9DE331964CDB2EEA8BEBA2_849895130;
        } //End block
        int newCapacity = oldCapacity * 2;
        HashtableEntry<K, V>[] newTable = makeTable(newCapacity);
        if(size == 0)        
        {
HashtableEntry<K, V>[] varBBDF9FA229AA843E98D9C8441545D1D6_828203952 =             newTable;
            varBBDF9FA229AA843E98D9C8441545D1D6_828203952.addTaint(taint);
            return varBBDF9FA229AA843E98D9C8441545D1D6_828203952;
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
HashtableEntry<K, V>[] varBBDF9FA229AA843E98D9C8441545D1D6_1213045010 =         newTable;
        varBBDF9FA229AA843E98D9C8441545D1D6_1213045010.addTaint(taint);
        return varBBDF9FA229AA843E98D9C8441545D1D6_1213045010;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.366 -0400", hash_original_method = "B19FA41811C96CC39A17F943778772D8", hash_generated_method = "80B04D515B1317EE61E1AAF9F5382248")
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
V var65D32B0ADAFF3F55986024909BAFC34B_1592031703 =                 e.value;
                var65D32B0ADAFF3F55986024909BAFC34B_1592031703.addTaint(taint);
                return var65D32B0ADAFF3F55986024909BAFC34B_1592031703;
            } //End block
        } //End block
V var540C13E9E156B687226421B24F2DF178_812101797 =         null;
        var540C13E9E156B687226421B24F2DF178_812101797.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_812101797;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.367 -0400", hash_original_method = "1C0D329A7E5E91219CE97B2AC82E739C", hash_generated_method = "45AD9C95CF6097B621C7C9B171BF463C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.367 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "0BF30D06B517FD8D8DA79FFC3A6A2F5C")
    public synchronized Set<K> keySet() {
        Set<K> ks = keySet;
Set<K> varB6853687BE649BA8B10F9701AD179BB7_757009538 =         (ks != null) ? ks : (keySet = new KeySet());
        varB6853687BE649BA8B10F9701AD179BB7_757009538.addTaint(taint);
        return varB6853687BE649BA8B10F9701AD179BB7_757009538;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.367 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "E59F3976A2B93651AD7EFEBF2CC2964C")
    public synchronized Collection<V> values() {
        Collection<V> vs = values;
Collection<V> var5CABA883D65798B391E2C02013734397_23688239 =         (vs != null) ? vs : (values = new Values());
        var5CABA883D65798B391E2C02013734397_23688239.addTaint(taint);
        return var5CABA883D65798B391E2C02013734397_23688239;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.368 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "CF6379F765767D007D563C4052D00846")
    public synchronized Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> es = entrySet;
Set<Entry<K, V>> var25D080FAAE722B04AA5C8EBDE33DD606_370579160 =         (es != null) ? es : (entrySet = new EntrySet());
        var25D080FAAE722B04AA5C8EBDE33DD606_370579160.addTaint(taint);
        return var25D080FAAE722B04AA5C8EBDE33DD606_370579160;
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.368 -0400", hash_original_method = "BD8590C2A6B44E1AD87F42CA1DDBEEC0", hash_generated_method = "8693180988660B3F37CDC637A13CD5A8")
    public synchronized Enumeration<K> keys() {
Enumeration<K> var72EDC079A47B19D9B47B38BBA00AF901_1738885427 =         new KeyEnumeration();
        var72EDC079A47B19D9B47B38BBA00AF901_1738885427.addTaint(taint);
        return var72EDC079A47B19D9B47B38BBA00AF901_1738885427;
        // ---------- Original Method ----------
        //return new KeyEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.368 -0400", hash_original_method = "D92B3AB4F78D152BCFDB4F438052384E", hash_generated_method = "3698A0D9DC498C7A503FBCDCEFC73B91")
    public synchronized Enumeration<V> elements() {
Enumeration<V> var3998A6162E9CBDC16A5D7E7745A926CC_955772035 =         new ValueEnumeration();
        var3998A6162E9CBDC16A5D7E7745A926CC_955772035.addTaint(taint);
        return var3998A6162E9CBDC16A5D7E7745A926CC_955772035;
        // ---------- Original Method ----------
        //return new ValueEnumeration();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.369 -0400", hash_original_method = "CF57466F07C2DB8AF5EFB522D22E3680", hash_generated_method = "871E41CFD4777EF0B724B8C5351615A3")
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
                boolean var9D13214451B619F7B04A75FF2E5FF359_433297057 = (e.value.equals(value));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_500120985 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_500120985;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1303279549 = (false);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.371 -0400", hash_original_method = "A191738781408606E816E9A37080097D", hash_generated_method = "D8F6E8E7E7FD3058625E314BE1505141")
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
                    boolean var68934A3E9455FA72420237EB05902327_1515054890 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_106015084 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_106015084;
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
                boolean varB326B5062B2F0E69046810717534CB09_1188939133 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2049830685 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2049830685;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_693806806 = (false);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.372 -0400", hash_original_method = "9BC17AC5DA957A9C0A07708C3D3A3E68", hash_generated_method = "F8B89AA5185BF6471795C144B2BC5C78")
    @Override
    public synchronized boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean var33DF79B9894C00BA5911C8933571E1E7_2019233544 = ((object instanceof Map) &&
                entrySet().equals(((Map<?, ?>)object).entrySet()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_984155201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_984155201;
        // ---------- Original Method ----------
        //return (object instanceof Map) &&
                //entrySet().equals(((Map<?, ?>)object).entrySet());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.373 -0400", hash_original_method = "0904BEF2CA25AF4229493E32A4F8928E", hash_generated_method = "86246877047D25E9EA99B529A94671D4")
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
        int varB4A88417B3D0170D754C647C30B7216A_11399535 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771963894 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771963894;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.374 -0400", hash_original_method = "A78197C1027A9ECA0DF472B01066EEE7", hash_generated_method = "B4802C5F5E1EC42704522B104481436F")
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
String varE65B3A02759122992CB82C0E651AD408_1054590055 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1054590055.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1054590055;
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

    
    @DSModeled(DSC.SAFE)
    private static int secondaryHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    
    @DSModeled(DSC.SAFE)
    private static int roundUpToPowerOfTwo(int i) {
        i--;
        i |= i >>>  1;
        i |= i >>>  2;
        i |= i >>>  4;
        i |= i >>>  8;
        i |= i >>> 16;
        return i + 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.376 -0400", hash_original_method = "19818AA4E6F1DBA67EBB75B368743917", hash_generated_method = "3F395FD92DFBACFB0EEEE0858BA58751")
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

    
        @DSModeled(DSC.SAFE)
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
            InvalidObjectException varE685AABC7A986A19539C13F2F8920021_1526559440 = new InvalidObjectException("Size: " + size);
            varE685AABC7A986A19539C13F2F8920021_1526559440.addTaint(taint);
            throw varE685AABC7A986A19539C13F2F8920021_1526559440;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.378 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.378 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.378 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.378 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A5AC9F76C2A7B9F6F79010A5F4A3B4B7")

        HashtableEntry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.379 -0400", hash_original_method = "FCC59894C2665A76D7100104D46402EE", hash_generated_method = "7F8F2DB59D28E587038E679033461007")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.379 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "BD4D92350B6011966540E076F0490311")
        public final K getKey() {
K var6A95247616A3A8B93CFF7783DABD08D4_703827325 =             key;
            var6A95247616A3A8B93CFF7783DABD08D4_703827325.addTaint(taint);
            return var6A95247616A3A8B93CFF7783DABD08D4_703827325;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.379 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "F87136309722E7FD4928B96FE5FFE787")
        public final V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_794323703 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_794323703.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_794323703;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.379 -0400", hash_original_method = "09EE506DF55191FF6B72960EEA25D181", hash_generated_method = "20A8E747CDE2C1F7C51185649D8EE3F7")
        public final V setValue(V value) {
            if(value == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_76334288 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_76334288.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_76334288;
            } //End block
            V oldValue = this.value;
            this.value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_217347115 =             oldValue;
            var8CDBD2181CBEF5C2129AFFA68C014D4A_217347115.addTaint(taint);
            return var8CDBD2181CBEF5C2129AFFA68C014D4A_217347115;
            // ---------- Original Method ----------
            //if (value == null) {
                //throw new NullPointerException();
            //}
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.379 -0400", hash_original_method = "509D67FA76563438156B3275F90914F5", hash_generated_method = "55CE6598374229A513037C8C4DE33F07")
        @Override
        public final boolean equals(Object o) {
            addTaint(o.getTaint());
            if(!(o instanceof Entry))            
            {
                boolean var68934A3E9455FA72420237EB05902327_404100882 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1774156781 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1774156781;
            } //End block
            Entry<?, ?> e = (Entry<?, ?>) o;
            boolean varBDE3EC6CCF05189A86D923F3FEC0BC60_2105746114 = (key.equals(e.getKey()) && value.equals(e.getValue()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_759856688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_759856688;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return key.equals(e.getKey()) && value.equals(e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.379 -0400", hash_original_method = "28D407F854479314A0A7C3BE1F12A9AB", hash_generated_method = "AC018EC09F0D9B3141ADCECE772D6E6B")
        @Override
        public final int hashCode() {
            int varD8C9F3525E899BE1FE8346EA0B439C65_1413540138 = (key.hashCode() ^ value.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907002219 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907002219;
            // ---------- Original Method ----------
            //return key.hashCode() ^ value.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.380 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "E8D8082AF044E0A670E7BBBA9D0F06E0")
        @Override
        public final String toString() {
String varFE698C13EFD83B87FAF2DC2AB0874271_632215990 =             key + "=" + value;
            varFE698C13EFD83B87FAF2DC2AB0874271_632215990.addTaint(taint);
            return varFE698C13EFD83B87FAF2DC2AB0874271_632215990;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
    }


    
    private abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.380 -0400", hash_original_field = "B6F75212F617C3E247C9474AFDA3B784", hash_generated_field = "04911A8A6B33F6D23811475122C95D0E")

        int nextIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.380 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "7A671A08D7EC5144843A6963DC69FDC7")

        HashtableEntry<K, V> nextEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.380 -0400", hash_original_field = "8A3A9937F6D0DA3448C9C061B347CECF", hash_generated_field = "7DA4F26BBE36FAFDC112AEE30391E8D1")

        HashtableEntry<K, V> lastEntryReturned;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.380 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "17128C49BCF19B4186F02F384F2DEA86")

        int expectedModCount = modCount;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.380 -0400", hash_original_method = "1BB35CB0E7E6DF7A5633A61B0F63C5AA", hash_generated_method = "1DEA380805BCD885E22B88C930E74A1E")
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.380 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "2A2F596DA7013C9731BB7754B4385F74")
        public boolean hasNext() {
            boolean var89CBB2F442CE6BC294273342C489EBAF_1700489096 = (nextEntry != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_578311394 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_578311394;
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.380 -0400", hash_original_method = "5FA6641462F5564CAC982C4AF6FCFB6C", hash_generated_method = "EA1FBE554BB593E298E0DEEBCE1CCB86")
         HashtableEntry<K, V> nextEntry() {
            if(modCount != expectedModCount)            
            {
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_694239968 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_694239968.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_694239968;
            }
            if(nextEntry == null)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_433334328 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_433334328.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_433334328;
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
HashtableEntry<K, V> var4D0F707C8B7B92ABA91FE6E8CAA540A2_1920240741 =             lastEntryReturned = entryToReturn;
            var4D0F707C8B7B92ABA91FE6E8CAA540A2_1920240741.addTaint(taint);
            return var4D0F707C8B7B92ABA91FE6E8CAA540A2_1920240741;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.381 -0400", hash_original_method = "1C3D72122BB58702CE822C81122C0D27", hash_generated_method = "8F4C848EA71064A576284FEB71341C76")
         HashtableEntry<K, V> nextEntryNotFailFast() {
            if(nextEntry == null)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_85874031 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_85874031.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_85874031;
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
HashtableEntry<K, V> var4D0F707C8B7B92ABA91FE6E8CAA540A2_1548100404 =             lastEntryReturned = entryToReturn;
            var4D0F707C8B7B92ABA91FE6E8CAA540A2_1548100404.addTaint(taint);
            return var4D0F707C8B7B92ABA91FE6E8CAA540A2_1548100404;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.381 -0400", hash_original_method = "342FDC52CA82B385D96AADB83EE8F936", hash_generated_method = "D2BCDF2DB83814E0AA801527863C1268")
        public void remove() {
            if(lastEntryReturned == null)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_91452271 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_91452271.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_91452271;
            }
            if(modCount != expectedModCount)            
            {
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_457523838 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_457523838.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_457523838;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.381 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.381 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "CE1CFCD4D1176F8177E5BBE2A246AA64")
        public K next() {
K varDFFFB017DDA62C15E8D1D49BA5F94802_1777265449 =             nextEntry().key;
            varDFFFB017DDA62C15E8D1D49BA5F94802_1777265449.addTaint(taint);
            return varDFFFB017DDA62C15E8D1D49BA5F94802_1777265449;
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends HashIterator implements Iterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.381 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.381 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "AE17D2C49E58C714A22741DDE4B7390E")
        public V next() {
V var57B066C0B962D4E7D7CC8F9272046644_572177911 =             nextEntry().value;
            var57B066C0B962D4E7D7CC8F9272046644_572177911.addTaint(taint);
            return var57B066C0B962D4E7D7CC8F9272046644_572177911;
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.381 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.382 -0400", hash_original_method = "C7E2B840B075445DC1033B130AB2E6A6", hash_generated_method = "07AFD30287B4D7E2661B5B329027D44D")
        public Entry<K, V> next() {
Entry<K, V> varDC8D7EA83135934E991F02D91E02BF6E_2040329618 =             nextEntry();
            varDC8D7EA83135934E991F02D91E02BF6E_2040329618.addTaint(taint);
            return varDC8D7EA83135934E991F02D91E02BF6E_2040329618;
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private final class KeyEnumeration extends HashIterator implements Enumeration<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.382 -0400", hash_original_method = "2E46AFA79C505478BD5C8702CDCDD1D4", hash_generated_method = "2E46AFA79C505478BD5C8702CDCDD1D4")
        public KeyEnumeration ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.382 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "F25CF839E6695BDA8815CF7F1F79192C")
        public boolean hasMoreElements() {
            boolean varABBE3B24714136305D7430F5669CF141_200900921 = (hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1227463954 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1227463954;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.382 -0400", hash_original_method = "BED82438F0CBBB90FF7803670DD55802", hash_generated_method = "67C27AC9DDEC7D48BCCFFA0021372CB9")
        public K nextElement() {
K var543B7F1D4AED8B3FA8DE77E5172AD0E2_1508036540 =             nextEntryNotFailFast().key;
            var543B7F1D4AED8B3FA8DE77E5172AD0E2_1508036540.addTaint(taint);
            return var543B7F1D4AED8B3FA8DE77E5172AD0E2_1508036540;
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().key;
        }

        
    }


    
    private final class ValueEnumeration extends HashIterator implements Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.382 -0400", hash_original_method = "0C70885115EB664BF7ADABD8AB769AB3", hash_generated_method = "0C70885115EB664BF7ADABD8AB769AB3")
        public ValueEnumeration ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.382 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "F6D1E2B220D652B152911471E765021E")
        public boolean hasMoreElements() {
            boolean varABBE3B24714136305D7430F5669CF141_1878264784 = (hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1442291361 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1442291361;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.382 -0400", hash_original_method = "433328C2A0882CA6574B6B21E730CA05", hash_generated_method = "55BCE922394F1A4B7F5085959C3D04BC")
        public V nextElement() {
V var14E6AFDEC282DCCE83E189119A2AA690_1611441041 =             nextEntryNotFailFast().value;
            var14E6AFDEC282DCCE83E189119A2AA690_1611441041.addTaint(taint);
            return var14E6AFDEC282DCCE83E189119A2AA690_1611441041;
            // ---------- Original Method ----------
            //return nextEntryNotFailFast().value;
        }

        
    }


    
    private final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.382 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.382 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "54C1351229B65A96444ACDE3DB47D549")
        public Iterator<K> iterator() {
Iterator<K> var3934136BB713579A43A8E8C1C3034CA0_543747246 =             new KeyIterator();
            var3934136BB713579A43A8E8C1C3034CA0_543747246.addTaint(taint);
            return var3934136BB713579A43A8E8C1C3034CA0_543747246;
            // ---------- Original Method ----------
            //return new KeyIterator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.383 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "A90CEAB1135CBC4A2744141B82421E72")
        public int size() {
            int varB057BBA362E5B50E22D7AFEEF31086FA_1008002683 = (Hashtable.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93272775 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93272775;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.383 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "E7F85B13C9B631BAF0D6746625CE9B19")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var6CE6D88A4041ABB2C763C00DFE3D40ED_281813991 = (containsKey(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_609041190 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_609041190;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.383 -0400", hash_original_method = "FF159DEBFD9D37DD2EC80383AA98B734", hash_generated_method = "74319557D303A001CC4A0A9DD4E562E9")
        public boolean remove(Object o) {
            addTaint(o.getTaint());
            synchronized
(Hashtable.this)            {
                int oldSize = size;
                Hashtable.this.remove(o);
                boolean varF5DDED0F84B0A41C9923865D0C223F3C_912937 = (size != oldSize);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1572246268 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1572246268;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //int oldSize = size;
                //Hashtable.this.remove(o);
                //return size != oldSize;
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.384 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.384 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "1B7B9DB812B054A8828F13343137BA99")
        public boolean removeAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean varC59E950B034B0097B868C2C96544231D_1649059546 = (super.removeAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28354259 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_28354259;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.384 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "42BADEBA6CFC8671E154DE741FA268EF")
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var503FF497CC541185965B7F24CCB51DB8_742471732 = (super.retainAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7653963 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_7653963;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.384 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "777E3415459B4A65531FDB538132AE58")
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var7D226F5CF447636EBAEB56D51C084B69_1620468316 = (super.containsAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1749282032 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1749282032;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.384 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "D80945361DCBE8BBAE923727F01EBD8C")
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var75EAEC12DA10D524D5BB1C4333283B8A_187265343 = (super.equals(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2085274366 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2085274366;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.384 -0400", hash_original_method = "2EB37718E343BC9663B783B0FC3BE747", hash_generated_method = "8F415165C03BE8EC0ED87BB13E531112")
        public int hashCode() {
            synchronized
(Hashtable.this)            {
                int var805ED14872F1C08E5C4314680FD405F0_1154349369 = (super.hashCode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165360478 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165360478;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.hashCode();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.384 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "1F98C31A4759B41261EADFC015508419")
        public String toString() {
            synchronized
(Hashtable.this)            {
String varD8287C6801A4C167675BF9EBA9EC2C1B_1404482196 =                 super.toString();
                varD8287C6801A4C167675BF9EBA9EC2C1B_1404482196.addTaint(taint);
                return varD8287C6801A4C167675BF9EBA9EC2C1B_1404482196;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.384 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "BFFD389AC1C0053AFA4238D53AB79887")
        public Object[] toArray() {
            synchronized
(Hashtable.this)            {
Object[] var49FE09309552BE881763EA685A7D0CAF_2006455332 =                 super.toArray();
                var49FE09309552BE881763EA685A7D0CAF_2006455332.addTaint(taint);
                return var49FE09309552BE881763EA685A7D0CAF_2006455332;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.385 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "5AB2165F1411D6C9E5B8E179FCFAE181")
        public <T> T[] toArray(T[] a) {
            addTaint(a[0].getTaint());
            synchronized
(Hashtable.this)            {
T[] var8B3B9EE2A35763F71C420B8875277B7C_1159667460 =                 super.toArray(a);
                var8B3B9EE2A35763F71C420B8875277B7C_1159667460.addTaint(taint);
                return var8B3B9EE2A35763F71C420B8875277B7C_1159667460;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.385 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.385 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "33F722CFE951C1E2FCFEE4BDF9FF729F")
        public Iterator<V> iterator() {
Iterator<V> varA5D0B7DD47403A81B3461DEE499DEE74_1517288867 =             new ValueIterator();
            varA5D0B7DD47403A81B3461DEE499DEE74_1517288867.addTaint(taint);
            return varA5D0B7DD47403A81B3461DEE499DEE74_1517288867;
            // ---------- Original Method ----------
            //return new ValueIterator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.385 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "44A92FBEFED209436D5516751E37879C")
        public int size() {
            int varB057BBA362E5B50E22D7AFEEF31086FA_256166506 = (Hashtable.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939773621 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939773621;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.385 -0400", hash_original_method = "C13053467D6FDF772DF450C87D40A3D5", hash_generated_method = "67C0FFFD0D8E50693AC288D9AC915B3E")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var1B8C9A98435D2C268A243B67E80B7085_1460407082 = (containsValue(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1458070309 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1458070309;
            // ---------- Original Method ----------
            //return containsValue(o);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.385 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.386 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "878C640A1738B85EA6DD4F625EE7084B")
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var7D226F5CF447636EBAEB56D51C084B69_419371389 = (super.containsAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1939389438 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1939389438;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.386 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "C92A0BB820BE7A71DB98272C8BCC7247")
        public String toString() {
            synchronized
(Hashtable.this)            {
String varD8287C6801A4C167675BF9EBA9EC2C1B_1628424165 =                 super.toString();
                varD8287C6801A4C167675BF9EBA9EC2C1B_1628424165.addTaint(taint);
                return varD8287C6801A4C167675BF9EBA9EC2C1B_1628424165;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.386 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "D59883B6ACE7BC7C42C90EF33D58AC07")
        public Object[] toArray() {
            synchronized
(Hashtable.this)            {
Object[] var49FE09309552BE881763EA685A7D0CAF_548536560 =                 super.toArray();
                var49FE09309552BE881763EA685A7D0CAF_548536560.addTaint(taint);
                return var49FE09309552BE881763EA685A7D0CAF_548536560;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.386 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "8BE429AE68EA2C6F8E2759C3590E22A0")
        public <T> T[] toArray(T[] a) {
            addTaint(a[0].getTaint());
            synchronized
(Hashtable.this)            {
T[] var8B3B9EE2A35763F71C420B8875277B7C_1513763010 =                 super.toArray(a);
                var8B3B9EE2A35763F71C420B8875277B7C_1513763010.addTaint(taint);
                return var8B3B9EE2A35763F71C420B8875277B7C_1513763010;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    private final class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.387 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.387 -0400", hash_original_method = "D7164BC97FFDCB587AB273006C953E50", hash_generated_method = "60E02584A3D445DC5936F712B55DE26F")
        public Iterator<Entry<K, V>> iterator() {
Iterator<Entry<K, V>> varA27729B8E339A6F174B2D9A9BA7B896F_1398284402 =             new EntryIterator();
            varA27729B8E339A6F174B2D9A9BA7B896F_1398284402.addTaint(taint);
            return varA27729B8E339A6F174B2D9A9BA7B896F_1398284402;
            // ---------- Original Method ----------
            //return new EntryIterator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.387 -0400", hash_original_method = "6E695F138E29D844DC896198513B6135", hash_generated_method = "0CE2DF8810148B7CCE434000EAC03172")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            if(!(o instanceof Entry))            
            {
            boolean var68934A3E9455FA72420237EB05902327_1711041458 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683010765 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683010765;
            }
            Entry<?, ?> e = (Entry<?, ?>) o;
            boolean varBCB5439A3C90DA1EEC1D1019805D2AEB_1732426879 = (containsMapping(e.getKey(), e.getValue()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312547563 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312547563;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return containsMapping(e.getKey(), e.getValue());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.387 -0400", hash_original_method = "F484CBC8566C601718EDE0034034C7B3", hash_generated_method = "5E811336DE34EA1A2E3C4BF087460B28")
        public boolean remove(Object o) {
            addTaint(o.getTaint());
            if(!(o instanceof Entry))            
            {
            boolean var68934A3E9455FA72420237EB05902327_2065748818 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1765751257 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1765751257;
            }
            Entry<?, ?> e = (Entry<?, ?>)o;
            boolean varC8B62CA77D8440BA8EB39DF9C30B611A_171307385 = (removeMapping(e.getKey(), e.getValue()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1669437001 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1669437001;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>)o;
            //return removeMapping(e.getKey(), e.getValue());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.387 -0400", hash_original_method = "4D94E1187CEF061AFF285C9B88148BEA", hash_generated_method = "1561B84413FA2C7C3E8649D851A75CE4")
        public int size() {
            int varB057BBA362E5B50E22D7AFEEF31086FA_567119153 = (Hashtable.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2144581102 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2144581102;
            // ---------- Original Method ----------
            //return Hashtable.this.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.387 -0400", hash_original_method = "AE02AA469A4E8570D154A10ABA31B821", hash_generated_method = "F532431CEF2368433A5DB4F8A6DBCD80")
        public void clear() {
            Hashtable.this.clear();
            // ---------- Original Method ----------
            //Hashtable.this.clear();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.387 -0400", hash_original_method = "9BA117A8F63C9FFDE2D5EA1FE72298AB", hash_generated_method = "34E33CA006B3DAB7330E143D24BC5807")
        public boolean removeAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean varC59E950B034B0097B868C2C96544231D_924167398 = (super.removeAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_881618645 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_881618645;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.removeAll(collection);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.387 -0400", hash_original_method = "F51EE2CE89398EE7EFBA716BFF5B2C29", hash_generated_method = "2242403085D684A2C3D6E82E2546AFBD")
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var503FF497CC541185965B7F24CCB51DB8_1617180345 = (super.retainAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1833981762 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1833981762;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.retainAll(collection);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_method = "16251063ADEDD8E4E0F4377C58C438F7", hash_generated_method = "CF383635141B6530D7EEA24B6824D44E")
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var7D226F5CF447636EBAEB56D51C084B69_339867193 = (super.containsAll(collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177822841 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177822841;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.containsAll(collection);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_method = "806262E7A3C64BA287E3756348FCDE7E", hash_generated_method = "BBF17A28D08B599CBC6DAFB5C57B3C05")
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            synchronized
(Hashtable.this)            {
                boolean var75EAEC12DA10D524D5BB1C4333283B8A_910506629 = (super.equals(object));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_282644288 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_282644288;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.equals(object);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_method = "3000FE237E7845AEAFDA2B41B0704346", hash_generated_method = "D6AB1E0F56689E099BA5C3C35801C41E")
        public int hashCode() {
            int var40E5B040409EAFD396E30657035E9D74_795726471 = (Hashtable.this.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273400572 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273400572;
            // ---------- Original Method ----------
            //return Hashtable.this.hashCode();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_method = "41533210C6AD9564260587928C07D199", hash_generated_method = "B2A24F80DA80A4F20BC940A1754ED096")
        public String toString() {
            synchronized
(Hashtable.this)            {
String varD8287C6801A4C167675BF9EBA9EC2C1B_2137351959 =                 super.toString();
                varD8287C6801A4C167675BF9EBA9EC2C1B_2137351959.addTaint(taint);
                return varD8287C6801A4C167675BF9EBA9EC2C1B_2137351959;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toString();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_method = "2DE6CB7DA73A7C633D03F26162BE3C9B", hash_generated_method = "53CB2BC1DDE51D3D8D076894BA2A16E8")
        public Object[] toArray() {
            synchronized
(Hashtable.this)            {
Object[] var49FE09309552BE881763EA685A7D0CAF_1220440272 =                 super.toArray();
                var49FE09309552BE881763EA685A7D0CAF_1220440272.addTaint(taint);
                return var49FE09309552BE881763EA685A7D0CAF_1220440272;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_method = "9FE9B3BD459851B05CC02013C00F3ABD", hash_generated_method = "0171E69715B8449143910654CCDBA8BD")
        public <T> T[] toArray(T[] a) {
            addTaint(a[0].getTaint());
            synchronized
(Hashtable.this)            {
T[] var8B3B9EE2A35763F71C420B8875277B7C_1268229516 =                 super.toArray(a);
                var8B3B9EE2A35763F71C420B8875277B7C_1268229516.addTaint(taint);
                return var8B3B9EE2A35763F71C420B8875277B7C_1268229516;
            } //End block
            // ---------- Original Method ----------
            //synchronized (Hashtable.this) {
                //return super.toArray(a);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_field = "74773297EBE9767DD8F1E8A0F109042B", hash_generated_field = "2D66E915A2C4A5FBF28A99892F20B1AF")

    private static final int MINIMUM_CAPACITY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "C94813E6F46C48A83BBFCFA3C9862983")

    private static final int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_field = "215B48891AB1D8DA059087E167B4E6A3", hash_generated_field = "BC3AFA3625EEAFE404B4E2EE0E75EE0F")

    private static final Entry[] EMPTY_TABLE = new HashtableEntry[MINIMUM_CAPACITY >>> 1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_field = "2457D6689D4C035FB0208C51E3216836", hash_generated_field = "41B5CEA68D112450CD83A4199938FEF0")

    private static final float DEFAULT_LOAD_FACTOR = .75F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_field = "C12E356D9C08DF40A0A68843ED778698", hash_generated_field = "46C6C9B52666C02F378F5368FD774F43")

    private static final int CHARS_PER_ENTRY = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_field = "5908451E267AA95A476F28CC7A33B199", hash_generated_field = "C70DCA64D7F48D81CC1FCEA91128ADE1")

    private static final long serialVersionUID = 1421746759512286392L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.388 -0400", hash_original_field = "109308E5D4D5B0ADE2743F48081B723A", hash_generated_field = "BED226748EC460106938E3D870C7138F")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("threshold", int.class),
        new ObjectStreamField("loadFactor", float.class),
    };
}


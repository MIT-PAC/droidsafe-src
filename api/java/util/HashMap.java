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
import libcore.util.Objects;

public class HashMap<K, V> extends AbstractMap<K, V> implements Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.962 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "5BCDF9B3CCDE8C26B422211A63786F6F")

    transient HashMapEntry<K, V>[] table;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.962 -0400", hash_original_field = "789DFF82296D9E921000DB270879418B", hash_generated_field = "001B08BF95F5AEB6F938F9E6275C3105")

    transient HashMapEntry<K, V> entryForNullKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.962 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "7BEABDDA8AE5EA70226B47F806396840")

    transient int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.962 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "66B0BB3B51ED8DFDAEFDC2833CA7C4AB")

    transient int modCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.962 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "AC9BEC59E41404676A448C0DD2BB745B")

    private transient int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.962 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "EB6C570550CCFE8E5FEBB44BA37D02C0")

    private transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.962 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "BFDE585634496DDD7FBD15EDD2D3C5DD")

    private transient Set<Entry<K, V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.962 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "5A2A505CEEC79706812E901D735E2A7C")

    private transient Collection<V> values;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.963 -0400", hash_original_method = "67F8ADB6599C3AA95FA8DFFD843377DD", hash_generated_method = "7409D258B8D042741B25C0440FA51BF9")
    @SuppressWarnings("unchecked")
    public  HashMap() {
        table = (HashMapEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1;
        // ---------- Original Method ----------
        //table = (HashMapEntry<K, V>[]) EMPTY_TABLE;
        //threshold = -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.970 -0400", hash_original_method = "DBEA46BF5DB352E6536C06B54FDF6C1E", hash_generated_method = "7FE94A00763E7E488D81DCDBEADA9FA8")
    public  HashMap(int capacity) {
        addTaint(capacity);
        if(capacity < 0)        
        {
            IllegalArgumentException varE68AB0C8AF29B541CCF795D60D7AEAE6_237232596 = new IllegalArgumentException("Capacity: " + capacity);
            varE68AB0C8AF29B541CCF795D60D7AEAE6_237232596.addTaint(taint);
            throw varE68AB0C8AF29B541CCF795D60D7AEAE6_237232596;
        } //End block
        if(capacity == 0)        
        {
            @SuppressWarnings("unchecked") HashMapEntry<K, V>[] tab = (HashMapEntry<K, V>[]) EMPTY_TABLE;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.971 -0400", hash_original_method = "ED265422F07438826BD7CEB727CA13DA", hash_generated_method = "47E72622CE8AEA9D8C4C87DE9ACF34E7")
    public  HashMap(int capacity, float loadFactor) {
        this(capacity);
        addTaint(loadFactor);
        addTaint(capacity);
        if(loadFactor <= 0 || Float.isNaN(loadFactor))        
        {
            IllegalArgumentException var5B3332F9036D49CF8BF1BBF51FC6B72E_2053821357 = new IllegalArgumentException("Load factor: " + loadFactor);
            var5B3332F9036D49CF8BF1BBF51FC6B72E_2053821357.addTaint(taint);
            throw var5B3332F9036D49CF8BF1BBF51FC6B72E_2053821357;
        } //End block
        // ---------- Original Method ----------
        //if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            //throw new IllegalArgumentException("Load factor: " + loadFactor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.971 -0400", hash_original_method = "D988B3BE94D6CE1D83E9BB54AA86E55F", hash_generated_method = "D8E5CB87B1CD6B8482A863452313CF44")
    public  HashMap(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        addTaint(map.getTaint());
        constructorPutAll(map);
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.971 -0400", hash_original_method = "6631235722E4D3190E3529D2039DDD7A", hash_generated_method = "8D7F5D032E30466EC3C57C24156A7447")
    final void constructorPutAll(Map<? extends K, ? extends V> map) {
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
    static int capacityForInitSize(int size) {
        int result = (size >> 1) + size;
        return (result & ~(MAXIMUM_CAPACITY-1))==0 ? result : MAXIMUM_CAPACITY;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.971 -0400", hash_original_method = "C555E25CE67FE12926CA5480B863847E", hash_generated_method = "4A44D89334A62F71EC7507883AA9B14C")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        HashMap<K, V> result;
        try 
        {
            result = (HashMap<K, V>) super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1421621907 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1421621907.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1421621907;
        } //End block
        result.makeTable(table.length);
        result.entryForNullKey = null;
        result.size = 0;
        result.keySet = null;
        result.entrySet = null;
        result.values = null;
        result.init();
        result.constructorPutAll(this);
Object varDC838461EE2FA0CA4C9BBB70A15456B0_649335864 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_649335864.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_649335864;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.971 -0400", hash_original_method = "417EF77086319CE91314CCF850ADA61E", hash_generated_method = "2067003B6622767497B839D408201FF1")
     void init() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.971 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "52BB03CA3062B96B919C127580AD78D2")
    @Override
    public boolean isEmpty() {
        boolean var9FB8BC7F775DDD98EEAB5582D340229E_1243866766 = (size == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1331077368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1331077368;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.971 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "D38E40A4B000AC4B4BF2CFF3964637FF")
    @Override
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_819909038 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_270183978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_270183978;
        // ---------- Original Method ----------
        //return size;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.972 -0400", hash_original_method = "D55BBCD9F0C6BD0BD798F81C2A3EFECD", hash_generated_method = "01147977E5FD26B41435E65E757134BC")
    public V get(Object key) {
        addTaint(key.getTaint());
        if(key == null)        
        {
            HashMapEntry<K, V> e = entryForNullKey;
V var78AF416712B960DDFC22256875A90AD3_1251468293 =             e == null ? null : e.value;
            var78AF416712B960DDFC22256875A90AD3_1251468293.addTaint(taint);
            return var78AF416712B960DDFC22256875A90AD3_1251468293;
        } //End block
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashMapEntry<K, V>[] tab = table;
for(HashMapEntry<K, V> e = tab[hash & (tab.length - 1)];e != null;e = e.next)
        {
            K eKey = e.key;
            if(eKey == key || (e.hash == hash && key.equals(eKey)))            
            {
V var65D32B0ADAFF3F55986024909BAFC34B_1128366113 =                 e.value;
                var65D32B0ADAFF3F55986024909BAFC34B_1128366113.addTaint(taint);
                return var65D32B0ADAFF3F55986024909BAFC34B_1128366113;
            } //End block
        } //End block
V var540C13E9E156B687226421B24F2DF178_2061252436 =         null;
        var540C13E9E156B687226421B24F2DF178_2061252436.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2061252436;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.972 -0400", hash_original_method = "664DBEAFB6D0F34975160DBB887BD5CA", hash_generated_method = "CDC88F23C90EA8F61CB7D9E54E05ACE8")
    @Override
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
        if(key == null)        
        {
            boolean varF21C562BE459533EEFBE06DDE1004600_1675929150 = (entryForNullKey != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_293618733 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_293618733;
        } //End block
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashMapEntry<K, V>[] tab = table;
for(HashMapEntry<K, V> e = tab[hash & (tab.length - 1)];e != null;e = e.next)
        {
            K eKey = e.key;
            if(eKey == key || (e.hash == hash && key.equals(eKey)))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1356159595 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_929563561 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_929563561;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2074752139 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_823959073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_823959073;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.972 -0400", hash_original_method = "8A9DFD8A0E528EE1DFDA14FDA5F2B177", hash_generated_method = "915DF5C796CBDC10C8270C0B63D0EEED")
    @Override
    public boolean containsValue(Object value) {
        addTaint(value.getTaint());
        HashMapEntry[] tab = table;
        int len = tab.length;
        if(value == null)        
        {
for(int i = 0;i < len;i++)
            {
for(HashMapEntry e = tab[i];e != null;e = e.next)
                {
                    if(e.value == null)                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_1234089697 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1119118612 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1119118612;
                    } //End block
                } //End block
            } //End block
            boolean varBED79A40078FAB4BD9A2B4CB0127BB45_1182608597 = (entryForNullKey != null && entryForNullKey.value == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1971596 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1971596;
        } //End block
for(int i = 0;i < len;i++)
        {
for(HashMapEntry e = tab[i];e != null;e = e.next)
            {
                if(value.equals(e.value))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_966449978 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772332674 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_772332674;
                } //End block
            } //End block
        } //End block
        boolean var61B0A99FE77B255BC00677C823E02ED8_1567015194 = (entryForNullKey != null && value.equals(entryForNullKey.value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1457929116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1457929116;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.973 -0400", hash_original_method = "5BBA395276A0B9AAD236878C1432D189", hash_generated_method = "3E3623857B8FD3C9706EA7D03E1970EB")
    @Override
    public V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        if(key == null)        
        {
V var1511B2704E8FA27130A4520ED7054286_2011841802 =             putValueForNullKey(value);
            var1511B2704E8FA27130A4520ED7054286_2011841802.addTaint(taint);
            return var1511B2704E8FA27130A4520ED7054286_2011841802;
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
for(HashMapEntry<K, V> e = tab[index];e != null;e = e.next)
        {
            if(e.hash == hash && key.equals(e.key))            
            {
                preModify(e);
                V oldValue = e.value;
                e.value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_1250991426 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_1250991426.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_1250991426;
            } //End block
        } //End block
        modCount++;
        if(size++ > threshold)        
        {
            tab = doubleCapacity();
            index = hash & (tab.length - 1);
        } //End block
        addNewEntry(key, value, hash, index);
V var540C13E9E156B687226421B24F2DF178_1149995742 =         null;
        var540C13E9E156B687226421B24F2DF178_1149995742.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1149995742;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.973 -0400", hash_original_method = "23837E71B15780DD12C36C21FB15F598", hash_generated_method = "C216BF2169AA7B12DC38EC472391C3C8")
    private V putValueForNullKey(V value) {
        addTaint(value.getTaint());
        HashMapEntry<K, V> entry = entryForNullKey;
        if(entry == null)        
        {
            addNewEntryForNullKey(value);
            size++;
            modCount++;
V var540C13E9E156B687226421B24F2DF178_107923857 =             null;
            var540C13E9E156B687226421B24F2DF178_107923857.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_107923857;
        } //End block
        else
        {
            preModify(entry);
            V oldValue = entry.value;
            entry.value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_256910460 =             oldValue;
            var8CDBD2181CBEF5C2129AFFA68C014D4A_256910460.addTaint(taint);
            return var8CDBD2181CBEF5C2129AFFA68C014D4A_256910460;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.973 -0400", hash_original_method = "DFE0557B59605BA6C5CD9DE7502DD68F", hash_generated_method = "8E8423E144F06F950B93A82209065B3F")
     void preModify(HashMapEntry<K, V> e) {
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.973 -0400", hash_original_method = "627029122DE3FFF8BEA7942964D9C227", hash_generated_method = "FFCD2A7B00EA12A81DBAC227091AE54B")
    private void constructorPut(K key, V value) {
        addTaint(key.getTaint());
        if(key == null)        
        {
            HashMapEntry<K, V> entry = entryForNullKey;
            if(entry == null)            
            {
                entryForNullKey = constructorNewEntry(null, value, 0, null);
                size++;
            } //End block
            else
            {
                entry.value = value;
            } //End block
            return;
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
        HashMapEntry<K, V> first = tab[index];
for(HashMapEntry<K, V> e = first;e != null;e = e.next)
        {
            if(e.hash == hash && key.equals(e.key))            
            {
                e.value = value;
                return;
            } //End block
        } //End block
        tab[index] = constructorNewEntry(key, value, hash, first);
        size++;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.974 -0400", hash_original_method = "6DFE8ABD0EB0EC55F81B8127E2FB540C", hash_generated_method = "453D2264FFA6453AAFEB1CBBCCBC261D")
     void addNewEntry(K key, V value, int hash, int index) {
        table[index] = new HashMapEntry<K, V>(key, value, hash, table[index]);
        // ---------- Original Method ----------
        //table[index] = new HashMapEntry<K, V>(key, value, hash, table[index]);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.974 -0400", hash_original_method = "1A0C0EFFA3B59B8426ED7AB00D5D7C14", hash_generated_method = "0ED80084966D32973E9213641BE7C311")
     void addNewEntryForNullKey(V value) {
        entryForNullKey = new HashMapEntry<K, V>(null, value, 0, null);
        // ---------- Original Method ----------
        //entryForNullKey = new HashMapEntry<K, V>(null, value, 0, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.974 -0400", hash_original_method = "08952C170F8B11733B904F0E99F6B0F5", hash_generated_method = "DEC317236C208A85D0616DEA0FA87B6C")
     HashMapEntry<K, V> constructorNewEntry(
            K key, V value, int hash, HashMapEntry<K, V> first) {
        addTaint(first.getTaint());
        addTaint(hash);
        addTaint(value.getTaint());
        addTaint(key.getTaint());
HashMapEntry<K, V> var32D4351C727AE69E15ACD6733FAC472C_991963906 =         new HashMapEntry<K, V>(key, value, hash, first);
        var32D4351C727AE69E15ACD6733FAC472C_991963906.addTaint(taint);
        return var32D4351C727AE69E15ACD6733FAC472C_991963906;
        // ---------- Original Method ----------
        //return new HashMapEntry<K, V>(key, value, hash, first);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.974 -0400", hash_original_method = "A51614C8AB5E8271029690D5F9184632", hash_generated_method = "6D77BC3BC87ED2E7901FAB9074E6E697")
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        addTaint(map.getTaint());
        ensureCapacity(map.size());
        super.putAll(map);
        // ---------- Original Method ----------
        //ensureCapacity(map.size());
        //super.putAll(map);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.974 -0400", hash_original_method = "4BE6F38D6656B87B29773B0AAEA75993", hash_generated_method = "BA99B5709024C608E4A1123BBC665ACB")
    private void ensureCapacity(int numMappings) {
        addTaint(numMappings);
        int newCapacity = roundUpToPowerOfTwo(capacityForInitSize(numMappings));
        HashMapEntry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;
        if(newCapacity <= oldCapacity)        
        {
            return;
        } //End block
        if(newCapacity == oldCapacity * 2)        
        {
            doubleCapacity();
            return;
        } //End block
        HashMapEntry<K, V>[] newTable = makeTable(newCapacity);
        if(size != 0)        
        {
            int newMask = newCapacity - 1;
for(int i = 0;i < oldCapacity;i++)
            {
for(HashMapEntry<K, V> e = oldTable[i];e != null;)
                {
                    HashMapEntry<K, V> oldNext = e.next;
                    int newIndex = e.hash & newMask;
                    HashMapEntry<K, V> newNext = newTable[newIndex];
                    newTable[newIndex] = e;
                    e.next = newNext;
                    e = oldNext;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.975 -0400", hash_original_method = "EE2E1A4893DAC33AFE32D39C3AA93587", hash_generated_method = "8E75843E8A09E8DD4102598E97093699")
    private HashMapEntry<K, V>[] makeTable(int newCapacity) {
        @SuppressWarnings("unchecked") HashMapEntry<K, V>[] newTable = (HashMapEntry<K, V>[]) new HashMapEntry[newCapacity];
        table = newTable;
        threshold = (newCapacity >> 1) + (newCapacity >> 2);
HashMapEntry<K, V>[] varBBDF9FA229AA843E98D9C8441545D1D6_1131626688 =         newTable;
        varBBDF9FA229AA843E98D9C8441545D1D6_1131626688.addTaint(taint);
        return varBBDF9FA229AA843E98D9C8441545D1D6_1131626688;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked") HashMapEntry<K, V>[] newTable
                //= (HashMapEntry<K, V>[]) new HashMapEntry[newCapacity];
        //table = newTable;
        //threshold = (newCapacity >> 1) + (newCapacity >> 2);
        //return newTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.975 -0400", hash_original_method = "0D1C32EF365F651EE12DB3FC6B4877B2", hash_generated_method = "3427B15CEE33079CA1CD47B1C240DF21")
    private HashMapEntry<K, V>[] doubleCapacity() {
        HashMapEntry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;
        if(oldCapacity == MAXIMUM_CAPACITY)        
        {
HashMapEntry<K, V>[] var644E69580A9DE331964CDB2EEA8BEBA2_1856228209 =             oldTable;
            var644E69580A9DE331964CDB2EEA8BEBA2_1856228209.addTaint(taint);
            return var644E69580A9DE331964CDB2EEA8BEBA2_1856228209;
        } //End block
        int newCapacity = oldCapacity * 2;
        HashMapEntry<K, V>[] newTable = makeTable(newCapacity);
        if(size == 0)        
        {
HashMapEntry<K, V>[] varBBDF9FA229AA843E98D9C8441545D1D6_870327979 =             newTable;
            varBBDF9FA229AA843E98D9C8441545D1D6_870327979.addTaint(taint);
            return varBBDF9FA229AA843E98D9C8441545D1D6_870327979;
        } //End block
for(int j = 0;j < oldCapacity;j++)
        {
            HashMapEntry<K, V> e = oldTable[j];
            if(e == null)            
            {
                continue;
            } //End block
            int highBit = e.hash & oldCapacity;
            HashMapEntry<K, V> broken = null;
            newTable[j | highBit] = e;
for(HashMapEntry<K, V> n = e.next;n != null;e = n,n = n.next)
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
HashMapEntry<K, V>[] varBBDF9FA229AA843E98D9C8441545D1D6_606599871 =         newTable;
        varBBDF9FA229AA843E98D9C8441545D1D6_606599871.addTaint(taint);
        return varBBDF9FA229AA843E98D9C8441545D1D6_606599871;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.976 -0400", hash_original_method = "D4E7D7B0427A5C260627922F822E871C", hash_generated_method = "BFF5D70B4A5C661B08D53566201DA747")
    @Override
    public V remove(Object key) {
        addTaint(key.getTaint());
        if(key == null)        
        {
V var7EA115A11D6B5E6A00E8CE3D3832EB2E_1824191150 =             removeNullKey();
            var7EA115A11D6B5E6A00E8CE3D3832EB2E_1824191150.addTaint(taint);
            return var7EA115A11D6B5E6A00E8CE3D3832EB2E_1824191150;
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
for(HashMapEntry<K, V> e = tab[index], prev = null;e != null;prev = e,e = e.next)
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
                postRemove(e);
V var65D32B0ADAFF3F55986024909BAFC34B_906412418 =                 e.value;
                var65D32B0ADAFF3F55986024909BAFC34B_906412418.addTaint(taint);
                return var65D32B0ADAFF3F55986024909BAFC34B_906412418;
            } //End block
        } //End block
V var540C13E9E156B687226421B24F2DF178_262724475 =         null;
        var540C13E9E156B687226421B24F2DF178_262724475.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_262724475;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.976 -0400", hash_original_method = "C27EF61BE4179F161C4389258A9892DE", hash_generated_method = "70B79646709BF4795B950183DFC9B160")
    private V removeNullKey() {
        HashMapEntry<K, V> e = entryForNullKey;
        if(e == null)        
        {
V var540C13E9E156B687226421B24F2DF178_1407246984 =             null;
            var540C13E9E156B687226421B24F2DF178_1407246984.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1407246984;
        } //End block
        entryForNullKey = null;
        modCount++;
        size--;
        postRemove(e);
V var65D32B0ADAFF3F55986024909BAFC34B_2025742986 =         e.value;
        var65D32B0ADAFF3F55986024909BAFC34B_2025742986.addTaint(taint);
        return var65D32B0ADAFF3F55986024909BAFC34B_2025742986;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.976 -0400", hash_original_method = "FA0A77625972B3EBD78B9E2926769234", hash_generated_method = "BDB96E09DB8E60586F70F118100AD4CC")
     void postRemove(HashMapEntry<K, V> e) {
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.976 -0400", hash_original_method = "19183B81B15552124143C4B9B1D176AB", hash_generated_method = "3A7FA2C7F18D6DE314506B54972462B8")
    @Override
    public void clear() {
        if(size != 0)        
        {
            Arrays.fill(table, null);
            entryForNullKey = null;
            modCount++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.976 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "B531639DFA42E70460884D762F25071F")
    @Override
    public Set<K> keySet() {
        Set<K> ks = keySet;
Set<K> varB6853687BE649BA8B10F9701AD179BB7_1835411969 =         (ks != null) ? ks : (keySet = new KeySet());
        varB6853687BE649BA8B10F9701AD179BB7_1835411969.addTaint(taint);
        return varB6853687BE649BA8B10F9701AD179BB7_1835411969;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.976 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "AC27A9FABDAC02ADC197639E93D9C2AB")
    @Override
    public Collection<V> values() {
        Collection<V> vs = values;
Collection<V> var5CABA883D65798B391E2C02013734397_1540613550 =         (vs != null) ? vs : (values = new Values());
        var5CABA883D65798B391E2C02013734397_1540613550.addTaint(taint);
        return var5CABA883D65798B391E2C02013734397_1540613550;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.977 -0400", hash_original_method = "54875E203703AD755476CBDF0B4AFC75", hash_generated_method = "8823E12553CEF9F29146B21A2A664B17")
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> es = entrySet;
Set<Entry<K, V>> var25D080FAAE722B04AA5C8EBDE33DD606_1917910008 =         (es != null) ? es : (entrySet = new EntrySet());
        var25D080FAAE722B04AA5C8EBDE33DD606_1917910008.addTaint(taint);
        return var25D080FAAE722B04AA5C8EBDE33DD606_1917910008;
        // ---------- Original Method ----------
        //Set<Entry<K, V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.977 -0400", hash_original_method = "DB078B96D3A026778ABE08AF9188B4AF", hash_generated_method = "B269550FE5C2A2D1F2C81140D8484158")
    private boolean containsMapping(Object key, Object value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        if(key == null)        
        {
            HashMapEntry<K, V> e = entryForNullKey;
            boolean var2DF30576FF9B9478F6D70015D77602DE_1330685580 = (e != null && Objects.equal(value, e.value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1288828795 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1288828795;
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
for(HashMapEntry<K, V> e = tab[index];e != null;e = e.next)
        {
            if(e.hash == hash && key.equals(e.key))            
            {
                boolean varD272096AE2A6FE49BA001908161744C6_916368804 = (Objects.equal(value, e.value));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1704884194 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1704884194;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1165095824 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1049615791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1049615791;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.978 -0400", hash_original_method = "6968B8C772086C45A00DBEEB8B4680E5", hash_generated_method = "BEE430F59B713CD8A30EDB0CD086608A")
    private boolean removeMapping(Object key, Object value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        if(key == null)        
        {
            HashMapEntry<K, V> e = entryForNullKey;
            if(e == null || !Objects.equal(value, e.value))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1593440035 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593165048 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593165048;
            } //End block
            entryForNullKey = null;
            modCount++;
            size--;
            postRemove(e);
            boolean varB326B5062B2F0E69046810717534CB09_167025652 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1899444127 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1899444127;
        } //End block
        int hash = secondaryHash(key.hashCode());
        HashMapEntry<K, V>[] tab = table;
        int index = hash & (tab.length - 1);
for(HashMapEntry<K, V> e = tab[index], prev = null;e != null;prev = e,e = e.next)
        {
            if(e.hash == hash && key.equals(e.key))            
            {
                if(!Objects.equal(value, e.value))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1179057718 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_735896217 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_735896217;
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
                postRemove(e);
                boolean varB326B5062B2F0E69046810717534CB09_999656095 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1093365686 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1093365686;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_385816061 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1000613535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1000613535;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.978 -0400", hash_original_method = "E5C2B853B7FE0DFF8A1198070D9AED67", hash_generated_method = "F1668116AB541A216AD9592E8E42C0BD")
     Iterator<K> newKeyIterator() {
Iterator<K> var3934136BB713579A43A8E8C1C3034CA0_100747736 =         new KeyIterator();
        var3934136BB713579A43A8E8C1C3034CA0_100747736.addTaint(taint);
        return var3934136BB713579A43A8E8C1C3034CA0_100747736;
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.978 -0400", hash_original_method = "58BEE1C21CE9010029EB8FF9FDCDF9B3", hash_generated_method = "76778FE3AC7497DB30455C5DA4DC78C7")
     Iterator<V> newValueIterator() {
Iterator<V> varA5D0B7DD47403A81B3461DEE499DEE74_1420326065 =         new ValueIterator();
        varA5D0B7DD47403A81B3461DEE499DEE74_1420326065.addTaint(taint);
        return varA5D0B7DD47403A81B3461DEE499DEE74_1420326065;
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.978 -0400", hash_original_method = "41242F67E24C22ACB46F6D238FB07528", hash_generated_method = "9F3760E9FC0892201279CD83EFB7C0E6")
     Iterator<Entry<K, V>> newEntryIterator() {
Iterator<Entry<K, V>> varA27729B8E339A6F174B2D9A9BA7B896F_72655629 =         new EntryIterator();
        varA27729B8E339A6F174B2D9A9BA7B896F_72655629.addTaint(taint);
        return varA27729B8E339A6F174B2D9A9BA7B896F_72655629;
        // ---------- Original Method ----------
        //return new EntryIterator();
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.978 -0400", hash_original_method = "04BAFB4D83496263E755E7BD0F7C13FF", hash_generated_method = "52C658DC0E2F13C5A057F812129BFFD0")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        ObjectOutputStream.PutField fields = stream.putFields();
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.979 -0400", hash_original_method = "332DDC73CD162DC81E3D2D410CF74F29", hash_generated_method = "084A0B9A938F9631A78FC483203ED3E4")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        int capacity = stream.readInt();
        if(capacity < 0)        
        {
            InvalidObjectException var4B6A7F779A4667EA55847180B6A27960_1717193179 = new InvalidObjectException("Capacity: " + capacity);
            var4B6A7F779A4667EA55847180B6A27960_1717193179.addTaint(taint);
            throw var4B6A7F779A4667EA55847180B6A27960_1717193179;
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
            InvalidObjectException varE685AABC7A986A19539C13F2F8920021_14933937 = new InvalidObjectException("Size: " + size);
            varE685AABC7A986A19539C13F2F8920021_14933937.addTaint(taint);
            throw varE685AABC7A986A19539C13F2F8920021_14933937;
        } //End block
        init();
for(int i = 0;i < size;i++)
        {
            @SuppressWarnings("unchecked") K key = (K) stream.readObject();
            @SuppressWarnings("unchecked") V val = (V) stream.readObject();
            constructorPut(key, val);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static class HashMapEntry<K, V> implements Entry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.979 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.979 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.979 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.979 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "EFF097737D8D1DD9FA2B138EC8EE329B")

        HashMapEntry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.980 -0400", hash_original_method = "59EAB065FDED45CEE8A2A37A4323841C", hash_generated_method = "A273A4961FF63025E25EB678F2528A39")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.980 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "80C649F81D8CB6F13B08D9F262E40990")
        public final K getKey() {
K var6A95247616A3A8B93CFF7783DABD08D4_28077046 =             key;
            var6A95247616A3A8B93CFF7783DABD08D4_28077046.addTaint(taint);
            return var6A95247616A3A8B93CFF7783DABD08D4_28077046;
            // ---------- Original Method ----------
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.980 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "88C19F7082E93F377C0A40E0A8765219")
        public final V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_2140300394 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_2140300394.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_2140300394;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.980 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "C781C4508B774A10B84C7B84A4B12011")
        public final V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_2118743556 =             oldValue;
            var8CDBD2181CBEF5C2129AFFA68C014D4A_2118743556.addTaint(taint);
            return var8CDBD2181CBEF5C2129AFFA68C014D4A_2118743556;
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.980 -0400", hash_original_method = "A2F2028BE339F747959E241A5FA9FFD4", hash_generated_method = "240B0626A83BF8FE8808FD769A3EB43B")
        @Override
        public final boolean equals(Object o) {
            addTaint(o.getTaint());
            if(!(o instanceof Entry))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1415127356 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1446501355 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1446501355;
            } //End block
            Entry<?, ?> e = (Entry<?, ?>) o;
            boolean var18631C95EE2886E3AE12AE4A13CE37D4_456215512 = (Objects.equal(e.getKey(), key)
                    && Objects.equal(e.getValue(), value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2045543616 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2045543616;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry)) {
                //return false;
            //}
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return Objects.equal(e.getKey(), key)
                    //&& Objects.equal(e.getValue(), value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.980 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "475EDDB69F1329FEC137FD498AB41855")
        @Override
        public final int hashCode() {
            int varE781106C2F974DC3DA3AA9DC4A937B40_560035826 = ((key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_40681163 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_40681163;
            // ---------- Original Method ----------
            //return (key == null ? 0 : key.hashCode()) ^
                    //(value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.980 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "6CBBEE2FB7956EEB42D5FDF090310385")
        @Override
        public final String toString() {
String varFE698C13EFD83B87FAF2DC2AB0874271_1137350615 =             key + "=" + value;
            varFE698C13EFD83B87FAF2DC2AB0874271_1137350615.addTaint(taint);
            return varFE698C13EFD83B87FAF2DC2AB0874271_1137350615;
            // ---------- Original Method ----------
            //return key + "=" + value;
        }

        
    }


    
    private abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.980 -0400", hash_original_field = "B6F75212F617C3E247C9474AFDA3B784", hash_generated_field = "04911A8A6B33F6D23811475122C95D0E")

        int nextIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.980 -0400", hash_original_field = "1BF1C18789BF9A611993EC2DE07C682C", hash_generated_field = "714CC477FAEEEEC0B90131EEA4F76ACE")

        HashMapEntry<K, V> nextEntry = entryForNullKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.980 -0400", hash_original_field = "8A3A9937F6D0DA3448C9C061B347CECF", hash_generated_field = "0C026A4A91581F8AA81723168CEE7A19")

        HashMapEntry<K, V> lastEntryReturned;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.980 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "17128C49BCF19B4186F02F384F2DEA86")

        int expectedModCount = modCount;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.981 -0400", hash_original_method = "1EAE57F880E5B81388FFC9611EFAA8EA", hash_generated_method = "0E815CC1DAEDDD549C8BCEC8F3AF959F")
          HashIterator() {
            if(nextEntry == null)            
            {
                HashMapEntry<K, V>[] tab = table;
                HashMapEntry<K, V> next = null;
                while
(next == null && nextIndex < tab.length)                
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.981 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "5B857A9AF453DEFCE8B54FAC9C46F252")
        public boolean hasNext() {
            boolean var89CBB2F442CE6BC294273342C489EBAF_1841309584 = (nextEntry != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_524565539 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_524565539;
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.981 -0400", hash_original_method = "5956AFD098F3B365104EB4761E150134", hash_generated_method = "FB6B307EEE92B35A2CC69EB7AF88A415")
         HashMapEntry<K, V> nextEntry() {
            if(modCount != expectedModCount)            
            {
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1587845708 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1587845708.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1587845708;
            }
            if(nextEntry == null)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1820387577 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1820387577.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1820387577;
            }
            HashMapEntry<K, V> entryToReturn = nextEntry;
            HashMapEntry<K, V>[] tab = table;
            HashMapEntry<K, V> next = entryToReturn.next;
            while
(next == null && nextIndex < tab.length)            
            {
                next = tab[nextIndex++];
            } //End block
            nextEntry = next;
HashMapEntry<K, V> var4D0F707C8B7B92ABA91FE6E8CAA540A2_670960450 =             lastEntryReturned = entryToReturn;
            var4D0F707C8B7B92ABA91FE6E8CAA540A2_670960450.addTaint(taint);
            return var4D0F707C8B7B92ABA91FE6E8CAA540A2_670960450;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.981 -0400", hash_original_method = "FE8482BFEC11D819DE4FA740E823F031", hash_generated_method = "84FB2A3A23C0942F27C0F2C0A35B2BE7")
        public void remove() {
            if(lastEntryReturned == null)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1809313701 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1809313701.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1809313701;
            }
            if(modCount != expectedModCount)            
            {
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1216019113 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1216019113.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1216019113;
            }
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.981 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.981 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "609CCB4733429F11AF6698BB931827BA")
        public K next() {
K varDFFFB017DDA62C15E8D1D49BA5F94802_971482281 =             nextEntry().key;
            varDFFFB017DDA62C15E8D1D49BA5F94802_971482281.addTaint(taint);
            return varDFFFB017DDA62C15E8D1D49BA5F94802_971482281;
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends HashIterator implements Iterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.981 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.981 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "0858DD5850E83166393A1D0C9A9BCD27")
        public V next() {
V var57B066C0B962D4E7D7CC8F9272046644_232509233 =             nextEntry().value;
            var57B066C0B962D4E7D7CC8F9272046644_232509233.addTaint(taint);
            return var57B066C0B962D4E7D7CC8F9272046644_232509233;
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends HashIterator implements Iterator<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.981 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.982 -0400", hash_original_method = "C7E2B840B075445DC1033B130AB2E6A6", hash_generated_method = "4C669F6B8E162BC3DE7C9336EE87CC22")
        public Entry<K, V> next() {
Entry<K, V> varDC8D7EA83135934E991F02D91E02BF6E_1366322056 =             nextEntry();
            varDC8D7EA83135934E991F02D91E02BF6E_1366322056.addTaint(taint);
            return varDC8D7EA83135934E991F02D91E02BF6E_1366322056;
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.982 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.982 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "E728B723CDC0E18367EB9065AF324DDC")
        public Iterator<K> iterator() {
Iterator<K> var3934136BB713579A43A8E8C1C3034CA0_180599581 =             newKeyIterator();
            var3934136BB713579A43A8E8C1C3034CA0_180599581.addTaint(taint);
            return var3934136BB713579A43A8E8C1C3034CA0_180599581;
            // ---------- Original Method ----------
            //return newKeyIterator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.982 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "980D55528B60EECA542E8F9C0A767640")
        public int size() {
            int varF7BD60B75B29D79B660A2859395C1A24_2085812478 = (size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990873416 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990873416;
            // ---------- Original Method ----------
            //return size;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.982 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "7016E4C94C9AA8A6389C5C34FC631896")
        public boolean isEmpty() {
            boolean var9FB8BC7F775DDD98EEAB5582D340229E_1115463432 = (size == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2070070555 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2070070555;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.982 -0400", hash_original_method = "55474555B71DFC8666AC2B6E4F0261A5", hash_generated_method = "D02B94A87942B6F9AFD49F37C635421A")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var6CE6D88A4041ABB2C763C00DFE3D40ED_1107123363 = (containsKey(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1031484648 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1031484648;
            // ---------- Original Method ----------
            //return containsKey(o);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.982 -0400", hash_original_method = "AFD23FBC02983B6BF4B878FD36F94DEB", hash_generated_method = "1AC5EF7204FF400F821DFFB35FF6B34B")
        public boolean remove(Object o) {
            addTaint(o.getTaint());
            int oldSize = size;
            HashMap.this.remove(o);
            boolean varF5DDED0F84B0A41C9923865D0C223F3C_116963154 = (size != oldSize);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_407446899 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_407446899;
            // ---------- Original Method ----------
            //int oldSize = size;
            //HashMap.this.remove(o);
            //return size != oldSize;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.982 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    private final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.982 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.982 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "4F2FDDE846E5B7236D37E9D522D1C7FC")
        public Iterator<V> iterator() {
Iterator<V> varA5D0B7DD47403A81B3461DEE499DEE74_1378350570 =             newValueIterator();
            varA5D0B7DD47403A81B3461DEE499DEE74_1378350570.addTaint(taint);
            return varA5D0B7DD47403A81B3461DEE499DEE74_1378350570;
            // ---------- Original Method ----------
            //return newValueIterator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.982 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "A645281E96123C5B9F79AF41964C947F")
        public int size() {
            int varF7BD60B75B29D79B660A2859395C1A24_499162840 = (size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_109377924 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_109377924;
            // ---------- Original Method ----------
            //return size;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.982 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "D82867FC51713C084C068B54696EAA85")
        public boolean isEmpty() {
            boolean var9FB8BC7F775DDD98EEAB5582D340229E_721827593 = (size == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1080816630 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1080816630;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.983 -0400", hash_original_method = "C13053467D6FDF772DF450C87D40A3D5", hash_generated_method = "C7455A574CE6B82F9D0562D0BA99DC36")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var1B8C9A98435D2C268A243B67E80B7085_2835275 = (containsValue(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1058875449 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1058875449;
            // ---------- Original Method ----------
            //return containsValue(o);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.983 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    private final class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.983 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.983 -0400", hash_original_method = "D7164BC97FFDCB587AB273006C953E50", hash_generated_method = "9DF67A7DAAC77FA18F8D749B65626382")
        public Iterator<Entry<K, V>> iterator() {
Iterator<Entry<K, V>> varA27729B8E339A6F174B2D9A9BA7B896F_1688390063 =             newEntryIterator();
            varA27729B8E339A6F174B2D9A9BA7B896F_1688390063.addTaint(taint);
            return varA27729B8E339A6F174B2D9A9BA7B896F_1688390063;
            // ---------- Original Method ----------
            //return newEntryIterator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.983 -0400", hash_original_method = "6E695F138E29D844DC896198513B6135", hash_generated_method = "F80BA888C2CD0BDAC48DA8B4FFFFE70C")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            if(!(o instanceof Entry))            
            {
            boolean var68934A3E9455FA72420237EB05902327_551133191 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_963258946 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_963258946;
            }
            Entry<?, ?> e = (Entry<?, ?>) o;
            boolean varBCB5439A3C90DA1EEC1D1019805D2AEB_1906318422 = (containsMapping(e.getKey(), e.getValue()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852718579 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852718579;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>) o;
            //return containsMapping(e.getKey(), e.getValue());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.983 -0400", hash_original_method = "F484CBC8566C601718EDE0034034C7B3", hash_generated_method = "2720A7A68ABCDD485778703B73EA4F4D")
        public boolean remove(Object o) {
            addTaint(o.getTaint());
            if(!(o instanceof Entry))            
            {
            boolean var68934A3E9455FA72420237EB05902327_525176293 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_650724868 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_650724868;
            }
            Entry<?, ?> e = (Entry<?, ?>)o;
            boolean varC8B62CA77D8440BA8EB39DF9C30B611A_975458323 = (removeMapping(e.getKey(), e.getValue()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_67371265 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_67371265;
            // ---------- Original Method ----------
            //if (!(o instanceof Entry))
                //return false;
            //Entry<?, ?> e = (Entry<?, ?>)o;
            //return removeMapping(e.getKey(), e.getValue());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.983 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "3DE6D1D61A050DB1167A143DCC63A94D")
        public int size() {
            int varF7BD60B75B29D79B660A2859395C1A24_1959584415 = (size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_304307042 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_304307042;
            // ---------- Original Method ----------
            //return size;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.983 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "4B1DD5C628A75BF7F8C991DBE9731DBD")
        public boolean isEmpty() {
            boolean var9FB8BC7F775DDD98EEAB5582D340229E_1344411133 = (size == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1755429503 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1755429503;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.983 -0400", hash_original_method = "CC7950FE19A79FE938BA7BE1D102D14C", hash_generated_method = "CEF95997841CE3C868205CB0933370FD")
        public void clear() {
            HashMap.this.clear();
            // ---------- Original Method ----------
            //HashMap.this.clear();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.984 -0400", hash_original_field = "74773297EBE9767DD8F1E8A0F109042B", hash_generated_field = "2D66E915A2C4A5FBF28A99892F20B1AF")

    private static final int MINIMUM_CAPACITY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.984 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "C94813E6F46C48A83BBFCFA3C9862983")

    private static final int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.984 -0400", hash_original_field = "A1E5317AEBE2AA7B440C685A8E07ADDF", hash_generated_field = "EAEFC19DF41584BBCC74BC909378688B")

    private static final Entry[] EMPTY_TABLE = new HashMapEntry[MINIMUM_CAPACITY >>> 1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.984 -0400", hash_original_field = "2457D6689D4C035FB0208C51E3216836", hash_generated_field = "8B66B6321C50459F7579C610CEA9040E")

    static final float DEFAULT_LOAD_FACTOR = .75F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.984 -0400", hash_original_field = "B9B0D4CAFA519E3022BDB211EDB6108F", hash_generated_field = "895D2EFED015878DCDE59CE17F2ED051")

    private static final long serialVersionUID = 362498820763181265L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.984 -0400", hash_original_field = "6B5047BD80649C86F20ACE5466546B8B", hash_generated_field = "07BD8E29CA88435F65E9AD35F51067E8")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("loadFactor", float.class)
    };
}


package org.apache.harmony.luni.util;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class TwoKeyHashMap<E, K, V> extends AbstractMap<String, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.126 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "922E9E523E3B4B4E0BBECCC2419D9A8A")

    private Set<Map.Entry<String, V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.126 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "0CA88E23C485E63FB3BB9610D40E8264")

    private Collection<V> values;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.126 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.126 -0400", hash_original_field = "DFEF811547BBC141513674AE42682230", hash_generated_field = "316FD2AB259DA26036E31C0D78278AE7")

    private int arrSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.126 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "444771311A9B09F69D7C8D75C59C2BBB")

    private int modCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.126 -0400", hash_original_field = "47C80780AB608CC046F2A6E6F071FEB6", hash_generated_field = "8E4CC84ABB20D75F51E93933E0A59066")

    private Entry<E, K, V>[] arr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.126 -0400", hash_original_field = "97C293EF8ABD832D29E88C21D8E562F5", hash_generated_field = "4BC2677DD136E3CB5AE0C48B0EDF5A53")

    private float loadFactor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.126 -0400", hash_original_field = "70D6CECF8D97F10969A69F5BF3BDD295", hash_generated_field = "F9A5F8AF6E8A641C6C49EB5204F6EF63")

    int threshold = 0;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.126 -0400", hash_original_method = "294B6DEE36941009B0B201B0BEC2DD67", hash_generated_method = "E45D157C82C9A0D27E45C7E8FDC413D5")
    public  TwoKeyHashMap() {
        this(DEFAULT_INITIAL_SIZE, DEFAULT_LOAD_FACTOR);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.126 -0400", hash_original_method = "E595C77056089A502D8DE33B445FC550", hash_generated_method = "8A450F5AB8941E4B262790914C952160")
    public  TwoKeyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
        addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.127 -0400", hash_original_method = "679241DAB133FCD723055BFD98A1C12B", hash_generated_method = "FB9D5C79DDC94937AFDFFC3939AD95C6")
    @SuppressWarnings("unchecked")
    public  TwoKeyHashMap(int initialCapacity, float initialLoadFactor) {
        if(initialCapacity < 0)        
        {
            IllegalArgumentException var0A877F35152ACC09293597AA0CA40C38_1089442613 = new IllegalArgumentException("initialCapacity should be >= 0");
            var0A877F35152ACC09293597AA0CA40C38_1089442613.addTaint(taint);
            throw var0A877F35152ACC09293597AA0CA40C38_1089442613;
        } //End block
        if(initialLoadFactor <= 0)        
        {
            IllegalArgumentException var2896D4B56FBA4EF31B67FCCC04385A32_1106132151 = new IllegalArgumentException(
                    "initialLoadFactor should be > 0");
            var2896D4B56FBA4EF31B67FCCC04385A32_1106132151.addTaint(taint);
            throw var2896D4B56FBA4EF31B67FCCC04385A32_1106132151;
        } //End block
        loadFactor = initialLoadFactor;
        if(initialCapacity == Integer.MAX_VALUE)        
        {
            initialCapacity--;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.128 -0400", hash_original_method = "66B88A01F8296942609EF87ACA0E012C", hash_generated_method = "863CC48C2011F4CF7981398979DEDB36")
    public Collection<V> values() {
        if(values == null)        
        {
            values = new ValuesCollectionImpl();
        } //End block
Collection<V> var674B10C763DBAAF9696AD9A3DDAE07B3_1816147221 =         values;
        var674B10C763DBAAF9696AD9A3DDAE07B3_1816147221.addTaint(taint);
        return var674B10C763DBAAF9696AD9A3DDAE07B3_1816147221;
        // ---------- Original Method ----------
        //if (values == null) {
            //values = new ValuesCollectionImpl();
        //}
        //return values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.128 -0400", hash_original_method = "56D76EA36DEC4CA5689518DF65F0FB11", hash_generated_method = "E7094BECBF20321F5D22E7BBD3A448D4")
    public Set<Map.Entry<String, V>> entrySet() {
        if(entrySet == null)        
        {
            entrySet = new EntrySetImpl();
        } //End block
Set<Map.Entry<String, V>> var844F1DC6137EC02DBA16CAD3ADE04B13_1662788856 =         entrySet;
        var844F1DC6137EC02DBA16CAD3ADE04B13_1662788856.addTaint(taint);
        return var844F1DC6137EC02DBA16CAD3ADE04B13_1662788856;
        // ---------- Original Method ----------
        //if (entrySet == null) {
            //entrySet = new EntrySetImpl();
        //}
        //return entrySet;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.129 -0400", hash_original_method = "818EB47C54D790B2A626C59717AA13C9", hash_generated_method = "D8F3DDDEF4CB3BA5796A4BE244A81452")
    public void clear() {
        modCount++;
        size = 0;
        Arrays.fill(arr, 0, arr.length, null);
        // ---------- Original Method ----------
        //modCount++;
        //size = 0;
        //Arrays.fill(arr, 0, arr.length, null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.129 -0400", hash_original_method = "FFF3CF52B9B0B5141C3665D271E08CFC", hash_generated_method = "DF3D2C7AC1F761BCC0156DF405FA2E7F")
    public V remove(Object key1, Object key2) {
        addTaint(key2.getTaint());
        addTaint(key1.getTaint());
        Entry<E, K, V> e = removeEntry(key1, key2);
V var9A2106950A51C9551E1CF534E2C1C0D6_1662748105 =         (e != null) ? e.value : null;
        var9A2106950A51C9551E1CF534E2C1C0D6_1662748105.addTaint(taint);
        return var9A2106950A51C9551E1CF534E2C1C0D6_1662748105;
        // ---------- Original Method ----------
        //Entry<E, K, V> e = removeEntry(key1, key2);
        //return (e != null) ? e.value : null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.131 -0400", hash_original_method = "8D27DE23631F09453D73093F15998EF0", hash_generated_method = "03EC485830C9011D30EFD5F0A16C5D6C")
    public V put(E key1, K key2, V value) {
        if(key1 == null && key2 == null)        
        {
            int index = arrSize;
            if(arr[index] == null)            
            {
                arr[index] = createEntry(0, null, null, value, null);
                size++;
                modCount++;
V var540C13E9E156B687226421B24F2DF178_1438738442 =                 null;
                var540C13E9E156B687226421B24F2DF178_1438738442.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1438738442;
            } //End block
            else
            {
                V oldValue = arr[index].value;
                arr[index].value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_1833763549 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_1833763549.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_1833763549;
            } //End block
        } //End block
        int hash = key1.hashCode() + key2.hashCode();
        int index = (hash & 0x7fffffff) % arrSize;
        Entry<E, K, V> e = arr[index];
        while
(e != null)        
        {
            if(hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2()))            
            {
                V oldValue = e.value;
                e.value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_1173746607 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_1173746607.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_1173746607;
            } //End block
            e = e.next;
        } //End block
        arr[index] = createEntry(hash, key1, key2, value, arr[index]);
        size++;
        modCount++;
        if(size > threshold)        
        {
            rehash();
        } //End block
V var540C13E9E156B687226421B24F2DF178_652183546 =         null;
        var540C13E9E156B687226421B24F2DF178_652183546.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_652183546;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.133 -0400", hash_original_method = "4E92EE4014ABA801EB273C60A5958799", hash_generated_method = "B1A9862083B080C77260CDE5CD0C202B")
    @SuppressWarnings("unchecked")
     void rehash() {
        int newArrSize = (arrSize + 1) * 2 + 1;
        if(newArrSize < 0)        
        {
            newArrSize = Integer.MAX_VALUE - 1;
        } //End block
        Entry<E, K, V>[] newArr = new Entry[newArrSize + 1];
for(int i = 0;i < arr.length - 1;i++)
        {
            Entry<E, K, V> entry = arr[i];
            while
(entry != null)            
            {
                Entry<E, K, V> next = entry.next;
                int newIndex = (entry.hash & 0x7fffffff) % newArrSize;
                entry.next = newArr[newIndex];
                newArr[newIndex] = entry;
                entry = next;
            } //End block
        } //End block
        newArr[newArrSize] = arr[arrSize];
        arrSize = newArrSize;
        if(arrSize == Integer.MAX_VALUE)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.133 -0400", hash_original_method = "31FF250303275620FA0192DC25A0041E", hash_generated_method = "7FFB7F22CBAD05B1B0771EE04A4E6D93")
    public boolean containsKey(Object key1, Object key2) {
        addTaint(key2.getTaint());
        addTaint(key1.getTaint());
        boolean varD43818A8336024C58ED250A3F811D712_703296050 = (findEntry(key1, key2) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1040441890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1040441890;
        // ---------- Original Method ----------
        //return findEntry(key1, key2) != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.134 -0400", hash_original_method = "E13BBD09CFB92FF506FEC56FABF87B9F", hash_generated_method = "ABBE875CC9DEB994F8DCF102A4D07A12")
    public V get(Object key1, Object key2) {
        addTaint(key2.getTaint());
        addTaint(key1.getTaint());
        Entry<E, K, V> e = findEntry(key1, key2);
        if(e != null)        
        {
V var65D32B0ADAFF3F55986024909BAFC34B_454872928 =             e.value;
            var65D32B0ADAFF3F55986024909BAFC34B_454872928.addTaint(taint);
            return var65D32B0ADAFF3F55986024909BAFC34B_454872928;
        } //End block
V var540C13E9E156B687226421B24F2DF178_666506222 =         null;
        var540C13E9E156B687226421B24F2DF178_666506222.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_666506222;
        // ---------- Original Method ----------
        //Entry<E, K, V> e = findEntry(key1, key2);
        //if (e != null) {
            //return e.value;
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.134 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "EE449DA925BBB1576612632B405286CE")
    public boolean isEmpty() {
        boolean var9FB8BC7F775DDD98EEAB5582D340229E_871114478 = (size == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1393484430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1393484430;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.134 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "BA46C479C3C1D80C72F8E8E2FF969B08")
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_158326849 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_481111449 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_481111449;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.135 -0400", hash_original_method = "B126004260D8EBAD1640E464F002A4A4", hash_generated_method = "B5EFF631C2A99DB3A37D38D200B2A0B4")
     Entry<E, K, V> createEntry(int hashCode, E key1, K key2, V value,
            Entry<E, K, V> next) {
        addTaint(next.getTaint());
        addTaint(value.getTaint());
        addTaint(key2.getTaint());
        addTaint(key1.getTaint());
        addTaint(hashCode);
Entry<E, K, V> var2C18A0A8AF7077C354443EE552A67DB0_434804528 =         new Entry<E, K, V>(hashCode, key1, key2, value, next);
        var2C18A0A8AF7077C354443EE552A67DB0_434804528.addTaint(taint);
        return var2C18A0A8AF7077C354443EE552A67DB0_434804528;
        // ---------- Original Method ----------
        //return new Entry<E, K, V>(hashCode, key1, key2, value, next);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.135 -0400", hash_original_method = "F4E18AFB5A6BD2866D211174F2C65244", hash_generated_method = "4AE44E5943C2B39792158AA6EFCAE46B")
     Iterator<Map.Entry<String, V>> createEntrySetIterator() {
Iterator<Map.Entry<String, V>> varA8EA1EF1323C8ED28EB1F0576287C6FE_858307180 =         new EntryIteratorImpl();
        varA8EA1EF1323C8ED28EB1F0576287C6FE_858307180.addTaint(taint);
        return varA8EA1EF1323C8ED28EB1F0576287C6FE_858307180;
        // ---------- Original Method ----------
        //return new EntryIteratorImpl();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.135 -0400", hash_original_method = "6209E5C519243BC33CB9A47AFA9E017F", hash_generated_method = "84A5C035528A094436E530D404E3F99C")
     Iterator<V> createValueCollectionIterator() {
Iterator<V> varED1FEEF907E41228C2F16F509E697FD4_1102943904 =         new ValueIteratorImpl();
        varED1FEEF907E41228C2F16F509E697FD4_1102943904.addTaint(taint);
        return varED1FEEF907E41228C2F16F509E697FD4_1102943904;
        // ---------- Original Method ----------
        //return new ValueIteratorImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.136 -0400", hash_original_method = "C152D61E326241B091FB8EBCBC5C9180", hash_generated_method = "FFF0C35D36346B5405FA8F6433D991F8")
    private final Entry<E, K, V> findEntry(Object key1, Object key2) {
        addTaint(key2.getTaint());
        addTaint(key1.getTaint());
        if(key1 == null && key2 == null)        
        {
Entry<E, K, V> var9370A07A76DB50A17B85C7AC557133DB_1031979476 =             arr[arrSize];
            var9370A07A76DB50A17B85C7AC557133DB_1031979476.addTaint(taint);
            return var9370A07A76DB50A17B85C7AC557133DB_1031979476;
        } //End block
        int hash = key1.hashCode() + key2.hashCode();
        int index = (hash & 0x7fffffff) % arrSize;
        Entry<E, K, V> e = arr[index];
        while
(e != null)        
        {
            if(hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2()))            
            {
Entry<E, K, V> var6BFFBFA2F1D556BA80433C2335198CE9_1309518995 =                 e;
                var6BFFBFA2F1D556BA80433C2335198CE9_1309518995.addTaint(taint);
                return var6BFFBFA2F1D556BA80433C2335198CE9_1309518995;
            } //End block
            e = e.next;
        } //End block
Entry<E, K, V> var540C13E9E156B687226421B24F2DF178_1149610761 =         null;
        var540C13E9E156B687226421B24F2DF178_1149610761.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1149610761;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.137 -0400", hash_original_method = "C98DB123D4E5CC84B2492FBCF56B145D", hash_generated_method = "64E2A6D64190ACBF0191036EEDB5636F")
    private final Entry<E, K, V> removeEntry(Object key1, Object key2) {
        addTaint(key2.getTaint());
        addTaint(key1.getTaint());
        if(key1 == null && key2 == null)        
        {
            int index = arrSize;
            if(arr[index] != null)            
            {
                Entry<E, K, V> ret = arr[index];
                arr[index] = null;
                size--;
                modCount++;
Entry<E, K, V> varEDFF4FBBF053B5DC2B444ADFA049EE0F_2128012062 =                 ret;
                varEDFF4FBBF053B5DC2B444ADFA049EE0F_2128012062.addTaint(taint);
                return varEDFF4FBBF053B5DC2B444ADFA049EE0F_2128012062;
            } //End block
Entry<E, K, V> var540C13E9E156B687226421B24F2DF178_1485616925 =             null;
            var540C13E9E156B687226421B24F2DF178_1485616925.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1485616925;
        } //End block
        int hash = key1.hashCode() + key2.hashCode();
        int index = (hash & 0x7fffffff) % arrSize;
        Entry<E, K, V> e = arr[index];
        Entry<E, K, V> prev = e;
        while
(e != null)        
        {
            if(hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2()))            
            {
                if(prev == e)                
                {
                    arr[index] = e.next;
                } //End block
                else
                {
                    prev.next = e.next;
                } //End block
                size--;
                modCount++;
Entry<E, K, V> var6BFFBFA2F1D556BA80433C2335198CE9_643991192 =                 e;
                var6BFFBFA2F1D556BA80433C2335198CE9_643991192.addTaint(taint);
                return var6BFFBFA2F1D556BA80433C2335198CE9_643991192;
            } //End block
            prev = e;
            e = e.next;
        } //End block
Entry<E, K, V> var540C13E9E156B687226421B24F2DF178_1797432989 =         null;
        var540C13E9E156B687226421B24F2DF178_1797432989.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1797432989;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class Entry<E, K, V> implements Map.Entry<String, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.137 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.137 -0400", hash_original_field = "C2ADD694BF942DC77B376592D9C862CD", hash_generated_field = "FF2F76F560606089FC32D051F70C3BCF")

        E key1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.137 -0400", hash_original_field = "78F825AAA0103319AAA1A30BF4FE3ADA", hash_generated_field = "DE7247D222A6A88790AAD9007484F2CE")

        K key2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.137 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.137 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "041FC26789DCA96E16327DF3859848D1")

        Entry<E, K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.138 -0400", hash_original_method = "3E3A99A3B7891AEE573C3F0F98EEE3AE", hash_generated_method = "6DEBEC5295235A0ED788B9F66F6D400D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.138 -0400", hash_original_method = "43A91F8C54B90BC0F4C951BCB1425B25", hash_generated_method = "9E7B2D0F8E476BB36D7A4ACAECC2D17F")
        public String getKey() {
String var68CFAAB40FE81B389C40EF166B3D7E7E_1594039173 =             key1.toString() + key2.toString();
            var68CFAAB40FE81B389C40EF166B3D7E7E_1594039173.addTaint(taint);
            return var68CFAAB40FE81B389C40EF166B3D7E7E_1594039173;
            // ---------- Original Method ----------
            //return key1.toString() + key2.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.138 -0400", hash_original_method = "8E21854AE9ADC89A1868BC4522219FB2", hash_generated_method = "02AC37E1A3677196DFC97D59077ECB15")
        public E getKey1() {
E var1DFC6AC0D2D727F36FD87608E8DCDD41_1584280199 =             key1;
            var1DFC6AC0D2D727F36FD87608E8DCDD41_1584280199.addTaint(taint);
            return var1DFC6AC0D2D727F36FD87608E8DCDD41_1584280199;
            // ---------- Original Method ----------
            //return key1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.138 -0400", hash_original_method = "7F02D1AD568FC6C2F60475D661F743CB", hash_generated_method = "279659BF90FB4C886AD1DDA6C6C53FBC")
        public K getKey2() {
K varA654CD75EFA94D4E93625838DEFFD3AA_427994556 =             key2;
            varA654CD75EFA94D4E93625838DEFFD3AA_427994556.addTaint(taint);
            return varA654CD75EFA94D4E93625838DEFFD3AA_427994556;
            // ---------- Original Method ----------
            //return key2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.138 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "721643787FDBFB85248B96D742D2F0A5")
        public V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_931355215 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_931355215.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_931355215;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.138 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "1D8BC3CB0B990BB7310B3C4699E452A9")
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_254955845 =             oldValue;
            var8CDBD2181CBEF5C2129AFFA68C014D4A_254955845.addTaint(taint);
            return var8CDBD2181CBEF5C2129AFFA68C014D4A_254955845;
            // ---------- Original Method ----------
            //V oldValue = this.value;
            //this.value = value;
            //return oldValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.139 -0400", hash_original_method = "2C745FE5DF9CE9CA09289DC08E07F848", hash_generated_method = "570E8323A239B22AA0F05512FFC8E391")
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
            if(!(obj instanceof Entry))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1111235769 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_229979651 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_229979651;
            } //End block
            Entry<?, ?, ?> e = (Entry<?, ?, ?>) obj;
            Object getKey1 = e.getKey1();
            Object getKey2 = e.getKey2();
            Object getValue = e.getValue();
            if((key1 == null && getKey1 != null)
                    || (key2 == null && getKey2 != null)
                    || (value == null && getValue != null)
                    || !key1.equals(e.getKey1()) || !key2.equals(e.getKey2())
                    || !value.equals(getValue))            
            {
                boolean var68934A3E9455FA72420237EB05902327_943768611 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1012448511 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1012448511;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_573980631 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1538188175 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1538188175;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.139 -0400", hash_original_method = "57C89921FB9688640B9C568340F7B69C", hash_generated_method = "9B990A6C95641328A96D6ECBFE74C82E")
        public int hashCode() {
            int hash1 = (key1 == null ? 0 : key1.hashCode());
            int hash2 = (key2 == null ? 0 : key2.hashCode());
            int var7A5A2898A05093C44E45CD578D1E5BEB_773213421 = ((hash1 + hash2) ^ (value == null ? 0 : value.hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282488226 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282488226;
            // ---------- Original Method ----------
            //int hash1 = (key1 == null ? 0 : key1.hashCode());
            //int hash2 = (key2 == null ? 0 : key2.hashCode());
            //return (hash1 + hash2) ^ (value == null ? 0 : value.hashCode());
        }

        
    }


    
    class EntrySetImpl extends AbstractSet<Map.Entry<String, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.139 -0400", hash_original_method = "403B9BE439CBD0FBC0501C0EDC2D9426", hash_generated_method = "403B9BE439CBD0FBC0501C0EDC2D9426")
        public EntrySetImpl ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.139 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "7CA03AB83273B8DF0CF0C88F9FBC0DB1")
        public int size() {
            int varF7BD60B75B29D79B660A2859395C1A24_1370438675 = (size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094608783 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094608783;
            // ---------- Original Method ----------
            //return size;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.139 -0400", hash_original_method = "AE463F3857FBE52FC47F5CD4A94D1EE6", hash_generated_method = "CB1BBFA30FC78A80159E3DCADA51A3C9")
        public void clear() {
            TwoKeyHashMap.this.clear();
            // ---------- Original Method ----------
            //TwoKeyHashMap.this.clear();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.140 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "70FA169A111ABE76AC1DE9BEDE202574")
        public boolean isEmpty() {
            boolean var9FB8BC7F775DDD98EEAB5582D340229E_1881839426 = (size == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_4873195 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_4873195;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.140 -0400", hash_original_method = "0351D580B43E9823D3890B3F7A27BB60", hash_generated_method = "CA6E45DEFB6F94E668B381F4F77C236A")
        public boolean contains(Object obj) {
            addTaint(obj.getTaint());
            if(!(obj instanceof Entry))            
            {
                boolean var68934A3E9455FA72420237EB05902327_2094359482 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_378348231 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_378348231;
            } //End block
            Entry<?, ?, ?> entry = (Entry<?, ?, ?>) obj;
            Entry<E, K, V> entry2 = findEntry(entry.getKey1(), entry.getKey2());
            if(entry2 == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_2069520009 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499737210 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499737210;
            } //End block
            Object value = entry.getValue();
            Object value2 = entry2.getValue();
            boolean var1B289607B97035EE44BC8F983777E683_2104292862 = (value == null ? value2 == null : value.equals(value2));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1184567736 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1184567736;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.140 -0400", hash_original_method = "30A2FA02E1530F63F4EB8959C457654B", hash_generated_method = "3939D91BA3610B4F57F00CB6235343FF")
        public boolean remove(Object obj) {
            addTaint(obj.getTaint());
            if(!(obj instanceof Entry))            
            {
                boolean var68934A3E9455FA72420237EB05902327_85400120 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1805370109 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1805370109;
            } //End block
            boolean var8F5C55C6469D40181FED57850D6554A2_2056944598 = (removeEntry(((Entry) obj).getKey1(), ((Entry) obj).getKey2()) != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_586177925 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_586177925;
            // ---------- Original Method ----------
            //if (!(obj instanceof Entry)) {
                //return false;
            //}
            //return removeEntry(((Entry) obj).getKey1(), ((Entry) obj).getKey2()) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.141 -0400", hash_original_method = "820C2D57E851A82BD3B2742370FA728A", hash_generated_method = "9A67F8070FB3AFF96D18287745D62CBC")
        public Iterator<Map.Entry<String, V>> iterator() {
Iterator<Map.Entry<String, V>> var14AEF51E68502241E0E8311B58D0F4CA_443058795 =             createEntrySetIterator();
            var14AEF51E68502241E0E8311B58D0F4CA_443058795.addTaint(taint);
            return var14AEF51E68502241E0E8311B58D0F4CA_443058795;
            // ---------- Original Method ----------
            //return createEntrySetIterator();
        }

        
    }


    
    class EntryIteratorImpl implements Iterator<Map.Entry<String, V>> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.141 -0400", hash_original_field = "80E557AEBBB542A89F16261A24CEC107", hash_generated_field = "B4C5A8998384DD2BFFBA01B52B5A43F1")

        private int startModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.141 -0400", hash_original_field = "6CFE61694EE1BB13AE719D47C2F80B7A", hash_generated_field = "A24795FFAF6F71C43D54678ACBE48727")

        private boolean found;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.141 -0400", hash_original_field = "D8BFB05268C3F10F56D2E317116E092F", hash_generated_field = "5246D1500CC51F8F9763D7817E7866E1")

        private int curr = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.141 -0400", hash_original_field = "8C1AFCF80C11DFC9B00A5AA1A18FF85B", hash_generated_field = "9B36237E7FADCCC12E7D5892AF7FF998")

        private int returned_index = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.141 -0400", hash_original_field = "4D68C10F64A8B575EA358BB9796F7290", hash_generated_field = "EAAB6E203DE27FDA0DA70E7B83C4808C")

        private Entry<E, K, V> curr_entry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.141 -0400", hash_original_field = "65384B1BED378C7A7453F2DA54B739A6", hash_generated_field = "FCA5E17EE5CF26E634230F4C2907BA4F")

        private Entry<E, K, V> returned_entry;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.142 -0400", hash_original_method = "E708A38A6B1072C269DF2FC2A57F4EEE", hash_generated_method = "795363C7EF8F0A7D3A2E876BD06BA763")
          EntryIteratorImpl() {
            startModCount = modCount;
            // ---------- Original Method ----------
            //startModCount = modCount;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.142 -0400", hash_original_method = "2E6F84DE8CBAE5EA419B2332CF98801C", hash_generated_method = "FD0C7BEB5F70C78DF3026ABC4771571C")
        public boolean hasNext() {
            if(found)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_545992969 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1164870471 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1164870471;
            } //End block
            if(curr_entry != null)            
            {
                curr_entry = curr_entry.next;
            } //End block
            if(curr_entry == null)            
            {
for(curr++;curr < arr.length && arr[curr] == null;curr++)
                {
                } //End block
                if(curr < arr.length)                
                {
                    curr_entry = arr[curr];
                } //End block
            } //End block
            boolean var216754F5C9B0D9A13F1128B49DB8363C_27325297 = (found = (curr_entry != null));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_548775096 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_548775096;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.144 -0400", hash_original_method = "4A9B66986403EF804F6712808B1107B5", hash_generated_method = "C5F4673C18355418DE7D7CD9FB93D866")
        public Map.Entry<String, V> next() {
            if(modCount != startModCount)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_496281109 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_496281109.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_496281109;
            } //End block
            if(!hasNext())            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1520863527 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1520863527.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1520863527;
            } //End block
            found = false;
            returned_index = curr;
            returned_entry = curr_entry;
Map.Entry<String, V> var0E82C5A158A65061F6724C3C1498CE33_1940066595 =             (Map.Entry<String, V>) curr_entry;
            var0E82C5A158A65061F6724C3C1498CE33_1940066595.addTaint(taint);
            return var0E82C5A158A65061F6724C3C1498CE33_1940066595;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.146 -0400", hash_original_method = "5DECA7771A914CFF4F808726B9F33811", hash_generated_method = "9E8A238AB8C1838A2864FE4F5685B38C")
        public void remove() {
            if(returned_index == -1)            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_2002251258 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_2002251258.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_2002251258;
            } //End block
            if(modCount != startModCount)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_743669331 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_743669331.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_743669331;
            } //End block
            Entry<E, K, V> p = null;
            Entry<E, K, V> e = arr[returned_index];
            while
(e != returned_entry)            
            {
                p = e;
                e = e.next;
            } //End block
            if(p != null)            
            {
                p.next = returned_entry.next;
            } //End block
            else
            {
                arr[returned_index] = returned_entry.next;
            } //End block
            size--;
            modCount++;
            startModCount++;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.147 -0400", hash_original_method = "3C90742D57762549FF961ACAAF6110EC", hash_generated_method = "3C90742D57762549FF961ACAAF6110EC")
        public ValuesCollectionImpl ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.147 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "034993C3DE600C94ADA4338A607719FB")
        public int size() {
            int varF7BD60B75B29D79B660A2859395C1A24_475459148 = (size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586566617 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586566617;
            // ---------- Original Method ----------
            //return size;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.147 -0400", hash_original_method = "AE463F3857FBE52FC47F5CD4A94D1EE6", hash_generated_method = "CB1BBFA30FC78A80159E3DCADA51A3C9")
        public void clear() {
            TwoKeyHashMap.this.clear();
            // ---------- Original Method ----------
            //TwoKeyHashMap.this.clear();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.147 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "51BB53816631CFFE347FB0591CBF90E1")
        public boolean isEmpty() {
            boolean var9FB8BC7F775DDD98EEAB5582D340229E_989276872 = (size == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2016705356 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2016705356;
            // ---------- Original Method ----------
            //return size == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.148 -0400", hash_original_method = "680FD22D8DB10527F3174FA8865D96E7", hash_generated_method = "468FE5046A1BC8B024119F3106A56133")
        public Iterator<V> iterator() {
Iterator<V> varFA13F1FC571FA0A48E63CCBACC5FD2F6_1698676617 =             createValueCollectionIterator();
            varFA13F1FC571FA0A48E63CCBACC5FD2F6_1698676617.addTaint(taint);
            return varFA13F1FC571FA0A48E63CCBACC5FD2F6_1698676617;
            // ---------- Original Method ----------
            //return createValueCollectionIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.148 -0400", hash_original_method = "74702C44933E62600B2ED3E7307D82B0", hash_generated_method = "65B0B7ADC3AC59AF1C368CB9E56D6515")
        public boolean contains(Object obj) {
            addTaint(obj.getTaint());
            boolean var49ECC502DED1C41872A01FD09C4F67E3_811163840 = (containsValue(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_811331034 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_811331034;
            // ---------- Original Method ----------
            //return containsValue(obj);
        }

        
    }


    
    class ValueIteratorImpl implements Iterator<V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.149 -0400", hash_original_field = "62FCE98555002A61A6DA4D29476B0A9F", hash_generated_field = "48025B493C25248658D4DBBDCE3A3E0F")

        private EntryIteratorImpl itr;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.149 -0400", hash_original_method = "5B2B0240442A661D6F35A8FA67A7469B", hash_generated_method = "FAA2EFD99674487E058F0C99576A9B8D")
          ValueIteratorImpl() {
            this.itr = new EntryIteratorImpl();
            // ---------- Original Method ----------
            //this.itr = new EntryIteratorImpl();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.149 -0400", hash_original_method = "351E0C8E290AF7E9E6FFA36B6DF7C9FA", hash_generated_method = "0F0055ADF7447ABE83988AF7DAAFDA9B")
        public V next() {
V var38C1C07DB5894AF0B7B800444D7089FE_1195039970 =             itr.next().getValue();
            var38C1C07DB5894AF0B7B800444D7089FE_1195039970.addTaint(taint);
            return var38C1C07DB5894AF0B7B800444D7089FE_1195039970;
            // ---------- Original Method ----------
            //return itr.next().getValue();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.149 -0400", hash_original_method = "C9ED4E1E548B82ACF6AA423D5E0C3E8C", hash_generated_method = "F1B26A301CD95E7A3CF3E96C8421A61D")
        public void remove() {
            itr.remove();
            // ---------- Original Method ----------
            //itr.remove();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.150 -0400", hash_original_method = "0093C9D638C4ECB39AFF8230D36DFCB0", hash_generated_method = "1B9B9366BBF44A736612B03D1128D651")
        public boolean hasNext() {
            boolean var2E059FDD0916F8B7ED700AC082E399BC_1705753416 = (itr.hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_152043535 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_152043535;
            // ---------- Original Method ----------
            //return itr.hasNext();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.150 -0400", hash_original_field = "DF48F8D92FC36ACC8968654109C53FC4", hash_generated_field = "A8CC9CBDCFEE884AAACD2650D6276B04")

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.150 -0400", hash_original_field = "DA4109A0CC3182799ED4F6C2DDA24CF9", hash_generated_field = "EA69D1A7FA6057000A0CB80BAF0F0ADB")

    static final int DEFAULT_INITIAL_SIZE = 16;
}


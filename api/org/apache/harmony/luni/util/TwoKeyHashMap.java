package org.apache.harmony.luni.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.468 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "922E9E523E3B4B4E0BBECCC2419D9A8A")

    private Set<Map.Entry<String, V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.468 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "0CA88E23C485E63FB3BB9610D40E8264")

    private Collection<V> values;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.468 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.468 -0400", hash_original_field = "DFEF811547BBC141513674AE42682230", hash_generated_field = "316FD2AB259DA26036E31C0D78278AE7")

    private int arrSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.468 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "444771311A9B09F69D7C8D75C59C2BBB")

    private int modCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.468 -0400", hash_original_field = "47C80780AB608CC046F2A6E6F071FEB6", hash_generated_field = "8E4CC84ABB20D75F51E93933E0A59066")

    private Entry<E, K, V>[] arr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.469 -0400", hash_original_field = "97C293EF8ABD832D29E88C21D8E562F5", hash_generated_field = "4BC2677DD136E3CB5AE0C48B0EDF5A53")

    private float loadFactor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.469 -0400", hash_original_field = "70D6CECF8D97F10969A69F5BF3BDD295", hash_generated_field = "F9A5F8AF6E8A641C6C49EB5204F6EF63")

    int threshold = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.469 -0400", hash_original_method = "294B6DEE36941009B0B201B0BEC2DD67", hash_generated_method = "E45D157C82C9A0D27E45C7E8FDC413D5")
    public  TwoKeyHashMap() {
        this(DEFAULT_INITIAL_SIZE, DEFAULT_LOAD_FACTOR);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.469 -0400", hash_original_method = "E595C77056089A502D8DE33B445FC550", hash_generated_method = "8A450F5AB8941E4B262790914C952160")
    public  TwoKeyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
        addTaint(initialCapacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.470 -0400", hash_original_method = "679241DAB133FCD723055BFD98A1C12B", hash_generated_method = "9329D104F8E9FE493A26274215BC1F49")
    @SuppressWarnings("unchecked")
    public  TwoKeyHashMap(int initialCapacity, float initialLoadFactor) {
    if(initialCapacity < 0)        
        {
            IllegalArgumentException var0A877F35152ACC09293597AA0CA40C38_510563901 = new IllegalArgumentException("initialCapacity should be >= 0");
            var0A877F35152ACC09293597AA0CA40C38_510563901.addTaint(taint);
            throw var0A877F35152ACC09293597AA0CA40C38_510563901;
        } 
    if(initialLoadFactor <= 0)        
        {
            IllegalArgumentException var2896D4B56FBA4EF31B67FCCC04385A32_97780646 = new IllegalArgumentException(
                    "initialLoadFactor should be > 0");
            var2896D4B56FBA4EF31B67FCCC04385A32_97780646.addTaint(taint);
            throw var2896D4B56FBA4EF31B67FCCC04385A32_97780646;
        } 
        loadFactor = initialLoadFactor;
    if(initialCapacity == Integer.MAX_VALUE)        
        {
            initialCapacity--;
        } 
        arrSize = initialCapacity > 0 ? initialCapacity : 1;
        threshold = (int) (arrSize * loadFactor);
        arr = new Entry[arrSize + 1];
        
        
            
        
        
            
                    
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.471 -0400", hash_original_method = "66B88A01F8296942609EF87ACA0E012C", hash_generated_method = "5CEB66AB832B5CB52AFC660A400BDA72")
    public Collection<V> values() {
    if(values == null)        
        {
            values = new ValuesCollectionImpl();
        } 
Collection<V> var674B10C763DBAAF9696AD9A3DDAE07B3_1756504561 =         values;
        var674B10C763DBAAF9696AD9A3DDAE07B3_1756504561.addTaint(taint);
        return var674B10C763DBAAF9696AD9A3DDAE07B3_1756504561;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.471 -0400", hash_original_method = "56D76EA36DEC4CA5689518DF65F0FB11", hash_generated_method = "03EA351B8DD7725FEB78DDADF81FDD97")
    public Set<Map.Entry<String, V>> entrySet() {
    if(entrySet == null)        
        {
            entrySet = new EntrySetImpl();
        } 
Set<Map.Entry<String, V>> var844F1DC6137EC02DBA16CAD3ADE04B13_1192492286 =         entrySet;
        var844F1DC6137EC02DBA16CAD3ADE04B13_1192492286.addTaint(taint);
        return var844F1DC6137EC02DBA16CAD3ADE04B13_1192492286;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.471 -0400", hash_original_method = "818EB47C54D790B2A626C59717AA13C9", hash_generated_method = "D8F3DDDEF4CB3BA5796A4BE244A81452")
    public void clear() {
        modCount++;
        size = 0;
        Arrays.fill(arr, 0, arr.length, null);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.472 -0400", hash_original_method = "FFF3CF52B9B0B5141C3665D271E08CFC", hash_generated_method = "6E1F3DBB771CC63153F259DBFD2A41E4")
    public V remove(Object key1, Object key2) {
        addTaint(key2.getTaint());
        addTaint(key1.getTaint());
        Entry<E, K, V> e = removeEntry(key1, key2);
V var9A2106950A51C9551E1CF534E2C1C0D6_1549816169 =         (e != null) ? e.value : null;
        var9A2106950A51C9551E1CF534E2C1C0D6_1549816169.addTaint(taint);
        return var9A2106950A51C9551E1CF534E2C1C0D6_1549816169;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.473 -0400", hash_original_method = "8D27DE23631F09453D73093F15998EF0", hash_generated_method = "C6D34BC9108482AC5BFDDED96199309B")
    public V put(E key1, K key2, V value) {
    if(key1 == null && key2 == null)        
        {
            int index = arrSize;
    if(arr[index] == null)            
            {
                arr[index] = createEntry(0, null, null, value, null);
                size++;
                modCount++;
V var540C13E9E156B687226421B24F2DF178_1079738899 =                 null;
                var540C13E9E156B687226421B24F2DF178_1079738899.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1079738899;
            } 
            else
            {
                V oldValue = arr[index].value;
                arr[index].value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_899736059 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_899736059.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_899736059;
            } 
        } 
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
V var8CDBD2181CBEF5C2129AFFA68C014D4A_1220271275 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_1220271275.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_1220271275;
            } 
            e = e.next;
        } 
        arr[index] = createEntry(hash, key1, key2, value, arr[index]);
        size++;
        modCount++;
    if(size > threshold)        
        {
            rehash();
        } 
V var540C13E9E156B687226421B24F2DF178_654540709 =         null;
        var540C13E9E156B687226421B24F2DF178_654540709.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_654540709;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.475 -0400", hash_original_method = "4E92EE4014ABA801EB273C60A5958799", hash_generated_method = "B1A9862083B080C77260CDE5CD0C202B")
    @SuppressWarnings("unchecked")
     void rehash() {
        int newArrSize = (arrSize + 1) * 2 + 1;
    if(newArrSize < 0)        
        {
            newArrSize = Integer.MAX_VALUE - 1;
        } 
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
            } 
        } 
        newArr[newArrSize] = arr[arrSize];
        arrSize = newArrSize;
    if(arrSize == Integer.MAX_VALUE)        
        {
            loadFactor *= 10;
        } 
        threshold = (int) (arrSize * loadFactor);
        arr = newArr;
        
        
        
            
        
        
        
            
            
                
                
                
                
                
            
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.475 -0400", hash_original_method = "31FF250303275620FA0192DC25A0041E", hash_generated_method = "6199CA202D4BD391B6EEDE455B86A5A3")
    public boolean containsKey(Object key1, Object key2) {
        addTaint(key2.getTaint());
        addTaint(key1.getTaint());
        boolean varD43818A8336024C58ED250A3F811D712_435324726 = (findEntry(key1, key2) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174069644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174069644;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.476 -0400", hash_original_method = "E13BBD09CFB92FF506FEC56FABF87B9F", hash_generated_method = "52B45E4A9492F051B407A387A0B1865B")
    public V get(Object key1, Object key2) {
        addTaint(key2.getTaint());
        addTaint(key1.getTaint());
        Entry<E, K, V> e = findEntry(key1, key2);
    if(e != null)        
        {
V var65D32B0ADAFF3F55986024909BAFC34B_1821588765 =             e.value;
            var65D32B0ADAFF3F55986024909BAFC34B_1821588765.addTaint(taint);
            return var65D32B0ADAFF3F55986024909BAFC34B_1821588765;
        } 
V var540C13E9E156B687226421B24F2DF178_456901297 =         null;
        var540C13E9E156B687226421B24F2DF178_456901297.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_456901297;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.476 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "930EB8B26277C15A53827C35E60DF686")
    public boolean isEmpty() {
        boolean var9FB8BC7F775DDD98EEAB5582D340229E_958907105 = (size == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_195845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_195845;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.476 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "F6D29778425257C6391B0D56D17D9CA4")
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1752444765 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842646297 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842646297;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.477 -0400", hash_original_method = "B126004260D8EBAD1640E464F002A4A4", hash_generated_method = "9F87AEBCC75366205237E009605F9FD5")
     Entry<E, K, V> createEntry(int hashCode, E key1, K key2, V value,
            Entry<E, K, V> next) {
        addTaint(next.getTaint());
        addTaint(value.getTaint());
        addTaint(key2.getTaint());
        addTaint(key1.getTaint());
        addTaint(hashCode);
Entry<E, K, V> var2C18A0A8AF7077C354443EE552A67DB0_864000388 =         new Entry<E, K, V>(hashCode, key1, key2, value, next);
        var2C18A0A8AF7077C354443EE552A67DB0_864000388.addTaint(taint);
        return var2C18A0A8AF7077C354443EE552A67DB0_864000388;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.477 -0400", hash_original_method = "F4E18AFB5A6BD2866D211174F2C65244", hash_generated_method = "5B8CACDE31F7BDBCAB1DFAA9A5612F04")
     Iterator<Map.Entry<String, V>> createEntrySetIterator() {
Iterator<Map.Entry<String, V>> varA8EA1EF1323C8ED28EB1F0576287C6FE_1482821396 =         new EntryIteratorImpl();
        varA8EA1EF1323C8ED28EB1F0576287C6FE_1482821396.addTaint(taint);
        return varA8EA1EF1323C8ED28EB1F0576287C6FE_1482821396;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.477 -0400", hash_original_method = "6209E5C519243BC33CB9A47AFA9E017F", hash_generated_method = "39F1E02B3A4ECCC9FD2905308F33698F")
     Iterator<V> createValueCollectionIterator() {
Iterator<V> varED1FEEF907E41228C2F16F509E697FD4_42718973 =         new ValueIteratorImpl();
        varED1FEEF907E41228C2F16F509E697FD4_42718973.addTaint(taint);
        return varED1FEEF907E41228C2F16F509E697FD4_42718973;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.478 -0400", hash_original_method = "C152D61E326241B091FB8EBCBC5C9180", hash_generated_method = "C2E07FBE3579F7B54CCC4053D04A43AA")
    private final Entry<E, K, V> findEntry(Object key1, Object key2) {
        addTaint(key2.getTaint());
        addTaint(key1.getTaint());
    if(key1 == null && key2 == null)        
        {
Entry<E, K, V> var9370A07A76DB50A17B85C7AC557133DB_713785317 =             arr[arrSize];
            var9370A07A76DB50A17B85C7AC557133DB_713785317.addTaint(taint);
            return var9370A07A76DB50A17B85C7AC557133DB_713785317;
        } 
        int hash = key1.hashCode() + key2.hashCode();
        int index = (hash & 0x7fffffff) % arrSize;
        Entry<E, K, V> e = arr[index];
        while
(e != null)        
        {
    if(hash == e.hash && key1.equals(e.getKey1())
                    && key2.equals(e.getKey2()))            
            {
Entry<E, K, V> var6BFFBFA2F1D556BA80433C2335198CE9_1224046584 =                 e;
                var6BFFBFA2F1D556BA80433C2335198CE9_1224046584.addTaint(taint);
                return var6BFFBFA2F1D556BA80433C2335198CE9_1224046584;
            } 
            e = e.next;
        } 
Entry<E, K, V> var540C13E9E156B687226421B24F2DF178_210997028 =         null;
        var540C13E9E156B687226421B24F2DF178_210997028.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_210997028;
        
        
            
        
        
        
        
        
            
                    
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.479 -0400", hash_original_method = "C98DB123D4E5CC84B2492FBCF56B145D", hash_generated_method = "46F7725F8175662C78942A9D34C9EA34")
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
Entry<E, K, V> varEDFF4FBBF053B5DC2B444ADFA049EE0F_450576482 =                 ret;
                varEDFF4FBBF053B5DC2B444ADFA049EE0F_450576482.addTaint(taint);
                return varEDFF4FBBF053B5DC2B444ADFA049EE0F_450576482;
            } 
Entry<E, K, V> var540C13E9E156B687226421B24F2DF178_1408415546 =             null;
            var540C13E9E156B687226421B24F2DF178_1408415546.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1408415546;
        } 
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
                } 
                else
                {
                    prev.next = e.next;
                } 
                size--;
                modCount++;
Entry<E, K, V> var6BFFBFA2F1D556BA80433C2335198CE9_2116619073 =                 e;
                var6BFFBFA2F1D556BA80433C2335198CE9_2116619073.addTaint(taint);
                return var6BFFBFA2F1D556BA80433C2335198CE9_2116619073;
            } 
            prev = e;
            e = e.next;
        } 
Entry<E, K, V> var540C13E9E156B687226421B24F2DF178_312899 =         null;
        var540C13E9E156B687226421B24F2DF178_312899.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_312899;
        
        
    }

    
    public static class Entry<E, K, V> implements Map.Entry<String, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.480 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.480 -0400", hash_original_field = "C2ADD694BF942DC77B376592D9C862CD", hash_generated_field = "FF2F76F560606089FC32D051F70C3BCF")

        E key1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.480 -0400", hash_original_field = "78F825AAA0103319AAA1A30BF4FE3ADA", hash_generated_field = "DE7247D222A6A88790AAD9007484F2CE")

        K key2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.480 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.480 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "041FC26789DCA96E16327DF3859848D1")

        Entry<E, K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.481 -0400", hash_original_method = "3E3A99A3B7891AEE573C3F0F98EEE3AE", hash_generated_method = "6DEBEC5295235A0ED788B9F66F6D400D")
        public  Entry(int hash, E key1, K key2, V value, Entry<E, K, V> next) {
            this.hash = hash;
            this.key1 = key1;
            this.key2 = key2;
            this.value = value;
            this.next = next;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.481 -0400", hash_original_method = "43A91F8C54B90BC0F4C951BCB1425B25", hash_generated_method = "5DFD23AD18848C6FD57654ACADF59657")
        public String getKey() {
String var68CFAAB40FE81B389C40EF166B3D7E7E_213744972 =             key1.toString() + key2.toString();
            var68CFAAB40FE81B389C40EF166B3D7E7E_213744972.addTaint(taint);
            return var68CFAAB40FE81B389C40EF166B3D7E7E_213744972;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.482 -0400", hash_original_method = "8E21854AE9ADC89A1868BC4522219FB2", hash_generated_method = "8DFD230B0FD9F4CD082F00FFA2566548")
        public E getKey1() {
E var1DFC6AC0D2D727F36FD87608E8DCDD41_1856608871 =             key1;
            var1DFC6AC0D2D727F36FD87608E8DCDD41_1856608871.addTaint(taint);
            return var1DFC6AC0D2D727F36FD87608E8DCDD41_1856608871;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.482 -0400", hash_original_method = "7F02D1AD568FC6C2F60475D661F743CB", hash_generated_method = "B62D0B8CF563DBC526DC0066E22DBF79")
        public K getKey2() {
K varA654CD75EFA94D4E93625838DEFFD3AA_1987279601 =             key2;
            varA654CD75EFA94D4E93625838DEFFD3AA_1987279601.addTaint(taint);
            return varA654CD75EFA94D4E93625838DEFFD3AA_1987279601;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.482 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "2CF503B2C3D78BC67F15E57C4543CB1A")
        public V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_1717202123 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_1717202123.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_1717202123;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.483 -0400", hash_original_method = "B73895AEE255DB24C138E57D2456050E", hash_generated_method = "9B2005B85ED4E9772492B559F564BFAC")
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
V var8CDBD2181CBEF5C2129AFFA68C014D4A_990485515 =             oldValue;
            var8CDBD2181CBEF5C2129AFFA68C014D4A_990485515.addTaint(taint);
            return var8CDBD2181CBEF5C2129AFFA68C014D4A_990485515;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.483 -0400", hash_original_method = "2C745FE5DF9CE9CA09289DC08E07F848", hash_generated_method = "7BD09DF51AD1B9D533F16D9FF635D0E4")
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
    if(!(obj instanceof Entry))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1016649879 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073445346 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073445346;
            } 
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
                boolean var68934A3E9455FA72420237EB05902327_1587147870 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1530639855 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1530639855;
            } 
            boolean varB326B5062B2F0E69046810717534CB09_63200742 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1767333054 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1767333054;
            
            
                
            
            
            
            
            
            
                    
                    
                    
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.484 -0400", hash_original_method = "57C89921FB9688640B9C568340F7B69C", hash_generated_method = "26C9EAED74D2C099FF4CFA0FC30709C2")
        public int hashCode() {
            int hash1 = (key1 == null ? 0 : key1.hashCode());
            int hash2 = (key2 == null ? 0 : key2.hashCode());
            int var7A5A2898A05093C44E45CD578D1E5BEB_1254637639 = ((hash1 + hash2) ^ (value == null ? 0 : value.hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536327963 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536327963;
            
            
            
            
        }

        
    }


    
    class EntrySetImpl extends AbstractSet<Map.Entry<String, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.484 -0400", hash_original_method = "403B9BE439CBD0FBC0501C0EDC2D9426", hash_generated_method = "403B9BE439CBD0FBC0501C0EDC2D9426")
        public EntrySetImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.484 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "5CFA92B7684E20FBE7C8E145353AF7D4")
        public int size() {
            int varF7BD60B75B29D79B660A2859395C1A24_1760552253 = (size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_54073434 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_54073434;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.484 -0400", hash_original_method = "AE463F3857FBE52FC47F5CD4A94D1EE6", hash_generated_method = "CB1BBFA30FC78A80159E3DCADA51A3C9")
        public void clear() {
            TwoKeyHashMap.this.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.484 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "515B4F7D70776143A517473C321728CA")
        public boolean isEmpty() {
            boolean var9FB8BC7F775DDD98EEAB5582D340229E_1426568607 = (size == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1693574078 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1693574078;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.485 -0400", hash_original_method = "0351D580B43E9823D3890B3F7A27BB60", hash_generated_method = "0A88A391C126B264E2F69CBAAFF9B29A")
        public boolean contains(Object obj) {
            addTaint(obj.getTaint());
    if(!(obj instanceof Entry))            
            {
                boolean var68934A3E9455FA72420237EB05902327_2042008005 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_999024678 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_999024678;
            } 
            Entry<?, ?, ?> entry = (Entry<?, ?, ?>) obj;
            Entry<E, K, V> entry2 = findEntry(entry.getKey1(), entry.getKey2());
    if(entry2 == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1534811517 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1758279968 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1758279968;
            } 
            Object value = entry.getValue();
            Object value2 = entry2.getValue();
            boolean var1B289607B97035EE44BC8F983777E683_310917816 = (value == null ? value2 == null : value.equals(value2));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1549263919 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1549263919;
            
            
                
            
            
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.485 -0400", hash_original_method = "30A2FA02E1530F63F4EB8959C457654B", hash_generated_method = "9A6CBF3A4380BD3FA24612FA797552BB")
        public boolean remove(Object obj) {
            addTaint(obj.getTaint());
    if(!(obj instanceof Entry))            
            {
                boolean var68934A3E9455FA72420237EB05902327_733792525 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_701699097 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_701699097;
            } 
            boolean var8F5C55C6469D40181FED57850D6554A2_279909828 = (removeEntry(((Entry) obj).getKey1(), ((Entry) obj).getKey2()) != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2048164085 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2048164085;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.486 -0400", hash_original_method = "820C2D57E851A82BD3B2742370FA728A", hash_generated_method = "96155CDCC7CE7BFBA44911E6EAA76EB6")
        public Iterator<Map.Entry<String, V>> iterator() {
Iterator<Map.Entry<String, V>> var14AEF51E68502241E0E8311B58D0F4CA_477343067 =             createEntrySetIterator();
            var14AEF51E68502241E0E8311B58D0F4CA_477343067.addTaint(taint);
            return var14AEF51E68502241E0E8311B58D0F4CA_477343067;
            
            
        }

        
    }


    
    class EntryIteratorImpl implements Iterator<Map.Entry<String, V>> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.486 -0400", hash_original_field = "80E557AEBBB542A89F16261A24CEC107", hash_generated_field = "B4C5A8998384DD2BFFBA01B52B5A43F1")

        private int startModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.486 -0400", hash_original_field = "6CFE61694EE1BB13AE719D47C2F80B7A", hash_generated_field = "A24795FFAF6F71C43D54678ACBE48727")

        private boolean found;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.486 -0400", hash_original_field = "D8BFB05268C3F10F56D2E317116E092F", hash_generated_field = "5246D1500CC51F8F9763D7817E7866E1")

        private int curr = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.486 -0400", hash_original_field = "8C1AFCF80C11DFC9B00A5AA1A18FF85B", hash_generated_field = "9B36237E7FADCCC12E7D5892AF7FF998")

        private int returned_index = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.486 -0400", hash_original_field = "4D68C10F64A8B575EA358BB9796F7290", hash_generated_field = "EAAB6E203DE27FDA0DA70E7B83C4808C")

        private Entry<E, K, V> curr_entry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.486 -0400", hash_original_field = "65384B1BED378C7A7453F2DA54B739A6", hash_generated_field = "FCA5E17EE5CF26E634230F4C2907BA4F")

        private Entry<E, K, V> returned_entry;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.487 -0400", hash_original_method = "E708A38A6B1072C269DF2FC2A57F4EEE", hash_generated_method = "795363C7EF8F0A7D3A2E876BD06BA763")
          EntryIteratorImpl() {
            startModCount = modCount;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.487 -0400", hash_original_method = "2E6F84DE8CBAE5EA419B2332CF98801C", hash_generated_method = "3968A2F2ABED8B78D8F77CF31EA2F47F")
        public boolean hasNext() {
    if(found)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_257906640 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1937503289 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1937503289;
            } 
    if(curr_entry != null)            
            {
                curr_entry = curr_entry.next;
            } 
    if(curr_entry == null)            
            {
for(curr++;curr < arr.length && arr[curr] == null;curr++)
                {
                } 
    if(curr < arr.length)                
                {
                    curr_entry = arr[curr];
                } 
            } 
            boolean var216754F5C9B0D9A13F1128B49DB8363C_2051369183 = (found = (curr_entry != null));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1229741092 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1229741092;
            
            
                
            
            
                
            
            
                
                
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.488 -0400", hash_original_method = "4A9B66986403EF804F6712808B1107B5", hash_generated_method = "A13CEB0359EACD4E2BB7F2890F1ACDF3")
        public Map.Entry<String, V> next() {
    if(modCount != startModCount)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1156527986 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_1156527986.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_1156527986;
            } 
    if(!hasNext())            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1781313835 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1781313835.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1781313835;
            } 
            found = false;
            returned_index = curr;
            returned_entry = curr_entry;
Map.Entry<String, V> var0E82C5A158A65061F6724C3C1498CE33_2122584028 =             (Map.Entry<String, V>) curr_entry;
            var0E82C5A158A65061F6724C3C1498CE33_2122584028.addTaint(taint);
            return var0E82C5A158A65061F6724C3C1498CE33_2122584028;
            
            
                
            
            
                
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.489 -0400", hash_original_method = "5DECA7771A914CFF4F808726B9F33811", hash_generated_method = "70D801870F44A09C9AD434942F45D4A2")
        public void remove() {
    if(returned_index == -1)            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_627850403 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_627850403.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_627850403;
            } 
    if(modCount != startModCount)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_681039853 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_681039853.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_681039853;
            } 
            Entry<E, K, V> p = null;
            Entry<E, K, V> e = arr[returned_index];
            while
(e != returned_entry)            
            {
                p = e;
                e = e.next;
            } 
    if(p != null)            
            {
                p.next = returned_entry.next;
            } 
            else
            {
                arr[returned_index] = returned_entry.next;
            } 
            size--;
            modCount++;
            startModCount++;
            returned_index = -1;
            
            
                
            
            
                
            
            
            
            
                
                
            
            
                
            
                
            
            
            
            
            
        }

        
    }


    
    class ValuesCollectionImpl extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.490 -0400", hash_original_method = "3C90742D57762549FF961ACAAF6110EC", hash_generated_method = "3C90742D57762549FF961ACAAF6110EC")
        public ValuesCollectionImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.490 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "1F10BF7D23D0CB856DA24A7E0026988B")
        public int size() {
            int varF7BD60B75B29D79B660A2859395C1A24_1196992454 = (size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1355601234 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1355601234;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.490 -0400", hash_original_method = "AE463F3857FBE52FC47F5CD4A94D1EE6", hash_generated_method = "CB1BBFA30FC78A80159E3DCADA51A3C9")
        public void clear() {
            TwoKeyHashMap.this.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.491 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "2103BA03A9276EE6240B35AD06055846")
        public boolean isEmpty() {
            boolean var9FB8BC7F775DDD98EEAB5582D340229E_1229047549 = (size == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682437945 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_682437945;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.491 -0400", hash_original_method = "680FD22D8DB10527F3174FA8865D96E7", hash_generated_method = "D5793D29F3443E181A952D083C8EA50D")
        public Iterator<V> iterator() {
Iterator<V> varFA13F1FC571FA0A48E63CCBACC5FD2F6_1495764750 =             createValueCollectionIterator();
            varFA13F1FC571FA0A48E63CCBACC5FD2F6_1495764750.addTaint(taint);
            return varFA13F1FC571FA0A48E63CCBACC5FD2F6_1495764750;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.491 -0400", hash_original_method = "74702C44933E62600B2ED3E7307D82B0", hash_generated_method = "0BB6700615D9505A1D45406E933F497C")
        public boolean contains(Object obj) {
            addTaint(obj.getTaint());
            boolean var49ECC502DED1C41872A01FD09C4F67E3_1096690410 = (containsValue(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_706683658 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_706683658;
            
            
        }

        
    }


    
    class ValueIteratorImpl implements Iterator<V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.491 -0400", hash_original_field = "62FCE98555002A61A6DA4D29476B0A9F", hash_generated_field = "48025B493C25248658D4DBBDCE3A3E0F")

        private EntryIteratorImpl itr;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.492 -0400", hash_original_method = "5B2B0240442A661D6F35A8FA67A7469B", hash_generated_method = "FAA2EFD99674487E058F0C99576A9B8D")
          ValueIteratorImpl() {
            this.itr = new EntryIteratorImpl();
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.492 -0400", hash_original_method = "351E0C8E290AF7E9E6FFA36B6DF7C9FA", hash_generated_method = "E2FD7E0D42EE80A532CAA10D24838896")
        public V next() {
V var38C1C07DB5894AF0B7B800444D7089FE_1813698989 =             itr.next().getValue();
            var38C1C07DB5894AF0B7B800444D7089FE_1813698989.addTaint(taint);
            return var38C1C07DB5894AF0B7B800444D7089FE_1813698989;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.492 -0400", hash_original_method = "C9ED4E1E548B82ACF6AA423D5E0C3E8C", hash_generated_method = "F1B26A301CD95E7A3CF3E96C8421A61D")
        public void remove() {
            itr.remove();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.493 -0400", hash_original_method = "0093C9D638C4ECB39AFF8230D36DFCB0", hash_generated_method = "5322410BEDD642FCEEE5B044FBF2C9DD")
        public boolean hasNext() {
            boolean var2E059FDD0916F8B7ED700AC082E399BC_941509372 = (itr.hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1636287847 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1636287847;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.493 -0400", hash_original_field = "DF48F8D92FC36ACC8968654109C53FC4", hash_generated_field = "A8CC9CBDCFEE884AAACD2650D6276B04")

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.493 -0400", hash_original_field = "DA4109A0CC3182799ED4F6C2DDA24CF9", hash_generated_field = "EA69D1A7FA6057000A0CB80BAF0F0ADB")

    static final int DEFAULT_INITIAL_SIZE = 16;
}


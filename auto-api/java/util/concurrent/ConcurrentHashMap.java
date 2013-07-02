package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.concurrent.locks.*;
import java.util.*;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.273 -0400", hash_original_field = "6E087A676FE9EB60B1F8BDB5CE343DC8", hash_generated_field = "4BE7BE92627D08015B3B3DAF23AD6BAD")

    int segmentMask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.273 -0400", hash_original_field = "4CDE234FA7C6312E0DF85BE9485BF1E3", hash_generated_field = "306EF00C73243987FA23D1582323C779")

    int segmentShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.273 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "8FCA8AAE37A6D97176077745C90AB57A")

    Segment<K,V>[] segments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.273 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "B015B4740FB481B602A7C5EA08044E34")

    transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.273 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "8070B936D9AF3972F9E8198F31643848")

    transient Set<Map.Entry<K,V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.273 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "1963670AE696FF62CC56DF446CAA129C")

    transient Collection<V> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.274 -0400", hash_original_method = "E1CECF835D0BD6DA840C10527C435227", hash_generated_method = "573FFD7A58BAA3540642C4CE1BC14EC9")
    public  ConcurrentHashMap(int initialCapacity,
                             float loadFactor, int concurrencyLevel) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        concurrencyLevel = MAX_SEGMENTS;
        int sshift = 0;
        int ssize = 1;
        {
            ssize <<= 1;
        } 
        segmentShift = 32 - sshift;
        segmentMask = ssize - 1;
        this.segments = Segment.newArray(ssize);
        initialCapacity = MAXIMUM_CAPACITY;
        int c = initialCapacity / ssize;
        int cap = 1;
        cap <<= 1;
        {
            int i = 0;
            this.segments[i] = new Segment<K,V>(cap, loadFactor);
        } 
        addTaint(initialCapacity);
        addTaint(concurrencyLevel);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.274 -0400", hash_original_method = "1B0A2C6B75A6C9CD77B06A2BA6F95389", hash_generated_method = "E509032E9AF7FADEE74C211A10674A2E")
    public  ConcurrentHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, DEFAULT_CONCURRENCY_LEVEL);
        addTaint(initialCapacity);
        addTaint(loadFactor);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.274 -0400", hash_original_method = "FC082FCC77B50E96B6B6DB58BAB97957", hash_generated_method = "CDAAD7AE035E81DF97303AEAF9A04212")
    public  ConcurrentHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        addTaint(initialCapacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.274 -0400", hash_original_method = "DFADDF9198F2268E7EB2B4F062BE54B9", hash_generated_method = "D4298CEE30095C17DFF133A738118CBC")
    public  ConcurrentHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.275 -0400", hash_original_method = "485F32D8EAC40E4F4B6CB1DCBDB98D35", hash_generated_method = "2C160C28EF4E9BFFE4EEBFC23ADFDE48")
    public  ConcurrentHashMap(Map<? extends K, ? extends V> m) {
        this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,
                      DEFAULT_INITIAL_CAPACITY),
             DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        putAll(m);
        addTaint(m.getTaint());
        
        
    }

    
    private static int hash(int h) {
        h += (h <<  15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h <<   3);
        h ^= (h >>>  6);
        h += (h <<   2) + (h << 14);
        return h ^ (h >>> 16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.275 -0400", hash_original_method = "9480E4BE528687F57BD0A5E0057A4838", hash_generated_method = "6CACAF00BD54EC52398E52BA529A8692")
    final Segment<K,V> segmentFor(int hash) {
        Segment<K,V> varB4EAC82CA7396A68D541C85D26508E83_705957343 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_705957343 = segments[(hash >>> segmentShift) & segmentMask];
        addTaint(hash);
        varB4EAC82CA7396A68D541C85D26508E83_705957343.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_705957343;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.276 -0400", hash_original_method = "1D5F6259D73E7678D3D06BFBE271A26B", hash_generated_method = "4E8E64DE66B0518B60C772560E52D190")
    public boolean isEmpty() {
        final Segment<K,V>[] segments = this.segments;
        int[] mc = new int[segments.length];
        int mcsum = 0;
        {
            int i = 0;
            {
                mcsum += mc[i] = segments[i].modCount;
            } 
        } 
        {
            {
                int i = 0;
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600478655 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600478655;
        
        
        
        
        
            
                
            
                
        
        
            
                
                    
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.276 -0400", hash_original_method = "BA4A00EBCDE2550C0DA253B4E73A18FB", hash_generated_method = "FB7DB58FCB359636AE3A3CF5FAE56F59")
    public int size() {
        final Segment<K,V>[] segments = this.segments;
        long sum = 0;
        long check = 0;
        int[] mc = new int[segments.length];
        {
            int k = 0;
            {
                check = 0;
                sum = 0;
                int mcsum = 0;
                {
                    int i = 0;
                    {
                        sum += segments[i].count;
                        mcsum += mc[i] = segments[i].modCount;
                    } 
                } 
                {
                    {
                        int i = 0;
                        {
                            check += segments[i].count;
                            {
                                check = -1;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            sum = 0;
            {
                int i = 0;
                segments[i].lock();
            } 
            {
                int i = 0;
                sum += segments[i].count;
            } 
            {
                int i = 0;
                segments[i].unlock();
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534710788 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534710788;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.277 -0400", hash_original_method = "332CB84E85FBD8A2CB62BBB184B280CA", hash_generated_method = "E7E8290C4AB2A8E8D35E366DF72F46C8")
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1725122818 = null; 
        int hash = hash(key.hashCode());
        varB4EAC82CA7396A68D541C85D26508E83_1725122818 = segmentFor(hash).get(key, hash);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1725122818.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1725122818;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.277 -0400", hash_original_method = "6145F82DE390788BB7B29DCBC031D263", hash_generated_method = "ABDF3E8829936C6B26419CFF1AF33727")
    public boolean containsKey(Object key) {
        int hash = hash(key.hashCode());
        boolean varC72B072B37EFDE3DA0301245AE002A77_1195061989 = (segmentFor(hash).containsKey(key, hash));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_747289322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_747289322;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.278 -0400", hash_original_method = "F1AF23545DF8C9E4F21CC9D8D7EE161E", hash_generated_method = "529FD203C2DF47A4B11BEFD8DB5DEEF0")
    public boolean containsValue(Object value) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        final Segment<K,V>[] segments = this.segments;
        int[] mc = new int[segments.length];
        {
            int k = 0;
            {
                int sum = 0;
                int mcsum = 0;
                {
                    int i = 0;
                    {
                        int c = segments[i].count;
                        mcsum += mc[i] = segments[i].modCount;
                        {
                            boolean varFE6D9E1890DD06E80AC0DE0A80F87D5C_580599090 = (segments[i].containsValue(value));
                        } 
                    } 
                } 
                boolean cleanSweep = true;
                {
                    {
                        int i = 0;
                        {
                            int c = segments[i].count;
                            {
                                cleanSweep = false;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            int i = 0;
            segments[i].lock();
        } 
        boolean found = false;
        try 
        {
            {
                int i = 0;
                {
                    {
                        boolean var9D288256F2CF948D64C59EFBBE617CE4_385263717 = (segments[i].containsValue(value));
                        {
                            found = true;
                        } 
                    } 
                } 
            } 
        } 
        finally 
        {
            {
                int i = 0;
                segments[i].unlock();
            } 
        } 
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_855862551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_855862551;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.279 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "C847B07210266911166B8FB677A08AD9")
    public boolean contains(Object value) {
        boolean var9D0C71166B134CB9FEA4F5814A8E4863_791689991 = (containsValue(value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1072358729 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1072358729;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.279 -0400", hash_original_method = "7B5FF6221D53537744EF141B1F8CB9FD", hash_generated_method = "1B5F6AFBEB769CCB6E13A4EF8D2006EC")
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1319977476 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int hash = hash(key.hashCode());
        varB4EAC82CA7396A68D541C85D26508E83_1319977476 = segmentFor(hash).put(key, hash, value, false);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1319977476.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1319977476;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.280 -0400", hash_original_method = "667464B5C7B8632F9930C4BABEB48EA8", hash_generated_method = "DDC59F8B7857DE28EFED945735F325C9")
    public V putIfAbsent(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_232235415 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int hash = hash(key.hashCode());
        varB4EAC82CA7396A68D541C85D26508E83_232235415 = segmentFor(hash).put(key, hash, value, true);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_232235415.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_232235415;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.283 -0400", hash_original_method = "B9175F57BE6F5AB8BBC535010119C8D9", hash_generated_method = "4AFC417F322AE51E7E06BA50FFDB996D")
    public void putAll(Map<? extends K, ? extends V> m) {
        {
            m.entrySet().iterator().hasNext();
            Map.Entry<? extends K, ? extends V> e = m.entrySet().iterator().next();
            put(e.getKey(), e.getValue());
        } 
        addTaint(m.getTaint());
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.283 -0400", hash_original_method = "337505C9EECB4FFE48F33491B52A72CA", hash_generated_method = "B8B79EBF2494D4B905D8BA99281DC5A5")
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_369914670 = null; 
        int hash = hash(key.hashCode());
        varB4EAC82CA7396A68D541C85D26508E83_369914670 = segmentFor(hash).remove(key, hash, null);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_369914670.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_369914670;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.284 -0400", hash_original_method = "B30F0ED29C44EDE9B7A1F9EA4182F243", hash_generated_method = "875E886136C8EF7A68F409A7F683787C")
    public boolean remove(Object key, Object value) {
        int hash = hash(key.hashCode());
        boolean var4FB63BD05D28C05209F98FEC987C6A2D_627143665 = (segmentFor(hash).remove(key, hash, value) != null);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1903538463 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1903538463;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.284 -0400", hash_original_method = "FFBE8ED355379D3641A692556CD55FD9", hash_generated_method = "E45A0CBDF6D0B63CD9890847151EC863")
    public boolean replace(K key, V oldValue, V newValue) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int hash = hash(key.hashCode());
        boolean var6897B508DBA234E8BBCB7D9C7C58A2E8_11357530 = (segmentFor(hash).replace(key, hash, oldValue, newValue));
        addTaint(key.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(newValue.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997488694 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997488694;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.285 -0400", hash_original_method = "0AA66A0CD7ECE54F0D1BA81883147959", hash_generated_method = "DAD6026B888ED678B168869FD982B281")
    public V replace(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1656236621 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int hash = hash(key.hashCode());
        varB4EAC82CA7396A68D541C85D26508E83_1656236621 = segmentFor(hash).replace(key, hash, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1656236621.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1656236621;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.286 -0400", hash_original_method = "F4B890B3C1A244A1C39416FB7B7BF8FF", hash_generated_method = "3412EAFC29D2354C02C0AF758845BBAC")
    public void clear() {
        {
            int i = 0;
            segments[i].clear();
        } 
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.287 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "F81913B2381A2EBCAD7634321CC398F2")
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_1158199314 = null; 
        Set<K> ks = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_1158199314 = (ks != null) ? ks : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_1158199314.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1158199314;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.289 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "7564D0F64AFA127B07B0D50A0FD4B8BD")
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_882230873 = null; 
        Collection<V> vs = values;
        varB4EAC82CA7396A68D541C85D26508E83_882230873 = (vs != null) ? vs : (values = new Values());
        varB4EAC82CA7396A68D541C85D26508E83_882230873.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_882230873;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.292 -0400", hash_original_method = "A019E2D84135E4E25D7FF3C9850D91E8", hash_generated_method = "75D0419235EED8FAD8FA937F55EB6BEB")
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> varB4EAC82CA7396A68D541C85D26508E83_396175473 = null; 
        Set<Map.Entry<K,V>> es = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_396175473 = (es != null) ? es : (entrySet = new EntrySet());
        varB4EAC82CA7396A68D541C85D26508E83_396175473.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_396175473;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.293 -0400", hash_original_method = "1378C07218E9226BC9F7AD403D7C2636", hash_generated_method = "6AD4B877B38C5AE38FD5D4B9A0AD8B2A")
    public Enumeration<K> keys() {
        Enumeration<K> varB4EAC82CA7396A68D541C85D26508E83_1015142361 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1015142361 = new KeyIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1015142361.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1015142361;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.294 -0400", hash_original_method = "5CBB59F043F7E5A98C79AC06A0CCF84B", hash_generated_method = "63EF09249C20669BDA7793BC9899D32D")
    public Enumeration<V> elements() {
        Enumeration<V> varB4EAC82CA7396A68D541C85D26508E83_1814761324 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1814761324 = new ValueIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1814761324.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1814761324;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.295 -0400", hash_original_method = "39AA0B3013D1EF3A3A6D6B7DFFE53DC3", hash_generated_method = "37CA8551C6C00521FAC141CE5D6DD0A3")
    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        {
            int k = 0;
            {
                Segment<K,V> seg = segments[k];
                seg.lock();
                try 
                {
                    HashEntry<K,V>[] tab = seg.table;
                    {
                        int i = 0;
                        {
                            {
                                HashEntry<K,V> e = tab[i];
                                e = e.next;
                                {
                                    s.writeObject(e.key);
                                    s.writeObject(e.value);
                                } 
                            } 
                        } 
                    } 
                } 
                finally 
                {
                    seg.unlock();
                } 
            } 
        } 
        s.writeObject(null);
        s.writeObject(null);
        addTaint(s.getTaint());
        
        
        
            
            
            
                
                
                    
                        
                        
                    
                
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.296 -0400", hash_original_method = "27FA8D459FE7A66670B6D1423BE5DC25", hash_generated_method = "BE97B393BEF61F4B84AAF741BDB3147A")
    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        {
            int i = 0;
            {
                segments[i].setTable(new HashEntry[1]);
            } 
        } 
        {
            K key = (K) s.readObject();
            V value = (V) s.readObject();
            put(key, value);
        } 
        addTaint(s.getTaint());
        
        
        
            
        
        
            
            
            
                
            
        
    }

    
    static final class HashEntry<K,V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.296 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.296 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.296 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D9A5701E394E22D841141BE91A2D9F15")

        volatile V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.296 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "AC47A60384D70A26B3EF9024FD965BF5")

        HashEntry<K,V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.297 -0400", hash_original_method = "89FFAB6F57FFB83251DFC8FAF8476851", hash_generated_method = "8A58D929EE079DEBCD95A67A156E3547")
          HashEntry(K key, int hash, HashEntry<K,V> next, V value) {
            this.key = key;
            this.hash = hash;
            this.next = next;
            this.value = value;
            
            
            
            
            
        }

        
        @SuppressWarnings("unchecked")
        static final <K,V> HashEntry<K,V>[] newArray(int i) {
            return new HashEntry[i];
        }

        
    }


    
    static final class Segment<K,V> extends ReentrantLock implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.298 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "A5A8CDA7B0601BDA04B06999B66113E1")

        transient volatile int count;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.298 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "66B0BB3B51ED8DFDAEFDC2833CA7C4AB")

        transient int modCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.298 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "EBFF2C10A18F7B4BDFBFF5FE82B9E916")

        transient int threshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.298 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "7AFDE33CE4930D8257094745BD6A1CD4")

        transient volatile HashEntry<K,V>[] table;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.298 -0400", hash_original_field = "97C293EF8ABD832D29E88C21D8E562F5", hash_generated_field = "9AE85CE37BA4DE356F76E49D73EDA32D")

        float loadFactor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.299 -0400", hash_original_method = "467240A23868E01B6F6E31DCEE5330A3", hash_generated_method = "F919AD8B7C803DFE03CEEB564FE01E06")
          Segment(int initialCapacity, float lf) {
            loadFactor = lf;
            setTable(HashEntry.<K,V>newArray(initialCapacity));
            addTaint(initialCapacity);
            
            
            
        }

        
        @SuppressWarnings("unchecked")
        static final <K,V> Segment<K,V>[] newArray(int i) {
            return new Segment[i];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.300 -0400", hash_original_method = "76FBB7D49FE13DE65CD87FF1D7913D53", hash_generated_method = "3CA87F2CA9B91DD40FEA6234D1C6C098")
         void setTable(HashEntry<K,V>[] newTable) {
            threshold = (int)(newTable.length * loadFactor);
            table = newTable;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.301 -0400", hash_original_method = "526D0582321A198EF4385AC6C7D29654", hash_generated_method = "6E62798C430B8C921B4B817862C8B0DC")
         HashEntry<K,V> getFirst(int hash) {
            HashEntry<K,V> varB4EAC82CA7396A68D541C85D26508E83_1137329796 = null; 
            HashEntry<K,V>[] tab = table;
            varB4EAC82CA7396A68D541C85D26508E83_1137329796 = tab[hash & (tab.length - 1)];
            addTaint(hash);
            varB4EAC82CA7396A68D541C85D26508E83_1137329796.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1137329796;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.302 -0400", hash_original_method = "6C9E8EADE7BF0CF7C06CF8A72D599D54", hash_generated_method = "CBE404264DDDC83CA9FB9475AAE7FEE4")
         V readValueUnderLock(HashEntry<K,V> e) {
            V varB4EAC82CA7396A68D541C85D26508E83_484352419 = null; 
            lock();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_484352419 = e.value;
            } 
            finally 
            {
                unlock();
            } 
            addTaint(e.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_484352419.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_484352419;
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.303 -0400", hash_original_method = "1AC5B4CC2690982021F35FD4CB4FB319", hash_generated_method = "7ED4767998FD91ADB8A824A20F828FA7")
         V get(Object key, int hash) {
            V varB4EAC82CA7396A68D541C85D26508E83_1970478396 = null; 
            V varB4EAC82CA7396A68D541C85D26508E83_676984555 = null; 
            V varB4EAC82CA7396A68D541C85D26508E83_1516506656 = null; 
            {
                HashEntry<K,V> e = getFirst(hash);
                {
                    {
                        boolean var8A7AE4752A388591DE1859857B46D43A_855423411 = (e.hash == hash && key.equals(e.key));
                        {
                            V v = e.value;
                            varB4EAC82CA7396A68D541C85D26508E83_1970478396 = v;
                            varB4EAC82CA7396A68D541C85D26508E83_676984555 = readValueUnderLock(e);
                        } 
                    } 
                    e = e.next;
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1516506656 = null;
            addTaint(key.getTaint());
            addTaint(hash);
            V varA7E53CE21691AB073D9660D615818899_1461455230; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1461455230 = varB4EAC82CA7396A68D541C85D26508E83_1970478396;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1461455230 = varB4EAC82CA7396A68D541C85D26508E83_676984555;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1461455230 = varB4EAC82CA7396A68D541C85D26508E83_1516506656;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1461455230.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1461455230;
            
            
                
                
                    
                        
                        
                            
                        
                    
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.303 -0400", hash_original_method = "4906CD88672F5095094E2A23826E0F83", hash_generated_method = "D9F8964EA6CBE41D2AFC72C9789E3B77")
         boolean containsKey(Object key, int hash) {
            {
                HashEntry<K,V> e = getFirst(hash);
                {
                    {
                        boolean var8A7AE4752A388591DE1859857B46D43A_1235310325 = (e.hash == hash && key.equals(e.key));
                    } 
                    e = e.next;
                } 
            } 
            addTaint(key.getTaint());
            addTaint(hash);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1718748490 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1718748490;
            
            
                
                
                    
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.303 -0400", hash_original_method = "4B02A5A0C6C760AB5CD92802AE9AC755", hash_generated_method = "65806225A53D40A59747C71DD7B975D6")
         boolean containsValue(Object value) {
            {
                HashEntry<K,V>[] tab = table;
                int len = tab.length;
                {
                    int i = 0;
                    {
                        {
                            HashEntry<K,V> e = tab[i];
                            e = e.next;
                            {
                                V v = e.value;
                                v = readValueUnderLock(e);
                                {
                                    boolean varAF9B2D3689B03A5213EF203D483D8AD4_606687232 = (value.equals(v));
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1623908898 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1623908898;
            
            
                
                
                
                    
                        
                        
                            
                        
                            
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.304 -0400", hash_original_method = "B03D3F6036D4D187AC672F9D98953439", hash_generated_method = "5A424C6BB6067621BF92B212D5B2DDF8")
         boolean replace(K key, int hash, V oldValue, V newValue) {
            lock();
            try 
            {
                HashEntry<K,V> e = getFirst(hash);
                {
                    boolean varFA336E0F01A8F7D94110F42C42943CEA_2028146791 = (e != null && (e.hash != hash || !key.equals(e.key)));
                    e = e.next;
                } 
                boolean replaced = false;
                {
                    boolean varB391AA6784122268E404E2A55161AFDC_86208345 = (e != null && oldValue.equals(e.value));
                    {
                        replaced = true;
                        e.value = newValue;
                    } 
                } 
            } 
            finally 
            {
                unlock();
            } 
            addTaint(key.getTaint());
            addTaint(hash);
            addTaint(oldValue.getTaint());
            addTaint(newValue.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788503607 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788503607;
            
            
            
                
                
                    
                
                
                    
                    
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.305 -0400", hash_original_method = "496F1B463B31D22372CDAB52F4D749A3", hash_generated_method = "D4BF9CC6F8846B3999A6A5EAD6CC485B")
         V replace(K key, int hash, V newValue) {
            V varB4EAC82CA7396A68D541C85D26508E83_1920663674 = null; 
            lock();
            try 
            {
                HashEntry<K,V> e = getFirst(hash);
                {
                    boolean varFA336E0F01A8F7D94110F42C42943CEA_1285759580 = (e != null && (e.hash != hash || !key.equals(e.key)));
                    e = e.next;
                } 
                V oldValue = null;
                {
                    oldValue = e.value;
                    e.value = newValue;
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1920663674 = oldValue;
            } 
            finally 
            {
                unlock();
            } 
            addTaint(key.getTaint());
            addTaint(hash);
            addTaint(newValue.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1920663674.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1920663674;
            
            
            
                
                
                    
                
                
                    
                    
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.306 -0400", hash_original_method = "F92903F43B391F8F1B397027DA8E7AA9", hash_generated_method = "9188D9D2FCFBEF2911223967229A7653")
         V put(K key, int hash, V value, boolean onlyIfAbsent) {
            V varB4EAC82CA7396A68D541C85D26508E83_173367989 = null; 
            lock();
            try 
            {
                int c = count;
                rehash();
                HashEntry<K,V>[] tab = table;
                int index = hash & (tab.length - 1);
                HashEntry<K,V> first = tab[index];
                HashEntry<K,V> e = first;
                {
                    boolean varFA336E0F01A8F7D94110F42C42943CEA_727672728 = (e != null && (e.hash != hash || !key.equals(e.key)));
                    e = e.next;
                } 
                V oldValue;
                {
                    oldValue = e.value;
                    e.value = value;
                } 
                {
                    oldValue = null;
                    tab[index] = new HashEntry<K,V>(key, hash, first, value);
                    count = c;
                } 
                varB4EAC82CA7396A68D541C85D26508E83_173367989 = oldValue;
            } 
            finally 
            {
                unlock();
            } 
            addTaint(key.getTaint());
            addTaint(hash);
            addTaint(value.getTaint());
            addTaint(onlyIfAbsent);
            varB4EAC82CA7396A68D541C85D26508E83_173367989.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_173367989;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.307 -0400", hash_original_method = "7AA7A225DF7E6D5CA86650AFCB7B431B", hash_generated_method = "C8AE6BA944581BB0C5E46876FF91194F")
         void rehash() {
            HashEntry<K,V>[] oldTable = table;
            int oldCapacity = oldTable.length;
            HashEntry<K,V>[] newTable = HashEntry.newArray(oldCapacity<<1);
            threshold = (int)(newTable.length * loadFactor);
            int sizeMask = newTable.length - 1;
            {
                int i = 0;
                {
                    HashEntry<K,V> e = oldTable[i];
                    {
                        HashEntry<K,V> next = e.next;
                        int idx = e.hash & sizeMask;
                        newTable[idx] = e;
                        {
                            HashEntry<K,V> lastRun = e;
                            int lastIdx = idx;
                            {
                                HashEntry<K,V> last = next;
                                last = last.next;
                                {
                                    int k = last.hash & sizeMask;
                                    {
                                        lastIdx = k;
                                        lastRun = last;
                                    } 
                                } 
                            } 
                            newTable[lastIdx] = lastRun;
                            {
                                HashEntry<K,V> p = e;
                                p = p.next;
                                {
                                    int k = p.hash & sizeMask;
                                    HashEntry<K,V> n = newTable[k];
                                    newTable[k] = new HashEntry<K,V>(p.key, p.hash,
                                                             n, p.value);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            table = newTable;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.310 -0400", hash_original_method = "A22DE89D38A395B57956004D412DD3F5", hash_generated_method = "8672737B8AC29113D1155263B2D612B2")
         V remove(Object key, int hash, Object value) {
            V varB4EAC82CA7396A68D541C85D26508E83_1463547625 = null; 
            lock();
            try 
            {
                int c = count - 1;
                HashEntry<K,V>[] tab = table;
                int index = hash & (tab.length - 1);
                HashEntry<K,V> first = tab[index];
                HashEntry<K,V> e = first;
                {
                    boolean varFA336E0F01A8F7D94110F42C42943CEA_130422351 = (e != null && (e.hash != hash || !key.equals(e.key)));
                    e = e.next;
                } 
                V oldValue = null;
                {
                    V v = e.value;
                    {
                        boolean varCDFC5F5D65441A80D44B2E79B876F2E6_951832102 = (value == null || value.equals(v));
                        {
                            oldValue = v;
                            HashEntry<K,V> newFirst = e.next;
                            {
                                HashEntry<K,V> p = first;
                                p = p.next;
                                newFirst = new HashEntry<K,V>(p.key, p.hash,
                                                          newFirst, p.value);
                            } 
                            tab[index] = newFirst;
                            count = c;
                        } 
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1463547625 = oldValue;
            } 
            finally 
            {
                unlock();
            } 
            addTaint(key.getTaint());
            addTaint(hash);
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1463547625.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1463547625;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.311 -0400", hash_original_method = "20609B8FF53EC43AEB5A4460B52EBDFF", hash_generated_method = "E0D99C72AAB0AB61E7181915A90B944A")
         void clear() {
            {
                lock();
                try 
                {
                    HashEntry<K,V>[] tab = table;
                    {
                        int i = 0;
                        tab[i] = null;
                    } 
                    count = 0;
                } 
                finally 
                {
                    unlock();
                } 
            } 
            
            
                
                
                    
                    
                        
                    
                    
                
                    
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.311 -0400", hash_original_field = "50094462426A989CA556C53151CA22A4", hash_generated_field = "63C62A82A3FF7049D8720153B66FBF4F")

        private static final long serialVersionUID = 2249069246763182397L;
    }


    
    abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.311 -0400", hash_original_field = "735C46731EEFB77B5ECB5630A622022B", hash_generated_field = "6D9B0937081A44F32DBD7158CFD76C24")

        int nextSegmentIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.312 -0400", hash_original_field = "F8C5594496DE1EFBE5BC9860038CE5E1", hash_generated_field = "2A2A99ACC13355EBDE9E414F85DC6404")

        int nextTableIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.312 -0400", hash_original_field = "73EBE5C2CCB25E5F693EC01CFE4A9A12", hash_generated_field = "0851F1AD358B7E0A6DDF18DC99A51E84")

        HashEntry<K,V>[] currentTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.312 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "34F1B1A1DBD9F7012195EE8A5509C745")

        HashEntry<K, V> nextEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.312 -0400", hash_original_field = "41032E42645C86567A380648031CF141", hash_generated_field = "EF55F7F73AA7A34DDB20CE140C1B2DB7")

        HashEntry<K, V> lastReturned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.312 -0400", hash_original_method = "1331DC8249C406CC83024534A57FEFEB", hash_generated_method = "D903CC46D67C5E6BD87F25FE63BEB736")
          HashIterator() {
            nextSegmentIndex = segments.length - 1;
            nextTableIndex = -1;
            advance();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.313 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "5F6E42A1DABE8ABC5AE737D8066100C5")
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_1051520204 = (hasNext());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211629963 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211629963;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.314 -0400", hash_original_method = "A06EA4B51D378F01CE00F7FB99A616EF", hash_generated_method = "8CD03FB13157099170941EC6B5012BD0")
        final void advance() {
            {
                boolean varAE56CE09D98F8D249FB4EAAAC2365BBF_601498644 = (nextEntry != null && (nextEntry = nextEntry.next) != null);
            } 
            {
                {
                    boolean var63500D3C047D4C906175A14EF6FEFB9D_679026107 = ((nextEntry = currentTable[nextTableIndex--]) != null);
                } 
            } 
            {
                Segment<K,V> seg = segments[nextSegmentIndex--];
                {
                    currentTable = seg.table;
                    {
                        int j = currentTable.length - 1;
                        {
                            {
                                boolean var561CE7603C783A55D13FDCDDA31772EC_1747972079 = ((nextEntry = currentTable[j]) != null);
                                {
                                    nextTableIndex = j - 1;
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            
            
                
            
                
                    
            
            
                
                
                    
                    
                        
                            
                            
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.316 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "5C49EA33B44380920C5FEECAA912C1A5")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857587610 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_857587610;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.319 -0400", hash_original_method = "DB7CF742BB593212DEE9E7DE200FEED8", hash_generated_method = "9324E2A170B546B9C3C14CA94B89BF1B")
         HashEntry<K,V> nextEntry() {
            HashEntry<K,V> varB4EAC82CA7396A68D541C85D26508E83_1389232511 = null; 
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            lastReturned = nextEntry;
            advance();
            varB4EAC82CA7396A68D541C85D26508E83_1389232511 = lastReturned;
            varB4EAC82CA7396A68D541C85D26508E83_1389232511.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1389232511;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.321 -0400", hash_original_method = "EB8010C2D5EA80D446C3485BFC85793F", hash_generated_method = "64211DA248DE87BDD0671C84567097BA")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            ConcurrentHashMap.this.remove(lastReturned.key);
            lastReturned = null;
            
            
                
            
            
        }

        
    }


    
    final class KeyIterator extends HashIterator implements Iterator<K>, Enumeration<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.322 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.323 -0400", hash_original_method = "AC02B860B54618170BE24E50FF82F167", hash_generated_method = "6FC43CCC5A581851136FB44ED9EFD93A")
        public K next() {
            K varB4EAC82CA7396A68D541C85D26508E83_1056883406 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1056883406 = super.nextEntry().key;
            varB4EAC82CA7396A68D541C85D26508E83_1056883406.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1056883406;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.324 -0400", hash_original_method = "1473F8B0EF10582FE9B24F9D164CBEAD", hash_generated_method = "370D54BE3AAE2CADBB449D3AFA6E4BC3")
        public K nextElement() {
            K varB4EAC82CA7396A68D541C85D26508E83_558993161 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_558993161 = super.nextEntry().key;
            varB4EAC82CA7396A68D541C85D26508E83_558993161.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_558993161;
            
            
        }

        
    }


    
    final class ValueIterator extends HashIterator implements Iterator<V>, Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.324 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.325 -0400", hash_original_method = "282B954004CE321F97FD15862590F160", hash_generated_method = "7ADA228F63CA69FCFBE7802808E0AC5C")
        public V next() {
            V varB4EAC82CA7396A68D541C85D26508E83_64905453 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_64905453 = super.nextEntry().value;
            varB4EAC82CA7396A68D541C85D26508E83_64905453.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_64905453;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.326 -0400", hash_original_method = "95D48303D225ADC424CB718F2FA08908", hash_generated_method = "D4613BE504D092918C6B1B8D0DFAD0FC")
        public V nextElement() {
            V varB4EAC82CA7396A68D541C85D26508E83_2004584222 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2004584222 = super.nextEntry().value;
            varB4EAC82CA7396A68D541C85D26508E83_2004584222.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2004584222;
            
            
        }

        
    }


    
    final class WriteThroughEntry extends AbstractMap.SimpleEntry<K,V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.326 -0400", hash_original_method = "A56113014EC205E193BCD1C4F8B24855", hash_generated_method = "2BCC3E18A00E366FA4BDB5DEAFB24F13")
          WriteThroughEntry(K k, V v) {
            super(k,v);
            addTaint(k.getTaint());
            addTaint(v.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.327 -0400", hash_original_method = "38F302BB69197C5906EE6F553583F6F9", hash_generated_method = "DA22CCF832EA6DF4F6AA069B93311A11")
        public V setValue(V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_1732834490 = null; 
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            V v = super.setValue(value);
            ConcurrentHashMap.this.put(getKey(), value);
            varB4EAC82CA7396A68D541C85D26508E83_1732834490 = v;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1732834490.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1732834490;
            
            
            
            
            
        }

        
    }


    
    final class EntryIterator extends HashIterator implements Iterator<Entry<K,V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.327 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.328 -0400", hash_original_method = "DA1DC8695C9406305A6247D7AF5617DE", hash_generated_method = "6F452270C78CA7B69299849C8CFACB9B")
        public Map.Entry<K,V> next() {
            Map.Entry<K,V> varB4EAC82CA7396A68D541C85D26508E83_202451276 = null; 
            HashEntry<K,V> e = super.nextEntry();
            varB4EAC82CA7396A68D541C85D26508E83_202451276 = new WriteThroughEntry(e.key, e.value);
            varB4EAC82CA7396A68D541C85D26508E83_202451276.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_202451276;
            
            
            
        }

        
    }


    
    final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.328 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.329 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "1BFBBE7249712AED7940E157A2AE261D")
        public Iterator<K> iterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_590864025 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_590864025 = new KeyIterator();
            varB4EAC82CA7396A68D541C85D26508E83_590864025.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_590864025;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.330 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "3F123BB38B2AC1C8824DABAFED0E631B")
        public int size() {
            int var2AE1BD72658B11B83F17E3D8DE9C3742_351848298 = (ConcurrentHashMap.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983569840 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983569840;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.330 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "DFA413A4CCDB7EF60A73E257FDCCD627")
        public boolean isEmpty() {
            boolean var2129446389ED975B0F4481D55BB56F6F_463157611 = (ConcurrentHashMap.this.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1831712360 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1831712360;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.331 -0400", hash_original_method = "37248D467FF06BE0B2F5DDC1489510DF", hash_generated_method = "6A0B43C348C7D8E0F81015FB783369BD")
        public boolean contains(Object o) {
            boolean var3A007D079E775775EF3E281A61BA88AC_1134282217 = (ConcurrentHashMap.this.containsKey(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_946303077 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_946303077;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.331 -0400", hash_original_method = "5AA31A160A27D834D20E2EBCA8B4999F", hash_generated_method = "B27B7E56476ECE5C11E8D6FBD2B1126B")
        public boolean remove(Object o) {
            boolean var7AF3FCDEC3414604DC101A294DC0E9A1_1918382750 = (ConcurrentHashMap.this.remove(o) != null);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_713354580 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_713354580;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.332 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        public void clear() {
            ConcurrentHashMap.this.clear();
            
            
        }

        
    }


    
    final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.332 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.333 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "BA7EC36DCAC932C59D560259F696E051")
        public Iterator<V> iterator() {
            Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_1766536095 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1766536095 = new ValueIterator();
            varB4EAC82CA7396A68D541C85D26508E83_1766536095.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1766536095;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.333 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "26C2D7C227E333E9976740D9449F8F84")
        public int size() {
            int var2AE1BD72658B11B83F17E3D8DE9C3742_887016620 = (ConcurrentHashMap.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1958341162 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1958341162;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.333 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "B61BD4698E3ECCB1A2E0F2A4C1AD7183")
        public boolean isEmpty() {
            boolean var2129446389ED975B0F4481D55BB56F6F_559444036 = (ConcurrentHashMap.this.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_423970598 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_423970598;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.334 -0400", hash_original_method = "6F20D95CF6074119AB0347E3FAAE80A2", hash_generated_method = "5CD4C7180201E0A48858B82E527ECF35")
        public boolean contains(Object o) {
            boolean varB5437F4F6895ACF0564A8B739D6BBE8E_917301313 = (ConcurrentHashMap.this.containsValue(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742081872 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_742081872;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.334 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        public void clear() {
            ConcurrentHashMap.this.clear();
            
            
        }

        
    }


    
    final class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.334 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.335 -0400", hash_original_method = "A1AF959F7C17DD47B4014053BC413A23", hash_generated_method = "D9ADD418A6EF6A839B938E6DE662BA52")
        public Iterator<Map.Entry<K,V>> iterator() {
            Iterator<Map.Entry<K,V>> varB4EAC82CA7396A68D541C85D26508E83_456843138 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_456843138 = new EntryIterator();
            varB4EAC82CA7396A68D541C85D26508E83_456843138.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_456843138;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.335 -0400", hash_original_method = "44CFEB1CC21C67EDDE5E7F2C0FB0C916", hash_generated_method = "70F6AB3203A226EE53E9B901839E0EC0")
        public boolean contains(Object o) {
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            V v = ConcurrentHashMap.this.get(e.getKey());
            boolean varA30474C0E53C22C4F5FAE67C3EFD9B30_1582349710 = (v != null && v.equals(e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_892280060 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_892280060;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.336 -0400", hash_original_method = "8F57FBEE664B771D5FDC7BC47FB0BA8F", hash_generated_method = "7ED466B28F70DF29736879F2739E2240")
        public boolean remove(Object o) {
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            boolean var610A1F7E9B8954F006C6C3D32F43CF4E_1059757565 = (ConcurrentHashMap.this.remove(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1869467291 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1869467291;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.337 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "C1CC93962489AB22EAA17006BB3A06FA")
        public int size() {
            int var2AE1BD72658B11B83F17E3D8DE9C3742_2004085175 = (ConcurrentHashMap.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644793986 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644793986;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.337 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "D67216030B809F812D94C5FFA9CABB61")
        public boolean isEmpty() {
            boolean var2129446389ED975B0F4481D55BB56F6F_895033571 = (ConcurrentHashMap.this.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1094466006 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1094466006;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.338 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        public void clear() {
            ConcurrentHashMap.this.clear();
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.338 -0400", hash_original_field = "38B2FE469B8CC3659DBEBB0BBB913A6C", hash_generated_field = "CFEA0CB484FBA67AE2EE2BC289FD3823")

    private static final long serialVersionUID = 7249069246763182397L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.338 -0400", hash_original_field = "F2DE208954D426D31F499310022241CF", hash_generated_field = "E41669AD5B156D132F42EF1B84E41D37")

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.338 -0400", hash_original_field = "DF48F8D92FC36ACC8968654109C53FC4", hash_generated_field = "A8CC9CBDCFEE884AAACD2650D6276B04")

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.338 -0400", hash_original_field = "ED64AF2D88EA33EF6133115E5E8FFE32", hash_generated_field = "6CEFE70232E37AD1C46346373D85BAC4")

    static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.338 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "F5FAB930A5B7C8AC42E4718B6294507D")

    static final int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.338 -0400", hash_original_field = "C9E0D462440D958860E70662EC748F43", hash_generated_field = "7552200CFB9EB51127B30554F45C2149")

    static final int MAX_SEGMENTS = 1 << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.338 -0400", hash_original_field = "4866497D0659FC39D1D9B2B7C08C16DB", hash_generated_field = "C971A9BB3C20B29D95F33E07A3449F39")

    static final int RETRIES_BEFORE_LOCK = 2;
}


package java.util.concurrent;

// Droidsafe Imports
import java.io.IOException;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.482 -0400", hash_original_field = "6E087A676FE9EB60B1F8BDB5CE343DC8", hash_generated_field = "4BE7BE92627D08015B3B3DAF23AD6BAD")

    int segmentMask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.482 -0400", hash_original_field = "4CDE234FA7C6312E0DF85BE9485BF1E3", hash_generated_field = "306EF00C73243987FA23D1582323C779")

    int segmentShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.482 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "8FCA8AAE37A6D97176077745C90AB57A")

    Segment<K,V>[] segments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.482 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "B015B4740FB481B602A7C5EA08044E34")

    transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.482 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "8070B936D9AF3972F9E8198F31643848")

    transient Set<Map.Entry<K,V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.482 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "1963670AE696FF62CC56DF446CAA129C")

    transient Collection<V> values;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.483 -0400", hash_original_method = "E1CECF835D0BD6DA840C10527C435227", hash_generated_method = "43894965F0DB79482AA92974EB7A9CDC")
    public  ConcurrentHashMap(int initialCapacity,
                             float loadFactor, int concurrencyLevel) {
        addTaint(concurrencyLevel);
        addTaint(initialCapacity);
        if(!(loadFactor > 0) || initialCapacity < 0 || concurrencyLevel <= 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_208954920 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_208954920.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_208954920;
        }
        if(concurrencyLevel > MAX_SEGMENTS)        
        concurrencyLevel = MAX_SEGMENTS;
        int sshift = 0;
        int ssize = 1;
        while
(ssize < concurrencyLevel)        
        {
            ++sshift;
            ssize <<= 1;
        } //End block
        segmentShift = 32 - sshift;
        segmentMask = ssize - 1;
        this.segments = Segment.newArray(ssize);
        if(initialCapacity > MAXIMUM_CAPACITY)        
        initialCapacity = MAXIMUM_CAPACITY;
        int c = initialCapacity / ssize;
        if(c * ssize < initialCapacity)        
        ++c;
        int cap = 1;
        while
(cap < c)        
        cap <<= 1;
for(int i = 0;i < this.segments.length;++i)
        this.segments[i] = new Segment<K,V>(cap, loadFactor);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.484 -0400", hash_original_method = "1B0A2C6B75A6C9CD77B06A2BA6F95389", hash_generated_method = "986E8D4C259C709A18C0ACB4C2A37ACA")
    public  ConcurrentHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, DEFAULT_CONCURRENCY_LEVEL);
        addTaint(loadFactor);
        addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.484 -0400", hash_original_method = "FC082FCC77B50E96B6B6DB58BAB97957", hash_generated_method = "CDAAD7AE035E81DF97303AEAF9A04212")
    public  ConcurrentHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.484 -0400", hash_original_method = "DFADDF9198F2268E7EB2B4F062BE54B9", hash_generated_method = "D4298CEE30095C17DFF133A738118CBC")
    public  ConcurrentHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.485 -0400", hash_original_method = "485F32D8EAC40E4F4B6CB1DCBDB98D35", hash_generated_method = "FC05ACDD7F9F8068DB83CBB872A3BDB0")
    public  ConcurrentHashMap(Map<? extends K, ? extends V> m) {
        this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,
                      DEFAULT_INITIAL_CAPACITY),
             DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        addTaint(m.getTaint());
        putAll(m);
        // ---------- Original Method ----------
        //putAll(m);
    }

    
    @DSModeled(DSC.SAFE)
    private static int hash(int h) {
        h += (h <<  15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h <<   3);
        h ^= (h >>>  6);
        h += (h <<   2) + (h << 14);
        return h ^ (h >>> 16);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.485 -0400", hash_original_method = "9480E4BE528687F57BD0A5E0057A4838", hash_generated_method = "AC665825A94976348AB199D5DE8BFBD3")
    final Segment<K,V> segmentFor(int hash) {
        addTaint(hash);
Segment<K,V> var81E1DC7BB6CFBB976BA039133E98DCDC_1617604321 =         segments[(hash >>> segmentShift) & segmentMask];
        var81E1DC7BB6CFBB976BA039133E98DCDC_1617604321.addTaint(taint);
        return var81E1DC7BB6CFBB976BA039133E98DCDC_1617604321;
        // ---------- Original Method ----------
        //return segments[(hash >>> segmentShift) & segmentMask];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.486 -0400", hash_original_method = "1D5F6259D73E7678D3D06BFBE271A26B", hash_generated_method = "34D317688B1193DFF589D9E286F74787")
    public boolean isEmpty() {
        final Segment<K,V>[] segments = this.segments;
        int[] mc = new int[segments.length];
        int mcsum = 0;
for(int i = 0;i < segments.length;++i)
        {
            if(segments[i].count != 0)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1710816173 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844675239 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_844675239;
            }
            else
            mcsum += mc[i] = segments[i].modCount;
        } //End block
        if(mcsum != 0)        
        {
for(int i = 0;i < segments.length;++i)
            {
                if(segments[i].count != 0 ||
                    mc[i] != segments[i].modCount)                
                {
                boolean var68934A3E9455FA72420237EB05902327_1145428815 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136470893 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136470893;
                }
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_976409496 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_921066393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_921066393;
        // ---------- Original Method ----------
        //final Segment<K,V>[] segments = this.segments;
        //int[] mc = new int[segments.length];
        //int mcsum = 0;
        //for (int i = 0; i < segments.length; ++i) {
            //if (segments[i].count != 0)
                //return false;
            //else
                //mcsum += mc[i] = segments[i].modCount;
        //}
        //if (mcsum != 0) {
            //for (int i = 0; i < segments.length; ++i) {
                //if (segments[i].count != 0 ||
                    //mc[i] != segments[i].modCount)
                    //return false;
            //}
        //}
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.488 -0400", hash_original_method = "BA4A00EBCDE2550C0DA253B4E73A18FB", hash_generated_method = "DC989D8B1C0A2A952E9D9D26A8B832BE")
    public int size() {
        final Segment<K,V>[] segments = this.segments;
        long sum = 0;
        long check = 0;
        int[] mc = new int[segments.length];
for(int k = 0;k < RETRIES_BEFORE_LOCK;++k)
        {
            check = 0;
            sum = 0;
            int mcsum = 0;
for(int i = 0;i < segments.length;++i)
            {
                sum += segments[i].count;
                mcsum += mc[i] = segments[i].modCount;
            } //End block
            if(mcsum != 0)            
            {
for(int i = 0;i < segments.length;++i)
                {
                    check += segments[i].count;
                    if(mc[i] != segments[i].modCount)                    
                    {
                        check = -1;
                        break;
                    } //End block
                } //End block
            } //End block
            if(check == sum)            
            break;
        } //End block
        if(check != sum)        
        {
            sum = 0;
for(int i = 0;i < segments.length;++i)
            segments[i].lock();
for(int i = 0;i < segments.length;++i)
            sum += segments[i].count;
for(int i = 0;i < segments.length;++i)
            segments[i].unlock();
        } //End block
        if(sum > Integer.MAX_VALUE)        
        {
        int varE7A95D949116A2DA0F0FA83DC6E76C00_1094323260 = (Integer.MAX_VALUE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1495214558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1495214558;
        }
        else
        {
        int varD984D8288ADAB7DF06981564287D9240_1697124573 = ((int)sum);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_965345563 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_965345563;
        }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.490 -0400", hash_original_method = "332CB84E85FBD8A2CB62BBB184B280CA", hash_generated_method = "1A0C0EDE34257FF713604205821E6191")
    public V get(Object key) {
        addTaint(key.getTaint());
        int hash = hash(key.hashCode());
V var58B1A596DF295DAEF8FBFB190D5BE740_1948468916 =         segmentFor(hash).get(key, hash);
        var58B1A596DF295DAEF8FBFB190D5BE740_1948468916.addTaint(taint);
        return var58B1A596DF295DAEF8FBFB190D5BE740_1948468916;
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).get(key, hash);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.490 -0400", hash_original_method = "6145F82DE390788BB7B29DCBC031D263", hash_generated_method = "434125A10EB3E38F066F39DE0DE32B41")
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
        int hash = hash(key.hashCode());
        boolean var603D0257C52BC77068BB435DD3A21187_1298497794 = (segmentFor(hash).containsKey(key, hash));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_71070751 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_71070751;
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).containsKey(key, hash);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.491 -0400", hash_original_method = "F1AF23545DF8C9E4F21CC9D8D7EE161E", hash_generated_method = "FDC6E88E6CBF965B2653C5CE3C23F592")
    public boolean containsValue(Object value) {
        addTaint(value.getTaint());
        if(value == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1725068580 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1725068580.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1725068580;
        }
        final Segment<K,V>[] segments = this.segments;
        int[] mc = new int[segments.length];
for(int k = 0;k < RETRIES_BEFORE_LOCK;++k)
        {
            int sum = 0;
            int mcsum = 0;
for(int i = 0;i < segments.length;++i)
            {
                int c = segments[i].count;
                mcsum += mc[i] = segments[i].modCount;
                if(segments[i].containsValue(value))                
                {
                boolean varB326B5062B2F0E69046810717534CB09_1551368660 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_570604597 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_570604597;
                }
            } //End block
            boolean cleanSweep = true;
            if(mcsum != 0)            
            {
for(int i = 0;i < segments.length;++i)
                {
                    int c = segments[i].count;
                    if(mc[i] != segments[i].modCount)                    
                    {
                        cleanSweep = false;
                        break;
                    } //End block
                } //End block
            } //End block
            if(cleanSweep)            
            {
            boolean var68934A3E9455FA72420237EB05902327_417670564 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_805915699 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_805915699;
            }
        } //End block
for(int i = 0;i < segments.length;++i)
        segments[i].lock();
        boolean found = false;
        try 
        {
for(int i = 0;i < segments.length;++i)
            {
                if(segments[i].containsValue(value))                
                {
                    found = true;
                    break;
                } //End block
            } //End block
        } //End block
        finally 
        {
for(int i = 0;i < segments.length;++i)
            segments[i].unlock();
        } //End block
        boolean var6CFE61694EE1BB13AE719D47C2F80B7A_996102910 = (found);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2026110730 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2026110730;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.491 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "88F7869D1DB79A560788B9F9E1D7AAEC")
    public boolean contains(Object value) {
        addTaint(value.getTaint());
        boolean varF98DD5D16840FDEEA577F8F359CCE837_7014733 = (containsValue(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221381554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_221381554;
        // ---------- Original Method ----------
        //return containsValue(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.491 -0400", hash_original_method = "7B5FF6221D53537744EF141B1F8CB9FD", hash_generated_method = "9939D5CBECD079AB10F28CC02CFC2E5B")
    public V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        if(value == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_814810188 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_814810188.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_814810188;
        }
        int hash = hash(key.hashCode());
V varB8E72255B46E49A27EDFFD32AA280918_1601330798 =         segmentFor(hash).put(key, hash, value, false);
        varB8E72255B46E49A27EDFFD32AA280918_1601330798.addTaint(taint);
        return varB8E72255B46E49A27EDFFD32AA280918_1601330798;
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).put(key, hash, value, false);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.491 -0400", hash_original_method = "667464B5C7B8632F9930C4BABEB48EA8", hash_generated_method = "6A0EFADBA3F149F4A4D0012EEF3BFA45")
    public V putIfAbsent(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        if(value == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_399671853 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_399671853.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_399671853;
        }
        int hash = hash(key.hashCode());
V var418D4E99839E5E3DF1FB9C798D977AF2_2052464205 =         segmentFor(hash).put(key, hash, value, true);
        var418D4E99839E5E3DF1FB9C798D977AF2_2052464205.addTaint(taint);
        return var418D4E99839E5E3DF1FB9C798D977AF2_2052464205;
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).put(key, hash, value, true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.492 -0400", hash_original_method = "B9175F57BE6F5AB8BBC535010119C8D9", hash_generated_method = "B50B09FC64C3FA250D453424D4DEA45D")
    public void putAll(Map<? extends K, ? extends V> m) {
        addTaint(m.getTaint());
for(Map.Entry<? extends K, ? extends V> e : m.entrySet())
        put(e.getKey(), e.getValue());
        // ---------- Original Method ----------
        //for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            //put(e.getKey(), e.getValue());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.492 -0400", hash_original_method = "337505C9EECB4FFE48F33491B52A72CA", hash_generated_method = "BB423EDB8FE59B2204C08ED360113017")
    public V remove(Object key) {
        addTaint(key.getTaint());
        int hash = hash(key.hashCode());
V varF04126AECFC2728B9C58FE5A362B44A0_1022845212 =         segmentFor(hash).remove(key, hash, null);
        varF04126AECFC2728B9C58FE5A362B44A0_1022845212.addTaint(taint);
        return varF04126AECFC2728B9C58FE5A362B44A0_1022845212;
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).remove(key, hash, null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.492 -0400", hash_original_method = "B30F0ED29C44EDE9B7A1F9EA4182F243", hash_generated_method = "1D45DBA253270964620E0AA6B1E33FEC")
    public boolean remove(Object key, Object value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        int hash = hash(key.hashCode());
        if(value == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_815902506 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_207122585 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_207122585;
        }
        boolean var5984AFF027ACA5A688DB4D2B8222A21A_1623875771 = (segmentFor(hash).remove(key, hash, value) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942556816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_942556816;
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //if (value == null)
            //return false;
        //return segmentFor(hash).remove(key, hash, value) != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.492 -0400", hash_original_method = "FFBE8ED355379D3641A692556CD55FD9", hash_generated_method = "77D016D32CF2FA18AC5E819D7BA5B2CC")
    public boolean replace(K key, V oldValue, V newValue) {
        addTaint(newValue.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(key.getTaint());
        if(oldValue == null || newValue == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_40628257 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_40628257.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_40628257;
        }
        int hash = hash(key.hashCode());
        boolean varF8247769ED22EE4C0591A0066F1EDF98_273560582 = (segmentFor(hash).replace(key, hash, oldValue, newValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_374378211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_374378211;
        // ---------- Original Method ----------
        //if (oldValue == null || newValue == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).replace(key, hash, oldValue, newValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.492 -0400", hash_original_method = "0AA66A0CD7ECE54F0D1BA81883147959", hash_generated_method = "251087B2EC3AB04D81B5CDF17030BA89")
    public V replace(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        if(value == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_276380302 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_276380302.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_276380302;
        }
        int hash = hash(key.hashCode());
V var9D64916B4DF1085135740B680007D62A_505768253 =         segmentFor(hash).replace(key, hash, value);
        var9D64916B4DF1085135740B680007D62A_505768253.addTaint(taint);
        return var9D64916B4DF1085135740B680007D62A_505768253;
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).replace(key, hash, value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.493 -0400", hash_original_method = "F4B890B3C1A244A1C39416FB7B7BF8FF", hash_generated_method = "1C4E31AEFE8E9D209F1755AF9FACB321")
    public void clear() {
for(int i = 0;i < segments.length;++i)
        segments[i].clear();
        // ---------- Original Method ----------
        //for (int i = 0; i < segments.length; ++i)
            //segments[i].clear();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.493 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "507FC0C6693345027AFC6D5BAD5C0227")
    public Set<K> keySet() {
        Set<K> ks = keySet;
Set<K> varB6853687BE649BA8B10F9701AD179BB7_2003258032 =         (ks != null) ? ks : (keySet = new KeySet());
        varB6853687BE649BA8B10F9701AD179BB7_2003258032.addTaint(taint);
        return varB6853687BE649BA8B10F9701AD179BB7_2003258032;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.493 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "40D60E50DBC2AB779E2959383D1C60DF")
    public Collection<V> values() {
        Collection<V> vs = values;
Collection<V> var5CABA883D65798B391E2C02013734397_867083385 =         (vs != null) ? vs : (values = new Values());
        var5CABA883D65798B391E2C02013734397_867083385.addTaint(taint);
        return var5CABA883D65798B391E2C02013734397_867083385;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.493 -0400", hash_original_method = "A019E2D84135E4E25D7FF3C9850D91E8", hash_generated_method = "32DCFE995B95A5038D4A1FB107814467")
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> es = entrySet;
Set<Map.Entry<K,V>> var25D080FAAE722B04AA5C8EBDE33DD606_1283002275 =         (es != null) ? es : (entrySet = new EntrySet());
        var25D080FAAE722B04AA5C8EBDE33DD606_1283002275.addTaint(taint);
        return var25D080FAAE722B04AA5C8EBDE33DD606_1283002275;
        // ---------- Original Method ----------
        //Set<Map.Entry<K,V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.493 -0400", hash_original_method = "1378C07218E9226BC9F7AD403D7C2636", hash_generated_method = "1C22E698AC4724F022E676A554728F7D")
    public Enumeration<K> keys() {
Enumeration<K> var3934136BB713579A43A8E8C1C3034CA0_1909038873 =         new KeyIterator();
        var3934136BB713579A43A8E8C1C3034CA0_1909038873.addTaint(taint);
        return var3934136BB713579A43A8E8C1C3034CA0_1909038873;
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.493 -0400", hash_original_method = "5CBB59F043F7E5A98C79AC06A0CCF84B", hash_generated_method = "B1418C200BB7829D2C9A3D35FCDD8FA6")
    public Enumeration<V> elements() {
Enumeration<V> varA5D0B7DD47403A81B3461DEE499DEE74_1147019218 =         new ValueIterator();
        varA5D0B7DD47403A81B3461DEE499DEE74_1147019218.addTaint(taint);
        return varA5D0B7DD47403A81B3461DEE499DEE74_1147019218;
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.493 -0400", hash_original_method = "39AA0B3013D1EF3A3A6D6B7DFFE53DC3", hash_generated_method = "F38085849F4A55073030916148165AC9")
    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        addTaint(s.getTaint());
        s.defaultWriteObject();
for(int k = 0;k < segments.length;++k)
        {
            Segment<K,V> seg = segments[k];
            seg.lock();
            try 
            {
                HashEntry<K,V>[] tab = seg.table;
for(int i = 0;i < tab.length;++i)
                {
for(HashEntry<K,V> e = tab[i];e != null;e = e.next)
                    {
                        s.writeObject(e.key);
                        s.writeObject(e.value);
                    } //End block
                } //End block
            } //End block
            finally 
            {
                seg.unlock();
            } //End block
        } //End block
        s.writeObject(null);
        s.writeObject(null);
        // ---------- Original Method ----------
        //s.defaultWriteObject();
        //for (int k = 0; k < segments.length; ++k) {
            //Segment<K,V> seg = segments[k];
            //seg.lock();
            //try {
                //HashEntry<K,V>[] tab = seg.table;
                //for (int i = 0; i < tab.length; ++i) {
                    //for (HashEntry<K,V> e = tab[i]; e != null; e = e.next) {
                        //s.writeObject(e.key);
                        //s.writeObject(e.value);
                    //}
                //}
            //} finally {
                //seg.unlock();
            //}
        //}
        //s.writeObject(null);
        //s.writeObject(null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.494 -0400", hash_original_method = "27FA8D459FE7A66670B6D1423BE5DC25", hash_generated_method = "9BE88E4957E056FC7CBF2EE5C4389504")
    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        addTaint(s.getTaint());
        s.defaultReadObject();
for(int i = 0;i < segments.length;++i)
        {
            segments[i].setTable(new HashEntry[1]);
        } //End block
for(;;)
        {
            K key = (K) s.readObject();
            V value = (V) s.readObject();
            if(key == null)            
            break;
            put(key, value);
        } //End block
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //for (int i = 0; i < segments.length; ++i) {
            //segments[i].setTable(new HashEntry[1]);
        //}
        //for (;;) {
            //K key = (K) s.readObject();
            //V value = (V) s.readObject();
            //if (key == null)
                //break;
            //put(key, value);
        //}
    }

    
    static final class HashEntry<K,V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.494 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.494 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.494 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D9A5701E394E22D841141BE91A2D9F15")

        volatile V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.494 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "AC47A60384D70A26B3EF9024FD965BF5")

        HashEntry<K,V> next;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.494 -0400", hash_original_method = "89FFAB6F57FFB83251DFC8FAF8476851", hash_generated_method = "8A58D929EE079DEBCD95A67A156E3547")
          HashEntry(K key, int hash, HashEntry<K,V> next, V value) {
            this.key = key;
            this.hash = hash;
            this.next = next;
            this.value = value;
            // ---------- Original Method ----------
            //this.key = key;
            //this.hash = hash;
            //this.next = next;
            //this.value = value;
        }

        
        @SuppressWarnings("unchecked")
        static final <K,V> HashEntry<K,V>[] newArray(int i) {
            return new HashEntry[i];
        }

        
    }


    
    static final class Segment<K,V> extends ReentrantLock implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.495 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "A5A8CDA7B0601BDA04B06999B66113E1")

        transient volatile int count;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.495 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "66B0BB3B51ED8DFDAEFDC2833CA7C4AB")

        transient int modCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.495 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "EBFF2C10A18F7B4BDFBFF5FE82B9E916")

        transient int threshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.495 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "7AFDE33CE4930D8257094745BD6A1CD4")

        transient volatile HashEntry<K,V>[] table;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.495 -0400", hash_original_field = "97C293EF8ABD832D29E88C21D8E562F5", hash_generated_field = "9AE85CE37BA4DE356F76E49D73EDA32D")

        float loadFactor;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.495 -0400", hash_original_method = "467240A23868E01B6F6E31DCEE5330A3", hash_generated_method = "20784A3B2163F8A8EBBC0C3169DA3A53")
          Segment(int initialCapacity, float lf) {
            addTaint(initialCapacity);
            loadFactor = lf;
            setTable(HashEntry.<K,V>newArray(initialCapacity));
            // ---------- Original Method ----------
            //loadFactor = lf;
            //setTable(HashEntry.<K,V>newArray(initialCapacity));
        }

        
        @SuppressWarnings("unchecked")
        static final <K,V> Segment<K,V>[] newArray(int i) {
            return new Segment[i];
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.495 -0400", hash_original_method = "76FBB7D49FE13DE65CD87FF1D7913D53", hash_generated_method = "3CA87F2CA9B91DD40FEA6234D1C6C098")
         void setTable(HashEntry<K,V>[] newTable) {
            threshold = (int)(newTable.length * loadFactor);
            table = newTable;
            // ---------- Original Method ----------
            //threshold = (int)(newTable.length * loadFactor);
            //table = newTable;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.495 -0400", hash_original_method = "526D0582321A198EF4385AC6C7D29654", hash_generated_method = "2A38D64BD4EF5D3A8C2BB962EE0FDC55")
         HashEntry<K,V> getFirst(int hash) {
            addTaint(hash);
            HashEntry<K,V>[] tab = table;
HashEntry<K,V> var0FA78C090C8091B6BCA949F01FFB4F37_1002397411 =             tab[hash & (tab.length - 1)];
            var0FA78C090C8091B6BCA949F01FFB4F37_1002397411.addTaint(taint);
            return var0FA78C090C8091B6BCA949F01FFB4F37_1002397411;
            // ---------- Original Method ----------
            //HashEntry<K,V>[] tab = table;
            //return tab[hash & (tab.length - 1)];
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.495 -0400", hash_original_method = "6C9E8EADE7BF0CF7C06CF8A72D599D54", hash_generated_method = "66981BAC467F0DF57E6A9CA1634A623B")
         V readValueUnderLock(HashEntry<K,V> e) {
            addTaint(e.getTaint());
            lock();
            try 
            {
V var65D32B0ADAFF3F55986024909BAFC34B_1234176138 =                 e.value;
                var65D32B0ADAFF3F55986024909BAFC34B_1234176138.addTaint(taint);
                return var65D32B0ADAFF3F55986024909BAFC34B_1234176138;
            } //End block
            finally 
            {
                unlock();
            } //End block
            // ---------- Original Method ----------
            //lock();
            //try {
                //return e.value;
            //} finally {
                //unlock();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.496 -0400", hash_original_method = "1AC5B4CC2690982021F35FD4CB4FB319", hash_generated_method = "383F07A31525183A657F4AF33FF3B6B3")
         V get(Object key, int hash) {
            addTaint(hash);
            addTaint(key.getTaint());
            if(count != 0)            
            {
                HashEntry<K,V> e = getFirst(hash);
                while
(e != null)                
                {
                    if(e.hash == hash && key.equals(e.key))                    
                    {
                        V v = e.value;
                        if(v != null)                        
                        {
V var6DC76BC51820DD65E8396280E884AA78_776139377 =                         v;
                        var6DC76BC51820DD65E8396280E884AA78_776139377.addTaint(taint);
                        return var6DC76BC51820DD65E8396280E884AA78_776139377;
                        }
V var20A15466315772769C99DC55299061F2_1426523364 =                         readValueUnderLock(e);
                        var20A15466315772769C99DC55299061F2_1426523364.addTaint(taint);
                        return var20A15466315772769C99DC55299061F2_1426523364;
                    } //End block
                    e = e.next;
                } //End block
            } //End block
V var540C13E9E156B687226421B24F2DF178_752889385 =             null;
            var540C13E9E156B687226421B24F2DF178_752889385.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_752889385;
            // ---------- Original Method ----------
            //if (count != 0) { 
                //HashEntry<K,V> e = getFirst(hash);
                //while (e != null) {
                    //if (e.hash == hash && key.equals(e.key)) {
                        //V v = e.value;
                        //if (v != null)
                            //return v;
                        //return readValueUnderLock(e); 
                    //}
                    //e = e.next;
                //}
            //}
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.496 -0400", hash_original_method = "4906CD88672F5095094E2A23826E0F83", hash_generated_method = "5A8F2D30E323B7332834759246FCB1AB")
         boolean containsKey(Object key, int hash) {
            addTaint(hash);
            addTaint(key.getTaint());
            if(count != 0)            
            {
                HashEntry<K,V> e = getFirst(hash);
                while
(e != null)                
                {
                    if(e.hash == hash && key.equals(e.key))                    
                    {
                    boolean varB326B5062B2F0E69046810717534CB09_1417259290 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_884984229 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_884984229;
                    }
                    e = e.next;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1780200401 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024848617 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024848617;
            // ---------- Original Method ----------
            //if (count != 0) { 
                //HashEntry<K,V> e = getFirst(hash);
                //while (e != null) {
                    //if (e.hash == hash && key.equals(e.key))
                        //return true;
                    //e = e.next;
                //}
            //}
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.496 -0400", hash_original_method = "4B02A5A0C6C760AB5CD92802AE9AC755", hash_generated_method = "8B2C34A568460DD4D1334A2D922748B8")
         boolean containsValue(Object value) {
            addTaint(value.getTaint());
            if(count != 0)            
            {
                HashEntry<K,V>[] tab = table;
                int len = tab.length;
for(int i = 0;i < len;i++)
                {
for(HashEntry<K,V> e = tab[i];e != null;e = e.next)
                    {
                        V v = e.value;
                        if(v == null)                        
                        v = readValueUnderLock(e);
                        if(value.equals(v))                        
                        {
                        boolean varB326B5062B2F0E69046810717534CB09_853524204 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_173514353 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_173514353;
                        }
                    } //End block
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_779579029 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750392479 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_750392479;
            // ---------- Original Method ----------
            //if (count != 0) { 
                //HashEntry<K,V>[] tab = table;
                //int len = tab.length;
                //for (int i = 0 ; i < len; i++) {
                    //for (HashEntry<K,V> e = tab[i]; e != null; e = e.next) {
                        //V v = e.value;
                        //if (v == null) 
                            //v = readValueUnderLock(e);
                        //if (value.equals(v))
                            //return true;
                    //}
                //}
            //}
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.497 -0400", hash_original_method = "B03D3F6036D4D187AC672F9D98953439", hash_generated_method = "9AB8F512C49BF650D539457545C3A03E")
         boolean replace(K key, int hash, V oldValue, V newValue) {
            addTaint(newValue.getTaint());
            addTaint(oldValue.getTaint());
            addTaint(hash);
            addTaint(key.getTaint());
            lock();
            try 
            {
                HashEntry<K,V> e = getFirst(hash);
                while
(e != null && (e.hash != hash || !key.equals(e.key)))                
                e = e.next;
                boolean replaced = false;
                if(e != null && oldValue.equals(e.value))                
                {
                    replaced = true;
                    e.value = newValue;
                } //End block
                boolean var91BB248359043FE98416E259C9BDF10D_822764130 = (replaced);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_995713141 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_995713141;
            } //End block
            finally 
            {
                unlock();
            } //End block
            // ---------- Original Method ----------
            //lock();
            //try {
                //HashEntry<K,V> e = getFirst(hash);
                //while (e != null && (e.hash != hash || !key.equals(e.key)))
                    //e = e.next;
                //boolean replaced = false;
                //if (e != null && oldValue.equals(e.value)) {
                    //replaced = true;
                    //e.value = newValue;
                //}
                //return replaced;
            //} finally {
                //unlock();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.497 -0400", hash_original_method = "496F1B463B31D22372CDAB52F4D749A3", hash_generated_method = "3AA3FC3AC00114D2271D296616963A9A")
         V replace(K key, int hash, V newValue) {
            addTaint(newValue.getTaint());
            addTaint(hash);
            addTaint(key.getTaint());
            lock();
            try 
            {
                HashEntry<K,V> e = getFirst(hash);
                while
(e != null && (e.hash != hash || !key.equals(e.key)))                
                e = e.next;
                V oldValue = null;
                if(e != null)                
                {
                    oldValue = e.value;
                    e.value = newValue;
                } //End block
V var8CDBD2181CBEF5C2129AFFA68C014D4A_9619215 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_9619215.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_9619215;
            } //End block
            finally 
            {
                unlock();
            } //End block
            // ---------- Original Method ----------
            //lock();
            //try {
                //HashEntry<K,V> e = getFirst(hash);
                //while (e != null && (e.hash != hash || !key.equals(e.key)))
                    //e = e.next;
                //V oldValue = null;
                //if (e != null) {
                    //oldValue = e.value;
                    //e.value = newValue;
                //}
                //return oldValue;
            //} finally {
                //unlock();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.497 -0400", hash_original_method = "F92903F43B391F8F1B397027DA8E7AA9", hash_generated_method = "99BCBF92A1AD270A3340D50BA23B5951")
         V put(K key, int hash, V value, boolean onlyIfAbsent) {
            addTaint(onlyIfAbsent);
            addTaint(value.getTaint());
            addTaint(hash);
            addTaint(key.getTaint());
            lock();
            try 
            {
                int c = count;
                if(c++ > threshold)                
                rehash();
                HashEntry<K,V>[] tab = table;
                int index = hash & (tab.length - 1);
                HashEntry<K,V> first = tab[index];
                HashEntry<K,V> e = first;
                while
(e != null && (e.hash != hash || !key.equals(e.key)))                
                e = e.next;
                V oldValue;
                if(e != null)                
                {
                    oldValue = e.value;
                    if(!onlyIfAbsent)                    
                    e.value = value;
                } //End block
                else
                {
                    oldValue = null;
                    ++modCount;
                    tab[index] = new HashEntry<K,V>(key, hash, first, value);
                    count = c;
                } //End block
V var8CDBD2181CBEF5C2129AFFA68C014D4A_639153053 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_639153053.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_639153053;
            } //End block
            finally 
            {
                unlock();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.498 -0400", hash_original_method = "7AA7A225DF7E6D5CA86650AFCB7B431B", hash_generated_method = "8BAC461036EC1828EEDB915060B0025A")
         void rehash() {
            HashEntry<K,V>[] oldTable = table;
            int oldCapacity = oldTable.length;
            if(oldCapacity >= MAXIMUM_CAPACITY)            
            return;
            HashEntry<K,V>[] newTable = HashEntry.newArray(oldCapacity<<1);
            threshold = (int)(newTable.length * loadFactor);
            int sizeMask = newTable.length - 1;
for(int i = 0;i < oldCapacity;i++)
            {
                HashEntry<K,V> e = oldTable[i];
                if(e != null)                
                {
                    HashEntry<K,V> next = e.next;
                    int idx = e.hash & sizeMask;
                    if(next == null)                    
                    newTable[idx] = e;
                    else
                    {
                        HashEntry<K,V> lastRun = e;
                        int lastIdx = idx;
for(HashEntry<K,V> last = next;last != null;last = last.next)
                        {
                            int k = last.hash & sizeMask;
                            if(k != lastIdx)                            
                            {
                                lastIdx = k;
                                lastRun = last;
                            } //End block
                        } //End block
                        newTable[lastIdx] = lastRun;
for(HashEntry<K,V> p = e;p != lastRun;p = p.next)
                        {
                            int k = p.hash & sizeMask;
                            HashEntry<K,V> n = newTable[k];
                            newTable[k] = new HashEntry<K,V>(p.key, p.hash,
                                                             n, p.value);
                        } //End block
                    } //End block
                } //End block
            } //End block
            table = newTable;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.499 -0400", hash_original_method = "A22DE89D38A395B57956004D412DD3F5", hash_generated_method = "113A98C9C43B91FCCE951278D99D719F")
         V remove(Object key, int hash, Object value) {
            addTaint(value.getTaint());
            addTaint(hash);
            addTaint(key.getTaint());
            lock();
            try 
            {
                int c = count - 1;
                HashEntry<K,V>[] tab = table;
                int index = hash & (tab.length - 1);
                HashEntry<K,V> first = tab[index];
                HashEntry<K,V> e = first;
                while
(e != null && (e.hash != hash || !key.equals(e.key)))                
                e = e.next;
                V oldValue = null;
                if(e != null)                
                {
                    V v = e.value;
                    if(value == null || value.equals(v))                    
                    {
                        oldValue = v;
                        ++modCount;
                        HashEntry<K,V> newFirst = e.next;
for(HashEntry<K,V> p = first;p != e;p = p.next)
                        newFirst = new HashEntry<K,V>(p.key, p.hash,
                                                          newFirst, p.value);
                        tab[index] = newFirst;
                        count = c;
                    } //End block
                } //End block
V var8CDBD2181CBEF5C2129AFFA68C014D4A_840746860 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_840746860.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_840746860;
            } //End block
            finally 
            {
                unlock();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.499 -0400", hash_original_method = "20609B8FF53EC43AEB5A4460B52EBDFF", hash_generated_method = "459F9E052AD7579835F7FCEC4031D7AC")
         void clear() {
            if(count != 0)            
            {
                lock();
                try 
                {
                    HashEntry<K,V>[] tab = table;
for(int i = 0;i < tab.length;i++)
                    tab[i] = null;
                    ++modCount;
                    count = 0;
                } //End block
                finally 
                {
                    unlock();
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (count != 0) {
                //lock();
                //try {
                    //HashEntry<K,V>[] tab = table;
                    //for (int i = 0; i < tab.length ; i++)
                        //tab[i] = null;
                    //++modCount;
                    //count = 0; 
                //} finally {
                    //unlock();
                //}
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.499 -0400", hash_original_field = "50094462426A989CA556C53151CA22A4", hash_generated_field = "63C62A82A3FF7049D8720153B66FBF4F")

        private static final long serialVersionUID = 2249069246763182397L;
    }


    
    abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.499 -0400", hash_original_field = "735C46731EEFB77B5ECB5630A622022B", hash_generated_field = "6D9B0937081A44F32DBD7158CFD76C24")

        int nextSegmentIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.499 -0400", hash_original_field = "F8C5594496DE1EFBE5BC9860038CE5E1", hash_generated_field = "2A2A99ACC13355EBDE9E414F85DC6404")

        int nextTableIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.500 -0400", hash_original_field = "73EBE5C2CCB25E5F693EC01CFE4A9A12", hash_generated_field = "0851F1AD358B7E0A6DDF18DC99A51E84")

        HashEntry<K,V>[] currentTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.500 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "34F1B1A1DBD9F7012195EE8A5509C745")

        HashEntry<K, V> nextEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.500 -0400", hash_original_field = "41032E42645C86567A380648031CF141", hash_generated_field = "EF55F7F73AA7A34DDB20CE140C1B2DB7")

        HashEntry<K, V> lastReturned;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.500 -0400", hash_original_method = "1331DC8249C406CC83024534A57FEFEB", hash_generated_method = "D903CC46D67C5E6BD87F25FE63BEB736")
          HashIterator() {
            nextSegmentIndex = segments.length - 1;
            nextTableIndex = -1;
            advance();
            // ---------- Original Method ----------
            //nextSegmentIndex = segments.length - 1;
            //nextTableIndex = -1;
            //advance();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.500 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "ADB468B06EDAFA7CAD24AC394F73BE59")
        public boolean hasMoreElements() {
            boolean varABBE3B24714136305D7430F5669CF141_41746864 = (hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992701065 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992701065;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.500 -0400", hash_original_method = "A06EA4B51D378F01CE00F7FB99A616EF", hash_generated_method = "F6D15BCA9A4C3C844E84A459510518AE")
        final void advance() {
            if(nextEntry != null && (nextEntry = nextEntry.next) != null)            
            return;
            while
(nextTableIndex >= 0)            
            {
                if((nextEntry = currentTable[nextTableIndex--]) != null)                
                return;
            } //End block
            while
(nextSegmentIndex >= 0)            
            {
                Segment<K,V> seg = segments[nextSegmentIndex--];
                if(seg.count != 0)                
                {
                    currentTable = seg.table;
for(int j = currentTable.length - 1;j >= 0;--j)
                    {
                        if((nextEntry = currentTable[j]) != null)                        
                        {
                            nextTableIndex = j - 1;
                            return;
                        } //End block
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (nextEntry != null && (nextEntry = nextEntry.next) != null)
                //return;
            //while (nextTableIndex >= 0) {
                //if ( (nextEntry = currentTable[nextTableIndex--]) != null)
                    //return;
            //}
            //while (nextSegmentIndex >= 0) {
                //Segment<K,V> seg = segments[nextSegmentIndex--];
                //if (seg.count != 0) {
                    //currentTable = seg.table;
                    //for (int j = currentTable.length - 1; j >= 0; --j) {
                        //if ( (nextEntry = currentTable[j]) != null) {
                            //nextTableIndex = j - 1;
                            //return;
                        //}
                    //}
                //}
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.500 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "274568FAC5C36B1AFC59A799C88C824E")
        public boolean hasNext() {
            boolean var89CBB2F442CE6BC294273342C489EBAF_46958077 = (nextEntry != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_694634350 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_694634350;
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.501 -0400", hash_original_method = "DB7CF742BB593212DEE9E7DE200FEED8", hash_generated_method = "1EF21C22EC4BDC0A1682BCF9BA8B5297")
         HashEntry<K,V> nextEntry() {
            if(nextEntry == null)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_708651315 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_708651315.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_708651315;
            }
            lastReturned = nextEntry;
            advance();
HashEntry<K,V> varBB386FC8A1600B8B2770D46D0DDD0432_1531597213 =             lastReturned;
            varBB386FC8A1600B8B2770D46D0DDD0432_1531597213.addTaint(taint);
            return varBB386FC8A1600B8B2770D46D0DDD0432_1531597213;
            // ---------- Original Method ----------
            //if (nextEntry == null)
                //throw new NoSuchElementException();
            //lastReturned = nextEntry;
            //advance();
            //return lastReturned;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.501 -0400", hash_original_method = "EB8010C2D5EA80D446C3485BFC85793F", hash_generated_method = "CC24351E3062A9099419E556CC0FE442")
        public void remove() {
            if(lastReturned == null)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1578663698 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1578663698.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1578663698;
            }
            ConcurrentHashMap.this.remove(lastReturned.key);
            lastReturned = null;
            // ---------- Original Method ----------
            //if (lastReturned == null)
                //throw new IllegalStateException();
            //ConcurrentHashMap.this.remove(lastReturned.key);
            //lastReturned = null;
        }

        
    }


    
    final class KeyIterator extends HashIterator implements Iterator<K>, Enumeration<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.501 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.501 -0400", hash_original_method = "AC02B860B54618170BE24E50FF82F167", hash_generated_method = "D56F9294E0803C4797D8A4E63D171004")
        public K next() {
K var14F628CF3ADA3267E4D35928D18FC85F_1007599845 =             super.nextEntry().key;
            var14F628CF3ADA3267E4D35928D18FC85F_1007599845.addTaint(taint);
            return var14F628CF3ADA3267E4D35928D18FC85F_1007599845;
            // ---------- Original Method ----------
            //return super.nextEntry().key;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.501 -0400", hash_original_method = "1473F8B0EF10582FE9B24F9D164CBEAD", hash_generated_method = "0050AB7122F2EC8D754919A710A3AF0E")
        public K nextElement() {
K var14F628CF3ADA3267E4D35928D18FC85F_192576037 =             super.nextEntry().key;
            var14F628CF3ADA3267E4D35928D18FC85F_192576037.addTaint(taint);
            return var14F628CF3ADA3267E4D35928D18FC85F_192576037;
            // ---------- Original Method ----------
            //return super.nextEntry().key;
        }

        
    }


    
    final class ValueIterator extends HashIterator implements Iterator<V>, Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.501 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.501 -0400", hash_original_method = "282B954004CE321F97FD15862590F160", hash_generated_method = "7E18FF94992BE9A064E09EFB851A24FD")
        public V next() {
V varDDD34ECB520407FF2B35D37A084182FA_1628613394 =             super.nextEntry().value;
            varDDD34ECB520407FF2B35D37A084182FA_1628613394.addTaint(taint);
            return varDDD34ECB520407FF2B35D37A084182FA_1628613394;
            // ---------- Original Method ----------
            //return super.nextEntry().value;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.501 -0400", hash_original_method = "95D48303D225ADC424CB718F2FA08908", hash_generated_method = "430CF063B92073ACDBF06F8A62673EE3")
        public V nextElement() {
V varDDD34ECB520407FF2B35D37A084182FA_1980315925 =             super.nextEntry().value;
            varDDD34ECB520407FF2B35D37A084182FA_1980315925.addTaint(taint);
            return varDDD34ECB520407FF2B35D37A084182FA_1980315925;
            // ---------- Original Method ----------
            //return super.nextEntry().value;
        }

        
    }


    
    final class WriteThroughEntry extends AbstractMap.SimpleEntry<K,V> {
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.501 -0400", hash_original_method = "A56113014EC205E193BCD1C4F8B24855", hash_generated_method = "272362F5E07165D243582536CFFD1277")
          WriteThroughEntry(K k, V v) {
            super(k,v);
            addTaint(v.getTaint());
            addTaint(k.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.502 -0400", hash_original_method = "38F302BB69197C5906EE6F553583F6F9", hash_generated_method = "E0357D3C694E005DA70E0BB77F7A1F8E")
        public V setValue(V value) {
            addTaint(value.getTaint());
            if(value == null)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_806834470 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_806834470.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_806834470;
            }
            V v = super.setValue(value);
            ConcurrentHashMap.this.put(getKey(), value);
V var6DC76BC51820DD65E8396280E884AA78_1770393322 =             v;
            var6DC76BC51820DD65E8396280E884AA78_1770393322.addTaint(taint);
            return var6DC76BC51820DD65E8396280E884AA78_1770393322;
            // ---------- Original Method ----------
            //if (value == null) throw new NullPointerException();
            //V v = super.setValue(value);
            //ConcurrentHashMap.this.put(getKey(), value);
            //return v;
        }

        
    }


    
    final class EntryIterator extends HashIterator implements Iterator<Entry<K,V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.502 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.502 -0400", hash_original_method = "DA1DC8695C9406305A6247D7AF5617DE", hash_generated_method = "E5A183B97FA56EF56AB15F4948F51ECF")
        public Map.Entry<K,V> next() {
            HashEntry<K,V> e = super.nextEntry();
Map.Entry<K,V> var519386A83C4C9C32B145A2A117BFFCE0_2020069393 =             new WriteThroughEntry(e.key, e.value);
            var519386A83C4C9C32B145A2A117BFFCE0_2020069393.addTaint(taint);
            return var519386A83C4C9C32B145A2A117BFFCE0_2020069393;
            // ---------- Original Method ----------
            //HashEntry<K,V> e = super.nextEntry();
            //return new WriteThroughEntry(e.key, e.value);
        }

        
    }


    
    final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.502 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.502 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "D2FBA81B0D07E354327B590DE019BC3C")
        public Iterator<K> iterator() {
Iterator<K> var3934136BB713579A43A8E8C1C3034CA0_331792254 =             new KeyIterator();
            var3934136BB713579A43A8E8C1C3034CA0_331792254.addTaint(taint);
            return var3934136BB713579A43A8E8C1C3034CA0_331792254;
            // ---------- Original Method ----------
            //return new KeyIterator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.502 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "F5DB2C5A22A92183519326C96C52F4DF")
        public int size() {
            int var345B11F0DA09C9FA75700FC5C9489627_1818579028 = (ConcurrentHashMap.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464530811 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464530811;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.502 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "18E58D05E235AD105531A5E404574C7B")
        public boolean isEmpty() {
            boolean var7C345E5125DF1DAD9DC32F0A16C89075_526910508 = (ConcurrentHashMap.this.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_861768526 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_861768526;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.isEmpty();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.502 -0400", hash_original_method = "37248D467FF06BE0B2F5DDC1489510DF", hash_generated_method = "64E29AAE513374935298371A9413CCDD")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var39B78C1543C496539E50C19D7342DEA2_1020544823 = (ConcurrentHashMap.this.containsKey(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_471598174 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_471598174;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.containsKey(o);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.502 -0400", hash_original_method = "5AA31A160A27D834D20E2EBCA8B4999F", hash_generated_method = "AE85A984F2F0F28CFBBCF88A651F2F3E")
        public boolean remove(Object o) {
            addTaint(o.getTaint());
            boolean varE270B1B475C7049CF136F5238DAD836A_182103636 = (ConcurrentHashMap.this.remove(o) != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1883396538 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1883396538;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.remove(o) != null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.502 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        public void clear() {
            ConcurrentHashMap.this.clear();
            // ---------- Original Method ----------
            //ConcurrentHashMap.this.clear();
        }

        
    }


    
    final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.503 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.503 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "FB7D20B5CF0865F2F32DC85E73BCF127")
        public Iterator<V> iterator() {
Iterator<V> varA5D0B7DD47403A81B3461DEE499DEE74_652218745 =             new ValueIterator();
            varA5D0B7DD47403A81B3461DEE499DEE74_652218745.addTaint(taint);
            return varA5D0B7DD47403A81B3461DEE499DEE74_652218745;
            // ---------- Original Method ----------
            //return new ValueIterator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.503 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "DDFD825FABE059AA4F94C1BB102B51A7")
        public int size() {
            int var345B11F0DA09C9FA75700FC5C9489627_1559881988 = (ConcurrentHashMap.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020468092 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020468092;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.503 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "562A2A30D3A6D2302B45BE635E21EF61")
        public boolean isEmpty() {
            boolean var7C345E5125DF1DAD9DC32F0A16C89075_2121788149 = (ConcurrentHashMap.this.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255777588 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255777588;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.isEmpty();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.503 -0400", hash_original_method = "6F20D95CF6074119AB0347E3FAAE80A2", hash_generated_method = "EC22C522187679086BE7575BA72370C9")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var457DF1E22DBB88994FE6A2C27CDFF858_937774049 = (ConcurrentHashMap.this.containsValue(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746455153 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746455153;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.containsValue(o);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.503 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        public void clear() {
            ConcurrentHashMap.this.clear();
            // ---------- Original Method ----------
            //ConcurrentHashMap.this.clear();
        }

        
    }


    
    final class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.503 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.503 -0400", hash_original_method = "A1AF959F7C17DD47B4014053BC413A23", hash_generated_method = "8D15EAA7499D8D92B1995383B16C47AD")
        public Iterator<Map.Entry<K,V>> iterator() {
Iterator<Map.Entry<K,V>> varA27729B8E339A6F174B2D9A9BA7B896F_2115037125 =             new EntryIterator();
            varA27729B8E339A6F174B2D9A9BA7B896F_2115037125.addTaint(taint);
            return varA27729B8E339A6F174B2D9A9BA7B896F_2115037125;
            // ---------- Original Method ----------
            //return new EntryIterator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.503 -0400", hash_original_method = "44CFEB1CC21C67EDDE5E7F2C0FB0C916", hash_generated_method = "0A07C76F52DDA4B794C652093E856B72")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            if(!(o instanceof Map.Entry))            
            {
            boolean var68934A3E9455FA72420237EB05902327_2048860309 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_133184981 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_133184981;
            }
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            V v = ConcurrentHashMap.this.get(e.getKey());
            boolean varE7EE7D5469E58955D06CF5388CFAA910_938606544 = (v != null && v.equals(e.getValue()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1608851957 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1608851957;
            // ---------- Original Method ----------
            //if (!(o instanceof Map.Entry))
                //return false;
            //Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            //V v = ConcurrentHashMap.this.get(e.getKey());
            //return v != null && v.equals(e.getValue());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.503 -0400", hash_original_method = "8F57FBEE664B771D5FDC7BC47FB0BA8F", hash_generated_method = "C05BB6987273C4A208A6EC5303B7C944")
        public boolean remove(Object o) {
            addTaint(o.getTaint());
            if(!(o instanceof Map.Entry))            
            {
            boolean var68934A3E9455FA72420237EB05902327_200531369 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1480364257 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1480364257;
            }
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            boolean varEF9E2634FE850530C4B16DAA0CF0AF0B_2069735526 = (ConcurrentHashMap.this.remove(e.getKey(), e.getValue()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1431652031 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1431652031;
            // ---------- Original Method ----------
            //if (!(o instanceof Map.Entry))
                //return false;
            //Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            //return ConcurrentHashMap.this.remove(e.getKey(), e.getValue());
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.504 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "4FC6AF644882BAF18C1BCB765A4A25D5")
        public int size() {
            int var345B11F0DA09C9FA75700FC5C9489627_287796449 = (ConcurrentHashMap.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_509150645 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_509150645;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.504 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "BAEEE6E3B33B47B40EDA9BF50799EBF4")
        public boolean isEmpty() {
            boolean var7C345E5125DF1DAD9DC32F0A16C89075_1598423656 = (ConcurrentHashMap.this.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_430056973 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_430056973;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.isEmpty();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.504 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        public void clear() {
            ConcurrentHashMap.this.clear();
            // ---------- Original Method ----------
            //ConcurrentHashMap.this.clear();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.504 -0400", hash_original_field = "38B2FE469B8CC3659DBEBB0BBB913A6C", hash_generated_field = "CFEA0CB484FBA67AE2EE2BC289FD3823")

    private static final long serialVersionUID = 7249069246763182397L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.504 -0400", hash_original_field = "F2DE208954D426D31F499310022241CF", hash_generated_field = "E41669AD5B156D132F42EF1B84E41D37")

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.504 -0400", hash_original_field = "DF48F8D92FC36ACC8968654109C53FC4", hash_generated_field = "A8CC9CBDCFEE884AAACD2650D6276B04")

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.504 -0400", hash_original_field = "ED64AF2D88EA33EF6133115E5E8FFE32", hash_generated_field = "6CEFE70232E37AD1C46346373D85BAC4")

    static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.504 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "F5FAB930A5B7C8AC42E4718B6294507D")

    static final int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.504 -0400", hash_original_field = "C9E0D462440D958860E70662EC748F43", hash_generated_field = "7552200CFB9EB51127B30554F45C2149")

    static final int MAX_SEGMENTS = 1 << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.504 -0400", hash_original_field = "4866497D0659FC39D1D9B2B7C08C16DB", hash_generated_field = "C971A9BB3C20B29D95F33E07A3449F39")

    static final int RETRIES_BEFORE_LOCK = 2;
}


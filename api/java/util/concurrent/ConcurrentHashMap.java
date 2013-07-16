package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.concurrent.locks.*;
import java.util.*;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.383 -0400", hash_original_field = "6E087A676FE9EB60B1F8BDB5CE343DC8", hash_generated_field = "4BE7BE92627D08015B3B3DAF23AD6BAD")

    int segmentMask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.383 -0400", hash_original_field = "4CDE234FA7C6312E0DF85BE9485BF1E3", hash_generated_field = "306EF00C73243987FA23D1582323C779")

    int segmentShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.383 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "8FCA8AAE37A6D97176077745C90AB57A")

    Segment<K,V>[] segments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.383 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "B015B4740FB481B602A7C5EA08044E34")

    transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.383 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "8070B936D9AF3972F9E8198F31643848")

    transient Set<Map.Entry<K,V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.383 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "1963670AE696FF62CC56DF446CAA129C")

    transient Collection<V> values;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.385 -0400", hash_original_method = "E1CECF835D0BD6DA840C10527C435227", hash_generated_method = "33E275EE379E90F2EAACC492DD406BAB")
    public  ConcurrentHashMap(int initialCapacity,
                             float loadFactor, int concurrencyLevel) {
        addTaint(concurrencyLevel);
        addTaint(initialCapacity);
    if(!(loadFactor > 0) || initialCapacity < 0 || concurrencyLevel <= 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1882136133 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1882136133.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1882136133;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.385 -0400", hash_original_method = "1B0A2C6B75A6C9CD77B06A2BA6F95389", hash_generated_method = "986E8D4C259C709A18C0ACB4C2A37ACA")
    public  ConcurrentHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, DEFAULT_CONCURRENCY_LEVEL);
        addTaint(loadFactor);
        addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.385 -0400", hash_original_method = "FC082FCC77B50E96B6B6DB58BAB97957", hash_generated_method = "CDAAD7AE035E81DF97303AEAF9A04212")
    public  ConcurrentHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.386 -0400", hash_original_method = "DFADDF9198F2268E7EB2B4F062BE54B9", hash_generated_method = "D4298CEE30095C17DFF133A738118CBC")
    public  ConcurrentHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.386 -0400", hash_original_method = "485F32D8EAC40E4F4B6CB1DCBDB98D35", hash_generated_method = "FC05ACDD7F9F8068DB83CBB872A3BDB0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.386 -0400", hash_original_method = "9480E4BE528687F57BD0A5E0057A4838", hash_generated_method = "5091319B05984E41EECA681BF1DC5FE9")
    final Segment<K,V> segmentFor(int hash) {
        addTaint(hash);
Segment<K,V> var81E1DC7BB6CFBB976BA039133E98DCDC_1238736263 =         segments[(hash >>> segmentShift) & segmentMask];
        var81E1DC7BB6CFBB976BA039133E98DCDC_1238736263.addTaint(taint);
        return var81E1DC7BB6CFBB976BA039133E98DCDC_1238736263;
        // ---------- Original Method ----------
        //return segments[(hash >>> segmentShift) & segmentMask];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.387 -0400", hash_original_method = "1D5F6259D73E7678D3D06BFBE271A26B", hash_generated_method = "0E44A01C20909952218528F823246416")
    public boolean isEmpty() {
        final Segment<K,V>[] segments = this.segments;
        int[] mc = new int[segments.length];
        int mcsum = 0;
for(int i = 0;i < segments.length;++i)
        {
    if(segments[i].count != 0)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1291162984 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1259413244 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1259413244;
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
                boolean var68934A3E9455FA72420237EB05902327_597480782 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1937542308 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1937542308;
                }
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_967676718 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1150713777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1150713777;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.388 -0400", hash_original_method = "BA4A00EBCDE2550C0DA253B4E73A18FB", hash_generated_method = "BE3960FBEF05B87ACBFDC6E1C60AEB6D")
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
        int varE7A95D949116A2DA0F0FA83DC6E76C00_587409420 = (Integer.MAX_VALUE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424797551 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424797551;
        }
        else
        {
        int varD984D8288ADAB7DF06981564287D9240_1511417139 = ((int)sum);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504680423 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504680423;
        }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.389 -0400", hash_original_method = "332CB84E85FBD8A2CB62BBB184B280CA", hash_generated_method = "EC12646CC5C7E264218C43A97B20CA0E")
    public V get(Object key) {
        addTaint(key.getTaint());
        int hash = hash(key.hashCode());
V var58B1A596DF295DAEF8FBFB190D5BE740_1445936734 =         segmentFor(hash).get(key, hash);
        var58B1A596DF295DAEF8FBFB190D5BE740_1445936734.addTaint(taint);
        return var58B1A596DF295DAEF8FBFB190D5BE740_1445936734;
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).get(key, hash);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.389 -0400", hash_original_method = "6145F82DE390788BB7B29DCBC031D263", hash_generated_method = "CCCBA2C0429F656515E10EC32DC5F815")
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
        int hash = hash(key.hashCode());
        boolean var603D0257C52BC77068BB435DD3A21187_1228481944 = (segmentFor(hash).containsKey(key, hash));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_142068592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_142068592;
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).containsKey(key, hash);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.390 -0400", hash_original_method = "F1AF23545DF8C9E4F21CC9D8D7EE161E", hash_generated_method = "E000F50F61A1614981BC3E34E42A6CAB")
    public boolean containsValue(Object value) {
        addTaint(value.getTaint());
    if(value == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_729307 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_729307.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_729307;
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
                boolean varB326B5062B2F0E69046810717534CB09_308762495 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1762349707 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1762349707;
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
            boolean var68934A3E9455FA72420237EB05902327_183436558 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2064339238 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2064339238;
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
        boolean var6CFE61694EE1BB13AE719D47C2F80B7A_675314090 = (found);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_718372409 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_718372409;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.391 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "D9181D236A34C52A27F4622CA8B81F82")
    public boolean contains(Object value) {
        addTaint(value.getTaint());
        boolean varF98DD5D16840FDEEA577F8F359CCE837_924810031 = (containsValue(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1124467380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1124467380;
        // ---------- Original Method ----------
        //return containsValue(value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.391 -0400", hash_original_method = "7B5FF6221D53537744EF141B1F8CB9FD", hash_generated_method = "0D898147D8DA307F26DFC3E62B6C5255")
    public V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
    if(value == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_271242358 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_271242358.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_271242358;
        }
        int hash = hash(key.hashCode());
V varB8E72255B46E49A27EDFFD32AA280918_1134429045 =         segmentFor(hash).put(key, hash, value, false);
        varB8E72255B46E49A27EDFFD32AA280918_1134429045.addTaint(taint);
        return varB8E72255B46E49A27EDFFD32AA280918_1134429045;
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).put(key, hash, value, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.391 -0400", hash_original_method = "667464B5C7B8632F9930C4BABEB48EA8", hash_generated_method = "DA47CC144D96A94F155FD83FEBA55E88")
    public V putIfAbsent(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
    if(value == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2080798457 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_2080798457.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_2080798457;
        }
        int hash = hash(key.hashCode());
V var418D4E99839E5E3DF1FB9C798D977AF2_1453597371 =         segmentFor(hash).put(key, hash, value, true);
        var418D4E99839E5E3DF1FB9C798D977AF2_1453597371.addTaint(taint);
        return var418D4E99839E5E3DF1FB9C798D977AF2_1453597371;
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).put(key, hash, value, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.392 -0400", hash_original_method = "B9175F57BE6F5AB8BBC535010119C8D9", hash_generated_method = "B50B09FC64C3FA250D453424D4DEA45D")
    public void putAll(Map<? extends K, ? extends V> m) {
        addTaint(m.getTaint());
for(Map.Entry<? extends K, ? extends V> e : m.entrySet())
        put(e.getKey(), e.getValue());
        // ---------- Original Method ----------
        //for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            //put(e.getKey(), e.getValue());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.392 -0400", hash_original_method = "337505C9EECB4FFE48F33491B52A72CA", hash_generated_method = "8164BD8B44335AE258DDE9CD94327CF9")
    public V remove(Object key) {
        addTaint(key.getTaint());
        int hash = hash(key.hashCode());
V varF04126AECFC2728B9C58FE5A362B44A0_933890423 =         segmentFor(hash).remove(key, hash, null);
        varF04126AECFC2728B9C58FE5A362B44A0_933890423.addTaint(taint);
        return varF04126AECFC2728B9C58FE5A362B44A0_933890423;
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).remove(key, hash, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.392 -0400", hash_original_method = "B30F0ED29C44EDE9B7A1F9EA4182F243", hash_generated_method = "5AE02CBECBC8FD3EFE23449557901E0C")
    public boolean remove(Object key, Object value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        int hash = hash(key.hashCode());
    if(value == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1803907298 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_911478656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_911478656;
        }
        boolean var5984AFF027ACA5A688DB4D2B8222A21A_336197829 = (segmentFor(hash).remove(key, hash, value) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_406590168 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_406590168;
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //if (value == null)
            //return false;
        //return segmentFor(hash).remove(key, hash, value) != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.393 -0400", hash_original_method = "FFBE8ED355379D3641A692556CD55FD9", hash_generated_method = "A98D59F9ED3925F54FF82539A92B1BD1")
    public boolean replace(K key, V oldValue, V newValue) {
        addTaint(newValue.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(key.getTaint());
    if(oldValue == null || newValue == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1675839395 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1675839395.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1675839395;
        }
        int hash = hash(key.hashCode());
        boolean varF8247769ED22EE4C0591A0066F1EDF98_583058630 = (segmentFor(hash).replace(key, hash, oldValue, newValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_656861708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_656861708;
        // ---------- Original Method ----------
        //if (oldValue == null || newValue == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).replace(key, hash, oldValue, newValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.393 -0400", hash_original_method = "0AA66A0CD7ECE54F0D1BA81883147959", hash_generated_method = "D9A0E98A8AE35006409668B7E5143387")
    public V replace(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
    if(value == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_133885153 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_133885153.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_133885153;
        }
        int hash = hash(key.hashCode());
V var9D64916B4DF1085135740B680007D62A_1757782990 =         segmentFor(hash).replace(key, hash, value);
        var9D64916B4DF1085135740B680007D62A_1757782990.addTaint(taint);
        return var9D64916B4DF1085135740B680007D62A_1757782990;
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).replace(key, hash, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.393 -0400", hash_original_method = "F4B890B3C1A244A1C39416FB7B7BF8FF", hash_generated_method = "1C4E31AEFE8E9D209F1755AF9FACB321")
    public void clear() {
for(int i = 0;i < segments.length;++i)
        segments[i].clear();
        // ---------- Original Method ----------
        //for (int i = 0; i < segments.length; ++i)
            //segments[i].clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.394 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "02DC6A8331AD43EE16AB96C5680627F8")
    public Set<K> keySet() {
        Set<K> ks = keySet;
Set<K> varB6853687BE649BA8B10F9701AD179BB7_2030579971 =         (ks != null) ? ks : (keySet = new KeySet());
        varB6853687BE649BA8B10F9701AD179BB7_2030579971.addTaint(taint);
        return varB6853687BE649BA8B10F9701AD179BB7_2030579971;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.394 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "B8E39A4CF57C77696D871F10E19A249E")
    public Collection<V> values() {
        Collection<V> vs = values;
Collection<V> var5CABA883D65798B391E2C02013734397_1172908011 =         (vs != null) ? vs : (values = new Values());
        var5CABA883D65798B391E2C02013734397_1172908011.addTaint(taint);
        return var5CABA883D65798B391E2C02013734397_1172908011;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.394 -0400", hash_original_method = "A019E2D84135E4E25D7FF3C9850D91E8", hash_generated_method = "87CD1965CD2E888C16D28FAA7EFE5343")
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> es = entrySet;
Set<Map.Entry<K,V>> var25D080FAAE722B04AA5C8EBDE33DD606_1203675481 =         (es != null) ? es : (entrySet = new EntrySet());
        var25D080FAAE722B04AA5C8EBDE33DD606_1203675481.addTaint(taint);
        return var25D080FAAE722B04AA5C8EBDE33DD606_1203675481;
        // ---------- Original Method ----------
        //Set<Map.Entry<K,V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.394 -0400", hash_original_method = "1378C07218E9226BC9F7AD403D7C2636", hash_generated_method = "B036E03DFB6C23C0500B973DF1480021")
    public Enumeration<K> keys() {
Enumeration<K> var3934136BB713579A43A8E8C1C3034CA0_1543331428 =         new KeyIterator();
        var3934136BB713579A43A8E8C1C3034CA0_1543331428.addTaint(taint);
        return var3934136BB713579A43A8E8C1C3034CA0_1543331428;
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.395 -0400", hash_original_method = "5CBB59F043F7E5A98C79AC06A0CCF84B", hash_generated_method = "4884F89C20179D2AC7EE3D2CE93B6E14")
    public Enumeration<V> elements() {
Enumeration<V> varA5D0B7DD47403A81B3461DEE499DEE74_632573418 =         new ValueIterator();
        varA5D0B7DD47403A81B3461DEE499DEE74_632573418.addTaint(taint);
        return varA5D0B7DD47403A81B3461DEE499DEE74_632573418;
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.396 -0400", hash_original_method = "39AA0B3013D1EF3A3A6D6B7DFFE53DC3", hash_generated_method = "F38085849F4A55073030916148165AC9")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.396 -0400", hash_original_method = "27FA8D459FE7A66670B6D1423BE5DC25", hash_generated_method = "9BE88E4957E056FC7CBF2EE5C4389504")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.397 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.397 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.397 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D9A5701E394E22D841141BE91A2D9F15")

        volatile V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.397 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "AC47A60384D70A26B3EF9024FD965BF5")

        HashEntry<K,V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.397 -0400", hash_original_method = "89FFAB6F57FFB83251DFC8FAF8476851", hash_generated_method = "8A58D929EE079DEBCD95A67A156E3547")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.398 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "A5A8CDA7B0601BDA04B06999B66113E1")

        transient volatile int count;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.398 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "66B0BB3B51ED8DFDAEFDC2833CA7C4AB")

        transient int modCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.398 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "EBFF2C10A18F7B4BDFBFF5FE82B9E916")

        transient int threshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.398 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "7AFDE33CE4930D8257094745BD6A1CD4")

        transient volatile HashEntry<K,V>[] table;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.398 -0400", hash_original_field = "97C293EF8ABD832D29E88C21D8E562F5", hash_generated_field = "9AE85CE37BA4DE356F76E49D73EDA32D")

        float loadFactor;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.398 -0400", hash_original_method = "467240A23868E01B6F6E31DCEE5330A3", hash_generated_method = "20784A3B2163F8A8EBBC0C3169DA3A53")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.399 -0400", hash_original_method = "76FBB7D49FE13DE65CD87FF1D7913D53", hash_generated_method = "3CA87F2CA9B91DD40FEA6234D1C6C098")
         void setTable(HashEntry<K,V>[] newTable) {
            threshold = (int)(newTable.length * loadFactor);
            table = newTable;
            // ---------- Original Method ----------
            //threshold = (int)(newTable.length * loadFactor);
            //table = newTable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.399 -0400", hash_original_method = "526D0582321A198EF4385AC6C7D29654", hash_generated_method = "8CCCAEF40296ACFF60C7A4901F714427")
         HashEntry<K,V> getFirst(int hash) {
            addTaint(hash);
            HashEntry<K,V>[] tab = table;
HashEntry<K,V> var0FA78C090C8091B6BCA949F01FFB4F37_1265632397 =             tab[hash & (tab.length - 1)];
            var0FA78C090C8091B6BCA949F01FFB4F37_1265632397.addTaint(taint);
            return var0FA78C090C8091B6BCA949F01FFB4F37_1265632397;
            // ---------- Original Method ----------
            //HashEntry<K,V>[] tab = table;
            //return tab[hash & (tab.length - 1)];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.400 -0400", hash_original_method = "6C9E8EADE7BF0CF7C06CF8A72D599D54", hash_generated_method = "10232CBBB6B5F20CB5940636995C2651")
         V readValueUnderLock(HashEntry<K,V> e) {
            addTaint(e.getTaint());
            lock();
            try 
            {
V var65D32B0ADAFF3F55986024909BAFC34B_1868472724 =                 e.value;
                var65D32B0ADAFF3F55986024909BAFC34B_1868472724.addTaint(taint);
                return var65D32B0ADAFF3F55986024909BAFC34B_1868472724;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.400 -0400", hash_original_method = "1AC5B4CC2690982021F35FD4CB4FB319", hash_generated_method = "9AAA1C5717145E98FF54D3EDDE1AAFF6")
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
V var6DC76BC51820DD65E8396280E884AA78_1373247604 =                         v;
                        var6DC76BC51820DD65E8396280E884AA78_1373247604.addTaint(taint);
                        return var6DC76BC51820DD65E8396280E884AA78_1373247604;
                        }
V var20A15466315772769C99DC55299061F2_824243263 =                         readValueUnderLock(e);
                        var20A15466315772769C99DC55299061F2_824243263.addTaint(taint);
                        return var20A15466315772769C99DC55299061F2_824243263;
                    } //End block
                    e = e.next;
                } //End block
            } //End block
V var540C13E9E156B687226421B24F2DF178_1431839268 =             null;
            var540C13E9E156B687226421B24F2DF178_1431839268.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1431839268;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.401 -0400", hash_original_method = "4906CD88672F5095094E2A23826E0F83", hash_generated_method = "505270FADAC382B6281DF1908AE10956")
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
                    boolean varB326B5062B2F0E69046810717534CB09_489605765 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2132335191 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2132335191;
                    }
                    e = e.next;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1473751961 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_442822714 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_442822714;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.402 -0400", hash_original_method = "4B02A5A0C6C760AB5CD92802AE9AC755", hash_generated_method = "CE07DCCDE5416163625FB4C562B0D147")
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
                        boolean varB326B5062B2F0E69046810717534CB09_638779191 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866330728 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_866330728;
                        }
                    } //End block
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1031717421 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2066548413 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2066548413;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.402 -0400", hash_original_method = "B03D3F6036D4D187AC672F9D98953439", hash_generated_method = "54A44C29FB889AF694D8F31EFDF70CE2")
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
                boolean var91BB248359043FE98416E259C9BDF10D_1783748093 = (replaced);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1581328260 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1581328260;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.403 -0400", hash_original_method = "496F1B463B31D22372CDAB52F4D749A3", hash_generated_method = "A25D5D1745A427305CA33903541E41AF")
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
V var8CDBD2181CBEF5C2129AFFA68C014D4A_1444739809 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_1444739809.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_1444739809;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.404 -0400", hash_original_method = "F92903F43B391F8F1B397027DA8E7AA9", hash_generated_method = "AD4D0FF1E987B02216C5294690C8C522")
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
V var8CDBD2181CBEF5C2129AFFA68C014D4A_279590095 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_279590095.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_279590095;
            } //End block
            finally 
            {
                unlock();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.407 -0400", hash_original_method = "7AA7A225DF7E6D5CA86650AFCB7B431B", hash_generated_method = "8BAC461036EC1828EEDB915060B0025A")
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.409 -0400", hash_original_method = "A22DE89D38A395B57956004D412DD3F5", hash_generated_method = "ECF981E62B3DD1071CA43BAB4769DE0D")
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
V var8CDBD2181CBEF5C2129AFFA68C014D4A_2068527188 =                 oldValue;
                var8CDBD2181CBEF5C2129AFFA68C014D4A_2068527188.addTaint(taint);
                return var8CDBD2181CBEF5C2129AFFA68C014D4A_2068527188;
            } //End block
            finally 
            {
                unlock();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.410 -0400", hash_original_method = "20609B8FF53EC43AEB5A4460B52EBDFF", hash_generated_method = "459F9E052AD7579835F7FCEC4031D7AC")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.410 -0400", hash_original_field = "50094462426A989CA556C53151CA22A4", hash_generated_field = "63C62A82A3FF7049D8720153B66FBF4F")

        private static final long serialVersionUID = 2249069246763182397L;
    }


    
    abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.411 -0400", hash_original_field = "735C46731EEFB77B5ECB5630A622022B", hash_generated_field = "6D9B0937081A44F32DBD7158CFD76C24")

        int nextSegmentIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.411 -0400", hash_original_field = "F8C5594496DE1EFBE5BC9860038CE5E1", hash_generated_field = "2A2A99ACC13355EBDE9E414F85DC6404")

        int nextTableIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.411 -0400", hash_original_field = "73EBE5C2CCB25E5F693EC01CFE4A9A12", hash_generated_field = "0851F1AD358B7E0A6DDF18DC99A51E84")

        HashEntry<K,V>[] currentTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.411 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "34F1B1A1DBD9F7012195EE8A5509C745")

        HashEntry<K, V> nextEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.411 -0400", hash_original_field = "41032E42645C86567A380648031CF141", hash_generated_field = "EF55F7F73AA7A34DDB20CE140C1B2DB7")

        HashEntry<K, V> lastReturned;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.412 -0400", hash_original_method = "1331DC8249C406CC83024534A57FEFEB", hash_generated_method = "D903CC46D67C5E6BD87F25FE63BEB736")
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.412 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "385A5D747A7619D7222DD5A2528D42F5")
        public boolean hasMoreElements() {
            boolean varABBE3B24714136305D7430F5669CF141_1346899264 = (hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1272745180 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1272745180;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.413 -0400", hash_original_method = "A06EA4B51D378F01CE00F7FB99A616EF", hash_generated_method = "F6D15BCA9A4C3C844E84A459510518AE")
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.413 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "C337D326C3C38C8C7C560D06492DD767")
        public boolean hasNext() {
            boolean var89CBB2F442CE6BC294273342C489EBAF_1005262609 = (nextEntry != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472253545 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472253545;
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.414 -0400", hash_original_method = "DB7CF742BB593212DEE9E7DE200FEED8", hash_generated_method = "62FA421B731478FF874E95BFB2197101")
         HashEntry<K,V> nextEntry() {
    if(nextEntry == null)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1507469331 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1507469331.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1507469331;
            }
            lastReturned = nextEntry;
            advance();
HashEntry<K,V> varBB386FC8A1600B8B2770D46D0DDD0432_328695345 =             lastReturned;
            varBB386FC8A1600B8B2770D46D0DDD0432_328695345.addTaint(taint);
            return varBB386FC8A1600B8B2770D46D0DDD0432_328695345;
            // ---------- Original Method ----------
            //if (nextEntry == null)
                //throw new NoSuchElementException();
            //lastReturned = nextEntry;
            //advance();
            //return lastReturned;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.414 -0400", hash_original_method = "EB8010C2D5EA80D446C3485BFC85793F", hash_generated_method = "EADCDD0B6D9F4483F3CDCFD747627E1E")
        public void remove() {
    if(lastReturned == null)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_555010373 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_555010373.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_555010373;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.415 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.415 -0400", hash_original_method = "AC02B860B54618170BE24E50FF82F167", hash_generated_method = "B5A76BB9DD296EAEAF45C26DEB2BD829")
        public K next() {
K var14F628CF3ADA3267E4D35928D18FC85F_869976939 =             super.nextEntry().key;
            var14F628CF3ADA3267E4D35928D18FC85F_869976939.addTaint(taint);
            return var14F628CF3ADA3267E4D35928D18FC85F_869976939;
            // ---------- Original Method ----------
            //return super.nextEntry().key;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.415 -0400", hash_original_method = "1473F8B0EF10582FE9B24F9D164CBEAD", hash_generated_method = "49E6C8BF36E6F324645E6057C6DE1AAA")
        public K nextElement() {
K var14F628CF3ADA3267E4D35928D18FC85F_1430194764 =             super.nextEntry().key;
            var14F628CF3ADA3267E4D35928D18FC85F_1430194764.addTaint(taint);
            return var14F628CF3ADA3267E4D35928D18FC85F_1430194764;
            // ---------- Original Method ----------
            //return super.nextEntry().key;
        }

        
    }


    
    final class ValueIterator extends HashIterator implements Iterator<V>, Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.415 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.415 -0400", hash_original_method = "282B954004CE321F97FD15862590F160", hash_generated_method = "76EB03FABB9786893BF8DB61922A6AAD")
        public V next() {
V varDDD34ECB520407FF2B35D37A084182FA_395627404 =             super.nextEntry().value;
            varDDD34ECB520407FF2B35D37A084182FA_395627404.addTaint(taint);
            return varDDD34ECB520407FF2B35D37A084182FA_395627404;
            // ---------- Original Method ----------
            //return super.nextEntry().value;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.415 -0400", hash_original_method = "95D48303D225ADC424CB718F2FA08908", hash_generated_method = "FF75382E2D754FB54176F95239F75696")
        public V nextElement() {
V varDDD34ECB520407FF2B35D37A084182FA_1214542283 =             super.nextEntry().value;
            varDDD34ECB520407FF2B35D37A084182FA_1214542283.addTaint(taint);
            return varDDD34ECB520407FF2B35D37A084182FA_1214542283;
            // ---------- Original Method ----------
            //return super.nextEntry().value;
        }

        
    }


    
    final class WriteThroughEntry extends AbstractMap.SimpleEntry<K,V> {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.416 -0400", hash_original_method = "A56113014EC205E193BCD1C4F8B24855", hash_generated_method = "272362F5E07165D243582536CFFD1277")
          WriteThroughEntry(K k, V v) {
            super(k,v);
            addTaint(v.getTaint());
            addTaint(k.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.416 -0400", hash_original_method = "38F302BB69197C5906EE6F553583F6F9", hash_generated_method = "49CD97A1E13A51FA5412526503AED9F5")
        public V setValue(V value) {
            addTaint(value.getTaint());
    if(value == null)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_611179282 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_611179282.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_611179282;
            }
            V v = super.setValue(value);
            ConcurrentHashMap.this.put(getKey(), value);
V var6DC76BC51820DD65E8396280E884AA78_2002589935 =             v;
            var6DC76BC51820DD65E8396280E884AA78_2002589935.addTaint(taint);
            return var6DC76BC51820DD65E8396280E884AA78_2002589935;
            // ---------- Original Method ----------
            //if (value == null) throw new NullPointerException();
            //V v = super.setValue(value);
            //ConcurrentHashMap.this.put(getKey(), value);
            //return v;
        }

        
    }


    
    final class EntryIterator extends HashIterator implements Iterator<Entry<K,V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.416 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.417 -0400", hash_original_method = "DA1DC8695C9406305A6247D7AF5617DE", hash_generated_method = "7C125E8E3F8036A8B7CCDB5E794A98D1")
        public Map.Entry<K,V> next() {
            HashEntry<K,V> e = super.nextEntry();
Map.Entry<K,V> var519386A83C4C9C32B145A2A117BFFCE0_1998619783 =             new WriteThroughEntry(e.key, e.value);
            var519386A83C4C9C32B145A2A117BFFCE0_1998619783.addTaint(taint);
            return var519386A83C4C9C32B145A2A117BFFCE0_1998619783;
            // ---------- Original Method ----------
            //HashEntry<K,V> e = super.nextEntry();
            //return new WriteThroughEntry(e.key, e.value);
        }

        
    }


    
    final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.417 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.417 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "4F4CE015CB9C61D92DD52378A3BC3374")
        public Iterator<K> iterator() {
Iterator<K> var3934136BB713579A43A8E8C1C3034CA0_1149005358 =             new KeyIterator();
            var3934136BB713579A43A8E8C1C3034CA0_1149005358.addTaint(taint);
            return var3934136BB713579A43A8E8C1C3034CA0_1149005358;
            // ---------- Original Method ----------
            //return new KeyIterator();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.417 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "02397C24A4F4A8CC431E8CD7EBC5F99A")
        public int size() {
            int var345B11F0DA09C9FA75700FC5C9489627_135943742 = (ConcurrentHashMap.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140929050 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140929050;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.size();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.417 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "911B845E6E14A54E76B7EDB22170AD37")
        public boolean isEmpty() {
            boolean var7C345E5125DF1DAD9DC32F0A16C89075_2036601059 = (ConcurrentHashMap.this.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_722916961 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_722916961;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.isEmpty();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.418 -0400", hash_original_method = "37248D467FF06BE0B2F5DDC1489510DF", hash_generated_method = "A2A24EF7B5895229CAFA9AF52C4ADAFA")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var39B78C1543C496539E50C19D7342DEA2_473754402 = (ConcurrentHashMap.this.containsKey(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985525612 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_985525612;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.containsKey(o);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.418 -0400", hash_original_method = "5AA31A160A27D834D20E2EBCA8B4999F", hash_generated_method = "9EFC519B28D25E2DE9E5166A24677000")
        public boolean remove(Object o) {
            addTaint(o.getTaint());
            boolean varE270B1B475C7049CF136F5238DAD836A_1164491118 = (ConcurrentHashMap.this.remove(o) != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1428305743 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1428305743;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.remove(o) != null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.418 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        public void clear() {
            ConcurrentHashMap.this.clear();
            // ---------- Original Method ----------
            //ConcurrentHashMap.this.clear();
        }

        
    }


    
    final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.418 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.419 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "559EFF83AA5651CBF970435CB640A1FF")
        public Iterator<V> iterator() {
Iterator<V> varA5D0B7DD47403A81B3461DEE499DEE74_1886140985 =             new ValueIterator();
            varA5D0B7DD47403A81B3461DEE499DEE74_1886140985.addTaint(taint);
            return varA5D0B7DD47403A81B3461DEE499DEE74_1886140985;
            // ---------- Original Method ----------
            //return new ValueIterator();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.419 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "98728033DFEB1D331AECB9AB3144AC6B")
        public int size() {
            int var345B11F0DA09C9FA75700FC5C9489627_168730639 = (ConcurrentHashMap.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314433832 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314433832;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.size();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.419 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "93F69A62F8F9AEA51EBF5A50BF6A7E3D")
        public boolean isEmpty() {
            boolean var7C345E5125DF1DAD9DC32F0A16C89075_1505792429 = (ConcurrentHashMap.this.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_863268806 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_863268806;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.isEmpty();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.419 -0400", hash_original_method = "6F20D95CF6074119AB0347E3FAAE80A2", hash_generated_method = "C963ADFD46B1853435633EB3AEC264CF")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
            boolean var457DF1E22DBB88994FE6A2C27CDFF858_1724269556 = (ConcurrentHashMap.this.containsValue(o));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1771137549 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1771137549;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.containsValue(o);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.419 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        public void clear() {
            ConcurrentHashMap.this.clear();
            // ---------- Original Method ----------
            //ConcurrentHashMap.this.clear();
        }

        
    }


    
    final class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.420 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.420 -0400", hash_original_method = "A1AF959F7C17DD47B4014053BC413A23", hash_generated_method = "A5FD727FF9A6C5C675DC63FD6EDCF20D")
        public Iterator<Map.Entry<K,V>> iterator() {
Iterator<Map.Entry<K,V>> varA27729B8E339A6F174B2D9A9BA7B896F_131569595 =             new EntryIterator();
            varA27729B8E339A6F174B2D9A9BA7B896F_131569595.addTaint(taint);
            return varA27729B8E339A6F174B2D9A9BA7B896F_131569595;
            // ---------- Original Method ----------
            //return new EntryIterator();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.420 -0400", hash_original_method = "44CFEB1CC21C67EDDE5E7F2C0FB0C916", hash_generated_method = "EE7EA07407B0713079A5B6A6DF46FE50")
        public boolean contains(Object o) {
            addTaint(o.getTaint());
    if(!(o instanceof Map.Entry))            
            {
            boolean var68934A3E9455FA72420237EB05902327_485789704 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1950943400 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1950943400;
            }
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            V v = ConcurrentHashMap.this.get(e.getKey());
            boolean varE7EE7D5469E58955D06CF5388CFAA910_1022900111 = (v != null && v.equals(e.getValue()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399149086 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399149086;
            // ---------- Original Method ----------
            //if (!(o instanceof Map.Entry))
                //return false;
            //Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            //V v = ConcurrentHashMap.this.get(e.getKey());
            //return v != null && v.equals(e.getValue());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.420 -0400", hash_original_method = "8F57FBEE664B771D5FDC7BC47FB0BA8F", hash_generated_method = "7341A4E5FC8A931D440F772643677A41")
        public boolean remove(Object o) {
            addTaint(o.getTaint());
    if(!(o instanceof Map.Entry))            
            {
            boolean var68934A3E9455FA72420237EB05902327_2041612632 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047219611 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047219611;
            }
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            boolean varEF9E2634FE850530C4B16DAA0CF0AF0B_1871223298 = (ConcurrentHashMap.this.remove(e.getKey(), e.getValue()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2044839608 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2044839608;
            // ---------- Original Method ----------
            //if (!(o instanceof Map.Entry))
                //return false;
            //Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            //return ConcurrentHashMap.this.remove(e.getKey(), e.getValue());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.421 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "813354CEDFB8ED523060A929B599FD52")
        public int size() {
            int var345B11F0DA09C9FA75700FC5C9489627_506930791 = (ConcurrentHashMap.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768554098 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768554098;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.size();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.421 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "4BFFEE2E61AC1D8A16CBD938F612451F")
        public boolean isEmpty() {
            boolean var7C345E5125DF1DAD9DC32F0A16C89075_1582475998 = (ConcurrentHashMap.this.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235052394 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_235052394;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.isEmpty();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.421 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        public void clear() {
            ConcurrentHashMap.this.clear();
            // ---------- Original Method ----------
            //ConcurrentHashMap.this.clear();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.421 -0400", hash_original_field = "38B2FE469B8CC3659DBEBB0BBB913A6C", hash_generated_field = "CFEA0CB484FBA67AE2EE2BC289FD3823")

    private static final long serialVersionUID = 7249069246763182397L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.421 -0400", hash_original_field = "F2DE208954D426D31F499310022241CF", hash_generated_field = "E41669AD5B156D132F42EF1B84E41D37")

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.421 -0400", hash_original_field = "DF48F8D92FC36ACC8968654109C53FC4", hash_generated_field = "A8CC9CBDCFEE884AAACD2650D6276B04")

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.421 -0400", hash_original_field = "ED64AF2D88EA33EF6133115E5E8FFE32", hash_generated_field = "6CEFE70232E37AD1C46346373D85BAC4")

    static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.421 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "F5FAB930A5B7C8AC42E4718B6294507D")

    static final int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.421 -0400", hash_original_field = "C9E0D462440D958860E70662EC748F43", hash_generated_field = "7552200CFB9EB51127B30554F45C2149")

    static final int MAX_SEGMENTS = 1 << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.422 -0400", hash_original_field = "4866497D0659FC39D1D9B2B7C08C16DB", hash_generated_field = "C971A9BB3C20B29D95F33E07A3449F39")

    static final int RETRIES_BEFORE_LOCK = 2;
}


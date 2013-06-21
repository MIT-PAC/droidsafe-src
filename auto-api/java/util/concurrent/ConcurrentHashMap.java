package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.locks.*;
import java.util.*;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    int segmentMask;
    int segmentShift;
    Segment<K,V>[] segments;
    transient Set<K> keySet;
    transient Set<Map.Entry<K,V>> entrySet;
    transient Collection<V> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.355 -0400", hash_original_method = "E1CECF835D0BD6DA840C10527C435227", hash_generated_method = "F9E31A98B78A193F0B95E08924FF7412")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConcurrentHashMap(int initialCapacity,
                             float loadFactor, int concurrencyLevel) {
        dsTaint.addTaint(initialCapacity);
        dsTaint.addTaint(concurrencyLevel);
        dsTaint.addTaint(loadFactor);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        concurrencyLevel = MAX_SEGMENTS;
        int sshift;
        sshift = 0;
        int ssize;
        ssize = 1;
        {
            ssize <<= 1;
        } //End block
        segmentShift = 32 - sshift;
        segmentMask = ssize - 1;
        this.segments = Segment.newArray(ssize);
        initialCapacity = MAXIMUM_CAPACITY;
        int c;
        c = initialCapacity / ssize;
        int cap;
        cap = 1;
        cap <<= 1;
        {
            int i;
            i = 0;
            this.segments[i] = new Segment<K,V>(cap, loadFactor);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.356 -0400", hash_original_method = "1B0A2C6B75A6C9CD77B06A2BA6F95389", hash_generated_method = "0F092D7FE7F543AD0595E57A46440118")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConcurrentHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, DEFAULT_CONCURRENCY_LEVEL);
        dsTaint.addTaint(initialCapacity);
        dsTaint.addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.356 -0400", hash_original_method = "FC082FCC77B50E96B6B6DB58BAB97957", hash_generated_method = "9C253907D6B4D49206FC24BB6F83A313")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConcurrentHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        dsTaint.addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.356 -0400", hash_original_method = "DFADDF9198F2268E7EB2B4F062BE54B9", hash_generated_method = "D4298CEE30095C17DFF133A738118CBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConcurrentHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.356 -0400", hash_original_method = "485F32D8EAC40E4F4B6CB1DCBDB98D35", hash_generated_method = "17DA3854FCB854C1B1CAC21CA1CBEA88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConcurrentHashMap(Map<? extends K, ? extends V> m) {
        this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,
                      DEFAULT_INITIAL_CAPACITY),
             DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        dsTaint.addTaint(m.dsTaint);
        putAll(m);
        // ---------- Original Method ----------
        //putAll(m);
    }

    
        private static int hash(int h) {
        h += (h <<  15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h <<   3);
        h ^= (h >>>  6);
        h += (h <<   2) + (h << 14);
        return h ^ (h >>> 16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.357 -0400", hash_original_method = "9480E4BE528687F57BD0A5E0057A4838", hash_generated_method = "CCBF56F9F2D924E8237ADD84048B635A")
    @DSModeled(DSC.SAFE)
    final Segment<K,V> segmentFor(int hash) {
        dsTaint.addTaint(hash);
        return (Segment<K,V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return segments[(hash >>> segmentShift) & segmentMask];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.357 -0400", hash_original_method = "1D5F6259D73E7678D3D06BFBE271A26B", hash_generated_method = "F61E74754B4CB6F08231A7E64DBE5CDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        Segment<K,V>[] segments;
        segments = this.segments;
        int[] mc;
        mc = new int[segments.length];
        int mcsum;
        mcsum = 0;
        {
            int i;
            i = 0;
            {
                mcsum += mc[i] = segments[i].modCount;
            } //End block
        } //End collapsed parenthetic
        {
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.358 -0400", hash_original_method = "BA4A00EBCDE2550C0DA253B4E73A18FB", hash_generated_method = "5326DF2818BCDF00F3E92906BB9A8875")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        Segment<K,V>[] segments;
        segments = this.segments;
        long sum;
        sum = 0;
        long check;
        check = 0;
        int[] mc;
        mc = new int[segments.length];
        {
            int k;
            k = 0;
            {
                check = 0;
                sum = 0;
                int mcsum;
                mcsum = 0;
                {
                    int i;
                    i = 0;
                    {
                        sum += segments[i].count;
                        mcsum += mc[i] = segments[i].modCount;
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        int i;
                        i = 0;
                        {
                            check += segments[i].count;
                            {
                                check = -1;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            sum = 0;
            {
                int i;
                i = 0;
                segments[i].lock();
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                sum += segments[i].count;
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                segments[i].unlock();
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.358 -0400", hash_original_method = "332CB84E85FBD8A2CB62BBB184B280CA", hash_generated_method = "880C246110D2E751DD8FAB446DEF7E56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        int hash;
        hash = hash(key.hashCode());
        V varCBB3409DDB95243078DD1910549F7FA9_1374978443 = (segmentFor(hash).get(key, hash));
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).get(key, hash);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.358 -0400", hash_original_method = "6145F82DE390788BB7B29DCBC031D263", hash_generated_method = "A3F896AB60D3EACF16EA21842583FF0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        int hash;
        hash = hash(key.hashCode());
        boolean varC72B072B37EFDE3DA0301245AE002A77_919349970 = (segmentFor(hash).containsKey(key, hash));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).containsKey(key, hash);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.358 -0400", hash_original_method = "F1AF23545DF8C9E4F21CC9D8D7EE161E", hash_generated_method = "E1C12D186CDD42E9E93777FB8ADA5641")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Segment<K,V>[] segments;
        segments = this.segments;
        int[] mc;
        mc = new int[segments.length];
        {
            int k;
            k = 0;
            {
                int sum;
                sum = 0;
                int mcsum;
                mcsum = 0;
                {
                    int i;
                    i = 0;
                    {
                        int c;
                        c = segments[i].count;
                        mcsum += mc[i] = segments[i].modCount;
                        {
                            boolean varFE6D9E1890DD06E80AC0DE0A80F87D5C_1492627692 = (segments[i].containsValue(value));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                boolean cleanSweep;
                cleanSweep = true;
                {
                    {
                        int i;
                        i = 0;
                        {
                            int c;
                            c = segments[i].count;
                            {
                                cleanSweep = false;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            segments[i].lock();
        } //End collapsed parenthetic
        boolean found;
        found = false;
        try 
        {
            {
                int i;
                i = 0;
                {
                    {
                        boolean var9D288256F2CF948D64C59EFBBE617CE4_762482542 = (segments[i].containsValue(value));
                        {
                            found = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            {
                int i;
                i = 0;
                segments[i].unlock();
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.359 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "CC1AA2239810A0421BFEDD2ADB5029DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object value) {
        dsTaint.addTaint(value.dsTaint);
        boolean var9D0C71166B134CB9FEA4F5814A8E4863_1531274027 = (containsValue(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.359 -0400", hash_original_method = "7B5FF6221D53537744EF141B1F8CB9FD", hash_generated_method = "93C35F386923FE7A9C4F3B1C953BC1CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int hash;
        hash = hash(key.hashCode());
        V varFBF4A8F43BD9789FD3EA72B3418B7E5C_182266912 = (segmentFor(hash).put(key, hash, value, false));
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).put(key, hash, value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.359 -0400", hash_original_method = "667464B5C7B8632F9930C4BABEB48EA8", hash_generated_method = "551C5C07FD156F0EB6C47FE4B5B85A52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V putIfAbsent(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int hash;
        hash = hash(key.hashCode());
        V var44845C1B66961044F799AF2227E6F84B_1172016299 = (segmentFor(hash).put(key, hash, value, true));
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).put(key, hash, value, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.361 -0400", hash_original_method = "B9175F57BE6F5AB8BBC535010119C8D9", hash_generated_method = "503AED4664EF24AECF2B23C0643B1B1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putAll(Map<? extends K, ? extends V> m) {
        dsTaint.addTaint(m.dsTaint);
        {
            m.entrySet().iterator().hasNext();
            Map.Entry<? extends K, ? extends V> e = m.entrySet().iterator().next();
            put(e.getKey(), e.getValue());
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            //put(e.getKey(), e.getValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.362 -0400", hash_original_method = "337505C9EECB4FFE48F33491B52A72CA", hash_generated_method = "B49A93A61D78FD0155329BE9E6E06EDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        int hash;
        hash = hash(key.hashCode());
        V var833B7734CCA046B2E4664599B36EE1CF_167995652 = (segmentFor(hash).remove(key, hash, null));
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).remove(key, hash, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.362 -0400", hash_original_method = "B30F0ED29C44EDE9B7A1F9EA4182F243", hash_generated_method = "FBB6720E6998629E531B761CEEC72874")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean remove(Object key, Object value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        int hash;
        hash = hash(key.hashCode());
        boolean var4FB63BD05D28C05209F98FEC987C6A2D_1008879377 = (segmentFor(hash).remove(key, hash, value) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //if (value == null)
            //return false;
        //return segmentFor(hash).remove(key, hash, value) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.362 -0400", hash_original_method = "FFBE8ED355379D3641A692556CD55FD9", hash_generated_method = "896C584577203FE2A607ED85D21EFAD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean replace(K key, V oldValue, V newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(oldValue.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int hash;
        hash = hash(key.hashCode());
        boolean var6897B508DBA234E8BBCB7D9C7C58A2E8_584550706 = (segmentFor(hash).replace(key, hash, oldValue, newValue));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (oldValue == null || newValue == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).replace(key, hash, oldValue, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.362 -0400", hash_original_method = "0AA66A0CD7ECE54F0D1BA81883147959", hash_generated_method = "6E694DC98AB9134E2DE66CF999CE88FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V replace(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int hash;
        hash = hash(key.hashCode());
        V var224A35379FB25B241C59A44ABDC61D9C_554529738 = (segmentFor(hash).replace(key, hash, value));
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).replace(key, hash, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.362 -0400", hash_original_method = "F4B890B3C1A244A1C39416FB7B7BF8FF", hash_generated_method = "05B6673C529D5BCC8796DE509B299A45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        {
            int i;
            i = 0;
            segments[i].clear();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < segments.length; ++i)
            //segments[i].clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.363 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "18F63A77972D84991112476A93670116")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<K> keySet() {
        Set<K> ks;
        ks = keySet;
        {
            Object varB5B77DAF0CA06DFD739ACDEAEEA4B87A_1496769070 = ((keySet = new KeySet()));
        } //End flattened ternary
        return (Set<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.363 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "C9222CAA968CE5FDD03419FFAB2B16FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<V> values() {
        Collection<V> vs;
        vs = values;
        {
            Object varA810554C04DFEDF1EF7ED76F9552EC23_1960302242 = ((values = new Values()));
        } //End flattened ternary
        return (Collection<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.363 -0400", hash_original_method = "A019E2D84135E4E25D7FF3C9850D91E8", hash_generated_method = "0F2687842A698A3D312535F3FC39F31B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> es;
        es = entrySet;
        {
            Object var8EEA31F996A0AE22A7B2AC281EA5A60C_295957307 = ((entrySet = new EntrySet()));
        } //End flattened ternary
        return (Set<Map.Entry<K,V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<Map.Entry<K,V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.364 -0400", hash_original_method = "1378C07218E9226BC9F7AD403D7C2636", hash_generated_method = "923CD89D43358F9CF1D0FF37A7DE3B8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Enumeration<K> keys() {
        Enumeration<K> var23DBCBF4E184D62482444F7AF7A8A6FB_1359481151 = (new KeyIterator());
        return (Enumeration<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.364 -0400", hash_original_method = "5CBB59F043F7E5A98C79AC06A0CCF84B", hash_generated_method = "8CBAC0187DADE2A0B8647CC5A23C7712")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Enumeration<V> elements() {
        Enumeration<V> varD97090F3A13A0D960A637BC236C561C5_752676206 = (new ValueIterator());
        return (Enumeration<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.364 -0400", hash_original_method = "39AA0B3013D1EF3A3A6D6B7DFFE53DC3", hash_generated_method = "A30DF3D38CEC81D5580CC9B1BF089CC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        dsTaint.addTaint(s.dsTaint);
        s.defaultWriteObject();
        {
            int k;
            k = 0;
            {
                Segment<K,V> seg;
                seg = segments[k];
                seg.lock();
                try 
                {
                    HashEntry<K,V>[] tab;
                    tab = seg.table;
                    {
                        int i;
                        i = 0;
                        {
                            {
                                HashEntry<K,V> e;
                                e = tab[i];
                                e = e.next;
                                {
                                    s.writeObject(e.key);
                                    s.writeObject(e.value);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                finally 
                {
                    seg.unlock();
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.364 -0400", hash_original_method = "27FA8D459FE7A66670B6D1423BE5DC25", hash_generated_method = "072435508FE4B2AEA341E97EB2D7B1AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(s.dsTaint);
        s.defaultReadObject();
        {
            int i;
            i = 0;
            {
                segments[i].setTable(new HashEntry[1]);
            } //End block
        } //End collapsed parenthetic
        {
            K key;
            key = (K) s.readObject();
            V value;
            value = (V) s.readObject();
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
        K key;
        int hash;
        volatile V value;
        HashEntry<K,V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.365 -0400", hash_original_method = "89FFAB6F57FFB83251DFC8FAF8476851", hash_generated_method = "97AF8531B958BA9DF14C5099AAF5A153")
        @DSModeled(DSC.SAFE)
         HashEntry(K key, int hash, HashEntry<K,V> next, V value) {
            dsTaint.addTaint(hash);
            dsTaint.addTaint(next.dsTaint);
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
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
        transient volatile int count;
        transient int modCount;
        transient int threshold;
        transient volatile HashEntry<K,V>[] table;
        float loadFactor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.365 -0400", hash_original_method = "467240A23868E01B6F6E31DCEE5330A3", hash_generated_method = "3D404A31D12E25C1C9C88B5CE0E6B8F2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Segment(int initialCapacity, float lf) {
            dsTaint.addTaint(lf);
            dsTaint.addTaint(initialCapacity);
            setTable(HashEntry.<K,V>newArray(initialCapacity));
            // ---------- Original Method ----------
            //loadFactor = lf;
            //setTable(HashEntry.<K,V>newArray(initialCapacity));
        }

        
                @SuppressWarnings("unchecked")
        static final <K,V> Segment<K,V>[] newArray(int i) {
            return new Segment[i];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.365 -0400", hash_original_method = "76FBB7D49FE13DE65CD87FF1D7913D53", hash_generated_method = "CE7E6BCB7AE9FCA571124B11FD6D4CD6")
        @DSModeled(DSC.SAFE)
         void setTable(HashEntry<K,V>[] newTable) {
            dsTaint.addTaint(newTable[0].dsTaint);
            threshold = (int)(newTable.length * loadFactor);
            // ---------- Original Method ----------
            //threshold = (int)(newTable.length * loadFactor);
            //table = newTable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.365 -0400", hash_original_method = "526D0582321A198EF4385AC6C7D29654", hash_generated_method = "4755A219686B5FE6954A5BC50ACA35B4")
        @DSModeled(DSC.SAFE)
         HashEntry<K,V> getFirst(int hash) {
            dsTaint.addTaint(hash);
            HashEntry<K,V>[] tab;
            tab = table;
            return (HashEntry<K,V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //HashEntry<K,V>[] tab = table;
            //return tab[hash & (tab.length - 1)];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.366 -0400", hash_original_method = "6C9E8EADE7BF0CF7C06CF8A72D599D54", hash_generated_method = "450816F138080F5351424F6220DE6AC0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         V readValueUnderLock(HashEntry<K,V> e) {
            dsTaint.addTaint(e.dsTaint);
            lock();
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //lock();
            //try {
                //return e.value;
            //} finally {
                //unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.366 -0400", hash_original_method = "1AC5B4CC2690982021F35FD4CB4FB319", hash_generated_method = "A41FB06194C42D825B79FB6DECB41ACE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         V get(Object key, int hash) {
            dsTaint.addTaint(hash);
            dsTaint.addTaint(key.dsTaint);
            {
                HashEntry<K,V> e;
                e = getFirst(hash);
                {
                    {
                        boolean var8A7AE4752A388591DE1859857B46D43A_1050121528 = (e.hash == hash && key.equals(e.key));
                        {
                            V v;
                            v = e.value;
                            V varC847CCD019DC161F3F1385963DAD3925_683640294 = (readValueUnderLock(e));
                        } //End block
                    } //End collapsed parenthetic
                    e = e.next;
                } //End block
            } //End block
            return (V)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.366 -0400", hash_original_method = "4906CD88672F5095094E2A23826E0F83", hash_generated_method = "2F2CF0C1C72D5667FEBED20DAB8FEA8F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean containsKey(Object key, int hash) {
            dsTaint.addTaint(hash);
            dsTaint.addTaint(key.dsTaint);
            {
                HashEntry<K,V> e;
                e = getFirst(hash);
                {
                    {
                        boolean var8A7AE4752A388591DE1859857B46D43A_1594018223 = (e.hash == hash && key.equals(e.key));
                    } //End collapsed parenthetic
                    e = e.next;
                } //End block
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.366 -0400", hash_original_method = "4B02A5A0C6C760AB5CD92802AE9AC755", hash_generated_method = "213AFFEB6AD5FC14424D8B981CA3A387")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            {
                HashEntry<K,V>[] tab;
                tab = table;
                int len;
                len = tab.length;
                {
                    int i;
                    i = 0;
                    {
                        {
                            HashEntry<K,V> e;
                            e = tab[i];
                            e = e.next;
                            {
                                V v;
                                v = e.value;
                                v = readValueUnderLock(e);
                                {
                                    boolean varAF9B2D3689B03A5213EF203D483D8AD4_626544191 = (value.equals(v));
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.367 -0400", hash_original_method = "B03D3F6036D4D187AC672F9D98953439", hash_generated_method = "A9BD44CC073D3C0871886AFF10CA699A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean replace(K key, int hash, V oldValue, V newValue) {
            dsTaint.addTaint(newValue.dsTaint);
            dsTaint.addTaint(hash);
            dsTaint.addTaint(oldValue.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            lock();
            try 
            {
                HashEntry<K,V> e;
                e = getFirst(hash);
                {
                    boolean varFA336E0F01A8F7D94110F42C42943CEA_1739291949 = (e != null && (e.hash != hash || !key.equals(e.key)));
                    e = e.next;
                } //End collapsed parenthetic
                boolean replaced;
                replaced = false;
                {
                    boolean varB391AA6784122268E404E2A55161AFDC_748516803 = (e != null && oldValue.equals(e.value));
                    {
                        replaced = true;
                        e.value = newValue;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                unlock();
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.367 -0400", hash_original_method = "496F1B463B31D22372CDAB52F4D749A3", hash_generated_method = "443C0EAE391FD30A73FCAB0157134807")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         V replace(K key, int hash, V newValue) {
            dsTaint.addTaint(newValue.dsTaint);
            dsTaint.addTaint(hash);
            dsTaint.addTaint(key.dsTaint);
            lock();
            try 
            {
                HashEntry<K,V> e;
                e = getFirst(hash);
                {
                    boolean varFA336E0F01A8F7D94110F42C42943CEA_1041142233 = (e != null && (e.hash != hash || !key.equals(e.key)));
                    e = e.next;
                } //End collapsed parenthetic
                V oldValue;
                oldValue = null;
                {
                    oldValue = e.value;
                    e.value = newValue;
                } //End block
            } //End block
            finally 
            {
                unlock();
            } //End block
            return (V)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.367 -0400", hash_original_method = "F92903F43B391F8F1B397027DA8E7AA9", hash_generated_method = "1865E863D07E9A7854B5D58C8A99D00D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         V put(K key, int hash, V value, boolean onlyIfAbsent) {
            dsTaint.addTaint(hash);
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(onlyIfAbsent);
            dsTaint.addTaint(key.dsTaint);
            lock();
            try 
            {
                int c;
                c = count;
                rehash();
                HashEntry<K,V>[] tab;
                tab = table;
                int index;
                index = hash & (tab.length - 1);
                HashEntry<K,V> first;
                first = tab[index];
                HashEntry<K,V> e;
                e = first;
                {
                    boolean varFA336E0F01A8F7D94110F42C42943CEA_340544102 = (e != null && (e.hash != hash || !key.equals(e.key)));
                    e = e.next;
                } //End collapsed parenthetic
                V oldValue;
                {
                    oldValue = e.value;
                    e.value = value;
                } //End block
                {
                    oldValue = null;
                    tab[index] = new HashEntry<K,V>(key, hash, first, value);
                    count = c;
                } //End block
            } //End block
            finally 
            {
                unlock();
            } //End block
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.368 -0400", hash_original_method = "7AA7A225DF7E6D5CA86650AFCB7B431B", hash_generated_method = "7D3F56C9B1E26EA08F794FC3871C06DC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void rehash() {
            HashEntry<K,V>[] oldTable;
            oldTable = table;
            int oldCapacity;
            oldCapacity = oldTable.length;
            HashEntry<K,V>[] newTable;
            newTable = HashEntry.newArray(oldCapacity<<1);
            threshold = (int)(newTable.length * loadFactor);
            int sizeMask;
            sizeMask = newTable.length - 1;
            {
                int i;
                i = 0;
                {
                    HashEntry<K,V> e;
                    e = oldTable[i];
                    {
                        HashEntry<K,V> next;
                        next = e.next;
                        int idx;
                        idx = e.hash & sizeMask;
                        newTable[idx] = e;
                        {
                            HashEntry<K,V> lastRun;
                            lastRun = e;
                            int lastIdx;
                            lastIdx = idx;
                            {
                                HashEntry<K,V> last;
                                last = next;
                                last = last.next;
                                {
                                    int k;
                                    k = last.hash & sizeMask;
                                    {
                                        lastIdx = k;
                                        lastRun = last;
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                            newTable[lastIdx] = lastRun;
                            {
                                HashEntry<K,V> p;
                                p = e;
                                p = p.next;
                                {
                                    int k;
                                    k = p.hash & sizeMask;
                                    HashEntry<K,V> n;
                                    n = newTable[k];
                                    newTable[k] = new HashEntry<K,V>(p.key, p.hash,
                                                             n, p.value);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            table = newTable;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.368 -0400", hash_original_method = "A22DE89D38A395B57956004D412DD3F5", hash_generated_method = "34DF0F4D5F92274F65158790C6412F00")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         V remove(Object key, int hash, Object value) {
            dsTaint.addTaint(hash);
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            lock();
            try 
            {
                int c;
                c = count - 1;
                HashEntry<K,V>[] tab;
                tab = table;
                int index;
                index = hash & (tab.length - 1);
                HashEntry<K,V> first;
                first = tab[index];
                HashEntry<K,V> e;
                e = first;
                {
                    boolean varFA336E0F01A8F7D94110F42C42943CEA_166274536 = (e != null && (e.hash != hash || !key.equals(e.key)));
                    e = e.next;
                } //End collapsed parenthetic
                V oldValue;
                oldValue = null;
                {
                    V v;
                    v = e.value;
                    {
                        boolean varCDFC5F5D65441A80D44B2E79B876F2E6_1046965488 = (value == null || value.equals(v));
                        {
                            oldValue = v;
                            HashEntry<K,V> newFirst;
                            newFirst = e.next;
                            {
                                HashEntry<K,V> p;
                                p = first;
                                p = p.next;
                                newFirst = new HashEntry<K,V>(p.key, p.hash,
                                                          newFirst, p.value);
                            } //End collapsed parenthetic
                            tab[index] = newFirst;
                            count = c;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            finally 
            {
                unlock();
            } //End block
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.369 -0400", hash_original_method = "20609B8FF53EC43AEB5A4460B52EBDFF", hash_generated_method = "C3A44EE0BE4D521B85985A81D8C3D53D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void clear() {
            {
                lock();
                try 
                {
                    HashEntry<K,V>[] tab;
                    tab = table;
                    {
                        int i;
                        i = 0;
                        tab[i] = null;
                    } //End collapsed parenthetic
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

        
        private static final long serialVersionUID = 2249069246763182397L;
    }


    
    abstract class HashIterator {
        int nextSegmentIndex;
        int nextTableIndex;
        HashEntry<K,V>[] currentTable;
        HashEntry<K, V> nextEntry;
        HashEntry<K, V> lastReturned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.369 -0400", hash_original_method = "1331DC8249C406CC83024534A57FEFEB", hash_generated_method = "D903CC46D67C5E6BD87F25FE63BEB736")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         HashIterator() {
            nextSegmentIndex = segments.length - 1;
            nextTableIndex = -1;
            advance();
            // ---------- Original Method ----------
            //nextSegmentIndex = segments.length - 1;
            //nextTableIndex = -1;
            //advance();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.369 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "DD8BF19BDB51F85C95D0B0A903DC8F8F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_1962883735 = (hasNext());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.370 -0400", hash_original_method = "A06EA4B51D378F01CE00F7FB99A616EF", hash_generated_method = "10AA11F9E7ED40CE36D67DE18BD4E78D")
        @DSModeled(DSC.SAFE)
        final void advance() {
            {
                boolean varAE56CE09D98F8D249FB4EAAAC2365BBF_281901522 = (nextEntry != null && (nextEntry = nextEntry.next) != null);
            } //End collapsed parenthetic
            {
                {
                    boolean var63500D3C047D4C906175A14EF6FEFB9D_2109680285 = ((nextEntry = currentTable[nextTableIndex--]) != null);
                } //End collapsed parenthetic
            } //End block
            {
                Segment<K,V> seg;
                seg = segments[nextSegmentIndex--];
                {
                    currentTable = seg.table;
                    {
                        int j;
                        j = currentTable.length - 1;
                        {
                            {
                                boolean var561CE7603C783A55D13FDCDDA31772EC_772210329 = ((nextEntry = currentTable[j]) != null);
                                {
                                    nextTableIndex = j - 1;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.370 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "CC4831130E120DAE2C5139D0C4D85FB9")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.370 -0400", hash_original_method = "DB7CF742BB593212DEE9E7DE200FEED8", hash_generated_method = "4D049E34200BA27E452C338E62971775")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         HashEntry<K,V> nextEntry() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            lastReturned = nextEntry;
            advance();
            return (HashEntry<K,V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (nextEntry == null)
                //throw new NoSuchElementException();
            //lastReturned = nextEntry;
            //advance();
            //return lastReturned;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.370 -0400", hash_original_method = "EB8010C2D5EA80D446C3485BFC85793F", hash_generated_method = "64211DA248DE87BDD0671C84567097BA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.370 -0400", hash_original_method = "5D388AF9F4BC08670D6FC8B0690B4586", hash_generated_method = "5D388AF9F4BC08670D6FC8B0690B4586")
                public KeyIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.370 -0400", hash_original_method = "AC02B860B54618170BE24E50FF82F167", hash_generated_method = "E1B608BE5867D63A8F3FECFF72D79397")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K next() {
            K varE6B9D5A76754AF7C33934F717D9D96FF_770400295 = (super.nextEntry().key);
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return super.nextEntry().key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.370 -0400", hash_original_method = "1473F8B0EF10582FE9B24F9D164CBEAD", hash_generated_method = "38EEC5F7A16415F5BBB9A6ADE530A7E5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K nextElement() {
            K varE6B9D5A76754AF7C33934F717D9D96FF_548531396 = (super.nextEntry().key);
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return super.nextEntry().key;
        }

        
    }


    
    final class ValueIterator extends HashIterator implements Iterator<V>, Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.371 -0400", hash_original_method = "0633288CFFDB0D47FC844EDFD5BB157F", hash_generated_method = "0633288CFFDB0D47FC844EDFD5BB157F")
                public ValueIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.371 -0400", hash_original_method = "282B954004CE321F97FD15862590F160", hash_generated_method = "85B80E92EFCE0D2A258C43E9A6D1A595")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public V next() {
            V var94A759489ACFB39424C0DF9FE848EDC7_1771416733 = (super.nextEntry().value);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return super.nextEntry().value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.371 -0400", hash_original_method = "95D48303D225ADC424CB718F2FA08908", hash_generated_method = "7D59D3B3C4E8269BEB63A941220A3A5A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public V nextElement() {
            V var94A759489ACFB39424C0DF9FE848EDC7_2126084745 = (super.nextEntry().value);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return super.nextEntry().value;
        }

        
    }


    
    final class WriteThroughEntry extends AbstractMap.SimpleEntry<K,V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.371 -0400", hash_original_method = "A56113014EC205E193BCD1C4F8B24855", hash_generated_method = "A7616DE34637995CDF14634D72A915A7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         WriteThroughEntry(K k, V v) {
            super(k,v);
            dsTaint.addTaint(v.dsTaint);
            dsTaint.addTaint(k.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.371 -0400", hash_original_method = "38F302BB69197C5906EE6F553583F6F9", hash_generated_method = "E7EEAB7E0BA1567BC59A9BAF606AF30B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public V setValue(V value) {
            dsTaint.addTaint(value.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            V v;
            v = super.setValue(value);
            ConcurrentHashMap.this.put(getKey(), value);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (value == null) throw new NullPointerException();
            //V v = super.setValue(value);
            //ConcurrentHashMap.this.put(getKey(), value);
            //return v;
        }

        
    }


    
    final class EntryIterator extends HashIterator implements Iterator<Entry<K,V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.371 -0400", hash_original_method = "FCA6D1B18319AC57F041ABBA6E1FAA59", hash_generated_method = "FCA6D1B18319AC57F041ABBA6E1FAA59")
                public EntryIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.371 -0400", hash_original_method = "DA1DC8695C9406305A6247D7AF5617DE", hash_generated_method = "9A299628FD507B3720FFA8FBEDB118FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Map.Entry<K,V> next() {
            HashEntry<K,V> e;
            e = super.nextEntry();
            Map.Entry<K,V> var92BB0F3E4BFF10E3970CE9418A2B8EA7_1335862790 = (new WriteThroughEntry(e.key, e.value));
            return (Map.Entry<K,V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //HashEntry<K,V> e = super.nextEntry();
            //return new WriteThroughEntry(e.key, e.value);
        }

        
    }


    
    final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.371 -0400", hash_original_method = "AD2AA12DF2DCFDBEC9B4D1AB308E571A", hash_generated_method = "AD2AA12DF2DCFDBEC9B4D1AB308E571A")
                public KeySet ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.372 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "C2F6F286B2C6C8AEB01D08C1B803E9A2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<K> iterator() {
            Iterator<K> var727A467D8B784AF4C95A4BCEAD645213_1502217397 = (new KeyIterator());
            return (Iterator<K>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new KeyIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.372 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "7B50A14B761773F93AD07C14E6E7B864")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int size() {
            int var2AE1BD72658B11B83F17E3D8DE9C3742_222551645 = (ConcurrentHashMap.this.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.372 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "A08D880C6A903E47209FFFE0936FFCCD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isEmpty() {
            boolean var2129446389ED975B0F4481D55BB56F6F_1423331966 = (ConcurrentHashMap.this.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.372 -0400", hash_original_method = "37248D467FF06BE0B2F5DDC1489510DF", hash_generated_method = "5D2DB74FED0385198A2565B75D0F8AF4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean var3A007D079E775775EF3E281A61BA88AC_1749847144 = (ConcurrentHashMap.this.containsKey(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.372 -0400", hash_original_method = "5AA31A160A27D834D20E2EBCA8B4999F", hash_generated_method = "54E3A1207A07E75FA6FBE436BCF9490B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean remove(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean var7AF3FCDEC3414604DC101A294DC0E9A1_527744897 = (ConcurrentHashMap.this.remove(o) != null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.remove(o) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.372 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            ConcurrentHashMap.this.clear();
            // ---------- Original Method ----------
            //ConcurrentHashMap.this.clear();
        }

        
    }


    
    final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.372 -0400", hash_original_method = "D4CD3011C6EAF83FB83B7739F97A2374", hash_generated_method = "D4CD3011C6EAF83FB83B7739F97A2374")
                public Values ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.373 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "9EF3C0A2BF09F4C19DFA5EF7AA76840E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<V> iterator() {
            Iterator<V> var574E07CFE3EC53CCAFC369382828B6D5_1450088397 = (new ValueIterator());
            return (Iterator<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ValueIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.373 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "42E344F53E9ABC0B33DD16D6E8FAA324")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int size() {
            int var2AE1BD72658B11B83F17E3D8DE9C3742_1814707463 = (ConcurrentHashMap.this.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.373 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "3055A0B972136EA8741FBF9999464303")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isEmpty() {
            boolean var2129446389ED975B0F4481D55BB56F6F_233101196 = (ConcurrentHashMap.this.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.373 -0400", hash_original_method = "6F20D95CF6074119AB0347E3FAAE80A2", hash_generated_method = "299010F17A20C39E006CB8C3907CEADE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            boolean varB5437F4F6895ACF0564A8B739D6BBE8E_1385479068 = (ConcurrentHashMap.this.containsValue(o));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.containsValue(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.373 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            ConcurrentHashMap.this.clear();
            // ---------- Original Method ----------
            //ConcurrentHashMap.this.clear();
        }

        
    }


    
    final class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.373 -0400", hash_original_method = "2F953926D7C5D976A09AA3C5A1A35BD1", hash_generated_method = "2F953926D7C5D976A09AA3C5A1A35BD1")
                public EntrySet ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.374 -0400", hash_original_method = "A1AF959F7C17DD47B4014053BC413A23", hash_generated_method = "A65C9AA45A9F833EA71A2D57B26C36EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<Map.Entry<K,V>> iterator() {
            Iterator<Map.Entry<K,V>> var8A4CFE84C6EAED9EA430E32D824AF517_253746995 = (new EntryIterator());
            return (Iterator<Map.Entry<K,V>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new EntryIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.374 -0400", hash_original_method = "44CFEB1CC21C67EDDE5E7F2C0FB0C916", hash_generated_method = "B4C39BC913C4994E12771FC968DF58D7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Map.Entry<?,?> e;
            e = (Map.Entry<?,?>)o;
            V v;
            v = ConcurrentHashMap.this.get(e.getKey());
            boolean varA30474C0E53C22C4F5FAE67C3EFD9B30_105861784 = (v != null && v.equals(e.getValue()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof Map.Entry))
                //return false;
            //Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            //V v = ConcurrentHashMap.this.get(e.getKey());
            //return v != null && v.equals(e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.374 -0400", hash_original_method = "8F57FBEE664B771D5FDC7BC47FB0BA8F", hash_generated_method = "369586426D4883302ED34AAE1F704B26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean remove(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Map.Entry<?,?> e;
            e = (Map.Entry<?,?>)o;
            boolean var610A1F7E9B8954F006C6C3D32F43CF4E_2004472054 = (ConcurrentHashMap.this.remove(e.getKey(), e.getValue()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof Map.Entry))
                //return false;
            //Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            //return ConcurrentHashMap.this.remove(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.374 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "84FF245C01C99BEB551788A7733FB768")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int size() {
            int var2AE1BD72658B11B83F17E3D8DE9C3742_2093533823 = (ConcurrentHashMap.this.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.374 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "A65CD10BBF5D8CD6CDE850ED0E5ABBAC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isEmpty() {
            boolean var2129446389ED975B0F4481D55BB56F6F_1858391153 = (ConcurrentHashMap.this.isEmpty());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.375 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            ConcurrentHashMap.this.clear();
            // ---------- Original Method ----------
            //ConcurrentHashMap.this.clear();
        }

        
    }


    
    private static final long serialVersionUID = 7249069246763182397L;
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int MAX_SEGMENTS = 1 << 16;
    static final int RETRIES_BEFORE_LOCK = 2;
}


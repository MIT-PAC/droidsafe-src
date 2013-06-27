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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.940 -0400", hash_original_field = "6E087A676FE9EB60B1F8BDB5CE343DC8", hash_generated_field = "4BE7BE92627D08015B3B3DAF23AD6BAD")

    int segmentMask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.940 -0400", hash_original_field = "4CDE234FA7C6312E0DF85BE9485BF1E3", hash_generated_field = "306EF00C73243987FA23D1582323C779")

    int segmentShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.940 -0400", hash_original_field = "1F982D988D45344BF00CD08220780A1E", hash_generated_field = "8FCA8AAE37A6D97176077745C90AB57A")

    Segment<K,V>[] segments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.940 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "B015B4740FB481B602A7C5EA08044E34")

    transient Set<K> keySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.940 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "8070B936D9AF3972F9E8198F31643848")

    transient Set<Map.Entry<K,V>> entrySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.940 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "1963670AE696FF62CC56DF446CAA129C")

    transient Collection<V> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.942 -0400", hash_original_method = "E1CECF835D0BD6DA840C10527C435227", hash_generated_method = "92684E42D395568C50D240F2300C5FDA")
    public  ConcurrentHashMap(int initialCapacity,
                             float loadFactor, int concurrencyLevel) {
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
        addTaint(initialCapacity);
        addTaint(concurrencyLevel);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.071 -0400", hash_original_method = "1B0A2C6B75A6C9CD77B06A2BA6F95389", hash_generated_method = "E509032E9AF7FADEE74C211A10674A2E")
    public  ConcurrentHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, DEFAULT_CONCURRENCY_LEVEL);
        addTaint(initialCapacity);
        addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.072 -0400", hash_original_method = "FC082FCC77B50E96B6B6DB58BAB97957", hash_generated_method = "CDAAD7AE035E81DF97303AEAF9A04212")
    public  ConcurrentHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.072 -0400", hash_original_method = "DFADDF9198F2268E7EB2B4F062BE54B9", hash_generated_method = "D4298CEE30095C17DFF133A738118CBC")
    public  ConcurrentHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.073 -0400", hash_original_method = "485F32D8EAC40E4F4B6CB1DCBDB98D35", hash_generated_method = "2C160C28EF4E9BFFE4EEBFC23ADFDE48")
    public  ConcurrentHashMap(Map<? extends K, ? extends V> m) {
        this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,
                      DEFAULT_INITIAL_CAPACITY),
             DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        putAll(m);
        addTaint(m.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.074 -0400", hash_original_method = "9480E4BE528687F57BD0A5E0057A4838", hash_generated_method = "26AB0AD2742A81018F46C912B2239462")
    final Segment<K,V> segmentFor(int hash) {
        Segment<K,V> varB4EAC82CA7396A68D541C85D26508E83_897778190 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_897778190 = segments[(hash >>> segmentShift) & segmentMask];
        addTaint(hash);
        varB4EAC82CA7396A68D541C85D26508E83_897778190.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_897778190;
        // ---------- Original Method ----------
        //return segments[(hash >>> segmentShift) & segmentMask];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.080 -0400", hash_original_method = "1D5F6259D73E7678D3D06BFBE271A26B", hash_generated_method = "42E18977022C192C74A4C74C391F2205")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_777279059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_777279059;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.099 -0400", hash_original_method = "BA4A00EBCDE2550C0DA253B4E73A18FB", hash_generated_method = "B1C32F8733FBF7D1DBF43D9691A4BF30")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598638686 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598638686;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.099 -0400", hash_original_method = "332CB84E85FBD8A2CB62BBB184B280CA", hash_generated_method = "AB1469D1F1ACD0BB11D6DA0158789526")
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1170818371 = null; //Variable for return #1
        int hash;
        hash = hash(key.hashCode());
        varB4EAC82CA7396A68D541C85D26508E83_1170818371 = segmentFor(hash).get(key, hash);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1170818371.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1170818371;
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).get(key, hash);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.100 -0400", hash_original_method = "6145F82DE390788BB7B29DCBC031D263", hash_generated_method = "D369B8ED239A38997C644917894CE884")
    public boolean containsKey(Object key) {
        int hash;
        hash = hash(key.hashCode());
        boolean varC72B072B37EFDE3DA0301245AE002A77_261180886 = (segmentFor(hash).containsKey(key, hash));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583538416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_583538416;
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).containsKey(key, hash);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.115 -0400", hash_original_method = "F1AF23545DF8C9E4F21CC9D8D7EE161E", hash_generated_method = "82E544B9A7FDF01EE44DDD59430061C2")
    public boolean containsValue(Object value) {
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
                            boolean varFE6D9E1890DD06E80AC0DE0A80F87D5C_1760387042 = (segments[i].containsValue(value));
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
                        boolean var9D288256F2CF948D64C59EFBBE617CE4_115274004 = (segments[i].containsValue(value));
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
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1866775526 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1866775526;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.116 -0400", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "4894A6FA5F554040A5C200C2408173AD")
    public boolean contains(Object value) {
        boolean var9D0C71166B134CB9FEA4F5814A8E4863_1997689934 = (containsValue(value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127319048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127319048;
        // ---------- Original Method ----------
        //return containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.117 -0400", hash_original_method = "7B5FF6221D53537744EF141B1F8CB9FD", hash_generated_method = "B642F1535764F5022FFE9E1F50F03F29")
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_105440575 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int hash;
        hash = hash(key.hashCode());
        varB4EAC82CA7396A68D541C85D26508E83_105440575 = segmentFor(hash).put(key, hash, value, false);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_105440575.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_105440575;
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).put(key, hash, value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.117 -0400", hash_original_method = "667464B5C7B8632F9930C4BABEB48EA8", hash_generated_method = "C47E58F7F61684EBF8BACBC542A3AFAC")
    public V putIfAbsent(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_473517787 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int hash;
        hash = hash(key.hashCode());
        varB4EAC82CA7396A68D541C85D26508E83_473517787 = segmentFor(hash).put(key, hash, value, true);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_473517787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_473517787;
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).put(key, hash, value, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.174 -0400", hash_original_method = "B9175F57BE6F5AB8BBC535010119C8D9", hash_generated_method = "4AFC417F322AE51E7E06BA50FFDB996D")
    public void putAll(Map<? extends K, ? extends V> m) {
        {
            m.entrySet().iterator().hasNext();
            Map.Entry<? extends K, ? extends V> e = m.entrySet().iterator().next();
            put(e.getKey(), e.getValue());
        } //End collapsed parenthetic
        addTaint(m.getTaint());
        // ---------- Original Method ----------
        //for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            //put(e.getKey(), e.getValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.185 -0400", hash_original_method = "337505C9EECB4FFE48F33491B52A72CA", hash_generated_method = "1E83BA9211833109F86EA41BE5AC42E3")
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1486323781 = null; //Variable for return #1
        int hash;
        hash = hash(key.hashCode());
        varB4EAC82CA7396A68D541C85D26508E83_1486323781 = segmentFor(hash).remove(key, hash, null);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1486323781.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1486323781;
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).remove(key, hash, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.186 -0400", hash_original_method = "B30F0ED29C44EDE9B7A1F9EA4182F243", hash_generated_method = "08959FCD84A0777E9C2F086025DD2BC0")
    public boolean remove(Object key, Object value) {
        int hash;
        hash = hash(key.hashCode());
        boolean var4FB63BD05D28C05209F98FEC987C6A2D_870310133 = (segmentFor(hash).remove(key, hash, value) != null);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046210435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046210435;
        // ---------- Original Method ----------
        //int hash = hash(key.hashCode());
        //if (value == null)
            //return false;
        //return segmentFor(hash).remove(key, hash, value) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.186 -0400", hash_original_method = "FFBE8ED355379D3641A692556CD55FD9", hash_generated_method = "C8B3D1D5A7C5536FA226D9768502DF94")
    public boolean replace(K key, V oldValue, V newValue) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int hash;
        hash = hash(key.hashCode());
        boolean var6897B508DBA234E8BBCB7D9C7C58A2E8_1087218673 = (segmentFor(hash).replace(key, hash, oldValue, newValue));
        addTaint(key.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(newValue.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1143976728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1143976728;
        // ---------- Original Method ----------
        //if (oldValue == null || newValue == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).replace(key, hash, oldValue, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.187 -0400", hash_original_method = "0AA66A0CD7ECE54F0D1BA81883147959", hash_generated_method = "4315B5672B27CCEACDCCC9AEB24EF8F1")
    public V replace(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_54242204 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int hash;
        hash = hash(key.hashCode());
        varB4EAC82CA7396A68D541C85D26508E83_54242204 = segmentFor(hash).replace(key, hash, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_54242204.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_54242204;
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException();
        //int hash = hash(key.hashCode());
        //return segmentFor(hash).replace(key, hash, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.187 -0400", hash_original_method = "F4B890B3C1A244A1C39416FB7B7BF8FF", hash_generated_method = "05B6673C529D5BCC8796DE509B299A45")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.187 -0400", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "214A0B292066F3572ACECFD4A5C45DEE")
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_223603326 = null; //Variable for return #1
        Set<K> ks;
        ks = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_223603326 = (ks != null) ? ks : (keySet = new KeySet());
        varB4EAC82CA7396A68D541C85D26508E83_223603326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_223603326;
        // ---------- Original Method ----------
        //Set<K> ks = keySet;
        //return (ks != null) ? ks : (keySet = new KeySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.190 -0400", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "DE95A2B01FFF8F754BD40A5B6D8A474F")
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_952138597 = null; //Variable for return #1
        Collection<V> vs;
        vs = values;
        varB4EAC82CA7396A68D541C85D26508E83_952138597 = (vs != null) ? vs : (values = new Values());
        varB4EAC82CA7396A68D541C85D26508E83_952138597.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_952138597;
        // ---------- Original Method ----------
        //Collection<V> vs = values;
        //return (vs != null) ? vs : (values = new Values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.191 -0400", hash_original_method = "A019E2D84135E4E25D7FF3C9850D91E8", hash_generated_method = "4D05043D250F7FBE9219F2C7FB04000E")
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> varB4EAC82CA7396A68D541C85D26508E83_1478681990 = null; //Variable for return #1
        Set<Map.Entry<K,V>> es;
        es = entrySet;
        varB4EAC82CA7396A68D541C85D26508E83_1478681990 = (es != null) ? es : (entrySet = new EntrySet());
        varB4EAC82CA7396A68D541C85D26508E83_1478681990.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1478681990;
        // ---------- Original Method ----------
        //Set<Map.Entry<K,V>> es = entrySet;
        //return (es != null) ? es : (entrySet = new EntrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.192 -0400", hash_original_method = "1378C07218E9226BC9F7AD403D7C2636", hash_generated_method = "D18B6E1A7CF0EF284924DEB166B46E8C")
    public Enumeration<K> keys() {
        Enumeration<K> varB4EAC82CA7396A68D541C85D26508E83_1114302037 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1114302037 = new KeyIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1114302037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1114302037;
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.212 -0400", hash_original_method = "5CBB59F043F7E5A98C79AC06A0CCF84B", hash_generated_method = "57E4D956040B0D5BDE8BC64B437DCF9C")
    public Enumeration<V> elements() {
        Enumeration<V> varB4EAC82CA7396A68D541C85D26508E83_786547339 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_786547339 = new ValueIterator();
        varB4EAC82CA7396A68D541C85D26508E83_786547339.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_786547339;
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.213 -0400", hash_original_method = "39AA0B3013D1EF3A3A6D6B7DFFE53DC3", hash_generated_method = "06DD3B78C8CAFE362FE9A785AF7288AA")
    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
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
        addTaint(s.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.213 -0400", hash_original_method = "27FA8D459FE7A66670B6D1423BE5DC25", hash_generated_method = "DD853A837A2AD99EF00913D3188DA30F")
    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
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
        addTaint(s.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.213 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

        K key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.214 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.214 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D9A5701E394E22D841141BE91A2D9F15")

        volatile V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.214 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "AC47A60384D70A26B3EF9024FD965BF5")

        HashEntry<K,V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.214 -0400", hash_original_method = "89FFAB6F57FFB83251DFC8FAF8476851", hash_generated_method = "8A58D929EE079DEBCD95A67A156E3547")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.214 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "A5A8CDA7B0601BDA04B06999B66113E1")

        transient volatile int count;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.214 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "66B0BB3B51ED8DFDAEFDC2833CA7C4AB")

        transient int modCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.214 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "EBFF2C10A18F7B4BDFBFF5FE82B9E916")

        transient int threshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.214 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "7AFDE33CE4930D8257094745BD6A1CD4")

        transient volatile HashEntry<K,V>[] table;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.214 -0400", hash_original_field = "97C293EF8ABD832D29E88C21D8E562F5", hash_generated_field = "9AE85CE37BA4DE356F76E49D73EDA32D")

        float loadFactor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.215 -0400", hash_original_method = "467240A23868E01B6F6E31DCEE5330A3", hash_generated_method = "F919AD8B7C803DFE03CEEB564FE01E06")
          Segment(int initialCapacity, float lf) {
            loadFactor = lf;
            setTable(HashEntry.<K,V>newArray(initialCapacity));
            addTaint(initialCapacity);
            // ---------- Original Method ----------
            //loadFactor = lf;
            //setTable(HashEntry.<K,V>newArray(initialCapacity));
        }

        
                @SuppressWarnings("unchecked")
        static final <K,V> Segment<K,V>[] newArray(int i) {
            return new Segment[i];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.215 -0400", hash_original_method = "76FBB7D49FE13DE65CD87FF1D7913D53", hash_generated_method = "3CA87F2CA9B91DD40FEA6234D1C6C098")
         void setTable(HashEntry<K,V>[] newTable) {
            threshold = (int)(newTable.length * loadFactor);
            table = newTable;
            // ---------- Original Method ----------
            //threshold = (int)(newTable.length * loadFactor);
            //table = newTable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.238 -0400", hash_original_method = "526D0582321A198EF4385AC6C7D29654", hash_generated_method = "4861100033A30EABEE7893AC2839FB11")
         HashEntry<K,V> getFirst(int hash) {
            HashEntry<K,V> varB4EAC82CA7396A68D541C85D26508E83_2052671705 = null; //Variable for return #1
            HashEntry<K,V>[] tab;
            tab = table;
            varB4EAC82CA7396A68D541C85D26508E83_2052671705 = tab[hash & (tab.length - 1)];
            addTaint(hash);
            varB4EAC82CA7396A68D541C85D26508E83_2052671705.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2052671705;
            // ---------- Original Method ----------
            //HashEntry<K,V>[] tab = table;
            //return tab[hash & (tab.length - 1)];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.239 -0400", hash_original_method = "6C9E8EADE7BF0CF7C06CF8A72D599D54", hash_generated_method = "E9389CC5FFC0CDE958A2490F58B34B32")
         V readValueUnderLock(HashEntry<K,V> e) {
            V varB4EAC82CA7396A68D541C85D26508E83_1381368380 = null; //Variable for return #1
            lock();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1381368380 = e.value;
            } //End block
            finally 
            {
                unlock();
            } //End block
            addTaint(e.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1381368380.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1381368380;
            // ---------- Original Method ----------
            //lock();
            //try {
                //return e.value;
            //} finally {
                //unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.240 -0400", hash_original_method = "1AC5B4CC2690982021F35FD4CB4FB319", hash_generated_method = "8AE4F8D4FB4F8264697D63315671356D")
         V get(Object key, int hash) {
            V varB4EAC82CA7396A68D541C85D26508E83_1251845507 = null; //Variable for return #1
            V varB4EAC82CA7396A68D541C85D26508E83_1004761414 = null; //Variable for return #2
            V varB4EAC82CA7396A68D541C85D26508E83_1468658905 = null; //Variable for return #3
            {
                HashEntry<K,V> e;
                e = getFirst(hash);
                {
                    {
                        boolean var8A7AE4752A388591DE1859857B46D43A_1509287486 = (e.hash == hash && key.equals(e.key));
                        {
                            V v;
                            v = e.value;
                            varB4EAC82CA7396A68D541C85D26508E83_1251845507 = v;
                            varB4EAC82CA7396A68D541C85D26508E83_1004761414 = readValueUnderLock(e);
                        } //End block
                    } //End collapsed parenthetic
                    e = e.next;
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1468658905 = null;
            addTaint(key.getTaint());
            addTaint(hash);
            V varA7E53CE21691AB073D9660D615818899_1923006327; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1923006327 = varB4EAC82CA7396A68D541C85D26508E83_1251845507;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1923006327 = varB4EAC82CA7396A68D541C85D26508E83_1004761414;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1923006327 = varB4EAC82CA7396A68D541C85D26508E83_1468658905;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1923006327.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1923006327;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.240 -0400", hash_original_method = "4906CD88672F5095094E2A23826E0F83", hash_generated_method = "2F956976B43297C11F997C68AE8F25FF")
         boolean containsKey(Object key, int hash) {
            {
                HashEntry<K,V> e;
                e = getFirst(hash);
                {
                    {
                        boolean var8A7AE4752A388591DE1859857B46D43A_662001651 = (e.hash == hash && key.equals(e.key));
                    } //End collapsed parenthetic
                    e = e.next;
                } //End block
            } //End block
            addTaint(key.getTaint());
            addTaint(hash);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736577107 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_736577107;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.241 -0400", hash_original_method = "4B02A5A0C6C760AB5CD92802AE9AC755", hash_generated_method = "2749CCDD3007CCDCB7CAE163BAFB69ED")
         boolean containsValue(Object value) {
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
                                    boolean varAF9B2D3689B03A5213EF203D483D8AD4_1165967318 = (value.equals(v));
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            addTaint(value.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_34583094 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_34583094;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.254 -0400", hash_original_method = "B03D3F6036D4D187AC672F9D98953439", hash_generated_method = "3F343F42C3B5C6E2C1076AC2AEE16786")
         boolean replace(K key, int hash, V oldValue, V newValue) {
            lock();
            try 
            {
                HashEntry<K,V> e;
                e = getFirst(hash);
                {
                    boolean varFA336E0F01A8F7D94110F42C42943CEA_826702720 = (e != null && (e.hash != hash || !key.equals(e.key)));
                    e = e.next;
                } //End collapsed parenthetic
                boolean replaced;
                replaced = false;
                {
                    boolean varB391AA6784122268E404E2A55161AFDC_1226629090 = (e != null && oldValue.equals(e.value));
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
            addTaint(key.getTaint());
            addTaint(hash);
            addTaint(oldValue.getTaint());
            addTaint(newValue.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_178397394 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_178397394;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.255 -0400", hash_original_method = "496F1B463B31D22372CDAB52F4D749A3", hash_generated_method = "193BA15F11088A8E0134F6690A988D72")
         V replace(K key, int hash, V newValue) {
            V varB4EAC82CA7396A68D541C85D26508E83_1755286715 = null; //Variable for return #1
            lock();
            try 
            {
                HashEntry<K,V> e;
                e = getFirst(hash);
                {
                    boolean varFA336E0F01A8F7D94110F42C42943CEA_127605280 = (e != null && (e.hash != hash || !key.equals(e.key)));
                    e = e.next;
                } //End collapsed parenthetic
                V oldValue;
                oldValue = null;
                {
                    oldValue = e.value;
                    e.value = newValue;
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1755286715 = oldValue;
            } //End block
            finally 
            {
                unlock();
            } //End block
            addTaint(key.getTaint());
            addTaint(hash);
            addTaint(newValue.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1755286715.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1755286715;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.271 -0400", hash_original_method = "F92903F43B391F8F1B397027DA8E7AA9", hash_generated_method = "A9492C452A66D0193E26B8D5DF64F36C")
         V put(K key, int hash, V value, boolean onlyIfAbsent) {
            V varB4EAC82CA7396A68D541C85D26508E83_2086099514 = null; //Variable for return #1
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
                    boolean varFA336E0F01A8F7D94110F42C42943CEA_1445289540 = (e != null && (e.hash != hash || !key.equals(e.key)));
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
                varB4EAC82CA7396A68D541C85D26508E83_2086099514 = oldValue;
            } //End block
            finally 
            {
                unlock();
            } //End block
            addTaint(key.getTaint());
            addTaint(hash);
            addTaint(value.getTaint());
            addTaint(onlyIfAbsent);
            varB4EAC82CA7396A68D541C85D26508E83_2086099514.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2086099514;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.273 -0400", hash_original_method = "7AA7A225DF7E6D5CA86650AFCB7B431B", hash_generated_method = "7D3F56C9B1E26EA08F794FC3871C06DC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.274 -0400", hash_original_method = "A22DE89D38A395B57956004D412DD3F5", hash_generated_method = "F70404FF4365AB406353729E0577F318")
         V remove(Object key, int hash, Object value) {
            V varB4EAC82CA7396A68D541C85D26508E83_254892747 = null; //Variable for return #1
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
                    boolean varFA336E0F01A8F7D94110F42C42943CEA_411543940 = (e != null && (e.hash != hash || !key.equals(e.key)));
                    e = e.next;
                } //End collapsed parenthetic
                V oldValue;
                oldValue = null;
                {
                    V v;
                    v = e.value;
                    {
                        boolean varCDFC5F5D65441A80D44B2E79B876F2E6_136216643 = (value == null || value.equals(v));
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
                varB4EAC82CA7396A68D541C85D26508E83_254892747 = oldValue;
            } //End block
            finally 
            {
                unlock();
            } //End block
            addTaint(key.getTaint());
            addTaint(hash);
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_254892747.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_254892747;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.280 -0400", hash_original_method = "20609B8FF53EC43AEB5A4460B52EBDFF", hash_generated_method = "C3A44EE0BE4D521B85985A81D8C3D53D")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.280 -0400", hash_original_field = "50094462426A989CA556C53151CA22A4", hash_generated_field = "7573E78FA9BC529A32D39D59B99C89AD")

        private static long serialVersionUID = 2249069246763182397L;
    }


    
    abstract class HashIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.280 -0400", hash_original_field = "735C46731EEFB77B5ECB5630A622022B", hash_generated_field = "6D9B0937081A44F32DBD7158CFD76C24")

        int nextSegmentIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.280 -0400", hash_original_field = "F8C5594496DE1EFBE5BC9860038CE5E1", hash_generated_field = "2A2A99ACC13355EBDE9E414F85DC6404")

        int nextTableIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.280 -0400", hash_original_field = "73EBE5C2CCB25E5F693EC01CFE4A9A12", hash_generated_field = "0851F1AD358B7E0A6DDF18DC99A51E84")

        HashEntry<K,V>[] currentTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.280 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "34F1B1A1DBD9F7012195EE8A5509C745")

        HashEntry<K, V> nextEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.280 -0400", hash_original_field = "41032E42645C86567A380648031CF141", hash_generated_field = "EF55F7F73AA7A34DDB20CE140C1B2DB7")

        HashEntry<K, V> lastReturned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.299 -0400", hash_original_method = "1331DC8249C406CC83024534A57FEFEB", hash_generated_method = "D903CC46D67C5E6BD87F25FE63BEB736")
          HashIterator() {
            nextSegmentIndex = segments.length - 1;
            nextTableIndex = -1;
            advance();
            // ---------- Original Method ----------
            //nextSegmentIndex = segments.length - 1;
            //nextTableIndex = -1;
            //advance();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.302 -0400", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "A2E6E8A38F577F8539B9582C3CE740CB")
        public boolean hasMoreElements() {
            boolean varA4B7F1D30987591EF97AE96837F93D35_1082242300 = (hasNext());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2053993222 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2053993222;
            // ---------- Original Method ----------
            //return hasNext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.302 -0400", hash_original_method = "A06EA4B51D378F01CE00F7FB99A616EF", hash_generated_method = "8E8BAB6B6A65BD403FC28896837E324C")
        final void advance() {
            {
                boolean varAE56CE09D98F8D249FB4EAAAC2365BBF_1486685145 = (nextEntry != null && (nextEntry = nextEntry.next) != null);
            } //End collapsed parenthetic
            {
                {
                    boolean var63500D3C047D4C906175A14EF6FEFB9D_901929914 = ((nextEntry = currentTable[nextTableIndex--]) != null);
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
                                boolean var561CE7603C783A55D13FDCDDA31772EC_1818271616 = ((nextEntry = currentTable[j]) != null);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.303 -0400", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "5376D6DBA8DC3BCDC6A30782EC033ECC")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1805988989 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1805988989;
            // ---------- Original Method ----------
            //return nextEntry != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.303 -0400", hash_original_method = "DB7CF742BB593212DEE9E7DE200FEED8", hash_generated_method = "6AAD6321A6BA56849CC70EA09944CCDF")
         HashEntry<K,V> nextEntry() {
            HashEntry<K,V> varB4EAC82CA7396A68D541C85D26508E83_2125132283 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            lastReturned = nextEntry;
            advance();
            varB4EAC82CA7396A68D541C85D26508E83_2125132283 = lastReturned;
            varB4EAC82CA7396A68D541C85D26508E83_2125132283.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2125132283;
            // ---------- Original Method ----------
            //if (nextEntry == null)
                //throw new NoSuchElementException();
            //lastReturned = nextEntry;
            //advance();
            //return lastReturned;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.304 -0400", hash_original_method = "EB8010C2D5EA80D446C3485BFC85793F", hash_generated_method = "64211DA248DE87BDD0671C84567097BA")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.304 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.304 -0400", hash_original_method = "AC02B860B54618170BE24E50FF82F167", hash_generated_method = "061384628DCBAE370E07BE8ED4D09868")
        public K next() {
            K varB4EAC82CA7396A68D541C85D26508E83_1044767428 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1044767428 = super.nextEntry().key;
            varB4EAC82CA7396A68D541C85D26508E83_1044767428.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1044767428;
            // ---------- Original Method ----------
            //return super.nextEntry().key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.305 -0400", hash_original_method = "1473F8B0EF10582FE9B24F9D164CBEAD", hash_generated_method = "EA708BC336F2247F7BCBB774E5E646CD")
        public K nextElement() {
            K varB4EAC82CA7396A68D541C85D26508E83_403018320 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_403018320 = super.nextEntry().key;
            varB4EAC82CA7396A68D541C85D26508E83_403018320.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_403018320;
            // ---------- Original Method ----------
            //return super.nextEntry().key;
        }

        
    }


    
    final class ValueIterator extends HashIterator implements Iterator<V>, Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.305 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.305 -0400", hash_original_method = "282B954004CE321F97FD15862590F160", hash_generated_method = "64758D75B0A7D3BB7882E6DDA1DA3CE8")
        public V next() {
            V varB4EAC82CA7396A68D541C85D26508E83_1988938075 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1988938075 = super.nextEntry().value;
            varB4EAC82CA7396A68D541C85D26508E83_1988938075.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1988938075;
            // ---------- Original Method ----------
            //return super.nextEntry().value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.306 -0400", hash_original_method = "95D48303D225ADC424CB718F2FA08908", hash_generated_method = "92FE443F9E0BAEBBC84990188F6EBBCC")
        public V nextElement() {
            V varB4EAC82CA7396A68D541C85D26508E83_361647081 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_361647081 = super.nextEntry().value;
            varB4EAC82CA7396A68D541C85D26508E83_361647081.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_361647081;
            // ---------- Original Method ----------
            //return super.nextEntry().value;
        }

        
    }


    
    final class WriteThroughEntry extends AbstractMap.SimpleEntry<K,V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.306 -0400", hash_original_method = "A56113014EC205E193BCD1C4F8B24855", hash_generated_method = "2BCC3E18A00E366FA4BDB5DEAFB24F13")
          WriteThroughEntry(K k, V v) {
            super(k,v);
            addTaint(k.getTaint());
            addTaint(v.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.306 -0400", hash_original_method = "38F302BB69197C5906EE6F553583F6F9", hash_generated_method = "731CFC39125C1550F14EF9C12B25FE50")
        public V setValue(V value) {
            V varB4EAC82CA7396A68D541C85D26508E83_436670704 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            V v;
            v = super.setValue(value);
            ConcurrentHashMap.this.put(getKey(), value);
            varB4EAC82CA7396A68D541C85D26508E83_436670704 = v;
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_436670704.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_436670704;
            // ---------- Original Method ----------
            //if (value == null) throw new NullPointerException();
            //V v = super.setValue(value);
            //ConcurrentHashMap.this.put(getKey(), value);
            //return v;
        }

        
    }


    
    final class EntryIterator extends HashIterator implements Iterator<Entry<K,V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.307 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.307 -0400", hash_original_method = "DA1DC8695C9406305A6247D7AF5617DE", hash_generated_method = "5CA8F01C755152C92B8AD8C9169689C8")
        public Map.Entry<K,V> next() {
            Map.Entry<K,V> varB4EAC82CA7396A68D541C85D26508E83_1878973392 = null; //Variable for return #1
            HashEntry<K,V> e;
            e = super.nextEntry();
            varB4EAC82CA7396A68D541C85D26508E83_1878973392 = new WriteThroughEntry(e.key, e.value);
            varB4EAC82CA7396A68D541C85D26508E83_1878973392.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1878973392;
            // ---------- Original Method ----------
            //HashEntry<K,V> e = super.nextEntry();
            //return new WriteThroughEntry(e.key, e.value);
        }

        
    }


    
    final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.307 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.354 -0400", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "073CC61E7881CEBFAFE3C8E215C168E4")
        public Iterator<K> iterator() {
            Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_1542362927 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1542362927 = new KeyIterator();
            varB4EAC82CA7396A68D541C85D26508E83_1542362927.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1542362927;
            // ---------- Original Method ----------
            //return new KeyIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.356 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "07C9F4EC17A8C511D8C5A7428D9AFEC0")
        public int size() {
            int var2AE1BD72658B11B83F17E3D8DE9C3742_1340392921 = (ConcurrentHashMap.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482590943 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482590943;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.357 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "62AF2F81A3D31071957B088761D5A3AE")
        public boolean isEmpty() {
            boolean var2129446389ED975B0F4481D55BB56F6F_544149594 = (ConcurrentHashMap.this.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2130960565 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2130960565;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.357 -0400", hash_original_method = "37248D467FF06BE0B2F5DDC1489510DF", hash_generated_method = "B3B9329979A6D99503070A09D2BE4DA2")
        public boolean contains(Object o) {
            boolean var3A007D079E775775EF3E281A61BA88AC_2011426314 = (ConcurrentHashMap.this.containsKey(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_671615396 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_671615396;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.containsKey(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.358 -0400", hash_original_method = "5AA31A160A27D834D20E2EBCA8B4999F", hash_generated_method = "A4E1410593C1AF32D9D5544EF7426056")
        public boolean remove(Object o) {
            boolean var7AF3FCDEC3414604DC101A294DC0E9A1_1335911529 = (ConcurrentHashMap.this.remove(o) != null);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_466296851 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_466296851;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.remove(o) != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.358 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        public void clear() {
            ConcurrentHashMap.this.clear();
            // ---------- Original Method ----------
            //ConcurrentHashMap.this.clear();
        }

        
    }


    
    final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.358 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.359 -0400", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "BBDF45D90C9701BE80328D8086C0E1E6")
        public Iterator<V> iterator() {
            Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_1986096479 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1986096479 = new ValueIterator();
            varB4EAC82CA7396A68D541C85D26508E83_1986096479.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1986096479;
            // ---------- Original Method ----------
            //return new ValueIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.359 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "B97A36AB735FBFBAA55656122556071A")
        public int size() {
            int var2AE1BD72658B11B83F17E3D8DE9C3742_165313890 = (ConcurrentHashMap.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1982757394 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1982757394;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.359 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "C81836BE4977D84391EAAA999F71EF53")
        public boolean isEmpty() {
            boolean var2129446389ED975B0F4481D55BB56F6F_1608433600 = (ConcurrentHashMap.this.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_393842761 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_393842761;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.360 -0400", hash_original_method = "6F20D95CF6074119AB0347E3FAAE80A2", hash_generated_method = "7A65830E25FD17C0B68E4CAC3147F592")
        public boolean contains(Object o) {
            boolean varB5437F4F6895ACF0564A8B739D6BBE8E_2105460750 = (ConcurrentHashMap.this.containsValue(o));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1665190150 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1665190150;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.containsValue(o);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.360 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        public void clear() {
            ConcurrentHashMap.this.clear();
            // ---------- Original Method ----------
            //ConcurrentHashMap.this.clear();
        }

        
    }


    
    final class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.360 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.370 -0400", hash_original_method = "A1AF959F7C17DD47B4014053BC413A23", hash_generated_method = "56F59E42E6D435153EBC4548A505358F")
        public Iterator<Map.Entry<K,V>> iterator() {
            Iterator<Map.Entry<K,V>> varB4EAC82CA7396A68D541C85D26508E83_964251443 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_964251443 = new EntryIterator();
            varB4EAC82CA7396A68D541C85D26508E83_964251443.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_964251443;
            // ---------- Original Method ----------
            //return new EntryIterator();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.370 -0400", hash_original_method = "44CFEB1CC21C67EDDE5E7F2C0FB0C916", hash_generated_method = "2728EB4338818E50A5D908E449524A6F")
        public boolean contains(Object o) {
            Map.Entry<?,?> e;
            e = (Map.Entry<?,?>)o;
            V v;
            v = ConcurrentHashMap.this.get(e.getKey());
            boolean varA30474C0E53C22C4F5FAE67C3EFD9B30_504599856 = (v != null && v.equals(e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_49974168 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_49974168;
            // ---------- Original Method ----------
            //if (!(o instanceof Map.Entry))
                //return false;
            //Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            //V v = ConcurrentHashMap.this.get(e.getKey());
            //return v != null && v.equals(e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.370 -0400", hash_original_method = "8F57FBEE664B771D5FDC7BC47FB0BA8F", hash_generated_method = "E4BA31BA27754FF80B69A24F63950D73")
        public boolean remove(Object o) {
            Map.Entry<?,?> e;
            e = (Map.Entry<?,?>)o;
            boolean var610A1F7E9B8954F006C6C3D32F43CF4E_2016797383 = (ConcurrentHashMap.this.remove(e.getKey(), e.getValue()));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1056459700 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1056459700;
            // ---------- Original Method ----------
            //if (!(o instanceof Map.Entry))
                //return false;
            //Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            //return ConcurrentHashMap.this.remove(e.getKey(), e.getValue());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.371 -0400", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "D0F217B4133A3879A5221FCA786B6100")
        public int size() {
            int var2AE1BD72658B11B83F17E3D8DE9C3742_1318243373 = (ConcurrentHashMap.this.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280928741 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280928741;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.371 -0400", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "8E152B2013717BF24C4DC84F1C6357E1")
        public boolean isEmpty() {
            boolean var2129446389ED975B0F4481D55BB56F6F_1105633028 = (ConcurrentHashMap.this.isEmpty());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1244939769 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1244939769;
            // ---------- Original Method ----------
            //return ConcurrentHashMap.this.isEmpty();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.371 -0400", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "29610EFF6CC76F338DB294003E83D492")
        public void clear() {
            ConcurrentHashMap.this.clear();
            // ---------- Original Method ----------
            //ConcurrentHashMap.this.clear();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.371 -0400", hash_original_field = "38B2FE469B8CC3659DBEBB0BBB913A6C", hash_generated_field = "BF2617945CF630DB2593086D34799BD4")

    private static long serialVersionUID = 7249069246763182397L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.371 -0400", hash_original_field = "F2DE208954D426D31F499310022241CF", hash_generated_field = "1663AF33A8C8A49A332245ABC80F803F")

    static int DEFAULT_INITIAL_CAPACITY = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.371 -0400", hash_original_field = "DF48F8D92FC36ACC8968654109C53FC4", hash_generated_field = "5E50DAC6309EF9A0289BCDB49DC3C430")

    static float DEFAULT_LOAD_FACTOR = 0.75f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.382 -0400", hash_original_field = "ED64AF2D88EA33EF6133115E5E8FFE32", hash_generated_field = "EBD24B88F108F08BFD5DAE87B8B1D6E3")

    static int DEFAULT_CONCURRENCY_LEVEL = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.382 -0400", hash_original_field = "3644613F5550D368EA9636CD57F0B359", hash_generated_field = "058A066A806AD24D7D50CE5B288593E6")

    static int MAXIMUM_CAPACITY = 1 << 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.383 -0400", hash_original_field = "C9E0D462440D958860E70662EC748F43", hash_generated_field = "A540A743D6E7ADC7A4EC4E9C26BC538F")

    static int MAX_SEGMENTS = 1 << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.383 -0400", hash_original_field = "4866497D0659FC39D1D9B2B7C08C16DB", hash_generated_field = "5F6EB6668C469A3CE1F38C25FACBB8EA")

    static int RETRIES_BEFORE_LOCK = 2;
}


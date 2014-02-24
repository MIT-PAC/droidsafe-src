/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.util;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * IdentityHashMap is a variant on HashMap which tests equality by reference
 * instead of equality by value. Basically, keys and values are compared for
 * equality by checking if their references are equal rather than by calling the
 * "equals" function.
 * <p>
 * <b>Note: This class intentionally violates the general contract of {@code
 * Map}'s on comparing objects by their {@code equals} method.</b>
 * <p>
 * IdentityHashMap uses open addressing (linear probing in particular) for
 * collision resolution. This is different from HashMap which uses Chaining.
 * <p>
 * Like HashMap, IdentityHashMap is not thread safe, so access by multiple
 * threads must be synchronized by an external mechanism such as
 * Collections.synchronizedMap.
 *
 * @since 1.4
 */
public class IdentityHashMap<K, V> extends AbstractMap<K, V> implements
        Map<K, V>, Serializable, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:08.748 -0500", hash_original_field = "A0A78839DFCD243E0A97CB3922652AE0", hash_generated_field = "79E552DDD6CD74A49BFF2F345B8A2229")


    private static final long serialVersionUID = 8188218128353913216L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:08.784 -0500", hash_original_field = "FA52DE8B5B17B97C5698B7FC564EBDA0", hash_generated_field = "FB05DAE1C403395EF791F285C9C2DC34")

    private static final int DEFAULT_MAX_SIZE = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:08.804 -0500", hash_original_field = "6EAC791D9BA308D55B821E0CE21F1BE5", hash_generated_field = "8DF1401F08FBAB169B77234D2A23A58C")

    private static final int loadFactor = 7500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:08.820 -0500", hash_original_field = "628074FB2C8671CA43F28F2F69FAC9AF", hash_generated_field = "9670838B634F6F99ABC3B1A0098F1B0D")

    private static final Object NULL_OBJECT = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:08.759 -0500", hash_original_field = "67BBD4B95E990052FBB9600D15E343A4", hash_generated_field = "AD127E2B4D986278CBFC1D9FF3B666A1")

    transient Object[] elementData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:08.767 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

    int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:08.774 -0500", hash_original_field = "B212DD967AF5750AEF1DDA2E6D14352F", hash_generated_field = "EBFF2C10A18F7B4BDFBFF5FE82B9E916")

    transient int threshold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:08.812 -0500", hash_original_field = "7C38AA8724D6D8AD727BB2AB85887DF0", hash_generated_field = "12E79C42739D112FBF146E2A08503782")

    transient int modCount = 0;  //$NON-LOCK-1$




    /**
     * Creates an IdentityHashMap with default expected maximum size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.077 -0500", hash_original_method = "CF4E04D9BE7BBED84D489834E5A66249", hash_generated_method = "EEBC4270709A81BAEA5E9378F3C6027B")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
public IdentityHashMap() {
        this(DEFAULT_MAX_SIZE);
    }

    /**
     * Creates an IdentityHashMap with the specified maximum size parameter.
     *
     * @param maxSize
     *            The estimated maximum number of entries that will be put in
     *            this map.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.085 -0500", hash_original_method = "7CD774B1E9CE336DC45F8F4C393FF983", hash_generated_method = "FD20BB14DD5208672DF9D0E4314121FC")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
public IdentityHashMap(int maxSize) {
        super();
        super.requestCapacity(maxSize);
    }

    /**
     * Creates an IdentityHashMap using the given map as initial values.
     *
     * @param map
     *            A map of (key,value) pairs to copy into the IdentityHashMap.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.113 -0500", hash_original_method = "A6044E4311D15BDAC205EAB611B1078B", hash_generated_method = "8416BACE806C6F858F66806C75501E66")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
public IdentityHashMap(Map<? extends K, ? extends V> map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        super.putAll(map);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.094 -0500", hash_original_method = "781BC1AEB43B59447DF913A0C6E9B0CF", hash_generated_method = "AC018E552D65C008A9EE92D22B4070C4")
    
private int getThreshold(int maxSize) {
        // assign the threshold to maxSize initially, this will change to a
        // higher value if rehashing occurs.
        return maxSize > 3 ? maxSize : 3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.100 -0500", hash_original_method = "1EC323E151A9A9F2A50AC6CDC57160D0", hash_generated_method = "CF8B1E95899E43E71C69DCF8B8185BE1")
    
private int computeElementArraySize() {
        int arraySize = (int) (((long) threshold * 10000) / loadFactor) * 2;
        // ensure arraySize is positive, the above cast from long to int type
        // leads to overflow and negative arraySize if threshold is too big
        return arraySize < 0 ? -arraySize : arraySize;
    }

    /**
     * Create a new element array
     *
     * @param s
     *            the number of elements
     * @return Reference to the element array
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.106 -0500", hash_original_method = "82EDC40DB5D2D8551DABF13E0864CA4A", hash_generated_method = "54D0AB823BFC5743163A31F7205CD3F7")
    
private Object[] newElementArray(int s) {
        return new Object[s];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.119 -0500", hash_original_method = "EC077FF294E7BB24D59CB59A711685E2", hash_generated_method = "5A61917980BE4D628B918E7DC3915AA7")
    
@SuppressWarnings("unchecked")
    private V massageValue(Object value) {
        return (V) ((value == NULL_OBJECT) ? null : value);
    }

    /**
     * Removes all elements from this map, leaving it empty.
     *
     * @see #isEmpty()
     * @see #size()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.125 -0500", hash_original_method = "BDCD76FD65816EABAE96959FB0B37C8A", hash_generated_method = "1852DEAACE6CBD9A162B16B4EBCCD696")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST) 
@Override
    public void clear() {
        super.clear();
    }

    /**
     * Returns whether this map contains the specified key.
     *
     * @param key
     *            the key to search for.
     * @return {@code true} if this map contains the specified key,
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.133 -0500", hash_original_method = "5096545BB8D7E235F81B2D74AA90BB35", hash_generated_method = "F16077268B84C9A843A28E77999DA1F2")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST) 
@Override
    public boolean containsKey(Object key) {
        return super.containsKey(key);
    }

    /**
     * Returns whether this map contains the specified value.
     *
     * @param value
     *            the value to search for.
     * @return {@code true} if this map contains the specified value,
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.139 -0500", hash_original_method = "182DC7E21BB3FA85F9FDDA653B5E53EC", hash_generated_method = "3147F376099BBEB2B4A0E4028F1A2E2F")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST) 
@Override
    public boolean containsValue(Object value) {
        return super.containsValue(value);
    }

    /**
     * Returns the value of the mapping with the specified key.
     *
     * @param key
     *            the key.
     * @return the value of the mapping with the specified key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.146 -0500", hash_original_method = "F6964BC1AA97AC873AACFDCE0324626E", hash_generated_method = "ED72F047B0F52E41ADBE7ED30146BA8D")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST) 
@Override
    public V get(Object key) {
        return super.get(key);
    }

    /**
     * Maps the specified key to the specified value.
     *
     * @param key
     *            the key.
     * @param value
     *            the value.
     * @return the value of any previous mapping with the specified key or
     *         {@code null} if there was no such mapping.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.179 -0500", hash_original_method = "5FE57D2E7B335A053FA4B0E269FB9FA5", hash_generated_method = "9F0D9977F43D85DB151F9F0E50619FCB")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST) 
@Override
    public V put(K key, V value) {
        return super.put(key,  value);
    }

    /**
     * Copies all the mappings in the specified map to this map. These mappings
     * will replace all mappings that this map had for any of the keys currently
     * in the given map.
     *
     * @param map
     *            the map to copy mappings from.
     * @throws NullPointerException
     *             if {@code map} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.185 -0500", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "180A9BE19E826613D60BF9D91B5A0A45")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
@Override
    public void putAll(Map<? extends K, ? extends V> map) {
        super.putAll(map);
    }

    /**
     * Removes the mapping with the specified key from this map.
     *
     * @param key
     *            the key of the mapping to remove.
     * @return the value of the removed mapping, or {@code null} if no mapping
     *         for the specified key was found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.206 -0500", hash_original_method = "5D1C6299BDD74A2A432086CB6E5E8EB0", hash_generated_method = "A51643FD1FC88DE197D002FD989BE4CC")
    
@Override
    public V remove(Object key) {
        return super.remove(key);
    }

    /**
     * Returns a set containing all of the mappings in this map. Each mapping is
     * an instance of {@link Map.Entry}. As the set is backed by this map,
     * changes in one will be reflected in the other.
     *
     * @return a set of the mappings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.212 -0500", hash_original_method = "426CBD32668C89F2F09688DDB7CBD67D", hash_generated_method = "C85D713BD4BCF693C4014393A83CA47D")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
@Override
    public Set<Map.Entry<K, V>> entrySet() {
        return super.getEntrySet();
    }

    /**
     * Returns a set of the keys contained in this map. The set is backed by
     * this map so changes to one are reflected by the other. The set does not
     * support adding.
     *
     * @return a set of the keys.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.261 -0500", hash_original_method = "9E081198F867421B2EE1E810B189D8F9", hash_generated_method = "BCC8384EAE212F81EE15688CABF5786B")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)    
@Override
    public Set<K> keySet() {
        return super.keySet();
    }
    

    /**
     * Returns a collection of the values contained in this map. The collection
     * is backed by this map so changes to one are reflected by the other. The
     * collection supports remove, removeAll, retainAll and clear operations,
     * and it does not support add or addAll operations.
     * <p>
     * This method returns a collection which is the subclass of
     * AbstractCollection. The iterator method of this subclass returns a
     * "wrapper object" over the iterator of map's entrySet(). The {@code size}
     * method wraps the map's size method and the {@code contains} method wraps
     * the map's containsValue method.
     * <p>
     * The collection is created when this method is called for the first time
     * and returned in response to all subsequent calls. This method may return
     * different collections when multiple concurrent calls occur, since no
     * synchronization is performed.
     *
     * @return a collection of the values contained in this map.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.312 -0500", hash_original_method = "C71140816AE220E4DE6F3C222B8E61B9", hash_generated_method = "EAB1096B92FB78D39FC84D8BC5E0DC53")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
@Override
    public Collection<V> values() {
        return super.values();
    }

    /**
     * Compares this map with other objects. This map is equal to another map is
     * it represents the same set of mappings. With this map, two mappings are
     * the same if both the key and the value are equal by reference. When
     * compared with a map that is not an IdentityHashMap, the equals method is
     * neither necessarily symmetric (a.equals(b) implies b.equals(a)) nor
     * transitive (a.equals(b) and b.equals(c) implies a.equals(c)).
     *
     * @param object
     *            the object to compare to.
     * @return whether the argument object is equal to this object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.320 -0500", hash_original_method = "84B9E6027D2FCCE6A1B5E4707316E9F7", hash_generated_method = "086F7A707D0523E6E0AF66D51D098DC7")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
@Override
    public boolean equals(Object object) {
        /*
         * We need to override the equals method in AbstractMap because
         * AbstractMap.equals will call ((Map) object).entrySet().contains() to
         * determine equality of the entries, so it will defer to the argument
         * for comparison, meaning that reference-based comparison will not take
         * place. We must ensure that all comparison is implemented by methods
         * in this class (or in one of our inner classes) for reference-based
         * comparison to take place.
         */
        if (this == object) {
            return true;
        }
        if (object instanceof Map) {
            Map<?, ?> map = (Map) object;
            if (size() != map.size()) {
                return false;
            }

            Set<Map.Entry<K, V>> set = entrySet();
            // ensure we use the equals method of the set created by "this"
            return set.equals(map.entrySet());
        }
        return false;
    }

    /**
     * Returns a new IdentityHashMap with the same mappings and size as this
     * one.
     *
     * @return a shallow copy of this IdentityHashMap.
     * @see java.lang.Cloneable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.326 -0500", hash_original_method = "593629377CF6402E72F5DC997FF5D0DD", hash_generated_method = "E5520E2615841A376E1AE93951083E59")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
@Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Returns whether this IdentityHashMap has no elements.
     *
     * @return {@code true} if this IdentityHashMap has no elements,
     *         {@code false} otherwise.
     * @see #size()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.332 -0500", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "EF685F710D479F00750620AFE7C916C4")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
@Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Returns the number of mappings in this IdentityHashMap.
     *
     * @return the number of mappings in this IdentityHashMap.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 14:42:09.338 -0500", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "1B1551AD543164CCE8ABE887F4733D99")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
@Override
    public int size() {
        return super.size();
    }

}

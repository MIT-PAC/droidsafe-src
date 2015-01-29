/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v4.util;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * ArrayMap is a generic key->value mapping data structure that is
 * designed to be more memory efficient than a traditional {@link java.util.HashMap},
 * this implementation is a version of the platform's
 * {@link android.util.ArrayMap} that can be used on older versions of the platform.
 * It keeps its mappings in an array data structure -- an integer array of hash
 * codes for each item, and an Object array of the key/value pairs.  This allows it to
 * avoid having to create an extra object for every entry put in to the map, and it
 * also tries to control the growth of the size of these arrays more aggressively
 * (since growing them only requires copying the entries in the array, not rebuilding
 * a hash map).
 *
 * <p>If you don't need the standard Java container APIs provided here (iterators etc),
 * consider using {@link SimpleArrayMap} instead.</p>
 *
 * <p>Note that this implementation is not intended to be appropriate for data structures
 * that may contain large numbers of items.  It is generally slower than a traditional
 * HashMap, since lookups require a binary search and adds and removes require inserting
 * and deleting entries in the array.  For containers holding up to hundreds of items,
 * the performance difference is not significant, less than 50%.</p>
 *
 * <p>Because this container is intended to better balance memory use, unlike most other
 * standard Java containers it will shrink its array as items are removed from it.  Currently
 * you have no control over this shrinking -- if you set a capacity and then remove an
 * item, it may reduce the capacity to better match the current size.  In the future an
 * explicit call to set the capacity should turn off this aggressive shrinking behavior.</p>
 */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.082 -0400", hash_original_field = "F67395B26F28D5225C45670B34CA1F57", hash_generated_field = "F67395B26F28D5225C45670B34CA1F57")

    MapCollections<K, V> mCollections;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.086 -0400", hash_original_method = "0C252A4F9E59FDF8EE461DF0F5B8326F", hash_generated_method = "70D7EE0AF837031A869281F26B713455")
    
public ArrayMap() {
        super();
    }

    /**
     * Create a new ArrayMap with a given initial capacity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.090 -0400", hash_original_method = "DF7A572B056BE70EAA6AE74E5669DA15", hash_generated_method = "280942780F4537FA0572B56DF1075B9C")
    
public ArrayMap(int capacity) {
        super(capacity);
    }

    /**
     * Create a new ArrayMap with the mappings from the given ArrayMap.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.094 -0400", hash_original_method = "032AFDBA296A046117454F423BB945D1", hash_generated_method = "7F8B3EEF4781D43E5E6F8D938583981A")
    
public ArrayMap(SimpleArrayMap map) {
        super(map);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.144 -0400", hash_original_method = "253EF9E2C94604F3B36A2A7D788080CE", hash_generated_method = "48A457611827B33D6AB9E1DCD0C06592")
    
private MapCollections<K, V> getCollection() {
        if (mCollections == null) {
            mCollections = new MapCollections<K, V>() {
                @DSSafe(DSCat.SAFE_LIST)
        @Override
                protected int colGetSize() {
                    return mSize;
                }

                @DSSafe(DSCat.SAFE_LIST)
        @Override
                protected Object colGetEntry(int index, int offset) {
                    return mArray[(index<<1) + offset];
                }

                @DSSafe(DSCat.SAFE_LIST)
        @Override
                protected int colIndexOfKey(Object key) {
                    return key == null ? indexOfNull() : indexOf(key, key.hashCode());
                }

                @DSSafe(DSCat.SAFE_LIST)
        @Override
                protected int colIndexOfValue(Object value) {
                    return indexOfValue(value);
                }

                @DSSafe(DSCat.SAFE_LIST)
        @Override
                protected Map<K, V> colGetMap() {
                    return ArrayMap.this;
                }

                @DSSafe(DSCat.SAFE_LIST)
        @Override
                protected void colPut(K key, V value) {
                    put(key, value);
                }

                @DSSafe(DSCat.SAFE_LIST)
        @Override
                protected V colSetValue(int index, V value) {
                    return setValueAt(index, value);
                }

                @DSSafe(DSCat.SAFE_LIST)
        @Override
                protected void colRemoveAt(int index) {
                    removeAt(index);
                }

                @DSSafe(DSCat.SAFE_LIST)
        @Override
                protected void colClear() {
                    clear();
                }
            };
        }
        return mCollections;
    }

    /**
     * Determine if the array map contains all of the keys in the given collection.
     * @param collection The collection whose contents are to be checked against.
     * @return Returns true if this array map contains a key for every entry
     * in <var>collection</var>, else returns false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.148 -0400", hash_original_method = "0D3170F69C4BA9ADEC94C90304C41ED9", hash_generated_method = "21573AF4568D3A5F45FBD567D5AD3B55")
    
public boolean containsAll(Collection<?> collection) {
        return MapCollections.containsAllHelper(this, collection);
    }

    /**
     * Perform a {@link #put(Object, Object)} of all key/value pairs in <var>map</var>
     * @param map The map whose contents are to be retrieved.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.152 -0400", hash_original_method = "2C4D4B00FF54802FEAB4AFA7EF2A48C6", hash_generated_method = "A96BF73B6D4472A450B96DD156F4CF89")
    
@Override
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(mSize + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Remove all keys in the array map that exist in the given collection.
     * @param collection The collection whose contents are to be used to remove keys.
     * @return Returns true if any keys were removed from the array map, else false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.157 -0400", hash_original_method = "FFD6A69C57026BBF1F40ED7C305CFB7A", hash_generated_method = "868A4C4BC350AF41B7690107A0086CD3")
    
public boolean removeAll(Collection<?> collection) {
        return MapCollections.removeAllHelper(this, collection);
    }

    /**
     * Remove all keys in the array map that do <b>not</b> exist in the given collection.
     * @param collection The collection whose contents are to be used to determine which
     * keys to keep.
     * @return Returns true if any keys were removed from the array map, else false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.161 -0400", hash_original_method = "8DF8926045FA3D7488F8F6C655626305", hash_generated_method = "7E89933F178AF29E4FE757E998492C47")
    
public boolean retainAll(Collection<?> collection) {
        return MapCollections.retainAllHelper(this, collection);
    }

    /**
     * Return a {@link java.util.Set} for iterating over and interacting with all mappings
     * in the array map.
     *
     * <p><b>Note:</b> this is a very inefficient way to access the array contents, it
     * requires generating a number of temporary objects.</p>
     *
     * <p><b>Note:</b></p> the semantics of this
     * Set are subtly different than that of a {@link java.util.HashMap}: most important,
     * the {@link java.util.Map.Entry Map.Entry} object returned by its iterator is a single
     * object that exists for the entire iterator, so you can <b>not</b> hold on to it
     * after calling {@link java.util.Iterator#next() Iterator.next}.</p>
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.165 -0400", hash_original_method = "A427D615D591B7E5D3629D4DD8D1932A", hash_generated_method = "1286D68978A16DEC0C1EE4AE0DE24953")
    
@Override
    public Set<Entry<K, V>> entrySet() {
        return getCollection().getEntrySet();
    }

    /**
     * Return a {@link java.util.Set} for iterating over and interacting with all keys
     * in the array map.
     *
     * <p><b>Note:</b> this is a fairly inefficient way to access the array contents, it
     * requires generating a number of temporary objects.</p>
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.169 -0400", hash_original_method = "B357E55034E4D406BD96CAA828907FAA", hash_generated_method = "392CD3F52635868EED10B8E7B29B9950")
    
@Override
    public Set<K> keySet() {
        return getCollection().getKeySet();
    }

    /**
     * Return a {@link java.util.Collection} for iterating over and interacting with all values
     * in the array map.
     *
     * <p><b>Note:</b> this is a fairly inefficient way to access the array contents, it
     * requires generating a number of temporary objects.</p>
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.173 -0400", hash_original_method = "CB75CC20D831538868CB2246F6C3A390", hash_generated_method = "6DEDDF296C9E9AC2B63F5504D2832F29")
    
@Override
    public Collection<V> values() {
        return getCollection().getValues();
    }
}

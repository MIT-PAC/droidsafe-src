/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.util;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;

import java.util.Map;

/**
 * Base implementation of {@link ArrayMap} that doesn't include any standard Java
 * container API interoperability.  These features are generally heavier-weight ways
 * to interact with the container, so discouraged, but they can be useful to make it
 * easier to use as a drop-in replacement for HashMap.  If you don't need them, this
 * class can be preferrable since it doesn't bring in any of the implementation of those
 * APIs, allowing that code to be stripped by ProGuard.
 */
public class SimpleArrayMap<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.485 -0400", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.489 -0400", hash_original_field = "EF884FE79CB4FA1371ABF03247A6AC49", hash_generated_field = "AE5F975A5D7AEE6CCA2924AA6DD2D880")

    private static final String TAG = "ArrayMap";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.493 -0400", hash_original_field = "C67274439F1CF8F7F6DFD7F2B4346632", hash_generated_field = "D6D11F45859C8324E13080FF6254C0A0")

    private static final int BASE_SIZE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.497 -0400", hash_original_field = "F16CF4FDC75C7D23A23055FA52E83DFA", hash_generated_field = "15201F94BE9DB48FAC2DC530A8FC26DA")

    private static final int CACHE_SIZE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.500 -0400", hash_original_field = "DC3E4304A233823D86842381374AC444", hash_generated_field = "1A9D37FF87CF6A9751F65CF8E2BE65F4")

    static Object[] mBaseCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.503 -0400", hash_original_field = "AB5137C8FF5675998C2CC8B138EE2DFA", hash_generated_field = "3B5459696920A56D7EB09A4D09C6E88B")

    static int mBaseCacheSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.506 -0400", hash_original_field = "F6D82DFD2EEB7032F098CF13DE83F1AB", hash_generated_field = "5D9A3320879FCD04D1732879B2C6A84D")

    static Object[] mTwiceBaseCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.511 -0400", hash_original_field = "F7BC8919997525BBA230806D0826FAD4", hash_generated_field = "613E8853E73DFA6AAB129218D5939A87")

    static int mTwiceBaseCacheSize;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.542 -0400", hash_original_method = "A9476A1EEB8913C9E9932D0B7E7DDF89", hash_generated_method = "BFA4786C4DCA2621AC95051AA5811F74")
    
private static void freeArrays(final int[] hashes, final Object[] array, final int size) {
        if (hashes.length == (BASE_SIZE*2)) {
            synchronized (ArrayMap.class) {
                if (mTwiceBaseCacheSize < CACHE_SIZE) {
                    array[0] = mTwiceBaseCache;
                    array[1] = hashes;
                    for (int i=(size<<1)-1; i>=2; i--) {
                        array[i] = null;
                    }
                    mTwiceBaseCache = array;
                    mTwiceBaseCacheSize++;
                    if (DEBUG) Log.d(TAG, "Storing 2x cache " + array
                            + " now have " + mTwiceBaseCacheSize + " entries");
                }
            }
        } else if (hashes.length == BASE_SIZE) {
            synchronized (ArrayMap.class) {
                if (mBaseCacheSize < CACHE_SIZE) {
                    array[0] = mBaseCache;
                    array[1] = hashes;
                    for (int i=(size<<1)-1; i>=2; i--) {
                        array[i] = null;
                    }
                    mBaseCache = array;
                    mBaseCacheSize++;
                    if (DEBUG) Log.d(TAG, "Storing 1x cache " + array
                            + " now have " + mBaseCacheSize + " entries");
                }
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.514 -0400", hash_original_field = "DB058C63BA7F65396899317129B01509", hash_generated_field = "DB058C63BA7F65396899317129B01509")

    int[] mHashes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.517 -0400", hash_original_field = "DBD5B7CFEC3506603E12B2C560617C01", hash_generated_field = "DBD5B7CFEC3506603E12B2C560617C01")

    Object[] mArray;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.521 -0400", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "205262C28D2B190751535A4911B3B259")

    int mSize;

    /**
     * Create a new empty ArrayMap.  The default capacity of an array map is 0, and
     * will grow once items are added to it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.545 -0400", hash_original_method = "25CAA756E143C0865A6637497CD6F2C1", hash_generated_method = "3C38BB05E0B5167D561C92351BF342B4")
    
public SimpleArrayMap() {
        mHashes = ContainerHelpers.EMPTY_INTS;
        mArray = ContainerHelpers.EMPTY_OBJECTS;
        mSize = 0;
    }

    /**
     * Create a new ArrayMap with a given initial capacity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.549 -0400", hash_original_method = "BA1421E7ADA5C5B5A70A9ABA5C9A4B45", hash_generated_method = "6330EBD913AF8D87164E2AA9C4839746")
    
public SimpleArrayMap(int capacity) {
        if (capacity == 0) {
            mHashes = ContainerHelpers.EMPTY_INTS;
            mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(capacity);
        }
        mSize = 0;
    }

    /**
     * Create a new ArrayMap with the mappings from the given ArrayMap.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.553 -0400", hash_original_method = "B80EC25530CA78E81C76AB2BDDD2D797", hash_generated_method = "5DC0ED740025801AE369B5F9914B9740")
    
public SimpleArrayMap(SimpleArrayMap map) {
        this();
        if (map != null) {
            putAll(map);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.525 -0400", hash_original_method = "A25D329AED0FC45488C75E184A8E590D", hash_generated_method = "AB34D97F47A669A37D55920E9E5B672A")
    
int indexOf(Object key, int hash) {
        final int N = mSize;

        // Important fast case: if nothing is in here, nothing to look for.
        if (N == 0) {
            return ~0;
        }

        int index = ContainerHelpers.binarySearch(mHashes, N, hash);

        // If the hash code wasn't found, then we have no entry for this key.
        if (index < 0) {
            return index;
        }

        // If the key at the returned index matches, that's what we want.
        if (key.equals(mArray[index<<1])) {
            return index;
        }

        // Search for a matching key after the index.
        int end;
        for (end = index + 1; end < N && mHashes[end] == hash; end++) {
            if (key.equals(mArray[end << 1])) return end;
        }

        // Search for a matching key before the index.
        for (int i = index - 1; i >= 0 && mHashes[i] == hash; i--) {
            if (key.equals(mArray[i << 1])) return i;
        }

        // Key not found -- return negative value indicating where a
        // new entry for this key should go.  We use the end of the
        // hash chain to reduce the number of array entries that will
        // need to be copied when inserting.
        return ~end;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.530 -0400", hash_original_method = "076C98F15276A17990CA16A9FAB64216", hash_generated_method = "864066E34CCAE212B34AB8ABDF2A431C")
    
int indexOfNull() {
        final int N = mSize;

        // Important fast case: if nothing is in here, nothing to look for.
        if (N == 0) {
            return ~0;
        }

        int index = ContainerHelpers.binarySearch(mHashes, N, 0);

        // If the hash code wasn't found, then we have no entry for this key.
        if (index < 0) {
            return index;
        }

        // If the key at the returned index matches, that's what we want.
        if (null == mArray[index<<1]) {
            return index;
        }

        // Search for a matching key after the index.
        int end;
        for (end = index + 1; end < N && mHashes[end] == 0; end++) {
            if (null == mArray[end << 1]) return end;
        }

        // Search for a matching key before the index.
        for (int i = index - 1; i >= 0 && mHashes[i] == 0; i--) {
            if (null == mArray[i << 1]) return i;
        }

        // Key not found -- return negative value indicating where a
        // new entry for this key should go.  We use the end of the
        // hash chain to reduce the number of array entries that will
        // need to be copied when inserting.
        return ~end;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.537 -0400", hash_original_method = "7F2186F200D69C67DC84F80AE7755398", hash_generated_method = "985B8C5252ABAA578289784F3CA49BD2")
    
private void allocArrays(final int size) {
        if (size == (BASE_SIZE*2)) {
            synchronized (ArrayMap.class) {
                if (mTwiceBaseCache != null) {
                    final Object[] array = mTwiceBaseCache;
                    mArray = array;
                    mTwiceBaseCache = (Object[])array[0];
                    mHashes = (int[])array[1];
                    array[0] = array[1] = null;
                    mTwiceBaseCacheSize--;
                    if (DEBUG) Log.d(TAG, "Retrieving 2x cache " + mHashes
                            + " now have " + mTwiceBaseCacheSize + " entries");
                    return;
                }
            }
        } else if (size == BASE_SIZE) {
            synchronized (ArrayMap.class) {
                if (mBaseCache != null) {
                    final Object[] array = mBaseCache;
                    mArray = array;
                    mBaseCache = (Object[])array[0];
                    mHashes = (int[])array[1];
                    array[0] = array[1] = null;
                    mBaseCacheSize--;
                    if (DEBUG) Log.d(TAG, "Retrieving 1x cache " + mHashes
                            + " now have " + mBaseCacheSize + " entries");
                    return;
                }
            }
        }

        mHashes = new int[size];
        mArray = new Object[size<<1];
    }

    /**
     * Make the array map empty.  All storage is released.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.557 -0400", hash_original_method = "B75081E678B9EDAB87E52EF21686F3B2", hash_generated_method = "BFF60BFDCC4DB93E6D36092F69D1D31B")
    
public void clear() {
        if (mSize != 0) {
            freeArrays(mHashes, mArray, mSize);
            mHashes = ContainerHelpers.EMPTY_INTS;
            mArray = ContainerHelpers.EMPTY_OBJECTS;
            mSize = 0;
        }
    }

    /**
     * Ensure the array map can hold at least <var>minimumCapacity</var>
     * items.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.561 -0400", hash_original_method = "577EA5DA8974E61A386C8E147A3CEF63", hash_generated_method = "95DAE55CDE1E508ACD62AF5CD93D719E")
    
public void ensureCapacity(int minimumCapacity) {
        if (mHashes.length < minimumCapacity) {
            final int[] ohashes = mHashes;
            final Object[] oarray = mArray;
            allocArrays(minimumCapacity);
            if (mSize > 0) {
                System.arraycopy(ohashes, 0, mHashes, 0, mSize);
                System.arraycopy(oarray, 0, mArray, 0, mSize<<1);
            }
            freeArrays(ohashes, oarray, mSize);
        }
    }

    /**
     * Check whether a key exists in the array.
     *
     * @param key The key to search for.
     * @return Returns true if the key exists, else false.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.565 -0400", hash_original_method = "FE50170C6E9B5F6E23D039E9F1C0F9A6", hash_generated_method = "E5F2AB62762346A4AF55168101F6229C")
    
public boolean containsKey(Object key) {
        return key == null ? (indexOfNull() >= 0) : (indexOf(key, key.hashCode()) >= 0);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.569 -0400", hash_original_method = "0C4D12D0B2AB19F9897899616C77750E", hash_generated_method = "0C4D12D0B2AB19F9897899616C77750E")
    
int indexOfValue(Object value) {
        final int N = mSize*2;
        final Object[] array = mArray;
        if (value == null) {
            for (int i=1; i<N; i+=2) {
                if (array[i] == null) {
                    return i>>1;
                }
            }
        } else {
            for (int i=1; i<N; i+=2) {
                if (value.equals(array[i])) {
                    return i>>1;
                }
            }
        }
        return -1;
    }

    /**
     * Check whether a value exists in the array.  This requires a linear search
     * through the entire array.
     *
     * @param value The value to search for.
     * @return Returns true if the value exists, else false.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.573 -0400", hash_original_method = "865E5C3BA09922B2D2CC59AD7D677871", hash_generated_method = "EA423ECBD3F35350F55C578F5F215162")
    
public boolean containsValue(Object value) {
        return indexOfValue(value) >= 0;
    }

    /**
     * Retrieve a value from the array.
     * @param key The key of the value to retrieve.
     * @return Returns the value associated with the given key,
     * or null if there is no such key.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.577 -0400", hash_original_method = "F4147250FFB8E0057FC4F7B21039E29E", hash_generated_method = "D280C7EE974ECE378AA11D733CF2002B")
    
public V get(Object key) {
        final int index = key == null ? indexOfNull() : indexOf(key, key.hashCode());
        return index >= 0 ? (V)mArray[(index<<1)+1] : null;
    }

    /**
     * Return the key at the given index in the array.
     * @param index The desired index, must be between 0 and {@link #size()}-1.
     * @return Returns the key stored at the given index.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.582 -0400", hash_original_method = "943099AB2885A4BDD8B9C646B5F94275", hash_generated_method = "9B4C3F6F3E948F433E0CB6833B663B3A")
    
public K keyAt(int index) {
        return (K)mArray[index << 1];
    }

    /**
     * Return the value at the given index in the array.
     * @param index The desired index, must be between 0 and {@link #size()}-1.
     * @return Returns the value stored at the given index.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.588 -0400", hash_original_method = "C68F9C1CA0ECDC5E3EA9380F963B92A4", hash_generated_method = "B7EB395BBA2A6FD76A1273DB5A773C28")
    
public V valueAt(int index) {
        return (V)mArray[(index << 1) + 1];
    }

    /**
     * Set the value at a given index in the array.
     * @param index The desired index, must be between 0 and {@link #size()}-1.
     * @param value The new value to store at this index.
     * @return Returns the previous value at the given index.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.592 -0400", hash_original_method = "B02392C48FFF6B3C28B3112109C950FE", hash_generated_method = "DE6C44054C568937985AFE7C8841D3C5")
    
public V setValueAt(int index, V value) {
        index = (index << 1) + 1;
        V old = (V)mArray[index];
        mArray[index] = value;
        return old;
    }

    /**
     * Return true if the array map contains no items.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.596 -0400", hash_original_method = "119D5908F9AFB28EF70EEC655725E14A", hash_generated_method = "90FC14C3CF6E4C64E9D1E4746566671A")
    
public boolean isEmpty() {
        return mSize <= 0;
    }

    /**
     * Add a new value to the array map.
     * @param key The key under which to store the value.  <b>Must not be null.</b>  If
     * this key already exists in the array, its value will be replaced.
     * @param value The value to store for the given key.
     * @return Returns the old value that was stored for the given key, or null if there
     * was no such key.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.602 -0400", hash_original_method = "B38C6295CAE53BA65E4DF4CF73E69F95", hash_generated_method = "70138DD998A7B872A142DD51EF913EA7")
    
public V put(K key, V value) {
        final int hash;
        int index;
        if (key == null) {
            hash = 0;
            index = indexOfNull();
        } else {
            hash = key.hashCode();
            index = indexOf(key, hash);
        }
        if (index >= 0) {
            index = (index<<1) + 1;
            final V old = (V)mArray[index];
            mArray[index] = value;
            return old;
        }

        index = ~index;
        if (mSize >= mHashes.length) {
            final int n = mSize >= (BASE_SIZE*2) ? (mSize+(mSize>>1))
                    : (mSize >= BASE_SIZE ? (BASE_SIZE*2) : BASE_SIZE);

            if (DEBUG) Log.d(TAG, "put: grow from " + mHashes.length + " to " + n);

            final int[] ohashes = mHashes;
            final Object[] oarray = mArray;
            allocArrays(n);

            if (mHashes.length > 0) {
                if (DEBUG) Log.d(TAG, "put: copy 0-" + mSize + " to 0");
                System.arraycopy(ohashes, 0, mHashes, 0, ohashes.length);
                System.arraycopy(oarray, 0, mArray, 0, oarray.length);
            }

            freeArrays(ohashes, oarray, mSize);
        }

        if (index < mSize) {
            if (DEBUG) Log.d(TAG, "put: move " + index + "-" + (mSize-index)
                    + " to " + (index+1));
            System.arraycopy(mHashes, index, mHashes, index + 1, mSize - index);
            System.arraycopy(mArray, index << 1, mArray, (index + 1) << 1, (mSize - index) << 1);
        }

        mHashes[index] = hash;
        mArray[index<<1] = key;
        mArray[(index<<1)+1] = value;
        mSize++;
        return null;
    }

    /**
     * Perform a {@link #put(Object, Object)} of all key/value pairs in <var>array</var>
     * @param array The array whose contents are to be retrieved.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.606 -0400", hash_original_method = "AAAE48FCAFBB59B6194134EC5A32BF70", hash_generated_method = "837970D3A2951748EA32AE8DB8945A9D")
    
public void putAll(SimpleArrayMap<? extends K, ? extends V> array) {
        final int N = array.mSize;
        ensureCapacity(mSize + N);
        if (mSize == 0) {
            if (N > 0) {
                System.arraycopy(array.mHashes, 0, mHashes, 0, N);
                System.arraycopy(array.mArray, 0, mArray, 0, N<<1);
                mSize = N;
            }
        } else {
            for (int i=0; i<N; i++) {
                put(array.keyAt(i), array.valueAt(i));
            }
        }
    }

    /**
     * Remove an existing key from the array map.
     * @param key The key of the mapping to remove.
     * @return Returns the value that was stored under the key, or null if there
     * was no such key.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.610 -0400", hash_original_method = "676C0A638DA8EF39748E2163ADEF98DA", hash_generated_method = "C632400BF56BB1F2E34FC2D1096C579B")
    
public V remove(Object key) {
        int index = key == null ? indexOfNull() : indexOf(key, key.hashCode());
        if (index >= 0) {
            return removeAt(index);
        }

        return null;
    }

    /**
     * Remove the key/value mapping at the given index.
     * @param index The desired index, must be between 0 and {@link #size()}-1.
     * @return Returns the value that was stored at this index.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.616 -0400", hash_original_method = "B60560CE6362D056056BD3B06A5B4503", hash_generated_method = "A79A8914298914F4D41BD6986C6163EA")
    
public V removeAt(int index) {
        final Object old = mArray[(index << 1) + 1];
        if (mSize <= 1) {
            // Now empty.
            if (DEBUG) Log.d(TAG, "remove: shrink from " + mHashes.length + " to 0");
            freeArrays(mHashes, mArray, mSize);
            mHashes = ContainerHelpers.EMPTY_INTS;
            mArray = ContainerHelpers.EMPTY_OBJECTS;
            mSize = 0;
        } else {
            if (mHashes.length > (BASE_SIZE*2) && mSize < mHashes.length/3) {
                // Shrunk enough to reduce size of arrays.  We don't allow it to
                // shrink smaller than (BASE_SIZE*2) to avoid flapping between
                // that and BASE_SIZE.
                final int n = mSize > (BASE_SIZE*2) ? (mSize + (mSize>>1)) : (BASE_SIZE*2);

                if (DEBUG) Log.d(TAG, "remove: shrink from " + mHashes.length + " to " + n);

                final int[] ohashes = mHashes;
                final Object[] oarray = mArray;
                allocArrays(n);

                mSize--;
                if (index > 0) {
                    if (DEBUG) Log.d(TAG, "remove: copy from 0-" + index + " to 0");
                    System.arraycopy(ohashes, 0, mHashes, 0, index);
                    System.arraycopy(oarray, 0, mArray, 0, index << 1);
                }
                if (index < mSize) {
                    if (DEBUG) Log.d(TAG, "remove: copy from " + (index+1) + "-" + mSize
                            + " to " + index);
                    System.arraycopy(ohashes, index + 1, mHashes, index, mSize - index);
                    System.arraycopy(oarray, (index + 1) << 1, mArray, index << 1,
                            (mSize - index) << 1);
                }
            } else {
                mSize--;
                if (index < mSize) {
                    if (DEBUG) Log.d(TAG, "remove: move " + (index+1) + "-" + mSize
                            + " to " + index);
                    System.arraycopy(mHashes, index + 1, mHashes, index, mSize - index);
                    System.arraycopy(mArray, (index + 1) << 1, mArray, index << 1,
                            (mSize - index) << 1);
                }
                mArray[mSize << 1] = null;
                mArray[(mSize << 1) + 1] = null;
            }
        }
        return (V)old;
    }

    /**
     * Return the number of items in this array map.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.619 -0400", hash_original_method = "9550C69BAA91C5298BA75D226127D5FF", hash_generated_method = "D1146B99C52208B28E4F9EC1242180A7")
    
public int size() {
        return mSize;
    }

    /**
     * {@inheritDoc}
     *
     * <p>This implementation returns false if the object is not a map, or
     * if the maps have different sizes. Otherwise, for each key in this map,
     * values of both maps are compared. If the values for any key are not
     * equal, the method returns false, otherwise it returns true.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.624 -0400", hash_original_method = "600CF8179180C586440A53D82C1F6217", hash_generated_method = "5203B8FF6AF41420301DADF7C14DBDB9")
    
@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) object;
            if (size() != map.size()) {
                return false;
            }

            try {
                for (int i=0; i<mSize; i++) {
                    K key = keyAt(i);
                    V mine = valueAt(i);
                    Object theirs = map.get(key);
                    if (mine == null) {
                        if (theirs != null || !map.containsKey(key)) {
                            return false;
                        }
                    } else if (!mine.equals(theirs)) {
                        return false;
                    }
                }
            } catch (NullPointerException ignored) {
                return false;
            } catch (ClassCastException ignored) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.629 -0400", hash_original_method = "D146F98A429A5E1B4E0EF53309D53AB3", hash_generated_method = "0CD220004109FECD3257B85DA9394C82")
    
@Override
    public int hashCode() {
        final int[] hashes = mHashes;
        final Object[] array = mArray;
        int result = 0;
        for (int i = 0, v = 1, s = mSize; i < s; i++, v+=2) {
            Object value = array[v];
            result += hashes[i] ^ (value == null ? 0 : value.hashCode());
        }
        return result;
    }

    /**
     * {@inheritDoc}
     *
     * <p>This implementation composes a string by iterating over its mappings. If
     * this map contains itself as a key or a value, the string "(this Map)"
     * will appear in its place.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:23.633 -0400", hash_original_method = "91DC7E539B05087C0C28289F68FAF563", hash_generated_method = "B572EFA506622D92D1E321EE2E3E26CB")
    
@Override
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }

        StringBuilder buffer = new StringBuilder(mSize * 28);
        buffer.append('{');
        for (int i=0; i<mSize; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            Object key = keyAt(i);
            if (key != this) {
                buffer.append(key);
            } else {
                buffer.append("(this Map)");
            }
            buffer.append('=');
            Object value = valueAt(i);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Map)");
            }
        }
        buffer.append('}');
        return buffer.toString();
    }
}

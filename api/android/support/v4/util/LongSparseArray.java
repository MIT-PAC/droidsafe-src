/*
 * Copyright (C) 2009 The Android Open Source Project
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

/**
 * SparseArray mapping longs to Objects.  Unlike a normal array of Objects,
 * there can be gaps in the indices.  It is intended to be more efficient
 * than using a HashMap to map Longs to Objects.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
public class LongSparseArray<E> implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.343 -0500", hash_original_field = "3DBE75CD3847B615A3748344C30DB0A6", hash_generated_field = "FCFA6BA9119CC3C1F3EE77ED9D99A0CB")

    private static final Object DELETED = new Object();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.376 -0500", hash_original_method = "5D31A3D7A0E67E45752AFCF3D2F00D3F", hash_generated_method = "5EFDA50F3246D2A60070817B5CA38C18")
    
private static int binarySearch(long[] a, int start, int len, long key) {
        int high = start + len, low = start - 1, guess;

        while (high - low > 1) {
            guess = (high + low) / 2;

            if (a[guess] < key)
                low = guess;
            else
                high = guess;
        }

        if (high == start + len)
            return ~(start + len);
        else if (a[high] == key)
            return high;
        else
            return ~high;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.377 -0500", hash_original_method = "78F4782A9945BD922AE4F703F6706A7E", hash_generated_method = "476E3135F747B27C638A7747394DD781")
    
public static int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++)
            if (need <= (1 << i) - 12)
                return (1 << i) - 12;

        return need;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.379 -0500", hash_original_method = "81E7FAA327416436814745B8BDC163E2", hash_generated_method = "7A7A55B2D3E16E87C86D175661E4F019")
    
public static int idealLongArraySize(int need) {
        return idealByteArraySize(need * 8) / 8;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.344 -0500", hash_original_field = "F7CE00CBAE369ABF1B3EF35E26DE59C6", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.345 -0500", hash_original_field = "7F71001B36E5A98550DE3229F909BE4A", hash_generated_field = "10A03D33DDA7196CABEC9D15EF00ADBE")


    private long[] mKeys;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.346 -0500", hash_original_field = "D3F28F3EBFA7D0D8D614CF293C7CCCA8", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.347 -0500", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;

    /**
     * Creates a new LongSparseArray containing no mappings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.349 -0500", hash_original_method = "F893922E2C2E4CF6AF95C190516DB394", hash_generated_method = "FDE8D96477E28E3BDD367BAF0ED08001")
    
public LongSparseArray() {
        this(10);
    }

    /**
     * Creates a new LongSparseArray containing no mappings that will not
     * require any additional memory allocation to store the specified
     * number of mappings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.351 -0500", hash_original_method = "16D402CE6C8A18B31360BC5A64438993", hash_generated_method = "587E26B484264A00B9E32E86B75AB1CC")
    
public LongSparseArray(int initialCapacity) {
        initialCapacity = idealLongArraySize(initialCapacity);

        mKeys = new long[initialCapacity];
        mValues = new Object[initialCapacity];
        mSize = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.352 -0500", hash_original_method = "BABF4C30E15FB15D68E2A1BD6E5F56F5", hash_generated_method = "9A75D1F05BA6340C82FBD3F7FACBF332")
    
@Override
    @SuppressWarnings("unchecked")
    public LongSparseArray<E> clone() {
        LongSparseArray<E> clone = null;
        try {
            clone = (LongSparseArray<E>) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } catch (CloneNotSupportedException cnse) {
            /* ignore */
        }
        return clone;
    }

    /**
     * Gets the Object mapped from the specified key, or <code>null</code>
     * if no such mapping has been made.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.353 -0500", hash_original_method = "4371A69A3700205284573EEAA3E6B17F", hash_generated_method = "32538B9F100C37D1DA2550D390ED9059")
    
public E get(long key) {
        return get(key, null);
    }

    /**
     * Gets the Object mapped from the specified key, or the specified Object
     * if no such mapping has been made.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.355 -0500", hash_original_method = "E2D85B672251F3A6432F3D64B14D09C9", hash_generated_method = "D8D203FBF66AB3483D8033296DCAA26C")
    
@SuppressWarnings("unchecked")
    public E get(long key, E valueIfKeyNotFound) {
        int i = binarySearch(mKeys, 0, mSize, key);

        if (i < 0 || mValues[i] == DELETED) {
            return valueIfKeyNotFound;
        } else {
            return (E) mValues[i];
        }
    }

    /**
     * Removes the mapping from the specified key, if there was any.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.356 -0500", hash_original_method = "D6F064C21D8F72C9BE34FD8563F8D233", hash_generated_method = "C03CE451C689F3424295E47270350D88")
    
public void delete(long key) {
        int i = binarySearch(mKeys, 0, mSize, key);

        if (i >= 0) {
            if (mValues[i] != DELETED) {
                mValues[i] = DELETED;
                mGarbage = true;
            }
        }
    }

    /**
     * Alias for {@link #delete(long)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.357 -0500", hash_original_method = "A104FD86A71D431024F36E7E390CA038", hash_generated_method = "C4C5A91321438687966034DCD746AD3A")
    
public void remove(long key) {
        delete(key);
    }

    /**
     * Removes the mapping at the specified index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.358 -0500", hash_original_method = "1992218C2CA2A9A793E8A4995C16BACA", hash_generated_method = "64D74600A863EF1A66C3817EBCC9190A")
    
public void removeAt(int index) {
        if (mValues[index] != DELETED) {
            mValues[index] = DELETED;
            mGarbage = true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.360 -0500", hash_original_method = "DEC4F7080CE57358296ADF6582B59DD8", hash_generated_method = "7806AAC0088B5C739FB850F524F950C1")
    
private void gc() {
        // Log.e("SparseArray", "gc start with " + mSize);

        int n = mSize;
        int o = 0;
        long[] keys = mKeys;
        Object[] values = mValues;

        for (int i = 0; i < n; i++) {
            Object val = values[i];

            if (val != DELETED) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
                    values[i] = null;
                }

                o++;
            }
        }

        mGarbage = false;
        mSize = o;

        // Log.e("SparseArray", "gc end with " + mSize);
    }

    /**
     * Adds a mapping from the specified key to the specified value,
     * replacing the previous mapping from the specified key if there
     * was one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.362 -0500", hash_original_method = "8BF7664EE3AA81913FF5A6B556936B07", hash_generated_method = "318A49A0E5FDA97B4DA702E8D551630F")
    
public void put(long key, E value) {
        int i = binarySearch(mKeys, 0, mSize, key);

        if (i >= 0) {
            mValues[i] = value;
        } else {
            i = ~i;

            if (i < mSize && mValues[i] == DELETED) {
                mKeys[i] = key;
                mValues[i] = value;
                return;
            }

            if (mGarbage && mSize >= mKeys.length) {
                gc();

                // Search again because indices may have changed.
                i = ~binarySearch(mKeys, 0, mSize, key);
            }

            if (mSize >= mKeys.length) {
                int n = idealLongArraySize(mSize + 1);

                long[] nkeys = new long[n];
                Object[] nvalues = new Object[n];

                // Log.e("SparseArray", "grow " + mKeys.length + " to " + n);
                System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
                System.arraycopy(mValues, 0, nvalues, 0, mValues.length);

                mKeys = nkeys;
                mValues = nvalues;
            }

            if (mSize - i != 0) {
                // Log.e("SparseArray", "move " + (mSize - i));
                System.arraycopy(mKeys, i, mKeys, i + 1, mSize - i);
                System.arraycopy(mValues, i, mValues, i + 1, mSize - i);
            }

            mKeys[i] = key;
            mValues[i] = value;
            mSize++;
        }
    }

    /**
     * Returns the number of key-value mappings that this LongSparseArray
     * currently stores.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.364 -0500", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "DE82729ACB015F73FA05A44E77A4C535")
    
public int size() {
        if (mGarbage) {
            gc();
        }

        return mSize;
    }

    /**
     * Given an index in the range <code>0...size()-1</code>, returns
     * the key from the <code>index</code>th key-value mapping that this
     * LongSparseArray stores.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.366 -0500", hash_original_method = "B1F6BB5033A022FAFBEA87494F8412EB", hash_generated_method = "F555FC379CC33F661BA067D214FC3E04")
    
public long keyAt(int index) {
        if (mGarbage) {
            gc();
        }

        return mKeys[index];
    }

    /**
     * Given an index in the range <code>0...size()-1</code>, returns
     * the value from the <code>index</code>th key-value mapping that this
     * LongSparseArray stores.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.367 -0500", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "C93A647BB0F30DB0291E96149968A997")
    
@SuppressWarnings("unchecked")
    public E valueAt(int index) {
        if (mGarbage) {
            gc();
        }

        return (E) mValues[index];
    }

    /**
     * Given an index in the range <code>0...size()-1</code>, sets a new
     * value for the <code>index</code>th key-value mapping that this
     * LongSparseArray stores.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.368 -0500", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "7A845630E6D6556C2A9509C60FAF897D")
    
public void setValueAt(int index, E value) {
        if (mGarbage) {
            gc();
        }

        mValues[index] = value;
    }

    /**
     * Returns the index for which {@link #keyAt} would return the
     * specified key, or a negative number if the specified
     * key is not mapped.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.370 -0500", hash_original_method = "09C66188F9324AB9196B3AD659514994", hash_generated_method = "B02C58849364DD0F111F13A41736CF34")
    
public int indexOfKey(long key) {
        if (mGarbage) {
            gc();
        }

        return binarySearch(mKeys, 0, mSize, key);
    }

    /**
     * Returns an index for which {@link #valueAt} would return the
     * specified key, or a negative number if no keys map to the
     * specified value.
     * Beware that this is a linear search, unlike lookups by key,
     * and that multiple keys can map to the same value and this will
     * find only one of them.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.372 -0500", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "145E5383CC31DEB2B3D8802044F1BAA2")
    
public int indexOfValue(E value) {
        if (mGarbage) {
            gc();
        }

        for (int i = 0; i < mSize; i++)
            if (mValues[i] == value)
                return i;

        return -1;
    }

    /**
     * Removes all key-value mappings from this LongSparseArray.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.373 -0500", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "BEA9506A49791E09E851664F93E1DBF1")
    
public void clear() {
        int n = mSize;
        Object[] values = mValues;

        for (int i = 0; i < n; i++) {
            values[i] = null;
        }

        mSize = 0;
        mGarbage = false;
    }

    /**
     * Puts a key/value pair into the array, optimizing for the case where
     * the key is greater than all existing keys in the array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:40.375 -0500", hash_original_method = "4795393F1D971B9D48A1020105C314CF", hash_generated_method = "10CC6D7619BABD67BC8ED71DFE8AAAC6")
    
public void append(long key, E value) {
        if (mSize != 0 && key <= mKeys[mSize - 1]) {
            put(key, value);
            return;
        }

        if (mGarbage && mSize >= mKeys.length) {
            gc();
        }

        int pos = mSize;
        if (pos >= mKeys.length) {
            int n = idealLongArraySize(pos + 1);

            long[] nkeys = new long[n];
            Object[] nvalues = new Object[n];

            // Log.e("SparseArray", "grow " + mKeys.length + " to " + n);
            System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
            System.arraycopy(mValues, 0, nvalues, 0, mValues.length);

            mKeys = nkeys;
            mValues = nvalues;
        }

        mKeys[pos] = key;
        mValues[pos] = value;
        mSize = pos + 1;
    }
}

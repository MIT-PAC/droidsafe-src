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
 * Copyright (C) 2011 The Android Open Source Project
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


package android.support.v4.app;

/**
 * A copy of Honeycomb's {@link android.util.SparseArray}, that
 * provides a removeAt() method.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
class HCSparseArray<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.373 -0500", hash_original_field = "3DBE75CD3847B615A3748344C30DB0A6", hash_generated_field = "FCFA6BA9119CC3C1F3EE77ED9D99A0CB")

    private static final Object DELETED = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.463 -0500", hash_original_method = "7DB5AA23E16883217822FBC6D13669D2", hash_generated_method = "FEB35469F5B9E3BA231D8C8D51EF0135")
    
private static int binarySearch(int[] a, int start, int len, int key) {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.465 -0500", hash_original_method = "78F4782A9945BD922AE4F703F6706A7E", hash_generated_method = "B882F8244F97164E1A58459C59541F76")
    
static int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++)
            if (need <= (1 << i) - 12)
                return (1 << i) - 12;

        return need;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.467 -0500", hash_original_method = "C5D38D95B60B446AE8BAAF7982426E2B", hash_generated_method = "62DCA05F0054FCC37EAAC319A156AB93")
    
static int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.375 -0500", hash_original_field = "F7CE00CBAE369ABF1B3EF35E26DE59C6", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.470 -0500", hash_original_field = "904D0E6EB4847EA02E1703FDE76AE0FF", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")
    
    private int[] mKeys;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.473 -0500", hash_original_field = "D3F28F3EBFA7D0D8D614CF293C7CCCA8", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.475 -0500", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;

    /**
     * Creates a new SparseArray containing no mappings.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.378 -0500", hash_original_method = "22E432D55E87D9B082CFCE15ABC7A111", hash_generated_method = "4B41BA1002EC2475651508F5034D86F3")
    
public HCSparseArray() {
        this(10);
    }

    /**
     * Creates a new SparseArray containing no mappings that will not
     * require any additional memory allocation to store the specified
     * number of mappings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.380 -0500", hash_original_method = "A84A980EFFBE26E04B3C2E4EFBE3FAD0", hash_generated_method = "3FF522729320B6BF649625F844AC9520")
    
public HCSparseArray(int initialCapacity) {
        initialCapacity = idealIntArraySize(initialCapacity);

        mKeys = new int[initialCapacity];
        mValues = new Object[initialCapacity];
        mSize = 0;
    }

    /**
     * Gets the Object mapped from the specified key, or <code>null</code>
     * if no such mapping has been made.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.381 -0500", hash_original_method = "63029C5D60DB5A1F0C43DA1A71993094", hash_generated_method = "A7652660538AB6B2764F0F7687491E4B")
    
public E get(int key) {
        return get(key, null);
    }

    /**
     * Gets the Object mapped from the specified key, or the specified Object
     * if no such mapping has been made.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.384 -0500", hash_original_method = "C9E62D05249D95E7C50A204FF58AB455", hash_generated_method = "BA8F26CD51295D8DC29598C253FC1932")
    
public E get(int key, E valueIfKeyNotFound) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.387 -0500", hash_original_method = "D16C073A10FD3671AE05EBC49E38DA17", hash_generated_method = "80887C79768229A316C39532A8C6419F")
    
public void delete(int key) {
        int i = binarySearch(mKeys, 0, mSize, key);

        if (i >= 0) {
            if (mValues[i] != DELETED) {
                mValues[i] = DELETED;
                mGarbage = true;
            }
        }
    }

    /**
     * Alias for {@link #delete(int)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.388 -0500", hash_original_method = "EE51F875218CA8C1C2C8959A48F2A4BB", hash_generated_method = "C7FFA05DD1740D5D19664E20B4CEE216")
    
public void remove(int key) {
        delete(key);
    }

    /**
     * Removes the mapping at the specified index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.390 -0500", hash_original_method = "1992218C2CA2A9A793E8A4995C16BACA", hash_generated_method = "64D74600A863EF1A66C3817EBCC9190A")
    
public void removeAt(int index) {
        if (mValues[index] != DELETED) {
            mValues[index] = DELETED;
            mGarbage = true;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.393 -0500", hash_original_method = "7868047E3541D358CB50D9A842861F65", hash_generated_method = "83C61FF7853C3689F47327323B6A23E5")
    
private void gc() {
        // Log.e("SparseArray", "gc start with " + mSize);

        int n = mSize;
        int o = 0;
        int[] keys = mKeys;
        Object[] values = mValues;

        for (int i = 0; i < n; i++) {
            Object val = values[i];

            if (val != DELETED) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.398 -0500", hash_original_method = "954FE01203E8E0B89D8DDB8D29119B01", hash_generated_method = "EC6AADF753D5966CC946C3ECD22E2424")
    
public void put(int key, E value) {
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
                int n = idealIntArraySize(mSize + 1);

                int[] nkeys = new int[n];
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
     * Returns the number of key-value mappings that this SparseArray
     * currently stores.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.401 -0500", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "DE82729ACB015F73FA05A44E77A4C535")
    
public int size() {
        if (mGarbage) {
            gc();
        }

        return mSize;
    }

    /**
     * Given an index in the range <code>0...size()-1</code>, returns
     * the key from the <code>index</code>th key-value mapping that this
     * SparseArray stores.  
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.403 -0500", hash_original_method = "AD3650995583655A8D059B5C8CE85FAD", hash_generated_method = "366CF084EB99511539C960AAB90DA5DB")
    
public int keyAt(int index) {
        if (mGarbage) {
            gc();
        }

        return mKeys[index];
    }
    
    /**
     * Given an index in the range <code>0...size()-1</code>, returns
     * the value from the <code>index</code>th key-value mapping that this
     * SparseArray stores.  
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.405 -0500", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "CBC4E30F7778F15DECD755991AE421F6")
    
public E valueAt(int index) {
        if (mGarbage) {
            gc();
        }

        return (E) mValues[index];
    }

    /**
     * Given an index in the range <code>0...size()-1</code>, sets a new
     * value for the <code>index</code>th key-value mapping that this
     * SparseArray stores.  
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.407 -0500", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "7A845630E6D6556C2A9509C60FAF897D")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.409 -0500", hash_original_method = "2AE05DC6F4A524A5C2D1FCD4B3573FB7", hash_generated_method = "E89EF5B21BDA47A9D7B7079CAA41EA4A")
    
public int indexOfKey(int key) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.410 -0500", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "145E5383CC31DEB2B3D8802044F1BAA2")
    
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
     * Removes all key-value mappings from this SparseArray.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.413 -0500", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "BEA9506A49791E09E851664F93E1DBF1")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:12.451 -0500", hash_original_method = "9C68345D80E74B8E583DD83B51C68973", hash_generated_method = "23CE4BE721FB71F983A94D76D7BC97E8")
    
public void append(int key, E value) {
        if (mSize != 0 && key <= mKeys[mSize - 1]) {
            put(key, value);
            return;
        }

        if (mGarbage && mSize >= mKeys.length) {
            gc();
        }

        int pos = mSize;
        if (pos >= mKeys.length) {
            int n = idealIntArraySize(pos + 1);

            int[] nkeys = new int[n];
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

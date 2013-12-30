package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import com.android.internal.util.ArrayUtils;






public class LongSparseArray<E> {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.477 -0500", hash_original_method = "5D31A3D7A0E67E45752AFCF3D2F00D3F", hash_generated_method = "5EFDA50F3246D2A60070817B5CA38C18")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.424 -0500", hash_original_field = "3DBE75CD3847B615A3748344C30DB0A6", hash_generated_field = "FCFA6BA9119CC3C1F3EE77ED9D99A0CB")

    private static final Object DELETED = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.426 -0500", hash_original_field = "F7CE00CBAE369ABF1B3EF35E26DE59C6", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.482 -0500", hash_original_field = "7F71001B36E5A98550DE3229F909BE4A", hash_generated_field = "10A03D33DDA7196CABEC9D15EF00ADBE")


    private long[] mKeys;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.484 -0500", hash_original_field = "D3F28F3EBFA7D0D8D614CF293C7CCCA8", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.487 -0500", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;

    /**
     * Creates a new SparseArray containing no mappings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.428 -0500", hash_original_method = "F893922E2C2E4CF6AF95C190516DB394", hash_generated_method = "FDE8D96477E28E3BDD367BAF0ED08001")
    
public LongSparseArray() {
        this(10);
    }

    /**
     * Creates a new SparseArray containing no mappings that will not
     * require any additional memory allocation to store the specified
     * number of mappings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.431 -0500", hash_original_method = "69FE78AD0B4200050B3EDA46329CEBED", hash_generated_method = "BFE6F106A50CB2C5C0AAB90CBC00F5C7")
    
public LongSparseArray(int initialCapacity) {
        initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);

        mKeys = new long[initialCapacity];
        mValues = new Object[initialCapacity];
        mSize = 0;
    }
    
    /**
     * @return A copy of all keys contained in the sparse array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.433 -0500", hash_original_method = "9447795B515DAD767A419A6C51E84D78", hash_generated_method = "12A7D107FF5874246C8CDF642E279C93")
    
public long[] getKeys() {
        int length = mKeys.length;
        long[] result = new long[length];
        System.arraycopy(mKeys, 0, result, 0, length);
        return result;
    }
    
    /**
     * Sets all supplied keys to the given unique value.
     * @param keys Keys to set
     * @param uniqueValue Value to set all supplied keys to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.436 -0500", hash_original_method = "F8E34621620A1E3C4828967422EF7D07", hash_generated_method = "6D77984ED4792E9DA75C2836FF0EBB89")
    
public void setValues(long[] keys, E uniqueValue) {
        int length = keys.length;
        for (int i = 0; i < length; i++) {
            put(keys[i], uniqueValue);
        }
    }

    /**
     * Gets the Object mapped from the specified key, or <code>null</code>
     * if no such mapping has been made.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.438 -0500", hash_original_method = "4371A69A3700205284573EEAA3E6B17F", hash_generated_method = "32538B9F100C37D1DA2550D390ED9059")
    
public E get(long key) {
        return get(key, null);
    }

    /**
     * Gets the Object mapped from the specified key, or the specified Object
     * if no such mapping has been made.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.441 -0500", hash_original_method = "E2D85B672251F3A6432F3D64B14D09C9", hash_generated_method = "686647A208F500FFED9220521975E6B3")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.443 -0500", hash_original_method = "D6F064C21D8F72C9BE34FD8563F8D233", hash_generated_method = "C03CE451C689F3424295E47270350D88")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.445 -0500", hash_original_method = "A104FD86A71D431024F36E7E390CA038", hash_generated_method = "C4C5A91321438687966034DCD746AD3A")
    
public void remove(long key) {
        delete(key);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.448 -0500", hash_original_method = "A9D8FA819E144A31281F443F869190B4", hash_generated_method = "D9BD76CDF6AE36B9E0F94DDE7526E423")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.451 -0500", hash_original_method = "A67B583D0E7AD982D1504BFCE2629D2E", hash_generated_method = "FF4C9CE0D607B3031AB0E0754CA3230A")
    
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
                int n = ArrayUtils.idealIntArraySize(mSize + 1);

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
     * Returns the number of key-value mappings that this SparseArray
     * currently stores.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.453 -0500", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "DE82729ACB015F73FA05A44E77A4C535")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.456 -0500", hash_original_method = "B1F6BB5033A022FAFBEA87494F8412EB", hash_generated_method = "F555FC379CC33F661BA067D214FC3E04")
    
public long keyAt(int index) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.459 -0500", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "CBC4E30F7778F15DECD755991AE421F6")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.462 -0500", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "7A845630E6D6556C2A9509C60FAF897D")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.465 -0500", hash_original_method = "09C66188F9324AB9196B3AD659514994", hash_generated_method = "B02C58849364DD0F111F13A41736CF34")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.468 -0500", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "145E5383CC31DEB2B3D8802044F1BAA2")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.470 -0500", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "BEA9506A49791E09E851664F93E1DBF1")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.473 -0500", hash_original_method = "0B04A70E2C13FA00A3C14F0564BE387C", hash_generated_method = "CD28D606709EB3935A41ED96F79479D8")
    
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
            int n = ArrayUtils.idealIntArraySize(pos + 1);

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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.480 -0500", hash_original_method = "B88BEB15E15C0A7F30A2606914985D6D", hash_generated_method = "4F1D3C2A86A114558AFCB9938D7483E2")
    
private void checkIntegrity() {
        for (int i = 1; i < mSize; i++) {
            if (mKeys[i] <= mKeys[i - 1]) {
                for (int j = 0; j < mSize; j++) {
                    Log.e("FAIL", j + ": " + mKeys[j] + " -> " + mValues[j]);
                }

                throw new RuntimeException();
            }
        }
    }
}


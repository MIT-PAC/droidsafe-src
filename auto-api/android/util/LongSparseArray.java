package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.util.ArrayUtils;

public class LongSparseArray<E> {
    private static final Object DELETED = new Object();
    private boolean mGarbage = false;
    private long[] mKeys;
    private Object[] mValues;
    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.622 -0400", hash_original_method = "F893922E2C2E4CF6AF95C190516DB394", hash_generated_method = "19DF3BF1B2A261B877767D7590B370FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LongSparseArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.622 -0400", hash_original_method = "69FE78AD0B4200050B3EDA46329CEBED", hash_generated_method = "AEDA83169F40C128D1DA02ECFC95D23A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LongSparseArray(int initialCapacity) {
        dsTaint.addTaint(initialCapacity);
        initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        mKeys = new long[initialCapacity];
        mValues = new Object[initialCapacity];
        mSize = 0;
        // ---------- Original Method ----------
        //initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        //mKeys = new long[initialCapacity];
        //mValues = new Object[initialCapacity];
        //mSize = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.622 -0400", hash_original_method = "9447795B515DAD767A419A6C51E84D78", hash_generated_method = "9EA26F3038594B5B359F2B30BAA63BFA")
    @DSModeled(DSC.SAFE)
    public long[] getKeys() {
        int length;
        length = mKeys.length;
        long[] result;
        result = new long[length];
        System.arraycopy(mKeys, 0, result, 0, length);
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //int length = mKeys.length;
        //long[] result = new long[length];
        //System.arraycopy(mKeys, 0, result, 0, length);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.622 -0400", hash_original_method = "F8E34621620A1E3C4828967422EF7D07", hash_generated_method = "77AB947BA921C231FE2B3CD7BA23A8E4")
    @DSModeled(DSC.SAFE)
    public void setValues(long[] keys, E uniqueValue) {
        dsTaint.addTaint(keys);
        dsTaint.addTaint(uniqueValue.dsTaint);
        int length;
        length = keys.length;
        {
            int i;
            i = 0;
            {
                put(keys[i], uniqueValue);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int length = keys.length;
        //for (int i = 0; i < length; i++) {
            //put(keys[i], uniqueValue);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.622 -0400", hash_original_method = "4371A69A3700205284573EEAA3E6B17F", hash_generated_method = "7F6FFF16F84F9A6E63E3CB7CA9CBA737")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E get(long key) {
        dsTaint.addTaint(key);
        E var2D4BC10AF814DB6E28CC507D53A17135_1513314194 = (get(key, null));
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.623 -0400", hash_original_method = "E2D85B672251F3A6432F3D64B14D09C9", hash_generated_method = "826731C3CF92B624597E00905C77A44D")
    @DSModeled(DSC.SAFE)
    public E get(long key, E valueIfKeyNotFound) {
        dsTaint.addTaint(valueIfKeyNotFound.dsTaint);
        dsTaint.addTaint(key);
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0 || mValues[i] == DELETED) {
            //return valueIfKeyNotFound;
        //} else {
            //return (E) mValues[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.623 -0400", hash_original_method = "D6F064C21D8F72C9BE34FD8563F8D233", hash_generated_method = "C7BA585FC04523960CCA4BE225403DCF")
    @DSModeled(DSC.SAFE)
    public void delete(long key) {
        dsTaint.addTaint(key);
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            {
                mValues[i] = DELETED;
                mGarbage = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i >= 0) {
            //if (mValues[i] != DELETED) {
                //mValues[i] = DELETED;
                //mGarbage = true;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.623 -0400", hash_original_method = "A104FD86A71D431024F36E7E390CA038", hash_generated_method = "5D0E890E5F338B709C1560B63A1EE21A")
    @DSModeled(DSC.SAFE)
    public void remove(long key) {
        dsTaint.addTaint(key);
        delete(key);
        // ---------- Original Method ----------
        //delete(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.623 -0400", hash_original_method = "A9D8FA819E144A31281F443F869190B4", hash_generated_method = "217E11C0AF5A3DD4F6C67AE765D92B88")
    @DSModeled(DSC.SAFE)
    private void gc() {
        int n;
        n = mSize;
        int o;
        o = 0;
        long[] keys;
        keys = mKeys;
        Object[] values;
        values = mValues;
        {
            int i;
            i = 0;
            {
                Object val;
                val = values[i];
                {
                    {
                        keys[o] = keys[i];
                        values[o] = val;
                    } //End block
                    o++;
                } //End block
            } //End block
        } //End collapsed parenthetic
        mGarbage = false;
        mSize = o;
        // ---------- Original Method ----------
        //int n = mSize;
        //int o = 0;
        //long[] keys = mKeys;
        //Object[] values = mValues;
        //for (int i = 0; i < n; i++) {
            //Object val = values[i];
            //if (val != DELETED) {
                //if (i != o) {
                    //keys[o] = keys[i];
                    //values[o] = val;
                //}
                //o++;
            //}
        //}
        //mGarbage = false;
        //mSize = o;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.623 -0400", hash_original_method = "A67B583D0E7AD982D1504BFCE2629D2E", hash_generated_method = "8FB624C66799E67CC482C814BA77F7CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(long key, E value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            mValues[i] = value;
        } //End block
        {
            i = ~i;
            {
                mKeys[i] = key;
                mValues[i] = value;
            } //End block
            {
                gc();
                i = ~binarySearch(mKeys, 0, mSize, key);
            } //End block
            {
                int n;
                n = ArrayUtils.idealIntArraySize(mSize + 1);
                long[] nkeys;
                nkeys = new long[n];
                Object[] nvalues;
                nvalues = new Object[n];
                System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
                System.arraycopy(mValues, 0, nvalues, 0, mValues.length);
                mKeys = nkeys;
                mValues = nvalues;
            } //End block
            {
                System.arraycopy(mKeys, i, mKeys, i + 1, mSize - i);
                System.arraycopy(mValues, i, mValues, i + 1, mSize - i);
            } //End block
            mKeys[i] = key;
            mValues[i] = value;
            mSize++;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.623 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "C7A0E536EFB673E50E1CD975BB9DC486")
    @DSModeled(DSC.SAFE)
    public int size() {
        {
            gc();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.623 -0400", hash_original_method = "B1F6BB5033A022FAFBEA87494F8412EB", hash_generated_method = "6502A53A1B4CA9EBC6BC8AC85155F298")
    @DSModeled(DSC.SAFE)
    public long keyAt(int index) {
        dsTaint.addTaint(index);
        {
            gc();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.624 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "B8B8B55CF555A832B6C10FCB9C9FA40E")
    @DSModeled(DSC.SAFE)
    public E valueAt(int index) {
        dsTaint.addTaint(index);
        {
            gc();
        } //End block
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return (E) mValues[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.624 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "688C50169BB42B09C9FBD40D76AD344E")
    @DSModeled(DSC.SAFE)
    public void setValueAt(int index, E value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value.dsTaint);
        {
            gc();
        } //End block
        mValues[index] = value;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //mValues[index] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.624 -0400", hash_original_method = "09C66188F9324AB9196B3AD659514994", hash_generated_method = "58A2F73D232B8D5FEEF4997D07EE9172")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOfKey(long key) {
        dsTaint.addTaint(key);
        {
            gc();
        } //End block
        int varEF803A1EE726CA2553B95F3E48B65AD1_1501739256 = (binarySearch(mKeys, 0, mSize, key));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.624 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "0B61CD6A3BB5FDDC7D794A4C208AC967")
    @DSModeled(DSC.SAFE)
    public int indexOfValue(E value) {
        dsTaint.addTaint(value.dsTaint);
        {
            gc();
        } //End block
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //for (int i = 0; i < mSize; i++)
            //if (mValues[i] == value)
                //return i;
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.624 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "E980226B785262E24F1E4C5D013A16A2")
    @DSModeled(DSC.SAFE)
    public void clear() {
        int n;
        n = mSize;
        Object[] values;
        values = mValues;
        {
            int i;
            i = 0;
            {
                values[i] = null;
            } //End block
        } //End collapsed parenthetic
        mSize = 0;
        mGarbage = false;
        // ---------- Original Method ----------
        //int n = mSize;
        //Object[] values = mValues;
        //for (int i = 0; i < n; i++) {
            //values[i] = null;
        //}
        //mSize = 0;
        //mGarbage = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.624 -0400", hash_original_method = "0B04A70E2C13FA00A3C14F0564BE387C", hash_generated_method = "4E0D5BBDF84BA89627C8A15EFC6E8CEA")
    @DSModeled(DSC.SAFE)
    public void append(long key, E value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        {
            put(key, value);
        } //End block
        {
            gc();
        } //End block
        int pos;
        pos = mSize;
        {
            int n;
            n = ArrayUtils.idealIntArraySize(pos + 1);
            long[] nkeys;
            nkeys = new long[n];
            Object[] nvalues;
            nvalues = new Object[n];
            System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
            System.arraycopy(mValues, 0, nvalues, 0, mValues.length);
            mKeys = nkeys;
            mValues = nvalues;
        } //End block
        mKeys[pos] = key;
        mValues[pos] = value;
        mSize = pos + 1;
        // ---------- Original Method ----------
        //if (mSize != 0 && key <= mKeys[mSize - 1]) {
            //put(key, value);
            //return;
        //}
        //if (mGarbage && mSize >= mKeys.length) {
            //gc();
        //}
        //int pos = mSize;
        //if (pos >= mKeys.length) {
            //int n = ArrayUtils.idealIntArraySize(pos + 1);
            //long[] nkeys = new long[n];
            //Object[] nvalues = new Object[n];
            //System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
            //System.arraycopy(mValues, 0, nvalues, 0, mValues.length);
            //mKeys = nkeys;
            //mValues = nvalues;
        //}
        //mKeys[pos] = key;
        //mValues[pos] = value;
        //mSize = pos + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.624 -0400", hash_original_method = "5D31A3D7A0E67E45752AFCF3D2F00D3F", hash_generated_method = "5EFDA50F3246D2A60070817B5CA38C18")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.624 -0400", hash_original_method = "B88BEB15E15C0A7F30A2606914985D6D", hash_generated_method = "82B1ADAB3433FFF342C230453C12D53F")
    @DSModeled(DSC.SAFE)
    private void checkIntegrity() {
        {
            int i;
            i = 1;
            {
                {
                    {
                        int j;
                        j = 0;
                    } //End collapsed parenthetic
                    throw new RuntimeException();
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 1; i < mSize; i++) {
            //if (mKeys[i] <= mKeys[i - 1]) {
                //for (int j = 0; j < mSize; j++) {
                    //Log.e("FAIL", j + ": " + mKeys[j] + " -> " + mValues[j]);
                //}
                //throw new RuntimeException();
            //}
        //}
    }

    
}



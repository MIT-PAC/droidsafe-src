package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class LongSparseArray<E> {
    private boolean mGarbage = false;
    private long[] mKeys;
    private Object[] mValues;
    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.244 -0400", hash_original_method = "F893922E2C2E4CF6AF95C190516DB394", hash_generated_method = "6A1F4B6B8C0C50DC092B16F38EE20B61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LongSparseArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.244 -0400", hash_original_method = "69FE78AD0B4200050B3EDA46329CEBED", hash_generated_method = "CFC155E500223B90DE87EB0D170BC4CF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.245 -0400", hash_original_method = "9447795B515DAD767A419A6C51E84D78", hash_generated_method = "AC11B9BDE32060659F2934350395F3B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.245 -0400", hash_original_method = "F8E34621620A1E3C4828967422EF7D07", hash_generated_method = "10FAF102A66B87F522B8077A0FA2454D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValues(long[] keys, E uniqueValue) {
        dsTaint.addTaint(uniqueValue.dsTaint);
        dsTaint.addTaint(keys[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.246 -0400", hash_original_method = "4371A69A3700205284573EEAA3E6B17F", hash_generated_method = "60A841153443CBEA7677C3930FFC18F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E get(long key) {
        dsTaint.addTaint(key);
        E var2D4BC10AF814DB6E28CC507D53A17135_2143713536 = (get(key, null));
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.248 -0400", hash_original_method = "E2D85B672251F3A6432F3D64B14D09C9", hash_generated_method = "1D267820FEADD929D588EA504C64A59C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.248 -0400", hash_original_method = "D6F064C21D8F72C9BE34FD8563F8D233", hash_generated_method = "CB7797019D5840A53EEF17C46C203F1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.248 -0400", hash_original_method = "A104FD86A71D431024F36E7E390CA038", hash_generated_method = "F1EADBA2C6DCF6CD22BCD697C1E5916C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void remove(long key) {
        dsTaint.addTaint(key);
        delete(key);
        // ---------- Original Method ----------
        //delete(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.248 -0400", hash_original_method = "A9D8FA819E144A31281F443F869190B4", hash_generated_method = "C58ACD70F029E84CD8D05A3172FBDDEC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.249 -0400", hash_original_method = "A67B583D0E7AD982D1504BFCE2629D2E", hash_generated_method = "4D81FA60AB8A31A5E22C569EC61C0768")
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
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.249 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "EA130492709E5C5A63682A798DFF2A11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.250 -0400", hash_original_method = "B1F6BB5033A022FAFBEA87494F8412EB", hash_generated_method = "A38EF0B7A56E29832A57B6E35E072EAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.250 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "91DBD39461F487653D086104AB486863")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.250 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "3E89D5ABD90985EA47019D7DDCEF7A65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.250 -0400", hash_original_method = "09C66188F9324AB9196B3AD659514994", hash_generated_method = "5C41E4CD10FE524D0038231DBACA0BAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOfKey(long key) {
        dsTaint.addTaint(key);
        {
            gc();
        } //End block
        int varEF803A1EE726CA2553B95F3E48B65AD1_621908309 = (binarySearch(mKeys, 0, mSize, key));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.251 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "B44723DEFBC57AB3594BA94F1B51DD0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.251 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "0C4828A3CB0B54289774B69C4B300C28")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.251 -0400", hash_original_method = "0B04A70E2C13FA00A3C14F0564BE387C", hash_generated_method = "DA667A98C5FF3BF144A8D36206294483")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.252 -0400", hash_original_method = "B88BEB15E15C0A7F30A2606914985D6D", hash_generated_method = "2B738B199FBF97C6691F88C379516160")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
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

    
    private static final Object DELETED = new Object();
}


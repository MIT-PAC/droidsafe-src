package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.util.ArrayUtils;

public class SparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage = false;
    private int[] mKeys;
    private Object[] mValues;
    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.671 -0400", hash_original_method = "E97D5EED29ED8377C999990C20A12343", hash_generated_method = "3B8A10A8A777D2877F19458E7EB1EB1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SparseArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.671 -0400", hash_original_method = "F193A0D2E79CC42C4145064D20AB5B71", hash_generated_method = "7122B4C21BFBD266208136173F657F02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SparseArray(int initialCapacity) {
        dsTaint.addTaint(initialCapacity);
        initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        mKeys = new int[initialCapacity];
        mValues = new Object[initialCapacity];
        mSize = 0;
        // ---------- Original Method ----------
        //initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        //mKeys = new int[initialCapacity];
        //mValues = new Object[initialCapacity];
        //mSize = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.671 -0400", hash_original_method = "A950936C46135A90B64D99C98FBE0DD0", hash_generated_method = "4A9B94EBAE8B948FEA99004B06D6ED82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @SuppressWarnings("unchecked")
    public SparseArray<E> clone() {
        SparseArray<E> clone;
        clone = null;
        try 
        {
            clone = (SparseArray<E>) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } //End block
        catch (CloneNotSupportedException cnse)
        { }
        return (SparseArray<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SparseArray<E> clone = null;
        //try {
            //clone = (SparseArray<E>) super.clone();
            //clone.mKeys = mKeys.clone();
            //clone.mValues = mValues.clone();
        //} catch (CloneNotSupportedException cnse) {
        //}
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.671 -0400", hash_original_method = "63029C5D60DB5A1F0C43DA1A71993094", hash_generated_method = "C6F778886EE7C8BDA8191FE4064E85A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E get(int key) {
        dsTaint.addTaint(key);
        E var2D4BC10AF814DB6E28CC507D53A17135_624517660 = (get(key, null));
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.672 -0400", hash_original_method = "C9E62D05249D95E7C50A204FF58AB455", hash_generated_method = "0F5A522FAC7A6FAEC4D5349F9B68B9B4")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public E get(int key, E valueIfKeyNotFound) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.672 -0400", hash_original_method = "D16C073A10FD3671AE05EBC49E38DA17", hash_generated_method = "326088E29F4DFF93C8FE716705992271")
    @DSModeled(DSC.SAFE)
    public void delete(int key) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.672 -0400", hash_original_method = "EE51F875218CA8C1C2C8959A48F2A4BB", hash_generated_method = "E593B8474D34B1A05154C46F3F9947DE")
    @DSModeled(DSC.SAFE)
    public void remove(int key) {
        dsTaint.addTaint(key);
        delete(key);
        // ---------- Original Method ----------
        //delete(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.672 -0400", hash_original_method = "1992218C2CA2A9A793E8A4995C16BACA", hash_generated_method = "1E11FA3321E96F07C92B07886F1A842F")
    @DSModeled(DSC.SAFE)
    public void removeAt(int index) {
        dsTaint.addTaint(index);
        {
            mValues[index] = DELETED;
            mGarbage = true;
        } //End block
        // ---------- Original Method ----------
        //if (mValues[index] != DELETED) {
            //mValues[index] = DELETED;
            //mGarbage = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.672 -0400", hash_original_method = "92E5B832E30042BFCDC9211BA5952F8C", hash_generated_method = "86960A4A1A232F49C8BCCD2C92C75075")
    @DSModeled(DSC.SAFE)
    private void gc() {
        int n;
        n = mSize;
        int o;
        o = 0;
        int[] keys;
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
                        values[i] = null;
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
        //int[] keys = mKeys;
        //Object[] values = mValues;
        //for (int i = 0; i < n; i++) {
            //Object val = values[i];
            //if (val != DELETED) {
                //if (i != o) {
                    //keys[o] = keys[i];
                    //values[o] = val;
                    //values[i] = null;
                //}
                //o++;
            //}
        //}
        //mGarbage = false;
        //mSize = o;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.672 -0400", hash_original_method = "D431925AC076B56C67C685DECF88777D", hash_generated_method = "EB73F5416960FCDD4F52201BCDF62ADF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(int key, E value) {
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
                int[] nkeys;
                nkeys = new int[n];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.672 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "C7A0E536EFB673E50E1CD975BB9DC486")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.672 -0400", hash_original_method = "AD3650995583655A8D059B5C8CE85FAD", hash_generated_method = "9E0E8E137B0F841F8EE529E6C548DCC0")
    @DSModeled(DSC.SAFE)
    public int keyAt(int index) {
        dsTaint.addTaint(index);
        {
            gc();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.673 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "AAB46A833D0DA6F0B106C4F6AA33B861")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.673 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "688C50169BB42B09C9FBD40D76AD344E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.673 -0400", hash_original_method = "2AE05DC6F4A524A5C2D1FCD4B3573FB7", hash_generated_method = "FA79F3BD3787CC196168B131EAC04AB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOfKey(int key) {
        dsTaint.addTaint(key);
        {
            gc();
        } //End block
        int varEF803A1EE726CA2553B95F3E48B65AD1_1342832257 = (binarySearch(mKeys, 0, mSize, key));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.673 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "0B61CD6A3BB5FDDC7D794A4C208AC967")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.673 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "E980226B785262E24F1E4C5D013A16A2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.673 -0400", hash_original_method = "5B63A048C0AD4A7F3A46491DB8DBCD38", hash_generated_method = "FFC98A4ED3547E68D9846307E172BDE9")
    @DSModeled(DSC.SAFE)
    public void append(int key, E value) {
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
            int[] nkeys;
            nkeys = new int[n];
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
            //int[] nkeys = new int[n];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.673 -0400", hash_original_method = "7DB5AA23E16883217822FBC6D13669D2", hash_generated_method = "FEB35469F5B9E3BA231D8C8D51EF0135")
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

    
}



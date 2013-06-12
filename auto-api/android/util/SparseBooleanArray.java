package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.util.ArrayUtils;

public class SparseBooleanArray implements Cloneable {
    private int[] mKeys;
    private boolean[] mValues;
    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.678 -0400", hash_original_method = "8D15548F78BDFDD752295E5C53E86F2F", hash_generated_method = "99463EC7093EB4B80D4D1CA275BE2798")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SparseBooleanArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.679 -0400", hash_original_method = "A6A3EB653943D50370F97C74C514666D", hash_generated_method = "6003F7824DFE64B993A74D3985A0C975")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SparseBooleanArray(int initialCapacity) {
        dsTaint.addTaint(initialCapacity);
        initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        mKeys = new int[initialCapacity];
        mValues = new boolean[initialCapacity];
        mSize = 0;
        // ---------- Original Method ----------
        //initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        //mKeys = new int[initialCapacity];
        //mValues = new boolean[initialCapacity];
        //mSize = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.679 -0400", hash_original_method = "F55567A3E3F95227EEE521C36E220AEC", hash_generated_method = "B52E8D5206CC22AB4BFD7A7E333516BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SparseBooleanArray clone() {
        SparseBooleanArray clone;
        clone = null;
        try 
        {
            clone = (SparseBooleanArray) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } //End block
        catch (CloneNotSupportedException cnse)
        { }
        return (SparseBooleanArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SparseBooleanArray clone = null;
        //try {
            //clone = (SparseBooleanArray) super.clone();
            //clone.mKeys = mKeys.clone();
            //clone.mValues = mValues.clone();
        //} catch (CloneNotSupportedException cnse) {
        //}
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.679 -0400", hash_original_method = "1186B1642AA4116A541B7A05AB024C1E", hash_generated_method = "BBA41F5F22EE1002AD571B69A4130B61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean get(int key) {
        dsTaint.addTaint(key);
        boolean varCD674645E34E1A3C54E107D1D1366795_878222920 = (get(key, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return get(key, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.679 -0400", hash_original_method = "421C2461F361B34EC4C9F82A0C8C35E5", hash_generated_method = "EA7C86FD49E3063C1F16CB46EE80B939")
    @DSModeled(DSC.SAFE)
    public boolean get(int key, boolean valueIfKeyNotFound) {
        dsTaint.addTaint(valueIfKeyNotFound);
        dsTaint.addTaint(key);
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0) {
            //return valueIfKeyNotFound;
        //} else {
            //return mValues[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.679 -0400", hash_original_method = "18B11B5534C55393394DE082DEBB04D1", hash_generated_method = "7BBF82FE221A3A7ABB8AB734D9307AFB")
    @DSModeled(DSC.SAFE)
    public void delete(int key) {
        dsTaint.addTaint(key);
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            System.arraycopy(mKeys, i + 1, mKeys, i, mSize - (i + 1));
            System.arraycopy(mValues, i + 1, mValues, i, mSize - (i + 1));
            mSize--;
        } //End block
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i >= 0) {
            //System.arraycopy(mKeys, i + 1, mKeys, i, mSize - (i + 1));
            //System.arraycopy(mValues, i + 1, mValues, i, mSize - (i + 1));
            //mSize--;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.679 -0400", hash_original_method = "D051F7BD1248EC7F2DE7541E7D2B2D2A", hash_generated_method = "5C670836C5E4F570FF17F7A5D1400F32")
    @DSModeled(DSC.SAFE)
    public void put(int key, boolean value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            mValues[i] = value;
        } //End block
        {
            i = ~i;
            {
                int n;
                n = ArrayUtils.idealIntArraySize(mSize + 1);
                int[] nkeys;
                nkeys = new int[n];
                boolean[] nvalues;
                nvalues = new boolean[n];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.679 -0400", hash_original_method = "9550C69BAA91C5298BA75D226127D5FF", hash_generated_method = "E983E1B75BD0F10382F0597D805F253E")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.679 -0400", hash_original_method = "A3423B1919CBB5E5DDAE8E35A522AED2", hash_generated_method = "A1A1A9AA788BC591999ED38AA47D9D41")
    @DSModeled(DSC.SAFE)
    public int keyAt(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.680 -0400", hash_original_method = "29A1BAF882E385B3C84A3B34D45CFC9E", hash_generated_method = "1277B72E1A21D8AF30D6632FD1E09321")
    @DSModeled(DSC.SAFE)
    public boolean valueAt(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mValues[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.680 -0400", hash_original_method = "AE2F6996EFD9E2EE7383268F20118C3E", hash_generated_method = "F7C4E6C147E6B564BB16160D7C3413EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOfKey(int key) {
        dsTaint.addTaint(key);
        int varEF803A1EE726CA2553B95F3E48B65AD1_563553717 = (binarySearch(mKeys, 0, mSize, key));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.680 -0400", hash_original_method = "7EFAF81E1CDED3A683A46526F2D63473", hash_generated_method = "D77219E804752917D785F5171E0FABFB")
    @DSModeled(DSC.SAFE)
    public int indexOfValue(boolean value) {
        dsTaint.addTaint(value);
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (int i = 0; i < mSize; i++)
            //if (mValues[i] == value)
                //return i;
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.680 -0400", hash_original_method = "78B640B3511AD026106C387D36058FFC", hash_generated_method = "FE5AA176CE337602E1A16E6696CCC717")
    @DSModeled(DSC.SAFE)
    public void clear() {
        mSize = 0;
        // ---------- Original Method ----------
        //mSize = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.680 -0400", hash_original_method = "1A2B721538032798B5FC0916FF4BED9A", hash_generated_method = "A4E77E5D254A78FD0657D8A5CD7E986B")
    @DSModeled(DSC.SAFE)
    public void append(int key, boolean value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        {
            put(key, value);
        } //End block
        int pos;
        pos = mSize;
        {
            int n;
            n = ArrayUtils.idealIntArraySize(pos + 1);
            int[] nkeys;
            nkeys = new int[n];
            boolean[] nvalues;
            nvalues = new boolean[n];
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
        //int pos = mSize;
        //if (pos >= mKeys.length) {
            //int n = ArrayUtils.idealIntArraySize(pos + 1);
            //int[] nkeys = new int[n];
            //boolean[] nvalues = new boolean[n];
            //System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
            //System.arraycopy(mValues, 0, nvalues, 0, mValues.length);
            //mKeys = nkeys;
            //mValues = nvalues;
        //}
        //mKeys[pos] = key;
        //mValues[pos] = value;
        //mSize = pos + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.680 -0400", hash_original_method = "7DB5AA23E16883217822FBC6D13669D2", hash_generated_method = "FEB35469F5B9E3BA231D8C8D51EF0135")
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



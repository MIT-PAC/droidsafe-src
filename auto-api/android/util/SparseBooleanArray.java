package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class SparseBooleanArray implements Cloneable {
    private int[] mKeys;
    private boolean[] mValues;
    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.362 -0400", hash_original_method = "8D15548F78BDFDD752295E5C53E86F2F", hash_generated_method = "615FAF32D19F7E913E71139FAA2C7BA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SparseBooleanArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.362 -0400", hash_original_method = "A6A3EB653943D50370F97C74C514666D", hash_generated_method = "BA14568724039087F5212BCED55468D4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.363 -0400", hash_original_method = "F55567A3E3F95227EEE521C36E220AEC", hash_generated_method = "1EB997A4D1692EF875E6E5D71B432002")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.363 -0400", hash_original_method = "1186B1642AA4116A541B7A05AB024C1E", hash_generated_method = "0F6E5D9720FE9E14C1FA3F39B867DC0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean get(int key) {
        dsTaint.addTaint(key);
        boolean varCD674645E34E1A3C54E107D1D1366795_2070655420 = (get(key, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return get(key, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.363 -0400", hash_original_method = "421C2461F361B34EC4C9F82A0C8C35E5", hash_generated_method = "7DD261793DA22AE2E95DE205EFF13D14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.363 -0400", hash_original_method = "18B11B5534C55393394DE082DEBB04D1", hash_generated_method = "59370B2220290AE2DE63310944F0ECBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void delete(int key) {
        dsTaint.addTaint(key);
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            System.arraycopy(mKeys, i + 1, mKeys, i, mSize - (i + 1));
            System.arraycopy(mValues, i + 1, mValues, i, mSize - (i + 1));
        } //End block
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i >= 0) {
            //System.arraycopy(mKeys, i + 1, mKeys, i, mSize - (i + 1));
            //System.arraycopy(mValues, i + 1, mValues, i, mSize - (i + 1));
            //mSize--;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.364 -0400", hash_original_method = "D051F7BD1248EC7F2DE7541E7D2B2D2A", hash_generated_method = "62EA2293E6D30F51C2D7FDC55AC61444")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.364 -0400", hash_original_method = "9550C69BAA91C5298BA75D226127D5FF", hash_generated_method = "EDC3A0E6A899CA68E35DB6151A06DD44")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.364 -0400", hash_original_method = "A3423B1919CBB5E5DDAE8E35A522AED2", hash_generated_method = "52D88FD68B44C2EC44B71F407F25B579")
    @DSModeled(DSC.SAFE)
    public int keyAt(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.364 -0400", hash_original_method = "29A1BAF882E385B3C84A3B34D45CFC9E", hash_generated_method = "C284DA80B3CE036FCDFC3BE8F12A741B")
    @DSModeled(DSC.SAFE)
    public boolean valueAt(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mValues[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.365 -0400", hash_original_method = "AE2F6996EFD9E2EE7383268F20118C3E", hash_generated_method = "7BC459DCC151DA0175838D29CB61886F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOfKey(int key) {
        dsTaint.addTaint(key);
        int varEF803A1EE726CA2553B95F3E48B65AD1_1117513220 = (binarySearch(mKeys, 0, mSize, key));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.365 -0400", hash_original_method = "7EFAF81E1CDED3A683A46526F2D63473", hash_generated_method = "7B5371902F2868A4233EBAC361BC877F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.365 -0400", hash_original_method = "78B640B3511AD026106C387D36058FFC", hash_generated_method = "2F55AFCAF967A1646FEBDAF6AC2C8455")
    @DSModeled(DSC.SAFE)
    public void clear() {
        mSize = 0;
        // ---------- Original Method ----------
        //mSize = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.365 -0400", hash_original_method = "1A2B721538032798B5FC0916FF4BED9A", hash_generated_method = "40BD40B7A53763547275CEBD639E90AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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


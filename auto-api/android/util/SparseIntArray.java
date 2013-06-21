package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class SparseIntArray implements Cloneable {
    private int[] mKeys;
    private int[] mValues;
    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.374 -0400", hash_original_method = "3CB703BA4BBEFDD58F8198A538C651FA", hash_generated_method = "DD3187CC4240A3B6F7662B05387FA78D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SparseIntArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.374 -0400", hash_original_method = "4F3979691C622EA5D57CC5639ACF4BFA", hash_generated_method = "41BD0FB44A7BF71A2F44D15F75677EBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SparseIntArray(int initialCapacity) {
        dsTaint.addTaint(initialCapacity);
        initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        mKeys = new int[initialCapacity];
        mValues = new int[initialCapacity];
        mSize = 0;
        // ---------- Original Method ----------
        //initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        //mKeys = new int[initialCapacity];
        //mValues = new int[initialCapacity];
        //mSize = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.374 -0400", hash_original_method = "A8A0500EAB2E651EC2684F9205BC101D", hash_generated_method = "359F7547C042DCCF4D2E6F0A725643E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SparseIntArray clone() {
        SparseIntArray clone;
        clone = null;
        try 
        {
            clone = (SparseIntArray) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } //End block
        catch (CloneNotSupportedException cnse)
        { }
        return (SparseIntArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SparseIntArray clone = null;
        //try {
            //clone = (SparseIntArray) super.clone();
            //clone.mKeys = mKeys.clone();
            //clone.mValues = mValues.clone();
        //} catch (CloneNotSupportedException cnse) {
        //}
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.374 -0400", hash_original_method = "31C2EB74F838DC49D6A7CCB91DEC9730", hash_generated_method = "1C29B51DFF63DA17D9062EB9C839FA48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int get(int key) {
        dsTaint.addTaint(key);
        int var2681AF3C27FD52FDD48BA1C704E320C9_1721881301 = (get(key, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return get(key, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.375 -0400", hash_original_method = "F09A11123BBC4B0EABD4FD786A922B87", hash_generated_method = "391CC2C5CEB1F5E6454E4912567A9096")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int get(int key, int valueIfKeyNotFound) {
        dsTaint.addTaint(valueIfKeyNotFound);
        dsTaint.addTaint(key);
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0) {
            //return valueIfKeyNotFound;
        //} else {
            //return mValues[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.375 -0400", hash_original_method = "8400B64AA446E0EFD1887423DF561D32", hash_generated_method = "2770F3819263A82AD8C1C4A758C8FF12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void delete(int key) {
        dsTaint.addTaint(key);
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            removeAt(i);
        } //End block
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i >= 0) {
            //removeAt(i);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.375 -0400", hash_original_method = "95F6538276A47A94F5635C5979B3D205", hash_generated_method = "66F167CC4B89C7563E1623CC410C167D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAt(int index) {
        dsTaint.addTaint(index);
        System.arraycopy(mKeys, index + 1, mKeys, index, mSize - (index + 1));
        System.arraycopy(mValues, index + 1, mValues, index, mSize - (index + 1));
        // ---------- Original Method ----------
        //System.arraycopy(mKeys, index + 1, mKeys, index, mSize - (index + 1));
        //System.arraycopy(mValues, index + 1, mValues, index, mSize - (index + 1));
        //mSize--;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.375 -0400", hash_original_method = "22FC701C5FD198EE89684FFAA296E5FF", hash_generated_method = "84AD840FAEC9D946D6C5E2806BB3C2D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(int key, int value) {
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
                int[] nvalues;
                nvalues = new int[n];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.376 -0400", hash_original_method = "9550C69BAA91C5298BA75D226127D5FF", hash_generated_method = "EDC3A0E6A899CA68E35DB6151A06DD44")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.376 -0400", hash_original_method = "A3423B1919CBB5E5DDAE8E35A522AED2", hash_generated_method = "52D88FD68B44C2EC44B71F407F25B579")
    @DSModeled(DSC.SAFE)
    public int keyAt(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.376 -0400", hash_original_method = "C4C41F7CADA2DF58870780D8F849030A", hash_generated_method = "8E6BFEE07440F4067AE91662D7A2B1C0")
    @DSModeled(DSC.SAFE)
    public int valueAt(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mValues[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.376 -0400", hash_original_method = "AE2F6996EFD9E2EE7383268F20118C3E", hash_generated_method = "EECBDEC9CE727249D86EF01F146B466F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOfKey(int key) {
        dsTaint.addTaint(key);
        int varEF803A1EE726CA2553B95F3E48B65AD1_817562974 = (binarySearch(mKeys, 0, mSize, key));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.376 -0400", hash_original_method = "951F96E1F188074D8F08952A6EB559DF", hash_generated_method = "195881539D60034D335EE603170C120D")
    @DSModeled(DSC.SAFE)
    public int indexOfValue(int value) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.377 -0400", hash_original_method = "78B640B3511AD026106C387D36058FFC", hash_generated_method = "2F55AFCAF967A1646FEBDAF6AC2C8455")
    @DSModeled(DSC.SAFE)
    public void clear() {
        mSize = 0;
        // ---------- Original Method ----------
        //mSize = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.377 -0400", hash_original_method = "582360498D222FA3AC7FD1DD315CF583", hash_generated_method = "9FEF3222882016E08A3082045DF3B5E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void append(int key, int value) {
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
            int[] nvalues;
            nvalues = new int[n];
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
            //int[] nvalues = new int[n];
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


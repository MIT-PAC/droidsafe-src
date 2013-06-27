package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class SparseBooleanArray implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.529 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.529 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "A2C25611A545F26A4C8405C4B8B577DD")

    private boolean[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.529 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.530 -0400", hash_original_method = "8D15548F78BDFDD752295E5C53E86F2F", hash_generated_method = "615FAF32D19F7E913E71139FAA2C7BA8")
    public  SparseBooleanArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.538 -0400", hash_original_method = "A6A3EB653943D50370F97C74C514666D", hash_generated_method = "C46C350968A04AE428E20A28C4AC075E")
    public  SparseBooleanArray(int initialCapacity) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.548 -0400", hash_original_method = "F55567A3E3F95227EEE521C36E220AEC", hash_generated_method = "09C2ED9C684284D7C4E67B74E62661A6")
    @Override
    public SparseBooleanArray clone() {
        SparseBooleanArray varB4EAC82CA7396A68D541C85D26508E83_2053594568 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_2053594568 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_2053594568.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2053594568;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.549 -0400", hash_original_method = "1186B1642AA4116A541B7A05AB024C1E", hash_generated_method = "2046F0A99681B5850A58368FD4395AE9")
    public boolean get(int key) {
        boolean varCD674645E34E1A3C54E107D1D1366795_1815797394 = (get(key, false));
        addTaint(key);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1957825796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1957825796;
        // ---------- Original Method ----------
        //return get(key, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.564 -0400", hash_original_method = "421C2461F361B34EC4C9F82A0C8C35E5", hash_generated_method = "2358E0484574A7F760CE18D45BCFED0A")
    public boolean get(int key, boolean valueIfKeyNotFound) {
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        addTaint(key);
        addTaint(valueIfKeyNotFound);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_322065288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_322065288;
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0) {
            //return valueIfKeyNotFound;
        //} else {
            //return mValues[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.564 -0400", hash_original_method = "18B11B5534C55393394DE082DEBB04D1", hash_generated_method = "8092B607D6DCCF461CD47B955DD006D5")
    public void delete(int key) {
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            System.arraycopy(mKeys, i + 1, mKeys, i, mSize - (i + 1));
            System.arraycopy(mValues, i + 1, mValues, i, mSize - (i + 1));
        } //End block
        addTaint(key);
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i >= 0) {
            //System.arraycopy(mKeys, i + 1, mKeys, i, mSize - (i + 1));
            //System.arraycopy(mValues, i + 1, mValues, i, mSize - (i + 1));
            //mSize--;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.565 -0400", hash_original_method = "D051F7BD1248EC7F2DE7541E7D2B2D2A", hash_generated_method = "6A55FC6341594EF7D56D36AF0B13446D")
    public void put(int key, boolean value) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.566 -0400", hash_original_method = "9550C69BAA91C5298BA75D226127D5FF", hash_generated_method = "89D6028B47951C517A16B3845A9465BD")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350892231 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350892231;
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.566 -0400", hash_original_method = "A3423B1919CBB5E5DDAE8E35A522AED2", hash_generated_method = "E87299B9BD900D104C306AC53BF6B236")
    public int keyAt(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_241254595 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_241254595;
        // ---------- Original Method ----------
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.566 -0400", hash_original_method = "29A1BAF882E385B3C84A3B34D45CFC9E", hash_generated_method = "2FF694A58B6012171AB6139C7527F6F1")
    public boolean valueAt(int index) {
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_193645828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_193645828;
        // ---------- Original Method ----------
        //return mValues[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.567 -0400", hash_original_method = "AE2F6996EFD9E2EE7383268F20118C3E", hash_generated_method = "4A00C7B9C4ABC3F70A4849DE1BA8546B")
    public int indexOfKey(int key) {
        int varEF803A1EE726CA2553B95F3E48B65AD1_1804277043 = (binarySearch(mKeys, 0, mSize, key));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270556232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270556232;
        // ---------- Original Method ----------
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.567 -0400", hash_original_method = "7EFAF81E1CDED3A683A46526F2D63473", hash_generated_method = "CD7091B4F5BBEA955648532F975E6A29")
    public int indexOfValue(boolean value) {
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734971112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734971112;
        // ---------- Original Method ----------
        //for (int i = 0; i < mSize; i++)
            //if (mValues[i] == value)
                //return i;
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.580 -0400", hash_original_method = "78B640B3511AD026106C387D36058FFC", hash_generated_method = "2F55AFCAF967A1646FEBDAF6AC2C8455")
    public void clear() {
        mSize = 0;
        // ---------- Original Method ----------
        //mSize = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.587 -0400", hash_original_method = "1A2B721538032798B5FC0916FF4BED9A", hash_generated_method = "925630DD092A8772A947FC3160BC4469")
    public void append(int key, boolean value) {
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


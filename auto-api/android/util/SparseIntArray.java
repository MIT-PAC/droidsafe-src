package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class SparseIntArray implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.208 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.215 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "99CDF6DB2A492E619A6F25FAC593741C")

    private int[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.215 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.227 -0400", hash_original_method = "3CB703BA4BBEFDD58F8198A538C651FA", hash_generated_method = "DD3187CC4240A3B6F7662B05387FA78D")
    public  SparseIntArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.227 -0400", hash_original_method = "4F3979691C622EA5D57CC5639ACF4BFA", hash_generated_method = "37CCE572277F2EF9BBAD927B73134A48")
    public  SparseIntArray(int initialCapacity) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.228 -0400", hash_original_method = "A8A0500EAB2E651EC2684F9205BC101D", hash_generated_method = "4C84761C0B862B43D939A7A6E5F57856")
    @Override
    public SparseIntArray clone() {
        SparseIntArray varB4EAC82CA7396A68D541C85D26508E83_489731742 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_489731742 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_489731742.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_489731742;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.228 -0400", hash_original_method = "31C2EB74F838DC49D6A7CCB91DEC9730", hash_generated_method = "10BE2F8104290A315BD275C5641C69CC")
    public int get(int key) {
        int var2681AF3C27FD52FDD48BA1C704E320C9_729439983 = (get(key, 0));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945857699 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945857699;
        // ---------- Original Method ----------
        //return get(key, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.229 -0400", hash_original_method = "F09A11123BBC4B0EABD4FD786A922B87", hash_generated_method = "21BB98641F65A643D74097835A3D4ACC")
    public int get(int key, int valueIfKeyNotFound) {
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        addTaint(key);
        addTaint(valueIfKeyNotFound);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404033838 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404033838;
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0) {
            //return valueIfKeyNotFound;
        //} else {
            //return mValues[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.229 -0400", hash_original_method = "8400B64AA446E0EFD1887423DF561D32", hash_generated_method = "7A35F8516ADC273DEDF5AEA92CECC59C")
    public void delete(int key) {
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            removeAt(i);
        } //End block
        addTaint(key);
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i >= 0) {
            //removeAt(i);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.230 -0400", hash_original_method = "95F6538276A47A94F5635C5979B3D205", hash_generated_method = "E3E4526070D7FA71B63F2740C50E5CFB")
    public void removeAt(int index) {
        System.arraycopy(mKeys, index + 1, mKeys, index, mSize - (index + 1));
        System.arraycopy(mValues, index + 1, mValues, index, mSize - (index + 1));
        addTaint(index);
        // ---------- Original Method ----------
        //System.arraycopy(mKeys, index + 1, mKeys, index, mSize - (index + 1));
        //System.arraycopy(mValues, index + 1, mValues, index, mSize - (index + 1));
        //mSize--;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.248 -0400", hash_original_method = "22FC701C5FD198EE89684FFAA296E5FF", hash_generated_method = "A18D220273590CD8A2FAE3FC931099D4")
    public void put(int key, int value) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.249 -0400", hash_original_method = "9550C69BAA91C5298BA75D226127D5FF", hash_generated_method = "2797AA670EBD6275A9E3BB28BAC6397F")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1255727484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1255727484;
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.249 -0400", hash_original_method = "A3423B1919CBB5E5DDAE8E35A522AED2", hash_generated_method = "762736E87DB4212D5157E32E96D26F39")
    public int keyAt(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191522843 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191522843;
        // ---------- Original Method ----------
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.250 -0400", hash_original_method = "C4C41F7CADA2DF58870780D8F849030A", hash_generated_method = "F087519E8295E5C7DE68CCFA38C6CD39")
    public int valueAt(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_383112474 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_383112474;
        // ---------- Original Method ----------
        //return mValues[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.250 -0400", hash_original_method = "AE2F6996EFD9E2EE7383268F20118C3E", hash_generated_method = "2A89F7F593F0E42DAC903F64560EE236")
    public int indexOfKey(int key) {
        int varEF803A1EE726CA2553B95F3E48B65AD1_2110243864 = (binarySearch(mKeys, 0, mSize, key));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074299557 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074299557;
        // ---------- Original Method ----------
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.251 -0400", hash_original_method = "951F96E1F188074D8F08952A6EB559DF", hash_generated_method = "B2B1C1AEC604760E1DAD7F99026A8F3A")
    public int indexOfValue(int value) {
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117314922 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117314922;
        // ---------- Original Method ----------
        //for (int i = 0; i < mSize; i++)
            //if (mValues[i] == value)
                //return i;
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.252 -0400", hash_original_method = "78B640B3511AD026106C387D36058FFC", hash_generated_method = "2F55AFCAF967A1646FEBDAF6AC2C8455")
    public void clear() {
        mSize = 0;
        // ---------- Original Method ----------
        //mSize = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.252 -0400", hash_original_method = "582360498D222FA3AC7FD1DD315CF583", hash_generated_method = "ED92E4102B32E0DDFD4BF86D633560EF")
    public void append(int key, int value) {
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


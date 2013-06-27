package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class SparseIntArray implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.514 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.514 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "99CDF6DB2A492E619A6F25FAC593741C")

    private int[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.514 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.515 -0400", hash_original_method = "3CB703BA4BBEFDD58F8198A538C651FA", hash_generated_method = "DD3187CC4240A3B6F7662B05387FA78D")
    public  SparseIntArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.523 -0400", hash_original_method = "4F3979691C622EA5D57CC5639ACF4BFA", hash_generated_method = "37CCE572277F2EF9BBAD927B73134A48")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.524 -0400", hash_original_method = "A8A0500EAB2E651EC2684F9205BC101D", hash_generated_method = "BC3C1B8BD873410A063B9E6A4DF371EE")
    @Override
    public SparseIntArray clone() {
        SparseIntArray varB4EAC82CA7396A68D541C85D26508E83_1772336943 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1772336943 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1772336943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1772336943;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.524 -0400", hash_original_method = "31C2EB74F838DC49D6A7CCB91DEC9730", hash_generated_method = "3136C583D517FD4F31FA54FD7817F5FD")
    public int get(int key) {
        int var2681AF3C27FD52FDD48BA1C704E320C9_1930476869 = (get(key, 0));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197621240 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197621240;
        // ---------- Original Method ----------
        //return get(key, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.524 -0400", hash_original_method = "F09A11123BBC4B0EABD4FD786A922B87", hash_generated_method = "2B16BA4914AF88A8E2F0445C4B9D3617")
    public int get(int key, int valueIfKeyNotFound) {
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        addTaint(key);
        addTaint(valueIfKeyNotFound);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562768644 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562768644;
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0) {
            //return valueIfKeyNotFound;
        //} else {
            //return mValues[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.525 -0400", hash_original_method = "8400B64AA446E0EFD1887423DF561D32", hash_generated_method = "7A35F8516ADC273DEDF5AEA92CECC59C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.525 -0400", hash_original_method = "95F6538276A47A94F5635C5979B3D205", hash_generated_method = "E3E4526070D7FA71B63F2740C50E5CFB")
    public void removeAt(int index) {
        System.arraycopy(mKeys, index + 1, mKeys, index, mSize - (index + 1));
        System.arraycopy(mValues, index + 1, mValues, index, mSize - (index + 1));
        addTaint(index);
        // ---------- Original Method ----------
        //System.arraycopy(mKeys, index + 1, mKeys, index, mSize - (index + 1));
        //System.arraycopy(mValues, index + 1, mValues, index, mSize - (index + 1));
        //mSize--;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.538 -0400", hash_original_method = "22FC701C5FD198EE89684FFAA296E5FF", hash_generated_method = "A18D220273590CD8A2FAE3FC931099D4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.539 -0400", hash_original_method = "9550C69BAA91C5298BA75D226127D5FF", hash_generated_method = "ECF0471B369A5486A5428F74F6B42B8B")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_251373129 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_251373129;
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.540 -0400", hash_original_method = "A3423B1919CBB5E5DDAE8E35A522AED2", hash_generated_method = "1305874302782C3AE723BC2668B5C851")
    public int keyAt(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_432112621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_432112621;
        // ---------- Original Method ----------
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.540 -0400", hash_original_method = "C4C41F7CADA2DF58870780D8F849030A", hash_generated_method = "ECB4CDB402EEBCBA15E755800E580909")
    public int valueAt(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989969792 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989969792;
        // ---------- Original Method ----------
        //return mValues[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.540 -0400", hash_original_method = "AE2F6996EFD9E2EE7383268F20118C3E", hash_generated_method = "75D2F4FD3B36FE772EE33F62943F39A9")
    public int indexOfKey(int key) {
        int varEF803A1EE726CA2553B95F3E48B65AD1_40691932 = (binarySearch(mKeys, 0, mSize, key));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844199265 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844199265;
        // ---------- Original Method ----------
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.548 -0400", hash_original_method = "951F96E1F188074D8F08952A6EB559DF", hash_generated_method = "A381837D15E32E99C24DE289939628DE")
    public int indexOfValue(int value) {
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896881554 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896881554;
        // ---------- Original Method ----------
        //for (int i = 0; i < mSize; i++)
            //if (mValues[i] == value)
                //return i;
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.561 -0400", hash_original_method = "78B640B3511AD026106C387D36058FFC", hash_generated_method = "2F55AFCAF967A1646FEBDAF6AC2C8455")
    public void clear() {
        mSize = 0;
        // ---------- Original Method ----------
        //mSize = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.561 -0400", hash_original_method = "582360498D222FA3AC7FD1DD315CF583", hash_generated_method = "ED92E4102B32E0DDFD4BF86D633560EF")
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


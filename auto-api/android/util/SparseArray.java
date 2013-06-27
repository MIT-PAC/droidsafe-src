package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class SparseArray<E> implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.270 -0400", hash_original_field = "09A7D01F9A4EF2933D39C68D27937238", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.270 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.270 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.270 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.270 -0400", hash_original_method = "E97D5EED29ED8377C999990C20A12343", hash_generated_method = "E245EEBE3057EE5A6B20AA3D7F52AD37")
    public  SparseArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.271 -0400", hash_original_method = "F193A0D2E79CC42C4145064D20AB5B71", hash_generated_method = "0CE585F4CFEAD80D83275E2B999CFA02")
    public  SparseArray(int initialCapacity) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.283 -0400", hash_original_method = "A950936C46135A90B64D99C98FBE0DD0", hash_generated_method = "973DFF59DA03A9A321884D0CB69BCA9E")
    @Override
    @SuppressWarnings("unchecked")
    public SparseArray<E> clone() {
        SparseArray<E> varB4EAC82CA7396A68D541C85D26508E83_71897817 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_71897817 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_71897817.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_71897817;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.284 -0400", hash_original_method = "63029C5D60DB5A1F0C43DA1A71993094", hash_generated_method = "CB322693AD2E7B0E11D7F1218FAB067C")
    public E get(int key) {
        E varB4EAC82CA7396A68D541C85D26508E83_1155396991 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1155396991 = get(key, null);
        addTaint(key);
        varB4EAC82CA7396A68D541C85D26508E83_1155396991.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1155396991;
        // ---------- Original Method ----------
        //return get(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.299 -0400", hash_original_method = "C9E62D05249D95E7C50A204FF58AB455", hash_generated_method = "0021061C172D97F527AAF00A7B448202")
    @SuppressWarnings("unchecked")
    public E get(int key, E valueIfKeyNotFound) {
        E varB4EAC82CA7396A68D541C85D26508E83_1964681729 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_505766101 = null; //Variable for return #2
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1964681729 = valueIfKeyNotFound;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_505766101 = (E) mValues[i];
        } //End block
        addTaint(key);
        addTaint(valueIfKeyNotFound.getTaint());
        E varA7E53CE21691AB073D9660D615818899_200462924; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_200462924 = varB4EAC82CA7396A68D541C85D26508E83_1964681729;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_200462924 = varB4EAC82CA7396A68D541C85D26508E83_505766101;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_200462924.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_200462924;
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0 || mValues[i] == DELETED) {
            //return valueIfKeyNotFound;
        //} else {
            //return (E) mValues[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.300 -0400", hash_original_method = "D16C073A10FD3671AE05EBC49E38DA17", hash_generated_method = "F3F5B9DEC4C2D8469B1455EACC7FD63D")
    public void delete(int key) {
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            {
                mValues[i] = DELETED;
                mGarbage = true;
            } //End block
        } //End block
        addTaint(key);
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i >= 0) {
            //if (mValues[i] != DELETED) {
                //mValues[i] = DELETED;
                //mGarbage = true;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.300 -0400", hash_original_method = "EE51F875218CA8C1C2C8959A48F2A4BB", hash_generated_method = "A541873280F5B14A2E5AF66CDD6B2A31")
    public void remove(int key) {
        delete(key);
        addTaint(key);
        // ---------- Original Method ----------
        //delete(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.301 -0400", hash_original_method = "1992218C2CA2A9A793E8A4995C16BACA", hash_generated_method = "11AA72D0B0C5E13EDB85E84A76E794B2")
    public void removeAt(int index) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.310 -0400", hash_original_method = "92E5B832E30042BFCDC9211BA5952F8C", hash_generated_method = "881BBA9ECADDDC35BAEE45B0C3432ACE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.312 -0400", hash_original_method = "D431925AC076B56C67C685DECF88777D", hash_generated_method = "33661DDDF0E598A1F38711EFFBFB205D")
    public void put(int key, E value) {
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
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.312 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "A2AFBB66E46E490BB5D42F5AEDA80F25")
    public int size() {
        {
            gc();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1297479540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1297479540;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.322 -0400", hash_original_method = "AD3650995583655A8D059B5C8CE85FAD", hash_generated_method = "88591BB4376851A45498F0D33B556D07")
    public int keyAt(int index) {
        {
            gc();
        } //End block
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657024186 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657024186;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.323 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "9237BCD461B30A066A067B84273A0577")
    @SuppressWarnings("unchecked")
    public E valueAt(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_72696873 = null; //Variable for return #1
        {
            gc();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_72696873 = (E) mValues[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_72696873.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_72696873;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return (E) mValues[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.324 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "DC84236D6C02A331D1F56F5E93625B9F")
    public void setValueAt(int index, E value) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.340 -0400", hash_original_method = "2AE05DC6F4A524A5C2D1FCD4B3573FB7", hash_generated_method = "F28315C1349C06E7A6C092F7B1E892D9")
    public int indexOfKey(int key) {
        {
            gc();
        } //End block
        int varEF803A1EE726CA2553B95F3E48B65AD1_1600618267 = (binarySearch(mKeys, 0, mSize, key));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1547147511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1547147511;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.341 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "5E0346C4CBCE98039C49654B5405FF1F")
    public int indexOfValue(E value) {
        {
            gc();
        } //End block
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930894450 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930894450;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //for (int i = 0; i < mSize; i++)
            //if (mValues[i] == value)
                //return i;
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.341 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "0C4828A3CB0B54289774B69C4B300C28")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.350 -0400", hash_original_method = "5B63A048C0AD4A7F3A46491DB8DBCD38", hash_generated_method = "C8124B12BFCD77EE1DB340C749940564")
    public void append(int key, E value) {
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.350 -0400", hash_original_field = "92065CB108C8800DF5E4F0483558AC68", hash_generated_field = "6456E1D1AD9DCB9B6C6C03727663B20A")

    private static Object DELETED = new Object();
}


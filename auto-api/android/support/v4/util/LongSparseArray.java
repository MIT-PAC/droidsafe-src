package android.support.v4.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class LongSparseArray<E> implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.576 -0400", hash_original_field = "09A7D01F9A4EF2933D39C68D27937238", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.576 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "10A03D33DDA7196CABEC9D15EF00ADBE")

    private long[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.576 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.576 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.588 -0400", hash_original_method = "F893922E2C2E4CF6AF95C190516DB394", hash_generated_method = "6A1F4B6B8C0C50DC092B16F38EE20B61")
    public  LongSparseArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.589 -0400", hash_original_method = "16D402CE6C8A18B31360BC5A64438993", hash_generated_method = "AEF9E27E09EB9FFD1839E8E3B7419CA8")
    public  LongSparseArray(int initialCapacity) {
        initialCapacity = idealLongArraySize(initialCapacity);
        mKeys = new long[initialCapacity];
        mValues = new Object[initialCapacity];
        mSize = 0;
        // ---------- Original Method ----------
        //initialCapacity = idealLongArraySize(initialCapacity);
        //mKeys = new long[initialCapacity];
        //mValues = new Object[initialCapacity];
        //mSize = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.602 -0400", hash_original_method = "BABF4C30E15FB15D68E2A1BD6E5F56F5", hash_generated_method = "466E1B9D64ACCE78B6E1A145AD5C130A")
    @Override
    @SuppressWarnings("unchecked")
    public LongSparseArray<E> clone() {
        LongSparseArray<E> varB4EAC82CA7396A68D541C85D26508E83_1797536307 = null; //Variable for return #1
        LongSparseArray<E> clone;
        clone = null;
        try 
        {
            clone = (LongSparseArray<E>) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } //End block
        catch (CloneNotSupportedException cnse)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1797536307 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1797536307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1797536307;
        // ---------- Original Method ----------
        //LongSparseArray<E> clone = null;
        //try {
            //clone = (LongSparseArray<E>) super.clone();
            //clone.mKeys = mKeys.clone();
            //clone.mValues = mValues.clone();
        //} catch (CloneNotSupportedException cnse) {
        //}
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.603 -0400", hash_original_method = "4371A69A3700205284573EEAA3E6B17F", hash_generated_method = "4D519AA65FF1B59FB1BB4F8507F042C7")
    public E get(long key) {
        E varB4EAC82CA7396A68D541C85D26508E83_858536938 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_858536938 = get(key, null);
        addTaint(key);
        varB4EAC82CA7396A68D541C85D26508E83_858536938.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_858536938;
        // ---------- Original Method ----------
        //return get(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.604 -0400", hash_original_method = "E2D85B672251F3A6432F3D64B14D09C9", hash_generated_method = "33EE250832C2FC41422BB724AE53C5D4")
    @SuppressWarnings("unchecked")
    public E get(long key, E valueIfKeyNotFound) {
        E varB4EAC82CA7396A68D541C85D26508E83_1969685937 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_1041299723 = null; //Variable for return #2
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1969685937 = valueIfKeyNotFound;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1041299723 = (E) mValues[i];
        } //End block
        addTaint(key);
        addTaint(valueIfKeyNotFound.getTaint());
        E varA7E53CE21691AB073D9660D615818899_228636844; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_228636844 = varB4EAC82CA7396A68D541C85D26508E83_1969685937;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_228636844 = varB4EAC82CA7396A68D541C85D26508E83_1041299723;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_228636844.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_228636844;
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0 || mValues[i] == DELETED) {
            //return valueIfKeyNotFound;
        //} else {
            //return (E) mValues[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.605 -0400", hash_original_method = "D6F064C21D8F72C9BE34FD8563F8D233", hash_generated_method = "682D116CF160FBCD73C883DC575088D4")
    public void delete(long key) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.605 -0400", hash_original_method = "A104FD86A71D431024F36E7E390CA038", hash_generated_method = "155FAE649ACD3D549736C8ABC1158492")
    public void remove(long key) {
        delete(key);
        addTaint(key);
        // ---------- Original Method ----------
        //delete(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.622 -0400", hash_original_method = "1992218C2CA2A9A793E8A4995C16BACA", hash_generated_method = "11AA72D0B0C5E13EDB85E84A76E794B2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.623 -0400", hash_original_method = "DEC4F7080CE57358296ADF6582B59DD8", hash_generated_method = "CA4F0327B097F99127C8755A80E1C8D0")
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
        //long[] keys = mKeys;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.625 -0400", hash_original_method = "8BF7664EE3AA81913FF5A6B556936B07", hash_generated_method = "8799E4B9A1C2A93E91D349F76146BC1A")
    public void put(long key, E value) {
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
                n = idealLongArraySize(mSize + 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.626 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "47366CE6983BEFEB2D3B66A8C63EBD16")
    public int size() {
        {
            gc();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854895302 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854895302;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.627 -0400", hash_original_method = "B1F6BB5033A022FAFBEA87494F8412EB", hash_generated_method = "C9AA81D497001A390AA713C6E74DA1AD")
    public long keyAt(int index) {
        {
            gc();
        } //End block
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1191402793 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1191402793;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.647 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "06E0F4F66914FC8D7F828E13C20B183D")
    @SuppressWarnings("unchecked")
    public E valueAt(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_1075913525 = null; //Variable for return #1
        {
            gc();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1075913525 = (E) mValues[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1075913525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1075913525;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return (E) mValues[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.648 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "DC84236D6C02A331D1F56F5E93625B9F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.648 -0400", hash_original_method = "09C66188F9324AB9196B3AD659514994", hash_generated_method = "6C82452A44F6DC8EE46C7EA3E7DE96EF")
    public int indexOfKey(long key) {
        {
            gc();
        } //End block
        int varEF803A1EE726CA2553B95F3E48B65AD1_969672727 = (binarySearch(mKeys, 0, mSize, key));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559220974 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559220974;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.649 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "FFF4D2DD9BD338937B7174337F651229")
    public int indexOfValue(E value) {
        {
            gc();
        } //End block
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983708317 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983708317;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //for (int i = 0; i < mSize; i++)
            //if (mValues[i] == value)
                //return i;
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.656 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "0C4828A3CB0B54289774B69C4B300C28")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.658 -0400", hash_original_method = "4795393F1D971B9D48A1020105C314CF", hash_generated_method = "5A623E68079B4D8C162BEF6B22E31C79")
    public void append(long key, E value) {
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
            n = idealLongArraySize(pos + 1);
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
            //int n = idealLongArraySize(pos + 1);
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

    
        public static int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++)
            if (need <= (1 << i) - 12)
                return (1 << i) - 12;
        return need;
    }

    
        public static int idealLongArraySize(int need) {
        return idealByteArraySize(need * 8) / 8;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.659 -0400", hash_original_field = "92065CB108C8800DF5E4F0483558AC68", hash_generated_field = "6456E1D1AD9DCB9B6C6C03727663B20A")

    private static Object DELETED = new Object();
}


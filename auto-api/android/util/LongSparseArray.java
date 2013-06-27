package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class LongSparseArray<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.070 -0400", hash_original_field = "09A7D01F9A4EF2933D39C68D27937238", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.071 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "10A03D33DDA7196CABEC9D15EF00ADBE")

    private long[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.071 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.071 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.071 -0400", hash_original_method = "F893922E2C2E4CF6AF95C190516DB394", hash_generated_method = "6A1F4B6B8C0C50DC092B16F38EE20B61")
    public  LongSparseArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.072 -0400", hash_original_method = "69FE78AD0B4200050B3EDA46329CEBED", hash_generated_method = "2F8B33E1FC222BCBE8DE8718FECEA2E8")
    public  LongSparseArray(int initialCapacity) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.073 -0400", hash_original_method = "9447795B515DAD767A419A6C51E84D78", hash_generated_method = "8A49FB2C891E14F6199E381597CDF073")
    public long[] getKeys() {
        int length;
        length = mKeys.length;
        long[] result;
        result = new long[length];
        System.arraycopy(mKeys, 0, result, 0, length);
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_199831518 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_199831518;
        // ---------- Original Method ----------
        //int length = mKeys.length;
        //long[] result = new long[length];
        //System.arraycopy(mKeys, 0, result, 0, length);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.073 -0400", hash_original_method = "F8E34621620A1E3C4828967422EF7D07", hash_generated_method = "1DA234BDF0D09D3243BF71833C2401C4")
    public void setValues(long[] keys, E uniqueValue) {
        int length;
        length = keys.length;
        {
            int i;
            i = 0;
            {
                put(keys[i], uniqueValue);
            } //End block
        } //End collapsed parenthetic
        addTaint(keys[0]);
        addTaint(uniqueValue.getTaint());
        // ---------- Original Method ----------
        //int length = keys.length;
        //for (int i = 0; i < length; i++) {
            //put(keys[i], uniqueValue);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.077 -0400", hash_original_method = "4371A69A3700205284573EEAA3E6B17F", hash_generated_method = "D1AC5BFDEA581D6B248D81F0CF928E34")
    public E get(long key) {
        E varB4EAC82CA7396A68D541C85D26508E83_1418027735 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1418027735 = get(key, null);
        addTaint(key);
        varB4EAC82CA7396A68D541C85D26508E83_1418027735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1418027735;
        // ---------- Original Method ----------
        //return get(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.092 -0400", hash_original_method = "E2D85B672251F3A6432F3D64B14D09C9", hash_generated_method = "78A71438685C0E5C2B8AD213BD7F87B1")
    public E get(long key, E valueIfKeyNotFound) {
        E varB4EAC82CA7396A68D541C85D26508E83_1314889590 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_361216423 = null; //Variable for return #2
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1314889590 = valueIfKeyNotFound;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_361216423 = (E) mValues[i];
        } //End block
        addTaint(key);
        addTaint(valueIfKeyNotFound.getTaint());
        E varA7E53CE21691AB073D9660D615818899_189655215; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_189655215 = varB4EAC82CA7396A68D541C85D26508E83_1314889590;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_189655215 = varB4EAC82CA7396A68D541C85D26508E83_361216423;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_189655215.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_189655215;
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0 || mValues[i] == DELETED) {
            //return valueIfKeyNotFound;
        //} else {
            //return (E) mValues[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.093 -0400", hash_original_method = "D6F064C21D8F72C9BE34FD8563F8D233", hash_generated_method = "682D116CF160FBCD73C883DC575088D4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.101 -0400", hash_original_method = "A104FD86A71D431024F36E7E390CA038", hash_generated_method = "155FAE649ACD3D549736C8ABC1158492")
    public void remove(long key) {
        delete(key);
        addTaint(key);
        // ---------- Original Method ----------
        //delete(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.102 -0400", hash_original_method = "A9D8FA819E144A31281F443F869190B4", hash_generated_method = "C58ACD70F029E84CD8D05A3172FBDDEC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.118 -0400", hash_original_method = "A67B583D0E7AD982D1504BFCE2629D2E", hash_generated_method = "2A05A679264CD57795EEC1C289350E9F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.119 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "E72A68AB8FC3EF96CECDAF5DCFD3F903")
    public int size() {
        {
            gc();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_703872964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_703872964;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.119 -0400", hash_original_method = "B1F6BB5033A022FAFBEA87494F8412EB", hash_generated_method = "BE5A0EE9C07F16653E762B57CAD1F47B")
    public long keyAt(int index) {
        {
            gc();
        } //End block
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_620174347 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_620174347;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.131 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "84201EDB773112368079546D5EAC988F")
    public E valueAt(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_1141468990 = null; //Variable for return #1
        {
            gc();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1141468990 = (E) mValues[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1141468990.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1141468990;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return (E) mValues[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.132 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "DC84236D6C02A331D1F56F5E93625B9F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.136 -0400", hash_original_method = "09C66188F9324AB9196B3AD659514994", hash_generated_method = "E93DF7962506E9C4DE4CDECFA7ECB931")
    public int indexOfKey(long key) {
        {
            gc();
        } //End block
        int varEF803A1EE726CA2553B95F3E48B65AD1_1355093560 = (binarySearch(mKeys, 0, mSize, key));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_848070954 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_848070954;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.152 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "B7C46C9002A29F58DB16C5C5E7D06B7C")
    public int indexOfValue(E value) {
        {
            gc();
        } //End block
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556844153 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556844153;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //for (int i = 0; i < mSize; i++)
            //if (mValues[i] == value)
                //return i;
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.153 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "0C4828A3CB0B54289774B69C4B300C28")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.154 -0400", hash_original_method = "0B04A70E2C13FA00A3C14F0564BE387C", hash_generated_method = "2FBB30DF187420B1F9975538354D2263")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.161 -0400", hash_original_method = "B88BEB15E15C0A7F30A2606914985D6D", hash_generated_method = "2B738B199FBF97C6691F88C379516160")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.161 -0400", hash_original_field = "92065CB108C8800DF5E4F0483558AC68", hash_generated_field = "6456E1D1AD9DCB9B6C6C03727663B20A")

    private static Object DELETED = new Object();
}


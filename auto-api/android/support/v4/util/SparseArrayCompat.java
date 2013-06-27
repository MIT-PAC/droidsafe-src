package android.support.v4.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SparseArrayCompat<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.858 -0400", hash_original_field = "09A7D01F9A4EF2933D39C68D27937238", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.858 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.858 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.858 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.858 -0400", hash_original_method = "852197A14CD77BDEC27A8A7AFA07662E", hash_generated_method = "FC5CCB1F58FC6EAA98D5C9D204348719")
    public  SparseArrayCompat() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.868 -0400", hash_original_method = "9D9122CB8619CFE228E107EF9174420D", hash_generated_method = "A08B58E64A279A233B60652615D7E9A7")
    public  SparseArrayCompat(int initialCapacity) {
        initialCapacity = idealIntArraySize(initialCapacity);
        mKeys = new int[initialCapacity];
        mValues = new Object[initialCapacity];
        mSize = 0;
        // ---------- Original Method ----------
        //initialCapacity = idealIntArraySize(initialCapacity);
        //mKeys = new int[initialCapacity];
        //mValues = new Object[initialCapacity];
        //mSize = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.877 -0400", hash_original_method = "63029C5D60DB5A1F0C43DA1A71993094", hash_generated_method = "BC24E83AD43AF8C6448A657CE05B6C00")
    public E get(int key) {
        E varB4EAC82CA7396A68D541C85D26508E83_653323597 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_653323597 = get(key, null);
        addTaint(key);
        varB4EAC82CA7396A68D541C85D26508E83_653323597.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_653323597;
        // ---------- Original Method ----------
        //return get(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.878 -0400", hash_original_method = "C9E62D05249D95E7C50A204FF58AB455", hash_generated_method = "34A7E8640D38C902380EB4CF306C1CA4")
    public E get(int key, E valueIfKeyNotFound) {
        E varB4EAC82CA7396A68D541C85D26508E83_1753255975 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_1960191209 = null; //Variable for return #2
        int i;
        i = binarySearch(mKeys, 0, mSize, key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1753255975 = valueIfKeyNotFound;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1960191209 = (E) mValues[i];
        } //End block
        addTaint(key);
        addTaint(valueIfKeyNotFound.getTaint());
        E varA7E53CE21691AB073D9660D615818899_697052686; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_697052686 = varB4EAC82CA7396A68D541C85D26508E83_1753255975;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_697052686 = varB4EAC82CA7396A68D541C85D26508E83_1960191209;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_697052686.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_697052686;
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0 || mValues[i] == DELETED) {
            //return valueIfKeyNotFound;
        //} else {
            //return (E) mValues[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.882 -0400", hash_original_method = "D16C073A10FD3671AE05EBC49E38DA17", hash_generated_method = "F3F5B9DEC4C2D8469B1455EACC7FD63D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.882 -0400", hash_original_method = "EE51F875218CA8C1C2C8959A48F2A4BB", hash_generated_method = "A541873280F5B14A2E5AF66CDD6B2A31")
    public void remove(int key) {
        delete(key);
        addTaint(key);
        // ---------- Original Method ----------
        //delete(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.883 -0400", hash_original_method = "1992218C2CA2A9A793E8A4995C16BACA", hash_generated_method = "11AA72D0B0C5E13EDB85E84A76E794B2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.883 -0400", hash_original_method = "2C5263E549B4F001B6A4C4F0C63C3EBE", hash_generated_method = "E91D1C6C263DBAD57196E7D40220EAF7")
    public void removeAtRange(int index, int size) {
        int end;
        end = Math.min(mSize, index + size);
        {
            int i;
            i = index;
            {
                removeAt(i);
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        addTaint(size);
        // ---------- Original Method ----------
        //final int end = Math.min(mSize, index + size);
        //for (int i = index; i < end; i++) {
            //removeAt(i);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.884 -0400", hash_original_method = "7868047E3541D358CB50D9A842861F65", hash_generated_method = "0647CFA236C79ABB2BB450B9555A7CC4")
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
                //}
                //o++;
            //}
        //}
        //mGarbage = false;
        //mSize = o;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.900 -0400", hash_original_method = "954FE01203E8E0B89D8DDB8D29119B01", hash_generated_method = "ED07C9C4452110EA09875E41ED20A9A7")
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
                n = idealIntArraySize(mSize + 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.900 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "5EDD835CCB8A1AA3B5453F4602610EEB")
    public int size() {
        {
            gc();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_306398870 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_306398870;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.909 -0400", hash_original_method = "AD3650995583655A8D059B5C8CE85FAD", hash_generated_method = "FB3F903C63292C4404A0759F60D3440A")
    public int keyAt(int index) {
        {
            gc();
        } //End block
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_377189181 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_377189181;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.927 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "A2114DEFDBBFC02E35531F7C8B5F14D1")
    public E valueAt(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_494973519 = null; //Variable for return #1
        {
            gc();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_494973519 = (E) mValues[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_494973519.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_494973519;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return (E) mValues[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.928 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "DC84236D6C02A331D1F56F5E93625B9F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.929 -0400", hash_original_method = "2AE05DC6F4A524A5C2D1FCD4B3573FB7", hash_generated_method = "36FC12FBB49D15EEAA29F749C92B2228")
    public int indexOfKey(int key) {
        {
            gc();
        } //End block
        int varEF803A1EE726CA2553B95F3E48B65AD1_539507248 = (binarySearch(mKeys, 0, mSize, key));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1498651108 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1498651108;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.929 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "2F8EDAC19D98AB65B594AA6B381F8A11")
    public int indexOfValue(E value) {
        {
            gc();
        } //End block
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_525578043 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_525578043;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //for (int i = 0; i < mSize; i++)
            //if (mValues[i] == value)
                //return i;
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.930 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "0C4828A3CB0B54289774B69C4B300C28")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.931 -0400", hash_original_method = "9C68345D80E74B8E583DD83B51C68973", hash_generated_method = "1B4A0F7000D2D9DFBE69F5EED22E7C1C")
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
            n = idealIntArraySize(pos + 1);
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
            //int n = idealIntArraySize(pos + 1);
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

    
        static int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++)
            if (need <= (1 << i) - 12)
                return (1 << i) - 12;
        return need;
    }

    
        static int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.963 -0400", hash_original_field = "92065CB108C8800DF5E4F0483558AC68", hash_generated_field = "6456E1D1AD9DCB9B6C6C03727663B20A")

    private static Object DELETED = new Object();
}


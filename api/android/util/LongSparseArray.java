package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.util.ArrayUtils;

public class LongSparseArray<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.998 -0400", hash_original_field = "09A7D01F9A4EF2933D39C68D27937238", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.998 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "10A03D33DDA7196CABEC9D15EF00ADBE")

    private long[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.998 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.998 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.998 -0400", hash_original_method = "F893922E2C2E4CF6AF95C190516DB394", hash_generated_method = "6A1F4B6B8C0C50DC092B16F38EE20B61")
    public  LongSparseArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.999 -0400", hash_original_method = "69FE78AD0B4200050B3EDA46329CEBED", hash_generated_method = "2F8B33E1FC222BCBE8DE8718FECEA2E8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.999 -0400", hash_original_method = "9447795B515DAD767A419A6C51E84D78", hash_generated_method = "120436782BBFA9C809453E76AD20D849")
    public long[] getKeys() {
        int length = mKeys.length;
        long[] result = new long[length];
        System.arraycopy(mKeys, 0, result, 0, length);
        long[] varB4A88417B3D0170D754C647C30B7216A_1940324523 = (result);
                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1789014745 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1789014745;
        // ---------- Original Method ----------
        //int length = mKeys.length;
        //long[] result = new long[length];
        //System.arraycopy(mKeys, 0, result, 0, length);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.000 -0400", hash_original_method = "F8E34621620A1E3C4828967422EF7D07", hash_generated_method = "F65B88B7C2216D28197498FC6B402B99")
    public void setValues(long[] keys, E uniqueValue) {
        addTaint(uniqueValue.getTaint());
        addTaint(keys[0]);
        int length = keys.length;
for(int i = 0;i < length;i++)
        {
            put(keys[i], uniqueValue);
        } //End block
        // ---------- Original Method ----------
        //int length = keys.length;
        //for (int i = 0; i < length; i++) {
            //put(keys[i], uniqueValue);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.000 -0400", hash_original_method = "4371A69A3700205284573EEAA3E6B17F", hash_generated_method = "435A9DCFF3705335D3D8C7D0BB760E09")
    public E get(long key) {
        addTaint(key);
E varB73A11C4827B454321D868D4D1819714_1537622244 =         get(key, null);
        varB73A11C4827B454321D868D4D1819714_1537622244.addTaint(taint);
        return varB73A11C4827B454321D868D4D1819714_1537622244;
        // ---------- Original Method ----------
        //return get(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.001 -0400", hash_original_method = "E2D85B672251F3A6432F3D64B14D09C9", hash_generated_method = "D68DB38DA4479112D462AD9B64F3CA9E")
    public E get(long key, E valueIfKeyNotFound) {
        addTaint(valueIfKeyNotFound.getTaint());
        addTaint(key);
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i < 0 || mValues[i] == DELETED)        
        {
E var71321CF999B39AD93438E8ED59522752_437883776 =             valueIfKeyNotFound;
            var71321CF999B39AD93438E8ED59522752_437883776.addTaint(taint);
            return var71321CF999B39AD93438E8ED59522752_437883776;
        } //End block
        else
        {
E var9A906597833C8E11199C8E4BAC361563_1667460449 =             (E) mValues[i];
            var9A906597833C8E11199C8E4BAC361563_1667460449.addTaint(taint);
            return var9A906597833C8E11199C8E4BAC361563_1667460449;
        } //End block
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0 || mValues[i] == DELETED) {
            //return valueIfKeyNotFound;
        //} else {
            //return (E) mValues[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.001 -0400", hash_original_method = "D6F064C21D8F72C9BE34FD8563F8D233", hash_generated_method = "CF17BD7C013BDCBF019F34F878EC7475")
    public void delete(long key) {
        addTaint(key);
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i >= 0)        
        {
    if(mValues[i] != DELETED)            
            {
                mValues[i] = DELETED;
                mGarbage = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i >= 0) {
            //if (mValues[i] != DELETED) {
                //mValues[i] = DELETED;
                //mGarbage = true;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.002 -0400", hash_original_method = "A104FD86A71D431024F36E7E390CA038", hash_generated_method = "08E9C063C5ADE9F4ED8C6B9004580137")
    public void remove(long key) {
        addTaint(key);
        delete(key);
        // ---------- Original Method ----------
        //delete(key);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.003 -0400", hash_original_method = "A9D8FA819E144A31281F443F869190B4", hash_generated_method = "8C06E3E29373946E775F8591664FBD65")
    private void gc() {
        int n = mSize;
        int o = 0;
        long[] keys = mKeys;
        Object[] values = mValues;
for(int i = 0;i < n;i++)
        {
            Object val = values[i];
    if(val != DELETED)            
            {
    if(i != o)                
                {
                    keys[o] = keys[i];
                    values[o] = val;
                } //End block
                o++;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.005 -0400", hash_original_method = "A67B583D0E7AD982D1504BFCE2629D2E", hash_generated_method = "BEDCB5FF8597F24B8FA617470519D827")
    public void put(long key, E value) {
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i >= 0)        
        {
            mValues[i] = value;
        } //End block
        else
        {
            i = ~i;
    if(i < mSize && mValues[i] == DELETED)            
            {
                mKeys[i] = key;
                mValues[i] = value;
                return;
            } //End block
    if(mGarbage && mSize >= mKeys.length)            
            {
                gc();
                i = ~binarySearch(mKeys, 0, mSize, key);
            } //End block
    if(mSize >= mKeys.length)            
            {
                int n = ArrayUtils.idealIntArraySize(mSize + 1);
                long[] nkeys = new long[n];
                Object[] nvalues = new Object[n];
                System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
                System.arraycopy(mValues, 0, nvalues, 0, mValues.length);
                mKeys = nkeys;
                mValues = nvalues;
            } //End block
    if(mSize - i != 0)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.005 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "B6C711389348992AB5F3752154C1CB12")
    public int size() {
    if(mGarbage)        
        {
            gc();
        } //End block
        int var27DFA0EFE73BCB065533443A05E9DEE4_34213660 = (mSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876477218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876477218;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.005 -0400", hash_original_method = "B1F6BB5033A022FAFBEA87494F8412EB", hash_generated_method = "1E3654D303C666092CE67A534F90634E")
    public long keyAt(int index) {
        addTaint(index);
    if(mGarbage)        
        {
            gc();
        } //End block
        long var3A009E05729778D41B3FA1B029E6698B_1681689254 = (mKeys[index]);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2030239231 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2030239231;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mKeys[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.006 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "6688D05030132B8FF48B8E421512F5C7")
    public E valueAt(int index) {
        addTaint(index);
    if(mGarbage)        
        {
            gc();
        } //End block
E varFD8FAAC0C3572ACBC73A56817ABFB8BB_1242344100 =         (E) mValues[index];
        varFD8FAAC0C3572ACBC73A56817ABFB8BB_1242344100.addTaint(taint);
        return varFD8FAAC0C3572ACBC73A56817ABFB8BB_1242344100;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return (E) mValues[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.006 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "C9DDB9E9EA02C5782F8816164CB68524")
    public void setValueAt(int index, E value) {
    if(mGarbage)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.007 -0400", hash_original_method = "09C66188F9324AB9196B3AD659514994", hash_generated_method = "66A6B3671EE761FFF4172B208AD32B4E")
    public int indexOfKey(long key) {
        addTaint(key);
    if(mGarbage)        
        {
            gc();
        } //End block
        int var3C05684F465B8C390E8426D688C55DF4_226901973 = (binarySearch(mKeys, 0, mSize, key));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1980780069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1980780069;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.007 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "6CE9E3D990F090E00CD0A28DD1683C47")
    public int indexOfValue(E value) {
        addTaint(value.getTaint());
    if(mGarbage)        
        {
            gc();
        } //End block
for(int i = 0;i < mSize;i++)
    if(mValues[i] == value)        
        {
        int var865C0C0B4AB0E063E5CAA3387C1A8741_489880524 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222951690 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222951690;
        }
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1285364320 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497670267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497670267;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //for (int i = 0; i < mSize; i++)
            //if (mValues[i] == value)
                //return i;
        //return -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.008 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "61ED33368900ED20EB0D15BBCF4A009A")
    public void clear() {
        int n = mSize;
        Object[] values = mValues;
for(int i = 0;i < n;i++)
        {
            values[i] = null;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.008 -0400", hash_original_method = "0B04A70E2C13FA00A3C14F0564BE387C", hash_generated_method = "E8F6C775F31EEB08BE8D9DB280F8CBD3")
    public void append(long key, E value) {
    if(mSize != 0 && key <= mKeys[mSize - 1])        
        {
            put(key, value);
            return;
        } //End block
    if(mGarbage && mSize >= mKeys.length)        
        {
            gc();
        } //End block
        int pos = mSize;
    if(pos >= mKeys.length)        
        {
            int n = ArrayUtils.idealIntArraySize(pos + 1);
            long[] nkeys = new long[n];
            Object[] nvalues = new Object[n];
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

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.009 -0400", hash_original_method = "B88BEB15E15C0A7F30A2606914985D6D", hash_generated_method = "FB233834E0E1E435A8128C0A429FFF94")
    private void checkIntegrity() {
for(int i = 1;i < mSize;i++)
        {
    if(mKeys[i] <= mKeys[i - 1])            
            {
for(int j = 0;j < mSize;j++)
                {
                } //End block
                RuntimeException varF1484B21EF4EE84F790184975238945B_947028073 = new RuntimeException();
                varF1484B21EF4EE84F790184975238945B_947028073.addTaint(taint);
                throw varF1484B21EF4EE84F790184975238945B_947028073;
            } //End block
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.010 -0400", hash_original_field = "92065CB108C8800DF5E4F0483558AC68", hash_generated_field = "FCFA6BA9119CC3C1F3EE77ED9D99A0CB")

    private static final Object DELETED = new Object();
}


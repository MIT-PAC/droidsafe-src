package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class LongSparseArray<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.380 -0400", hash_original_field = "09A7D01F9A4EF2933D39C68D27937238", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.380 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "10A03D33DDA7196CABEC9D15EF00ADBE")

    private long[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.380 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.380 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.381 -0400", hash_original_method = "F893922E2C2E4CF6AF95C190516DB394", hash_generated_method = "6A1F4B6B8C0C50DC092B16F38EE20B61")
    public  LongSparseArray() {
        this(10);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.381 -0400", hash_original_method = "69FE78AD0B4200050B3EDA46329CEBED", hash_generated_method = "2F8B33E1FC222BCBE8DE8718FECEA2E8")
    public  LongSparseArray(int initialCapacity) {
        initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        mKeys = new long[initialCapacity];
        mValues = new Object[initialCapacity];
        mSize = 0;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.381 -0400", hash_original_method = "9447795B515DAD767A419A6C51E84D78", hash_generated_method = "01121450D2C032A08BB56EC9D2CB0051")
    public long[] getKeys() {
        int length = mKeys.length;
        long[] result = new long[length];
        System.arraycopy(mKeys, 0, result, 0, length);
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_82987294 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_82987294;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.382 -0400", hash_original_method = "F8E34621620A1E3C4828967422EF7D07", hash_generated_method = "9A42060C1D3C6C31B74F087D42D23212")
    public void setValues(long[] keys, E uniqueValue) {
        int length = keys.length;
        {
            int i = 0;
            {
                put(keys[i], uniqueValue);
            } 
        } 
        addTaint(keys[0]);
        addTaint(uniqueValue.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.382 -0400", hash_original_method = "4371A69A3700205284573EEAA3E6B17F", hash_generated_method = "5AF5260FA58F877A11A378FC386BDB5B")
    public E get(long key) {
        E varB4EAC82CA7396A68D541C85D26508E83_809038415 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_809038415 = get(key, null);
        addTaint(key);
        varB4EAC82CA7396A68D541C85D26508E83_809038415.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_809038415;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.384 -0400", hash_original_method = "E2D85B672251F3A6432F3D64B14D09C9", hash_generated_method = "9BF72C4C180D818BEDB57D2EA9A8FFC4")
    public E get(long key, E valueIfKeyNotFound) {
        E varB4EAC82CA7396A68D541C85D26508E83_284505273 = null; 
        E varB4EAC82CA7396A68D541C85D26508E83_1987546788 = null; 
        int i = binarySearch(mKeys, 0, mSize, key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_284505273 = valueIfKeyNotFound;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1987546788 = (E) mValues[i];
        } 
        addTaint(key);
        addTaint(valueIfKeyNotFound.getTaint());
        E varA7E53CE21691AB073D9660D615818899_1013426256; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1013426256 = varB4EAC82CA7396A68D541C85D26508E83_284505273;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1013426256 = varB4EAC82CA7396A68D541C85D26508E83_1987546788;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1013426256.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1013426256;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.384 -0400", hash_original_method = "D6F064C21D8F72C9BE34FD8563F8D233", hash_generated_method = "F5405EEA777AC518B8149872CD7D7FB3")
    public void delete(long key) {
        int i = binarySearch(mKeys, 0, mSize, key);
        {
            {
                mValues[i] = DELETED;
                mGarbage = true;
            } 
        } 
        addTaint(key);
        
        
        
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.384 -0400", hash_original_method = "A104FD86A71D431024F36E7E390CA038", hash_generated_method = "155FAE649ACD3D549736C8ABC1158492")
    public void remove(long key) {
        delete(key);
        addTaint(key);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.385 -0400", hash_original_method = "A9D8FA819E144A31281F443F869190B4", hash_generated_method = "7B62E9757C5DB4A6BFD1D3137D287BDF")
    private void gc() {
        int n = mSize;
        int o = 0;
        long[] keys = mKeys;
        Object[] values = mValues;
        {
            int i = 0;
            {
                Object val = values[i];
                {
                    {
                        keys[o] = keys[i];
                        values[o] = val;
                    } 
                } 
            } 
        } 
        mGarbage = false;
        mSize = o;
        
        
        
        
        
        
            
            
                
                    
                    
                
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.386 -0400", hash_original_method = "A67B583D0E7AD982D1504BFCE2629D2E", hash_generated_method = "3C1E9DDD8A3EF38D4398BE9A6D8246AA")
    public void put(long key, E value) {
        int i = binarySearch(mKeys, 0, mSize, key);
        {
            mValues[i] = value;
        } 
        {
            i = ~i;
            {
                mKeys[i] = key;
                mValues[i] = value;
            } 
            {
                gc();
                i = ~binarySearch(mKeys, 0, mSize, key);
            } 
            {
                int n = ArrayUtils.idealIntArraySize(mSize + 1);
                long[] nkeys = new long[n];
                Object[] nvalues = new Object[n];
                System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
                System.arraycopy(mValues, 0, nvalues, 0, mValues.length);
                mKeys = nkeys;
                mValues = nvalues;
            } 
            {
                System.arraycopy(mKeys, i, mKeys, i + 1, mSize - i);
                System.arraycopy(mValues, i, mValues, i + 1, mSize - i);
            } 
            mKeys[i] = key;
            mValues[i] = value;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.386 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "0A95A0F1760EC1864C964F76D68C23EE")
    public int size() {
        {
            gc();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090126459 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090126459;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.386 -0400", hash_original_method = "B1F6BB5033A022FAFBEA87494F8412EB", hash_generated_method = "A9D665F7A59CD1CF2B98599BFAFC95BA")
    public long keyAt(int index) {
        {
            gc();
        } 
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1098165878 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1098165878;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.387 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "9DA783902E36A26243DC52EC59E101C1")
    public E valueAt(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_1500145960 = null; 
        {
            gc();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1500145960 = (E) mValues[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1500145960.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1500145960;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.387 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "DC84236D6C02A331D1F56F5E93625B9F")
    public void setValueAt(int index, E value) {
        {
            gc();
        } 
        mValues[index] = value;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.388 -0400", hash_original_method = "09C66188F9324AB9196B3AD659514994", hash_generated_method = "ECC754AFAB7895A3EC61ED4A68E17656")
    public int indexOfKey(long key) {
        {
            gc();
        } 
        int varEF803A1EE726CA2553B95F3E48B65AD1_2011594429 = (binarySearch(mKeys, 0, mSize, key));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603503994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603503994;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.388 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "CA1DA2C9D11DB880E92C786D4B233069")
    public int indexOfValue(E value) {
        {
            gc();
        } 
        {
            int i = 0;
        } 
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915931041 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915931041;
        
        
            
        
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.388 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "A99674D52ED0A179724028E7A97AAE26")
    public void clear() {
        int n = mSize;
        Object[] values = mValues;
        {
            int i = 0;
            {
                values[i] = null;
            } 
        } 
        mSize = 0;
        mGarbage = false;
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.389 -0400", hash_original_method = "0B04A70E2C13FA00A3C14F0564BE387C", hash_generated_method = "A515B3B30607CC66D61CA598E3AE8013")
    public void append(long key, E value) {
        {
            put(key, value);
        } 
        {
            gc();
        } 
        int pos = mSize;
        {
            int n = ArrayUtils.idealIntArraySize(pos + 1);
            long[] nkeys = new long[n];
            Object[] nvalues = new Object[n];
            System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
            System.arraycopy(mValues, 0, nvalues, 0, mValues.length);
            mKeys = nkeys;
            mValues = nvalues;
        } 
        mKeys[pos] = key;
        mValues[pos] = value;
        mSize = pos + 1;
        
        
            
            
        
        
            
        
        
        
            
            
            
            
            
            
            
        
        
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.390 -0400", hash_original_method = "B88BEB15E15C0A7F30A2606914985D6D", hash_generated_method = "0BB794AB4B21A2792983CC800D33736A")
    private void checkIntegrity() {
        {
            int i = 1;
            {
                {
                    {
                        int j = 0;
                    } 
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
                } 
            } 
        } 
        
        
            
                
                    
                
                
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.390 -0400", hash_original_field = "92065CB108C8800DF5E4F0483558AC68", hash_generated_field = "FCFA6BA9119CC3C1F3EE77ED9D99A0CB")

    private static final Object DELETED = new Object();
}


package android.support.v4.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SparseArrayCompat<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.598 -0400", hash_original_field = "09A7D01F9A4EF2933D39C68D27937238", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.598 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.598 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.598 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.598 -0400", hash_original_method = "852197A14CD77BDEC27A8A7AFA07662E", hash_generated_method = "FC5CCB1F58FC6EAA98D5C9D204348719")
    public  SparseArrayCompat() {
        this(10);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.599 -0400", hash_original_method = "9D9122CB8619CFE228E107EF9174420D", hash_generated_method = "A08B58E64A279A233B60652615D7E9A7")
    public  SparseArrayCompat(int initialCapacity) {
        initialCapacity = idealIntArraySize(initialCapacity);
        mKeys = new int[initialCapacity];
        mValues = new Object[initialCapacity];
        mSize = 0;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.600 -0400", hash_original_method = "63029C5D60DB5A1F0C43DA1A71993094", hash_generated_method = "A33A9D930C349F1189BD055698DAAB31")
    public E get(int key) {
        addTaint(key);
E varB73A11C4827B454321D868D4D1819714_1426584779 =         get(key, null);
        varB73A11C4827B454321D868D4D1819714_1426584779.addTaint(taint);
        return varB73A11C4827B454321D868D4D1819714_1426584779;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.600 -0400", hash_original_method = "C9E62D05249D95E7C50A204FF58AB455", hash_generated_method = "C5083D9EA9E4DB05D88C386690930A43")
    public E get(int key, E valueIfKeyNotFound) {
        addTaint(valueIfKeyNotFound.getTaint());
        addTaint(key);
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i < 0 || mValues[i] == DELETED)        
        {
E var71321CF999B39AD93438E8ED59522752_788795810 =             valueIfKeyNotFound;
            var71321CF999B39AD93438E8ED59522752_788795810.addTaint(taint);
            return var71321CF999B39AD93438E8ED59522752_788795810;
        } 
        else
        {
E var9A906597833C8E11199C8E4BAC361563_1134367384 =             (E) mValues[i];
            var9A906597833C8E11199C8E4BAC361563_1134367384.addTaint(taint);
            return var9A906597833C8E11199C8E4BAC361563_1134367384;
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.601 -0400", hash_original_method = "D16C073A10FD3671AE05EBC49E38DA17", hash_generated_method = "D40CE1717731410AA2972ACDA51E344E")
    public void delete(int key) {
        addTaint(key);
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i >= 0)        
        {
    if(mValues[i] != DELETED)            
            {
                mValues[i] = DELETED;
                mGarbage = true;
            } 
        } 
        
        
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.601 -0400", hash_original_method = "EE51F875218CA8C1C2C8959A48F2A4BB", hash_generated_method = "31B38247D7E21D1B1118F942D733A6EC")
    public void remove(int key) {
        addTaint(key);
        delete(key);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.602 -0400", hash_original_method = "1992218C2CA2A9A793E8A4995C16BACA", hash_generated_method = "CA640CDFEEE9EE6687BB0AE18A3535CE")
    public void removeAt(int index) {
    if(mValues[index] != DELETED)        
        {
            mValues[index] = DELETED;
            mGarbage = true;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.602 -0400", hash_original_method = "2C5263E549B4F001B6A4C4F0C63C3EBE", hash_generated_method = "EBA03DAF57CC7BB8DE07C1BF8CB32496")
    public void removeAtRange(int index, int size) {
        addTaint(size);
        addTaint(index);
        final int end = Math.min(mSize, index + size);
for(int i = index;i < end;i++)
        {
            removeAt(i);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.603 -0400", hash_original_method = "7868047E3541D358CB50D9A842861F65", hash_generated_method = "CA3EB3DE5B4A330ED8C8F6988D7EE3A9")
    private void gc() {
        int n = mSize;
        int o = 0;
        int[] keys = mKeys;
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
                } 
                o++;
            } 
        } 
        mGarbage = false;
        mSize = o;
        
        
        
        
        
        
            
            
                
                    
                    
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.606 -0400", hash_original_method = "954FE01203E8E0B89D8DDB8D29119B01", hash_generated_method = "D59FD80C727EF55225FEEE95B4F38710")
    public void put(int key, E value) {
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i >= 0)        
        {
            mValues[i] = value;
        } 
        else
        {
            i = ~i;
    if(i < mSize && mValues[i] == DELETED)            
            {
                mKeys[i] = key;
                mValues[i] = value;
                return;
            } 
    if(mGarbage && mSize >= mKeys.length)            
            {
                gc();
                i = ~binarySearch(mKeys, 0, mSize, key);
            } 
    if(mSize >= mKeys.length)            
            {
                int n = idealIntArraySize(mSize + 1);
                int[] nkeys = new int[n];
                Object[] nvalues = new Object[n];
                System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
                System.arraycopy(mValues, 0, nvalues, 0, mValues.length);
                mKeys = nkeys;
                mValues = nvalues;
            } 
    if(mSize - i != 0)            
            {
                System.arraycopy(mKeys, i, mKeys, i + 1, mSize - i);
                System.arraycopy(mValues, i, mValues, i + 1, mSize - i);
            } 
            mKeys[i] = key;
            mValues[i] = value;
            mSize++;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.607 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "65AF29731410BEF3F25AE591D15136B1")
    public int size() {
    if(mGarbage)        
        {
            gc();
        } 
        int var27DFA0EFE73BCB065533443A05E9DEE4_284295029 = (mSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739579232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739579232;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.608 -0400", hash_original_method = "AD3650995583655A8D059B5C8CE85FAD", hash_generated_method = "34E03FBB8BFACBB6DB559B5B0BA1E42C")
    public int keyAt(int index) {
        addTaint(index);
    if(mGarbage)        
        {
            gc();
        } 
        int var3A009E05729778D41B3FA1B029E6698B_1255317914 = (mKeys[index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_773875747 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_773875747;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.608 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "0EDA29448E435E58F980B76093494B10")
    public E valueAt(int index) {
        addTaint(index);
    if(mGarbage)        
        {
            gc();
        } 
E varFD8FAAC0C3572ACBC73A56817ABFB8BB_1278431279 =         (E) mValues[index];
        varFD8FAAC0C3572ACBC73A56817ABFB8BB_1278431279.addTaint(taint);
        return varFD8FAAC0C3572ACBC73A56817ABFB8BB_1278431279;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.609 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "C9DDB9E9EA02C5782F8816164CB68524")
    public void setValueAt(int index, E value) {
    if(mGarbage)        
        {
            gc();
        } 
        mValues[index] = value;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.609 -0400", hash_original_method = "2AE05DC6F4A524A5C2D1FCD4B3573FB7", hash_generated_method = "0307DA699FE9E91313EECEBD385EFAAC")
    public int indexOfKey(int key) {
        addTaint(key);
    if(mGarbage)        
        {
            gc();
        } 
        int var3C05684F465B8C390E8426D688C55DF4_290528070 = (binarySearch(mKeys, 0, mSize, key));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356712123 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356712123;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.610 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "16446FA4138FDB85E7194C3E9CBCFBAB")
    public int indexOfValue(E value) {
        addTaint(value.getTaint());
    if(mGarbage)        
        {
            gc();
        } 
for(int i = 0;i < mSize;i++)
    if(mValues[i] == value)        
        {
        int var865C0C0B4AB0E063E5CAA3387C1A8741_1959223678 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280961169 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280961169;
        }
        int var6BB61E3B7BCE0931DA574D19D1D82C88_978723591 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_85068144 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_85068144;
        
        
            
        
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.610 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "61ED33368900ED20EB0D15BBCF4A009A")
    public void clear() {
        int n = mSize;
        Object[] values = mValues;
for(int i = 0;i < n;i++)
        {
            values[i] = null;
        } 
        mSize = 0;
        mGarbage = false;
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.612 -0400", hash_original_method = "9C68345D80E74B8E583DD83B51C68973", hash_generated_method = "3E9410F49E8CC82B4273694F1F5FC272")
    public void append(int key, E value) {
    if(mSize != 0 && key <= mKeys[mSize - 1])        
        {
            put(key, value);
            return;
        } 
    if(mGarbage && mSize >= mKeys.length)        
        {
            gc();
        } 
        int pos = mSize;
    if(pos >= mKeys.length)        
        {
            int n = idealIntArraySize(pos + 1);
            int[] nkeys = new int[n];
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.613 -0400", hash_original_field = "92065CB108C8800DF5E4F0483558AC68", hash_generated_field = "FCFA6BA9119CC3C1F3EE77ED9D99A0CB")

    private static final Object DELETED = new Object();
}


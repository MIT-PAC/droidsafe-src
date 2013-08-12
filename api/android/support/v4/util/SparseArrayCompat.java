package android.support.v4.util;

// Droidsafe Imports
import droidsafe.annotations.*;





public class SparseArrayCompat<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.110 -0400", hash_original_field = "09A7D01F9A4EF2933D39C68D27937238", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.110 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.110 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.110 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.111 -0400", hash_original_method = "852197A14CD77BDEC27A8A7AFA07662E", hash_generated_method = "FC5CCB1F58FC6EAA98D5C9D204348719")
    public  SparseArrayCompat() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.112 -0400", hash_original_method = "9D9122CB8619CFE228E107EF9174420D", hash_generated_method = "A08B58E64A279A233B60652615D7E9A7")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.112 -0400", hash_original_method = "63029C5D60DB5A1F0C43DA1A71993094", hash_generated_method = "88CA91D5FDC33A4BC306A3D1C709E46B")
    public E get(int key) {
        addTaint(key);
E varB73A11C4827B454321D868D4D1819714_1187518068 =         get(key, null);
        varB73A11C4827B454321D868D4D1819714_1187518068.addTaint(taint);
        return varB73A11C4827B454321D868D4D1819714_1187518068;
        // ---------- Original Method ----------
        //return get(key, null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.113 -0400", hash_original_method = "C9E62D05249D95E7C50A204FF58AB455", hash_generated_method = "044DA702EFA24955A97B2EA83EFAC36C")
    public E get(int key, E valueIfKeyNotFound) {
        addTaint(valueIfKeyNotFound.getTaint());
        addTaint(key);
        int i = binarySearch(mKeys, 0, mSize, key);
        if(i < 0 || mValues[i] == DELETED)        
        {
E var71321CF999B39AD93438E8ED59522752_1616541749 =             valueIfKeyNotFound;
            var71321CF999B39AD93438E8ED59522752_1616541749.addTaint(taint);
            return var71321CF999B39AD93438E8ED59522752_1616541749;
        } //End block
        else
        {
E var9A906597833C8E11199C8E4BAC361563_521460119 =             (E) mValues[i];
            var9A906597833C8E11199C8E4BAC361563_521460119.addTaint(taint);
            return var9A906597833C8E11199C8E4BAC361563_521460119;
        } //End block
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0 || mValues[i] == DELETED) {
            //return valueIfKeyNotFound;
        //} else {
            //return (E) mValues[i];
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.113 -0400", hash_original_method = "D16C073A10FD3671AE05EBC49E38DA17", hash_generated_method = "D40CE1717731410AA2972ACDA51E344E")
    public void delete(int key) {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.114 -0400", hash_original_method = "EE51F875218CA8C1C2C8959A48F2A4BB", hash_generated_method = "31B38247D7E21D1B1118F942D733A6EC")
    public void remove(int key) {
        addTaint(key);
        delete(key);
        // ---------- Original Method ----------
        //delete(key);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.114 -0400", hash_original_method = "1992218C2CA2A9A793E8A4995C16BACA", hash_generated_method = "CA640CDFEEE9EE6687BB0AE18A3535CE")
    public void removeAt(int index) {
        if(mValues[index] != DELETED)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.114 -0400", hash_original_method = "2C5263E549B4F001B6A4C4F0C63C3EBE", hash_generated_method = "EBA03DAF57CC7BB8DE07C1BF8CB32496")
    public void removeAtRange(int index, int size) {
        addTaint(size);
        addTaint(index);
        final int end = Math.min(mSize, index + size);
for(int i = index;i < end;i++)
        {
            removeAt(i);
        } //End block
        // ---------- Original Method ----------
        //final int end = Math.min(mSize, index + size);
        //for (int i = index; i < end; i++) {
            //removeAt(i);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.115 -0400", hash_original_method = "7868047E3541D358CB50D9A842861F65", hash_generated_method = "CA3EB3DE5B4A330ED8C8F6988D7EE3A9")
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
                } //End block
                o++;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.118 -0400", hash_original_method = "954FE01203E8E0B89D8DDB8D29119B01", hash_generated_method = "D59FD80C727EF55225FEEE95B4F38710")
    public void put(int key, E value) {
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
                int n = idealIntArraySize(mSize + 1);
                int[] nkeys = new int[n];
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.120 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "2C9C388E2C0D60D808AFA8A3C525F70D")
    public int size() {
        if(mGarbage)        
        {
            gc();
        } //End block
        int var27DFA0EFE73BCB065533443A05E9DEE4_925552271 = (mSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410845768 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410845768;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.120 -0400", hash_original_method = "AD3650995583655A8D059B5C8CE85FAD", hash_generated_method = "0A4A8C9AD0710F46702E4138F8C7A313")
    public int keyAt(int index) {
        addTaint(index);
        if(mGarbage)        
        {
            gc();
        } //End block
        int var3A009E05729778D41B3FA1B029E6698B_366102930 = (mKeys[index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_28739812 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_28739812;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mKeys[index];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.120 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "21A267F5D0B48F7C93EAAFCBB5B141F5")
    public E valueAt(int index) {
        addTaint(index);
        if(mGarbage)        
        {
            gc();
        } //End block
E varFD8FAAC0C3572ACBC73A56817ABFB8BB_1727651179 =         (E) mValues[index];
        varFD8FAAC0C3572ACBC73A56817ABFB8BB_1727651179.addTaint(taint);
        return varFD8FAAC0C3572ACBC73A56817ABFB8BB_1727651179;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return (E) mValues[index];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.121 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "C9DDB9E9EA02C5782F8816164CB68524")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.122 -0400", hash_original_method = "2AE05DC6F4A524A5C2D1FCD4B3573FB7", hash_generated_method = "AB865A63A35909EA0323B152559EAC8A")
    public int indexOfKey(int key) {
        addTaint(key);
        if(mGarbage)        
        {
            gc();
        } //End block
        int var3C05684F465B8C390E8426D688C55DF4_880607292 = (binarySearch(mKeys, 0, mSize, key));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809509409 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809509409;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.122 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "65EF38B35C9025737A3E8DF1D91FC5F2")
    public int indexOfValue(E value) {
        addTaint(value.getTaint());
        if(mGarbage)        
        {
            gc();
        } //End block
for(int i = 0;i < mSize;i++)
        if(mValues[i] == value)        
        {
        int var865C0C0B4AB0E063E5CAA3387C1A8741_1544611178 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502013716 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502013716;
        }
        int var6BB61E3B7BCE0931DA574D19D1D82C88_111620710 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365866504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365866504;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.123 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "61ED33368900ED20EB0D15BBCF4A009A")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.123 -0400", hash_original_method = "9C68345D80E74B8E583DD83B51C68973", hash_generated_method = "3E9410F49E8CC82B4273694F1F5FC272")
    public void append(int key, E value) {
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
            int n = idealIntArraySize(pos + 1);
            int[] nkeys = new int[n];
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
    static int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++)
            if (need <= (1 << i) - 12)
                return (1 << i) - 12;
        return need;
    }

    
    @DSModeled(DSC.SAFE)
    static int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.124 -0400", hash_original_field = "92065CB108C8800DF5E4F0483558AC68", hash_generated_field = "FCFA6BA9119CC3C1F3EE77ED9D99A0CB")

    private static final Object DELETED = new Object();
}


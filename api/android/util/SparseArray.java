package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.util.ArrayUtils;

public class SparseArray<E> implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.119 -0400", hash_original_field = "09A7D01F9A4EF2933D39C68D27937238", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.119 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.119 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.119 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.120 -0400", hash_original_method = "E97D5EED29ED8377C999990C20A12343", hash_generated_method = "E245EEBE3057EE5A6B20AA3D7F52AD37")
    public  SparseArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.121 -0400", hash_original_method = "F193A0D2E79CC42C4145064D20AB5B71", hash_generated_method = "0CE585F4CFEAD80D83275E2B999CFA02")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.121 -0400", hash_original_method = "A950936C46135A90B64D99C98FBE0DD0", hash_generated_method = "1928A156791E1B32F9858BFA7CCEA689")
    @Override
    @SuppressWarnings("unchecked")
    public SparseArray<E> clone() {
        SparseArray<E> clone = null;
        try 
        {
            clone = (SparseArray<E>) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } //End block
        catch (CloneNotSupportedException cnse)
        {
        } //End block
SparseArray<E> var3DE52045BFD3C1BF3742F994ED6139AD_400646647 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_400646647.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_400646647;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.122 -0400", hash_original_method = "63029C5D60DB5A1F0C43DA1A71993094", hash_generated_method = "BD4C18830814519171F3859E27857B71")
    public E get(int key) {
        addTaint(key);
E varB73A11C4827B454321D868D4D1819714_1109239418 =         get(key, null);
        varB73A11C4827B454321D868D4D1819714_1109239418.addTaint(taint);
        return varB73A11C4827B454321D868D4D1819714_1109239418;
        // ---------- Original Method ----------
        //return get(key, null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.122 -0400", hash_original_method = "C9E62D05249D95E7C50A204FF58AB455", hash_generated_method = "0FC18AF5E0B2F6696A599D4585D92D27")
    @SuppressWarnings("unchecked")
    public E get(int key, E valueIfKeyNotFound) {
        addTaint(valueIfKeyNotFound.getTaint());
        addTaint(key);
        int i = binarySearch(mKeys, 0, mSize, key);
        if(i < 0 || mValues[i] == DELETED)        
        {
E var71321CF999B39AD93438E8ED59522752_991616894 =             valueIfKeyNotFound;
            var71321CF999B39AD93438E8ED59522752_991616894.addTaint(taint);
            return var71321CF999B39AD93438E8ED59522752_991616894;
        } //End block
        else
        {
E var9A906597833C8E11199C8E4BAC361563_447121620 =             (E) mValues[i];
            var9A906597833C8E11199C8E4BAC361563_447121620.addTaint(taint);
            return var9A906597833C8E11199C8E4BAC361563_447121620;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.123 -0400", hash_original_method = "D16C073A10FD3671AE05EBC49E38DA17", hash_generated_method = "D40CE1717731410AA2972ACDA51E344E")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.123 -0400", hash_original_method = "EE51F875218CA8C1C2C8959A48F2A4BB", hash_generated_method = "31B38247D7E21D1B1118F942D733A6EC")
    public void remove(int key) {
        addTaint(key);
        delete(key);
        // ---------- Original Method ----------
        //delete(key);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.124 -0400", hash_original_method = "1992218C2CA2A9A793E8A4995C16BACA", hash_generated_method = "CA640CDFEEE9EE6687BB0AE18A3535CE")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.125 -0400", hash_original_method = "92E5B832E30042BFCDC9211BA5952F8C", hash_generated_method = "248E34A5E02C6CAEA9549F87CABCB657")
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
                    values[i] = null;
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
                    //values[i] = null;
                //}
                //o++;
            //}
        //}
        //mGarbage = false;
        //mSize = o;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.127 -0400", hash_original_method = "D431925AC076B56C67C685DECF88777D", hash_generated_method = "CB25B13FFCC5E786C611D2207D35A7FC")
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
                int n = ArrayUtils.idealIntArraySize(mSize + 1);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.128 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "3AC58E730DBE5BE011C2F70C1FDE657F")
    public int size() {
        if(mGarbage)        
        {
            gc();
        } //End block
        int var27DFA0EFE73BCB065533443A05E9DEE4_598028124 = (mSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055813221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055813221;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.128 -0400", hash_original_method = "AD3650995583655A8D059B5C8CE85FAD", hash_generated_method = "E360C1BD7DB03661527F07711EB9AA89")
    public int keyAt(int index) {
        addTaint(index);
        if(mGarbage)        
        {
            gc();
        } //End block
        int var3A009E05729778D41B3FA1B029E6698B_394332431 = (mKeys[index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1821091717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1821091717;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return mKeys[index];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.129 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "36ED8803C6111551B308068AB5718709")
    @SuppressWarnings("unchecked")
    public E valueAt(int index) {
        addTaint(index);
        if(mGarbage)        
        {
            gc();
        } //End block
E varFD8FAAC0C3572ACBC73A56817ABFB8BB_755850410 =         (E) mValues[index];
        varFD8FAAC0C3572ACBC73A56817ABFB8BB_755850410.addTaint(taint);
        return varFD8FAAC0C3572ACBC73A56817ABFB8BB_755850410;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return (E) mValues[index];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.129 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "C9DDB9E9EA02C5782F8816164CB68524")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.130 -0400", hash_original_method = "2AE05DC6F4A524A5C2D1FCD4B3573FB7", hash_generated_method = "18EDB1682421D29B42E8B0994266328F")
    public int indexOfKey(int key) {
        addTaint(key);
        if(mGarbage)        
        {
            gc();
        } //End block
        int var3C05684F465B8C390E8426D688C55DF4_1477245093 = (binarySearch(mKeys, 0, mSize, key));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281470028 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281470028;
        // ---------- Original Method ----------
        //if (mGarbage) {
            //gc();
        //}
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.130 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "F68E7F96D79A1712A897120A7233200F")
    public int indexOfValue(E value) {
        addTaint(value.getTaint());
        if(mGarbage)        
        {
            gc();
        } //End block
for(int i = 0;i < mSize;i++)
        if(mValues[i] == value)        
        {
        int var865C0C0B4AB0E063E5CAA3387C1A8741_886402466 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911917682 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911917682;
        }
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1310243507 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836597227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836597227;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.131 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "61ED33368900ED20EB0D15BBCF4A009A")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.131 -0400", hash_original_method = "5B63A048C0AD4A7F3A46491DB8DBCD38", hash_generated_method = "E5BE7126557319647405778022C25AEE")
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
            int n = ArrayUtils.idealIntArraySize(pos + 1);
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.132 -0400", hash_original_field = "92065CB108C8800DF5E4F0483558AC68", hash_generated_field = "FCFA6BA9119CC3C1F3EE77ED9D99A0CB")

    private static final Object DELETED = new Object();
}


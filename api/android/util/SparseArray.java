package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.util.ArrayUtils;

public class SparseArray<E> implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.250 -0400", hash_original_field = "09A7D01F9A4EF2933D39C68D27937238", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.250 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.250 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.250 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.250 -0400", hash_original_method = "E97D5EED29ED8377C999990C20A12343", hash_generated_method = "E245EEBE3057EE5A6B20AA3D7F52AD37")
    public  SparseArray() {
        this(10);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.251 -0400", hash_original_method = "F193A0D2E79CC42C4145064D20AB5B71", hash_generated_method = "0CE585F4CFEAD80D83275E2B999CFA02")
    public  SparseArray(int initialCapacity) {
        initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        mKeys = new int[initialCapacity];
        mValues = new Object[initialCapacity];
        mSize = 0;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.252 -0400", hash_original_method = "A950936C46135A90B64D99C98FBE0DD0", hash_generated_method = "D9AEB55440201C6AE7C7FC3DE19B5EB0")
    @Override
    @SuppressWarnings("unchecked")
    public SparseArray<E> clone() {
        SparseArray<E> clone = null;
        try 
        {
            clone = (SparseArray<E>) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } 
        catch (CloneNotSupportedException cnse)
        {
        } 
SparseArray<E> var3DE52045BFD3C1BF3742F994ED6139AD_1654600270 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1654600270.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1654600270;
        
        
        
            
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.253 -0400", hash_original_method = "63029C5D60DB5A1F0C43DA1A71993094", hash_generated_method = "8D811DD1DEE46E1FB34A61754AEA16EE")
    public E get(int key) {
        addTaint(key);
E varB73A11C4827B454321D868D4D1819714_976702287 =         get(key, null);
        varB73A11C4827B454321D868D4D1819714_976702287.addTaint(taint);
        return varB73A11C4827B454321D868D4D1819714_976702287;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.253 -0400", hash_original_method = "C9E62D05249D95E7C50A204FF58AB455", hash_generated_method = "DA89B8EC72EF00AD21AEEB856B431A62")
    @SuppressWarnings("unchecked")
    public E get(int key, E valueIfKeyNotFound) {
        addTaint(valueIfKeyNotFound.getTaint());
        addTaint(key);
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i < 0 || mValues[i] == DELETED)        
        {
E var71321CF999B39AD93438E8ED59522752_1321313558 =             valueIfKeyNotFound;
            var71321CF999B39AD93438E8ED59522752_1321313558.addTaint(taint);
            return var71321CF999B39AD93438E8ED59522752_1321313558;
        } 
        else
        {
E var9A906597833C8E11199C8E4BAC361563_1310756004 =             (E) mValues[i];
            var9A906597833C8E11199C8E4BAC361563_1310756004.addTaint(taint);
            return var9A906597833C8E11199C8E4BAC361563_1310756004;
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.255 -0400", hash_original_method = "D16C073A10FD3671AE05EBC49E38DA17", hash_generated_method = "D40CE1717731410AA2972ACDA51E344E")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.256 -0400", hash_original_method = "EE51F875218CA8C1C2C8959A48F2A4BB", hash_generated_method = "31B38247D7E21D1B1118F942D733A6EC")
    public void remove(int key) {
        addTaint(key);
        delete(key);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.257 -0400", hash_original_method = "1992218C2CA2A9A793E8A4995C16BACA", hash_generated_method = "CA640CDFEEE9EE6687BB0AE18A3535CE")
    public void removeAt(int index) {
    if(mValues[index] != DELETED)        
        {
            mValues[index] = DELETED;
            mGarbage = true;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.258 -0400", hash_original_method = "92E5B832E30042BFCDC9211BA5952F8C", hash_generated_method = "248E34A5E02C6CAEA9549F87CABCB657")
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
                } 
                o++;
            } 
        } 
        mGarbage = false;
        mSize = o;
        
        
        
        
        
        
            
            
                
                    
                    
                    
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.260 -0400", hash_original_method = "D431925AC076B56C67C685DECF88777D", hash_generated_method = "CB25B13FFCC5E786C611D2207D35A7FC")
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
                int n = ArrayUtils.idealIntArraySize(mSize + 1);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.261 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "E5D285EF34949EB71E3D1DD2B1AE24C8")
    public int size() {
    if(mGarbage)        
        {
            gc();
        } 
        int var27DFA0EFE73BCB065533443A05E9DEE4_237131708 = (mSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960046307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960046307;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.262 -0400", hash_original_method = "AD3650995583655A8D059B5C8CE85FAD", hash_generated_method = "80FF2B4823A6590333D694AB1A4D034D")
    public int keyAt(int index) {
        addTaint(index);
    if(mGarbage)        
        {
            gc();
        } 
        int var3A009E05729778D41B3FA1B029E6698B_1309630442 = (mKeys[index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1167225031 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1167225031;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.262 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "03A10331FAAD4FC5C77DC9B13C09D20D")
    @SuppressWarnings("unchecked")
    public E valueAt(int index) {
        addTaint(index);
    if(mGarbage)        
        {
            gc();
        } 
E varFD8FAAC0C3572ACBC73A56817ABFB8BB_1520052726 =         (E) mValues[index];
        varFD8FAAC0C3572ACBC73A56817ABFB8BB_1520052726.addTaint(taint);
        return varFD8FAAC0C3572ACBC73A56817ABFB8BB_1520052726;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.263 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "C9DDB9E9EA02C5782F8816164CB68524")
    public void setValueAt(int index, E value) {
    if(mGarbage)        
        {
            gc();
        } 
        mValues[index] = value;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.263 -0400", hash_original_method = "2AE05DC6F4A524A5C2D1FCD4B3573FB7", hash_generated_method = "AF1026FD72015E4CECBFFDFA7E38DA30")
    public int indexOfKey(int key) {
        addTaint(key);
    if(mGarbage)        
        {
            gc();
        } 
        int var3C05684F465B8C390E8426D688C55DF4_515823513 = (binarySearch(mKeys, 0, mSize, key));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070475215 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070475215;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.264 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "E18082B1C119E865109A2966C4BDBAA7")
    public int indexOfValue(E value) {
        addTaint(value.getTaint());
    if(mGarbage)        
        {
            gc();
        } 
for(int i = 0;i < mSize;i++)
    if(mValues[i] == value)        
        {
        int var865C0C0B4AB0E063E5CAA3387C1A8741_2071753198 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746803790 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746803790;
        }
        int var6BB61E3B7BCE0931DA574D19D1D82C88_171180993 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1063866301 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1063866301;
        
        
            
        
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.266 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "61ED33368900ED20EB0D15BBCF4A009A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.268 -0400", hash_original_method = "5B63A048C0AD4A7F3A46491DB8DBCD38", hash_generated_method = "E5BE7126557319647405778022C25AEE")
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
            int n = ArrayUtils.idealIntArraySize(pos + 1);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.268 -0400", hash_original_field = "92065CB108C8800DF5E4F0483558AC68", hash_generated_field = "FCFA6BA9119CC3C1F3EE77ED9D99A0CB")

    private static final Object DELETED = new Object();
}


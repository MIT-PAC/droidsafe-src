package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.util.ArrayUtils;

public class SparseIntArray implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.333 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.334 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "99CDF6DB2A492E619A6F25FAC593741C")

    private int[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.334 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.334 -0400", hash_original_method = "3CB703BA4BBEFDD58F8198A538C651FA", hash_generated_method = "DD3187CC4240A3B6F7662B05387FA78D")
    public  SparseIntArray() {
        this(10);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.335 -0400", hash_original_method = "4F3979691C622EA5D57CC5639ACF4BFA", hash_generated_method = "37CCE572277F2EF9BBAD927B73134A48")
    public  SparseIntArray(int initialCapacity) {
        initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        mKeys = new int[initialCapacity];
        mValues = new int[initialCapacity];
        mSize = 0;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.335 -0400", hash_original_method = "A8A0500EAB2E651EC2684F9205BC101D", hash_generated_method = "621B3F0A590CA551284BB13F85A9A4B2")
    @Override
    public SparseIntArray clone() {
        SparseIntArray clone = null;
        try 
        {
            clone = (SparseIntArray) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } 
        catch (CloneNotSupportedException cnse)
        {
        } 
SparseIntArray var3DE52045BFD3C1BF3742F994ED6139AD_1081024157 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1081024157.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1081024157;
        
        
        
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.336 -0400", hash_original_method = "31C2EB74F838DC49D6A7CCB91DEC9730", hash_generated_method = "F8D127D79931B07E789CC9FAD9B57B1D")
    public int get(int key) {
        addTaint(key);
        int varAB9BE217F4CD05AD3B28F49CE5057627_2102602190 = (get(key, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138587870 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138587870;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.336 -0400", hash_original_method = "F09A11123BBC4B0EABD4FD786A922B87", hash_generated_method = "7801066FEFECD054DB96D87C538B8ED2")
    public int get(int key, int valueIfKeyNotFound) {
        addTaint(valueIfKeyNotFound);
        addTaint(key);
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i < 0)        
        {
            int var993854ACC78701A1DDC4D2270D676BF7_858896870 = (valueIfKeyNotFound);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_596181447 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_596181447;
        } 
        else
        {
            int var838C6F69E6EC457E9BF3DAB6E87CEB43_119131881 = (mValues[i]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882992958 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882992958;
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.336 -0400", hash_original_method = "8400B64AA446E0EFD1887423DF561D32", hash_generated_method = "BCE902EECFE5BC3E5E7FD9CA05826B84")
    public void delete(int key) {
        addTaint(key);
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i >= 0)        
        {
            removeAt(i);
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.337 -0400", hash_original_method = "95F6538276A47A94F5635C5979B3D205", hash_generated_method = "989989166AD9D997A543C12D119BE959")
    public void removeAt(int index) {
        addTaint(index);
        System.arraycopy(mKeys, index + 1, mKeys, index, mSize - (index + 1));
        System.arraycopy(mValues, index + 1, mValues, index, mSize - (index + 1));
        mSize--;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.338 -0400", hash_original_method = "22FC701C5FD198EE89684FFAA296E5FF", hash_generated_method = "42C3359AE3017D88BE66B4D5173E7543")
    public void put(int key, int value) {
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i >= 0)        
        {
            mValues[i] = value;
        } 
        else
        {
            i = ~i;
    if(mSize >= mKeys.length)            
            {
                int n = ArrayUtils.idealIntArraySize(mSize + 1);
                int[] nkeys = new int[n];
                int[] nvalues = new int[n];
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.339 -0400", hash_original_method = "9550C69BAA91C5298BA75D226127D5FF", hash_generated_method = "B0C93397EABD05ED0F5A1E87DB4C99EE")
    public int size() {
        int var27DFA0EFE73BCB065533443A05E9DEE4_5580818 = (mSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817040418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817040418;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.340 -0400", hash_original_method = "A3423B1919CBB5E5DDAE8E35A522AED2", hash_generated_method = "76FE6B38687ECA232FC4070E3CE35BEF")
    public int keyAt(int index) {
        addTaint(index);
        int var3A009E05729778D41B3FA1B029E6698B_1674517593 = (mKeys[index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_407662282 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_407662282;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.340 -0400", hash_original_method = "C4C41F7CADA2DF58870780D8F849030A", hash_generated_method = "92E1F9109EC132EDCD6F0A859979146A")
    public int valueAt(int index) {
        addTaint(index);
        int var6FB1DFB969E1EF0A685B48F18F0AD9D2_884676715 = (mValues[index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_766244836 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_766244836;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.341 -0400", hash_original_method = "AE2F6996EFD9E2EE7383268F20118C3E", hash_generated_method = "6B407E70123336EAD2A40A2B406B79A4")
    public int indexOfKey(int key) {
        addTaint(key);
        int var3C05684F465B8C390E8426D688C55DF4_988013203 = (binarySearch(mKeys, 0, mSize, key));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1281949617 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1281949617;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.342 -0400", hash_original_method = "951F96E1F188074D8F08952A6EB559DF", hash_generated_method = "DC1113CFD1FF2C286288F2214DB773BB")
    public int indexOfValue(int value) {
        addTaint(value);
for(int i = 0;i < mSize;i++)
    if(mValues[i] == value)        
        {
        int var865C0C0B4AB0E063E5CAA3387C1A8741_2003679860 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_483462505 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_483462505;
        }
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1574099102 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1974533212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1974533212;
        
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.342 -0400", hash_original_method = "78B640B3511AD026106C387D36058FFC", hash_generated_method = "2F55AFCAF967A1646FEBDAF6AC2C8455")
    public void clear() {
        mSize = 0;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.344 -0400", hash_original_method = "582360498D222FA3AC7FD1DD315CF583", hash_generated_method = "6D15455B2AD5C59F478FD0176AF82617")
    public void append(int key, int value) {
    if(mSize != 0 && key <= mKeys[mSize - 1])        
        {
            put(key, value);
            return;
        } 
        int pos = mSize;
    if(pos >= mKeys.length)        
        {
            int n = ArrayUtils.idealIntArraySize(pos + 1);
            int[] nkeys = new int[n];
            int[] nvalues = new int[n];
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

    
}


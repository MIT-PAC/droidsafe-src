package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class SparseIntArray implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.664 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.664 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "99CDF6DB2A492E619A6F25FAC593741C")

    private int[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.664 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.665 -0400", hash_original_method = "3CB703BA4BBEFDD58F8198A538C651FA", hash_generated_method = "DD3187CC4240A3B6F7662B05387FA78D")
    public  SparseIntArray() {
        this(10);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.665 -0400", hash_original_method = "4F3979691C622EA5D57CC5639ACF4BFA", hash_generated_method = "37CCE572277F2EF9BBAD927B73134A48")
    public  SparseIntArray(int initialCapacity) {
        initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        mKeys = new int[initialCapacity];
        mValues = new int[initialCapacity];
        mSize = 0;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.666 -0400", hash_original_method = "A8A0500EAB2E651EC2684F9205BC101D", hash_generated_method = "DFDFFEC94506794CA890EC1C25F473A6")
    @Override
    public SparseIntArray clone() {
        SparseIntArray varB4EAC82CA7396A68D541C85D26508E83_391168118 = null; 
        SparseIntArray clone = null;
        try 
        {
            clone = (SparseIntArray) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } 
        catch (CloneNotSupportedException cnse)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_391168118 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_391168118.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_391168118;
        
        
        
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.666 -0400", hash_original_method = "31C2EB74F838DC49D6A7CCB91DEC9730", hash_generated_method = "4D42441ABC8A8840F54268FEE393FBD6")
    public int get(int key) {
        int var2681AF3C27FD52FDD48BA1C704E320C9_866465021 = (get(key, 0));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_339755801 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_339755801;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.667 -0400", hash_original_method = "F09A11123BBC4B0EABD4FD786A922B87", hash_generated_method = "0ECDE08792B5D57BE4C871F6678F4843")
    public int get(int key, int valueIfKeyNotFound) {
        int i = binarySearch(mKeys, 0, mSize, key);
        addTaint(key);
        addTaint(valueIfKeyNotFound);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_219585252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_219585252;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.667 -0400", hash_original_method = "8400B64AA446E0EFD1887423DF561D32", hash_generated_method = "060395FF769BDF9006F60752B891C48E")
    public void delete(int key) {
        int i = binarySearch(mKeys, 0, mSize, key);
        {
            removeAt(i);
        } 
        addTaint(key);
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.668 -0400", hash_original_method = "95F6538276A47A94F5635C5979B3D205", hash_generated_method = "E3E4526070D7FA71B63F2740C50E5CFB")
    public void removeAt(int index) {
        System.arraycopy(mKeys, index + 1, mKeys, index, mSize - (index + 1));
        System.arraycopy(mValues, index + 1, mValues, index, mSize - (index + 1));
        addTaint(index);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.669 -0400", hash_original_method = "22FC701C5FD198EE89684FFAA296E5FF", hash_generated_method = "B60F1D5309101AB8222910C5466998F5")
    public void put(int key, int value) {
        int i = binarySearch(mKeys, 0, mSize, key);
        {
            mValues[i] = value;
        } 
        {
            i = ~i;
            {
                int n = ArrayUtils.idealIntArraySize(mSize + 1);
                int[] nkeys = new int[n];
                int[] nvalues = new int[n];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.669 -0400", hash_original_method = "9550C69BAA91C5298BA75D226127D5FF", hash_generated_method = "522760F3AE7E4FE6CACCD5A66BAC8157")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723260385 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723260385;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.670 -0400", hash_original_method = "A3423B1919CBB5E5DDAE8E35A522AED2", hash_generated_method = "C7C2882C1BCB17253E49957C385547BF")
    public int keyAt(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349284523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349284523;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.671 -0400", hash_original_method = "C4C41F7CADA2DF58870780D8F849030A", hash_generated_method = "29786E1EECD83BA5D2934E6164E6C3B3")
    public int valueAt(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168658512 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168658512;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.671 -0400", hash_original_method = "AE2F6996EFD9E2EE7383268F20118C3E", hash_generated_method = "138B6FA48A7FA0B18BEA7918C2F30683")
    public int indexOfKey(int key) {
        int varEF803A1EE726CA2553B95F3E48B65AD1_1741920803 = (binarySearch(mKeys, 0, mSize, key));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309693357 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309693357;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.672 -0400", hash_original_method = "951F96E1F188074D8F08952A6EB559DF", hash_generated_method = "32C6BA84C0B7A6707D5A142129CBD67B")
    public int indexOfValue(int value) {
        {
            int i = 0;
        } 
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1589627989 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1589627989;
        
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.673 -0400", hash_original_method = "78B640B3511AD026106C387D36058FFC", hash_generated_method = "2F55AFCAF967A1646FEBDAF6AC2C8455")
    public void clear() {
        mSize = 0;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.674 -0400", hash_original_method = "582360498D222FA3AC7FD1DD315CF583", hash_generated_method = "B126810FBA0B9DDB07AA88EDADD209C0")
    public void append(int key, int value) {
        {
            put(key, value);
        } 
        int pos = mSize;
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


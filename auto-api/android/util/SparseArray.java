package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class SparseArray<E> implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.592 -0400", hash_original_field = "09A7D01F9A4EF2933D39C68D27937238", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.592 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.592 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.592 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.592 -0400", hash_original_method = "E97D5EED29ED8377C999990C20A12343", hash_generated_method = "E245EEBE3057EE5A6B20AA3D7F52AD37")
    public  SparseArray() {
        this(10);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.593 -0400", hash_original_method = "F193A0D2E79CC42C4145064D20AB5B71", hash_generated_method = "0CE585F4CFEAD80D83275E2B999CFA02")
    public  SparseArray(int initialCapacity) {
        initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        mKeys = new int[initialCapacity];
        mValues = new Object[initialCapacity];
        mSize = 0;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.594 -0400", hash_original_method = "A950936C46135A90B64D99C98FBE0DD0", hash_generated_method = "38E7F6C91AAFAEB3265E0180C14D56C2")
    @Override
    @SuppressWarnings("unchecked")
    public SparseArray<E> clone() {
        SparseArray<E> varB4EAC82CA7396A68D541C85D26508E83_970027790 = null; 
        SparseArray<E> clone = null;
        try 
        {
            clone = (SparseArray<E>) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } 
        catch (CloneNotSupportedException cnse)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_970027790 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_970027790.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_970027790;
        
        
        
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.596 -0400", hash_original_method = "63029C5D60DB5A1F0C43DA1A71993094", hash_generated_method = "F5CBDCA6BE6F79EE7BC6B31B042185F2")
    public E get(int key) {
        E varB4EAC82CA7396A68D541C85D26508E83_924034545 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_924034545 = get(key, null);
        addTaint(key);
        varB4EAC82CA7396A68D541C85D26508E83_924034545.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_924034545;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.597 -0400", hash_original_method = "C9E62D05249D95E7C50A204FF58AB455", hash_generated_method = "8464AC0CEC9BF8AFEFAD56D4765C4FE9")
    @SuppressWarnings("unchecked")
    public E get(int key, E valueIfKeyNotFound) {
        E varB4EAC82CA7396A68D541C85D26508E83_78929418 = null; 
        E varB4EAC82CA7396A68D541C85D26508E83_582530612 = null; 
        int i = binarySearch(mKeys, 0, mSize, key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_78929418 = valueIfKeyNotFound;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_582530612 = (E) mValues[i];
        } 
        addTaint(key);
        addTaint(valueIfKeyNotFound.getTaint());
        E varA7E53CE21691AB073D9660D615818899_1189727302; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1189727302 = varB4EAC82CA7396A68D541C85D26508E83_78929418;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1189727302 = varB4EAC82CA7396A68D541C85D26508E83_582530612;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1189727302.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1189727302;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.598 -0400", hash_original_method = "D16C073A10FD3671AE05EBC49E38DA17", hash_generated_method = "79225D3021C3D45359D12FA03DAAB501")
    public void delete(int key) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.598 -0400", hash_original_method = "EE51F875218CA8C1C2C8959A48F2A4BB", hash_generated_method = "A541873280F5B14A2E5AF66CDD6B2A31")
    public void remove(int key) {
        delete(key);
        addTaint(key);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.599 -0400", hash_original_method = "1992218C2CA2A9A793E8A4995C16BACA", hash_generated_method = "11AA72D0B0C5E13EDB85E84A76E794B2")
    public void removeAt(int index) {
        {
            mValues[index] = DELETED;
            mGarbage = true;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.600 -0400", hash_original_method = "92E5B832E30042BFCDC9211BA5952F8C", hash_generated_method = "BB2D9AA087389DCABBA3F35F67DAF82B")
    private void gc() {
        int n = mSize;
        int o = 0;
        int[] keys = mKeys;
        Object[] values = mValues;
        {
            int i = 0;
            {
                Object val = values[i];
                {
                    {
                        keys[o] = keys[i];
                        values[o] = val;
                        values[i] = null;
                    } 
                } 
            } 
        } 
        mGarbage = false;
        mSize = o;
        
        
        
        
        
        
            
            
                
                    
                    
                    
                
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.601 -0400", hash_original_method = "D431925AC076B56C67C685DECF88777D", hash_generated_method = "3B302513EE21E6D98DC511D97811BAFA")
    public void put(int key, E value) {
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
                int[] nkeys = new int[n];
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.601 -0400", hash_original_method = "F891E9E45688B24DB77EAA9DE670091B", hash_generated_method = "C7260A893B3641F03F62C8F67BCB2AE9")
    public int size() {
        {
            gc();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372385637 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372385637;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.602 -0400", hash_original_method = "AD3650995583655A8D059B5C8CE85FAD", hash_generated_method = "30AEED635CF2C15827734534E5A81B6E")
    public int keyAt(int index) {
        {
            gc();
        } 
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_845011092 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_845011092;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.602 -0400", hash_original_method = "23592451CB50AFA841274AC3732C91A0", hash_generated_method = "AAEDFE8A407FC894BB893AFD8948F863")
    @SuppressWarnings("unchecked")
    public E valueAt(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_1774375163 = null; 
        {
            gc();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1774375163 = (E) mValues[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1774375163.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1774375163;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.603 -0400", hash_original_method = "7F2F6916ED61673EAF8E91642A81797D", hash_generated_method = "DC84236D6C02A331D1F56F5E93625B9F")
    public void setValueAt(int index, E value) {
        {
            gc();
        } 
        mValues[index] = value;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.603 -0400", hash_original_method = "2AE05DC6F4A524A5C2D1FCD4B3573FB7", hash_generated_method = "A219473F4D0347296083E7AF0A7E4523")
    public int indexOfKey(int key) {
        {
            gc();
        } 
        int varEF803A1EE726CA2553B95F3E48B65AD1_1334771968 = (binarySearch(mKeys, 0, mSize, key));
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817531655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817531655;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.604 -0400", hash_original_method = "726CF5EE08645CFDA1A6766EA2A8BAE2", hash_generated_method = "1A052C4288581C49638BAF87124D8568")
    public int indexOfValue(E value) {
        {
            gc();
        } 
        {
            int i = 0;
        } 
        addTaint(value.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828335506 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828335506;
        
        
            
        
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.604 -0400", hash_original_method = "43C05B8A0FF5CBFFF8E027DF94B104CB", hash_generated_method = "A99674D52ED0A179724028E7A97AAE26")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.605 -0400", hash_original_method = "5B63A048C0AD4A7F3A46491DB8DBCD38", hash_generated_method = "69C0105DAEA139E4745C9ACD3A014AB5")
    public void append(int key, E value) {
        {
            put(key, value);
        } 
        {
            gc();
        } 
        int pos = mSize;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.606 -0400", hash_original_field = "92065CB108C8800DF5E4F0483558AC68", hash_generated_field = "FCFA6BA9119CC3C1F3EE77ED9D99A0CB")

    private static final Object DELETED = new Object();
}


package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import com.android.internal.util.ArrayUtils;




public class SparseArray<E> implements Cloneable {

    
    @DSModeled(DSC.BAN)
    private static int binarySearch(int[] a, int start, int len, int key){
		// Original method
		/*
		{
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
		*/
		return 0;
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.733 -0500", hash_original_field = "3DBE75CD3847B615A3748344C30DB0A6", hash_generated_field = "FCFA6BA9119CC3C1F3EE77ED9D99A0CB")

    private static final Object DELETED = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.736 -0500", hash_original_field = "F7CE00CBAE369ABF1B3EF35E26DE59C6", hash_generated_field = "3E9E77485A77FB735B3D2728BEADA3A6")

    private boolean mGarbage = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.739 -0500", hash_original_field = "904D0E6EB4847EA02E1703FDE76AE0FF", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")


    private int[] mKeys;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.742 -0500", hash_original_field = "D3F28F3EBFA7D0D8D614CF293C7CCCA8", hash_generated_field = "8F96A7DD3A8AA044003D4A42FBE80825")

    private Object[] mValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.746 -0500", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;

    /**
     * Creates a new SparseArray containing no mappings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.749 -0500", hash_original_method = "E97D5EED29ED8377C999990C20A12343", hash_generated_method = "883E33622B92FE2F9F88EA2CD46632D6")
    
public SparseArray() {
        this(10);
    }

    
    @DSModeled(DSC.SAFE)
	public SparseArray(int initialCapacity){
		ArrayUtils.idealIntArraySize(initialCapacity);
		mKeys = new int[0];
		mValues = new Object[0];
		/*
		initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
		mKeys = new int[initialCapacity];
		mValues = new Object[initialCapacity];
		mSize = 0;
		*/
	}

    
    @DSModeled(DSC.SAFE)
	@Override @SuppressWarnings("unchecked") public SparseArray<E> clone(){
		SparseArray<E> clone = new SparseArray<E>(0);
		clone.addTaint(this.getTaint());
		return clone;
		// Original method
		/*
		{
        SparseArray<E> clone = null;
        try {
            clone = (SparseArray<E>) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } catch (CloneNotSupportedException cnse) {
        }
        return clone;
    }
		*/
	}

    /**
     * Gets the Object mapped from the specified key, or <code>null</code>
     * if no such mapping has been made.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.760 -0500", hash_original_method = "63029C5D60DB5A1F0C43DA1A71993094", hash_generated_method = "A7652660538AB6B2764F0F7687491E4B")
    
public E get(int key) {
        return get(key, null);
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked") public E get(int key, E valueIfKeyNotFound){
		return (E) mValues[0];
		// Original method
		/*
		{
        int i = binarySearch(mKeys, 0, mSize, key);
        if (i < 0 || mValues[i] == DELETED) {
            return valueIfKeyNotFound;
        } else {
            return (E) mValues[i];
        }
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void delete(int key){
		mValues[0] = DELETED;
		// Original method
		/*
		{
        int i = binarySearch(mKeys, 0, mSize, key);
        if (i >= 0) {
            if (mValues[i] != DELETED) {
                mValues[i] = DELETED;
                mGarbage = true;
            }
        }
    }
		*/
		//Return nothing
	}

    /**
     * Alias for {@link #delete(int)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.771 -0500", hash_original_method = "EE51F875218CA8C1C2C8959A48F2A4BB", hash_generated_method = "C7FFA05DD1740D5D19664E20B4CEE216")
    
public void remove(int key) {
        delete(key);
    }

    
    @DSModeled(DSC.SAFE)
    public void removeAt(int index){
		mValues[index] = DELETED;
		// Original method
		/*
		{
        if (mValues[index] != DELETED) {
            mValues[index] = DELETED;
            mGarbage = true;
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void gc(){
		// Original method
		/*
		{
        int n = mSize;
        int o = 0;
        int[] keys = mKeys;
        Object[] values = mValues;
        for (int i = 0; i < n; i++) {
            Object val = values[i];
            if (val != DELETED) {
                if (i != o) {
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
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public void put(int key, E value){
		mValues[0] = value;
		// How do we check if a type has field  
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public int size(){
		return getTaintInt();
		// Original method
		/*
		{
        if (mGarbage) {
            gc();
        }
        return mSize;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public int keyAt(int index){
		return getTaintInt();
		// Original method
		/*
		{
        if (mGarbage) {
            gc();
        }
        return mKeys[index];
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked") public E valueAt(int index){
		return (E) mValues[0];
		// Original method
		/*
		{
        if (mGarbage) {
            gc();
        }
        return (E) mValues[index];
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void setValueAt(int index, E value){
		mValues[0] = value;
		// Original method
		/*
		{
        if (mGarbage) {
            gc();
        }
        mValues[index] = value;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int indexOfKey(int key){
		return getTaintInt();
		// Original method
		/*
		{
        if (mGarbage) {
            gc();
        }
        return binarySearch(mKeys, 0, mSize, key);
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public int indexOfValue(E value){
		return getTaintInt();
		// Original method
		/*
		{
        if (mGarbage) {
            gc();
        }
        for (int i = 0; i < mSize; i++)
            if (mValues[i] == value)
                return i;
        return -1;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void clear(){
		// Original method
		/*
		{
        int n = mSize;
        Object[] values = mValues;
        for (int i = 0; i < n; i++) {
            values[i] = null;
        }
        mSize = 0;
        mGarbage = false;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void append(int key, E value){
		put(key, value);
		ArrayUtils.idealIntArraySize(0);
		// Original method
		/*
		{
        if (mSize != 0 && key <= mKeys[mSize - 1]) {
            put(key, value);
            return;
        }
        if (mGarbage && mSize >= mKeys.length) {
            gc();
        }
        int pos = mSize;
        if (pos >= mKeys.length) {
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
		*/
		//Return nothing
	}
}


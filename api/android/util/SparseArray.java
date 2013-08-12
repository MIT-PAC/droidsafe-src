package android.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import com.android.internal.util.ArrayUtils;




public class SparseArray<E> implements Cloneable {
    private boolean mGarbage = false;
    private int[] mKeys;
    private Object[] mValues;
    private int mSize;
    
    @DSModeled(DSC.SAFE)
	public SparseArray(){
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

    
    @DSModeled(DSC.SAFE)
    public E get(int key){
		return get(key, null);
		// Original method
		/*
		{
        return get(key, null);
    }
		*/
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

    
    @DSModeled(DSC.SAFE)
    public void remove(int key){
		delete(key);
		// Original method
		/*
		{
        delete(key);
    }
		*/
		//Return nothing
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

    
    private static final Object DELETED = new Object();
}


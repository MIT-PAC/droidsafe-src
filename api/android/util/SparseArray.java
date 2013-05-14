package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import com.android.internal.util.ArrayUtils;

public class SparseArray<E> implements Cloneable {
	private DSTaintObject dsTaint = new DSTaintObject();
	
	private static final Object DELETED = new Object();
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
		initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
		mKeys = new int[initialCapacity];
		mValues = new Object[initialCapacity];
		/*
		initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
		mKeys = new int[initialCapacity];
		mValues = new Object[initialCapacity];
		mSize = 0;
		*/
	}
	
	@Override @SuppressWarnings("unchecked") public SparseArray<E> clone(){
		SparseArray<E> clone = new SparseArray<E>(0);
		clone.dsTaint.addTaint(this.dsTaint);
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
	
	public E get(int key){
		return get(key, null);
		// Original method
		/*
		{
        return get(key, null);
    }
		*/
	}
	
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
	
	public void put(int key, E value){
		mValues[0] = value;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	public int size(){
		return dsTaint.getTaintInt();
		
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
	
	public int keyAt(int index){
		// Original method
		/*
		{
        if (mGarbage) {
            gc();
        }

        return mKeys[index];
    }
		*/
		return dsTaint.getTaintInt();
	}
	
	@SuppressWarnings("unchecked") public E valueAt(int index){
		return (E) mValues[0]; //DSFIXME:  Validate taint
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
	
	public int indexOfKey(int key){
		return binarySearch(mKeys, 0, mSize, key);
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
	
	public int indexOfValue(E value){
		return dsTaint.getTaintInt();
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
	
	public void append(int key, E value){
		put(key, value);
		int n = ArrayUtils.idealIntArraySize(mSize + 1);
		int[] nkeys = new int[n];
        Object[] nvalues = new Object[n];
		//System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length); //DSFIXME:  Need to model System.arraycopy
        //System.arraycopy(mValues, 0, nvalues, 0, mValues.length); //DSFIXME:  Need to model System.arraycopy
        mKeys = nkeys;
        mValues = nvalues;
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
}


package android.util;

import com.android.internal.util.ArrayUtils;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public class SparseArray<E> implements Cloneable {
	private int[] mKeys;
    private Object[] mValues;
    private int mSize;
    
    private DSTaintObject dsTaint = new DSTaintObject();
	
    @DSModeled(DSC.SAFE)
	public SparseArray() {
        this(10);
    }
	
    @DSModeled(DSC.SAFE)
	public SparseArray(int initialCapacity) {
		dsTaint.addTaint(initialCapacity); //The taint is a bit diffused by whatever idealIntArraySize returns, but we'll track it for now
        //initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);

        mKeys = new int[initialCapacity];
        mValues = new Object[initialCapacity];
        mSize = 0;
    }
    
    public void put(int key, E value) {
    	dsTaint.addTaint(value); //Effectively, dynamic sizing/allocation aside it's adding it to an array, so just track the taint
    	/*
    	int i = binarySearch(mKeys, 0, mSize, key);

        if (i >= 0) {
            mValues[i] = value;
        } else {
            i = ~i;

            if (i < mSize && mValues[i] == DELETED) {
                mKeys[i] = key;
                mValues[i] = value;
                return;
            }

            if (mGarbage && mSize >= mKeys.length) {
                gc();

                // Search again because indices may have changed.
                i = ~binarySearch(mKeys, 0, mSize, key);
            }

            if (mSize >= mKeys.length) {
                int n = ArrayUtils.idealIntArraySize(mSize + 1);

                int[] nkeys = new int[n];
                Object[] nvalues = new Object[n];

                // Log.e("SparseArray", "grow " + mKeys.length + " to " + n);
                System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
                System.arraycopy(mValues, 0, nvalues, 0, mValues.length);

                mKeys = nkeys;
                mValues = nvalues;
            }

            if (mSize - i != 0) {
                // Log.e("SparseArray", "move " + (mSize - i));
                System.arraycopy(mKeys, i, mKeys, i + 1, mSize - i);
                System.arraycopy(mValues, i, mValues, i + 1, mSize - i);
            }

            mKeys[i] = key;
            mValues[i] = value;
            mSize++;
        }
        */
    }
    
    public void append(int key, E value) {
    	put(key, value); //No need to model everything, we can gist this
    	/*
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

            // Log.e("SparseArray", "grow " + mKeys.length + " to " + n);
            System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
            System.arraycopy(mValues, 0, nvalues, 0, mValues.length);

            mKeys = nkeys;
            mValues = nvalues;
        }

        mKeys[pos] = key;
        mValues[pos] = value;
        mSize = pos + 1;
        */
    }
}

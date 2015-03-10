/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.util;

// Droidsafe Imports
import com.android.internal.util.ArrayUtils;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class SparseArray<E> implements Cloneable {
	
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


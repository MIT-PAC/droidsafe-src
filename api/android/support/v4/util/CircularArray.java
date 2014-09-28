/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package android.support.v4.util;

/**
 * A circular array implementation that provides O(1) random read and O(1)
 * prepend and O(1) append.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class CircularArray<E>
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.317 -0400", hash_original_field = "DE5B481FC2061A113DC9EDC99AA94DAD", hash_generated_field = "076E3F85000A817C6AA5AE0D5106B32F")

    private E[] mElements;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.323 -0400", hash_original_field = "8B3E1ED9C04E233B21144D17FD80B512", hash_generated_field = "ABE543C126C0FE93B0899D31BCDF7342")

    private int mHead;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.326 -0400", hash_original_field = "7C6024E979B8F31A590EB6292AE18320", hash_generated_field = "29C14DBD178AEEB325D03EC50F936101")

    private int mTail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.330 -0400", hash_original_field = "357DBCFE26BC0E5CFBEAB56C9BA1818F", hash_generated_field = "3ED06B4B0844687C3CB04745F4D90496")

    private int mCapacityBitmask;

    /**
     * Create a CircularArray with default capacity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.340 -0400", hash_original_method = "3D2976751EA3A332078C5B3264BF8C17", hash_generated_method = "AB122FB0E0604D7040AFE832BD34CAE8")
    
public CircularArray() {
        this(8);
    }

    /**
     * Create a CircularArray with capacity for at least minCapacity elements.
     *
     * @param minCapacity The minimum capacity required for the circular array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.346 -0400", hash_original_method = "CA894133E63B0A70D1E32D1954E0ACBB", hash_generated_method = "BEBECC82DED761B80AECA807E2249AEC")
    
public CircularArray(int minCapacity) {
        if (minCapacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        int arrayCapacity = minCapacity;
        // If minCapacity isn't a power of 2, round up to the next highest power
        // of 2.
        if (Integer.bitCount(minCapacity) != 1) {
            arrayCapacity = 1 << (Integer.highestOneBit(minCapacity) + 1);
        }
        mCapacityBitmask = arrayCapacity - 1;
        mElements = (E[]) new Object[arrayCapacity];
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.336 -0400", hash_original_method = "40E5CCDE120C577646DC94DF8326BBF7", hash_generated_method = "CB60441459B98E168A803481549D3409")
    
private void doubleCapacity() {
        int n = mElements.length;
        int r = n - mHead;
        int newCapacity = n << 1;
        if (newCapacity < 0) {
            throw new RuntimeException("Too big");
        }
        Object[] a = new Object[newCapacity];
        System.arraycopy(mElements, mHead, a, 0, r);
        System.arraycopy(mElements, 0, a, r, mHead);
        mElements = (E[])a;
        mHead = 0;
        mTail = n;
        mCapacityBitmask = newCapacity - 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.350 -0400", hash_original_method = "C81CA423C70BDD06D994E9E8DFC05151", hash_generated_method = "DA74FA2E6BB2F535192F18BCC6CB23A9")
    
public final void addFirst(E e) {
        mHead = (mHead - 1) & mCapacityBitmask;
        mElements[mHead] = e;
        if (mHead == mTail) {
            doubleCapacity();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.355 -0400", hash_original_method = "D517D65D585B259493805431F047324A", hash_generated_method = "619C0C4F1ACA137F2D92444DBDF465E3")
    
public final void addLast(E e) {
        mElements[mTail] = e;
        mTail = (mTail + 1) & mCapacityBitmask;
        if (mTail == mHead) {
            doubleCapacity();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.359 -0400", hash_original_method = "E731B4BDC33040A4EC25F438151AE974", hash_generated_method = "9D5582631A404035D2ED697BC114586F")
    
public final E popFirst() {
        if (mHead == mTail) throw new ArrayIndexOutOfBoundsException();
        E result = mElements[mHead];
        mElements[mHead] = null;
        mHead = (mHead + 1) & mCapacityBitmask;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.364 -0400", hash_original_method = "112BA9481F30309D3FFCF3B11DE888A1", hash_generated_method = "3B435B1E9D95DA6C9A1A112E17B5C3C4")
    
public final E popLast() {
        if (mHead == mTail) throw new ArrayIndexOutOfBoundsException();
        int t = (mTail - 1) & mCapacityBitmask;
        E result = mElements[t];
        mElements[t] = null;
        mTail = t;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.369 -0400", hash_original_method = "747845FB1FF032DC40FE3DEC7F05CDA7", hash_generated_method = "C40D2A5B19F7C5F225B7B0C0FFFA3BDC")
    
public final E getFirst() {
        if (mHead == mTail) throw new ArrayIndexOutOfBoundsException();
        return mElements[mHead];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.373 -0400", hash_original_method = "4B6A0C51E6F5FCB50E6FB3F7376C4757", hash_generated_method = "5D68FD0B08A20FB0AA14D1FEDD8C9791")
    
public final E getLast() {
        if (mHead == mTail) throw new ArrayIndexOutOfBoundsException();
        return mElements[(mTail - 1) & mCapacityBitmask];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.379 -0400", hash_original_method = "65EBA4C95B990CB8403CF399F08106CC", hash_generated_method = "2C4B5459072BF9DACDDAAAC74D9FEC55")
    
public final E get(int i) {
        if (i < 0 || i >= size()) throw new ArrayIndexOutOfBoundsException();
        int p = (mHead + i) & mCapacityBitmask;
        return mElements[p];
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.383 -0400", hash_original_method = "3F239FCF0F7FF153AF61F8C83E1E7F5A", hash_generated_method = "0E73468ED21CF22D7AF0E3FE06796BBD")
    
public final int size() {
        return (mTail - mHead) & mCapacityBitmask;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.388 -0400", hash_original_method = "41743E347164C02C7288A32B3086B08F", hash_generated_method = "31757D9BB2833D9E0EFD93BE2CDC4D98")
    
public final boolean isEmpty() {
        return mHead == mTail;
    }

}

/*
 * Copyright (C) 2013 The Android Open Source Project
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

package android.support.v4.util;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
class ContainerHelpers {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.588 -0400", hash_original_field = "C48927DFD6C4C5FC88F9F39B289BAA79", hash_generated_field = "ADE45B85B75912B725BCADADEF41F6F7")

    static final int[] EMPTY_INTS = new int[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.593 -0400", hash_original_field = "E580CCEED2FE4D5D8C2DC30D3B2BAD79", hash_generated_field = "656AF971F523E86BAA90D759196B7227")

    static final long[] EMPTY_LONGS = new long[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.597 -0400", hash_original_field = "ACDBC578718790BFA50C8050CEF399F0", hash_generated_field = "49F460CCD45134FCB9866EB3A4DBF80B")

    static final Object[] EMPTY_OBJECTS = new Object[0];

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.601 -0400", hash_original_method = "C5D38D95B60B446AE8BAAF7982426E2B", hash_generated_method = "89087E12BD5927700561885B368C654D")
    
public static int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.605 -0400", hash_original_method = "81E7FAA327416436814745B8BDC163E2", hash_generated_method = "7A7A55B2D3E16E87C86D175661E4F019")
    
public static int idealLongArraySize(int need) {
        return idealByteArraySize(need * 8) / 8;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.609 -0400", hash_original_method = "78F4782A9945BD922AE4F703F6706A7E", hash_generated_method = "476E3135F747B27C638A7747394DD781")
    
public static int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++)
            if (need <= (1 << i) - 12)
                return (1 << i) - 12;

        return need;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.613 -0400", hash_original_method = "F296275000E1AA53C7B464F5FDA7A4B5", hash_generated_method = "F1FE59F254185FB0421C417ADE74E86C")
    
public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    // This is Arrays.binarySearch(), but doesn't do any argument validation.
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.617 -0400", hash_original_method = "AAF6C34952922D0E5AACA07FEBEB0788", hash_generated_method = "F00CB0A9A26DBE91E4E6BCA56BD2CAD6")
    
static int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:21.622 -0400", hash_original_method = "3B32571B267BB6099FA8B2E6DC17D75C", hash_generated_method = "7B0E688FF4372ADE23665A8AE40297AE")
    
static int binarySearch(long[] array, int size, long value) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final long midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }
}

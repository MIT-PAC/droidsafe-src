/*
 * Copyright (C) 2007 The Android Open Source Project
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

package java.nio;

/**
 * This class is used via JNI by code in frameworks/base/.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
final class NIOAccess {

    /**
     * Returns the underlying native pointer to the data of the given
     * Buffer starting at the Buffer's current position, or 0 if the
     * Buffer is not backed by native heap storage. Note that this is
     * different than what the Harmony implementation calls a "base
     * address."
     *
     * @param b the Buffer to be queried
     * @return the native pointer to the Buffer's data at its current
     * position, or 0 if there is none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.324 -0400", hash_original_method = "A1BCAD21C8B6E1378107070ECB834100", hash_generated_method = "54A364C830B5ED30E744B5569D4599DE")
    
static long getBasePointer(Buffer b) {
        long address = b.effectiveDirectAddress;
        if (address == 0) {
            return 0L;
        }
        return address + (b.position << b._elementSizeShift);
    }

    /**
     * Returns the underlying Java array containing the data of the
     * given Buffer, or null if the Buffer is not backed by a Java array.
     *
     * @param b the Buffer to be queried
     * @return the Java array containing the Buffer's data, or null if
     * there is none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.325 -0400", hash_original_method = "6AC5245CF036B2CA5B87C1FD74DA4AE6", hash_generated_method = "F5E214D77ADC82662FAACEAE313AC4CF")
    
static Object getBaseArray(Buffer b) {
        return b.hasArray() ? b.array() : null;
    }

    /**
     * Returns the offset in bytes from the start of the underlying
     * Java array object containing the data of the given Buffer to
     * the actual start of the data. The start of the data takes into
     * account the Buffer's current position. This method is only
     * meaningful if getBaseArray() returns non-null.
     *
     * @param b the Buffer to be queried
     * @return the data offset in bytes to the start of this Buffer's data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.325 -0400", hash_original_method = "E074C2A27182F0EFF7EB3EAA18DA46C8", hash_generated_method = "06A5034E36CB04561AE22CD938969F2A")
    
static int getBaseArrayOffset(Buffer b) {
        return b.hasArray() ? ((b.arrayOffset() + b.position) << b._elementSizeShift) : 0;
    }
}

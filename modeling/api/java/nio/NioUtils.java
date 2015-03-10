/* Licensed to the Apache Software Foundation (ASF) under one or more
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
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.nio.channels.FileChannel;

public final class NioUtils {

    /**
     * Gets the start address of a direct buffer.
     * <p>
     * This method corresponds to the JNI function:
     *
     * <pre>
     *    void* GetDirectBufferAddress(JNIEnv* env, jobject buf);
     * </pre>
     *
     * @param buf
     *            the direct buffer whose address shall be returned must not be
     *            <code>null</code>.
     * @return the address of the buffer given, or zero if the buffer is not a
     *         direct Buffer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.550 -0500", hash_original_method = "6FD5A6B6EFE1B654EBBB85A447B00936", hash_generated_method = "B1EC0440B234EDBF99B5A433B378CE46")
    
public static int getDirectBufferAddress(Buffer buffer) {
        return buffer.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.553 -0500", hash_original_method = "0317201F8BF863383AD73DA0A92FFDF2", hash_generated_method = "E6C10C6DF1801BD646FF159D787C2339")
    
public static void freeDirectBuffer(ByteBuffer buffer) {
        if (buffer == null) {
            return;
        }
        if (buffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) buffer).free();
        } else if (buffer instanceof MappedByteBuffer) {
            ((MappedByteBufferAdapter) buffer).free();
        } else {
            throw new AssertionError();
        }
    }

    /**
     * Returns the int file descriptor from within the given FileChannel 'fc'.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.557 -0500", hash_original_method = "EDFF18FC78F4764F7133825B9C3635B5", hash_generated_method = "209B46B133CA6BF5240477E289D3CD74")
    
public static FileDescriptor getFD(FileChannel fc) {
        return ((FileChannelImpl) fc).getFD();
    }

    /**
     * Helps bridge between io and nio.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.559 -0500", hash_original_method = "36934C37A2F983F9B004D8F963783105", hash_generated_method = "FCC64B53C0D1519E199C7FE2CAF59931")
    
public static FileChannel newFileChannel(Object stream, FileDescriptor fd, int mode) {
        return new FileChannelImpl(stream, fd, mode);
    }

    /**
     * Exposes the array backing a non-direct ByteBuffer, even if the ByteBuffer is read-only.
     * Normally, attempting to access the array backing a read-only buffer throws.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.562 -0500", hash_original_method = "7D240E99D6029C73158519B20A0F21EF", hash_generated_method = "94762D1C307E5FEE551265262BD093BF")
    
public static byte[] unsafeArray(ByteBuffer b) {
        return ((HeapByteBuffer) b).backingArray;
    }

    /**
     * Exposes the array offset for the array backing a non-direct ByteBuffer,
     * even if the ByteBuffer is read-only.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.564 -0500", hash_original_method = "2FFF8F204F2E28FEC7295F423960F22A", hash_generated_method = "9780990C20FA425691B10159F7452F6E")
    
public static int unsafeArrayOffset(ByteBuffer b) {
        return ((HeapByteBuffer) b).offset;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.547 -0500", hash_original_method = "8E7A8D6DFD82A6BAC9AB3CD54CF31BDC", hash_generated_method = "2169ABF68DC1CD5C851E50C33CE807CB")
    
private NioUtils() {
    }
    
}


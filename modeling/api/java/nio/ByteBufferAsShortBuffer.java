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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import libcore.io.SizeOf;

/**
 * This class wraps a byte buffer to be a short buffer.
 * <p>
 * Implementation notice:
 * <ul>
 * <li>After a byte buffer instance is wrapped, it becomes privately owned by
 * the adapter. It must NOT be accessed outside the adapter any more.</li>
 * <li>The byte buffer's position and limit are NOT linked with the adapter.
 * The adapter extends Buffer, thus has its own position and limit.</li>
 * </ul>
 * </p>
 */
final class ByteBufferAsShortBuffer extends ShortBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.659 -0400", hash_original_method = "18516E710810F59088E2B5A0A6983B76", hash_generated_method = "02212CE4FC39975477C9F9FE3D6162BF")
    
static ShortBuffer asShortBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ByteBufferAsShortBuffer(slice);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.658 -0400", hash_original_field = "1550DCB87D4D50D3727BEA306C5BDDD3", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")


    private  ByteBuffer byteBuffer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.659 -0400", hash_original_method = "BAC95608B43482866F5406FB132E02BD", hash_generated_method = "2CF20266DC5DF7407B859C5E9848EC28")
    
private ByteBufferAsShortBuffer(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.SHORT);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.660 -0400", hash_original_method = "BD8731916AA8C6B6371B040CFABCE778", hash_generated_method = "4F9F391669A4D707C68C6C21DFB34014")
    
@Override
    public ShortBuffer asReadOnlyBuffer() {
        ByteBufferAsShortBuffer buf = new ByteBufferAsShortBuffer(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.660 -0400", hash_original_method = "05DE7B6CED27ACAA0A9F6BF73EB6C673", hash_generated_method = "C17DE4268799F46E1C65B1F3ECA07BBF")
    
@Override
    public ShortBuffer compact() {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.661 -0400", hash_original_method = "2C436126CBEE3B5146472A949533E14E", hash_generated_method = "EE0112E5A313A8A1EA6151FA729A1BF2")
    
@Override
    public ShortBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        ByteBufferAsShortBuffer buf = new ByteBufferAsShortBuffer(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.661 -0400", hash_original_method = "7C4E3224E8CBDBDF522D2B052ECE14D8", hash_generated_method = "82B17A8C8BCF24BDD23E36AD7C16BD8C")
    
@Override
    public short get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return byteBuffer.getShort(position++ * SizeOf.SHORT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.662 -0400", hash_original_method = "99D353FC1689A601B3A3A0ABA15D7065", hash_generated_method = "C903AE4171B05B827EAFF7DA1604C3F1")
    
@Override
    public short get(int index) {
        checkIndex(index);
        return byteBuffer.getShort(index * SizeOf.SHORT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.662 -0400", hash_original_method = "273FACB24473BAA5FC7F1F79DB7D214A", hash_generated_method = "7C65E422447075738D1D7CCD8B2B4010")
    
@Override
    public ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        } else {
            ((ByteArrayBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        }
        this.position += shortCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.662 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "009663403DDC37C5A9CC05093822324F")
    
@Override
    public boolean isDirect() {
        return byteBuffer.isDirect();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.663 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "C9CF4EA86C1E45319D8243CAB871AD82")
    
@Override
    public boolean isReadOnly() {
        return byteBuffer.isReadOnly();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.663 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "72A628D0C0DB04E7966F3ACE077688CC")
    
@Override
    public ByteOrder order() {
        return byteBuffer.order();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.664 -0400", hash_original_method = "797461B8F23A38201C61F803B025213F", hash_generated_method = "1186FA96BC6AFCE7F32F86B25E5AB940")
    
@Override short[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.664 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "6C1DF53F257EB1584DB18DEED31F5721")
    
@Override int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.664 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "55743CF37FADA0E310D2F208DB2BEB10")
    
@Override boolean protectedHasArray() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.665 -0400", hash_original_method = "BED9261A5E47204D4C26D68EDDB52578", hash_generated_method = "BC5FE641074BA04388BC580BEC4CA545")
    
@Override
    public ShortBuffer put(short c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        byteBuffer.putShort(position++ * SizeOf.SHORT, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.665 -0400", hash_original_method = "81BB381464177DAD01780ED6CBAA4133", hash_generated_method = "E5438BAB7AC34A2EABC0845B6F608ECE")
    
@Override
    public ShortBuffer put(int index, short c) {
        checkIndex(index);
        byteBuffer.putShort(index * SizeOf.SHORT, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.666 -0400", hash_original_method = "C39D9A7C8BBD6F7F4F1C7B3BD38459B4", hash_generated_method = "444B4D77C150E0B1A8303329E3C9E345")
    
@Override
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        } else {
            ((ByteArrayBuffer) byteBuffer).put(src, srcOffset, shortCount);
        }
        this.position += shortCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.666 -0400", hash_original_method = "FAAD156454804CB35807006F4E33E1BC", hash_generated_method = "030593CE98632B506D07461EDE99BE4F")
    
@Override
    public ShortBuffer slice() {
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        ShortBuffer result = new ByteBufferAsShortBuffer(bb);
        byteBuffer.clear();
        return result;
    }

}

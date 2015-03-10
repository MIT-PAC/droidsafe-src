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
 * This class wraps a byte buffer to be a int buffer.
 * <p>
 * Implementation notice:
 * <ul>
 * <li>After a byte buffer instance is wrapped, it becomes privately owned by
 * the adapter. It must NOT be accessed outside the adapter any more.</li>
 * <li>The byte buffer's position and limit are NOT linked with the adapter.
 * The adapter extends Buffer, thus has its own position and limit.</li>
 * </ul>
 * </p>
 *
 */
final class ByteBufferAsIntBuffer extends IntBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.712 -0400", hash_original_method = "CA25DC9CB5D99CAC8550BA3A8FBAAA9A", hash_generated_method = "3076D9BAC64592BDF9FACE557D1951B2")
    
static IntBuffer asIntBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ByteBufferAsIntBuffer(slice);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.711 -0400", hash_original_field = "1550DCB87D4D50D3727BEA306C5BDDD3", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")


    private  ByteBuffer byteBuffer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.712 -0400", hash_original_method = "B0218F56B4270DB8CF0806D46BF5EC69", hash_generated_method = "1D7C0FABB18CFCDDC8DD46BB45114D9B")
    
private ByteBufferAsIntBuffer(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.INT);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.712 -0400", hash_original_method = "7B0B6F9CC7BF48205BA8BEA19E20987B", hash_generated_method = "78F4D6177E586B93C15BA2C7856B6856")
    
@Override
    public IntBuffer asReadOnlyBuffer() {
        ByteBufferAsIntBuffer buf = new ByteBufferAsIntBuffer(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.713 -0400", hash_original_method = "D18BA662CC63D97B7B456C28811B5740", hash_generated_method = "E6800CE86F80DE4B147D4D5EE05688CA")
    
@Override
    public IntBuffer compact() {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.714 -0400", hash_original_method = "3ECF91FF34A9A607AC9E48F9CF680A60", hash_generated_method = "EEB8E499FBEE97AA721B647AF4D7877F")
    
@Override
    public IntBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        ByteBufferAsIntBuffer buf = new ByteBufferAsIntBuffer(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.715 -0400", hash_original_method = "B6C265DA3B3DAD372E7C00DDFF580FE2", hash_generated_method = "3F444A582DADF506D3312AFFF54778C4")
    
@Override
    public int get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return byteBuffer.getInt(position++ * SizeOf.INT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.715 -0400", hash_original_method = "A308FF9E693AF460AC240055AB8B4E4F", hash_generated_method = "D93315D6A544398E7593D6C51BC41302")
    
@Override
    public int get(int index) {
        checkIndex(index);
        return byteBuffer.getInt(index * SizeOf.INT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.716 -0400", hash_original_method = "5B442F4CAFA3A495E975B2807E1B3169", hash_generated_method = "8DE7A34482120E8D386BB49AF701F2C9")
    
@Override
    public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        } else {
            ((ByteArrayBuffer) byteBuffer).get(dst, dstOffset, intCount);
        }
        this.position += intCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.716 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "009663403DDC37C5A9CC05093822324F")
    
@Override
    public boolean isDirect() {
        return byteBuffer.isDirect();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.717 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "C9CF4EA86C1E45319D8243CAB871AD82")
    
@Override
    public boolean isReadOnly() {
        return byteBuffer.isReadOnly();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.717 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "72A628D0C0DB04E7966F3ACE077688CC")
    
@Override
    public ByteOrder order() {
        return byteBuffer.order();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.717 -0400", hash_original_method = "B5E68F6CE1B6AAF4D730BB4F773E288A", hash_generated_method = "B04A7CC5C1CD9E2FBAFA3ACD57545D43")
    
@Override int[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.718 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "6C1DF53F257EB1584DB18DEED31F5721")
    
@Override int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.718 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "55743CF37FADA0E310D2F208DB2BEB10")
    
@Override boolean protectedHasArray() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.719 -0400", hash_original_method = "3F86EA2C1F796EC91605CF34A16A44E5", hash_generated_method = "F52CC257E42DD231D1D53FCD304AA380")
    
@Override
    public IntBuffer put(int c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        byteBuffer.putInt(position++ * SizeOf.INT, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.719 -0400", hash_original_method = "3231AAB5D18FCEA9F424FA8559AECE08", hash_generated_method = "8B1C17B0CC0DCFCD5A4FFC8A44361AF3")
    
@Override
    public IntBuffer put(int index, int c) {
        checkIndex(index);
        byteBuffer.putInt(index * SizeOf.INT, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.720 -0400", hash_original_method = "0861EAAB67359CC632F13A7C5C4483E4", hash_generated_method = "F859D536F0D6701FF8F2FC27723EA8F6")
    
@Override
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        } else {
            ((ByteArrayBuffer) byteBuffer).put(src, srcOffset, intCount);
        }
        this.position += intCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.720 -0400", hash_original_method = "FC5EBDEC78C3FADCEB90A4EC1549D123", hash_generated_method = "D82B500F2CE0331F9EAA7D34EDA05741")
    
@Override
    public IntBuffer slice() {
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        IntBuffer result = new ByteBufferAsIntBuffer(bb);
        byteBuffer.clear();
        return result;
    }

}

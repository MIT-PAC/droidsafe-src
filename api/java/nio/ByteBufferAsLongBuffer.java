/* Licensed to the Apache Software Foundation (ASF) under one or more
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

package java.nio;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import libcore.io.SizeOf;

/**
 * This class wraps a byte buffer to be a long buffer.
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
final class ByteBufferAsLongBuffer extends LongBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.770 -0400", hash_original_method = "B6E2C08DD79BA80D28FAAA0474C6EB02", hash_generated_method = "FDA0BB1B127395E88D33BF3D1BCD6A84")
    
static LongBuffer asLongBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ByteBufferAsLongBuffer(slice);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.769 -0400", hash_original_field = "1550DCB87D4D50D3727BEA306C5BDDD3", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")


    private  ByteBuffer byteBuffer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.770 -0400", hash_original_method = "F388B7FF4D5CC49D2562DD85C5898222", hash_generated_method = "0BF5CDE8CD4A52607124C1BB61B8FBC7")
    
private ByteBufferAsLongBuffer(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.LONG);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.771 -0400", hash_original_method = "4CDF54F17F3F9BAC4909676E4873DBA3", hash_generated_method = "51333327889551C1636833FF90B377A9")
    
@Override
    public LongBuffer asReadOnlyBuffer() {
        ByteBufferAsLongBuffer buf = new ByteBufferAsLongBuffer(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.771 -0400", hash_original_method = "B90A69906FF2A7DF6CFB9034F84C98E2", hash_generated_method = "63C408C126C668925623E4C1E8309E6D")
    
@Override
    public LongBuffer compact() {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.772 -0400", hash_original_method = "AA07DA8174D38A5C59C93D8C6113F9CB", hash_generated_method = "416385184C5E4D658D17DDBB8ACF1C94")
    
@Override
    public LongBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        ByteBufferAsLongBuffer buf = new ByteBufferAsLongBuffer(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.772 -0400", hash_original_method = "69EF1CD1610BDC80B0B9220CD61D963E", hash_generated_method = "1A6C85E8B2D9B3E9D8C30278622528AB")
    
@Override
    public long get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return byteBuffer.getLong(position++ * SizeOf.LONG);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.772 -0400", hash_original_method = "89069B89A0801CA51434AC3AB566C55F", hash_generated_method = "250BBE1E5E22CFC51F5177704F4D4D93")
    
@Override
    public long get(int index) {
        checkIndex(index);
        return byteBuffer.getLong(index * SizeOf.LONG);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.773 -0400", hash_original_method = "DF130461A5B0AC933B22AB62D95C97A7", hash_generated_method = "44704817800927FF8AF2FF78A055E149")
    
@Override
    public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } else {
            ((ByteArrayBuffer) byteBuffer).get(dst, dstOffset, longCount);
        }
        this.position += longCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.773 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "009663403DDC37C5A9CC05093822324F")
    
@Override
    public boolean isDirect() {
        return byteBuffer.isDirect();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.774 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "C9CF4EA86C1E45319D8243CAB871AD82")
    
@Override
    public boolean isReadOnly() {
        return byteBuffer.isReadOnly();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.775 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "72A628D0C0DB04E7966F3ACE077688CC")
    
@Override
    public ByteOrder order() {
        return byteBuffer.order();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.775 -0400", hash_original_method = "BB4072AD98AEBDD15F1C2BE658CD1C60", hash_generated_method = "D03507F8300AFC03E4884E2E4BCC28F6")
    
@Override long[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.775 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "6C1DF53F257EB1584DB18DEED31F5721")
    
@Override int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.776 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "55743CF37FADA0E310D2F208DB2BEB10")
    
@Override boolean protectedHasArray() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.776 -0400", hash_original_method = "87F5FD3E4F89C8080D5C7CCD57D2DD50", hash_generated_method = "791FAA1EB501CB85267F780D792086C2")
    
@Override
    public LongBuffer put(long c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        byteBuffer.putLong(position++ * SizeOf.LONG, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.776 -0400", hash_original_method = "CF44390369F77E5D846E6D2329A6B3BC", hash_generated_method = "E2131AD4E5C9E469729672ECCFFA08DE")
    
@Override
    public LongBuffer put(int index, long c) {
        checkIndex(index);
        byteBuffer.putLong(index * SizeOf.LONG, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.777 -0400", hash_original_method = "EF64CDDDC94478B184303111B51E774C", hash_generated_method = "D515E2F2DCB39849E9395BD4EA8996AA")
    
@Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } else {
            ((ByteArrayBuffer) byteBuffer).put(src, srcOffset, longCount);
        }
        this.position += longCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.777 -0400", hash_original_method = "889A8F062070C544BA54E3BB10E54E88", hash_generated_method = "181D5F58FCE9EFFE3A0FBB43846A1373")
    
@Override
    public LongBuffer slice() {
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        LongBuffer result = new ByteBufferAsLongBuffer(bb);
        byteBuffer.clear();
        return result;
    }

}

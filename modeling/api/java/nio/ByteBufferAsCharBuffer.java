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
 * This class wraps a byte buffer to be a char buffer.
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
final class ByteBufferAsCharBuffer extends CharBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.654 -0400", hash_original_method = "502E4D7D1B8CF0516F247CCB0B5D6383", hash_generated_method = "08806AB416EE48F403A6D929AFBBFBFF")
    
static CharBuffer asCharBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ByteBufferAsCharBuffer(slice);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.654 -0400", hash_original_field = "1550DCB87D4D50D3727BEA306C5BDDD3", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private  ByteBuffer byteBuffer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.654 -0400", hash_original_method = "DFF17BDD3436991D6670BD10233B6852", hash_generated_method = "66C4B73BCBD26331620C601FC5087FCA")
    
private ByteBufferAsCharBuffer(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.CHAR);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.655 -0400", hash_original_method = "2A1804082AF54318EE123889A7E7B578", hash_generated_method = "AFCF71706392EB75128577FBE9E10606")
    
@Override
    public CharBuffer asReadOnlyBuffer() {
        ByteBufferAsCharBuffer buf = new ByteBufferAsCharBuffer(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return buf;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.655 -0400", hash_original_method = "2B216932B774F9FB3B903B024B1F44DD", hash_generated_method = "F14AAE8FCBE23930C4615524B071B64B")
    
@Override
    public CharBuffer compact() {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.656 -0400", hash_original_method = "E122DDCC44646870BD6BE6B79C653CCA", hash_generated_method = "C07CA8B2B54527F20981E719D03187EB")
    
@Override
    public CharBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        ByteBufferAsCharBuffer buf = new ByteBufferAsCharBuffer(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.656 -0400", hash_original_method = "E3B7C628ECBF1BA157CEBCB59E54138B", hash_generated_method = "FFACC0788C10DF37BEAB726CF2101594")
    
@Override
    public char get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return byteBuffer.getChar(position++ * SizeOf.CHAR);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.657 -0400", hash_original_method = "2E9BB5D57AAEB3C216C710BA88C55EF9", hash_generated_method = "065EFE2C922136B5CAB51E31C8E365A1")
    
@Override
    public char get(int index) {
        checkIndex(index);
        return byteBuffer.getChar(index * SizeOf.CHAR);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.657 -0400", hash_original_method = "4B6D037D3D484BB87E29AC378490CC53", hash_generated_method = "C2FD7961492C2B6912B011DC2F539E25")
    
@Override
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        } else {
            ((ByteArrayBuffer) byteBuffer).get(dst, dstOffset, charCount);
        }
        this.position += charCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.658 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "009663403DDC37C5A9CC05093822324F")
    
@Override
    public boolean isDirect() {
        return byteBuffer.isDirect();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.658 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "C9CF4EA86C1E45319D8243CAB871AD82")
    
@Override
    public boolean isReadOnly() {
        return byteBuffer.isReadOnly();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.659 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "72A628D0C0DB04E7966F3ACE077688CC")
    
@Override
    public ByteOrder order() {
        return byteBuffer.order();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.659 -0400", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "BA6A704F60FCDC1396C5CD214FD02077")
    
@Override char[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.660 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "6C1DF53F257EB1584DB18DEED31F5721")
    
@Override int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.660 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "55743CF37FADA0E310D2F208DB2BEB10")
    
@Override boolean protectedHasArray() {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.660 -0400", hash_original_method = "A46BC55FC455B05EF747C70552AAC069", hash_generated_method = "61ABEA2ADBAFAAE509189A5135E81F35")
    
@Override
    public CharBuffer put(char c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        byteBuffer.putChar(position++ * SizeOf.CHAR, c);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.661 -0400", hash_original_method = "3E41BE4D2E49CC352D854BBBF4557ADA", hash_generated_method = "B7F140A54ADA2C555F037218CEC98DBB")
    
@Override
    public CharBuffer put(int index, char c) {
        checkIndex(index);
        byteBuffer.putChar(index * SizeOf.CHAR, c);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.661 -0400", hash_original_method = "9E9E26DE8F0FB1C7C1DCDB0ECE07501F", hash_generated_method = "263E9C909BC909B04D04C32A1738A950")
    
@Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        } else {
            ((ByteArrayBuffer) byteBuffer).put(src, srcOffset, charCount);
        }
        this.position += charCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.662 -0400", hash_original_method = "400C233E97B47EACD80F63A6CF663FAE", hash_generated_method = "E2E70577C53F83D0661F42088BC8ABA9")
    
@Override
    public CharBuffer slice() {
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        CharBuffer result = new ByteBufferAsCharBuffer(bb);
        byteBuffer.clear();
        return result;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.662 -0400", hash_original_method = "33B5F8BE8E188219F2F5547567745B18", hash_generated_method = "4AA4A19460A45419EF3F4C54D1B81B31")
    
@Override public CharBuffer subSequence(int start, int end) {
        checkStartEndRemaining(start, end);
        CharBuffer result = duplicate();
        result.limit(position + end);
        result.position(position + start);
        return result;
    }
}

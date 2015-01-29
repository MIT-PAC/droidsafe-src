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
 * This class wraps a byte buffer to be a float buffer.
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
final class ByteBufferAsFloatBuffer extends FloatBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.247 -0400", hash_original_method = "1B1307504A26763AD68B9E16002A0775", hash_generated_method = "AB333FE764537106EBCEDF081C534180")
    
static FloatBuffer asFloatBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ByteBufferAsFloatBuffer(slice);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.246 -0400", hash_original_field = "1550DCB87D4D50D3727BEA306C5BDDD3", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")


    private  ByteBuffer byteBuffer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.247 -0400", hash_original_method = "190F6F7F173C80CDDAE8922DA27C9B5D", hash_generated_method = "190F6F7F173C80CDDAE8922DA27C9B5D")
    
ByteBufferAsFloatBuffer(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.FLOAT);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.248 -0400", hash_original_method = "D0A139FD8E8772659ED119749028589D", hash_generated_method = "BE7D70729274CBAE563B684A11E3E69A")
    
@Override
    public FloatBuffer asReadOnlyBuffer() {
        ByteBufferAsFloatBuffer buf = new ByteBufferAsFloatBuffer(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.248 -0400", hash_original_method = "FBAC0D7CFE3E15F2BC0CE6753022B0DD", hash_generated_method = "F3CB90BBDF8F8CC1B934FF863C57D767")
    
@Override
    public FloatBuffer compact() {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.249 -0400", hash_original_method = "E5D6AC42E95F67FDD71590D1F05529A4", hash_generated_method = "089267C324FAF403D750D3B8D77F4C27")
    
@Override
    public FloatBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        ByteBufferAsFloatBuffer buf = new ByteBufferAsFloatBuffer(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.249 -0400", hash_original_method = "B6EAE0A3183D6C7B7623279A287B061F", hash_generated_method = "9D2FD73857D890BFAC382C4D06A93804")
    
@Override
    public float get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return byteBuffer.getFloat(position++ * SizeOf.FLOAT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.250 -0400", hash_original_method = "230A68E38935998751EB725110E55452", hash_generated_method = "333291051F34D4C7C1B5D195EFC89B01")
    
@Override
    public float get(int index) {
        checkIndex(index);
        return byteBuffer.getFloat(index * SizeOf.FLOAT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.250 -0400", hash_original_method = "A76AC3B69571CF0D73BD3DC13EE41F30", hash_generated_method = "0A3FC23C1FC489888D7B215321D29635")
    
@Override
    public FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        } else {
            ((ByteArrayBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        }
        this.position += floatCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.251 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "009663403DDC37C5A9CC05093822324F")
    
@Override
    public boolean isDirect() {
        return byteBuffer.isDirect();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.251 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "C9CF4EA86C1E45319D8243CAB871AD82")
    
@Override
    public boolean isReadOnly() {
        return byteBuffer.isReadOnly();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.251 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "72A628D0C0DB04E7966F3ACE077688CC")
    
@Override
    public ByteOrder order() {
        return byteBuffer.order();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.252 -0400", hash_original_method = "B84097C1EE35CBEC4451B3A83458D5FB", hash_generated_method = "806AA2334A727C4879F32F7FD24456C9")
    
@Override float[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.252 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "6C1DF53F257EB1584DB18DEED31F5721")
    
@Override int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.252 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "55743CF37FADA0E310D2F208DB2BEB10")
    
@Override boolean protectedHasArray() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.253 -0400", hash_original_method = "BFCE73D0BEC9C4C5044FD718D90FCD3E", hash_generated_method = "2C22A5CECD7A431F9A6C682E7EED3514")
    
@Override
    public FloatBuffer put(float c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        byteBuffer.putFloat(position++ * SizeOf.FLOAT, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.253 -0400", hash_original_method = "031128B9243B4CE1487F7A32DBB76678", hash_generated_method = "415AE599113D8030A5477E6609FDA17C")
    
@Override
    public FloatBuffer put(int index, float c) {
        checkIndex(index);
        byteBuffer.putFloat(index * SizeOf.FLOAT, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.254 -0400", hash_original_method = "8D332D9C859EBC7A29C84E9593292248", hash_generated_method = "88DFDE41A09CF5C873D1119460C35EE0")
    
@Override
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        } else {
            ((ByteArrayBuffer) byteBuffer).put(src, srcOffset, floatCount);
        }
        this.position += floatCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:44.254 -0400", hash_original_method = "00E6D8E67EF440DAD6A747EFBE57E840", hash_generated_method = "9326005339702B4701A7A61E9F5EBED9")
    
@Override
    public FloatBuffer slice() {
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        FloatBuffer result = new ByteBufferAsFloatBuffer(bb);
        byteBuffer.clear();
        return result;
    }

}

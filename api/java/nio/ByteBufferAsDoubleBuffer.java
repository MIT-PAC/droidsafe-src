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
 * This class wraps a byte buffer to be a double buffer.
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
final class ByteBufferAsDoubleBuffer extends DoubleBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.504 -0400", hash_original_method = "DF30D4B3EE157F456354B24CE657BE72", hash_generated_method = "A70E83C9A3BCE447EC2C403DEF21F121")
    
static DoubleBuffer asDoubleBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ByteBufferAsDoubleBuffer(slice);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.504 -0400", hash_original_field = "1550DCB87D4D50D3727BEA306C5BDDD3", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")


    private  ByteBuffer byteBuffer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.505 -0400", hash_original_method = "B4A6A4D697B5159EEE45EBB74DF615E8", hash_generated_method = "4CC4C4A6E653864BF88197A7106EB4D4")
    
private ByteBufferAsDoubleBuffer(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.DOUBLE);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.506 -0400", hash_original_method = "14BE8E42CCA3B23667026F47CA5F700B", hash_generated_method = "40F1308CACF3E32927FA3073771C3F16")
    
@Override
    public DoubleBuffer asReadOnlyBuffer() {
        ByteBufferAsDoubleBuffer buf = new ByteBufferAsDoubleBuffer(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.506 -0400", hash_original_method = "A0960685ED8E4B90630D067C0149A7A7", hash_generated_method = "E48B7F828D76D0EE1EFA14D5A1AA94FF")
    
@Override
    public DoubleBuffer compact() {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.507 -0400", hash_original_method = "5A8F43FDF59A9DB10DAF1449C69AA878", hash_generated_method = "3F6FA2998964A086B474120379224330")
    
@Override
    public DoubleBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        ByteBufferAsDoubleBuffer buf = new ByteBufferAsDoubleBuffer(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.507 -0400", hash_original_method = "0C75853E3C2CF6732FFCF6E98F870BD4", hash_generated_method = "8BFB2D29019C5C0E7D36420740DB24A0")
    
@Override
    public double get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return byteBuffer.getDouble(position++ * SizeOf.DOUBLE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.507 -0400", hash_original_method = "E6FEAF9DCFF95E07F26C5202FDF2E7B8", hash_generated_method = "F09B0EB843E32BF1958A62C669F9D498")
    
@Override
    public double get(int index) {
        checkIndex(index);
        return byteBuffer.getDouble(index * SizeOf.DOUBLE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.508 -0400", hash_original_method = "E67F5FF97493A20B96D31BD9CE1A16E1", hash_generated_method = "F0B0647645CF7B4CCB1841F71088A465")
    
@Override
    public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        } else {
            ((ByteArrayBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        }
        this.position += doubleCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.508 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "009663403DDC37C5A9CC05093822324F")
    
@Override
    public boolean isDirect() {
        return byteBuffer.isDirect();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.509 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "C9CF4EA86C1E45319D8243CAB871AD82")
    
@Override
    public boolean isReadOnly() {
        return byteBuffer.isReadOnly();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.509 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "72A628D0C0DB04E7966F3ACE077688CC")
    
@Override
    public ByteOrder order() {
        return byteBuffer.order();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.509 -0400", hash_original_method = "74B676FF851868B6C558CA9DCC9A472E", hash_generated_method = "1EDED707483C53FCAA2501FD3F8DF647")
    
@Override double[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.510 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "6C1DF53F257EB1584DB18DEED31F5721")
    
@Override int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.510 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "55743CF37FADA0E310D2F208DB2BEB10")
    
@Override boolean protectedHasArray() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.511 -0400", hash_original_method = "40AF4DBB8CAF825D560827D27834F61A", hash_generated_method = "56C756281100F2E62A89ECCD9A9E2DAD")
    
@Override
    public DoubleBuffer put(double c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        byteBuffer.putDouble(position++ * SizeOf.DOUBLE, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.511 -0400", hash_original_method = "86E534F052F254A7B02EA4C07E94BFA8", hash_generated_method = "CA01EB90D90845CE9B581235FFE7779F")
    
@Override
    public DoubleBuffer put(int index, double c) {
        checkIndex(index);
        byteBuffer.putDouble(index * SizeOf.DOUBLE, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.512 -0400", hash_original_method = "83AA3CA35D3620392E131679D5384134", hash_generated_method = "FC476676AC8421D04CB8C3185D011E6A")
    
@Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        } else {
            ((ByteArrayBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        }
        this.position += doubleCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:43.512 -0400", hash_original_method = "DC320730F4A63A12F1BEB05E1BE9D5E5", hash_generated_method = "1D3950FDB775873C884A6445160A9274")
    
@Override
    public DoubleBuffer slice() {
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        DoubleBuffer result = new ByteBufferAsDoubleBuffer(bb);
        byteBuffer.clear();
        return result;
    }

}

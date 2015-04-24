/*
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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public class ByteArrayInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.611 -0500", hash_original_field = "001DD3820C6A6A544AB42831C6F17A05", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.613 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.617 -0500", hash_original_field = "991588E73ADCDD01620933B72DAD6CA7", hash_generated_field = "5CD36671CA275C4800A9D662FF24FD61")

    protected int mark;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.619 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;

    /**
     * Constructs a new {@code ByteArrayInputStream} on the byte array
     * {@code buf}.
     *
     * @param buf
     *            the byte array to stream over.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.621 -0500", hash_original_method = "CF1B6A0EB8AC88640F4210354AA3396D", hash_generated_method = "22ECD6164ED993D37BCA3A52212F68AE")
    
public ByteArrayInputStream(byte[] buf) {
        this.mark = 0;
        this.buf = buf;
        this.count = buf.length;
        addTaint(buf.getTaint());
        addTaint((double)buf[0]);
    }

    /**
     * Constructs a new {@code ByteArrayInputStream} on the byte array
     * {@code buf} with the initial position set to {@code offset} and the
     * number of bytes available set to {@code offset} + {@code length}.
     *
     * @param buf
     *            the byte array to stream over.
     * @param offset
     *            the initial position in {@code buf} to start streaming from.
     * @param length
     *            the number of bytes available for streaming.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.624 -0500", hash_original_method = "CF3AD622E6B16C040D235FE2C3A31C84", hash_generated_method = "002D6764A0F21990A33FD29DEB63DF23")
    
public ByteArrayInputStream(byte[] buf, int offset, int length) {
        this.buf = buf;
        pos = offset;
        mark = offset;
        count = offset + length > buf.length ? buf.length : offset + length;
    }

    /**
     * Returns the number of remaining bytes.
     *
     * @return {@code count - pos}
     */
    @DSComment("not sensitive, memory stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.627 -0500", hash_original_method = "60B3E89517A58F980CEC13EE6BBDFCDA", hash_generated_method = "F83D86E173E2EE8747B4A5BEAFCB1DC1")
    
@Override
    public synchronized int available() {
        return count - pos;
    }

    /**
     * Closes this stream and frees resources associated with this stream.
     *
     * @throws IOException
     *             if an I/O error occurs while closing this stream.
     */
    @DSComment("not sensitive, memory stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.629 -0500", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "558F8491AE877DB6C3CABF8605DAD589")
    
@Override
    public void close() throws IOException {
        // Do nothing on close, this matches JDK behavior.
    }

    /**
     * Sets a mark position in this ByteArrayInputStream. The parameter
     * {@code readlimit} is ignored. Sending {@code reset()} will reposition the
     * stream back to the marked position.
     *
     * @param readlimit
     *            ignored.
     * @see #markSupported()
     * @see #reset()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.632 -0500", hash_original_method = "78F90254D622F331873962595002D35F", hash_generated_method = "09535714B85650F57DC3794E013DEC58")
    
@Override
    public synchronized void mark(int readlimit) {
        mark = pos;
    }

    /**
     * Indicates whether this stream supports the {@code mark()} and
     * {@code reset()} methods. Returns {@code true} since this class supports
     * these methods.
     *
     * @return always {@code true}.
     * @see #mark(int)
     * @see #reset()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.635 -0500", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "8651EC098CD56FF2A595F29537142CD3")
    
@Override
    public boolean markSupported() {
        return true;
    }

    /**
     * Reads a single byte from the source byte array and returns it as an
     * integer in the range from 0 to 255. Returns -1 if the end of the source
     * array has been reached.
     *
     * @return the byte read or -1 if the end of this stream has been reached.
     */
    @DSSource({DSSourceKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.637 -0500", hash_original_method = "BB56F6666E3E1FB5BE1E06064B4DC5BD", hash_generated_method = "1CD9D56F7E510AAFDDF684F8D4CA4A37")
    
@Override
    public synchronized int read() {
        return pos < count ? buf[pos++] & 0xFF : -1;
    }

    /**
     * Reads at most {@code len} bytes from this stream and stores
     * them in byte array {@code b} starting at {@code offset}. This
     * implementation reads bytes from the source byte array.
     *
     * @param buffer
     *            the byte array in which to store the bytes read.
     * @param offset
     *            the initial position in {@code b} to store the bytes read from
     *            this stream.
     * @param length
     *            the maximum number of bytes to store in {@code b}.
     * @return the number of bytes actually read or -1 if no bytes were read and
     *         the end of the stream was encountered.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code length < 0}, or if
     *             {@code offset + length} is greater than the size of
     *             {@code b}.
     * @throws NullPointerException
     *             if {@code b} is {@code null}.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.640 -0500", hash_original_method = "2397610A056026EF1112E9790F6EF360", hash_generated_method = "663B8330086A3871A53D5A7AE9818F19")
    
@Override
    public synchronized int read(byte[] buffer, int offset, int length) {
        Arrays.checkOffsetAndCount(buffer.length, offset, length);

        // Are there any bytes available?
        if (this.pos >= this.count) {
            return -1;
        }
        if (length == 0) {
            return 0;
        }

        int copylen = this.count - pos < length ? this.count - pos : length;
        System.arraycopy(this.buf, pos, buffer, offset, copylen);
        pos += copylen;
        return copylen;
    }

    /**
     * Resets this stream to the last marked location. This implementation
     * resets the position to either the marked position, the start position
     * supplied in the constructor or 0 if neither has been provided.
     *
     * @see #mark(int)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.642 -0500", hash_original_method = "C62CA45FA6D33EC45CB5D1463505B2CA", hash_generated_method = "8B157EA1F935A471AB47D800D0AC4AF3")
    
@Override
    public synchronized void reset() {
        pos = mark;
    }

    /**
     * Skips {@code byteCount} bytes in this InputStream. Subsequent
     * calls to {@code read} will not return these bytes unless {@code reset} is
     * used. This implementation skips {@code byteCount} number of bytes in the
     * target stream. It does nothing and returns 0 if {@code byteCount} is negative.
     *
     * @return the number of bytes actually skipped.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.645 -0500", hash_original_method = "18E56C09FFA023CF1EF098815CAD3886", hash_generated_method = "6E84A1643042A7F06B393E044B40838F")
    
@Override
    public synchronized long skip(long byteCount) {
        if (byteCount <= 0) {
            return 0;
        }
        int temp = pos;
        pos = this.count - pos < byteCount ? this.count : (int) (pos + byteCount);
        return pos - temp;
    }
    
}


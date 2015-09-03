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

public class ByteArrayOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.326 -0500", hash_original_field = "001DD3820C6A6A544AB42831C6F17A05", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.329 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;

    /**
     * Constructs a new ByteArrayOutputStream with a default size of 32 bytes.
     * If more than 32 bytes are written to this instance, the underlying byte
     * array will expand.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.332 -0500", hash_original_method = "4DC3C0B5ECFA05562A9AFEF7B1CF9D45", hash_generated_method = "FDFBFEB3E3EF5CD81ADCFCD518080293")
    
public ByteArrayOutputStream() {
        buf = new byte[32];        
    }

    /**
     * Constructs a new {@code ByteArrayOutputStream} with a default size of
     * {@code size} bytes. If more than {@code size} bytes are written to this
     * instance, the underlying byte array will expand.
     *
     * @param size
     *            initial size for the underlying byte array, must be
     *            non-negative.
     * @throws IllegalArgumentException
     *             if {@code size} < 0.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.334 -0500", hash_original_method = "931B663776F41DA70E9677006016F16F", hash_generated_method = "CE24AC27B7B66339EC71838E2850BE11")
    
public ByteArrayOutputStream(int size) {
        if (size >= 0) {
            buf = new byte[size];
        } else {
            throw new IllegalArgumentException("size < 0");
        }
    }

    /**
     * Closes this stream. This releases system resources used for this stream.
     *
     * @throws IOException
     *             if an error occurs while attempting to close this stream.
     */
    @DSComment("not sensitive, memory stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.337 -0500", hash_original_method = "04777FE12371C5E12A689BB328BF05B3", hash_generated_method = "81559B248840B4A8460F72A02952056A")
    
@Override
    public void close() throws IOException {
        /**
         * Although the spec claims "A closed stream cannot perform output
         * operations and cannot be reopened.", this implementation must do
         * nothing.
         */
        super.close();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.339 -0500", hash_original_method = "D6EC9446F27E74EA041BF330AAB72CEF", hash_generated_method = "92873E091686E9A0835B54C164A67468")
    
private void expand(int i) {
        /* Can the buffer handle @i more bytes, if not expand it */
        if (count + i <= buf.length) {
            return;
        }

        byte[] newbuf = new byte[(count + i) * 2];
        System.arraycopy(buf, 0, newbuf, 0, count);
        buf = newbuf;
    }

    /**
     * Resets this stream to the beginning of the underlying byte array. All
     * subsequent writes will overwrite any bytes previously stored in this
     * stream.
     */
    @DSComment("not sensitive, memory stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.342 -0500", hash_original_method = "D84F167B372983A8A32E17B936FA6E9B", hash_generated_method = "ABCB19599E50D7E02937CF8C013B8534")
    
public synchronized void reset() {
        count = 0;
    }

    /**
     * Returns the total number of bytes written to this stream so far.
     *
     * @return the number of bytes written to this stream.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.345 -0500", hash_original_method = "F417CE3385B772AADA134FBE4FF63C9E", hash_generated_method = "CF994FCC7B87BF04A6C8FECB8C53A973")
    
public int size() {
        return count;
    }

    /**
     * Returns the contents of this ByteArrayOutputStream as a byte array. Any
     * changes made to the receiver after returning will not be reflected in the
     * byte array returned to the caller.
     *
     * @return this stream's current contents as a byte array.
     */
    @DSComment("not sensitive, memory stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.347 -0500", hash_original_method = "F52D84F15F793E7D52B479C7891604F2", hash_generated_method = "5951B27DBA1F36D666752B978F5E613C")
    
public synchronized byte[] toByteArray() {
        byte[] newArray = new byte[count];
        System.arraycopy(buf, 0, newArray, 0, count);
        return newArray;
    }

    /**
     * Returns the contents of this ByteArrayOutputStream as a string. Any
     * changes made to the receiver after returning will not be reflected in the
     * string returned to the caller.
     *
     * @return this stream's current contents as a string.
     */

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.350 -0500", hash_original_method = "2951DD657350D2DCE6E576199EA1BCE5", hash_generated_method = "7968FA611011C95228850E21792E4778")
    
@Override
    public String toString() {
        return new String(buf, 0, count);
    }

    /**
     * Returns the contents of this ByteArrayOutputStream as a string. Each byte
     * {@code b} in this stream is converted to a character {@code c} using the
     * following function:
     * {@code c == (char)(((hibyte & 0xff) << 8) | (b & 0xff))}. This method is
     * deprecated and either {@link #toString()} or {@link #toString(String)}
     * should be used.
     *
     * @param hibyte
     *            the high byte of each resulting Unicode character.
     * @return this stream's current contents as a string with the high byte set
     *         to {@code hibyte}.
     * @deprecated Use {@link #toString()}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.353 -0500", hash_original_method = "3E105C3C1F43529FE32D861B80701B8D", hash_generated_method = "C6CFEEA61A0DCD6BB1F2236DA0668836")
    
@Deprecated
    public String toString(int hibyte) {
        char[] newBuf = new char[size()];
        for (int i = 0; i < newBuf.length; i++) {
            newBuf[i] = (char) (((hibyte & 0xff) << 8) | (buf[i] & 0xff));
        }
        return new String(newBuf);
    }

    /**
     * Returns the contents of this ByteArrayOutputStream as a string converted
     * according to the encoding declared in {@code enc}.
     *
     * @param enc
     *            a string representing the encoding to use when translating
     *            this stream to a string.
     * @return this stream's current contents as an encoded string.
     * @throws UnsupportedEncodingException
     *             if the provided encoding is not supported.
     */
    @DSComment("not sensitive, memory stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.355 -0500", hash_original_method = "E8B99C45FE2629BCCA1491714FD1F75F", hash_generated_method = "F57D6B578A28E83BF8E89D2D606E161E")
    
public String toString(String enc) throws UnsupportedEncodingException {
        return new String(buf, 0, count, enc);
    }

    /**
     * Writes {@code count} bytes from the byte array {@code buffer} starting at
     * offset {@code index} to this stream.
     *
     * @param buffer
     *            the buffer to be written.
     * @param offset
     *            the initial position in {@code buffer} to retrieve bytes.
     * @param len
     *            the number of bytes of {@code buffer} to write.
     * @throws NullPointerException
     *             if {@code buffer} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code len < 0}, or if
     *             {@code offset + len} is greater than the length of
     *             {@code buffer}.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.358 -0500", hash_original_method = "6803EEF19C65AA8F03D81EBEC2EC6C85", hash_generated_method = "E48309311986BABB80FA0DD25BCC37B3")
    
@Override
    public synchronized void write(byte[] buffer, int offset, int len) {
        Arrays.checkOffsetAndCount(buffer.length, offset, len);
        if (len == 0) {
            return;
        }
        expand(len);
        System.arraycopy(buffer, offset, buf, this.count, len);
        this.count += len;
    }

    /**
     * Writes the specified byte {@code oneByte} to the OutputStream. Only the
     * low order byte of {@code oneByte} is written.
     *
     * @param oneByte
     *            the byte to be written.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.360 -0500", hash_original_method = "0E8EDDE6C6CD9DF7AD28FE0F8F877448", hash_generated_method = "EC4AA14B7223D43B9330AFEFE8B74404")
    
@Override
    public synchronized void write(int oneByte) {
        if (count == buf.length) {
            expand(1);
        }
        buf[count++] = (byte) oneByte;
        
        //propagate it to the base class OutputStrea
        addTaint(oneByte);
    }

    /**
     * Takes the contents of this stream and writes it to the output stream
     * {@code out}.
     *
     * @param out
     *            an OutputStream on which to write the contents of this stream.
     * @throws IOException
     *             if an error occurs while writing to {@code out}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.363 -0500", hash_original_method = "19AD6C910070CA1BF00692AA88EF7627", hash_generated_method = "E8A59A9914B35A8F5F08030434E3B1BF")
    
public synchronized void writeTo(OutputStream out) throws IOException {
        out.write(buf, 0, count);
    }
    
}


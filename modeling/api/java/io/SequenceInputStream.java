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
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.515 -0500", hash_original_field = "978C925AD7599B7FA8038D4E71D9603D", hash_generated_field = "18AD9586F739C9162783E991FCA98C7A")

    private Enumeration<? extends InputStream> e;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.517 -0500", hash_original_field = "0A829BC26C36EAF422E245C1EC11D5B0", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;

    /**
     * Constructs a new {@code SequenceInputStream} using the two streams
     * {@code s1} and {@code s2} as the sequence of streams to read from.
     *
     * @param s1
     *            the first stream to get bytes from.
     * @param s2
     *            the second stream to get bytes from.
     * @throws NullPointerException
     *             if {@code s1} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.520 -0500", hash_original_method = "29105F0198123C3B47FC811BDEDF639D", hash_generated_method = "FAE899BBBE3848D239BB94B55785FAFA")
    
public SequenceInputStream(InputStream s1, InputStream s2) {
        if (s1 == null) {
            throw new NullPointerException();
        }
        Vector<InputStream> inVector = new Vector<InputStream>(1);
        inVector.addElement(s2);
        e = inVector.elements();
        in = s1;
    }

    /**
     * Constructs a new SequenceInputStream using the elements returned from
     * Enumeration {@code e} as the stream sequence. The instances returned by
     * {@code e.nextElement()} must be of type {@link InputStream}.
     *
     * @param e
     *            the enumeration of {@code InputStreams} to get bytes from.
     * @throws NullPointerException
     *             if any of the elements in {@code e} is {@code null}.
     */
    @DSComment("not sensitive, memory stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.523 -0500", hash_original_method = "4836B5679700B3654AB08A07E2FBBEF0", hash_generated_method = "AAFB9F87E498C432E91EC33F6617B737")
    
public SequenceInputStream(Enumeration<? extends InputStream> e) {
        this.e = e;
        if (e.hasMoreElements()) {
            in = e.nextElement();
            if (in == null) {
                throw new NullPointerException();
            }
        }
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.526 -0500", hash_original_method = "989AE899244AE453B2C16F0363EA8BF3", hash_generated_method = "02B44B8FAFB26FBCA83D48F0525D06EA")
    
@Override
    public int available() throws IOException {
        if (e != null && in != null) {
            return in.available();
        }
        return 0;
    }

    /**
     * Closes all streams in this sequence of input stream.
     *
     * @throws IOException
     *             if an error occurs while closing any of the input streams.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.528 -0500", hash_original_method = "1749070D39A948E7280B7E9ED33867CE", hash_generated_method = "AF5F3B912050135F4B8E788773021C22")
    
@Override
    public void close() throws IOException {
        while (in != null) {
            nextStream();
        }
        e = null;
    }

    /**
     * Sets up the next InputStream or leaves it alone if there are none left.
     *
     * @throws IOException
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.531 -0500", hash_original_method = "AA61F30EE9F68EF2787A55BE84FD9C61", hash_generated_method = "A7C3AA52849A0E697C5FC3DACAD2587D")
    
private void nextStream() throws IOException {
        if (in != null) {
            in.close();
        }
        if (e.hasMoreElements()) {
            in = e.nextElement();
            if (in == null) {
                throw new NullPointerException();
            }
        } else {
            in = null;
        }
    }

    /**
     * Reads a single byte from this sequence of input streams and returns it as
     * an integer in the range from 0 to 255. It tries to read from the current
     * stream first; if the end of this stream has been reached, it reads from
     * the next one. Blocks until one byte has been read, the end of the last
     * input stream in the sequence has been reached, or an exception is thrown.
     *
     * @return the byte read or -1 if either the end of the last stream in the
     *         sequence has been reached or this input stream sequence is
     *         closed.
     * @throws IOException
     *             if an error occurs while reading the current source input
     *             stream.
     */
    @DSSource({DSSourceKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.533 -0500", hash_original_method = "2AFBD8CC3EA20986AC27924C0AD5D7EE", hash_generated_method = "ABB08D2AC960F1D8DE8C995F725AAEFC")
    
@Override
    public int read() throws IOException {
        while (in != null) {
            int result = in.read();
            if (result >= 0) {
                return result;
            }
            nextStream();
        }
        return -1;
    }

    /**
     * Reads at most {@code count} bytes from this sequence of input streams and
     * stores them in the byte array {@code buffer} starting at {@code offset}.
     * Blocks only until at least 1 byte has been read, the end of the stream
     * has been reached, or an exception is thrown.
     * <p>
     * This SequenceInputStream shows the same behavior as other InputStreams.
     * To do this it will read only as many bytes as a call to read on the
     * current substream returns. If that call does not return as many bytes as
     * requested by {@code count}, it will not retry to read more on its own
     * because subsequent reads might block. This would violate the rule that
     * it will only block until at least one byte has been read.
     * <p>
     * If a substream has already reached the end when this call is made, it
     * will close that substream and start with the next one. If there are no
     * more substreams it will return -1.
     *
     * @param buffer
     *            the array in which to store the bytes read.
     * @param offset
     *            the initial position in {@code buffer} to store the bytes read
     *            from this stream.
     * @param count
     *            the maximum number of bytes to store in {@code buffer}.
     * @return the number of bytes actually read; -1 if this sequence of streams
     *         is closed or if the end of the last stream in the sequence has
     *         been reached.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if {@code
     *             offset + count} is greater than the size of {@code buffer}.
     * @throws IOException
     *             if an I/O error occurs.
     * @throws NullPointerException
     *             if {@code buffer} is {@code null}.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.536 -0500", hash_original_method = "D0BE57C4BCBFEEAAABF8F255E34909BC", hash_generated_method = "22342A6D5C517E89E4A3F3617B99EA99")
    
@Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        if (in == null) {
            return -1;
        }
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        while (in != null) {
            int result = in.read(buffer, offset, count);
            if (result >= 0) {
                return result;
            }
            nextStream();
        }
        return -1;
    }
    
}


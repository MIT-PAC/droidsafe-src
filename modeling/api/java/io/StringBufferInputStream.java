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
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;
public class StringBufferInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.668 -0500", hash_original_field = "5691B23D11017F76E02A170C10F2BD89", hash_generated_field = "ED717DDCA3146879332E3CB1E590C4E3")

    protected String buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.670 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.672 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;

    /**
     * Construct a new {@code StringBufferInputStream} with {@code str} as
     * source. The size of the stream is set to the {@code length()} of the
     * string.
     *
     * @param str
     *            the source string for this stream.
     * @throws NullPointerException
     *             if {@code str} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.676 -0500", hash_original_method = "76979FB4443A3642C3C41F9A7D4BA5B1", hash_generated_method = "7DEF0E9BB2901FC0F2A6B1EF62CDFB90")
    
public StringBufferInputStream(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        buffer = str;
        count = str.length();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.679 -0500", hash_original_method = "60B3E89517A58F980CEC13EE6BBDFCDA", hash_generated_method = "F83D86E173E2EE8747B4A5BEAFCB1DC1")
    
@Override
    public synchronized int available() {
        return count - pos;
    }

    /**
     * Reads a single byte from the source string and returns it as an integer
     * in the range from 0 to 255. Returns -1 if the end of the source string
     * has been reached.
     *
     * @return the byte read or -1 if the end of the source string has been
     *         reached.
     */
    @DSSource({DSSourceKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.681 -0500", hash_original_method = "13B1BC43B8C5BB9B164E62DA1A0BBF2A", hash_generated_method = "6F9AB4C50A662290F4B5F8D5EC47BCC8")
    
@Override
    public synchronized int read() {
        return pos < count ? buffer.charAt(pos++) & 0xFF : -1;
    }

    /**
     * Reads at most {@code length} bytes from the source string and stores them
     * in the byte array {@code b} starting at {@code offset}.
     *
     * @param buffer
     *            the byte array in which to store the bytes read.
     * @param offset
     *            the initial position in {@code b} to store the bytes read from
     *            this stream.
     * @param length
     *            the maximum number of bytes to store in {@code b}.
     * @return the number of bytes actually read or -1 if the end of the source
     *         string has been reached.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code length < 0}, or if
     *             {@code offset + length} is greater than the length of
     *             {@code b}.
     * @throws NullPointerException
     *             if {@code b} is {@code null}.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.685 -0500", hash_original_method = "72F57B370F566A93B2245D6F4EE475E3", hash_generated_method = "67AFE95D1DF95898453DD8D3E1C1559C")
    
@Override
    public synchronized int read(byte[] buffer, int offset, int length) {
        if (buffer == null) {
            throw new NullPointerException("buffer == null");
        }
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        if (length == 0) {
            return 0;
        }

        int copylen = count - pos < length ? count - pos : length;
        for (int i = 0; i < copylen; i++) {
            buffer[offset + i] = (byte) this.buffer.charAt(pos + i);
        }
        pos += copylen;
        return copylen;
    }

    /**
     * Resets this stream to the beginning of the source string.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.687 -0500", hash_original_method = "4A8566B6C9E948D021F9A160FC69F9F0", hash_generated_method = "B203292C024EC0BD68E507B4BF96ACB1")
    
@Override
    public synchronized void reset() {
        pos = 0;
    }

    /**
     * Skips {@code charCount} characters in the source string. It does nothing and
     * returns 0 if {@code charCount} is negative. Less than {@code charCount} characters are
     * skipped if the end of the source string is reached before the operation
     * completes.
     *
     * @return the number of characters actually skipped.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.690 -0500", hash_original_method = "CF6031E947756BEE937415A3AF461C41", hash_generated_method = "A9917BF0DADF84F2E687E96438ADEB0F")
    
@Override
    public synchronized long skip(long charCount) {
        if (charCount <= 0) {
            return 0;
        }

        int numskipped;
        if (this.count - pos < charCount) {
            numskipped = this.count - pos;
            pos = this.count;
        } else {
            numskipped = (int) charCount;
            pos += charCount;
        }
        return numskipped;
    }
    
}


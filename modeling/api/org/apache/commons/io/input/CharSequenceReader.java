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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.io.input;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Reader;
import java.io.Serializable;

/**
 * {@link Reader} implementation that can read from String, StringBuffer,
 * StringBuilder or CharBuffer.
 * <p>
 * <strong>Note:</strong> Supports {@link #mark(int)} and {@link #reset()}.
 *
 * @version $Id: CharSequenceReader.java 1307461 2012-03-30 15:12:29Z ggregory $
 * @since 1.4
 */
public class CharSequenceReader extends Reader implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.335 -0400", hash_original_field = "C9E55D7B01085E843F2DBF64FC9544D5", hash_generated_field = "628CA2327BAF8770AC77399355FDC52D")

    private  CharSequence charSequence;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.336 -0400", hash_original_field = "56CB30AE4D1FDFD14E6ECC30D8B6AAD0", hash_generated_field = "89AA0A275323729DA7EFED27B4506FAF")

    private int idx;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.336 -0400", hash_original_field = "991588E73ADCDD01620933B72DAD6CA7", hash_generated_field = "C8691DE93C87EAA877C8B89B47679C83")

    private int mark;

    /**
     * Construct a new instance with the specified character sequence.
     *
     * @param charSequence The character sequence, may be {@code null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.337 -0400", hash_original_method = "182A6C4ED1D1E19AB9569E928EB756A5", hash_generated_method = "271C1670CF8BC6153F082F32F6322B9F")
    
public CharSequenceReader(CharSequence charSequence) {
        this.charSequence = charSequence != null ? charSequence : "";
    }

    /**
     * Close resets the file back to the start and removes any marked position.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.337 -0400", hash_original_method = "40FE3D25511A62018FC369BF8427CEB7", hash_generated_method = "E555F44876A2103FC7372A2E8BF3597A")
    
@Override
    public void close() {
        idx = 0;
        mark = 0;
    }

    /**
     * Mark the current position.
     *
     * @param readAheadLimit ignored
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.338 -0400", hash_original_method = "AE312126AF817511B6AC9FA9A8EAB6F5", hash_generated_method = "5C0FD56F27A38F18958A78AD40CC95DD")
    
@Override
    public void mark(int readAheadLimit) {
        mark = idx;
    }

    /**
     * Mark is supported (returns true).
     *
     * @return {@code true}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.338 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "8651EC098CD56FF2A595F29537142CD3")
    
@Override
    public boolean markSupported() {
        return true;
    }

    /**
     * Read a single character.
     *
     * @return the next character from the character sequence
     * or -1 if the end has been reached.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.339 -0400", hash_original_method = "9ACE53EBE9E224BA089484C6AABDF5C3", hash_generated_method = "0139704B104F196A88422C5465D86838")
    
@Override
    public int read() {
        if (idx >= charSequence.length()) {
            return -1;
        } else {
            return charSequence.charAt(idx++);
        }
    }

    /**
     * Read the sepcified number of characters into the array.
     *
     * @param array The array to store the characters in
     * @param offset The starting position in the array to store
     * @param length The maximum number of characters to read
     * @return The number of characters read or -1 if there are
     * no more
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.340 -0400", hash_original_method = "9EABECFB34552C6029ED722DF84F07FF", hash_generated_method = "A1E714C7101539F653873C5BAA608E48")
    
@Override
    public int read(char[] array, int offset, int length) {
        if (idx >= charSequence.length()) {
            return -1;
        }
        if (array == null) {
            throw new NullPointerException("Character array is missing");
        }
        if (length < 0 || offset < 0 || offset + length > array.length) {
            throw new IndexOutOfBoundsException("Array Size=" + array.length +
                    ", offset=" + offset + ", length=" + length);
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            int c = read();
            if (c == -1) {
                return count;
            }
            array[offset + i] = (char)c;
            count++;
        }
        return count;
    }

    /**
     * Reset the reader to the last marked position (or the beginning if
     * mark has not been called).
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.340 -0400", hash_original_method = "854753638CC0197CC47838DCD9FB66E4", hash_generated_method = "A0088BD4733B7FC8F6BFA14F91107A67")
    
@Override
    public void reset() {
        idx = mark;
    }

    /**
     * Skip the specified number of characters.
     *
     * @param n The number of characters to skip
     * @return The actual number of characters skipped
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.341 -0400", hash_original_method = "75F54BDE1C47E9678EFB232794384C6F", hash_generated_method = "862BEA436CADF88DE9A7A340F87E1725")
    
@Override
    public long skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    "Number of characters to skip is less than zero: " + n);
        }
        if (idx >= charSequence.length()) {
            return -1;
        }
        int dest = (int)Math.min(charSequence.length(), idx + n);
        int count = dest - idx;
        idx = dest;
        return count;
    }

    /**
     * Return a String representation of the underlying
     * character sequence.
     *
     * @return The contents of the character sequence
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.342 -0400", hash_original_method = "610F60ED6DB50185F33A85945665EF11", hash_generated_method = "57A04B03533AEBB95DA85C73B06358AD")
    
@Override
    public String toString() {
        return charSequence.toString();
    }
}

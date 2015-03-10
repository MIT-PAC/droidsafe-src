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

public abstract class OutputStream implements Closeable, Flushable {

    /**
     * Default constructor.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.823 -0500", hash_original_method = "5995752F91892DAFA432449AA7A2BB76", hash_generated_method = "1D6DCD4069A5099E588E31C568880D1D")
    
public OutputStream() {
    }

    /**
     * Closes this stream. Implementations of this method should free any
     * resources used by the stream. This implementation does nothing.
     *
     * @throws IOException
     *             if an error occurs while closing this stream.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.825 -0500", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "BDB80A0BA0CE964F390B74B4F78F39D0")
    
public void close() throws IOException {
        /* empty */
    }

    /**
     * Flushes this stream. Implementations of this method should ensure that
     * any buffered data is written out. This implementation does nothing.
     *
     * @throws IOException
     *             if an error occurs while flushing this stream.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.827 -0500", hash_original_method = "1521992F8E9F05A9FDFB0E59716E3E93", hash_generated_method = "243C0871CD5D1DDEC1C9766742E8A0B7")
    
public void flush() throws IOException {
        /* empty */
    }

    /**
     * Equivalent to {@code write(buffer, 0, buffer.length)}.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.829 -0500", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "227B669FDA8AD574341B08A5DD95557F")
    
public void write(byte[] buffer) throws IOException {
        write(buffer, 0, buffer.length);
    }

    /**
     * Writes {@code count} bytes from the byte array {@code buffer} starting at
     * position {@code offset} to this stream.
     *
     * @param buffer
     *            the buffer to be written.
     * @param offset
     *            the start position in {@code buffer} from where to get bytes.
     * @param count
     *            the number of bytes from {@code buffer} to write to this
     *            stream.
     * @throws IOException
     *             if an error occurs while writing to this stream.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if
     *             {@code offset + count} is bigger than the length of
     *             {@code buffer}.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.832 -0500", hash_original_method = "F6CDEA64748F80FE862CBAFFE4725DDE", hash_generated_method = "CDD044E99B9A9B3DC054F6D500C9D2DA")
    
public void write(byte[] buffer, int offset, int count) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        for (int i = offset; i < offset + count; i++) {
            write(buffer[i]);
        }
    }

    /**
     * Writes a single byte to this stream. Only the least significant byte of
     * the integer {@code oneByte} is written to the stream.
     *
     * @param oneByte
     *            the byte to be written.
     * @throws IOException
     *             if an error occurs while writing to this stream.
     */
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.835 -0500", hash_original_method = "6F952A0997C9C7FC75CA00C51592E230", hash_generated_method = "EFF3C84F96B0F410A6246A434AA1C3DB")
    
public abstract void write(int oneByte) throws IOException;

    /**
     * Returns true if this writer has encountered and suppressed an error. Used
     * by PrintStreams as an alternative to checked exceptions.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.837 -0500", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8")
    
boolean checkError() {
        return false;
    }
    
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeWrite(int oneByte) {
        addTaint(oneByte);
    }
    
}


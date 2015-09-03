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
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;

public abstract class FilterWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.139 -0500", hash_original_field = "EBCE22DD0E30FF0E4040ABB2E7F29C97", hash_generated_field = "8FF81F1EABE94AA2FE1148793CBBDC2D")

    protected Writer out;

    /**
     * Constructs a new FilterWriter on the Writer {@code out}. All writes are
     * now filtered through this writer.
     *
     * @param out
     *            the target Writer to filter writes on.
     */
    @DSComment("IO reader/writer construtor")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.142 -0500", hash_original_method = "C9832951E5B51AA5FF45C56E637B6353", hash_generated_method = "512D40C5894D17A76D1DCE0C5DD17367")
    
protected FilterWriter(Writer out) {
        super(out);
        this.out = out;
    }

    /**
     * Closes this writer. This implementation closes the target writer.
     *
     * @throws IOException
     *             if an error occurs attempting to close this writer.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.144 -0500", hash_original_method = "05673170CC0D0E023F5651E2EFB2043A", hash_generated_method = "45CCF4926380A2CEB56B7EE47CF351E8")
    
@Override
    public void close() throws IOException {
        synchronized (lock) {
            out.close();
        }
    }

    /**
     * Flushes this writer to ensure all pending data is sent out to the target
     * writer. This implementation flushes the target writer.
     *
     * @throws IOException
     *             if an error occurs attempting to flush this writer.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.147 -0500", hash_original_method = "6E517A9D20FAB02C8C7ECBD26B835783", hash_generated_method = "C55B90E5292B86C7CB54EE3BBC993E7C")
    
@Override
    public void flush() throws IOException {
        synchronized (lock) {
            out.flush();
        }
    }

    /**
     * Writes {@code count} characters from the char array {@code buffer}
     * starting at position {@code offset} to the target writer.
     *
     * @param buffer
     *            the buffer to write.
     * @param offset
     *            the index of the first character in {@code buffer} to write.
     * @param count
     *            the number of characters in {@code buffer} to write.
     * @throws IOException
     *             if an error occurs while writing to this writer.
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.149 -0500", hash_original_method = "8844CE5B6BE403964369DBE67DE17A9B", hash_generated_method = "2E00E4C573A8E41256FB0356A1320F41")
    
@Override
    public void write(char[] buffer, int offset, int count) throws IOException {
        synchronized (lock) {
            out.write(buffer, offset, count);
        }
    }

    /**
     * Writes the specified character {@code oneChar} to the target writer. Only the
     * two least significant bytes of the integer {@code oneChar} are written.
     *
     * @param oneChar
     *            the char to write to the target writer.
     * @throws IOException
     *             if an error occurs while writing to this writer.
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.153 -0500", hash_original_method = "C0F1D18AD38B0E8F448CFE46E5D9188A", hash_generated_method = "83C4E3F94324FAE20304ACFEED490308")
    
@Override
    public void write(int oneChar) throws IOException {
        synchronized (lock) {
            out.write(oneChar);
        }
    }

    /**
     * Writes {@code count} characters from the string {@code str} starting at
     * position {@code index} to this writer. This implementation writes
     * {@code str} to the target writer.
     *
     * @param str
     *            the string to be written.
     * @param offset
     *            the index of the first character in {@code str} to write.
     * @param count
     *            the number of chars in {@code str} to write.
     * @throws IOException
     *             if an error occurs while writing to this writer.
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.155 -0500", hash_original_method = "C7C8D1E997868E998D408F658DA19BDC", hash_generated_method = "7E939F34F6EFB94386E9711D9B6784A2")
    
@Override
    public void write(String str, int offset, int count) throws IOException {
        synchronized (lock) {
            out.write(str, offset, count);
        }
    }
    
}


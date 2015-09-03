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
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.zip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;

public class GZIPOutputStream extends DeflaterOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.922 -0500", hash_original_field = "8797544496C08ADE2D4F77E9A38D0FB1", hash_generated_field = "C9B4058E3717760CA96883C40FEF405D")

    protected CRC32 crc = new CRC32();

    /**
     * Construct a new {@code GZIPOutputStream} to write data in GZIP format to
     * the underlying stream.
     *
     * @param os
     *            the {@code OutputStream} to write data to.
     * @throws IOException
     *             if an {@code IOException} occurs.
     */
    @DSComment("IO/Stream accessing")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.925 -0500", hash_original_method = "2B29886F93DAD97985C1121E7A12F1EB", hash_generated_method = "4EBA3666AEC6F4D602136FF2FC083F36")
    
public GZIPOutputStream(OutputStream os) throws IOException {
        this(os, BUF_SIZE);
    }

    /**
     * Construct a new {@code GZIPOutputStream} to write data in GZIP format to
     * the underlying stream. Set the internal compression buffer to size
     * {@code size}.
     *
     * @param os
     *            the {@code OutputStream} to write to.
     * @param size
     *            the internal buffer size.
     * @throws IOException
     *             if an {@code IOException} occurs.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.928 -0500", hash_original_method = "982A9C109F13C35696C1D1D71982D2AE", hash_generated_method = "B57F57453763161E8A8F13028AC91462")
    
public GZIPOutputStream(OutputStream os, int size) throws IOException {
        super(os, new Deflater(Deflater.DEFAULT_COMPRESSION, true), size);
        writeShort(GZIPInputStream.GZIP_MAGIC);
        out.write(Deflater.DEFLATED);
        out.write(0); // flags
        writeLong(0); // mod time
        out.write(0); // extra flags
        out.write(0); // operating system
    }

    /**
     * Indicates to the stream that all data has been written out, and any GZIP
     * terminal data can now be written.
     *
     * @throws IOException
     *             if an {@code IOException} occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.931 -0500", hash_original_method = "A3CDE33229CB27B38C3E63AFF1767104", hash_generated_method = "26BC287997A7254A5A12B42366A4EE4F")
    
@Override
    public void finish() throws IOException {
        super.finish();
        writeLong(crc.getValue());
        writeLong(crc.tbytes);
    }

    /**
     * Write up to nbytes of data from the given buffer, starting at offset off,
     * to the underlying stream in GZIP format.
     */
    @DSComment("IO/Stream accessing")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.933 -0500", hash_original_method = "3845FBBF6C0965A8BD527CE35C72F9CE", hash_generated_method = "FBEDB0427C9F5135E9A7874A797C5A41")
    
@Override
    public void write(byte[] buffer, int off, int nbytes) throws IOException {
        super.write(buffer, off, nbytes);
        crc.update(buffer, off, nbytes);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.936 -0500", hash_original_method = "47F39FA28854367E1C176B836238D964", hash_generated_method = "A10CA5051B4714D6AD80970BEA237AE3")
    
private long writeLong(long i) throws IOException {
        // Write out the long value as an unsigned int
        int unsigned = (int) i;
        out.write(unsigned & 0xFF);
        out.write((unsigned >> 8) & 0xFF);
        out.write((unsigned >> 16) & 0xFF);
        out.write((unsigned >> 24) & 0xFF);
        return i;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.938 -0500", hash_original_method = "22B8B662F709BB8BFEF4CD6C31753D50", hash_generated_method = "53FBFB19EE2DCED99DD16824297DCC0A")
    
private int writeShort(int i) throws IOException {
        out.write(i & 0xFF);
        out.write((i >> 8) & 0xFF);
        return i;
    }
    
}


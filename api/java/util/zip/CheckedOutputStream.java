/*
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

package java.util.zip;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * The {@code CheckedOutputStream} class is used to maintain a running checksum
 * of all data written to a stream. The purpose of this checksum is to establish
 * data integrity, by publishing the checksum to other parties wanting to read
 * the non corrupted data.
 */
public class CheckedOutputStream extends java.io.FilterOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.171 -0400", hash_original_field = "4AE29764ABB14C73F8209F7640A7CC1D", hash_generated_field = "17891C0CAF0BD7DDA9A721E3165E41B4")


    private  Checksum check;

    /**
     * Constructs a new {@code CheckedOutputStream} on {@code OutputStream}
     * {@code os}. The checksum is calculated using the algorithm implemented
     * by {@code csum}.
     *
     * @param os
     *            the output stream to calculate checksum for.
     * @param cs
     *            an entity implementing the checksum algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.172 -0400", hash_original_method = "56E4D0CBC2AA216E79C64E271338D82B", hash_generated_method = "65432651422B7AB519A1FFFB728A30BA")
    
public CheckedOutputStream(OutputStream os, Checksum cs) {
        super(os);
        check = cs;
    }

    /**
     * Returns the checksum calculated on the stream read so far.
     *
     * @return the updated checksum.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.172 -0400", hash_original_method = "8D60BCB1BD17D4099BEB55CEF28E25BB", hash_generated_method = "ACB993D8534E9018B97946C2173993C4")
    
public Checksum getChecksum() {
        return check;
    }

    /**
     * Writes the specified byte to the underlying stream. The checksum is
     * updated with {@code val}.
     *
     * @param val
     *            the data value to written to the output stream.
     * @throws IOException
     *             if an IO error has occurred.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.172 -0400", hash_original_method = "2DF83CFEF9E6036227219DB8EF0DD76F", hash_generated_method = "93BEF2EF8387275EBA02ADEBCAE1FB6B")
    
@Override
    public void write(int val) throws IOException {
        out.write(val);
        check.update(val);
    }

    /**
     * Writes n bytes of data from {@code buf} starting at offset {@code off} to
     * the underlying stream. The checksum is updated with the bytes written.
     *
     * @param buf
     *            data written to the output stream.
     * @param off
     *            the offset to start reading the data from {@code buf} written
     *            to the output stream.
     * @param nbytes
     *            number of bytes to write to the output stream.
     * @throws IOException
     *             if an IO error has occurred.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.173 -0400", hash_original_method = "AB520801C576DAA6BCE159FF29C6C3E4", hash_generated_method = "05EAC1A8146DA2C29616A364C44780DE")
    
@Override
    public void write(byte[] buf, int off, int nbytes) throws IOException {
        out.write(buf, off, nbytes);
        check.update(buf, off, nbytes);
    }
}

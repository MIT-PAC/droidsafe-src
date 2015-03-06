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


package java.security;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * {@code DigestInputStream} is a {@code FilterInputStream} which maintains an
 * associated message digest.
 */
public class DigestInputStream extends FilterInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.444 -0400", hash_original_field = "6490B74EBA547C3BEF2402BDE5E0FF43", hash_generated_field = "8DA730CB679B04148593A439C35CDEC7")

    protected MessageDigest digest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.445 -0400", hash_original_field = "37B9E5AB72663E618FF17BD6EAAD2FA0", hash_generated_field = "C3E57B5DDC38B195C9150C6EAC92AC46")

    private boolean isOn = true;

    /**
     * Constructs a new instance of this {@code DigestInputStream}, using the
     * given {@code stream} and the {@code digest}.
     *
     * <p><strong>Warning:</strong> passing a null source creates an invalid
     * {@code DigestInputStream}. All operations on such a stream will fail.
     *
     * @param stream
     *            the input stream.
     * @param digest
     *            the message digest.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.447 -0400", hash_original_method = "E976EB2BAEF0B93C6A9713EA5E558A88", hash_generated_method = "98D482C31EBB831D60F25E3B310CBECE")
    
public DigestInputStream(InputStream stream, MessageDigest digest) {
        super(stream);
        this.digest = digest;
    }

    /**
     * Returns the message digest for this stream.
     *
     * @return the message digest for this stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.448 -0400", hash_original_method = "22DB117AAAA8039A00B962C7F1A2ACC4", hash_generated_method = "6A8A800C6F70EA71C7E1EAB102924AAC")
    
public MessageDigest getMessageDigest() {
        return digest;
    }

    /**
     * Sets the message digest which this stream will use.
     *
     * @param digest
     *            the message digest which this stream will use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.450 -0400", hash_original_method = "E9866D35830711BE495B9AF765AA4FDB", hash_generated_method = "3B6C2904F561F7693204A914724472E2")
    
public void setMessageDigest(MessageDigest digest) {
        this.digest = digest;
    }

    /**
     * Reads the next byte and returns it as an {@code int}. Updates the digest
     * for the byte if this function is {@link #on(boolean)}.
     * <p>
     * This operation is blocking.
     *
     * @return the byte which was read or -1 at end of stream.
     * @throws IOException
     *             if reading the source stream causes an {@code IOException}.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.451 -0400", hash_original_method = "CE5E9376456B694DC2A0B97189343D71", hash_generated_method = "D99D8A443B82BE368AE5B2234F8832D3")
    
@Override
    public int read() throws IOException {
        // read the next byte
        int byteRead = in.read();
        // update digest only if
        // - digest functionality is on
        // - eos has not been reached
        if (isOn && (byteRead != -1)) {
            digest.update((byte)byteRead);
        }
        // return byte read
        return byteRead;
    }

    /**
     * Reads {@code len} bytes into the specified {@code byte[]}, starting from
     * the specified offset. Updates the digest if this function is
     * {@link #on(boolean)}.
     * <p>
     * This operation is blocking.
     *
     * @param b
     *            the byte array in which to store the bytes
     * @param off
     *            the initial position in {@code b} to store the bytes read from
     *            this stream
     * @param len
     *            the maximum number of bytes to store in {@code b}
     * @return the number of bytes actually read or -1 if the end of the
     *         filtered stream has been reached while reading
     * @throws IOException
     *             if reading the source stream causes an {@code IOException}
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.453 -0400", hash_original_method = "6B5CA766D30FA77A4EDC8D5B97D55443", hash_generated_method = "75B0971D8DF8AC2D06CAF83D1C1D3971")
    
@Override
    public int read(byte[] b, int off, int len) throws IOException {
        // read next up to len bytes
        int bytesRead = in.read(b, off, len);
        // update digest only if
        // - digest functionality is on
        // - eos has not been reached
        if (isOn && (bytesRead != -1)) {
            digest.update(b, off, bytesRead);
        }
        // return number of bytes read
        return bytesRead;
    }

    /**
     * Enables or disables the digest function (default is on).
     *
     * @param on
     *            {@code true} if the digest should be computed, {@code false}
     *            otherwise.
     * @see MessageDigest
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.454 -0400", hash_original_method = "3D6ED86CB32057B75140F25F5AFE5484", hash_generated_method = "AC2B6074B8350E280C8D594B75EA9D8C")
    
public void on(boolean on) {
        isOn = on;
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * {@code DigestInputStream} including the digest.
     *
     * @return a printable representation for this {@code DigestInputStream}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.457 -0400", hash_original_method = "4B13C7C889B2A909FFC668347DF457C3", hash_generated_method = "B8E996CE2552E95167EBDB1291062299")
    
@Override
    public String toString() {
        return super.toString() + ", " + digest.toString() +
            (isOn ? ", is on" : ", is off");
    }
}

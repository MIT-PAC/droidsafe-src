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
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * {@code DigestOutputStream} is a {@code FilterOutputStream} which maintains an
 * associated message digest.
 */
public class DigestOutputStream extends FilterOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.488 -0400", hash_original_field = "6490B74EBA547C3BEF2402BDE5E0FF43", hash_generated_field = "8DA730CB679B04148593A439C35CDEC7")

    protected MessageDigest digest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.489 -0400", hash_original_field = "37B9E5AB72663E618FF17BD6EAAD2FA0", hash_generated_field = "C3E57B5DDC38B195C9150C6EAC92AC46")

    private boolean isOn = true;

    /**
     * Constructs a new instance of this {@code DigestOutputStream}, using the
     * given {@code stream} and the {@code digest}.
     *
     * @param stream
     *            the output stream.
     * @param digest
     *            the message digest.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.490 -0400", hash_original_method = "326A31D3AD80931B0EA2E58741ECF534", hash_generated_method = "A1AE3E7D49B2EEBD1FF480E07BCEE4A8")
    
public DigestOutputStream(OutputStream stream, MessageDigest digest) {
        super(stream);
        this.digest = digest;
    }

    /**
     * Returns the message digest for this stream.
     *
     * @return the message digest for this stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.492 -0400", hash_original_method = "22DB117AAAA8039A00B962C7F1A2ACC4", hash_generated_method = "6A8A800C6F70EA71C7E1EAB102924AAC")
    
public MessageDigest getMessageDigest() {
        return digest;
    }

    /**
     * Sets the message digest which this stream will use.
     *
     * @param digest
     *            the message digest which this stream will use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.493 -0400", hash_original_method = "E9866D35830711BE495B9AF765AA4FDB", hash_generated_method = "3B6C2904F561F7693204A914724472E2")
    
public void setMessageDigest(MessageDigest digest) {
        this.digest = digest;
    }

    /**
     * Writes the specified {@code int} to the stream. Updates the digest if
     * this function is {@link #on(boolean)}.
     *
     * @param b
     *            the byte to be written.
     * @throws IOException
     *             if writing to the stream causes a {@code IOException}
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.494 -0400", hash_original_method = "1DC42AADF909EF36A66F7452F9B5F17D", hash_generated_method = "E9C1138607C630499EC31CC2BB8DBBA8")
    
@Override
    public void write(int b) throws IOException {
        // update digest only if digest functionality is on
        if (isOn) {
            digest.update((byte)b);
        }
        // write the byte
        out.write(b);
    }

    /**
     * Writes {@code len} bytes into the stream, starting from the specified
     * offset. Updates the digest if this function is {@link #on(boolean)}.
     *
     * @param b
     *            the buffer to write to.
     * @param off
     *            the index of the first byte in {@code b} to write.
     * @param len
     *            the number of bytes in {@code b} to write.
     * @throws IOException
     *             if writing to the stream causes an {@code IOException}.
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.496 -0400", hash_original_method = "78D0CB148C68F9A200832EB116A08570", hash_generated_method = "8E3437987AD1131016FB71D1F4F69E98")
    
@Override
    public void write(byte[] b, int off, int len) throws IOException {
        // update digest only if digest functionality is on
        if (isOn) {
            digest.update(b, off, len);
        }
        // write len bytes
        out.write(b, off, len);
    }

    /**
     * Enables or disables the digest function (default is on).
     *
     * @param on
     *            {@code true} if the digest should be computed, {@code false}
     *            otherwise.
     * @see MessageDigest
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.497 -0400", hash_original_method = "3D6ED86CB32057B75140F25F5AFE5484", hash_generated_method = "AC2B6074B8350E280C8D594B75EA9D8C")
    
public void on(boolean on) {
        isOn = on;
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * {@code DigestOutputStream} including the digest.
     *
     * @return a printable representation for this {@code DigestOutputStream}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.498 -0400", hash_original_method = "4B13C7C889B2A909FFC668347DF457C3", hash_generated_method = "B8E996CE2552E95167EBDB1291062299")
    
@Override
    public String toString() {
        return super.toString() + ", " + digest.toString() +
            (isOn ? ", is on" : ", is off");
    }
}

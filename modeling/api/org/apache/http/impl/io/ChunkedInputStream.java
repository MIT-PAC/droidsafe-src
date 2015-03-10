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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/impl/io/ChunkedInputStream.java $
 * $Revision: 569843 $
 * $Date: 2007-08-26 10:05:40 -0700 (Sun, 26 Aug 2007) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.ExceptionUtils;

public class ChunkedInputStream extends InputStream {
    
    /**
     * Exhaust an input stream, reading until EOF has been encountered.
     *
     * <p>Note that this function is intended as a non-public utility.
     * This is a little weird, but it seemed silly to make a utility
     * class for this one function, so instead it is just static and
     * shared that way.</p>
     *
     * @param inStream The {@link InputStream} to exhaust.
     * @throws IOException If an IO problem occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.211 -0500", hash_original_method = "D70623C6F3F3546E610A0761808ACD51", hash_generated_method = "7153314C2BD4370663FC9A00A6B9E867")
    
static void exhaustInputStream(final InputStream inStream) throws IOException {
        // read and discard the remainder of the message
        byte buffer[] = new byte[1024];
        while (inStream.read(buffer) >= 0) {
            ;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.169 -0500", hash_original_field = "70993BC56EC5FB33DD67D98C82018650", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private SessionInputBuffer in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.172 -0500", hash_original_field = "350F4DBD74AB8DD54F1F983317E69056", hash_generated_field = "2D6B54E04F26AA35A63824F1627650C8")

    private  CharArrayBuffer buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.175 -0500", hash_original_field = "8D4654446C9DD3E766BE07B4267F3234", hash_generated_field = "47235E9A35474F8DBDD6D8DBB4AB5B6A")

    private int chunkSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.177 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.179 -0500", hash_original_field = "F33F0652333827FC54B09EF681817D98", hash_generated_field = "C7D7F0DB76F14B1CC635F97425C47305")

    private boolean bof = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.181 -0500", hash_original_field = "35FBA36BFF4EF032B0A0118B3A595ECD", hash_generated_field = "9D21D7F75CFE95F29DC47C0C3AFEC881")

    private boolean eof = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.183 -0500", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.185 -0500", hash_original_field = "18F5AA99B5063C2655DD04975F7C54A5", hash_generated_field = "A74851231E6F66E8990234BC00C8E61F")
    
    private Header[] footers = new Header[] {};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.188 -0500", hash_original_method = "A74B5C02541010DFF9C03CAF0620A33C", hash_generated_method = "84DB1223B64EFCF6F03092871343DCFB")
    
public ChunkedInputStream(final SessionInputBuffer in) {
        super();
        if (in == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        }
        this.in = in;
        this.pos = 0;
        this.buffer = new CharArrayBuffer(16);
    }

    /**
     * <p> Returns all the data in a chunked stream in coalesced form. A chunk
     * is followed by a CRLF. The method returns -1 as soon as a chunksize of 0
     * is detected.</p>
     * 
     * <p> Trailer headers are read automcatically at the end of the stream and
     * can be obtained with the getResponseFooters() method.</p>
     *
     * @return -1 of the end of the stream has been reached or the next data
     * byte
     * @throws IOException If an IO problem occurs
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.192 -0500", hash_original_method = "5987C40EBD16187447E09174CE17A1D5", hash_generated_method = "11C8E65F36ECC436105906060B9725E9")
    
public int read() throws IOException {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        }
        if (this.eof) {
            return -1;
        } 
        if (this.pos >= this.chunkSize) {
            nextChunk();
            if (this.eof) { 
                return -1;
            }
        }
        pos++;
        return in.read();
    }

    /**
     * Read some bytes from the stream.
     * @param b The byte array that will hold the contents from the stream.
     * @param off The offset into the byte array at which bytes will start to be
     * placed.
     * @param len the maximum number of bytes that can be returned.
     * @return The number of bytes returned or -1 if the end of stream has been
     * reached.
     * @see java.io.InputStream#read(byte[], int, int)
     * @throws IOException if an IO problem occurs.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.194 -0500", hash_original_method = "3658228930DC027E604760F33BD6E163", hash_generated_method = "6E895E4791EAA7C54ED5D455FB855F58")
    
public int read (byte[] b, int off, int len) throws IOException {

        if (closed) {
            throw new IOException("Attempted read from closed stream.");
        }

        if (eof) { 
            return -1;
        }
        if (pos >= chunkSize) {
            nextChunk();
            if (eof) { 
                return -1;
            }
        }
        len = Math.min(len, chunkSize - pos);
        int count = in.read(b, off, len);
        pos += count;
        return count;
    }

    /**
     * Read some bytes from the stream.
     * @param b The byte array that will hold the contents from the stream.
     * @return The number of bytes returned or -1 if the end of stream has been
     * reached.
     * @see java.io.InputStream#read(byte[])
     * @throws IOException if an IO problem occurs.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.196 -0500", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "E0F9C5B343EA0376178403393DBFABB2")
    
public int read (byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    /**
     * Read the next chunk.
     * @throws IOException If an IO error occurs.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.199 -0500", hash_original_method = "4EC8EF70B227B064D40EEFDD2252C457", hash_generated_method = "83ABCC4598E21E5B401D267A4724D136")
    
private void nextChunk() throws IOException {
        chunkSize = getChunkSize();
        if (chunkSize < 0) {
            throw new MalformedChunkCodingException("Negative chunk size");
        }
        bof = false;
        pos = 0;
        if (chunkSize == 0) {
            eof = true;
            parseTrailerHeaders();
        }
    }

    /**
     * Expects the stream to start with a chunksize in hex with optional
     * comments after a semicolon. The line must end with a CRLF: "a3; some
     * comment\r\n" Positions the stream at the start of the next line.
     *
     * @param in The new input stream.
     * @param required <tt>true<tt/> if a valid chunk must be present,
     *                 <tt>false<tt/> otherwise.
     * 
     * @return the chunk size as integer
     * 
     * @throws IOException when the chunk size could not be parsed
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.201 -0500", hash_original_method = "992D2E5FFE364796E637C7610DCE798B", hash_generated_method = "984043FD4603F59C9F4EE0A228878B4F")
    
private int getChunkSize() throws IOException {
        // skip CRLF
        if (!bof) {
            int cr = in.read();
            int lf = in.read();
            if ((cr != HTTP.CR) || (lf != HTTP.LF)) { 
                throw new MalformedChunkCodingException(
                    "CRLF expected at end of chunk");
            }
        }
        //parse data
        this.buffer.clear();
        int i = this.in.readLine(this.buffer);
        if (i == -1) {
            throw new MalformedChunkCodingException(
                    "Chunked stream ended unexpectedly");
        }
        int separator = this.buffer.indexOf(';');
        if (separator < 0) {
            separator = this.buffer.length();
        }
        try {
            return Integer.parseInt(this.buffer.substringTrimmed(0, separator), 16);
        } catch (NumberFormatException e) {
            throw new MalformedChunkCodingException("Bad chunk header");
        }
    }

    /**
     * Reads and stores the Trailer headers.
     * @throws IOException If an IO problem occurs
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.204 -0500", hash_original_method = "B639A385C0DFC1E0B0F3B3045E38F98A", hash_generated_method = "1850CB8BED76D50CE56B0CC208CCB3C6")
    
private void parseTrailerHeaders() throws IOException {
        try {
            this.footers = AbstractMessageParser.parseHeaders
                (in, -1, -1, null);
        } catch (HttpException e) {
            IOException ioe = new MalformedChunkCodingException("Invalid footer: " 
                    + e.getMessage());
            ExceptionUtils.initCause(ioe, e); 
            throw ioe;
        }
    }

    /**
     * Upon close, this reads the remainder of the chunked message,
     * leaving the underlying socket at a position to start reading the
     * next response without scanning.
     * @throws IOException If an IO problem occurs.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.206 -0500", hash_original_method = "7C0EA5C3612B6B07D60F3A7E9A05393C", hash_generated_method = "A0CD67C0024A67AF6FE62D0CDBFBCB76")
    
public void close() throws IOException {
        if (!closed) {
            try {
                if (!eof) {
                    exhaustInputStream(this);
                }
            } finally {
                eof = true;
                closed = true;
            }
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.208 -0500", hash_original_method = "7163A37F445D9A153E08F6B88D28A6E4", hash_generated_method = "06FFEACFF7B2DF64E7931EEAD93BB078")
    
public Header[] getFooters() {
        return (Header[])this.footers.clone();
    }
    
}


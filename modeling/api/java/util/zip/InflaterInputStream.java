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
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import libcore.io.Streams;

public class InflaterInputStream extends FilterInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.025 -0500", hash_original_field = "86AF9D144AB13FC6B685B7332D58DC58", hash_generated_field = "A60956B00A99CF9DF92AF09280C120E9")

    static final int BUF_SIZE = 512;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.013 -0500", hash_original_field = "91462E289D2F6E91C1C1F707980A1ADD", hash_generated_field = "1E4B81450D564B8A8EB02BC28E6E6C0F")

    protected Inflater inf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.016 -0500", hash_original_field = "001DD3820C6A6A544AB42831C6F17A05", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.018 -0500", hash_original_field = "EF721EE4D9006031C7456130341457B7", hash_generated_field = "5D5995101D8A63DD862FB3CCC8ECEF3F")

    protected int len;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.020 -0500", hash_original_field = "0B6D06FC66AB1A3316E7702989E3F923", hash_generated_field = "0B6D06FC66AB1A3316E7702989E3F923")

    boolean closed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.023 -0500", hash_original_field = "F63D5C2A3218247517725999753A7A52", hash_generated_field = "F63D5C2A3218247517725999753A7A52")

    boolean eof;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.027 -0500", hash_original_field = "7E70FEE52575958CC96A2F34CB55F620", hash_generated_field = "7E70FEE52575958CC96A2F34CB55F620")

    int nativeEndBufSize = 0;

    /**
     * This is the most basic constructor. You only need to pass the {@code
     * InputStream} from which the compressed data is to be read from. Default
     * settings for the {@code Inflater} and internal buffer are be used. In
     * particular the Inflater expects a ZLIB header from the input stream.
     *
     * @param is
     *            the {@code InputStream} to read data from.
     */
    @DSComment("zip/io")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.030 -0500", hash_original_method = "E5B01AC162409617460AC7C3F79F7BB2", hash_generated_method = "8799600FD8890367D6AA1EAF5709AAD6")
    
public InflaterInputStream(InputStream is) {
        this(is, new Inflater(), BUF_SIZE);
    }

    /**
     * This constructor lets you pass a specifically initialized Inflater,
     * for example one that expects no ZLIB header.
     *
     * @param is
     *            the {@code InputStream} to read data from.
     * @param inflater
     *            the specific {@code Inflater} for decompressing data.
     */
    @DSComment("zip/io")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.033 -0500", hash_original_method = "FFCF6E0CDA6D7391850CE9D2857BF932", hash_generated_method = "AF318CFBAC8C7A87DD8058BBAD45CBFC")
    
public InflaterInputStream(InputStream is, Inflater inflater) {
        this(is, inflater, BUF_SIZE);
    }

    /**
     * This constructor lets you specify both the {@code Inflater} as well as
     * the internal buffer size to be used.
     *
     * @param is
     *            the {@code InputStream} to read data from.
     * @param inflater
     *            the specific {@code Inflater} for decompressing data.
     * @param bsize
     *            the size to be used for the internal buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.037 -0500", hash_original_method = "C80CB7FC71CBD6181B9FF475CD694AFF", hash_generated_method = "63C21F10C8CCE2213F311E3DE5EEABF0")
    
public InflaterInputStream(InputStream is, Inflater inflater, int bsize) {
        super(is);
        if (is == null || inflater == null) {
            throw new NullPointerException();
        }
        if (bsize <= 0) {
            throw new IllegalArgumentException();
        }
        this.inf = inflater;
        if (is instanceof ZipFile.RAFStream) {
            nativeEndBufSize = bsize;
        } else {
            buf = new byte[bsize];
        }
    }

    /**
     * Reads a single byte of decompressed data.
     *
     * @return the byte read.
     * @throws IOException
     *             if an error occurs reading the byte.
     */
    @DSSource({DSSourceKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.040 -0500", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "259E44B8B64C1FF49A2A2EC42CFB5CBE")
    
@Override public int read() throws IOException {
        //return Streams.readSingleByte(this);
        return droidsafeRead();
    }

    /**
     * Reads up to {@code byteCount} bytes of decompressed data and stores it in
     * {@code buffer} starting at {@code offset}.
     *
     * @return Number of uncompressed bytes read
     */
    @DSSource({DSSourceKind.FILE})
    @DSComment("zip/io")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.043 -0500", hash_original_method = "DE515D2D289FDA03BF01DDF0E0AD6AE1", hash_generated_method = "24C747E38DD44413DDF0B87FFC31A7EB")
    
@Override
    public int read(byte[] buffer, int offset, int byteCount) throws IOException {
        checkClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);

        if (byteCount == 0) {
            return 0;
        }

        if (eof) {
            return -1;
        }

        do {
            if (inf.needsInput()) {
                fill();
            }
            // Invariant: if reading returns -1 or throws, eof must be true.
            // It may also be true if the next read() should return -1.
            try {
                int result = inf.inflate(buffer, offset, byteCount);
                eof = inf.finished();
                if (result > 0) {
                    return result;
                } else if (eof) {
                    return -1;
                } else if (inf.needsDictionary()) {
                    eof = true;
                    return -1;
                } else if (len == -1) {
                    eof = true;
                    throw new EOFException();
                    // If result == 0, fill() and try again
                }
            } catch (DataFormatException e) {
                eof = true;
                if (len == -1) {
                    throw new EOFException();
                }
                throw (IOException) (new IOException().initCause(e));
            }
        } while (true);
    }

    /**
     * Fills the input buffer with data to be decompressed.
     *
     * @throws IOException
     *             if an {@code IOException} occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.045 -0500", hash_original_method = "92AAFAE1121490A2E461EB88A6DC741C", hash_generated_method = "7F5D5393B4EA764BDC990A4E8D36D27D")
    
protected void fill() throws IOException {
        checkClosed();
        if (nativeEndBufSize > 0) {
            ZipFile.RAFStream is = (ZipFile.RAFStream)in;
            synchronized (is.mSharedRaf) {
                long len = is.mLength - is.mOffset;
                if (len > nativeEndBufSize) len = nativeEndBufSize;
                int cnt = inf.setFileInput(is.mSharedRaf.getFD(), is.mOffset, nativeEndBufSize);
                is.skip(cnt);
            }
        } else {
            if ((len = in.read(buf)) > 0) {
                inf.setInput(buf, 0, len);
            }
        }
    }

    /**
     * Skips up to {@code byteCount} bytes of uncompressed data.
     *
     * @param byteCount the number of bytes to skip.
     * @return the number of uncompressed bytes skipped.
     * @throws IllegalArgumentException if {@code byteCount < 0}.
     * @throws IOException if an error occurs skipping.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.048 -0500", hash_original_method = "A9123C6756DDC4D0ED42EE705B1E650B", hash_generated_method = "888FD6837E4B31EE74C24517F9D5E38D")
    
@Override
    public long skip(long byteCount) throws IOException {
        if (byteCount < 0) {
            throw new IllegalArgumentException("byteCount < 0");
        }
        return Streams.skipByReading(this, byteCount);
    }

    /**
     * Returns 0 when when this stream has exhausted its input; and 1 otherwise.
     * A result of 1 does not guarantee that further bytes can be returned,
     * with or without blocking.
     *
     * <p>Although consistent with the RI, this behavior is inconsistent with
     * {@link InputStream#available()}, and violates the <a
     * href="http://en.wikipedia.org/wiki/Liskov_substitution_principle">Liskov
     * Substitution Principle</a>. This method should not be used.
     *
     * @return 0 if no further bytes are available. Otherwise returns 1,
     *         which suggests (but does not guarantee) that additional bytes are
     *         available.
     * @throws IOException if this stream is closed or an error occurs
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.051 -0500", hash_original_method = "CA27A6E1F269DA8120632D3AC729E489", hash_generated_method = "D14CB242DC391688E70046D9149DD6F3")
    
@Override
    public int available() throws IOException {
        checkClosed();
        if (eof) {
            return 0;
        }
        return 1;
    }

    /**
     * Closes the input stream.
     *
     * @throws IOException
     *             If an error occurs closing the input stream.
     */
    @DSComment("No action/impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.053 -0500", hash_original_method = "EA60532C802B6FAE0DE9014BA74F497F", hash_generated_method = "4D5EC13FAA0FD03AE14A617945F59CAE")
    
@Override
    public void close() throws IOException {
        if (!closed) {
            inf.end();
            closed = true;
            eof = true;
            super.close();
        }
    }

    /**
     * Marks the current position in the stream. This implementation overrides
     * the super type implementation to do nothing at all.
     *
     * @param readlimit
     *            of no use.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.056 -0500", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "B192DF6DAE9C0FAF199088F4F2FAAE45")
    
@Override
    public void mark(int readlimit) {
        // do nothing
    }

    /**
     * Reset the position of the stream to the last marked position. This
     * implementation overrides the supertype implementation and always throws
     * an {@link IOException IOException} when called.
     *
     * @throws IOException
     *             if the method is called
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.059 -0500", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "982040414CDBED77657D44B5E5A8ACAA")
    
@Override
    public void reset() throws IOException {
        throw new IOException();
    }

    /**
     * Returns whether the receiver implements {@code mark} semantics. This type
     * does not support {@code mark()}, so always responds {@code false}.
     *
     * @return false, always
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.061 -0500", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "98834879561C7504F012DD22F86DCE30")
    
@Override
    public boolean markSupported() {
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.064 -0500", hash_original_method = "249965AABC06DCB5B5F50760C9E2C49A", hash_generated_method = "B2C7CAFBEA57F8C308959ADD87C03C39")
    
private void checkClosed() throws IOException {
        if (closed) {
            throw new IOException("Stream is closed");
        }
    }
}


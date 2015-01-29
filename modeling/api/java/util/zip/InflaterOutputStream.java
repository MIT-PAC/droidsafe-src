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
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * An {@code OutputStream} filter to decompress data. Callers write
 * compressed data in the "deflate" format, and uncompressed data is
 * written to the underlying stream.
 * @since 1.6
 */
public class InflaterOutputStream extends FilterOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.257 -0400", hash_original_field = "83879FC61CA6B5F6B78284980EC3B627", hash_generated_field = "2888F3AB0EE3CA8F80F09281C7B29EDA")

    private static final int DEFAULT_BUFFER_SIZE = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.257 -0400", hash_original_field = "91462E289D2F6E91C1C1F707980A1ADD", hash_generated_field = "1E4B81450D564B8A8EB02BC28E6E6C0F")

    protected  Inflater inf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.257 -0400", hash_original_field = "001DD3820C6A6A544AB42831C6F17A05", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected  byte[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.258 -0400", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;

    /**
     * Constructs an {@code InflaterOutputStream} with a new {@code Inflater} and an
     * implementation-defined default internal buffer size. {@code out} is a destination
     * for uncompressed data, and compressed data will be written to this stream.
     *
     * @param out the destination {@code OutputStream}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.258 -0400", hash_original_method = "DAA926FD7E9E3F070B33F9FB3ACFE2B6", hash_generated_method = "AFE42792076A97FD90A4D6E24E1415DE")
    
public InflaterOutputStream(OutputStream out) {
        this(out, new Inflater());
    }

    /**
     * Constructs an {@code InflaterOutputStream} with the given {@code Inflater} and an
     * implementation-defined default internal buffer size. {@code out} is a destination
     * for uncompressed data, and compressed data will be written to this stream.
     *
     * @param out the destination {@code OutputStream}
     * @param inf the {@code Inflater} to be used for decompression
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.258 -0400", hash_original_method = "217E6C0934CE6E5EDC5AF42B7A0BE1AF", hash_generated_method = "66A7D11FD8ED5DB50A435BFFEA37E586")
    
public InflaterOutputStream(OutputStream out, Inflater inf) {
        this(out, inf, DEFAULT_BUFFER_SIZE);
    }

    /**
     * Constructs an {@code InflaterOutputStream} with the given {@code Inflater} and
     * given internal buffer size. {@code out} is a destination
     * for uncompressed data, and compressed data will be written to this stream.
     *
     * @param out the destination {@code OutputStream}
     * @param inf the {@code Inflater} to be used for decompression
     * @param bufferSize the length in bytes of the internal buffer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.259 -0400", hash_original_method = "6E836A838198860AEF2650BA899B9F8B", hash_generated_method = "010FCCDC1E80FBF058D5ABD9807B5EE0")
    
public InflaterOutputStream(OutputStream out, Inflater inf, int bufferSize) {
        super(out);
        if (out == null) {
            throw new NullPointerException("out == null");
        } else if (inf == null) {
            throw new NullPointerException("inf == null");
        }
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("bufferSize <= 0: " + bufferSize);
        }
        this.inf = inf;
        this.buf = new byte[bufferSize];
    }

    /**
     * Writes remaining data into the output stream and closes the underlying
     * output stream.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.260 -0400", hash_original_method = "C7E69C7E232B119CCA1DF33F2834B53C", hash_generated_method = "DCA3E77BCB2EE59B79BA8CD42C5F63B8")
    
@Override
    public void close() throws IOException {
        if (!closed) {
            finish();
            inf.end();
            out.close();
            closed = true;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.260 -0400", hash_original_method = "A01F9A7571A64991C67A6E67AB0C4D1D", hash_generated_method = "FF990421DDA3ED9EE23E72D38BE7841F")
    
@Override
    public void flush() throws IOException {
        finish();
        out.flush();
    }

    /**
     * Finishes writing current uncompressed data into the InflaterOutputStream
     * without closing it.
     *
     * @throws IOException if an I/O error occurs, or the stream has been closed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.261 -0400", hash_original_method = "204BA9C6E53FA914ED5C736802A5AC49", hash_generated_method = "EE04553184A22B85B15058D0DDC57EAF")
    
public void finish() throws IOException {
        checkClosed();
        write();
    }

    /**
     * Writes a byte to the decompressing output stream. {@code b} should be a byte of
     * compressed input. The corresponding uncompressed data will be written to the underlying
     * stream.
     *
     * @param b the byte
     * @throws IOException if an I/O error occurs, or the stream has been closed
     * @throws ZipException if a zip exception occurs.
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.261 -0400", hash_original_method = "02F43A8986C37DB67EC951D0B7203DBE", hash_generated_method = "D371D23855741083C6D7CC2B6737E6F1")
    
@Override
    public void write(int b) throws IOException, ZipException {
        write(new byte[] { (byte) b }, 0, 1);
    }

    /**
     * Writes to the decompressing output stream. The {@code bytes} array should contain
     * compressed input. The corresponding uncompressed data will be written to the underlying
     * stream.
     *
     * @throws IOException if an I/O error occurs, or the stream has been closed
     * @throws ZipException if a zip exception occurs.
     * @throws NullPointerException if {@code b == null}.
     * @throws IndexOutOfBoundsException if {@code off < 0 || len < 0 || off + len > b.length}
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.262 -0400", hash_original_method = "0CE43216A5278CC11C8B1E01A32D0746", hash_generated_method = "49DF10605D64A4FCDEB963F6DD99CE4C")
    
@Override
    public void write(byte[] bytes, int offset, int byteCount) throws IOException, ZipException {
        checkClosed();
        Arrays.checkOffsetAndCount(bytes.length, offset, byteCount);
        inf.setInput(bytes, offset, byteCount);
        write();
    }

    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.262 -0400", hash_original_method = "6D1E70DC7726D5752814BADEF47EB41F", hash_generated_method = "8989445EAFA24375DEE7968E3FAC2C2A")
    
private void write() throws IOException, ZipException {
        try {
            int inflated;
            while ((inflated = inf.inflate(buf)) > 0) {
                out.write(buf, 0, inflated);
            }
        } catch (DataFormatException e) {
            throw new ZipException();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.262 -0400", hash_original_method = "209ABA46214E1B9BCCD5E31E7F27CC57", hash_generated_method = "487585AC730C40A837AA74041246589A")
    
private void checkClosed() throws IOException {
        if (closed) {
            throw new IOException();
        }
    }
}

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
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import libcore.io.Streams;

/**
 * An {@code InputStream} filter to compress data. Callers read
 * compressed data in the "deflate" format from the uncompressed
 * underlying stream.
 * @since 1.6
 */
public class DeflaterInputStream extends FilterInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.500 -0400", hash_original_field = "83879FC61CA6B5F6B78284980EC3B627", hash_generated_field = "2888F3AB0EE3CA8F80F09281C7B29EDA")

    private static final int DEFAULT_BUFFER_SIZE = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.500 -0400", hash_original_field = "1BB4DFAD44B3741493C144A3265C33E5", hash_generated_field = "BB50A00575DEBF8BAC8ED22DB8D1D289")


    protected  Deflater def;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.501 -0400", hash_original_field = "001DD3820C6A6A544AB42831C6F17A05", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected  byte[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.501 -0400", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")


    private boolean closed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.502 -0400", hash_original_field = "B05F79CE37372FE8A0F84265ED8F86DB", hash_generated_field = "4202BD86292CB1C0097A265D15F2CE06")

    private boolean available = true;

    /**
     * Constructs a {@code DeflaterInputStream} with a new {@code Deflater} and an
     * implementation-defined default internal buffer size. {@code in} is a source of
     * uncompressed data, and this stream will be a source of compressed data.
     *
     * @param in the source {@code InputStream}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.502 -0400", hash_original_method = "5E95B6A8BB1573269E71F79FC75EFCD8", hash_generated_method = "1FAF22B3AB2A07FD7ADFEFD6CE31A2FF")
    
public DeflaterInputStream(InputStream in) {
        this(in, new Deflater(), DEFAULT_BUFFER_SIZE);
    }

    /**
     * Constructs a {@code DeflaterInputStream} with the given {@code Deflater} and an
     * implementation-defined default internal buffer size. {@code in} is a source of
     * uncompressed data, and this stream will be a source of compressed data.
     *
     * @param in the source {@code InputStream}
     * @param deflater the {@code Deflater} to be used for compression
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.502 -0400", hash_original_method = "75D21F7475E4B58D5172D80918CF1195", hash_generated_method = "C4BFCAF8566CCE0B322FBE88069BCD15")
    
public DeflaterInputStream(InputStream in, Deflater deflater) {
        this(in, deflater, DEFAULT_BUFFER_SIZE);
    }

    /**
     * Constructs a {@code DeflaterInputStream} with the given {@code Deflater} and
     * given internal buffer size. {@code in} is a source of
     * uncompressed data, and this stream will be a source of compressed data.
     *
     * @param in the source {@code InputStream}
     * @param deflater the {@code Deflater} to be used for compression
     * @param bufferSize the length in bytes of the internal buffer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.503 -0400", hash_original_method = "3E5BF64DAD9FD971DCAE98C85230FA66", hash_generated_method = "B8FC532074E378CA448FA59E043094FB")
    
public DeflaterInputStream(InputStream in, Deflater deflater, int bufferSize) {
        super(in);
        if (in == null) {
            throw new NullPointerException("in == null");
        } else if (deflater == null) {
            throw new NullPointerException("deflater == null");
        }
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("bufferSize <= 0: " + bufferSize);
        }
        this.def = deflater;
        this.buf = new byte[bufferSize];
    }

    /**
     * Closes the underlying input stream and discards any remaining uncompressed
     * data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.503 -0400", hash_original_method = "C359156F5B1EAAF19EFF7CED9FA6C214", hash_generated_method = "C2264BE40DBB5954D615FAFA5D21BBB2")
    
@Override
    public void close() throws IOException {
        closed = true;
        def.end();
        in.close();
    }

    /**
     * Reads a byte from the compressed input stream. The result will be a byte of compressed
     * data corresponding to an uncompressed byte or bytes read from the underlying stream.
     *
     * @return the byte or -1 if the end of the stream has been reached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.504 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "259E44B8B64C1FF49A2A2EC42CFB5CBE")
    
@Override public int read() throws IOException {
        return Streams.readSingleByte(this);
    }

    /**
     * Reads up to {@code byteCount} bytes of compressed data into a byte buffer. The result will be bytes of compressed
     * data corresponding to an uncompressed byte or bytes read from the underlying stream.
     * Returns the number of bytes read or -1 if the end of the compressed input
     * stream has been reached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.505 -0400", hash_original_method = "19164904BE928B554AFCB99D8B5A601C", hash_generated_method = "E474E12617424C40301F243E30D64A97")
    
@Override public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        checkClosed();
        Arrays.checkOffsetAndCount(buffer.length, byteOffset, byteCount);
        if (byteCount == 0) {
            return 0;
        }

        if (!available) {
            return -1;
        }

        int count = 0;
        while (count < byteCount && !def.finished()) {
            if (def.needsInput()) {
                // read data from input stream
                int bytesRead = in.read(buf);
                if (bytesRead == -1) {
                    def.finish();
                } else {
                    def.setInput(buf, 0, bytesRead);
                }
            }
            int bytesDeflated = def.deflate(buf, 0, Math.min(buf.length, byteCount - count));
            if (bytesDeflated == -1) {
                break;
            }
            System.arraycopy(buf, 0, buffer, byteOffset + count, bytesDeflated);
            count += bytesDeflated;
        }
        if (count == 0) {
            count = -1;
            available = false;
        }
        return count;
    }

    /**
     * {@inheritDoc}
     * <p>Note: if {@code n > Integer.MAX_VALUE}, this stream will only attempt to
     * skip {@code Integer.MAX_VALUE} bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.505 -0400", hash_original_method = "565E152BEC5BFE2BBB7113B2C9AAD9E9", hash_generated_method = "E15FFEE4D819AAC0CCD9363A53B6EFE3")
    
@Override
    public long skip(long byteCount) throws IOException {
        byteCount = Math.min(Integer.MAX_VALUE, byteCount);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.506 -0400", hash_original_method = "012D19A90EC960D9A12BF7D37FCA19A5", hash_generated_method = "AF147BCE6F473C746D086F9C7603E587")
    
@Override
    public int available() throws IOException {
        checkClosed();
        return available ? 1 : 0;
    }

    /**
     * Returns false because {@code DeflaterInputStream} does not support
     * {@code mark}/{@code reset}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.506 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "98834879561C7504F012DD22F86DCE30")
    
@Override
    public boolean markSupported() {
        return false;
    }

    /**
     * This operation is not supported and does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.506 -0400", hash_original_method = "24F28C58F333FD0DCB61CF11D4AE344F", hash_generated_method = "A59C0843EF9A250368BB5C040FD4AFDA")
    
@Override
    public void mark(int limit) {
    }

    /**
     * This operation is not supported and throws {@code IOException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.507 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "982040414CDBED77657D44B5E5A8ACAA")
    
@Override
    public void reset() throws IOException {
        throw new IOException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.507 -0400", hash_original_method = "249965AABC06DCB5B5F50760C9E2C49A", hash_generated_method = "B2C7CAFBEA57F8C308959ADD87C03C39")
    
private void checkClosed() throws IOException {
        if (closed) {
            throw new IOException("Stream is closed");
        }
    }
}

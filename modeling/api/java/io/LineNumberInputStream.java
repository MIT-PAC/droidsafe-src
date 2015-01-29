/*
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

package java.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Arrays;
import libcore.io.Streams;

/**
 * Wraps an existing {@link InputStream} and counts the line terminators
 * encountered while reading the data. Line numbering starts at 0. Recognized
 * line terminator sequences are {@code '\r'}, {@code '\n'} and {@code "\r\n"}.
 * When using {@code read}, line terminator sequences are always translated into
 * {@code '\n'}.
 *
 * @deprecated Use {@link LineNumberReader}
 */
@Deprecated
public class LineNumberInputStream extends FilterInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.515 -0400", hash_original_field = "330B2760AA91CE77EFBAED3976D7655C", hash_generated_field = "09A4698FFE38FA7794A20A1F94A6867E")

    private int lineNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.516 -0400", hash_original_field = "DBC81950E23E00CD1D8CBF4B88EAECD0", hash_generated_field = "1C916C4658DC40807EB1430C1DBE7CA4")

    private int markedLineNumber = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.517 -0400", hash_original_field = "98C08A237D42C5FB2A83529B1F1E52FB", hash_generated_field = "EA630226E6A8C14200174F39623A2DEA")

    private int lastChar = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.519 -0400", hash_original_field = "945E005DF69CCD63B42D5AD932BD72EB", hash_generated_field = "2213796FBCE93855E6DF953D61640FFB")

    private int markedLastChar;

    /**
     * Constructs a new {@code LineNumberInputStream} on the {@link InputStream}
     * {@code in}. Line numbers are counted for all data read from this stream.
     *
     * <p><strong>Warning:</strong> passing a null source creates an invalid
     * {@code LineNumberInputStream}. All operations on such a stream will fail.
     *
     * @param in
     *            The non-null input stream to count line numbers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.528 -0400", hash_original_method = "3CCF230F1828E86683A20C2C61FF99EF", hash_generated_method = "1AA366E4F776F21FDE9537720CC31C63")
    
public LineNumberInputStream(InputStream in) {
        super(in);
    }

    /**
     * {@inheritDoc}
     *
     * <p>Note that the source stream may just be a sequence of {@code "\r\n"} bytes
     * which are converted into {@code '\n'} by this stream. Therefore,
     * {@code available} returns only {@code in.available() / 2} bytes as
     * result.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.529 -0400", hash_original_method = "9656C3365F203F315A3500AFB9043F07", hash_generated_method = "78F62E915B13C69CC156406F51AC0917")
    
@Override
    public int available() throws IOException {
        return in.available() / 2 + (lastChar == -1 ? 0 : 1);
    }

    /**
     * Returns the current line number for this stream. Numbering starts at 0.
     *
     * @return the current line number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.530 -0400", hash_original_method = "0B737233CC5342C14C595BEE1A87604B", hash_generated_method = "CF4B4A3CBEDDB2EC6C0EA97DADAE4C2D")
    
public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets a mark position in this stream. The parameter {@code readlimit}
     * indicates how many bytes can be read before the mark is invalidated.
     * Sending {@code reset()} will reposition this stream back to the marked
     * position, provided that {@code readlimit} has not been surpassed.
     * The line number count will also be reset to the last marked
     * line number count.
     * <p>
     * This implementation sets a mark in the filtered stream.
     *
     * @param readlimit
     *            the number of bytes that can be read from this stream before
     *            the mark is invalidated.
     * @see #markSupported()
     * @see #reset()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.532 -0400", hash_original_method = "B96EC2539DB250F8E95A33A3A09EEE3D", hash_generated_method = "ED1FC67D8A0D05DC55B055F239975CD4")
    
@Override
    public void mark(int readlimit) {
        in.mark(readlimit);
        markedLineNumber = lineNumber;
        markedLastChar = lastChar;
    }

    /**
     * Reads a single byte from the filtered stream and returns it as an integer
     * in the range from 0 to 255. Returns -1 if the end of this stream has been
     * reached.
     * <p>
     * The line number count is incremented if a line terminator is encountered.
     * Recognized line terminator sequences are {@code '\r'}, {@code '\n'} and
     * {@code "\r\n"}. Line terminator sequences are always translated into
     * {@code '\n'}.
     *
     * @return the byte read or -1 if the end of the filtered stream has been
     *         reached.
     * @throws IOException
     *             if the stream is closed or another IOException occurs.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.533 -0400", hash_original_method = "881233CAFAEB30A182B61CB7440FD1DB", hash_generated_method = "547A2033ADE3CA3ACDC544D8D1CA6901")
    
@SuppressWarnings("fallthrough")
    @Override
    public int read() throws IOException {
        int currentChar = lastChar;
        if (currentChar == -1) {
            currentChar = in.read();
        } else {
            lastChar = -1;
        }
        switch (currentChar) {
            case '\r':
                currentChar = '\n';
                lastChar = in.read();
                if (lastChar == '\n') {
                    lastChar = -1;
                }
                // fall through
            case '\n':
                lineNumber++;
        }
        return currentChar;
    }

    /**
     * Reads at most {@code length} bytes from the filtered stream and stores
     * them in the byte array {@code buffer} starting at {@code offset}.
     * Returns the number of bytes actually read or -1 if no bytes have been
     * read and the end of this stream has been reached.
     * <p>
     * The line number count is incremented if a line terminator is encountered.
     * Recognized line terminator sequences are {@code '\r'}, {@code '\n'} and
     * {@code "\r\n"}. Line terminator sequences are always translated into
     * {@code '\n'}.
     *
     * @param buffer
     *            the array in which to store the bytes read.
     * @param offset
     *            the initial position in {@code buffer} to store the bytes read
     *            from this stream.
     * @param length
     *            the maximum number of bytes to store in {@code buffer}.
     * @return the number of bytes actually read or -1 if the end of the
     *         filtered stream has been reached while reading.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code length < 0}, or if
     *             {@code offset + length} is greater than the length of
     *             {@code buffer}.
     * @throws IOException
     *             if this stream is closed or another IOException occurs.
     * @throws NullPointerException
     *             if {@code buffer} is {@code null}.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.535 -0400", hash_original_method = "7B3082DF4DFF3271DA5B12250C3600A9", hash_generated_method = "0988799D89BDC4690F48B77D24CC5611")
    
@Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        for (int i = 0; i < length; i++) {
            int currentChar;
            try {
                currentChar = read();
            } catch (IOException e) {
                if (i != 0) {
                    return i;
                }
                throw e;
            }
            if (currentChar == -1) {
                return i == 0 ? -1 : i;
            }
            buffer[offset + i] = (byte) currentChar;
        }
        return length;
    }

    /**
     * Resets this stream to the last marked location. It also resets the line
     * count to what is was when this stream was marked.
     *
     * @throws IOException
     *             if this stream is already closed, no mark has been set or the
     *             mark is no longer valid because more than {@code readlimit}
     *             bytes have been read since setting the mark.
     * @see #mark(int)
     * @see #markSupported()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.536 -0400", hash_original_method = "5CFC5B6B1EB8619DEC60F6B82F3081E9", hash_generated_method = "170A64221F00215B2CD270A529F3E477")
    
@Override
    public void reset() throws IOException {
        in.reset();
        lineNumber = markedLineNumber;
        lastChar = markedLastChar;
    }

    /**
     * Sets the line number of this stream to the specified
     * {@code lineNumber}. Note that this may have side effects on the
     * line number associated with the last marked position.
     *
     * @param lineNumber
     *            the new lineNumber value.
     * @see #mark(int)
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.537 -0400", hash_original_method = "57105994EF91DD2584057988497ACBF5", hash_generated_method = "6017253C51FF36A7937C0B03247B0C2E")
    
public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * Skips {@code count} number of bytes in this stream. Subsequent
     * calls to {@code read} will not return these bytes unless {@code reset} is
     * used. This implementation skips {@code byteCount} bytes in the
     * filtered stream and increments the line number count whenever line
     * terminator sequences are skipped.
     *
     * @param byteCount
     *            the number of bytes to skip.
     * @return the number of bytes actually skipped.
     * @throws IOException
     *             if this stream is closed or another IOException occurs.
     * @see #mark(int)
     * @see #read()
     * @see #reset()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.539 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "FA64348A96D1C68BD0600E70DFA81D7E")
    
@Override
    public long skip(long byteCount) throws IOException {
        return Streams.skipByReading(this, byteCount);
    }
}

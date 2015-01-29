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

/**
 * Wraps an existing {@link Reader} and counts the line terminators encountered
 * while reading the data. The line number starts at 0 and is incremented any
 * time {@code '\r'}, {@code '\n'} or {@code "\r\n"} is read. The class has an
 * internal buffer for its data. The size of the buffer defaults to 8 KB.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class LineNumberReader extends BufferedReader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.580 -0400", hash_original_field = "330B2760AA91CE77EFBAED3976D7655C", hash_generated_field = "09A4698FFE38FA7794A20A1F94A6867E")

    private int lineNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.582 -0400", hash_original_field = "DBC81950E23E00CD1D8CBF4B88EAECD0", hash_generated_field = "1C916C4658DC40807EB1430C1DBE7CA4")

    private int markedLineNumber = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.583 -0400", hash_original_field = "E2E2FBCCD5790249C12592969A1D3B9E", hash_generated_field = "A7E171056A69CD25A43C14AA77C5FAE0")

    private boolean lastWasCR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.584 -0400", hash_original_field = "02CADD283B743740142DBF0425B094F7", hash_generated_field = "3D8255297E22E58585C9CAFB47895B72")

    private boolean markedLastWasCR;

    /**
     * Constructs a new LineNumberReader on the Reader {@code in}. The internal
     * buffer gets the default size (8 KB).
     *
     * @param in
     *            the Reader that is buffered.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.586 -0400", hash_original_method = "45BD344F3487CD36BAE63DE575807BB6", hash_generated_method = "E4389B143F44C156108020EE33582036")
    
public LineNumberReader(Reader in) {
        super(in);
    }

    /**
     * Constructs a new LineNumberReader on the Reader {@code in}. The size of
     * the internal buffer is specified by the parameter {@code size}.
     *
     * @param in
     *            the Reader that is buffered.
     * @param size
     *            the size of the buffer to allocate.
     * @throws IllegalArgumentException
     *             if {@code size <= 0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.587 -0400", hash_original_method = "E7D8F245B6B241AF92FD292023F7061D", hash_generated_method = "80C9ABF0C3008324CCEBFC18E8D775A0")
    
public LineNumberReader(Reader in, int size) {
        super(in, size);
    }

    /**
     * Returns the current line number for this reader. Numbering starts at 0.
     *
     * @return the current line number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.588 -0400", hash_original_method = "37F4F12C9492DE0958C990CB67C14D9D", hash_generated_method = "4E1A355C17A3B3808505353D0CBC4609")
    
public int getLineNumber() {
        synchronized (lock) {
            return lineNumber;
        }
    }

    /**
     * Sets a mark position in this reader. The parameter {@code readlimit}
     * indicates how many characters can be read before the mark is invalidated.
     * Sending {@code reset()} will reposition this reader back to the marked
     * position, provided that {@code readlimit} has not been surpassed. The
     * line number associated with this marked position is also stored so that
     * it can be restored when {@code reset()} is called.
     *
     * @param readlimit
     *            the number of characters that can be read from this stream
     *            before the mark is invalidated.
     * @throws IOException
     *             if an error occurs while setting the mark in this reader.
     * @see #markSupported()
     * @see #reset()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.590 -0400", hash_original_method = "61DB0949DFDA870236B101B4DC594793", hash_generated_method = "747DB9CF27F3672AB4C703CB24C594DD")
    
@Override
    public void mark(int readlimit) throws IOException {
        synchronized (lock) {
            super.mark(readlimit);
            markedLineNumber = lineNumber;
            markedLastWasCR = lastWasCR;
        }
    }

    /**
     * Reads a single character from the source reader and returns it as an
     * integer with the two higher-order bytes set to 0. Returns -1 if the end
     * of the source reader has been reached.
     * <p>
     * The line number count is incremented if a line terminator is encountered.
     * Recognized line terminator sequences are {@code '\r'}, {@code '\n'} and
     * {@code "\r\n"}. Line terminator sequences are always translated into
     * {@code '\n'}.
     *
     * @return the character read or -1 if the end of the source reader has been
     *         reached.
     * @throws IOException
     *             if the reader is closed or another IOException occurs.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.592 -0400", hash_original_method = "BF2DC28E0D85E461273B7FDD43155D52", hash_generated_method = "5933B2440A3A8CD1E077EF37546F71ED")
    
@SuppressWarnings("fallthrough")
    @Override
    public int read() throws IOException {
        synchronized (lock) {
            int ch = super.read();
            if (ch == '\n' && lastWasCR) {
                ch = super.read();
            }
            lastWasCR = false;
            switch (ch) {
                case '\r':
                    ch = '\n';
                    lastWasCR = true;
                    // fall through
                case '\n':
                    lineNumber++;
            }
            return ch;
        }
    }

    /**
     * Reads at most {@code count} characters from the source reader and stores
     * them in the character array {@code buffer} starting at {@code offset}.
     * Returns the number of characters actually read or -1 if no characters
     * have been read and the end of this reader has been reached.
     * <p>
     * The line number count is incremented if a line terminator is encountered.
     * Recognized line terminator sequences are {@code '\r'}, {@code '\n'} and
     * {@code "\r\n"}.
     *
     * @param buffer
     *            the array in which to store the characters read.
     * @param offset
     *            the initial position in {@code buffer} to store the characters
     *            read from this reader.
     * @param count
     *            the maximum number of characters to store in {@code buffer}.
     * @return the number of characters actually read or -1 if the end of the
     *         source reader has been reached while reading.
     * @throws IOException
     *             if this reader is closed or another IOException occurs.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.594 -0400", hash_original_method = "FDA77893270A91A814AF5E2C6C2EF118", hash_generated_method = "F844C6E8242F0AF2714CCB69C3E4E85E")
    
@Override
    public int read(char[] buffer, int offset, int count) throws IOException {
        synchronized (lock) {
            int read = super.read(buffer, offset, count);
            if (read == -1) {
                return -1;
            }
            for (int i = 0; i < read; i++) {
                char ch = buffer[offset + i];
                if (ch == '\r') {
                    lineNumber++;
                    lastWasCR = true;
                } else if (ch == '\n') {
                    if (!lastWasCR) {
                        lineNumber++;
                    }
                    lastWasCR = false;
                } else {
                    lastWasCR = false;
                }
            }
            return read;
        }
    }

    /**
     * Returns the next line of text available from this reader. A line is
     * represented by 0 or more characters followed by {@code '\r'},
     * {@code '\n'}, {@code "\r\n"} or the end of the stream. The returned
     * string does not include the newline sequence.
     *
     * @return the contents of the line or {@code null} if no characters have
     *         been read before the end of the stream has been reached.
     * @throws IOException
     *             if this reader is closed or another IOException occurs.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.595 -0400", hash_original_method = "723DEA0966AE094423D220BA4AE4E984", hash_generated_method = "A19854D59D4890C4663C2300BC245912")
    
@Override
    public String readLine() throws IOException {
        synchronized (lock) {
            if (lastWasCR) {
                chompNewline();
                lastWasCR = false;
            }
            String result = super.readLine();
            if (result != null) {
                lineNumber++;
            }
            return result;
        }
    }

    /**
     * Resets this reader to the last marked location. It also resets the line
     * count to what is was when this reader was marked. This implementation
     * resets the source reader.
     *
     * @throws IOException
     *             if this reader is already closed, no mark has been set or the
     *             mark is no longer valid because more than {@code readlimit}
     *             bytes have been read since setting the mark.
     * @see #mark(int)
     * @see #markSupported()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.597 -0400", hash_original_method = "B59F3780435E1D82A9BC71252DB81041", hash_generated_method = "A33E77749A78F60ECA6DC727ABB6C535")
    
@Override
    public void reset() throws IOException {
        synchronized (lock) {
            super.reset();
            lineNumber = markedLineNumber;
            lastWasCR = markedLastWasCR;
        }
    }

    /**
     * Sets the line number of this reader to the specified {@code lineNumber}.
     * Note that this may have side effects on the line number associated with
     * the last marked position.
     *
     * @param lineNumber
     *            the new line number value.
     * @see #mark(int)
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.598 -0400", hash_original_method = "808009BC0C2D2E0490E1C8660EF8DAAC", hash_generated_method = "3F9C77DE501E36383209D422CA67FC00")
    
public void setLineNumber(int lineNumber) {
        synchronized (lock) {
            this.lineNumber = lineNumber;
        }
    }

    /**
     * Skips {@code charCount} characters in this reader. Subsequent calls to
     * {@code read} will not return these characters unless {@code reset}
     * is used. This implementation skips {@code charCount} number of characters in
     * the source reader and increments the line number count whenever line
     * terminator sequences are skipped.
     *
     * @return the number of characters actually skipped.
     * @throws IllegalArgumentException
     *             if {@code charCount < 0}.
     * @throws IOException
     *             if this reader is closed or another IOException occurs.
     * @see #mark(int)
     * @see #read()
     * @see #reset()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.599 -0400", hash_original_method = "7DBB09E24CB2DDA5770D4340DA752505", hash_generated_method = "3BABF2C1E59DC946E4F20C0118F48094")
    
@Override
    public long skip(long charCount) throws IOException {
        if (charCount < 0) {
            throw new IllegalArgumentException("charCount < 0: " + charCount);
        }
        synchronized (lock) {
            for (int i = 0; i < charCount; i++) {
                if (read() == -1) {
                    return i;
                }
            }
            return charCount;
        }
    }
}

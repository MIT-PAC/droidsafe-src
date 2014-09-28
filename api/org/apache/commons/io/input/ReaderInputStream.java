/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.io.input;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/**
 * {@link InputStream} implementation that reads a character stream from a {@link Reader}
 * and transforms it to a byte stream using a specified charset encoding. The stream
 * is transformed using a {@link CharsetEncoder} object, guaranteeing that all charset
 * encodings supported by the JRE are handled correctly. In particular for charsets such as
 * UTF-16, the implementation ensures that one and only one byte order marker
 * is produced.
 * <p>
 * Since in general it is not possible to predict the number of characters to be read from the
 * {@link Reader} to satisfy a read request on the {@link ReaderInputStream}, all reads from
 * the {@link Reader} are buffered. There is therefore no well defined correlation
 * between the current position of the {@link Reader} and that of the {@link ReaderInputStream}.
 * This also implies that in general there is no need to wrap the underlying {@link Reader}
 * in a {@link java.io.BufferedReader}.
 * <p>
 * {@link ReaderInputStream} implements the inverse transformation of {@link java.io.InputStreamReader};
 * in the following example, reading from <tt>in2</tt> would return the same byte
 * sequence as reading from <tt>in</tt> (provided that the initial byte sequence is legal
 * with respect to the charset encoding):
 * <pre>
 * InputStream in = ...
 * Charset cs = ...
 * InputStreamReader reader = new InputStreamReader(in, cs);
 * ReaderInputStream in2 = new ReaderInputStream(reader, cs);</pre>
 * {@link ReaderInputStream} implements the same transformation as {@link java.io.OutputStreamWriter},
 * except that the control flow is reversed: both classes transform a character stream
 * into a byte stream, but {@link java.io.OutputStreamWriter} pushes data to the underlying stream,
 * while {@link ReaderInputStream} pulls it from the underlying stream.
 * <p>
 * Note that while there are use cases where there is no alternative to using
 * this class, very often the need to use this class is an indication of a flaw
 * in the design of the code. This class is typically used in situations where an existing
 * API only accepts an {@link InputStream}, but where the most natural way to produce the data
 * is as a character stream, i.e. by providing a {@link Reader} instance. An example of a situation
 * where this problem may appear is when implementing the {@link javax.activation.DataSource}
 * interface from the Java Activation Framework.
 * <p>
 * Given the fact that the {@link Reader} class doesn't provide any way to predict whether the next
 * read operation will block or not, it is not possible to provide a meaningful
 * implementation of the {@link InputStream#available()} method. A call to this method
 * will always return 0. Also, this class doesn't support {@link InputStream#mark(int)}.
 * <p>
 * Instances of {@link ReaderInputStream} are not thread safe.
 * 
 * @see org.apache.commons.io.output.WriterOutputStream
 * 
 * @since 2.0
 */
public class ReaderInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.632 -0400", hash_original_field = "83879FC61CA6B5F6B78284980EC3B627", hash_generated_field = "2888F3AB0EE3CA8F80F09281C7B29EDA")

    private static final int DEFAULT_BUFFER_SIZE = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.632 -0400", hash_original_field = "359C2477A0D4C46A46237360E9D6E3E1", hash_generated_field = "506A19594AC0AF91386404965612888E")

    private  Reader reader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.633 -0400", hash_original_field = "35DE68BB49761C7459EF0234F6EAB1B7", hash_generated_field = "A07B3C678B690A0A298B0184B628874A")

    private  CharsetEncoder encoder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.634 -0400", hash_original_field = "03EA9FB465CE677625E1ED61C602D319", hash_generated_field = "B60F0BBBB9014F06D5B95B719C3C190B")

    private  CharBuffer encoderIn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.634 -0400", hash_original_field = "8A725CA8BAEECE211982A61811A265EF", hash_generated_field = "72413451FD4C93ACB89B8EE051BE2E39")

    private  ByteBuffer encoderOut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.634 -0400", hash_original_field = "C03510FFC4FD1485E1CD8D9E9EBAAFB0", hash_generated_field = "027A16390EC7AF19AFCD69BC85AAE931")

    private CoderResult lastCoderResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.635 -0400", hash_original_field = "14C5302C44DEF4A7613BA0A6E0BAD709", hash_generated_field = "759737216E42E53DB8195D44DC15B09C")

    private boolean endOfInput;

    /**
     * Construct a new {@link ReaderInputStream}.
     * 
     * @param reader the target {@link Reader}
     * @param encoder the charset encoder
     * @since 2.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.635 -0400", hash_original_method = "DC774D82E80C58D521C1DE3E75EA3234", hash_generated_method = "994CFE6A7780B5681BCF21335380B100")
    
public ReaderInputStream(Reader reader, CharsetEncoder encoder) {
        this(reader, encoder, DEFAULT_BUFFER_SIZE);
    }

    /**
     * Construct a new {@link ReaderInputStream}.
     * 
     * @param reader the target {@link Reader}
     * @param encoder the charset encoder
     * @param bufferSize the size of the input buffer in number of characters
     * @since 2.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.636 -0400", hash_original_method = "A6AF0B0DEDD8FD34E7B252A21E73275C", hash_generated_method = "F2DA74E19C0C40DB5AD2428146CD7AC7")
    
public ReaderInputStream(Reader reader, CharsetEncoder encoder, int bufferSize) {
        this.reader = reader;
        this.encoder = encoder;
        this.encoderIn = CharBuffer.allocate(bufferSize);
        this.encoderIn.flip();
        this.encoderOut = ByteBuffer.allocate(128);
        this.encoderOut.flip();
    }

    /**
     * Construct a new {@link ReaderInputStream}.
     * 
     * @param reader the target {@link Reader}
     * @param charset the charset encoding
     * @param bufferSize the size of the input buffer in number of characters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.637 -0400", hash_original_method = "098FEFB55144E5D136CA5E0996327A4A", hash_generated_method = "A7FA0630527D642F0DA3635F62E4C251")
    
public ReaderInputStream(Reader reader, Charset charset, int bufferSize) {
        this(reader,
             charset.newEncoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE),
             bufferSize);
    }

    /**
     * Construct a new {@link ReaderInputStream} with a default input buffer size of
     * 1024 characters.
     * 
     * @param reader the target {@link Reader}
     * @param charset the charset encoding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.637 -0400", hash_original_method = "69E1F502F9939E0034482B73D6F14557", hash_generated_method = "76D653196BD3456AB5C0C91306957DD0")
    
public ReaderInputStream(Reader reader, Charset charset) {
        this(reader, charset, DEFAULT_BUFFER_SIZE);
    }

    /**
     * Construct a new {@link ReaderInputStream}.
     * 
     * @param reader the target {@link Reader}
     * @param charsetName the name of the charset encoding
     * @param bufferSize the size of the input buffer in number of characters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.638 -0400", hash_original_method = "62449A8A28906ABC0866BF33E5F4E4BA", hash_generated_method = "84B8A9A6A0DA906F4B4D93794A297444")
    
public ReaderInputStream(Reader reader, String charsetName, int bufferSize) {
        this(reader, Charset.forName(charsetName), bufferSize);
    }

    /**
     * Construct a new {@link ReaderInputStream} with a default input buffer size of
     * 1024 characters.
     * 
     * @param reader the target {@link Reader}
     * @param charsetName the name of the charset encoding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.638 -0400", hash_original_method = "98B240FEEBDE4993FBD19F610BA6219B", hash_generated_method = "C42171EF31E1465C7A3ADB9FB449FFE4")
    
public ReaderInputStream(Reader reader, String charsetName) {
        this(reader, charsetName, DEFAULT_BUFFER_SIZE);
    }

    /**
     * Construct a new {@link ReaderInputStream} that uses the default character encoding
     * with a default input buffer size of 1024 characters.
     * 
     * @param reader the target {@link Reader}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.639 -0400", hash_original_method = "CD00642F55B4FEC77508F18FE9833050", hash_generated_method = "805730FAD27307D159C366B2150427F0")
    
public ReaderInputStream(Reader reader) {
        this(reader, Charset.defaultCharset());
    }

    /**
     * Fills the internal char buffer from the reader.
     * 
     * @throws IOException
     *             If an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.640 -0400", hash_original_method = "A6D59C67E1B0FB9D0521062EBAAF3984", hash_generated_method = "787898DA8410423B0B59DD22830B0F3F")
    
private void fillBuffer() throws IOException {
        if (!endOfInput && (lastCoderResult == null || lastCoderResult.isUnderflow())) {
            encoderIn.compact();
            int position = encoderIn.position();
            // We don't use Reader#read(CharBuffer) here because it is more efficient
            // to write directly to the underlying char array (the default implementation
            // copies data to a temporary char array).
            int c = reader.read(encoderIn.array(), position, encoderIn.remaining());
            if (c == -1) {
                endOfInput = true;
            } else {
                encoderIn.position(position+c);
            }
            encoderIn.flip();
        }
        encoderOut.compact();
        lastCoderResult = encoder.encode(encoderIn, encoderOut, endOfInput);
        encoderOut.flip();
    }
    
    /**
     * Read the specified number of bytes into an array.
     * 
     * @param b the byte array to read into
     * @param off the offset to start reading bytes into
     * @param len the number of bytes to read
     * @return the number of bytes read or <code>-1</code>
     *         if the end of the stream has been reached
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.641 -0400", hash_original_method = "9AA2BEF9DA8AFF8D251BF2FC6F763561", hash_generated_method = "298EFBAA7A51F11C69F08AF0C7F43929")
    
@Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array must not be null");
        }
        if (len < 0 || off < 0 || (off + len) > b.length) {
            throw new IndexOutOfBoundsException("Array Size=" + b.length +
                    ", offset=" + off + ", length=" + len);
        }
        int read = 0;
        if (len == 0) {
            return 0; // Always return 0 if len == 0
        }
        while (len > 0) {
            if (encoderOut.hasRemaining()) {
                int c = Math.min(encoderOut.remaining(), len);
                encoderOut.get(b, off, c);
                off += c;
                len -= c;
                read += c;
            } else {
                fillBuffer();
                if (endOfInput && !encoderOut.hasRemaining()) {
                    break;
                }
            }
        }
        return read == 0 && endOfInput ? -1 : read;
    }

    /**
     * Read the specified number of bytes into an array.
     * 
     * @param b the byte array to read into
     * @return the number of bytes read or <code>-1</code>
     *         if the end of the stream has been reached
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.641 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "CFD5B18414297C5D63F6DE9EDDF7232C")
    
@Override
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    /**
     * Read a single byte.
     *
     * @return either the byte read or <code>-1</code> if the end of the stream
     *         has been reached
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.642 -0400", hash_original_method = "DE40F403B4AA3B3194A9FBF22582153E", hash_generated_method = "797BA1D0D041A26281B5AB9F4D6EDF41")
    
@Override
    public int read() throws IOException {
        for (;;) {
            if (encoderOut.hasRemaining()) {
                return encoderOut.get() & 0xFF;
            } else {
                fillBuffer();
                if (endOfInput && !encoderOut.hasRemaining()) {
                    return -1;
                }
            }
        }
    }

    /**
     * Close the stream. This method will cause the underlying {@link Reader}
     * to be closed.
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.642 -0400", hash_original_method = "A1FFC9B80BA56A6C1B0EFB45497D16D1", hash_generated_method = "41BF0F39484A92E2DE0C5158288ACAC3")
    
@Override
    public void close() throws IOException {
        reader.close();
    }
}

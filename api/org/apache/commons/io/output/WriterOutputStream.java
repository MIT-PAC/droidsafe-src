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
package org.apache.commons.io.output;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/**
 * {@link OutputStream} implementation that transforms a byte stream to a
 * character stream using a specified charset encoding and writes the resulting
 * stream to a {@link Writer}. The stream is transformed using a
 * {@link CharsetDecoder} object, guaranteeing that all charset
 * encodings supported by the JRE are handled correctly.
 * <p>
 * The output of the {@link CharsetDecoder} is buffered using a fixed size buffer.
 * This implies that the data is written to the underlying {@link Writer} in chunks
 * that are no larger than the size of this buffer. By default, the buffer is
 * flushed only when it overflows or when {@link #flush()} or {@link #close()}
 * is called. In general there is therefore no need to wrap the underlying {@link Writer}
 * in a {@link java.io.BufferedWriter}. {@link WriterOutputStream} can also
 * be instructed to flush the buffer after each write operation. In this case, all
 * available data is written immediately to the underlying {@link Writer}, implying that
 * the current position of the {@link Writer} is correlated to the current position
 * of the {@link WriterOutputStream}.
 * <p>
 * {@link WriterOutputStream} implements the inverse transformation of {@link java.io.OutputStreamWriter};
 * in the following example, writing to <tt>out2</tt> would have the same result as writing to
 * <tt>out</tt> directly (provided that the byte sequence is legal with respect to the
 * charset encoding):
 * <pre>
 * OutputStream out = ...
 * Charset cs = ...
 * OutputStreamWriter writer = new OutputStreamWriter(out, cs);
 * WriterOutputStream out2 = new WriterOutputStream(writer, cs);</pre>
 * {@link WriterOutputStream} implements the same transformation as {@link java.io.InputStreamReader},
 * except that the control flow is reversed: both classes transform a byte stream
 * into a character stream, but {@link java.io.InputStreamReader} pulls data from the underlying stream,
 * while {@link WriterOutputStream} pushes it to the underlying stream.
 * <p>
 * Note that while there are use cases where there is no alternative to using
 * this class, very often the need to use this class is an indication of a flaw
 * in the design of the code. This class is typically used in situations where an existing
 * API only accepts an {@link OutputStream} object, but where the stream is known to represent
 * character data that must be decoded for further use.
 * <p>
 * Instances of {@link WriterOutputStream} are not thread safe.
 * 
 * @see org.apache.commons.io.input.ReaderInputStream
 * 
 * @since 2.0
 */
public class WriterOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.847 -0400", hash_original_field = "83879FC61CA6B5F6B78284980EC3B627", hash_generated_field = "2888F3AB0EE3CA8F80F09281C7B29EDA")

    private static final int DEFAULT_BUFFER_SIZE = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.847 -0400", hash_original_field = "2893095D821727F8868345026D6906A1", hash_generated_field = "DB075F4140D7FA00980C54A40F997F59")


    private  Writer writer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.848 -0400", hash_original_field = "EB8B81788E764E7EC09C99438B975CD8", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private  CharsetDecoder decoder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.848 -0400", hash_original_field = "2A4ACBAA8943B7B60831A9971757B0E8", hash_generated_field = "CD0A8A60A3B382C20C5A148FCE76F0A8")

    private  boolean writeImmediately;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.849 -0400", hash_original_field = "EA0A31499CF00CF51DB2966A741EA811", hash_generated_field = "A9F316D4B0184188DCFEE946C32A3D7B")

    private final ByteBuffer decoderIn = ByteBuffer.allocate(128);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.849 -0400", hash_original_field = "165B12072FEC8376CAEEFD2D3D9FE8E6", hash_generated_field = "455BF49B21823C664D42B2AC67A38E34")

    private  CharBuffer decoderOut;

    /**
     * Constructs a new {@link WriterOutputStream} with a default output buffer size of
     * 1024 characters. The output buffer will only be flushed when it overflows or when
     * {@link #flush()} or {@link #close()} is called.
     * 
     * @param writer the target {@link Writer}
     * @param decoder the charset decoder
     * @since 2.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.850 -0400", hash_original_method = "4A2ECD3C7335CA4F94CBBF612E64A3A4", hash_generated_method = "885310E6C2AFA7038FFC0FD2BD2F39C7")
    
public WriterOutputStream(Writer writer, CharsetDecoder decoder) {
        this(writer, decoder, DEFAULT_BUFFER_SIZE, false);
    }

    /**
     * Constructs a new {@link WriterOutputStream}.
     * 
     * @param writer the target {@link Writer}
     * @param decoder the charset decoder
     * @param bufferSize the size of the output buffer in number of characters
     * @param writeImmediately If <tt>true</tt> the output buffer will be flushed after each
     *                         write operation, i.e. all available data will be written to the
     *                         underlying {@link Writer} immediately. If <tt>false</tt>, the
     *                         output buffer will only be flushed when it overflows or when
     *                         {@link #flush()} or {@link #close()} is called.
     * @since 2.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.850 -0400", hash_original_method = "3EDB33815F621AFED5D37E18A3A21495", hash_generated_method = "A9FE28135B22F9D7FAE4068274B21F28")
    
public WriterOutputStream(Writer writer, CharsetDecoder decoder, int bufferSize, boolean writeImmediately) {
        this.writer = writer;
        this.decoder = decoder;
        this.writeImmediately = writeImmediately;
        decoderOut = CharBuffer.allocate(bufferSize);
    }

    /**
     * Constructs a new {@link WriterOutputStream}.
     * 
     * @param writer the target {@link Writer}
     * @param charset the charset encoding
     * @param bufferSize the size of the output buffer in number of characters
     * @param writeImmediately If <tt>true</tt> the output buffer will be flushed after each
     *                         write operation, i.e. all available data will be written to the
     *                         underlying {@link Writer} immediately. If <tt>false</tt>, the
     *                         output buffer will only be flushed when it overflows or when
     *                         {@link #flush()} or {@link #close()} is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.851 -0400", hash_original_method = "B867148FBA5E55CD84C23E5CFFC25359", hash_generated_method = "715E3B2E5ABD8D3FB25DF1D2771A4AB7")
    
public WriterOutputStream(Writer writer, Charset charset, int bufferSize, boolean writeImmediately) {
        this(writer,
             charset.newDecoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE)
                    .replaceWith("?"),
             bufferSize,
             writeImmediately);
    }

    /**
     * Constructs a new {@link WriterOutputStream} with a default output buffer size of
     * 1024 characters. The output buffer will only be flushed when it overflows or when
     * {@link #flush()} or {@link #close()} is called.
     * 
     * @param writer the target {@link Writer}
     * @param charset the charset encoding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.852 -0400", hash_original_method = "F5E8CFB6E56AC508C368EDA9E41EBCA5", hash_generated_method = "8CFA8349066206A6EC7B1A719907F287")
    
public WriterOutputStream(Writer writer, Charset charset) {
        this(writer, charset, DEFAULT_BUFFER_SIZE, false);
    }

    /**
     * Constructs a new {@link WriterOutputStream}.
     * 
     * @param writer the target {@link Writer}
     * @param charsetName the name of the charset encoding
     * @param bufferSize the size of the output buffer in number of characters
     * @param writeImmediately If <tt>true</tt> the output buffer will be flushed after each
     *                         write operation, i.e. all available data will be written to the
     *                         underlying {@link Writer} immediately. If <tt>false</tt>, the
     *                         output buffer will only be flushed when it overflows or when
     *                         {@link #flush()} or {@link #close()} is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.852 -0400", hash_original_method = "EFA34CAB468BE610E644DAB0715A71E2", hash_generated_method = "46ECEC930BD2D915DD0422909809BC6B")
    
public WriterOutputStream(Writer writer, String charsetName, int bufferSize, boolean writeImmediately) {
        this(writer, Charset.forName(charsetName), bufferSize, writeImmediately);
    }

    /**
     * Constructs a new {@link WriterOutputStream} with a default output buffer size of
     * 1024 characters. The output buffer will only be flushed when it overflows or when
     * {@link #flush()} or {@link #close()} is called.
     * 
     * @param writer the target {@link Writer}
     * @param charsetName the name of the charset encoding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.853 -0400", hash_original_method = "F26B5DFECB697DCFF94DB93FC05ACF8E", hash_generated_method = "16A47017CC83D354A27A5872508CA210")
    
public WriterOutputStream(Writer writer, String charsetName) {
        this(writer, charsetName, DEFAULT_BUFFER_SIZE, false);
    }

    /**
     * Constructs a new {@link WriterOutputStream} that uses the default character encoding
     * and with a default output buffer size of 1024 characters. The output buffer will only
     * be flushed when it overflows or when {@link #flush()} or {@link #close()} is called.
     * 
     * @param writer the target {@link Writer}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.853 -0400", hash_original_method = "C117D3B09C26E87BDD8081C71BA84253", hash_generated_method = "C18A5E26179748D5AB5E0EF0CC26F642")
    
public WriterOutputStream(Writer writer) {
        this(writer, Charset.defaultCharset(), DEFAULT_BUFFER_SIZE, false);
    }

    /**
     * Write bytes from the specified byte array to the stream.
     * 
     * @param b the byte array containing the bytes to write
     * @param off the start offset in the byte array
     * @param len the number of bytes to write
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.854 -0400", hash_original_method = "C0D49EB08A267ED3491A74132BB97C44", hash_generated_method = "90A500B68C5B9D736374CBF484F83215")
    
@Override
    public void write(byte[] b, int off, int len) throws IOException {
        while (len > 0) {
            int c = Math.min(len, decoderIn.remaining());
            decoderIn.put(b, off, c);
            processInput(false);
            len -= c;
            off += c;
        }
        if (writeImmediately) {
            flushOutput();
        }
    }

    /**
     * Write bytes from the specified byte array to the stream.
     * 
     * @param b the byte array containing the bytes to write
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.855 -0400", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "7D09861B37E141F39BE351A56688C45A")
    
@Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    /**
     * Write a single byte to the stream.
     * 
     * @param b the byte to write
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.855 -0400", hash_original_method = "72E9EA9CB4D496A22134A9DE55B8B91A", hash_generated_method = "C5CFE166C9FCDBCC793D313229493905")
    
@Override
    public void write(int b) throws IOException {
        write(new byte[] { (byte)b }, 0, 1);
    }

    /**
     * Flush the stream. Any remaining content accumulated in the output buffer
     * will be written to the underlying {@link Writer}. After that
     * {@link Writer#flush()} will be called. 
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.856 -0400", hash_original_method = "AC63B2DA15A83F7213D18D8342590F5B", hash_generated_method = "9E3755C851694214765A39D1531FAFBD")
    
@Override
    public void flush() throws IOException {
        flushOutput();
        writer.flush();
    }

    /**
     * Close the stream. Any remaining content accumulated in the output buffer
     * will be written to the underlying {@link Writer}. After that
     * {@link Writer#close()} will be called. 
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.856 -0400", hash_original_method = "420EB211773CB08496419ABA1A7EC597", hash_generated_method = "EC293B6F2FC98C106C0D6026E701A5BE")
    
@Override
    public void close() throws IOException {
        processInput(true);
        flushOutput();
        writer.close();
    }

    /**
     * Decode the contents of the input ByteBuffer into a CharBuffer.
     * 
     * @param endOfInput indicates end of input
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.857 -0400", hash_original_method = "8DBE36D3CC23C0C9E5FAAD9804EB9F8E", hash_generated_method = "B8E268DF01A1D59287B8F2ED5303EAE7")
    
private void processInput(boolean endOfInput) throws IOException {
        // Prepare decoderIn for reading
        decoderIn.flip();
        CoderResult coderResult;
        while (true) {
            coderResult = decoder.decode(decoderIn, decoderOut, endOfInput);
            if (coderResult.isOverflow()) {
                flushOutput();
            } else if (coderResult.isUnderflow()) {
                break;
            } else {
                // The decoder is configured to replace malformed input and unmappable characters,
                // so we should not get here.
                throw new IOException("Unexpected coder result");
            }
        }
        // Discard the bytes that have been read
        decoderIn.compact();
    }

    /**
     * Flush the output.
     * 
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.858 -0400", hash_original_method = "CB0233CD34D87630D222478FE14929AD", hash_generated_method = "6EACB49EAA8492043C350AAB1B1F2EDE")
    
private void flushOutput() throws IOException {
        if (decoderOut.position() > 0) {
            writer.write(decoderOut.array(), 0, decoderOut.position());
            decoderOut.rewind();
        }
    }
}

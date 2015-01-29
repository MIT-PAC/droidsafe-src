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

package org.apache.commons.codec.binary;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Provides Base64 encoding and decoding in a streaming fashion (unlimited size). When encoding the default lineLength
 * is 76 characters and the default lineEnding is CRLF, but these can be overridden by using the appropriate
 * constructor.
 * <p>
 * The default behaviour of the Base64OutputStream is to ENCODE, whereas the default behaviour of the Base64InputStream
 * is to DECODE. But this behaviour can be overridden by using a different constructor.
 * </p>
 * <p>
 * This class implements section <cite>6.8. Base64 Content-Transfer-Encoding</cite> from RFC 2045 <cite>Multipurpose
 * Internet Mail Extensions (MIME) Part One: Format of Internet Message Bodies</cite> by Freed and Borenstein.
 * </p>
 * <p>
 * Since this class operates directly on byte streams, and not character streams, it is hard-coded to only encode/decode
 * character encodings which are compatible with the lower 127 ASCII chart (ISO-8859-1, Windows-1252, UTF-8, etc).
 * </p>
 * 
 * @author Apache Software Foundation
 * @version $Id: Base64OutputStream.java 799806 2009-08-01 04:33:17Z ggregory $
 * @see <a href="http://www.ietf.org/rfc/rfc2045.txt">RFC 2045</a>
 * @since 1.4
 */
public class Base64OutputStream extends FilterOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 16:09:10.028 -0500", hash_original_field = "E72EF02D0C2DDFF4BA821DB2B3D8E361", hash_generated_field = "84E7C226D49AED72233210CA671D90FD")

    private  boolean doEncode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 16:09:10.039 -0500", hash_original_field = "7FD8C736AE32FE8DF05681358D1096BD", hash_generated_field = "1766A614F9FE1DA8D7613293052FF924")

    private  Base64 base64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 16:09:10.048 -0500", hash_original_field = "C563C497DF1B0B36C3B298AC6308EB3F", hash_generated_field = "9BD39ECEAC31FB507C39A41CCA51990D")

    private final byte[] singleByte = new byte[1];

    /**
     * Creates a Base64OutputStream such that all data written is Base64-encoded to the original provided OutputStream.
     * 
     * @param out
     *            OutputStream to wrap.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 16:09:10.059 -0500", hash_original_method = "D429979643A042485DCB33B3CB11511A", hash_generated_method = "1CBADFC2814802505AC6D93CE89ED5E5")
    
public Base64OutputStream(OutputStream out) {
        this(out, true);
    }

    /**
     * Creates a Base64OutputStream such that all data written is either Base64-encoded or Base64-decoded to the
     * original provided OutputStream.
     * 
     * @param out
     *            OutputStream to wrap.
     * @param doEncode
     *            true if we should encode all data written to us, false if we should decode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 16:09:10.069 -0500", hash_original_method = "A004EFF3212CF1F0BEAA16DF9FAC4D54", hash_generated_method = "082F675AE8270BFAB92FA59495250ADF")
    
public Base64OutputStream(OutputStream out, boolean doEncode) {
        super(out);
        this.doEncode = doEncode;
        this.base64 = new Base64();
    }

    /**
     * Creates a Base64OutputStream such that all data written is either Base64-encoded or Base64-decoded to the
     * original provided OutputStream.
     * 
     * @param out
     *            OutputStream to wrap.
     * @param doEncode
     *            true if we should encode all data written to us, false if we should decode.
     * @param lineLength
     *            If doEncode is true, each line of encoded data will contain lineLength characters (rounded down to
     *            nearest multiple of 4). If lineLength <=0, the encoded data is not divided into lines. If doEncode is
     *            false, lineLength is ignored.
     * @param lineSeparator
     *            If doEncode is true, each line of encoded data will be terminated with this byte sequence (e.g. \r\n).
     *            If lineLength <= 0, the lineSeparator is not used. If doEncode is false lineSeparator is ignored.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 16:09:10.080 -0500", hash_original_method = "4A23FA304401B8212AFFCC6CDE5C960E", hash_generated_method = "0B989C678E10304D5CEDB8C17EA77594")
    
public Base64OutputStream(OutputStream out, boolean doEncode, int lineLength, byte[] lineSeparator) {
        super(out);
        this.doEncode = doEncode;
        this.base64 = new Base64(lineLength, lineSeparator);
    }

    /**
     * Writes the specified <code>byte</code> to this output stream.
     * 
     * @param i
     *            source byte
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 16:09:10.102 -0500", hash_original_method = "D38D28D8C40C92DB1F9D6C2E1B0DC8AA", hash_generated_method = "69B7B62672AB1D4CC5087EE6A83EB249")
    
public void write(int i) throws IOException {
        singleByte[0] = (byte) i;
        write(singleByte, 0, 1);
    }

    /**
     * Writes <code>len</code> bytes from the specified <code>b</code> array starting at <code>offset</code> to this
     * output stream.
     * 
     * @param b
     *            source byte array
     * @param offset
     *            where to start reading the bytes
     * @param len
     *            maximum number of bytes to write
     * 
     * @throws IOException
     *             if an I/O error occurs.
     * @throws NullPointerException
     *             if the byte array parameter is null
     * @throws IndexOutOfBoundsException
     *             if offset, len or buffer size are invalid
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 16:09:10.117 -0500", hash_original_method = "71297ADEDFB051E21A298196DEA9F7A9", hash_generated_method = "512C8436B08E5E9450DA46964D8395B7")
    
public void write(byte b[], int offset, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (offset < 0 || len < 0) {
            throw new IndexOutOfBoundsException();
        } else if (offset > b.length || offset + len > b.length) {
            throw new IndexOutOfBoundsException();
        } else if (len > 0) {
            if (doEncode) {
                base64.encode(b, offset, len);
            } else {
                base64.decode(b, offset, len);
            }
            flush(false);
        }
    }

    /**
     * Flushes this output stream and forces any buffered output bytes to be written out to the stream. If propogate is
     * true, the wrapped stream will also be flushed.
     * 
     * @param propogate
     *            boolean flag to indicate whether the wrapped OutputStream should also be flushed.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 16:09:10.130 -0500", hash_original_method = "9CF355A1080B1C5188ACDD31B59B3C7A", hash_generated_method = "DF56149423846E6235D8003E1808F06E")
    
private void flush(boolean propogate) throws IOException {
        int avail = base64.avail();
        if (avail > 0) {
            byte[] buf = new byte[avail];
            int c = base64.readResults(buf, 0, avail);
            if (c > 0) {
                out.write(buf, 0, c);
            }
        }
        if (propogate) {
            out.flush();
        }
    }

    /**
     * Flushes this output stream and forces any buffered output bytes to be written out to the stream.
     * 
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 16:09:10.138 -0500", hash_original_method = "12B88D256BE6909244011FA728F05779", hash_generated_method = "A76BC19837CC4CA07F375216D19D2DA4")
    
public void flush() throws IOException {
        flush(true);
    }

    /**
     * Closes this output stream and releases any system resources associated with the stream.
     * 
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 16:09:10.147 -0500", hash_original_method = "58A8BC724A3363C0278FA14872218B7C", hash_generated_method = "8A33CF1A8E6E7B639331FA26DE5634D1")
    
public void close() throws IOException {
        // Notify encoder of EOF (-1).
        if (doEncode) {
            base64.encode(singleByte, 0, -1);
        } else {
            base64.decode(singleByte, 0, -1);
        }
        flush();
        out.close();
    }

}

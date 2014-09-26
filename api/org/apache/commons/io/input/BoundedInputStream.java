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

/**
 * This is a stream that will only supply bytes up to a certain length - if its
 * position goes above that, it will stop.
 * <p>
 * This is useful to wrap ServletInputStreams. The ServletInputStream will block
 * if you try to read content from it that isn't there, because it doesn't know
 * whether the content hasn't arrived yet or whether the content has finished.
 * So, one of these, initialized with the Content-length sent in the
 * ServletInputStream's header, will stop it blocking, providing it's been sent
 * with a correct content length.
 *
 * @version $Id: BoundedInputStream.java 1307462 2012-03-30 15:13:11Z ggregory $
 * @since 2.0
 */
public class BoundedInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.377 -0400", hash_original_field = "0A829BC26C36EAF422E245C1EC11D5B0", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private  InputStream in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.377 -0400", hash_original_field = "F6D0C05991AFAA303AAE72EDF341C67A", hash_generated_field = "5B2AB7FACB5522D79218E5E18F9B6725")

    private  long max;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.378 -0400", hash_original_field = "20E65178D546E6F052E77AAADF12715C", hash_generated_field = "337E67B29A254DB50F39D690161DCA16")

    private long pos = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.378 -0400", hash_original_field = "3863EE780FA482243DACC4207FAAD902", hash_generated_field = "D1E0F56B583923CB5E6B889CBA9E43DD")

    private long mark = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.379 -0400", hash_original_field = "6CCF829280866840E9B99FAA4B9C5DA4", hash_generated_field = "C13C08818952F3D52164107F1B754367")

    private boolean propagateClose = true;

    /**
     * Creates a new <code>BoundedInputStream</code> that wraps the given input
     * stream and limits it to a certain size.
     *
     * @param in The wrapped input stream
     * @param size The maximum number of bytes to return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.380 -0400", hash_original_method = "BF2D432EB127F7CFDFED5801805EF7D3", hash_generated_method = "21C31E4611E532237AF4689D6DC78AA9")
    
public BoundedInputStream(InputStream in, long size) {
        // Some badly designed methods - eg the servlet API - overload length
        // such that "-1" means stream finished
        this.max = size;
        this.in = in;
    }

    /**
     * Creates a new <code>BoundedInputStream</code> that wraps the given input
     * stream and is unlimited.
     *
     * @param in The wrapped input stream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.380 -0400", hash_original_method = "B5B6039E253EDFE159BEF140A8BD9D88", hash_generated_method = "BE2C9BA42F04698FE9C18A9F10387CA8")
    
public BoundedInputStream(InputStream in) {
        this(in, -1);
    }

    /**
     * Invokes the delegate's <code>read()</code> method if
     * the current position is less than the limit.
     * @return the byte read or -1 if the end of stream or
     * the limit has been reached.
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.381 -0400", hash_original_method = "3B17BBAD3F2EB7B5AD570704422B04DF", hash_generated_method = "E4595D1150620DB6A28E6C23D90EB3DE")
    
@Override
    public int read() throws IOException {
        if (max >= 0 && pos >= max) {
            return -1;
        }
        int result = in.read();
        pos++;
        return result;
    }

    /**
     * Invokes the delegate's <code>read(byte[])</code> method.
     * @param b the buffer to read the bytes into
     * @return the number of bytes read or -1 if the end of stream or
     * the limit has been reached.
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.381 -0400", hash_original_method = "19F9C1719138FA897C10FCE8AB2E8039", hash_generated_method = "49FD28DF421FEF8CD1F21A9ACDBF2702")
    
@Override
    public int read(byte[] b) throws IOException {
        return this.read(b, 0, b.length);
    }

    /**
     * Invokes the delegate's <code>read(byte[], int, int)</code> method.
     * @param b the buffer to read the bytes into
     * @param off The start offset
     * @param len The number of bytes to read
     * @return the number of bytes read or -1 if the end of stream or
     * the limit has been reached.
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.382 -0400", hash_original_method = "6E26F3926C5C4BE64BEC3614C2578ECF", hash_generated_method = "DCA5893E95EBCAA6A167DCC40A92D6C6")
    
@Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (max>=0 && pos>=max) {
            return -1;
        }
        long maxRead = max>=0 ? Math.min(len, max-pos) : len;
        int bytesRead = in.read(b, off, (int)maxRead);

        if (bytesRead==-1) {
            return -1;
        }

        pos+=bytesRead;
        return bytesRead;
    }

    /**
     * Invokes the delegate's <code>skip(long)</code> method.
     * @param n the number of bytes to skip
     * @return the actual number of bytes skipped
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.382 -0400", hash_original_method = "3E60C451BC527FA5E0EE5111E14B91C6", hash_generated_method = "FA9A227518DD8FAF55840E8CD6E333C4")
    
@Override
    public long skip(long n) throws IOException {
        long toSkip = max>=0 ? Math.min(n, max-pos) : n;
        long skippedBytes = in.skip(toSkip);
        pos+=skippedBytes;
        return skippedBytes;
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.383 -0400", hash_original_method = "E5B4C78CEEFEAE7860E3B26DF4558532", hash_generated_method = "3F909D66FB3F4E3E53579A0162D1D953")
    
@Override
    public int available() throws IOException {
        if (max>=0 && pos>=max) {
            return 0;
        }
        return in.available();
    }

    /**
     * Invokes the delegate's <code>toString()</code> method.
     * @return the delegate's <code>toString()</code>
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.383 -0400", hash_original_method = "470E22CC32FA86C99C3D62D15B859950", hash_generated_method = "87D6EDE96859AF961B8D65DCD93E3C60")
    
@Override
    public String toString() {
        return in.toString();
    }

    /**
     * Invokes the delegate's <code>close()</code> method
     * if {@link #isPropagateClose()} is {@code true}.
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.384 -0400", hash_original_method = "1FFBF77FC0F2EDDE2606808C3D8F55E3", hash_generated_method = "36934EA4C8357F3785F502AC2601F406")
    
@Override
    public void close() throws IOException {
        if (propagateClose) {
            in.close();
        }
    }

    /**
     * Invokes the delegate's <code>reset()</code> method.
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.384 -0400", hash_original_method = "BD0421AF6C1AA9CFCF6C9B3AE10A8647", hash_generated_method = "5C3178ECC6D08BE1B7069E4CE30C9620")
    
@Override
    public synchronized void reset() throws IOException {
        in.reset();
        pos = mark;
    }

    /**
     * Invokes the delegate's <code>mark(int)</code> method.
     * @param readlimit read ahead limit
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.385 -0400", hash_original_method = "AEC932ABAD6BD3D26DA661A0D3655827", hash_generated_method = "38152F1A8F437FC89A8BF7703DAB79E9")
    
@Override
    public synchronized void mark(int readlimit) {
        in.mark(readlimit);
        mark = pos;
    }

    /**
     * Invokes the delegate's <code>markSupported()</code> method.
     * @return true if mark is supported, otherwise false
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.386 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "AAA0E9FA70DCC42A6EF6C686E3CCDC7E")
    
@Override
    public boolean markSupported() {
        return in.markSupported();
    }

    /**
     * Indicates whether the {@link #close()} method
     * should propagate to the underling {@link InputStream}.
     *
     * @return {@code true} if calling {@link #close()}
     * propagates to the <code>close()</code> method of the
     * underlying stream or {@code false} if it does not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.386 -0400", hash_original_method = "B87A5A17B4254C830F655DB212D58118", hash_generated_method = "30568660C9492311CE3A1670DA5CC05C")
    
public boolean isPropagateClose() {
        return propagateClose;
    }

    /**
     * Set whether the {@link #close()} method
     * should propagate to the underling {@link InputStream}.
     *
     * @param propagateClose {@code true} if calling
     * {@link #close()} propagates to the <code>close()</code>
     * method of the underlying stream or
     * {@code false} if it does not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.386 -0400", hash_original_method = "40C566C4C217B32854110D373EA24264", hash_generated_method = "C7D19D0D8CA8EC21FCCB2AE75F2D74A4")
    
public void setPropagateClose(boolean propagateClose) {
        this.propagateClose = propagateClose;
    }
}

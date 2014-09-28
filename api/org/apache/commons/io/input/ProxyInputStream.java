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
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * A Proxy stream which acts as expected, that is it passes the method
 * calls on to the proxied stream and doesn't change which methods are
 * being called.
 * <p>
 * It is an alternative base class to FilterInputStream
 * to increase reusability, because FilterInputStream changes the
 * methods being called, such as read(byte[]) to read(byte[], int, int).
 * <p>
 * See the protected methods for ways in which a subclass can easily decorate
 * a stream with custom pre-, post- or error processing functionality.
 *
 * @version $Id: ProxyInputStream.java 1304052 2012-03-22 20:55:29Z ggregory $
 */
public abstract class ProxyInputStream extends FilterInputStream {

    /**
     * Constructs a new ProxyInputStream.
     *
     * @param proxy  the InputStream to delegate to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.472 -0400", hash_original_method = "F5C674A4B4C3C6B0C4DE10E9E5CA4DD0", hash_generated_method = "2FBC03AD389DEBB693FDBCA5D35E4519")
    
public ProxyInputStream(InputStream proxy) {
        super(proxy);
        // the proxy is stored in a protected superclass variable named 'in'
    }

    /**
     * Invokes the delegate's <code>read()</code> method.
     * @return the byte read or -1 if the end of stream
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.473 -0400", hash_original_method = "54B5A34E53A0B96BE3D94E0D4A7D572A", hash_generated_method = "3D6BB7F1FA6BA070C87313FFEA7AFD38")
    
@Override
    public int read() throws IOException {
        try {
            beforeRead(1);
            int b = in.read();
            afterRead(b != -1 ? 1 : -1);
            return b;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    /**
     * Invokes the delegate's <code>read(byte[])</code> method.
     * @param bts the buffer to read the bytes into
     * @return the number of bytes read or -1 if the end of stream
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.474 -0400", hash_original_method = "ACF1A17E0D23809C356E177971499CFB", hash_generated_method = "C084603B1E8F1EDF53DB37D1B859A462")
    
@Override
    public int read(byte[] bts) throws IOException {
        try {
            beforeRead(bts != null ? bts.length : 0);
            int n = in.read(bts);
            afterRead(n);
            return n;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    /**
     * Invokes the delegate's <code>read(byte[], int, int)</code> method.
     * @param bts the buffer to read the bytes into
     * @param off The start offset
     * @param len The number of bytes to read
     * @return the number of bytes read or -1 if the end of stream
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.474 -0400", hash_original_method = "2C3D85339C2DDA831F01519845123B39", hash_generated_method = "AA79F4B08C140AB947EEDF78E949FA4F")
    
@Override
    public int read(byte[] bts, int off, int len) throws IOException {
        try {
            beforeRead(len);
            int n = in.read(bts, off, len);
            afterRead(n);
            return n;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    /**
     * Invokes the delegate's <code>skip(long)</code> method.
     * @param ln the number of bytes to skip
     * @return the actual number of bytes skipped
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.475 -0400", hash_original_method = "FA9F888D4C4D27A705AD6E4249FF9A0F", hash_generated_method = "C8F649F07984A40C7FEFB1C94172B5AD")
    
@Override
    public long skip(long ln) throws IOException {
        try {
            return in.skip(ln);
        } catch (IOException e) {
            handleIOException(e);
            return 0;
        }
    }

    /**
     * Invokes the delegate's <code>available()</code> method.
     * @return the number of available bytes
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.475 -0400", hash_original_method = "7BBD2FE125A14B4336F98A66912C9079", hash_generated_method = "6B291B7CF066ACAB4A37FF3BC6B00BEE")
    
@Override
    public int available() throws IOException {
        try {
            return super.available();
        } catch (IOException e) {
            handleIOException(e);
            return 0;
        }
    }

    /**
     * Invokes the delegate's <code>close()</code> method.
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.476 -0400", hash_original_method = "B82B927E9AF02AC9DAC77E074F6BBD30", hash_generated_method = "8DF4356E8F366D7D46C891448336116D")
    
@Override
    public void close() throws IOException {
        try {
            in.close();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Invokes the delegate's <code>mark(int)</code> method.
     * @param readlimit read ahead limit
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.476 -0400", hash_original_method = "FFAC7C303832D87EA3757F73ECC9CF0F", hash_generated_method = "97D4206E523BA3252F44669193A79E5B")
    
@Override
    public synchronized void mark(int readlimit) {
        in.mark(readlimit);
    }

    /**
     * Invokes the delegate's <code>reset()</code> method.
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.478 -0400", hash_original_method = "C1647ABF099BDE2A705C358E5A628D51", hash_generated_method = "8DA51924A1B4238BF8D93028A7202CD0")
    
@Override
    public synchronized void reset() throws IOException {
        try {
            in.reset();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Invokes the delegate's <code>markSupported()</code> method.
     * @return true if mark is supported, otherwise false
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.478 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "AAA0E9FA70DCC42A6EF6C686E3CCDC7E")
    
@Override
    public boolean markSupported() {
        return in.markSupported();
    }

    /**
     * Invoked by the read methods before the call is proxied. The number
     * of bytes that the caller wanted to read (1 for the {@link #read()}
     * method, buffer length for {@link #read(byte[])}, etc.) is given as
     * an argument.
     * <p>
     * Subclasses can override this method to add common pre-processing
     * functionality without having to override all the read methods.
     * The default implementation does nothing.
     * <p>
     * Note this method is <em>not</em> called from {@link #skip(long)} or
     * {@link #reset()}. You need to explicitly override those methods if
     * you want to add pre-processing steps also to them.
     *
     * @since 2.0
     * @param n number of bytes that the caller asked to be read
     * @throws IOException if the pre-processing fails
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.479 -0400", hash_original_method = "5DF216E1C56E8B7D3C0329D45F13AA7E", hash_generated_method = "FD212A4C535EA30D1B50D105A0130F85")
    
protected void beforeRead(int n) throws IOException {
    }

    /**
     * Invoked by the read methods after the proxied call has returned
     * successfully. The number of bytes returned to the caller (or -1 if
     * the end of stream was reached) is given as an argument.
     * <p>
     * Subclasses can override this method to add common post-processing
     * functionality without having to override all the read methods.
     * The default implementation does nothing.
     * <p>
     * Note this method is <em>not</em> called from {@link #skip(long)} or
     * {@link #reset()}. You need to explicitly override those methods if
     * you want to add post-processing steps also to them.
     *
     * @since 2.0
     * @param n number of bytes read, or -1 if the end of stream was reached
     * @throws IOException if the post-processing fails
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.479 -0400", hash_original_method = "C3D8A276950C0BAD0FCEDE931894DAB6", hash_generated_method = "B1D8425EF51444B0AAD78DEEF31E88A8")
    
protected void afterRead(int n) throws IOException {
    }

    /**
     * Handle any IOExceptions thrown.
     * <p>
     * This method provides a point to implement custom exception
     * handling. The default behaviour is to re-throw the exception.
     * @param e The IOException thrown
     * @throws IOException if an I/O error occurs
     * @since 2.0
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.479 -0400", hash_original_method = "A242DFA5F52516C95D0F167B92B745B6", hash_generated_method = "1891156C8FEFAA68CD85CC13506CC1D3")
    
protected void handleIOException(IOException e) throws IOException {
        throw e;
    }

}

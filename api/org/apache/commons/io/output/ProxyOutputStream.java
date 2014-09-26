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
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * A Proxy stream which acts as expected, that is it passes the method 
 * calls on to the proxied stream and doesn't change which methods are 
 * being called. It is an alternative base class to FilterOutputStream
 * to increase reusability.
 * <p>
 * See the protected methods for ways in which a subclass can easily decorate
 * a stream with custom pre-, post- or error processing functionality.
 * 
 * @version $Id: ProxyOutputStream.java 1304052 2012-03-22 20:55:29Z ggregory $
 */
public class ProxyOutputStream extends FilterOutputStream {

    /**
     * Constructs a new ProxyOutputStream.
     * 
     * @param proxy  the OutputStream to delegate to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.264 -0400", hash_original_method = "994F669A59E4B3A0EE398298B336F810", hash_generated_method = "2BEECC6B96D4108E92CF5063E98986E9")
    
public ProxyOutputStream(OutputStream proxy) {
        super(proxy);
        // the proxy is stored in a protected superclass variable named 'out'
    }

    /**
     * Invokes the delegate's <code>write(int)</code> method.
     * @param idx the byte to write
     * @throws IOException if an I/O error occurs
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.264 -0400", hash_original_method = "C10E35B15C5C34D2F11AD8F56A8AFBE7", hash_generated_method = "8538DC9FDF04C178771F287DC9084D00")
    
@Override
    public void write(int idx) throws IOException {
        try {
            beforeWrite(1);
            out.write(idx);
            afterWrite(1);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Invokes the delegate's <code>write(byte[])</code> method.
     * @param bts the bytes to write
     * @throws IOException if an I/O error occurs
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.266 -0400", hash_original_method = "E4B5E15EBD1DC0F51B6909882AA2B9D3", hash_generated_method = "F2EA6D6D1EB28486AFF7B8C18D6CD1F3")
    
@Override
    public void write(byte[] bts) throws IOException {
        try {
            int len = bts != null ? bts.length : 0;
            beforeWrite(len);
            out.write(bts);
            afterWrite(len);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Invokes the delegate's <code>write(byte[])</code> method.
     * @param bts the bytes to write
     * @param st The start offset
     * @param end The number of bytes to write
     * @throws IOException if an I/O error occurs
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.266 -0400", hash_original_method = "6659C26B9D2F6D845755120D9E3C542C", hash_generated_method = "1D85046399E8D016E013E1B1E96055F2")
    
@Override
    public void write(byte[] bts, int st, int end) throws IOException {
        try {
            beforeWrite(end);
            out.write(bts, st, end);
            afterWrite(end);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Invokes the delegate's <code>flush()</code> method.
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.267 -0400", hash_original_method = "EEECDB779BCD3F1C16C4BB7414585E36", hash_generated_method = "A55EC4CDFFAE64F1B331AEE9E72C7A09")
    
@Override
    public void flush() throws IOException {
        try {
            out.flush();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Invokes the delegate's <code>close()</code> method.
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.268 -0400", hash_original_method = "EA1F98341C1FEBB76DE541E0DAA4DDD0", hash_generated_method = "2908ECB022F338E34CD3F0E8541D8B63")
    
@Override
    public void close() throws IOException {
        try {
            out.close();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Invoked by the write methods before the call is proxied. The number
     * of bytes to be written (1 for the {@link #write(int)} method, buffer
     * length for {@link #write(byte[])}, etc.) is given as an argument.
     * <p>
     * Subclasses can override this method to add common pre-processing
     * functionality without having to override all the write methods.
     * The default implementation does nothing.
     *
     * @since 2.0
     * @param n number of bytes to be written
     * @throws IOException if the pre-processing fails
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.268 -0400", hash_original_method = "961C14EE073174624B2AA02C565F3907", hash_generated_method = "52BDA559670D4FF766CC677735730AEA")
    
protected void beforeWrite(int n) throws IOException {
    }

    /**
     * Invoked by the write methods after the proxied call has returned
     * successfully. The number of bytes written (1 for the
     * {@link #write(int)} method, buffer length for {@link #write(byte[])},
     * etc.) is given as an argument.
     * <p>
     * Subclasses can override this method to add common post-processing
     * functionality without having to override all the write methods.
     * The default implementation does nothing.
     *
     * @since 2.0
     * @param n number of bytes written
     * @throws IOException if the post-processing fails
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.269 -0400", hash_original_method = "634EDAC0BBD2C7E1FA3D5BDE9765B3F8", hash_generated_method = "E22D951CDC0C6538752306DA0A369FDB")
    
protected void afterWrite(int n) throws IOException {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.270 -0400", hash_original_method = "A242DFA5F52516C95D0F167B92B745B6", hash_generated_method = "1891156C8FEFAA68CD85CC13506CC1D3")
    
protected void handleIOException(IOException e) throws IOException {
        throw e;
    }

}

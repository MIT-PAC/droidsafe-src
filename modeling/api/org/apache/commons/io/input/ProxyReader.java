/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.io.input;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/**
 * A Proxy stream which acts as expected, that is it passes the method 
 * calls on to the proxied stream and doesn't change which methods are 
 * being called. 
 * <p>
 * It is an alternative base class to FilterReader
 * to increase reusability, because FilterReader changes the 
 * methods being called, such as read(char[]) to read(char[], int, int).
 * 
 * @version $Id: ProxyReader.java 1304052 2012-03-22 20:55:29Z ggregory $
 */
public abstract class ProxyReader extends FilterReader {

    /**
     * Constructs a new ProxyReader.
     * 
     * @param proxy  the Reader to delegate to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.678 -0400", hash_original_method = "B02C906E6ABD17D05C219574C0B0E791", hash_generated_method = "DB2D35A555E307126FAC7A0ED05BDE1D")
    
public ProxyReader(Reader proxy) {
        super(proxy);
        // the proxy is stored in a protected superclass variable named 'in'
    }

    /**
     * Invokes the delegate's <code>read()</code> method.
     * @return the character read or -1 if the end of stream
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.679 -0400", hash_original_method = "F5A2FF58A48B2EE55066C0DB2B9AC980", hash_generated_method = "65B7E972E19D306244BB98798323AA70")
    
@Override
    public int read() throws IOException {
        try {
            beforeRead(1);
            int c = in.read();
            afterRead(c != -1 ? 1 : -1);
            return c;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    /**
     * Invokes the delegate's <code>read(char[])</code> method.
     * @param chr the buffer to read the characters into
     * @return the number of characters read or -1 if the end of stream
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.679 -0400", hash_original_method = "994E9DF4336B3658B3591197F683F468", hash_generated_method = "00985BC2762F24350F95CBBE864007B0")
    
@Override
    public int read(char[] chr) throws IOException {
        try {
            beforeRead(chr != null ? chr.length : 0);
            int n = in.read(chr);
            afterRead(n);
            return n;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    /**
     * Invokes the delegate's <code>read(char[], int, int)</code> method.
     * @param chr the buffer to read the characters into
     * @param st The start offset
     * @param len The number of bytes to read
     * @return the number of characters read or -1 if the end of stream
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.680 -0400", hash_original_method = "819423AAC8700E3137A36825F0D63A1E", hash_generated_method = "E9C6596C20B426756B32B95C67633D8E")
    
@Override
    public int read(char[] chr, int st, int len) throws IOException {
        try {
            beforeRead(len);
            int n = in.read(chr, st, len);
            afterRead(n);
            return n;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    /**
     * Invokes the delegate's <code>read(CharBuffer)</code> method.
     * @param target the char buffer to read the characters into
     * @return the number of characters read or -1 if the end of stream
     * @throws IOException if an I/O error occurs
     * @since 2.0
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.681 -0400", hash_original_method = "6C91D7D5FFA64861FDFA028E5549C4E1", hash_generated_method = "FEE8C0895D2AC408B30877F3904607C6")
    
@Override
    public int read(CharBuffer target) throws IOException {
        try {
            beforeRead(target != null ? target.length() : 0);
            int n = in.read(target);
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
     * @return the number of bytes to skipped or -1 if the end of stream
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.681 -0400", hash_original_method = "FA9F888D4C4D27A705AD6E4249FF9A0F", hash_generated_method = "C8F649F07984A40C7FEFB1C94172B5AD")
    
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
     * Invokes the delegate's <code>ready()</code> method.
     * @return true if the stream is ready to be read
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.682 -0400", hash_original_method = "898ED87B3E2D635579A550CF0CA7DA33", hash_generated_method = "CB065DAF4E5CD1B91067DE099E902E01")
    
@Override
    public boolean ready() throws IOException {
        try {
            return in.ready();
        } catch (IOException e) {
            handleIOException(e);
            return false;
        }
    }

    /**
     * Invokes the delegate's <code>close()</code> method.
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.683 -0400", hash_original_method = "B82B927E9AF02AC9DAC77E074F6BBD30", hash_generated_method = "8DF4356E8F366D7D46C891448336116D")
    
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
     * @param idx read ahead limit
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.683 -0400", hash_original_method = "C433C94D03198733235CDD6598A695B3", hash_generated_method = "19B8D51D9B29969F86A9BA7E99FD18C5")
    
@Override
    public synchronized void mark(int idx) throws IOException {
        try {
            in.mark(idx);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Invokes the delegate's <code>reset()</code> method.
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.684 -0400", hash_original_method = "C1647ABF099BDE2A705C358E5A628D51", hash_generated_method = "8DA51924A1B4238BF8D93028A7202CD0")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.684 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "AAA0E9FA70DCC42A6EF6C686E3CCDC7E")
    
@Override
    public boolean markSupported() {
        return in.markSupported();
    }

    /**
     * Invoked by the read methods before the call is proxied. The number
     * of chars that the caller wanted to read (1 for the {@link #read()}
     * method, buffer length for {@link #read(char[])}, etc.) is given as
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
     * @param n number of chars that the caller asked to be read
     * @throws IOException if the pre-processing fails
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.685 -0400", hash_original_method = "5DF216E1C56E8B7D3C0329D45F13AA7E", hash_generated_method = "FD212A4C535EA30D1B50D105A0130F85")
    
protected void beforeRead(int n) throws IOException {
    }

    /**
     * Invoked by the read methods after the proxied call has returned
     * successfully. The number of chars returned to the caller (or -1 if
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
     * @param n number of chars read, or -1 if the end of stream was reached
     * @throws IOException if the post-processing fails
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.685 -0400", hash_original_method = "C3D8A276950C0BAD0FCEDE931894DAB6", hash_generated_method = "B1D8425EF51444B0AAD78DEEF31E88A8")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.686 -0400", hash_original_method = "A242DFA5F52516C95D0F167B92B745B6", hash_generated_method = "1891156C8FEFAA68CD85CC13506CC1D3")
    
protected void handleIOException(IOException e) throws IOException {
        throw e;
    }

}

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
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * A Proxy stream which acts as expected, that is it passes the method 
 * calls on to the proxied stream and doesn't change which methods are 
 * being called. It is an alternative base class to FilterWriter
 * to increase reusability, because FilterWriter changes the 
 * methods being called, such as write(char[]) to write(char[], int, int)
 * and write(String) to write(String, int, int).
 * 
 * @version $Id: ProxyWriter.java 1304052 2012-03-22 20:55:29Z ggregory $
 */
public class ProxyWriter extends FilterWriter {

    /**
     * Constructs a new ProxyWriter.
     * 
     * @param proxy  the Writer to delegate to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.768 -0400", hash_original_method = "033B4CFD391086531B126612D5903ED1", hash_generated_method = "B63CBE398DCC52E4B4FCA4043EAD4654")
    
public ProxyWriter(Writer proxy) {
        super(proxy);
        // the proxy is stored in a protected superclass variable named 'out'
    }

    /**
     * Invokes the delegate's <code>append(char)</code> method.
     * @param c The character to write
     * @return this writer
     * @throws IOException if an I/O error occurs
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.769 -0400", hash_original_method = "94E64203D23ECC11F0966710C23548F3", hash_generated_method = "A06CCE7300A2A2536C74343D00CD989D")
    
@Override
    public Writer append(char c) throws IOException {
        try {
            beforeWrite(1);
            out.append(c);
            afterWrite(1);
        } catch (IOException e) {
            handleIOException(e);
        }
        return this;
    }

    /**
     * Invokes the delegate's <code>append(CharSequence, int, int)</code> method.
     * @param csq The character sequence to write
     * @param start The index of the first character to write
     * @param end  The index of the first character to write (exclusive)
     * @return this writer
     * @throws IOException if an I/O error occurs
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.770 -0400", hash_original_method = "391E9756F83F23FF347EF2129E3A0E99", hash_generated_method = "D1659AD21EAF8B4DE464BAC0141C052C")
    
@Override
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        try {
            beforeWrite(end - start);
            out.append(csq, start, end);
            afterWrite(end - start);
        } catch (IOException e) {
            handleIOException(e);
        }
        return this;
    }

    /**
     * Invokes the delegate's <code>append(CharSequence)</code> method.
     * @param csq The character sequence to write
     * @return this writer
     * @throws IOException if an I/O error occurs
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.770 -0400", hash_original_method = "AF511130F35AA3E3B287C842560F9DCE", hash_generated_method = "31E7EB75C8368215C547C5CD1DE26F7C")
    
@Override
    public Writer append(CharSequence csq) throws IOException {
        try {
            int len = 0;
            if (csq != null) {
                len = csq.length();
            }

            beforeWrite(len);
            out.append(csq);
            afterWrite(len);
        } catch (IOException e) {
            handleIOException(e);
        }
        return this;
    }

    /**
     * Invokes the delegate's <code>write(int)</code> method.
     * @param idx the character to write
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.771 -0400", hash_original_method = "C10E35B15C5C34D2F11AD8F56A8AFBE7", hash_generated_method = "8538DC9FDF04C178771F287DC9084D00")
    
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
     * Invokes the delegate's <code>write(char[])</code> method.
     * @param chr the characters to write
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.771 -0400", hash_original_method = "579B5F1267C3E5A23AE0501F4C0FD567", hash_generated_method = "4B3C8F41C253C09EE53C6F475AC7F7C1")
    
@Override
    public void write(char[] chr) throws IOException {
        try {
            int len = 0;
            if (chr != null) {
                len = chr.length;
            }

            beforeWrite(len);
            out.write(chr);
            afterWrite(len);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Invokes the delegate's <code>write(char[], int, int)</code> method.
     * @param chr the characters to write
     * @param st The start offset
     * @param len The number of characters to write
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.772 -0400", hash_original_method = "4BD1C735F7EB97F1200118825DBDCCC5", hash_generated_method = "669CC50EA5B2EF86DA42CB28ADA7155A")
    
@Override
    public void write(char[] chr, int st, int len) throws IOException {
        try {
            beforeWrite(len);
            out.write(chr, st, len);
            afterWrite(len);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Invokes the delegate's <code>write(String)</code> method.
     * @param str the string to write
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.773 -0400", hash_original_method = "6B60D7F6AE629840306B83B2B10FEDBF", hash_generated_method = "C386FD922E0961B57B289A4051F2A0E6")
    
@Override
    public void write(String str) throws IOException {
        try {
            int len = 0;
            if (str != null) {
                len = str.length();
            }

            beforeWrite(len);
            out.write(str);
            afterWrite(len);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Invokes the delegate's <code>write(String)</code> method.
     * @param str the string to write
     * @param st The start offset
     * @param len The number of characters to write
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.773 -0400", hash_original_method = "E5A50F6C55F59DD4142D90322431FA35", hash_generated_method = "739960DEFBE1047F365B92CD8C757715")
    
@Override
    public void write(String str, int st, int len) throws IOException {
        try {
            beforeWrite(len);
            out.write(str, st, len);
            afterWrite(len);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Invokes the delegate's <code>flush()</code> method.
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.774 -0400", hash_original_method = "EEECDB779BCD3F1C16C4BB7414585E36", hash_generated_method = "A55EC4CDFFAE64F1B331AEE9E72C7A09")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.774 -0400", hash_original_method = "EA1F98341C1FEBB76DE541E0DAA4DDD0", hash_generated_method = "2908ECB022F338E34CD3F0E8541D8B63")
    
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
     * of chars to be written (1 for the {@link #write(int)} method, buffer
     * length for {@link #write(char[])}, etc.) is given as an argument.
     * <p>
     * Subclasses can override this method to add common pre-processing
     * functionality without having to override all the write methods.
     * The default implementation does nothing.
     *
     * @since 2.0
     * @param n number of chars to be written
     * @throws IOException if the pre-processing fails
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.775 -0400", hash_original_method = "961C14EE073174624B2AA02C565F3907", hash_generated_method = "52BDA559670D4FF766CC677735730AEA")
    
protected void beforeWrite(int n) throws IOException {
    }

    /**
     * Invoked by the write methods after the proxied call has returned
     * successfully. The number of chars written (1 for the
     * {@link #write(int)} method, buffer length for {@link #write(char[])},
     * etc.) is given as an argument.
     * <p>
     * Subclasses can override this method to add common post-processing
     * functionality without having to override all the write methods.
     * The default implementation does nothing.
     *
     * @since 2.0
     * @param n number of chars written
     * @throws IOException if the post-processing fails
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.775 -0400", hash_original_method = "634EDAC0BBD2C7E1FA3D5BDE9765B3F8", hash_generated_method = "E22D951CDC0C6538752306DA0A369FDB")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.776 -0400", hash_original_method = "A242DFA5F52516C95D0F167B92B745B6", hash_generated_method = "1891156C8FEFAA68CD85CC13506CC1D3")
    
protected void handleIOException(IOException e) throws IOException {
        throw e;
    }

}

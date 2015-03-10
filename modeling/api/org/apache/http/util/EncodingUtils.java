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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/util/EncodingUtils.java $
 * $Revision: 503413 $
 * $Date: 2007-02-04 06:22:14 -0800 (Sun, 04 Feb 2007) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;

import org.apache.http.protocol.HTTP;

public final class EncodingUtils {

    /**
     * Converts the byte array of HTTP content characters to a string. If
     * the specified charset is not supported, default system encoding
     * is used.
     *
     * @param data the byte array to be encoded
     * @param offset the index of the first byte to encode
     * @param length the number of bytes to encode 
     * @param charset the desired character encoding
     * @return The result of the conversion.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.753 -0500", hash_original_method = "40BB3B2C4BB4C731F5583BF6098AFE18", hash_generated_method = "8976F30A253F465CBA0EB67FF9636DBF")
    
public static String getString(
        final byte[] data, 
        int offset, 
        int length, 
        String charset
    ) {

        if (data == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }

        if (charset == null || charset.length() == 0) {
            throw new IllegalArgumentException("charset may not be null or empty");
        }

        try {
            return new String(data, offset, length, charset);
        } catch (UnsupportedEncodingException e) {
            return new String(data, offset, length);
        }
    }

    /**
     * Converts the byte array of HTTP content characters to a string. If
     * the specified charset is not supported, default system encoding
     * is used.
     *
     * @param data the byte array to be encoded
     * @param charset the desired character encoding
     * @return The result of the conversion.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.755 -0500", hash_original_method = "FEB603F543F1F5AF4F6A224218D3D260", hash_generated_method = "3D315426762ABE49A91B6A91D40088DC")
    
public static String getString(final byte[] data, final String charset) {
        if (data == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        return getString(data, 0, data.length, charset);
    }

    /**
     * Converts the specified string to a byte array.  If the charset is not supported the
     * default system charset is used.
     *
     * @param data the string to be encoded
     * @param charset the desired character encoding
     * @return The resulting byte array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.757 -0500", hash_original_method = "38B56644692964A3419BDFD155B57672", hash_generated_method = "B3BA75F36FBD6E9813662D57B6350E73")
    
public static byte[] getBytes(final String data, final String charset) {

        if (data == null) {
            throw new IllegalArgumentException("data may not be null");
        }

        if (charset == null || charset.length() == 0) {
            throw new IllegalArgumentException("charset may not be null or empty");
        }

        try {
            return data.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            return data.getBytes();
        }
    }
    
    /**
     * Converts the specified string to byte array of ASCII characters.
     *
     * @param data the string to be encoded
     * @return The string as a byte array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.760 -0500", hash_original_method = "58BB75688EA0004E060732C344F2327F", hash_generated_method = "DDA7941C7C9D25454B332B6E47F493BB")
    
public static byte[] getAsciiBytes(final String data) {

        if (data == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }

        try {
            return data.getBytes(HTTP.US_ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new Error("HttpClient requires ASCII support");
        }
    }

    /**
     * Converts the byte array of ASCII characters to a string. This method is
     * to be used when decoding content of HTTP elements (such as response
     * headers)
     *
     * @param data the byte array to be encoded
     * @param offset the index of the first byte to encode
     * @param length the number of bytes to encode 
     * @return The string representation of the byte array
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.762 -0500", hash_original_method = "54C133774B5EF322D037D483B88C7A86", hash_generated_method = "BA1CF2153BCD524BE783DB4924D48338")
    
public static String getAsciiString(final byte[] data, int offset, int length) {

        if (data == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }

        try {
            return new String(data, offset, length, HTTP.US_ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new Error("HttpClient requires ASCII support");
        }
    }

    /**
     * Converts the byte array of ASCII characters to a string. This method is
     * to be used when decoding content of HTTP elements (such as response
     * headers)
     *
     * @param data the byte array to be encoded
     * @return The string representation of the byte array
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.765 -0500", hash_original_method = "9EE23858D5093508DE644A77EDC3E526", hash_generated_method = "397F472CF67EA5F5F434127EDF0D1CDD")
    
public static String getAsciiString(final byte[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        return getAsciiString(data, 0, data.length);
    }

    /**
     * This class should not be instantiated.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.767 -0500", hash_original_method = "9056910A11B8F7E2130B8014667A5810", hash_generated_method = "CEECFF6F08063F48651117F1E4FF30DE")
    
private EncodingUtils() {
    }
    
}


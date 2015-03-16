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
 * Copyright 2001-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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


package org.apache.commons.codec.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

/**
 * <p>Implements the 'www-form-urlencoded' encoding scheme, 
 * also misleadingly known as URL encoding.</p>
 *  
 * <p>For more detailed information please refer to 
 * <a href="http://www.w3.org/TR/html4/interact/forms.html#h-17.13.4.1">
 * Chapter 17.13.4 'Form content types'</a> of the 
 * <a href="http://www.w3.org/TR/html4/">HTML 4.01 Specification<a></p>
 * 
 * <p> 
 * This codec is meant to be a replacement for standard Java classes
 * {@link java.net.URLEncoder} and {@link java.net.URLDecoder} 
 * on older Java platforms, as these classes in Java versions below 
 * 1.4 rely on the platform's default charset encoding.
 * </p>
 * 
 * @author Apache Software Foundation
 * @since 1.2
 * @version $Id: URLCodec.java,v 1.19 2004/03/29 07:59:00 ggregory Exp $
 */
public class URLCodec implements BinaryEncoder, BinaryDecoder, StringEncoder, StringDecoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.379 -0400", hash_original_field = "B90A5B50CBF83D34693E9C3F8277F14D", hash_generated_field = "13E9DD0AAFBBA742226E4745F527C33B")

    
    protected static byte ESCAPE_CHAR = '%';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.380 -0400", hash_original_field = "F556FE8D651D12BECE4A77FAF5F13BA6", hash_generated_field = "5A146ACAD1BAF644A66930AB66A60659")

    protected static final BitSet WWW_FORM_URL = new BitSet(256);

    /**
     * Encodes an array of bytes into an array of URL safe 7-bit 
     * characters. Unsafe characters are escaped.
     *
     * @param urlsafe bitset of characters deemed URL safe
     * @param bytes array of bytes to convert to URL safe characters
     * @return array of bytes containing URL safe characters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.382 -0400", hash_original_method = "A43774E69E9908236515137E841EAEB1", hash_generated_method = "0C0A24C290F14EB46D0ACD23CBBBCC62")
    
public static final byte[] encodeUrl(BitSet urlsafe, byte[] bytes) 
    {
        if (bytes == null) {
            return null;
        }
        if (urlsafe == null) {
            urlsafe = WWW_FORM_URL;
        }
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream(); 
        for (int i = 0; i < bytes.length; i++) {
            int b = bytes[i];
            if (b < 0) {
                b = 256 + b;
            }
            if (urlsafe.get(b)) {
                if (b == ' ') {
                    b = '+';
                }
                buffer.write(b);
            } else {
                buffer.write('%');
                char hex1 = Character.toUpperCase(
                  Character.forDigit((b >> 4) & 0xF, 16));
                char hex2 = Character.toUpperCase(
                  Character.forDigit(b & 0xF, 16));
                buffer.write(hex1);
                buffer.write(hex2);
            }
        }
        return buffer.toByteArray(); 
    }
    
    // Static initializer for www_form_url
    static {
        // alpha characters
        for (int i = 'a'; i <= 'z'; i++) {
            WWW_FORM_URL.set(i);
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            WWW_FORM_URL.set(i);
        }
        // numeric characters
        for (int i = '0'; i <= '9'; i++) {
            WWW_FORM_URL.set(i);
        }
        // special chars
        WWW_FORM_URL.set('-');
        WWW_FORM_URL.set('_');
        WWW_FORM_URL.set('.');
        WWW_FORM_URL.set('*');
        // blank to be replaced with +
        WWW_FORM_URL.set(' ');
    }


    /**
     * Decodes an array of URL safe 7-bit characters into an array of 
     * original bytes. Escaped characters are converted back to their 
     * original representation.
     *
     * @param bytes array of URL safe characters
     * @return array of original bytes 
     * @throws DecoderException Thrown if URL decoding is unsuccessful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.383 -0400", hash_original_method = "A865ADEBF58247B6AD56000E5CC2504C", hash_generated_method = "352DF15A9748450D49191CDCADB73AEF")
    
public static final byte[] decodeUrl(byte[] bytes) 
         throws DecoderException
    {
        if (bytes == null) {
            return null;
        }
        ByteArrayOutputStream buffer = new ByteArrayOutputStream(); 
        for (int i = 0; i < bytes.length; i++) {
            int b = bytes[i];
            if (b == '+') {
                buffer.write(' ');
            } else if (b == '%') {
                try {
                    int u = Character.digit((char)bytes[++i], 16);
                    int l = Character.digit((char)bytes[++i], 16);
                    if (u == -1 || l == -1) {
                        throw new DecoderException("Invalid URL encoding");
                    }
                    buffer.write((char)((u << 4) + l));
                } catch(ArrayIndexOutOfBoundsException e) {
                    throw new DecoderException("Invalid URL encoding");
                }
            } else {
                buffer.write(b);
            }
        }
        return buffer.toByteArray(); 
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.379 -0400", hash_original_field = "B1CB9DCBF2CC34A785844A4F8D009195", hash_generated_field = "99797936593485F2791D7E1A39C67409")

    protected String charset = StringEncodings.UTF8;


    /**
     * Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.380 -0400", hash_original_method = "49864F76C91DD138880CCDBFF6481D51", hash_generated_method = "B3459A65A4DAB7A9E733DFFA31FC5AC8")
    
public URLCodec() {
        super();
    }

    /**
     * Constructor which allows for the selection of a default charset
     * 
     * @param charset the default string charset to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.381 -0400", hash_original_method = "680AF2442DC2DAF0252E80B8E6CBF5FD", hash_generated_method = "3ACD505EBF1D52DEB2B473A434E25AA4")
    
public URLCodec(String charset) {
        super();
        this.charset = charset;
    }


    /**
     * Encodes an array of bytes into an array of URL safe 7-bit 
     * characters. Unsafe characters are escaped.
     *
     * @param bytes array of bytes to convert to URL safe characters
     * @return array of bytes containing URL safe characters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.384 -0400", hash_original_method = "ADB04057797F52456DB7F46168AA93CE", hash_generated_method = "1479D060227502DB5CECF2708C5ECBEF")
    
public byte[] encode(byte[] bytes) {
        return encodeUrl(WWW_FORM_URL, bytes);
    }


    /**
     * Decodes an array of URL safe 7-bit characters into an array of 
     * original bytes. Escaped characters are converted back to their 
     * original representation.
     *
     * @param bytes array of URL safe characters
     * @return array of original bytes 
     * @throws DecoderException Thrown if URL decoding is unsuccessful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.384 -0400", hash_original_method = "4B8C8480512DA051CE22C87157965AAC", hash_generated_method = "4593F14C511CEE77F80A935A25D5C37A")
    @DSSource(DSSourceKind.ENCODED)
public byte[] decode(byte[] bytes) throws DecoderException {
        return decodeUrl(bytes);
    }


    /**
     * Encodes a string into its URL safe form using the specified
     * string charset. Unsafe characters are escaped.
     *
     * @param pString string to convert to a URL safe form
     * @param charset the charset for pString
     * @return URL safe string
     * @throws UnsupportedEncodingException Thrown if charset is not
     *                                      supported 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.385 -0400", hash_original_method = "385A210A4F53DD068AEE801B7B136BBE", hash_generated_method = "0815FCBC3E537BB3192BE42996501FD5")
    
public String encode(String pString, String charset) 
        throws UnsupportedEncodingException  
    {
        if (pString == null) {
            return null;
        }
        return new String(encode(pString.getBytes(charset)), StringEncodings.US_ASCII);
    }


    /**
     * Encodes a string into its URL safe form using the default string 
     * charset. Unsafe characters are escaped.
     *
     * @param pString string to convert to a URL safe form
     * @return URL safe string
     * @throws EncoderException Thrown if URL encoding is unsuccessful
     * 
     * @see #getDefaultCharset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.386 -0400", hash_original_method = "87E4447E26C3107C6DF2678BD461EF96", hash_generated_method = "B0D9B1E23058F28E118D0AED26ABE5C9")
    
public String encode(String pString) throws EncoderException {
        if (pString == null) {
            return null;
        }
        try {
            return encode(pString, getDefaultCharset());
        } catch(UnsupportedEncodingException e) {
            throw new EncoderException(e.getMessage());
        }
    }


    /**
     * Decodes a URL safe string into its original form using the 
     * specified encoding. Escaped characters are converted back 
     * to their original representation.
     *
     * @param pString URL safe string to convert into its original form
     * @param charset the original string charset
     * @return original string 
     * @throws DecoderException Thrown if URL decoding is unsuccessful
     * @throws UnsupportedEncodingException Thrown if charset is not
     *                                      supported 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.386 -0400", hash_original_method = "F3793FD3E2505AD035424F13E8FC4E3E", hash_generated_method = "A58E4C50621A1951F80865295014D02B")
    
public String decode(String pString, String charset) 
        throws DecoderException, UnsupportedEncodingException 
    {
        if (pString == null) {
            return null;
        }
        return new String(decode(pString.getBytes(StringEncodings.US_ASCII)), charset);
    }


    /**
     * Decodes a URL safe string into its original form using the default
     * string charset. Escaped characters are converted back to their 
     * original representation.
     *
     * @param pString URL safe string to convert into its original form
     * @return original string 
     * @throws DecoderException Thrown if URL decoding is unsuccessful
     * 
     * @see #getDefaultCharset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.387 -0400", hash_original_method = "8C409C50276DC5FFF073C17593B975AC", hash_generated_method = "253D44827C6A185BCD712DA99FC5ECAC")
    
public String decode(String pString) throws DecoderException {
        if (pString == null) {
            return null;
        }
        try {
            return decode(pString, getDefaultCharset());
        } catch(UnsupportedEncodingException e) {
            throw new DecoderException(e.getMessage());
        }
    }

    /**
     * Encodes an object into its URL safe form. Unsafe characters are 
     * escaped.
     *
     * @param pObject string to convert to a URL safe form
     * @return URL safe object
     * @throws EncoderException Thrown if URL encoding is not 
     *                          applicable to objects of this type or
     *                          if encoding is unsuccessful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.387 -0400", hash_original_method = "13A2E944F2DC31C8D9BCDECDB68E3CE6", hash_generated_method = "7ECF7AEC58498795FA60F0915D4478F3")
    
public Object encode(Object pObject) throws EncoderException {
        if (pObject == null) {
            return null;
        } else if (pObject instanceof byte[]) {
            return encode((byte[])pObject);
        } else if (pObject instanceof String) {
            return encode((String)pObject);
        } else {
            throw new EncoderException("Objects of type " +
                pObject.getClass().getName() + " cannot be URL encoded"); 
              
        }
    }

    /**
     * Decodes a URL safe object into its original form. Escaped 
     * characters are converted back to their original representation.
     *
     * @param pObject URL safe object to convert into its original form
     * @return original object 
     * @throws DecoderException Thrown if URL decoding is not 
     *                          applicable to objects of this type
     *                          if decoding is unsuccessful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.388 -0400", hash_original_method = "9A8A9369607CBCE0B198118FFA0FC7E8", hash_generated_method = "5716A6A6812CE555B3B711E566D55EB5")
    
public Object decode(Object pObject) throws DecoderException {
        if (pObject == null) {
            return null;
        } else if (pObject instanceof byte[]) {
            return decode((byte[])pObject);
        } else if (pObject instanceof String) {
            return decode((String)pObject);
        } else {
            throw new DecoderException("Objects of type " +
                pObject.getClass().getName() + " cannot be URL decoded"); 
              
        }
    }

    /**
     * The <code>String</code> encoding used for decoding and encoding.
     *
     * @return Returns the encoding.
     * 
     * @deprecated use #getDefaultCharset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.389 -0400", hash_original_method = "67949C8562ADC5FEA333643588D62633", hash_generated_method = "AD0D2AD822E77451851F5E672BAAC011")
    
public String getEncoding() {
        return this.charset;
    }

    /**
     * The default charset used for string decoding and encoding.
     *
     * @return the default string charset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.390 -0400", hash_original_method = "BBEE24F22F047B14B05EB2D9AC64A64D", hash_generated_method = "41115F037B14D5BF809A57FFDF9E0425")
    
public String getDefaultCharset() {
        return this.charset;
    }

}

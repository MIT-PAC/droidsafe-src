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
 * <p>
 * Codec for the Quoted-Printable section of <a href="http://www.ietf.org/rfc/rfc1521.txt">RFC 1521 </a>.
 * </p>
 * <p>
 * The Quoted-Printable encoding is intended to represent data that largely consists of octets that correspond to
 * printable characters in the ASCII character set. It encodes the data in such a way that the resulting octets are
 * unlikely to be modified by mail transport. If the data being encoded are mostly ASCII text, the encoded form of the
 * data remains largely recognizable by humans. A body which is entirely ASCII may also be encoded in Quoted-Printable
 * to ensure the integrity of the data should the message pass through a character- translating, and/or line-wrapping
 * gateway.
 * </p>
 * 
 * <p>
 * Note:
 * </p>
 * <p>
 * Rules #3, #4, and #5 of the quoted-printable spec are not implemented yet because the complete quoted-printable spec
 * does not lend itself well into the byte[] oriented codec framework. Complete the codec once the steamable codec
 * framework is ready. The motivation behind providing the codec in a partial form is that it can already come in handy
 * for those applications that do not require quoted-printable line formatting (rules #3, #4, #5), for instance Q codec.
 * </p>
 * 
 * @see <a href="http://www.ietf.org/rfc/rfc1521.txt"> RFC 1521 MIME (Multipurpose Internet Mail Extensions) Part One:
 *          Mechanisms for Specifying and Describing the Format of Internet Message Bodies </a>
 * 
 * @author Apache Software Foundation
 * @since 1.3
 * @version $Id: QuotedPrintableCodec.java,v 1.7 2004/04/09 22:21:07 ggregory Exp $
 */
public class QuotedPrintableCodec implements BinaryEncoder, BinaryDecoder, StringEncoder, StringDecoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.215 -0400", hash_original_field = "B538E050E7CF37DDE201F82E2869F092", hash_generated_field = "987BFFE776F2B10AD949126DE45EB951")

    private static final BitSet PRINTABLE_CHARS = new BitSet(256);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.216 -0400", hash_original_field = "9A5FA930163BA6827CCBEB566236A1B6", hash_generated_field = "A67C945472C940C7E548E856A1863A26")


    private static byte ESCAPE_CHAR = '=';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.216 -0400", hash_original_field = "D31A31CCB9EC88D9DD1152FCCDE62D4C", hash_generated_field = "170CAA9AA326A7EF806BC45F1343CAAB")


    private static byte TAB = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.217 -0400", hash_original_field = "F4E34F27553B9548BDF3E005A978F661", hash_generated_field = "48B871438C6A8297E3D632B070E2250A")


    private static byte SPACE = 32;

    /**
     * Encodes byte into its quoted-printable representation.
     * 
     * @param b
     *                  byte to encode
     * @param buffer
     *                  the buffer to write to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.219 -0400", hash_original_method = "98AAAE75DDCE3D3FA7591EC8A79E16D2", hash_generated_method = "18DFDEC2953587CABA458423618AA224")
    
private static final void encodeQuotedPrintable(int b, ByteArrayOutputStream buffer) {
        buffer.write(ESCAPE_CHAR);
        char hex1 = Character.toUpperCase(Character.forDigit((b >> 4) & 0xF, 16));
        char hex2 = Character.toUpperCase(Character.forDigit(b & 0xF, 16));
        buffer.write(hex1);
        buffer.write(hex2);
    }
    // Static initializer for printable chars collection
    static {
        // alpha characters
        for (int i = 33; i <= 60; i++) {
            PRINTABLE_CHARS.set(i);
        }
        for (int i = 62; i <= 126; i++) {
            PRINTABLE_CHARS.set(i);
        }
        PRINTABLE_CHARS.set(TAB);
        PRINTABLE_CHARS.set(SPACE);
    }

    /**
     * Encodes an array of bytes into an array of quoted-printable 7-bit characters. Unsafe characters are escaped.
     * 
     * <p>
     * This function implements a subset of quoted-printable encoding specification (rule #1 and rule #2) as defined in
     * RFC 1521 and is suitable for encoding binary data and unformatted text.
     * </p>
     * 
     * @param printable
     *                  bitset of characters deemed quoted-printable
     * @param bytes
     *                  array of bytes to be encoded
     * @return array of bytes containing quoted-printable data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.219 -0400", hash_original_method = "84986DC2D90959660B24E731A37BB035", hash_generated_method = "AF9F4D06DF2CA58C0A0386A10094685E")
    
public static final byte[] encodeQuotedPrintable(BitSet printable, byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        if (printable == null) {
            printable = PRINTABLE_CHARS;
        }
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        for (int i = 0; i < bytes.length; i++) {
            int b = bytes[i];
            if (b < 0) {
                b = 256 + b;
            }
            if (printable.get(b)) {
                buffer.write(b);
            } else {
                encodeQuotedPrintable(b, buffer);
            }
        }
        return buffer.toByteArray();
    }

    /**
     * Decodes an array quoted-printable characters into an array of original bytes. Escaped characters are converted
     * back to their original representation.
     * 
     * <p>
     * This function implements a subset of quoted-printable encoding specification (rule #1 and rule #2) as defined in
     * RFC 1521.
     * </p>
     * 
     * @param bytes
     *                  array of quoted-printable characters
     * @return array of original bytes
     * @throws DecoderException
     *                  Thrown if quoted-printable decoding is unsuccessful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.220 -0400", hash_original_method = "A41E02D575B1C0C7B40A96A2209ED20C", hash_generated_method = "94856C096084B62D0C927E4FAE3932FE")
    
public static final byte[] decodeQuotedPrintable(byte[] bytes) throws DecoderException {
        if (bytes == null) {
            return null;
        }
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        for (int i = 0; i < bytes.length; i++) {
            int b = bytes[i];
            if (b == ESCAPE_CHAR) {
                try {
                    int u = Character.digit((char) bytes[++i], 16);
                    int l = Character.digit((char) bytes[++i], 16);
                    if (u == -1 || l == -1) {
                        throw new DecoderException("Invalid quoted-printable encoding");
                    }
                    buffer.write((char) ((u << 4) + l));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DecoderException("Invalid quoted-printable encoding");
                }
            } else {
                buffer.write(b);
            }
        }
        return buffer.toByteArray();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.214 -0400", hash_original_field = "B1CB9DCBF2CC34A785844A4F8D009195", hash_generated_field = "8F782543AC8CA9041E32C533975E885D")

    private String charset = StringEncodings.UTF8;

    /**
     * Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.217 -0400", hash_original_method = "5D160F4AF599D1E99888D9EA5DD32C84", hash_generated_method = "A8B0F0378CCF7C4C011CA1D1FFCFD8C6")
    
public QuotedPrintableCodec() {
        super();
    }

    /**
     * Constructor which allows for the selection of a default charset
     * 
     * @param charset
     *                  the default string charset to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.218 -0400", hash_original_method = "EDCA537E34639F92A48511A9FB782DD1", hash_generated_method = "B98928E46947343A8257B6D2B27EB9FD")
    
public QuotedPrintableCodec(String charset) {
        super();
        this.charset = charset;
    }

    /**
     * Encodes an array of bytes into an array of quoted-printable 7-bit characters. Unsafe characters are escaped.
     * 
     * <p>
     * This function implements a subset of quoted-printable encoding specification (rule #1 and rule #2) as defined in
     * RFC 1521 and is suitable for encoding binary data and unformatted text.
     * </p>
     * 
     * @param bytes
     *                  array of bytes to be encoded
     * @return array of bytes containing quoted-printable data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.221 -0400", hash_original_method = "1A7FE62B9009FCF7C5788DAE3284B8C2", hash_generated_method = "685C73591268352675F49EAA0A1B1056")
    
public byte[] encode(byte[] bytes) {
        return encodeQuotedPrintable(PRINTABLE_CHARS, bytes);
    }

    /**
     * Decodes an array of quoted-printable characters into an array of original bytes. Escaped characters are converted
     * back to their original representation.
     * 
     * <p>
     * This function implements a subset of quoted-printable encoding specification (rule #1 and rule #2) as defined in
     * RFC 1521.
     * </p>
     * 
     * @param bytes
     *                  array of quoted-printable characters
     * @return array of original bytes
     * @throws DecoderException
     *                  Thrown if quoted-printable decoding is unsuccessful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.221 -0400", hash_original_method = "0934641DA89F31AC7E4DAD11F960B852", hash_generated_method = "8B3F1A07247871C2D47EB27B91F628C4")
    
public byte[] decode(byte[] bytes) throws DecoderException {
        return decodeQuotedPrintable(bytes);
    }

    /**
     * Encodes a string into its quoted-printable form using the default string charset. Unsafe characters are escaped.
     * 
     * <p>
     * This function implements a subset of quoted-printable encoding specification (rule #1 and rule #2) as defined in
     * RFC 1521 and is suitable for encoding binary data.
     * </p>
     * 
     * @param pString
     *                  string to convert to quoted-printable form
     * @return quoted-printable string
     * 
     * @throws EncoderException
     *                  Thrown if quoted-printable encoding is unsuccessful
     * 
     * @see #getDefaultCharset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.222 -0400", hash_original_method = "87E4447E26C3107C6DF2678BD461EF96", hash_generated_method = "B0D9B1E23058F28E118D0AED26ABE5C9")
    
public String encode(String pString) throws EncoderException {
        if (pString == null) {
            return null;
        }
        try {
            return encode(pString, getDefaultCharset());
        } catch (UnsupportedEncodingException e) {
            throw new EncoderException(e.getMessage());
        }
    }

    /**
     * Decodes a quoted-printable string into its original form using the specified string charset. Escaped characters
     * are converted back to their original representation.
     * 
     * @param pString
     *                  quoted-printable string to convert into its original form
     * @param charset
     *                  the original string charset
     * @return original string
     * @throws DecoderException
     *                  Thrown if quoted-printable decoding is unsuccessful
     * @throws UnsupportedEncodingException
     *                  Thrown if charset is not supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.223 -0400", hash_original_method = "F3793FD3E2505AD035424F13E8FC4E3E", hash_generated_method = "A58E4C50621A1951F80865295014D02B")
    
public String decode(String pString, String charset) throws DecoderException, UnsupportedEncodingException {
        if (pString == null) {
            return null;
        }
        return new String(decode(pString.getBytes(StringEncodings.US_ASCII)), charset);
    }

    /**
     * Decodes a quoted-printable string into its original form using the default string charset. Escaped characters are
     * converted back to their original representation.
     * 
     * @param pString
     *                  quoted-printable string to convert into its original form
     * @return original string
     * @throws DecoderException
     *                  Thrown if quoted-printable decoding is unsuccessful
     * @throws UnsupportedEncodingException
     *                  Thrown if charset is not supported
     * @see #getDefaultCharset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.223 -0400", hash_original_method = "8C409C50276DC5FFF073C17593B975AC", hash_generated_method = "253D44827C6A185BCD712DA99FC5ECAC")
    
public String decode(String pString) throws DecoderException {
        if (pString == null) {
            return null;
        }
        try {
            return decode(pString, getDefaultCharset());
        } catch (UnsupportedEncodingException e) {
            throw new DecoderException(e.getMessage());
        }
    }

    /**
     * Encodes an object into its quoted-printable safe form. Unsafe characters are escaped.
     * 
     * @param pObject
     *                  string to convert to a quoted-printable form
     * @return quoted-printable object
     * @throws EncoderException
     *                  Thrown if quoted-printable encoding is not applicable to objects of this type or if encoding is
     *                  unsuccessful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.224 -0400", hash_original_method = "EFCF335DDCF1382916955B39D3B5FAD3", hash_generated_method = "6322580611D29DA1285271BC29701D8D")
    
public Object encode(Object pObject) throws EncoderException {
        if (pObject == null) {
            return null;
        } else if (pObject instanceof byte[]) {
            return encode((byte[]) pObject);
        } else if (pObject instanceof String) {
            return encode((String) pObject);
        } else {
            throw new EncoderException("Objects of type "
                + pObject.getClass().getName()
                + " cannot be quoted-printable encoded");
        }
    }

    /**
     * Decodes a quoted-printable object into its original form. Escaped characters are converted back to their original
     * representation.
     * 
     * @param pObject
     *                  quoted-printable object to convert into its original form
     * @return original object
     * @throws DecoderException
     *                  Thrown if quoted-printable decoding is not applicable to objects of this type if decoding is
     *                  unsuccessful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.225 -0400", hash_original_method = "1DD02F40CB7ADA84392EE8D645EFC005", hash_generated_method = "0FD44489DB9880A52C6AC4F3545F2D1E")
    
public Object decode(Object pObject) throws DecoderException {
        if (pObject == null) {
            return null;
        } else if (pObject instanceof byte[]) {
            return decode((byte[]) pObject);
        } else if (pObject instanceof String) {
            return decode((String) pObject);
        } else {
            throw new DecoderException("Objects of type "
                + pObject.getClass().getName()
                + " cannot be quoted-printable decoded");
        }
    }

    /**
     * Returns the default charset used for string decoding and encoding.
     * 
     * @return the default string charset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.225 -0400", hash_original_method = "BBEE24F22F047B14B05EB2D9AC64A64D", hash_generated_method = "41115F037B14D5BF809A57FFDF9E0425")
    
public String getDefaultCharset() {
        return this.charset;
    }

    /**
     * Encodes a string into its quoted-printable form using the specified charset. Unsafe characters are escaped.
     * 
     * <p>
     * This function implements a subset of quoted-printable encoding specification (rule #1 and rule #2) as defined in
     * RFC 1521 and is suitable for encoding binary data and unformatted text.
     * </p>
     * 
     * @param pString
     *                  string to convert to quoted-printable form
     * @param charset
     *                  the charset for pString
     * @return quoted-printable string
     * 
     * @throws UnsupportedEncodingException
     *                  Thrown if the charset is not supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.226 -0400", hash_original_method = "385A210A4F53DD068AEE801B7B136BBE", hash_generated_method = "0815FCBC3E537BB3192BE42996501FD5")
    
public String encode(String pString, String charset) throws UnsupportedEncodingException {
        if (pString == null) {
            return null;
        }
        return new String(encode(pString.getBytes(charset)), StringEncodings.US_ASCII);
    }
}

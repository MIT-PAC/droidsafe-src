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
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/**
 * <p>
 * Implements methods common to all codecs defined in RFC 1522.
 * </p>
 * 
 * <p>
 * <a href="http://www.ietf.org/rfc/rfc1522.txt">RFC 1522</a> 
 * describes techniques to allow the encoding of non-ASCII text in 
 * various portions of a RFC 822 [2] message header, in a manner which
 * is unlikely to confuse existing message handling software.
 * </p>

 * @see <a href="http://www.ietf.org/rfc/rfc1522.txt">
 * MIME (Multipurpose Internet Mail Extensions) Part Two:
 * Message Header Extensions for Non-ASCII Text</a>
 * </p>
 * 
 * @author Apache Software Foundation
 * @since 1.3
 * @version $Id: RFC1522Codec.java,v 1.2 2004/04/09 22:21:43 ggregory Exp $
 */
abstract class RFC1522Codec {
    
    /**
     * Applies an RFC 1522 compliant encoding scheme to the given string of text with the 
     * given charset. This method constructs the "encoded-word" header common to all the 
     * RFC 1522 codecs and then invokes {@link #doEncoding(byte [])} method of a concrete 
     * class to perform the specific enconding.
     * 
     * @param text a string to encode
     * @param charset a charset to be used
     * 
     * @return RFC 1522 compliant "encoded-word"
     * 
     * @throws EncoderException thrown if there is an error conidition during the Encoding 
     *  process.
     * @throws UnsupportedEncodingException thrown if charset is not supported 
     * 
     * @see <a href="http://java.sun.com/j2se/1.3/docs/api/java/lang/package-summary.html#charenc">JRE character
     *          encoding names</a>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.321 -0400", hash_original_method = "00FAF8953862632630D9A6F8E97BB3CD", hash_generated_method = "DD900E84F69FF4D34DA6946AB361F5F5")
    
protected String encodeText(final String text, final String charset)
     throws EncoderException, UnsupportedEncodingException  
    {
        if (text == null) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("=?"); 
        buffer.append(charset); 
        buffer.append('?'); 
        buffer.append(getEncoding()); 
        buffer.append('?');
        byte [] rawdata = doEncoding(text.getBytes(charset)); 
        buffer.append(new String(rawdata, StringEncodings.US_ASCII));
        buffer.append("?="); 
        return buffer.toString();
    }
    
    /**
     * Applies an RFC 1522 compliant decoding scheme to the given string of text. This method 
     * processes the "encoded-word" header common to all the RFC 1522 codecs and then invokes 
     * {@link #doEncoding(byte [])} method of a concrete class to perform the specific deconding.
     * 
     * @param text a string to decode
     * 
     * @throws DecoderException thrown if there is an error conidition during the Decoding 
     *  process.
     * @throws UnsupportedEncodingException thrown if charset specified in the "encoded-word" 
     *  header is not supported 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.322 -0400", hash_original_method = "B7BD889FD4658A0008E72FB411D8CA64", hash_generated_method = "CB727E0D8B8BF8116D1017AB7C92104B")
    
protected String decodeText(final String text)
     throws DecoderException, UnsupportedEncodingException  
    {
        if (text == null) {
            return null;
        }
        if ((!text.startsWith("=?")) || (!text.endsWith("?="))) {
            throw new DecoderException("RFC 1522 violation: malformed encoded content");
        }
        int termnator = text.length() - 2;
        int from = 2;
        int to = text.indexOf("?", from);
        if ((to == -1) || (to == termnator)) {
            throw new DecoderException("RFC 1522 violation: charset token not found");
        }
        String charset = text.substring(from, to);
        if (charset.equals("")) {
            throw new DecoderException("RFC 1522 violation: charset not specified");
        }
        from = to + 1;
        to = text.indexOf("?", from);
        if ((to == -1) || (to == termnator)) {
            throw new DecoderException("RFC 1522 violation: encoding token not found");
        }
        String encoding = text.substring(from, to);
        if (!getEncoding().equalsIgnoreCase(encoding)) {
            throw new DecoderException("This codec cannot decode " + 
                encoding + " encoded content");
        }
        from = to + 1;
        to = text.indexOf("?", from);
        byte[] data = text.substring(from, to).getBytes(StringEncodings.US_ASCII);
        data = doDecoding(data); 
        return new String(data, charset);
    }

    /**
     * Returns the codec name (referred to as encoding in the RFC 1522)
     * 
     * @return name of the codec
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.323 -0400", hash_original_method = "2D33BECAED94113132CEB482F2BFD407", hash_generated_method = "EF52425A4A8F98A51AB99235257DBF82")
    
protected abstract String getEncoding();

    /**
     * Encodes an array of bytes using the defined encoding scheme
     * 
     * @param bytes Data to be encoded
     *
     * @return A byte array containing the encoded data
     * 
     * @throws EncoderException thrown if the Encoder encounters a failure condition 
     *  during the encoding process.
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.323 -0400", hash_original_method = "24ABC15B4A8032FE22C42A9FEAA52972", hash_generated_method = "8350B5D79E259D9D2697F32A59F64DC5")
    
protected abstract byte[] doEncoding(byte[] bytes) throws EncoderException;

    /**
     * Decodes an array of bytes using the defined encoding scheme
     * 
     * @param bytes Data to be decoded
     *
     * @return a byte array that contains decoded data
     * 
     * @throws DecoderException A decoder exception is thrown if a Decoder encounters a 
     *  failure condition during the decode process.
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.324 -0400", hash_original_method = "CB80F75CD8454EDD7706F90FD4053B72", hash_generated_method = "80B4E65A531C6C8A430251F4BD8E7108")
    
protected abstract byte[] doDecoding(byte[] bytes) throws DecoderException;
}

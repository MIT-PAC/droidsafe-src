/*
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

package org.apache.commons.codec.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;

/**
 * <p>
 * Identical to the Base64 encoding defined by <a href="http://www.ietf.org/rfc/rfc1521.txt">RFC
 * 1521</a> and allows a character set to be specified.
 * </p>
 * 
 * <p>
 * <a href="http://www.ietf.org/rfc/rfc1522.txt">RFC 1522</a> describes techniques to allow the encoding of non-ASCII
 * text in various portions of a RFC 822 [2] message header, in a manner which is unlikely to confuse existing message
 * handling software.
 * </p>
 * 
 * @see <a href="http://www.ietf.org/rfc/rfc1522.txt">MIME (Multipurpose Internet Mail Extensions) Part Two: Message
 *          Header Extensions for Non-ASCII Text</a>
 * 
 * @author Apache Software Foundation
 * @since 1.3
 * @version $Id: BCodec.java,v 1.5 2004/04/13 22:46:37 ggregory Exp $
 */
public class BCodec extends RFC1522Codec implements StringEncoder, StringDecoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.274 -0400", hash_original_field = "B1CB9DCBF2CC34A785844A4F8D009195", hash_generated_field = "8F782543AC8CA9041E32C533975E885D")

    private String charset = StringEncodings.UTF8;

    /**
     * Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.275 -0400", hash_original_method = "E1C0BC57FE2A230614DDC8F27AB43A3C", hash_generated_method = "97E420491B9F9445CA623D8A951138F8")
    
public BCodec() {
        super();
    }

    /**
     * Constructor which allows for the selection of a default charset
     * 
     * @param charset
     *                  the default string charset to use.
     * 
     * @see <a href="http://java.sun.com/j2se/1.3/docs/api/java/lang/package-summary.html#charenc">JRE character
     *          encoding names</a>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.275 -0400", hash_original_method = "816653319B6BAD20F61F58A50D2F92A2", hash_generated_method = "698227267BEBCEE2640F85F41C84EAD9")
    
public BCodec(final String charset) {
        super();
        this.charset = charset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.276 -0400", hash_original_method = "9B7E3FF10F38F0C4D6EF616EEBF123C6", hash_generated_method = "64D6CB8CFD661263D89845DB4D7CD984")
    
protected String getEncoding() {
        return "B";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.276 -0400", hash_original_method = "8798F37486EC64E26DE084FEEB1A9D77", hash_generated_method = "5BB684336B0CE76792A3FC3AE9E6948A")
    
protected byte[] doEncoding(byte[] bytes) throws EncoderException {
        if (bytes == null) {
            return null;
        }
        return Base64.encodeBase64(bytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.277 -0400", hash_original_method = "8211B72AFA041F97002C694564F275E0", hash_generated_method = "FF6D7A79CFD6E178342E123B212EEBF5")
    
protected byte[] doDecoding(byte[] bytes) throws DecoderException {
        if (bytes == null) {
            return null;
        }
        return Base64.decodeBase64(bytes);
    }

    /**
     * Encodes a string into its Base64 form using the specified charset. Unsafe characters are escaped.
     * 
     * @param value
     *                  string to convert to Base64 form
     * @param charset
     *                  the charset for pString
     * @return Base64 string
     * 
     * @throws EncoderException
     *                  thrown if a failure condition is encountered during the encoding process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.278 -0400", hash_original_method = "A7230128DD423D1B7536E07303DF6D4F", hash_generated_method = "56FBE1220EA5B4DB0310C2F49525E0FB")
    
public String encode(final String value, final String charset) throws EncoderException {
        if (value == null) {
            return null;
        }
        try {
            return encodeText(value, charset);
        } catch (UnsupportedEncodingException e) {
            throw new EncoderException(e.getMessage());
        }
    }

    /**
     * Encodes a string into its Base64 form using the default charset. Unsafe characters are escaped.
     * 
     * @param value
     *                  string to convert to Base64 form
     * @return Base64 string
     * 
     * @throws EncoderException
     *                  thrown if a failure condition is encountered during the encoding process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.278 -0400", hash_original_method = "5EB8E94EADAFBCF57E85D04CE454DC2B", hash_generated_method = "5B6A2C96854362656679742F272D83FF")
    
public String encode(String value) throws EncoderException {
        if (value == null) {
            return null;
        }
        return encode(value, getDefaultCharset());
    }

    /**
     * Decodes a Base64 string into its original form. Escaped characters are converted back to their original
     * representation.
     * 
     * @param value
     *                  Base64 string to convert into its original form
     * 
     * @return original string
     * 
     * @throws DecoderException
     *                  A decoder exception is thrown if a failure condition is encountered during the decode process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.279 -0400", hash_original_method = "0064360AB1AB3F05FE92D2335A446B5F", hash_generated_method = "26CD8A537B8C09100AF720689779985A")
    
public String decode(String value) throws DecoderException {
        if (value == null) {
            return null;
        }
        try {
            return decodeText(value);
        } catch (UnsupportedEncodingException e) {
            throw new DecoderException(e.getMessage());
        }
    }

    /**
     * Encodes an object into its Base64 form using the default charset. Unsafe characters are escaped.
     * 
     * @param value
     *                  object to convert to Base64 form
     * @return Base64 object
     * 
     * @throws EncoderException
     *                  thrown if a failure condition is encountered during the encoding process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.279 -0400", hash_original_method = "A294BF825FE516E958C00EDA16E1C69E", hash_generated_method = "6AD7317BC080EB6E3AE796A7D15C25B1")
    
public Object encode(Object value) throws EncoderException {
        if (value == null) {
            return null;
        } else if (value instanceof String) {
            return encode((String) value);
        } else {
            throw new EncoderException("Objects of type "
                + value.getClass().getName()
                + " cannot be encoded using BCodec");
        }
    }

    /**
     * Decodes a Base64 object into its original form. Escaped characters are converted back to their original
     * representation.
     * 
     * @param value
     *                  Base64 object to convert into its original form
     * 
     * @return original object
     * 
     * @throws DecoderException
     *                  A decoder exception is thrown if a failure condition is encountered during the decode process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.280 -0400", hash_original_method = "574797F39018366831514608E69BEACB", hash_generated_method = "B94C66F614EA50AE15AEF08D9A856E97")
    
public Object decode(Object value) throws DecoderException {
        if (value == null) {
            return null;
        } else if (value instanceof String) {
            return decode((String) value);
        } else {
            throw new DecoderException("Objects of type "
                + value.getClass().getName()
                + " cannot be decoded using BCodec");
        }
    }

    /**
     * The default charset used for string decoding and encoding.
     * 
     * @return the default string charset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.281 -0400", hash_original_method = "BBEE24F22F047B14B05EB2D9AC64A64D", hash_generated_method = "41115F037B14D5BF809A57FFDF9E0425")
    
public String getDefaultCharset() {
        return this.charset;
    }
}

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
import java.util.BitSet;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

/**
 * <p>
 * Similar to the Quoted-Printable content-transfer-encoding defined in <a
 * href="http://www.ietf.org/rfc/rfc1521.txt">RFC 1521</a> and designed to allow text containing mostly ASCII
 * characters to be decipherable on an ASCII terminal without decoding.
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
 * @version $Id: QCodec.java,v 1.6 2004/05/24 00:24:32 ggregory Exp $
 */
public class QCodec extends RFC1522Codec implements StringEncoder, StringDecoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.137 -0400", hash_original_field = "B538E050E7CF37DDE201F82E2869F092", hash_generated_field = "987BFFE776F2B10AD949126DE45EB951")

    private static final BitSet PRINTABLE_CHARS = new BitSet(256);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.137 -0400", hash_original_field = "FE9725B7C919902B8DDECAC3F3A57B42", hash_generated_field = "EE9C7F0CC58A7D1FD395C55BAB0F6093")


    private static byte BLANK = 32;
    // Static initializer for printable chars collection
    static {
        // alpha characters
        PRINTABLE_CHARS.set(' ');
        PRINTABLE_CHARS.set('!');
        PRINTABLE_CHARS.set('"');
        PRINTABLE_CHARS.set('#');
        PRINTABLE_CHARS.set('$');
        PRINTABLE_CHARS.set('%');
        PRINTABLE_CHARS.set('&');
        PRINTABLE_CHARS.set('\'');
        PRINTABLE_CHARS.set('(');
        PRINTABLE_CHARS.set(')');
        PRINTABLE_CHARS.set('*');
        PRINTABLE_CHARS.set('+');
        PRINTABLE_CHARS.set(',');
        PRINTABLE_CHARS.set('-');
        PRINTABLE_CHARS.set('.');
        PRINTABLE_CHARS.set('/');
        for (int i = '0'; i <= '9'; i++) {
            PRINTABLE_CHARS.set(i);
        }
        PRINTABLE_CHARS.set(':');
        PRINTABLE_CHARS.set(';');
        PRINTABLE_CHARS.set('<');
        PRINTABLE_CHARS.set('>');
        PRINTABLE_CHARS.set('@');
        for (int i = 'A'; i <= 'Z'; i++) {
            PRINTABLE_CHARS.set(i);
        }
        PRINTABLE_CHARS.set('[');
        PRINTABLE_CHARS.set('\\');
        PRINTABLE_CHARS.set(']');
        PRINTABLE_CHARS.set('^');
        PRINTABLE_CHARS.set('`');
        for (int i = 'a'; i <= 'z'; i++) {
            PRINTABLE_CHARS.set(i);
        }
        PRINTABLE_CHARS.set('{');
        PRINTABLE_CHARS.set('|');
        PRINTABLE_CHARS.set('}');
        PRINTABLE_CHARS.set('~');
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.138 -0400", hash_original_field = "B316A9184E5EA22AF8A680D6D29CEC88", hash_generated_field = "207B8030BE537B7E2CE0E80C727DCA06")


    private static byte UNDERSCORE = 95;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.136 -0400", hash_original_field = "B1CB9DCBF2CC34A785844A4F8D009195", hash_generated_field = "8F782543AC8CA9041E32C533975E885D")

    private String charset = StringEncodings.UTF8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.138 -0400", hash_original_field = "AF8A2E4281299689437A5F32F7F538E4", hash_generated_field = "CCFD8446D97D73E23C7AA39498D36FE8")


    private boolean encodeBlanks = false;

    /**
     * Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.139 -0400", hash_original_method = "B9CB07249F1C4748331DE6A78B60A9F8", hash_generated_method = "8AA01CA02F7AD5BE4A39511BAF348E10")
    
public QCodec() {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.139 -0400", hash_original_method = "477C8B25236DBDF98FB3B01560041BE6", hash_generated_method = "CB12EE05EAEF938792E382BBEE4D8908")
    
public QCodec(final String charset) {
        super();
        this.charset = charset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.140 -0400", hash_original_method = "61D2212898950CA27F2E3A734EF53003", hash_generated_method = "8E0F3111B8A4A97BA76456F5D3EA1D8C")
    
protected String getEncoding() {
        return "Q";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.140 -0400", hash_original_method = "D8B295394BDD4E66503A301194A34B4E", hash_generated_method = "8E8409762088825729B6B87A765FFA6F")
    
protected byte[] doEncoding(byte[] bytes) throws EncoderException {
        if (bytes == null) {
            return null;
        }
        byte[] data = QuotedPrintableCodec.encodeQuotedPrintable(PRINTABLE_CHARS, bytes);
        if (this.encodeBlanks) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == BLANK) {
                    data[i] = UNDERSCORE;
                }
            }
        }
        return data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.142 -0400", hash_original_method = "552C474E244B3B7D91F7DBF9FED3B63F", hash_generated_method = "A3146A3D8E97545AA9F4BED21E12A64B")
    
protected byte[] doDecoding(byte[] bytes) throws DecoderException {
        if (bytes == null) {
            return null;
        }
        boolean hasUnderscores = false;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == UNDERSCORE) {
                hasUnderscores = true;
                break;
            }
        }
        if (hasUnderscores) {
            byte[] tmp = new byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                if (b != UNDERSCORE) {
                    tmp[i] = b;
                } else {
                    tmp[i] = BLANK;
                }
            }
            return QuotedPrintableCodec.decodeQuotedPrintable(tmp);
        } 
        return QuotedPrintableCodec.decodeQuotedPrintable(bytes);       
    }

    /**
     * Encodes a string into its quoted-printable form using the specified charset. Unsafe characters are escaped.
     * 
     * @param pString
     *                  string to convert to quoted-printable form
     * @param charset
     *                  the charset for pString
     * @return quoted-printable string
     * 
     * @throws EncoderException
     *                  thrown if a failure condition is encountered during the encoding process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.142 -0400", hash_original_method = "0DCCCF3C7FBF5B5E529AA17B2A2FB2B1", hash_generated_method = "534FCB1961D01B4C57FC4404D13D9CF4")
    
public String encode(final String pString, final String charset) throws EncoderException {
        if (pString == null) {
            return null;
        }
        try {
            return encodeText(pString, charset);
        } catch (UnsupportedEncodingException e) {
            throw new EncoderException(e.getMessage());
        }
    }

    /**
     * Encodes a string into its quoted-printable form using the default charset. Unsafe characters are escaped.
     * 
     * @param pString
     *                  string to convert to quoted-printable form
     * @return quoted-printable string
     * 
     * @throws EncoderException
     *                  thrown if a failure condition is encountered during the encoding process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.143 -0400", hash_original_method = "9FB5BB21D34461FAB25EC78F8089DE3A", hash_generated_method = "FCFF3DCBB5A560D1D977DF31C3E3BDD7")
    
public String encode(String pString) throws EncoderException {
        if (pString == null) {
            return null;
        }
        return encode(pString, getDefaultCharset());
    }

    /**
     * Decodes a quoted-printable string into its original form. Escaped characters are converted back to their original
     * representation.
     * 
     * @param pString
     *                  quoted-printable string to convert into its original form
     * 
     * @return original string
     * 
     * @throws DecoderException
     *                  A decoder exception is thrown if a failure condition is encountered during the decode process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.143 -0400", hash_original_method = "31D7AE397CFF252A33936405586C7B59", hash_generated_method = "57535DE803B1480D862171A96E69BC63")
    
public String decode(String pString) throws DecoderException {
        if (pString == null) {
            return null;
        }
        try {
            return decodeText(pString);
        } catch (UnsupportedEncodingException e) {
            throw new DecoderException(e.getMessage());
        }
    }

    /**
     * Encodes an object into its quoted-printable form using the default charset. Unsafe characters are escaped.
     * 
     * @param pObject
     *                  object to convert to quoted-printable form
     * @return quoted-printable object
     * 
     * @throws EncoderException
     *                  thrown if a failure condition is encountered during the encoding process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.144 -0400", hash_original_method = "3697643F129B92B3621F4F9C1EF1C970", hash_generated_method = "2049645E4F8B42379BB79B89F9701548")
    
public Object encode(Object pObject) throws EncoderException {
        if (pObject == null) {
            return null;
        } else if (pObject instanceof String) {
            return encode((String) pObject);
        } else {
            throw new EncoderException("Objects of type "
                + pObject.getClass().getName()
                + " cannot be encoded using Q codec");
        }
    }

    /**
     * Decodes a quoted-printable object into its original form. Escaped characters are converted back to their original
     * representation.
     * 
     * @param pObject
     *                  quoted-printable object to convert into its original form
     * 
     * @return original object
     * 
     * @throws DecoderException
     *                  A decoder exception is thrown if a failure condition is encountered during the decode process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.145 -0400", hash_original_method = "592837949A664839EE3E21CA118C3F99", hash_generated_method = "6C7D62B76C1F1170CAD1C14CE1FC488B")
    
public Object decode(Object pObject) throws DecoderException {
        if (pObject == null) {
            return null;
        } else if (pObject instanceof String) {
            return decode((String) pObject);
        } else {
            throw new DecoderException("Objects of type "
                + pObject.getClass().getName()
                + " cannot be decoded using Q codec");
        }
    }

    /**
     * The default charset used for string decoding and encoding.
     * 
     * @return the default string charset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.145 -0400", hash_original_method = "BBEE24F22F047B14B05EB2D9AC64A64D", hash_generated_method = "41115F037B14D5BF809A57FFDF9E0425")
    
public String getDefaultCharset() {
        return this.charset;
    }

    /**
     * Tests if optional tranformation of SPACE characters is to be used
     * 
     * @return <code>true</code> if SPACE characters are to be transformed, <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.146 -0400", hash_original_method = "8A4B58739FD03C96102234AFF51BEC4F", hash_generated_method = "EB32B3C16C086F091A98B7A73942B15F")
    
public boolean isEncodeBlanks() {
        return this.encodeBlanks;
    }

    /**
     * Defines whether optional tranformation of SPACE characters is to be used
     * 
     * @param b
     *                  <code>true</code> if SPACE characters are to be transformed, <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.146 -0400", hash_original_method = "497FD2C415F405001209FC4E0D69B3C6", hash_generated_method = "3143ED3CF4280C552444F2BA691081A6")
    
public void setEncodeBlanks(boolean b) {
        this.encodeBlanks = b;
    }
}

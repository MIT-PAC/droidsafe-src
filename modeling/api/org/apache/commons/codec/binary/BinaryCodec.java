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

package org.apache.commons.codec.binary;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/**
 * Translates between byte arrays and strings of "0"s and "1"s.
 * 
 * <b>TODO:</b> may want to add more bit vector functions like and/or/xor/nand.
 * <B>TODO:</b> also might be good to generate boolean[]
 * from byte[] et. cetera.
 * 
 * @author Apache Software Foundation
 * @since 1.3
 * @version $Id $
 */
public class BinaryCodec implements BinaryDecoder, BinaryEncoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.447 -0500", hash_original_field = "5A0A95E1727041088D2B08ACC90DF90E", hash_generated_field = "38C669B5348863810FFA06248C9493E1")

    /** Empty char array. */
    private static final char[] EMPTY_CHAR_ARRAY = new char[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.459 -0500", hash_original_field = "45FA37ADE7AEBE752F3BB76FB60A0A5D", hash_generated_field = "23CD3BB989FCF974E9040053987FEC76")

    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.468 -0500", hash_original_field = "95B639C83BA14F5AA119F351E5A45DD8", hash_generated_field = "F4140A697267558F3E33F1E19A22DAFF")

    private static final int BIT_0 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.477 -0500", hash_original_field = "707188903DD4A4CD0AC1E548A2052B02", hash_generated_field = "6BC9605A28292ABBA220ADE153E18FD1")

    private static final int BIT_1 = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.486 -0500", hash_original_field = "030D5B35A0C23A9BB10B13776559D078", hash_generated_field = "163F0AB330F56E154A9E3E4513743BB0")

    private static final int BIT_2 = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.507 -0500", hash_original_field = "F9BA053D8C03335F0C8209BDB76405DE", hash_generated_field = "F8158AC5414638357002CEDA775627D2")

    private static final int BIT_3 = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.516 -0500", hash_original_field = "1318B075D5D87F9E738EBA6F342EC3BE", hash_generated_field = "004BD6751AA2FCF0C313F6F83AF836FE")

    private static final int BIT_4 = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.525 -0500", hash_original_field = "C08F5CBA1E3333C04C9BD93F154B6221", hash_generated_field = "B3C12967DA6830948EB06026550C7B2A")

    private static final int BIT_5 = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.534 -0500", hash_original_field = "A2C833336E9ADF6084237DBB2C4A6459", hash_generated_field = "7A2DB0B0FC474601A1B87542E58120F7")

    private static final int BIT_6 = 0x40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.544 -0500", hash_original_field = "76072722D204DE8CDF5FB6455EA6F0C6", hash_generated_field = "E6D9B57E96C0918F9C10F61978C85981")

    private static final int BIT_7 = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.557 -0500", hash_original_field = "C80CAA6623A89899DBB5EE4B8CB704A9", hash_generated_field = "3C05DBA22BC10D57994B54FB8C1D0CA4")


    private static final int[] BITS = {BIT_0, BIT_1, BIT_2, BIT_3, BIT_4, BIT_5, BIT_6, BIT_7};

    // ------------------------------------------------------------------------
    //
    // static codec operations
    //
    // ------------------------------------------------------------------------
    /**
     * Decodes a byte array where each char represents an ascii '0' or '1'.
     * 
     * @param ascii
     *                  each char represents an ascii '0' or '1'
     * @return the raw encoded binary where each bit corresponds to a char in the char array argument
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.620 -0500", hash_original_method = "74CDAF19D7204E21B78486A9CDDF7726", hash_generated_method = "B407B1FB660427FED29AFAF67686F012")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public static byte[] fromAscii(char[] ascii) {
        if (ascii == null || ascii.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        // get length/8 times bytes with 3 bit shifts to the right of the length
        byte[] l_raw = new byte[ascii.length >> 3];
        /*
         * We decr index jj by 8 as we go along to not recompute indices using multiplication every time inside the
         * loop.
         */
        for (int ii = 0, jj = ascii.length - 1; ii < l_raw.length; ii++, jj -= 8) {
            for (int bits = 0; bits < BITS.length; ++bits) {
                if (ascii[jj - bits] == '1') {
                    l_raw[ii] |= BITS[bits];
                }
            }
        }
        return l_raw;
    }

    /**
     * Decodes a byte array where each byte represents an ascii '0' or '1'.
     * 
     * @param ascii
     *                  each byte represents an ascii '0' or '1'
     * @return the raw encoded binary where each bit corresponds to a byte in the byte array argument
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.634 -0500", hash_original_method = "92DAD7D47899A96696ADABA34E37CA07", hash_generated_method = "3B64DE5E179374FD8BC81DB74FCC2684")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public static byte[] fromAscii(byte[] ascii) {
        if (ascii == null || ascii.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        // get length/8 times bytes with 3 bit shifts to the right of the length
        byte[] l_raw = new byte[ascii.length >> 3];
        
        l_raw.addTaint(ascii.getTaint());
        return l_raw;
    }

    /**
     * Converts an array of raw binary data into an array of ascii 0 and 1 character bytes - each byte is a truncated
     * char.
     * 
     * @param raw
     *                  the raw binary data to convert
     * @return an array of 0 and 1 character bytes for each bit of the argument
     * @see org.apache.commons.codec.BinaryEncoder#encode(byte[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.649 -0500", hash_original_method = "91D303D5C085A2886EA18E68D84B5130", hash_generated_method = "AB93A70CB43B88578EAB171A59E30AB6")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public static byte[] toAsciiBytes(byte[] raw) {
        if (raw == null || raw.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        // get 8 times the bytes with 3 bit shifts to the left of the length
        byte[] l_ascii = new byte[raw.length << 3];

        l_ascii.addTaint(raw.getTaint());
        return l_ascii;
    }

    /**
     * Converts an array of raw binary data into an array of ascii 0 and 1 characters.
     * 
     * @param raw
     *                  the raw binary data to convert
     * @return an array of 0 and 1 characters for each bit of the argument
     * @see org.apache.commons.codec.BinaryEncoder#encode(byte[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.662 -0500", hash_original_method = "F6B041BF98EA41D5C441E6A872FA253A", hash_generated_method = "E993F9B1F2E513B14E60C12881C9E59B")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION) 
public static char[] toAsciiChars(byte[] raw) {
        if (raw == null || raw.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        // get 8 times the bytes with 3 bit shifts to the left of the length
        char[] l_ascii = new char[raw.length << 3];

        l_ascii.addTaint(raw.getTaint());
        return l_ascii;
    }

    /**
     * Converts an array of raw binary data into a String of ascii 0 and 1 characters.
     * 
     * @param raw
     *                  the raw binary data to convert
     * @return a String of 0 and 1 characters representing the binary data
     * @see org.apache.commons.codec.BinaryEncoder#encode(byte[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.671 -0500", hash_original_method = "82873A3E6B9086EDEC305DD96F7BB3F0", hash_generated_method = "FEB1D33AD053F278407D256FDB7876DA")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public static String toAsciiString(byte[] raw) {
        return new String(toAsciiChars(raw));
    }

    /**
     * Converts an array of raw binary data into an array of ascii 0 and 1 characters.
     * 
     * @param raw
     *                  the raw binary data to convert
     * @return 0 and 1 ascii character bytes one for each bit of the argument
     * @see org.apache.commons.codec.BinaryEncoder#encode(byte[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.565 -0500", hash_original_method = "3A81668836E1D4D5E6C2DBC8F77E3AE9", hash_generated_method = "4CE503B62DAEA49E4CABBB209E73D1EA")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public byte[] encode(byte[] raw) {
        return toAsciiBytes(raw);
    }

    /**
     * Converts an array of raw binary data into an array of ascii 0 and 1 chars.
     * 
     * @param raw
     *                  the raw binary data to convert
     * @return 0 and 1 ascii character chars one for each bit of the argument
     * @throws EncoderException
     *                  if the argument is not a byte[]
     * @see org.apache.commons.codec.Encoder#encode(java.lang.Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.575 -0500", hash_original_method = "10CBFF06ED80A3585304A13176ACBF2F", hash_generated_method = "14E7760AF34F964CBE0CEBC0D64090EB")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public Object encode(Object raw) throws EncoderException {
        if (!(raw instanceof byte[])) {
            throw new EncoderException("argument not a byte array");
        }
        return toAsciiChars((byte[]) raw);
    }

    /**
     * Decodes a byte array where each byte represents an ascii '0' or '1'.
     * 
     * @param ascii
     *                  each byte represents an ascii '0' or '1'
     * @return the raw encoded binary where each bit corresponds to a byte in the byte array argument
     * @throws DecoderException
     *                  if argument is not a byte[], char[] or String
     * @see org.apache.commons.codec.Decoder#decode(java.lang.Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.589 -0500", hash_original_method = "A129BE03B45CF5082261B54769E43850", hash_generated_method = "80D9242F283F040C715EB74BA189EB03")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public Object decode(Object ascii) throws DecoderException {
        if (ascii == null) {
            return EMPTY_BYTE_ARRAY;
        }
        if (ascii instanceof byte[]) {
            return fromAscii((byte[]) ascii);
        }
        if (ascii instanceof char[]) {
            return fromAscii((char[]) ascii);
        }
        if (ascii instanceof String) {
            return fromAscii(((String) ascii).toCharArray());
        }
        throw new DecoderException("argument not a byte array");
    }

    /**
     * Decodes a byte array where each byte represents an ascii '0' or '1'.
     * 
     * @param ascii
     *                  each byte represents an ascii '0' or '1'
     * @return the raw encoded binary where each bit corresponds to a byte in the byte array argument
     * @see org.apache.commons.codec.Decoder#decode(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.598 -0500", hash_original_method = "DF1E091BE078187B5F780BC493CC7330", hash_generated_method = "8D1C1AF6356D648686011C7E04909D37")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public byte[] decode(byte[] ascii) {
        return fromAscii(ascii);
    }

    /**
     * Decodes a String where each char of the String represents an ascii '0' or '1'.
     * 
     * @param ascii
     *                  String of '0' and '1' characters
     * @return the raw encoded binary where each bit corresponds to a byte in the byte array argument
     * @see org.apache.commons.codec.Decoder#decode(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:34:30.607 -0500", hash_original_method = "0A3E235DA23D08A23EA1E7B6F3841669", hash_generated_method = "52005CAA94770D6C812849D99D9A273C")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public byte[] toByteArray(String ascii) {
        if (ascii == null) {
            return EMPTY_BYTE_ARRAY;
        }
        return fromAscii(ascii.toCharArray());
    }
}

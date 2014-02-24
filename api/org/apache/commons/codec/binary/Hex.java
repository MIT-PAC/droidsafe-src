package org.apache.commons.codec.binary;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class Hex implements BinaryEncoder, BinaryDecoder {

    /**
     * Converts an array of characters representing hexidecimal values into an
     * array of bytes of those same values. The returned array will be half the
     * length of the passed array, as it takes two characters to represent any
     * given byte. An exception is thrown if the passed char array has an odd
     * number of elements.
     * 
     * @param data An array of characters containing hexidecimal digits
     * @return A byte array containing binary data decoded from
     *         the supplied char array.
     * @throws DecoderException Thrown if an odd number or illegal of characters 
     *         is supplied
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.739 -0500", hash_original_method = "B601E34EA293BA88B55F6A64935FC5DC", hash_generated_method = "1D0981A94C4AD37C0BFF170C7DBC532D")
    
public static byte[] decodeHex(char[] data) throws DecoderException {

        int len = data.length;

        if ((len & 0x01) != 0) {
            throw new DecoderException("Odd number of characters.");
        }

        byte[] out = new byte[len >> 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }

    /**
     * Converts a hexadecimal character to an integer.
     *  
     * @param ch A character to convert to an integer digit
     * @param index The index of the character in the source
     * @return An integer
     * @throws DecoderException Thrown if ch is an illegal hex character
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.741 -0500", hash_original_method = "8DFB6DF41A3F3D055DAE389A113EB960", hash_generated_method = "64C121B97B5278B1BF2017E99C88A8EB")
    
protected static int toDigit(char ch, int index) throws DecoderException {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new DecoderException("Illegal hexadecimal charcter " + ch + " at index " + index);
        }
        return digit;
    }

    /**
     * Converts an array of bytes into an array of characters representing the hexidecimal values of each byte in order.
     * The returned array will be double the length of the passed array, as it takes two characters to represent any
     * given byte.
     * 
     * @param data
     *                  a byte[] to convert to Hex characters
     * @return A char[] containing hexidecimal characters
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.744 -0500", hash_original_method = "01C49558DED2DE24F896F908105CD756", hash_generated_method = "CD93DA4C1C1B38B7502DF1AB3E17F9C3")
    
public static char[] encodeHex(byte[] data) {

        int l = data.length;

           char[] out = new char[l << 1];

           // two characters form the hex value.
           for (int i = 0, j = 0; i < l; i++) {
               out[j++] = DIGITS[(0xF0 & data[i]) >>> 4 ];
               out[j++] = DIGITS[ 0x0F & data[i] ];
           }

           return out;
    }
    
    @DSSafe(DSCat.UTIL_FUNCTION)
    public static String encodeHexString(byte[] data) {
        return new String(encodeHex(data));
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.736 -0500", hash_original_field = "6A79B7FE9690C6CB215ECF581D2C9051", hash_generated_field = "951B6C7D58E013204229930C868FD053")

    private static final char[] DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7',
           '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.678 -0400", hash_original_method = "2062DFA17AA591396821D3397343CC6D", hash_generated_method = "2062DFA17AA591396821D3397343CC6D")
    public Hex ()
    {
        //Synthesized constructor
    }
    
    /**
     * Converts an array of character bytes representing hexidecimal values into an
     * array of bytes of those same values. The returned array will be half the
     * length of the passed array, as it takes two characters to represent any
     * given byte. An exception is thrown if the passed char array has an odd
     * number of elements.
     * 
     * @param array An array of character bytes containing hexidecimal digits
     * @return A byte array containing binary data decoded from
     *         the supplied byte array (representing characters).
     * @throws DecoderException Thrown if an odd number of characters is supplied
     *                   to this function
     * @see #decodeHex(char[])
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.746 -0500", hash_original_method = "A17636F69FEFB6DDDFC5F873DED10994", hash_generated_method = "60C8C0188F520A0E56A43B3C97B10639")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public byte[] decode(byte[] array) throws DecoderException {
        return decodeHex(new String(array).toCharArray());
    }
    
    /**
     * Converts a String or an array of character bytes representing hexidecimal values into an
     * array of bytes of those same values. The returned array will be half the
     * length of the passed String or array, as it takes two characters to represent any
     * given byte. An exception is thrown if the passed char array has an odd
     * number of elements.
     * 
     * @param object A String or, an array of character bytes containing hexidecimal digits
     * @return A byte array containing binary data decoded from
     *         the supplied byte array (representing characters).
     * @throws DecoderException Thrown if an odd number of characters is supplied
     *                   to this function or the object is not a String or char[]
     * @see #decodeHex(char[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.749 -0500", hash_original_method = "259B1B44CE3EA0D75FAE3A3A31435A4B", hash_generated_method = "C6C4C645FD0EAABF29F771E2F97C02E5")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public Object decode(Object object) throws DecoderException {
        try {
            char[] charArray = object instanceof String ? ((String) object).toCharArray() : (char[]) object;
            return decodeHex(charArray);
        } catch (ClassCastException e) {
            throw new DecoderException(e.getMessage());
        }
    }
    
    /**
     * Converts an array of bytes into an array of bytes for the characters representing the
     * hexidecimal values of each byte in order. The returned array will be
     * double the length of the passed array, as it takes two characters to
     * represent any given byte.
     *
     * @param array a byte[] to convert to Hex characters
     * @return A byte[] containing the bytes of the hexidecimal characters
     * @see #encodeHex(byte[])
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.752 -0500", hash_original_method = "50DBD5604B609ED94F02B18C89B60347", hash_generated_method = "117BABCF8A047303DF484347B3136DE9")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public byte[] encode(byte[] array) {
        return new String(encodeHex(array)).getBytes();
    }

    /**
     * Converts a String or an array of bytes into an array of characters representing the
     * hexidecimal values of each byte in order. The returned array will be
     * double the length of the passed String or array, as it takes two characters to
     * represent any given byte.
     *
     * @param object a String, or byte[] to convert to Hex characters
     * @return A char[] containing hexidecimal characters
     * @throws EncoderException Thrown if the given object is not a String or byte[]
     * @see #encodeHex(byte[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.754 -0500", hash_original_method = "65D07AA1ACA3F409200AC5EFDF123AC8", hash_generated_method = "4674FA6F6A3412B85ACB310AC9769419")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public Object encode(Object object) throws EncoderException {    
        try {
            byte[] byteArray = object instanceof String ? ((String) object).getBytes() : (byte[]) object;
            return encodeHex(byteArray);
        } catch (ClassCastException e) {
            throw new EncoderException(e.getMessage());
        }
    }
}


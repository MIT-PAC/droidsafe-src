package org.apache.commons.codec.binary;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class Hex implements BinaryEncoder, BinaryDecoder {
    private static final char[] DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7',
           '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.552 -0400", hash_original_method = "B601E34EA293BA88B55F6A64935FC5DC", hash_generated_method = "0C1AA3D15A187A0F9A349CD8574984D4")
    public static byte[] decodeHex(char[] data) throws DecoderException {
        int len = data.length;
        if ((len & 0x01) != 0) {
            throw new DecoderException("Odd number of characters.");
        }
        byte[] out = new byte[len >> 1];
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }
        return out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.552 -0400", hash_original_method = "8DFB6DF41A3F3D055DAE389A113EB960", hash_generated_method = "64C121B97B5278B1BF2017E99C88A8EB")
    protected static int toDigit(char ch, int index) throws DecoderException {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new DecoderException("Illegal hexadecimal charcter " + ch + " at index " + index);
        }
        return digit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.552 -0400", hash_original_method = "01C49558DED2DE24F896F908105CD756", hash_generated_method = "F085E3532E3364431CB6A89BA02BCD89")
    public static char[] encodeHex(byte[] data) {
        int l = data.length;
        char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < l; i++) {
               out[j++] = DIGITS[(0xF0 & data[i]) >>> 4 ];
               out[j++] = DIGITS[ 0x0F & data[i] ];
           }
        return out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.552 -0400", hash_original_method = "A17636F69FEFB6DDDFC5F873DED10994", hash_generated_method = "494B687C67DCAB95F2D4C317064E398B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] decode(byte[] array) throws DecoderException {
        dsTaint.addTaint(array);
        byte[] varDFD55A814397BED5500E1AC87F4F0C1F_1709168351 = (decodeHex(new String(array).toCharArray()));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return decodeHex(new String(array).toCharArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.552 -0400", hash_original_method = "259B1B44CE3EA0D75FAE3A3A31435A4B", hash_generated_method = "C038995BF4E7934076D45DB3109AA24C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(Object object) throws DecoderException {
        dsTaint.addTaint(object.dsTaint);
        try 
        {
            char[] charArray;
            charArray = ((String) object).toCharArray();
            charArray = (char[]) object;
            Object varCE2A4677DCAE8F8536A102F5135D1FD9_1880189430 = (decodeHex(charArray));
        } //End block
        catch (ClassCastException e)
        {
            throw new DecoderException(e.getMessage());
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //char[] charArray = object instanceof String ? ((String) object).toCharArray() : (char[]) object;
            //return decodeHex(charArray);
        //} catch (ClassCastException e) {
            //throw new DecoderException(e.getMessage());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.553 -0400", hash_original_method = "50DBD5604B609ED94F02B18C89B60347", hash_generated_method = "9FCA22529E01CE0CB434903229101843")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] encode(byte[] array) {
        dsTaint.addTaint(array);
        byte[] var8BB4A16095E8E693A45721E2D1957B05_1343327162 = (new String(encodeHex(array)).getBytes());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return new String(encodeHex(array)).getBytes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.553 -0400", hash_original_method = "65D07AA1ACA3F409200AC5EFDF123AC8", hash_generated_method = "B2313570A76ACF2C68C6B25AB8CA7D7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object encode(Object object) throws EncoderException {
        dsTaint.addTaint(object.dsTaint);
        try 
        {
            byte[] byteArray;
            byteArray = ((String) object).getBytes();
            byteArray = (byte[]) object;
            Object var2B16E4FF1FEAC9F188DEC7609EE18B0D_1361540294 = (encodeHex(byteArray));
        } //End block
        catch (ClassCastException e)
        {
            throw new EncoderException(e.getMessage());
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //byte[] byteArray = object instanceof String ? ((String) object).getBytes() : (byte[]) object;
            //return encodeHex(byteArray);
        //} catch (ClassCastException e) {
            //throw new EncoderException(e.getMessage());
        //}
    }

    
}



package org.apache.commons.codec.binary;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class Hex implements BinaryEncoder, BinaryDecoder {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.469 -0400", hash_original_method = "2062DFA17AA591396821D3397343CC6D", hash_generated_method = "2062DFA17AA591396821D3397343CC6D")
    public Hex ()
    {
        //Synthesized constructor
    }


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

    
        protected static int toDigit(char ch, int index) throws DecoderException {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new DecoderException("Illegal hexadecimal charcter " + ch + " at index " + index);
        }
        return digit;
    }

    
        public static char[] encodeHex(byte[] data) {
        int l = data.length;
        char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < l; i++) {
               out[j++] = DIGITS[(0xF0 & data[i]) >>> 4 ];
               out[j++] = DIGITS[ 0x0F & data[i] ];
           }
        return out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.484 -0400", hash_original_method = "A17636F69FEFB6DDDFC5F873DED10994", hash_generated_method = "FABD1A16045D036D24938549A3C512B5")
    public byte[] decode(byte[] array) throws DecoderException {
        byte[] varDFD55A814397BED5500E1AC87F4F0C1F_1252577152 = (decodeHex(new String(array).toCharArray()));
        addTaint(array[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1775907071 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1775907071;
        // ---------- Original Method ----------
        //return decodeHex(new String(array).toCharArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.485 -0400", hash_original_method = "259B1B44CE3EA0D75FAE3A3A31435A4B", hash_generated_method = "5AB6E555ED0B94EEF06E26B60A0D9E59")
    public Object decode(Object object) throws DecoderException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1330410117 = null; //Variable for return #1
        try 
        {
            char[] charArray;
            charArray = ((String) object).toCharArray();
            charArray = (char[]) object;
            varB4EAC82CA7396A68D541C85D26508E83_1330410117 = decodeHex(charArray);
        } //End block
        catch (ClassCastException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new DecoderException(e.getMessage());
        } //End block
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1330410117.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1330410117;
        // ---------- Original Method ----------
        //try {
            //char[] charArray = object instanceof String ? ((String) object).toCharArray() : (char[]) object;
            //return decodeHex(charArray);
        //} catch (ClassCastException e) {
            //throw new DecoderException(e.getMessage());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.485 -0400", hash_original_method = "50DBD5604B609ED94F02B18C89B60347", hash_generated_method = "2E9B6ED31C89FE0DE0D4428600BE4C30")
    public byte[] encode(byte[] array) {
        byte[] var8BB4A16095E8E693A45721E2D1957B05_396367867 = (new String(encodeHex(array)).getBytes());
        addTaint(array[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_321120408 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_321120408;
        // ---------- Original Method ----------
        //return new String(encodeHex(array)).getBytes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.486 -0400", hash_original_method = "65D07AA1ACA3F409200AC5EFDF123AC8", hash_generated_method = "9EF3160EE9734E5A4BC319D86FDF9F62")
    public Object encode(Object object) throws EncoderException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1373016048 = null; //Variable for return #1
        try 
        {
            byte[] byteArray;
            byteArray = ((String) object).getBytes();
            byteArray = (byte[]) object;
            varB4EAC82CA7396A68D541C85D26508E83_1373016048 = encodeHex(byteArray);
        } //End block
        catch (ClassCastException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new EncoderException(e.getMessage());
        } //End block
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1373016048.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1373016048;
        // ---------- Original Method ----------
        //try {
            //byte[] byteArray = object instanceof String ? ((String) object).getBytes() : (byte[]) object;
            //return encodeHex(byteArray);
        //} catch (ClassCastException e) {
            //throw new EncoderException(e.getMessage());
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.486 -0400", hash_original_field = "009B308B1627DC0078C45AA16112713E", hash_generated_field = "D65854F37D133994A5CD968BA1C3B3CD")

    private static char[] DIGITS = ;
}


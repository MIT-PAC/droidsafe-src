package org.apache.commons.codec.binary;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class Hex implements BinaryEncoder, BinaryDecoder {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.183 -0400", hash_original_method = "2062DFA17AA591396821D3397343CC6D", hash_generated_method = "2062DFA17AA591396821D3397343CC6D")
    public Hex ()
    {
        
    }


    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.184 -0400", hash_original_method = "A17636F69FEFB6DDDFC5F873DED10994", hash_generated_method = "A0320BE74CA263D0F5D13659AEAD5773")
    public byte[] decode(byte[] array) throws DecoderException {
        byte[] varDFD55A814397BED5500E1AC87F4F0C1F_41890527 = (decodeHex(new String(array).toCharArray()));
        addTaint(array[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_240708025 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_240708025;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.185 -0400", hash_original_method = "259B1B44CE3EA0D75FAE3A3A31435A4B", hash_generated_method = "5B432158559625862E8596BEA641BE4B")
    public Object decode(Object object) throws DecoderException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1913347548 = null; 
        try 
        {
            char[] charArray;
            charArray = ((String) object).toCharArray();
            charArray = (char[]) object;
            varB4EAC82CA7396A68D541C85D26508E83_1913347548 = decodeHex(charArray);
        } 
        catch (ClassCastException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new DecoderException(e.getMessage());
        } 
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1913347548.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1913347548;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.185 -0400", hash_original_method = "50DBD5604B609ED94F02B18C89B60347", hash_generated_method = "B19774912DB82C055E4B8B800BB4FD26")
    public byte[] encode(byte[] array) {
        byte[] var8BB4A16095E8E693A45721E2D1957B05_1332694757 = (new String(encodeHex(array)).getBytes());
        addTaint(array[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1539644606 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1539644606;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.185 -0400", hash_original_method = "65D07AA1ACA3F409200AC5EFDF123AC8", hash_generated_method = "FBEC4FF9200372A383152191834816A1")
    public Object encode(Object object) throws EncoderException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1533824741 = null; 
        try 
        {
            byte[] byteArray;
            byteArray = ((String) object).getBytes();
            byteArray = (byte[]) object;
            varB4EAC82CA7396A68D541C85D26508E83_1533824741 = encodeHex(byteArray);
        } 
        catch (ClassCastException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new EncoderException(e.getMessage());
        } 
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1533824741.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1533824741;
        
        
            
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.186 -0400", hash_original_field = "009B308B1627DC0078C45AA16112713E", hash_generated_field = "951B6C7D58E013204229930C868FD053")

    private static final char[] DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7',
           '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
}


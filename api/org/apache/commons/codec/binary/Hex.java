package org.apache.commons.codec.binary;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class Hex implements BinaryEncoder, BinaryDecoder {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.678 -0400", hash_original_method = "2062DFA17AA591396821D3397343CC6D", hash_generated_method = "2062DFA17AA591396821D3397343CC6D")
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

    
    @DSModeled(DSC.SAFE)
    public static char[] encodeHex(byte[] data) {
        int l = data.length;
        char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < l; i++) {
               out[j++] = DIGITS[(0xF0 & data[i]) >>> 4 ];
               out[j++] = DIGITS[ 0x0F & data[i] ];
           }
        return out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.704 -0400", hash_original_method = "A17636F69FEFB6DDDFC5F873DED10994", hash_generated_method = "78AA884176727BF2CA639DB787FAB301")
    public byte[] decode(byte[] array) throws DecoderException {
        addTaint(array[0]);
        byte[] var97B90485A3658EC4692779AAC8EC8312_647779118 = (decodeHex(new String(array).toCharArray()));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_880527145 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_880527145;
        // ---------- Original Method ----------
        //return decodeHex(new String(array).toCharArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.705 -0400", hash_original_method = "259B1B44CE3EA0D75FAE3A3A31435A4B", hash_generated_method = "D9B8CD83ED1C3B462D1F8B2056D7AB31")
    public Object decode(Object object) throws DecoderException {
        addTaint(object.getTaint());
        try 
        {
            char[] charArray = object instanceof String ? ((String) object).toCharArray() : (char[]) object;
Object var7D7CE31ADFA4FD7FAC36DE7403692C28_1778087439 =             decodeHex(charArray);
            var7D7CE31ADFA4FD7FAC36DE7403692C28_1778087439.addTaint(taint);
            return var7D7CE31ADFA4FD7FAC36DE7403692C28_1778087439;
        } //End block
        catch (ClassCastException e)
        {
            DecoderException var15679C41938BD969A61CD780F300373F_923264097 = new DecoderException(e.getMessage());
            var15679C41938BD969A61CD780F300373F_923264097.addTaint(taint);
            throw var15679C41938BD969A61CD780F300373F_923264097;
        } //End block
        // ---------- Original Method ----------
        //try {
            //char[] charArray = object instanceof String ? ((String) object).toCharArray() : (char[]) object;
            //return decodeHex(charArray);
        //} catch (ClassCastException e) {
            //throw new DecoderException(e.getMessage());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.705 -0400", hash_original_method = "50DBD5604B609ED94F02B18C89B60347", hash_generated_method = "51EE2C3630699F8508A59D9DFD4D86F5")
    public byte[] encode(byte[] array) {
        addTaint(array[0]);
        byte[] varFDE8ED34EEA182E97DD9AC8CF64B8695_613372022 = (new String(encodeHex(array)).getBytes());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_572461035 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_572461035;
        // ---------- Original Method ----------
        //return new String(encodeHex(array)).getBytes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.705 -0400", hash_original_method = "65D07AA1ACA3F409200AC5EFDF123AC8", hash_generated_method = "0E2AAF41EA1931C86A62435A44545C05")
    public Object encode(Object object) throws EncoderException {
        addTaint(object.getTaint());
        try 
        {
            byte[] byteArray = object instanceof String ? ((String) object).getBytes() : (byte[]) object;
Object var7C50A76DB1406D2F70D7CFCDD0480BFF_747060158 =             encodeHex(byteArray);
            var7C50A76DB1406D2F70D7CFCDD0480BFF_747060158.addTaint(taint);
            return var7C50A76DB1406D2F70D7CFCDD0480BFF_747060158;
        } //End block
        catch (ClassCastException e)
        {
            EncoderException var7E1EBAF8143A5434180A91114C241A87_1545484159 = new EncoderException(e.getMessage());
            var7E1EBAF8143A5434180A91114C241A87_1545484159.addTaint(taint);
            throw var7E1EBAF8143A5434180A91114C241A87_1545484159;
        } //End block
        // ---------- Original Method ----------
        //try {
            //byte[] byteArray = object instanceof String ? ((String) object).getBytes() : (byte[]) object;
            //return encodeHex(byteArray);
        //} catch (ClassCastException e) {
            //throw new EncoderException(e.getMessage());
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.705 -0400", hash_original_field = "009B308B1627DC0078C45AA16112713E", hash_generated_field = "951B6C7D58E013204229930C868FD053")

    private static final char[] DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7',
           '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
}


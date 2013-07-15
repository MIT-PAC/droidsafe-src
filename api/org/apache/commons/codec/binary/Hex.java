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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.885 -0400", hash_original_method = "2062DFA17AA591396821D3397343CC6D", hash_generated_method = "2062DFA17AA591396821D3397343CC6D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.886 -0400", hash_original_method = "A17636F69FEFB6DDDFC5F873DED10994", hash_generated_method = "5084FBDAB01E514D923039249422A2BF")
    public byte[] decode(byte[] array) throws DecoderException {
        addTaint(array[0]);
        byte[] var97B90485A3658EC4692779AAC8EC8312_861964823 = (decodeHex(new String(array).toCharArray()));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1971433666 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1971433666;
        // ---------- Original Method ----------
        //return decodeHex(new String(array).toCharArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.886 -0400", hash_original_method = "259B1B44CE3EA0D75FAE3A3A31435A4B", hash_generated_method = "06C95522D0C74E96E62D07DD94FB900C")
    public Object decode(Object object) throws DecoderException {
        addTaint(object.getTaint());
        try 
        {
            char[] charArray = object instanceof String ? ((String) object).toCharArray() : (char[]) object;
Object var7D7CE31ADFA4FD7FAC36DE7403692C28_1253497196 =             decodeHex(charArray);
            var7D7CE31ADFA4FD7FAC36DE7403692C28_1253497196.addTaint(taint);
            return var7D7CE31ADFA4FD7FAC36DE7403692C28_1253497196;
        } //End block
        catch (ClassCastException e)
        {
            DecoderException var15679C41938BD969A61CD780F300373F_1396960308 = new DecoderException(e.getMessage());
            var15679C41938BD969A61CD780F300373F_1396960308.addTaint(taint);
            throw var15679C41938BD969A61CD780F300373F_1396960308;
        } //End block
        // ---------- Original Method ----------
        //try {
            //char[] charArray = object instanceof String ? ((String) object).toCharArray() : (char[]) object;
            //return decodeHex(charArray);
        //} catch (ClassCastException e) {
            //throw new DecoderException(e.getMessage());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.887 -0400", hash_original_method = "50DBD5604B609ED94F02B18C89B60347", hash_generated_method = "1B0F939C66E6E547F53DC8761EAAA5FF")
    public byte[] encode(byte[] array) {
        addTaint(array[0]);
        byte[] varFDE8ED34EEA182E97DD9AC8CF64B8695_174084422 = (new String(encodeHex(array)).getBytes());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_745953441 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_745953441;
        // ---------- Original Method ----------
        //return new String(encodeHex(array)).getBytes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.887 -0400", hash_original_method = "65D07AA1ACA3F409200AC5EFDF123AC8", hash_generated_method = "D8BF15EDABC2ED2D9286D171EA7DFFDF")
    public Object encode(Object object) throws EncoderException {
        addTaint(object.getTaint());
        try 
        {
            byte[] byteArray = object instanceof String ? ((String) object).getBytes() : (byte[]) object;
Object var7C50A76DB1406D2F70D7CFCDD0480BFF_954799071 =             encodeHex(byteArray);
            var7C50A76DB1406D2F70D7CFCDD0480BFF_954799071.addTaint(taint);
            return var7C50A76DB1406D2F70D7CFCDD0480BFF_954799071;
        } //End block
        catch (ClassCastException e)
        {
            EncoderException var7E1EBAF8143A5434180A91114C241A87_774541964 = new EncoderException(e.getMessage());
            var7E1EBAF8143A5434180A91114C241A87_774541964.addTaint(taint);
            throw var7E1EBAF8143A5434180A91114C241A87_774541964;
        } //End block
        // ---------- Original Method ----------
        //try {
            //byte[] byteArray = object instanceof String ? ((String) object).getBytes() : (byte[]) object;
            //return encodeHex(byteArray);
        //} catch (ClassCastException e) {
            //throw new EncoderException(e.getMessage());
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.887 -0400", hash_original_field = "009B308B1627DC0078C45AA16112713E", hash_generated_field = "951B6C7D58E013204229930C868FD053")

    private static final char[] DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7',
           '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
}


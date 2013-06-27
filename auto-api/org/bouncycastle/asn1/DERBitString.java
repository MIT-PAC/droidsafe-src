package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class DERBitString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.912 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "FE472066F06E7EB612EB3FC3B9912573")

    protected byte[] data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.912 -0400", hash_original_field = "2B6E1E69F76FB71BC1BD5E9D6660FE41", hash_generated_field = "133CFF098A8491F27C40D29FAE7800EB")

    protected int padBits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.913 -0400", hash_original_method = "26EE121790982A47721F4E882F2E6D1B", hash_generated_method = "F9659D794398D2062248EB34A4C3BF44")
    protected  DERBitString(
        byte    data,
        int     padBits) {
        this.data = new byte[1];
        this.data[0] = data;
        this.padBits = padBits;
        // ---------- Original Method ----------
        //this.data = new byte[1];
        //this.data[0] = data;
        //this.padBits = padBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.922 -0400", hash_original_method = "FFBC3727DD76CEA695B58D8154C3FE06", hash_generated_method = "CADEBBFE8908BA669336E0DD7B955C29")
    public  DERBitString(
        byte[]  data,
        int     padBits) {
        this.data = data;
        this.padBits = padBits;
        // ---------- Original Method ----------
        //this.data = data;
        //this.padBits = padBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.923 -0400", hash_original_method = "B944CF7FA9085EE991D9A8B7F428DA93", hash_generated_method = "BFADE815C0FBA5F064F9CAC679789DB8")
    public  DERBitString(
        byte[]  data) {
        this(data, 0);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.923 -0400", hash_original_method = "CADA9C81F27161B70BDA506AB461E094", hash_generated_method = "FEB19EF3918CED7CD585FC404A7CE6D7")
    public  DERBitString(
        DEREncodable  obj) {
        try 
        {
            this.data = obj.getDERObject().getEncoded(ASN1Encodable.DER);
            this.padBits = 0;
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Error processing object : " + e.toString());
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //this.data = obj.getDERObject().getEncoded(ASN1Encodable.DER);
            //this.padBits = 0;
        //}
        //catch (IOException e)
        //{
            //throw new IllegalArgumentException("Error processing object : " + e.toString());
        //}
    }

    
        static protected int getPadBits(
        int bitString) {
        int val = 0;
        for (int i = 3; i >= 0; i--) 
        {
            if (i != 0)
            {
                if ((bitString >> (i * 8)) != 0) 
                {
                    val = (bitString >> (i * 8)) & 0xFF;
                    break;
                }
            }
            else
            {
                if (bitString != 0)
                {
                    val = bitString & 0xFF;
                    break;
                }
            }
        }
        if (val == 0)
        {
            return 7;
        }
        int bits = 1;
        while (((val <<= 1) & 0xFF) != 0)
        {
            bits++;
        }
        return 8 - bits;
    }

    
        static protected byte[] getBytes(int bitString) {
        int bytes = 4;
        for (int i = 3; i >= 1; i--)
        {
            if ((bitString & (0xFF << (i * 8))) != 0)
            {
                break;
            }
            bytes--;
        }
        byte[] result = new byte[bytes];
        for (int i = 0; i < bytes; i++)
        {
            result[i] = (byte) ((bitString >> (i * 8)) & 0xFF);
        }
        return result;
    }

    
        public static DERBitString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERBitString)
        {
            return (DERBitString)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        public static DERBitString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERBitString)
        {
            return getInstance(o);
        }
        else
        {
            return fromOctetString(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.925 -0400", hash_original_method = "A347A6B90A5D4D940F0721005973D58D", hash_generated_method = "F298CED6160A2A479825B1FD5C15CFF9")
    public byte[] getBytes() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_849885191 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_849885191;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.932 -0400", hash_original_method = "417B58F84A036F27149A8DCAE574FCD8", hash_generated_method = "8FDB107C46C20908F354F62D531AE9FC")
    public int getPadBits() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753420868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753420868;
        // ---------- Original Method ----------
        //return padBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.933 -0400", hash_original_method = "4C040E65E95E154142FD7B39A853E86F", hash_generated_method = "CF2CB3463C727AB49429B6A97D252E24")
    public int intValue() {
        int value;
        value = 0;
        {
            int i;
            i = 0;
            {
                value |= (data[i] & 0xff) << (8 * i);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_612278652 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_612278652;
        // ---------- Original Method ----------
        //int value = 0;
        //for (int i = 0; i != data.length && i != 4; i++)
        //{
            //value |= (data[i] & 0xff) << (8 * i);
        //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.933 -0400", hash_original_method = "CB83D166557B7D270FFD9D836925EA70", hash_generated_method = "D3F09E7501406C965431ECF62BFC6B56")
     void encode(
        DEROutputStream  out) throws IOException {
        byte[] bytes;
        bytes = new byte[getBytes().length + 1];
        bytes[0] = (byte)getPadBits();
        System.arraycopy(getBytes(), 0, bytes, 1, bytes.length - 1);
        out.writeEncoded(BIT_STRING, bytes);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //byte[]  bytes = new byte[getBytes().length + 1];
        //bytes[0] = (byte)getPadBits();
        //System.arraycopy(getBytes(), 0, bytes, 1, bytes.length - 1);
        //out.writeEncoded(BIT_STRING, bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.934 -0400", hash_original_method = "0FA775A3BA483D59A323D752B0FD6DA8", hash_generated_method = "B522DFC8BE4D93C65973EEE205346B71")
    public int hashCode() {
        int var11E55EB25DAE699D862B36628FA1489C_1887903954 = (padBits ^ Arrays.hashCode(data));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_644334802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_644334802;
        // ---------- Original Method ----------
        //return padBits ^ Arrays.hashCode(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.934 -0400", hash_original_method = "6A45C831F2BEA87730EF6E467856CBF1", hash_generated_method = "1BB5A020F4986551139066A0E1003437")
    protected boolean asn1Equals(
        DERObject  o) {
        DERBitString other;
        other = (DERBitString)o;
        boolean var6C6ECD84CD4DCB75C88AA039F569B8E1_649038513 = (this.padBits == other.padBits
            && Arrays.areEqual(this.data, other.data));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1906094930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1906094930;
        // ---------- Original Method ----------
        //if (!(o instanceof DERBitString))
        //{
            //return false;
        //}
        //DERBitString other = (DERBitString)o;
        //return this.padBits == other.padBits
            //&& Arrays.areEqual(this.data, other.data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.946 -0400", hash_original_method = "C8AC92EF6B951363C15B3CD0868FB9EA", hash_generated_method = "C92E1998AC8F0678377B064E14099B52")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1691239056 = null; //Variable for return #1
        StringBuffer buf;
        buf = new StringBuffer("#");
        ByteArrayOutputStream bOut;
        bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut;
        aOut = new ASN1OutputStream(bOut);
        try 
        {
            aOut.writeObject(this);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("internal error encoding BitString");
        } //End block
        byte[] string;
        string = bOut.toByteArray();
        {
            int i;
            i = 0;
            {
                buf.append(table[(string[i] >>> 4) & 0xf]);
                buf.append(table[string[i] & 0xf]);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1691239056 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1691239056.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1691239056;
        // ---------- Original Method ----------
        //StringBuffer          buf = new StringBuffer("#");
        //ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        //ASN1OutputStream      aOut = new ASN1OutputStream(bOut);
        //try
        //{
            //aOut.writeObject(this);
        //}
        //catch (IOException e)
        //{
           //throw new RuntimeException("internal error encoding BitString");
        //}
        //byte[]    string = bOut.toByteArray();
        //for (int i = 0; i != string.length; i++)
        //{
            //buf.append(table[(string[i] >>> 4) & 0xf]);
            //buf.append(table[string[i] & 0xf]);
        //}
        //return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.947 -0400", hash_original_method = "79F534E26CC8382FAA66B4080878D117", hash_generated_method = "6ECCF6EC3F36FF8D7323B5CECB1C104E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1802633427 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1802633427 = getString();
        varB4EAC82CA7396A68D541C85D26508E83_1802633427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1802633427;
        // ---------- Original Method ----------
        //return getString();
    }

    
        static DERBitString fromOctetString(byte[] bytes) {
        if (bytes.length < 1)
        {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int padBits = bytes[0];
        byte[] data = new byte[bytes.length - 1];
        if (data.length != 0)
        {
            System.arraycopy(bytes, 1, data, 0, bytes.length - 1);
        }
        return new DERBitString(data, padBits);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.947 -0400", hash_original_field = "5102FEFA75F1FF15CF0FF9123C653112", hash_generated_field = "16B625E7D69E2A0D7C5AB10B3550AEAF")

    private static char[] table = ;
}


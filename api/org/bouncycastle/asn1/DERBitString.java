package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.bouncycastle.util.Arrays;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DERBitString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.136 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "FE472066F06E7EB612EB3FC3B9912573")

    protected byte[] data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.137 -0400", hash_original_field = "2B6E1E69F76FB71BC1BD5E9D6660FE41", hash_generated_field = "133CFF098A8491F27C40D29FAE7800EB")

    protected int padBits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.137 -0400", hash_original_method = "26EE121790982A47721F4E882F2E6D1B", hash_generated_method = "F9659D794398D2062248EB34A4C3BF44")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.138 -0400", hash_original_method = "FFBC3727DD76CEA695B58D8154C3FE06", hash_generated_method = "CADEBBFE8908BA669336E0DD7B955C29")
    public  DERBitString(
        byte[]  data,
        int     padBits) {
        this.data = data;
        this.padBits = padBits;
        // ---------- Original Method ----------
        //this.data = data;
        //this.padBits = padBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.138 -0400", hash_original_method = "B944CF7FA9085EE991D9A8B7F428DA93", hash_generated_method = "BFADE815C0FBA5F064F9CAC679789DB8")
    public  DERBitString(
        byte[]  data) {
        this(data, 0);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.139 -0400", hash_original_method = "CADA9C81F27161B70BDA506AB461E094", hash_generated_method = "73D5B8F6AD3043AE4C09F29717FD661D")
    public  DERBitString(
        DEREncodable  obj) {
        try 
        {
            this.data = obj.getDERObject().getEncoded(ASN1Encodable.DER);
            this.padBits = 0;
        } //End block
        catch (IOException e)
        {
            IllegalArgumentException var9B1477DE179542DA2A6D027531904C24_1096391363 = new IllegalArgumentException("Error processing object : " + e.toString());
            var9B1477DE179542DA2A6D027531904C24_1096391363.addTaint(taint);
            throw var9B1477DE179542DA2A6D027531904C24_1096391363;
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.140 -0400", hash_original_method = "A347A6B90A5D4D940F0721005973D58D", hash_generated_method = "EC99EAFB74ECE634352B2C89D337F005")
    public byte[] getBytes() {
        byte[] var8D777F385D3DFEC8815D20F7496026DC_1448309202 = (data);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1739460651 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1739460651;
        // ---------- Original Method ----------
        //return data;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.140 -0400", hash_original_method = "417B58F84A036F27149A8DCAE574FCD8", hash_generated_method = "2819AB2B7DEDFF486FF2291640C4D3D1")
    public int getPadBits() {
        int var2B6E1E69F76FB71BC1BD5E9D6660FE41_1203855083 = (padBits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_468924064 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_468924064;
        // ---------- Original Method ----------
        //return padBits;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.141 -0400", hash_original_method = "4C040E65E95E154142FD7B39A853E86F", hash_generated_method = "AABCA7E085BC627AD216AAB41B8EEDF1")
    public int intValue() {
        int value = 0;
for(int i = 0;i != data.length && i != 4;i++)
        {
            value |= (data[i] & 0xff) << (8 * i);
        } //End block
        int var2063C1608D6E0BAF80249C42E2BE5804_1079950977 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652007853 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652007853;
        // ---------- Original Method ----------
        //int value = 0;
        //for (int i = 0; i != data.length && i != 4; i++)
        //{
            //value |= (data[i] & 0xff) << (8 * i);
        //}
        //return value;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.142 -0400", hash_original_method = "CB83D166557B7D270FFD9D836925EA70", hash_generated_method = "1632A7601780DEFAB2394AB3BFE8EBE7")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        byte[] bytes = new byte[getBytes().length + 1];
        bytes[0] = (byte)getPadBits();
        System.arraycopy(getBytes(), 0, bytes, 1, bytes.length - 1);
        out.writeEncoded(BIT_STRING, bytes);
        // ---------- Original Method ----------
        //byte[]  bytes = new byte[getBytes().length + 1];
        //bytes[0] = (byte)getPadBits();
        //System.arraycopy(getBytes(), 0, bytes, 1, bytes.length - 1);
        //out.writeEncoded(BIT_STRING, bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.142 -0400", hash_original_method = "0FA775A3BA483D59A323D752B0FD6DA8", hash_generated_method = "48E94FA1F059E41DEB013780380E5CEC")
    public int hashCode() {
        int var7471FC882F94143252B8475D94AA8371_1529048950 = (padBits ^ Arrays.hashCode(data));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567689399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567689399;
        // ---------- Original Method ----------
        //return padBits ^ Arrays.hashCode(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.142 -0400", hash_original_method = "6A45C831F2BEA87730EF6E467856CBF1", hash_generated_method = "8B4C6459915F063EAD4F0B813594C3A9")
    protected boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
        if(!(o instanceof DERBitString))        
        {
            boolean var68934A3E9455FA72420237EB05902327_372182031 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79896078 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_79896078;
        } //End block
        DERBitString other = (DERBitString)o;
        boolean var3BAC3CEDD58BB7B3EAF248391C9F8C7A_1313734242 = (this.padBits == other.padBits
            && Arrays.areEqual(this.data, other.data));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776860329 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776860329;
        // ---------- Original Method ----------
        //if (!(o instanceof DERBitString))
        //{
            //return false;
        //}
        //DERBitString other = (DERBitString)o;
        //return this.padBits == other.padBits
            //&& Arrays.areEqual(this.data, other.data);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.143 -0400", hash_original_method = "C8AC92EF6B951363C15B3CD0868FB9EA", hash_generated_method = "626E493780AE1E74185926C935326D86")
    public String getString() {
        StringBuffer buf = new StringBuffer("#");
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut = new ASN1OutputStream(bOut);
        try 
        {
            aOut.writeObject(this);
        } //End block
        catch (IOException e)
        {
            RuntimeException var56AF4A68FA1BC5130CBC0C2451EDF493_1201044559 = new RuntimeException("internal error encoding BitString");
            var56AF4A68FA1BC5130CBC0C2451EDF493_1201044559.addTaint(taint);
            throw var56AF4A68FA1BC5130CBC0C2451EDF493_1201044559;
        } //End block
        byte[] string = bOut.toByteArray();
for(int i = 0;i != string.length;i++)
        {
            buf.append(table[(string[i] >>> 4) & 0xf]);
            buf.append(table[string[i] & 0xf]);
        } //End block
String var4FC680801218E6372BC708D6FA44AE60_934514628 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_934514628.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_934514628;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.143 -0400", hash_original_method = "79F534E26CC8382FAA66B4080878D117", hash_generated_method = "60725DD70024E37AC8F6C63D227C5E00")
    public String toString() {
String var8DB59AA9A0821BE4812A8E2F6919F1D5_644269756 =         getString();
        var8DB59AA9A0821BE4812A8E2F6919F1D5_644269756.addTaint(taint);
        return var8DB59AA9A0821BE4812A8E2F6919F1D5_644269756;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.143 -0400", hash_original_field = "5102FEFA75F1FF15CF0FF9123C653112", hash_generated_field = "4F8597255A63B9818A65C2C1EBCFBC6D")

    private static final char[] table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
}


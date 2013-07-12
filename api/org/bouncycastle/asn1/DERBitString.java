package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class DERBitString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.917 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "FE472066F06E7EB612EB3FC3B9912573")

    protected byte[] data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.917 -0400", hash_original_field = "2B6E1E69F76FB71BC1BD5E9D6660FE41", hash_generated_field = "133CFF098A8491F27C40D29FAE7800EB")

    protected int padBits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.918 -0400", hash_original_method = "26EE121790982A47721F4E882F2E6D1B", hash_generated_method = "F9659D794398D2062248EB34A4C3BF44")
    protected  DERBitString(
        byte    data,
        int     padBits) {
        this.data = new byte[1];
        this.data[0] = data;
        this.padBits = padBits;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.919 -0400", hash_original_method = "FFBC3727DD76CEA695B58D8154C3FE06", hash_generated_method = "CADEBBFE8908BA669336E0DD7B955C29")
    public  DERBitString(
        byte[]  data,
        int     padBits) {
        this.data = data;
        this.padBits = padBits;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.919 -0400", hash_original_method = "B944CF7FA9085EE991D9A8B7F428DA93", hash_generated_method = "BFADE815C0FBA5F064F9CAC679789DB8")
    public  DERBitString(
        byte[]  data) {
        this(data, 0);
        addTaint(data[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.920 -0400", hash_original_method = "CADA9C81F27161B70BDA506AB461E094", hash_generated_method = "5F2E1B4445BA91A97D70C311B3E974F6")
    public  DERBitString(
        DEREncodable  obj) {
        try 
        {
            this.data = obj.getDERObject().getEncoded(ASN1Encodable.DER);
            this.padBits = 0;
        } 
        catch (IOException e)
        {
            IllegalArgumentException var9B1477DE179542DA2A6D027531904C24_75305407 = new IllegalArgumentException("Error processing object : " + e.toString());
            var9B1477DE179542DA2A6D027531904C24_75305407.addTaint(taint);
            throw var9B1477DE179542DA2A6D027531904C24_75305407;
        } 
        
        
        
            
            
        
        
        
            
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.921 -0400", hash_original_method = "A347A6B90A5D4D940F0721005973D58D", hash_generated_method = "A2D1D9976977F179A78F0A63456FF5E0")
    public byte[] getBytes() {
        byte[] var8D777F385D3DFEC8815D20F7496026DC_1454466847 = (data);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_689946102 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_689946102;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.921 -0400", hash_original_method = "417B58F84A036F27149A8DCAE574FCD8", hash_generated_method = "9FE340212252FF4C478FB507B4120A9D")
    public int getPadBits() {
        int var2B6E1E69F76FB71BC1BD5E9D6660FE41_531051989 = (padBits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1494031487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1494031487;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.922 -0400", hash_original_method = "4C040E65E95E154142FD7B39A853E86F", hash_generated_method = "CF07CC0D33ECB0AC7C5B77CDD97DAE31")
    public int intValue() {
        int value = 0;
for(int i = 0;i != data.length && i != 4;i++)
        {
            value |= (data[i] & 0xff) << (8 * i);
        } 
        int var2063C1608D6E0BAF80249C42E2BE5804_535788363 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690379319 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690379319;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.922 -0400", hash_original_method = "CB83D166557B7D270FFD9D836925EA70", hash_generated_method = "1632A7601780DEFAB2394AB3BFE8EBE7")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        byte[] bytes = new byte[getBytes().length + 1];
        bytes[0] = (byte)getPadBits();
        System.arraycopy(getBytes(), 0, bytes, 1, bytes.length - 1);
        out.writeEncoded(BIT_STRING, bytes);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.923 -0400", hash_original_method = "0FA775A3BA483D59A323D752B0FD6DA8", hash_generated_method = "8922B6D5B734E81526EE4E2A94D80375")
    public int hashCode() {
        int var7471FC882F94143252B8475D94AA8371_1134565743 = (padBits ^ Arrays.hashCode(data));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474422339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474422339;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.923 -0400", hash_original_method = "6A45C831F2BEA87730EF6E467856CBF1", hash_generated_method = "0A18C0CC0951B34F803FBD90D0F63C8A")
    protected boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
    if(!(o instanceof DERBitString))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1927770665 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_60999066 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_60999066;
        } 
        DERBitString other = (DERBitString)o;
        boolean var3BAC3CEDD58BB7B3EAF248391C9F8C7A_1610515904 = (this.padBits == other.padBits
            && Arrays.areEqual(this.data, other.data));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1489573757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1489573757;
        
        
        
            
        
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.924 -0400", hash_original_method = "C8AC92EF6B951363C15B3CD0868FB9EA", hash_generated_method = "32F765E54D151C2F17C165AE6E5F6BE8")
    public String getString() {
        StringBuffer buf = new StringBuffer("#");
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut = new ASN1OutputStream(bOut);
        try 
        {
            aOut.writeObject(this);
        } 
        catch (IOException e)
        {
            RuntimeException var56AF4A68FA1BC5130CBC0C2451EDF493_1347678298 = new RuntimeException("internal error encoding BitString");
            var56AF4A68FA1BC5130CBC0C2451EDF493_1347678298.addTaint(taint);
            throw var56AF4A68FA1BC5130CBC0C2451EDF493_1347678298;
        } 
        byte[] string = bOut.toByteArray();
for(int i = 0;i != string.length;i++)
        {
            buf.append(table[(string[i] >>> 4) & 0xf]);
            buf.append(table[string[i] & 0xf]);
        } 
String var4FC680801218E6372BC708D6FA44AE60_1694570178 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_1694570178.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_1694570178;
        
        
        
        
        
        
            
        
        
        
           
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.924 -0400", hash_original_method = "79F534E26CC8382FAA66B4080878D117", hash_generated_method = "9DA3757C71F23AA3663BE7119E0DC1C0")
    public String toString() {
String var8DB59AA9A0821BE4812A8E2F6919F1D5_197778494 =         getString();
        var8DB59AA9A0821BE4812A8E2F6919F1D5_197778494.addTaint(taint);
        return var8DB59AA9A0821BE4812A8E2F6919F1D5_197778494;
        
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.924 -0400", hash_original_field = "5102FEFA75F1FF15CF0FF9123C653112", hash_generated_field = "4F8597255A63B9818A65C2C1EBCFBC6D")

    private static final char[] table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
}


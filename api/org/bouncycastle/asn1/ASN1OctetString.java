package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public abstract class ASN1OctetString extends ASN1Object implements ASN1OctetStringParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.617 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "4DFAD1EC9079C516825D3C67F76850BC")

    byte[] string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.618 -0400", hash_original_method = "210B116B260CE188F6D07BB4AB757CE1", hash_generated_method = "1267ECEF8E7F1832493BA30CF81780C3")
    public  ASN1OctetString(
        byte[]  string) {
    if(string == null)        
        {
            NullPointerException var583B156DFC6C0D3E5E7C194136874CD3_1358198358 = new NullPointerException("string cannot be null");
            var583B156DFC6C0D3E5E7C194136874CD3_1358198358.addTaint(taint);
            throw var583B156DFC6C0D3E5E7C194136874CD3_1358198358;
        } //End block
        this.string = string;
        // ---------- Original Method ----------
        //if (string == null)
        //{
            //throw new NullPointerException("string cannot be null");
        //}
        //this.string = string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.620 -0400", hash_original_method = "654F394A2F1F18AA4253E49ED9387EFC", hash_generated_method = "8633E04C92B07960B4FEE23172AB6340")
    public  ASN1OctetString(
        DEREncodable obj) {
        try 
        {
            this.string = obj.getDERObject().getEncoded(ASN1Encodable.DER);
        } //End block
        catch (IOException e)
        {
            IllegalArgumentException var9B1477DE179542DA2A6D027531904C24_429036538 = new IllegalArgumentException("Error processing object : " + e.toString());
            var9B1477DE179542DA2A6D027531904C24_429036538.addTaint(taint);
            throw var9B1477DE179542DA2A6D027531904C24_429036538;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //this.string = obj.getDERObject().getEncoded(ASN1Encodable.DER);
        //}
        //catch (IOException e)
        //{
            //throw new IllegalArgumentException("Error processing object : " + e.toString());
        //}
    }

    
        public static ASN1OctetString getInstance(
        ASN1TaggedObject    obj,
        boolean             explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof ASN1OctetString)
        {
            return getInstance(o);
        }
        else
        {
            return BERConstructedOctetString.fromSequence(ASN1Sequence.getInstance(o)); 
        }
    }

    
        public static ASN1OctetString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof ASN1OctetString)
        {
            return (ASN1OctetString)obj;
        }
        if (obj instanceof ASN1TaggedObject)
        {
            return getInstance(((ASN1TaggedObject)obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.621 -0400", hash_original_method = "34640A97A031BA78080CEBB6F9EA17E5", hash_generated_method = "A2928CBF5BD9B1B0DDC4A5EA555284D3")
    public InputStream getOctetStream() {
InputStream varFDCDB5E8FC538F264AC02353EB3C9F5D_283676052 =         new ByteArrayInputStream(string);
        varFDCDB5E8FC538F264AC02353EB3C9F5D_283676052.addTaint(taint);
        return varFDCDB5E8FC538F264AC02353EB3C9F5D_283676052;
        // ---------- Original Method ----------
        //return new ByteArrayInputStream(string);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.622 -0400", hash_original_method = "9D3ECD11646B7B9703C16B797DA8DA2E", hash_generated_method = "0C90AF6A4C84AF3BC3DA517C52D0335D")
    public ASN1OctetStringParser parser() {
ASN1OctetStringParser var72A74007B2BE62B849F475C7BDA4658B_510237722 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_510237722.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_510237722;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.622 -0400", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "0D1AB98C512BAE0C5485130A618C25ED")
    public byte[] getOctets() {
        byte[] varB45CFFE084DD3D20D928BEE85E7B0F21_236564180 = (string);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_642403043 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_642403043;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.622 -0400", hash_original_method = "306C0053EB93BF3AE4D12BCDAA093AD0", hash_generated_method = "9DA642E0B7DD600CF7385FBB9EDAB772")
    public int hashCode() {
        int var8CC5DCD7A6E75AED57809811CBC104BF_1531730215 = (Arrays.hashCode(this.getOctets()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501475418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501475418;
        // ---------- Original Method ----------
        //return Arrays.hashCode(this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.623 -0400", hash_original_method = "5FE20DA2EBC8E33EF5740C0666CFE34F", hash_generated_method = "A33E0740AD30567D0B5AC4BE2E4141EC")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
    if(!(o instanceof ASN1OctetString))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1857791416 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1001841550 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1001841550;
        } //End block
        ASN1OctetString other = (ASN1OctetString)o;
        boolean var38610FAC509F575427AAB91B42854553_1543013442 = (Arrays.areEqual(string, other.string));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1041442338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1041442338;
        // ---------- Original Method ----------
        //if (!(o instanceof ASN1OctetString))
        //{
            //return false;
        //}
        //ASN1OctetString  other = (ASN1OctetString)o;
        //return Arrays.areEqual(string, other.string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.623 -0400", hash_original_method = "D3363286272FDA8D05900543905FFBE8", hash_generated_method = "981F6B564CA97E589C0C9F0995514745")
    public DERObject getLoadedObject() {
DERObject var637323B1C4EE7CAF17B2CD40E14254B5_383424228 =         this.getDERObject();
        var637323B1C4EE7CAF17B2CD40E14254B5_383424228.addTaint(taint);
        return var637323B1C4EE7CAF17B2CD40E14254B5_383424228;
        // ---------- Original Method ----------
        //return this.getDERObject();
    }

    
    abstract void encode(DEROutputStream out)
        throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.624 -0400", hash_original_method = "A6F4AE428E861451DA18F2BDC0B16A3E", hash_generated_method = "F71C3B62FF91AC147A24E578D0458E19")
    public String toString() {
String var9E18392C58EAD0B1BFCF106787A98CB2_1487910992 =         "#"+new String(Hex.encode(string));
        var9E18392C58EAD0B1BFCF106787A98CB2_1487910992.addTaint(taint);
        return var9E18392C58EAD0B1BFCF106787A98CB2_1487910992;
        // ---------- Original Method ----------
        //return "#"+new String(Hex.encode(string));
    }

    
}


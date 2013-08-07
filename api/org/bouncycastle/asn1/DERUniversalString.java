package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;






public class DERUniversalString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.660 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "F26C5AE8BA7ACEC7B1EA4DA4444275F5")

    private byte[] string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.660 -0400", hash_original_method = "2B92FC0148DCC3B768EB41AB12E19E0C", hash_generated_method = "EB9C704CCBDB706AC49133E4C66FA4A0")
    public  DERUniversalString(
        byte[]   string) {
        this.string = string;
        // ---------- Original Method ----------
        //this.string = string;
    }

    
    public static DERUniversalString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERUniversalString)
        {
            return (DERUniversalString)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    public static DERUniversalString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERUniversalString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERUniversalString(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.663 -0400", hash_original_method = "C8AC92EF6B951363C15B3CD0868FB9EA", hash_generated_method = "1B366A3534680DFC2EBE6A02145DDD9B")
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
            RuntimeException var56AF4A68FA1BC5130CBC0C2451EDF493_166943009 = new RuntimeException("internal error encoding BitString");
            var56AF4A68FA1BC5130CBC0C2451EDF493_166943009.addTaint(taint);
            throw var56AF4A68FA1BC5130CBC0C2451EDF493_166943009;
        } //End block
        byte[] string = bOut.toByteArray();
for(int i = 0;i != string.length;i++)
        {
            buf.append(table[(string[i] >>> 4) & 0xf]);
            buf.append(table[string[i] & 0xf]);
        } //End block
String var4FC680801218E6372BC708D6FA44AE60_739083286 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_739083286.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_739083286;
        // ---------- Original Method ----------
        //StringBuffer    buf = new StringBuffer("#");
        //ByteArrayOutputStream    bOut = new ByteArrayOutputStream();
        //ASN1OutputStream            aOut = new ASN1OutputStream(bOut);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.663 -0400", hash_original_method = "79F534E26CC8382FAA66B4080878D117", hash_generated_method = "0DC391A51D3658D0B8A69373F4CF67C8")
    public String toString() {
String var8DB59AA9A0821BE4812A8E2F6919F1D5_1426518529 =         getString();
        var8DB59AA9A0821BE4812A8E2F6919F1D5_1426518529.addTaint(taint);
        return var8DB59AA9A0821BE4812A8E2F6919F1D5_1426518529;
        // ---------- Original Method ----------
        //return getString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.664 -0400", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "F796154826623AAA81B005344F4919E7")
    public byte[] getOctets() {
        byte[] varB45CFFE084DD3D20D928BEE85E7B0F21_253619164 = (string);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1951164772 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1951164772;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.665 -0400", hash_original_method = "7109223BA8B3755943761B0801F71200", hash_generated_method = "F88007CD612C447D9E6A0F14C5CFAD23")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(UNIVERSAL_STRING, this.getOctets());
        // ---------- Original Method ----------
        //out.writeEncoded(UNIVERSAL_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.666 -0400", hash_original_method = "2C48DF670B2A84721AF2DD998EBDD99A", hash_generated_method = "CA97362764E90AAE26BA49353C946BE2")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
        if(!(o instanceof DERUniversalString))        
        {
            boolean var68934A3E9455FA72420237EB05902327_955585652 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1379486864 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1379486864;
        } //End block
        boolean var5FB290BD94CF14033886264596514A2E_1583141925 = (this.getString().equals(((DERUniversalString)o).getString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1896564495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1896564495;
        // ---------- Original Method ----------
        //if (!(o instanceof DERUniversalString))
        //{
            //return false;
        //}
        //return this.getString().equals(((DERUniversalString)o).getString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.667 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "5F6DB062E852EBBDF95729E6EF68ADF2")
    public int hashCode() {
        int var5EE87F4C9D30CCD0C63D46FAC325C3D6_2008375627 = (this.getString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_323012153 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_323012153;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.667 -0400", hash_original_field = "5102FEFA75F1FF15CF0FF9123C653112", hash_generated_field = "4F8597255A63B9818A65C2C1EBCFBC6D")

    private static final char[] table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
}


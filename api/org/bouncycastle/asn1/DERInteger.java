package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;
import java.math.BigInteger;

import org.bouncycastle.util.Arrays;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DERInteger extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.366 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "AB97A4156FC1CC1DAF26375194010FF1")

    byte[] bytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.366 -0400", hash_original_method = "5201B112432D21625783310AA9CEC395", hash_generated_method = "42720B8B1671B205A71B78FEF08907A6")
    public  DERInteger(
        int         value) {
        bytes = BigInteger.valueOf(value).toByteArray();
        // ---------- Original Method ----------
        //bytes = BigInteger.valueOf(value).toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.366 -0400", hash_original_method = "52A85FB71F259AF94A4C569903FA35A3", hash_generated_method = "E20D10919EB5723E10B3A8A6847E53D2")
    public  DERInteger(
        BigInteger   value) {
        bytes = value.toByteArray();
        // ---------- Original Method ----------
        //bytes = value.toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.367 -0400", hash_original_method = "742445D1CBEB8EC33F0452B05DE17699", hash_generated_method = "3B54D0B289C9422429FE1852B21923A5")
    public  DERInteger(
        byte[]   bytes) {
        this.bytes = bytes;
        // ---------- Original Method ----------
        //this.bytes = bytes;
    }

    
    @DSModeled(DSC.SPEC)
    public static DERInteger getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERInteger)
        {
            return (DERInteger)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    public static DERInteger getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERInteger)
        {
            return getInstance(o);
        }
        else
        {
            return new ASN1Integer(ASN1OctetString.getInstance(obj.getObject()).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.367 -0400", hash_original_method = "9CD9452AB0CD35F4B73E8FBD8DC6F0C8", hash_generated_method = "A0DC8DF6C45ABB47EDF2D59BBD9EC28F")
    public BigInteger getValue() {
BigInteger varE4C146659CDD6B837AD2066CCD33EC90_665067192 =         new BigInteger(bytes);
        varE4C146659CDD6B837AD2066CCD33EC90_665067192.addTaint(taint);
        return varE4C146659CDD6B837AD2066CCD33EC90_665067192;
        // ---------- Original Method ----------
        //return new BigInteger(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.368 -0400", hash_original_method = "71BDB36FFF593CAF4C9E79EFECF43EBD", hash_generated_method = "D5E6D2B22C023C77086D373F573F0175")
    public BigInteger getPositiveValue() {
BigInteger var7698F9817E45674D2D13D01E9A3007E4_1654450930 =         new BigInteger(1, bytes);
        var7698F9817E45674D2D13D01E9A3007E4_1654450930.addTaint(taint);
        return var7698F9817E45674D2D13D01E9A3007E4_1654450930;
        // ---------- Original Method ----------
        //return new BigInteger(1, bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.368 -0400", hash_original_method = "01662A631E5ACE6C7726FCC0828E9E63", hash_generated_method = "2A6EA4ADDC9E9D048BA1CE0AD22E8810")
     void encode(
        DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(INTEGER, bytes);
        // ---------- Original Method ----------
        //out.writeEncoded(INTEGER, bytes);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.369 -0400", hash_original_method = "473F358B008FFCD851D487BD1750243E", hash_generated_method = "D40EDC26C65022C6ABFF5E66200079CC")
    public int hashCode() {
        int value = 0;
for(int i = 0;i != bytes.length;i++)
        {
            value ^= (bytes[i] & 0xff) << (i % 4);
        } //End block
        int var2063C1608D6E0BAF80249C42E2BE5804_1056439930 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819327814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819327814;
        // ---------- Original Method ----------
        //int     value = 0;
        //for (int i = 0; i != bytes.length; i++)
         //{
             //value ^= (bytes[i] & 0xff) << (i % 4);
         //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.369 -0400", hash_original_method = "A031FF36E08BD1C92CE6416060813BEC", hash_generated_method = "BE45389536FFA3222350511B6B670046")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
        if(!(o instanceof DERInteger))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1103876887 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144476072 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144476072;
        } //End block
        DERInteger other = (DERInteger)o;
        boolean varCEDE50EF1F8187EEE555CDE0434A8B05_669837755 = (Arrays.areEqual(bytes, other.bytes));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1162981054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1162981054;
        // ---------- Original Method ----------
        //if (!(o instanceof DERInteger))
        //{
            //return false;
        //}
        //DERInteger other = (DERInteger)o;
        //return Arrays.areEqual(bytes, other.bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.369 -0400", hash_original_method = "EFB82D2D11830675F5DB319D1D1561C4", hash_generated_method = "0F8EAA248A9ABA6635545B7C2BB22B82")
    public String toString() {
String var1D0CCDA7D64D5831623D6828115D6FF2_558379800 =         getValue().toString();
        var1D0CCDA7D64D5831623D6828115D6FF2_558379800.addTaint(taint);
        return var1D0CCDA7D64D5831623D6828115D6FF2_558379800;
        // ---------- Original Method ----------
        //return getValue().toString();
    }

    
}


package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class DERBoolean extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.932 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "8CCAF7A9B8382D1617ADC5CB954C674D")

    private byte value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.932 -0400", hash_original_method = "DE46F6E30E17087250BC7B7B32B3A323", hash_generated_method = "32679D1A7F651A39D96A5F1BE8D9BE83")
    protected  DERBoolean(
        boolean     value) {
        this.value = (value) ? (byte)0xff : (byte)0;
        // ---------- Original Method ----------
        //this.value = (value) ? (byte)0xff : (byte)0;
    }

    
        @DSModeled(DSC.SPEC)
    public static DERBoolean getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERBoolean)
        {
            return (DERBoolean)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        @DSModeled(DSC.SAFE)
    public static DERBoolean getInstance(
        boolean  value) {
        return (value ? TRUE : FALSE);
    }

    
        @DSModeled(DSC.SAFE)
    public static DERBoolean getInstance(
        byte[] octets) {
        return (octets[0] != 0) ? TRUE : FALSE;
    }

    
        public static DERBoolean getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERBoolean)
        {
            return getInstance(o);
        }
        else
        {
            return getInstance(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.933 -0400", hash_original_method = "CAF36277BE2299D4A97B34E514847231", hash_generated_method = "A4FF6E5CBF9343D4B02AF44EBC3B30A6")
    public boolean isTrue() {
        boolean var4661EA07E82336BE9B2AECA9A764B18E_125028910 = ((value != 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1584362352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1584362352;
        // ---------- Original Method ----------
        //return (value != 0);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.935 -0400", hash_original_method = "17536CB7674727E81A6C11BC3F7B5C5B", hash_generated_method = "339736C0392F9DA44B50A766C32B8CD3")
     void encode(
        DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        byte[] bytes = new byte[1];
        bytes[0] = value;
        out.writeEncoded(BOOLEAN, bytes);
        // ---------- Original Method ----------
        //byte[]  bytes = new byte[1];
        //bytes[0] = value;
        //out.writeEncoded(BOOLEAN, bytes);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.942 -0400", hash_original_method = "7025372BC5443A52FED5B1B11C72A34D", hash_generated_method = "8484472E9AE9B04FE2945E6EEB4944A5")
    protected boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
    if((o == null) || !(o instanceof DERBoolean))        
        {
            boolean var68934A3E9455FA72420237EB05902327_557939159 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732857600 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732857600;
        } //End block
        boolean var046E5C2E5199CE2B37C484B6DC4530E0_1829006475 = ((value == ((DERBoolean)o).value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_918256149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_918256149;
        // ---------- Original Method ----------
        //if ((o == null) || !(o instanceof DERBoolean))
        //{
            //return false;
        //}
        //return (value == ((DERBoolean)o).value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.943 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "973546ECB6481D7B1C6A4C2C38A14420")
    public int hashCode() {
        int var2063C1608D6E0BAF80249C42E2BE5804_1426732188 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1493689228 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1493689228;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.944 -0400", hash_original_method = "9F6A9420185E5E125B8A61B3882EDFBB", hash_generated_method = "DD9302D3246BD844F67C510F07029EC2")
    public String toString() {
String var304B31753549FEAA0EC0E7EC343CD6BE_1774561757 =         (value != 0) ? "TRUE" : "FALSE";
        var304B31753549FEAA0EC0E7EC343CD6BE_1774561757.addTaint(taint);
        return var304B31753549FEAA0EC0E7EC343CD6BE_1774561757;
        // ---------- Original Method ----------
        //return (value != 0) ? "TRUE" : "FALSE";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.944 -0400", hash_original_field = "954CDE13DC4345C4B66DC594DD7EB8A1", hash_generated_field = "AD41B06028B6D238FF4AF850CAEFE733")

    public static final DERBoolean FALSE = new DERBoolean(false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.944 -0400", hash_original_field = "75C038426B85F270822D4441A8A13DF1", hash_generated_field = "74021F0F40550CDAE080A69CBD04BF42")

    public static final DERBoolean TRUE  = new DERBoolean(true);
}


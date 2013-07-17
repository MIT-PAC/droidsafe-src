package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Type;

public final class CRLNumber extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.868 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "74AD3D429EE1BAEF847B6467FE79538D")

    private BigInteger number;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.869 -0400", hash_original_method = "F2D26D3BB1859BB9D7AC567B8EA30F7D", hash_generated_method = "E13ABED8946C422780CE8CDBBC8C2031")
    public  CRLNumber(byte[] encoding) throws IOException {
        super(encoding);
        number = new BigInteger((byte[]) ASN1.decode(encoding));
        // ---------- Original Method ----------
        //number = new BigInteger((byte[]) ASN1.decode(encoding));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.870 -0400", hash_original_method = "ABBA63B4278019F3F838A8B1357B04F0", hash_generated_method = "4AA8027143919FF0AE575F4DAD191BD9")
    public BigInteger getNumber() {
BigInteger var63E80DF571E08DAA47BEFBF0BD0EEBAD_1533690070 =         number;
        var63E80DF571E08DAA47BEFBF0BD0EEBAD_1533690070.addTaint(taint);
        return var63E80DF571E08DAA47BEFBF0BD0EEBAD_1533690070;
        // ---------- Original Method ----------
        //return number;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.871 -0400", hash_original_method = "264373D11CB6B7A95DC9A45E336ACDCB", hash_generated_method = "BD326F9AAFD268A9069013988DEF2123")
    @Override
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(number.toByteArray());
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1776692231 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_200246330 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_200246330;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(number.toByteArray());
        //}
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.871 -0400", hash_original_method = "C82E67A30D76F52198943C49A8E53C0F", hash_generated_method = "14D8E9996402DC284C132D873CAB6495")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("CRL Number: [ ").append(number).append(" ]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("CRL Number: [ ").append(number).append(" ]\n");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.871 -0400", hash_original_field = "B667F312D4B19901372E246437BDE029", hash_generated_field = "7B920D394449223FD2E6E364A4B27926")

    public static final ASN1Type ASN1 = ASN1Integer.getInstance();
}


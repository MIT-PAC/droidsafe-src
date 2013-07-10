package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Type;

public final class CRLNumber extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.688 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "74AD3D429EE1BAEF847B6467FE79538D")

    private BigInteger number;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.689 -0400", hash_original_method = "F2D26D3BB1859BB9D7AC567B8EA30F7D", hash_generated_method = "E13ABED8946C422780CE8CDBBC8C2031")
    public  CRLNumber(byte[] encoding) throws IOException {
        super(encoding);
        number = new BigInteger((byte[]) ASN1.decode(encoding));
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.689 -0400", hash_original_method = "ABBA63B4278019F3F838A8B1357B04F0", hash_generated_method = "AEB4E1358A230BF6CF85F353CE98F91C")
    public BigInteger getNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1742149489 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1742149489 = number;
        varB4EAC82CA7396A68D541C85D26508E83_1742149489.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1742149489;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.689 -0400", hash_original_method = "264373D11CB6B7A95DC9A45E336ACDCB", hash_generated_method = "0A3747311B76CBD84AB60845BA99A1C5")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(number.toByteArray());
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_502774150 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_502774150;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.690 -0400", hash_original_method = "C82E67A30D76F52198943C49A8E53C0F", hash_generated_method = "2A6D123AAAC0A36523C75A7BA374D166")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("CRL Number: [ ").append(number).append(" ]\n");
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.690 -0400", hash_original_field = "B667F312D4B19901372E246437BDE029", hash_generated_field = "7B920D394449223FD2E6E364A4B27926")

    public static final ASN1Type ASN1 = ASN1Integer.getInstance();
}


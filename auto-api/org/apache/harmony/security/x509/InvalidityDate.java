package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.Date;
import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Type;

public final class InvalidityDate extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.143 -0400", hash_original_field = "5FC732311905CB27E82D67F4F6511F7F", hash_generated_field = "64CE46416AB14CBD0C0CFE7A851676E2")

    private Date date;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.144 -0400", hash_original_method = "98A9E577A59DEA03C0EE49B7902CB339", hash_generated_method = "3CB2D9165E68212C202C773456E8842D")
    public  InvalidityDate(byte[] encoding) throws IOException {
        super(encoding);
        date = (Date) ASN1.decode(encoding);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.144 -0400", hash_original_method = "0B806974B94533A41261B38C9B34792D", hash_generated_method = "5142F612E7A8424A19356C46716E001E")
    public Date getDate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_972241890 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_972241890 = date;
        varB4EAC82CA7396A68D541C85D26508E83_972241890.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_972241890;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.144 -0400", hash_original_method = "B06BF934ECBF90D26364500F0540AD98", hash_generated_method = "E01252DBC269E0D6727F100596938755")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(date);
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1732044656 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1732044656;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.145 -0400", hash_original_method = "CC2AAAF6B06623B04694869CF132851E", hash_generated_method = "6EB0317809DF1762A2390586D082DFC8")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Invalidity Date: [ ").append(date).append(" ]\n");
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.145 -0400", hash_original_field = "79E362F71ED62FF887623A3C07FAEE8A", hash_generated_field = "9BCF15C1FFDD11FFF02BAB5AC5C1860B")

    public static final ASN1Type ASN1 = ASN1GeneralizedTime.getInstance();
}


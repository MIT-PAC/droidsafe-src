package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Date;
import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Type;

public final class InvalidityDate extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.123 -0400", hash_original_field = "5FC732311905CB27E82D67F4F6511F7F", hash_generated_field = "64CE46416AB14CBD0C0CFE7A851676E2")

    private Date date;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.123 -0400", hash_original_method = "98A9E577A59DEA03C0EE49B7902CB339", hash_generated_method = "3CB2D9165E68212C202C773456E8842D")
    public  InvalidityDate(byte[] encoding) throws IOException {
        super(encoding);
        date = (Date) ASN1.decode(encoding);
        // ---------- Original Method ----------
        //date = (Date) ASN1.decode(encoding);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.123 -0400", hash_original_method = "0B806974B94533A41261B38C9B34792D", hash_generated_method = "56FDD66054CBCB181FA349A7A9CB466D")
    public Date getDate() {
Date var1F31043EE3B8C862CA53EA8B99691F13_1589957941 =         date;
        var1F31043EE3B8C862CA53EA8B99691F13_1589957941.addTaint(taint);
        return var1F31043EE3B8C862CA53EA8B99691F13_1589957941;
        // ---------- Original Method ----------
        //return date;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.124 -0400", hash_original_method = "B06BF934ECBF90D26364500F0540AD98", hash_generated_method = "F8086DB9370DE0F93591E905A5055A6D")
    @Override
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = ASN1.encode(date);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1906314740 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1971199822 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1971199822;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(date);
        //}
        //return encoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.124 -0400", hash_original_method = "CC2AAAF6B06623B04694869CF132851E", hash_generated_method = "9CEADBB37D860329F66ABC139E730BC4")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("Invalidity Date: [ ").append(date).append(" ]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("Invalidity Date: [ ").append(date).append(" ]\n");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.124 -0400", hash_original_field = "79E362F71ED62FF887623A3C07FAEE8A", hash_generated_field = "9BCF15C1FFDD11FFF02BAB5AC5C1860B")

    public static final ASN1Type ASN1 = ASN1GeneralizedTime.getInstance();
}


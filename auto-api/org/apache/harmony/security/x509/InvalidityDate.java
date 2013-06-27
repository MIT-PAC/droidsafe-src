package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Date;
import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Type;

public final class InvalidityDate extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.962 -0400", hash_original_field = "5FC732311905CB27E82D67F4F6511F7F", hash_generated_field = "64CE46416AB14CBD0C0CFE7A851676E2")

    private Date date;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.963 -0400", hash_original_method = "98A9E577A59DEA03C0EE49B7902CB339", hash_generated_method = "3CB2D9165E68212C202C773456E8842D")
    public  InvalidityDate(byte[] encoding) throws IOException {
        super(encoding);
        date = (Date) ASN1.decode(encoding);
        // ---------- Original Method ----------
        //date = (Date) ASN1.decode(encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.963 -0400", hash_original_method = "0B806974B94533A41261B38C9B34792D", hash_generated_method = "6E4D149F559A9C9FB66727ABE82A4E61")
    public Date getDate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_406742262 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_406742262 = date;
        varB4EAC82CA7396A68D541C85D26508E83_406742262.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_406742262;
        // ---------- Original Method ----------
        //return date;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.964 -0400", hash_original_method = "B06BF934ECBF90D26364500F0540AD98", hash_generated_method = "E872BE71AFBB1B5BA2A73BF4EEA69DF3")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(date);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1513036509 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1513036509;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(date);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.964 -0400", hash_original_method = "CC2AAAF6B06623B04694869CF132851E", hash_generated_method = "6EB0317809DF1762A2390586D082DFC8")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Invalidity Date: [ ").append(date).append(" ]\n");
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //sb.append(prefix).append("Invalidity Date: [ ").append(date).append(" ]\n");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.964 -0400", hash_original_field = "79E362F71ED62FF887623A3C07FAEE8A", hash_generated_field = "9BCF15C1FFDD11FFF02BAB5AC5C1860B")

    public static final ASN1Type ASN1 = ASN1GeneralizedTime.getInstance();
}


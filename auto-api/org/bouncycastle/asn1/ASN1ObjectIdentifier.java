package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ASN1ObjectIdentifier extends DERObjectIdentifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.566 -0400", hash_original_method = "5D809321835D0BA25C10E4492B1A0DC6", hash_generated_method = "DAACAE5FD40E4B46E7C6A20CFC027519")
    public  ASN1ObjectIdentifier(String identifier) {
        super(identifier);
        addTaint(identifier.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.566 -0400", hash_original_method = "EF822DF50E24A8FAE333A23CFFE3D191", hash_generated_method = "800270272E59DBE5A948B225A5E9BCB1")
      ASN1ObjectIdentifier(byte[] bytes) {
        super(bytes);
        addTaint(bytes[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.567 -0400", hash_original_method = "DFE7160E8E684D8D4AB128F02145CDAB", hash_generated_method = "E78504AC746F298C4D076553A8BF390D")
    public ASN1ObjectIdentifier branch(String branchID) {
        ASN1ObjectIdentifier varB4EAC82CA7396A68D541C85D26508E83_1881709059 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1881709059 = new ASN1ObjectIdentifier(getId() + "." + branchID);
        addTaint(branchID.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1881709059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1881709059;
        // ---------- Original Method ----------
        //return new ASN1ObjectIdentifier(getId() + "." + branchID);
    }

    
}


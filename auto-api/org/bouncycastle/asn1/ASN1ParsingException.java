package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ASN1ParsingException extends IllegalStateException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.603 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.604 -0400", hash_original_method = "A04BEE8A9A73EAD532708A0AE36FAA5C", hash_generated_method = "B74E3B8C969CC011DCD96E67B42BFF1B")
      ASN1ParsingException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.604 -0400", hash_original_method = "9ABB1845457B0FD65DC264E5CAAB1469", hash_generated_method = "75E511F5872A529C998A34438C937DDE")
      ASN1ParsingException(String message, Throwable cause) {
        super(message);
        this.cause = cause;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //this.cause = cause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.620 -0400", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "5661FE600620EECAA355255BF8C4D2C9")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1744717427 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1744717427 = cause;
        varB4EAC82CA7396A68D541C85D26508E83_1744717427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1744717427;
        // ---------- Original Method ----------
        //return cause;
    }

    
}


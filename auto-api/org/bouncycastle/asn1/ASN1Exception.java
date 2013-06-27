package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class ASN1Exception extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.520 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.521 -0400", hash_original_method = "723A1DBA8406751CA0BE121F0D1A9151", hash_generated_method = "BCDB967B921E585F1BBFBFA3FF4A327F")
      ASN1Exception(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.522 -0400", hash_original_method = "D17952479D481E219D9ED9BCF5D089F2", hash_generated_method = "9652B0507CB84355CD198EEA354F92AE")
      ASN1Exception(String message, Throwable cause) {
        super(message);
        this.cause = cause;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //this.cause = cause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.522 -0400", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "CE82C314BE432922C6BCC05C27DE2CEB")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_784538821 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_784538821 = cause;
        varB4EAC82CA7396A68D541C85D26508E83_784538821.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_784538821;
        // ---------- Original Method ----------
        //return cause;
    }

    
}


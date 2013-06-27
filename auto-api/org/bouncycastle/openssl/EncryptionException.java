package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class EncryptionException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.507 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.508 -0400", hash_original_method = "0A5225B15FFCBBF051BE0F84A5007C61", hash_generated_method = "89AC63CD9CB583D280CD505887C5F8E6")
    public  EncryptionException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.508 -0400", hash_original_method = "FE6B7F9DB7E1AFAF6DF8BCFDDE4BB303", hash_generated_method = "8C6C6FBA20458EA64DE1908DC2D1E519")
    public  EncryptionException(String msg, Throwable ex) {
        super(msg);
        this.cause = ex;
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //this.cause = ex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.508 -0400", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "4DCC933AF6AC70341D7E0E47F40EF781")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_2010764433 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2010764433 = cause;
        varB4EAC82CA7396A68D541C85D26508E83_2010764433.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2010764433;
        // ---------- Original Method ----------
        //return cause;
    }

    
}


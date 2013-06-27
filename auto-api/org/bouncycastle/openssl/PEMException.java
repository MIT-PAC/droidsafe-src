package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class PEMException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.574 -0400", hash_original_field = "4AB57483724829010C32E288B605D5E5", hash_generated_field = "C31C43ABE3D5D61AFE96A228698D8959")

    Exception underlying;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.574 -0400", hash_original_method = "DBCE2D6935FCAE6513D26D3BE9F92180", hash_generated_method = "3B5A6E1FAC809290D7BA159E9C8E5806")
    public  PEMException(
        String    message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.575 -0400", hash_original_method = "62F9842AAA557466DBCCBFAEB65A702E", hash_generated_method = "A5BC716F0065DC3FA7BB289F535CD8CC")
    public  PEMException(
        String        message,
        Exception    underlying) {
        super(message);
        this.underlying = underlying;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //this.underlying = underlying;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.584 -0400", hash_original_method = "8D4B98C08FC53F956480CC6A65685E20", hash_generated_method = "10B4544675B2E0636F741E11F132713B")
    public Exception getUnderlyingException() {
        Exception varB4EAC82CA7396A68D541C85D26508E83_1028861670 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1028861670 = underlying;
        varB4EAC82CA7396A68D541C85D26508E83_1028861670.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1028861670;
        // ---------- Original Method ----------
        //return underlying;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.584 -0400", hash_original_method = "F2813220852B09056C9C149C0538BE80", hash_generated_method = "0019BDA6A18BE156A7A081901624E5C7")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_2133835730 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2133835730 = underlying;
        varB4EAC82CA7396A68D541C85D26508E83_2133835730.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2133835730;
        // ---------- Original Method ----------
        //return underlying;
    }

    
}


package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class PEMException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.522 -0400", hash_original_field = "4AB57483724829010C32E288B605D5E5", hash_generated_field = "C31C43ABE3D5D61AFE96A228698D8959")

    Exception underlying;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.523 -0400", hash_original_method = "DBCE2D6935FCAE6513D26D3BE9F92180", hash_generated_method = "3B5A6E1FAC809290D7BA159E9C8E5806")
    public  PEMException(
        String    message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.523 -0400", hash_original_method = "62F9842AAA557466DBCCBFAEB65A702E", hash_generated_method = "A5BC716F0065DC3FA7BB289F535CD8CC")
    public  PEMException(
        String        message,
        Exception    underlying) {
        super(message);
        this.underlying = underlying;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //this.underlying = underlying;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.524 -0400", hash_original_method = "8D4B98C08FC53F956480CC6A65685E20", hash_generated_method = "16B5E3F020F14567024D7DD84F29320D")
    public Exception getUnderlyingException() {
        Exception varB4EAC82CA7396A68D541C85D26508E83_1568842062 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1568842062 = underlying;
        varB4EAC82CA7396A68D541C85D26508E83_1568842062.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1568842062;
        // ---------- Original Method ----------
        //return underlying;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.524 -0400", hash_original_method = "F2813220852B09056C9C149C0538BE80", hash_generated_method = "9DF70198659EBB205EFC4C51B05FD9B1")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_2136412645 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2136412645 = underlying;
        varB4EAC82CA7396A68D541C85D26508E83_2136412645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2136412645;
        // ---------- Original Method ----------
        //return underlying;
    }

    
}


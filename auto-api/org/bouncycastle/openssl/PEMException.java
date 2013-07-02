package org.bouncycastle.openssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class PEMException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.007 -0400", hash_original_field = "4AB57483724829010C32E288B605D5E5", hash_generated_field = "C31C43ABE3D5D61AFE96A228698D8959")

    Exception underlying;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.007 -0400", hash_original_method = "DBCE2D6935FCAE6513D26D3BE9F92180", hash_generated_method = "3B5A6E1FAC809290D7BA159E9C8E5806")
    public  PEMException(
        String    message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.007 -0400", hash_original_method = "62F9842AAA557466DBCCBFAEB65A702E", hash_generated_method = "A5BC716F0065DC3FA7BB289F535CD8CC")
    public  PEMException(
        String        message,
        Exception    underlying) {
        super(message);
        this.underlying = underlying;
        addTaint(message.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.008 -0400", hash_original_method = "8D4B98C08FC53F956480CC6A65685E20", hash_generated_method = "C650DD616A8E6BBC649DB00C8D3A6459")
    public Exception getUnderlyingException() {
        Exception varB4EAC82CA7396A68D541C85D26508E83_1555947144 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1555947144 = underlying;
        varB4EAC82CA7396A68D541C85D26508E83_1555947144.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1555947144;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.008 -0400", hash_original_method = "F2813220852B09056C9C149C0538BE80", hash_generated_method = "BF94770209F8EE90C1EF649C8347BFDB")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_822698260 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_822698260 = underlying;
        varB4EAC82CA7396A68D541C85D26508E83_822698260.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_822698260;
        
        
    }

    
}


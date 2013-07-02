package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class PrivilegedActionException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.432 -0400", hash_original_method = "EDD6A4125897553733853A01EFA0A0B7", hash_generated_method = "AF1093C48D4324A2D9FF70091893DC5F")
    public  PrivilegedActionException(Exception ex) {
        super(ex);
        addTaint(ex.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.432 -0400", hash_original_method = "96C5131DB95D0ADB8B79CD396371D505", hash_generated_method = "234F8BF48A3E68F5400319B6C53979E2")
    public Exception getException() {
        Exception varB4EAC82CA7396A68D541C85D26508E83_245783535 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_245783535 = null;
        varB4EAC82CA7396A68D541C85D26508E83_245783535.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_245783535;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.432 -0400", hash_original_field = "C6EE766F2D182B1AF374A82150C8909C", hash_generated_field = "5A2756170436A968A38DABC1A0F1BBB0")

    private static final long serialVersionUID = 4724086851538908602l;
}


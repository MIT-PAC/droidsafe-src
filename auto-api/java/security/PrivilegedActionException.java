package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PrivilegedActionException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.108 -0400", hash_original_method = "EDD6A4125897553733853A01EFA0A0B7", hash_generated_method = "AF1093C48D4324A2D9FF70091893DC5F")
    public  PrivilegedActionException(Exception ex) {
        super(ex);
        addTaint(ex.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.108 -0400", hash_original_method = "96C5131DB95D0ADB8B79CD396371D505", hash_generated_method = "EAEC6936788B6A61E54815FF03912220")
    public Exception getException() {
        Exception varB4EAC82CA7396A68D541C85D26508E83_1488331972 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1488331972 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1488331972.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1488331972;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.108 -0400", hash_original_field = "C6EE766F2D182B1AF374A82150C8909C", hash_generated_field = "01A2824FA17B9A770D176999387269DD")

    private static long serialVersionUID = 4724086851538908602l;
}


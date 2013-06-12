package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class OptionalDataException extends ObjectStreamException {
    private static final long serialVersionUID = -8011121865681257820L;
    public boolean eof;
    public int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:22:14.264 -0400", hash_original_method = "C77AFC0EE27E4B45ACE7BE98CCDC7A8A", hash_generated_method = "C4CCD4A3BDF951152BD3114E3E7669AD")
    @DSModeled(DSC.SAFE)
     OptionalDataException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:22:14.269 -0400", hash_original_method = "EE3BF9736C6F166E6F73C7336660246A", hash_generated_method = "205A2E0F185C7EE3323421EB4FEE7EBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     OptionalDataException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}



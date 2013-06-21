package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class OptionalDataException extends ObjectStreamException {
    public boolean eof;
    public int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.183 -0400", hash_original_method = "C77AFC0EE27E4B45ACE7BE98CCDC7A8A", hash_generated_method = "D7539358F0EC362E989324DB6CBCFA5C")
    @DSModeled(DSC.SAFE)
     OptionalDataException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.183 -0400", hash_original_method = "EE3BF9736C6F166E6F73C7336660246A", hash_generated_method = "C91352DCF9CCA55383BE74EF950ADAD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     OptionalDataException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -8011121865681257820L;
}


package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnrecoverableKeyException extends UnrecoverableEntryException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.612 -0400", hash_original_method = "E20357D553B788F278F646C0E3221E57", hash_generated_method = "412BDED3421627C40FB42DCC35166C6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnrecoverableKeyException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.612 -0400", hash_original_method = "03224602BAA5F9956174116E90B167DC", hash_generated_method = "457CE1EC41599347D74B5CD5A4C0D88F")
    @DSModeled(DSC.SAFE)
    public UnrecoverableKeyException() {
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 7275063078190151277L;
}


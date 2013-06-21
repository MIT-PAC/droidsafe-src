package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoClassDefFoundError extends LinkageError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.892 -0400", hash_original_method = "8CFE32FE45EF5975C0AEC893301BEE4B", hash_generated_method = "0E91492388418CA4E74C2221C3AD3DDC")
    @DSModeled(DSC.SAFE)
    public NoClassDefFoundError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.892 -0400", hash_original_method = "88A7AB7FEE2EA03213AF9C41CB5D2B15", hash_generated_method = "DF39BE13A4EB16187E950BC1CFA58BFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoClassDefFoundError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 9095859863287012458L;
}


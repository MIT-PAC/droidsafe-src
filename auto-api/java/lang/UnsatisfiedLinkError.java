package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnsatisfiedLinkError extends LinkageError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.652 -0400", hash_original_method = "4F1AAD53B033EB263910F7523EBBB434", hash_generated_method = "7AB5ED1DC96BEAEC657FF0F58A7545D2")
    @DSModeled(DSC.SAFE)
    public UnsatisfiedLinkError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.653 -0400", hash_original_method = "B54BA137AD45C0554FF2013805B3936E", hash_generated_method = "C4470177E4E2CD8F2B7FA6FC0CCC02D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsatisfiedLinkError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -4019343241616879428L;
}


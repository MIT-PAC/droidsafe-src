package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IncompatibleClassChangeError extends LinkageError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.746 -0400", hash_original_method = "38CC6ACCD85379A3B9DD104582709484", hash_generated_method = "E2CC95403ED1D8F0D7622D45695DC5F3")
    @DSModeled(DSC.SAFE)
    public IncompatibleClassChangeError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.746 -0400", hash_original_method = "F3D6EF8EF2783206A3E0857F77261690", hash_generated_method = "F66F05D194EB3A9D282713414C762077")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IncompatibleClassChangeError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -4914975503642802119L;
}


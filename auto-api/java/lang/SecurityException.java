package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SecurityException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.034 -0400", hash_original_method = "0D8A79337436926212C4E8DACFE6A955", hash_generated_method = "49F62E2C6329A19237B5CEBA0FFCFB90")
    @DSModeled(DSC.SAFE)
    public SecurityException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.035 -0400", hash_original_method = "35201AC9E2F0540A3FCA08DB4F71F2A3", hash_generated_method = "7E89FA5F6235BD7B6A297FD533A1B8A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.035 -0400", hash_original_method = "6D3B8DD6DA516F6B2B4EBB83E8379AAA", hash_generated_method = "A71C334889E9B8A2AF3DD75591C92AC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.035 -0400", hash_original_method = "B0CE861A38AC7D57FFFB507001C97872", hash_generated_method = "0DA8DD59792093EA35DC4B1950111571")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 6878364983674394167L;
}


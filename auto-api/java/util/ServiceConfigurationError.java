package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ServiceConfigurationError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.220 -0400", hash_original_method = "EBAE74DC80F9C6BC38A9630AD570AE77", hash_generated_method = "8166FEB2A7CFBD5A660988010F43ACE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceConfigurationError(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.220 -0400", hash_original_method = "29CC4F4897E024335846D9CA60D25833", hash_generated_method = "3554FB338FC4659EA558F86D7499D112")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceConfigurationError(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 74132770414881L;
}


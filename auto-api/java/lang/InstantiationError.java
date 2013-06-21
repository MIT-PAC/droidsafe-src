package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InstantiationError extends IncompatibleClassChangeError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.749 -0400", hash_original_method = "0CADFA7EDCF977E1C3E40BA09A641E39", hash_generated_method = "FBD8BFBFF8541964AECF4F628B71A9C5")
    @DSModeled(DSC.SAFE)
    public InstantiationError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.749 -0400", hash_original_method = "023CF4960A8F6AD78560985CF4A496AC", hash_generated_method = "5263B67F136AC1F60B40016FF4158975")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InstantiationError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.749 -0400", hash_original_method = "715FEA28AECD396E352AFBA27C6E8A8B", hash_generated_method = "E1BC4818EB708C09885299DDD7CC655F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InstantiationError(Class<?> clazz) {
        super(clazz.getName());
        dsTaint.addTaint(clazz.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -4885810657349421204L;
}


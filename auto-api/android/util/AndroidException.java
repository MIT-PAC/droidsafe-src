package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AndroidException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.087 -0400", hash_original_method = "B114E564F5DD3A8162C6B705516D48E4", hash_generated_method = "8C3552774B1B809997CFE9A91843D730")
    @DSModeled(DSC.SAFE)
    public AndroidException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.087 -0400", hash_original_method = "891590FF533F04EE265F2E23F15D3AEC", hash_generated_method = "1EF45C02849C9723FC02BFCF036470E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidException(String name) {
        super(name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.087 -0400", hash_original_method = "B244007C3BAFD44F95BE0B614ABC1B32", hash_generated_method = "F6E1E5904B72855CC5F4129C634EB073")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidException(String name, Throwable cause) {
        super(name, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.087 -0400", hash_original_method = "C5375F3D80EA6460B68F9344F734F18D", hash_generated_method = "6D9C9FD9C133B646AF31ABA3705D7038")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidException(Exception cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


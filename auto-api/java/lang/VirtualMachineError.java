package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class VirtualMachineError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.681 -0400", hash_original_method = "0F69B8238323DB052C2C0DA7A3D55736", hash_generated_method = "BD1C14FF154705C3FFBF881DDDA61EC6")
    @DSModeled(DSC.SAFE)
    public VirtualMachineError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.681 -0400", hash_original_method = "93E73561FDCA8CBD84645ED54333765D", hash_generated_method = "72327C9603D05F2259D64FF38F03B5BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public VirtualMachineError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 4161983926571568670L;
}


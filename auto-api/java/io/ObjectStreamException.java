package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class ObjectStreamException extends IOException {
    private static final long serialVersionUID = 7260898174833392607L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.631 -0400", hash_original_method = "7277EDCE895E14A1718765213C9E754B", hash_generated_method = "9443F2E363210253F8B53A3502EF78FA")
    @DSModeled(DSC.SAFE)
    protected ObjectStreamException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.631 -0400", hash_original_method = "B5966321481D67D0B2EAAF8863CF68D1", hash_generated_method = "EE327791BE07AA6DEB0E68135197997B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ObjectStreamException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}



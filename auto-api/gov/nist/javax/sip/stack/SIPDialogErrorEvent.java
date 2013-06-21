package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;

public class SIPDialogErrorEvent extends EventObject {
    private int errorID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.434 -0400", hash_original_method = "63B6C69AA01911B678EB33AE8A4167CE", hash_generated_method = "7E66F4DF3527A1E6CD6586EB40DD8222")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SIPDialogErrorEvent(
        SIPDialog sourceDialog,
        int dialogErrorID) {
        super(sourceDialog);
        dsTaint.addTaint(dialogErrorID);
        dsTaint.addTaint(sourceDialog.dsTaint);
        // ---------- Original Method ----------
        //errorID = dialogErrorID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.434 -0400", hash_original_method = "0519EBFB6DA70B425C38921D23DA7A64", hash_generated_method = "B86210BDA60B949FF41CE9DC66CFC0C2")
    @DSModeled(DSC.SAFE)
    public int getErrorID() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return errorID;
    }

    
    public static final int DIALOG_ACK_NOT_RECEIVED_TIMEOUT = 1;
    public static final int DIALOG_ACK_NOT_SENT_TIMEOUT = 2;
    public static final int DIALOG_REINVITE_TIMEOUT = 3;
}


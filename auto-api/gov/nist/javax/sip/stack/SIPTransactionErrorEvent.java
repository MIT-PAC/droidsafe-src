package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;

public class SIPTransactionErrorEvent extends EventObject {
    private int errorID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.855 -0400", hash_original_method = "09AF95BC0271C57553075E85B6A27865", hash_generated_method = "DFB1BB6A43FAD43E5E4B77E1C93E79D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SIPTransactionErrorEvent(
        SIPTransaction sourceTransaction,
        int transactionErrorID) {
        super(sourceTransaction);
        dsTaint.addTaint(transactionErrorID);
        dsTaint.addTaint(sourceTransaction.dsTaint);
        // ---------- Original Method ----------
        //errorID = transactionErrorID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.855 -0400", hash_original_method = "0519EBFB6DA70B425C38921D23DA7A64", hash_generated_method = "B86210BDA60B949FF41CE9DC66CFC0C2")
    @DSModeled(DSC.SAFE)
    public int getErrorID() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return errorID;
    }

    
    private static final long serialVersionUID = -2713188471978065031L;
    public static final int TIMEOUT_ERROR = 1;
    public static final int TRANSPORT_ERROR = 2;
    public static final int TIMEOUT_RETRANSMIT = 3;
}


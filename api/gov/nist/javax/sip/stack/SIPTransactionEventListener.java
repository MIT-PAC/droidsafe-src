package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventListener;

public interface SIPTransactionEventListener extends EventListener {

    
    public void transactionErrorEvent(SIPTransactionErrorEvent transactionErrorEvent);
}

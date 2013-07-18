package gov.nist.javax.sip.stack;

// Droidsafe Imports
import java.util.EventListener;

public interface SIPTransactionEventListener extends EventListener {

    
    public void transactionErrorEvent(SIPTransactionErrorEvent transactionErrorEvent);
}

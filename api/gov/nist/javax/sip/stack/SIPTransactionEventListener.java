package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventListener;

public interface SIPTransactionEventListener extends EventListener {

    
    public void transactionErrorEvent(SIPTransactionErrorEvent transactionErrorEvent);
}

package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventListener;

public interface SIPTransactionEventListener extends EventListener {

    
    public void transactionErrorEvent(SIPTransactionErrorEvent transactionErrorEvent);
}

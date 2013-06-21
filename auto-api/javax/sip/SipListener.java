package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface SipListener {
    void processDialogTerminated(DialogTerminatedEvent dialogTerminatedEvent);
    void processIOException(IOExceptionEvent exceptionEvent);
    void processRequest(RequestEvent requestEvent);
    void processResponse(ResponseEvent responseEvent);
    void processTimeout(TimeoutEvent timeoutEvent);
    void processTransactionTerminated(
            TransactionTerminatedEvent transactionTerminatedEvent);
}

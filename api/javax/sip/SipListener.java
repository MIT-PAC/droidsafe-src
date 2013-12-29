package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface SipListener {
    void processDialogTerminated(DialogTerminatedEvent dialogTerminatedEvent);
    void processIOException(IOExceptionEvent exceptionEvent);
    void processRequest(RequestEvent requestEvent);
    void processResponse(ResponseEvent responseEvent);
    void processTimeout(TimeoutEvent timeoutEvent);
    void processTransactionTerminated(
            TransactionTerminatedEvent transactionTerminatedEvent);
}

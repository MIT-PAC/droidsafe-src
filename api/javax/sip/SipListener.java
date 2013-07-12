package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface SipListener {
    void processDialogTerminated(DialogTerminatedEvent dialogTerminatedEvent);
    void processIOException(IOExceptionEvent exceptionEvent);
    void processRequest(RequestEvent requestEvent);
    void processResponse(ResponseEvent responseEvent);
    void processTimeout(TimeoutEvent timeoutEvent);
    void processTransactionTerminated(
            TransactionTerminatedEvent transactionTerminatedEvent);
}

package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface SipListener {
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void processDialogTerminated(DialogTerminatedEvent dialogTerminatedEvent);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void processIOException(IOExceptionEvent exceptionEvent);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void processRequest(RequestEvent requestEvent);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void processResponse(ResponseEvent responseEvent);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void processTimeout(TimeoutEvent timeoutEvent);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void processTransactionTerminated(
            TransactionTerminatedEvent transactionTerminatedEvent);
}

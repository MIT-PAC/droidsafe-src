package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.SipListener;

public interface SipListenerExt extends SipListener {

    
    public void processDialogTimeout(DialogTimeoutEvent timeoutEvent);
}

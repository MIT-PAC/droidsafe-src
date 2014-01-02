package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.SipListener;

public interface SipListenerExt extends SipListener {

    
    public void processDialogTimeout(DialogTimeoutEvent timeoutEvent);
}

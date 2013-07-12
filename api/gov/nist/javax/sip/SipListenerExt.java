package gov.nist.javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.Dialog;
import javax.sip.SipListener;

public interface SipListenerExt extends SipListener {

    
    public void processDialogTimeout(DialogTimeoutEvent timeoutEvent);
}

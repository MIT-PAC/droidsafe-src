package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.Dialog;
import javax.sip.SipListener;

public interface SipListenerExt extends SipListener {

    
    public void processDialogTimeout(DialogTimeoutEvent timeoutEvent);
}

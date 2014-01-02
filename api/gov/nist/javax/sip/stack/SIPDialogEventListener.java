package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventListener;

public interface SIPDialogEventListener extends EventListener {

    
    public void dialogErrorEvent(SIPDialogErrorEvent dialogErrorEvent);
}

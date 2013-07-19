package gov.nist.javax.sip.stack;

// Droidsafe Imports
import java.util.EventListener;

public interface SIPDialogEventListener extends EventListener {

    
    public void dialogErrorEvent(SIPDialogErrorEvent dialogErrorEvent);
}

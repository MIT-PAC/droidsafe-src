package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.SipProvider;

public interface SipProviderExt extends SipProvider {
    
    public void setDialogErrorsAutomaticallyHandled();
}

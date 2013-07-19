package gov.nist.javax.sip;

// Droidsafe Imports
import javax.sip.SipProvider;

public interface SipProviderExt extends SipProvider {
    
    public void setDialogErrorsAutomaticallyHandled();
}

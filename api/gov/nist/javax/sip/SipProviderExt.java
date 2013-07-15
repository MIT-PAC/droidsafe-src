package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.SipProvider;

public interface SipProviderExt extends SipProvider {
    
    public void setDialogErrorsAutomaticallyHandled();
}

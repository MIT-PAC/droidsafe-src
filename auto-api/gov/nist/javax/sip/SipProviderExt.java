package gov.nist.javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.SipProvider;

public interface SipProviderExt extends SipProvider {
    
    public void setDialogErrorsAutomaticallyHandled();
}

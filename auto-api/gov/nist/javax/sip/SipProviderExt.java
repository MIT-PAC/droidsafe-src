package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.SipProvider;

public interface SipProviderExt extends SipProvider {
    
    public void setDialogErrorsAutomaticallyHandled();
}

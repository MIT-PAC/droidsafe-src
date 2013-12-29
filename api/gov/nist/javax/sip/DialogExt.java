package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.Dialog;
import javax.sip.SipProvider;

public interface DialogExt extends Dialog {

    
    public SipProvider getSipProvider();

    
    public void setBackToBackUserAgent();
    
    
    
    public void disableSequenceNumberValidation();

  
    
    

}

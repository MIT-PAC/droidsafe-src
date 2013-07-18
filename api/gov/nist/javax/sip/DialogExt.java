package gov.nist.javax.sip;

// Droidsafe Imports
import javax.sip.Dialog;
import javax.sip.SipProvider;

public interface DialogExt extends Dialog {

    
    public SipProvider getSipProvider();

    
    public void setBackToBackUserAgent();
    
    
    
    public void disableSequenceNumberValidation();

  
    
    

}

package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;

public interface StackMessageFactory {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ServerRequestInterface newSIPServerRequest(
        SIPRequest sipRequest,
        MessageChannel msgChan);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ServerResponseInterface newSIPServerResponse(
        SIPResponse sipResponse,
        MessageChannel msgChan);
}

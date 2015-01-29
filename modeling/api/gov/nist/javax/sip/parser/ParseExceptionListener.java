package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.message.SIPMessage;

import java.text.ParseException;

public interface ParseExceptionListener {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void handleException(
        ParseException ex,
        SIPMessage sipMessage,
        Class headerClass,
        String headerText,
        String messageText)
        throws ParseException;
}

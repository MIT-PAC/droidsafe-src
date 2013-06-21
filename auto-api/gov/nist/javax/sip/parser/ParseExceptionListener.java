package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.message.*;
import java.text.ParseException;

public interface ParseExceptionListener {
    
    public void handleException(
        ParseException ex,
        SIPMessage sipMessage,
        Class headerClass,
        String headerText,
        String messageText)
        throws ParseException;
}

package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

public class SecurityServer extends SecurityAgree implements SecurityServerHeader, ExtensionHeader {

    // TODO serialVersionUID

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.148 -0500", hash_original_method = "33339D36120DC8E0BA97A29C8E334060", hash_generated_method = "F3C8E0605CC16B3241E68253B5342FEE")
    
public SecurityServer()
    {
        super(SecurityServerHeader.NAME);

    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.152 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException
    {
        throw new ParseException(value,0);
    }
    
}


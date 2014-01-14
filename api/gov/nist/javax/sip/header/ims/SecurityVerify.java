package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

public class SecurityVerify extends SecurityAgree implements SecurityVerifyHeader, ExtensionHeader {

    // TODO serialVersionUID

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.192 -0500", hash_original_method = "EFF056AEE5121CFCE6CEB606B41C2105", hash_generated_method = "30AD504D21D96C78D041B2DF9F50280B")
    
public SecurityVerify()
    {
        super(SecurityVerifyHeader.NAME);

    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.195 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException
    {
        throw new ParseException(value,0);
    }
    
}


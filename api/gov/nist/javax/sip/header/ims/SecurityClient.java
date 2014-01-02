package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.ExtensionHeader;



public class SecurityClient extends SecurityAgree implements SecurityClientHeader, ExtensionHeader {

    // TODO serialVersionUID

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.934 -0500", hash_original_method = "2DC95595D33B318EDF43269B772F4B7E", hash_generated_method = "1C9984EFDD3C1F75A690111EDC51F207")
    
public SecurityClient()
    {
        super(SecurityClientHeader.NAME);

    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.937 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException
    {
        throw new ParseException(value,0);
    }

    
}


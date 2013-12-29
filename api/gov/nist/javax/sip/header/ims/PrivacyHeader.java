package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.Header;

public interface PrivacyHeader extends Header
{

    
    public final static String NAME = "Privacy";


    
    public void setPrivacy(String privacy) throws ParseException;

    
    public String getPrivacy();


}

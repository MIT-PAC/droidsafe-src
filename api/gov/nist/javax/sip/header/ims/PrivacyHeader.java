package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.Header;
import javax.sip.header.Parameters;

public interface PrivacyHeader extends Header
{

    
    public final static String NAME = "Privacy";


    
    public void setPrivacy(String privacy) throws ParseException;

    
    public String getPrivacy();


}

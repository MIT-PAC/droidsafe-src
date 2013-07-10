package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import javax.sip.header.AuthorizationHeader;

public interface AuthorizationHeaderIms extends AuthorizationHeader
{

    
    public static final String YES  = "yes";
    public static final String NO   = "no";



    
    public void setIntegrityProtected(String integrityProtected) throws InvalidArgumentException, ParseException;


    public String getIntegrityProtected();

}

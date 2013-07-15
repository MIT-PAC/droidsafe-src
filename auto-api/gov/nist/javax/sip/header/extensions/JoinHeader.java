package gov.nist.javax.sip.header.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.Header;
import javax.sip.header.Parameters;

public interface JoinHeader extends Parameters, Header {



    
    public void setToTag(String tag) throws ParseException;
    public void setFromTag(String tag) throws ParseException;





    

    public String getToTag();
    public String getFromTag();


    

    public void setCallId(String callId) throws ParseException;



    

    public String getCallId();



    

    public final static String NAME = "Join";

}

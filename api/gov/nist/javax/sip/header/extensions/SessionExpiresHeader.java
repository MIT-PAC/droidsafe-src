package gov.nist.javax.sip.header.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.*;

public interface SessionExpiresHeader extends Parameters, Header, ExtensionHeader{

    public final static String NAME = "Session-Expires";

    public int getExpires();

    public void setExpires(int expires) throws InvalidArgumentException;

    public String getRefresher() ;

    public void setRefresher(String refresher);



}

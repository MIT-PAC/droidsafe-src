package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;
import javax.sip.header.*;

public interface SessionExpiresHeader extends Parameters, Header, ExtensionHeader{

    public final static String NAME = "Session-Expires";

    public int getExpires();

    public void setExpires(int expires) throws InvalidArgumentException;

    public String getRefresher() ;

    public void setRefresher(String refresher);



}

package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.Header;

public interface PAssertedServiceHeader extends Header{

    public static final String NAME = "P-Asserted-Service";

    public void setSubserviceIdentifiers(String subservices);

    public String getSubserviceIdentifiers();

    public void setApplicationIdentifiers(String appids);

    public String getApplicationIdentifiers();
}

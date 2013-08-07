package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.header.Header;

public interface PPreferredServiceHeader extends Header{

    public static final String NAME = "P-Preferred-Service";

    public void setSubserviceIdentifiers(String subservices);

    public String getSubserviceIdentifiers();

    public void setApplicationIdentifiers(String appids);

    public String getApplicationIdentifiers();


}

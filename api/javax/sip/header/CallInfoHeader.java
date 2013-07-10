package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.address.URI;

public interface CallInfoHeader extends Header, Parameters {
    String NAME = "Call-Info";

    URI getInfo();
    void setInfo(URI info);

    String getPurpose();
    void setPurpose(String purpose);
}

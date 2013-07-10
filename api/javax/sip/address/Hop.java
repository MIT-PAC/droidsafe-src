package javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Hop {
    String getHost();
    int getPort();
    String getTransport();

    boolean isURIRoute();
    void setURIRouteFlag();

    String toString();
}

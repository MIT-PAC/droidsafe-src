package javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Hop {
    String getHost();
    int getPort();
    String getTransport();

    boolean isURIRoute();
    void setURIRouteFlag();

    String toString();
}
